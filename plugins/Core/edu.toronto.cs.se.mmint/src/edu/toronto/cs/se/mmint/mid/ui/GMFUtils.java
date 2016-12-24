/**
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.ui;

import java.util.HashMap;
import java.util.Map;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

public class GMFUtils {

	/** The suffix for GMF diagrams. */
	public static final String DIAGRAM_SUFFIX = "diag";

	public static Diagram createGMFDiagram(String modelUri, String diagramUri, String diagramKind, String diagramPluginId, boolean isWorkspaceRelative) throws Exception {

		ResourceSet domainResourceSet = new ResourceSetImpl();
		Resource modelResource = domainResourceSet.getResource(FileUtils.createEMFUri(modelUri, isWorkspaceRelative), true);
		ResourceSet diagramResourceSet = new ResourceSetImpl();
		Resource diagramResource =	diagramResourceSet.createResource(FileUtils.createEMFUri(diagramUri, isWorkspaceRelative));
		EObject rootModelObj = (EObject) modelResource.getContents().get(0);
		Diagram diagram = ViewService.createDiagram(
			rootModelObj,
			diagramKind,
			new PreferencesHint(diagramPluginId)
		);
		diagram.setName(FileUtils.getLastSegmentFromPath(diagramUri));
		diagramResource.getContents().add(diagram);
		Map<String, Object> saveOptions = new HashMap<String, Object>();
		saveOptions.put(XMLResource.OPTION_ENCODING, "UTF-8");
		saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
		diagramResource.save(saveOptions);

		return diagram;
	}

	public static ComposedAdapterFactory getAdapterFactory() {

		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		return adapterFactory;
	}

	public static void colorDiagramElement(View diagramView, int color, int fontColor) throws MMINTException {

		if (!(diagramView instanceof Shape) && !(diagramView instanceof Connector)) {
			throw new MMINTException("Diagram element not supported: " + diagramView.getClass().getName());
		}

		if (diagramView instanceof Shape) {
			Shape node = (Shape) diagramView;
			node.setFillColor(color);
			node.setLineColor(color);
			node.setFontColor(fontColor);
		}
		else if (diagramView instanceof Connector) {
			Connector edge = (Connector) diagramView;
			edge.setLineColor(color);
			FontStyle labelFont = (FontStyle) edge.getStyles().get(0);
			labelFont.setFontColor(fontColor);
		}
	}

	public static @NonNull IFile getModelFileFromDiagramFile(@NonNull IFile diagramFile) throws Exception {

		Diagram diagram = (Diagram) FileUtils.readModelFile(diagramFile.getFullPath().toString(), true);
		String modelUri = MIDRegistry.getModelAndModelElementUris(diagram.getElement(), MIDLevel.INSTANCES)[0];
		IFile modelFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(modelUri));

		return modelFile;
	}

	public static Node createGMFNode(EObject modelObj, Diagram gmfDiagram, String diagramPluginId) {

		// works only if modelObj has the right eStorage adapters attached
		IElementType gmfType = ElementTypeRegistry.getInstance().getElementType(modelObj);
		String gmfTypeHint = gmfType.getId().substring(gmfType.getId().lastIndexOf('_') + 1);
		Node gmfNode = ViewService.createNode(gmfDiagram, modelObj, gmfTypeHint, new PreferencesHint(diagramPluginId));

		return gmfNode;
	}

	public static void addGMFShortcut(Node gmfNode, String shortcutId) {

		EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		shortcutAnnotation.setSource("Shortcut");
		shortcutAnnotation.getDetails().put("modelID", shortcutId);
		gmfNode.getEAnnotations().add(shortcutAnnotation);
	}

	public static Node createGMFNodeShortcut(EObject modelObj, Diagram gmfDiagram, String diagramPluginId, String shortcutId) {

		Node gmfNode = GMFUtils.createGMFNode(modelObj, gmfDiagram, diagramPluginId);
		GMFUtils.addGMFShortcut(gmfNode, shortcutId);

		return gmfNode;
	}

}

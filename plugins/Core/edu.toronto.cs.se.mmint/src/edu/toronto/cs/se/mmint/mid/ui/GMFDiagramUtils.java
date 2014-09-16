/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;

public class GMFDiagramUtils {

	private final static String EXTELEM_NULLTYPE = "NOTYPE";
	/** The suffix for GMF diagrams. */
	public static final String DIAGRAM_SUFFIX = "diag";

	public static String getElementLabel(ExtendibleElement element) {
	
		String label = (element.getName() == null) ? "" : element.getName();
		if (MultiModelConstraintChecker.isInstancesLevel(element)) {
			ExtendibleElement type = element.getMetatype();
			String typeLabel = (type == null) ? EXTELEM_NULLTYPE : type.getName();
			label += " : " + typeLabel;
		}
	
		return label;
	}

	public static String getEndpointLabel(ExtendibleElementEndpoint endpoint) {
	
		String label = getElementLabel(endpoint);
	
		int low = endpoint.getLowerBound();
		int up = endpoint.getUpperBound();
		if (low == 0 && up == 1) {
			label += " [?]";
		}
		else if (low == 1 && up == 1) {
			// default
		}
		else if (low == 0 && up == -1) {
			label += " [*]";
		}
		else if (low == 1 && up == -1) {
			label += " [+]";
		}
		else {
			String up2 = (up == -1) ? "*" : Integer.toString(up);
			label += " [" + low + "," + up2 + "]";
		}
	
		return label;
	}

	public static String editElementLabel(ExtendibleElement element) {
	
		String name = element.getName();
		if (name == null) {
			name = "";
		}
	
		return name;
	}

	public static void createGMFDiagram(String modelUri, String diagramUri, String diagramKind, String diagramPluginId) throws Exception {

		ResourceSet domainResourceSet = new ResourceSetImpl();
		Resource modelResource = domainResourceSet.getResource(URI.createFileURI(modelUri), true);
		ResourceSet diagramResourceSet = new ResourceSetImpl();
		Resource diagramResource =	diagramResourceSet.createResource(URI.createFileURI(diagramUri));
		EObject rootModelObj = (EObject) modelResource.getContents().get(0);
		Diagram diagram = ViewService.createDiagram(
			rootModelObj,
			diagramKind,
			new PreferencesHint(diagramPluginId)
		);
		diagramResource.getContents().add(diagram);
		Map<String, Object> saveOptions = new HashMap<String, Object>();
		saveOptions.put(XMLResource.OPTION_ENCODING, "UTF-8");
		saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
		diagramResource.save(saveOptions);
	}

	public static void openGMFDiagram(String diagramUri, String diagramId, boolean isWorkspaceRelative) throws Exception {

		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(
			new URIEditorInput(MultiModelUtils.getEMFUri(diagramUri, isWorkspaceRelative)),
			diagramId
		);
	}

	public static ComposedAdapterFactory getAdapterFactory() {

		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		return adapterFactory;
	}

}

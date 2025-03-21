/**
 * Copyright (c) 2012-2025 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import java.net.URL;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.providers.IViewProvider;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.ClientContextManager;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelper;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

public class GMFUtils {

	/** The suffix for GMF diagrams. */
	public static final String DIAGRAM_SUFFIX = "diag";

	public static Diagram createGMFDiagram(EObject rootModelObj, String diagramKind, String diagramPluginId) {
		var diagram = ViewService.createDiagram(rootModelObj, diagramKind, new PreferencesHint(diagramPluginId));
		return diagram;
	}

  public static Diagram createGMFDiagramAndFile(EObject rootModelObj, String diagramPath, String diagramKind,
                                                String diagramPluginId, boolean isWorkspaceRelative) throws Exception {
    var diagramResource = FileUtils.writeEMFResource(diagramPath, rootModelObj.eResource().getResourceSet(),
                                                     isWorkspaceRelative);
    var diagram = GMFUtils.createGMFDiagram(rootModelObj, diagramKind, diagramPluginId);
    diagram.setName(FileUtils.getLastSegmentFromPath(diagramPath));
    diagramResource.getContents().add(diagram);
    var saveOptions = Map.of(XMLResource.OPTION_ENCODING, "UTF-8",
                             Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
    diagramResource.save(saveOptions);

    return diagram;
  }

	public static Diagram createGMFDiagramAndFile(String modelPath, String diagramPath, String diagramKind,
	                                              String diagramPluginId, boolean isWorkspaceRelative) throws Exception {
    var rootModelObj = FileUtils.readModelFile(modelPath, null, isWorkspaceRelative);
		return createGMFDiagramAndFile(rootModelObj, diagramPath, diagramKind, diagramPluginId, isWorkspaceRelative);
	}

	public static @NonNull IFile getModelFileFromDiagramFile(@NonNull IFile diagramFile) throws Exception {

		var diagram = (Diagram) FileUtils.readModelFile(diagramFile.getFullPath().toString(), null, true);
		var modelUri = MIDRegistry.getModelUri(diagram.getElement());
		var modelFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(modelUri));

		return modelFile;
	}

	public static @NonNull String getGMFRegistryType(@NonNull EObject modelObj, @Nullable String contextId) {

		IElementType gmfType = null;
		if (contextId == null) {
			gmfType = ElementTypeRegistry.getInstance().getElementType(modelObj);
		}
		else {
			var context = ClientContextManager.getInstance().getClientContext(contextId);
			gmfType = ElementTypeRegistry.getInstance().getElementType(modelObj, context);
		}
		var gmfTypeHint = gmfType.getId().substring(gmfType.getId().lastIndexOf('_') + 1);

		return gmfTypeHint;
	}

	public static @Nullable Node createGMFNode(@NonNull EObject modelObj, @NonNull Diagram gmfDiagram, @NonNull String diagramPluginId, @Nullable IViewProvider viewProvider) {

		Node gmfNode = null;
		if (viewProvider == null) {
			var gmfTypeHint = GMFUtils.getGMFRegistryType(modelObj, null);
			// works only if modelObj has the right eStorage adapters attached, or it returns a generic type
			gmfNode = ViewService.createNode(gmfDiagram, modelObj, gmfTypeHint, new PreferencesHint(diagramPluginId));
		}
		else {
			gmfNode = viewProvider.createNode(new EObjectAdapter(modelObj), gmfDiagram, null, -1, true, new PreferencesHint(diagramPluginId));
		}

		return gmfNode;
	}

	public static @Nullable Edge createGMFEdge(@NonNull EObject modelObj, @NonNull Node srcNode, @NonNull Node tgtNode, @NonNull Diagram gmfDiagram, @NonNull String diagramPluginId, @Nullable IViewProvider viewProvider) {

		Edge gmfEdge = null;
		if (viewProvider == null) {
			var gmfTypeHint = GMFUtils.getGMFRegistryType(modelObj, null);
			// works only if modelObj has the right eStorage adapters attached, or it returns a generic type
			gmfEdge = ViewService.createEdge(srcNode, tgtNode, modelObj, gmfTypeHint, new PreferencesHint(diagramPluginId));
		}
		else {
			var modelObjWrapper = new IAdaptable() {
				@Override
        public Object getAdapter(Class adapter) {
					if (adapter == IElementType.class) {
						return new IHintedType() {
							@Override
              public String getSemanticHint() {
								return GMFUtils.getGMFRegistryType(modelObj, diagramPluginId + ".TypeContext");
							}
							@Override
              public String getId() { return null; }
							@Override
              public URL getIconURL() { return null; }
							@Override
              public String getDisplayName() { return null; }
							@Override
              public EClass getEClass() { return null; }
							@Override
              public ICommand getEditCommand(IEditCommandRequest request) { return null; }
							@Override
              public boolean canEdit(IEditCommandRequest req) { return false; }
							@Override
              public IEditHelper getEditHelper() { return null; }
							@Override
              public IElementType[] getAllSuperTypes() { return null; }
							@Override
              public <T> T getAdapter(Class<T> adapter) { return null; }
						};
					}
					return new EObjectAdapter(modelObj).getAdapter(adapter);
				}
			};
			gmfEdge = viewProvider.createEdge(modelObjWrapper, gmfDiagram, null, -1, true, new PreferencesHint(diagramPluginId));
			gmfEdge.setSource(srcNode);
			gmfEdge.setTarget(tgtNode);
		}

		return gmfEdge;
	}

	public static void addGMFShortcut(@NonNull Node gmfNode, @NonNull String shortcutId) {

		var shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		shortcutAnnotation.setSource("Shortcut");
		shortcutAnnotation.getDetails().put("modelID", shortcutId);
		gmfNode.getEAnnotations().add(shortcutAnnotation);
	}

	public static @Nullable Node createGMFNodeShortcut(@NonNull EObject modelObj, @NonNull Diagram gmfDiagram, @NonNull String diagramPluginId, @NonNull String shortcutId, @Nullable IViewProvider viewProvider) {

		var gmfNode = GMFUtils.createGMFNode(modelObj, gmfDiagram, diagramPluginId, viewProvider);
		GMFUtils.addGMFShortcut(gmfNode, shortcutId);

		return gmfNode;
	}

	public static void colorDiagramElement(View diagramView, int color, int fontColor) throws MMINTException {

		if (!(diagramView instanceof Shape) && !(diagramView instanceof Connector)) {
			throw new MMINTException("Diagram element not supported: " + diagramView.getClass().getName());
		}

		if (diagramView instanceof Shape node) {
			node.setFillColor(color);
			node.setLineColor(color);
			node.setFontColor(fontColor);
		}
		else if (diagramView instanceof Connector edge) {
			edge.setLineColor(color);
			var labelFont = (FontStyle) edge.getStyles().get(0);
			labelFont.setFontColor(fontColor);
		}
	}

	public static ComposedAdapterFactory getAdapterFactory() {

		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		return adapterFactory;
	}

}

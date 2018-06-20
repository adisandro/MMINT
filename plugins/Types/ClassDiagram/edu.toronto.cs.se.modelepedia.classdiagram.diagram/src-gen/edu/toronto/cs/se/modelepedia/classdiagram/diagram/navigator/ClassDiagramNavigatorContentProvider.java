/*
* Copyright (c) 2012-2018 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
* Rick Salay.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
* 
* Contributors:
*    Alessio Di Sandro - Implementation.
*/
package edu.toronto.cs.se.modelepedia.classdiagram.diagram.navigator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;

import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.AssociationEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.AttributeEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.ClassClassOwnedAttributesCompartmentEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.ClassClassOwnedOperationsCompartmentEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.ClassDiagramEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.ClassEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.ClassNestedInEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.ClassSuperclassEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.DependencyEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.OperationEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.part.ClassDiagramVisualIDRegistry;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.part.Messages;

/**
 * @generated
 */
public class ClassDiagramNavigatorContentProvider implements ICommonContentProvider {

	/**
	* @generated
	*/
	private static final Object[] EMPTY_ARRAY = new Object[0];

	/**
	* @generated
	*/
	private Viewer myViewer;

	/**
	* @generated
	*/
	private AdapterFactoryEditingDomain myEditingDomain;

	/**
	* @generated
	*/
	private WorkspaceSynchronizer myWorkspaceSynchronizer;

	/**
	* @generated
	*/
	private Runnable myViewerRefreshRunnable;

	/**
	* @generated
	*/
	@SuppressWarnings({ "unchecked", "serial", "rawtypes" })
	public ClassDiagramNavigatorContentProvider() {
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE.createEditingDomain();
		myEditingDomain = (AdapterFactoryEditingDomain) editingDomain;
		myEditingDomain.setResourceToReadOnlyMap(new HashMap() {
			public Object get(Object key) {
				if (!containsKey(key)) {
					put(key, Boolean.TRUE);
				}
				return super.get(key);
			}
		});
		myViewerRefreshRunnable = new Runnable() {
			public void run() {
				if (myViewer != null) {
					myViewer.refresh();
				}
			}
		};
		myWorkspaceSynchronizer = new WorkspaceSynchronizer(editingDomain, new WorkspaceSynchronizer.Delegate() {
			public void dispose() {
			}

			public boolean handleResourceChanged(final Resource resource) {
				unloadAllResources();
				asyncRefresh();
				return true;
			}

			public boolean handleResourceDeleted(Resource resource) {
				unloadAllResources();
				asyncRefresh();
				return true;
			}

			public boolean handleResourceMoved(Resource resource, final URI newURI) {
				unloadAllResources();
				asyncRefresh();
				return true;
			}
		});
	}

	/**
	* @generated
	*/
	public void dispose() {
		myWorkspaceSynchronizer.dispose();
		myWorkspaceSynchronizer = null;
		myViewerRefreshRunnable = null;
		myViewer = null;
		unloadAllResources();
		((TransactionalEditingDomain) myEditingDomain).dispose();
		myEditingDomain = null;
	}

	/**
	* @generated
	*/
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		myViewer = viewer;
	}

	/**
	* @generated
	*/
	void unloadAllResources() {
		for (Resource nextResource : myEditingDomain.getResourceSet().getResources()) {
			nextResource.unload();
		}
	}

	/**
	* @generated
	*/
	void asyncRefresh() {
		if (myViewer != null && !myViewer.getControl().isDisposed()) {
			myViewer.getControl().getDisplay().asyncExec(myViewerRefreshRunnable);
		}
	}

	/**
	* @generated
	*/
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	/**
	* @generated
	*/
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	* @generated
	*/
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	* @generated
	*/
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof IFile) {
			IFile file = (IFile) parentElement;
			URI fileURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			Resource resource = myEditingDomain.getResourceSet().getResource(fileURI, true);
			ArrayList<ClassDiagramNavigatorItem> result = new ArrayList<ClassDiagramNavigatorItem>();
			ArrayList<View> topViews = new ArrayList<View>(resource.getContents().size());
			for (EObject o : resource.getContents()) {
				if (o instanceof View) {
					topViews.add((View) o);
				}
			}
			result
				.addAll(createNavigatorItems(selectViewsByType(topViews, ClassDiagramEditPart.MODEL_ID), file, false));
			return result.toArray();
		}

		if (parentElement instanceof ClassDiagramNavigatorGroup) {
			ClassDiagramNavigatorGroup group = (ClassDiagramNavigatorGroup) parentElement;
			return group.getChildren();
		}

		if (parentElement instanceof ClassDiagramNavigatorItem) {
			ClassDiagramNavigatorItem navigatorItem = (ClassDiagramNavigatorItem) parentElement;
			if (navigatorItem.isLeaf() || !isOwnView(navigatorItem.getView())) {
				return EMPTY_ARRAY;
			}
			return getViewChildren(navigatorItem.getView(), parentElement);
		}

		/*
		* Due to plugin.xml restrictions this code will be called only for views representing
		* shortcuts to this diagram elements created on other diagrams. 
		*/
		if (parentElement instanceof IAdaptable) {
			View view = (View) ((IAdaptable) parentElement).getAdapter(View.class);
			if (view != null) {
				return getViewChildren(view, parentElement);
			}
		}

		return EMPTY_ARRAY;
	}

	/**
	* @generated
	*/
	private Object[] getViewChildren(View view, Object parentElement) {
		switch (ClassDiagramVisualIDRegistry.getVisualID(view)) {

			case ClassDiagramEditPart.VISUAL_ID: {
				LinkedList<ClassDiagramAbstractNavigatorItem> result = new LinkedList<ClassDiagramAbstractNavigatorItem>();
				result.addAll(getForeignShortcuts((Diagram) view, parentElement));
				Diagram sv = (Diagram) view;
				ClassDiagramNavigatorGroup links = new ClassDiagramNavigatorGroup(
					Messages.NavigatorGroupName_ClassDiagram_1000_links,
					"icons/linksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
				Collection<View> connectedViews;
				connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ClassDiagramVisualIDRegistry.getType(ClassEditPart.VISUAL_ID));
				result.addAll(createNavigatorItems(connectedViews, parentElement, false));
				connectedViews = getDiagramLinksByType(
					Collections.singleton(sv),
					ClassDiagramVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
				links.addChildren(createNavigatorItems(connectedViews, links, false));
				connectedViews = getDiagramLinksByType(
					Collections.singleton(sv),
					ClassDiagramVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
				links.addChildren(createNavigatorItems(connectedViews, links, false));
				connectedViews = getDiagramLinksByType(
					Collections.singleton(sv),
					ClassDiagramVisualIDRegistry.getType(ClassNestedInEditPart.VISUAL_ID));
				links.addChildren(createNavigatorItems(connectedViews, links, false));
				connectedViews = getDiagramLinksByType(
					Collections.singleton(sv),
					ClassDiagramVisualIDRegistry.getType(ClassSuperclassEditPart.VISUAL_ID));
				links.addChildren(createNavigatorItems(connectedViews, links, false));
				if (!links.isEmpty()) {
					result.add(links);
				}
				return result.toArray();
			}

			case ClassEditPart.VISUAL_ID: {
				LinkedList<ClassDiagramAbstractNavigatorItem> result = new LinkedList<ClassDiagramAbstractNavigatorItem>();
				Node sv = (Node) view;
				ClassDiagramNavigatorGroup incominglinks = new ClassDiagramNavigatorGroup(
					Messages.NavigatorGroupName_Class_2001_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
				ClassDiagramNavigatorGroup outgoinglinks = new ClassDiagramNavigatorGroup(
					Messages.NavigatorGroupName_Class_2001_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
				Collection<View> connectedViews;
				connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ClassDiagramVisualIDRegistry.getType(ClassClassOwnedAttributesCompartmentEditPart.VISUAL_ID));
				connectedViews = getChildrenByType(
					connectedViews,
					ClassDiagramVisualIDRegistry.getType(AttributeEditPart.VISUAL_ID));
				result.addAll(createNavigatorItems(connectedViews, parentElement, false));
				connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ClassDiagramVisualIDRegistry.getType(ClassClassOwnedOperationsCompartmentEditPart.VISUAL_ID));
				connectedViews = getChildrenByType(
					connectedViews,
					ClassDiagramVisualIDRegistry.getType(OperationEditPart.VISUAL_ID));
				result.addAll(createNavigatorItems(connectedViews, parentElement, false));
				connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ClassDiagramVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
				incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
				connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ClassDiagramVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
				outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
				connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ClassDiagramVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
				incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
				connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ClassDiagramVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
				outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
				connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ClassDiagramVisualIDRegistry.getType(ClassNestedInEditPart.VISUAL_ID));
				incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
				connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ClassDiagramVisualIDRegistry.getType(ClassNestedInEditPart.VISUAL_ID));
				outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
				connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ClassDiagramVisualIDRegistry.getType(ClassSuperclassEditPart.VISUAL_ID));
				incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
				connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ClassDiagramVisualIDRegistry.getType(ClassSuperclassEditPart.VISUAL_ID));
				outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
				if (!incominglinks.isEmpty()) {
					result.add(incominglinks);
				}
				if (!outgoinglinks.isEmpty()) {
					result.add(outgoinglinks);
				}
				return result.toArray();
			}

			case AssociationEditPart.VISUAL_ID: {
				LinkedList<ClassDiagramAbstractNavigatorItem> result = new LinkedList<ClassDiagramAbstractNavigatorItem>();
				Edge sv = (Edge) view;
				ClassDiagramNavigatorGroup target = new ClassDiagramNavigatorGroup(
					Messages.NavigatorGroupName_Association_4001_target,
					"icons/linkTargetNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
				ClassDiagramNavigatorGroup source = new ClassDiagramNavigatorGroup(
					Messages.NavigatorGroupName_Association_4001_source,
					"icons/linkSourceNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
				Collection<View> connectedViews;
				connectedViews = getLinksTargetByType(
					Collections.singleton(sv),
					ClassDiagramVisualIDRegistry.getType(ClassEditPart.VISUAL_ID));
				target.addChildren(createNavigatorItems(connectedViews, target, true));
				connectedViews = getLinksSourceByType(
					Collections.singleton(sv),
					ClassDiagramVisualIDRegistry.getType(ClassEditPart.VISUAL_ID));
				source.addChildren(createNavigatorItems(connectedViews, source, true));
				if (!target.isEmpty()) {
					result.add(target);
				}
				if (!source.isEmpty()) {
					result.add(source);
				}
				return result.toArray();
			}

			case DependencyEditPart.VISUAL_ID: {
				LinkedList<ClassDiagramAbstractNavigatorItem> result = new LinkedList<ClassDiagramAbstractNavigatorItem>();
				Edge sv = (Edge) view;
				ClassDiagramNavigatorGroup target = new ClassDiagramNavigatorGroup(
					Messages.NavigatorGroupName_Dependency_4002_target,
					"icons/linkTargetNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
				ClassDiagramNavigatorGroup source = new ClassDiagramNavigatorGroup(
					Messages.NavigatorGroupName_Dependency_4002_source,
					"icons/linkSourceNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
				Collection<View> connectedViews;
				connectedViews = getLinksTargetByType(
					Collections.singleton(sv),
					ClassDiagramVisualIDRegistry.getType(ClassEditPart.VISUAL_ID));
				target.addChildren(createNavigatorItems(connectedViews, target, true));
				connectedViews = getLinksSourceByType(
					Collections.singleton(sv),
					ClassDiagramVisualIDRegistry.getType(ClassEditPart.VISUAL_ID));
				source.addChildren(createNavigatorItems(connectedViews, source, true));
				if (!target.isEmpty()) {
					result.add(target);
				}
				if (!source.isEmpty()) {
					result.add(source);
				}
				return result.toArray();
			}

			case ClassNestedInEditPart.VISUAL_ID: {
				LinkedList<ClassDiagramAbstractNavigatorItem> result = new LinkedList<ClassDiagramAbstractNavigatorItem>();
				Edge sv = (Edge) view;
				ClassDiagramNavigatorGroup target = new ClassDiagramNavigatorGroup(
					Messages.NavigatorGroupName_ClassNestedIn_4003_target,
					"icons/linkTargetNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
				ClassDiagramNavigatorGroup source = new ClassDiagramNavigatorGroup(
					Messages.NavigatorGroupName_ClassNestedIn_4003_source,
					"icons/linkSourceNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
				Collection<View> connectedViews;
				connectedViews = getLinksTargetByType(
					Collections.singleton(sv),
					ClassDiagramVisualIDRegistry.getType(ClassEditPart.VISUAL_ID));
				target.addChildren(createNavigatorItems(connectedViews, target, true));
				connectedViews = getLinksSourceByType(
					Collections.singleton(sv),
					ClassDiagramVisualIDRegistry.getType(ClassEditPart.VISUAL_ID));
				source.addChildren(createNavigatorItems(connectedViews, source, true));
				if (!target.isEmpty()) {
					result.add(target);
				}
				if (!source.isEmpty()) {
					result.add(source);
				}
				return result.toArray();
			}

			case ClassSuperclassEditPart.VISUAL_ID: {
				LinkedList<ClassDiagramAbstractNavigatorItem> result = new LinkedList<ClassDiagramAbstractNavigatorItem>();
				Edge sv = (Edge) view;
				ClassDiagramNavigatorGroup target = new ClassDiagramNavigatorGroup(
					Messages.NavigatorGroupName_ClassSuperclass_4004_target,
					"icons/linkTargetNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
				ClassDiagramNavigatorGroup source = new ClassDiagramNavigatorGroup(
					Messages.NavigatorGroupName_ClassSuperclass_4004_source,
					"icons/linkSourceNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
				Collection<View> connectedViews;
				connectedViews = getLinksTargetByType(
					Collections.singleton(sv),
					ClassDiagramVisualIDRegistry.getType(ClassEditPart.VISUAL_ID));
				target.addChildren(createNavigatorItems(connectedViews, target, true));
				connectedViews = getLinksSourceByType(
					Collections.singleton(sv),
					ClassDiagramVisualIDRegistry.getType(ClassEditPart.VISUAL_ID));
				source.addChildren(createNavigatorItems(connectedViews, source, true));
				if (!target.isEmpty()) {
					result.add(target);
				}
				if (!source.isEmpty()) {
					result.add(source);
				}
				return result.toArray();
			}
		}
		return EMPTY_ARRAY;
	}

	/**
	* @generated
	*/
	private Collection<View> getLinksSourceByType(Collection<Edge> edges, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (Edge nextEdge : edges) {
			View nextEdgeSource = nextEdge.getSource();
			if (type.equals(nextEdgeSource.getType()) && isOwnView(nextEdgeSource)) {
				result.add(nextEdgeSource);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getLinksTargetByType(Collection<Edge> edges, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (Edge nextEdge : edges) {
			View nextEdgeTarget = nextEdge.getTarget();
			if (type.equals(nextEdgeTarget.getType()) && isOwnView(nextEdgeTarget)) {
				result.add(nextEdgeTarget);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getOutgoingLinksByType(Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getSourceEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getIncomingLinksByType(Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getTargetEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getChildrenByType(Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getChildren(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getDiagramLinksByType(Collection<Diagram> diagrams, String type) {
		ArrayList<View> result = new ArrayList<View>();
		for (Diagram nextDiagram : diagrams) {
			result.addAll(selectViewsByType(nextDiagram.getEdges(), type));
		}
		return result;
	}

	// TODO refactor as static method
	/**
	 * @generated
	 */
	private Collection<View> selectViewsByType(Collection<View> views, String type) {
		ArrayList<View> result = new ArrayList<View>();
		for (View nextView : views) {
			if (type.equals(nextView.getType()) && isOwnView(nextView)) {
				result.add(nextView);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return ClassDiagramEditPart.MODEL_ID.equals(ClassDiagramVisualIDRegistry.getModelID(view));
	}

	/**
	 * @generated
	 */
	private Collection<ClassDiagramNavigatorItem> createNavigatorItems(
			Collection<View> views, Object parent, boolean isLeafs) {
		ArrayList<ClassDiagramNavigatorItem> result = new ArrayList<ClassDiagramNavigatorItem>(views.size());
		for (View nextView : views) {
			result.add(new ClassDiagramNavigatorItem(nextView, parent, isLeafs));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<ClassDiagramNavigatorItem> getForeignShortcuts(Diagram diagram, Object parent) {
		LinkedList<View> result = new LinkedList<View>();
		for (Iterator<View> it = diagram.getChildren().iterator(); it.hasNext();) {
			View nextView = it.next();
			if (!isOwnView(nextView) && nextView.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
				result.add(nextView);
			}
		}
		return createNavigatorItems(result, parent, false);
	}

	/**
	* @generated
	*/
	public Object getParent(Object element) {
		if (element instanceof ClassDiagramAbstractNavigatorItem) {
			ClassDiagramAbstractNavigatorItem abstractNavigatorItem = (ClassDiagramAbstractNavigatorItem) element;
			return abstractNavigatorItem.getParent();
		}
		return null;
	}

	/**
	* @generated
	*/
	public boolean hasChildren(Object element) {
		return element instanceof IFile || getChildren(element).length > 0;
	}

}

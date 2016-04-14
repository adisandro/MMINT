/*
* Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
* Rick Salay.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
* 
* Contributors:
*    Alessio Di Sandro - Implementation.
*/
package edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator;

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

/**
 * @generated
 */
public class ICSE15_SequenceDiagram_MAVONavigatorContentProvider implements ICommonContentProvider {

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
	public ICSE15_SequenceDiagram_MAVONavigatorContentProvider() {
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
			ArrayList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorItem> result = new ArrayList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorItem>();
			ArrayList<View> topViews = new ArrayList<View>(resource.getContents().size());
			for (EObject o : resource.getContents()) {
				if (o instanceof View) {
					topViews.add((View) o);
				}
			}
			result.addAll(createNavigatorItems(
					selectViewsByType(topViews,
							edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.SequenceDiagramEditPart.MODEL_ID),
					file, false));
			return result.toArray();
		}

		if (parentElement instanceof edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorGroup) {
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorGroup group = (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorGroup) parentElement;
			return group.getChildren();
		}

		if (parentElement instanceof edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorItem) {
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorItem navigatorItem = (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorItem) parentElement;
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
		switch (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
				.getVisualID(view)) {

		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.SequenceDiagramEditPart.VISUAL_ID: {
			LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVOAbstractNavigatorItem> result = new LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVOAbstractNavigatorItem>();
			result.addAll(getForeignShortcuts((Diagram) view, parentElement));
			Diagram sv = (Diagram) view;
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorGroup links = new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorGroup(
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.Messages.NavigatorGroupName_SequenceDiagram_1000_links,
					"icons/linksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
							.getType(
									edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.LifelineEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
							.getType(
									edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.ClassEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
							.getType(
									edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.MessageEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
							.getType(
									edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.ClassReferenceEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
							.getType(
									edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.OperationReferenceEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
							.getType(
									edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.SourceLifelineReferenceEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
							.getType(
									edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.TargetLifelineReferenceEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			if (!links.isEmpty()) {
				result.add(links);
			}
			return result.toArray();
		}

		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.LifelineEditPart.VISUAL_ID: {
			LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVOAbstractNavigatorItem> result = new LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVOAbstractNavigatorItem>();
			Node sv = (Node) view;
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorGroup outgoinglinks = new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorGroup(
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.Messages.NavigatorGroupName_Lifeline_2001_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorGroup incominglinks = new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorGroup(
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.Messages.NavigatorGroupName_Lifeline_2001_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
							.getType(
									edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.ClassReferenceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
							.getType(
									edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.SourceLifelineReferenceEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
							.getType(
									edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.TargetLifelineReferenceEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.ClassEditPart.VISUAL_ID: {
			LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVOAbstractNavigatorItem> result = new LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVOAbstractNavigatorItem>();
			Node sv = (Node) view;
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorGroup incominglinks = new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorGroup(
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.Messages.NavigatorGroupName_Class_2002_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
							.getType(
									edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.ClassClassOperationsCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
							.getType(
									edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.OperationEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
							.getType(
									edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.ClassReferenceEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.MessageEditPart.VISUAL_ID: {
			LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVOAbstractNavigatorItem> result = new LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVOAbstractNavigatorItem>();
			Node sv = (Node) view;
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorGroup outgoinglinks = new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorGroup(
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.Messages.NavigatorGroupName_Message_2003_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
							.getType(
									edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.OperationReferenceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
							.getType(
									edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.SourceLifelineReferenceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
							.getType(
									edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.TargetLifelineReferenceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.OperationEditPart.VISUAL_ID: {
			LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVOAbstractNavigatorItem> result = new LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVOAbstractNavigatorItem>();
			Node sv = (Node) view;
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorGroup incominglinks = new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorGroup(
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.Messages.NavigatorGroupName_Operation_3001_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
							.getType(
									edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.OperationReferenceEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.ClassReferenceEditPart.VISUAL_ID: {
			LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVOAbstractNavigatorItem> result = new LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVOAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorGroup target = new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorGroup(
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.Messages.NavigatorGroupName_ClassReference_4001_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorGroup source = new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorGroup(
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.Messages.NavigatorGroupName_ClassReference_4001_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
							.getType(
									edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.ClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
							.getType(
									edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.LifelineEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.OperationReferenceEditPart.VISUAL_ID: {
			LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVOAbstractNavigatorItem> result = new LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVOAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorGroup target = new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorGroup(
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.Messages.NavigatorGroupName_OperationReference_4002_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorGroup source = new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorGroup(
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.Messages.NavigatorGroupName_OperationReference_4002_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
							.getType(
									edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.OperationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
							.getType(
									edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.MessageEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.SourceLifelineReferenceEditPart.VISUAL_ID: {
			LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVOAbstractNavigatorItem> result = new LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVOAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorGroup target = new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorGroup(
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.Messages.NavigatorGroupName_SourceLifelineReference_4003_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorGroup source = new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorGroup(
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.Messages.NavigatorGroupName_SourceLifelineReference_4003_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
							.getType(
									edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.LifelineEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
							.getType(
									edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.MessageEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.TargetLifelineReferenceEditPart.VISUAL_ID: {
			LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVOAbstractNavigatorItem> result = new LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVOAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorGroup target = new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorGroup(
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.Messages.NavigatorGroupName_TargetLifelineReference_4004_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorGroup source = new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorGroup(
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.Messages.NavigatorGroupName_TargetLifelineReference_4004_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
							.getType(
									edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.LifelineEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
							.getType(
									edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.MessageEditPart.VISUAL_ID));
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
		return edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.SequenceDiagramEditPart.MODEL_ID
				.equals(edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
						.getModelID(view));
	}

	/**
	 * @generated
	 */
	private Collection<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorItem> createNavigatorItems(
			Collection<View> views, Object parent, boolean isLeafs) {
		ArrayList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorItem> result = new ArrayList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorItem>(
				views.size());
		for (View nextView : views) {
			result.add(
					new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorItem(
							nextView, parent, isLeafs));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVONavigatorItem> getForeignShortcuts(
			Diagram diagram, Object parent) {
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
		if (element instanceof edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVOAbstractNavigatorItem) {
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVOAbstractNavigatorItem abstractNavigatorItem = (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.navigator.ICSE15_SequenceDiagram_MAVOAbstractNavigatorItem) element;
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

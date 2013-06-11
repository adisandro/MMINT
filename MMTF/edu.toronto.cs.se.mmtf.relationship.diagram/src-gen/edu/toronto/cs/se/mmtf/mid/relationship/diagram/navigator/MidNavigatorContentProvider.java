/*
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.relationship.diagram.navigator;

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

import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.BinaryLinkReference2EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.BinaryLinkReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ExtendibleElementReferenceSupertypeRefEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.LinkReference2EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.LinkReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelElementEndpointReference2EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelElementEndpointReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelElementReference2EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelElementReference3EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelElementReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelEndpointReference2EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelEndpointReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelEndpointReferenceModelEndpointReferenceCompartmentEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelEndpointReferenceModelEndpointReferenceSuperCompartmentEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelRelEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.part.Messages;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.part.MidVisualIDRegistry;

/**
 * @generated
 */
public class MidNavigatorContentProvider implements ICommonContentProvider {

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
	public MidNavigatorContentProvider() {
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE
				.createEditingDomain();
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
		myWorkspaceSynchronizer = new WorkspaceSynchronizer(editingDomain,
				new WorkspaceSynchronizer.Delegate() {
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

					public boolean handleResourceMoved(Resource resource,
							final URI newURI) {
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
		for (Resource nextResource : myEditingDomain.getResourceSet()
				.getResources()) {
			nextResource.unload();
		}
	}

	/**
	 * @generated
	 */
	void asyncRefresh() {
		if (myViewer != null && !myViewer.getControl().isDisposed()) {
			myViewer.getControl().getDisplay()
					.asyncExec(myViewerRefreshRunnable);
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
			URI fileURI = URI.createPlatformResourceURI(file.getFullPath()
					.toString(), true);
			Resource resource = myEditingDomain.getResourceSet().getResource(
					fileURI, true);
			ArrayList<MidNavigatorItem> result = new ArrayList<MidNavigatorItem>();
			ArrayList<View> topViews = new ArrayList<View>(resource
					.getContents().size());
			for (EObject o : resource.getContents()) {
				if (o instanceof View) {
					topViews.add((View) o);
				}
			}
			result.addAll(createNavigatorItems(
					selectViewsByType(topViews, ModelRelEditPart.MODEL_ID),
					file, false));
			return result.toArray();
		}

		if (parentElement instanceof MidNavigatorGroup) {
			MidNavigatorGroup group = (MidNavigatorGroup) parentElement;
			return group.getChildren();
		}

		if (parentElement instanceof MidNavigatorItem) {
			MidNavigatorItem navigatorItem = (MidNavigatorItem) parentElement;
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
			View view = (View) ((IAdaptable) parentElement)
					.getAdapter(View.class);
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
		switch (MidVisualIDRegistry.getVisualID(view)) {

		case ModelRelEditPart.VISUAL_ID: {
			LinkedList<MidAbstractNavigatorItem> result = new LinkedList<MidAbstractNavigatorItem>();
			result.addAll(getForeignShortcuts((Diagram) view, parentElement));
			Diagram sv = (Diagram) view;
			MidNavigatorGroup links = new MidNavigatorGroup(
					Messages.NavigatorGroupName_ModelRel_1000_links,
					"icons/linksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelEndpointReferenceEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(LinkReferenceEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(LinkReference2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelEndpointReference2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getDiagramLinksByType(
					Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ExtendibleElementReferenceSupertypeRefEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(
					Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelElementEndpointReferenceEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(BinaryLinkReferenceEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(BinaryLinkReference2EditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(
					Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelElementEndpointReference2EditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			if (!links.isEmpty()) {
				result.add(links);
			}
			return result.toArray();
		}

		case ModelEndpointReferenceEditPart.VISUAL_ID: {
			LinkedList<MidAbstractNavigatorItem> result = new LinkedList<MidAbstractNavigatorItem>();
			Node sv = (Node) view;
			MidNavigatorGroup incominglinks = new MidNavigatorGroup(
					Messages.NavigatorGroupName_ModelEndpointReference_2007_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			MidNavigatorGroup outgoinglinks = new MidNavigatorGroup(
					Messages.NavigatorGroupName_ModelEndpointReference_2007_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelEndpointReferenceModelEndpointReferenceCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					MidVisualIDRegistry
							.getType(ModelElementReferenceEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ExtendibleElementReferenceSupertypeRefEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ExtendibleElementReferenceSupertypeRefEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case LinkReferenceEditPart.VISUAL_ID: {
			LinkedList<MidAbstractNavigatorItem> result = new LinkedList<MidAbstractNavigatorItem>();
			Node sv = (Node) view;
			MidNavigatorGroup incominglinks = new MidNavigatorGroup(
					Messages.NavigatorGroupName_LinkReference_2008_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			MidNavigatorGroup outgoinglinks = new MidNavigatorGroup(
					Messages.NavigatorGroupName_LinkReference_2008_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ExtendibleElementReferenceSupertypeRefEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ExtendibleElementReferenceSupertypeRefEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelElementEndpointReferenceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelElementEndpointReference2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case LinkReference2EditPart.VISUAL_ID: {
			LinkedList<MidAbstractNavigatorItem> result = new LinkedList<MidAbstractNavigatorItem>();
			Node sv = (Node) view;
			MidNavigatorGroup incominglinks = new MidNavigatorGroup(
					Messages.NavigatorGroupName_LinkReference_2009_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			MidNavigatorGroup outgoinglinks = new MidNavigatorGroup(
					Messages.NavigatorGroupName_LinkReference_2009_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ExtendibleElementReferenceSupertypeRefEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ExtendibleElementReferenceSupertypeRefEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelElementEndpointReferenceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelElementEndpointReference2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ModelEndpointReference2EditPart.VISUAL_ID: {
			LinkedList<MidAbstractNavigatorItem> result = new LinkedList<MidAbstractNavigatorItem>();
			Node sv = (Node) view;
			MidNavigatorGroup incominglinks = new MidNavigatorGroup(
					Messages.NavigatorGroupName_ModelEndpointReference_2010_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			MidNavigatorGroup outgoinglinks = new MidNavigatorGroup(
					Messages.NavigatorGroupName_ModelEndpointReference_2010_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelEndpointReferenceModelEndpointReferenceSuperCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					MidVisualIDRegistry
							.getType(ModelElementReference2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelEndpointReferenceModelEndpointReferenceSuperCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					MidVisualIDRegistry
							.getType(ModelElementReference3EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ExtendibleElementReferenceSupertypeRefEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ExtendibleElementReferenceSupertypeRefEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ModelElementReferenceEditPart.VISUAL_ID: {
			LinkedList<MidAbstractNavigatorItem> result = new LinkedList<MidAbstractNavigatorItem>();
			Node sv = (Node) view;
			MidNavigatorGroup incominglinks = new MidNavigatorGroup(
					Messages.NavigatorGroupName_ModelElementReference_3005_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			MidNavigatorGroup outgoinglinks = new MidNavigatorGroup(
					Messages.NavigatorGroupName_ModelElementReference_3005_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ExtendibleElementReferenceSupertypeRefEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ExtendibleElementReferenceSupertypeRefEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelElementEndpointReferenceEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(BinaryLinkReferenceEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(BinaryLinkReferenceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(BinaryLinkReference2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(BinaryLinkReference2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelElementEndpointReference2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ModelElementReference2EditPart.VISUAL_ID: {
			LinkedList<MidAbstractNavigatorItem> result = new LinkedList<MidAbstractNavigatorItem>();
			Node sv = (Node) view;
			MidNavigatorGroup incominglinks = new MidNavigatorGroup(
					Messages.NavigatorGroupName_ModelElementReference_3006_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			MidNavigatorGroup outgoinglinks = new MidNavigatorGroup(
					Messages.NavigatorGroupName_ModelElementReference_3006_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ExtendibleElementReferenceSupertypeRefEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ExtendibleElementReferenceSupertypeRefEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelElementEndpointReferenceEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(BinaryLinkReferenceEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(BinaryLinkReferenceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(BinaryLinkReference2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(BinaryLinkReference2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelElementEndpointReference2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ModelElementReference3EditPart.VISUAL_ID: {
			LinkedList<MidAbstractNavigatorItem> result = new LinkedList<MidAbstractNavigatorItem>();
			Node sv = (Node) view;
			MidNavigatorGroup incominglinks = new MidNavigatorGroup(
					Messages.NavigatorGroupName_ModelElementReference_3007_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			MidNavigatorGroup outgoinglinks = new MidNavigatorGroup(
					Messages.NavigatorGroupName_ModelElementReference_3007_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ExtendibleElementReferenceSupertypeRefEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ExtendibleElementReferenceSupertypeRefEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelElementEndpointReferenceEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(BinaryLinkReferenceEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(BinaryLinkReferenceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(BinaryLinkReference2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(BinaryLinkReference2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelElementEndpointReference2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ExtendibleElementReferenceSupertypeRefEditPart.VISUAL_ID: {
			LinkedList<MidAbstractNavigatorItem> result = new LinkedList<MidAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			MidNavigatorGroup target = new MidNavigatorGroup(
					Messages.NavigatorGroupName_ExtendibleElementReferenceSupertypeRef_4010_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			MidNavigatorGroup source = new MidNavigatorGroup(
					Messages.NavigatorGroupName_ExtendibleElementReferenceSupertypeRef_4010_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelEndpointReferenceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(LinkReferenceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(LinkReference2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelEndpointReference2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelElementReferenceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelElementReference2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelElementReference3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelEndpointReferenceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(LinkReferenceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(LinkReference2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelEndpointReference2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelElementReferenceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelElementReference2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelElementReference3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case ModelElementEndpointReferenceEditPart.VISUAL_ID: {
			LinkedList<MidAbstractNavigatorItem> result = new LinkedList<MidAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			MidNavigatorGroup target = new MidNavigatorGroup(
					Messages.NavigatorGroupName_ModelElementEndpointReference_4011_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			MidNavigatorGroup source = new MidNavigatorGroup(
					Messages.NavigatorGroupName_ModelElementEndpointReference_4011_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelElementReferenceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelElementReference2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelElementReference3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(LinkReferenceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(LinkReference2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case BinaryLinkReferenceEditPart.VISUAL_ID: {
			LinkedList<MidAbstractNavigatorItem> result = new LinkedList<MidAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			MidNavigatorGroup target = new MidNavigatorGroup(
					Messages.NavigatorGroupName_BinaryLinkReference_4012_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			MidNavigatorGroup source = new MidNavigatorGroup(
					Messages.NavigatorGroupName_BinaryLinkReference_4012_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			MidNavigatorGroup outgoinglinks = new MidNavigatorGroup(
					Messages.NavigatorGroupName_BinaryLinkReference_4012_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelElementReferenceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelElementReference2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelElementReference3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelElementReferenceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelElementReference2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelElementReference3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case BinaryLinkReference2EditPart.VISUAL_ID: {
			LinkedList<MidAbstractNavigatorItem> result = new LinkedList<MidAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			MidNavigatorGroup target = new MidNavigatorGroup(
					Messages.NavigatorGroupName_BinaryLinkReference_4013_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			MidNavigatorGroup source = new MidNavigatorGroup(
					Messages.NavigatorGroupName_BinaryLinkReference_4013_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			MidNavigatorGroup outgoinglinks = new MidNavigatorGroup(
					Messages.NavigatorGroupName_BinaryLinkReference_4013_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelElementReferenceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelElementReference2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelElementReference3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelElementReferenceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelElementReference2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelElementReference3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ModelElementEndpointReference2EditPart.VISUAL_ID: {
			LinkedList<MidAbstractNavigatorItem> result = new LinkedList<MidAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			MidNavigatorGroup target = new MidNavigatorGroup(
					Messages.NavigatorGroupName_ModelElementEndpointReference_4014_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			MidNavigatorGroup source = new MidNavigatorGroup(
					Messages.NavigatorGroupName_ModelElementEndpointReference_4014_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelElementReferenceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelElementReference2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(ModelElementReference3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(LinkReferenceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					MidVisualIDRegistry
							.getType(LinkReference2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
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
	private Collection<View> getLinksSourceByType(Collection<Edge> edges,
			String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (Edge nextEdge : edges) {
			View nextEdgeSource = nextEdge.getSource();
			if (type.equals(nextEdgeSource.getType())
					&& isOwnView(nextEdgeSource)) {
				result.add(nextEdgeSource);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getLinksTargetByType(Collection<Edge> edges,
			String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (Edge nextEdge : edges) {
			View nextEdgeTarget = nextEdge.getTarget();
			if (type.equals(nextEdgeTarget.getType())
					&& isOwnView(nextEdgeTarget)) {
				result.add(nextEdgeTarget);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getOutgoingLinksByType(
			Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getSourceEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getIncomingLinksByType(
			Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getTargetEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getChildrenByType(
			Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getChildren(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getDiagramLinksByType(
			Collection<Diagram> diagrams, String type) {
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
	private Collection<View> selectViewsByType(Collection<View> views,
			String type) {
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
		return ModelRelEditPart.MODEL_ID.equals(MidVisualIDRegistry
				.getModelID(view));
	}

	/**
	 * @generated
	 */
	private Collection<MidNavigatorItem> createNavigatorItems(
			Collection<View> views, Object parent, boolean isLeafs) {
		ArrayList<MidNavigatorItem> result = new ArrayList<MidNavigatorItem>(
				views.size());
		for (View nextView : views) {
			result.add(new MidNavigatorItem(nextView, parent, isLeafs));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<MidNavigatorItem> getForeignShortcuts(Diagram diagram,
			Object parent) {
		LinkedList<View> result = new LinkedList<View>();
		for (Iterator<View> it = diagram.getChildren().iterator(); it.hasNext();) {
			View nextView = it.next();
			if (!isOwnView(nextView)
					&& nextView.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
				result.add(nextView);
			}
		}
		return createNavigatorItems(result, parent, false);
	}

	/**
	 * @generated
	 */
	public Object getParent(Object element) {
		if (element instanceof MidAbstractNavigatorItem) {
			MidAbstractNavigatorItem abstractNavigatorItem = (MidAbstractNavigatorItem) element;
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

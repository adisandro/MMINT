/*
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
package edu.toronto.cs.se.mmint.mid.diagram.navigator;

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

import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.BinaryModelRelEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ExtendibleElementSupertypeEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.MIDEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.Model2EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelEndpoint2EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelEndpoint3EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelEndpointEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelRel2EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelRelEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.OperatorEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.part.MIDVisualIDRegistry;
import edu.toronto.cs.se.mmint.mid.diagram.part.Messages;

/**
 * @generated
 */
public class MIDNavigatorContentProvider implements ICommonContentProvider {

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
	public MIDNavigatorContentProvider() {
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
			ArrayList<MIDNavigatorItem> result = new ArrayList<MIDNavigatorItem>();
			ArrayList<View> topViews = new ArrayList<View>(resource.getContents().size());
			for (EObject o : resource.getContents()) {
				if (o instanceof View) {
					topViews.add((View) o);
				}
			}
			result.addAll(createNavigatorItems(selectViewsByType(topViews, MIDEditPart.MODEL_ID), file, false));
			return result.toArray();
		}

		if (parentElement instanceof MIDNavigatorGroup) {
			MIDNavigatorGroup group = (MIDNavigatorGroup) parentElement;
			return group.getChildren();
		}

		if (parentElement instanceof MIDNavigatorItem) {
			MIDNavigatorItem navigatorItem = (MIDNavigatorItem) parentElement;
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
		switch (MIDVisualIDRegistry.getVisualID(view)) {

			case MIDEditPart.VISUAL_ID: {
				LinkedList<MIDAbstractNavigatorItem> result = new LinkedList<MIDAbstractNavigatorItem>();
				result.addAll(getForeignShortcuts((Diagram) view, parentElement));
				Diagram sv = (Diagram) view;
				MIDNavigatorGroup links = new MIDNavigatorGroup(
					Messages.NavigatorGroupName_MID_1000_links,
					"icons/linksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
				Collection<View> connectedViews;
				connectedViews = getChildrenByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelEditPart.VISUAL_ID));
				result.addAll(createNavigatorItems(connectedViews, parentElement, false));
				connectedViews = getChildrenByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(Model2EditPart.VISUAL_ID));
				result.addAll(createNavigatorItems(connectedViews, parentElement, false));
				connectedViews = getChildrenByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelRelEditPart.VISUAL_ID));
				result.addAll(createNavigatorItems(connectedViews, parentElement, false));
				connectedViews = getChildrenByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelRel2EditPart.VISUAL_ID));
				result.addAll(createNavigatorItems(connectedViews, parentElement, false));
				connectedViews = getChildrenByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(OperatorEditPart.VISUAL_ID));
				result.addAll(createNavigatorItems(connectedViews, parentElement, false));
				connectedViews = getDiagramLinksByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ExtendibleElementSupertypeEditPart.VISUAL_ID));
				links.addChildren(createNavigatorItems(connectedViews, links, false));
				connectedViews = getDiagramLinksByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelEndpointEditPart.VISUAL_ID));
				links.addChildren(createNavigatorItems(connectedViews, links, false));
				connectedViews = getDiagramLinksByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(BinaryModelRelEditPart.VISUAL_ID));
				links.addChildren(createNavigatorItems(connectedViews, links, false));
				connectedViews = getDiagramLinksByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelEndpoint2EditPart.VISUAL_ID));
				links.addChildren(createNavigatorItems(connectedViews, links, false));
				connectedViews = getDiagramLinksByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelEndpoint3EditPart.VISUAL_ID));
				links.addChildren(createNavigatorItems(connectedViews, links, false));
				if (!links.isEmpty()) {
					result.add(links);
				}
				return result.toArray();
			}

			case ModelEditPart.VISUAL_ID: {
				LinkedList<MIDAbstractNavigatorItem> result = new LinkedList<MIDAbstractNavigatorItem>();
				Node sv = (Node) view;
				MIDNavigatorGroup incominglinks = new MIDNavigatorGroup(
					Messages.NavigatorGroupName_Model_2001_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
				MIDNavigatorGroup outgoinglinks = new MIDNavigatorGroup(
					Messages.NavigatorGroupName_Model_2001_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
				Collection<View> connectedViews;
				connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ExtendibleElementSupertypeEditPart.VISUAL_ID));
				incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
				connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ExtendibleElementSupertypeEditPart.VISUAL_ID));
				outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
				connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelEndpointEditPart.VISUAL_ID));
				incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
				connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(BinaryModelRelEditPart.VISUAL_ID));
				incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
				connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(BinaryModelRelEditPart.VISUAL_ID));
				outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
				connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelEndpoint2EditPart.VISUAL_ID));
				incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
				connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelEndpoint3EditPart.VISUAL_ID));
				incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
				if (!incominglinks.isEmpty()) {
					result.add(incominglinks);
				}
				if (!outgoinglinks.isEmpty()) {
					result.add(outgoinglinks);
				}
				return result.toArray();
			}

			case Model2EditPart.VISUAL_ID: {
				LinkedList<MIDAbstractNavigatorItem> result = new LinkedList<MIDAbstractNavigatorItem>();
				Node sv = (Node) view;
				MIDNavigatorGroup incominglinks = new MIDNavigatorGroup(
					Messages.NavigatorGroupName_Model_2002_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
				MIDNavigatorGroup outgoinglinks = new MIDNavigatorGroup(
					Messages.NavigatorGroupName_Model_2002_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
				Collection<View> connectedViews;
				connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ExtendibleElementSupertypeEditPart.VISUAL_ID));
				incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
				connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ExtendibleElementSupertypeEditPart.VISUAL_ID));
				outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
				connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelEndpointEditPart.VISUAL_ID));
				incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
				connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(BinaryModelRelEditPart.VISUAL_ID));
				incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
				connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(BinaryModelRelEditPart.VISUAL_ID));
				outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
				connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelEndpoint2EditPart.VISUAL_ID));
				incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
				connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelEndpoint3EditPart.VISUAL_ID));
				incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
				if (!incominglinks.isEmpty()) {
					result.add(incominglinks);
				}
				if (!outgoinglinks.isEmpty()) {
					result.add(outgoinglinks);
				}
				return result.toArray();
			}

			case ModelRelEditPart.VISUAL_ID: {
				LinkedList<MIDAbstractNavigatorItem> result = new LinkedList<MIDAbstractNavigatorItem>();
				Node sv = (Node) view;
				MIDNavigatorGroup incominglinks = new MIDNavigatorGroup(
					Messages.NavigatorGroupName_ModelRel_2003_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
				MIDNavigatorGroup outgoinglinks = new MIDNavigatorGroup(
					Messages.NavigatorGroupName_ModelRel_2003_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
				Collection<View> connectedViews;
				connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ExtendibleElementSupertypeEditPart.VISUAL_ID));
				incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
				connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ExtendibleElementSupertypeEditPart.VISUAL_ID));
				outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
				connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelEndpointEditPart.VISUAL_ID));
				incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
				connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelEndpointEditPart.VISUAL_ID));
				outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
				connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(BinaryModelRelEditPart.VISUAL_ID));
				incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
				connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(BinaryModelRelEditPart.VISUAL_ID));
				outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
				connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelEndpoint2EditPart.VISUAL_ID));
				incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
				connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelEndpoint3EditPart.VISUAL_ID));
				incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
				if (!incominglinks.isEmpty()) {
					result.add(incominglinks);
				}
				if (!outgoinglinks.isEmpty()) {
					result.add(outgoinglinks);
				}
				return result.toArray();
			}

			case ModelRel2EditPart.VISUAL_ID: {
				LinkedList<MIDAbstractNavigatorItem> result = new LinkedList<MIDAbstractNavigatorItem>();
				Node sv = (Node) view;
				MIDNavigatorGroup incominglinks = new MIDNavigatorGroup(
					Messages.NavigatorGroupName_ModelRel_2004_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
				MIDNavigatorGroup outgoinglinks = new MIDNavigatorGroup(
					Messages.NavigatorGroupName_ModelRel_2004_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
				Collection<View> connectedViews;
				connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ExtendibleElementSupertypeEditPart.VISUAL_ID));
				incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
				connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ExtendibleElementSupertypeEditPart.VISUAL_ID));
				outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
				connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelEndpointEditPart.VISUAL_ID));
				incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
				connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelEndpointEditPart.VISUAL_ID));
				outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
				connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(BinaryModelRelEditPart.VISUAL_ID));
				incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
				connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(BinaryModelRelEditPart.VISUAL_ID));
				outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
				connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelEndpoint2EditPart.VISUAL_ID));
				incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
				connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelEndpoint3EditPart.VISUAL_ID));
				incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
				if (!incominglinks.isEmpty()) {
					result.add(incominglinks);
				}
				if (!outgoinglinks.isEmpty()) {
					result.add(outgoinglinks);
				}
				return result.toArray();
			}

			case OperatorEditPart.VISUAL_ID: {
				LinkedList<MIDAbstractNavigatorItem> result = new LinkedList<MIDAbstractNavigatorItem>();
				Node sv = (Node) view;
				MIDNavigatorGroup incominglinks = new MIDNavigatorGroup(
					Messages.NavigatorGroupName_Operator_2005_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
				MIDNavigatorGroup outgoinglinks = new MIDNavigatorGroup(
					Messages.NavigatorGroupName_Operator_2005_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
				Collection<View> connectedViews;
				connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ExtendibleElementSupertypeEditPart.VISUAL_ID));
				incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
				connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ExtendibleElementSupertypeEditPart.VISUAL_ID));
				outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
				connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelEndpointEditPart.VISUAL_ID));
				incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
				connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelEndpoint2EditPart.VISUAL_ID));
				incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
				connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelEndpoint2EditPart.VISUAL_ID));
				outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
				connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelEndpoint3EditPart.VISUAL_ID));
				incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
				connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelEndpoint3EditPart.VISUAL_ID));
				outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
				if (!incominglinks.isEmpty()) {
					result.add(incominglinks);
				}
				if (!outgoinglinks.isEmpty()) {
					result.add(outgoinglinks);
				}
				return result.toArray();
			}

			case ExtendibleElementSupertypeEditPart.VISUAL_ID: {
				LinkedList<MIDAbstractNavigatorItem> result = new LinkedList<MIDAbstractNavigatorItem>();
				Edge sv = (Edge) view;
				MIDNavigatorGroup target = new MIDNavigatorGroup(
					Messages.NavigatorGroupName_ExtendibleElementSupertype_4001_target,
					"icons/linkTargetNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
				MIDNavigatorGroup source = new MIDNavigatorGroup(
					Messages.NavigatorGroupName_ExtendibleElementSupertype_4001_source,
					"icons/linkSourceNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
				Collection<View> connectedViews;
				connectedViews = getLinksTargetByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelEditPart.VISUAL_ID));
				target.addChildren(createNavigatorItems(connectedViews, target, true));
				connectedViews = getLinksTargetByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(Model2EditPart.VISUAL_ID));
				target.addChildren(createNavigatorItems(connectedViews, target, true));
				connectedViews = getLinksTargetByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelRelEditPart.VISUAL_ID));
				target.addChildren(createNavigatorItems(connectedViews, target, true));
				connectedViews = getLinksTargetByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelRel2EditPart.VISUAL_ID));
				target.addChildren(createNavigatorItems(connectedViews, target, true));
				connectedViews = getLinksTargetByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(OperatorEditPart.VISUAL_ID));
				target.addChildren(createNavigatorItems(connectedViews, target, true));
				connectedViews = getLinksSourceByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelEditPart.VISUAL_ID));
				source.addChildren(createNavigatorItems(connectedViews, source, true));
				connectedViews = getLinksSourceByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(Model2EditPart.VISUAL_ID));
				source.addChildren(createNavigatorItems(connectedViews, source, true));
				connectedViews = getLinksSourceByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelRelEditPart.VISUAL_ID));
				source.addChildren(createNavigatorItems(connectedViews, source, true));
				connectedViews = getLinksSourceByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelRel2EditPart.VISUAL_ID));
				source.addChildren(createNavigatorItems(connectedViews, source, true));
				connectedViews = getLinksSourceByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(OperatorEditPart.VISUAL_ID));
				source.addChildren(createNavigatorItems(connectedViews, source, true));
				if (!target.isEmpty()) {
					result.add(target);
				}
				if (!source.isEmpty()) {
					result.add(source);
				}
				return result.toArray();
			}

			case ModelEndpointEditPart.VISUAL_ID: {
				LinkedList<MIDAbstractNavigatorItem> result = new LinkedList<MIDAbstractNavigatorItem>();
				Edge sv = (Edge) view;
				MIDNavigatorGroup target = new MIDNavigatorGroup(
					Messages.NavigatorGroupName_ModelEndpoint_4002_target,
					"icons/linkTargetNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
				MIDNavigatorGroup incominglinks = new MIDNavigatorGroup(
					Messages.NavigatorGroupName_ModelEndpoint_4002_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
				MIDNavigatorGroup source = new MIDNavigatorGroup(
					Messages.NavigatorGroupName_ModelEndpoint_4002_source,
					"icons/linkSourceNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
				Collection<View> connectedViews;
				connectedViews = getLinksTargetByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelEditPart.VISUAL_ID));
				target.addChildren(createNavigatorItems(connectedViews, target, true));
				connectedViews = getLinksTargetByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(Model2EditPart.VISUAL_ID));
				target.addChildren(createNavigatorItems(connectedViews, target, true));
				connectedViews = getLinksTargetByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelRelEditPart.VISUAL_ID));
				target.addChildren(createNavigatorItems(connectedViews, target, true));
				connectedViews = getLinksTargetByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelRel2EditPart.VISUAL_ID));
				target.addChildren(createNavigatorItems(connectedViews, target, true));
				connectedViews = getLinksTargetByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(OperatorEditPart.VISUAL_ID));
				target.addChildren(createNavigatorItems(connectedViews, target, true));
				connectedViews = getLinksSourceByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelRelEditPart.VISUAL_ID));
				source.addChildren(createNavigatorItems(connectedViews, source, true));
				connectedViews = getLinksSourceByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelRel2EditPart.VISUAL_ID));
				source.addChildren(createNavigatorItems(connectedViews, source, true));
				if (!target.isEmpty()) {
					result.add(target);
				}
				if (!incominglinks.isEmpty()) {
					result.add(incominglinks);
				}
				if (!source.isEmpty()) {
					result.add(source);
				}
				return result.toArray();
			}

			case BinaryModelRelEditPart.VISUAL_ID: {
				LinkedList<MIDAbstractNavigatorItem> result = new LinkedList<MIDAbstractNavigatorItem>();
				Edge sv = (Edge) view;
				MIDNavigatorGroup target = new MIDNavigatorGroup(
					Messages.NavigatorGroupName_BinaryModelRel_4003_target,
					"icons/linkTargetNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
				MIDNavigatorGroup incominglinks = new MIDNavigatorGroup(
					Messages.NavigatorGroupName_BinaryModelRel_4003_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
				MIDNavigatorGroup source = new MIDNavigatorGroup(
					Messages.NavigatorGroupName_BinaryModelRel_4003_source,
					"icons/linkSourceNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
				MIDNavigatorGroup outgoinglinks = new MIDNavigatorGroup(
					Messages.NavigatorGroupName_BinaryModelRel_4003_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
				Collection<View> connectedViews;
				connectedViews = getLinksTargetByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelEditPart.VISUAL_ID));
				target.addChildren(createNavigatorItems(connectedViews, target, true));
				connectedViews = getLinksTargetByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(Model2EditPart.VISUAL_ID));
				target.addChildren(createNavigatorItems(connectedViews, target, true));
				connectedViews = getLinksTargetByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelRelEditPart.VISUAL_ID));
				target.addChildren(createNavigatorItems(connectedViews, target, true));
				connectedViews = getLinksTargetByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelRel2EditPart.VISUAL_ID));
				target.addChildren(createNavigatorItems(connectedViews, target, true));
				connectedViews = getLinksSourceByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelEditPart.VISUAL_ID));
				source.addChildren(createNavigatorItems(connectedViews, source, true));
				connectedViews = getLinksSourceByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(Model2EditPart.VISUAL_ID));
				source.addChildren(createNavigatorItems(connectedViews, source, true));
				connectedViews = getLinksSourceByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelRelEditPart.VISUAL_ID));
				source.addChildren(createNavigatorItems(connectedViews, source, true));
				connectedViews = getLinksSourceByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelRel2EditPart.VISUAL_ID));
				source.addChildren(createNavigatorItems(connectedViews, source, true));
				if (!target.isEmpty()) {
					result.add(target);
				}
				if (!incominglinks.isEmpty()) {
					result.add(incominglinks);
				}
				if (!source.isEmpty()) {
					result.add(source);
				}
				if (!outgoinglinks.isEmpty()) {
					result.add(outgoinglinks);
				}
				return result.toArray();
			}

			case ModelEndpoint2EditPart.VISUAL_ID: {
				LinkedList<MIDAbstractNavigatorItem> result = new LinkedList<MIDAbstractNavigatorItem>();
				Edge sv = (Edge) view;
				MIDNavigatorGroup target = new MIDNavigatorGroup(
					Messages.NavigatorGroupName_ModelEndpoint_4004_target,
					"icons/linkTargetNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
				MIDNavigatorGroup incominglinks = new MIDNavigatorGroup(
					Messages.NavigatorGroupName_ModelEndpoint_4004_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
				MIDNavigatorGroup source = new MIDNavigatorGroup(
					Messages.NavigatorGroupName_ModelEndpoint_4004_source,
					"icons/linkSourceNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
				Collection<View> connectedViews;
				connectedViews = getLinksTargetByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelEditPart.VISUAL_ID));
				target.addChildren(createNavigatorItems(connectedViews, target, true));
				connectedViews = getLinksTargetByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(Model2EditPart.VISUAL_ID));
				target.addChildren(createNavigatorItems(connectedViews, target, true));
				connectedViews = getLinksTargetByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelRelEditPart.VISUAL_ID));
				target.addChildren(createNavigatorItems(connectedViews, target, true));
				connectedViews = getLinksTargetByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelRel2EditPart.VISUAL_ID));
				target.addChildren(createNavigatorItems(connectedViews, target, true));
				connectedViews = getLinksTargetByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(OperatorEditPart.VISUAL_ID));
				target.addChildren(createNavigatorItems(connectedViews, target, true));
				connectedViews = getLinksSourceByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(OperatorEditPart.VISUAL_ID));
				source.addChildren(createNavigatorItems(connectedViews, source, true));
				if (!target.isEmpty()) {
					result.add(target);
				}
				if (!incominglinks.isEmpty()) {
					result.add(incominglinks);
				}
				if (!source.isEmpty()) {
					result.add(source);
				}
				return result.toArray();
			}

			case ModelEndpoint3EditPart.VISUAL_ID: {
				LinkedList<MIDAbstractNavigatorItem> result = new LinkedList<MIDAbstractNavigatorItem>();
				Edge sv = (Edge) view;
				MIDNavigatorGroup target = new MIDNavigatorGroup(
					Messages.NavigatorGroupName_ModelEndpoint_4005_target,
					"icons/linkTargetNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
				MIDNavigatorGroup incominglinks = new MIDNavigatorGroup(
					Messages.NavigatorGroupName_ModelEndpoint_4005_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
				MIDNavigatorGroup source = new MIDNavigatorGroup(
					Messages.NavigatorGroupName_ModelEndpoint_4005_source,
					"icons/linkSourceNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
				Collection<View> connectedViews;
				connectedViews = getLinksTargetByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelEditPart.VISUAL_ID));
				target.addChildren(createNavigatorItems(connectedViews, target, true));
				connectedViews = getLinksTargetByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(Model2EditPart.VISUAL_ID));
				target.addChildren(createNavigatorItems(connectedViews, target, true));
				connectedViews = getLinksTargetByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelRelEditPart.VISUAL_ID));
				target.addChildren(createNavigatorItems(connectedViews, target, true));
				connectedViews = getLinksTargetByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(ModelRel2EditPart.VISUAL_ID));
				target.addChildren(createNavigatorItems(connectedViews, target, true));
				connectedViews = getLinksTargetByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(OperatorEditPart.VISUAL_ID));
				target.addChildren(createNavigatorItems(connectedViews, target, true));
				connectedViews = getLinksSourceByType(
					Collections.singleton(sv),
					MIDVisualIDRegistry.getType(OperatorEditPart.VISUAL_ID));
				source.addChildren(createNavigatorItems(connectedViews, source, true));
				if (!target.isEmpty()) {
					result.add(target);
				}
				if (!incominglinks.isEmpty()) {
					result.add(incominglinks);
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
		return MIDEditPart.MODEL_ID.equals(MIDVisualIDRegistry.getModelID(view));
	}

	/**
	 * @generated
	 */
	private Collection<MIDNavigatorItem> createNavigatorItems(Collection<View> views, Object parent, boolean isLeafs) {
		ArrayList<MIDNavigatorItem> result = new ArrayList<MIDNavigatorItem>(views.size());
		for (View nextView : views) {
			result.add(new MIDNavigatorItem(nextView, parent, isLeafs));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<MIDNavigatorItem> getForeignShortcuts(Diagram diagram, Object parent) {
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
		if (element instanceof MIDAbstractNavigatorItem) {
			MIDAbstractNavigatorItem abstractNavigatorItem = (MIDAbstractNavigatorItem) element;
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

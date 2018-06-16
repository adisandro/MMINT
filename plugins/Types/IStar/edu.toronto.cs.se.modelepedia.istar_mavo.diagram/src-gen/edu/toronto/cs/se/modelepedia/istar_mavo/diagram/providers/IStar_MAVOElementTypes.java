/*
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.providers.DiagramElementTypeImages;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.providers.DiagramElementTypes;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

/**
 * @generated
 */
public class IStar_MAVOElementTypes {

	/**
	* @generated
	*/
	private IStar_MAVOElementTypes() {
	}

	/**
	* @generated
	*/
	private static Map<IElementType, ENamedElement> elements;

	/**
	* @generated
	*/
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(
			edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVODiagramEditorPlugin.getInstance()
					.getItemProvidersAdapterFactory());

	/**
	* @generated
	*/
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	* @generated
	*/
	public static final IElementType IStar_1000 = getElementType(
			"edu.toronto.cs.se.modelepedia.istar_mavo.diagram.IStar_1000"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType SoftGoal_2001 = getElementType(
			"edu.toronto.cs.se.modelepedia.istar_mavo.diagram.SoftGoal_2001"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Task_2002 = getElementType(
			"edu.toronto.cs.se.modelepedia.istar_mavo.diagram.Task_2002"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Resource_2003 = getElementType(
			"edu.toronto.cs.se.modelepedia.istar_mavo.diagram.Resource_2003"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Goal_2004 = getElementType(
			"edu.toronto.cs.se.modelepedia.istar_mavo.diagram.Goal_2004"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Actor_2005 = getElementType(
			"edu.toronto.cs.se.modelepedia.istar_mavo.diagram.Actor_2005"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType SoftGoal_3001 = getElementType(
			"edu.toronto.cs.se.modelepedia.istar_mavo.diagram.SoftGoal_3001"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Task_3002 = getElementType(
			"edu.toronto.cs.se.modelepedia.istar_mavo.diagram.Task_3002"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Resource_3003 = getElementType(
			"edu.toronto.cs.se.modelepedia.istar_mavo.diagram.Resource_3003"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Goal_3004 = getElementType(
			"edu.toronto.cs.se.modelepedia.istar_mavo.diagram.Goal_3004"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType MeansEnd_4001 = getElementType(
			"edu.toronto.cs.se.modelepedia.istar_mavo.diagram.MeansEnd_4001"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Decomposition_4002 = getElementType(
			"edu.toronto.cs.se.modelepedia.istar_mavo.diagram.Decomposition_4002"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Contribution_4003 = getElementType(
			"edu.toronto.cs.se.modelepedia.istar_mavo.diagram.Contribution_4003"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType DependerLink_4004 = getElementType(
			"edu.toronto.cs.se.modelepedia.istar_mavo.diagram.DependerLink_4004"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType DependeeLink_4005 = getElementType(
			"edu.toronto.cs.se.modelepedia.istar_mavo.diagram.DependeeLink_4005"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		return elementTypeImages.getImageDescriptor(element);
	}

	/**
	* @generated
	*/
	public static Image getImage(ENamedElement element) {
		return elementTypeImages.getImage(element);
	}

	/**
	* @generated
	*/
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		return getImageDescriptor(getElement(hint));
	}

	/**
	* @generated
	*/
	public static Image getImage(IAdaptable hint) {
		return getImage(getElement(hint));
	}

	/**
	* Returns 'type' of the ecore object associated with the hint.
	* 
	* @generated
	*/
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap<IElementType, ENamedElement>();

			elements.put(IStar_1000, edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE.getIStar());

			elements.put(SoftGoal_2001,
					edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE.getSoftGoal());

			elements.put(Task_2002, edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE.getTask());

			elements.put(Resource_2003,
					edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE.getResource());

			elements.put(Goal_2004, edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE.getGoal());

			elements.put(Actor_2005, edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE.getActor());

			elements.put(SoftGoal_3001,
					edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE.getSoftGoal());

			elements.put(Task_3002, edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE.getTask());

			elements.put(Resource_3003,
					edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE.getResource());

			elements.put(Goal_3004, edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE.getGoal());

			elements.put(MeansEnd_4001,
					edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE.getMeansEnd());

			elements.put(Decomposition_4002,
					edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE.getDecomposition());

			elements.put(Contribution_4003,
					edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE.getContribution());

			elements.put(DependerLink_4004,
					edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE.getDependerLink());

			elements.put(DependeeLink_4005,
					edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE.getDependeeLink());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	* @generated
	*/
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	* @generated
	*/
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(IStar_1000);
			KNOWN_ELEMENT_TYPES.add(SoftGoal_2001);
			KNOWN_ELEMENT_TYPES.add(Task_2002);
			KNOWN_ELEMENT_TYPES.add(Resource_2003);
			KNOWN_ELEMENT_TYPES.add(Goal_2004);
			KNOWN_ELEMENT_TYPES.add(Actor_2005);
			KNOWN_ELEMENT_TYPES.add(SoftGoal_3001);
			KNOWN_ELEMENT_TYPES.add(Task_3002);
			KNOWN_ELEMENT_TYPES.add(Resource_3003);
			KNOWN_ELEMENT_TYPES.add(Goal_3004);
			KNOWN_ELEMENT_TYPES.add(MeansEnd_4001);
			KNOWN_ELEMENT_TYPES.add(Decomposition_4002);
			KNOWN_ELEMENT_TYPES.add(Contribution_4003);
			KNOWN_ELEMENT_TYPES.add(DependerLink_4004);
			KNOWN_ELEMENT_TYPES.add(DependeeLink_4005);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	* @generated
	*/
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.IStarEditPart.VISUAL_ID:
			return IStar_1000;
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoalEditPart.VISUAL_ID:
			return SoftGoal_2001;
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.TaskEditPart.VISUAL_ID:
			return Task_2002;
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ResourceEditPart.VISUAL_ID:
			return Resource_2003;
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.GoalEditPart.VISUAL_ID:
			return Goal_2004;
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ActorEditPart.VISUAL_ID:
			return Actor_2005;
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoal2EditPart.VISUAL_ID:
			return SoftGoal_3001;
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Task2EditPart.VISUAL_ID:
			return Task_3002;
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Resource2EditPart.VISUAL_ID:
			return Resource_3003;
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Goal2EditPart.VISUAL_ID:
			return Goal_3004;
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.MeansEndEditPart.VISUAL_ID:
			return MeansEnd_4001;
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DecompositionEditPart.VISUAL_ID:
			return Decomposition_4002;
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ContributionEditPart.VISUAL_ID:
			return Contribution_4003;
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DependerLinkEditPart.VISUAL_ID:
			return DependerLink_4004;
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DependeeLinkEditPart.VISUAL_ID:
			return DependeeLink_4005;
		}
		return null;
	}

	/**
	* @generated
	*/
	public static final DiagramElementTypes TYPED_INSTANCE = new DiagramElementTypes(elementTypeImages) {

		/**
		* @generated
		*/
		@Override

		public boolean isKnownElementType(IElementType elementType) {
			return edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes
					.isKnownElementType(elementType);
		}

		/**
		* @generated
		*/
		@Override

		public IElementType getElementTypeForVisualId(int visualID) {
			return edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes
					.getElementType(visualID);
		}

		/**
		* @generated
		*/
		@Override

		public ENamedElement getDefiningNamedElement(IAdaptable elementTypeAdapter) {
			return edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes
					.getElement(elementTypeAdapter);
		}
	};

}

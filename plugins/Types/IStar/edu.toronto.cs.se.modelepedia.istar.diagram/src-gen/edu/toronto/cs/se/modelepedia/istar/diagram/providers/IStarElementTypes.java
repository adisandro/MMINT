/*
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
package edu.toronto.cs.se.modelepedia.istar.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

import edu.toronto.cs.se.modelepedia.istar.IStarPackage;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.ActorEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.ContributionEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.DecompositionEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.DependeeLinkEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.DependerLinkEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.Goal2EditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.GoalEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.IStarEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.MeansEndEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.Resource2EditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.ResourceEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.SoftGoal2EditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.SoftGoalEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.Task2EditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.TaskEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.part.IStarDiagramEditorPlugin;

/**
 * @generated
 */
public class IStarElementTypes {

	/**
	 * @generated
	 */
	private IStarElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map<IElementType, ENamedElement> elements;

	/**
	 * @generated
	 */
	private static ImageRegistry imageRegistry;

	/**
	 * @generated
	 */
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType IStar_1000 = getElementType("edu.toronto.cs.se.modelepedia.istar.diagram.IStar_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType SoftGoal_2001 = getElementType("edu.toronto.cs.se.modelepedia.istar.diagram.SoftGoal_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Task_2002 = getElementType("edu.toronto.cs.se.modelepedia.istar.diagram.Task_2002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Resource_2003 = getElementType("edu.toronto.cs.se.modelepedia.istar.diagram.Resource_2003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Goal_2004 = getElementType("edu.toronto.cs.se.modelepedia.istar.diagram.Goal_2004"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Actor_2005 = getElementType("edu.toronto.cs.se.modelepedia.istar.diagram.Actor_2005"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType SoftGoal_3001 = getElementType("edu.toronto.cs.se.modelepedia.istar.diagram.SoftGoal_3001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Task_3002 = getElementType("edu.toronto.cs.se.modelepedia.istar.diagram.Task_3002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Resource_3003 = getElementType("edu.toronto.cs.se.modelepedia.istar.diagram.Resource_3003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Goal_3004 = getElementType("edu.toronto.cs.se.modelepedia.istar.diagram.Goal_3004"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType MeansEnd_4001 = getElementType("edu.toronto.cs.se.modelepedia.istar.diagram.MeansEnd_4001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Decomposition_4002 = getElementType("edu.toronto.cs.se.modelepedia.istar.diagram.Decomposition_4002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Contribution_4003 = getElementType("edu.toronto.cs.se.modelepedia.istar.diagram.Contribution_4003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType DependerLink_4004 = getElementType("edu.toronto.cs.se.modelepedia.istar.diagram.DependerLink_4004"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType DependeeLink_4005 = getElementType("edu.toronto.cs.se.modelepedia.istar.diagram.DependeeLink_4005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static ImageRegistry getImageRegistry() {
		if (imageRegistry == null) {
			imageRegistry = new ImageRegistry();
		}
		return imageRegistry;
	}

	/**
	 * @generated
	 */
	private static String getImageRegistryKey(ENamedElement element) {
		return element.getName();
	}

	/**
	 * @generated
	 */
	private static ImageDescriptor getProvidedImageDescriptor(
			ENamedElement element) {
		if (element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature) element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if (eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if (eType instanceof EClass
					&& !((EClass) eType).isAbstract()) {
				element = eType;
			}
		}
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (!eClass.isAbstract()) {
				return IStarDiagramEditorPlugin.getInstance()
						.getItemImageDescriptor(
								eClass.getEPackage().getEFactoryInstance()
										.create(eClass));
			}
		}
		// TODO : support structural features
		return null;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		String key = getImageRegistryKey(element);
		ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);
		if (imageDescriptor == null) {
			imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
		}
		return imageDescriptor;
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		String key = getImageRegistryKey(element);
		Image image = getImageRegistry().get(key);
		if (image == null) {
			ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
			image = getImageRegistry().get(key);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImage(element);
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

			elements.put(IStar_1000, IStarPackage.eINSTANCE.getIStar());

			elements.put(SoftGoal_2001, IStarPackage.eINSTANCE.getSoftGoal());

			elements.put(Task_2002, IStarPackage.eINSTANCE.getTask());

			elements.put(Resource_2003, IStarPackage.eINSTANCE.getResource());

			elements.put(Goal_2004, IStarPackage.eINSTANCE.getGoal());

			elements.put(Actor_2005, IStarPackage.eINSTANCE.getActor());

			elements.put(SoftGoal_3001, IStarPackage.eINSTANCE.getSoftGoal());

			elements.put(Task_3002, IStarPackage.eINSTANCE.getTask());

			elements.put(Resource_3003, IStarPackage.eINSTANCE.getResource());

			elements.put(Goal_3004, IStarPackage.eINSTANCE.getGoal());

			elements.put(MeansEnd_4001, IStarPackage.eINSTANCE.getMeansEnd());

			elements.put(Decomposition_4002,
					IStarPackage.eINSTANCE.getDecomposition());

			elements.put(Contribution_4003,
					IStarPackage.eINSTANCE.getContribution());

			elements.put(DependerLink_4004,
					IStarPackage.eINSTANCE.getDependerLink());

			elements.put(DependeeLink_4005,
					IStarPackage.eINSTANCE.getDependeeLink());
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
		case IStarEditPart.VISUAL_ID:
			return IStar_1000;
		case SoftGoalEditPart.VISUAL_ID:
			return SoftGoal_2001;
		case TaskEditPart.VISUAL_ID:
			return Task_2002;
		case ResourceEditPart.VISUAL_ID:
			return Resource_2003;
		case GoalEditPart.VISUAL_ID:
			return Goal_2004;
		case ActorEditPart.VISUAL_ID:
			return Actor_2005;
		case SoftGoal2EditPart.VISUAL_ID:
			return SoftGoal_3001;
		case Task2EditPart.VISUAL_ID:
			return Task_3002;
		case Resource2EditPart.VISUAL_ID:
			return Resource_3003;
		case Goal2EditPart.VISUAL_ID:
			return Goal_3004;
		case MeansEndEditPart.VISUAL_ID:
			return MeansEnd_4001;
		case DecompositionEditPart.VISUAL_ID:
			return Decomposition_4002;
		case ContributionEditPart.VISUAL_ID:
			return Contribution_4003;
		case DependerLinkEditPart.VISUAL_ID:
			return DependerLink_4004;
		case DependeeLinkEditPart.VISUAL_ID:
			return DependeeLink_4005;
		}
		return null;
	}

}

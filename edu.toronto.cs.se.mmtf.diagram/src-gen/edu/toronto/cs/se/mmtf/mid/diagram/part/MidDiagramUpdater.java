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
package edu.toronto.cs.se.mmtf.mid.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;

import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.MidPackage;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.BinaryModelRelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ExtendibleElementSupertypeEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.Model2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelParameter2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelParameterEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelRel2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelRelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelRelModelsEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.MultiModelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.OperatorEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.providers.MidElementTypes;
import edu.toronto.cs.se.mmtf.mid.operator.ModelParameter;
import edu.toronto.cs.se.mmtf.mid.operator.Operator;
import edu.toronto.cs.se.mmtf.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;

/**
 * @generated
 */
public class MidDiagramUpdater {

	/**
	 * @generated
	 */
	public static boolean isShortcutOrphaned(View view) {
		return !view.isSetElement() || view.getElement() == null
				|| view.getElement().eIsProxy();
	}

	/**
	 * @generated
	 */
	public static List<MidNodeDescriptor> getSemanticChildren(View view) {
		switch (MidVisualIDRegistry.getVisualID(view)) {
		case MultiModelEditPart.VISUAL_ID:
			return getMultiModel_1000SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MidNodeDescriptor> getMultiModel_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		MultiModel modelElement = (MultiModel) view.getElement();
		LinkedList<MidNodeDescriptor> result = new LinkedList<MidNodeDescriptor>();
		for (Iterator<?> it = modelElement.getModels().iterator(); it.hasNext();) {
			Model childElement = (Model) it.next();
			int visualID = MidVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == ModelEditPart.VISUAL_ID) {
				result.add(new MidNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Model2EditPart.VISUAL_ID) {
				result.add(new MidNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ModelRelEditPart.VISUAL_ID) {
				result.add(new MidNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ModelRel2EditPart.VISUAL_ID) {
				result.add(new MidNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getOperators().iterator(); it
				.hasNext();) {
			Operator childElement = (Operator) it.next();
			int visualID = MidVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == OperatorEditPart.VISUAL_ID) {
				result.add(new MidNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getContainedLinks(View view) {
		switch (MidVisualIDRegistry.getVisualID(view)) {
		case MultiModelEditPart.VISUAL_ID:
			return getMultiModel_1000ContainedLinks(view);
		case ModelEditPart.VISUAL_ID:
			return getModel_2001ContainedLinks(view);
		case Model2EditPart.VISUAL_ID:
			return getModel_2002ContainedLinks(view);
		case ModelRelEditPart.VISUAL_ID:
			return getModelRel_2003ContainedLinks(view);
		case ModelRel2EditPart.VISUAL_ID:
			return getModelRel_2004ContainedLinks(view);
		case OperatorEditPart.VISUAL_ID:
			return getOperator_2005ContainedLinks(view);
		case BinaryModelRelEditPart.VISUAL_ID:
			return getBinaryModelRel_4003ContainedLinks(view);
		case ModelParameterEditPart.VISUAL_ID:
			return getModelParameter_4004ContainedLinks(view);
		case ModelParameter2EditPart.VISUAL_ID:
			return getModelParameter_4005ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getIncomingLinks(View view) {
		switch (MidVisualIDRegistry.getVisualID(view)) {
		case ModelEditPart.VISUAL_ID:
			return getModel_2001IncomingLinks(view);
		case Model2EditPart.VISUAL_ID:
			return getModel_2002IncomingLinks(view);
		case ModelRelEditPart.VISUAL_ID:
			return getModelRel_2003IncomingLinks(view);
		case ModelRel2EditPart.VISUAL_ID:
			return getModelRel_2004IncomingLinks(view);
		case OperatorEditPart.VISUAL_ID:
			return getOperator_2005IncomingLinks(view);
		case BinaryModelRelEditPart.VISUAL_ID:
			return getBinaryModelRel_4003IncomingLinks(view);
		case ModelParameterEditPart.VISUAL_ID:
			return getModelParameter_4004IncomingLinks(view);
		case ModelParameter2EditPart.VISUAL_ID:
			return getModelParameter_4005IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getOutgoingLinks(View view) {
		switch (MidVisualIDRegistry.getVisualID(view)) {
		case ModelEditPart.VISUAL_ID:
			return getModel_2001OutgoingLinks(view);
		case Model2EditPart.VISUAL_ID:
			return getModel_2002OutgoingLinks(view);
		case ModelRelEditPart.VISUAL_ID:
			return getModelRel_2003OutgoingLinks(view);
		case ModelRel2EditPart.VISUAL_ID:
			return getModelRel_2004OutgoingLinks(view);
		case OperatorEditPart.VISUAL_ID:
			return getOperator_2005OutgoingLinks(view);
		case BinaryModelRelEditPart.VISUAL_ID:
			return getBinaryModelRel_4003OutgoingLinks(view);
		case ModelParameterEditPart.VISUAL_ID:
			return getModelParameter_4004OutgoingLinks(view);
		case ModelParameter2EditPart.VISUAL_ID:
			return getModelParameter_4005OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getMultiModel_1000ContainedLinks(
			View view) {
		MultiModel modelElement = (MultiModel) view.getElement();
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_BinaryModelRel_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getModel_2001ContainedLinks(View view) {
		Model modelElement = (Model) view.getElement();
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getModel_2002ContainedLinks(View view) {
		Model modelElement = (Model) view.getElement();
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getModelRel_2003ContainedLinks(
			View view) {
		ModelRel modelElement = (ModelRel) view.getElement();
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ModelRel_Models_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getModelRel_2004ContainedLinks(
			View view) {
		ModelRel modelElement = (ModelRel) view.getElement();
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ModelRel_Models_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getOperator_2005ContainedLinks(
			View view) {
		Operator modelElement = (Operator) view.getElement();
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_ModelParameter_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelParameter_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getBinaryModelRel_4003ContainedLinks(
			View view) {
		BinaryModelRel modelElement = (BinaryModelRel) view.getElement();
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ModelRel_Models_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getModelParameter_4004ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getModelParameter_4005ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getModel_2001IncomingLinks(View view) {
		Model modelElement = (Model) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ModelRel_Models_4002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_BinaryModelRel_4003(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelParameter_4004(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelParameter_4005(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getModel_2002IncomingLinks(View view) {
		Model modelElement = (Model) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ModelRel_Models_4002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_BinaryModelRel_4003(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelParameter_4004(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelParameter_4005(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getModelRel_2003IncomingLinks(
			View view) {
		ModelRel modelElement = (ModelRel) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ModelRel_Models_4002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_BinaryModelRel_4003(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelParameter_4004(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelParameter_4005(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getModelRel_2004IncomingLinks(
			View view) {
		ModelRel modelElement = (ModelRel) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ModelRel_Models_4002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_BinaryModelRel_4003(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelParameter_4004(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelParameter_4005(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getOperator_2005IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getBinaryModelRel_4003IncomingLinks(
			View view) {
		BinaryModelRel modelElement = (BinaryModelRel) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ModelRel_Models_4002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_BinaryModelRel_4003(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelParameter_4004(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelParameter_4005(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getModelParameter_4004IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getModelParameter_4005IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getModel_2001OutgoingLinks(View view) {
		Model modelElement = (Model) view.getElement();
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_BinaryModelRel_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getModel_2002OutgoingLinks(View view) {
		Model modelElement = (Model) view.getElement();
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_BinaryModelRel_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getModelRel_2003OutgoingLinks(
			View view) {
		ModelRel modelElement = (ModelRel) view.getElement();
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ModelRel_Models_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_BinaryModelRel_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getModelRel_2004OutgoingLinks(
			View view) {
		ModelRel modelElement = (ModelRel) view.getElement();
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ModelRel_Models_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_BinaryModelRel_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getOperator_2005OutgoingLinks(
			View view) {
		Operator modelElement = (Operator) view.getElement();
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_ModelParameter_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelParameter_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getBinaryModelRel_4003OutgoingLinks(
			View view) {
		BinaryModelRel modelElement = (BinaryModelRel) view.getElement();
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ModelRel_Models_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_BinaryModelRel_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getModelParameter_4004OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getModelParameter_4005OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	private static Collection<MidLinkDescriptor> getContainedTypeModelFacetLinks_BinaryModelRel_4003(
			MultiModel container) {
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		for (Iterator<?> links = container.getModels().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof BinaryModelRel) {
				continue;
			}
			BinaryModelRel link = (BinaryModelRel) linkObject;
			if (BinaryModelRelEditPart.VISUAL_ID != MidVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getModels();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof Model) {
				continue;
			}
			Model dst = (Model) theTarget;
			List sources = link.getModels();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof Model) {
				continue;
			}
			Model src = (Model) theSource;
			result.add(new MidLinkDescriptor(src, dst, link,
					MidElementTypes.BinaryModelRel_4003,
					BinaryModelRelEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MidLinkDescriptor> getContainedTypeModelFacetLinks_ModelParameter_4004(
			Operator container) {
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		for (Iterator<?> links = container.getInputs().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof ModelParameter) {
				continue;
			}
			ModelParameter link = (ModelParameter) linkObject;
			if (ModelParameterEditPart.VISUAL_ID != MidVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Model dst = link.getModel();
			result.add(new MidLinkDescriptor(container, dst, link,
					MidElementTypes.ModelParameter_4004,
					ModelParameterEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MidLinkDescriptor> getContainedTypeModelFacetLinks_ModelParameter_4005(
			Operator container) {
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		for (Iterator<?> links = container.getOutputs().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof ModelParameter) {
				continue;
			}
			ModelParameter link = (ModelParameter) linkObject;
			if (ModelParameter2EditPart.VISUAL_ID != MidVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Model dst = link.getModel();
			result.add(new MidLinkDescriptor(container, dst, link,
					MidElementTypes.ModelParameter_4005,
					ModelParameter2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MidLinkDescriptor> getIncomingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(
			ExtendibleElement target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == MidPackage.eINSTANCE
					.getExtendibleElement_Supertype()) {
				result.add(new MidLinkDescriptor(setting.getEObject(), target,
						MidElementTypes.ExtendibleElementSupertype_4001,
						ExtendibleElementSupertypeEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MidLinkDescriptor> getIncomingFeatureModelFacetLinks_ModelRel_Models_4002(
			Model target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == RelationshipPackage.eINSTANCE
					.getModelRel_Models()) {
				result.add(new MidLinkDescriptor(setting.getEObject(), target,
						MidElementTypes.ModelRelModels_4002,
						ModelRelModelsEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MidLinkDescriptor> getIncomingTypeModelFacetLinks_BinaryModelRel_4003(
			Model target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != RelationshipPackage.eINSTANCE
					.getModelRel_Models()
					|| false == setting.getEObject() instanceof BinaryModelRel) {
				continue;
			}
			BinaryModelRel link = (BinaryModelRel) setting.getEObject();
			if (BinaryModelRelEditPart.VISUAL_ID != MidVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getModels();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof Model) {
				continue;
			}
			Model src = (Model) theSource;
			result.add(new MidLinkDescriptor(src, target, link,
					MidElementTypes.BinaryModelRel_4003,
					BinaryModelRelEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MidLinkDescriptor> getIncomingTypeModelFacetLinks_ModelParameter_4004(
			Model target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != OperatorPackage.eINSTANCE
					.getModelParameter_Model()
					|| false == setting.getEObject() instanceof ModelParameter) {
				continue;
			}
			ModelParameter link = (ModelParameter) setting.getEObject();
			if (ModelParameterEditPart.VISUAL_ID != MidVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			if (false == link.eContainer() instanceof Operator) {
				continue;
			}
			Operator container = (Operator) link.eContainer();
			result.add(new MidLinkDescriptor(container, target, link,
					MidElementTypes.ModelParameter_4004,
					ModelParameterEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MidLinkDescriptor> getIncomingTypeModelFacetLinks_ModelParameter_4005(
			Model target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != OperatorPackage.eINSTANCE
					.getModelParameter_Model()
					|| false == setting.getEObject() instanceof ModelParameter) {
				continue;
			}
			ModelParameter link = (ModelParameter) setting.getEObject();
			if (ModelParameter2EditPart.VISUAL_ID != MidVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			if (false == link.eContainer() instanceof Operator) {
				continue;
			}
			Operator container = (Operator) link.eContainer();
			result.add(new MidLinkDescriptor(container, target, link,
					MidElementTypes.ModelParameter_4005,
					ModelParameter2EditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MidLinkDescriptor> getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(
			ExtendibleElement source) {
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		ExtendibleElement destination = source.getSupertype();
		if (destination == null) {
			return result;
		}
		result.add(new MidLinkDescriptor(source, destination,
				MidElementTypes.ExtendibleElementSupertype_4001,
				ExtendibleElementSupertypeEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MidLinkDescriptor> getOutgoingFeatureModelFacetLinks_ModelRel_Models_4002(
			ModelRel source) {
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		for (Iterator<?> destinations = source.getModels().iterator(); destinations
				.hasNext();) {
			Model destination = (Model) destinations.next();
			result.add(new MidLinkDescriptor(source, destination,
					MidElementTypes.ModelRelModels_4002,
					ModelRelModelsEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MidLinkDescriptor> getOutgoingTypeModelFacetLinks_BinaryModelRel_4003(
			Model source) {
		MultiModel container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof MultiModel) {
				container = (MultiModel) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		for (Iterator<?> links = container.getModels().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof BinaryModelRel) {
				continue;
			}
			BinaryModelRel link = (BinaryModelRel) linkObject;
			if (BinaryModelRelEditPart.VISUAL_ID != MidVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getModels();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof Model) {
				continue;
			}
			Model dst = (Model) theTarget;
			List sources = link.getModels();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof Model) {
				continue;
			}
			Model src = (Model) theSource;
			if (src != source) {
				continue;
			}
			result.add(new MidLinkDescriptor(src, dst, link,
					MidElementTypes.BinaryModelRel_4003,
					BinaryModelRelEditPart.VISUAL_ID));
		}
		return result;
	}

}

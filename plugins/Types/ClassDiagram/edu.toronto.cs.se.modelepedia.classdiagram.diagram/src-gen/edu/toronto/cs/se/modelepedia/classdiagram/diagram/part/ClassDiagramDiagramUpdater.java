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
package edu.toronto.cs.se.modelepedia.classdiagram.diagram.part;

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
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.update.DiagramUpdater;

import edu.toronto.cs.se.modelepedia.classdiagram.Association;
import edu.toronto.cs.se.modelepedia.classdiagram.Attribute;
import edu.toronto.cs.se.modelepedia.classdiagram.Class;
import edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagram;
import edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage;
import edu.toronto.cs.se.modelepedia.classdiagram.Dependency;
import edu.toronto.cs.se.modelepedia.classdiagram.Operation;
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
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.providers.ClassDiagramElementTypes;

/**
 * @generated
 */
public class ClassDiagramDiagramUpdater {

	/**
	* @generated
	*/
	public static boolean isShortcutOrphaned(View view) {
		return !view.isSetElement() || view.getElement() == null || view.getElement().eIsProxy();
	}

	/**
	* @generated
	*/
	public static List<ClassDiagramNodeDescriptor> getSemanticChildren(View view) {
		switch (ClassDiagramVisualIDRegistry.getVisualID(view)) {
			case ClassDiagramEditPart.VISUAL_ID:
				return getClassDiagram_1000SemanticChildren(view);
			case ClassClassOwnedAttributesCompartmentEditPart.VISUAL_ID:
				return getClassClassOwnedAttributesCompartment_7001SemanticChildren(view);
			case ClassClassOwnedOperationsCompartmentEditPart.VISUAL_ID:
				return getClassClassOwnedOperationsCompartment_7002SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<ClassDiagramNodeDescriptor> getClassDiagram_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		ClassDiagram modelElement = (ClassDiagram) view.getElement();
		LinkedList<ClassDiagramNodeDescriptor> result = new LinkedList<ClassDiagramNodeDescriptor>();
		for (Iterator<?> it = modelElement.getClasses().iterator(); it.hasNext();) {
			Class childElement = (Class) it.next();
			int visualID = ClassDiagramVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ClassEditPart.VISUAL_ID) {
				result.add(new ClassDiagramNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<ClassDiagramNodeDescriptor> getClassClassOwnedAttributesCompartment_7001SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Class modelElement = (Class) containerView.getElement();
		LinkedList<ClassDiagramNodeDescriptor> result = new LinkedList<ClassDiagramNodeDescriptor>();
		for (Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Attribute childElement = (Attribute) it.next();
			int visualID = ClassDiagramVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == AttributeEditPart.VISUAL_ID) {
				result.add(new ClassDiagramNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<ClassDiagramNodeDescriptor> getClassClassOwnedOperationsCompartment_7002SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Class modelElement = (Class) containerView.getElement();
		LinkedList<ClassDiagramNodeDescriptor> result = new LinkedList<ClassDiagramNodeDescriptor>();
		for (Iterator<?> it = modelElement.getOwnedOperations().iterator(); it.hasNext();) {
			Operation childElement = (Operation) it.next();
			int visualID = ClassDiagramVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperationEditPart.VISUAL_ID) {
				result.add(new ClassDiagramNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<ClassDiagramLinkDescriptor> getContainedLinks(View view) {
		switch (ClassDiagramVisualIDRegistry.getVisualID(view)) {
			case ClassDiagramEditPart.VISUAL_ID:
				return getClassDiagram_1000ContainedLinks(view);
			case ClassEditPart.VISUAL_ID:
				return getClass_2001ContainedLinks(view);
			case AttributeEditPart.VISUAL_ID:
				return getAttribute_3001ContainedLinks(view);
			case OperationEditPart.VISUAL_ID:
				return getOperation_3002ContainedLinks(view);
			case AssociationEditPart.VISUAL_ID:
				return getAssociation_4001ContainedLinks(view);
			case DependencyEditPart.VISUAL_ID:
				return getDependency_4002ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<ClassDiagramLinkDescriptor> getIncomingLinks(View view) {
		switch (ClassDiagramVisualIDRegistry.getVisualID(view)) {
			case ClassEditPart.VISUAL_ID:
				return getClass_2001IncomingLinks(view);
			case AttributeEditPart.VISUAL_ID:
				return getAttribute_3001IncomingLinks(view);
			case OperationEditPart.VISUAL_ID:
				return getOperation_3002IncomingLinks(view);
			case AssociationEditPart.VISUAL_ID:
				return getAssociation_4001IncomingLinks(view);
			case DependencyEditPart.VISUAL_ID:
				return getDependency_4002IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<ClassDiagramLinkDescriptor> getOutgoingLinks(View view) {
		switch (ClassDiagramVisualIDRegistry.getVisualID(view)) {
			case ClassEditPart.VISUAL_ID:
				return getClass_2001OutgoingLinks(view);
			case AttributeEditPart.VISUAL_ID:
				return getAttribute_3001OutgoingLinks(view);
			case OperationEditPart.VISUAL_ID:
				return getOperation_3002OutgoingLinks(view);
			case AssociationEditPart.VISUAL_ID:
				return getAssociation_4001OutgoingLinks(view);
			case DependencyEditPart.VISUAL_ID:
				return getDependency_4002OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ClassDiagramLinkDescriptor> getClassDiagram_1000ContainedLinks(View view) {
		ClassDiagram modelElement = (ClassDiagram) view.getElement();
		LinkedList<ClassDiagramLinkDescriptor> result = new LinkedList<ClassDiagramLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ClassDiagramLinkDescriptor> getClass_2001ContainedLinks(View view) {
		Class modelElement = (Class) view.getElement();
		LinkedList<ClassDiagramLinkDescriptor> result = new LinkedList<ClassDiagramLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Class_NestedIn_4003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Class_Superclass_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ClassDiagramLinkDescriptor> getAttribute_3001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ClassDiagramLinkDescriptor> getOperation_3002ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ClassDiagramLinkDescriptor> getAssociation_4001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ClassDiagramLinkDescriptor> getDependency_4002ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ClassDiagramLinkDescriptor> getClass_2001IncomingLinks(View view) {
		Class modelElement = (Class) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
			.find(view.eResource().getResourceSet().getResources());
		LinkedList<ClassDiagramLinkDescriptor> result = new LinkedList<ClassDiagramLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Class_NestedIn_4003(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Class_Superclass_4004(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ClassDiagramLinkDescriptor> getAttribute_3001IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ClassDiagramLinkDescriptor> getOperation_3002IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ClassDiagramLinkDescriptor> getAssociation_4001IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ClassDiagramLinkDescriptor> getDependency_4002IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ClassDiagramLinkDescriptor> getClass_2001OutgoingLinks(View view) {
		Class modelElement = (Class) view.getElement();
		LinkedList<ClassDiagramLinkDescriptor> result = new LinkedList<ClassDiagramLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Class_NestedIn_4003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Class_Superclass_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ClassDiagramLinkDescriptor> getAttribute_3001OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ClassDiagramLinkDescriptor> getOperation_3002OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ClassDiagramLinkDescriptor> getAssociation_4001OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ClassDiagramLinkDescriptor> getDependency_4002OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	private static Collection<ClassDiagramLinkDescriptor> getContainedTypeModelFacetLinks_Association_4001(
			ClassDiagram container) {
		LinkedList<ClassDiagramLinkDescriptor> result = new LinkedList<ClassDiagramLinkDescriptor>();
		for (Iterator<?> links = container.getAssociations().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Association) {
				continue;
			}
			Association link = (Association) linkObject;
			if (AssociationEditPart.VISUAL_ID != ClassDiagramVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Class dst = link.getTarget();
			Class src = link.getSource();
			result.add(
				new ClassDiagramLinkDescriptor(
					src,
					dst,
					link,
					ClassDiagramElementTypes.Association_4001,
					AssociationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<ClassDiagramLinkDescriptor> getContainedTypeModelFacetLinks_Dependency_4002(
			ClassDiagram container) {
		LinkedList<ClassDiagramLinkDescriptor> result = new LinkedList<ClassDiagramLinkDescriptor>();
		for (Iterator<?> links = container.getDependencies().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency) linkObject;
			if (DependencyEditPart.VISUAL_ID != ClassDiagramVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Class dst = link.getDepender();
			Class src = link.getDependee();
			result.add(
				new ClassDiagramLinkDescriptor(
					src,
					dst,
					link,
					ClassDiagramElementTypes.Dependency_4002,
					DependencyEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ClassDiagramLinkDescriptor> getIncomingTypeModelFacetLinks_Association_4001(
			Class target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ClassDiagramLinkDescriptor> result = new LinkedList<ClassDiagramLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != ClassDiagramPackage.eINSTANCE.getAssociation_Target()
					|| false == setting.getEObject() instanceof Association) {
				continue;
			}
			Association link = (Association) setting.getEObject();
			if (AssociationEditPart.VISUAL_ID != ClassDiagramVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Class src = link.getSource();
			result.add(
				new ClassDiagramLinkDescriptor(
					src,
					target,
					link,
					ClassDiagramElementTypes.Association_4001,
					AssociationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ClassDiagramLinkDescriptor> getIncomingTypeModelFacetLinks_Dependency_4002(
			Class target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ClassDiagramLinkDescriptor> result = new LinkedList<ClassDiagramLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != ClassDiagramPackage.eINSTANCE.getDependency_Depender()
					|| false == setting.getEObject() instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency) setting.getEObject();
			if (DependencyEditPart.VISUAL_ID != ClassDiagramVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Class src = link.getDependee();
			result.add(
				new ClassDiagramLinkDescriptor(
					src,
					target,
					link,
					ClassDiagramElementTypes.Dependency_4002,
					DependencyEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ClassDiagramLinkDescriptor> getIncomingFeatureModelFacetLinks_Class_NestedIn_4003(
			Class target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ClassDiagramLinkDescriptor> result = new LinkedList<ClassDiagramLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == ClassDiagramPackage.eINSTANCE.getClass_NestedIn()) {
				result.add(
					new ClassDiagramLinkDescriptor(
						setting.getEObject(),
						target,
						ClassDiagramElementTypes.ClassNestedIn_4003,
						ClassNestedInEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ClassDiagramLinkDescriptor> getIncomingFeatureModelFacetLinks_Class_Superclass_4004(
			Class target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ClassDiagramLinkDescriptor> result = new LinkedList<ClassDiagramLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == ClassDiagramPackage.eINSTANCE.getClass_Superclass()) {
				result.add(
					new ClassDiagramLinkDescriptor(
						setting.getEObject(),
						target,
						ClassDiagramElementTypes.ClassSuperclass_4004,
						ClassSuperclassEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<ClassDiagramLinkDescriptor> getOutgoingTypeModelFacetLinks_Association_4001(
			Class source) {
		ClassDiagram container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof ClassDiagram) {
				container = (ClassDiagram) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<ClassDiagramLinkDescriptor> result = new LinkedList<ClassDiagramLinkDescriptor>();
		for (Iterator<?> links = container.getAssociations().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Association) {
				continue;
			}
			Association link = (Association) linkObject;
			if (AssociationEditPart.VISUAL_ID != ClassDiagramVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Class dst = link.getTarget();
			Class src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(
				new ClassDiagramLinkDescriptor(
					src,
					dst,
					link,
					ClassDiagramElementTypes.Association_4001,
					AssociationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<ClassDiagramLinkDescriptor> getOutgoingTypeModelFacetLinks_Dependency_4002(Class source) {
		ClassDiagram container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof ClassDiagram) {
				container = (ClassDiagram) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<ClassDiagramLinkDescriptor> result = new LinkedList<ClassDiagramLinkDescriptor>();
		for (Iterator<?> links = container.getDependencies().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency) linkObject;
			if (DependencyEditPart.VISUAL_ID != ClassDiagramVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Class dst = link.getDepender();
			Class src = link.getDependee();
			if (src != source) {
				continue;
			}
			result.add(
				new ClassDiagramLinkDescriptor(
					src,
					dst,
					link,
					ClassDiagramElementTypes.Dependency_4002,
					DependencyEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<ClassDiagramLinkDescriptor> getOutgoingFeatureModelFacetLinks_Class_NestedIn_4003(
			Class source) {
		LinkedList<ClassDiagramLinkDescriptor> result = new LinkedList<ClassDiagramLinkDescriptor>();
		Class destination = source.getNestedIn();
		if (destination == null) {
			return result;
		}
		result.add(
			new ClassDiagramLinkDescriptor(
				source,
				destination,
				ClassDiagramElementTypes.ClassNestedIn_4003,
				ClassNestedInEditPart.VISUAL_ID));
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<ClassDiagramLinkDescriptor> getOutgoingFeatureModelFacetLinks_Class_Superclass_4004(
			Class source) {
		LinkedList<ClassDiagramLinkDescriptor> result = new LinkedList<ClassDiagramLinkDescriptor>();
		Class destination = source.getSuperclass();
		if (destination == null) {
			return result;
		}
		result.add(
			new ClassDiagramLinkDescriptor(
				source,
				destination,
				ClassDiagramElementTypes.ClassSuperclass_4004,
				ClassSuperclassEditPart.VISUAL_ID));
		return result;
	}

	/**
	* @generated
	*/
	public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {
		/**
		* @generated
		*/
		@Override

		public List<ClassDiagramNodeDescriptor> getSemanticChildren(View view) {
			return ClassDiagramDiagramUpdater.getSemanticChildren(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<ClassDiagramLinkDescriptor> getContainedLinks(View view) {
			return ClassDiagramDiagramUpdater.getContainedLinks(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<ClassDiagramLinkDescriptor> getIncomingLinks(View view) {
			return ClassDiagramDiagramUpdater.getIncomingLinks(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<ClassDiagramLinkDescriptor> getOutgoingLinks(View view) {
			return ClassDiagramDiagramUpdater.getOutgoingLinks(view);
		}
	};

}

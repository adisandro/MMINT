/**
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
package edu.toronto.cs.se.modelepedia.classdiagram;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassdiagramFactory
 * @model kind="package"
 * @generated
 */
public interface ClassdiagramPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "classdiagram";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://se.cs.toronto.edu/modelepedia/classdiagram";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "classdiagram";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ClassdiagramPackage eINSTANCE = edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassdiagramPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassDiagramImpl <em>Class Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassDiagramImpl
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassdiagramPackageImpl#getClassDiagram()
	 * @generated
	 */
	int CLASS_DIAGRAM = 0;

	/**
	 * The feature id for the '<em><b>Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DIAGRAM__CLASSES = 0;

	/**
	 * The number of structural features of the '<em>Class Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DIAGRAM_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Class Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DIAGRAM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.NamedElementImpl
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassdiagramPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassImpl <em>Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassImpl
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassdiagramPackageImpl#getClass_()
	 * @generated
	 */
	int CLASS = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owned Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__OWNED_ATTRIBUTES = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.AttributeImpl
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassdiagramPackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__TYPE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__VALUE = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagram <em>Class Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Diagram</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagram
	 * @generated
	 */
	EClass getClassDiagram();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagram#getClasses <em>Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classes</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagram#getClasses()
	 * @see #getClassDiagram()
	 * @generated
	 */
	EReference getClassDiagram_Classes();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.classdiagram.Class <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.Class
	 * @generated
	 */
	EClass getClass_();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.classdiagram.Class#getOwnedAttributes <em>Owned Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Attributes</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.Class#getOwnedAttributes()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_OwnedAttributes();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.classdiagram.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.classdiagram.Attribute#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.Attribute#getType()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Type();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.classdiagram.Attribute#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.Attribute#getValue()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Value();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.classdiagram.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.classdiagram.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ClassdiagramFactory getClassdiagramFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassDiagramImpl <em>Class Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassDiagramImpl
		 * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassdiagramPackageImpl#getClassDiagram()
		 * @generated
		 */
		EClass CLASS_DIAGRAM = eINSTANCE.getClassDiagram();

		/**
		 * The meta object literal for the '<em><b>Classes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_DIAGRAM__CLASSES = eINSTANCE.getClassDiagram_Classes();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassImpl <em>Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassImpl
		 * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassdiagramPackageImpl#getClass_()
		 * @generated
		 */
		EClass CLASS = eINSTANCE.getClass_();

		/**
		 * The meta object literal for the '<em><b>Owned Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__OWNED_ATTRIBUTES = eINSTANCE.getClass_OwnedAttributes();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.AttributeImpl
		 * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassdiagramPackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__TYPE = eINSTANCE.getAttribute_Type();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__VALUE = eINSTANCE.getAttribute_Value();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.NamedElementImpl
		 * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassdiagramPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

	}

} //ClassdiagramPackage

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
import org.eclipse.emf.ecore.EEnum;
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
	String eNS_URI = "http://se.cs.toronto.edu/modelepedia/ClassDiagram";

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
	 * The feature id for the '<em><b>Dependencies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DIAGRAM__DEPENDENCIES = 1;

	/**
	 * The number of structural features of the '<em>Class Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DIAGRAM_FEATURE_COUNT = 2;

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
	 * The feature id for the '<em><b>Owned Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__OWNED_OPERATIONS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Dependencies As Dependee</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__DEPENDENCIES_AS_DEPENDEE = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Dependencies As Depender</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__DEPENDENCIES_AS_DEPENDER = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 4;

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
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__VISIBILITY = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.OperationImpl <em>Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.OperationImpl
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassdiagramPackageImpl#getOperation()
	 * @generated
	 */
	int OPERATION = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__VISIBILITY = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.DependencyImpl <em>Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.DependencyImpl
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassdiagramPackageImpl#getDependency()
	 * @generated
	 */
	int DEPENDENCY = 5;

	/**
	 * The feature id for the '<em><b>Dependee</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__DEPENDEE = 0;

	/**
	 * The feature id for the '<em><b>Depender</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__DEPENDER = 1;

	/**
	 * The number of structural features of the '<em>Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.classdiagram.Visibility <em>Visibility</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.Visibility
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassdiagramPackageImpl#getVisibility()
	 * @generated
	 */
	int VISIBILITY = 6;


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
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagram#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dependencies</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagram#getDependencies()
	 * @see #getClassDiagram()
	 * @generated
	 */
	EReference getClassDiagram_Dependencies();

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
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.classdiagram.Class#getOwnedOperations <em>Owned Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Operations</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.Class#getOwnedOperations()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_OwnedOperations();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.classdiagram.Class#getDependenciesAsDependee <em>Dependencies As Dependee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dependencies As Dependee</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.Class#getDependenciesAsDependee()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_DependenciesAsDependee();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.classdiagram.Class#getDependenciesAsDepender <em>Dependencies As Depender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dependencies As Depender</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.Class#getDependenciesAsDepender()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_DependenciesAsDepender();

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
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.classdiagram.Attribute#getVisibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visibility</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.Attribute#getVisibility()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Visibility();

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
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.classdiagram.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.Operation
	 * @generated
	 */
	EClass getOperation();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.classdiagram.Operation#getVisibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visibility</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.Operation#getVisibility()
	 * @see #getOperation()
	 * @generated
	 */
	EAttribute getOperation_Visibility();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.classdiagram.Dependency <em>Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependency</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.Dependency
	 * @generated
	 */
	EClass getDependency();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.classdiagram.Dependency#getDependee <em>Dependee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Dependee</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.Dependency#getDependee()
	 * @see #getDependency()
	 * @generated
	 */
	EReference getDependency_Dependee();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.classdiagram.Dependency#getDepender <em>Depender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Depender</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.Dependency#getDepender()
	 * @see #getDependency()
	 * @generated
	 */
	EReference getDependency_Depender();

	/**
	 * Returns the meta object for enum '{@link edu.toronto.cs.se.modelepedia.classdiagram.Visibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Visibility</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram.Visibility
	 * @generated
	 */
	EEnum getVisibility();

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
		 * The meta object literal for the '<em><b>Dependencies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_DIAGRAM__DEPENDENCIES = eINSTANCE.getClassDiagram_Dependencies();

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
		 * The meta object literal for the '<em><b>Owned Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__OWNED_OPERATIONS = eINSTANCE.getClass_OwnedOperations();

		/**
		 * The meta object literal for the '<em><b>Dependencies As Dependee</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__DEPENDENCIES_AS_DEPENDEE = eINSTANCE.getClass_DependenciesAsDependee();

		/**
		 * The meta object literal for the '<em><b>Dependencies As Depender</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__DEPENDENCIES_AS_DEPENDER = eINSTANCE.getClass_DependenciesAsDepender();

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
		 * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__VISIBILITY = eINSTANCE.getAttribute_Visibility();

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

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.OperationImpl <em>Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.OperationImpl
		 * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassdiagramPackageImpl#getOperation()
		 * @generated
		 */
		EClass OPERATION = eINSTANCE.getOperation();

		/**
		 * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION__VISIBILITY = eINSTANCE.getOperation_Visibility();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.DependencyImpl <em>Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.DependencyImpl
		 * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassdiagramPackageImpl#getDependency()
		 * @generated
		 */
		EClass DEPENDENCY = eINSTANCE.getDependency();

		/**
		 * The meta object literal for the '<em><b>Dependee</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY__DEPENDEE = eINSTANCE.getDependency_Dependee();

		/**
		 * The meta object literal for the '<em><b>Depender</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY__DEPENDER = eINSTANCE.getDependency_Depender();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.classdiagram.Visibility <em>Visibility</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.classdiagram.Visibility
		 * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassdiagramPackageImpl#getVisibility()
		 * @generated
		 */
		EEnum VISIBILITY = eINSTANCE.getVisibility();

	}

} //ClassdiagramPackage

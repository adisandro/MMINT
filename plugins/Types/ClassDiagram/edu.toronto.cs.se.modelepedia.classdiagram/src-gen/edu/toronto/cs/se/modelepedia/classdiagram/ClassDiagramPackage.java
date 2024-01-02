/**
 * Copyright (c) 2012-2024 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
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
 * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot'"
 * @generated
 */
public interface ClassDiagramPackage extends EPackage {
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
	ClassDiagramPackage eINSTANCE = edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassDiagramPackageImpl.init();

	/**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassDiagramImpl <em>Class Diagram</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassDiagramImpl
   * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassDiagramPackageImpl#getClassDiagram()
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
   * The feature id for the '<em><b>Associations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CLASS_DIAGRAM__ASSOCIATIONS = 2;

	/**
   * The feature id for the '<em><b>Datatypes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CLASS_DIAGRAM__DATATYPES = 3;

	/**
   * The feature id for the '<em><b>Compositions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CLASS_DIAGRAM__COMPOSITIONS = 4;

	/**
   * The number of structural features of the '<em>Class Diagram</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CLASS_DIAGRAM_FEATURE_COUNT = 5;

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
   * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassDiagramPackageImpl#getNamedElement()
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
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.TypeableImpl <em>Typeable</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.TypeableImpl
   * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassDiagramPackageImpl#getTypeable()
   * @generated
   */
	int TYPEABLE = 8;

	/**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TYPEABLE__NAME = ClassDiagramPackage.NAMED_ELEMENT__NAME;

	/**
   * The number of structural features of the '<em>Typeable</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TYPEABLE_FEATURE_COUNT = ClassDiagramPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
   * The number of operations of the '<em>Typeable</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TYPEABLE_OPERATION_COUNT = ClassDiagramPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassImpl <em>Class</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassImpl
   * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassDiagramPackageImpl#getClass_()
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
	int CLASS__NAME = ClassDiagramPackage.TYPEABLE__NAME;

	/**
   * The feature id for the '<em><b>Owned Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CLASS__OWNED_ATTRIBUTES = ClassDiagramPackage.TYPEABLE_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Owned Operations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CLASS__OWNED_OPERATIONS = ClassDiagramPackage.TYPEABLE_FEATURE_COUNT + 1;

	/**
   * The feature id for the '<em><b>Dependencies As Dependee</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CLASS__DEPENDENCIES_AS_DEPENDEE = ClassDiagramPackage.TYPEABLE_FEATURE_COUNT + 2;

	/**
   * The feature id for the '<em><b>Dependencies As Depender</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CLASS__DEPENDENCIES_AS_DEPENDER = ClassDiagramPackage.TYPEABLE_FEATURE_COUNT + 3;

	/**
   * The feature id for the '<em><b>Nested In</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CLASS__NESTED_IN = ClassDiagramPackage.TYPEABLE_FEATURE_COUNT + 4;

	/**
   * The feature id for the '<em><b>Nested</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CLASS__NESTED = ClassDiagramPackage.TYPEABLE_FEATURE_COUNT + 5;

	/**
   * The feature id for the '<em><b>Superclass</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CLASS__SUPERCLASS = ClassDiagramPackage.TYPEABLE_FEATURE_COUNT + 6;

	/**
   * The feature id for the '<em><b>Subclasses</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CLASS__SUBCLASSES = ClassDiagramPackage.TYPEABLE_FEATURE_COUNT + 7;

	/**
   * The feature id for the '<em><b>Associations As Source</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CLASS__ASSOCIATIONS_AS_SOURCE = ClassDiagramPackage.TYPEABLE_FEATURE_COUNT + 8;

	/**
   * The feature id for the '<em><b>Associations As Target</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CLASS__ASSOCIATIONS_AS_TARGET = ClassDiagramPackage.TYPEABLE_FEATURE_COUNT + 9;

	/**
   * The feature id for the '<em><b>Compositions As Constituent</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CLASS__COMPOSITIONS_AS_CONSTITUENT = ClassDiagramPackage.TYPEABLE_FEATURE_COUNT + 10;

	/**
   * The feature id for the '<em><b>Compositions As Composite</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CLASS__COMPOSITIONS_AS_COMPOSITE = ClassDiagramPackage.TYPEABLE_FEATURE_COUNT + 11;

	/**
   * The number of structural features of the '<em>Class</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CLASS_FEATURE_COUNT = ClassDiagramPackage.TYPEABLE_FEATURE_COUNT + 12;

	/**
   * The number of operations of the '<em>Class</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CLASS_OPERATION_COUNT = ClassDiagramPackage.TYPEABLE_OPERATION_COUNT + 0;

	/**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.TypedElementImpl <em>Typed Element</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.TypedElementImpl
   * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassDiagramPackageImpl#getTypedElement()
   * @generated
   */
	int TYPED_ELEMENT = 6;

	/**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TYPED_ELEMENT__NAME = ClassDiagramPackage.NAMED_ELEMENT__NAME;

	/**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TYPED_ELEMENT__TYPE = ClassDiagramPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Public</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TYPED_ELEMENT__PUBLIC = ClassDiagramPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
   * The number of structural features of the '<em>Typed Element</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TYPED_ELEMENT_FEATURE_COUNT = ClassDiagramPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
   * The number of operations of the '<em>Typed Element</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TYPED_ELEMENT_OPERATION_COUNT = ClassDiagramPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.AttributeImpl <em>Attribute</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.AttributeImpl
   * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassDiagramPackageImpl#getAttribute()
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
	int ATTRIBUTE__NAME = ClassDiagramPackage.TYPED_ELEMENT__NAME;

	/**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ATTRIBUTE__TYPE = ClassDiagramPackage.TYPED_ELEMENT__TYPE;

	/**
   * The feature id for the '<em><b>Public</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ATTRIBUTE__PUBLIC = ClassDiagramPackage.TYPED_ELEMENT__PUBLIC;

	/**
   * The number of structural features of the '<em>Attribute</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ATTRIBUTE_FEATURE_COUNT = ClassDiagramPackage.TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
   * The number of operations of the '<em>Attribute</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ATTRIBUTE_OPERATION_COUNT = ClassDiagramPackage.TYPED_ELEMENT_OPERATION_COUNT + 0;

	/**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.OperationImpl <em>Operation</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.OperationImpl
   * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassDiagramPackageImpl#getOperation()
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
	int OPERATION__NAME = ClassDiagramPackage.TYPED_ELEMENT__NAME;

	/**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int OPERATION__TYPE = ClassDiagramPackage.TYPED_ELEMENT__TYPE;

	/**
   * The feature id for the '<em><b>Public</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int OPERATION__PUBLIC = ClassDiagramPackage.TYPED_ELEMENT__PUBLIC;

	/**
   * The feature id for the '<em><b>Parameter Types</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int OPERATION__PARAMETER_TYPES = ClassDiagramPackage.TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>Operation</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int OPERATION_FEATURE_COUNT = ClassDiagramPackage.TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
   * The number of operations of the '<em>Operation</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int OPERATION_OPERATION_COUNT = ClassDiagramPackage.TYPED_ELEMENT_OPERATION_COUNT + 0;

	/**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.DependencyImpl <em>Dependency</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.DependencyImpl
   * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassDiagramPackageImpl#getDependency()
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
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int DEPENDENCY__NAME = 2;

	/**
   * The number of structural features of the '<em>Dependency</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int DEPENDENCY_FEATURE_COUNT = 3;

	/**
   * The number of operations of the '<em>Dependency</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int DEPENDENCY_OPERATION_COUNT = 0;

	/**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.AssociationImpl <em>Association</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.AssociationImpl
   * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassDiagramPackageImpl#getAssociation()
   * @generated
   */
	int ASSOCIATION = 7;

	/**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ASSOCIATION__NAME = ClassDiagramPackage.NAMED_ELEMENT__NAME;

	/**
   * The feature id for the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ASSOCIATION__SOURCE = ClassDiagramPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ASSOCIATION__TARGET = ClassDiagramPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
   * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ASSOCIATION__MULTIPLICITY = ClassDiagramPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
   * The number of structural features of the '<em>Association</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ASSOCIATION_FEATURE_COUNT = ClassDiagramPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
   * The number of operations of the '<em>Association</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ASSOCIATION_OPERATION_COUNT = ClassDiagramPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.DataTypeImpl <em>Data Type</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.DataTypeImpl
   * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassDiagramPackageImpl#getDataType()
   * @generated
   */
	int DATA_TYPE = 9;

	/**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int DATA_TYPE__NAME = ClassDiagramPackage.TYPEABLE__NAME;

	/**
   * The number of structural features of the '<em>Data Type</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int DATA_TYPE_FEATURE_COUNT = ClassDiagramPackage.TYPEABLE_FEATURE_COUNT + 0;

	/**
   * The number of operations of the '<em>Data Type</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int DATA_TYPE_OPERATION_COUNT = ClassDiagramPackage.TYPEABLE_OPERATION_COUNT + 0;


	/**
   * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.CompositionImpl <em>Composition</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.CompositionImpl
   * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassDiagramPackageImpl#getComposition()
   * @generated
   */
	int COMPOSITION = 10;

	/**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int COMPOSITION__NAME = ClassDiagramPackage.NAMED_ELEMENT__NAME;

	/**
   * The feature id for the '<em><b>Constituent</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int COMPOSITION__CONSTITUENT = ClassDiagramPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Composite</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int COMPOSITION__COMPOSITE = ClassDiagramPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
   * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int COMPOSITION__MULTIPLICITY = ClassDiagramPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
   * The number of structural features of the '<em>Composition</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int COMPOSITION_FEATURE_COUNT = ClassDiagramPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
   * The number of operations of the '<em>Composition</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int COMPOSITION_OPERATION_COUNT = ClassDiagramPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;


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
   * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagram#getAssociations <em>Associations</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Associations</em>'.
   * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagram#getAssociations()
   * @see #getClassDiagram()
   * @generated
   */
	EReference getClassDiagram_Associations();

	/**
   * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagram#getDatatypes <em>Datatypes</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Datatypes</em>'.
   * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagram#getDatatypes()
   * @see #getClassDiagram()
   * @generated
   */
	EReference getClassDiagram_Datatypes();

	/**
   * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagram#getCompositions <em>Compositions</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Compositions</em>'.
   * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagram#getCompositions()
   * @see #getClassDiagram()
   * @generated
   */
	EReference getClassDiagram_Compositions();

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
   * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.classdiagram.Class#getNestedIn <em>Nested In</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Nested In</em>'.
   * @see edu.toronto.cs.se.modelepedia.classdiagram.Class#getNestedIn()
   * @see #getClass_()
   * @generated
   */
	EReference getClass_NestedIn();

	/**
   * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.classdiagram.Class#getNested <em>Nested</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Nested</em>'.
   * @see edu.toronto.cs.se.modelepedia.classdiagram.Class#getNested()
   * @see #getClass_()
   * @generated
   */
	EReference getClass_Nested();

	/**
   * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.classdiagram.Class#getSuperclass <em>Superclass</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Superclass</em>'.
   * @see edu.toronto.cs.se.modelepedia.classdiagram.Class#getSuperclass()
   * @see #getClass_()
   * @generated
   */
	EReference getClass_Superclass();

	/**
   * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.classdiagram.Class#getSubclasses <em>Subclasses</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Subclasses</em>'.
   * @see edu.toronto.cs.se.modelepedia.classdiagram.Class#getSubclasses()
   * @see #getClass_()
   * @generated
   */
	EReference getClass_Subclasses();

	/**
   * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.classdiagram.Class#getAssociationsAsSource <em>Associations As Source</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Associations As Source</em>'.
   * @see edu.toronto.cs.se.modelepedia.classdiagram.Class#getAssociationsAsSource()
   * @see #getClass_()
   * @generated
   */
	EReference getClass_AssociationsAsSource();

	/**
   * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.classdiagram.Class#getAssociationsAsTarget <em>Associations As Target</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Associations As Target</em>'.
   * @see edu.toronto.cs.se.modelepedia.classdiagram.Class#getAssociationsAsTarget()
   * @see #getClass_()
   * @generated
   */
	EReference getClass_AssociationsAsTarget();

	/**
   * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.classdiagram.Class#getCompositionsAsConstituent <em>Compositions As Constituent</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Compositions As Constituent</em>'.
   * @see edu.toronto.cs.se.modelepedia.classdiagram.Class#getCompositionsAsConstituent()
   * @see #getClass_()
   * @generated
   */
	EReference getClass_CompositionsAsConstituent();

	/**
   * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.classdiagram.Class#getCompositionsAsComposite <em>Compositions As Composite</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Compositions As Composite</em>'.
   * @see edu.toronto.cs.se.modelepedia.classdiagram.Class#getCompositionsAsComposite()
   * @see #getClass_()
   * @generated
   */
	EReference getClass_CompositionsAsComposite();

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
   * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.classdiagram.Operation#getParameterTypes <em>Parameter Types</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Parameter Types</em>'.
   * @see edu.toronto.cs.se.modelepedia.classdiagram.Operation#getParameterTypes()
   * @see #getOperation()
   * @generated
   */
	EReference getOperation_ParameterTypes();

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
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.classdiagram.Dependency#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see edu.toronto.cs.se.modelepedia.classdiagram.Dependency#getName()
   * @see #getDependency()
   * @generated
   */
	EAttribute getDependency_Name();

	/**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.classdiagram.TypedElement <em>Typed Element</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Typed Element</em>'.
   * @see edu.toronto.cs.se.modelepedia.classdiagram.TypedElement
   * @generated
   */
	EClass getTypedElement();

	/**
   * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.classdiagram.TypedElement#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see edu.toronto.cs.se.modelepedia.classdiagram.TypedElement#getType()
   * @see #getTypedElement()
   * @generated
   */
	EReference getTypedElement_Type();

	/**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.classdiagram.TypedElement#isPublic <em>Public</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Public</em>'.
   * @see edu.toronto.cs.se.modelepedia.classdiagram.TypedElement#isPublic()
   * @see #getTypedElement()
   * @generated
   */
	EAttribute getTypedElement_Public();

	/**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.classdiagram.Association <em>Association</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Association</em>'.
   * @see edu.toronto.cs.se.modelepedia.classdiagram.Association
   * @generated
   */
	EClass getAssociation();

	/**
   * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.classdiagram.Association#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Source</em>'.
   * @see edu.toronto.cs.se.modelepedia.classdiagram.Association#getSource()
   * @see #getAssociation()
   * @generated
   */
	EReference getAssociation_Source();

	/**
   * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.classdiagram.Association#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see edu.toronto.cs.se.modelepedia.classdiagram.Association#getTarget()
   * @see #getAssociation()
   * @generated
   */
	EReference getAssociation_Target();

	/**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.classdiagram.Association#getMultiplicity <em>Multiplicity</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Multiplicity</em>'.
   * @see edu.toronto.cs.se.modelepedia.classdiagram.Association#getMultiplicity()
   * @see #getAssociation()
   * @generated
   */
	EAttribute getAssociation_Multiplicity();

	/**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.classdiagram.Typeable <em>Typeable</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Typeable</em>'.
   * @see edu.toronto.cs.se.modelepedia.classdiagram.Typeable
   * @generated
   */
	EClass getTypeable();

	/**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.classdiagram.DataType <em>Data Type</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Data Type</em>'.
   * @see edu.toronto.cs.se.modelepedia.classdiagram.DataType
   * @generated
   */
	EClass getDataType();

	/**
   * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.classdiagram.Composition <em>Composition</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Composition</em>'.
   * @see edu.toronto.cs.se.modelepedia.classdiagram.Composition
   * @generated
   */
	EClass getComposition();

	/**
   * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.classdiagram.Composition#getConstituent <em>Constituent</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Constituent</em>'.
   * @see edu.toronto.cs.se.modelepedia.classdiagram.Composition#getConstituent()
   * @see #getComposition()
   * @generated
   */
	EReference getComposition_Constituent();

	/**
   * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.classdiagram.Composition#getComposite <em>Composite</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Composite</em>'.
   * @see edu.toronto.cs.se.modelepedia.classdiagram.Composition#getComposite()
   * @see #getComposition()
   * @generated
   */
	EReference getComposition_Composite();

	/**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.classdiagram.Composition#getMultiplicity <em>Multiplicity</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Multiplicity</em>'.
   * @see edu.toronto.cs.se.modelepedia.classdiagram.Composition#getMultiplicity()
   * @see #getComposition()
   * @generated
   */
	EAttribute getComposition_Multiplicity();

	/**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
	ClassDiagramFactory getClassDiagramFactory();

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
     * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassDiagramPackageImpl#getClassDiagram()
     * @generated
     */
		EClass CLASS_DIAGRAM = ClassDiagramPackage.eINSTANCE.getClassDiagram();

		/**
     * The meta object literal for the '<em><b>Classes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference CLASS_DIAGRAM__CLASSES = ClassDiagramPackage.eINSTANCE.getClassDiagram_Classes();

		/**
     * The meta object literal for the '<em><b>Dependencies</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference CLASS_DIAGRAM__DEPENDENCIES = ClassDiagramPackage.eINSTANCE.getClassDiagram_Dependencies();

		/**
     * The meta object literal for the '<em><b>Associations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference CLASS_DIAGRAM__ASSOCIATIONS = ClassDiagramPackage.eINSTANCE.getClassDiagram_Associations();

		/**
     * The meta object literal for the '<em><b>Datatypes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference CLASS_DIAGRAM__DATATYPES = ClassDiagramPackage.eINSTANCE.getClassDiagram_Datatypes();

		/**
     * The meta object literal for the '<em><b>Compositions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference CLASS_DIAGRAM__COMPOSITIONS = ClassDiagramPackage.eINSTANCE.getClassDiagram_Compositions();

		/**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassImpl <em>Class</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassImpl
     * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassDiagramPackageImpl#getClass_()
     * @generated
     */
		EClass CLASS = ClassDiagramPackage.eINSTANCE.getClass_();

		/**
     * The meta object literal for the '<em><b>Owned Attributes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference CLASS__OWNED_ATTRIBUTES = ClassDiagramPackage.eINSTANCE.getClass_OwnedAttributes();

		/**
     * The meta object literal for the '<em><b>Owned Operations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference CLASS__OWNED_OPERATIONS = ClassDiagramPackage.eINSTANCE.getClass_OwnedOperations();

		/**
     * The meta object literal for the '<em><b>Dependencies As Dependee</b></em>' reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference CLASS__DEPENDENCIES_AS_DEPENDEE = ClassDiagramPackage.eINSTANCE.getClass_DependenciesAsDependee();

		/**
     * The meta object literal for the '<em><b>Dependencies As Depender</b></em>' reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference CLASS__DEPENDENCIES_AS_DEPENDER = ClassDiagramPackage.eINSTANCE.getClass_DependenciesAsDepender();

		/**
     * The meta object literal for the '<em><b>Nested In</b></em>' reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference CLASS__NESTED_IN = ClassDiagramPackage.eINSTANCE.getClass_NestedIn();

		/**
     * The meta object literal for the '<em><b>Nested</b></em>' reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference CLASS__NESTED = ClassDiagramPackage.eINSTANCE.getClass_Nested();

		/**
     * The meta object literal for the '<em><b>Superclass</b></em>' reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference CLASS__SUPERCLASS = ClassDiagramPackage.eINSTANCE.getClass_Superclass();

		/**
     * The meta object literal for the '<em><b>Subclasses</b></em>' reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference CLASS__SUBCLASSES = ClassDiagramPackage.eINSTANCE.getClass_Subclasses();

		/**
     * The meta object literal for the '<em><b>Associations As Source</b></em>' reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference CLASS__ASSOCIATIONS_AS_SOURCE = ClassDiagramPackage.eINSTANCE.getClass_AssociationsAsSource();

		/**
     * The meta object literal for the '<em><b>Associations As Target</b></em>' reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference CLASS__ASSOCIATIONS_AS_TARGET = ClassDiagramPackage.eINSTANCE.getClass_AssociationsAsTarget();

		/**
     * The meta object literal for the '<em><b>Compositions As Constituent</b></em>' reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference CLASS__COMPOSITIONS_AS_CONSTITUENT = ClassDiagramPackage.eINSTANCE.getClass_CompositionsAsConstituent();

		/**
     * The meta object literal for the '<em><b>Compositions As Composite</b></em>' reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference CLASS__COMPOSITIONS_AS_COMPOSITE = ClassDiagramPackage.eINSTANCE.getClass_CompositionsAsComposite();

		/**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.AttributeImpl <em>Attribute</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.AttributeImpl
     * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassDiagramPackageImpl#getAttribute()
     * @generated
     */
		EClass ATTRIBUTE = ClassDiagramPackage.eINSTANCE.getAttribute();

		/**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.NamedElementImpl <em>Named Element</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.NamedElementImpl
     * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassDiagramPackageImpl#getNamedElement()
     * @generated
     */
		EClass NAMED_ELEMENT = ClassDiagramPackage.eINSTANCE.getNamedElement();

		/**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute NAMED_ELEMENT__NAME = ClassDiagramPackage.eINSTANCE.getNamedElement_Name();

		/**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.OperationImpl <em>Operation</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.OperationImpl
     * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassDiagramPackageImpl#getOperation()
     * @generated
     */
		EClass OPERATION = ClassDiagramPackage.eINSTANCE.getOperation();

		/**
     * The meta object literal for the '<em><b>Parameter Types</b></em>' reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference OPERATION__PARAMETER_TYPES = ClassDiagramPackage.eINSTANCE.getOperation_ParameterTypes();

		/**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.DependencyImpl <em>Dependency</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.DependencyImpl
     * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassDiagramPackageImpl#getDependency()
     * @generated
     */
		EClass DEPENDENCY = ClassDiagramPackage.eINSTANCE.getDependency();

		/**
     * The meta object literal for the '<em><b>Dependee</b></em>' reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference DEPENDENCY__DEPENDEE = ClassDiagramPackage.eINSTANCE.getDependency_Dependee();

		/**
     * The meta object literal for the '<em><b>Depender</b></em>' reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference DEPENDENCY__DEPENDER = ClassDiagramPackage.eINSTANCE.getDependency_Depender();

		/**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute DEPENDENCY__NAME = ClassDiagramPackage.eINSTANCE.getDependency_Name();

		/**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.TypedElementImpl <em>Typed Element</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.TypedElementImpl
     * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassDiagramPackageImpl#getTypedElement()
     * @generated
     */
		EClass TYPED_ELEMENT = ClassDiagramPackage.eINSTANCE.getTypedElement();

		/**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference TYPED_ELEMENT__TYPE = ClassDiagramPackage.eINSTANCE.getTypedElement_Type();

		/**
     * The meta object literal for the '<em><b>Public</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute TYPED_ELEMENT__PUBLIC = ClassDiagramPackage.eINSTANCE.getTypedElement_Public();

		/**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.AssociationImpl <em>Association</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.AssociationImpl
     * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassDiagramPackageImpl#getAssociation()
     * @generated
     */
		EClass ASSOCIATION = ClassDiagramPackage.eINSTANCE.getAssociation();

		/**
     * The meta object literal for the '<em><b>Source</b></em>' reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ASSOCIATION__SOURCE = ClassDiagramPackage.eINSTANCE.getAssociation_Source();

		/**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ASSOCIATION__TARGET = ClassDiagramPackage.eINSTANCE.getAssociation_Target();

		/**
     * The meta object literal for the '<em><b>Multiplicity</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute ASSOCIATION__MULTIPLICITY = ClassDiagramPackage.eINSTANCE.getAssociation_Multiplicity();

		/**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.TypeableImpl <em>Typeable</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.TypeableImpl
     * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassDiagramPackageImpl#getTypeable()
     * @generated
     */
		EClass TYPEABLE = ClassDiagramPackage.eINSTANCE.getTypeable();

		/**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.DataTypeImpl <em>Data Type</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.DataTypeImpl
     * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassDiagramPackageImpl#getDataType()
     * @generated
     */
		EClass DATA_TYPE = ClassDiagramPackage.eINSTANCE.getDataType();

		/**
     * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.CompositionImpl <em>Composition</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.CompositionImpl
     * @see edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassDiagramPackageImpl#getComposition()
     * @generated
     */
		EClass COMPOSITION = ClassDiagramPackage.eINSTANCE.getComposition();

		/**
     * The meta object literal for the '<em><b>Constituent</b></em>' reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference COMPOSITION__CONSTITUENT = ClassDiagramPackage.eINSTANCE.getComposition_Constituent();

		/**
     * The meta object literal for the '<em><b>Composite</b></em>' reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference COMPOSITION__COMPOSITE = ClassDiagramPackage.eINSTANCE.getComposition_Composite();

		/**
     * The meta object literal for the '<em><b>Multiplicity</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute COMPOSITION__MULTIPLICITY = ClassDiagramPackage.eINSTANCE.getComposition_Multiplicity();

	}

} //ClassDiagramPackage

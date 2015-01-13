/**
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
package edu.toronto.cs.se.modelepedia.classdiagram_mavo;

import edu.toronto.cs.se.mavo.MAVOPackage;
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
 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot'"
 * @generated
 */
public interface ClassDiagram_MAVOPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "classdiagram_mavo";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://se.cs.toronto.edu/modelepedia/ClassDiagram_MAVO";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "classdiagram_mavo";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ClassDiagram_MAVOPackage eINSTANCE = edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.ClassDiagram_MAVOPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.ClassDiagramImpl <em>Class Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.ClassDiagramImpl
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.ClassDiagram_MAVOPackageImpl#getClassDiagram()
	 * @generated
	 */
	int CLASS_DIAGRAM = 0;

	/**
	 * The feature id for the '<em><b>Inc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DIAGRAM__INC = MAVOPackage.MAVO_MODEL__INC;

	/**
	 * The feature id for the '<em><b>Decisions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DIAGRAM__DECISIONS = MAVOPackage.MAVO_MODEL__DECISIONS;

	/**
	 * The feature id for the '<em><b>Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DIAGRAM__CLASSES = MAVOPackage.MAVO_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DIAGRAM__DEPENDENCIES = MAVOPackage.MAVO_MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Associations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DIAGRAM__ASSOCIATIONS = MAVOPackage.MAVO_MODEL_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Class Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DIAGRAM_FEATURE_COUNT = MAVOPackage.MAVO_MODEL_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Class Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DIAGRAM_OPERATION_COUNT = MAVOPackage.MAVO_MODEL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.NamedElementImpl
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.ClassDiagram_MAVOPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__FORMULA_VARIABLE = MAVOPackage.MAVO_ELEMENT__FORMULA_VARIABLE;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__MAY = MAVOPackage.MAVO_ELEMENT__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__SET = MAVOPackage.MAVO_ELEMENT__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__VAR = MAVOPackage.MAVO_ELEMENT__VAR;

	/**
	 * The feature id for the '<em><b>Alternatives</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__ALTERNATIVES = MAVOPackage.MAVO_ELEMENT__ALTERNATIVES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = MAVOPackage.MAVO_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = MAVOPackage.MAVO_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_OPERATION_COUNT = MAVOPackage.MAVO_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.ClassImpl <em>Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.ClassImpl
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.ClassDiagram_MAVOPackageImpl#getClass_()
	 * @generated
	 */
	int CLASS = 1;

	/**
	 * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__FORMULA_VARIABLE = NAMED_ELEMENT__FORMULA_VARIABLE;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__MAY = NAMED_ELEMENT__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__SET = NAMED_ELEMENT__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__VAR = NAMED_ELEMENT__VAR;

	/**
	 * The feature id for the '<em><b>Alternatives</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__ALTERNATIVES = NAMED_ELEMENT__ALTERNATIVES;

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
	 * The feature id for the '<em><b>Nested In</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__NESTED_IN = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Nested</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__NESTED = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Superclass</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__SUPERCLASS = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Subclasses</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__SUBCLASSES = NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Associations As Source</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__ASSOCIATIONS_AS_SOURCE = NAMED_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Associations As Target</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__ASSOCIATIONS_AS_TARGET = NAMED_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The number of operations of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.TypedElementImpl <em>Typed Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.TypedElementImpl
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.ClassDiagram_MAVOPackageImpl#getTypedElement()
	 * @generated
	 */
	int TYPED_ELEMENT = 6;

	/**
	 * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__FORMULA_VARIABLE = NAMED_ELEMENT__FORMULA_VARIABLE;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__MAY = NAMED_ELEMENT__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__SET = NAMED_ELEMENT__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__VAR = NAMED_ELEMENT__VAR;

	/**
	 * The feature id for the '<em><b>Alternatives</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__ALTERNATIVES = NAMED_ELEMENT__ALTERNATIVES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Public</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__PUBLIC = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__TYPE = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Typed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Typed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.AttributeImpl
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.ClassDiagram_MAVOPackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 2;

	/**
	 * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__FORMULA_VARIABLE = TYPED_ELEMENT__FORMULA_VARIABLE;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__MAY = TYPED_ELEMENT__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__SET = TYPED_ELEMENT__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__VAR = TYPED_ELEMENT__VAR;

	/**
	 * The feature id for the '<em><b>Alternatives</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__ALTERNATIVES = TYPED_ELEMENT__ALTERNATIVES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__NAME = TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Public</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__PUBLIC = TYPED_ELEMENT__PUBLIC;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__TYPE = TYPED_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__OWNER = TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION_COUNT = TYPED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.OperationImpl <em>Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.OperationImpl
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.ClassDiagram_MAVOPackageImpl#getOperation()
	 * @generated
	 */
	int OPERATION = 4;

	/**
	 * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__FORMULA_VARIABLE = TYPED_ELEMENT__FORMULA_VARIABLE;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__MAY = TYPED_ELEMENT__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__SET = TYPED_ELEMENT__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__VAR = TYPED_ELEMENT__VAR;

	/**
	 * The feature id for the '<em><b>Alternatives</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__ALTERNATIVES = TYPED_ELEMENT__ALTERNATIVES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__NAME = TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Public</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__PUBLIC = TYPED_ELEMENT__PUBLIC;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__TYPE = TYPED_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__OWNER = TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_OPERATION_COUNT = TYPED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.DependencyImpl <em>Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.DependencyImpl
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.ClassDiagram_MAVOPackageImpl#getDependency()
	 * @generated
	 */
	int DEPENDENCY = 5;

	/**
	 * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__FORMULA_VARIABLE = MAVOPackage.MAVO_ELEMENT__FORMULA_VARIABLE;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__MAY = MAVOPackage.MAVO_ELEMENT__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__SET = MAVOPackage.MAVO_ELEMENT__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__VAR = MAVOPackage.MAVO_ELEMENT__VAR;

	/**
	 * The feature id for the '<em><b>Alternatives</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__ALTERNATIVES = MAVOPackage.MAVO_ELEMENT__ALTERNATIVES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__NAME = MAVOPackage.MAVO_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dependee</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__DEPENDEE = MAVOPackage.MAVO_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Depender</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__DEPENDER = MAVOPackage.MAVO_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_FEATURE_COUNT = MAVOPackage.MAVO_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_OPERATION_COUNT = MAVOPackage.MAVO_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.AssociationImpl <em>Association</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.AssociationImpl
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.ClassDiagram_MAVOPackageImpl#getAssociation()
	 * @generated
	 */
	int ASSOCIATION = 7;

	/**
	 * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__FORMULA_VARIABLE = NAMED_ELEMENT__FORMULA_VARIABLE;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__MAY = NAMED_ELEMENT__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__SET = NAMED_ELEMENT__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__VAR = NAMED_ELEMENT__VAR;

	/**
	 * The feature id for the '<em><b>Alternatives</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__ALTERNATIVES = NAMED_ELEMENT__ALTERNATIVES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__SOURCE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__TARGET = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.NestedInReferenceImpl <em>Nested In Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.NestedInReferenceImpl
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.ClassDiagram_MAVOPackageImpl#getNestedInReference()
	 * @generated
	 */
	int NESTED_IN_REFERENCE = 8;

	/**
	 * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_IN_REFERENCE__FORMULA_VARIABLE = MAVOPackage.MAVO_REFERENCE__FORMULA_VARIABLE;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_IN_REFERENCE__MAY = MAVOPackage.MAVO_REFERENCE__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_IN_REFERENCE__SET = MAVOPackage.MAVO_REFERENCE__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_IN_REFERENCE__VAR = MAVOPackage.MAVO_REFERENCE__VAR;

	/**
	 * The feature id for the '<em><b>Alternatives</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_IN_REFERENCE__ALTERNATIVES = MAVOPackage.MAVO_REFERENCE__ALTERNATIVES;

	/**
	 * The feature id for the '<em><b>Source</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_IN_REFERENCE__SOURCE = MAVOPackage.MAVO_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_IN_REFERENCE__TARGET = MAVOPackage.MAVO_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Nested In Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_IN_REFERENCE_FEATURE_COUNT = MAVOPackage.MAVO_REFERENCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Nested In Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_IN_REFERENCE_OPERATION_COUNT = MAVOPackage.MAVO_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.SuperclassReferenceImpl <em>Superclass Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.SuperclassReferenceImpl
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.ClassDiagram_MAVOPackageImpl#getSuperclassReference()
	 * @generated
	 */
	int SUPERCLASS_REFERENCE = 9;

	/**
	 * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERCLASS_REFERENCE__FORMULA_VARIABLE = MAVOPackage.MAVO_REFERENCE__FORMULA_VARIABLE;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERCLASS_REFERENCE__MAY = MAVOPackage.MAVO_REFERENCE__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERCLASS_REFERENCE__SET = MAVOPackage.MAVO_REFERENCE__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERCLASS_REFERENCE__VAR = MAVOPackage.MAVO_REFERENCE__VAR;

	/**
	 * The feature id for the '<em><b>Alternatives</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERCLASS_REFERENCE__ALTERNATIVES = MAVOPackage.MAVO_REFERENCE__ALTERNATIVES;

	/**
	 * The feature id for the '<em><b>Source</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERCLASS_REFERENCE__SOURCE = MAVOPackage.MAVO_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERCLASS_REFERENCE__TARGET = MAVOPackage.MAVO_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Superclass Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERCLASS_REFERENCE_FEATURE_COUNT = MAVOPackage.MAVO_REFERENCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Superclass Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERCLASS_REFERENCE_OPERATION_COUNT = MAVOPackage.MAVO_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram <em>Class Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Diagram</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram
	 * @generated
	 */
	EClass getClassDiagram();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram#getClasses <em>Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classes</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram#getClasses()
	 * @see #getClassDiagram()
	 * @generated
	 */
	EReference getClassDiagram_Classes();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dependencies</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram#getDependencies()
	 * @see #getClassDiagram()
	 * @generated
	 */
	EReference getClassDiagram_Dependencies();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram#getAssociations <em>Associations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Associations</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram#getAssociations()
	 * @see #getClassDiagram()
	 * @generated
	 */
	EReference getClassDiagram_Associations();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class
	 * @generated
	 */
	EClass getClass_();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class#getOwnedAttributes <em>Owned Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Attributes</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class#getOwnedAttributes()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_OwnedAttributes();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class#getOwnedOperations <em>Owned Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Operations</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class#getOwnedOperations()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_OwnedOperations();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class#getDependenciesAsDependee <em>Dependencies As Dependee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dependencies As Dependee</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class#getDependenciesAsDependee()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_DependenciesAsDependee();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class#getDependenciesAsDepender <em>Dependencies As Depender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dependencies As Depender</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class#getDependenciesAsDepender()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_DependenciesAsDepender();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class#getNestedIn <em>Nested In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nested In</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class#getNestedIn()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_NestedIn();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class#getNested <em>Nested</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Nested</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class#getNested()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Nested();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class#getSuperclass <em>Superclass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Superclass</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class#getSuperclass()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Superclass();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class#getSubclasses <em>Subclasses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Subclasses</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class#getSubclasses()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Subclasses();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class#getAssociationsAsSource <em>Associations As Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Associations As Source</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class#getAssociationsAsSource()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_AssociationsAsSource();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class#getAssociationsAsTarget <em>Associations As Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Associations As Target</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class#getAssociationsAsTarget()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_AssociationsAsTarget();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for the container reference '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.Attribute#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.Attribute#getOwner()
	 * @see #getAttribute()
	 * @generated
	 */
	EReference getAttribute_Owner();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.Operation
	 * @generated
	 */
	EClass getOperation();

	/**
	 * Returns the meta object for the container reference '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.Operation#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.Operation#getOwner()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_Owner();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.Dependency <em>Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependency</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.Dependency
	 * @generated
	 */
	EClass getDependency();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.Dependency#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.Dependency#getName()
	 * @see #getDependency()
	 * @generated
	 */
	EAttribute getDependency_Name();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.Dependency#getDependee <em>Dependee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Dependee</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.Dependency#getDependee()
	 * @see #getDependency()
	 * @generated
	 */
	EReference getDependency_Dependee();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.Dependency#getDepender <em>Depender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Depender</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.Dependency#getDepender()
	 * @see #getDependency()
	 * @generated
	 */
	EReference getDependency_Depender();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.TypedElement <em>Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Element</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.TypedElement
	 * @generated
	 */
	EClass getTypedElement();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.TypedElement#isPublic <em>Public</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Public</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.TypedElement#isPublic()
	 * @see #getTypedElement()
	 * @generated
	 */
	EAttribute getTypedElement_Public();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.TypedElement#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.TypedElement#getType()
	 * @see #getTypedElement()
	 * @generated
	 */
	EReference getTypedElement_Type();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.Association <em>Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.Association
	 * @generated
	 */
	EClass getAssociation();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.Association#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.Association#getSource()
	 * @see #getAssociation()
	 * @generated
	 */
	EReference getAssociation_Source();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.Association#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.Association#getTarget()
	 * @see #getAssociation()
	 * @generated
	 */
	EReference getAssociation_Target();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.NestedInReference <em>Nested In Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nested In Reference</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.NestedInReference
	 * @generated
	 */
	EClass getNestedInReference();

	/**
	 * Returns the meta object for the container reference '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.NestedInReference#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Source</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.NestedInReference#getSource()
	 * @see #getNestedInReference()
	 * @generated
	 */
	EReference getNestedInReference_Source();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.NestedInReference#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.NestedInReference#getTarget()
	 * @see #getNestedInReference()
	 * @generated
	 */
	EReference getNestedInReference_Target();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.SuperclassReference <em>Superclass Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Superclass Reference</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.SuperclassReference
	 * @generated
	 */
	EClass getSuperclassReference();

	/**
	 * Returns the meta object for the container reference '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.SuperclassReference#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Source</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.SuperclassReference#getSource()
	 * @see #getSuperclassReference()
	 * @generated
	 */
	EReference getSuperclassReference_Source();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.SuperclassReference#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.SuperclassReference#getTarget()
	 * @see #getSuperclassReference()
	 * @generated
	 */
	EReference getSuperclassReference_Target();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ClassDiagram_MAVOFactory getClassDiagram_MAVOFactory();

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
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.ClassDiagramImpl <em>Class Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.ClassDiagramImpl
		 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.ClassDiagram_MAVOPackageImpl#getClassDiagram()
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
		 * The meta object literal for the '<em><b>Associations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_DIAGRAM__ASSOCIATIONS = eINSTANCE.getClassDiagram_Associations();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.ClassImpl <em>Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.ClassImpl
		 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.ClassDiagram_MAVOPackageImpl#getClass_()
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
		 * The meta object literal for the '<em><b>Nested In</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__NESTED_IN = eINSTANCE.getClass_NestedIn();

		/**
		 * The meta object literal for the '<em><b>Nested</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__NESTED = eINSTANCE.getClass_Nested();

		/**
		 * The meta object literal for the '<em><b>Superclass</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__SUPERCLASS = eINSTANCE.getClass_Superclass();

		/**
		 * The meta object literal for the '<em><b>Subclasses</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__SUBCLASSES = eINSTANCE.getClass_Subclasses();

		/**
		 * The meta object literal for the '<em><b>Associations As Source</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__ASSOCIATIONS_AS_SOURCE = eINSTANCE.getClass_AssociationsAsSource();

		/**
		 * The meta object literal for the '<em><b>Associations As Target</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__ASSOCIATIONS_AS_TARGET = eINSTANCE.getClass_AssociationsAsTarget();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.AttributeImpl
		 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.ClassDiagram_MAVOPackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE__OWNER = eINSTANCE.getAttribute_Owner();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.NamedElementImpl
		 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.ClassDiagram_MAVOPackageImpl#getNamedElement()
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
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.OperationImpl <em>Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.OperationImpl
		 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.ClassDiagram_MAVOPackageImpl#getOperation()
		 * @generated
		 */
		EClass OPERATION = eINSTANCE.getOperation();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__OWNER = eINSTANCE.getOperation_Owner();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.DependencyImpl <em>Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.DependencyImpl
		 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.ClassDiagram_MAVOPackageImpl#getDependency()
		 * @generated
		 */
		EClass DEPENDENCY = eINSTANCE.getDependency();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPENDENCY__NAME = eINSTANCE.getDependency_Name();

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
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.TypedElementImpl <em>Typed Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.TypedElementImpl
		 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.ClassDiagram_MAVOPackageImpl#getTypedElement()
		 * @generated
		 */
		EClass TYPED_ELEMENT = eINSTANCE.getTypedElement();

		/**
		 * The meta object literal for the '<em><b>Public</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPED_ELEMENT__PUBLIC = eINSTANCE.getTypedElement_Public();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_ELEMENT__TYPE = eINSTANCE.getTypedElement_Type();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.AssociationImpl <em>Association</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.AssociationImpl
		 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.ClassDiagram_MAVOPackageImpl#getAssociation()
		 * @generated
		 */
		EClass ASSOCIATION = eINSTANCE.getAssociation();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION__SOURCE = eINSTANCE.getAssociation_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION__TARGET = eINSTANCE.getAssociation_Target();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.NestedInReferenceImpl <em>Nested In Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.NestedInReferenceImpl
		 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.ClassDiagram_MAVOPackageImpl#getNestedInReference()
		 * @generated
		 */
		EClass NESTED_IN_REFERENCE = eINSTANCE.getNestedInReference();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NESTED_IN_REFERENCE__SOURCE = eINSTANCE.getNestedInReference_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NESTED_IN_REFERENCE__TARGET = eINSTANCE.getNestedInReference_Target();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.SuperclassReferenceImpl <em>Superclass Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.SuperclassReferenceImpl
		 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.ClassDiagram_MAVOPackageImpl#getSuperclassReference()
		 * @generated
		 */
		EClass SUPERCLASS_REFERENCE = eINSTANCE.getSuperclassReference();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUPERCLASS_REFERENCE__SOURCE = eINSTANCE.getSuperclassReference_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUPERCLASS_REFERENCE__TARGET = eINSTANCE.getSuperclassReference_Target();

	}

} //ClassDiagram_MAVOPackage

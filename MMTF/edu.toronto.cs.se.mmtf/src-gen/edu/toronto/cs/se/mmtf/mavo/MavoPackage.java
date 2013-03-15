/**
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro, Vivien Suen - Implementation.
 */
package edu.toronto.cs.se.mmtf.mavo;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
 * @see edu.toronto.cs.se.mmtf.mavo.MavoFactory
 * @model kind="package"
 * @generated
 */
public interface MavoPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "mavo";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://se.cs.toronto.edu/mmtf/MAVO";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "mavo";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MavoPackage eINSTANCE = edu.toronto.cs.se.mmtf.mavo.impl.MavoPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mavo.impl.MAVOElementImpl <em>MAVO Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mavo.impl.MAVOElementImpl
	 * @see edu.toronto.cs.se.mmtf.mavo.impl.MavoPackageImpl#getMAVOElement()
	 * @generated
	 */
	int MAVO_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_ELEMENT__MAY = 0;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_ELEMENT__SET = 1;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_ELEMENT__VAR = 2;

	/**
	 * The feature id for the '<em><b>Formula Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_ELEMENT__FORMULA_ID = 3;

	/**
	 * The number of structural features of the '<em>MAVO Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_ELEMENT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>MAVO Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mavo.impl.MAVOReferenceImpl <em>MAVO Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mavo.impl.MAVOReferenceImpl
	 * @see edu.toronto.cs.se.mmtf.mavo.impl.MavoPackageImpl#getMAVOReference()
	 * @generated
	 */
	int MAVO_REFERENCE = 1;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_REFERENCE__MAY = MAVO_ELEMENT__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_REFERENCE__SET = MAVO_ELEMENT__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_REFERENCE__VAR = MAVO_ELEMENT__VAR;

	/**
	 * The feature id for the '<em><b>Formula Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_REFERENCE__FORMULA_ID = MAVO_ELEMENT__FORMULA_ID;

	/**
	 * The number of structural features of the '<em>MAVO Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_REFERENCE_FEATURE_COUNT = MAVO_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>MAVO Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_REFERENCE_OPERATION_COUNT = MAVO_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mmtf.mavo.impl.MAVOModelImpl <em>MAVO Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mmtf.mavo.impl.MAVOModelImpl
	 * @see edu.toronto.cs.se.mmtf.mavo.impl.MavoPackageImpl#getMAVOModel()
	 * @generated
	 */
	int MAVO_MODEL = 2;

	/**
	 * The feature id for the '<em><b>Inc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_MODEL__INC = 0;

	/**
	 * The number of structural features of the '<em>MAVO Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_MODEL_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>MAVO Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_MODEL_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mavo.MAVOElement <em>MAVO Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MAVO Element</em>'.
	 * @see edu.toronto.cs.se.mmtf.mavo.MAVOElement
	 * @generated
	 */
	EClass getMAVOElement();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mavo.MAVOElement#isMay <em>May</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>May</em>'.
	 * @see edu.toronto.cs.se.mmtf.mavo.MAVOElement#isMay()
	 * @see #getMAVOElement()
	 * @generated
	 */
	EAttribute getMAVOElement_May();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mavo.MAVOElement#isSet <em>Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Set</em>'.
	 * @see edu.toronto.cs.se.mmtf.mavo.MAVOElement#isSet()
	 * @see #getMAVOElement()
	 * @generated
	 */
	EAttribute getMAVOElement_Set();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mavo.MAVOElement#isVar <em>Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Var</em>'.
	 * @see edu.toronto.cs.se.mmtf.mavo.MAVOElement#isVar()
	 * @see #getMAVOElement()
	 * @generated
	 */
	EAttribute getMAVOElement_Var();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mavo.MAVOElement#getFormulaId <em>Formula Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Formula Id</em>'.
	 * @see edu.toronto.cs.se.mmtf.mavo.MAVOElement#getFormulaId()
	 * @see #getMAVOElement()
	 * @generated
	 */
	EAttribute getMAVOElement_FormulaId();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mavo.MAVOReference <em>MAVO Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MAVO Reference</em>'.
	 * @see edu.toronto.cs.se.mmtf.mavo.MAVOReference
	 * @generated
	 */
	EClass getMAVOReference();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mmtf.mavo.MAVOModel <em>MAVO Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MAVO Model</em>'.
	 * @see edu.toronto.cs.se.mmtf.mavo.MAVOModel
	 * @generated
	 */
	EClass getMAVOModel();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmtf.mavo.MAVOModel#isInc <em>Inc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Inc</em>'.
	 * @see edu.toronto.cs.se.mmtf.mavo.MAVOModel#isInc()
	 * @see #getMAVOModel()
	 * @generated
	 */
	EAttribute getMAVOModel_Inc();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MavoFactory getMavoFactory();

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
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mavo.impl.MAVOElementImpl <em>MAVO Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mavo.impl.MAVOElementImpl
		 * @see edu.toronto.cs.se.mmtf.mavo.impl.MavoPackageImpl#getMAVOElement()
		 * @generated
		 */
		EClass MAVO_ELEMENT = eINSTANCE.getMAVOElement();

		/**
		 * The meta object literal for the '<em><b>May</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAVO_ELEMENT__MAY = eINSTANCE.getMAVOElement_May();

		/**
		 * The meta object literal for the '<em><b>Set</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAVO_ELEMENT__SET = eINSTANCE.getMAVOElement_Set();

		/**
		 * The meta object literal for the '<em><b>Var</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAVO_ELEMENT__VAR = eINSTANCE.getMAVOElement_Var();

		/**
		 * The meta object literal for the '<em><b>Formula Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAVO_ELEMENT__FORMULA_ID = eINSTANCE.getMAVOElement_FormulaId();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mavo.impl.MAVOReferenceImpl <em>MAVO Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mavo.impl.MAVOReferenceImpl
		 * @see edu.toronto.cs.se.mmtf.mavo.impl.MavoPackageImpl#getMAVOReference()
		 * @generated
		 */
		EClass MAVO_REFERENCE = eINSTANCE.getMAVOReference();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mmtf.mavo.impl.MAVOModelImpl <em>MAVO Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mmtf.mavo.impl.MAVOModelImpl
		 * @see edu.toronto.cs.se.mmtf.mavo.impl.MavoPackageImpl#getMAVOModel()
		 * @generated
		 */
		EClass MAVO_MODEL = eINSTANCE.getMAVOModel();

		/**
		 * The meta object literal for the '<em><b>Inc</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAVO_MODEL__INC = eINSTANCE.getMAVOModel_Inc();

	}

} //MavoPackage

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
package edu.toronto.cs.se.mavo.impl;

import edu.toronto.cs.se.mavo.DecisionElement;
import edu.toronto.cs.se.mavo.LogicElement;
import edu.toronto.cs.se.mavo.MAVOAlternative;
import edu.toronto.cs.se.mavo.MAVODecision;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mavo.MAVOFactory;
import edu.toronto.cs.se.mavo.MAVOModel;
import edu.toronto.cs.se.mavo.MAVOPackage;
import edu.toronto.cs.se.mavo.MAVOReference;
import edu.toronto.cs.se.mavo.MayDecision;
import edu.toronto.cs.se.mavo.MayDecisionLogic;
import edu.toronto.cs.se.mavo.VarDecision;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MAVOPackageImpl extends EPackageImpl implements MAVOPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass logicElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass decisionElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mavoModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mavoElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mavoReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mavoDecisionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mavoAlternativeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mayDecisionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass varDecisionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum mayDecisionLogicEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see edu.toronto.cs.se.mavo.MAVOPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MAVOPackageImpl() {
		super(eNS_URI, MAVOFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link MAVOPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MAVOPackage init() {
		if (isInited) return (MAVOPackage)EPackage.Registry.INSTANCE.getEPackage(MAVOPackage.eNS_URI);

		// Obtain or create and register package
		MAVOPackageImpl theMAVOPackage = (MAVOPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MAVOPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MAVOPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theMAVOPackage.createPackageContents();

		// Initialize created meta-data
		theMAVOPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMAVOPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MAVOPackage.eNS_URI, theMAVOPackage);
		return theMAVOPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLogicElement() {
		return logicElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLogicElement_FormulaVariable() {
		return (EAttribute)logicElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDecisionElement() {
		return decisionElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDecisionElement_Description() {
		return (EAttribute)decisionElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMAVOModel() {
		return mavoModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMAVOModel_Inc() {
		return (EAttribute)mavoModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMAVOModel_Decisions() {
		return (EReference)mavoModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMAVOElement() {
		return mavoElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMAVOElement_May() {
		return (EAttribute)mavoElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMAVOElement_Set() {
		return (EAttribute)mavoElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMAVOElement_Var() {
		return (EAttribute)mavoElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMAVOElement_Alternatives() {
		return (EReference)mavoElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMAVOReference() {
		return mavoReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMAVODecision() {
		return mavoDecisionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMAVODecision_RequiredDecisions() {
		return (EReference)mavoDecisionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMAVOAlternative() {
		return mavoAlternativeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMAVOAlternative_MavoElements() {
		return (EReference)mavoAlternativeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMayDecision() {
		return mayDecisionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMayDecision_Logic() {
		return (EAttribute)mayDecisionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMayDecision_Alternatives() {
		return (EReference)mayDecisionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVarDecision() {
		return varDecisionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVarDecision_Domain() {
		return (EReference)varDecisionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMayDecisionLogic() {
		return mayDecisionLogicEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MAVOFactory getMAVOFactory() {
		return (MAVOFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		logicElementEClass = createEClass(LOGIC_ELEMENT);
		createEAttribute(logicElementEClass, LOGIC_ELEMENT__FORMULA_VARIABLE);

		decisionElementEClass = createEClass(DECISION_ELEMENT);
		createEAttribute(decisionElementEClass, DECISION_ELEMENT__DESCRIPTION);

		mavoModelEClass = createEClass(MAVO_MODEL);
		createEAttribute(mavoModelEClass, MAVO_MODEL__INC);
		createEReference(mavoModelEClass, MAVO_MODEL__DECISIONS);

		mavoElementEClass = createEClass(MAVO_ELEMENT);
		createEAttribute(mavoElementEClass, MAVO_ELEMENT__MAY);
		createEAttribute(mavoElementEClass, MAVO_ELEMENT__SET);
		createEAttribute(mavoElementEClass, MAVO_ELEMENT__VAR);
		createEReference(mavoElementEClass, MAVO_ELEMENT__ALTERNATIVES);

		mavoReferenceEClass = createEClass(MAVO_REFERENCE);

		mavoDecisionEClass = createEClass(MAVO_DECISION);
		createEReference(mavoDecisionEClass, MAVO_DECISION__REQUIRED_DECISIONS);

		mavoAlternativeEClass = createEClass(MAVO_ALTERNATIVE);
		createEReference(mavoAlternativeEClass, MAVO_ALTERNATIVE__MAVO_ELEMENTS);

		mayDecisionEClass = createEClass(MAY_DECISION);
		createEAttribute(mayDecisionEClass, MAY_DECISION__LOGIC);
		createEReference(mayDecisionEClass, MAY_DECISION__ALTERNATIVES);

		varDecisionEClass = createEClass(VAR_DECISION);
		createEReference(varDecisionEClass, VAR_DECISION__DOMAIN);

		// Create enums
		mayDecisionLogicEEnum = createEEnum(MAY_DECISION_LOGIC);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		decisionElementEClass.getESuperTypes().add(this.getLogicElement());
		mavoElementEClass.getESuperTypes().add(this.getLogicElement());
		mavoReferenceEClass.getESuperTypes().add(this.getMAVOElement());
		mavoDecisionEClass.getESuperTypes().add(this.getDecisionElement());
		mavoAlternativeEClass.getESuperTypes().add(this.getDecisionElement());
		mayDecisionEClass.getESuperTypes().add(this.getMAVODecision());
		varDecisionEClass.getESuperTypes().add(this.getMAVODecision());

		// Initialize classes, features, and operations; add parameters
		initEClass(logicElementEClass, LogicElement.class, "LogicElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLogicElement_FormulaVariable(), ecorePackage.getEString(), "formulaVariable", null, 0, 1, LogicElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(decisionElementEClass, DecisionElement.class, "DecisionElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDecisionElement_Description(), ecorePackage.getEString(), "description", null, 0, 1, DecisionElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mavoModelEClass, MAVOModel.class, "MAVOModel", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMAVOModel_Inc(), ecorePackage.getEBoolean(), "inc", null, 0, 1, MAVOModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMAVOModel_Decisions(), this.getMAVODecision(), null, "decisions", null, 0, -1, MAVOModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mavoElementEClass, MAVOElement.class, "MAVOElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMAVOElement_May(), ecorePackage.getEBoolean(), "may", null, 0, 1, MAVOElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMAVOElement_Set(), ecorePackage.getEBoolean(), "set", null, 0, 1, MAVOElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMAVOElement_Var(), ecorePackage.getEBoolean(), "var", null, 0, 1, MAVOElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMAVOElement_Alternatives(), this.getMAVOAlternative(), this.getMAVOAlternative_MavoElements(), "alternatives", null, 0, -1, MAVOElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mavoReferenceEClass, MAVOReference.class, "MAVOReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mavoDecisionEClass, MAVODecision.class, "MAVODecision", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMAVODecision_RequiredDecisions(), this.getMAVODecision(), null, "requiredDecisions", null, 0, -1, MAVODecision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mavoAlternativeEClass, MAVOAlternative.class, "MAVOAlternative", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMAVOAlternative_MavoElements(), this.getMAVOElement(), this.getMAVOElement_Alternatives(), "mavoElements", null, 0, -1, MAVOAlternative.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mayDecisionEClass, MayDecision.class, "MayDecision", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMayDecision_Logic(), this.getMayDecisionLogic(), "logic", null, 1, 1, MayDecision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMayDecision_Alternatives(), this.getMAVOAlternative(), null, "alternatives", null, 1, -1, MayDecision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(varDecisionEClass, VarDecision.class, "VarDecision", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVarDecision_Domain(), this.getMAVOAlternative(), null, "domain", null, 1, 1, VarDecision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(mayDecisionLogicEEnum, MayDecisionLogic.class, "MayDecisionLogic");
		addEEnumLiteral(mayDecisionLogicEEnum, MayDecisionLogic.XOR);

		// Create resource
		createResource(eNS_URI);
	}

} //MAVOPackageImpl

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
package edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl;

import edu.toronto.cs.se.mavo.MAVOPackage;

import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ClassReference;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOFactory;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.NamedElement;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Operation;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.OperationReference;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SequenceDiagram;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SourceLifelineReference;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.TargetLifelineReference;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ICSE15_SequenceDiagram_MAVOPackageImpl extends EPackageImpl implements ICSE15_SequenceDiagram_MAVOPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sequenceDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lifelineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass messageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceLifelineReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetLifelineReferenceEClass = null;

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
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ICSE15_SequenceDiagram_MAVOPackageImpl() {
		super(eNS_URI, ICSE15_SequenceDiagram_MAVOFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ICSE15_SequenceDiagram_MAVOPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ICSE15_SequenceDiagram_MAVOPackage init() {
		if (isInited) return (ICSE15_SequenceDiagram_MAVOPackage)EPackage.Registry.INSTANCE.getEPackage(ICSE15_SequenceDiagram_MAVOPackage.eNS_URI);

		// Obtain or create and register package
		ICSE15_SequenceDiagram_MAVOPackageImpl theICSE15_SequenceDiagram_MAVOPackage = (ICSE15_SequenceDiagram_MAVOPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ICSE15_SequenceDiagram_MAVOPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ICSE15_SequenceDiagram_MAVOPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		MAVOPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theICSE15_SequenceDiagram_MAVOPackage.createPackageContents();

		// Initialize created meta-data
		theICSE15_SequenceDiagram_MAVOPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theICSE15_SequenceDiagram_MAVOPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ICSE15_SequenceDiagram_MAVOPackage.eNS_URI, theICSE15_SequenceDiagram_MAVOPackage);
		return theICSE15_SequenceDiagram_MAVOPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequenceDiagram() {
		return sequenceDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequenceDiagram_Lifelines() {
		return (EReference)sequenceDiagramEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequenceDiagram_Classes() {
		return (EReference)sequenceDiagramEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequenceDiagram_Messages() {
		return (EReference)sequenceDiagramEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedElement() {
		return namedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Name() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLifeline() {
		return lifelineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLifeline_Class() {
		return (EReference)lifelineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLifeline_MessagesAsSource() {
		return (EReference)lifelineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLifeline_MessagesAsTarget() {
		return (EReference)lifelineEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClass_() {
		return classEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_Operations() {
		return (EReference)classEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_Lifelines() {
		return (EReference)classEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperation() {
		return operationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperation_Messages() {
		return (EReference)operationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMessage() {
		return messageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessage_Operation() {
		return (EReference)messageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessage_SourceLifeline() {
		return (EReference)messageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessage_TargetLifeline() {
		return (EReference)messageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassReference() {
		return classReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassReference_Source() {
		return (EReference)classReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassReference_Target() {
		return (EReference)classReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperationReference() {
		return operationReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationReference_Source() {
		return (EReference)operationReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationReference_Target() {
		return (EReference)operationReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSourceLifelineReference() {
		return sourceLifelineReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSourceLifelineReference_Source() {
		return (EReference)sourceLifelineReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSourceLifelineReference_Target() {
		return (EReference)sourceLifelineReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTargetLifelineReference() {
		return targetLifelineReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTargetLifelineReference_Source() {
		return (EReference)targetLifelineReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTargetLifelineReference_Target() {
		return (EReference)targetLifelineReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ICSE15_SequenceDiagram_MAVOFactory getICSE15_SequenceDiagram_MAVOFactory() {
		return (ICSE15_SequenceDiagram_MAVOFactory)getEFactoryInstance();
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
		sequenceDiagramEClass = createEClass(SEQUENCE_DIAGRAM);
		createEReference(sequenceDiagramEClass, SEQUENCE_DIAGRAM__LIFELINES);
		createEReference(sequenceDiagramEClass, SEQUENCE_DIAGRAM__CLASSES);
		createEReference(sequenceDiagramEClass, SEQUENCE_DIAGRAM__MESSAGES);

		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

		lifelineEClass = createEClass(LIFELINE);
		createEReference(lifelineEClass, LIFELINE__CLASS);
		createEReference(lifelineEClass, LIFELINE__MESSAGES_AS_SOURCE);
		createEReference(lifelineEClass, LIFELINE__MESSAGES_AS_TARGET);

		classEClass = createEClass(CLASS);
		createEReference(classEClass, CLASS__OPERATIONS);
		createEReference(classEClass, CLASS__LIFELINES);

		operationEClass = createEClass(OPERATION);
		createEReference(operationEClass, OPERATION__MESSAGES);

		messageEClass = createEClass(MESSAGE);
		createEReference(messageEClass, MESSAGE__OPERATION);
		createEReference(messageEClass, MESSAGE__SOURCE_LIFELINE);
		createEReference(messageEClass, MESSAGE__TARGET_LIFELINE);

		classReferenceEClass = createEClass(CLASS_REFERENCE);
		createEReference(classReferenceEClass, CLASS_REFERENCE__SOURCE);
		createEReference(classReferenceEClass, CLASS_REFERENCE__TARGET);

		operationReferenceEClass = createEClass(OPERATION_REFERENCE);
		createEReference(operationReferenceEClass, OPERATION_REFERENCE__SOURCE);
		createEReference(operationReferenceEClass, OPERATION_REFERENCE__TARGET);

		sourceLifelineReferenceEClass = createEClass(SOURCE_LIFELINE_REFERENCE);
		createEReference(sourceLifelineReferenceEClass, SOURCE_LIFELINE_REFERENCE__SOURCE);
		createEReference(sourceLifelineReferenceEClass, SOURCE_LIFELINE_REFERENCE__TARGET);

		targetLifelineReferenceEClass = createEClass(TARGET_LIFELINE_REFERENCE);
		createEReference(targetLifelineReferenceEClass, TARGET_LIFELINE_REFERENCE__SOURCE);
		createEReference(targetLifelineReferenceEClass, TARGET_LIFELINE_REFERENCE__TARGET);
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

		// Obtain other dependent packages
		MAVOPackage theMAVOPackage = (MAVOPackage)EPackage.Registry.INSTANCE.getEPackage(MAVOPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		sequenceDiagramEClass.getESuperTypes().add(theMAVOPackage.getMAVOModel());
		namedElementEClass.getESuperTypes().add(theMAVOPackage.getMAVOElement());
		lifelineEClass.getESuperTypes().add(this.getNamedElement());
		classEClass.getESuperTypes().add(this.getNamedElement());
		operationEClass.getESuperTypes().add(this.getNamedElement());
		messageEClass.getESuperTypes().add(this.getNamedElement());
		classReferenceEClass.getESuperTypes().add(theMAVOPackage.getMAVOReference());
		operationReferenceEClass.getESuperTypes().add(theMAVOPackage.getMAVOReference());
		sourceLifelineReferenceEClass.getESuperTypes().add(theMAVOPackage.getMAVOReference());
		targetLifelineReferenceEClass.getESuperTypes().add(theMAVOPackage.getMAVOReference());

		// Initialize classes, features, and operations; add parameters
		initEClass(sequenceDiagramEClass, SequenceDiagram.class, "SequenceDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSequenceDiagram_Lifelines(), this.getLifeline(), null, "lifelines", null, 0, -1, SequenceDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSequenceDiagram_Classes(), this.getClass_(), null, "classes", null, 0, -1, SequenceDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSequenceDiagram_Messages(), this.getMessage(), null, "messages", null, 0, -1, SequenceDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(namedElementEClass, NamedElement.class, "NamedElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lifelineEClass, Lifeline.class, "Lifeline", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLifeline_Class(), this.getClassReference(), this.getClassReference_Source(), "class", null, 1, -1, Lifeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLifeline_MessagesAsSource(), this.getSourceLifelineReference(), this.getSourceLifelineReference_Target(), "messagesAsSource", null, 0, -1, Lifeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLifeline_MessagesAsTarget(), this.getTargetLifelineReference(), this.getTargetLifelineReference_Target(), "messagesAsTarget", null, 0, -1, Lifeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classEClass, edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Class.class, "Class", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClass_Operations(), this.getOperation(), null, "operations", null, 0, -1, edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClass_Lifelines(), this.getClassReference(), this.getClassReference_Target(), "lifelines", null, 0, -1, edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operationEClass, Operation.class, "Operation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperation_Messages(), this.getOperationReference(), this.getOperationReference_Target(), "messages", null, 0, -1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(messageEClass, Message.class, "Message", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMessage_Operation(), this.getOperationReference(), this.getOperationReference_Source(), "operation", null, 1, -1, Message.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMessage_SourceLifeline(), this.getSourceLifelineReference(), this.getSourceLifelineReference_Source(), "sourceLifeline", null, 1, -1, Message.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMessage_TargetLifeline(), this.getTargetLifelineReference(), this.getTargetLifelineReference_Source(), "targetLifeline", null, 1, -1, Message.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classReferenceEClass, ClassReference.class, "ClassReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassReference_Source(), this.getLifeline(), this.getLifeline_Class(), "source", null, 1, 1, ClassReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassReference_Target(), this.getClass_(), this.getClass_Lifelines(), "target", null, 1, 1, ClassReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operationReferenceEClass, OperationReference.class, "OperationReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperationReference_Source(), this.getMessage(), this.getMessage_Operation(), "source", null, 1, 1, OperationReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationReference_Target(), this.getOperation(), this.getOperation_Messages(), "target", null, 1, 1, OperationReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sourceLifelineReferenceEClass, SourceLifelineReference.class, "SourceLifelineReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSourceLifelineReference_Source(), this.getMessage(), this.getMessage_SourceLifeline(), "source", null, 1, 1, SourceLifelineReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSourceLifelineReference_Target(), this.getLifeline(), this.getLifeline_MessagesAsSource(), "target", null, 1, 1, SourceLifelineReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(targetLifelineReferenceEClass, TargetLifelineReference.class, "TargetLifelineReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTargetLifelineReference_Source(), this.getMessage(), this.getMessage_TargetLifeline(), "source", null, 1, 1, TargetLifelineReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTargetLifelineReference_Target(), this.getLifeline(), this.getLifeline_MessagesAsTarget(), "target", null, 1, 1, TargetLifelineReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// gmf.diagram
		createGmfAnnotations();
		// gmf.node
		createGmf_1Annotations();
		// gmf.compartment
		createGmf_2Annotations();
		// gmf.link
		createGmf_3Annotations();
	}

	/**
	 * Initializes the annotations for <b>gmf.diagram</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmfAnnotations() {
		String source = "gmf.diagram";	
		addAnnotation
		  (sequenceDiagramEClass, 
		   source, 
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>gmf.node</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmf_1Annotations() {
		String source = "gmf.node";	
		addAnnotation
		  (lifelineEClass, 
		   source, 
		   new String[] {
			 "label", "name"
		   });	
		addAnnotation
		  (classEClass, 
		   source, 
		   new String[] {
			 "label", "name"
		   });	
		addAnnotation
		  (operationEClass, 
		   source, 
		   new String[] {
			 "label", "name"
		   });	
		addAnnotation
		  (messageEClass, 
		   source, 
		   new String[] {
			 "label", "name"
		   });
	}

	/**
	 * Initializes the annotations for <b>gmf.compartment</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmf_2Annotations() {
		String source = "gmf.compartment";	
		addAnnotation
		  (getClass_Operations(), 
		   source, 
		   new String[] {
			 "layout", "list"
		   });
	}

	/**
	 * Initializes the annotations for <b>gmf.link</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmf_3Annotations() {
		String source = "gmf.link";	
		addAnnotation
		  (classReferenceEClass, 
		   source, 
		   new String[] {
			 "source", "source",
			 "target", "target",
			 "target.decoration", "arrow",
			 "label.icon", "true"
		   });	
		addAnnotation
		  (operationReferenceEClass, 
		   source, 
		   new String[] {
			 "source", "source",
			 "target", "target",
			 "target.decoration", "arrow",
			 "label.icon", "true"
		   });	
		addAnnotation
		  (sourceLifelineReferenceEClass, 
		   source, 
		   new String[] {
			 "source", "source",
			 "target", "target",
			 "target.decoration", "arrow",
			 "label.icon", "true"
		   });	
		addAnnotation
		  (targetLifelineReferenceEClass, 
		   source, 
		   new String[] {
			 "source", "source",
			 "target", "target",
			 "target.decoration", "arrow",
			 "label.icon", "true"
		   });
	}

} //ICSE15_SequenceDiagram_MAVOPackageImpl

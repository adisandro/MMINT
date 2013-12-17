/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.impl;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mavo.MavoPackage;
import edu.toronto.cs.se.mmtf.mavo.impl.MavoPackageImpl;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElementConstraintLanguage;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElementEndpoint;
import edu.toronto.cs.se.mmtf.mid.MidFactory;
import edu.toronto.cs.se.mmtf.mid.MidLevel;
import edu.toronto.cs.se.mmtf.mid.MidPackage;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.ModelElementWildcard;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;

import edu.toronto.cs.se.mmtf.mid.editor.EditorPackage;
import edu.toronto.cs.se.mmtf.mid.editor.impl.EditorPackageImpl;

import edu.toronto.cs.se.mmtf.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorPackageImpl;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmtf.mid.relationship.impl.RelationshipPackageImpl;
import edu.toronto.cs.se.mmtf.mid.util.MidValidator;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MidPackageImpl extends EPackageImpl implements MidPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extendibleElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extendibleElementEndpointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extendibleElementConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eStringToExtendibleElementMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelElementWildcardEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelEndpointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum midLevelEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum modelOriginEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum extendibleElementConstraintLanguageEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType mmtfExceptionEDataType = null;

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
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MidPackageImpl() {
		super(eNS_URI, MidFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link MidPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MidPackage init() {
		if (isInited) return (MidPackage)EPackage.Registry.INSTANCE.getEPackage(MidPackage.eNS_URI);

		// Obtain or create and register package
		MidPackageImpl theMidPackage = (MidPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MidPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MidPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		RelationshipPackageImpl theRelationshipPackage = (RelationshipPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RelationshipPackage.eNS_URI) instanceof RelationshipPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RelationshipPackage.eNS_URI) : RelationshipPackage.eINSTANCE);
		EditorPackageImpl theEditorPackage = (EditorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EditorPackage.eNS_URI) instanceof EditorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EditorPackage.eNS_URI) : EditorPackage.eINSTANCE);
		OperatorPackageImpl theOperatorPackage = (OperatorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(OperatorPackage.eNS_URI) instanceof OperatorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(OperatorPackage.eNS_URI) : OperatorPackage.eINSTANCE);
		MavoPackageImpl theMavoPackage = (MavoPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MavoPackage.eNS_URI) instanceof MavoPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MavoPackage.eNS_URI) : MavoPackage.eINSTANCE);

		// Create package meta-data objects
		theMidPackage.createPackageContents();
		theRelationshipPackage.createPackageContents();
		theEditorPackage.createPackageContents();
		theOperatorPackage.createPackageContents();
		theMavoPackage.createPackageContents();

		// Initialize created meta-data
		theMidPackage.initializePackageContents();
		theRelationshipPackage.initializePackageContents();
		theEditorPackage.initializePackageContents();
		theOperatorPackage.initializePackageContents();
		theMavoPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theMidPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return MidValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theMidPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MidPackage.eNS_URI, theMidPackage);
		return theMidPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtendibleElement() {
		return extendibleElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendibleElement_Uri() {
		return (EAttribute)extendibleElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendibleElement_Supertype() {
		return (EReference)extendibleElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendibleElement_Name() {
		return (EAttribute)extendibleElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendibleElement_Metatype() {
		return (EReference)extendibleElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendibleElement_Level() {
		return (EAttribute)extendibleElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendibleElement_MetatypeUri() {
		return (EAttribute)extendibleElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendibleElement_Dynamic() {
		return (EAttribute)extendibleElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendibleElement_Constraint() {
		return (EReference)extendibleElementEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtendibleElementEndpoint() {
		return extendibleElementEndpointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendibleElementEndpoint_LowerBound() {
		return (EAttribute)extendibleElementEndpointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendibleElementEndpoint_UpperBound() {
		return (EAttribute)extendibleElementEndpointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendibleElementEndpoint_Target() {
		return (EReference)extendibleElementEndpointEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendibleElementEndpoint_TargetUri() {
		return (EAttribute)extendibleElementEndpointEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExtendibleElementEndpoint__GetMetatype() {
		return extendibleElementEndpointEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExtendibleElementEndpoint__GetSupertype() {
		return extendibleElementEndpointEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiModel() {
		return multiModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiModel_Models() {
		return (EReference)multiModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiModel_Editors() {
		return (EReference)multiModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiModel_Operators() {
		return (EReference)multiModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiModel_ExtendibleTable() {
		return (EReference)multiModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiModel_Level() {
		return (EAttribute)multiModelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModel() {
		return modelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModel_Origin() {
		return (EAttribute)modelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModel_FileExtension() {
		return (EAttribute)modelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_Editors() {
		return (EReference)modelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_ModelElems() {
		return (EReference)modelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_ConversionOperators() {
		return (EReference)modelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModel_Abstract() {
		return (EAttribute)modelEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModel__GetMetatype() {
		return modelEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModel__GetSupertype() {
		return modelEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModel__CreateSubtype__String_String_String_boolean() {
		return modelEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModel__DeleteType() {
		return modelEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModel__CreateInstance__String_ModelOrigin_MultiModel() {
		return modelEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModel__DeleteInstance() {
		return modelEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtendibleElementConstraint() {
		return extendibleElementConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendibleElementConstraint_Implementation() {
		return (EAttribute)extendibleElementConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendibleElementConstraint_Language() {
		return (EAttribute)extendibleElementConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEStringToExtendibleElementMap() {
		return eStringToExtendibleElementMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEStringToExtendibleElementMap_Key() {
		return (EAttribute)eStringToExtendibleElementMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEStringToExtendibleElementMap_Value() {
		return (EReference)eStringToExtendibleElementMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelElement() {
		return modelElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelElement_ClassLiteral() {
		return (EAttribute)modelElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelElement__GetMetatype() {
		return modelElementEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelElement__GetSupertype() {
		return modelElementEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelElement__CreateSubtypeAndReference__ModelElementReference_String_String_ModelEndpointReference() {
		return modelElementEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelElement__CreateInstanceAndReference__String_String_String_ModelEndpointReference() {
		return modelElementEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelElement__DeleteInstance() {
		return modelElementEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelElement__DeleteType() {
		return modelElementEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelElementWildcard() {
		return modelElementWildcardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelEndpoint() {
		return modelEndpointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelEndpoint__GetSupertype() {
		return modelEndpointEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelEndpoint__GetTarget() {
		return modelEndpointEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelEndpoint__GetMetatype() {
		return modelEndpointEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelEndpoint__CreateSubtypeAndReference__ModelEndpointReference_String_Model_boolean_ModelRel() {
		return modelEndpointEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelEndpoint__ReplaceSubtypeAndReference__ModelEndpoint_ModelEndpointReference_String_Model_ModelRel() {
		return modelEndpointEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelEndpoint__DeleteTypeAndReference__boolean() {
		return modelEndpointEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelEndpoint__CreateInstanceAndReference__Model_boolean_ModelRel() {
		return modelEndpointEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelEndpoint__DeleteInstanceAndReference__boolean() {
		return modelEndpointEClass.getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelEndpoint__ReplaceInstanceAndReference__ModelEndpoint_Model() {
		return modelEndpointEClass.getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelEndpoint__CreateTypeReference__ModelEndpointReference_boolean_boolean_ModelRel() {
		return modelEndpointEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelEndpoint__CreateInstanceReference__boolean_ModelRel() {
		return modelEndpointEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMidLevel() {
		return midLevelEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getModelOrigin() {
		return modelOriginEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getExtendibleElementConstraintLanguage() {
		return extendibleElementConstraintLanguageEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getMMTFException() {
		return mmtfExceptionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MidFactory getMidFactory() {
		return (MidFactory)getEFactoryInstance();
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
		multiModelEClass = createEClass(MULTI_MODEL);
		createEReference(multiModelEClass, MULTI_MODEL__MODELS);
		createEReference(multiModelEClass, MULTI_MODEL__EDITORS);
		createEReference(multiModelEClass, MULTI_MODEL__OPERATORS);
		createEReference(multiModelEClass, MULTI_MODEL__EXTENDIBLE_TABLE);
		createEAttribute(multiModelEClass, MULTI_MODEL__LEVEL);

		eStringToExtendibleElementMapEClass = createEClass(ESTRING_TO_EXTENDIBLE_ELEMENT_MAP);
		createEAttribute(eStringToExtendibleElementMapEClass, ESTRING_TO_EXTENDIBLE_ELEMENT_MAP__KEY);
		createEReference(eStringToExtendibleElementMapEClass, ESTRING_TO_EXTENDIBLE_ELEMENT_MAP__VALUE);

		extendibleElementEClass = createEClass(EXTENDIBLE_ELEMENT);
		createEReference(extendibleElementEClass, EXTENDIBLE_ELEMENT__SUPERTYPE);
		createEReference(extendibleElementEClass, EXTENDIBLE_ELEMENT__METATYPE);
		createEAttribute(extendibleElementEClass, EXTENDIBLE_ELEMENT__URI);
		createEAttribute(extendibleElementEClass, EXTENDIBLE_ELEMENT__NAME);
		createEAttribute(extendibleElementEClass, EXTENDIBLE_ELEMENT__LEVEL);
		createEAttribute(extendibleElementEClass, EXTENDIBLE_ELEMENT__METATYPE_URI);
		createEAttribute(extendibleElementEClass, EXTENDIBLE_ELEMENT__DYNAMIC);
		createEReference(extendibleElementEClass, EXTENDIBLE_ELEMENT__CONSTRAINT);

		extendibleElementEndpointEClass = createEClass(EXTENDIBLE_ELEMENT_ENDPOINT);
		createEAttribute(extendibleElementEndpointEClass, EXTENDIBLE_ELEMENT_ENDPOINT__LOWER_BOUND);
		createEAttribute(extendibleElementEndpointEClass, EXTENDIBLE_ELEMENT_ENDPOINT__UPPER_BOUND);
		createEReference(extendibleElementEndpointEClass, EXTENDIBLE_ELEMENT_ENDPOINT__TARGET);
		createEAttribute(extendibleElementEndpointEClass, EXTENDIBLE_ELEMENT_ENDPOINT__TARGET_URI);
		createEOperation(extendibleElementEndpointEClass, EXTENDIBLE_ELEMENT_ENDPOINT___GET_METATYPE);
		createEOperation(extendibleElementEndpointEClass, EXTENDIBLE_ELEMENT_ENDPOINT___GET_SUPERTYPE);

		modelEClass = createEClass(MODEL);
		createEAttribute(modelEClass, MODEL__ORIGIN);
		createEAttribute(modelEClass, MODEL__FILE_EXTENSION);
		createEReference(modelEClass, MODEL__EDITORS);
		createEReference(modelEClass, MODEL__MODEL_ELEMS);
		createEReference(modelEClass, MODEL__CONVERSION_OPERATORS);
		createEAttribute(modelEClass, MODEL__ABSTRACT);
		createEOperation(modelEClass, MODEL___GET_METATYPE);
		createEOperation(modelEClass, MODEL___GET_SUPERTYPE);
		createEOperation(modelEClass, MODEL___CREATE_SUBTYPE__STRING_STRING_STRING_BOOLEAN);
		createEOperation(modelEClass, MODEL___DELETE_TYPE);
		createEOperation(modelEClass, MODEL___CREATE_INSTANCE__STRING_MODELORIGIN_MULTIMODEL);
		createEOperation(modelEClass, MODEL___DELETE_INSTANCE);

		extendibleElementConstraintEClass = createEClass(EXTENDIBLE_ELEMENT_CONSTRAINT);
		createEAttribute(extendibleElementConstraintEClass, EXTENDIBLE_ELEMENT_CONSTRAINT__IMPLEMENTATION);
		createEAttribute(extendibleElementConstraintEClass, EXTENDIBLE_ELEMENT_CONSTRAINT__LANGUAGE);

		modelElementEClass = createEClass(MODEL_ELEMENT);
		createEAttribute(modelElementEClass, MODEL_ELEMENT__CLASS_LITERAL);
		createEOperation(modelElementEClass, MODEL_ELEMENT___GET_METATYPE);
		createEOperation(modelElementEClass, MODEL_ELEMENT___GET_SUPERTYPE);
		createEOperation(modelElementEClass, MODEL_ELEMENT___CREATE_SUBTYPE_AND_REFERENCE__MODELELEMENTREFERENCE_STRING_STRING_MODELENDPOINTREFERENCE);
		createEOperation(modelElementEClass, MODEL_ELEMENT___DELETE_TYPE);
		createEOperation(modelElementEClass, MODEL_ELEMENT___CREATE_INSTANCE_AND_REFERENCE__STRING_STRING_STRING_MODELENDPOINTREFERENCE);
		createEOperation(modelElementEClass, MODEL_ELEMENT___DELETE_INSTANCE);

		modelElementWildcardEClass = createEClass(MODEL_ELEMENT_WILDCARD);

		modelEndpointEClass = createEClass(MODEL_ENDPOINT);
		createEOperation(modelEndpointEClass, MODEL_ENDPOINT___GET_SUPERTYPE);
		createEOperation(modelEndpointEClass, MODEL_ENDPOINT___GET_TARGET);
		createEOperation(modelEndpointEClass, MODEL_ENDPOINT___GET_METATYPE);
		createEOperation(modelEndpointEClass, MODEL_ENDPOINT___CREATE_TYPE_REFERENCE__MODELENDPOINTREFERENCE_BOOLEAN_BOOLEAN_MODELREL);
		createEOperation(modelEndpointEClass, MODEL_ENDPOINT___CREATE_SUBTYPE_AND_REFERENCE__MODELENDPOINTREFERENCE_STRING_MODEL_BOOLEAN_MODELREL);
		createEOperation(modelEndpointEClass, MODEL_ENDPOINT___REPLACE_SUBTYPE_AND_REFERENCE__MODELENDPOINT_MODELENDPOINTREFERENCE_STRING_MODEL_MODELREL);
		createEOperation(modelEndpointEClass, MODEL_ENDPOINT___DELETE_TYPE_AND_REFERENCE__BOOLEAN);
		createEOperation(modelEndpointEClass, MODEL_ENDPOINT___CREATE_INSTANCE_REFERENCE__BOOLEAN_MODELREL);
		createEOperation(modelEndpointEClass, MODEL_ENDPOINT___CREATE_INSTANCE_AND_REFERENCE__MODEL_BOOLEAN_MODELREL);
		createEOperation(modelEndpointEClass, MODEL_ENDPOINT___DELETE_INSTANCE_AND_REFERENCE__BOOLEAN);
		createEOperation(modelEndpointEClass, MODEL_ENDPOINT___REPLACE_INSTANCE_AND_REFERENCE__MODELENDPOINT_MODEL);

		// Create enums
		midLevelEEnum = createEEnum(MID_LEVEL);
		modelOriginEEnum = createEEnum(MODEL_ORIGIN);
		extendibleElementConstraintLanguageEEnum = createEEnum(EXTENDIBLE_ELEMENT_CONSTRAINT_LANGUAGE);

		// Create data types
		mmtfExceptionEDataType = createEDataType(MMTF_EXCEPTION);
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
		RelationshipPackage theRelationshipPackage = (RelationshipPackage)EPackage.Registry.INSTANCE.getEPackage(RelationshipPackage.eNS_URI);
		EditorPackage theEditorPackage = (EditorPackage)EPackage.Registry.INSTANCE.getEPackage(EditorPackage.eNS_URI);
		OperatorPackage theOperatorPackage = (OperatorPackage)EPackage.Registry.INSTANCE.getEPackage(OperatorPackage.eNS_URI);
		MavoPackage theMavoPackage = (MavoPackage)EPackage.Registry.INSTANCE.getEPackage(MavoPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theRelationshipPackage);
		getESubpackages().add(theEditorPackage);
		getESubpackages().add(theOperatorPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		multiModelEClass.getESuperTypes().add(theMavoPackage.getMAVOModel());
		extendibleElementEClass.getESuperTypes().add(theMavoPackage.getMAVOElement());
		extendibleElementEndpointEClass.getESuperTypes().add(this.getExtendibleElement());
		modelEClass.getESuperTypes().add(this.getExtendibleElement());
		modelEClass.getESuperTypes().add(theMavoPackage.getMAVOModel());
		modelElementEClass.getESuperTypes().add(this.getExtendibleElement());
		modelEndpointEClass.getESuperTypes().add(this.getExtendibleElementEndpoint());

		// Initialize classes, features, and operations; add parameters
		initEClass(multiModelEClass, MultiModel.class, "MultiModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMultiModel_Models(), this.getModel(), null, "models", null, 0, -1, MultiModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMultiModel_Editors(), theEditorPackage.getEditor(), null, "editors", null, 0, -1, MultiModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMultiModel_Operators(), theOperatorPackage.getOperator(), null, "operators", null, 0, -1, MultiModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMultiModel_ExtendibleTable(), this.getEStringToExtendibleElementMap(), null, "extendibleTable", null, 0, -1, MultiModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiModel_Level(), this.getMidLevel(), "level", null, 1, 1, MultiModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eStringToExtendibleElementMapEClass, Map.Entry.class, "EStringToExtendibleElementMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEStringToExtendibleElementMap_Key(), ecorePackage.getEString(), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEStringToExtendibleElementMap_Value(), this.getExtendibleElement(), null, "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(extendibleElementEClass, ExtendibleElement.class, "ExtendibleElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExtendibleElement_Supertype(), this.getExtendibleElement(), null, "supertype", null, 0, 1, ExtendibleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtendibleElement_Metatype(), this.getExtendibleElement(), null, "metatype", null, 0, 1, ExtendibleElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getExtendibleElement_Uri(), ecorePackage.getEString(), "uri", null, 1, 1, ExtendibleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExtendibleElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, ExtendibleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExtendibleElement_Level(), this.getMidLevel(), "level", null, 1, 1, ExtendibleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExtendibleElement_MetatypeUri(), ecorePackage.getEString(), "metatypeUri", null, 0, 1, ExtendibleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExtendibleElement_Dynamic(), ecorePackage.getEBoolean(), "dynamic", null, 1, 1, ExtendibleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtendibleElement_Constraint(), this.getExtendibleElementConstraint(), null, "constraint", null, 0, 1, ExtendibleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(extendibleElementEndpointEClass, ExtendibleElementEndpoint.class, "ExtendibleElementEndpoint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExtendibleElementEndpoint_LowerBound(), ecorePackage.getEInt(), "lowerBound", null, 1, 1, ExtendibleElementEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExtendibleElementEndpoint_UpperBound(), ecorePackage.getEInt(), "upperBound", null, 1, 1, ExtendibleElementEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtendibleElementEndpoint_Target(), this.getExtendibleElement(), null, "target", null, 1, 1, ExtendibleElementEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExtendibleElementEndpoint_TargetUri(), ecorePackage.getEString(), "targetUri", null, 1, 1, ExtendibleElementEndpoint.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEOperation(getExtendibleElementEndpoint__GetMetatype(), this.getExtendibleElementEndpoint(), "getMetatype", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getExtendibleElementEndpoint__GetSupertype(), this.getExtendibleElementEndpoint(), "getSupertype", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModel_Origin(), this.getModelOrigin(), "origin", null, 1, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModel_FileExtension(), ecorePackage.getEString(), "fileExtension", null, 1, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModel_Editors(), theEditorPackage.getEditor(), null, "editors", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModel_ModelElems(), this.getModelElement(), null, "modelElems", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModel_ConversionOperators(), theOperatorPackage.getConversionOperator(), null, "conversionOperators", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModel_Abstract(), ecorePackage.getEBoolean(), "abstract", null, 1, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getModel__GetMetatype(), this.getModel(), "getMetatype", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getModel__GetSupertype(), this.getModel(), "getSupertype", 0, 1, IS_UNIQUE, IS_ORDERED);

		EOperation op = initEOperation(getModel__CreateSubtype__String_String_String_boolean(), this.getModel(), "createSubtype", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "newModelTypeName", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "constraintLanguage", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "constraintImplementation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isMetamodelExtension", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getMMTFException());

		op = initEOperation(getModel__DeleteType(), null, "deleteType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getMMTFException());

		op = initEOperation(getModel__CreateInstance__String_ModelOrigin_MultiModel(), this.getModel(), "createInstance", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "newModelUri", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelOrigin(), "origin", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getMultiModel(), "containerMultiModel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getMMTFException());

		op = initEOperation(getModel__DeleteInstance(), null, "deleteInstance", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getMMTFException());

		initEClass(extendibleElementConstraintEClass, ExtendibleElementConstraint.class, "ExtendibleElementConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExtendibleElementConstraint_Implementation(), ecorePackage.getEString(), "implementation", null, 1, 1, ExtendibleElementConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExtendibleElementConstraint_Language(), this.getExtendibleElementConstraintLanguage(), "language", null, 1, 1, ExtendibleElementConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modelElementEClass, ModelElement.class, "ModelElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModelElement_ClassLiteral(), ecorePackage.getEString(), "classLiteral", null, 1, 1, ModelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getModelElement__GetMetatype(), this.getModelElement(), "getMetatype", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getModelElement__GetSupertype(), this.getModelElement(), "getSupertype", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getModelElement__CreateSubtypeAndReference__ModelElementReference_String_String_ModelEndpointReference(), theRelationshipPackage.getModelElementReference(), "createSubtypeAndReference", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRelationshipPackage.getModelElementReference(), "modelElemTypeRef", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "newModelElemTypeName", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "classLiteral", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRelationshipPackage.getModelEndpointReference(), "containerModelTypeEndpointRef", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getMMTFException());

		op = initEOperation(getModelElement__DeleteType(), null, "deleteType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getMMTFException());

		op = initEOperation(getModelElement__CreateInstanceAndReference__String_String_String_ModelEndpointReference(), theRelationshipPackage.getModelElementReference(), "createInstanceAndReference", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "newModelElemUri", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "newModelElemName", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "classLiteral", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRelationshipPackage.getModelEndpointReference(), "containerModelEndpointRef", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getMMTFException());

		op = initEOperation(getModelElement__DeleteInstance(), null, "deleteInstance", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getMMTFException());

		initEClass(modelElementWildcardEClass, ModelElementWildcard.class, "ModelElementWildcard", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(modelEndpointEClass, ModelEndpoint.class, "ModelEndpoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getModelEndpoint__GetSupertype(), this.getModelEndpoint(), "getSupertype", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getModelEndpoint__GetTarget(), this.getModel(), "getTarget", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getModelEndpoint__GetMetatype(), this.getModelEndpoint(), "getMetatype", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getModelEndpoint__CreateTypeReference__ModelEndpointReference_boolean_boolean_ModelRel(), theRelationshipPackage.getModelEndpointReference(), "createTypeReference", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRelationshipPackage.getModelEndpointReference(), "modelTypeEndpointRef", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isModifiable", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isBinarySrc", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRelationshipPackage.getModelRel(), "containerModelRelType", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getMMTFException());

		op = initEOperation(getModelEndpoint__CreateSubtypeAndReference__ModelEndpointReference_String_Model_boolean_ModelRel(), theRelationshipPackage.getModelEndpointReference(), "createSubtypeAndReference", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRelationshipPackage.getModelEndpointReference(), "modelTypeEndpointRef", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "newModelTypeEndpointName", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModel(), "targetModelType", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isBinarySrc", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRelationshipPackage.getModelRel(), "containerModelRelType", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getMMTFException());

		op = initEOperation(getModelEndpoint__ReplaceSubtypeAndReference__ModelEndpoint_ModelEndpointReference_String_Model_ModelRel(), null, "replaceSubtypeAndReference", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelEndpoint(), "oldModelTypeEndpoint", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRelationshipPackage.getModelEndpointReference(), "modelTypeEndpointRef", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "newModelTypeEndpointName", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModel(), "targetModelType", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRelationshipPackage.getModelRel(), "containerModelRelType", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getMMTFException());

		op = initEOperation(getModelEndpoint__DeleteTypeAndReference__boolean(), null, "deleteTypeAndReference", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isFullDelete", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getMMTFException());

		op = initEOperation(getModelEndpoint__CreateInstanceReference__boolean_ModelRel(), theRelationshipPackage.getModelEndpointReference(), "createInstanceReference", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isBinarySrc", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRelationshipPackage.getModelRel(), "containerModelRel", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getMMTFException());

		op = initEOperation(getModelEndpoint__CreateInstanceAndReference__Model_boolean_ModelRel(), theRelationshipPackage.getModelEndpointReference(), "createInstanceAndReference", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModel(), "targetModel", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isBinarySrc", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRelationshipPackage.getModelRel(), "containerModelRel", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getMMTFException());

		op = initEOperation(getModelEndpoint__DeleteInstanceAndReference__boolean(), null, "deleteInstanceAndReference", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isFullDelete", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getMMTFException());

		op = initEOperation(getModelEndpoint__ReplaceInstanceAndReference__ModelEndpoint_Model(), null, "replaceInstanceAndReference", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelEndpoint(), "oldModelEndpoint", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModel(), "targetModel", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getMMTFException());

		// Initialize enums and add enum literals
		initEEnum(midLevelEEnum, MidLevel.class, "MidLevel");
		addEEnumLiteral(midLevelEEnum, MidLevel.INSTANCES);
		addEEnumLiteral(midLevelEEnum, MidLevel.TYPES);

		initEEnum(modelOriginEEnum, ModelOrigin.class, "ModelOrigin");
		addEEnumLiteral(modelOriginEEnum, ModelOrigin.IMPORTED);
		addEEnumLiteral(modelOriginEEnum, ModelOrigin.CREATED);

		initEEnum(extendibleElementConstraintLanguageEEnum, ExtendibleElementConstraintLanguage.class, "ExtendibleElementConstraintLanguage");
		addEEnumLiteral(extendibleElementConstraintLanguageEEnum, ExtendibleElementConstraintLanguage.OCL);
		addEEnumLiteral(extendibleElementConstraintLanguageEEnum, ExtendibleElementConstraintLanguage.JAVA);
		addEEnumLiteral(extendibleElementConstraintLanguageEEnum, ExtendibleElementConstraintLanguage.SMTLIB);

		// Initialize data types
		initEDataType(mmtfExceptionEDataType, MMTFException.class, "MMTFException", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot
		createPivotAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";		
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "invocationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
			 "settingDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
			 "validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot"
		   });											
		addAnnotation
		  (extendibleElementEClass, 
		   source, 
		   new String[] {
			 "constraints", "typeLevel"
		   });																
		addAnnotation
		  (extendibleElementEndpointEClass, 
		   source, 
		   new String[] {
			 "constraints", "unboundedLevel"
		   });																																					
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createPivotAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot";														
		addAnnotation
		  (extendibleElementEClass, 
		   source, 
		   new String[] {
			 "typeLevel", "level = MidLevel::INSTANCES implies metatype.level = MidLevel::TYPES"
		   });															
		addAnnotation
		  (extendibleElementEndpointEClass, 
		   source, 
		   new String[] {
			 "unboundedLevel", "target.level = MidLevel::INSTANCES implies (lowerBound = 1 and upperBound = 1)"
		   });								
		addAnnotation
		  (getExtendibleElementEndpoint_TargetUri(), 
		   source, 
		   new String[] {
			 "derivation", "target.uri"
		   });																													
	}

} //MidPackageImpl

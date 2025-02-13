/*******************************************************************************
 * Copyright (c) 2017, 2025 Alessio Di Sandro, Nick Fung.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
 *     Nick Fung - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.modelepedia.gsn.impl;

import java.util.Optional;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import edu.toronto.cs.se.modelepedia.gsn.ASILLevel;
import edu.toronto.cs.se.modelepedia.gsn.ASILfulElement;
import edu.toronto.cs.se.modelepedia.gsn.ArgumentElement;
import edu.toronto.cs.se.modelepedia.gsn.Assumption;
import edu.toronto.cs.se.modelepedia.gsn.Context;
import edu.toronto.cs.se.modelepedia.gsn.Contextual;
import edu.toronto.cs.se.modelepedia.gsn.Contextualizable;
import edu.toronto.cs.se.modelepedia.gsn.Decoratable;
import edu.toronto.cs.se.modelepedia.gsn.DecoratorType;
import edu.toronto.cs.se.modelepedia.gsn.GSNFactory;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.Goal;
import edu.toronto.cs.se.modelepedia.gsn.ImpactAnnotation;
import edu.toronto.cs.se.modelepedia.gsn.ImpactType;
import edu.toronto.cs.se.modelepedia.gsn.InContextOf;
import edu.toronto.cs.se.modelepedia.gsn.Justification;
import edu.toronto.cs.se.modelepedia.gsn.RelationshipDecorator;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.Solution;
import edu.toronto.cs.se.modelepedia.gsn.Strategy;
import edu.toronto.cs.se.modelepedia.gsn.Supportable;
import edu.toronto.cs.se.modelepedia.gsn.SupportedBy;
import edu.toronto.cs.se.modelepedia.gsn.Supporter;
import edu.toronto.cs.se.modelepedia.gsn.Template;
import edu.toronto.cs.se.modelepedia.gsn.Undeveloped;
import edu.toronto.cs.se.modelepedia.gsn.util.GSNBuilder;
import edu.toronto.cs.se.modelepedia.gsn.util.GSNImpactStep;
import edu.toronto.cs.se.modelepedia.gsn.util.GSNValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class GSNPackageImpl extends EPackageImpl implements GSNPackage {
  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass safetyCaseEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass argumentElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass decoratableEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass asiLfulElementEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass supportedByEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass contextualizableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass contextualEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass inContextOfEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass goalEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass strategyEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass solutionEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass contextEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass justificationEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass assumptionEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass asilEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass impactAnnotationEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass supportableEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass supporterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass templateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass relationshipDecoratorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass undevelopedEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EEnum asilLevelEEnum = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EEnum impactTypeEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum decoratorTypeEEnum = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EDataType exceptionEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType gsnBuilderEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType gsnImpactStepEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType optionalEDataType = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
   * EPackage.Registry} by the package package URI value.
   * <p>
   * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
   * performs initialization of the package, or returns the registered package, if one already exists. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private GSNPackageImpl() {
    super(GSNPackage.eNS_URI, GSNFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   *
   * <p>This method is used to initialize {@link GSNPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static GSNPackage init() {
    if (GSNPackageImpl.isInited) {
      return (GSNPackage)EPackage.Registry.INSTANCE.getEPackage(GSNPackage.eNS_URI);
    }

    // Obtain or create and register package
    var registeredGSNPackage = EPackage.Registry.INSTANCE.get(GSNPackage.eNS_URI);
    var theGSNPackage = registeredGSNPackage instanceof GSNPackageImpl ? (GSNPackageImpl)registeredGSNPackage : new GSNPackageImpl();

    GSNPackageImpl.isInited = true;

    // Create package meta-data objects
    theGSNPackage.createPackageContents();

    // Initialize created meta-data
    theGSNPackage.initializePackageContents();

    // Register package validator
    EValidator.Registry.INSTANCE.put
      (theGSNPackage,
       new EValidator.Descriptor() {
         @Override
         public EValidator getEValidator() {
           return GSNValidator.INSTANCE;
         }
       });

    // Mark meta-data to indicate it can't be changed
    theGSNPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(GSNPackage.eNS_URI, theGSNPackage);
    return theGSNPackage;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getSafetyCase() {
    return this.safetyCaseEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSafetyCase_Goals() {
    return (EReference)this.safetyCaseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSafetyCase_Strategies() {
    return (EReference)this.safetyCaseEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSafetyCase_Solutions() {
    return (EReference)this.safetyCaseEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSafetyCase_Contexts() {
    return (EReference)this.safetyCaseEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSafetyCase_Justifications() {
    return (EReference)this.safetyCaseEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSafetyCase_Assumptions() {
    return (EReference)this.safetyCaseEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSafetyCase_Templates() {
    return (EReference)this.safetyCaseEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getArgumentElement() {
    return this.argumentElementEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getArgumentElement_Id() {
    return (EAttribute)this.argumentElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getArgumentElement_Description() {
    return (EAttribute)this.argumentElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getArgumentElement_Status() {
    return (EReference)this.argumentElementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getArgumentElement_Templates() {
    return (EReference)this.argumentElementEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getArgumentElement_TemplateId() {
    return (EAttribute)this.argumentElementEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getArgumentElement_Valid() {
    return (EAttribute)this.argumentElementEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getArgumentElement__Validate__Template() {
    return this.argumentElementEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getArgumentElement__Instantiate__Template() {
    return this.argumentElementEClass.getEOperations().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getDecoratable() {
    return this.decoratableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getDecoratable_Decorators() {
    return (EReference)this.decoratableEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getASILfulElement() {
    return this.asiLfulElementEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getASILfulElement_Asil() {
    return (EReference)this.asiLfulElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getSupportedBy() {
    return this.supportedByEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSupportedBy_Source() {
    return (EReference)this.supportedByEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSupportedBy_Target() {
    return (EReference)this.supportedByEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getContextualizable() {
    return this.contextualizableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getContextualizable_InContextOf() {
    return (EReference)this.contextualizableEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getContextual() {
    return this.contextualEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getContextual_ContextOf() {
    return (EReference)this.contextualEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getInContextOf() {
    return this.inContextOfEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getInContextOf_Context() {
    return (EReference)this.inContextOfEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getInContextOf_ContextOf() {
    return (EReference)this.inContextOfEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getGoal() {
    return this.goalEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getStrategy() {
    return this.strategyEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getSolution() {
    return this.solutionEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getContext() {
    return this.contextEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getJustification() {
    return this.justificationEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getAssumption() {
    return this.assumptionEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getASIL() {
    return this.asilEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getASIL_Value() {
    return (EAttribute)this.asilEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getASIL_Target() {
    return (EReference)this.asilEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getASIL_Status() {
    return (EReference)this.asilEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getImpactAnnotation() {
    return this.impactAnnotationEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getImpactAnnotation_Type() {
    return (EAttribute)this.impactAnnotationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getImpactAnnotation_Source() {
    return (EAttribute)this.impactAnnotationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getSupportable() {
    return this.supportableEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSupportable_SupportedBy() {
    return (EReference)this.supportableEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSupportable_Undeveloped() {
    return (EReference)this.supportableEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getSupporter() {
    return this.supporterEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSupporter_Supports() {
    return (EReference)this.supporterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getTemplate() {
    return this.templateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTemplate_Elements() {
    return (EReference)this.templateEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getTemplate_Id() {
    return (EAttribute)this.templateEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getTemplate__GetElement__String() {
    return this.templateEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getTemplate__Validate() {
    return this.templateEClass.getEOperations().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getTemplate__Import___SafetyCase() {
    return this.templateEClass.getEOperations().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getTemplate__Instantiate() {
    return this.templateEClass.getEOperations().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getTemplate__Impact__GSNImpactStep_Object() {
    return this.templateEClass.getEOperations().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getTemplate__Repair__Object() {
    return this.templateEClass.getEOperations().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getRelationshipDecorator() {
    return this.relationshipDecoratorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getRelationshipDecorator_Type() {
    return (EAttribute)this.relationshipDecoratorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getRelationshipDecorator_Cardinality() {
    return (EAttribute)this.relationshipDecoratorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getUndeveloped() {
    return this.undevelopedEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EEnum getASILLevel() {
    return this.asilLevelEEnum;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EEnum getImpactType() {
    return this.impactTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EEnum getDecoratorType() {
    return this.decoratorTypeEEnum;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EDataType getException() {
    return this.exceptionEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EDataType getGSNBuilder() {
    return this.gsnBuilderEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EDataType getGSNImpactStep() {
    return this.gsnImpactStepEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EDataType getOptional() {
    return this.optionalEDataType;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public GSNFactory getGSNFactory() {
    return (GSNFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents() {
    if (this.isCreated) {
      return;
    }
    this.isCreated = true;

    // Create classes and their features
    this.safetyCaseEClass = createEClass(GSNPackage.SAFETY_CASE);
    createEReference(this.safetyCaseEClass, GSNPackage.SAFETY_CASE__GOALS);
    createEReference(this.safetyCaseEClass, GSNPackage.SAFETY_CASE__STRATEGIES);
    createEReference(this.safetyCaseEClass, GSNPackage.SAFETY_CASE__SOLUTIONS);
    createEReference(this.safetyCaseEClass, GSNPackage.SAFETY_CASE__CONTEXTS);
    createEReference(this.safetyCaseEClass, GSNPackage.SAFETY_CASE__JUSTIFICATIONS);
    createEReference(this.safetyCaseEClass, GSNPackage.SAFETY_CASE__ASSUMPTIONS);
    createEReference(this.safetyCaseEClass, GSNPackage.SAFETY_CASE__TEMPLATES);

    this.argumentElementEClass = createEClass(GSNPackage.ARGUMENT_ELEMENT);
    createEAttribute(this.argumentElementEClass, GSNPackage.ARGUMENT_ELEMENT__ID);
    createEAttribute(this.argumentElementEClass, GSNPackage.ARGUMENT_ELEMENT__DESCRIPTION);
    createEReference(this.argumentElementEClass, GSNPackage.ARGUMENT_ELEMENT__STATUS);
    createEReference(this.argumentElementEClass, GSNPackage.ARGUMENT_ELEMENT__TEMPLATES);
    createEAttribute(this.argumentElementEClass, GSNPackage.ARGUMENT_ELEMENT__TEMPLATE_ID);
    createEAttribute(this.argumentElementEClass, GSNPackage.ARGUMENT_ELEMENT__VALID);
    createEOperation(this.argumentElementEClass, GSNPackage.ARGUMENT_ELEMENT___VALIDATE__TEMPLATE);
    createEOperation(this.argumentElementEClass, GSNPackage.ARGUMENT_ELEMENT___INSTANTIATE__TEMPLATE);

    this.decoratableEClass = createEClass(GSNPackage.DECORATABLE);
    createEReference(this.decoratableEClass, GSNPackage.DECORATABLE__DECORATORS);

    this.supportableEClass = createEClass(GSNPackage.SUPPORTABLE);
    createEReference(this.supportableEClass, GSNPackage.SUPPORTABLE__SUPPORTED_BY);
    createEReference(this.supportableEClass, GSNPackage.SUPPORTABLE__UNDEVELOPED);

    this.supporterEClass = createEClass(GSNPackage.SUPPORTER);
    createEReference(this.supporterEClass, GSNPackage.SUPPORTER__SUPPORTS);

    this.supportedByEClass = createEClass(GSNPackage.SUPPORTED_BY);
    createEReference(this.supportedByEClass, GSNPackage.SUPPORTED_BY__SOURCE);
    createEReference(this.supportedByEClass, GSNPackage.SUPPORTED_BY__TARGET);

    this.contextualizableEClass = createEClass(GSNPackage.CONTEXTUALIZABLE);
    createEReference(this.contextualizableEClass, GSNPackage.CONTEXTUALIZABLE__IN_CONTEXT_OF);

    this.contextualEClass = createEClass(GSNPackage.CONTEXTUAL);
    createEReference(this.contextualEClass, GSNPackage.CONTEXTUAL__CONTEXT_OF);

    this.inContextOfEClass = createEClass(GSNPackage.IN_CONTEXT_OF);
    createEReference(this.inContextOfEClass, GSNPackage.IN_CONTEXT_OF__CONTEXT);
    createEReference(this.inContextOfEClass, GSNPackage.IN_CONTEXT_OF__CONTEXT_OF);

    this.asiLfulElementEClass = createEClass(GSNPackage.ASI_LFUL_ELEMENT);
    createEReference(this.asiLfulElementEClass, GSNPackage.ASI_LFUL_ELEMENT__ASIL);

    this.goalEClass = createEClass(GSNPackage.GOAL);

    this.strategyEClass = createEClass(GSNPackage.STRATEGY);

    this.solutionEClass = createEClass(GSNPackage.SOLUTION);

    this.contextEClass = createEClass(GSNPackage.CONTEXT);

    this.justificationEClass = createEClass(GSNPackage.JUSTIFICATION);

    this.assumptionEClass = createEClass(GSNPackage.ASSUMPTION);

    this.undevelopedEClass = createEClass(GSNPackage.UNDEVELOPED);

    this.asilEClass = createEClass(GSNPackage.ASIL);
    createEAttribute(this.asilEClass, GSNPackage.ASIL__VALUE);
    createEReference(this.asilEClass, GSNPackage.ASIL__TARGET);
    createEReference(this.asilEClass, GSNPackage.ASIL__STATUS);

    this.impactAnnotationEClass = createEClass(GSNPackage.IMPACT_ANNOTATION);
    createEAttribute(this.impactAnnotationEClass, GSNPackage.IMPACT_ANNOTATION__TYPE);
    createEAttribute(this.impactAnnotationEClass, GSNPackage.IMPACT_ANNOTATION__SOURCE);

    this.templateEClass = createEClass(GSNPackage.TEMPLATE);
    createEReference(this.templateEClass, GSNPackage.TEMPLATE__ELEMENTS);
    createEAttribute(this.templateEClass, GSNPackage.TEMPLATE__ID);
    createEOperation(this.templateEClass, GSNPackage.TEMPLATE___GET_ELEMENT__STRING);
    createEOperation(this.templateEClass, GSNPackage.TEMPLATE___VALIDATE);
    createEOperation(this.templateEClass, GSNPackage.TEMPLATE___IMPORT____SAFETYCASE);
    createEOperation(this.templateEClass, GSNPackage.TEMPLATE___INSTANTIATE);
    createEOperation(this.templateEClass, GSNPackage.TEMPLATE___IMPACT__GSNIMPACTSTEP_OBJECT);
    createEOperation(this.templateEClass, GSNPackage.TEMPLATE___REPAIR__OBJECT);

    this.relationshipDecoratorEClass = createEClass(GSNPackage.RELATIONSHIP_DECORATOR);
    createEAttribute(this.relationshipDecoratorEClass, GSNPackage.RELATIONSHIP_DECORATOR__TYPE);
    createEAttribute(this.relationshipDecoratorEClass, GSNPackage.RELATIONSHIP_DECORATOR__CARDINALITY);

    // Create enums
    this.asilLevelEEnum = createEEnum(GSNPackage.ASIL_LEVEL);
    this.impactTypeEEnum = createEEnum(GSNPackage.IMPACT_TYPE);
    this.decoratorTypeEEnum = createEEnum(GSNPackage.DECORATOR_TYPE);

    // Create data types
    this.exceptionEDataType = createEDataType(GSNPackage.EXCEPTION);
    this.gsnBuilderEDataType = createEDataType(GSNPackage.GSN_BUILDER);
    this.gsnImpactStepEDataType = createEDataType(GSNPackage.GSN_IMPACT_STEP);
    this.optionalEDataType = createEDataType(GSNPackage.OPTIONAL);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents() {
    if (this.isInitialized) {
      return;
    }
    this.isInitialized = true;

    // Initialize package
    setName(GSNPackage.eNAME);
    setNsPrefix(GSNPackage.eNS_PREFIX);
    setNsURI(GSNPackage.eNS_URI);

    // Create type parameters
    addETypeParameter(this.optionalEDataType, "T");

    // Set bounds for type parameters

    // Add supertypes to classes
    this.decoratableEClass.getESuperTypes().add(this.getArgumentElement());
    this.supportableEClass.getESuperTypes().add(this.getDecoratable());
    this.supporterEClass.getESuperTypes().add(this.getArgumentElement());
    this.contextualizableEClass.getESuperTypes().add(this.getDecoratable());
    this.contextualEClass.getESuperTypes().add(this.getArgumentElement());
    this.goalEClass.getESuperTypes().add(this.getSupportable());
    this.goalEClass.getESuperTypes().add(this.getSupporter());
    this.goalEClass.getESuperTypes().add(this.getContextualizable());
    this.goalEClass.getESuperTypes().add(this.getASILfulElement());
    this.strategyEClass.getESuperTypes().add(this.getSupportable());
    this.strategyEClass.getESuperTypes().add(this.getSupporter());
    this.strategyEClass.getESuperTypes().add(this.getContextualizable());
    this.solutionEClass.getESuperTypes().add(this.getSupporter());
    this.contextEClass.getESuperTypes().add(this.getContextual());
    this.justificationEClass.getESuperTypes().add(this.getContextual());
    this.assumptionEClass.getESuperTypes().add(this.getContextual());
    this.relationshipDecoratorEClass.getESuperTypes().add(this.getSupportable());
    this.relationshipDecoratorEClass.getESuperTypes().add(this.getContextualizable());

    // Initialize classes, features, and operations; add parameters
    initEClass(this.safetyCaseEClass, SafetyCase.class, "SafetyCase", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSafetyCase_Goals(), this.getGoal(), null, "goals", null, 0, -1, SafetyCase.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getSafetyCase_Strategies(), this.getStrategy(), null, "strategies", null, 0, -1, SafetyCase.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getSafetyCase_Solutions(), this.getSolution(), null, "solutions", null, 0, -1, SafetyCase.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getSafetyCase_Contexts(), this.getContext(), null, "contexts", null, 0, -1, SafetyCase.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getSafetyCase_Justifications(), this.getJustification(), null, "justifications", null, 0, -1, SafetyCase.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getSafetyCase_Assumptions(), this.getAssumption(), null, "assumptions", null, 0, -1, SafetyCase.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getSafetyCase_Templates(), this.getTemplate(), null, "templates", null, 0, -1, SafetyCase.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.argumentElementEClass, ArgumentElement.class, "ArgumentElement", EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getArgumentElement_Id(), this.ecorePackage.getEString(), "id", null, 1, 1, ArgumentElement.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEAttribute(getArgumentElement_Description(), this.ecorePackage.getEString(), "description", null, 0, 1, ArgumentElement.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getArgumentElement_Status(), this.getImpactAnnotation(), null, "status", null, 0, 1, ArgumentElement.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getArgumentElement_Templates(), this.getTemplate(), this.getTemplate_Elements(), "templates", null, 0, -1, ArgumentElement.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEAttribute(getArgumentElement_TemplateId(), this.ecorePackage.getEString(), "templateId", null, 0, 1, ArgumentElement.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEAttribute(getArgumentElement_Valid(), this.ecorePackage.getEBoolean(), "valid", "true", 1, 1, ArgumentElement.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    var op = initEOperation(getArgumentElement__Validate__Template(), null, "validate", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getTemplate(), "template", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getException());

    op = initEOperation(getArgumentElement__Instantiate__Template(), null, "instantiate", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getTemplate(), "template", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getException());

    initEClass(this.decoratableEClass, Decoratable.class, "Decoratable", EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDecoratable_Decorators(), this.getRelationshipDecorator(), null, "decorators", null, 0, -1, Decoratable.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.supportableEClass, Supportable.class, "Supportable", EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSupportable_SupportedBy(), this.getSupportedBy(), this.getSupportedBy_Source(), "supportedBy", null, 1, -1, Supportable.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getSupportable_Undeveloped(), this.getUndeveloped(), null, "undeveloped", null, 0, 1, Supportable.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.supporterEClass, Supporter.class, "Supporter", EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSupporter_Supports(), this.getSupportedBy(), this.getSupportedBy_Target(), "supports", null, 0, -1, Supporter.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.supportedByEClass, SupportedBy.class, "SupportedBy", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSupportedBy_Source(), this.getSupportable(), this.getSupportable_SupportedBy(), "source", null, 1, 1, SupportedBy.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getSupportedBy_Target(), this.getSupporter(), this.getSupporter_Supports(), "target", null, 1, 1, SupportedBy.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.contextualizableEClass, Contextualizable.class, "Contextualizable", EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getContextualizable_InContextOf(), this.getInContextOf(), this.getInContextOf_ContextOf(), "inContextOf", null, 0, -1, Contextualizable.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.contextualEClass, Contextual.class, "Contextual", EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getContextual_ContextOf(), this.getInContextOf(), this.getInContextOf_Context(), "contextOf", null, 1, -1, Contextual.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.inContextOfEClass, InContextOf.class, "InContextOf", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInContextOf_Context(), this.getContextual(), this.getContextual_ContextOf(), "context", null, 1, 1, InContextOf.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getInContextOf_ContextOf(), this.getContextualizable(), this.getContextualizable_InContextOf(), "contextOf", null, 1, 1, InContextOf.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.asiLfulElementEClass, ASILfulElement.class, "ASILfulElement", EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getASILfulElement_Asil(), this.getASIL(), this.getASIL_Target(), "asil", null, 0, 1, ASILfulElement.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.goalEClass, Goal.class, "Goal", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    initEClass(this.strategyEClass, Strategy.class, "Strategy", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    initEClass(this.solutionEClass, Solution.class, "Solution", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    initEClass(this.contextEClass, Context.class, "Context", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    initEClass(this.justificationEClass, Justification.class, "Justification", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    initEClass(this.assumptionEClass, Assumption.class, "Assumption", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    initEClass(this.undevelopedEClass, Undeveloped.class, "Undeveloped", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    initEClass(this.asilEClass, edu.toronto.cs.se.modelepedia.gsn.ASIL.class, "ASIL", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getASIL_Value(), this.getASILLevel(), "value", null, 1, 1, edu.toronto.cs.se.modelepedia.gsn.ASIL.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getASIL_Target(), this.getASILfulElement(), this.getASILfulElement_Asil(), "target", null, 1, 1, edu.toronto.cs.se.modelepedia.gsn.ASIL.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getASIL_Status(), this.getImpactAnnotation(), null, "status", null, 0, 1, edu.toronto.cs.se.modelepedia.gsn.ASIL.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.impactAnnotationEClass, ImpactAnnotation.class, "ImpactAnnotation", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getImpactAnnotation_Type(), this.getImpactType(), "type", null, 1, 1, ImpactAnnotation.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEAttribute(getImpactAnnotation_Source(), this.ecorePackage.getEString(), "source", null, 0, 1, ImpactAnnotation.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.templateEClass, Template.class, "Template", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTemplate_Elements(), this.getArgumentElement(), this.getArgumentElement_Templates(), "elements", null, 1, -1, Template.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEAttribute(getTemplate_Id(), this.ecorePackage.getEString(), "id", null, 1, 1, Template.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    op = initEOperation(getTemplate__GetElement__String(), null, "getElement", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "id", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    var g1 = createEGenericType(this.getOptional());
    var g2 = createEGenericType(this.getArgumentElement());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    op = initEOperation(getTemplate__Validate(), null, "validate", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getException());

    op = initEOperation(getTemplate__Import___SafetyCase(), null, "import_", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getSafetyCase(), "safetyCase", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getException());

    op = initEOperation(getTemplate__Instantiate(), null, "instantiate", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getException());

    op = initEOperation(getTemplate__Impact__GSNImpactStep_Object(), this.getGSNImpactStep(), "impact", 0, -1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getGSNImpactStep(), "step", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEJavaObject(), "change", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getException());

    op = initEOperation(getTemplate__Repair__Object(), null, "repair", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEJavaObject(), "change", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getException());

    initEClass(this.relationshipDecoratorEClass, RelationshipDecorator.class, "RelationshipDecorator", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRelationshipDecorator_Type(), this.getDecoratorType(), "type", null, 1, 1, RelationshipDecorator.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEAttribute(getRelationshipDecorator_Cardinality(), this.ecorePackage.getEInt(), "cardinality", "-1", 0, 1, RelationshipDecorator.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(this.asilLevelEEnum, ASILLevel.class, "ASILLevel");
    addEEnumLiteral(this.asilLevelEEnum, ASILLevel.D);
    addEEnumLiteral(this.asilLevelEEnum, ASILLevel.C);
    addEEnumLiteral(this.asilLevelEEnum, ASILLevel.B);
    addEEnumLiteral(this.asilLevelEEnum, ASILLevel.A);
    addEEnumLiteral(this.asilLevelEEnum, ASILLevel.QM);

    initEEnum(this.impactTypeEEnum, ImpactType.class, "ImpactType");
    addEEnumLiteral(this.impactTypeEEnum, ImpactType.REUSE);
    addEEnumLiteral(this.impactTypeEEnum, ImpactType.RECHECK);
    addEEnumLiteral(this.impactTypeEEnum, ImpactType.REVISE);

    initEEnum(this.decoratorTypeEEnum, DecoratorType.class, "DecoratorType");
    addEEnumLiteral(this.decoratorTypeEEnum, DecoratorType.MULTIPLE);
    addEEnumLiteral(this.decoratorTypeEEnum, DecoratorType.OPTIONAL);
    addEEnumLiteral(this.decoratorTypeEEnum, DecoratorType.CHOICE);

    // Initialize data types
    initEDataType(this.exceptionEDataType, Exception.class, "Exception", EPackageImpl.IS_SERIALIZABLE, !EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEDataType(this.gsnBuilderEDataType, GSNBuilder.class, "GSNBuilder", EPackageImpl.IS_SERIALIZABLE, !EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEDataType(this.gsnImpactStepEDataType, GSNImpactStep.class, "GSNImpactStep", EPackageImpl.IS_SERIALIZABLE, !EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEDataType(this.optionalEDataType, Optional.class, "Optional", EPackageImpl.IS_SERIALIZABLE, !EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(GSNPackage.eNS_URI);

    // Create annotations
    // http://www.eclipse.org/OCL/Import
    createImportAnnotations();
    // http://www.eclipse.org/emf/2002/Ecore
    createEcoreAnnotations();
    // http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot
    createPivotAnnotations();
    // gmf.label
    createGmfAnnotations();
  }

  /**
   * Initializes the annotations for <b>http://www.eclipse.org/OCL/Import</b>. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @generated
   */
  protected void createImportAnnotations() {
    var source = "http://www.eclipse.org/OCL/Import";
    addAnnotation
      (this,
       source,
       new String[] {
         "ecore", "http://www.eclipse.org/emf/2002/Ecore"
       });
  }

  /**
   * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   */
  protected void createEcoreAnnotations() {
    var source = "http://www.eclipse.org/emf/2002/Ecore";
    addAnnotation
      (this,
       source,
       new String[] {
         "invocationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
         "settingDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
         "validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot"
       });
    addAnnotation
      (this.safetyCaseEClass,
       source,
       new String[] {
         "constraints", "SingleGoalRoot"
       });
    addAnnotation
      (this.supportableEClass,
       source,
       new String[] {
         "constraints", "SupportCycle StrategySupportsGoals"
       });
    addAnnotation
      (this.goalEClass,
       source,
       new String[] {
         "constraints", "ASILInheritance"
       });
    addAnnotation
      (this.relationshipDecoratorEClass,
       source,
       new String[] {
         "constraints", "OneRelationship"
       });
  }

  /**
   * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createPivotAnnotations() {
    var source = "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot";
    addAnnotation
      (this.safetyCaseEClass,
       source,
       new String[] {
         "SingleGoalRoot", "let root : Set(OclAny) = Supporter.allInstances()->select(s | s.supports->isEmpty()) in\n  root->size() = 1 and root->forAll(g | g.oclIsKindOf(gsn::Goal))"
       });
    addAnnotation
      (this.supportableEClass,
       source,
       new String[] {
         "SupportCycle", "self.supportedBy.target->closure(p | if p.oclIsKindOf(Supportable) then p.oclAsType(Supportable).supportedBy.target else p.oclAsSet() endif)->excludes(self)",
         "StrategySupportsGoals", "if self.oclIsKindOf(gsn::Strategy) then self.supportedBy->forAll(sb | sb.target.oclIsKindOf(gsn::Goal)) else true endif"
       });
    addAnnotation
      (this.goalEClass,
       source,
       new String[] {
         "ASILInheritance", "let parents : Set(Goal) = self.supports.source -> closure(c | if c.oclIsKindOf(Goal) then c.oclAsSet() else c.oclAsType(gsn::Supporter).supports.source endif) -> selectByKind(Goal) -> asSet() in\n  parents -> forAll(g | if g.asil = null then true else if self.asil = null then false else g.asil.value = ASILLevel::QM or (g.asil.value.toString() <= self.asil.value.toString() and self.asil.value <> ASILLevel::QM) endif endif)"
       });
    addAnnotation
      (this.relationshipDecoratorEClass,
       source,
       new String[] {
         "OneRelationship", "self.supportedBy->isEmpty() or self.inContextOf->isEmpty()"
       });
  }

  /**
   * Initializes the annotations for <b>gmf.label</b>.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void createGmfAnnotations() {
    var source = "gmf.label";
    addAnnotation
      (getArgumentElement_Description(),
       source,
       new String[] {
         "label", "description"
       });
  }

} // GSNPackageImpl

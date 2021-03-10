/**
 * Copyright (c) 2012-2021 Alessio Di Sandro, Marsha Chechik, Nick Fung.
 * All rights reserved. This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Alessio Di Sandro - Implementation
 *   Nick Fung - Implementation.
 *
 */
package edu.toronto.cs.se.modelepedia.gsn.util;

import edu.toronto.cs.se.modelepedia.gsn.*;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.modelepedia.gsn.ASIL;
import edu.toronto.cs.se.modelepedia.gsn.ASILDecompositionStrategy;
import edu.toronto.cs.se.modelepedia.gsn.ASILfulElement;
import edu.toronto.cs.se.modelepedia.gsn.AndSupporter;
import edu.toronto.cs.se.modelepedia.gsn.ArgumentElement;
import edu.toronto.cs.se.modelepedia.gsn.Assumption;
import edu.toronto.cs.se.modelepedia.gsn.BasicGoal;
import edu.toronto.cs.se.modelepedia.gsn.BasicStrategy;
import edu.toronto.cs.se.modelepedia.gsn.Context;
import edu.toronto.cs.se.modelepedia.gsn.ContextualElement;
import edu.toronto.cs.se.modelepedia.gsn.CoreElement;
import edu.toronto.cs.se.modelepedia.gsn.DecomposableCoreElement;
import edu.toronto.cs.se.modelepedia.gsn.DecompositionStrategy;
import edu.toronto.cs.se.modelepedia.gsn.Domain;
import edu.toronto.cs.se.modelepedia.gsn.DomainDecompositionElement;
import edu.toronto.cs.se.modelepedia.gsn.DomainDecompositionStrategy;
import edu.toronto.cs.se.modelepedia.gsn.DomainGoal;
import edu.toronto.cs.se.modelepedia.gsn.EnumDomain;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.Goal;
import edu.toronto.cs.se.modelepedia.gsn.ImpactAnnotation;
import edu.toronto.cs.se.modelepedia.gsn.InContextOf;
import edu.toronto.cs.se.modelepedia.gsn.IndependenceGoal;
import edu.toronto.cs.se.modelepedia.gsn.IntDomain;
import edu.toronto.cs.se.modelepedia.gsn.Justification;
import edu.toronto.cs.se.modelepedia.gsn.MofNSupporter;
import edu.toronto.cs.se.modelepedia.gsn.OrSupporter;
import edu.toronto.cs.se.modelepedia.gsn.PropertyDecompositionElement;
import edu.toronto.cs.se.modelepedia.gsn.PropertyDecompositionStrategy;
import edu.toronto.cs.se.modelepedia.gsn.PropertyGoal;
import edu.toronto.cs.se.modelepedia.gsn.RealDomain;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.Solution;
import edu.toronto.cs.se.modelepedia.gsn.StatefulElement;
import edu.toronto.cs.se.modelepedia.gsn.Strategy;
import edu.toronto.cs.se.modelepedia.gsn.SupportConnector;
import edu.toronto.cs.se.modelepedia.gsn.Supportable;
import edu.toronto.cs.se.modelepedia.gsn.SupportedBy;
import edu.toronto.cs.se.modelepedia.gsn.Supporter;
import edu.toronto.cs.se.modelepedia.gsn.ValueDomain;
import edu.toronto.cs.se.modelepedia.gsn.XorSupporter;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter <code>createXXX</code>
 * method for each class of the model. <!-- end-user-doc -->
 * 
 * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage
 * @generated
 */
public class GSNAdapterFactory extends AdapterFactoryImpl {
  /**
   * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected static GSNPackage modelPackage;

  /**
   * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public GSNAdapterFactory() {
    if (modelPackage == null) {
      modelPackage = GSNPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object. <!-- begin-user-doc --> This implementation
   * returns <code>true</code> if the object is either the model's package or is an instance object of the model. <!--
   * end-user-doc -->
   * 
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object) {
    if (object == modelPackage) {
      return true;
    }
    if (object instanceof EObject) {
      return ((EObject) object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected GSNSwitch<Adapter> modelSwitch = new GSNSwitch<Adapter>() {
    @Override
    public Adapter caseSafetyCase(SafetyCase object) {
      return createSafetyCaseAdapter();
    }

    @Override
    public Adapter caseArgumentElement(ArgumentElement object) {
      return createArgumentElementAdapter();
    }

    @Override
    public Adapter caseStatefulElement(StatefulElement object) {
      return createStatefulElementAdapter();
    }

    @Override
    public Adapter caseASILfulElement(ASILfulElement object) {
      return createASILfulElementAdapter();
    }

    @Override
    public Adapter caseCoreElement(CoreElement object) {
      return createCoreElementAdapter();
    }

    @Override
    public Adapter caseDecomposableCoreElement(DecomposableCoreElement object) {
      return createDecomposableCoreElementAdapter();
    }

    @Override
    public Adapter caseContextualElement(ContextualElement object) {
      return createContextualElementAdapter();
    }

    @Override
    public Adapter caseSupportedBy(SupportedBy object) {
      return createSupportedByAdapter();
    }

    @Override
    public Adapter caseInContextOf(InContextOf object) {
      return createInContextOfAdapter();
    }

    @Override
    public Adapter caseGoal(Goal object) {
      return createGoalAdapter();
    }

    @Override
    public Adapter caseBasicGoal(BasicGoal object) {
      return createBasicGoalAdapter();
    }

    @Override
    public Adapter caseIndependenceGoal(IndependenceGoal object) {
      return createIndependenceGoalAdapter();
    }

    @Override
    public Adapter caseStrategy(Strategy object) {
      return createStrategyAdapter();
    }

    @Override
    public Adapter caseBasicStrategy(BasicStrategy object) {
      return createBasicStrategyAdapter();
    }

    @Override
    public Adapter caseASILDecompositionStrategy(ASILDecompositionStrategy object) {
      return createASILDecompositionStrategyAdapter();
    }

    @Override
    public Adapter caseSolution(Solution object) {
      return createSolutionAdapter();
    }

    @Override
    public Adapter caseContext(Context object) {
      return createContextAdapter();
    }

    @Override
    public Adapter caseJustification(Justification object) {
      return createJustificationAdapter();
    }

    @Override
    public Adapter caseAssumption(Assumption object) {
      return createAssumptionAdapter();
    }

    @Override
    public Adapter caseASIL(ASIL object) {
      return createASILAdapter();
    }

    @Override
    public Adapter caseImpactAnnotation(ImpactAnnotation object) {
      return createImpactAnnotationAdapter();
    }

    @Override
    public Adapter caseSupportable(Supportable object) {
      return createSupportableAdapter();
    }

    @Override
    public Adapter caseSupporter(Supporter object) {
      return createSupporterAdapter();
    }

    @Override
    public Adapter caseSupportConnector(SupportConnector object) {
      return createSupportConnectorAdapter();
    }

    @Override
    public Adapter caseAndSupporter(AndSupporter object) {
      return createAndSupporterAdapter();
    }

    @Override
    public Adapter caseOrSupporter(OrSupporter object) {
      return createOrSupporterAdapter();
    }

    @Override
    public Adapter caseXorSupporter(XorSupporter object) {
      return createXorSupporterAdapter();
    }

    @Override
    public Adapter caseMofNSupporter(MofNSupporter object) {
      return createMofNSupporterAdapter();
    }

    @Override
    public Adapter caseDecompositionStrategy(DecompositionStrategy object) {
      return createDecompositionStrategyAdapter();
    }

    @Override
    public Adapter caseDomain(Domain object) {
      return createDomainAdapter();
    }

    @Override
    public Adapter caseIntDomain(IntDomain object) {
      return createIntDomainAdapter();
    }

    @Override
    public Adapter caseRealDomain(RealDomain object) {
      return createRealDomainAdapter();
    }

    @Override
    public Adapter caseEnumDomain(EnumDomain object) {
      return createEnumDomainAdapter();
    }

    @Override
    public Adapter caseValueDomain(ValueDomain object) {
      return createValueDomainAdapter();
    }

    @Override
    public Adapter caseDomainDecompositionElement(DomainDecompositionElement object) {
      return createDomainDecompositionElementAdapter();
    }

    @Override
    public Adapter caseDomainDecompositionStrategy(DomainDecompositionStrategy object) {
      return createDomainDecompositionStrategyAdapter();
    }

    @Override
    public Adapter caseDomainGoal(DomainGoal object) {
      return createDomainGoalAdapter();
    }

    @Override
    public Adapter caseProperty(Property object) {
      return createPropertyAdapter();
    }

    @Override
    public Adapter casePropertyDecompositionElement(PropertyDecompositionElement object) {
      return createPropertyDecompositionElementAdapter();
    }

    @Override
    public Adapter casePropertyDecompositionStrategy(PropertyDecompositionStrategy object) {
      return createPropertyDecompositionStrategyAdapter();
    }

    @Override
    public Adapter casePropertyGoal(PropertyGoal object) {
      return createPropertyGoalAdapter();
    }

    @Override
    public Adapter defaultCase(EObject object) {
      return createEObjectAdapter();
    }
  };

  /**
   * Creates an adapter for the <code>target</code>. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param target
   *          the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target) {
    return modelSwitch.doSwitch((EObject) target);
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.SafetyCase <em>Safety
   * Case</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.SafetyCase
   * @generated
   */
  public Adapter createSafetyCaseAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.ArgumentElement <em>Argument
   * Element</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
   * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.ArgumentElement
   * @generated
   */
  public Adapter createArgumentElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.StatefulElement <em>Stateful
   * Element</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
   * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.StatefulElement
   * @generated
   */
  public Adapter createStatefulElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.ASILfulElement <em>ASI Lful
   * Element</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
   * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.ASILfulElement
   * @generated
   */
  public Adapter createASILfulElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.CoreElement <em>Core
   * Element</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
   * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.CoreElement
   * @generated
   */
  public Adapter createCoreElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.DecomposableCoreElement
   * <em>Decomposable Core Element</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we
   * can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
   * end-user-doc -->
   * 
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.DecomposableCoreElement
   * @generated
   */
  public Adapter createDecomposableCoreElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.ContextualElement
   * <em>Contextual Element</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can
   * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
   * end-user-doc -->
   * 
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.ContextualElement
   * @generated
   */
  public Adapter createContextualElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.SupportedBy <em>Supported
   * By</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.SupportedBy
   * @generated
   */
  public Adapter createSupportedByAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.InContextOf <em>In Context
   * Of</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.InContextOf
   * @generated
   */
  public Adapter createInContextOfAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.Goal <em>Goal</em>}'. <!--
   * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.Goal
   * @generated
   */
  public Adapter createGoalAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.BasicGoal <em>Basic
   * Goal</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.BasicGoal
   * @generated
   */
  public Adapter createBasicGoalAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.IndependenceGoal
   * <em>Independence Goal</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can
   * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
   * end-user-doc -->
   * 
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.IndependenceGoal
   * @generated
   */
  public Adapter createIndependenceGoalAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.DomainGoal <em>Domain
   * Goal</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.DomainGoal
   * @generated
   */
  public Adapter createDomainGoalAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.Property
   * <em>Property</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
   * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.Property
   * @generated
   */
  public Adapter createPropertyAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.PropertyDecompositionElement
   * <em>Property Decomposition Element</em>}'. <!-- begin-user-doc --> This default implementation returns null so that
   * we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
   * end-user-doc -->
   * 
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.PropertyDecompositionElement
   * @generated
   */
  public Adapter createPropertyDecompositionElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class
   * '{@link edu.toronto.cs.se.modelepedia.gsn.PropertyDecompositionStrategy <em>Property Decomposition Strategy</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.PropertyDecompositionStrategy
   * @generated
   */
  public Adapter createPropertyDecompositionStrategyAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.PropertyGoal <em>Property
   * Goal</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.PropertyGoal
   * @generated
   */
  public Adapter createPropertyGoalAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.Strategy
   * <em>Strategy</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
   * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.Strategy
   * @generated
   */
  public Adapter createStrategyAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.BasicStrategy <em>Basic
   * Strategy</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
   * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.BasicStrategy
   * @generated
   */
  public Adapter createBasicStrategyAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.ASILDecompositionStrategy
   * <em>ASIL Decomposition Strategy</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we
   * can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
   * end-user-doc -->
   * 
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.ASILDecompositionStrategy
   * @generated
   */
  public Adapter createASILDecompositionStrategyAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.Solution
   * <em>Solution</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
   * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.Solution
   * @generated
   */
  public Adapter createSolutionAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.Context <em>Context</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.Context
   * @generated
   */
  public Adapter createContextAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.Justification
   * <em>Justification</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
   * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.Justification
   * @generated
   */
  public Adapter createJustificationAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.Assumption
   * <em>Assumption</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
   * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.Assumption
   * @generated
   */
  public Adapter createAssumptionAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.ASIL <em>ASIL</em>}'. <!--
   * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.ASIL
   * @generated
   */
  public Adapter createASILAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.ImpactAnnotation <em>Impact
   * Annotation</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
   * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.ImpactAnnotation
   * @generated
   */
  public Adapter createImpactAnnotationAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.Supportable
   * <em>Supportable</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
   * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.Supportable
   * @generated
   */
  public Adapter createSupportableAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.Supporter
   * <em>Supporter</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
   * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.Supporter
   * @generated
   */
  public Adapter createSupporterAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.SupportConnector <em>Support
   * Connector</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
   * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.SupportConnector
   * @generated
   */
  public Adapter createSupportConnectorAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.AndSupporter <em>And
   * Supporter</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
   * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.AndSupporter
   * @generated
   */
  public Adapter createAndSupporterAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.OrSupporter <em>Or
   * Supporter</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
   * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.OrSupporter
   * @generated
   */
  public Adapter createOrSupporterAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.XorSupporter <em>Xor
   * Supporter</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
   * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.XorSupporter
   * @generated
   */
  public Adapter createXorSupporterAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.MofNSupporter <em>Mof
   * NSupporter</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
   * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.MofNSupporter
   * @generated
   */
  public Adapter createMofNSupporterAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.DecompositionStrategy
   * <em>Decomposition Strategy</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can
   * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
   * end-user-doc -->
   * 
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.DecompositionStrategy
   * @generated
   */
  public Adapter createDecompositionStrategyAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.Domain <em>Domain</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.Domain
   * @generated
   */
  public Adapter createDomainAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.IntDomain <em>Int
   * Domain</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.IntDomain
   * @generated
   */
  public Adapter createIntDomainAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.RealDomain <em>Real
   * Domain</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.RealDomain
   * @generated
   */
  public Adapter createRealDomainAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.EnumDomain <em>Enum
   * Domain</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.EnumDomain
   * @generated
   */
  public Adapter createEnumDomainAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.ValueDomain <em>Value
   * Domain</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.ValueDomain
   * @generated
   */
  public Adapter createValueDomainAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.DomainDecompositionElement
   * <em>Domain Decomposition Element</em>}'. <!-- begin-user-doc --> This default implementation returns null so that
   * we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
   * end-user-doc -->
   * 
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.DomainDecompositionElement
   * @generated
   */
  public Adapter createDomainDecompositionElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.DomainDecompositionStrategy
   * <em>Domain Decomposition Strategy</em>}'. <!-- begin-user-doc --> This default implementation returns null so that
   * we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
   * end-user-doc -->
   * 
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.DomainDecompositionStrategy
   * @generated
   */
  public Adapter createDomainDecompositionStrategyAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for the default case. <!-- begin-user-doc --> This default implementation returns null. <!--
   * end-user-doc -->
   * 
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter() {
    return null;
  }

} // GSNAdapterFactory

/*******************************************************************************
 * Copyright (c) 2017, 2024 Alessio Di Sandro, Nick Fung.
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
package edu.toronto.cs.se.modelepedia.gsn.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.modelepedia.gsn.ASIL;
import edu.toronto.cs.se.modelepedia.gsn.ASILfulElement;
import edu.toronto.cs.se.modelepedia.gsn.ArgumentElement;
import edu.toronto.cs.se.modelepedia.gsn.Assumption;
import edu.toronto.cs.se.modelepedia.gsn.Context;
import edu.toronto.cs.se.modelepedia.gsn.ContextualElement;
import edu.toronto.cs.se.modelepedia.gsn.ContextualizableElement;
import edu.toronto.cs.se.modelepedia.gsn.Decoratable;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.Goal;
import edu.toronto.cs.se.modelepedia.gsn.ImpactAnnotation;
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

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter <code>createXXX</code>
 * method for each class of the model. <!-- end-user-doc -->
 * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage
 * @generated
 */
public class GSNAdapterFactory extends AdapterFactoryImpl {
  /**
   * The cached model package.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected static GSNPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public GSNAdapterFactory() {
    if (GSNAdapterFactory.modelPackage == null) {
      GSNAdapterFactory.modelPackage = GSNPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc --> This implementation
   * returns <code>true</code> if the object is either the model's package or is an instance object of the model. <!--
   * end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object) {
    if (object == GSNAdapterFactory.modelPackage) {
      return true;
    }
    if (object instanceof EObject) {
      return ((EObject)object).eClass().getEPackage() == GSNAdapterFactory.modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected GSNSwitch<Adapter> modelSwitch = new GSNSwitch<>() {
      @Override
      public Adapter caseSafetyCase(SafetyCase object) {
        return createSafetyCaseAdapter();
      }
      @Override
      public Adapter caseArgumentElement(ArgumentElement object) {
        return createArgumentElementAdapter();
      }
      @Override
      public Adapter caseDecoratable(Decoratable object) {
        return createDecoratableAdapter();
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
      public Adapter caseSupportedBy(SupportedBy object) {
        return createSupportedByAdapter();
      }
      @Override
      public Adapter caseContextualizableElement(ContextualizableElement object) {
        return createContextualizableElementAdapter();
      }
      @Override
      public Adapter caseContextualElement(ContextualElement object) {
        return createContextualElementAdapter();
      }
      @Override
      public Adapter caseInContextOf(InContextOf object) {
        return createInContextOfAdapter();
      }
      @Override
      public Adapter caseASILfulElement(ASILfulElement object) {
        return createASILfulElementAdapter();
      }
      @Override
      public Adapter caseGoal(Goal object) {
        return createGoalAdapter();
      }
      @Override
      public Adapter caseStrategy(Strategy object) {
        return createStrategyAdapter();
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
      public Adapter caseUndeveloped(Undeveloped object) {
        return createUndevelopedAdapter();
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
      public Adapter caseTemplate(Template object) {
        return createTemplateAdapter();
      }
      @Override
      public Adapter caseRelationshipDecorator(RelationshipDecorator object) {
        return createRelationshipDecoratorAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object) {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target) {
    return this.modelSwitch.doSwitch((EObject)target);
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.SafetyCase <em>Safety Case</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.SafetyCase
   * @generated
   */
  public Adapter createSafetyCaseAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.ArgumentElement <em>Argument Element</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
   * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.ArgumentElement
   * @generated
   */
  public Adapter createArgumentElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.Decoratable <em>Decoratable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.Decoratable
   * @generated
   */
  public Adapter createDecoratableAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.ASILfulElement <em>ASI Lful Element</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
   * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.ASILfulElement
   * @generated
   */
  public Adapter createASILfulElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.ContextualElement <em>Contextual Element</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can
   * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
   * end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.ContextualElement
   * @generated
   */
  public Adapter createContextualElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.SupportedBy <em>Supported By</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.SupportedBy
   * @generated
   */
  public Adapter createSupportedByAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.ContextualizableElement <em>Contextualizable Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.ContextualizableElement
   * @generated
   */
  public Adapter createContextualizableElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.InContextOf <em>In Context Of</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
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
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.Strategy <em>Strategy</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
   * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.Strategy
   * @generated
   */
  public Adapter createStrategyAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.Solution <em>Solution</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
   * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
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
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.Context
   * @generated
   */
  public Adapter createContextAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.Justification <em>Justification</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily
   * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.Justification
   * @generated
   */
  public Adapter createJustificationAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.Assumption <em>Assumption</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily
   * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
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
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.ImpactAnnotation <em>Impact Annotation</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
   * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.ImpactAnnotation
   * @generated
   */
  public Adapter createImpactAnnotationAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.Supportable <em>Supportable</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily
   * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.Supportable
   * @generated
   */
  public Adapter createSupportableAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.Supporter <em>Supporter</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
   * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.Supporter
   * @generated
   */
  public Adapter createSupporterAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.Template <em>Template</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.Template
   * @generated
   */
  public Adapter createTemplateAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.RelationshipDecorator <em>Relationship Decorator</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.RelationshipDecorator
   * @generated
   */
  public Adapter createRelationshipDecoratorAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.gsn.Undeveloped <em>Undeveloped</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.modelepedia.gsn.Undeveloped
   * @generated
   */
  public Adapter createUndevelopedAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc --> This default implementation returns null. <!--
   * end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter() {
    return null;
  }

} // GSNAdapterFactory

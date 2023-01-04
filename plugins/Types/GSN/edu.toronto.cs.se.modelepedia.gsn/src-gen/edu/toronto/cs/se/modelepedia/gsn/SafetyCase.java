/*******************************************************************************
 * Copyright (c) 2017, 2023 Alessio Di Sandro, Nick Fung.
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
package edu.toronto.cs.se.modelepedia.gsn;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Safety Case</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.SafetyCase#getGoals <em>Goals</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.SafetyCase#getStrategies <em>Strategies</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.SafetyCase#getSolutions <em>Solutions</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.SafetyCase#getContexts <em>Contexts</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.SafetyCase#getJustifications <em>Justifications</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.SafetyCase#getAssumptions <em>Assumptions</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.SafetyCase#getConnectors <em>Connectors</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getSafetyCase()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='SingleRoot'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot SingleRoot='Supporter.allInstances() -&gt; \n\t\t\tselect(d | d.supports.source -&gt; isEmpty()) -&gt; size() = 1'"
 * @generated
 */
public interface SafetyCase extends EObject {
  /**
   * Returns the value of the '<em><b>Goals</b></em>' containment reference list.
   * The list contents are of type {@link edu.toronto.cs.se.modelepedia.gsn.Goal}.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the value of the '<em>Goals</em>' containment reference list.
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getSafetyCase_Goals()
   * @model containment="true"
   * @generated
   */
  EList<Goal> getGoals();

  /**
   * Returns the value of the '<em><b>Strategies</b></em>' containment reference list.
   * The list contents are of type {@link edu.toronto.cs.se.modelepedia.gsn.Strategy}.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the value of the '<em>Strategies</em>' containment reference list.
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getSafetyCase_Strategies()
   * @model containment="true"
   * @generated
   */
  EList<Strategy> getStrategies();

  /**
   * Returns the value of the '<em><b>Solutions</b></em>' containment reference list.
   * The list contents are of type {@link edu.toronto.cs.se.modelepedia.gsn.Solution}.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the value of the '<em>Solutions</em>' containment reference list.
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getSafetyCase_Solutions()
   * @model containment="true"
   * @generated
   */
  EList<Solution> getSolutions();

  /**
   * Returns the value of the '<em><b>Contexts</b></em>' containment reference list.
   * The list contents are of type {@link edu.toronto.cs.se.modelepedia.gsn.Context}.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the value of the '<em>Contexts</em>' containment reference list.
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getSafetyCase_Contexts()
   * @model containment="true"
   * @generated
   */
  EList<Context> getContexts();

  /**
   * Returns the value of the '<em><b>Justifications</b></em>' containment reference list.
   * The list contents are of type {@link edu.toronto.cs.se.modelepedia.gsn.Justification}.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the value of the '<em>Justifications</em>' containment reference list.
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getSafetyCase_Justifications()
   * @model containment="true"
   * @generated
   */
  EList<Justification> getJustifications();

  /**
   * Returns the value of the '<em><b>Assumptions</b></em>' containment reference list.
   * The list contents are of type {@link edu.toronto.cs.se.modelepedia.gsn.Assumption}.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the value of the '<em>Assumptions</em>' containment reference list.
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getSafetyCase_Assumptions()
   * @model containment="true"
   * @generated
   */
  EList<Assumption> getAssumptions();

  /**
   * Returns the value of the '<em><b>Connectors</b></em>' containment reference list.
   * The list contents are of type {@link edu.toronto.cs.se.modelepedia.gsn.SupportConnector}.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the value of the '<em>Connectors</em>' containment reference list.
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getSafetyCase_Connectors()
   * @model containment="true"
   * @generated
   */
  EList<SupportConnector> getConnectors();

} // SafetyCase

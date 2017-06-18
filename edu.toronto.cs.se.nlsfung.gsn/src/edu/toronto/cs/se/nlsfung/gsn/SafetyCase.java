/**
 */
package edu.toronto.cs.se.nlsfung.gsn;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Safety Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.SafetyCase#getGoals <em>Goals</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.SafetyCase#getStrategies <em>Strategies</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.SafetyCase#getSolutions <em>Solutions</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.SafetyCase#getContexts <em>Contexts</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.SafetyCase#getASILLevels <em>ASIL Levels</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getSafetyCase()
 * @model
 * @generated
 */
public interface SafetyCase extends EObject {
	/**
	 * Returns the value of the '<em><b>Goals</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.nlsfung.gsn.Goal}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Goals</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Goals</em>' containment reference list.
	 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getSafetyCase_Goals()
	 * @model containment="true"
	 * @generated
	 */
	EList<Goal> getGoals();

	/**
	 * Returns the value of the '<em><b>Strategies</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.nlsfung.gsn.Strategy}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Strategies</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Strategies</em>' containment reference list.
	 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getSafetyCase_Strategies()
	 * @model containment="true"
	 * @generated
	 */
	EList<Strategy> getStrategies();

	/**
	 * Returns the value of the '<em><b>Solutions</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.nlsfung.gsn.Solution}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Solutions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solutions</em>' containment reference list.
	 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getSafetyCase_Solutions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Solution> getSolutions();

	/**
	 * Returns the value of the '<em><b>Contexts</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.nlsfung.gsn.Context}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contexts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contexts</em>' containment reference list.
	 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getSafetyCase_Contexts()
	 * @model containment="true"
	 * @generated
	 */
	EList<Context> getContexts();

	/**
	 * Returns the value of the '<em><b>ASIL Levels</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.nlsfung.gsn.ASIL}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ASIL Levels</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ASIL Levels</em>' containment reference list.
	 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getSafetyCase_ASILLevels()
	 * @model containment="true"
	 * @generated
	 */
	EList<ASIL> getASILLevels();

} // SafetyCase

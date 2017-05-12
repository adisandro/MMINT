/**
 */
package edu.toronto.cs.se.nlsfung.gsn.util;

import edu.toronto.cs.se.nlsfung.gsn.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage
 * @generated
 */
public class GSNAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GSNPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GSNAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = GSNPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GSNSwitch<Adapter> modelSwitch =
		new GSNSwitch<Adapter>() {
			@Override
			public Adapter caseSafetyCase(SafetyCase object) {
				return createSafetyCaseAdapter();
			}
			@Override
			public Adapter caseGsnElement(GsnElement object) {
				return createGsnElementAdapter();
			}
			@Override
			public Adapter caseGoalSupporter(GoalSupporter object) {
				return createGoalSupporterAdapter();
			}
			@Override
			public Adapter caseStrategySupporter(StrategySupporter object) {
				return createStrategySupporterAdapter();
			}
			@Override
			public Adapter caseContextualElement(ContextualElement object) {
				return createContextualElementAdapter();
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
			public Adapter caseASIL(ASIL object) {
				return createASILAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.nlsfung.gsn.SafetyCase <em>Safety Case</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.nlsfung.gsn.SafetyCase
	 * @generated
	 */
	public Adapter createSafetyCaseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.nlsfung.gsn.GsnElement <em>Gsn Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.nlsfung.gsn.GsnElement
	 * @generated
	 */
	public Adapter createGsnElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.nlsfung.gsn.GoalSupporter <em>Goal Supporter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.nlsfung.gsn.GoalSupporter
	 * @generated
	 */
	public Adapter createGoalSupporterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.nlsfung.gsn.StrategySupporter <em>Strategy Supporter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.nlsfung.gsn.StrategySupporter
	 * @generated
	 */
	public Adapter createStrategySupporterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.nlsfung.gsn.ContextualElement <em>Contextual Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.nlsfung.gsn.ContextualElement
	 * @generated
	 */
	public Adapter createContextualElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.nlsfung.gsn.Goal <em>Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.nlsfung.gsn.Goal
	 * @generated
	 */
	public Adapter createGoalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.nlsfung.gsn.Strategy <em>Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.nlsfung.gsn.Strategy
	 * @generated
	 */
	public Adapter createStrategyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.nlsfung.gsn.Solution <em>Solution</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.nlsfung.gsn.Solution
	 * @generated
	 */
	public Adapter createSolutionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.nlsfung.gsn.Context <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.nlsfung.gsn.Context
	 * @generated
	 */
	public Adapter createContextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.nlsfung.gsn.ASIL <em>ASIL</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.nlsfung.gsn.ASIL
	 * @generated
	 */
	public Adapter createASILAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //GSNAdapterFactory

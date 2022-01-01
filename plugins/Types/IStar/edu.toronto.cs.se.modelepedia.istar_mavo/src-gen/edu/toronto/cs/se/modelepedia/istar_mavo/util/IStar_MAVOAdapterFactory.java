/**
 * Copyright (c) 2012-2022 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.istar_mavo.util;

import edu.toronto.cs.se.mavo.LogicElement;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mavo.MAVORoot;
import edu.toronto.cs.se.modelepedia.istar_mavo.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage
 * @generated
 */
public class IStar_MAVOAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static IStar_MAVOPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IStar_MAVOAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = IStar_MAVOPackage.eINSTANCE;
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
	protected IStar_MAVOSwitch<Adapter> modelSwitch =
		new IStar_MAVOSwitch<Adapter>() {
			@Override
			public Adapter caseIStar(IStar object) {
				return createIStarAdapter();
			}
			@Override
			public Adapter caseActor(Actor object) {
				return createActorAdapter();
			}
			@Override
			public Adapter caseIntention(Intention object) {
				return createIntentionAdapter();
			}
			@Override
			public Adapter caseTask(Task object) {
				return createTaskAdapter();
			}
			@Override
			public Adapter caseResource(Resource object) {
				return createResourceAdapter();
			}
			@Override
			public Adapter caseGoal(Goal object) {
				return createGoalAdapter();
			}
			@Override
			public Adapter caseSoftGoal(SoftGoal object) {
				return createSoftGoalAdapter();
			}
			@Override
			public Adapter caseDependencyEndpoint(DependencyEndpoint object) {
				return createDependencyEndpointAdapter();
			}
			@Override
			public Adapter caseIntentionLink(IntentionLink object) {
				return createIntentionLinkAdapter();
			}
			@Override
			public Adapter caseMeansEnd(MeansEnd object) {
				return createMeansEndAdapter();
			}
			@Override
			public Adapter caseDecomposition(Decomposition object) {
				return createDecompositionAdapter();
			}
			@Override
			public Adapter caseContribution(Contribution object) {
				return createContributionAdapter();
			}
			@Override
			public Adapter caseDependerLink(DependerLink object) {
				return createDependerLinkAdapter();
			}
			@Override
			public Adapter caseDependeeLink(DependeeLink object) {
				return createDependeeLinkAdapter();
			}
			@Override
			public Adapter caseMAVORoot(MAVORoot object) {
				return createMAVORootAdapter();
			}
			@Override
			public Adapter caseLogicElement(LogicElement object) {
				return createLogicElementAdapter();
			}
			@Override
			public Adapter caseMAVOElement(MAVOElement object) {
				return createMAVOElementAdapter();
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
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.istar_mavo.IStar <em>IStar</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IStar
	 * @generated
	 */
	public Adapter createIStarAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Actor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.Actor
	 * @generated
	 */
	public Adapter createActorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Intention <em>Intention</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.Intention
	 * @generated
	 */
	public Adapter createIntentionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Task <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.Task
	 * @generated
	 */
	public Adapter createTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.Resource
	 * @generated
	 */
	public Adapter createResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Goal <em>Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.Goal
	 * @generated
	 */
	public Adapter createGoalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.istar_mavo.SoftGoal <em>Soft Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.SoftGoal
	 * @generated
	 */
	public Adapter createSoftGoalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.istar_mavo.DependencyEndpoint <em>Dependency Endpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.DependencyEndpoint
	 * @generated
	 */
	public Adapter createDependencyEndpointAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.istar_mavo.IntentionLink <em>Intention Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IntentionLink
	 * @generated
	 */
	public Adapter createIntentionLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.istar_mavo.MeansEnd <em>Means End</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.MeansEnd
	 * @generated
	 */
	public Adapter createMeansEndAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Decomposition <em>Decomposition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.Decomposition
	 * @generated
	 */
	public Adapter createDecompositionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Contribution <em>Contribution</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.Contribution
	 * @generated
	 */
	public Adapter createContributionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.istar_mavo.DependerLink <em>Depender Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.DependerLink
	 * @generated
	 */
	public Adapter createDependerLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.istar_mavo.DependeeLink <em>Dependee Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.DependeeLink
	 * @generated
	 */
	public Adapter createDependeeLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mavo.MAVORoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.mavo.MAVORoot
	 * @generated
	 */
	public Adapter createMAVORootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mavo.LogicElement <em>Logic Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.mavo.LogicElement
	 * @generated
	 */
	public Adapter createLogicElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mavo.MAVOElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.mavo.MAVOElement
	 * @generated
	 */
	public Adapter createMAVOElementAdapter() {
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

} //IStar_MAVOAdapterFactory

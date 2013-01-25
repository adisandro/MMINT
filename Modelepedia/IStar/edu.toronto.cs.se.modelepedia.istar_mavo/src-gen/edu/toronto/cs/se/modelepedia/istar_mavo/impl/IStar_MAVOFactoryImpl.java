/**
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro, Vivien Suen - Implementation.
 */
package edu.toronto.cs.se.modelepedia.istar_mavo.impl;

import edu.toronto.cs.se.modelepedia.istar_mavo.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class IStar_MAVOFactoryImpl extends EFactoryImpl implements IStar_MAVOFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IStar_MAVOFactory init() {
		try {
			IStar_MAVOFactory theIStar_MAVOFactory = (IStar_MAVOFactory)EPackage.Registry.INSTANCE.getEFactory("http://se.cs.toronto.edu/modelepedia/IStar_MAVO"); 
			if (theIStar_MAVOFactory != null) {
				return theIStar_MAVOFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new IStar_MAVOFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IStar_MAVOFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case IStar_MAVOPackage.ISTAR: return createIStar();
			case IStar_MAVOPackage.ACTOR: return createActor();
			case IStar_MAVOPackage.DEPENDENCY: return createDependency();
			case IStar_MAVOPackage.TASK: return createTask();
			case IStar_MAVOPackage.RESOURCE: return createResource();
			case IStar_MAVOPackage.GOAL: return createGoal();
			case IStar_MAVOPackage.SOFT_GOAL: return createSoftGoal();
			case IStar_MAVOPackage.CONTRIBUTION: return createContribution();
			case IStar_MAVOPackage.END_REFERENCE: return createEndReference();
			case IStar_MAVOPackage.COMPONENTS_REFERENCE: return createComponentsReference();
			case IStar_MAVOPackage.DEPENDER_REFERENCE: return createDependerReference();
			case IStar_MAVOPackage.DEPENDEE_REFERENCE: return createDependeeReference();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IStar createIStar() {
		IStarImpl iStar = new IStarImpl();
		return iStar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Actor createActor() {
		ActorImpl actor = new ActorImpl();
		return actor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dependency createDependency() {
		DependencyImpl dependency = new DependencyImpl();
		return dependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Task createTask() {
		TaskImpl task = new TaskImpl();
		return task;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource createResource() {
		ResourceImpl resource = new ResourceImpl();
		return resource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Goal createGoal() {
		GoalImpl goal = new GoalImpl();
		return goal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SoftGoal createSoftGoal() {
		SoftGoalImpl softGoal = new SoftGoalImpl();
		return softGoal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Contribution createContribution() {
		ContributionImpl contribution = new ContributionImpl();
		return contribution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndReference createEndReference() {
		EndReferenceImpl endReference = new EndReferenceImpl();
		return endReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentsReference createComponentsReference() {
		ComponentsReferenceImpl componentsReference = new ComponentsReferenceImpl();
		return componentsReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependerReference createDependerReference() {
		DependerReferenceImpl dependerReference = new DependerReferenceImpl();
		return dependerReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependeeReference createDependeeReference() {
		DependeeReferenceImpl dependeeReference = new DependeeReferenceImpl();
		return dependeeReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IStar_MAVOPackage getIStar_MAVOPackage() {
		return (IStar_MAVOPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static IStar_MAVOPackage getPackage() {
		return IStar_MAVOPackage.eINSTANCE;
	}

} //IStar_MAVOFactoryImpl

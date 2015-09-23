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
package edu.toronto.cs.se.modelepedia.kleisli.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import edu.toronto.cs.se.mavo.LogicElement;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mavo.MAVOModel;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliBinaryModelRel;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModel;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpointReference;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliPackage
 * @generated
 */
public class KleisliAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static KleisliPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KleisliAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = KleisliPackage.eINSTANCE;
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
	protected KleisliSwitch<Adapter> modelSwitch =
		new KleisliSwitch<Adapter>() {
			@Override
			public Adapter caseKleisliModel(KleisliModel object) {
				return createKleisliModelAdapter();
			}
			@Override
			public Adapter caseKleisliModelEndpoint(KleisliModelEndpoint object) {
				return createKleisliModelEndpointAdapter();
			}
			@Override
			public Adapter caseKleisliModelRel(KleisliModelRel object) {
				return createKleisliModelRelAdapter();
			}
			@Override
			public Adapter caseKleisliBinaryModelRel(KleisliBinaryModelRel object) {
				return createKleisliBinaryModelRelAdapter();
			}
			@Override
			public Adapter caseKleisliModelEndpointReference(KleisliModelEndpointReference object) {
				return createKleisliModelEndpointReferenceAdapter();
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
			public Adapter caseExtendibleElement(ExtendibleElement object) {
				return createExtendibleElementAdapter();
			}
			@Override
			public Adapter caseGenericElement(GenericElement object) {
				return createGenericElementAdapter();
			}
			@Override
			public Adapter caseMAVOModel(MAVOModel object) {
				return createMAVOModelAdapter();
			}
			@Override
			public Adapter caseModel(Model object) {
				return createModelAdapter();
			}
			@Override
			public Adapter caseExtendibleElementEndpoint(ExtendibleElementEndpoint object) {
				return createExtendibleElementEndpointAdapter();
			}
			@Override
			public Adapter caseModelEndpoint(ModelEndpoint object) {
				return createModelEndpointAdapter();
			}
			@Override
			public Adapter caseModelRel(ModelRel object) {
				return createModelRelAdapter();
			}
			@Override
			public Adapter caseBinaryModelRel(BinaryModelRel object) {
				return createBinaryModelRelAdapter();
			}
			@Override
			public Adapter caseExtendibleElementReference(ExtendibleElementReference object) {
				return createExtendibleElementReferenceAdapter();
			}
			@Override
			public Adapter caseExtendibleElementEndpointReference(ExtendibleElementEndpointReference object) {
				return createExtendibleElementEndpointReferenceAdapter();
			}
			@Override
			public Adapter caseModelEndpointReference(ModelEndpointReference object) {
				return createModelEndpointReferenceAdapter();
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
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModel
	 * @generated
	 */
	public Adapter createKleisliModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel <em>Model Rel</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel
	 * @generated
	 */
	public Adapter createKleisliModelRelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint <em>Model Endpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint
	 * @generated
	 */
	public Adapter createKleisliModelEndpointAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliBinaryModelRel <em>Binary Model Rel</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliBinaryModelRel
	 * @generated
	 */
	public Adapter createKleisliBinaryModelRelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpointReference <em>Model Endpoint Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpointReference
	 * @generated
	 */
	public Adapter createKleisliModelEndpointReferenceAdapter() {
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
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElement <em>Extendible Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.mmint.mid.ExtendibleElement
	 * @generated
	 */
	public Adapter createExtendibleElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.mid.GenericElement <em>Generic Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.mmint.mid.GenericElement
	 * @generated
	 */
	public Adapter createGenericElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mavo.MAVOModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.mavo.MAVOModel
	 * @generated
	 */
	public Adapter createMAVOModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.mid.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.mmint.mid.Model
	 * @generated
	 */
	public Adapter createModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelRel <em>Model Rel</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelRel
	 * @generated
	 */
	public Adapter createModelRelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint <em>Extendible Element Endpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint
	 * @generated
	 */
	public Adapter createExtendibleElementEndpointAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.mid.ModelEndpoint <em>Model Endpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.mmint.mid.ModelEndpoint
	 * @generated
	 */
	public Adapter createModelEndpointAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel <em>Binary Model Rel</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel
	 * @generated
	 */
	public Adapter createBinaryModelRelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference <em>Extendible Element Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference
	 * @generated
	 */
	public Adapter createExtendibleElementReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementEndpointReference <em>Extendible Element Endpoint Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementEndpointReference
	 * @generated
	 */
	public Adapter createExtendibleElementEndpointReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference <em>Model Endpoint Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference
	 * @generated
	 */
	public Adapter createModelEndpointReferenceAdapter() {
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

} //KleisliAdapterFactory

/**
 * Copyright (c) 2012-2021 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mavo.mavomid.util;

import edu.toronto.cs.se.mavo.LogicElement;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mavo.MAVORoot;

import edu.toronto.cs.se.mmint.mavo.mavomid.*;

import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;

import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMapping;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMIDPackage
 * @generated
 */
public class MAVOMIDAdapterFactory extends AdapterFactoryImpl {
	/**
   * The cached model package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected static MAVOMIDPackage modelPackage;

	/**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public MAVOMIDAdapterFactory() {
    if (modelPackage == null) {
      modelPackage = MAVOMIDPackage.eINSTANCE;
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
	protected MAVOMIDSwitch<Adapter> modelSwitch =
		new MAVOMIDSwitch<Adapter>() {
      @Override
      public Adapter caseMAVOModel(MAVOModel object) {
        return createMAVOModelAdapter();
      }
      @Override
      public Adapter caseMAVOModelElement(MAVOModelElement object) {
        return createMAVOModelElementAdapter();
      }
      @Override
      public Adapter caseMAVOModelRel(MAVOModelRel object) {
        return createMAVOModelRelAdapter();
      }
      @Override
      public Adapter caseBinaryMAVOModelRel(BinaryMAVOModelRel object) {
        return createBinaryMAVOModelRelAdapter();
      }
      @Override
      public Adapter caseMAVOModelEndpoint(MAVOModelEndpoint object) {
        return createMAVOModelEndpointAdapter();
      }
      @Override
      public Adapter caseMAVOMapping(MAVOMapping object) {
        return createMAVOMappingAdapter();
      }
      @Override
      public Adapter caseBinaryMAVOMapping(BinaryMAVOMapping object) {
        return createBinaryMAVOMappingAdapter();
      }
      @Override
      public Adapter caseMAVOModelElementReference(MAVOModelElementReference object) {
        return createMAVOModelElementReferenceAdapter();
      }
      @Override
      public Adapter caseMAVOModelEndpointReference(MAVOModelEndpointReference object) {
        return createMAVOModelEndpointReferenceAdapter();
      }
      @Override
      public Adapter caseMAVOMappingReference(MAVOMappingReference object) {
        return createMAVOMappingReferenceAdapter();
      }
      @Override
      public Adapter caseBinaryMAVOMappingReference(BinaryMAVOMappingReference object) {
        return createBinaryMAVOMappingReferenceAdapter();
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
      public Adapter caseModel(Model object) {
        return createModelAdapter();
      }
      @Override
      public Adapter caseMAVORoot(MAVORoot object) {
        return createMAVORootAdapter();
      }
      @Override
      public Adapter caseModelElement(ModelElement object) {
        return createModelElementAdapter();
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
      public Adapter caseModelRel(ModelRel object) {
        return createModelRelAdapter();
      }
      @Override
      public Adapter caseBinaryModelRel(BinaryModelRel object) {
        return createBinaryModelRelAdapter();
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
      public Adapter caseMapping(Mapping object) {
        return createMappingAdapter();
      }
      @Override
      public Adapter caseBinaryMapping(BinaryMapping object) {
        return createBinaryMappingAdapter();
      }
      @Override
      public Adapter caseExtendibleElementReference(ExtendibleElementReference object) {
        return createExtendibleElementReferenceAdapter();
      }
      @Override
      public Adapter caseModelElementReference(ModelElementReference object) {
        return createModelElementReferenceAdapter();
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
      public Adapter caseMappingReference(MappingReference object) {
        return createMappingReferenceAdapter();
      }
      @Override
      public Adapter caseBinaryMappingReference(BinaryMappingReference object) {
        return createBinaryMappingReferenceAdapter();
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
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModel <em>MAVO Model</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModel
   * @generated
   */
	public Adapter createMAVOModelAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelElement <em>MAVO Model Element</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelElement
   * @generated
   */
	public Adapter createMAVOModelElementAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelRel <em>MAVO Model Rel</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelRel
   * @generated
   */
	public Adapter createMAVOModelRelAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.mavo.mavomid.BinaryMAVOModelRel <em>Binary MAVO Model Rel</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.BinaryMAVOModelRel
   * @generated
   */
	public Adapter createBinaryMAVOModelRelAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelEndpoint <em>MAVO Model Endpoint</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelEndpoint
   * @generated
   */
	public Adapter createMAVOModelEndpointAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelEndpointReference <em>MAVO Model Endpoint Reference</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelEndpointReference
   * @generated
   */
	public Adapter createMAVOModelEndpointReferenceAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMappingReference <em>MAVO Mapping Reference</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMappingReference
   * @generated
   */
	public Adapter createMAVOMappingReferenceAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.mavo.mavomid.BinaryMAVOMappingReference <em>Binary MAVO Mapping Reference</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.BinaryMAVOMappingReference
   * @generated
   */
	public Adapter createBinaryMAVOMappingReferenceAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMapping <em>MAVO Mapping</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMapping
   * @generated
   */
	public Adapter createMAVOMappingAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.mavo.mavomid.BinaryMAVOMapping <em>Binary MAVO Mapping</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.BinaryMAVOMapping
   * @generated
   */
	public Adapter createBinaryMAVOMappingAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelElementReference <em>MAVO Model Element Reference</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelElementReference
   * @generated
   */
	public Adapter createMAVOModelElementReferenceAdapter() {
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
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference <em>Model Element Reference</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference
   * @generated
   */
	public Adapter createModelElementReferenceAdapter() {
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
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.mid.relationship.MappingReference <em>Mapping Reference</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint.mid.relationship.MappingReference
   * @generated
   */
	public Adapter createMappingReferenceAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference <em>Binary Mapping Reference</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference
   * @generated
   */
	public Adapter createBinaryMappingReferenceAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.mid.relationship.Mapping <em>Mapping</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint.mid.relationship.Mapping
   * @generated
   */
	public Adapter createMappingAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.mid.relationship.BinaryMapping <em>Binary Mapping</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint.mid.relationship.BinaryMapping
   * @generated
   */
	public Adapter createBinaryMappingAdapter() {
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
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.mid.ModelElement <em>Model Element</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint.mid.ModelElement
   * @generated
   */
	public Adapter createModelElementAdapter() {
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

} //MAVOMIDAdapterFactory

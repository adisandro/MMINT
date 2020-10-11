/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.relationship.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.relationship.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage
 * @generated
 */
public class RelationshipAdapterFactory extends AdapterFactoryImpl {
    /**
   * The cached model package.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    protected static RelationshipPackage modelPackage;

    /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public RelationshipAdapterFactory() {
    if (modelPackage == null) {
      modelPackage = RelationshipPackage.eINSTANCE;
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
    protected RelationshipSwitch<Adapter> modelSwitch =
        new RelationshipSwitch<Adapter>() {
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
      public Adapter caseModelElementReference(ModelElementReference object) {
        return createModelElementReferenceAdapter();
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
      public Adapter caseModelElementEndpoint(ModelElementEndpoint object) {
        return createModelElementEndpointAdapter();
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
      public Adapter caseModelElementEndpointReference(ModelElementEndpointReference object) {
        return createModelElementEndpointReferenceAdapter();
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
      public Adapter caseExtendibleElementEndpoint(ExtendibleElementEndpoint object) {
        return createExtendibleElementEndpointAdapter();
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
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint <em>Model Element Endpoint</em>}'.
   * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint
   * @generated
   */
    public Adapter createModelElementEndpointAdapter() {
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
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference <em>Model Element Endpoint Reference</em>}'.
   * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference
   * @generated
   */
    public Adapter createModelElementEndpointReferenceAdapter() {
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

} //RelationshipAdapterFactory

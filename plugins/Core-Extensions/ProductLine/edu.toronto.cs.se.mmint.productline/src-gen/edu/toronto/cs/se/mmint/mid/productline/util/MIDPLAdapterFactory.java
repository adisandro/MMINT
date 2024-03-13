/*******************************************************************************
 * Copyright (c) 2021, 2024 Alessio Di Sandro.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.mmint.mid.productline.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.productline.MIDPLPackage;
import edu.toronto.cs.se.mmint.mid.productline.PLBinaryMapping;
import edu.toronto.cs.se.mmint.mid.productline.PLBinaryMappingReference;
import edu.toronto.cs.se.mmint.mid.productline.PLBinaryModelRel;
import edu.toronto.cs.se.mmint.mid.productline.PLMapping;
import edu.toronto.cs.se.mmint.mid.productline.PLMappingReference;
import edu.toronto.cs.se.mmint.mid.productline.PLModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMapping;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.productline.PLElement;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.mmint.mid.productline.MIDPLPackage
 * @generated
 */
public class MIDPLAdapterFactory extends AdapterFactoryImpl {
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static MIDPLPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MIDPLAdapterFactory() {
    if (MIDPLAdapterFactory.modelPackage == null) {
      MIDPLAdapterFactory.modelPackage = MIDPLPackage.eINSTANCE;
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
    if (object == MIDPLAdapterFactory.modelPackage) {
      return true;
    }
    if (object instanceof EObject) {
      return ((EObject) object).eClass().getEPackage() == MIDPLAdapterFactory.modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MIDPLSwitch<Adapter> modelSwitch = new MIDPLSwitch<>() {
    @Override
    public Adapter casePLModelRel(PLModelRel object) {
      return createPLModelRelAdapter();
    }

    @Override
    public Adapter casePLBinaryModelRel(PLBinaryModelRel object) {
      return createPLBinaryModelRelAdapter();
    }

    @Override
    public Adapter casePLMapping(PLMapping object) {
      return createPLMappingAdapter();
    }

    @Override
    public Adapter casePLBinaryMapping(PLBinaryMapping object) {
      return createPLBinaryMappingAdapter();
    }

    @Override
    public Adapter casePLMappingReference(PLMappingReference object) {
      return createPLMappingReferenceAdapter();
    }

    @Override
    public Adapter casePLBinaryMappingReference(PLBinaryMappingReference object) {
      return createPLBinaryMappingReferenceAdapter();
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
    public Adapter caseModelRel(ModelRel object) {
      return createModelRelAdapter();
    }

    @Override
    public Adapter caseBinaryModelRel(BinaryModelRel object) {
      return createBinaryModelRelAdapter();
    }

    @Override
    public Adapter caseMapping(Mapping object) {
      return createMappingAdapter();
    }

    @Override
    public Adapter casePLElement(PLElement object) {
      return createPLElementAdapter();
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
    return this.modelSwitch.doSwitch((EObject) target);
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.mid.productline.PLModelRel <em>PL Model Rel</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint.mid.productline.PLModelRel
   * @generated
   */
  public Adapter createPLModelRelAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.mid.productline.PLBinaryModelRel <em>PL Binary Model Rel</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint.mid.productline.PLBinaryModelRel
   * @generated
   */
  public Adapter createPLBinaryModelRelAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.mid.productline.PLMapping <em>PL Mapping</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint.mid.productline.PLMapping
   * @generated
   */
  public Adapter createPLMappingAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.mid.productline.PLBinaryMapping <em>PL Binary Mapping</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint.mid.productline.PLBinaryMapping
   * @generated
   */
  public Adapter createPLBinaryMappingAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.mid.productline.PLMappingReference <em>PL Mapping Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint.mid.productline.PLMappingReference
   * @generated
   */
  public Adapter createPLMappingReferenceAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.mid.productline.PLBinaryMappingReference <em>PL Binary Mapping Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint.mid.productline.PLBinaryMappingReference
   * @generated
   */
  public Adapter createPLBinaryMappingReferenceAdapter() {
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
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.productline.PLElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint.productline.PLElement
   * @generated
   */
  public Adapter createPLElementAdapter() {
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

} //MIDPLAdapterFactory

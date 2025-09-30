/*******************************************************************************
 * Copyright (c) 2021, 2025 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.papyrus.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.papyrus.PapyrusPackage;
import edu.toronto.cs.se.mmint.papyrus.UMLModel;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter <code>createXXX</code>
 * method for each class of the model. <!-- end-user-doc -->
 *
 * @see edu.toronto.cs.se.mmint.papyrus.PapyrusPackage
 * @generated
 */
public class PapyrusAdapterFactory extends AdapterFactoryImpl {
  /**
   * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected static PapyrusPackage modelPackage;

  /**
   * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public PapyrusAdapterFactory() {
    if (PapyrusAdapterFactory.modelPackage == null) {
      PapyrusAdapterFactory.modelPackage = PapyrusPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object. <!-- begin-user-doc --> This implementation
   * returns <code>true</code> if the object is either the model's package or is an instance object of the model. <!--
   * end-user-doc -->
   *
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object) {
    if (object == PapyrusAdapterFactory.modelPackage) {
      return true;
    }
    if (object instanceof EObject) {
      return ((EObject) object).eClass().getEPackage() == PapyrusAdapterFactory.modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected PapyrusSwitch<Adapter> modelSwitch = new PapyrusSwitch<>() {
    @Override
    public Adapter caseUMLModel(UMLModel object) {
      return createUMLModelAdapter();
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
    public Adapter defaultCase(EObject object) {
      return createEObjectAdapter();
    }
  };

  /**
   * Creates an adapter for the <code>target</code>. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @param target
   *          the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target) {
    return this.modelSwitch.doSwitch((EObject) target);
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.papyrus.UMLModel <em>UML Model</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint.papyrus.UMLModel
   * @generated
   */
  public Adapter createUMLModelAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElement <em>Extendible
   * Element</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
   * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint.mid.ExtendibleElement
   * @generated
   */
  public Adapter createExtendibleElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.mid.GenericElement <em>Generic
   * Element</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
   * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint.mid.GenericElement
   * @generated
   */
  public Adapter createGenericElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.mid.Model <em>Model</em>}'. <!--
   * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint.mid.Model
   * @generated
   */
  public Adapter createModelAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for the default case. <!-- begin-user-doc --> This default implementation returns null. <!--
   * end-user-doc -->
   *
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter() {
    return null;
  }

} // PapyrusAdapterFactory

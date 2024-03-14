/*******************************************************************************
 * Copyright (c) 2024, 2024 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.types.gsn.productline.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.productline.PLElement;
import edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLArgumentElement;
import edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLPackage;
import edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLTemplate;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLPackage
 * @generated
 */
public class GSNPLAdapterFactory extends AdapterFactoryImpl {
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static GSNPLPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GSNPLAdapterFactory() {
    if (GSNPLAdapterFactory.modelPackage == null) {
      GSNPLAdapterFactory.modelPackage = GSNPLPackage.eINSTANCE;
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
    if (object == GSNPLAdapterFactory.modelPackage) {
      return true;
    }
    if (object instanceof EObject) {
      return ((EObject)object).eClass().getEPackage() == GSNPLAdapterFactory.modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GSNPLSwitch<Adapter> modelSwitch =
    new GSNPLSwitch<>() {
      @Override
      public Adapter caseGSNPLArgumentElement(GSNPLArgumentElement object) {
        return createGSNPLArgumentElementAdapter();
      }
      @Override
      public Adapter caseGSNPLTemplate(GSNPLTemplate object) {
        return createGSNPLTemplateAdapter();
      }
      @Override
      public Adapter casePLElement(PLElement object) {
        return createPLElementAdapter();
      }
      @Override
      public Adapter caseClass(edu.toronto.cs.se.mmint.productline.Class object) {
        return createClassAdapter();
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
    return this.modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLArgumentElement <em>Argument Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLArgumentElement
   * @generated
   */
  public Adapter createGSNPLArgumentElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLTemplate <em>Template</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLTemplate
   * @generated
   */
  public Adapter createGSNPLTemplateAdapter() {
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
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint.productline.Class <em>Class</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint.productline.Class
   * @generated
   */
  public Adapter createClassAdapter() {
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

} //GSNPLAdapterFactory

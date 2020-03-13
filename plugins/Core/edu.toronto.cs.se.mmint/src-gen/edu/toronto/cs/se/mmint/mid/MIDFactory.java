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
package edu.toronto.cs.se.mmint.mid;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.mmint.mid.MIDPackage
 * @generated
 */
public interface MIDFactory extends EFactory {
    /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    MIDFactory eINSTANCE = edu.toronto.cs.se.mmint.mid.impl.MIDFactoryImpl.init();

    /**
   * Returns a new object of class '<em>MID</em>'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return a new object of class '<em>MID</em>'.
   * @generated
   */
    MID createMID();

    /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
    Model createModel();

    /**
   * Returns a new object of class '<em>Extendible Element Constraint</em>'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return a new object of class '<em>Extendible Element Constraint</em>'.
   * @generated
   */
    ExtendibleElementConstraint createExtendibleElementConstraint();

    /**
   * Returns a new object of class '<em>Model Element</em>'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return a new object of class '<em>Model Element</em>'.
   * @generated
   */
    ModelElement createModelElement();

    /**
   * Returns a new object of class '<em>Model Endpoint</em>'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return a new object of class '<em>Model Endpoint</em>'.
   * @generated
   */
    ModelEndpoint createModelEndpoint();

    /**
   * Returns a new object of class '<em>EMF Info</em>'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return a new object of class '<em>EMF Info</em>'.
   * @generated
   */
    EMFInfo createEMFInfo();

    /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
    MIDPackage getMIDPackage();

} //MIDFactory

/**
 * Copyright (c) 2012-2025 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extendible Element Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A constraint for an extendible element.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint#getLanguage <em>Language</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.mid.MIDPackage#getExtendibleElementConstraint()
 * @model
 * @generated
 */
public interface ExtendibleElementConstraint extends EObject {
    /**
   * Returns the value of the '<em><b>Implementation</b></em>' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The constraint implementation.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Implementation</em>' attribute.
   * @see #setImplementation(String)
   * @see edu.toronto.cs.se.mmint.mid.MIDPackage#getExtendibleElementConstraint_Implementation()
   * @model required="true"
   * @generated
   */
    String getImplementation();

    /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint#getImplementation <em>Implementation</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Implementation</em>' attribute.
   * @see #getImplementation()
   * @generated
   */
    void setImplementation(String value);

    /**
   * Returns the value of the '<em><b>Language</b></em>' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The constraint language.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Language</em>' attribute.
   * @see #setLanguage(String)
   * @see edu.toronto.cs.se.mmint.mid.MIDPackage#getExtendibleElementConstraint_Language()
   * @model required="true"
   * @generated
   */
    String getLanguage();

    /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint#getLanguage <em>Language</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Language</em>' attribute.
   * @see #getLanguage()
   * @generated
   */
    void setLanguage(String value);

} // ExtendibleElementConstraint

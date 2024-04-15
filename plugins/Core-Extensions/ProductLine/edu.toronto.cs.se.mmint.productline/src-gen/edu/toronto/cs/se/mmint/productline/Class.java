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
package edu.toronto.cs.se.mmint.productline;

import java.util.stream.Stream;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.Class#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.Class#getReferences <em>References</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.Class#getReferencesAsTarget <em>References As Target</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.Class#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.productline.PLPackage#getClass_()
 * @model
 * @generated
 */
public interface Class extends PLElement {
  /**
   * Returns the value of the '<em><b>References As Target</b></em>' reference list.
   * The list contents are of type {@link edu.toronto.cs.se.mmint.productline.Reference}.
   * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.mmint.productline.Reference#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>References As Target</em>' reference list.
   * @see edu.toronto.cs.se.mmint.productline.PLPackage#getClass_ReferencesAsTarget()
   * @see edu.toronto.cs.se.mmint.productline.Reference#getTarget
   * @model opposite="target"
   * @generated
   */
  EList<Reference> getReferencesAsTarget();

  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
   * The list contents are of type {@link edu.toronto.cs.se.mmint.productline.Attribute}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see edu.toronto.cs.se.mmint.productline.PLPackage#getClass_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<Attribute> getAttributes();

  /**
   * Returns the value of the '<em><b>References</b></em>' containment reference list.
   * The list contents are of type {@link edu.toronto.cs.se.mmint.productline.Reference}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>References</em>' containment reference list.
   * @see edu.toronto.cs.se.mmint.productline.PLPackage#getClass_References()
   * @model containment="true"
   * @generated
   */
  EList<Reference> getReferences();

  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(EClass)
   * @see edu.toronto.cs.se.mmint.productline.PLPackage#getClass_Type()
   * @model required="true"
   * @generated
   */
  EClass getType();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.productline.Class#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(EClass value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model dataType="edu.toronto.cs.se.mmint.productline.Stream&lt;edu.toronto.cs.se.mmint.productline.Class&gt;" required="true" referenceTypeRequired="true"
   * @generated
   */
  Stream<Class> getStreamOfReference(EReference referenceType);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model referenceTypeRequired="true"
   * @generated
   */
  EList<Class> getReference(EReference referenceType);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model required="true" referenceTypeRequired="true" tgtClassRequired="true"
   * @generated
   */
  Reference addReference(EReference referenceType, Class tgtClass);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model referenceTypeRequired="true" tgtClassRequired="true"
   * @generated
   */
  void setReference(EReference referenceType, Class tgtClass);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model dataType="edu.toronto.cs.se.mmint.productline.Stream&lt;edu.toronto.cs.se.mmint.productline.Class&gt;" required="true" referenceTypeRequired="true"
   * @generated
   */
  Stream<Class> getStreamOfReferenceAsTarget(EReference referenceType);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model referenceTypeRequired="true"
   * @generated
   */
  EList<Class> getReferenceAsTarget(EReference referenceType);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model dataType="edu.toronto.cs.se.mmint.productline.Stream&lt;org.eclipse.emf.ecore.EString&gt;" required="true" attributeTypeRequired="true"
   * @generated
   */
  Stream<String> getStreamOfAttribute(EAttribute attributeType);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model attributeTypeRequired="true"
   * @generated
   */
  EList<String> getAttribute(EAttribute attributeType);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model required="true" attributeTypeRequired="true"
   * @generated
   */
  Attribute addAttribute(EAttribute attributeType);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model attributeTypeRequired="true" valueRequired="true"
   * @generated
   */
  void setAttribute(EAttribute attributeType, String value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model required="true" typeRequired="true"
   * @generated
   */
  boolean instanceOf(EClass type);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   * @generated
   */
  Class getEContainer();

} // Class

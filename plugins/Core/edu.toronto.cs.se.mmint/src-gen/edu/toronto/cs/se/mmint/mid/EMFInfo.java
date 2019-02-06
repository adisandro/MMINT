/**
 * Copyright (c) 2012-2019 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
 * A representation of the model object '<em><b>EMF Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A selection of EMF information related to a model element, to avoid accessing the EObject every time they are needed.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.EMFInfo#getClassName <em>Class Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.EMFInfo#getFeatureName <em>Feature Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.EMFInfo#isAttribute <em>Attribute</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.EMFInfo#getRelatedClassName <em>Related Class Name</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.mid.MIDPackage#getEMFInfo()
 * @model
 * @generated
 */
public interface EMFInfo extends EObject {
    /**
   * Returns the value of the '<em><b>Class Name</b></em>' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The EClass name (types: metamodel class; instances: metamodel class)
   * <!-- end-model-doc -->
   * @return the value of the '<em>Class Name</em>' attribute.
   * @see #setClassName(String)
   * @see edu.toronto.cs.se.mmint.mid.MIDPackage#getEMFInfo_ClassName()
   * @model required="true"
   * @generated
   */
    String getClassName();

    /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.EMFInfo#getClassName <em>Class Name</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Class Name</em>' attribute.
   * @see #getClassName()
   * @generated
   */
    void setClassName(String value);

    /**
   * Returns the value of the '<em><b>Feature Name</b></em>' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The EStructuralFeature name, if applicable (types: metamodel feature; instances: metamodel feature)
   * <!-- end-model-doc -->
   * @return the value of the '<em>Feature Name</em>' attribute.
   * @see #setFeatureName(String)
   * @see edu.toronto.cs.se.mmint.mid.MIDPackage#getEMFInfo_FeatureName()
   * @model
   * @generated
   */
    String getFeatureName();

    /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.EMFInfo#getFeatureName <em>Feature Name</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Feature Name</em>' attribute.
   * @see #getFeatureName()
   * @generated
   */
    void setFeatureName(String value);

    /**
   * Returns the value of the '<em><b>Attribute</b></em>' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * If applicable, true if the EStructuralFeature is an EAttribute, false otherwise (types: metamodel feature; instances: metamodel feature)
   * <!-- end-model-doc -->
   * @return the value of the '<em>Attribute</em>' attribute.
   * @see #setAttribute(boolean)
   * @see edu.toronto.cs.se.mmint.mid.MIDPackage#getEMFInfo_Attribute()
   * @model
   * @generated
   */
    boolean isAttribute();

    /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.EMFInfo#isAttribute <em>Attribute</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Attribute</em>' attribute.
   * @see #isAttribute()
   * @generated
   */
    void setAttribute(boolean value);

    /**
   * Returns the value of the '<em><b>Related Class Name</b></em>' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The related EClass name, if applicable (types: metamodel class of the type if reference; instances: metamodel class of the container if not root and not attribute)
   * <!-- end-model-doc -->
   * @return the value of the '<em>Related Class Name</em>' attribute.
   * @see #setRelatedClassName(String)
   * @see edu.toronto.cs.se.mmint.mid.MIDPackage#getEMFInfo_RelatedClassName()
   * @model
   * @generated
   */
    String getRelatedClassName();

    /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.EMFInfo#getRelatedClassName <em>Related Class Name</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Related Class Name</em>' attribute.
   * @see #getRelatedClassName()
   * @generated
   */
    void setRelatedClassName(String value);

    /**
   * <!-- begin-user-doc --> Returns a string representation of this EMF
     * metamodel info.
     * <!-- end-user-doc -->
   * @model required="true"
   * @generated
   */
    String toTypeString();

    /**
   * <!-- begin-user-doc --> Returns a string representation of this EMF model
     * info.
     * <!-- end-user-doc-->
   * @model required="true"
   * @generated
   */
    String toInstanceString();

} // EMFInfo

/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmtf.MMTFException;

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
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.EMFInfo#getClassName <em>Class Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.EMFInfo#getFeatureName <em>Feature Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.EMFInfo#isReference <em>Reference</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.EMFInfo#getContainerClassName <em>Container Class Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getEMFInfo()
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
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getEMFInfo_ClassName()
	 * @model required="true"
	 * @generated
	 */
	String getClassName();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.EMFInfo#getClassName <em>Class Name</em>}' attribute.
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
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getEMFInfo_FeatureName()
	 * @model
	 * @generated
	 */
	String getFeatureName();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.EMFInfo#getFeatureName <em>Feature Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Name</em>' attribute.
	 * @see #getFeatureName()
	 * @generated
	 */
	void setFeatureName(String value);

	/**
	 * Returns the value of the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If applicable, true if the EStructuralFeature is an EReference, false otherwise (types: metamodel feature; instances: metamodel feature)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Reference</em>' attribute.
	 * @see #setReference(boolean)
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getEMFInfo_Reference()
	 * @model
	 * @generated
	 */
	boolean isReference();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.EMFInfo#isReference <em>Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference</em>' attribute.
	 * @see #isReference()
	 * @generated
	 */
	void setReference(boolean value);

	/**
	 * Returns the value of the '<em><b>Container Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The eContainer EClass name, if applicable (types: not used; instances: metamodel class of the container)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Container Class Name</em>' attribute.
	 * @see #setContainerClassName(String)
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getEMFInfo_ContainerClassName()
	 * @model
	 * @generated
	 */
	String getContainerClassName();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmtf.mid.EMFInfo#getContainerClassName <em>Container Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container Class Name</em>' attribute.
	 * @see #getContainerClassName()
	 * @generated
	 */
	void setContainerClassName(String value);

	/**
	 * <!-- begin-user-doc --> Returns a string representation of this EMF
	 * metamodel info.
	 * 
	 * @throws MMTFException
	 *             If the container is a model element instance.
	 * <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException"
	 * @generated
	 */
	String toTypeString() throws MMTFException;

	/**
	 * <!-- begin-user-doc --> Returns a string representation of this EMF model
	 * info.
	 * 
	 * @throws MMTFException
	 *             If the container is a model element type.
	 * <!-- end-user-doc-->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmtf.mid.MMTFException"
	 * @generated
	 */
	String toInstanceString() throws MMTFException;

} // EMFInfo

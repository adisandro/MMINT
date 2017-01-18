/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extendible Element Endpoint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The abstract element endpoint. It represents a relationship between extendible elements.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint#getUpperBound <em>Upper Bound</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.mid.MIDPackage#getExtendibleElementEndpoint()
 * @model abstract="true"
 * @generated
 */
public interface ExtendibleElementEndpoint extends ExtendibleElement {
	/**
	 * Returns the value of the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The minimum number of target elements associated with the source (instances: always 1).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Lower Bound</em>' attribute.
	 * @see #setLowerBound(int)
	 * @see edu.toronto.cs.se.mmint.mid.MIDPackage#getExtendibleElementEndpoint_LowerBound()
	 * @model required="true"
	 * @generated
	 */
	int getLowerBound();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint#getLowerBound <em>Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Bound</em>' attribute.
	 * @see #getLowerBound()
	 * @generated
	 */
	void setLowerBound(int value);

	/**
	 * Returns the value of the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The maximum number of target elements associated with the source; -1 represents unbounded (instances: always 1).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Upper Bound</em>' attribute.
	 * @see #setUpperBound(int)
	 * @see edu.toronto.cs.se.mmint.mid.MIDPackage#getExtendibleElementEndpoint_UpperBound()
	 * @model required="true"
	 * @generated
	 */
	int getUpperBound();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint#getUpperBound <em>Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Bound</em>' attribute.
	 * @see #getUpperBound()
	 * @generated
	 */
	void setUpperBound(int value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The endpoint target element.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(ExtendibleElement)
	 * @see edu.toronto.cs.se.mmint.mid.MIDPackage#getExtendibleElementEndpoint_Target()
	 * @model required="true"
	 * @generated
	 */
	ExtendibleElement getTarget();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(ExtendibleElement value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The uri of the target element.
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ExtendibleElement target = this.getTarget();\nreturn (target == null) ? null : target.getUri();'"
	 * @generated
	 */
	String getTargetUri();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * {@inheritDoc}<br />
	 * Gets the element type endpoint of this element instance endpoint.
	 * <!-- end-model-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ExtendibleElement metatype = super.getMetatype();\nreturn (metatype == null) ? null : (ExtendibleElementEndpoint) metatype;'"
	 * @generated
	 */
	ExtendibleElementEndpoint getMetatype();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * {@inheritDoc}<br />
	 * Gets the element supertype endpoint of this element type endpoint.
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ExtendibleElement supertype = super.getSupertype();\nreturn (supertype == null) ? null : (ExtendibleElementEndpoint) supertype;'"
	 * @generated
	 */
	ExtendibleElementEndpoint getSupertype();

} // ExtendibleElementEndpoint

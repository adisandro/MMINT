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
package edu.toronto.cs.se.mmint.mid.operator;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint;
import edu.toronto.cs.se.mmint.mid.GenericElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generic Endpoint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The endpoint for a generic operator definition.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint#getMetatargetUri <em>Metatarget Uri</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.mid.operator.OperatorPackage#getGenericEndpoint()
 * @model
 * @generated
 */
public interface GenericEndpoint extends ExtendibleElementEndpoint {
	/**
	 * Returns the value of the '<em><b>Metatarget Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metatarget Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The target uri, at the upper MID level (types: empty; instances: the target type uri).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Metatarget Uri</em>' attribute.
	 * @see #setMetatargetUri(String)
	 * @see edu.toronto.cs.se.mmint.mid.operator.OperatorPackage#getGenericEndpoint_MetatargetUri()
	 * @model required="true"
	 * @generated
	 */
	String getMetatargetUri();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint#getMetatargetUri <em>Metatarget Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metatarget Uri</em>' attribute.
	 * @see #getMetatargetUri()
	 * @generated
	 */
	void setMetatargetUri(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * {@inheritDoc}<br />
	 * Gets the generic supertype endpoint of this generic type endpoint.
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ExtendibleElementEndpoint supertype = super.getSupertype();\nreturn (supertype == null) ? null : (GenericEndpoint) supertype;'"
	 * @generated
	 */
	GenericEndpoint getSupertype();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * {@inheritDoc}<br />
	 * Gets the generic target of this generic endpoint.
	 * <!-- end-model-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='GenericElement target = MIDTypeRegistry.getType(getMetatargetUri());\nreturn target;'"
	 * @generated
	 */
	GenericElement getTarget();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * {@inheritDoc}<br />
	 * Sets the generic target of this generic endpoint.
	 * <!-- end-model-doc -->
	 * @model newTargetRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='setMetatargetUri(newTarget.getUri());'"
	 * @generated
	 */
	void setTarget(ExtendibleElement newTarget);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * {@inheritDoc}<br />
	 * Gets the generic type endpoint of this generic instance endpoint.
	 * <!-- end-model-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ExtendibleElementEndpoint metatype = super.getMetatype();\nreturn (metatype == null) ? null : (GenericEndpoint) metatype;'"
	 * @generated
	 */
	GenericEndpoint getMetatype();

	/**
	 * <!-- begin-user-doc --> Creates and adds a generic instance endpoint of this generic type endpoint to an Instance
	 * MID.
	 * 
	 * @param targetGeneric
	 *            The generic that is the target of the new generic endpoint.
	 * @param containerOperator
	 *            The operator that will contain the new generic endpoint.
	 * @return The created generic endpoint.
	 * @throws MMINTException
	 *             If this is not a generic type endpoint. <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" targetGenericRequired="true" containerOperatorRequired="true"
	 * @generated
	 */
	GenericEndpoint createInstance(GenericElement targetGeneric, Operator containerOperator) throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Creates and adds a generic instance endpoint of this generic type endpoint to a Workflow
	 * MID.
	 * 
	 * @param targetGeneric
	 *            The generic that is the target of the new generic endpoint.
	 * @param containerOperator
	 *            The operator that will contain the new generic endpoint.
	 * @return The created generic endpoint.
	 * @throws MMINTException
	 *             If this is not a generic type endpoint. <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" targetGenericRequired="true" containerOperatorRequired="true"
	 * @generated
	 */
	GenericEndpoint createWorkflowInstance(GenericElement targetGeneric, Operator containerOperator) throws MMINTException;

} // GenericEndpoint

/**
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.operator.impl;

import edu.toronto.cs.se.mmint.MIDTypeFactory;
import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDFactory;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.library.MIDRegistry;
import edu.toronto.cs.se.mmint.mid.library.MIDUtils;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmint.mid.operator.WorkflowOperator;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Workflow Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.impl.WorkflowOperatorImpl#getWorkflowMIDUri <em>Workflow MID Uri</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WorkflowOperatorImpl extends OperatorImpl implements WorkflowOperator {
	/**
	 * The default value of the '{@link #getWorkflowMIDUri() <em>Workflow MID Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkflowMIDUri()
	 * @generated
	 * @ordered
	 */
	protected static final String WORKFLOW_MID_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWorkflowMIDUri() <em>Workflow MID Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkflowMIDUri()
	 * @generated
	 * @ordered
	 */
	protected String workflowMIDUri = WORKFLOW_MID_URI_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public WorkflowOperatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperatorPackage.Literals.WORKFLOW_OPERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWorkflowMIDUri() {
		return workflowMIDUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWorkflowMIDUri(String newWorkflowMIDUri) {
		String oldWorkflowMIDUri = workflowMIDUri;
		workflowMIDUri = newWorkflowMIDUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorPackage.WORKFLOW_OPERATOR__WORKFLOW_MID_URI, oldWorkflowMIDUri, workflowMIDUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MID getWorkflowMID() {
		try {
			return (MID) MIDUtils.readModelFileInState(this.getWorkflowMIDUri());
		}
		catch (Exception e) {
			return null;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OperatorPackage.WORKFLOW_OPERATOR__WORKFLOW_MID_URI:
				return getWorkflowMIDUri();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case OperatorPackage.WORKFLOW_OPERATOR__WORKFLOW_MID_URI:
				setWorkflowMIDUri((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case OperatorPackage.WORKFLOW_OPERATOR__WORKFLOW_MID_URI:
				setWorkflowMIDUri(WORKFLOW_MID_URI_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case OperatorPackage.WORKFLOW_OPERATOR__WORKFLOW_MID_URI:
				return WORKFLOW_MID_URI_EDEFAULT == null ? workflowMIDUri != null : !WORKFLOW_MID_URI_EDEFAULT.equals(workflowMIDUri);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case OperatorPackage.WORKFLOW_OPERATOR___GET_WORKFLOW_MID:
				return getWorkflowMID();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toStringGen() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (workflowMIDUri: ");
		result.append(workflowMIDUri);
		result.append(')');
		return result.toString();
	}

	/**
	 * Adds a subtype of this workflow operator type to the Type MID.
	 * 
	 * @param newOperatorType
	 *            The new operator type to be added.
	 * @param newOperatorTypeName
	 *            The name of the new operator type.
	 * @param workflowMIDUri
	 *            The uri of the Workflow MID that implements the new operator.
	 * @throws MMINTException
	 *             If the uri of the new operator type is already registered in the Type MID, or if the Workflow MID
	 *             cannot be read or copied.
	 * @generated NOT
	 */
	@Override
	protected void addSubtype(Operator newOperatorType, String newOperatorTypeName, String workflowMIDUri) throws MMINTException {

		MID typeMID = this.getMIDContainer();
		super.addSubtype(newOperatorType, this, null, newOperatorTypeName);
		try {
			MID workflowMID;
			String newWorkflowMIDUri;
			if (MIDUtils.isFileOrDirectoryInState(workflowMIDUri)) { // make a copy of the Workflow MID file..
				workflowMID = (MID) MIDUtils.readModelFileInState(workflowMIDUri);
				newWorkflowMIDUri = workflowMIDUri;
			}
			else { // ..or we're just recreating this subtype at startup
				workflowMID = (MID) MIDUtils.readModelFile(workflowMIDUri, true);
				newWorkflowMIDUri = newOperatorTypeName + MMINT.MODEL_FILEEXTENSION_SEPARATOR + MIDPackage.eNAME;
				MIDUtils.writeModelFileInState(workflowMID, newWorkflowMIDUri);
			}
			((WorkflowOperator) newOperatorType).setWorkflowMIDUri(newWorkflowMIDUri);
			MIDTypeFactory.addOperatorType(newOperatorType, typeMID);
			for (Model workflowModel : workflowMID.getModels()) {
				boolean isInput = MIDRegistry.getOutputOperators(workflowModel, workflowMID).isEmpty();
				boolean isOutput = MIDRegistry.getInputOperators(workflowModel, workflowMID).isEmpty();
				if (isInput || isOutput) {
					ModelEndpoint newModelTypeEndpoint = MIDFactory.eINSTANCE.createModelEndpoint();
					Model modelType = MIDRegistry.getExtendibleElement(workflowModel.getMetatypeUri(), typeMID);
					MIDTypeFactory.addType(newModelTypeEndpoint, null, newOperatorType.getUri() + MMINT.URI_SEPARATOR + workflowModel.getUri(), workflowModel.getName(), typeMID);
					newModelTypeEndpoint.setDynamic(true);
					String containerFeatureName = (isInput) ?
						OperatorPackage.eINSTANCE.getOperator_Inputs().getName() :
						OperatorPackage.eINSTANCE.getOperator_Outputs().getName();
					MIDTypeFactory.addModelTypeEndpoint(newModelTypeEndpoint, modelType, newOperatorType, containerFeatureName);
				}
			}
		}
		catch (Exception e) {
			super.delete(newOperatorType.getUri(), typeMID);
			throw new MMINTException("Error copying the Workflow MID", e);
		}
	}

	/**
	 * @generated NOT
	 */
	public void deleteType() throws MMINTException {

		super.deleteType();
		MIDUtils.deleteFileInState(this.getWorkflowMIDUri());
	}

	/**
	 * @generated NOT
	 */
	@Override
	protected void addInstance(@NonNull Operator newOperator, @NonNull MIDLevel midLevel, MID instanceMID) {

		super.addInstance(newOperator, midLevel, instanceMID);
		((WorkflowOperator) newOperator).setWorkflowMIDUri(this.getWorkflowMIDUri());
	}

	/**
	 * Runs this workflow operator instance, i.e. executes its Workflow MID implementation.
	 * 
	 * @param inputsByName
	 *            The input model instances, identified by their formal parameter name, i.e. the models in the Workflow
	 *            MID that are not output of any operator.
	 * @param genericsByName
	 *            The generic types, identified by their metatype name.
	 * @param outputMIDsByName
	 *            The instance MIDs where the output models are created, identified by the output name. A null Instance
	 *            MID means that the output model isn't added to it.
	 * @return The output model instances, identified by their name, i.e. the models in the Workflow MID that are not
	 *         input of any operator.
	 * @throws Exception
	 *             If something went wrong running the operator.
	 * @generated NOT
	 */
	@Override
	public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MID> outputMIDsByName) throws Exception {

		MMINTException.mustBeInstance(this);

		Map<String, Model> outputsByName = new HashMap<>();

		return outputsByName;
	}

} //WorkflowOperatorImpl

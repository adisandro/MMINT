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
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDFactory;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.editor.Diagram;
import edu.toronto.cs.se.mmint.mid.editor.Editor;
import edu.toronto.cs.se.mmint.mid.library.MIDRegistry;
import edu.toronto.cs.se.mmint.mid.library.MIDUtils;
import edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmint.mid.operator.WorkflowOperator;
import edu.toronto.cs.se.mmint.mid.ui.GMFDiagramUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Workflow Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.impl.WorkflowOperatorImpl#getMidUri <em>Mid Uri</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WorkflowOperatorImpl extends OperatorImpl implements WorkflowOperator {
	/**
	 * The default value of the '{@link #getMidUri() <em>Mid Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMidUri()
	 * @generated
	 * @ordered
	 */
	protected static final String MID_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMidUri() <em>Mid Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMidUri()
	 * @generated
	 * @ordered
	 */
	protected String midUri = MID_URI_EDEFAULT;

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
	public String getMidUri() {
		return midUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMidUri(String newMidUri) {
		String oldMidUri = midUri;
		midUri = newMidUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorPackage.WORKFLOW_OPERATOR__MID_URI, oldMidUri, midUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MID getWorkflowMID() throws MMINTException {
		MMINTException.mustBeType(this);
		
		try {
			return (MID) MIDUtils.readModelFileInState(this.getMidUri());
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
	public MID getInstanceMID() throws MMINTException {
		MMINTException.mustBeInstance(this);
		
		try {
			return (MID) MIDUtils.readModelFile(this.getMidUri(), true);
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
			case OperatorPackage.WORKFLOW_OPERATOR__MID_URI:
				return getMidUri();
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
			case OperatorPackage.WORKFLOW_OPERATOR__MID_URI:
				setMidUri((String)newValue);
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
			case OperatorPackage.WORKFLOW_OPERATOR__MID_URI:
				setMidUri(MID_URI_EDEFAULT);
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
			case OperatorPackage.WORKFLOW_OPERATOR__MID_URI:
				return MID_URI_EDEFAULT == null ? midUri != null : !MID_URI_EDEFAULT.equals(midUri);
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
				try {
					return getWorkflowMID();
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case OperatorPackage.WORKFLOW_OPERATOR___GET_INSTANCE_MID:
				try {
					return getInstanceMID();
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
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
		result.append(" (midUri: ");
		result.append(midUri);
		result.append(')');
		return result.toString();
	}

	/**
	 * @generated NOT
	 */
	@Override
	public String toString() {

		return "[workflow] " + super.toString();
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
			if (MIDUtils.isFileOrDirectoryInState(workflowMIDUri)) { // just recreating this subtype at startup
				workflowMID = (MID) MIDUtils.readModelFileInState(workflowMIDUri);
				newWorkflowMIDUri = workflowMIDUri;
			}
			else { // make a copy of the Workflow MID files
				workflowMID = (MID) MIDUtils.readModelFile(workflowMIDUri, true);
				newWorkflowMIDUri = newOperatorTypeName + MMINT.MODEL_FILEEXTENSION_SEPARATOR + MIDPackage.eNAME;
				MIDUtils.writeModelFileInState(workflowMID, newWorkflowMIDUri);
				MIDUtils.copyTextFileAndReplaceText(
					MIDUtils.prependWorkspaceToUri(workflowMIDUri + GMFDiagramUtils.DIAGRAM_SUFFIX),
					MIDUtils.prependStateToUri(newWorkflowMIDUri + GMFDiagramUtils.DIAGRAM_SUFFIX),
					MIDUtils.getLastSegmentFromUri(workflowMIDUri),
					newWorkflowMIDUri,
					false);
			}
			((WorkflowOperator) newOperatorType).setMidUri(newWorkflowMIDUri);
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
		MIDUtils.deleteFileInState(this.getMidUri());
		MIDUtils.deleteFileInState(this.getMidUri() + GMFDiagramUtils.DIAGRAM_SUFFIX);
	}

	/**
	 * @generated NOT
	 */
	@Override
	protected void addInstance(@NonNull Operator newOperator, @NonNull MIDLevel midLevel, @Nullable MID instanceMID) {

		super.addInstance(newOperator, midLevel, instanceMID);
		if (instanceMID != null) {
			String operatorInstanceMIDUri = MIDUtils.getUniqueUri(
				MIDUtils.replaceFileNameInUri(
					MIDRegistry.getModelAndModelElementUris(instanceMID, MIDLevel.INSTANCES)[0],
					newOperator.getName()),
				true,
				false);
			MID operatorInstanceMID = MIDFactory.eINSTANCE.createMID();
			operatorInstanceMID.setLevel(MIDLevel.INSTANCES);
			Model midModelType = MIDTypeRegistry.getType(MIDPackage.eNS_URI);
			Editor midDiagramType = midModelType.getEditors().stream()
				.filter(editor -> editor instanceof Diagram)
				.findFirst()
				.get();
			try {
				MIDUtils.writeModelFile(operatorInstanceMID, operatorInstanceMIDUri, true);
				((WorkflowOperator) newOperator).setMidUri(operatorInstanceMIDUri);
				GMFDiagramUtils.createGMFDiagram(
					operatorInstanceMIDUri,
					operatorInstanceMIDUri + GMFDiagramUtils.DIAGRAM_SUFFIX,
					midModelType.getName(),
					MIDTypeRegistry.getTypeBundle(midDiagramType.getUri()).getSymbolicName(),
					true);
			}
			catch (Exception e) {
				MMINTException.print(IStatus.WARNING, "Can't store the Instance MID to contain this workflow operator's intermediate results, skipping it", e);
			}
		}
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void deleteInstance() throws MMINTException {

		super.deleteInstance();
		MIDUtils.deleteFile(this.getMidUri(), true);
		MIDUtils.deleteFile(this.getMidUri() + GMFDiagramUtils.DIAGRAM_SUFFIX, true);
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

		// workflowMID is executed, intermediate results are stored in instanceMID, outputs in outputMIDsByName
		MID workflowMID = ((WorkflowOperator) this.getMetatype()).getWorkflowMID();
		MID instanceMID = this.getInstanceMID();
		Map<String, Model> allModelsByName = new HashMap<>(inputsByName);
		// create shortcuts to input models
		String instanceMIDUri = this.getMidUri();
		String instanceMIDDiagramUri = instanceMIDUri + GMFDiagramUtils.DIAGRAM_SUFFIX;
		View instanceMIDDiagramRoot = (View) MIDUtils.readModelFile(instanceMIDDiagramUri, true);
		Model midModelType = MIDTypeRegistry.getType(MIDPackage.eNS_URI);
		Editor midDiagramType = midModelType.getEditors().stream()
			.filter(editor -> editor instanceof Diagram)
			.findFirst()
			.get();
		String midDiagramPluginId = MIDTypeRegistry.getTypeBundle(midDiagramType.getUri()).getSymbolicName();
		if (instanceMID != null) {
			for (Model inputModel : inputsByName.values()) {
				GMFDiagramUtils.createGMFNodeShortcut(inputModel, instanceMIDDiagramRoot, midDiagramPluginId, midModelType.getName());
			}
		}
		Map<String, Model> outputsByName = new HashMap<>();
		// the order of operator creation in the workflow is a safe order of execution too
		for (Operator workflowOperator : workflowMID.getOperators()) {
			Map<String, Model> workflowInputsByName = new HashMap<>();
			for (ModelEndpoint inputModelEndpoint : workflowOperator.getInputs()) {
				workflowInputsByName.put(
					inputModelEndpoint.getName(),
					allModelsByName.get(inputModelEndpoint.getTargetUri()));
			}
			//TODO I need to start the operator now to create the intermediate operator instances, not just run, using the instanceMID
			Operator newOperator = workflowOperator.getMetatype().createInstance(null);
			Map<String, GenericElement> workflowGenericsByName = new HashMap<>();
			for (GenericEndpoint workflowGeneric : workflowOperator.getGenerics()) {
				workflowGenericsByName.put(workflowGeneric.getMetatype().getName(), workflowGeneric.getTarget());
			}
			Map<String, MID> workflowOutputMIDsByName = new HashMap<>();
			for (ModelEndpoint outputModelEndpoint : workflowOperator.getOutputs()) {
				MID outputMID = instanceMID;
				if (MIDRegistry.getInputOperators(outputModelEndpoint.getTarget(), workflowMID).isEmpty()) {
					outputMID = outputMIDsByName.get(outputModelEndpoint.getTargetUri());
				}
				workflowOutputMIDsByName.put(outputModelEndpoint.getName(), outputMID);
			}
			Properties inputProperties = newOperator.getInputProperties();
			newOperator.readInputProperties(inputProperties);
			Map<String, Model> workflowOutputsByName = newOperator.run(workflowInputsByName, workflowGenericsByName, workflowOutputMIDsByName);
			for (ModelEndpoint outputModelEndpoint : workflowOperator.getOutputs()) {
				Model outputModel = workflowOutputsByName.get(outputModelEndpoint.getName());
				allModelsByName.put(outputModelEndpoint.getTargetUri(), outputModel);
				if (workflowOutputMIDsByName.get(outputModelEndpoint.getName()) != null) {
					outputsByName.put(outputModelEndpoint.getTargetUri(), outputModel);
					//TODO include output model rel endpoints in output models
					//TODO Create shortcuts to output models
				}
			}
		}
		if (instanceMID != null) {
			MIDUtils.writeModelFile(instanceMID, instanceMIDUri, true);
			MIDUtils.writeModelFile(instanceMIDDiagramRoot, instanceMIDDiagramUri, true);
		}

		return outputsByName;
	}

} //WorkflowOperatorImpl

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
package edu.toronto.cs.se.mmint.mid.operator.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDFactory;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.editor.Diagram;
import edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorFactory;
import edu.toronto.cs.se.mmint.mid.operator.OperatorGeneric;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmint.mid.operator.WorkflowOperator;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.ui.GMFUtils;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;
import edu.toronto.cs.se.mmint.mid.utils.MIDTypeFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Workflow Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class WorkflowOperatorImpl extends NestingOperatorImpl implements WorkflowOperator {
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
	public MID getNestedWorkflowMID() throws MMINTException {
		MMINTException.mustBeType(this);

		try {
			return (MID) FileUtils.readModelFileInState(this.getNestedMIDPath());
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
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case OperatorPackage.WORKFLOW_OPERATOR___GET_NESTED_WORKFLOW_MID:
				try {
					return getNestedWorkflowMID();
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
		}
		return super.eInvoke(operationID, arguments);
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
	 * @param workflowMIDPath
	 *            The path to the Workflow MID that implements the new operator.
	 * @throws MMINTException
	 *             If the id of the new operator type is already registered in the Type MID, or if the Workflow MID
	 *             cannot be read or copied.
	 * @generated NOT
	 */
	@Override
	protected void addSubtype(Operator newOperatorType, String newOperatorTypeName, String workflowMIDPath) throws MMINTException {

		MID typeMID = this.getMIDContainer();
		super.addSubtype(newOperatorType, this, null, newOperatorTypeName);
		try {
			MID workflowMID;
			String newWorkflowMIDPath;
			if (FileUtils.isFileOrDirectoryInState(workflowMIDPath)) { // just recreating this subtype at startup
				workflowMID = (MID) FileUtils.readModelFileInState(workflowMIDPath);
				newWorkflowMIDPath = workflowMIDPath;
			}
			else { // make a copy of the Workflow MID files
				workflowMID = (MID) FileUtils.readModelFile(workflowMIDPath, true);
				newWorkflowMIDPath = newOperatorTypeName + MMINT.MODEL_FILEEXTENSION_SEPARATOR + MIDPackage.eNAME;
				FileUtils.writeModelFileInState(workflowMID, newWorkflowMIDPath);
				FileUtils.copyTextFileAndReplaceText(
					FileUtils.prependWorkspacePath(workflowMIDPath + GMFUtils.DIAGRAM_SUFFIX),
					FileUtils.prependStatePath(newWorkflowMIDPath + GMFUtils.DIAGRAM_SUFFIX),
					FileUtils.getLastSegmentFromPath(workflowMIDPath),
					newWorkflowMIDPath,
					false);
			}
			((WorkflowOperator) newOperatorType).setNestedMIDPath(newWorkflowMIDPath);
			MIDTypeFactory.addOperatorType(newOperatorType, typeMID);
			Map<Model, String> inoutWorkflowModels = new LinkedHashMap<>();
			for (Model workflowModel : workflowMID.getModels()) { // first pass: identify inputs and outputs
				boolean isInput = MIDRegistry.getOutputOperators(workflowModel, workflowMID).isEmpty(); // no operator generated this model
				if (isInput) {
					inoutWorkflowModels.put(workflowModel, OperatorPackage.eINSTANCE.getOperator_Inputs().getName());
					continue; // an input can't be output too
				}
				boolean isOutput = MIDRegistry.getInputOperators(workflowModel, workflowMID).isEmpty(); // no operator has this model as input
				if (isOutput) {
					inoutWorkflowModels.put(workflowModel, OperatorPackage.eINSTANCE.getOperator_Outputs().getName());
					if (workflowModel instanceof ModelRel) { // an output model rel needs its endpoint models as output too
						for (ModelEndpoint outModelEndpoint : ((ModelRel) workflowModel).getModelEndpoints()) {
							Model outModel = outModelEndpoint.getTarget();
							if (inoutWorkflowModels.containsKey(outModel)) {
								continue;
							}
							inoutWorkflowModels.put(outModel, OperatorPackage.eINSTANCE.getOperator_Outputs().getName());
						}
					}
				}
			}
			for (Entry<Model, String> inoutWorkflowModel : inoutWorkflowModels.entrySet()) { // second pass: create endpoints for operator type
				Model workflowModel = inoutWorkflowModel.getKey();
				ModelEndpoint newModelTypeEndpoint = MIDFactory.eINSTANCE.createModelEndpoint();
				Model modelType = typeMID.getExtendibleElement(workflowModel.getMetatypeUri());
				MIDTypeFactory.addType(newModelTypeEndpoint, null, newOperatorType.getUri() + MMINT.URI_SEPARATOR + workflowModel.getUri(), workflowModel.getName(), typeMID);
				newModelTypeEndpoint.setDynamic(true);
				MIDTypeFactory.addModelTypeEndpoint(newModelTypeEndpoint, modelType, newOperatorType, inoutWorkflowModel.getValue());
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
	@Override
	public void deleteType() throws MMINTException {

		super.deleteType();
		FileUtils.deleteFileInState(this.getNestedMIDPath());
		FileUtils.deleteFileInState(this.getNestedMIDPath() + GMFUtils.DIAGRAM_SUFFIX);
	}

	/**
	 * Opens the MID with the intermediate models generated by this workflow operator instance, if it exists.
	 *
	 * @throws Exception
	 *             If this is not a workflow operator instance, or if the MID diagram can't be opened.
	 * @generated NOT
	 */
	@Override
	public void openType() throws Exception {

		MMINTException.mustBeType(this);

		if (MIDTypeHierarchy.isRootType(this.getSupertype())) {
			super.openType();
			return;
		}
		Diagram midDiagramType = MIDTypeRegistry.getMIDDiagramType();
		FileUtils.openEclipseEditorInState(this.getNestedMIDPath() + GMFUtils.DIAGRAM_SUFFIX, midDiagramType.getId());
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

		// workflowMID is executed, intermediate models are stored in nestedMID, outputs in outputMIDsByName
		MID workflowMID = ((WorkflowOperator) this.getMetatype()).getNestedWorkflowMID();
		MID nestedMID = this.getNestedInstanceMID();
		String nestedMIDPath = this.getNestedMIDPath();
		Map<String, Model> allModelsByName = new HashMap<>(inputsByName);
		// create shortcuts to input models
		if (nestedMIDPath != null) {
			super.createNestedInstanceMIDModelShortcuts(ECollections.toEList(inputsByName.values()));
		}
		// the order of operator creation in the workflow is a safe order of execution too
		Map<String, Model> outputsByName = new HashMap<>();
		for (Operator workflowOperator : workflowMID.getOperators()) {
			EList<OperatorInput> workflowInputs = new BasicEList<>();
			for (ModelEndpoint inputModelEndpoint : workflowOperator.getInputs()) {
				Model inputModel = allModelsByName.get(inputModelEndpoint.getTargetUri());
				OperatorInput workflowInput = OperatorFactory.eINSTANCE.createOperatorInput();
				workflowInput.setModel(inputModel);
				workflowInput.setModelTypeEndpoint(inputModelEndpoint.getMetatype());
				workflowInputs.add(workflowInput);
			}
			EList<OperatorGeneric> workflowGenerics = new BasicEList<>();
			for (GenericEndpoint workflowGenericEndpoint : workflowOperator.getGenerics()) {
				OperatorGeneric workflowGeneric = OperatorFactory.eINSTANCE.createOperatorGeneric();
				workflowGeneric.setGenericSuperTypeEndpoint(workflowGenericEndpoint.getMetatype());
				workflowGeneric.setGeneric(workflowGenericEndpoint.getTarget());
				workflowGenerics.add(workflowGeneric);
			}
			Map<String, MID> workflowOutputMIDsByName = new HashMap<>();
			for (ModelEndpoint outputModelEndpoint : workflowOperator.getOutputs()) {
				MID outputMID = outputMIDsByName.getOrDefault(outputModelEndpoint.getTargetUri(), nestedMID); // match workflow ids..
				workflowOutputMIDsByName.put(outputModelEndpoint.getName(), outputMID); // ..with operator output names
			}
			Map<String, Model> workflowOutputsByName = workflowOperator.getMetatype().startInstance(
				workflowInputs,
				null,
				workflowGenerics,
				workflowOutputMIDsByName,
				nestedMID)
					.getOutputsByName();
			EList<Model> outputModels = new BasicEList<>();
			for (ModelEndpoint outputModelEndpoint : workflowOperator.getOutputs()) {
				Model outputModel = workflowOutputsByName.get(outputModelEndpoint.getName());
				allModelsByName.put(outputModelEndpoint.getTargetUri(), outputModel); // ids are unique in a workflowMID
				if (workflowOutputMIDsByName.get(outputModelEndpoint.getName()) != nestedMID) { // final outputs
					outputsByName.put(outputModelEndpoint.getTargetUri(), outputModel);
					outputModels.add(outputModel);
				}
			}
			// create shortcuts to output models
			if (nestedMIDPath != null) {
				super.createNestedInstanceMIDModelShortcuts(outputModels);
			}
		}
		if (nestedMIDPath != null) {
			super.writeNestedInstanceMID();
		}

		return outputsByName;
	}

} //WorkflowOperatorImpl

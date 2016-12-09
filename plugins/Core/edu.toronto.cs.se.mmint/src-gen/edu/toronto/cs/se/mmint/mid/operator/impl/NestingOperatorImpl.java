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

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;

import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDFactory;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.editor.Diagram;
import edu.toronto.cs.se.mmint.mid.operator.NestingOperator;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorGeneric;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmint.mid.ui.GMFUtils;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
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
 * An implementation of the model object '<em><b>Nesting Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.impl.NestingOperatorImpl#getNestedMIDPath <em>Nested MID Path</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NestingOperatorImpl extends OperatorImpl implements NestingOperator {
	/**
	 * The default value of the '{@link #getNestedMIDPath() <em>Nested MID Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNestedMIDPath()
	 * @generated
	 * @ordered
	 */
	protected static final String NESTED_MID_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNestedMIDPath() <em>Nested MID Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNestedMIDPath()
	 * @generated
	 * @ordered
	 */
	protected String nestedMIDPath = NESTED_MID_PATH_EDEFAULT;

	/**
	 * The nested MID, kept in memory for performance reasons.
	 * @generated NOT
	 */
	protected MID inMemoryNestedMID;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NestingOperatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperatorPackage.Literals.NESTING_OPERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNestedMIDPath() {
		return nestedMIDPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNestedMIDPath(String newNestedMIDPath) {
		String oldNestedMIDPath = nestedMIDPath;
		nestedMIDPath = newNestedMIDPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorPackage.NESTING_OPERATOR__NESTED_MID_PATH, oldNestedMIDPath, nestedMIDPath));
	}

	/**
	 * @generated NOT
	 */
	public MID getNestedInstanceMID() throws MMINTException {

		MMINTException.mustBeInstance(this);

		if (this.inMemoryNestedMID != null) {
			return this.inMemoryNestedMID;
		}

		try {
			if (this.getNestedMIDPath() == null) {
				return null;
			}
			MID nestedMID = (MID) FileUtils.readModelFile(this.getNestedMIDPath(), true);
			this.inMemoryNestedMID = nestedMID;
			return nestedMID;
		}
		catch (Exception e) {
			this.inMemoryNestedMID = null;
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
			case OperatorPackage.NESTING_OPERATOR__NESTED_MID_PATH:
				return getNestedMIDPath();
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
			case OperatorPackage.NESTING_OPERATOR__NESTED_MID_PATH:
				setNestedMIDPath((String)newValue);
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
			case OperatorPackage.NESTING_OPERATOR__NESTED_MID_PATH:
				setNestedMIDPath(NESTED_MID_PATH_EDEFAULT);
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
			case OperatorPackage.NESTING_OPERATOR__NESTED_MID_PATH:
				return NESTED_MID_PATH_EDEFAULT == null ? nestedMIDPath != null : !NESTED_MID_PATH_EDEFAULT.equals(nestedMIDPath);
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
			case OperatorPackage.NESTING_OPERATOR___GET_NESTED_INSTANCE_MID:
				try {
					return getNestedInstanceMID();
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
		result.append(" (nestedMIDPath: ");
		result.append(nestedMIDPath);
		result.append(')');
		return result.toString();
	}

	/**
	 * @generated NOT
	 */
	@Override
	protected void addInstance(@NonNull Operator newOperator, @NonNull MIDLevel midLevel, @Nullable MID instanceMID) {

		super.addInstance(newOperator, midLevel, instanceMID);
		if (instanceMID == null) {
			return;
		}

		String nestedInstanceMIDPath = FileUtils.getUniquePath(
			FileUtils.replaceFileNameInPath(
				MIDRegistry.getModelUri(instanceMID),
				newOperator.getName()),
			true,
			false);
		MID nestedInstanceMID = MIDFactory.eINSTANCE.createMID();
		nestedInstanceMID.setLevel(MIDLevel.INSTANCES);
		Model midModelType = MIDTypeRegistry.getMIDModelType();
		Diagram midDiagramType = MIDTypeRegistry.getMIDDiagramType();
		try {
			FileUtils.writeModelFile(nestedInstanceMID, nestedInstanceMIDPath, true);
			((NestingOperator) newOperator).setNestedMIDPath(nestedInstanceMIDPath);
			((NestingOperatorImpl) newOperator).inMemoryNestedMID = nestedInstanceMID;
			GMFUtils.createGMFDiagram(
				nestedInstanceMIDPath,
				nestedInstanceMIDPath + GMFUtils.DIAGRAM_SUFFIX,
				midModelType.getName(),
				MIDTypeRegistry.getTypeBundle(midDiagramType.getUri()).getSymbolicName(),
				true);
		}
		catch (Exception e) {
			MMINTException.print(IStatus.WARNING, "Can't store the Instance MID to contain this nesting operator's intermediate artifacts, skipping it", e);
		}
	}

	/**
	 * @generated NOT
	 */
	public View createInputShortcuts(EList<OperatorInput> inputs) throws Exception {

		View instanceMIDDiagramRoot = null;
		if (this.getNestedInstanceMID() != null) {
			String instanceMIDPath = this.getNestedMIDPath();
			String instanceMIDDiagramPath = instanceMIDPath + GMFUtils.DIAGRAM_SUFFIX;
			instanceMIDDiagramRoot = (View) FileUtils.readModelFile(instanceMIDDiagramPath, true);
			Model midModelType = MIDTypeRegistry.getMIDModelType();
			String midDiagramPluginId = MIDTypeRegistry.getTypeBundle(MIDTypeRegistry.getMIDDiagramType().getUri()).getSymbolicName();
			for (OperatorInput input : inputs) {
				GMFUtils.createGMFNodeShortcut(input.getModel(), instanceMIDDiagramRoot, midDiagramPluginId, midModelType.getName());
			}
		}

		return instanceMIDDiagramRoot;
	}

	/**
	 * @generated NOT
	 */
	public Operator startNestedInstanceSimple(Operator nestedOperatorType, EList<OperatorInput> inputs, Properties inputProperties, EList<OperatorGeneric> generics, Map<String, MID> outputMIDsByName) throws Exception {

		// use the nested MID as default, or provided output MIDs otherwise
		MID nestedInstanceMID = this.getNestedInstanceMID();
		Map<String, MID> nestedOutputMIDsByName = new HashMap<>();
		if (outputMIDsByName == null) {
			nestedOutputMIDsByName = MIDOperatorIOUtils.createSimpleOutputMIDsByName(nestedOperatorType, nestedInstanceMID);
		}
		else {
			for (ModelEndpoint outputModelTypeEndpoint : nestedOperatorType.getOutputs()) {
				MID outputMID = outputMIDsByName.getOrDefault(outputModelTypeEndpoint.getName(), nestedInstanceMID);
				nestedOutputMIDsByName.put(outputModelTypeEndpoint.getName(), outputMID);
			}
		}
		// run nested operator
		Operator newNestedOperator = nestedOperatorType.startInstance(
			inputs,
			inputProperties,
			generics,
			outputMIDsByName,
			nestedInstanceMID);

		return newNestedOperator;
	}

	/**
	 * @generated NOT
	 */
	public Operator startNestedInstance(Operator nestedOperatorType, EList<OperatorInput> inputs, Properties inputProperties, EList<OperatorGeneric> generics, Map<String, MID> outputMIDsByName) throws Exception {

		//TODO MMINT[SCRIPTING] Add in mid.ecore + javadoc
		//TODO MMINT[SCRIPTING] Add option to detect when the nested MID is enabled (WorkflowOperator too)
		// create shortcuts to input models
		View instanceMIDDiagramRoot = this.createInputShortcuts(inputs);
		// run nested operator
		Operator newNestedOperator = this.startNestedInstanceSimple(nestedOperatorType, inputs, inputProperties, generics, outputMIDsByName);
		// store nested MID
		MID nestedInstanceMID = this.getNestedInstanceMID();
		if (nestedInstanceMID != null) {
			String instanceMIDPath = this.getNestedMIDPath();
			String instanceMIDDiagramPath = instanceMIDPath + GMFUtils.DIAGRAM_SUFFIX;
			FileUtils.writeModelFile(nestedInstanceMID, instanceMIDPath, true);
			FileUtils.writeModelFile(instanceMIDDiagramRoot, instanceMIDDiagramPath, true);
		}

		return newNestedOperator;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void deleteInstance() throws MMINTException {

		super.deleteInstance();
		MID nestedInstanceMID = this.getNestedInstanceMID();
		for (Model nestedModel : new ArrayList<>(nestedInstanceMID.getModels())) {
			nestedModel.deleteInstanceAndFile();
		}
		FileUtils.deleteFile(this.getNestedMIDPath(), true);
		FileUtils.deleteFile(this.getNestedMIDPath() + GMFUtils.DIAGRAM_SUFFIX, true);
	}

	/**
	 * Opens the MID with the intermediate artifacts generated by this nesting operator instance, if it exists.
	 * 
	 * @throws Exception
	 *             If this is not an operator instance, or if the MID diagram can't be opened.
	 * @generated NOT
	 */
	@Override
	public void openInstance() throws Exception {

		MMINTException.mustBeInstance(this);

		if (FileUtils.isFile(this.getNestedMIDPath(), true)) {
			Diagram midDiagramType = MIDTypeRegistry.getMIDDiagramType();
			FileUtils.openEclipseEditor(this.getNestedMIDPath() + GMFUtils.DIAGRAM_SUFFIX, midDiagramType.getId(), true);
		}
	}

} //NestingOperatorImpl

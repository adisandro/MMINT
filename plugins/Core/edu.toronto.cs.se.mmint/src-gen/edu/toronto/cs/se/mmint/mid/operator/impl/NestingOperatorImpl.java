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
import edu.toronto.cs.se.mmint.mid.operator.NestingOperator;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorGeneric;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.ui.GMFUtils;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.gmf.runtime.diagram.core.providers.IViewProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
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
	 * The nested MID, kept in memory for performance reasons (different from
	 * {@link edu.toronto.cs.se.mmint.mid.impl.ModelImpl#inMemoryRootModelObj}, this is NOT for making it work when
	 * there is no serialization).
	 * 
	 * @generated NOT
	 */
	protected MID inMemoryNestedMID;

	/**
	 * The nested MID gmf diagram, kept in memory for performance reasons (different from
	 * {@link edu.toronto.cs.se.mmint.mid.impl.ModelImpl#inMemoryRootModelObj}, this is NOT for making it work when
	 * there is no serialization).
	 * 
	 * @generated NOT
	 */
	protected Diagram inMemoryNestedMIDDiagram;

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
			String nestedMIDPath = this.getNestedMIDPath();
			if (nestedMIDPath == null) {
				return null;
			}
			MID nestedMID = (MID) FileUtils.readModelFile(nestedMIDPath, true);
			this.inMemoryNestedMID = nestedMID;
			return nestedMID;
		}
		catch (Exception e) {
			this.inMemoryNestedMID = null;
			return null;
		}
	}

	/**
	 * @generated NOT
	 */
	public Diagram getNestedInstanceMIDDiagram() throws MMINTException {

		MMINTException.mustBeInstance(this);

		if (this.inMemoryNestedMIDDiagram != null) {
			return this.inMemoryNestedMIDDiagram;
		}

		try {
			String nestedMIDPath = this.getNestedMIDPath();
			if (nestedMIDPath == null) {
				return null;
			}
			String nestedMIDDiagramPath = nestedMIDPath + GMFUtils.DIAGRAM_SUFFIX;
			Diagram nestedMIDDiagram = (Diagram) FileUtils.readModelFile(nestedMIDDiagramPath, true);
			this.inMemoryNestedMIDDiagram = nestedMIDDiagram;
			return nestedMIDDiagram;
		}
		catch (Exception e) {
			this.inMemoryNestedMIDDiagram = null;
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
			/* TODO MMINT[OPERATOR] Could we put a nestedMID in memory when not serialized too, or will it defeat the purpose of having a null instanceMID?
			 * (find the cases where it could be useful)
			 */
			return;
		}

		String nestedMIDPath = FileUtils.getUniquePath(
			FileUtils.replaceFileNameInPath(
				MIDRegistry.getModelUri(instanceMID),
				newOperator.getName()),
			true,
			false);
		MID nestedMID = MIDFactory.eINSTANCE.createMID();
		nestedMID.setLevel(MIDLevel.INSTANCES);
		try {
			FileUtils.writeModelFile(nestedMID, nestedMIDPath, true);
			Diagram nestedMIDDiagram = GMFUtils.createGMFDiagramAndFile(
				nestedMIDPath,
				nestedMIDPath + GMFUtils.DIAGRAM_SUFFIX,
				MIDTypeRegistry.getMIDModelType().getName(),
				MIDTypeRegistry.getTypeBundle(MIDTypeRegistry.getMIDDiagramType().getUri()).getSymbolicName(),
				true);
			((NestingOperator) newOperator).setNestedMIDPath(nestedMIDPath);
			((NestingOperatorImpl) newOperator).inMemoryNestedMID = nestedMID;
			((NestingOperatorImpl) newOperator).inMemoryNestedMIDDiagram = nestedMIDDiagram;
		}
		catch (Exception e) {
			MMINTException.print(IStatus.WARNING, "Can't store the Instance MID to contain this nesting operator's intermediate artifacts, skipping it", e);
		}
	}

	/**
	 * create shortcuts to output models, or make a copy of output model rels
	 * @generated NOT
	 */
	protected void createNestedInstanceMIDModelShortcuts(EList<Model> models, IViewProvider viewProvider) throws MMINTException, IOException {

		MMINTException.mustBeInstance(this);

		String nestedMIDPath = this.getNestedMIDPath();
		if (nestedMIDPath == null) {
			throw new MMINTException("The nested MID is not serialized");
		}
		if (models.isEmpty()) {
			return;
		}

		MID nestedMID = this.getNestedInstanceMID();
		Diagram nestedMIDDiagram = this.getNestedInstanceMIDDiagram();
		Model midModelType = MIDTypeRegistry.getMIDModelType();
		String midDiagramPluginId = MIDTypeRegistry.getTypeBundle(MIDTypeRegistry.getMIDDiagramType().getUri()).getSymbolicName();
		// models first, then model rels
		Map<Model, Node> gmfNodes = new HashMap<>();
		for (Model model : models) {
			if (model instanceof BinaryModelRel) {
				continue;
			}
			Node gmfNode = GMFUtils.createGMFNodeShortcut(
				model,
				nestedMIDDiagram,
				midDiagramPluginId,
				midModelType.getName(),
				viewProvider);
			//TODO MMINT[NESTED] What about rels whose endpoints are not created here as shortcuts? Pass additional parameter to this function?
			gmfNodes.put(model, gmfNode);
			nestedMID.getExtendibleTable().put(model.getUri(), model);
		}
		for (Model model : models) {
			if (!(model instanceof BinaryModelRel)) {
				continue;
			}
			BinaryModelRel modelRel = (BinaryModelRel) model;
			GMFUtils.createGMFEdge(
				modelRel,
				gmfNodes.get(modelRel.getSourceModel()),
				gmfNodes.get(modelRel.getTargetModel()),
				nestedMIDDiagram,
				midDiagramPluginId,
				viewProvider);
			//TODO MMINT[NESTED] Need to create an endpoint from the nested operator to the model rel shortcut or it's automatic?
		}
	}

	/**
	 * @generated NOT
	 */
	protected void writeNestedInstanceMID() throws MMINTException, IOException {

		MMINTException.mustBeInstance(this);

		String nestedMIDPath = this.getNestedMIDPath();
		if (nestedMIDPath == null) {
			throw new MMINTException("The nested MID is not serialized");
		}

		String nestedMIDDiagramPath = nestedMIDPath + GMFUtils.DIAGRAM_SUFFIX;
		FileUtils.writeModelFile(this.getNestedInstanceMID(), nestedMIDPath, true);
		FileUtils.writeModelFile(this.getNestedInstanceMIDDiagram(), nestedMIDDiagramPath, true);
		this.inMemoryNestedMID = null;
		this.inMemoryNestedMIDDiagram = null;
	}

	/**
	 * @generated NOT
	 */
	public Operator startNestedInstance(Operator nestedOperatorType, EList<OperatorInput> inputs, Properties inputProperties, EList<OperatorGeneric> generics, Map<String, MID> outputMIDsByName) throws Exception {

		//TODO MMINT[NESTED] Add all new operations in mid.ecore + javadoc
		//TODO MMINT[NESTED] Add option to detect when the nested MID is enabled, different from when operator instances are enabled (WorkflowOperator too)
		MMINTException.mustBeInstance(this);

		// create shortcuts to input models
		String nestedMIDPath = this.getNestedMIDPath();
		if (nestedMIDPath != null) {
			EList<Model> inputModels = ECollections.toEList(
				inputs.stream()
					.map(OperatorInput::getModel)
					.collect(Collectors.toList()));
			this.createNestedInstanceMIDModelShortcuts(inputModels, null);
		}
		// run nested operator
		MID nestedMID = this.getNestedInstanceMID();
		Map<String, MID> nestedOutputMIDsByName = MIDOperatorIOUtils.mixOutputMIDsByName(
			nestedOperatorType,
			nestedMID,
			outputMIDsByName);
		Operator newNestedOperator = nestedOperatorType.startInstance(
			inputs,
			inputProperties,
			generics,
			nestedOutputMIDsByName,
			nestedMID);
		// store nested MID
		if (nestedMIDPath != null) {
			this.writeNestedInstanceMID();
		}

		return newNestedOperator;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void deleteInstance() throws MMINTException {

		super.deleteInstance();
		String nestedMIDPath = this.getNestedMIDPath();
		if (nestedMIDPath != null) {
			for (Model nestedModel : new ArrayList<>(this.getNestedInstanceMID().getModels())) {
				nestedModel.deleteInstanceAndFile();
			}
			FileUtils.deleteFile(nestedMIDPath, true);
			FileUtils.deleteFile(nestedMIDPath + GMFUtils.DIAGRAM_SUFFIX, true);
		}
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

		String nestedMIDPath = this.getNestedMIDPath();
		if (nestedMIDPath != null) {
			FileUtils.openEclipseEditor(nestedMIDPath + GMFUtils.DIAGRAM_SUFFIX, MIDTypeRegistry.getMIDDiagramType().getId(), true);
		}
	}

} //NestingOperatorImpl

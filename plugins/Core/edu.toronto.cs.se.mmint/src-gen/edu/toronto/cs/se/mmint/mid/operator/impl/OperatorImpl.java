/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.impl.GenericElementImpl;
import edu.toronto.cs.se.mmint.mid.library.MultiModelOperatorUtils;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.operator.ConversionOperator;
import edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorFactory;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmint.mid.ui.MultiModelDiagramUtils;
import edu.toronto.cs.se.mmint.repository.MMINTConstants;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl#getGenerics <em>Generics</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl#getInputSubdir <em>Input Subdir</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl#getPreviousOperator <em>Previous Operator</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl#isUpdateMID <em>Update MID</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl#getExecutionTime <em>Execution Time</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl#isCommutative <em>Commutative</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperatorImpl extends GenericElementImpl implements Operator {
	/**
	 * The cached value of the '{@link #getInputs() <em>Inputs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputs()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelEndpoint> inputs;

	/**
	 * The cached value of the '{@link #getOutputs() <em>Outputs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputs()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelEndpoint> outputs;

	/**
	 * The cached value of the '{@link #getGenerics() <em>Generics</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenerics()
	 * @generated
	 * @ordered
	 */
	protected EList<GenericEndpoint> generics;

	/**
	 * The default value of the '{@link #getInputSubdir() <em>Input Subdir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputSubdir()
	 * @generated
	 * @ordered
	 */
	protected static final String INPUT_SUBDIR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInputSubdir() <em>Input Subdir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputSubdir()
	 * @generated
	 * @ordered
	 */
	protected String inputSubdir = INPUT_SUBDIR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPreviousOperator() <em>Previous Operator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreviousOperator()
	 * @generated
	 * @ordered
	 */
	protected Operator previousOperator;

	/**
	 * The default value of the '{@link #isUpdateMID() <em>Update MID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUpdateMID()
	 * @generated
	 * @ordered
	 */
	protected static final boolean UPDATE_MID_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUpdateMID() <em>Update MID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUpdateMID()
	 * @generated
	 * @ordered
	 */
	protected boolean updateMID = UPDATE_MID_EDEFAULT;

	/**
	 * The default value of the '{@link #getExecutionTime() <em>Execution Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionTime()
	 * @generated
	 * @ordered
	 */
	protected static final long EXECUTION_TIME_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getExecutionTime() <em>Execution Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionTime()
	 * @generated
	 * @ordered
	 */
	protected long executionTime = EXECUTION_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #isCommutative() <em>Commutative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCommutative()
	 * @generated
	 * @ordered
	 */
	protected static final boolean COMMUTATIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCommutative() <em>Commutative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCommutative()
	 * @generated
	 * @ordered
	 */
	protected boolean commutative = COMMUTATIVE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperatorPackage.Literals.OPERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelEndpoint> getInputs() {
		if (inputs == null) {
			inputs = new EObjectContainmentEList<ModelEndpoint>(ModelEndpoint.class, this, OperatorPackage.OPERATOR__INPUTS);
		}
		return inputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelEndpoint> getOutputs() {
		if (outputs == null) {
			outputs = new EObjectContainmentEList<ModelEndpoint>(ModelEndpoint.class, this, OperatorPackage.OPERATOR__OUTPUTS);
		}
		return outputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GenericEndpoint> getGenerics() {
		if (generics == null) {
			generics = new EObjectContainmentEList<GenericEndpoint>(GenericEndpoint.class, this, OperatorPackage.OPERATOR__GENERICS);
		}
		return generics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInputSubdir() {
		return inputSubdir;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputSubdir(String newInputSubdir) {
		String oldInputSubdir = inputSubdir;
		inputSubdir = newInputSubdir;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorPackage.OPERATOR__INPUT_SUBDIR, oldInputSubdir, inputSubdir));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operator getPreviousOperator() {
		if (previousOperator != null && previousOperator.eIsProxy()) {
			InternalEObject oldPreviousOperator = (InternalEObject)previousOperator;
			previousOperator = (Operator)eResolveProxy(oldPreviousOperator);
			if (previousOperator != oldPreviousOperator) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperatorPackage.OPERATOR__PREVIOUS_OPERATOR, oldPreviousOperator, previousOperator));
			}
		}
		return previousOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operator basicGetPreviousOperator() {
		return previousOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreviousOperator(Operator newPreviousOperator) {
		Operator oldPreviousOperator = previousOperator;
		previousOperator = newPreviousOperator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorPackage.OPERATOR__PREVIOUS_OPERATOR, oldPreviousOperator, previousOperator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUpdateMID() {
		return updateMID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpdateMID(boolean newUpdateMID) {
		boolean oldUpdateMID = updateMID;
		updateMID = newUpdateMID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorPackage.OPERATOR__UPDATE_MID, oldUpdateMID, updateMID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getExecutionTime() {
		return executionTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExecutionTime(long newExecutionTime) {
		long oldExecutionTime = executionTime;
		executionTime = newExecutionTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorPackage.OPERATOR__EXECUTION_TIME, oldExecutionTime, executionTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCommutative() {
		return commutative;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCommutative(boolean newCommutative) {
		boolean oldCommutative = commutative;
		commutative = newCommutative;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorPackage.OPERATOR__COMMUTATIVE, oldCommutative, commutative));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operator getMetatype() {
		ExtendibleElement metatype = super.getMetatype();
		return (metatype == null) ? null : (Operator) metatype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operator getSupertype() {
		ExtendibleElement supertype = super.getSupertype();
		return (supertype == null) ? null : (Operator) supertype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OperatorPackage.OPERATOR__INPUTS:
				return ((InternalEList<?>)getInputs()).basicRemove(otherEnd, msgs);
			case OperatorPackage.OPERATOR__OUTPUTS:
				return ((InternalEList<?>)getOutputs()).basicRemove(otherEnd, msgs);
			case OperatorPackage.OPERATOR__GENERICS:
				return ((InternalEList<?>)getGenerics()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OperatorPackage.OPERATOR__INPUTS:
				return getInputs();
			case OperatorPackage.OPERATOR__OUTPUTS:
				return getOutputs();
			case OperatorPackage.OPERATOR__GENERICS:
				return getGenerics();
			case OperatorPackage.OPERATOR__INPUT_SUBDIR:
				return getInputSubdir();
			case OperatorPackage.OPERATOR__PREVIOUS_OPERATOR:
				if (resolve) return getPreviousOperator();
				return basicGetPreviousOperator();
			case OperatorPackage.OPERATOR__UPDATE_MID:
				return isUpdateMID();
			case OperatorPackage.OPERATOR__EXECUTION_TIME:
				return getExecutionTime();
			case OperatorPackage.OPERATOR__COMMUTATIVE:
				return isCommutative();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case OperatorPackage.OPERATOR__INPUTS:
				getInputs().clear();
				getInputs().addAll((Collection<? extends ModelEndpoint>)newValue);
				return;
			case OperatorPackage.OPERATOR__OUTPUTS:
				getOutputs().clear();
				getOutputs().addAll((Collection<? extends ModelEndpoint>)newValue);
				return;
			case OperatorPackage.OPERATOR__GENERICS:
				getGenerics().clear();
				getGenerics().addAll((Collection<? extends GenericEndpoint>)newValue);
				return;
			case OperatorPackage.OPERATOR__INPUT_SUBDIR:
				setInputSubdir((String)newValue);
				return;
			case OperatorPackage.OPERATOR__PREVIOUS_OPERATOR:
				setPreviousOperator((Operator)newValue);
				return;
			case OperatorPackage.OPERATOR__UPDATE_MID:
				setUpdateMID((Boolean)newValue);
				return;
			case OperatorPackage.OPERATOR__EXECUTION_TIME:
				setExecutionTime((Long)newValue);
				return;
			case OperatorPackage.OPERATOR__COMMUTATIVE:
				setCommutative((Boolean)newValue);
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
			case OperatorPackage.OPERATOR__INPUTS:
				getInputs().clear();
				return;
			case OperatorPackage.OPERATOR__OUTPUTS:
				getOutputs().clear();
				return;
			case OperatorPackage.OPERATOR__GENERICS:
				getGenerics().clear();
				return;
			case OperatorPackage.OPERATOR__INPUT_SUBDIR:
				setInputSubdir(INPUT_SUBDIR_EDEFAULT);
				return;
			case OperatorPackage.OPERATOR__PREVIOUS_OPERATOR:
				setPreviousOperator((Operator)null);
				return;
			case OperatorPackage.OPERATOR__UPDATE_MID:
				setUpdateMID(UPDATE_MID_EDEFAULT);
				return;
			case OperatorPackage.OPERATOR__EXECUTION_TIME:
				setExecutionTime(EXECUTION_TIME_EDEFAULT);
				return;
			case OperatorPackage.OPERATOR__COMMUTATIVE:
				setCommutative(COMMUTATIVE_EDEFAULT);
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
			case OperatorPackage.OPERATOR__INPUTS:
				return inputs != null && !inputs.isEmpty();
			case OperatorPackage.OPERATOR__OUTPUTS:
				return outputs != null && !outputs.isEmpty();
			case OperatorPackage.OPERATOR__GENERICS:
				return generics != null && !generics.isEmpty();
			case OperatorPackage.OPERATOR__INPUT_SUBDIR:
				return INPUT_SUBDIR_EDEFAULT == null ? inputSubdir != null : !INPUT_SUBDIR_EDEFAULT.equals(inputSubdir);
			case OperatorPackage.OPERATOR__PREVIOUS_OPERATOR:
				return previousOperator != null;
			case OperatorPackage.OPERATOR__UPDATE_MID:
				return updateMID != UPDATE_MID_EDEFAULT;
			case OperatorPackage.OPERATOR__EXECUTION_TIME:
				return executionTime != EXECUTION_TIME_EDEFAULT;
			case OperatorPackage.OPERATOR__COMMUTATIVE:
				return commutative != COMMUTATIVE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case OperatorPackage.OPERATOR___GET_METATYPE:
				return getMetatype();
			case OperatorPackage.OPERATOR___GET_SUPERTYPE:
				return getSupertype();
			case OperatorPackage.OPERATOR___DELETE_TYPE:
				try {
					deleteType();
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case OperatorPackage.OPERATOR___FIND_ALLOWED_INPUTS__ELIST:
				try {
					return findAllowedInputs((EList<MultiModel>)arguments.get(0));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case OperatorPackage.OPERATOR___FIND_FIRST_ALLOWED_INPUT__ELIST:
				try {
					return findFirstAllowedInput((EList<MultiModel>)arguments.get(0));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case OperatorPackage.OPERATOR___CHECK_ALLOWED_INPUTS__ELIST:
				try {
					return checkAllowedInputs((EList<Model>)arguments.get(0));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case OperatorPackage.OPERATOR___IS_ALLOWED_INPUT__MAP:
				try {
					return isAllowedInput((Map<String, Model>)arguments.get(0));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case OperatorPackage.OPERATOR___GET_OUTPUTS_BY_NAME:
				try {
					return getOutputsByName();
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case OperatorPackage.OPERATOR___CREATE_INSTANCE__MULTIMODEL:
				try {
					return createInstance((MultiModel)arguments.get(0));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case OperatorPackage.OPERATOR___DELETE_INSTANCE:
				try {
					deleteInstance();
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case OperatorPackage.OPERATOR___IS_ALLOWED_TARGET_GENERIC__GENERICENDPOINT_GENERICELEMENT_ELIST:
				try {
					return isAllowedTargetGeneric((GenericEndpoint)arguments.get(0), (GenericElement)arguments.get(1), (EList<OperatorInput>)arguments.get(2));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case OperatorPackage.OPERATOR___GET_INPUT_PROPERTIES:
				return getInputProperties();
			case OperatorPackage.OPERATOR___READ_INPUT_PROPERTIES__PROPERTIES:
				try {
					readInputProperties((Properties)arguments.get(0));
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case OperatorPackage.OPERATOR___INIT:
				try {
					init();
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case OperatorPackage.OPERATOR___RUN__MAP_MAP_MAP:
				try {
					return run((Map<String, Model>)arguments.get(0), (Map<String, GenericElement>)arguments.get(1), (Map<String, MultiModel>)arguments.get(2));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case OperatorPackage.OPERATOR___START__ELIST_MAP_MULTIMODEL:
				try {
					return start((EList<OperatorInput>)arguments.get(0), (Map<String, MultiModel>)arguments.get(1), (MultiModel)arguments.get(2));
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
	public String toStringGen() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (inputSubdir: ");
		result.append(inputSubdir);
		result.append(", updateMID: ");
		result.append(updateMID);
		result.append(", executionTime: ");
		result.append(executionTime);
		result.append(", commutative: ");
		result.append(commutative);
		result.append(')');
		return result.toString();
	}

	/**
	 * @generated NOT
	 */
	@Override
	public String toString() {

		String label = (getName() == null) ? "" : getName();
		if (!getGenerics().isEmpty()) {
			label +=
				"<" +
				getGenerics().stream()
					.map(GenericEndpoint::getName)
					.collect(Collectors.joining(",")) +
				">";
		}

		return label;
	}

	/**
	 * @generated NOT
	 */
	public void deleteType() throws MMINTException {

		MMINTException.mustBeType(this);

		MultiModel multiModel = MultiModelRegistry.getMultiModel(this);
		// delete the "thing"
		getInputs().forEach(modelTypeEndpoint -> super.delete(modelTypeEndpoint.getUri(), multiModel));
		getOutputs().forEach(modelTypeEndpoint -> super.delete(modelTypeEndpoint.getUri(), multiModel));
		getGenerics().forEach(genericTypeEndpoint -> super.delete(genericTypeEndpoint.getUri(), multiModel));
		super.deleteType();
		multiModel.getOperators().remove(this);
		// delete the subtypes of the "thing"
		for (Operator operatorSubtype : MultiModelTypeHierarchy.getDirectSubtypes(this, multiModel)) {
			operatorSubtype.deleteType();
		}
	}

	/**
	 * Computes the cartesian product of allowed input models for each formal parameters of this operator type.
	 * 
	 * @param modelTypeEndpointInputs
	 *            The allowed input models for each formal parameter.
	 * @return A set of allowed inputs to the operator type, including necessary conversions.
	 * @generated NOT
	 */
	private @NonNull Set<EList<OperatorInput>> getOperatorTypeInputs(@NonNull EList<EList<OperatorInput>> modelTypeEndpointInputs, boolean firstOnly) {

		Set<EList<OperatorInput>> operatorTypeInputSet = new HashSet<>();
		// if at least one is empty, there is no way to have a proper input for this operator
		if (modelTypeEndpointInputs.stream().anyMatch(modelTypeEndpointInput -> modelTypeEndpointInput.isEmpty())) {
			return operatorTypeInputSet;
		}
		Set<Set<Model>> operatorTypeInputSetCommutative = new HashSet<>();
		int[] indexes = new int[modelTypeEndpointInputs.size()];
		for (int i = 0; i < indexes.length; i++) {
			indexes[i] = 0;
		}
		while (true) {
			// get current inputs
			EList<OperatorInput> operatorTypeInputs = new BasicEList<>();
			for (int i = 0; i < indexes.length; i++) {
				EList<OperatorInput> modelTypeEndpointInput = modelTypeEndpointInputs.get(i);
				operatorTypeInputs.add(modelTypeEndpointInput.get(indexes[i]));
			}
			try {
				// add only if allowed and passes commutativity check
				Map<String, Model> inputsByName = createInputsByName(operatorTypeInputs, false, null);
				if (this.isAllowedInput(inputsByName)) {
					boolean commutative = false;
					if (this.isCommutative()) {
						Set<Model> operatorTypeInputsCommutative = new HashSet<>(inputsByName.values());
						if (operatorTypeInputSetCommutative.contains(operatorTypeInputsCommutative)) {
							commutative = true;
						}
						else {
							operatorTypeInputSetCommutative.add(operatorTypeInputsCommutative);
						}
					}
					if (!commutative) {
						operatorTypeInputSet.add(operatorTypeInputs);
						if (firstOnly) { // just return the first allowed
							return operatorTypeInputSet;
						}
					}
				}
			}
			catch (Exception e) {
				// do nothing
			}
			// move indexes
			int j = indexes.length - 1;
			while (true) {
				indexes[j] += 1;
				if (indexes[j] < modelTypeEndpointInputs.get(j).size()) {
					break;
				}
				indexes[j] = 0;
				j -= 1;
				if (j < 0) { // overflow, cartesian product done
					return operatorTypeInputSet;
				}
			}
		}
	}

	/**
	 * @generated NOT
	 */
	private @NonNull EList<EList<OperatorInput>> getModelTypeEndpointInputs(@NonNull EList<MultiModel> inputMIDs) {

		//TODO MMINT[OPERATOR] Unify with checkAllowedInputs()
		//TODO MMINT[MAP] Add support for upper bound = -1
		EList<EList<OperatorInput>> modelTypeEndpointInputs = new BasicEList<>();
		for (int i = 0; i < this.getInputs().size(); i++) {
			ModelEndpoint inputModelTypeEndpoint = this.getInputs().get(i);
			// TODO MMINT[MAP] Add support for arbitrary combinations of input MIDs to input arguments
			MultiModel inputMID;
			if (inputMIDs.size() == 1) {
				inputMID = inputMIDs.get(0);
			}
			else if (i < inputMIDs.size()) {
				inputMID = inputMIDs.get(i);
			}
			else {
				inputMID = inputMIDs.get(inputMIDs.size()-1);
			}
			EList<OperatorInput> modelTypeEndpointInputSet = new BasicEList<>();
			modelTypeEndpointInputs.add(modelTypeEndpointInputSet);
			for (Model inputModel : MultiModelRegistry.getModels(inputMID)) {
				List<ConversionOperator> conversions = MultiModelTypeHierarchy.instanceOf(
					inputModel,
					inputModelTypeEndpoint.getTargetUri());
				if (conversions == null) {
					continue;
				}
				OperatorInput operatorInput = OperatorFactory.eINSTANCE.createOperatorInput();
				operatorInput.setModel(inputModel);
				operatorInput.getConversions().addAll(conversions);
				operatorInput.setModelTypeEndpoint(inputModelTypeEndpoint);
				modelTypeEndpointInputSet.add(operatorInput);
			}
		}

		return modelTypeEndpointInputs;
	}

	/**
	 * @generated NOT
	 */
	public Set<EList<OperatorInput>> findAllowedInputs(EList<MultiModel> inputMIDs) throws MMINTException {

		MMINTException.mustBeType(this);

		// get inputs by model type endpoint
		EList<EList<OperatorInput>> modelTypeEndpointInputs = getModelTypeEndpointInputs(inputMIDs);
		// do cartesian product of inputs
		Set<EList<OperatorInput>> operatorTypeInputSet = getOperatorTypeInputs(modelTypeEndpointInputs, false);

		return operatorTypeInputSet;
	}

	/**
	 * @generated NOT
	 */
	public EList<OperatorInput> findFirstAllowedInput(EList<MultiModel> inputMIDs) throws MMINTException {

		MMINTException.mustBeType(this);

		// get inputs by model type endpoint
		EList<EList<OperatorInput>> modelTypeEndpointInputs = getModelTypeEndpointInputs(inputMIDs);
		// get the first allowed input
		Set<EList<OperatorInput>> operatorTypeInputSet = getOperatorTypeInputs(modelTypeEndpointInputs, true);
		if (operatorTypeInputSet.isEmpty()) {
			return null;
		}

		return operatorTypeInputSet.iterator().next();
	}

	/**
	 * @generated NOT
	 */
	public EList<OperatorInput> checkAllowedInputs(EList<Model> inputModels) throws MMINTException {

		MMINTException.mustBeType(this);

		// check actual parameters
		EList<OperatorInput> inputs = new BasicEList<>();
		int i = 0;
		for (ModelEndpoint inputModelTypeEndpoint : getInputs()) {
			// check 1: not enough actual parameters, considering formal parameters with upper bound > 1 too
			if (i >= inputModels.size()) {
				return null;
			}
			// check 2: type or substitutable types
			while (i < inputModels.size()) {
				Model inputModel = inputModels.get(i); // == actual parameter
				Model inputModelType = inputModelTypeEndpoint.getTarget(); // == formal parameter
				List<ConversionOperator> conversions = MultiModelTypeHierarchy.instanceOf(inputModel, inputModelType.getUri());
				if (conversions == null) {
					return null;
				}
				OperatorInput input = OperatorFactory.eINSTANCE.createOperatorInput();
				input.setModel(inputModel);
				input.setModelTypeEndpoint(inputModelTypeEndpoint);
				if (!conversions.isEmpty()) {
					input.getConversions().addAll(conversions);
				}
				inputs.add(input);
				i++;
				if (inputModelTypeEndpoint.getUpperBound() == 1) {
					break;
				}
			}
		}
		// check 3: too many actual parameters
		if (i < inputModels.size()) {
			return null;
		}
		// check 4: operator-specific constraints other than types (e.g. 2 model rels as input connected by same model)
		Map<String, Model> inputsByName = null;
		try {
			inputsByName = createInputsByName(inputs, false, null);
		}
		catch (Exception e) {
			// never happens
		}
		if (!this.isAllowedInput(inputsByName)) {
			//TODO MMINT[OPERATOR] Can there be conflicts since conversions are not run?
			return null;
		}

		return inputs;
	}

	/**
	 * @generated NOT
	 */
	public boolean isAllowedInput(Map<String, Model> inputsByName) throws MMINTException {

		MMINTException.mustBeType(this);

		return true;
	}

	/**
	 * @generated NOT
	 */
	public Map<String, Model> getOutputsByName() throws MMINTException {

		MMINTException.mustBeInstance(this);

		Map<String, Model> outputsByName = new HashMap<>();
		this.getOutputs().stream()
			.collect(Collectors.toMap(
				outputModelEndpoint -> outputModelEndpoint.getName(),
				outputModelEndpoint -> outputModelEndpoint.getTarget()));

		return outputsByName;
	}

	/**
	 * @generated NOT
	 */
	public Operator createInstance(MultiModel instanceMID) throws MMINTException {

		MMINTException.mustBeType(this);

		Operator newOperator;
		try {
			newOperator = this.getClass().newInstance();
		}
		catch (Exception e) {
			throw new MMINTException("Can't invoke constructor");
		}
		super.addBasicInstance(newOperator, null, getName());
		newOperator.setCommutative(false);
		if (instanceMID != null) {
			instanceMID.getOperators().add(newOperator);
		}

		return newOperator;
	}

	/**
	 * @generated NOT
	 */
	public void deleteInstance() throws MMINTException {

		MMINTException.mustBeInstance(this);

		MultiModel instanceMID = MultiModelRegistry.getMultiModel(this);
		instanceMID.getOperators().remove(this);
	}

	/**
	 * @generated NOT
	 */
	public boolean isAllowedTargetGeneric(GenericEndpoint genericTypeEndpoint, GenericElement genericType, EList<OperatorInput> inputs) throws MMINTException {

		MMINTException.mustBeType(this);

		return true;
	}

	/**
	 * Gets the uri of the properties file of this operator.
	 * 
	 * @param suffix
	 *            The suffix of the properties file.
	 * @return The uri of the properties file.
	 * @generated NOT
	 */
	private String getPropertiesUri(String suffix) {

		IFile midDiagram = (IFile) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().getEditorInput().getAdapter(IFile.class);
		String propertiesUri = MultiModelUtils.prependWorkspaceToUri(midDiagram.getParent().getFullPath().toString());
		propertiesUri += IPath.SEPARATOR + this.getName() + suffix + MultiModelOperatorUtils.PROPERTIES_SUFFIX;

		return propertiesUri;
	}

	/**
	 * @generated NOT
	 */
	public Properties getInputProperties() {

		String propertiesUri =  getPropertiesUri(MultiModelOperatorUtils.INPUT_PROPERTIES_SUFFIX);
		Properties inputProperties = new Properties();
		try {
			inputProperties.load(new FileInputStream(propertiesUri));
		}
		catch (Exception e) {
			// do nothing
		}

		return inputProperties;
	}

	/**
	 * @generated NOT
	 */
	public void readInputProperties(Properties inputProperties) throws MMINTException {

		setUpdateMID(
			MultiModelOperatorUtils.getOptionalBoolProperty(inputProperties, MultiModelOperatorUtils.PROPERTY_IN_UPDATEMID, true)
		);
		setInputSubdir(
			MultiModelOperatorUtils.getOptionalStringProperty(inputProperties, MultiModelOperatorUtils.PROPERTY_IN_SUBDIR, null)
		);
	}

	/**
	 * @generated NOT
	 */
	public void init() throws MMINTException {

		// do nothing
	}

	/**
	 * @generated NOT
	 */
	public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MultiModel> outputMIDsByName) throws Exception {

		throw new MMINTException("The default run() function must be overridden");
	}

	/**
	 * @generated NOT
	 */
	private Map<String, Model> createInputsByName(EList<OperatorInput> inputs, boolean runConversions, Operator newOperator) throws Exception {

		Map<String, Model> inputsByName = new HashMap<>();
		for (OperatorInput input : inputs) {
			ModelEndpoint modelEndpoint = null;
			if (newOperator != null) {
				modelEndpoint = input.getModelTypeEndpoint().createInstance(
					input.getModel(),
					newOperator,
					OperatorPackage.eINSTANCE.getOperator_Inputs().getName()
				);
			}
			String inputName = input.getModelTypeEndpoint().getName();
			if (input.getModelTypeEndpoint().getUpperBound() == -1) {
				int i = 0;
				while (inputsByName.get(inputName + i) != null) {
					i++;
				}
				inputName += i;
				if (newOperator != null) {
					modelEndpoint.setName(inputName);
				}
			}
			if (input.getConversions().isEmpty() || !runConversions) {
				inputsByName.put(inputName, input.getModel());
				continue;
			}
			Model convertedInputModel = input.getModel();
			for (ConversionOperator conversion : input.getConversions()) {
				Properties inputProperties = conversion.getInputProperties();
				conversion.readInputProperties(inputProperties);
				conversion.init();
				Map<String, Model> conversionInputsByName = new HashMap<>();
				conversionInputsByName.put(conversion.getInputs().get(0).getName(), convertedInputModel);
				Map<String, MultiModel> conversionOutputMIDsByName = new HashMap<>();
				conversionOutputMIDsByName.put(conversion.getOutputs().get(0).getName(), null);
				convertedInputModel = conversion.run(conversionInputsByName, new HashMap<>(), conversionOutputMIDsByName)
					.get(conversion.getOutputs().get(0).getName());
			}
			inputsByName.put(inputName, convertedInputModel);
		}

		return inputsByName;
	}

	/**
	 * @generated NOT
	 */
	public Operator start(EList<OperatorInput> inputs, Map<String, MultiModel> outputMIDsByName, MultiModel instanceMID) throws Exception {

		MMINTException.mustBeType(this);

		//TODO MMINT[OPERATOR] Run in its own thread to avoid blocking the user interface
		if (!Boolean.parseBoolean(MMINT.getPreference(MMINTConstants.PREFERENCE_MENU_OPERATORS_ENABLED))) {
			instanceMID = null;
		}
		Operator newOperator = this.createInstance(instanceMID);
		// generics
		Map<String, GenericElement> genericsByName = new HashMap<>();
		for (GenericEndpoint genericSuperTypeEndpoint : this.getGenerics()) {
			GenericElement genericType = MultiModelDiagramUtils.selectGenericTypeToCreate(genericSuperTypeEndpoint, inputs);
			genericSuperTypeEndpoint.createInstance(genericType, newOperator);
			genericsByName.put(genericSuperTypeEndpoint.getName(), genericType);
		}
		// inputs and conversions
		Map<String, Model> inputsByName = createInputsByName(inputs, true, (instanceMID == null) ? null : newOperator);
		// run operator
		Properties inputProperties = newOperator.getInputProperties();
		newOperator.readInputProperties(inputProperties);
		newOperator.init();
		long startTime = System.nanoTime();
		Map<String, Model> outputsByName = newOperator.run(inputsByName, genericsByName, outputMIDsByName);
		newOperator.setExecutionTime(System.nanoTime()-startTime);
		// outputs
		for (ModelEndpoint outputModelTypeEndpoint : this.getOutputs()) {
			List<Model> outputModels;
			if (outputModelTypeEndpoint.getUpperBound() == -1) {
				outputModels = MultiModelOperatorUtils.getVarargs(outputsByName, outputModelTypeEndpoint.getName());
			}
			else {
				outputModels = new ArrayList<>();
				outputModels.add(outputsByName.get(outputModelTypeEndpoint.getName()));
			}
			for (Model outputModel : outputModels) {
				outputModelTypeEndpoint.createInstance(
					outputModel,
					newOperator,
					OperatorPackage.eINSTANCE.getOperator_Outputs().getName()
				);
			}
		}
		// clean up conversions
		for (OperatorInput input : inputs) {
			if (input.getConversions().isEmpty()) {
				continue;
			}
			for (ConversionOperator conversion : input.getConversions()) {
				conversion.cleanup();
			}
		}

		return newOperator;
	}

} //OperatorImpl

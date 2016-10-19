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

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
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
import org.eclipse.jdt.annotation.Nullable;
import org.osgi.framework.Bundle;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTConstants;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.impl.GenericElementImpl;
import edu.toronto.cs.se.mmint.mid.operator.ConversionOperator;
import edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorConstraint;
import edu.toronto.cs.se.mmint.mid.operator.OperatorConstraintParameter;
import edu.toronto.cs.se.mmint.mid.operator.OperatorConstraintRule;
import edu.toronto.cs.se.mmint.mid.operator.OperatorFactory;
import edu.toronto.cs.se.mmint.mid.operator.OperatorGeneric;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmint.mid.reasoning.MIDConstraintChecker;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
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
	 * @generated NOT
	 */
	public OperatorImpl() {
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
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == ExtendibleElement.class) {
			switch (baseOperationID) {
				case MIDPackage.EXTENDIBLE_ELEMENT___GET_METATYPE: return OperatorPackage.OPERATOR___GET_METATYPE;
				case MIDPackage.EXTENDIBLE_ELEMENT___GET_MID_CONTAINER: return OperatorPackage.OPERATOR___GET_MID_CONTAINER;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
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
			case OperatorPackage.OPERATOR___GET_MID_CONTAINER:
				return getMIDContainer();
			case OperatorPackage.OPERATOR___CREATE_SUBTYPE__STRING_STRING:
				try {
					return createSubtype((String)arguments.get(0), (String)arguments.get(1));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case OperatorPackage.OPERATOR___DELETE_TYPE:
				try {
					deleteType();
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case OperatorPackage.OPERATOR___OPEN_TYPE:
				try {
					openType();
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case OperatorPackage.OPERATOR___FIND_ALLOWED_INPUTS__ELIST:
				try {
					return findAllowedInputs((EList<MID>)arguments.get(0));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case OperatorPackage.OPERATOR___FIND_FIRST_ALLOWED_INPUT__ELIST:
				try {
					return findFirstAllowedInput((EList<MID>)arguments.get(0));
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
			case OperatorPackage.OPERATOR___GET_OUTPUTS_BY_NAME:
				try {
					return getOutputsByName();
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case OperatorPackage.OPERATOR___GET_OUTPUT_MODELS:
				try {
					return getOutputModels();
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case OperatorPackage.OPERATOR___CREATE_INSTANCE__MID:
				try {
					return createInstance((MID)arguments.get(0));
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
			case OperatorPackage.OPERATOR___SELECT_ALLOWED_GENERICS__ELIST:
				try {
					return selectAllowedGenerics((EList<OperatorInput>)arguments.get(0));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case OperatorPackage.OPERATOR___IS_ALLOWED_GENERIC__GENERICENDPOINT_GENERICELEMENT_ELIST:
				try {
					return isAllowedGeneric((GenericEndpoint)arguments.get(0), (GenericElement)arguments.get(1), (EList<OperatorInput>)arguments.get(2));
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
			case OperatorPackage.OPERATOR___RUN__MAP_MAP_MAP:
				try {
					return run((Map<String, Model>)arguments.get(0), (Map<String, GenericElement>)arguments.get(1), (Map<String, MID>)arguments.get(2));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case OperatorPackage.OPERATOR___START_INSTANCE__ELIST_PROPERTIES_ELIST_MAP_MID:
				try {
					return startInstance((EList<OperatorInput>)arguments.get(0), (Properties)arguments.get(1), (EList<OperatorGeneric>)arguments.get(2), (Map<String, MID>)arguments.get(3), (MID)arguments.get(4));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case OperatorPackage.OPERATOR___OPEN_INSTANCE:
				try {
					openInstance();
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case OperatorPackage.OPERATOR___CREATE_WORKFLOW_INSTANCE__MID:
				try {
					return createWorkflowInstance((MID)arguments.get(0));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case OperatorPackage.OPERATOR___DELETE_WORKFLOW_INSTANCE:
				try {
					deleteWorkflowInstance();
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case OperatorPackage.OPERATOR___START_WORKFLOW_INSTANCE__ELIST_ELIST_MID:
				try {
					return startWorkflowInstance((EList<OperatorInput>)arguments.get(0), (EList<OperatorGeneric>)arguments.get(1), (MID)arguments.get(2));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case OperatorPackage.OPERATOR___OPEN_WORKFLOW_INSTANCE:
				try {
					openWorkflowInstance();
					return null;
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
	public MID getMIDContainer() {
		return (MID) this.eContainer();
	}

	/**
	 * Adds a subtype of this operator type to the Type MID.
	 * 
	 * @param newOperatorType
	 *            The new operator type to be added.
	 * @param newOperatorTypeName
	 *            The name of the new operator type.
	 * @param implementationUri
	 *            The uri of the new operator's implementation (a Java class inheriting from this class).
	 * @throws MMINTException
	 *             If the uri of the new operator type is already registered in the Type MID.
	 * @generated NOT
	 */
	protected void addSubtype(Operator newOperatorType, String newOperatorTypeName, String implementationUri) throws MMINTException {

		//TODO MMINT[OPERATOR] Implement a simple way to run a java class pointed by implementationUri
	}

	/**
	 * @generated NOT
	 */
	public Operator createSubtype(String newOperatorTypeName, String implementationUri) throws MMINTException {

		MMINTException.mustBeType(this);

		Operator newOperatorType = super.createThisEClass();
		this.addSubtype(newOperatorType, newOperatorTypeName, implementationUri);

		return newOperatorType;
	}

	/**
	 * @generated NOT
	 */
	public void deleteType() throws MMINTException {

		MMINTException.mustBeType(this);

		MID typeMID = this.getMIDContainer();
		// delete the "thing"
		getInputs().forEach(modelTypeEndpoint -> super.delete(modelTypeEndpoint.getUri(), typeMID));
		getOutputs().forEach(modelTypeEndpoint -> super.delete(modelTypeEndpoint.getUri(), typeMID));
		getGenerics().forEach(genericTypeEndpoint -> super.delete(genericTypeEndpoint.getUri(), typeMID));
		super.delete();
		typeMID.getOperators().remove(this);
		// delete the subtypes of the "thing"
		for (Operator operatorSubtype : MIDTypeHierarchy.getDirectSubtypes(this, typeMID)) {
			operatorSubtype.deleteType();
		}
	}

	/**
	 * @generated NOT
	 */
	public void openType() throws Exception {

		MMINTException.mustBeType(this);

		// get java source file from bundle
		Bundle bundle = MIDTypeRegistry.getTypeBundle(this.getUri());
		if (bundle == null) {
			throw new MMINTException("Can't find " + this.getName() + " bundle");
		}
		String javaFileName = this.getClass().getSimpleName() + ".java";
		String bundleFilePath = this.getClass().getProtectionDomain().getCodeSource().getLocation().getFile();
		String operatorImplPath;
		if (bundleFilePath.endsWith("jar")) { // binary installation
			int separator = bundleFilePath.lastIndexOf("_");
			bundleFilePath = bundleFilePath.substring(0, separator) + ".source" + bundleFilePath.substring(separator);
			if (!FileUtils.isFile(bundleFilePath, false)) {
				throw new MMINTException("Can't find the source java file for " + this.getName() + " (did you install mmint.sdk?)");
			}
			JarFile bundleJar = new JarFile(new File(bundleFilePath));
			ZipEntry bundleJarEntry = bundleJar.getEntry(this.getClass().getName().replace(".", File.separator) + ".java");
			Path tmpFilePath = Paths.get(System.getProperty("java.io.tmpdir") + "/" + javaFileName);
			Files.copy(bundleJar.getInputStream(bundleJarEntry), tmpFilePath, StandardCopyOption.REPLACE_EXISTING);
			operatorImplPath = tmpFilePath.toString();
			bundleJar.close();
		}
		else { // running from the sources
			Enumeration<URL> bundleEntries = bundle.findEntries("/", javaFileName, true);
			if (bundleEntries == null || !bundleEntries.hasMoreElements()) {
				throw new MMINTException("Can't find the source java file for " + this.getName());
			}
			operatorImplPath = FileLocator.toFileURL(bundleEntries.nextElement()).getFile();
		}

		// open editor
		FileUtils.openEclipseEditor(operatorImplPath, null, false);
	}

	/**
	 * Computes the cartesian product of inputs for this operator type.
	 * 
	 * @param modelTypeEndpointInputs
	 *            The allowed inputs for each formal parameter.
	 * @param firstOnly
	 *            True if only the first input is returned, false if the whole cartesian product is returned.
	 * @return A set of inputs to the operator type, including necessary conversions.
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
				if (MIDConstraintChecker.checkOperatorInputConstraint(this, inputsByName)) {
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
	 * Checks if an input model can be used as actual parameter for a formal parameter of an operator type.
	 * 
	 * @param inputModelTypeEndpoint
	 *            The model type endpoint representing the formal parameter of an operator type.
	 * @param inputModel
	 *            The input model.
	 * @return The input to the operator, including necessary conversions, or null if the input model can't be used.
	 * @generated NOT
	 */
	private @Nullable OperatorInput checkAllowedInput(@NonNull ModelEndpoint inputModelTypeEndpoint, @NonNull Model inputModel) {

		List<ConversionOperator> conversions = MIDTypeHierarchy.instanceOf(inputModel, inputModelTypeEndpoint.getTargetUri());
		if (conversions == null) {
			return null;
		}
		OperatorInput input = OperatorFactory.eINSTANCE.createOperatorInput();
		input.setModel(inputModel);
		input.setModelTypeEndpoint(inputModelTypeEndpoint);
		input.getConversions().addAll(conversions);

		return input;
	}

	/**
	 * Gets all allowed inputs for each formal parameter of this operator type.
	 * 
	 * @param inputMIDs
	 *            A list of instance MIDs where to get input models. Each formal parameter gets input models from a
	 *            different instance MID, following their order. If there are not enough instance MIDs, the last
	 *            instance MID is used for all subsequent formal parameters.
	 * @return The allowed inputs for each formal parameter, including necessary conversions.
	 * @generated NOT
	 */
	private @NonNull EList<EList<OperatorInput>> getModelTypeEndpointInputs(@NonNull EList<MID> inputMIDs) {

		//TODO MMINT[MAP] Add support for upper bound = -1
		EList<EList<OperatorInput>> modelTypeEndpointInputs = new BasicEList<>();
		for (int i = 0; i < this.getInputs().size(); i++) {
			ModelEndpoint inputModelTypeEndpoint = this.getInputs().get(i);
			// TODO MMINT[MAP] Add support for arbitrary combinations of input MIDs to input arguments
			MID inputMID;
			if (i < inputMIDs.size()) {
				inputMID = inputMIDs.get(i);
			}
			else {
				inputMID = inputMIDs.get(inputMIDs.size()-1);
			}
			EList<OperatorInput> modelTypeEndpointInputSet = new BasicEList<>();
			modelTypeEndpointInputs.add(modelTypeEndpointInputSet);
			for (Model inputModel : inputMID.getModels()) {
				OperatorInput operatorInput = checkAllowedInput(inputModelTypeEndpoint, inputModel);
				if (operatorInput == null) {
					continue;
				}
				modelTypeEndpointInputSet.add(operatorInput);
			}
		}

		return modelTypeEndpointInputs;
	}

	/**
	 * @generated NOT
	 */
	public Set<EList<OperatorInput>> findAllowedInputs(EList<MID> inputMIDs) throws MMINTException {

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
	public EList<OperatorInput> findFirstAllowedInput(EList<MID> inputMIDs) throws MMINTException {

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
				OperatorInput operatorInput = this.checkAllowedInput(inputModelTypeEndpoint, inputModels.get(i));
				if (operatorInput == null) {
					return null;
				}
				inputs.add(operatorInput);
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
			inputsByName = this.createInputsByName(inputs, false, null);
		}
		catch (Exception e) {
			// never happens
		}
		if (!MIDConstraintChecker.checkOperatorInputConstraint(this, inputsByName)) {
			//TODO MMINT[OPERATOR] Can there be conflicts since conversions are not run?
			return null;
		}

		return inputs;
	}

	/**
	 * @generated NOT
	 */
	public Map<String, Model> getOutputsByName() throws MMINTException {

		MMINTException.mustBeInstance(this);

		return this.getOutputs().stream()
			.collect(Collectors.toMap(
				outputModelEndpoint -> outputModelEndpoint.getName(),
				outputModelEndpoint -> outputModelEndpoint.getTarget()));
	}

	/**
	 * @generated NOT
	 */
	public EList<Model> getOutputModels() throws MMINTException {

		MMINTException.mustBeInstance(this);

		return new BasicEList<>(
			this.getOutputs().stream()
				.map(outputModelEndpoint -> outputModelEndpoint.getTarget())
				.collect(Collectors.toList()));
	}

	/**
	 * Adds an operator instance of this operator type to an Instance or Workflow MID.
	 * 
	 * @param newOperator
	 *            The new operator to be added.
	 * @param midLevel
	 *            The kind of MID (Instance or Workflow) that could contain the new operator, regardless of whether it
	 *            is or isn't going to be contained in one.
	 * @param instanceMID
	 *            An Instance or Workflow MID, null if the operator isn't going to be contained in one.
	 * @generated NOT
	 */
	protected void addInstance(@NonNull Operator newOperator, @NonNull MIDLevel midLevel, @Nullable MID instanceMID) {

		super.addBasicInstance(newOperator, null, this.getName(), midLevel);
		newOperator.setCommutative(false);
		if (instanceMID != null) {
			instanceMID.getOperators().add(newOperator);
		}
	}

	/**
	 * @generated NOT
	 */
	public Operator createInstance(MID instanceMID) throws MMINTException {

		MMINTException.mustBeType(this);

		Operator newOperator;
		try {
			newOperator = this.getClass().newInstance();
		}
		catch (Exception e) {
			throw new MMINTException("Can't invoke constructor");
		}
		if (this.getPreviousOperator() != null) {
			newOperator.setPreviousOperator(this.getPreviousOperator());
		}
		this.addInstance(newOperator, MIDLevel.INSTANCES, instanceMID);

		return newOperator;
	}

	/**
	 * Deletes this operator instance from an Instance or Workflow MID.
	 * 
	 * @param instanceMID
	 *            The Instance or Workflow MID that contains the operator.
	 * 
	 * @generated NOT
	 */
	protected void deleteInstance(MID instanceMID) {

		instanceMID.getOperators().remove(this);
	}

	/**
	 * @generated NOT
	 */
	public void deleteInstance() throws MMINTException {

		MMINTException.mustBeInstance(this);

		this.deleteInstance(this.getMIDContainer());
	}

	/**
	 * @generated NOT
	 */
	public EList<OperatorGeneric> selectAllowedGenerics(EList<OperatorInput> inputs) throws MMINTException {

		MMINTException.mustBeType(this);

		EList<OperatorGeneric> generics = new BasicEList<>();
		for (GenericEndpoint genericSuperTypeEndpoint : this.getGenerics()) {
			GenericElement genericType = MIDDialogs.selectGenericTypeToCreate(genericSuperTypeEndpoint, inputs);
			OperatorGeneric generic = OperatorFactory.eINSTANCE.createOperatorGeneric();
			generic.setGenericSuperTypeEndpoint(genericSuperTypeEndpoint);
			generic.setGeneric(genericType);
			generics.add(generic);
		}

		return generics;
	}

	/**
	 * @generated NOT
	 */
	public boolean isAllowedGeneric(GenericEndpoint genericTypeEndpoint, GenericElement genericType, EList<OperatorInput> inputs) throws MMINTException {

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
	private String getPropertiesUri(@NonNull String suffix) {

		IFile instanceMIDFile = MMINT.getActiveInstanceMIDFile();
		if (instanceMIDFile == null) { // can happen when an operator is invoked from a model editor
			return null;
		}
		String propertiesUri = FileUtils.prependWorkspacePath(instanceMIDFile.getParent().getFullPath().toString());
		propertiesUri += IPath.SEPARATOR + this.getName() + suffix + MIDOperatorIOUtils.PROPERTIES_SUFFIX;

		return propertiesUri;
	}

	/**
	 * @generated NOT
	 */
	public Properties getInputProperties() {

		String propertiesUri =  getPropertiesUri(MIDOperatorIOUtils.INPUT_PROPERTIES_SUFFIX);
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
			MIDOperatorIOUtils.getOptionalBoolProperty(inputProperties, MIDOperatorIOUtils.PROPERTY_IN_UPDATEMID, true)
		);
		setInputSubdir(
			MIDOperatorIOUtils.getOptionalStringProperty(inputProperties, MIDOperatorIOUtils.PROPERTY_IN_SUBDIR, null)
		);
	}

	/**
	 * @generated NOT
	 */
	public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MID> outputMIDsByName) throws Exception {

		throw new MMINTException("The default run() function must be overridden");
	}

	/**
	 * Creates a map of input model instances, identified by their formal parameter name.
	 * 
	 * @param inputs
	 *            A list of inputs to the operator instance, including necessary conversions.
	 * @param runConversions
	 *            True if conversions have to be run, false otherwise.
	 * @param newOperator
	 *            The operator instance that will be invoked with the input models, null if operator traceability is not
	 *            needed.
	 * @return The map of input model instances, identified by their formal parameter name.
	 * @throws Exception
	 *             If something went wrong running the conversions.
	 * @generated NOT
	 */
	protected Map<String, Model> createInputsByName(@NonNull EList<OperatorInput> inputs, boolean runConversions, @Nullable Operator newOperator) throws Exception {

		//TODO MMINT[OPERATOR] This is used for two purposes, just to create the map and to populate an operator: split
		boolean coerced = false;
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
			coerced = true;
			Model convertedInputModel = input.getModel();
			for (ConversionOperator conversion : input.getConversions()) {
				//TODO MMINT[WORKFLOW] Implement this as a simplified workflow?
				Properties inputProperties = conversion.getInputProperties();
				conversion.readInputProperties(inputProperties);
				Map<String, Model> conversionInputsByName = new HashMap<>();
				conversionInputsByName.put(conversion.getInputs().get(0).getName(), convertedInputModel);
				Map<String, MID> conversionOutputMIDsByName = new HashMap<>();
				conversionOutputMIDsByName.put(conversion.getOutputs().get(0).getName(), null);
				convertedInputModel = conversion.run(conversionInputsByName, new HashMap<>(), conversionOutputMIDsByName)
					.get(conversion.getOutputs().get(0).getName());
			}
			inputsByName.put(inputName, convertedInputModel);
		}
		if (coerced && newOperator != null) {
			newOperator.setName(newOperator.getName() + " (coerced)");
		}

		return inputsByName;
	}

	/**
	 * Creates a map of generic instances, identified by their name.
	 * 
	 * @param generics
	 *            A list of generic types for the operator instance.
	 * @param newOperator
	 *            The operator instance that will be invoked with the generics.
	 * @return The map of generic instances, identified by their name.
	 * @throws MMINTException
	 *             If any generic type is an instance instead.
	 * @generated NOT
	 */
	private Map<String, GenericElement> createGenericsByName(@NonNull EList<OperatorGeneric> generics, @NonNull Operator newOperator) throws MMINTException {

		Map<String, GenericElement> genericsByName = new HashMap<>();
		for (OperatorGeneric generic : generics) {
			GenericEndpoint genericSuperTypeEndpoint = generic.getGenericSuperTypeEndpoint();
			GenericElement genericType = generic.getGeneric();
			genericSuperTypeEndpoint.createInstance(genericType, newOperator);
			genericsByName.put(genericSuperTypeEndpoint.getName(), genericType);
		}

		return genericsByName;
	}

	/**
	 * @generated NOT
	 */
	public Operator startInstance(EList<OperatorInput> inputs, Properties inputProperties, EList<OperatorGeneric> generics, Map<String, MID> outputMIDsByName, MID instanceMID) throws Exception {

		MMINTException.mustBeType(this);

		//TODO MMINT[OPERATOR] Run in its own thread to avoid blocking the user interface (needs ui parts to be passed for GMFDiagramUtils functions to work)
		if (!Boolean.parseBoolean(MMINT.getPreference(MMINTConstants.PREFERENCE_MENU_OPERATORS_ENABLED))) {
			instanceMID = null;
		}
		Operator newOperator = this.createInstance(instanceMID);
		// generics, inputs and conversions
		Map<String, GenericElement> genericsByName = this.createGenericsByName(generics, newOperator);
		Map<String, Model> inputsByName = this.createInputsByName(inputs, true, newOperator);
		// run operator
		if (inputProperties == null) {
			inputProperties = newOperator.getInputProperties();
		}
		newOperator.readInputProperties(inputProperties);
		long startTime = System.nanoTime();
		Map<String, Model> outputsByName = newOperator.run(inputsByName, genericsByName, outputMIDsByName);
		newOperator.setExecutionTime(System.nanoTime()-startTime);
		// outputs
		for (ModelEndpoint outputModelTypeEndpoint : this.getOutputs()) {
			List<Model> outputModels;
			if (outputModelTypeEndpoint.getUpperBound() == -1) {
				outputModels = MIDOperatorIOUtils.getVarargs(outputsByName, outputModelTypeEndpoint.getName());
			}
			else {
				outputModels = new ArrayList<>();
				outputModels.add(outputsByName.get(outputModelTypeEndpoint.getName()));
			}
			for (int i = 0; i < outputModels.size(); i++) {
				ModelEndpoint outputModelEndpoint = outputModelTypeEndpoint.createInstance(
					outputModels.get(i),
					newOperator,
					OperatorPackage.eINSTANCE.getOperator_Outputs().getName()
				);
				if (outputModelTypeEndpoint.getUpperBound() == -1) {
					outputModelEndpoint.setName(outputModelEndpoint.getName() + i);
				}
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

	/**
	 * Opens the java implementation of the metatype of this operator instance.
	 * 
	 * @throws Exception
	 *             If the java editor can't be opened.
	 * @generated NOT
	 */
	protected void openInstanceMetatype() throws Exception {

		this.getMetatype().openType();
	}

	/**
	 * @generated NOT
	 */
	public void openInstance() throws Exception {

		MMINTException.mustBeInstance(this);

		this.openInstanceMetatype();
	}

	/**
	 * @generated NOT
	 */
	public Operator createWorkflowInstance(MID workflowMID) throws MMINTException {

		MMINTException.mustBeType(this);

		Operator newOperator = OperatorFactory.eINSTANCE.createOperator();
		this.addInstance(newOperator, MIDLevel.WORKFLOWS, workflowMID);

		return newOperator;
	}

	/**
	 * @generated NOT
	 */
	public void deleteWorkflowInstance() throws MMINTException {

		MMINTException.mustBeWorkflow(this);

		this.deleteInstance(this.getMIDContainer());
		for (ModelEndpoint outputModelEndpoint : this.getOutputs()) {
			Model outputModel = outputModelEndpoint.getTarget();
			if (outputModel.getMIDContainer() == null) { // already deleted
				continue;
			}
			outputModel.deleteWorkflowInstance();
		}
	}

	/**
	 * @generated NOT
	 */
	public Operator startWorkflowInstance(EList<OperatorInput> inputs, EList<OperatorGeneric> generics, MID workflowMID) throws MMINTException {

		MMINTException.mustBeType(this);

		Set<String> inputNames = new HashSet<>();
		Operator newOperator = this.createWorkflowInstance(workflowMID);
		// generics and inputs
		for (OperatorGeneric generic : generics) {
			GenericEndpoint genericSuperTypeEndpoint = generic.getGenericSuperTypeEndpoint();
			GenericElement genericType = generic.getGeneric();
			genericSuperTypeEndpoint.createWorkflowInstance(genericType, newOperator);
		}
		for (OperatorInput input : inputs) {
			ModelEndpoint modelEndpoint = input.getModelTypeEndpoint().createWorkflowInstance(
				input.getModel(),
				newOperator,
				OperatorPackage.eINSTANCE.getOperator_Inputs().getName());
			String inputName = input.getModelTypeEndpoint().getName();
			if (input.getModelTypeEndpoint().getUpperBound() == -1) {
				int i = 0;
				while (inputNames.contains(inputName + i) != false) {
					i++;
				}
				inputName += i;
				modelEndpoint.setName(inputName);
			}
			inputNames.add(inputName);
		}
		// outputs
		for (ModelEndpoint outputModelTypeEndpoint : this.getOutputs()) {
			if (outputModelTypeEndpoint.getUpperBound() == -1) {
				try {
					if (this.getClass().getMethod("startWorkflowInstance", EList.class, EList.class, MID.class).getDeclaringClass() == OperatorImpl.class) {
						throw new MMINTException(this.getClass().getSimpleName() + " has a variable number of outputs and must override startWorkflowInstance()");
					}
				}
				catch (NoSuchMethodException | SecurityException e) {
					MMINTException.print(IStatus.WARNING, this.getClass().getSimpleName() + " has a variable number of outputs and startWorkflowInstance() can't be reflected, skipping outputs", e);
				}
				break;
			}
			String outputModelId = MIDRegistry.getNextWorkflowID(workflowMID);
			Model outputModel = outputModelTypeEndpoint.getTarget().createWorkflowInstance(outputModelId, workflowMID);
			outputModelTypeEndpoint.createWorkflowInstance(
				outputModel,
				newOperator,
				OperatorPackage.eINSTANCE.getOperator_Outputs().getName());
		}
		OperatorConstraint constraint = (OperatorConstraint) this.getConstraint();
		if (constraint != null) { // create output model rel endpoints after all outputs are created
			for (OperatorConstraintRule rule : constraint.getRules()) {
				ModelEndpoint outputModelRelTypeEndpoint = rule.getOutputModelRel().getParameterRef().getObject();
				//TODO MMINT[WORKFLOW] Simply do the following when proper operator endpoint types are used
				//newOperator.getOutputs().stream().filter(outputModelEndpoint -> outputModelEndpoint.getMetatype() == outputModelRelTypeEndpoint);
				ModelRel outputModelRel = (ModelRel) newOperator.getOutputs().stream()
					.filter(outputModelEndpoint -> outputModelEndpoint.getName().equals(outputModelRelTypeEndpoint.getName()))
					.findFirst()
					.get()
					.getTarget();
				for (OperatorConstraintParameter param : rule.getEndpointModels()) {
					ModelEndpoint operatorModelTypeEndpoint = param.getParameterRef().getObject();
					//TODO MMINT[WORKFLOW] Make it a function?
					Model endpointModel = Stream.concat(newOperator.getInputs().stream(), newOperator.getOutputs().stream())
						.filter(modelEndpoint -> modelEndpoint.getName().equals(operatorModelTypeEndpoint.getName()))
						.findFirst()
						.get()
						.getTarget();
					if (param.getEndpointIndex() >= 0 && endpointModel instanceof ModelRel) {
						endpointModel = ((ModelRel) endpointModel).getModelEndpoints().get(param.getEndpointIndex()).getTarget();
					}
					String modelTypeEndpointUri = MIDConstraintChecker.getAllowedModelEndpoints(outputModelRel, null, endpointModel).get(0);
					ModelEndpoint modelTypeEndpoint = MIDTypeRegistry.getType(modelTypeEndpointUri);
					modelTypeEndpoint.createWorkflowInstance(endpointModel, outputModelRel);
				}
			}
		}

		return newOperator;
	}

	/**
	 * @generated NOT
	 */
	public void openWorkflowInstance() throws Exception {

		MMINTException.mustBeWorkflow(this);

		this.openInstanceMetatype();
	}

} //OperatorImpl

/**
 * Copyright (c) 2012-2019 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTConstants;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDFactory;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.impl.GenericElementImpl;
import edu.toronto.cs.se.mmint.mid.operator.ConversionOperator;
import edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorFactory;
import edu.toronto.cs.se.mmint.mid.operator.OperatorGeneric;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmint.mid.operator.WorkflowOperator;
import edu.toronto.cs.se.mmint.mid.reasoning.MIDConstraintChecker;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.ui.GMFUtils;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;
import edu.toronto.cs.se.mmint.mid.utils.MIDTypeFactory;

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
     * The default value of the '{@link #getWorkingPath() <em>Input Subdir</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWorkingPath()
     * @generated
     * @ordered
     */
    protected static final String INPUT_SUBDIR_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getWorkingPath() <em>Input Subdir</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWorkingPath()
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
    @Override
    public EList<ModelEndpoint> getInputs() {
        if (this.inputs == null) {
            this.inputs = new EObjectContainmentEList<>(ModelEndpoint.class, this, OperatorPackage.OPERATOR__INPUTS);
        }
        return this.inputs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<ModelEndpoint> getOutputs() {
        if (this.outputs == null) {
            this.outputs = new EObjectContainmentEList<>(ModelEndpoint.class, this, OperatorPackage.OPERATOR__OUTPUTS);
        }
        return this.outputs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<GenericEndpoint> getGenerics() {
        if (this.generics == null) {
            this.generics = new EObjectContainmentEList<>(GenericEndpoint.class, this, OperatorPackage.OPERATOR__GENERICS);
        }
        return this.generics;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getWorkingPath() {
        return this.inputSubdir;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setWorkingPath(String newInputSubdir) {
        String oldInputSubdir = this.inputSubdir;
        this.inputSubdir = newInputSubdir;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, OperatorPackage.OPERATOR__INPUT_SUBDIR, oldInputSubdir, this.inputSubdir));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Operator getPreviousOperator() {
        if (this.previousOperator != null && this.previousOperator.eIsProxy()) {
            InternalEObject oldPreviousOperator = (InternalEObject)this.previousOperator;
            this.previousOperator = (Operator)this.eResolveProxy(oldPreviousOperator);
            if (this.previousOperator != oldPreviousOperator) {
                if (this.eNotificationRequired())
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperatorPackage.OPERATOR__PREVIOUS_OPERATOR, oldPreviousOperator, this.previousOperator));
            }
        }
        return this.previousOperator;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Operator basicGetPreviousOperator() {
        return this.previousOperator;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setPreviousOperator(Operator newPreviousOperator) {
        Operator oldPreviousOperator = this.previousOperator;
        this.previousOperator = newPreviousOperator;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, OperatorPackage.OPERATOR__PREVIOUS_OPERATOR, oldPreviousOperator, this.previousOperator));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isUpdateMID() {
        return this.updateMID;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setUpdateMID(boolean newUpdateMID) {
        boolean oldUpdateMID = this.updateMID;
        this.updateMID = newUpdateMID;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, OperatorPackage.OPERATOR__UPDATE_MID, oldUpdateMID, this.updateMID));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public long getExecutionTime() {
        return this.executionTime;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setExecutionTime(long newExecutionTime) {
        long oldExecutionTime = this.executionTime;
        this.executionTime = newExecutionTime;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, OperatorPackage.OPERATOR__EXECUTION_TIME, oldExecutionTime, this.executionTime));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isCommutative() {
        return this.commutative;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setCommutative(boolean newCommutative) {
        boolean oldCommutative = this.commutative;
        this.commutative = newCommutative;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, OperatorPackage.OPERATOR__COMMUTATIVE, oldCommutative, this.commutative));
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
                return ((InternalEList<?>)this.getInputs()).basicRemove(otherEnd, msgs);
            case OperatorPackage.OPERATOR__OUTPUTS:
                return ((InternalEList<?>)this.getOutputs()).basicRemove(otherEnd, msgs);
            case OperatorPackage.OPERATOR__GENERICS:
                return ((InternalEList<?>)this.getGenerics()).basicRemove(otherEnd, msgs);
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
                return this.getInputs();
            case OperatorPackage.OPERATOR__OUTPUTS:
                return this.getOutputs();
            case OperatorPackage.OPERATOR__GENERICS:
                return this.getGenerics();
            case OperatorPackage.OPERATOR__INPUT_SUBDIR:
                return this.getWorkingPath();
            case OperatorPackage.OPERATOR__PREVIOUS_OPERATOR:
                if (resolve) return this.getPreviousOperator();
                return this.basicGetPreviousOperator();
            case OperatorPackage.OPERATOR__UPDATE_MID:
                return this.isUpdateMID();
            case OperatorPackage.OPERATOR__EXECUTION_TIME:
                return this.getExecutionTime();
            case OperatorPackage.OPERATOR__COMMUTATIVE:
                return this.isCommutative();
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
                this.getInputs().clear();
                this.getInputs().addAll((Collection<? extends ModelEndpoint>)newValue);
                return;
            case OperatorPackage.OPERATOR__OUTPUTS:
                this.getOutputs().clear();
                this.getOutputs().addAll((Collection<? extends ModelEndpoint>)newValue);
                return;
            case OperatorPackage.OPERATOR__GENERICS:
                this.getGenerics().clear();
                this.getGenerics().addAll((Collection<? extends GenericEndpoint>)newValue);
                return;
            case OperatorPackage.OPERATOR__INPUT_SUBDIR:
                this.setWorkingPath((String)newValue);
                return;
            case OperatorPackage.OPERATOR__PREVIOUS_OPERATOR:
                this.setPreviousOperator((Operator)newValue);
                return;
            case OperatorPackage.OPERATOR__UPDATE_MID:
                this.setUpdateMID((Boolean)newValue);
                return;
            case OperatorPackage.OPERATOR__EXECUTION_TIME:
                this.setExecutionTime((Long)newValue);
                return;
            case OperatorPackage.OPERATOR__COMMUTATIVE:
                this.setCommutative((Boolean)newValue);
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
                this.getInputs().clear();
                return;
            case OperatorPackage.OPERATOR__OUTPUTS:
                this.getOutputs().clear();
                return;
            case OperatorPackage.OPERATOR__GENERICS:
                this.getGenerics().clear();
                return;
            case OperatorPackage.OPERATOR__INPUT_SUBDIR:
                this.setWorkingPath(INPUT_SUBDIR_EDEFAULT);
                return;
            case OperatorPackage.OPERATOR__PREVIOUS_OPERATOR:
                this.setPreviousOperator((Operator)null);
                return;
            case OperatorPackage.OPERATOR__UPDATE_MID:
                this.setUpdateMID(UPDATE_MID_EDEFAULT);
                return;
            case OperatorPackage.OPERATOR__EXECUTION_TIME:
                this.setExecutionTime(EXECUTION_TIME_EDEFAULT);
                return;
            case OperatorPackage.OPERATOR__COMMUTATIVE:
                this.setCommutative(COMMUTATIVE_EDEFAULT);
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
                return this.inputs != null && !this.inputs.isEmpty();
            case OperatorPackage.OPERATOR__OUTPUTS:
                return this.outputs != null && !this.outputs.isEmpty();
            case OperatorPackage.OPERATOR__GENERICS:
                return this.generics != null && !this.generics.isEmpty();
            case OperatorPackage.OPERATOR__INPUT_SUBDIR:
                return INPUT_SUBDIR_EDEFAULT == null ? this.inputSubdir != null : !INPUT_SUBDIR_EDEFAULT.equals(this.inputSubdir);
            case OperatorPackage.OPERATOR__PREVIOUS_OPERATOR:
                return this.previousOperator != null;
            case OperatorPackage.OPERATOR__UPDATE_MID:
                return this.updateMID != UPDATE_MID_EDEFAULT;
            case OperatorPackage.OPERATOR__EXECUTION_TIME:
                return this.executionTime != EXECUTION_TIME_EDEFAULT;
            case OperatorPackage.OPERATOR__COMMUTATIVE:
                return this.commutative != COMMUTATIVE_EDEFAULT;
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
                return this.getMetatype();
            case OperatorPackage.OPERATOR___GET_SUPERTYPE:
                return this.getSupertype();
            case OperatorPackage.OPERATOR___GET_MID_CONTAINER:
                return this.getMIDContainer();
            case OperatorPackage.OPERATOR___GET_TYPE_SIGNATURE__ELIST:
                try {
                    return this.getTypeSignature((EList<OperatorInput>)arguments.get(0));
                }
                catch (Throwable throwable) {
                    throw new InvocationTargetException(throwable);
                }
            case OperatorPackage.OPERATOR___CREATE_SUBTYPE__STRING_STRING:
                try {
                    return this.createSubtype((String)arguments.get(0), (String)arguments.get(1));
                }
                catch (Throwable throwable) {
                    throw new InvocationTargetException(throwable);
                }
            case OperatorPackage.OPERATOR___DELETE_TYPE:
                try {
                    this.deleteType();
                    return null;
                }
                catch (Throwable throwable) {
                    throw new InvocationTargetException(throwable);
                }
            case OperatorPackage.OPERATOR___OPEN_TYPE:
                try {
                    this.openType();
                    return null;
                }
                catch (Throwable throwable) {
                    throw new InvocationTargetException(throwable);
                }
            case OperatorPackage.OPERATOR___FIND_ALLOWED_INPUTS__ELIST_ELIST:
                try {
                    return this.findAllowedInputs((EList<MID>)arguments.get(0), (EList<Set<Model>>)arguments.get(1));
                }
                catch (Throwable throwable) {
                    throw new InvocationTargetException(throwable);
                }
            case OperatorPackage.OPERATOR___FIND_FIRST_ALLOWED_INPUT__ELIST_ELIST:
                try {
                    return this.findFirstAllowedInput((EList<MID>)arguments.get(0), (EList<Set<Model>>)arguments.get(1));
                }
                catch (Throwable throwable) {
                    throw new InvocationTargetException(throwable);
                }
            case OperatorPackage.OPERATOR___CHECK_ALLOWED_INPUTS__ELIST:
                try {
                    return this.checkAllowedInputs((EList<Model>)arguments.get(0));
                }
                catch (Throwable throwable) {
                    throw new InvocationTargetException(throwable);
                }
            case OperatorPackage.OPERATOR___GET_OUTPUTS_BY_NAME:
                try {
                    return this.getOutputsByName();
                }
                catch (Throwable throwable) {
                    throw new InvocationTargetException(throwable);
                }
            case OperatorPackage.OPERATOR___GET_OUTPUT_MODELS:
                try {
                    return this.getOutputModels();
                }
                catch (Throwable throwable) {
                    throw new InvocationTargetException(throwable);
                }
            case OperatorPackage.OPERATOR___CREATE_INSTANCE__MID:
                try {
                    return this.createInstance((MID)arguments.get(0));
                }
                catch (Throwable throwable) {
                    throw new InvocationTargetException(throwable);
                }
            case OperatorPackage.OPERATOR___DELETE_INSTANCE:
                try {
                    this.deleteInstance();
                    return null;
                }
                catch (Throwable throwable) {
                    throw new InvocationTargetException(throwable);
                }
            case OperatorPackage.OPERATOR___SELECT_ALLOWED_GENERICS__ELIST:
                try {
                    return this.selectAllowedGenerics((EList<OperatorInput>)arguments.get(0));
                }
                catch (Throwable throwable) {
                    throw new InvocationTargetException(throwable);
                }
            case OperatorPackage.OPERATOR___GET_INPUT_PROPERTIES:
                return this.getInputProperties();
            case OperatorPackage.OPERATOR___READ_INPUT_PROPERTIES__PROPERTIES:
                try {
                    this.readInputProperties((Properties)arguments.get(0));
                    return null;
                }
                catch (Throwable throwable) {
                    throw new InvocationTargetException(throwable);
                }
            case OperatorPackage.OPERATOR___RUN__MAP_MAP_MAP:
                try {
                    return this.run((Map<String, Model>)arguments.get(0), (Map<String, GenericElement>)arguments.get(1), (Map<String, MID>)arguments.get(2));
                }
                catch (Throwable throwable) {
                    throw new InvocationTargetException(throwable);
                }
            case OperatorPackage.OPERATOR___START_INSTANCE__ELIST_PROPERTIES_ELIST_MAP_MID:
                try {
                    return this.startInstance((EList<OperatorInput>)arguments.get(0), (Properties)arguments.get(1), (EList<OperatorGeneric>)arguments.get(2), (Map<String, MID>)arguments.get(3), (MID)arguments.get(4));
                }
                catch (Throwable throwable) {
                    throw new InvocationTargetException(throwable);
                }
            case OperatorPackage.OPERATOR___OPEN_INSTANCE:
                try {
                    this.openInstance();
                    return null;
                }
                catch (Throwable throwable) {
                    throw new InvocationTargetException(throwable);
                }
            case OperatorPackage.OPERATOR___CREATE_WORKFLOW_INSTANCE__MID:
                try {
                    return this.createWorkflowInstance((MID)arguments.get(0));
                }
                catch (Throwable throwable) {
                    throw new InvocationTargetException(throwable);
                }
            case OperatorPackage.OPERATOR___DELETE_WORKFLOW_INSTANCE:
                try {
                    this.deleteWorkflowInstance();
                    return null;
                }
                catch (Throwable throwable) {
                    throw new InvocationTargetException(throwable);
                }
            case OperatorPackage.OPERATOR___CREATE_WORKFLOW_INSTANCE_OUTPUTS__OPERATOR_MAP_MID:
                try {
                    this.createWorkflowInstanceOutputs((Operator)arguments.get(0), (Map<String, Model>)arguments.get(1), (MID)arguments.get(2));
                    return null;
                }
                catch (Throwable throwable) {
                    throw new InvocationTargetException(throwable);
                }
            case OperatorPackage.OPERATOR___START_WORKFLOW_INSTANCE__ELIST_ELIST_MID:
                try {
                    return this.startWorkflowInstance((EList<OperatorInput>)arguments.get(0), (EList<OperatorGeneric>)arguments.get(1), (MID)arguments.get(2));
                }
                catch (Throwable throwable) {
                    throw new InvocationTargetException(throwable);
                }
            case OperatorPackage.OPERATOR___OPEN_WORKFLOW_INSTANCE:
                try {
                    this.openWorkflowInstance();
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
    @Override
    public String toStringGen() {
        if (this.eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (inputSubdir: ");
        result.append(this.inputSubdir);
        result.append(", updateMID: ");
        result.append(this.updateMID);
        result.append(", executionTime: ");
        result.append(this.executionTime);
        result.append(", commutative: ");
        result.append(this.commutative);
        result.append(')');
        return result.toString();
    }

    /**
     * @generated NOT
     */
    @Override
    public String toString() {

        String label = (this.getName() == null) ? "" : this.getName();
        if (!this.getGenerics().isEmpty()) {
            label +=
                "<" +
                this.getGenerics().stream()
                    .map(GenericEndpoint::toString)
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
    @Override
    public Operator getMetatype() {
        ExtendibleElement metatype = super.getMetatype();
        return (metatype == null) ? null : (Operator) metatype;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
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
    public MID getMIDContainer() {
        return (MID) this.eContainer();
    }

    /**
     * @generated NOT
     */
    @Override
    public String getTypeSignature(EList<OperatorInput> inputs) throws MMINTException {

        MMINTException.mustBeType(this);

        String signature = this.toString() + "(";
        if (inputs == null) {
            List<String> params = new ArrayList<>();
            for (ModelEndpoint formalParameter : this.getInputs()) {
                String formal = formalParameter.getTarget().getName() + " ";
                if (formalParameter.getUpperBound() > 1) {
                    formal += "*";
                }
                formal += formalParameter.getName();
                params.add(formal);
            }
            signature += String.join(", ", params);
            signature += ")";
        }
        else {
            //TODO MMINT[OPERATOR] Add coercion support
            Map<String, List<String>> varargs = new LinkedHashMap<>();
            for (OperatorInput input : inputs) {
                ModelEndpoint formalParameter = input.getModelTypeEndpoint();
                Model actualParameter = input.getModel();
                String formal = formalParameter.getTarget().getName() + " ";
                if (formalParameter.getUpperBound() > 1) {
                    formal += "*";
                }
                formal += formalParameter.getName();
                List<String> vararg = varargs.get(formal);
                if (vararg == null) {
                    vararg = new ArrayList<>();
                    varargs.put(formal, vararg);
                }
                vararg.add(actualParameter.getName());
            }
            List<String> params = new ArrayList<>();
            for (Entry<String, List<String>> vararg : varargs.entrySet()) {
                String actual = (vararg.getValue().size() > 1) ? vararg.getValue().toString() :
                                                                 vararg.getValue().get(0);
                params.add(vararg.getKey() + "=" + actual);
            }
            signature += String.join(", ", params);
            signature += ")";
        }

        return signature;
    }

    /**
     * Adds a subtype of this operator type to the Type MID.
     *
     * @param newOperatorType
     *            The new operator type to be added.
     * @param newOperatorTypeName
     *            The name of the new operator type.
     * @param implementationPath
     *            The path to the new operator's implementation (a Java class inheriting from this class, or a Workflow
     *            MID).
     * @throws MMINTException
     *             If the id of the new operator type is already registered in the Type MID, or if the Workflow MID
     *             cannot be read or copied.
     * @generated NOT
     */
    protected void addSubtype(Operator newOperatorType, String newOperatorTypeName, String implementationPath) throws MMINTException {

        if (implementationPath.endsWith(".java")) {
            //TODO MMINT[OPERATOR] Implement a simple way to run a java class pointed by implementationPath
            return;
        }

        MID typeMID = this.getMIDContainer();
        super.addSubtype(newOperatorType, this, null, newOperatorTypeName);
        try {
            String workflowMIDPath = implementationPath;
            MID workflowMID;
            String newWorkflowMIDPath;
            if (FileUtils.isFileOrDirectoryInState(workflowMIDPath)) { // just recreating this subtype at startup
                workflowMID = (MID) FileUtils.readModelFileInState(workflowMIDPath);
                newWorkflowMIDPath = workflowMIDPath;
            }
            else { // make a copy of the Workflow MID files
                workflowMID = (MID) FileUtils.readModelFile(workflowMIDPath, true);
                newWorkflowMIDPath = newOperatorTypeName + MMINTConstants.MODEL_FILEEXTENSION_SEPARATOR + MIDPackage.eNAME;
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
            // identify inputs and outputs, then create endpoints for the operator type
            Map<Model, String> inoutWorkflowModels = MIDRegistry.getInputOutputWorkflowModels(workflowMID);
            for (Entry<Model, String> inoutWorkflowModel : inoutWorkflowModels.entrySet()) {
                Model workflowModel = inoutWorkflowModel.getKey();
                ModelEndpoint newModelTypeEndpoint = MIDFactory.eINSTANCE.createModelEndpoint();
                Model modelType = typeMID.getExtendibleElement(workflowModel.getMetatypeUri());
                MIDTypeFactory.addType(newModelTypeEndpoint, null, newOperatorType.getUri() + MMINTConstants.URI_SEPARATOR + workflowModel.getUri(), workflowModel.getName(), typeMID);
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
    public Operator createSubtype(String newOperatorTypeName, String implementationUri) throws MMINTException {

        MMINTException.mustBeType(this);

        Operator newOperatorType = (implementationUri.endsWith(".java")) ?
            super.createThisEClass() :
            OperatorFactory.eINSTANCE.createWorkflowOperator();
        this.addSubtype(newOperatorType, newOperatorTypeName, implementationUri);

        return newOperatorType;
    }

    /**
     * @generated NOT
     */
    @Override
    public void deleteType() throws MMINTException {

        MMINTException.mustBeType(this);

        MID typeMID = this.getMIDContainer();
        // delete the "thing"
        this.getInputs().forEach(modelTypeEndpoint -> super.delete(modelTypeEndpoint.getUri(), typeMID));
        this.getOutputs().forEach(modelTypeEndpoint -> super.delete(modelTypeEndpoint.getUri(), typeMID));
        this.getGenerics().forEach(genericTypeEndpoint -> super.delete(genericTypeEndpoint.getUri(), typeMID));
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
    @Override
    public void openType() throws Exception {

        MMINTException.mustBeType(this);

        String operatorClassRelativePath = this.getClass().getName().replace(".", File.separator) + ".java";
        String operatorImplPath = MIDTypeRegistry.getFileBundlePath(this, operatorClassRelativePath);
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

        Set<EList<OperatorInput>> operatorTypeInputSet = new LinkedHashSet<>(); // reproducible order
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
            EList<OperatorInput> operatorTypeInputs = ECollections.newBasicEList();
            for (int i = 0; i < indexes.length; i++) {
                EList<OperatorInput> modelTypeEndpointInput = modelTypeEndpointInputs.get(i);
                operatorTypeInputs.add(modelTypeEndpointInput.get(indexes[i]));
            }
            try {
                // add only if allowed and passes commutativity check
                Map<String, Model> inputsByName = this.getInputsByName(operatorTypeInputs);
                if (MIDConstraintChecker.checkOperatorInputConstraint(this.getClosestTypeConstraint(), inputsByName)) {
                    boolean commutativeInput = false;
                    if (this.isCommutative()) {
                        Set<Model> operatorTypeInputsCommutative = new HashSet<>(inputsByName.values());
                        if (operatorTypeInputSetCommutative.contains(operatorTypeInputsCommutative)) {
                            commutativeInput = true;
                        }
                        else {
                            operatorTypeInputSetCommutative.add(operatorTypeInputsCommutative);
                        }
                    }
                    if (!commutativeInput) {
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
     * @param inputModelBlacklists
     *            A List of blacklisted models not to be considered as input, following the same order as the inputMIDs.
     * @return The allowed inputs for each formal parameter, including necessary conversions.
     * @generated NOT
     */
    private @NonNull EList<EList<OperatorInput>> getModelTypeEndpointInputs(@NonNull EList<MID> inputMIDs, @NonNull EList<Set<Model>> inputModelBlacklists) {

        //TODO MMINT[MAP] Add support for upper bound = -1
        EList<EList<OperatorInput>> modelTypeEndpointInputs = new BasicEList<>();
        for (int i = 0; i < this.getInputs().size(); i++) {
            ModelEndpoint inputModelTypeEndpoint = this.getInputs().get(i);
            // TODO MMINT[MAP] Add support for arbitrary combinations of input MIDs to input arguments
            MID inputMID;
            Set<Model> inputModelBlacklist;
            if (i < inputMIDs.size()) {
                inputMID = inputMIDs.get(i);
                inputModelBlacklist = inputModelBlacklists.get(i);
            }
            else {
                inputMID = inputMIDs.get(inputMIDs.size()-1);
                inputModelBlacklist = inputModelBlacklists.get(inputModelBlacklists.size()-1);
            }
            EList<OperatorInput> modelTypeEndpointInputSet = new BasicEList<>();
            modelTypeEndpointInputs.add(modelTypeEndpointInputSet);
            for (Model inputModel : inputMID.getModels()) {
                if (inputModelBlacklist.contains(inputModel)) {
                    continue;
                }
                OperatorInput operatorInput = this.checkAllowedInput(inputModelTypeEndpoint, inputModel);
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
    @Override
    public Set<EList<OperatorInput>> findAllowedInputs(EList<MID> inputMIDs, EList<Set<Model>> inputModelBlacklists) throws MMINTException {

        MMINTException.mustBeType(this);

        // get inputs by model type endpoint
        EList<EList<OperatorInput>> modelTypeEndpointInputs = this.getModelTypeEndpointInputs(inputMIDs, inputModelBlacklists);
        // do cartesian product of inputs
        Set<EList<OperatorInput>> operatorTypeInputSet = this.getOperatorTypeInputs(modelTypeEndpointInputs, false);

        return operatorTypeInputSet;
    }

    /**
     * @generated NOT
     */
    @Override
    public EList<OperatorInput> findFirstAllowedInput(EList<MID> inputMIDs, EList<Set<Model>> inputModelBlacklists) throws MMINTException {

        MMINTException.mustBeType(this);

        // get inputs by model type endpoint
        EList<EList<OperatorInput>> modelTypeEndpointInputs = this.getModelTypeEndpointInputs(inputMIDs, inputModelBlacklists);
        // get the first allowed input
        Set<EList<OperatorInput>> operatorTypeInputSet = this.getOperatorTypeInputs(modelTypeEndpointInputs, true);
        if (operatorTypeInputSet.isEmpty()) {
            return null;
        }

        return operatorTypeInputSet.iterator().next();
    }

    /**
     * @generated NOT
     */
    @Override
    public EList<OperatorInput> checkAllowedInputs(EList<Model> inputModels) throws MMINTException {

        MMINTException.mustBeType(this);

        // check actual parameters
        EList<OperatorInput> inputs = new BasicEList<>();
        int i = 0;
        for (ModelEndpoint inputModelTypeEndpoint : this.getInputs()) {
            // check 1: not enough actual parameters, excluding optional ones (lower bound == 0)
            if (i >= inputModels.size() && inputModelTypeEndpoint.getLowerBound() > 0) {
                return null;
            }
            // check 2: type or substitutable types
            while (i < inputModels.size()) { // loop is only for upper bound > 1
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
        Map<String, Model> inputsByName = this.getInputsByName(inputs);
        if (!MIDConstraintChecker.checkOperatorInputConstraint(this.getClosestTypeConstraint(), inputsByName)) {
            //TODO MMINT[OPERATOR] Can there be conflicts since conversions are not run?
            return null;
        }

        return inputs;
    }

    /**
     * @generated NOT
     */
    @Override
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
    @Override
    public EList<Model> getOutputModels() throws MMINTException {

        MMINTException.mustBeInstance(this);

        return ECollections.toEList(
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
    @Override
    public Operator createInstance(MID instanceMID) throws MMINTException {

        MMINTException.mustBeType(this);

        Operator newOperator;
        try {
            newOperator = getClass().getDeclaredConstructor().newInstance();
        }
        catch (Exception e) {
            throw new MMINTException("Can't invoke constructor");
        }
        //TODO MMINT[OPERATOR] This is an ugly way to run a callback
        if (this.getPreviousOperator() != null) {
            newOperator.setPreviousOperator(this.getPreviousOperator());
            this.setPreviousOperator(null);
        }
        if (this.getWorkingPath() != null) {
            newOperator.setWorkingPath(this.getWorkingPath());
            this.setWorkingPath(null);
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
    @Override
    public void deleteInstance() throws MMINTException {

        MMINTException.mustBeInstance(this);

        this.deleteInstance(this.getMIDContainer());
    }

    /**
     * @generated NOT
     */
    @Override
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
     * Gets the uri of the properties file of this operator.
     *
     * @param suffix
     *            The suffix of the properties file.
     * @return The uri of the properties file.
     * @generated NOT
     */
    private String getPropertiesUri(@NonNull String suffix) {

        String workingPath = this.getWorkingPath();
        if (workingPath == null) {
            IFile instanceMIDFile = MMINT.getActiveInstanceMIDFile();
            if (instanceMIDFile == null) { // can happen when an operator is invoked from a model editor
                return null;
            }
            workingPath = instanceMIDFile.getParent().getFullPath().toString();
        }
        String propertiesUri = FileUtils.prependWorkspacePath(workingPath) + File.separator + this.getName() + suffix +
                               MIDOperatorIOUtils.PROPERTIES_SUFFIX;

        return propertiesUri;
    }

    /**
     * @generated NOT
     */
    @Override
    public Properties getInputProperties() {

        String propertiesUri =  this.getPropertiesUri(MIDOperatorIOUtils.INPUT_PROPERTIES_SUFFIX);
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
    @Override
    public void readInputProperties(Properties inputProperties) throws MMINTException {

        this.setUpdateMID(
            MIDOperatorIOUtils.getOptionalBoolProperty(inputProperties, MIDOperatorIOUtils.PROPERTY_IN_UPDATEMID, true)
        );
    }

    /**
     * @generated NOT
     */
    @Override
    public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
            Map<String, MID> outputMIDsByName) throws Exception {

        throw new MMINTException("The default run() function must be overridden");
    }

    /**
     * Adds an input model instance out of an input of an operator instance.
     *
     * @param input
     *            An input of an operator instance.
     * @param inputsByName
     *            The input model instances, identified by their formal parameter name.
     * @return The name of the input, enumerated in case of varargs.
     * @generated NOT
     */
    private String addInputByName(@NonNull OperatorInput input, @NonNull Map<String, Model> inputsByName) {

        String inputName = input.getModelTypeEndpoint().getName();
        if (input.getModelTypeEndpoint().getUpperBound() == -1) {
            int i = 0;
            while (inputsByName.get(inputName + i) != null) {
                i++;
            }
            inputName += i;
        }
        inputsByName.put(inputName, input.getModel());

        return inputName;
    }

    /**
     * Gets the input model instances out of a list of inputs of an operator instance.
     *
     * @param inputs
     *            A list of inputs of an operator instance.
     * @return The input model instances, identified by their formal parameter name.
     * @generated NOT
     */
    private Map<String, Model> getInputsByName(@NonNull List<OperatorInput> inputs) {

        Map<String, Model> inputsByName = new HashMap<>();
        for (OperatorInput input : inputs) {
            this.addInputByName(input, inputsByName);
        }

        return inputsByName;
    }

    /**
     * Creates the inputs of a new operator instance.
     *
     * @param newOperator
     *            The new operator instance that will be invoked with the input models.
     * @param inputs
     *            A list of inputs of the operator instance, including necessary conversions.
     *
     * @return The input model instances, identified by their formal parameter name.
     * @throws MMINTException
     *             If any input type endpoint is not a type.
     * @throws Exception
     *             If something went wrong running the conversions.
     * @generated NOT
     */
    private Map<String, Model> createInstanceInputs(@NonNull Operator newOperator, @NonNull List<OperatorInput> inputs) throws Exception {

        boolean coerced = false;
        Map<String, Model> inputsByName = new HashMap<>();
        for (OperatorInput input : inputs) {
            ModelEndpoint modelTypeEndpoint = input.getModelTypeEndpoint();
            ModelEndpoint modelEndpoint = modelTypeEndpoint.createInstance(
                input.getModel(),
                newOperator,
                OperatorPackage.eINSTANCE.getOperator_Inputs().getName()
            );
            String inputName = this.addInputByName(input, inputsByName);
            if (modelTypeEndpoint.getUpperBound() == -1) {
                modelEndpoint.setName(inputName);
            }
            if (input.getConversions().isEmpty()) {
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
        if (coerced) {
            newOperator.setName(newOperator.getName() + " (coerced)");
        }

        return inputsByName;
    }

    /**
     * Creates the generics of a new operator instance.
     *
     * @param newOperator
     *            The new operator instance that will be invoked with the generics.
     * @param generics
     *            A list of generic types of the operator instance.
     * @return The generics, identified by their name.
     * @throws MMINTException
     *             If any generic type is not a type.
     * @generated NOT
     */
    private Map<String, GenericElement> createInstanceGenerics(@NonNull Operator newOperator, @NonNull List<OperatorGeneric> generics) throws MMINTException {

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
     * Creates the outputs of a new instance of this operator type.
     *
     * @param newOperator
     *            The new instance of this operator type.
     * @param inputsByName
     *            The input model instances, identified by their formal parameter name.
     * @param outputsByName
     *            The output model instances, identified by their formal parameter name.
     * @throws MMINTException
     *             If this is not an operator type.
     * @generated NOT
     */
    private void createInstanceOutputs(Operator newOperator, Map<String, Model> inputsByName, Map<String, Model> outputsByName) throws MMINTException {

        MMINTException.mustBeType(this);

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
    }

    /**
     * @generated NOT
     */
    @Override
    public Operator startInstance(EList<OperatorInput> inputs, Properties inputProperties, EList<OperatorGeneric> generics, Map<String, MID> outputMIDsByName, MID instanceMID) throws Exception {

        MMINTException.mustBeType(this);

        //TODO MMINT[OPERATOR] Run in its own thread to avoid blocking the user interface (needs ui parts to be passed for GMFDiagramUtils functions to work)
        if (!Boolean.parseBoolean(MMINT.getPreference(MMINTConstants.PREFERENCE_MENU_OPERATORS_ENABLED))) {
            instanceMID = null;
        }
        Operator newOperator = this.createInstance(instanceMID);
        // generics, inputs and conversions
        Map<String, GenericElement> genericsByName = this.createInstanceGenerics(newOperator, generics);
        Map<String, Model> inputsByName = this.createInstanceInputs(newOperator, inputs);
        // run operator
        if (inputProperties == null) {
            inputProperties = newOperator.getInputProperties();
        }
        newOperator.readInputProperties(inputProperties);
        long startTime = System.nanoTime();
        Map<String, Model> outputsByName = newOperator.run(inputsByName, genericsByName, outputMIDsByName);
        newOperator.setExecutionTime(System.nanoTime()-startTime);
        // outputs
        this.createInstanceOutputs(newOperator, inputsByName, outputsByName);
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
    @Override
    public void openInstance() throws Exception {

        MMINTException.mustBeInstance(this);

        this.openInstanceMetatype();
    }

    /**
     * @generated NOT
     */
    @Override
    public Operator createWorkflowInstance(MID workflowMID) throws MMINTException {

        MMINTException.mustBeType(this);

        Operator newOperator = OperatorFactory.eINSTANCE.createOperator();
        this.addInstance(newOperator, MIDLevel.WORKFLOWS, workflowMID);

        return newOperator;
    }

    /**
     * @generated NOT
     */
    @Override
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
     * Creates the inputs of a new operator instance in a workflow.
     *
     * @param newOperator
     *            The new operator instance in a workflow.
     * @param inputs
     *            A list of inputs of the operator instance.
     * @return The input model instances, identified by their formal parameter name.
     * @throws MMINTException
     *             If any input type endpoint is not a type.
     * @generated NOT
     */
    private Map<String, Model> createWorkflowInstanceInputs(@NonNull Operator newOperator, @NonNull List<OperatorInput> inputs) throws MMINTException {

        Map<String, Model> inputsByName = new HashMap<>();
        for (OperatorInput input : inputs) {
            ModelEndpoint modelTypeEndpoint = input.getModelTypeEndpoint();
            ModelEndpoint modelEndpoint = modelTypeEndpoint.createWorkflowInstance(
                input.getModel(),
                newOperator,
                OperatorPackage.eINSTANCE.getOperator_Inputs().getName()
            );
            String inputName = this.addInputByName(input, inputsByName);
            if (modelTypeEndpoint.getUpperBound() == -1) {
                modelEndpoint.setName(inputName);
            }
        }

        return inputsByName;
    }

    /**
     * Creates the generics of a new operator instance in a workflow.
     *
     * @param newOperator
     *            The new operator instance in a workflow.
     * @param generics
     *            A list of generic types of the operator instance.
     * @return The generic instances, identified by their name.
     * @throws MMINTException
     *             If any generic type is not a type.
     * @generated NOT
     */
    private Map<String, GenericElement> createWorkflowInstanceGenerics(@NonNull Operator newOperator, @NonNull List<OperatorGeneric> generics) throws MMINTException {

        Map<String, GenericElement> genericsByName = new HashMap<>();
        for (OperatorGeneric generic : generics) {
            GenericEndpoint genericSuperTypeEndpoint = generic.getGenericSuperTypeEndpoint();
            GenericElement genericType = generic.getGeneric();
            genericSuperTypeEndpoint.createWorkflowInstance(genericType, newOperator);
            genericsByName.put(genericSuperTypeEndpoint.getName(), genericType);
        }

        return genericsByName;
    }

    /**
     * @generated NOT
     */
    @Override
    public void createWorkflowInstanceOutputs(Operator newOperator, Map<String, Model> inputsByName, MID workflowMID) throws MMINTException {

        MMINTException.mustBeType(this);
        if (this.getOutputs().stream().anyMatch(outputModelTypeEndpoint -> outputModelTypeEndpoint.getUpperBound() == -1)) {
            try {
                if (this.getClass().getMethod("createWorkflowInstanceOutputs", Operator.class, Map.class, MID.class).getDeclaringClass() == OperatorImpl.class) {
                    throw new MMINTException(this.getClass().getSimpleName() + " has a variable number of outputs and must override createWorkflowInstanceOutputs()");
                }
            }
            catch (NoSuchMethodException | SecurityException e) {
                throw new MMINTException(this.getClass().getSimpleName() + " has a variable number of outputs and createWorkflowInstanceOutputs() can't be reflected", e);
            }
        }

        Map<String, Model> outputsByName = new HashMap<>();
        for (ModelEndpoint outputModelTypeEndpoint : this.getOutputs()) {
            //TODO MMINT[OPERATOR] workflowID can be null, so outputModelId should be generated differently
            String outputModelId = MIDRegistry.getNextWorkflowID(workflowMID);
            Model outputModel = outputModelTypeEndpoint.getTarget().createWorkflowInstance(outputModelId, workflowMID);
            ModelEndpoint outputModelEndpoint = outputModelTypeEndpoint.createWorkflowInstance(
                outputModel,
                newOperator,
                OperatorPackage.eINSTANCE.getOperator_Outputs().getName());
            outputsByName.put(outputModelEndpoint.getName(), outputModel);
        }
        Map<ModelRel, List<Model>> validOutputs = MIDConstraintChecker.getOperatorOutputConstraints(this.getClosestTypeConstraint(), inputsByName, outputsByName);
        for (Entry<ModelRel, List<Model>> validOutput : validOutputs.entrySet()) {
            ModelRel outputModelRel = validOutput.getKey();
            for (Model endpointModel : validOutput.getValue()) {
                String modelTypeEndpointUri = MIDConstraintChecker.getAllowedModelEndpoints(outputModelRel, null, endpointModel).get(0);
                ModelEndpoint modelTypeEndpoint = MIDTypeRegistry.getType(modelTypeEndpointUri);
                modelTypeEndpoint.createWorkflowInstance(endpointModel, outputModelRel);
            }
        }
    }

    /**
     * @generated NOT
     */
    @Override
    public Operator startWorkflowInstance(EList<OperatorInput> inputs, EList<OperatorGeneric> generics, MID workflowMID) throws MMINTException {

        MMINTException.mustBeType(this);

        Operator newOperator = this.createWorkflowInstance(workflowMID);
        // generics and inputs
        this.createWorkflowInstanceGenerics(newOperator, generics);
        Map<String, Model> inputsByName = this.createWorkflowInstanceInputs(newOperator, inputs);
        // outputs
        this.createWorkflowInstanceOutputs(newOperator, inputsByName, workflowMID);

        return newOperator;
    }

    /**
     * @generated NOT
     */
    @Override
    public void openWorkflowInstance() throws Exception {

        MMINTException.mustBeWorkflow(this);

        this.openInstanceMetatype();
    }

} //OperatorImpl

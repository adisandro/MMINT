/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.operator.impl;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.impl.ExtendibleElementImpl;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.operator.Operator;
import edu.toronto.cs.se.mmtf.mid.operator.OperatorExecutable;
import edu.toronto.cs.se.mmtf.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmtf.mid.operator.Parameter;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorImpl#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorImpl#getSignatureTable <em>Signature Table</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorImpl#getExecutable <em>Executable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperatorImpl extends ExtendibleElementImpl implements Operator {
	/**
	 * The cached value of the '{@link #getInputs() <em>Inputs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputs()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> inputs;

	/**
	 * The cached value of the '{@link #getOutputs() <em>Outputs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputs()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> outputs;

	/**
	 * The cached value of the '{@link #getSignatureTable() <em>Signature Table</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignatureTable()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, Parameter> signatureTable;

	/**
	 * The cached value of the '{@link #getExecutable() <em>Executable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutable()
	 * @generated
	 * @ordered
	 */
	protected OperatorExecutable executable;

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
	public EList<Parameter> getInputs() {
		if (inputs == null) {
			inputs = new EObjectContainmentEList<Parameter>(Parameter.class, this, OperatorPackage.OPERATOR__INPUTS);
		}
		return inputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getOutputs() {
		if (outputs == null) {
			outputs = new EObjectContainmentEList<Parameter>(Parameter.class, this, OperatorPackage.OPERATOR__OUTPUTS);
		}
		return outputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, Parameter> getSignatureTable() {
		if (signatureTable == null) {
			signatureTable = new EcoreEMap<String,Parameter>(OperatorPackage.Literals.ESTRING_TO_PARAMETER_MAP, EStringToParameterMapImpl.class, this, OperatorPackage.OPERATOR__SIGNATURE_TABLE);
		}
		return signatureTable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatorExecutable getExecutable() {
		return executable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExecutable(OperatorExecutable newExecutable, NotificationChain msgs) {
		OperatorExecutable oldExecutable = executable;
		executable = newExecutable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperatorPackage.OPERATOR__EXECUTABLE, oldExecutable, newExecutable);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExecutable(OperatorExecutable newExecutable) {
		if (newExecutable != executable) {
			NotificationChain msgs = null;
			if (executable != null)
				msgs = ((InternalEObject)executable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperatorPackage.OPERATOR__EXECUTABLE, null, msgs);
			if (newExecutable != null)
				msgs = ((InternalEObject)newExecutable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperatorPackage.OPERATOR__EXECUTABLE, null, msgs);
			msgs = basicSetExecutable(newExecutable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorPackage.OPERATOR__EXECUTABLE, newExecutable, newExecutable));
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
			case OperatorPackage.OPERATOR__SIGNATURE_TABLE:
				return ((InternalEList<?>)getSignatureTable()).basicRemove(otherEnd, msgs);
			case OperatorPackage.OPERATOR__EXECUTABLE:
				return basicSetExecutable(null, msgs);
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
			case OperatorPackage.OPERATOR__SIGNATURE_TABLE:
				if (coreType) return getSignatureTable();
				else return getSignatureTable().map();
			case OperatorPackage.OPERATOR__EXECUTABLE:
				return getExecutable();
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
				getInputs().addAll((Collection<? extends Parameter>)newValue);
				return;
			case OperatorPackage.OPERATOR__OUTPUTS:
				getOutputs().clear();
				getOutputs().addAll((Collection<? extends Parameter>)newValue);
				return;
			case OperatorPackage.OPERATOR__SIGNATURE_TABLE:
				((EStructuralFeature.Setting)getSignatureTable()).set(newValue);
				return;
			case OperatorPackage.OPERATOR__EXECUTABLE:
				setExecutable((OperatorExecutable)newValue);
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
			case OperatorPackage.OPERATOR__SIGNATURE_TABLE:
				getSignatureTable().clear();
				return;
			case OperatorPackage.OPERATOR__EXECUTABLE:
				setExecutable((OperatorExecutable)null);
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
			case OperatorPackage.OPERATOR__SIGNATURE_TABLE:
				return signatureTable != null && !signatureTable.isEmpty();
			case OperatorPackage.OPERATOR__EXECUTABLE:
				return executable != null;
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
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * @generated NOT
	 */
	public void deleteType() throws MMTFException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute TYPES level operation on INSTANCES level element");
		}

		MultiModel multiModel = MultiModelRegistry.getMultiModel(this);
		// delete the "thing"
		super.deleteType(multiModel);
		multiModel.getOperators().remove(this);
		// delete the subtypes of the "thing"
		for (Operator operatorSubtype : MultiModelTypeHierarchy.getDirectSubtypes(this)) {
			operatorSubtype.deleteType();
		}
	}

} //OperatorImpl

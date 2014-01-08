/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.operator.OperatorExecutable;
import edu.toronto.cs.se.mmtf.mid.operator.OperatorPackage;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Executable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorExecutableImpl#getInputSubdir <em>Input Subdir</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorExecutableImpl#getPreviousExecutable <em>Previous Executable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class OperatorExecutableImpl extends EObjectImpl implements OperatorExecutable {
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
	 * The cached value of the '{@link #getPreviousExecutable() <em>Previous Executable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreviousExecutable()
	 * @generated
	 * @ordered
	 */
	protected OperatorExecutable previousExecutable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperatorExecutableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperatorPackage.Literals.OPERATOR_EXECUTABLE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorPackage.OPERATOR_EXECUTABLE__INPUT_SUBDIR, oldInputSubdir, inputSubdir));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatorExecutable getPreviousExecutable() {
		if (previousExecutable != null && previousExecutable.eIsProxy()) {
			InternalEObject oldPreviousExecutable = (InternalEObject)previousExecutable;
			previousExecutable = (OperatorExecutable)eResolveProxy(oldPreviousExecutable);
			if (previousExecutable != oldPreviousExecutable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperatorPackage.OPERATOR_EXECUTABLE__PREVIOUS_EXECUTABLE, oldPreviousExecutable, previousExecutable));
			}
		}
		return previousExecutable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatorExecutable basicGetPreviousExecutable() {
		return previousExecutable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreviousExecutable(OperatorExecutable newPreviousExecutable) {
		OperatorExecutable oldPreviousExecutable = previousExecutable;
		previousExecutable = newPreviousExecutable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperatorPackage.OPERATOR_EXECUTABLE__PREVIOUS_EXECUTABLE, oldPreviousExecutable, previousExecutable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OperatorPackage.OPERATOR_EXECUTABLE__INPUT_SUBDIR:
				return getInputSubdir();
			case OperatorPackage.OPERATOR_EXECUTABLE__PREVIOUS_EXECUTABLE:
				if (resolve) return getPreviousExecutable();
				return basicGetPreviousExecutable();
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
			case OperatorPackage.OPERATOR_EXECUTABLE__INPUT_SUBDIR:
				setInputSubdir((String)newValue);
				return;
			case OperatorPackage.OPERATOR_EXECUTABLE__PREVIOUS_EXECUTABLE:
				setPreviousExecutable((OperatorExecutable)newValue);
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
			case OperatorPackage.OPERATOR_EXECUTABLE__INPUT_SUBDIR:
				setInputSubdir(INPUT_SUBDIR_EDEFAULT);
				return;
			case OperatorPackage.OPERATOR_EXECUTABLE__PREVIOUS_EXECUTABLE:
				setPreviousExecutable((OperatorExecutable)null);
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
			case OperatorPackage.OPERATOR_EXECUTABLE__INPUT_SUBDIR:
				return INPUT_SUBDIR_EDEFAULT == null ? inputSubdir != null : !INPUT_SUBDIR_EDEFAULT.equals(inputSubdir);
			case OperatorPackage.OPERATOR_EXECUTABLE__PREVIOUS_EXECUTABLE:
				return previousExecutable != null;
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
			case OperatorPackage.OPERATOR_EXECUTABLE___EXECUTE__ELIST:
				try {
					return execute((EList<Model>)arguments.get(0));
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
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (inputSubdir: ");
		result.append(inputSubdir);
		result.append(')');
		return result.toString();
	}

} //OperatorExecutableImpl

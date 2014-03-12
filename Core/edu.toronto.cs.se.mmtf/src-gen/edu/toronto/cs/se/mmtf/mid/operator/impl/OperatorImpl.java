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

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.impl.ExtendibleElementImpl;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.operator.ConversionOperator;
import edu.toronto.cs.se.mmtf.mid.operator.Operator;
import edu.toronto.cs.se.mmtf.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmtf.mid.operator.Parameter;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
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
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorImpl#getInputSubdir <em>Input Subdir</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorImpl#getPreviousOperator <em>Previous Operator</em>}</li>
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
			case OperatorPackage.OPERATOR__INPUT_SUBDIR:
				return getInputSubdir();
			case OperatorPackage.OPERATOR__PREVIOUS_OPERATOR:
				if (resolve) return getPreviousOperator();
				return basicGetPreviousOperator();
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
			case OperatorPackage.OPERATOR__INPUT_SUBDIR:
				setInputSubdir((String)newValue);
				return;
			case OperatorPackage.OPERATOR__PREVIOUS_OPERATOR:
				setPreviousOperator((Operator)newValue);
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
			case OperatorPackage.OPERATOR__INPUT_SUBDIR:
				setInputSubdir(INPUT_SUBDIR_EDEFAULT);
				return;
			case OperatorPackage.OPERATOR__PREVIOUS_OPERATOR:
				setPreviousOperator((Operator)null);
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
			case OperatorPackage.OPERATOR__INPUT_SUBDIR:
				return INPUT_SUBDIR_EDEFAULT == null ? inputSubdir != null : !INPUT_SUBDIR_EDEFAULT.equals(inputSubdir);
			case OperatorPackage.OPERATOR__PREVIOUS_OPERATOR:
				return previousOperator != null;
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
			case OperatorPackage.OPERATOR___EXECUTE__ELIST:
				try {
					return execute((EList<Model>)arguments.get(0));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case OperatorPackage.OPERATOR___GET_EXECUTABLES__ELIST_ELIST_ELIST_ELIST:
				try {
					return getExecutables((EList<Model>)arguments.get(0), (EList<EList<Model>>)arguments.get(1), (EList<Map<Integer, EList<ConversionOperator>>>)arguments.get(2), (EList<EList<Model>>)arguments.get(3));
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

	/**
	 * @generated NOT
	 */
	public void deleteType() throws MMTFException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute TYPES level operation on INSTANCES level element");
		}

		MultiModel multiModel = MultiModelRegistry.getMultiModel(this);
		// delete the "thing"
		super.deleteType();
		multiModel.getOperators().remove(this);
		// delete the subtypes of the "thing"
		for (Operator operatorSubtype : MultiModelTypeHierarchy.getDirectSubtypes(this, multiModel)) {
			operatorSubtype.deleteType();
		}
	}

	/**
	 * @generated NOT
	 */
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		throw new MMTFException("The default execute() function must be overridden");
	}

	/**
	 * @generated NOT
	 */
	public EList<Operator> getExecutables(EList<Model> actualModels, EList<EList<Model>> actualModelTypes, EList<Map<Integer, EList<ConversionOperator>>> conversions, EList<EList<Model>> generics) throws MMTFException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute TYPES level operation on INSTANCES level element");
		}

		int i = 0;
		Map<Integer, EList<ConversionOperator>> conversion = new HashMap<Integer, EList<ConversionOperator>>();
		for (Parameter parameter : getInputs()) {
			// check 1: not enough actual parameters
			if (i >= actualModels.size()) {
				return new BasicEList<Operator>();
			}
			// check 2: type or substitutable types
			while (i < actualModels.size()) {
				Model actualParameter = actualModels.get(i);
				Model formalParameter = parameter.getModel();
				// easy if formal parameter is root type for actual parameter
				if (!MultiModelTypeHierarchy.isRootType(formalParameter) || !formalParameter.getClass().isAssignableFrom(actualParameter.getClass())) {
					EList<ConversionOperator> conversionOperatorTypes = MultiModelTypeHierarchy.isEligibleParameter(actualModelTypes.get(i), formalParameter);
					if (conversionOperatorTypes == null) {
						return new BasicEList<Operator>();
					}
					if (!conversionOperatorTypes.isEmpty()) {
						conversion.put(new Integer(i), conversionOperatorTypes);
					}
				}
				i++;
				if (!parameter.isVararg()) {
					//TODO MMTF[OPERATOR] introduce vararg with low multiplicity
					break;
				}
			}
		}
		// check 3: too many actual parameters
		if (i < actualModels.size()) {
			return new BasicEList<Operator>();
		}
		// create return structures with this operator type as the only executable
		EList<Operator> executableOperatorTypes = new BasicEList<Operator>();
		executableOperatorTypes.add(this);
		conversions.add(conversion);
		generics.add(new BasicEList<Model>());

		return executableOperatorTypes;
	}

} //OperatorImpl

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

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.impl.ExtendibleElementImpl;
import edu.toronto.cs.se.mmint.mid.library.MultiModelOperatorUtils;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.operator.ConversionOperator;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmint.mid.operator.Parameter;

import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

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
import org.eclipse.ui.PlatformUI;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl#getInputSubdir <em>Input Subdir</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl#getPreviousOperator <em>Previous Operator</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl#isUpdateMID <em>Update MID</em>}</li>
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
			case OperatorPackage.OPERATOR__INPUT_SUBDIR:
				return getInputSubdir();
			case OperatorPackage.OPERATOR__PREVIOUS_OPERATOR:
				if (resolve) return getPreviousOperator();
				return basicGetPreviousOperator();
			case OperatorPackage.OPERATOR__UPDATE_MID:
				return isUpdateMID();
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
			case OperatorPackage.OPERATOR__INPUT_SUBDIR:
				setInputSubdir((String)newValue);
				return;
			case OperatorPackage.OPERATOR__PREVIOUS_OPERATOR:
				setPreviousOperator((Operator)newValue);
				return;
			case OperatorPackage.OPERATOR__UPDATE_MID:
				setUpdateMID((Boolean)newValue);
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
			case OperatorPackage.OPERATOR__INPUT_SUBDIR:
				setInputSubdir(INPUT_SUBDIR_EDEFAULT);
				return;
			case OperatorPackage.OPERATOR__PREVIOUS_OPERATOR:
				setPreviousOperator((Operator)null);
				return;
			case OperatorPackage.OPERATOR__UPDATE_MID:
				setUpdateMID(UPDATE_MID_EDEFAULT);
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
			case OperatorPackage.OPERATOR__INPUT_SUBDIR:
				return INPUT_SUBDIR_EDEFAULT == null ? inputSubdir != null : !INPUT_SUBDIR_EDEFAULT.equals(inputSubdir);
			case OperatorPackage.OPERATOR__PREVIOUS_OPERATOR:
				return previousOperator != null;
			case OperatorPackage.OPERATOR__UPDATE_MID:
				return updateMID != UPDATE_MID_EDEFAULT;
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
			case OperatorPackage.OPERATOR___GET_EXECUTABLES__ELIST_ELIST_ELIST_ELIST:
				try {
					return getExecutables((EList<Model>)arguments.get(0), (EList<EList<Model>>)arguments.get(1), (EList<Map<Integer, EList<ConversionOperator>>>)arguments.get(2), (EList<EList<Model>>)arguments.get(3));
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
			case OperatorPackage.OPERATOR___EXECUTE__ELIST:
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
		result.append(", updateMID: ");
		result.append(updateMID);
		result.append(')');
		return result.toString();
	}

	/**
	 * @generated NOT
	 */
	public void deleteType() throws MMINTException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
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
	public EList<Operator> getExecutables(EList<Model> actualModels, EList<EList<Model>> actualModelTypes, EList<Map<Integer, EList<ConversionOperator>>> conversions, EList<EList<Model>> generics) throws MMINTException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
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
					//TODO MMINT[OPERATOR] introduce vararg with low multiplicity
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

		//TODO MMINT[OPERATOR] Add actualParameters to the signature
		// do nothing
	}

	/**
	 * @generated NOT
	 */
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		throw new MMINTException("The default execute() function must be overridden");
	}

} //OperatorImpl

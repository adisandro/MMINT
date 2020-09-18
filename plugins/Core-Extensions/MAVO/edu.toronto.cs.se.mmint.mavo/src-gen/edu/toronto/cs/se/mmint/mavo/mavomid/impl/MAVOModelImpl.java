/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mavo.mavomid.impl;

import edu.toronto.cs.se.mavo.MAVODecision;
import edu.toronto.cs.se.mavo.MAVOPackage;
import edu.toronto.cs.se.mavo.MAVORoot;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mavo.constraint.MAVOMIDConstraintChecker;
import edu.toronto.cs.se.mmint.mavo.library.MAVOUtils;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMIDPackage;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModel;
import edu.toronto.cs.se.mmint.mavo.reasoning.IMAVOTrait.MAVOTruthValue;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.impl.ModelImpl;

import java.io.IOException;
import java.util.Collection;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.ConstraintStatus;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MAVO Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOModelImpl#isInc <em>Inc</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOModelImpl#getDecisions <em>Decisions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MAVOModelImpl extends ModelImpl implements MAVOModel {
	/**
   * The default value of the '{@link #isInc() <em>Inc</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #isInc()
   * @generated
   * @ordered
   */
	protected static final boolean INC_EDEFAULT = false;
	/**
   * The cached value of the '{@link #isInc() <em>Inc</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #isInc()
   * @generated
   * @ordered
   */
	protected boolean inc = INC_EDEFAULT;
	/**
   * The cached value of the '{@link #getDecisions() <em>Decisions</em>}' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getDecisions()
   * @generated
   * @ordered
   */
	protected EList<MAVODecision> decisions;
	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected MAVOModelImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return MAVOMIDPackage.Literals.MAVO_MODEL;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public boolean isInc() {
    return inc;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public void setInc(boolean newInc) {
    boolean oldInc = inc;
    inc = newInc;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MAVOMIDPackage.MAVO_MODEL__INC, oldInc, inc));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EList<MAVODecision> getDecisions() {
    if (decisions == null) {
      decisions = new EObjectContainmentEList<MAVODecision>(MAVODecision.class, this, MAVOMIDPackage.MAVO_MODEL__DECISIONS);
    }
    return decisions;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case MAVOMIDPackage.MAVO_MODEL__DECISIONS:
        return ((InternalEList<?>)getDecisions()).basicRemove(otherEnd, msgs);
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
      case MAVOMIDPackage.MAVO_MODEL__INC:
        return isInc();
      case MAVOMIDPackage.MAVO_MODEL__DECISIONS:
        return getDecisions();
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
      case MAVOMIDPackage.MAVO_MODEL__INC:
        setInc((Boolean)newValue);
        return;
      case MAVOMIDPackage.MAVO_MODEL__DECISIONS:
        getDecisions().clear();
        getDecisions().addAll((Collection<? extends MAVODecision>)newValue);
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
      case MAVOMIDPackage.MAVO_MODEL__INC:
        setInc(INC_EDEFAULT);
        return;
      case MAVOMIDPackage.MAVO_MODEL__DECISIONS:
        getDecisions().clear();
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
      case MAVOMIDPackage.MAVO_MODEL__INC:
        return inc != INC_EDEFAULT;
      case MAVOMIDPackage.MAVO_MODEL__DECISIONS:
        return decisions != null && !decisions.isEmpty();
    }
    return super.eIsSet(featureID);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
    if (baseClass == MAVORoot.class) {
      switch (derivedFeatureID) {
        case MAVOMIDPackage.MAVO_MODEL__INC: return MAVOPackage.MAVO_ROOT__INC;
        case MAVOMIDPackage.MAVO_MODEL__DECISIONS: return MAVOPackage.MAVO_ROOT__DECISIONS;
        default: return -1;
      }
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
    if (baseClass == MAVORoot.class) {
      switch (baseFeatureID) {
        case MAVOPackage.MAVO_ROOT__INC: return MAVOMIDPackage.MAVO_MODEL__INC;
        case MAVOPackage.MAVO_ROOT__DECISIONS: return MAVOMIDPackage.MAVO_MODEL__DECISIONS;
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (inc: ");
    result.append(inc);
    result.append(')');
    return result.toString();
  }

	/**
	 * @generated NOT
	 */
	@Override
	public Model createInstance(EObject rootModelObj, String newModelPath, MID instanceMID) throws MMINTException, IOException {

		MAVOModel newMAVOModel = (MAVOModel) super.createInstance(rootModelObj, newModelPath, instanceMID);
		if (rootModelObj != null) {
			MAVOUtils.initializeMAVOModel(rootModelObj, newMAVOModel);
		}

		return newMAVOModel;
	}

	/**
	 * @generated NOT
	 */
	public Model importInstance(String modelPath, MID instanceMID) throws MMINTException {

		MAVOModel newMAVOModel = (MAVOModel) super.importInstance(modelPath, instanceMID);
		MAVOUtils.initializeMAVOModel(newMAVOModel.getEMFInstanceRoot(), newMAVOModel);

		return newMAVOModel;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public IStatus validateInstanceInEditor(IValidationContext context) throws MMINTException {

		MMINTException.mustBeInstance(this);

		//TODO MMINT[MAVO] Extend this to the type level
		MAVOTruthValue validates = MAVOMIDConstraintChecker.checkMAVOModelConstraint(this, this.getConstraint());
		IStatus status;
		if (validates == MAVOTruthValue.TRUE) {
			status = context.createSuccessStatus();
		}
		else {
			ConstraintStatus failureStatus = (ConstraintStatus) context.createFailureStatus(
				"",
				this.getName(),
				this.getMetatype().getName());
			status = (validates == MAVOTruthValue.MAYBE) ? new ConstraintStatus(
				failureStatus.getConstraint(),
				this,
				IStatus.WARNING,
				200,
				"The MAVO constraint evaluated to Maybe",
				failureStatus.getResultLocus()) : failureStatus;
		}

		return status;
	}

	/**
	 * @generated NOT
	 */
	public String toMIDCustomPrintLabel() {

		return MAVOUtils.getMAVORootLabel(this, true);
	}

	/**
	 * @generated NOT
	 */
	public String toMIDCustomEditLabel() {

		return MAVOUtils.getMAVORootLabel(this, false);
	}

	/**
	 * @generated NOT
	 */
	public void updateMIDCustomLabel(String newLabel) {

		MAVOUtils.setMAVORootLabel(this, newLabel);
	}

} //MAVOModelImpl

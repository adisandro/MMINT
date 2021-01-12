/**
 * Copyright (c) 2012-2021 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl;

import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.AttributeReference;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.OperationReference;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SourceLifelineReference;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.TargetLifelineReference;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Message</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.MessageImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.MessageImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.MessageImpl#getSourceLifeline <em>Source Lifeline</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.MessageImpl#getTargetLifeline <em>Target Lifeline</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MessageImpl extends NamedElementImpl implements Message {
	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<AttributeReference> attributes;

	/**
	 * The cached value of the '{@link #getOperation() <em>Operation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperation()
	 * @generated
	 * @ordered
	 */
	protected EList<OperationReference> operation;

	/**
	 * The cached value of the '{@link #getSourceLifeline() <em>Source Lifeline</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceLifeline()
	 * @generated
	 * @ordered
	 */
	protected EList<SourceLifelineReference> sourceLifeline;

	/**
	 * The cached value of the '{@link #getTargetLifeline() <em>Target Lifeline</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetLifeline()
	 * @generated
	 * @ordered
	 */
	protected EList<TargetLifelineReference> targetLifeline;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MessageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ICSE15_SequenceDiagram_MAVOPackage.Literals.MESSAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttributeReference> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentWithInverseEList<AttributeReference>(AttributeReference.class, this, ICSE15_SequenceDiagram_MAVOPackage.MESSAGE__ATTRIBUTES, ICSE15_SequenceDiagram_MAVOPackage.ATTRIBUTE_REFERENCE__SOURCE);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OperationReference> getOperation() {
		if (operation == null) {
			operation = new EObjectContainmentWithInverseEList<OperationReference>(OperationReference.class, this, ICSE15_SequenceDiagram_MAVOPackage.MESSAGE__OPERATION, ICSE15_SequenceDiagram_MAVOPackage.OPERATION_REFERENCE__SOURCE);
		}
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SourceLifelineReference> getSourceLifeline() {
		if (sourceLifeline == null) {
			sourceLifeline = new EObjectContainmentWithInverseEList<SourceLifelineReference>(SourceLifelineReference.class, this, ICSE15_SequenceDiagram_MAVOPackage.MESSAGE__SOURCE_LIFELINE, ICSE15_SequenceDiagram_MAVOPackage.SOURCE_LIFELINE_REFERENCE__SOURCE);
		}
		return sourceLifeline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TargetLifelineReference> getTargetLifeline() {
		if (targetLifeline == null) {
			targetLifeline = new EObjectContainmentWithInverseEList<TargetLifelineReference>(TargetLifelineReference.class, this, ICSE15_SequenceDiagram_MAVOPackage.MESSAGE__TARGET_LIFELINE, ICSE15_SequenceDiagram_MAVOPackage.TARGET_LIFELINE_REFERENCE__SOURCE);
		}
		return targetLifeline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ICSE15_SequenceDiagram_MAVOPackage.MESSAGE__ATTRIBUTES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAttributes()).basicAdd(otherEnd, msgs);
			case ICSE15_SequenceDiagram_MAVOPackage.MESSAGE__OPERATION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOperation()).basicAdd(otherEnd, msgs);
			case ICSE15_SequenceDiagram_MAVOPackage.MESSAGE__SOURCE_LIFELINE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSourceLifeline()).basicAdd(otherEnd, msgs);
			case ICSE15_SequenceDiagram_MAVOPackage.MESSAGE__TARGET_LIFELINE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTargetLifeline()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ICSE15_SequenceDiagram_MAVOPackage.MESSAGE__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
			case ICSE15_SequenceDiagram_MAVOPackage.MESSAGE__OPERATION:
				return ((InternalEList<?>)getOperation()).basicRemove(otherEnd, msgs);
			case ICSE15_SequenceDiagram_MAVOPackage.MESSAGE__SOURCE_LIFELINE:
				return ((InternalEList<?>)getSourceLifeline()).basicRemove(otherEnd, msgs);
			case ICSE15_SequenceDiagram_MAVOPackage.MESSAGE__TARGET_LIFELINE:
				return ((InternalEList<?>)getTargetLifeline()).basicRemove(otherEnd, msgs);
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
			case ICSE15_SequenceDiagram_MAVOPackage.MESSAGE__ATTRIBUTES:
				return getAttributes();
			case ICSE15_SequenceDiagram_MAVOPackage.MESSAGE__OPERATION:
				return getOperation();
			case ICSE15_SequenceDiagram_MAVOPackage.MESSAGE__SOURCE_LIFELINE:
				return getSourceLifeline();
			case ICSE15_SequenceDiagram_MAVOPackage.MESSAGE__TARGET_LIFELINE:
				return getTargetLifeline();
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
			case ICSE15_SequenceDiagram_MAVOPackage.MESSAGE__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends AttributeReference>)newValue);
				return;
			case ICSE15_SequenceDiagram_MAVOPackage.MESSAGE__OPERATION:
				getOperation().clear();
				getOperation().addAll((Collection<? extends OperationReference>)newValue);
				return;
			case ICSE15_SequenceDiagram_MAVOPackage.MESSAGE__SOURCE_LIFELINE:
				getSourceLifeline().clear();
				getSourceLifeline().addAll((Collection<? extends SourceLifelineReference>)newValue);
				return;
			case ICSE15_SequenceDiagram_MAVOPackage.MESSAGE__TARGET_LIFELINE:
				getTargetLifeline().clear();
				getTargetLifeline().addAll((Collection<? extends TargetLifelineReference>)newValue);
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
			case ICSE15_SequenceDiagram_MAVOPackage.MESSAGE__ATTRIBUTES:
				getAttributes().clear();
				return;
			case ICSE15_SequenceDiagram_MAVOPackage.MESSAGE__OPERATION:
				getOperation().clear();
				return;
			case ICSE15_SequenceDiagram_MAVOPackage.MESSAGE__SOURCE_LIFELINE:
				getSourceLifeline().clear();
				return;
			case ICSE15_SequenceDiagram_MAVOPackage.MESSAGE__TARGET_LIFELINE:
				getTargetLifeline().clear();
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
			case ICSE15_SequenceDiagram_MAVOPackage.MESSAGE__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case ICSE15_SequenceDiagram_MAVOPackage.MESSAGE__OPERATION:
				return operation != null && !operation.isEmpty();
			case ICSE15_SequenceDiagram_MAVOPackage.MESSAGE__SOURCE_LIFELINE:
				return sourceLifeline != null && !sourceLifeline.isEmpty();
			case ICSE15_SequenceDiagram_MAVOPackage.MESSAGE__TARGET_LIFELINE:
				return targetLifeline != null && !targetLifeline.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MessageImpl

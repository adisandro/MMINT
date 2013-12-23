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
package edu.toronto.cs.se.mmtf.mid.impl;

import edu.toronto.cs.se.mmtf.MMTF;
import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelTypeFactory;
import edu.toronto.cs.se.mmtf.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.MidFactory;
import edu.toronto.cs.se.mmtf.mid.MidPackage;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipFactory;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.impl.ModelElementImpl#getClassLiteral <em>Class Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelElementImpl extends ExtendibleElementImpl implements ModelElement {
	/**
	 * The default value of the '{@link #getClassLiteral() <em>Class Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassLiteral()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASS_LITERAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClassLiteral() <em>Class Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassLiteral()
	 * @generated
	 * @ordered
	 */
	protected String classLiteral = CLASS_LITERAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MidPackage.Literals.MODEL_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClassLiteral() {
		return classLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassLiteral(String newClassLiteral) {
		String oldClassLiteral = classLiteral;
		classLiteral = newClassLiteral;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidPackage.MODEL_ELEMENT__CLASS_LITERAL, oldClassLiteral, classLiteral));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElement getMetatype() {
		ExtendibleElement metatype = super.getMetatype();
		return (metatype == null) ? null : (ModelElement) metatype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElement getSupertype() {
		ExtendibleElement supertype = super.getSupertype();
		return (supertype == null) ? null : (ModelElement) supertype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MidPackage.MODEL_ELEMENT__CLASS_LITERAL:
				return getClassLiteral();
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
			case MidPackage.MODEL_ELEMENT__CLASS_LITERAL:
				setClassLiteral((String)newValue);
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
			case MidPackage.MODEL_ELEMENT__CLASS_LITERAL:
				setClassLiteral(CLASS_LITERAL_EDEFAULT);
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
			case MidPackage.MODEL_ELEMENT__CLASS_LITERAL:
				return CLASS_LITERAL_EDEFAULT == null ? classLiteral != null : !CLASS_LITERAL_EDEFAULT.equals(classLiteral);
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
			case MidPackage.MODEL_ELEMENT___GET_METATYPE:
				return getMetatype();
			case MidPackage.MODEL_ELEMENT___GET_SUPERTYPE:
				return getSupertype();
			case MidPackage.MODEL_ELEMENT___CREATE_TYPE_REFERENCE__MODELELEMENTREFERENCE_BOOLEAN_MODELENDPOINTREFERENCE:
				try {
					return createTypeReference((ModelElementReference)arguments.get(0), (Boolean)arguments.get(1), (ModelEndpointReference)arguments.get(2));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MidPackage.MODEL_ELEMENT___CREATE_SUBTYPE_AND_REFERENCE__MODELELEMENTREFERENCE_STRING_STRING_MODELENDPOINTREFERENCE:
				try {
					return createSubtypeAndReference((ModelElementReference)arguments.get(0), (String)arguments.get(1), (String)arguments.get(2), (ModelEndpointReference)arguments.get(3));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MidPackage.MODEL_ELEMENT___DELETE_TYPE:
				try {
					deleteType();
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MidPackage.MODEL_ELEMENT___CREATE_INSTANCE_REFERENCE__MODELENDPOINTREFERENCE:
				try {
					return createInstanceReference((ModelEndpointReference)arguments.get(0));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MidPackage.MODEL_ELEMENT___CREATE_INSTANCE_AND_REFERENCE__STRING_STRING_STRING_MODELENDPOINTREFERENCE:
				try {
					return createInstanceAndReference((String)arguments.get(0), (String)arguments.get(1), (String)arguments.get(2), (ModelEndpointReference)arguments.get(3));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MidPackage.MODEL_ELEMENT___DELETE_INSTANCE:
				try {
					deleteInstance();
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
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (classLiteral: ");
		result.append(classLiteral);
		result.append(')');
		return result.toString();
	}

	/**
	 * @generated NOT
	 */
	public ModelElementReference createTypeReference(ModelElementReference modelElemTypeRef, boolean isModifiable, ModelEndpointReference containerModelTypeEndpointRef) throws MMTFException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute TYPES level operation on INSTANCES level element");
		}

		ModelElementReference newModelElemTypeRef = RelationshipFactory.eINSTANCE.createModelElementReference();
		super.addTypeReference(newModelElemTypeRef, modelElemTypeRef, isModifiable, false);
		containerModelTypeEndpointRef.getModelElemRefs().add(newModelElemTypeRef);

		return newModelElemTypeRef;
	}

	/**
	 * @generated NOT
	 */
	public ModelElementReference createSubtypeAndReference(ModelElementReference modelElemTypeRef, String newModelElemTypeName, String classLiteral, ModelEndpointReference containerModelTypeEndpointRef) throws MMTFException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute TYPES level operation on INSTANCES level element");
		}

		ModelRel modelRelType = (ModelRel) containerModelTypeEndpointRef.eContainer();
		MultiModel multiModel = MultiModelRegistry.getMultiModel(modelRelType);
		String newTypeUri = containerModelTypeEndpointRef.getObject().createSubtypeUri(containerModelTypeEndpointRef.getObject().getName(), newModelElemTypeName);
		ModelElement newModelElemType = MultiModelRegistry.getExtendibleElement(newTypeUri, multiModel);
		if (newModelElemType == null) {
			// create the "thing"
			newModelElemType = MidFactory.eINSTANCE.createModelElement();
			super.addSubtype(newModelElemType, containerModelTypeEndpointRef.getObject(), containerModelTypeEndpointRef.getObject().getName(), newModelElemTypeName);
			MultiModelTypeFactory.addModelElementType(newModelElemType, classLiteral, containerModelTypeEndpointRef.getObject().getTarget());
		}
		// create the reference of the "thing"
		ModelElementReference newModelElemTypeRef = newModelElemType.createTypeReference(modelElemTypeRef, true, containerModelTypeEndpointRef);
		// create references of the "thing" in subtypes of the container
		for (ModelRel modelRelSubtype : MultiModelTypeHierarchy.getSubtypes(modelRelType, multiModel)) {
			ModelEndpointReference containerModelSubtypeEndpointRef = MultiModelTypeHierarchy.getReference(containerModelTypeEndpointRef, modelRelSubtype.getModelEndpointRefs());
			ModelElementReference modelElemSubtypeRef = null;
			if (modelElemTypeRef != null) {
				ModelEndpointReference modelSubtypeRefSuper = MultiModelTypeHierarchy.getReference((ModelEndpointReference) modelElemTypeRef.eContainer(), modelRelSubtype.getModelEndpointRefs());
				modelElemSubtypeRef = MultiModelTypeHierarchy.getReference(modelElemTypeRef, modelSubtypeRefSuper.getModelElemRefs());
			}
			newModelElemType.createTypeReference(modelElemSubtypeRef, false, containerModelSubtypeEndpointRef);
		}

		return newModelElemTypeRef;
	}

	/**
	 * @generated NOT
	 */
	public void deleteType() throws MMTFException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute TYPES level operation on INSTANCES level element");
		}

		MultiModel multiModel = MultiModelRegistry.getMultiModel(this);
		super.deleteType(multiModel);
		//TODO MMTF[OO] might need to implement full removal
	}

	/**
	 * @generated NOT
	 */
	public ModelElementReference createInstanceReference(ModelEndpointReference containerModelEndpointRef) throws MMTFException {

		if (!MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute INSTANCES level operation on TYPES level element");
		}

		ModelElementReference newModelElemRef = RelationshipFactory.eINSTANCE.createModelElementReference();
		super.addInstanceReference(newModelElemRef, false);
		containerModelEndpointRef.getModelElemRefs().add(newModelElemRef);

		return newModelElemRef;
	}

	/**
	 * @generated NOT
	 */
	public ModelElementReference createInstanceAndReference(String newModelElemUri, String newModelElemName, String classLiteral, ModelEndpointReference containerModelEndpointRef) throws MMTFException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute TYPES level operation on INSTANCES level element");
		}

		MultiModel multiModel = MultiModelRegistry.getMultiModel(containerModelEndpointRef);
		newModelElemUri += MMTF.ROLE_SEPARATOR + getUri();
		ModelElement newModelElem = MultiModelRegistry.getExtendibleElement(newModelElemUri, multiModel);
		if (newModelElem == null) {
			newModelElem = MidFactory.eINSTANCE.createModelElement();
			super.addInstance(newModelElem, newModelElemUri, newModelElemName, multiModel);
			newModelElem.setClassLiteral(classLiteral);
			containerModelEndpointRef.getObject().getTarget().getModelElems().add(newModelElem);
		}
		ModelElementReference newModelElemRef = newModelElem.createInstanceReference(containerModelEndpointRef);

		return newModelElemRef;
	}

	/**
	 * @generated NOT
	 */
	public void deleteInstance() throws MMTFException {

		if (!MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute INSTANCES level operation on TYPES level element");
		}

		MultiModel multiModel = MultiModelRegistry.getMultiModel(this);
		super.deleteInstance(multiModel);
		//TODO MMTF[OO] might need to implement full removal
	}

} //ModelElementImpl

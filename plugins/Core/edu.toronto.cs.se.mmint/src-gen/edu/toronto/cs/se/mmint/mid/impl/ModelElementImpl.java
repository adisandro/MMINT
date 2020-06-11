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
package edu.toronto.cs.se.mmint.mid.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MMINTConstants;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.EMFInfo;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;
import edu.toronto.cs.se.mmint.mid.utils.MIDTypeFactory;
import edu.toronto.cs.se.mmint.mid.utils.PrimitiveEObjectWrapper;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.impl.ModelElementImpl#getEInfo <em>EInfo</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelElementImpl extends ExtendibleElementImpl implements ModelElement {
    /**
   * The cached value of the '{@link #getEInfo() <em>EInfo</em>}' containment reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getEInfo()
   * @generated
   * @ordered
   */
    protected EMFInfo eInfo;

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
    return MIDPackage.Literals.MODEL_ELEMENT;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EMFInfo getEInfo() {
    return this.eInfo;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public NotificationChain basicSetEInfo(EMFInfo newEInfo, NotificationChain msgs) {
    EMFInfo oldEInfo = this.eInfo;
    this.eInfo = newEInfo;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MIDPackage.MODEL_ELEMENT__EINFO, oldEInfo, newEInfo);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void setEInfo(EMFInfo newEInfo) {
    if (newEInfo != this.eInfo) {
      NotificationChain msgs = null;
      if (this.eInfo != null)
        msgs = ((InternalEObject)this.eInfo).eInverseRemove(this, InternalEObject.EOPPOSITE_FEATURE_BASE - MIDPackage.MODEL_ELEMENT__EINFO, null, msgs);
      if (newEInfo != null)
        msgs = ((InternalEObject)newEInfo).eInverseAdd(this, InternalEObject.EOPPOSITE_FEATURE_BASE - MIDPackage.MODEL_ELEMENT__EINFO, null, msgs);
      msgs = basicSetEInfo(newEInfo, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MIDPackage.MODEL_ELEMENT__EINFO, newEInfo, newEInfo));
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public ModelElement getMetatype() {
    ExtendibleElement metatype = super.getMetatype();
    return (metatype == null) ? null : (ModelElement) metatype;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
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
    public MID getMIDContainer() {
    return (MID) this.eContainer().eContainer();
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case MIDPackage.MODEL_ELEMENT__EINFO:
        return basicSetEInfo(null, msgs);
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
      case MIDPackage.MODEL_ELEMENT__EINFO:
        return getEInfo();
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
      case MIDPackage.MODEL_ELEMENT__EINFO:
        setEInfo((EMFInfo)newValue);
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
      case MIDPackage.MODEL_ELEMENT__EINFO:
        setEInfo((EMFInfo)null);
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
      case MIDPackage.MODEL_ELEMENT__EINFO:
        return this.eInfo != null;
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
        case MIDPackage.EXTENDIBLE_ELEMENT___GET_METATYPE: return MIDPackage.MODEL_ELEMENT___GET_METATYPE;
        case MIDPackage.EXTENDIBLE_ELEMENT___GET_MID_CONTAINER: return MIDPackage.MODEL_ELEMENT___GET_MID_CONTAINER;
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
    public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
    switch (operationID) {
      case MIDPackage.MODEL_ELEMENT___GET_METATYPE:
        return getMetatype();
      case MIDPackage.MODEL_ELEMENT___GET_SUPERTYPE:
        return getSupertype();
      case MIDPackage.MODEL_ELEMENT___GET_MID_CONTAINER:
        return getMIDContainer();
      case MIDPackage.MODEL_ELEMENT___CREATE_TYPE_REFERENCE__MODELELEMENTREFERENCE_BOOLEAN_MODELENDPOINTREFERENCE:
        try {
          return createTypeReference((ModelElementReference)arguments.get(0), (Boolean)arguments.get(1), (ModelEndpointReference)arguments.get(2));
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case MIDPackage.MODEL_ELEMENT___CREATE_SUBTYPE_AND_REFERENCE__MODELELEMENTREFERENCE_STRING_STRING_EMFINFO_MODELENDPOINTREFERENCE:
        try {
          return createSubtypeAndReference((ModelElementReference)arguments.get(0), (String)arguments.get(1), (String)arguments.get(2), (EMFInfo)arguments.get(3), (ModelEndpointReference)arguments.get(4));
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case MIDPackage.MODEL_ELEMENT___DELETE_TYPE:
        try {
          deleteType();
          return null;
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case MIDPackage.MODEL_ELEMENT___GET_EMF_TYPE_OBJECT:
        try {
          return getEMFTypeObject();
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case MIDPackage.MODEL_ELEMENT___CREATE_INSTANCE_REFERENCE__MODELENDPOINTREFERENCE:
        try {
          return createInstanceReference((ModelEndpointReference)arguments.get(0));
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case MIDPackage.MODEL_ELEMENT___CREATE_INSTANCE_AND_REFERENCE__STRING_STRING_EMFINFO_MODELENDPOINTREFERENCE:
        try {
          return createInstanceAndReference((String)arguments.get(0), (String)arguments.get(1), (EMFInfo)arguments.get(2), (ModelEndpointReference)arguments.get(3));
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case MIDPackage.MODEL_ELEMENT___DELETE_INSTANCE:
        try {
          deleteInstance();
          return null;
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case MIDPackage.MODEL_ELEMENT___GET_EMF_INSTANCE_OBJECT__RESOURCE:
        try {
          return getEMFInstanceObject((Resource)arguments.get(0));
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
    @Override
    public ModelElementReference createTypeReference(ModelElementReference modelElemTypeRef, boolean isModifiable, ModelEndpointReference containerModelTypeEndpointRef) throws MMINTException {

        MMINTException.mustBeType(this);

        ModelElementReference newModelElemTypeRef = super.createThisReferenceEClass();
        super.addTypeReference(newModelElemTypeRef, modelElemTypeRef, isModifiable, false);
        containerModelTypeEndpointRef.getModelElemRefs().add(newModelElemTypeRef);

        return newModelElemTypeRef;
    }

    /**
     * @generated NOT
     */
    @Override
    public ModelElementReference createSubtypeAndReference(ModelElementReference modelElemTypeRef, String newModelElemTypeUri, String newModelElemTypeName, EMFInfo eInfo, ModelEndpointReference containerModelTypeEndpointRef) throws MMINTException {

        MMINTException.mustBeType(this);

        ModelRel modelRelType = (ModelRel) containerModelTypeEndpointRef.eContainer();
        MID typeMID = modelRelType.getMIDContainer();
        ModelElement newModelElemType = typeMID.getExtendibleElement(newModelElemTypeUri);
        if (newModelElemType == null) {
            // create the "thing"
            newModelElemType = super.createThisEClass();
            super.addSubtype(newModelElemType, newModelElemTypeUri, newModelElemTypeName);
            MIDTypeFactory.addModelElementType(newModelElemType, eInfo, containerModelTypeEndpointRef.getObject().getTarget());
        }
        // create the reference of the "thing"
        ModelElementReference newModelElemTypeRef = newModelElemType.createTypeReference(modelElemTypeRef, true, containerModelTypeEndpointRef);
        // create references of the "thing" in subtypes of the container
        for (ModelRel modelRelSubtype : MIDTypeHierarchy.getSubtypes(modelRelType, typeMID)) {
            ModelEndpointReference containerModelSubtypeEndpointRef = MIDRegistry.getReference(containerModelTypeEndpointRef, modelRelSubtype.getModelEndpointRefs());
            ModelElementReference modelElemSubtypeRef = null;
            if (modelElemTypeRef != null) {
                ModelEndpointReference modelSubtypeRefSuper = MIDRegistry.getReference((ModelEndpointReference) modelElemTypeRef.eContainer(), modelRelSubtype.getModelEndpointRefs());
                modelElemSubtypeRef = MIDRegistry.getReference(modelElemTypeRef, modelSubtypeRefSuper.getModelElemRefs());
            }
            newModelElemType.createTypeReference(modelElemSubtypeRef, false, containerModelSubtypeEndpointRef);
        }

        return newModelElemTypeRef;
    }

    /**
     * @generated NOT
     */
    @Override
    public void deleteType() throws MMINTException {

        MMINTException.mustBeType(this);

        super.delete();
        //TODO MMINT[OO] might need to implement full removal
    }

    /**
     * @generated NOT
     */
    @Override
    public ENamedElement getEMFTypeObject() throws MMINTException {

        MMINTException.mustBeType(this);

        ENamedElement modelTypeObj;
        try {
            modelTypeObj = (ENamedElement) FileUtils.readModelObject(getUri(), ((Model) eContainer()).getEMFTypeRoot().eResource());
        }
        catch (Exception e) {
            throw new MMINTException("Error accessing metamodel file", e);
        }

        return modelTypeObj;
    }

    /**
     * @generated NOT
     */
    @Override
    public ModelElementReference createInstanceReference(ModelEndpointReference containerModelEndpointRef) throws MMINTException {

        MMINTException.mustBeInstance(this);

        ModelElementReference newModelElemRef = super.createThisReferenceEClass();
        super.addInstanceReference(newModelElemRef, false);
        containerModelEndpointRef.getModelElemRefs().add(newModelElemRef);

        return newModelElemRef;
    }

    /**
     * @generated NOT
     */
    @Override
    public ModelElementReference createInstanceAndReference(String newModelElemUri, String newModelElemName, EMFInfo eInfo, ModelEndpointReference containerModelEndpointRef) throws MMINTException {

        MMINTException.mustBeType(this);

        Model containerModel = containerModelEndpointRef.getObject().getTarget();
        MID instanceMID = containerModel.getMIDContainer();
        ModelElement newModelElem = null;
        newModelElemUri += MMINTConstants.ROLE_SEPARATOR + this.getUri();
        if (instanceMID != null) { // can be null when the containing model is not stored in the MID
            newModelElem = instanceMID.getExtendibleElement(newModelElemUri);
        }
        if (newModelElem == null) {
            newModelElem = super.createThisEClass();
            if (instanceMID == null) {
                super.addBasicInstance(newModelElem, newModelElemUri, newModelElemName, MIDLevel.INSTANCES);
            }
            else {
                super.addInstance(newModelElem, newModelElemUri, newModelElemName, instanceMID);
            }
            newModelElem.setEInfo(eInfo);
            containerModel.getModelElems().add(newModelElem);
        }
        ModelElementReference newModelElemRef = newModelElem.createInstanceReference(containerModelEndpointRef);

        return newModelElemRef;
    }

    /**
     * @generated NOT
     */
    @Override
    public void deleteInstance() throws MMINTException {

        MMINTException.mustBeInstance(this);

        super.delete();
        //TODO MMINT[OO] might need to implement full removal
    }

    /**
     * @generated NOT
     */
    @Override
    public EObject getEMFInstanceObject(@Nullable Resource emfResource) throws MMINTException {

        //TODO MMINT[OO] Does the argument still make sense?
        MMINTException.mustBeInstance(this);

        String modelObjUri = MIDRegistry.getModelObjectUri(this);
        int lastSegmentIndex = modelObjUri.lastIndexOf(MMINTConstants.MODEL_URI_SEPARATOR);
        String lastSegment = modelObjUri.substring(lastSegmentIndex + 1);
        boolean isPrimitive = !lastSegment.equals("") &&
                              !lastSegment.contains(MIDRegistry.ECORE_EREFERENCE_URI_PREFIX) &&
                              !lastSegment.startsWith("_");
        if (isPrimitive) {
            modelObjUri = modelObjUri.substring(0, lastSegmentIndex);
        }
        if (emfResource == null) {
            var modelContainer = (Model) this.eContainer();
            emfResource = modelContainer.getEMFInstanceResource();
        }
        EObject modelObj;
        try {
            modelObj = FileUtils.readModelObject(modelObjUri, emfResource);
        }
        catch (Exception e) {
            throw new MMINTException("Error accessing the model file for model element" + getUri(), e);
        }
        if (isPrimitive) {
            EObject modelObjOwner = modelObj;
            EStructuralFeature feature = modelObjOwner.eClass().getEStructuralFeature(lastSegment);
            modelObj = new PrimitiveEObjectWrapper(modelObjOwner, feature, modelObjOwner.eGet(feature));
        }

        return modelObj;
    }

} //ModelElementImpl

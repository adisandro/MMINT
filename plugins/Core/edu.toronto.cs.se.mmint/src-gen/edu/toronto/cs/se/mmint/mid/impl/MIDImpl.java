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
package edu.toronto.cs.se.mmint.mid.impl;

import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.Model;

import edu.toronto.cs.se.mmint.mid.editor.Editor;

import edu.toronto.cs.se.mmint.mid.operator.Operator;

import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MID</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.impl.MIDImpl#getModels <em>Models</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.impl.MIDImpl#getEditors <em>Editors</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.impl.MIDImpl#getOperators <em>Operators</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.impl.MIDImpl#getExtendibleTable <em>Extendible Table</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.impl.MIDImpl#getLevel <em>Level</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MIDImpl extends MinimalEObjectImpl.Container implements MID {
    /**
     * The cached value of the '{@link #getModels() <em>Models</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getModels()
     * @generated
     * @ordered
     */
    protected EList<Model> models;

    /**
     * The cached value of the '{@link #getEditors() <em>Editors</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEditors()
     * @generated
     * @ordered
     */
    protected EList<Editor> editors;

    /**
     * The cached value of the '{@link #getOperators() <em>Operators</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOperators()
     * @generated
     * @ordered
     */
    protected EList<Operator> operators;

    /**
     * The cached value of the '{@link #getExtendibleTable() <em>Extendible Table</em>}' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExtendibleTable()
     * @generated
     * @ordered
     */
    protected EMap<String, ExtendibleElement> extendibleTable;

    /**
     * The default value of the '{@link #getLevel() <em>Level</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLevel()
     * @generated
     * @ordered
     */
    protected static final MIDLevel LEVEL_EDEFAULT = MIDLevel.INSTANCES;

    /**
     * The cached value of the '{@link #getLevel() <em>Level</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLevel()
     * @generated
     * @ordered
     */
    protected MIDLevel level = LEVEL_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected MIDImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MIDPackage.Literals.MID;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Model> getModels() {
        if (models == null) {
            models = new EObjectContainmentEList<Model>(Model.class, this, MIDPackage.MID__MODELS);
        }
        return models;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Editor> getEditors() {
        if (editors == null) {
            editors = new EObjectContainmentEList<Editor>(Editor.class, this, MIDPackage.MID__EDITORS);
        }
        return editors;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Operator> getOperators() {
        if (operators == null) {
            operators = new EObjectContainmentEList<Operator>(Operator.class, this, MIDPackage.MID__OPERATORS);
        }
        return operators;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EMap<String, ExtendibleElement> getExtendibleTable() {
        if (extendibleTable == null) {
            extendibleTable = new EcoreEMap<String,ExtendibleElement>(MIDPackage.Literals.ESTRING_TO_EXTENDIBLE_ELEMENT_MAP, EStringToExtendibleElementMapImpl.class, this, MIDPackage.MID__EXTENDIBLE_TABLE);
        }
        return extendibleTable;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MIDLevel getLevel() {
        return level;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLevel(MIDLevel newLevel) {
        MIDLevel oldLevel = level;
        level = newLevel == null ? LEVEL_EDEFAULT : newLevel;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MIDPackage.MID__LEVEL, oldLevel, level));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isTypesLevel() {
        return this.getLevel() == MIDLevel.TYPES;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isInstancesLevel() {
        return this.getLevel() == MIDLevel.INSTANCES;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isWorkflowsLevel() {
        return this.getLevel() == MIDLevel.WORKFLOWS;
    }

    /**
     * @generated NOT
     */
    @SuppressWarnings("unchecked")
    public <T extends ExtendibleElement> @Nullable T getExtendibleElement(@NonNull String uri) {

        ExtendibleElement element = this.getExtendibleTable().get(uri);
        if (element == null) {
            return null;
        }

        try {
            return (T) element;
        }
        catch (ClassCastException e) {
            return null;
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ModelRel> getModelRels() {
        EList<ModelRel> modelRels = new BasicEList<>();
        for (Model model : this.getModels()) {
            if (model instanceof ModelRel) {
                modelRels.add((ModelRel) model);
            }
        }
        return modelRels;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case MIDPackage.MID__MODELS:
                return ((InternalEList<?>)getModels()).basicRemove(otherEnd, msgs);
            case MIDPackage.MID__EDITORS:
                return ((InternalEList<?>)getEditors()).basicRemove(otherEnd, msgs);
            case MIDPackage.MID__OPERATORS:
                return ((InternalEList<?>)getOperators()).basicRemove(otherEnd, msgs);
            case MIDPackage.MID__EXTENDIBLE_TABLE:
                return ((InternalEList<?>)getExtendibleTable()).basicRemove(otherEnd, msgs);
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
            case MIDPackage.MID__MODELS:
                return getModels();
            case MIDPackage.MID__EDITORS:
                return getEditors();
            case MIDPackage.MID__OPERATORS:
                return getOperators();
            case MIDPackage.MID__EXTENDIBLE_TABLE:
                if (coreType) return getExtendibleTable();
                else return getExtendibleTable().map();
            case MIDPackage.MID__LEVEL:
                return getLevel();
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
            case MIDPackage.MID__MODELS:
                getModels().clear();
                getModels().addAll((Collection<? extends Model>)newValue);
                return;
            case MIDPackage.MID__EDITORS:
                getEditors().clear();
                getEditors().addAll((Collection<? extends Editor>)newValue);
                return;
            case MIDPackage.MID__OPERATORS:
                getOperators().clear();
                getOperators().addAll((Collection<? extends Operator>)newValue);
                return;
            case MIDPackage.MID__EXTENDIBLE_TABLE:
                ((EStructuralFeature.Setting)getExtendibleTable()).set(newValue);
                return;
            case MIDPackage.MID__LEVEL:
                setLevel((MIDLevel)newValue);
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
            case MIDPackage.MID__MODELS:
                getModels().clear();
                return;
            case MIDPackage.MID__EDITORS:
                getEditors().clear();
                return;
            case MIDPackage.MID__OPERATORS:
                getOperators().clear();
                return;
            case MIDPackage.MID__EXTENDIBLE_TABLE:
                getExtendibleTable().clear();
                return;
            case MIDPackage.MID__LEVEL:
                setLevel(LEVEL_EDEFAULT);
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
            case MIDPackage.MID__MODELS:
                return models != null && !models.isEmpty();
            case MIDPackage.MID__EDITORS:
                return editors != null && !editors.isEmpty();
            case MIDPackage.MID__OPERATORS:
                return operators != null && !operators.isEmpty();
            case MIDPackage.MID__EXTENDIBLE_TABLE:
                return extendibleTable != null && !extendibleTable.isEmpty();
            case MIDPackage.MID__LEVEL:
                return level != LEVEL_EDEFAULT;
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
            case MIDPackage.MID___IS_TYPES_LEVEL:
                return isTypesLevel();
            case MIDPackage.MID___IS_INSTANCES_LEVEL:
                return isInstancesLevel();
            case MIDPackage.MID___IS_WORKFLOWS_LEVEL:
                return isWorkflowsLevel();
            case MIDPackage.MID___GET_EXTENDIBLE_ELEMENT__STRING:
                return getExtendibleElement((String)arguments.get(0));
            case MIDPackage.MID___GET_MODEL_RELS:
                return getModelRels();
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
        result.append(" (level: ");
        result.append(level);
        result.append(')');
        return result.toString();
    }

} //MIDImpl

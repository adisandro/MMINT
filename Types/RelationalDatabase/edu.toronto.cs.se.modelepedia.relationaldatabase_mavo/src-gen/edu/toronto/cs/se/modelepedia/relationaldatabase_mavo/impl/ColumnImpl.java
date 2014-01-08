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
package edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.impl;

import edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.Column;
import edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignColumnReference;
import edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.RelationalDatabase_MAVOPackage;
import edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.Table;
import edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.TableColumnReference;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Column</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.impl.ColumnImpl#getTable <em>Table</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.impl.ColumnImpl#getTableAsPrimaryKey <em>Table As Primary Key</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.impl.ColumnImpl#getForeignKeysAsColumn <em>Foreign Keys As Column</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.impl.ColumnImpl#getForeignKeysAsForeignColumn <em>Foreign Keys As Foreign Column</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ColumnImpl extends NamedElementImpl implements Column {
	/**
	 * The cached value of the '{@link #getTableAsPrimaryKey() <em>Table As Primary Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTableAsPrimaryKey()
	 * @generated
	 * @ordered
	 */
	protected Table tableAsPrimaryKey;

	/**
	 * The cached value of the '{@link #getForeignKeysAsColumn() <em>Foreign Keys As Column</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForeignKeysAsColumn()
	 * @generated
	 * @ordered
	 */
	protected EList<TableColumnReference> foreignKeysAsColumn;

	/**
	 * The cached value of the '{@link #getForeignKeysAsForeignColumn() <em>Foreign Keys As Foreign Column</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForeignKeysAsForeignColumn()
	 * @generated
	 * @ordered
	 */
	protected EList<ForeignColumnReference> foreignKeysAsForeignColumn;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ColumnImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RelationalDatabase_MAVOPackage.Literals.COLUMN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Table getTable() {
		if (eContainerFeatureID() != RelationalDatabase_MAVOPackage.COLUMN__TABLE) return null;
		return (Table)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTable(Table newTable, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTable, RelationalDatabase_MAVOPackage.COLUMN__TABLE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTable(Table newTable) {
		if (newTable != eInternalContainer() || (eContainerFeatureID() != RelationalDatabase_MAVOPackage.COLUMN__TABLE && newTable != null)) {
			if (EcoreUtil.isAncestor(this, newTable))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTable != null)
				msgs = ((InternalEObject)newTable).eInverseAdd(this, RelationalDatabase_MAVOPackage.TABLE__COLUMNS, Table.class, msgs);
			msgs = basicSetTable(newTable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelationalDatabase_MAVOPackage.COLUMN__TABLE, newTable, newTable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Table getTableAsPrimaryKey() {
		if (tableAsPrimaryKey != null && tableAsPrimaryKey.eIsProxy()) {
			InternalEObject oldTableAsPrimaryKey = (InternalEObject)tableAsPrimaryKey;
			tableAsPrimaryKey = (Table)eResolveProxy(oldTableAsPrimaryKey);
			if (tableAsPrimaryKey != oldTableAsPrimaryKey) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationalDatabase_MAVOPackage.COLUMN__TABLE_AS_PRIMARY_KEY, oldTableAsPrimaryKey, tableAsPrimaryKey));
			}
		}
		return tableAsPrimaryKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Table basicGetTableAsPrimaryKey() {
		return tableAsPrimaryKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTableAsPrimaryKey(Table newTableAsPrimaryKey, NotificationChain msgs) {
		Table oldTableAsPrimaryKey = tableAsPrimaryKey;
		tableAsPrimaryKey = newTableAsPrimaryKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RelationalDatabase_MAVOPackage.COLUMN__TABLE_AS_PRIMARY_KEY, oldTableAsPrimaryKey, newTableAsPrimaryKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTableAsPrimaryKey(Table newTableAsPrimaryKey) {
		if (newTableAsPrimaryKey != tableAsPrimaryKey) {
			NotificationChain msgs = null;
			if (tableAsPrimaryKey != null)
				msgs = ((InternalEObject)tableAsPrimaryKey).eInverseRemove(this, RelationalDatabase_MAVOPackage.TABLE__PRIMARY_KEY, Table.class, msgs);
			if (newTableAsPrimaryKey != null)
				msgs = ((InternalEObject)newTableAsPrimaryKey).eInverseAdd(this, RelationalDatabase_MAVOPackage.TABLE__PRIMARY_KEY, Table.class, msgs);
			msgs = basicSetTableAsPrimaryKey(newTableAsPrimaryKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelationalDatabase_MAVOPackage.COLUMN__TABLE_AS_PRIMARY_KEY, newTableAsPrimaryKey, newTableAsPrimaryKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TableColumnReference> getForeignKeysAsColumn() {
		if (foreignKeysAsColumn == null) {
			foreignKeysAsColumn = new EObjectWithInverseResolvingEList<TableColumnReference>(TableColumnReference.class, this, RelationalDatabase_MAVOPackage.COLUMN__FOREIGN_KEYS_AS_COLUMN, RelationalDatabase_MAVOPackage.TABLE_COLUMN_REFERENCE__TARGET);
		}
		return foreignKeysAsColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ForeignColumnReference> getForeignKeysAsForeignColumn() {
		if (foreignKeysAsForeignColumn == null) {
			foreignKeysAsForeignColumn = new EObjectWithInverseResolvingEList<ForeignColumnReference>(ForeignColumnReference.class, this, RelationalDatabase_MAVOPackage.COLUMN__FOREIGN_KEYS_AS_FOREIGN_COLUMN, RelationalDatabase_MAVOPackage.FOREIGN_COLUMN_REFERENCE__TARGET);
		}
		return foreignKeysAsForeignColumn;
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
			case RelationalDatabase_MAVOPackage.COLUMN__TABLE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTable((Table)otherEnd, msgs);
			case RelationalDatabase_MAVOPackage.COLUMN__TABLE_AS_PRIMARY_KEY:
				if (tableAsPrimaryKey != null)
					msgs = ((InternalEObject)tableAsPrimaryKey).eInverseRemove(this, RelationalDatabase_MAVOPackage.TABLE__PRIMARY_KEY, Table.class, msgs);
				return basicSetTableAsPrimaryKey((Table)otherEnd, msgs);
			case RelationalDatabase_MAVOPackage.COLUMN__FOREIGN_KEYS_AS_COLUMN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getForeignKeysAsColumn()).basicAdd(otherEnd, msgs);
			case RelationalDatabase_MAVOPackage.COLUMN__FOREIGN_KEYS_AS_FOREIGN_COLUMN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getForeignKeysAsForeignColumn()).basicAdd(otherEnd, msgs);
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
			case RelationalDatabase_MAVOPackage.COLUMN__TABLE:
				return basicSetTable(null, msgs);
			case RelationalDatabase_MAVOPackage.COLUMN__TABLE_AS_PRIMARY_KEY:
				return basicSetTableAsPrimaryKey(null, msgs);
			case RelationalDatabase_MAVOPackage.COLUMN__FOREIGN_KEYS_AS_COLUMN:
				return ((InternalEList<?>)getForeignKeysAsColumn()).basicRemove(otherEnd, msgs);
			case RelationalDatabase_MAVOPackage.COLUMN__FOREIGN_KEYS_AS_FOREIGN_COLUMN:
				return ((InternalEList<?>)getForeignKeysAsForeignColumn()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case RelationalDatabase_MAVOPackage.COLUMN__TABLE:
				return eInternalContainer().eInverseRemove(this, RelationalDatabase_MAVOPackage.TABLE__COLUMNS, Table.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RelationalDatabase_MAVOPackage.COLUMN__TABLE:
				return getTable();
			case RelationalDatabase_MAVOPackage.COLUMN__TABLE_AS_PRIMARY_KEY:
				if (resolve) return getTableAsPrimaryKey();
				return basicGetTableAsPrimaryKey();
			case RelationalDatabase_MAVOPackage.COLUMN__FOREIGN_KEYS_AS_COLUMN:
				return getForeignKeysAsColumn();
			case RelationalDatabase_MAVOPackage.COLUMN__FOREIGN_KEYS_AS_FOREIGN_COLUMN:
				return getForeignKeysAsForeignColumn();
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
			case RelationalDatabase_MAVOPackage.COLUMN__TABLE:
				setTable((Table)newValue);
				return;
			case RelationalDatabase_MAVOPackage.COLUMN__TABLE_AS_PRIMARY_KEY:
				setTableAsPrimaryKey((Table)newValue);
				return;
			case RelationalDatabase_MAVOPackage.COLUMN__FOREIGN_KEYS_AS_COLUMN:
				getForeignKeysAsColumn().clear();
				getForeignKeysAsColumn().addAll((Collection<? extends TableColumnReference>)newValue);
				return;
			case RelationalDatabase_MAVOPackage.COLUMN__FOREIGN_KEYS_AS_FOREIGN_COLUMN:
				getForeignKeysAsForeignColumn().clear();
				getForeignKeysAsForeignColumn().addAll((Collection<? extends ForeignColumnReference>)newValue);
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
			case RelationalDatabase_MAVOPackage.COLUMN__TABLE:
				setTable((Table)null);
				return;
			case RelationalDatabase_MAVOPackage.COLUMN__TABLE_AS_PRIMARY_KEY:
				setTableAsPrimaryKey((Table)null);
				return;
			case RelationalDatabase_MAVOPackage.COLUMN__FOREIGN_KEYS_AS_COLUMN:
				getForeignKeysAsColumn().clear();
				return;
			case RelationalDatabase_MAVOPackage.COLUMN__FOREIGN_KEYS_AS_FOREIGN_COLUMN:
				getForeignKeysAsForeignColumn().clear();
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
			case RelationalDatabase_MAVOPackage.COLUMN__TABLE:
				return getTable() != null;
			case RelationalDatabase_MAVOPackage.COLUMN__TABLE_AS_PRIMARY_KEY:
				return tableAsPrimaryKey != null;
			case RelationalDatabase_MAVOPackage.COLUMN__FOREIGN_KEYS_AS_COLUMN:
				return foreignKeysAsColumn != null && !foreignKeysAsColumn.isEmpty();
			case RelationalDatabase_MAVOPackage.COLUMN__FOREIGN_KEYS_AS_FOREIGN_COLUMN:
				return foreignKeysAsForeignColumn != null && !foreignKeysAsForeignColumn.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ColumnImpl

/**
 * Copyright (c) 2012-2025 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.relationaldatabase.impl;

import edu.toronto.cs.se.modelepedia.relationaldatabase.Column;
import edu.toronto.cs.se.modelepedia.relationaldatabase.ForeignKey;
import edu.toronto.cs.se.modelepedia.relationaldatabase.RelationalDatabasePackage;
import edu.toronto.cs.se.modelepedia.relationaldatabase.Table;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Foreign Key</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.relationaldatabase.impl.ForeignKeyImpl#getTableColumn <em>Table Column</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.relationaldatabase.impl.ForeignKeyImpl#getForeignColumn <em>Foreign Column</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.relationaldatabase.impl.ForeignKeyImpl#getTable <em>Table</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ForeignKeyImpl extends NamedElementImpl implements ForeignKey {
	/**
	 * The cached value of the '{@link #getTableColumn() <em>Table Column</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTableColumn()
	 * @generated
	 * @ordered
	 */
	protected Column tableColumn;

	/**
	 * The cached value of the '{@link #getForeignColumn() <em>Foreign Column</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForeignColumn()
	 * @generated
	 * @ordered
	 */
	protected Column foreignColumn;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ForeignKeyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RelationalDatabasePackage.Literals.FOREIGN_KEY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Column getTableColumn() {
		if (tableColumn != null && tableColumn.eIsProxy()) {
			InternalEObject oldTableColumn = (InternalEObject)tableColumn;
			tableColumn = (Column)eResolveProxy(oldTableColumn);
			if (tableColumn != oldTableColumn) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationalDatabasePackage.FOREIGN_KEY__TABLE_COLUMN, oldTableColumn, tableColumn));
			}
		}
		return tableColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Column basicGetTableColumn() {
		return tableColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTableColumn(Column newTableColumn, NotificationChain msgs) {
		Column oldTableColumn = tableColumn;
		tableColumn = newTableColumn;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RelationalDatabasePackage.FOREIGN_KEY__TABLE_COLUMN, oldTableColumn, newTableColumn);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTableColumn(Column newTableColumn) {
		if (newTableColumn != tableColumn) {
			NotificationChain msgs = null;
			if (tableColumn != null)
				msgs = ((InternalEObject)tableColumn).eInverseRemove(this, RelationalDatabasePackage.COLUMN__FOREIGN_KEYS_AS_COLUMN, Column.class, msgs);
			if (newTableColumn != null)
				msgs = ((InternalEObject)newTableColumn).eInverseAdd(this, RelationalDatabasePackage.COLUMN__FOREIGN_KEYS_AS_COLUMN, Column.class, msgs);
			msgs = basicSetTableColumn(newTableColumn, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelationalDatabasePackage.FOREIGN_KEY__TABLE_COLUMN, newTableColumn, newTableColumn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Column getForeignColumn() {
		if (foreignColumn != null && foreignColumn.eIsProxy()) {
			InternalEObject oldForeignColumn = (InternalEObject)foreignColumn;
			foreignColumn = (Column)eResolveProxy(oldForeignColumn);
			if (foreignColumn != oldForeignColumn) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationalDatabasePackage.FOREIGN_KEY__FOREIGN_COLUMN, oldForeignColumn, foreignColumn));
			}
		}
		return foreignColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Column basicGetForeignColumn() {
		return foreignColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetForeignColumn(Column newForeignColumn, NotificationChain msgs) {
		Column oldForeignColumn = foreignColumn;
		foreignColumn = newForeignColumn;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RelationalDatabasePackage.FOREIGN_KEY__FOREIGN_COLUMN, oldForeignColumn, newForeignColumn);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setForeignColumn(Column newForeignColumn) {
		if (newForeignColumn != foreignColumn) {
			NotificationChain msgs = null;
			if (foreignColumn != null)
				msgs = ((InternalEObject)foreignColumn).eInverseRemove(this, RelationalDatabasePackage.COLUMN__FOREIGN_KEYS_AS_FOREIGN_COLUMN, Column.class, msgs);
			if (newForeignColumn != null)
				msgs = ((InternalEObject)newForeignColumn).eInverseAdd(this, RelationalDatabasePackage.COLUMN__FOREIGN_KEYS_AS_FOREIGN_COLUMN, Column.class, msgs);
			msgs = basicSetForeignColumn(newForeignColumn, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelationalDatabasePackage.FOREIGN_KEY__FOREIGN_COLUMN, newForeignColumn, newForeignColumn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Table getTable() {
		if (eContainerFeatureID() != RelationalDatabasePackage.FOREIGN_KEY__TABLE) return null;
		return (Table)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTable(Table newTable, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTable, RelationalDatabasePackage.FOREIGN_KEY__TABLE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTable(Table newTable) {
		if (newTable != eInternalContainer() || (eContainerFeatureID() != RelationalDatabasePackage.FOREIGN_KEY__TABLE && newTable != null)) {
			if (EcoreUtil.isAncestor(this, newTable))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTable != null)
				msgs = ((InternalEObject)newTable).eInverseAdd(this, RelationalDatabasePackage.TABLE__FOREIGN_KEYS, Table.class, msgs);
			msgs = basicSetTable(newTable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelationalDatabasePackage.FOREIGN_KEY__TABLE, newTable, newTable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RelationalDatabasePackage.FOREIGN_KEY__TABLE_COLUMN:
				if (tableColumn != null)
					msgs = ((InternalEObject)tableColumn).eInverseRemove(this, RelationalDatabasePackage.COLUMN__FOREIGN_KEYS_AS_COLUMN, Column.class, msgs);
				return basicSetTableColumn((Column)otherEnd, msgs);
			case RelationalDatabasePackage.FOREIGN_KEY__FOREIGN_COLUMN:
				if (foreignColumn != null)
					msgs = ((InternalEObject)foreignColumn).eInverseRemove(this, RelationalDatabasePackage.COLUMN__FOREIGN_KEYS_AS_FOREIGN_COLUMN, Column.class, msgs);
				return basicSetForeignColumn((Column)otherEnd, msgs);
			case RelationalDatabasePackage.FOREIGN_KEY__TABLE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTable((Table)otherEnd, msgs);
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
			case RelationalDatabasePackage.FOREIGN_KEY__TABLE_COLUMN:
				return basicSetTableColumn(null, msgs);
			case RelationalDatabasePackage.FOREIGN_KEY__FOREIGN_COLUMN:
				return basicSetForeignColumn(null, msgs);
			case RelationalDatabasePackage.FOREIGN_KEY__TABLE:
				return basicSetTable(null, msgs);
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
			case RelationalDatabasePackage.FOREIGN_KEY__TABLE:
				return eInternalContainer().eInverseRemove(this, RelationalDatabasePackage.TABLE__FOREIGN_KEYS, Table.class, msgs);
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
			case RelationalDatabasePackage.FOREIGN_KEY__TABLE_COLUMN:
				if (resolve) return getTableColumn();
				return basicGetTableColumn();
			case RelationalDatabasePackage.FOREIGN_KEY__FOREIGN_COLUMN:
				if (resolve) return getForeignColumn();
				return basicGetForeignColumn();
			case RelationalDatabasePackage.FOREIGN_KEY__TABLE:
				return getTable();
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
			case RelationalDatabasePackage.FOREIGN_KEY__TABLE_COLUMN:
				setTableColumn((Column)newValue);
				return;
			case RelationalDatabasePackage.FOREIGN_KEY__FOREIGN_COLUMN:
				setForeignColumn((Column)newValue);
				return;
			case RelationalDatabasePackage.FOREIGN_KEY__TABLE:
				setTable((Table)newValue);
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
			case RelationalDatabasePackage.FOREIGN_KEY__TABLE_COLUMN:
				setTableColumn((Column)null);
				return;
			case RelationalDatabasePackage.FOREIGN_KEY__FOREIGN_COLUMN:
				setForeignColumn((Column)null);
				return;
			case RelationalDatabasePackage.FOREIGN_KEY__TABLE:
				setTable((Table)null);
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
			case RelationalDatabasePackage.FOREIGN_KEY__TABLE_COLUMN:
				return tableColumn != null;
			case RelationalDatabasePackage.FOREIGN_KEY__FOREIGN_COLUMN:
				return foreignColumn != null;
			case RelationalDatabasePackage.FOREIGN_KEY__TABLE:
				return getTable() != null;
		}
		return super.eIsSet(featureID);
	}

} //ForeignKeyImpl

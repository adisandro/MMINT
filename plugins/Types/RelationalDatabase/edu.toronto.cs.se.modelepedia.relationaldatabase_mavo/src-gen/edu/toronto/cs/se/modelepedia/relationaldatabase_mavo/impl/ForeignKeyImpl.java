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
package edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.impl;

import edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignColumnReference;
import edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignKey;
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

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Foreign Key</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.impl.ForeignKeyImpl#getTableColumn <em>Table Column</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.impl.ForeignKeyImpl#getForeignColumn <em>Foreign Column</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.impl.ForeignKeyImpl#getTable <em>Table</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ForeignKeyImpl extends NamedElementImpl implements ForeignKey {
	/**
	 * The cached value of the '{@link #getTableColumn() <em>Table Column</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTableColumn()
	 * @generated
	 * @ordered
	 */
	protected EList<TableColumnReference> tableColumn;

	/**
	 * The cached value of the '{@link #getForeignColumn() <em>Foreign Column</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForeignColumn()
	 * @generated
	 * @ordered
	 */
	protected EList<ForeignColumnReference> foreignColumn;

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
		return RelationalDatabase_MAVOPackage.Literals.FOREIGN_KEY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TableColumnReference> getTableColumn() {
		if (tableColumn == null) {
			tableColumn = new EObjectContainmentWithInverseEList<TableColumnReference>(TableColumnReference.class, this, RelationalDatabase_MAVOPackage.FOREIGN_KEY__TABLE_COLUMN, RelationalDatabase_MAVOPackage.TABLE_COLUMN_REFERENCE__SOURCE);
		}
		return tableColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ForeignColumnReference> getForeignColumn() {
		if (foreignColumn == null) {
			foreignColumn = new EObjectContainmentWithInverseEList<ForeignColumnReference>(ForeignColumnReference.class, this, RelationalDatabase_MAVOPackage.FOREIGN_KEY__FOREIGN_COLUMN, RelationalDatabase_MAVOPackage.FOREIGN_COLUMN_REFERENCE__SOURCE);
		}
		return foreignColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Table getTable() {
		if (eContainerFeatureID() != RelationalDatabase_MAVOPackage.FOREIGN_KEY__TABLE) return null;
		return (Table)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTable(Table newTable, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTable, RelationalDatabase_MAVOPackage.FOREIGN_KEY__TABLE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTable(Table newTable) {
		if (newTable != eInternalContainer() || (eContainerFeatureID() != RelationalDatabase_MAVOPackage.FOREIGN_KEY__TABLE && newTable != null)) {
			if (EcoreUtil.isAncestor(this, newTable))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTable != null)
				msgs = ((InternalEObject)newTable).eInverseAdd(this, RelationalDatabase_MAVOPackage.TABLE__FOREIGN_KEYS, Table.class, msgs);
			msgs = basicSetTable(newTable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelationalDatabase_MAVOPackage.FOREIGN_KEY__TABLE, newTable, newTable));
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
			case RelationalDatabase_MAVOPackage.FOREIGN_KEY__TABLE_COLUMN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTableColumn()).basicAdd(otherEnd, msgs);
			case RelationalDatabase_MAVOPackage.FOREIGN_KEY__FOREIGN_COLUMN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getForeignColumn()).basicAdd(otherEnd, msgs);
			case RelationalDatabase_MAVOPackage.FOREIGN_KEY__TABLE:
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
			case RelationalDatabase_MAVOPackage.FOREIGN_KEY__TABLE_COLUMN:
				return ((InternalEList<?>)getTableColumn()).basicRemove(otherEnd, msgs);
			case RelationalDatabase_MAVOPackage.FOREIGN_KEY__FOREIGN_COLUMN:
				return ((InternalEList<?>)getForeignColumn()).basicRemove(otherEnd, msgs);
			case RelationalDatabase_MAVOPackage.FOREIGN_KEY__TABLE:
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
			case RelationalDatabase_MAVOPackage.FOREIGN_KEY__TABLE:
				return eInternalContainer().eInverseRemove(this, RelationalDatabase_MAVOPackage.TABLE__FOREIGN_KEYS, Table.class, msgs);
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
			case RelationalDatabase_MAVOPackage.FOREIGN_KEY__TABLE_COLUMN:
				return getTableColumn();
			case RelationalDatabase_MAVOPackage.FOREIGN_KEY__FOREIGN_COLUMN:
				return getForeignColumn();
			case RelationalDatabase_MAVOPackage.FOREIGN_KEY__TABLE:
				return getTable();
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
			case RelationalDatabase_MAVOPackage.FOREIGN_KEY__TABLE_COLUMN:
				getTableColumn().clear();
				getTableColumn().addAll((Collection<? extends TableColumnReference>)newValue);
				return;
			case RelationalDatabase_MAVOPackage.FOREIGN_KEY__FOREIGN_COLUMN:
				getForeignColumn().clear();
				getForeignColumn().addAll((Collection<? extends ForeignColumnReference>)newValue);
				return;
			case RelationalDatabase_MAVOPackage.FOREIGN_KEY__TABLE:
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
			case RelationalDatabase_MAVOPackage.FOREIGN_KEY__TABLE_COLUMN:
				getTableColumn().clear();
				return;
			case RelationalDatabase_MAVOPackage.FOREIGN_KEY__FOREIGN_COLUMN:
				getForeignColumn().clear();
				return;
			case RelationalDatabase_MAVOPackage.FOREIGN_KEY__TABLE:
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
			case RelationalDatabase_MAVOPackage.FOREIGN_KEY__TABLE_COLUMN:
				return tableColumn != null && !tableColumn.isEmpty();
			case RelationalDatabase_MAVOPackage.FOREIGN_KEY__FOREIGN_COLUMN:
				return foreignColumn != null && !foreignColumn.isEmpty();
			case RelationalDatabase_MAVOPackage.FOREIGN_KEY__TABLE:
				return getTable() != null;
		}
		return super.eIsSet(featureID);
	}

} //ForeignKeyImpl

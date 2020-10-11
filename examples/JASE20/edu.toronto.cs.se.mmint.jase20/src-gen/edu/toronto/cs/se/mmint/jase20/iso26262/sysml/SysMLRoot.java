/**
 * Copyright (c) 2012-2020 Alessio Di Sandro, Marsha Chechik, Rick Salay, Sahar Kokaly.
 * All rights reserved. This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Alessio Di Sandro - Implementation
 */
package edu.toronto.cs.se.mmint.jase20.iso26262.sysml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.jase20.iso26262.sysml.SysMLRoot#getItems <em>Items</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.jase20.iso26262.sysml.SysMLPackage#getSysMLRoot()
 * @model
 * @generated
 */
public interface SysMLRoot extends EObject {
  /**
   * Returns the value of the '<em><b>Items</b></em>' containment reference list.
   * The list contents are of type {@link edu.toronto.cs.se.mmint.jase20.iso26262.sysml.Item}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Items</em>' containment reference list.
   * @see edu.toronto.cs.se.mmint.jase20.iso26262.sysml.SysMLPackage#getSysMLRoot_Items()
   * @model containment="true"
   * @generated
   */
  EList<Item> getItems();

} // SysMLRoot

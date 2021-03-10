/**
 * Copyright (c) 2012-2021 Alessio Di Sandro, Marsha Chechik, Nick Fung.
 * All rights reserved. This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Alessio Di Sandro - Implementation
 *   Nick Fung - Implementation.
 *
 */
package edu.toronto.cs.se.modelepedia.gsn;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Enum Domain</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link edu.toronto.cs.se.modelepedia.gsn.EnumDomain#getValues <em>Values</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getEnumDomain()
 * @model
 * @generated
 */
public interface EnumDomain extends Domain {
  /**
   * Returns the value of the '<em><b>Values</b></em>' attribute list. The list contents are of type
   * {@link java.lang.String}. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Values</em>' attribute list.
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getEnumDomain_Values()
   * @model lower="2"
   * @generated
   */
  EList<String> getValues();

} // EnumDomain

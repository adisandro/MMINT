/*******************************************************************************
 * Copyright (c) 2020, 2023 Alessio Di Sandro.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.modelepedia.gsn;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Domain</b></em>'. <!-- end-user-doc -->
 *
 *
 * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getDomain()
 * @model abstract="true"
 * @generated
 */
public interface Domain extends EObject {

  /**
   * <!-- begin-user-doc --> Validates the correctness of the decomposition of this domain.
   *
   * @param subDomains
   *          The sub-domains in which this domain is decomposed.
   * @throws Exception
   *           If the decomposition is not correct. <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.modelepedia.gsn.Exception" subDomainsMany="true"
   * @generated
   */
  void validateDecomposition(EList<Domain> subDomains) throws Exception;
} // Domain

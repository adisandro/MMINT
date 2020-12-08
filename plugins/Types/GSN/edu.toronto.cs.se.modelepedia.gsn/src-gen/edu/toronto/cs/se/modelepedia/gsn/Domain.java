/**
 * Copyright (c) 2012-2020 Alessio Di Sandro, Marsha Chechik, Nick Fung.
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
import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.MMINTException;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain</b></em>'.
 * <!-- end-user-doc -->
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
   * @throws MMINTException
   *           If the decomposition in not correct. <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.modelepedia.gsn.MMINTException" subDomainsMany="true"
   * @generated
   */
  void validateDecomposition(EList<Domain> subDomains) throws MMINTException;
} // Domain

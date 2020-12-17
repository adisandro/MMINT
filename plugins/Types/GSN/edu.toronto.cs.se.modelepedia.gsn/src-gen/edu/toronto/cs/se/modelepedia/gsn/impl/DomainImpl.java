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
package edu.toronto.cs.se.modelepedia.gsn.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.modelepedia.gsn.Domain;
import edu.toronto.cs.se.modelepedia.gsn.EnumDomain;
import edu.toronto.cs.se.modelepedia.gsn.GSNFactory;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.IntDomain;
import edu.toronto.cs.se.modelepedia.gsn.RealDomain;
import edu.toronto.cs.se.modelepedia.gsn.ValueDomain;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Domain</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class DomainImpl extends MinimalEObjectImpl.Container implements Domain {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DomainImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return GSNPackage.Literals.DOMAIN;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void validateDecomposition(EList<Domain> subDomains) throws Exception {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  @SuppressWarnings("unchecked")
  public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
    switch (operationID) {
      case GSNPackage.DOMAIN___VALIDATE_DECOMPOSITION__ELIST:
        try {
          validateDecomposition((EList<Domain>)arguments.get(0));
          return null;
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
    }
    return super.eInvoke(operationID, arguments);
  }

  /**
   * Parses a string representing a domain and creates a domain instance (e.g. integer range '-40_50'; real range
   * '-40.0_50.0'; enumeration 'x,y,z'; single value 'x').
   *
   * @param domainString
   *          The domain string.
   * @return The domain instance.
   * @throws Exception
   *           If the domain string is malformed.
   * @generated NOT
   */
  public static Domain parseDomainString(String domainString) throws Exception {
    if (domainString.isBlank()) {
      throw new MMINTException("Empty domain");
    }

    Domain domain;
    domainString = domainString.strip();
    if (domainString.contains("_")) {
      var entries = domainString.split("_");
      if (entries.length != 2) {
        throw new MMINTException("Bad numeric domain format");
      }
      try {
        var lower = Integer.parseInt(entries[0].strip());
        var upper = Integer.parseInt(entries[1].strip());
        if (upper <= lower) {
          throw new MMINTException("Upper bound must be > lower bound");
        }
        domain = GSNFactory.eINSTANCE.createIntDomain();
        ((IntDomain) domain).setLowerBound(lower);
        ((IntDomain) domain).setUpperBound(upper);
      }
      catch (NumberFormatException e) {
        var lower = Double.parseDouble(entries[0].strip());
        var upper = Double.parseDouble(entries[1].strip());
        if (upper <= lower) {
          throw new MMINTException("Upper bound must be > lower bound");
        }
        domain = GSNFactory.eINSTANCE.createRealDomain();
        ((RealDomain) domain).setLowerBound(lower);
        ((RealDomain) domain).setUpperBound(upper);
      }
    }
    else if (domainString.contains(",")) {
      var entries = domainString.split(",");
      if (entries.length == 1) {
        throw new MMINTException("Bad enumeration domain format");
      }
      domain = GSNFactory.eINSTANCE.createEnumDomain();
      var enumValues = ((EnumDomain) domain).getValues();
      for (var entry : entries) {
        if (entry.isBlank()) {
          continue;
        }
        enumValues.add(entry.strip());
      }
    }
    else {
      domain = GSNFactory.eINSTANCE.createValueDomain();
      ((ValueDomain) domain).setValue(domainString.strip());
    }

    return domain;
  }

} //DomainImpl

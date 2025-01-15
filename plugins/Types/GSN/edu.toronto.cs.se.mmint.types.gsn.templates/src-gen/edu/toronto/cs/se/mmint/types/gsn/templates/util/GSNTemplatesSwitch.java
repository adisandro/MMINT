/*******************************************************************************
 * Copyright (c) 2023, 2025 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.types.gsn.templates.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

import edu.toronto.cs.se.mmint.types.gsn.templates.AnalyticTemplate;
import edu.toronto.cs.se.mmint.types.gsn.templates.DecompositionTemplate;
import edu.toronto.cs.se.mmint.types.gsn.templates.Domain;
import edu.toronto.cs.se.mmint.types.gsn.templates.DomainDecompositionElement;
import edu.toronto.cs.se.mmint.types.gsn.templates.DomainDecompositionStrategy;
import edu.toronto.cs.se.mmint.types.gsn.templates.DomainDecompositionTemplate;
import edu.toronto.cs.se.mmint.types.gsn.templates.DomainGoal;
import edu.toronto.cs.se.mmint.types.gsn.templates.EnumDomain;
import edu.toronto.cs.se.mmint.types.gsn.templates.FilesContext;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage;
import edu.toronto.cs.se.mmint.types.gsn.templates.IntDomain;
import edu.toronto.cs.se.mmint.types.gsn.templates.Property;
import edu.toronto.cs.se.mmint.types.gsn.templates.PropertyDecompositionElement;
import edu.toronto.cs.se.mmint.types.gsn.templates.PropertyDecompositionStrategy;
import edu.toronto.cs.se.mmint.types.gsn.templates.PropertyDecompositionTemplate;
import edu.toronto.cs.se.mmint.types.gsn.templates.PropertyGoal;
import edu.toronto.cs.se.mmint.types.gsn.templates.RealDomain;
import edu.toronto.cs.se.mmint.types.gsn.templates.ValueDomain;
import edu.toronto.cs.se.modelepedia.gsn.ASILfulElement;
import edu.toronto.cs.se.modelepedia.gsn.ArgumentElement;
import edu.toronto.cs.se.modelepedia.gsn.Context;
import edu.toronto.cs.se.modelepedia.gsn.Contextual;
import edu.toronto.cs.se.modelepedia.gsn.Contextualizable;
import edu.toronto.cs.se.modelepedia.gsn.Decoratable;
import edu.toronto.cs.se.modelepedia.gsn.Goal;
import edu.toronto.cs.se.modelepedia.gsn.Strategy;
import edu.toronto.cs.se.modelepedia.gsn.Supportable;
import edu.toronto.cs.se.modelepedia.gsn.Supporter;
import edu.toronto.cs.se.modelepedia.gsn.Template;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage
 * @generated
 */
public class GSNTemplatesSwitch<T> extends Switch<T> {
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static GSNTemplatesPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GSNTemplatesSwitch() {
    if (GSNTemplatesSwitch.modelPackage == null) {
      GSNTemplatesSwitch.modelPackage = GSNTemplatesPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage) {
    return ePackage == GSNTemplatesSwitch.modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject) {
    switch (classifierID) {
      case GSNTemplatesPackage.DECOMPOSITION_TEMPLATE: {
        var decompositionTemplate = (DecompositionTemplate)theEObject;
        var result = caseDecompositionTemplate(decompositionTemplate);
        if (result == null) {
          result = caseTemplate(decompositionTemplate);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case GSNTemplatesPackage.DOMAIN: {
        var domain = (Domain)theEObject;
        var result = caseDomain(domain);
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case GSNTemplatesPackage.INT_DOMAIN: {
        var intDomain = (IntDomain)theEObject;
        var result = caseIntDomain(intDomain);
        if (result == null) {
          result = caseDomain(intDomain);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case GSNTemplatesPackage.REAL_DOMAIN: {
        var realDomain = (RealDomain)theEObject;
        var result = caseRealDomain(realDomain);
        if (result == null) {
          result = caseDomain(realDomain);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case GSNTemplatesPackage.ENUM_DOMAIN: {
        var enumDomain = (EnumDomain)theEObject;
        var result = caseEnumDomain(enumDomain);
        if (result == null) {
          result = caseDomain(enumDomain);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case GSNTemplatesPackage.VALUE_DOMAIN: {
        var valueDomain = (ValueDomain)theEObject;
        var result = caseValueDomain(valueDomain);
        if (result == null) {
          result = caseDomain(valueDomain);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case GSNTemplatesPackage.DOMAIN_DECOMPOSITION_ELEMENT: {
        var domainDecompositionElement = (DomainDecompositionElement)theEObject;
        var result = caseDomainDecompositionElement(domainDecompositionElement);
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case GSNTemplatesPackage.DOMAIN_DECOMPOSITION_STRATEGY: {
        var domainDecompositionStrategy = (DomainDecompositionStrategy)theEObject;
        var result = caseDomainDecompositionStrategy(domainDecompositionStrategy);
        if (result == null) {
          result = caseStrategy(domainDecompositionStrategy);
        }
        if (result == null) {
          result = caseDomainDecompositionElement(domainDecompositionStrategy);
        }
        if (result == null) {
          result = caseSupportable(domainDecompositionStrategy);
        }
        if (result == null) {
          result = caseSupporter(domainDecompositionStrategy);
        }
        if (result == null) {
          result = caseContextualizable(domainDecompositionStrategy);
        }
        if (result == null) {
          result = caseDecoratable(domainDecompositionStrategy);
        }
        if (result == null) {
          result = caseArgumentElement(domainDecompositionStrategy);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case GSNTemplatesPackage.DOMAIN_GOAL: {
        var domainGoal = (DomainGoal)theEObject;
        var result = caseDomainGoal(domainGoal);
        if (result == null) {
          result = caseGoal(domainGoal);
        }
        if (result == null) {
          result = caseDomainDecompositionElement(domainGoal);
        }
        if (result == null) {
          result = caseSupportable(domainGoal);
        }
        if (result == null) {
          result = caseSupporter(domainGoal);
        }
        if (result == null) {
          result = caseContextualizable(domainGoal);
        }
        if (result == null) {
          result = caseASILfulElement(domainGoal);
        }
        if (result == null) {
          result = caseDecoratable(domainGoal);
        }
        if (result == null) {
          result = caseArgumentElement(domainGoal);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case GSNTemplatesPackage.DOMAIN_DECOMPOSITION_TEMPLATE: {
        var domainDecompositionTemplate = (DomainDecompositionTemplate)theEObject;
        var result = caseDomainDecompositionTemplate(domainDecompositionTemplate);
        if (result == null) {
          result = caseDecompositionTemplate(domainDecompositionTemplate);
        }
        if (result == null) {
          result = caseTemplate(domainDecompositionTemplate);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case GSNTemplatesPackage.PROPERTY: {
        var property = (Property)theEObject;
        var result = caseProperty(property);
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case GSNTemplatesPackage.PROPERTY_DECOMPOSITION_ELEMENT: {
        var propertyDecompositionElement = (PropertyDecompositionElement)theEObject;
        var result = casePropertyDecompositionElement(propertyDecompositionElement);
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case GSNTemplatesPackage.PROPERTY_DECOMPOSITION_STRATEGY: {
        var propertyDecompositionStrategy = (PropertyDecompositionStrategy)theEObject;
        var result = casePropertyDecompositionStrategy(propertyDecompositionStrategy);
        if (result == null) {
          result = caseStrategy(propertyDecompositionStrategy);
        }
        if (result == null) {
          result = casePropertyDecompositionElement(propertyDecompositionStrategy);
        }
        if (result == null) {
          result = caseSupportable(propertyDecompositionStrategy);
        }
        if (result == null) {
          result = caseSupporter(propertyDecompositionStrategy);
        }
        if (result == null) {
          result = caseContextualizable(propertyDecompositionStrategy);
        }
        if (result == null) {
          result = caseDecoratable(propertyDecompositionStrategy);
        }
        if (result == null) {
          result = caseArgumentElement(propertyDecompositionStrategy);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case GSNTemplatesPackage.PROPERTY_GOAL: {
        var propertyGoal = (PropertyGoal)theEObject;
        var result = casePropertyGoal(propertyGoal);
        if (result == null) {
          result = caseGoal(propertyGoal);
        }
        if (result == null) {
          result = casePropertyDecompositionElement(propertyGoal);
        }
        if (result == null) {
          result = caseSupportable(propertyGoal);
        }
        if (result == null) {
          result = caseSupporter(propertyGoal);
        }
        if (result == null) {
          result = caseContextualizable(propertyGoal);
        }
        if (result == null) {
          result = caseASILfulElement(propertyGoal);
        }
        if (result == null) {
          result = caseDecoratable(propertyGoal);
        }
        if (result == null) {
          result = caseArgumentElement(propertyGoal);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case GSNTemplatesPackage.PROPERTY_DECOMPOSITION_TEMPLATE: {
        var propertyDecompositionTemplate = (PropertyDecompositionTemplate)theEObject;
        var result = casePropertyDecompositionTemplate(propertyDecompositionTemplate);
        if (result == null) {
          result = caseDecompositionTemplate(propertyDecompositionTemplate);
        }
        if (result == null) {
          result = caseTemplate(propertyDecompositionTemplate);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case GSNTemplatesPackage.FILES_CONTEXT: {
        var filesContext = (FilesContext)theEObject;
        var result = caseFilesContext(filesContext);
        if (result == null) {
          result = caseContext(filesContext);
        }
        if (result == null) {
          result = caseContextual(filesContext);
        }
        if (result == null) {
          result = caseArgumentElement(filesContext);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case GSNTemplatesPackage.ANALYTIC_TEMPLATE: {
        var analyticTemplate = (AnalyticTemplate)theEObject;
        var result = caseAnalyticTemplate(analyticTemplate);
        if (result == null) {
          result = caseTemplate(analyticTemplate);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Decomposition Template</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Decomposition Template</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDecompositionTemplate(DecompositionTemplate object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Domain</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Domain</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDomain(Domain object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Int Domain</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Int Domain</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIntDomain(IntDomain object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Real Domain</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Real Domain</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRealDomain(RealDomain object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enum Domain</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enum Domain</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumDomain(EnumDomain object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Value Domain</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Value Domain</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseValueDomain(ValueDomain object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Domain Decomposition Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Domain Decomposition Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDomainDecompositionElement(DomainDecompositionElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Domain Decomposition Strategy</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Domain Decomposition Strategy</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDomainDecompositionStrategy(DomainDecompositionStrategy object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Domain Goal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Domain Goal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDomainGoal(DomainGoal object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Domain Decomposition Template</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Domain Decomposition Template</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDomainDecompositionTemplate(DomainDecompositionTemplate object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseProperty(Property object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Decomposition Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Decomposition Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyDecompositionElement(PropertyDecompositionElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Decomposition Strategy</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Decomposition Strategy</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyDecompositionStrategy(PropertyDecompositionStrategy object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Goal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Goal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyGoal(PropertyGoal object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Decomposition Template</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Decomposition Template</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyDecompositionTemplate(PropertyDecompositionTemplate object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Files Context</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Files Context</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFilesContext(FilesContext object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Analytic Template</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Analytic Template</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnalyticTemplate(AnalyticTemplate object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Supporter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Supporter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSupporter(Supporter object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Contextualizable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Contextualizable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseContextualizable(Contextualizable object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Supportable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Supportable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSupportable(Supportable object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Argument Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Argument Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArgumentElement(ArgumentElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Decoratable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Decoratable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDecoratable(Decoratable object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Strategy</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Strategy</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStrategy(Strategy object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ASI Lful Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ASI Lful Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseASILfulElement(ASILfulElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Goal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Goal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGoal(Goal object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Contextual</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Contextual</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseContextual(Contextual object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Context</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Context</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseContext(Context object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Template</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Template</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTemplate(Template object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object) {
    return null;
  }

} //GSNTemplatesSwitch

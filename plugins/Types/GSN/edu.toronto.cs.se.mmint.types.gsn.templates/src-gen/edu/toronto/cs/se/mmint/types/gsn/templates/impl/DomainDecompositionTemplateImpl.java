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
package edu.toronto.cs.se.mmint.types.gsn.templates.impl;

import java.util.ArrayList;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClass;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.types.gsn.templates.DomainDecompositionStrategy;
import edu.toronto.cs.se.mmint.types.gsn.templates.DomainDecompositionTemplate;
import edu.toronto.cs.se.mmint.types.gsn.templates.DomainGoal;
import edu.toronto.cs.se.mmint.types.gsn.templates.EnumDomain;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage;
import edu.toronto.cs.se.mmint.types.gsn.templates.IntDomain;
import edu.toronto.cs.se.mmint.types.gsn.templates.RealDomain;
import edu.toronto.cs.se.mmint.types.gsn.templates.util.GSNTemplatesBuilder;
import edu.toronto.cs.se.modelepedia.gsn.Context;
import edu.toronto.cs.se.modelepedia.gsn.Goal;
import edu.toronto.cs.se.modelepedia.gsn.Justification;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.SupportedBy;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Domain Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class DomainDecompositionTemplateImpl extends DecompositionTemplateImpl implements DomainDecompositionTemplate {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DomainDecompositionTemplateImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return GSNTemplatesPackage.Literals.DOMAIN_DECOMPOSITION_TEMPLATE;
  }

  /**
   * @generated NOT
   */
  @Override
  public void decompose(Goal decomposed, GSNTemplatesBuilder builder) throws Exception {
    // ask for input
    var title = "Domain Decomposition";
    var numDomains = 0;
    Set<Integer> subDomainTypes = null;
    var domain = builder.createDomain(title, "Insert the domain to be decomposed",
                                      Set.of(GSNTemplatesPackage.INT_DOMAIN, GSNTemplatesPackage.REAL_DOMAIN,
                                             GSNTemplatesPackage.ENUM_DOMAIN));
    if (domain instanceof IntDomain || domain instanceof RealDomain) {
      var message = "Insert the number of sub-domains";
      numDomains = Integer.parseInt(MIDDialogs.getStringInput(title, message, null));
      if (numDomains <= 1) {
        throw new MMINTException("A domain must be decomposed into >1 sub-domains");
      }
      if (domain instanceof IntDomain) {
        subDomainTypes = Set.of(GSNTemplatesPackage.INT_DOMAIN, GSNTemplatesPackage.ENUM_DOMAIN,
                                GSNTemplatesPackage.VALUE_DOMAIN);
      }
      else if (domain instanceof RealDomain) {
        subDomainTypes = Set.of(GSNTemplatesPackage.REAL_DOMAIN);
      }
    }
    else if (domain instanceof EnumDomain) {
      numDomains = ((EnumDomain) domain).getValues().size();
      subDomainTypes = Set.of(GSNTemplatesPackage.ENUM_DOMAIN, GSNTemplatesPackage.VALUE_DOMAIN);
    }
    // customize decomposition
    var safetyCase = (SafetyCase) eContainer();
    var domainStrategy = getElements().stream()
      .filter(DomainDecompositionStrategy.class::isInstance)
      .map(DomainDecompositionStrategy.class::cast)
      .findFirst().get();
    var domainJust = (Justification) domainStrategy.getInContextOf().get(0).getContext();
    var domainCtx = (Context) domainStrategy.getInContextOf().get(1).getContext();
    var compGoal = (Goal) domainStrategy.getSupportedBy().get(0).getTarget();
    var subDomainGoals = domainStrategy.getSupportedBy().stream()
      .map(SupportedBy::getTarget)
      .filter(DomainGoal.class::isInstance)
      .map(DomainGoal.class::cast)
      .collect(Collectors.toList());
    var templateElems = getElements();
    domainStrategy.getSupportedBy().removeIf(sb -> sb.getTarget() instanceof DomainGoal); // the real subDomainGoals will be added later
    templateElems.removeAll(subDomainGoals);
    safetyCase.getGoals().removeAll(subDomainGoals);
    var placeholderId = domainStrategy.getId().substring(domainStrategy.getId().indexOf(".") + 1);
    var decomposedId = decomposed.getId();
    domainStrategy.setId(domainStrategy.getId().replace(placeholderId, decomposedId));
    domainStrategy.setDescription(domainStrategy.getDescription().replace(placeholderId, decomposedId));
    domainStrategy.setDomain(domain);
    domainJust.setId(domainJust.getId().replace(placeholderId, decomposedId));
    domainJust.setDescription(domainJust.getDescription().replace(placeholderId, decomposedId));
    domainCtx.setId(domainCtx.getId().replace(placeholderId, decomposedId));
    domainCtx.setDescription(domain.toString());
    compGoal.setId(compGoal.getId().replace(placeholderId, decomposedId));
    var subDomains = new ArrayList<String>();
    var subDomainGoalId = decomposedId + ".";
    var subDomainGoalDesc = decomposed.getDescription() + " for sub-domain ";
    for (var i = 0; i < numDomains; i++) {
      var subDomain = builder.createDomain(title, "Insert the sub-domain #" + (i+1), subDomainTypes);
      if (domain instanceof EnumDomain && subDomain instanceof EnumDomain subEnumDomain) {
        numDomains -= (subEnumDomain.getValues().size()-1);
      }
      subDomains.add(subDomain.toString());
      var subDomainGoal = builder.createDomainGoal(subDomainGoalId + (i+2), subDomainGoalDesc + subDomain.toString(),
                                                   subDomain);
      templateElems.add(subDomainGoal);
      builder.addSupporter(domainStrategy, subDomainGoal);
    }
    templateElems.add(decomposed);
  }

  /**
   * @generated NOT
   */
  @Override
  public void validate() throws Exception {
    // strategy validation will manage supported goals
    validate(getElements().stream().filter(Predicate.not(DomainGoal.class::isInstance)).collect(Collectors.toList()));
  }

} //DomainTemplateImpl

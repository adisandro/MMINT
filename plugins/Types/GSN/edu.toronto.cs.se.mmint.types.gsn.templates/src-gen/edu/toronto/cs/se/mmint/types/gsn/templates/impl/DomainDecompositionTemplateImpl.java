/*******************************************************************************
 * Copyright (c) 2023, 2023 Alessio Di Sandro.
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
import edu.toronto.cs.se.modelepedia.gsn.Goal;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;

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
    var templateSC = (SafetyCase) eContainer();
    var safetyGoal = templateSC.getGoals().get(0);
    var compGoal = templateSC.getGoals().get(1);
    var subDomainGoalN = (DomainGoal) templateSC.getGoals().get(2);
    var domainStrategy = (DomainDecompositionStrategy) templateSC.getStrategies().get(0);
    var domainJust = templateSC.getJustifications().get(0);
    domainStrategy.getSupportedBy().remove(1); // the real subDomainGoals will be added later
    var templateElems = getElements();
    templateElems.remove(safetyGoal);
    templateElems.remove(subDomainGoalN);
    var placeholderId = "CX";
    var decomposedId = decomposed.getId();
    domainStrategy.setId(domainStrategy.getId().replace(placeholderId, decomposedId));
    domainStrategy.setDescription(domainStrategy.getDescription().replace("DOMAIN_VALUES", domain.toString()));
    domainStrategy.setDomain(domain);
    domainJust.setId(domainJust.getId().replace(placeholderId, decomposedId));
    domainJust.setDescription(domainJust.getDescription().replace("DOMAIN_VALUES", domain.toString()));
    compGoal.setId(compGoal.getId().replace(placeholderId, decomposedId));
    var subDomains = new ArrayList<String>();
    var subDomainGoalId = subDomainGoalN.getId().replace(placeholderId, decomposedId);
    var subDomainGoalDesc = subDomainGoalN.getDescription();
    for (var i = 0; i < numDomains; i++) {
      var subDomain = builder.createDomain(title, "Insert the sub-domain #" + (i+1), subDomainTypes);
      if (domain instanceof EnumDomain && subDomain instanceof EnumDomain subEnumDomain) {
        numDomains -= (subEnumDomain.getValues().size()-1);
      }
      subDomains.add(subDomain.toString());
      var subDomainGoal = builder.createDomainGoal(subDomainGoalId.replace("N", String.valueOf(i+2)),
                                                   subDomainGoalDesc.replace("SUBDOMAIN_VALUES", subDomain.toString()),
                                                   subDomain);
      templateElems.add(subDomainGoal);
      builder.addSupporter(domainStrategy, subDomainGoal);
    }
    compGoal.setDescription(compGoal.getDescription().replace("DOMAIN_VALUES", domain.toString())
                                                     .replace("SUBDOMAIN_VALUES", String.join(", ", subDomains)));
    templateElems.add(decomposed);
    domainStrategy.getSupports().get(0).setSource(decomposed);
  }

} //DomainTemplateImpl

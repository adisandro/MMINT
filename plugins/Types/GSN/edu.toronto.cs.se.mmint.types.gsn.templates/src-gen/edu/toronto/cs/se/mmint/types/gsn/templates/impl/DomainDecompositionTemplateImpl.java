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
import edu.toronto.cs.se.mmint.types.gsn.templates.DomainDecompositionTemplate;
import edu.toronto.cs.se.mmint.types.gsn.templates.EnumDomain;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage;
import edu.toronto.cs.se.mmint.types.gsn.templates.IntDomain;
import edu.toronto.cs.se.mmint.types.gsn.templates.RealDomain;
import edu.toronto.cs.se.mmint.types.gsn.templates.util.GSNTemplatesBuilder;
import edu.toronto.cs.se.modelepedia.gsn.Goal;

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
    // create decomposition template
    var id = decomposed.getId();
    var desc = decomposed.getDescription();
    var strategyId = "S1." + id;
    var justId = "J." + id;
    var subGoalId = id + ".";
    var compGoalId = id + ".1";
    var strategyDesc = "Decomposition over domain " + domain.toString();
    var justDesc = "Every scenario has a corresponding value in the domain " + domain.toString();
    var subGoalDesc = desc + " for sub-domain ";
    var compGoalDesc = "Every possible value in the domain " + domain.toString() + " is covered by sub-domains ";
    var strategy = builder.createDomainStrategy(strategyId, strategyDesc, domain);
    var just = builder.createJustification(justId, justDesc);
    builder.addInContextOf(strategy, just);
    var subDomains = new ArrayList<String>();
    for (var i = 0; i < numDomains; i++) {
      var subDomain = builder.createDomain(title, "Insert the sub-domain #" + (i+1), subDomainTypes);
      if (domain instanceof EnumDomain && subDomain instanceof EnumDomain subEnumDomain) {
        numDomains -= (subEnumDomain.getValues().size()-1);
      }
      subDomains.add(subDomain.toString());
      var subGoal = builder.createDomainGoal(subGoalId + (i+2), subGoalDesc + subDomain.toString(), subDomain);
      builder.addSupporter(strategy, subGoal);
    }
    var goal = builder.createBasicGoal(compGoalId, compGoalDesc + String.join(", ", subDomains));
    builder.addSupporter(strategy, goal);
    builder.addSupporter(decomposed, strategy);
  }

} //DomainTemplateImpl

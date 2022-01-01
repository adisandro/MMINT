/*******************************************************************************
 * Copyright (c) 2020, 2022 Alessio Di Sandro.
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
package edu.toronto.cs.se.modelepedia.gsn.util;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.modelepedia.gsn.Domain;
import edu.toronto.cs.se.modelepedia.gsn.DomainDecompositionElement;
import edu.toronto.cs.se.modelepedia.gsn.DomainDecompositionStrategy;
import edu.toronto.cs.se.modelepedia.gsn.DomainGoal;
import edu.toronto.cs.se.modelepedia.gsn.EnumDomain;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.IntDomain;
import edu.toronto.cs.se.modelepedia.gsn.RealDomain;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.ValueDomain;
import edu.toronto.cs.se.modelepedia.gsn.impl.DomainImpl;

public class DomainBuilder extends GSNBuilder {

  public DomainBuilder(SafetyCase gsnRootModelObj) {
    super(gsnRootModelObj);
  }

  public void addDomainElement(DomainDecompositionElement domainElem, Domain domain) {
    domainElem.setDomain(domain);
  }

  public DomainGoal createDomainGoal(String id, String description, Domain domain) {
    var goal = this.factory.createDomainGoal();
    addGoal(goal, id, description);
    addDomainElement(goal, domain);

    return goal;
  }

  public DomainDecompositionStrategy createDomainStrategy(String id, String description, Domain domain) {
    var strategy = this.factory.createDomainDecompositionStrategy();
    addStrategy(strategy, id, description);
    addDomainElement(strategy, domain);

    return strategy;
  }

  public Domain createDomain(String title, String message, Set<Integer> whichTypes) throws Exception {
    var syntaxes = Map.of(GSNPackage.INT_DOMAIN,   "'_' for ranges",
                          GSNPackage.REAL_DOMAIN,  "'_' for ranges",
                          GSNPackage.ENUM_DOMAIN,  "',' for enumerations");
    var examples = Map.of(GSNPackage.INT_DOMAIN,   "integer range '-40_50'",
                          GSNPackage.REAL_DOMAIN,  "real range '-40.0_50.0'",
                          GSNPackage.ENUM_DOMAIN,  "enumeration 'x,y,z'",
                          GSNPackage.VALUE_DOMAIN, "single value 'x'");

    if (!whichTypes.isEmpty()) {
      var syntax = whichTypes.stream()
        .map(we -> syntaxes.get(we))
        .filter(Objects::nonNull)
        .distinct()
        .collect(Collectors.joining(" and "));
      if (!message.isBlank()) {
        message += ", using " + syntax;
      }
      var example = whichTypes.stream()
        .map(we -> examples.get(we))
        .filter(Objects::nonNull)
        .collect(Collectors.joining("; "));
      if (!example.isBlank()) {
        message += "\n(e.g. " + example + ")";
      }
    }
    var domainInput = MIDDialogs.getStringInput(title, message, null);
    var domain = DomainImpl.parseDomainString(domainInput);
    if (domain instanceof IntDomain && !whichTypes.contains(GSNPackage.INT_DOMAIN)) {
      throw new MMINTException("Integer range not allowed");
    }
    if (domain instanceof RealDomain && !whichTypes.contains(GSNPackage.REAL_DOMAIN)) {
      throw new MMINTException("Real range not allowed");
    }
    if (domain instanceof EnumDomain && !whichTypes.contains(GSNPackage.ENUM_DOMAIN)) {
      throw new MMINTException("Enumeration not allowed");
    }
    if (domain instanceof ValueDomain && !whichTypes.contains(GSNPackage.VALUE_DOMAIN)) {
      throw new MMINTException("Single value not allowed");
    }

    return domain;
  }
}

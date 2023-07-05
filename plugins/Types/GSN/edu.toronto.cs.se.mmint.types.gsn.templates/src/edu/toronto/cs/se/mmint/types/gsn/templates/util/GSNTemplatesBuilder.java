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
package edu.toronto.cs.se.mmint.types.gsn.templates.util;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.types.gsn.templates.Domain;
import edu.toronto.cs.se.mmint.types.gsn.templates.DomainDecompositionElement;
import edu.toronto.cs.se.mmint.types.gsn.templates.DomainDecompositionStrategy;
import edu.toronto.cs.se.mmint.types.gsn.templates.DomainGoal;
import edu.toronto.cs.se.mmint.types.gsn.templates.EnumDomain;
import edu.toronto.cs.se.mmint.types.gsn.templates.FilesContext;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesFactory;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage;
import edu.toronto.cs.se.mmint.types.gsn.templates.IntDomain;
import edu.toronto.cs.se.mmint.types.gsn.templates.Property;
import edu.toronto.cs.se.mmint.types.gsn.templates.PropertyDecompositionElement;
import edu.toronto.cs.se.mmint.types.gsn.templates.PropertyDecompositionStrategy;
import edu.toronto.cs.se.mmint.types.gsn.templates.PropertyGoal;
import edu.toronto.cs.se.mmint.types.gsn.templates.RealDomain;
import edu.toronto.cs.se.mmint.types.gsn.templates.ValueDomain;
import edu.toronto.cs.se.mmint.types.gsn.templates.impl.DomainImpl;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.util.GSNBuilder;

public class GSNTemplatesBuilder extends GSNBuilder {
  protected GSNTemplatesFactory templateFactory;

  public GSNTemplatesBuilder(SafetyCase safetyCase) {
    super(safetyCase);
    this.templateFactory = GSNTemplatesFactory.eINSTANCE;
  }

  public void addDomainElement(DomainDecompositionElement domainElem, Domain domain) {
    domainElem.setDomain(domain);
  }

  public DomainGoal createDomainGoal(String id, String description, Domain domain) {
    var goal = this.templateFactory.createDomainGoal();
    addGoal(goal, id, description);
    addDomainElement(goal, domain);

    return goal;
  }

  public DomainDecompositionStrategy createDomainStrategy(String id, String description, Domain domain) {
    var strategy = this.templateFactory.createDomainDecompositionStrategy();
    addStrategy(strategy, id, description);
    addDomainElement(strategy, domain);

    return strategy;
  }

  public Domain createDomain(String title, String message, Set<Integer> whichTypes) throws Exception {
    var syntaxes = Map.of(GSNTemplatesPackage.INT_DOMAIN,   "'_' for numeric ranges",
                          GSNTemplatesPackage.REAL_DOMAIN,  "'_' for numeric ranges",
                          GSNTemplatesPackage.ENUM_DOMAIN,  "',' for enumerations",
                          GSNTemplatesPackage.VALUE_DOMAIN, "use a single value");
    var examples = Map.of(GSNTemplatesPackage.INT_DOMAIN,   "integer range '-40_50'",
                          GSNTemplatesPackage.REAL_DOMAIN,  "real range '-40.0_50.0'",
                          GSNTemplatesPackage.ENUM_DOMAIN,  "enumeration 'x,y,z'",
                          GSNTemplatesPackage.VALUE_DOMAIN, "single value 'x'");

    if (!whichTypes.isEmpty()) {
      var syntax = whichTypes.stream()
        .map(we -> syntaxes.get(we))
        .filter(Objects::nonNull)
        .distinct()
        .collect(Collectors.joining(" or "));
      if (!message.isBlank()) {
        message += "\nUse " + syntax;
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
    if (domain instanceof IntDomain && !whichTypes.contains(GSNTemplatesPackage.INT_DOMAIN)) {
      throw new MMINTException("Integer range not allowed");
    }
    if (domain instanceof RealDomain && !whichTypes.contains(GSNTemplatesPackage.REAL_DOMAIN)) {
      throw new MMINTException("Real range not allowed");
    }
    if (domain instanceof EnumDomain && !whichTypes.contains(GSNTemplatesPackage.ENUM_DOMAIN)) {
      throw new MMINTException("Enumeration not allowed");
    }
    if (domain instanceof ValueDomain && !whichTypes.contains(GSNTemplatesPackage.VALUE_DOMAIN)) {
      throw new MMINTException("Single value not allowed");
    }

    return domain;
  }

  public void addPropertyElement(PropertyDecompositionElement propertyElem, Property property) {
    propertyElem.setProperty(property);
  }

  public Property createProperty(String title, String formalMessage, String informalMessage)
                                throws MIDDialogCancellation {
    var property = this.templateFactory.createProperty();
    var formal = MIDDialogs.getBigStringInput(title, formalMessage, null);
    var informal = MIDDialogs.getStringInput(title, informalMessage, null);
    property.setFormal(formal);
    property.setInformal(informal);

    return property;
  }

  public PropertyGoal createPropertyGoal(String id, String description, Property property) {
    var goal = this.templateFactory.createPropertyGoal();
    addGoal(goal, id, description);
    addPropertyElement(goal, property);

    return goal;
  }

  public PropertyDecompositionStrategy createPropertyStrategy(String id, String description, String reasonerName,
                                                              Property property) {
    var strategy = this.templateFactory.createPropertyDecompositionStrategy();
    addStrategy(strategy, id, description);
    addPropertyElement(strategy, property);
    strategy.setReasonerName(reasonerName);

    return strategy;
  }

  public FilesContext createFilesContext(String id, String description, List<String> paths) {
    var context = this.templateFactory.createFilesContext();
    addContext(context, id, description);
    context.getPaths().addAll(paths);

    return context;
  }
}

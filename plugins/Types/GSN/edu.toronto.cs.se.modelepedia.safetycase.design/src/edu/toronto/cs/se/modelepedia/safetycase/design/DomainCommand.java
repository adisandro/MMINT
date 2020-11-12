/**
 * Copyright (c) 2012-2020 Alessio Di Sandro, Marsha Chechik.
 * All rights reserved. This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Alessio Di Sandro - Implementation
 */
package edu.toronto.cs.se.modelepedia.safetycase.design;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.modelepedia.safetycase.ArgumentElement;
import edu.toronto.cs.se.modelepedia.safetycase.Domain;
import edu.toronto.cs.se.modelepedia.safetycase.DomainDecompositionStrategy;
import edu.toronto.cs.se.modelepedia.safetycase.DomainGoal;
import edu.toronto.cs.se.modelepedia.safetycase.EnumDomain;
import edu.toronto.cs.se.modelepedia.safetycase.GSNFactory;
import edu.toronto.cs.se.modelepedia.safetycase.GSNPackage;
import edu.toronto.cs.se.modelepedia.safetycase.Goal;
import edu.toronto.cs.se.modelepedia.safetycase.IntDomain;
import edu.toronto.cs.se.modelepedia.safetycase.Justification;
import edu.toronto.cs.se.modelepedia.safetycase.RealDomain;
import edu.toronto.cs.se.modelepedia.safetycase.SafetyCase;
import edu.toronto.cs.se.modelepedia.safetycase.Strategy;
import edu.toronto.cs.se.modelepedia.safetycase.Supportable;
import edu.toronto.cs.se.modelepedia.safetycase.Supporter;
import edu.toronto.cs.se.modelepedia.safetycase.ValueDomain;
import edu.toronto.cs.se.modelepedia.safetycase.impl.DomainImpl;

public abstract class DomainCommand extends RecordingCommand {
  protected SafetyCase gsnRootModelObj;
  protected GSNFactory factory;
  protected List<ArgumentElement> gsnElements;

  public DomainCommand(TransactionalEditingDomain domain, SafetyCase gsnRootModelObj) {
    super(domain);
    this.gsnRootModelObj = gsnRootModelObj;
    this.factory = GSNFactory.eINSTANCE;
    this.gsnElements = new ArrayList<>();
  }

  protected void addSupporter(Supportable supportable, Supporter supporter) {
    var support = this.factory.createSupportedBy();
    support.setSource(supportable);
    support.setTarget(supporter);
  }

  protected void addArgumentElement(ArgumentElement argument, String id, String description) {
    argument.setId(id);
    argument.setDescription(description);
  }

  protected void addGoal(Goal goal, String id, String description) {
    addArgumentElement(goal, id, description);
    this.gsnElements.add(goal);
  }

  protected DomainGoal createDomainGoal(String id, String description, Domain domain) {
    var goal = this.factory.createDomainGoal();
    addGoal(goal, id, description);
    goal.setDomain(domain);

    return goal;
  }

  protected DomainDecompositionStrategy createDomainStrategy(String id, String description, Domain domain) {
    var strategy = this.factory.createDomainDecompositionStrategy();
    addArgumentElement(strategy, id, description);
    strategy.setDomain(domain);
    this.gsnElements.add(strategy);

    return strategy;
  }

  protected Domain createDomain(String title, String message, Set<Integer> whichTypes) throws Exception {
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

  protected void commitChanges() {
    for (var gsnElement : this.gsnElements) {
      if (gsnElement instanceof Strategy) {
        this.gsnRootModelObj.getStrategies().add((Strategy) gsnElement);
      }
      else if (gsnElement instanceof Justification) {
        this.gsnRootModelObj.getJustifications().add((Justification) gsnElement);
      }
      else if (gsnElement instanceof Goal) {
        this.gsnRootModelObj.getGoals().add((Goal) gsnElement);
      }
    }
  }

}

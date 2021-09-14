/**
 * Copyright (c) 2012-2021 Alessio Di Sandro, Marsha Chechik.
 * All rights reserved. This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Alessio Di Sandro - Implementation
 */
package edu.toronto.cs.se.mmint.viatra.reasoning;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.viatra.query.patternlanguage.emf.specification.SpecificationBuilder;
import org.eclipse.viatra.query.patternlanguage.emf.vql.Pattern;
import org.eclipse.viatra.query.patternlanguage.emf.vql.PatternModel;
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.GenericPatternMatcher;
import org.eclipse.viatra.query.runtime.emf.EMFScope;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.reasoning.IQueryTrait;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;

public class ViatraReasoner implements IQueryTrait {

  @Override
  public String getName() {
    return "Viatra";
  }

  @Override
  public Set<String> getQueryFileExtensions() {
    return Set.of("vql");
  }

  protected Pattern getPattern(String queryFilePath, String queryName) throws Exception {
    // get model representation of query file
    var queryRoot = FileUtils.readModelFile(queryFilePath, null, true);
    if (!(queryRoot instanceof PatternModel)) {
      throw new MMINTException("Bad query file");
    }
    // find named query
    var pattern = ((PatternModel) queryRoot).getPatterns().stream()
      .filter(p -> queryName.equals(p.getName()))
      .findFirst()
      .orElseThrow(() -> new MMINTException(MessageFormat.format("Pattern {0} not found", queryName)));

    return pattern;
  }

  @Override
  public List<Object> evaluateQuery(String queryFilePath, String queryName, EObject context,
                                    List<? extends EObject> queryArgs) throws Exception {
    AdvancedViatraQueryEngine engine = null;
    try {
      // handle query arguments
      var pattern = getPattern(queryFilePath, queryName);
      if (!queryArgs.isEmpty()) { // bound input arguments
        var numFormal = pattern.getParameters().size();
        var numActual = queryArgs.size();
        var diffArgs = numFormal - numActual;
        if (diffArgs < 0) { // too many actual
          throw new MMINTException(MessageFormat.format("Pattern {0} has {1} parameters but {2} were passed", queryName,
                                                        numFormal, numActual));
        }
        if (diffArgs > 0) { // partially bound, add extra null arguments
          for (var i = 0; i < diffArgs; i++) {
            queryArgs.add(null);
          }
        }
      }
      // if context is a MID, preload all model roots into the same resource set
      var resourceSet = context.eResource().getResourceSet();
      if (context instanceof MID) {
        for (var model : ((MID) context).getModels()) {
          if (model instanceof ModelRel) {
            continue;
          }
          var rootModelObj = FileUtils.readModelFile(model.getUri(), resourceSet, true);
          model.eSetDeliver(false); // we are not making a real model change, bypass the need for a write transaction
          model.setEMFInstanceRoot(rootModelObj);
          model.setEMFInstanceResource(rootModelObj.eResource());
        }
      }
      // find query matches within context
      engine = AdvancedViatraQueryEngine.createUnmanagedEngine(new EMFScope(resourceSet));
      var builder = new SpecificationBuilder();
      var spec = builder.getOrCreateSpecification(pattern);
      var matcher = (GenericPatternMatcher) engine.getMatcher(spec);
      if (matcher == null) {
        throw new MMINTException("Can't initialize matching engine");
      }
      var vMatches = (queryArgs.isEmpty()) ?
        matcher.getAllMatches() :
        matcher.getAllMatches(matcher.newMatch(queryArgs.toArray()));
      var matches = new ArrayList<>();
      for (var vMatch : vMatches) {
        var match = (vMatch.parameterNames().size() == 1) ?
          vMatch.get(0) :
          vMatch.parameterNames().stream().map(p -> vMatch.get(p)).collect(Collectors.toList());
        matches.add(match);
      }
      return matches;
    }
    finally {
      if (engine != null) {
        engine.dispose();
      }
    }
  }
}

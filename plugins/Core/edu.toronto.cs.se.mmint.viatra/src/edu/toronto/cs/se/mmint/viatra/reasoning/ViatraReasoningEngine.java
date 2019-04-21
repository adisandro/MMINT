/**
 * Copyright (c) 2012-2019 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.viatra.reasoning;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.viatra.query.patternlanguage.emf.specification.SpecificationBuilder;
import org.eclipse.viatra.query.patternlanguage.emf.vql.PatternModel;
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.GenericPatternMatcher;
import org.eclipse.viatra.query.runtime.emf.EMFScope;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.reasoning.IReasoningEngine;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;

public class ViatraReasoningEngine implements IReasoningEngine {

  @Override
  public List<Object> evaluateQuery(String queryFilePath, @Nullable String queryName, EObject context,
                                    List<? extends EObject> queryArgs) {
    AdvancedViatraQueryEngine engine = null;
    try {
      // get model representation of query file
      var queryRoot = FileUtils.readModelFile(queryFilePath, true);
      if (!(queryRoot instanceof PatternModel)) {
        throw new MMINTException("Bad query file");
      }
      // find named query
      var pattern = ((PatternModel) queryRoot).getPatterns().stream()
        .filter(p -> queryName.equals(p.getName()))
        .findFirst()
        .orElseThrow(() -> new MMINTException(MessageFormat.format("Pattern {0} not found", queryName)));
      // handle query arguments
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
      // find query matches within context
      engine = AdvancedViatraQueryEngine.createUnmanagedEngine(new EMFScope(context));
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
    catch (Exception e) {
      MMINTException.print(IStatus.ERROR,
                           MessageFormat.format("Viatra file {0}, pattern {1} error: ", queryFilePath, queryName), e);
      return List.of();
    }
    finally {
      if (engine != null) {
        engine.dispose();
      }
    }
  }

}

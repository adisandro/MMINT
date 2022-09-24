/**
 * Copyright (c) 2012-2022 Alessio Di Sandro, Marsha Chechik.
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
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.viatra.query.patternlanguage.emf.specification.SpecificationBuilder;
import org.eclipse.viatra.query.patternlanguage.emf.vql.Pattern;
import org.eclipse.viatra.query.patternlanguage.emf.vql.PatternModel;
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.GenericPatternMatch;
import org.eclipse.viatra.query.runtime.api.GenericPatternMatcher;
import org.eclipse.viatra.query.runtime.emf.EMFScope;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.reasoning.IQueryTrait;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
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

  // gets model representation of query file
  protected PatternModel getVQLRoot(String queryFilePath, boolean isWorkspaceRelative) throws Exception {
    var queryRoot = FileUtils.readModelFile(queryFilePath, null, isWorkspaceRelative);
    if (!(queryRoot instanceof PatternModel vqlRoot)) {
      throw new MMINTException("Malformed VQL query file '" + queryFilePath + "'");
    }

    return vqlRoot;
  }

  @Override
  public Pattern selectQuery(String filePath) throws Exception {
    var patterns = getVQLRoot(filePath, true).getPatterns();
    var title = "Evaluate query";
    var message = "Select query";
    var labelProvider = LabelProvider.createTextProvider(p -> ((Pattern) p).getName());

    return MIDDialogs.<Pattern>openListDialog(title, message, patterns, new ArrayContentProvider(), labelProvider);
  }

  // finds named query
  protected Pattern getPattern(PatternModel vqlRoot, String queryName) throws Exception {
    return vqlRoot.getPatterns().stream()
      .filter(p -> queryName.equals(p.getName()))
      .findFirst()
      .orElseThrow(() -> new MMINTException(MessageFormat.format("Pattern {0} not found", queryName)));
  }

  protected Pattern getPattern(String filePath, Object queryObj) throws Exception {
    Pattern pattern;
    if (queryObj instanceof Pattern vqlPattern) {
      pattern = vqlPattern;
    }
    else if (queryObj instanceof String queryName) {
      var vqlRoot = getVQLRoot(filePath, true);
      pattern = getPattern(vqlRoot, queryName);
    }
    else {
      throw new MMINTException("Parameter 'query' must be a query name of type String or a VQL query of type Pattern");
    }

    return pattern;
  }

  protected List<Object> getMatches(Collection<GenericPatternMatch> vMatches) throws Exception {
    var matches = new ArrayList<>();
    for (var vMatch : vMatches) {
      var match = (vMatch.parameterNames().size() == 1) ?
        vMatch.get(0) :
        vMatch.parameterNames().stream().map(p -> vMatch.get(p)).collect(Collectors.toList());
      matches.add(match);
    }

    return matches;
  }

  protected List<Object> evaluateQuery(String filePath, Object queryObj, Notifier scopeRoot,
                                       List<? extends EObject> queryArgs) throws Exception {
    AdvancedViatraQueryEngine engine = null;
    try {
      // handle query arguments
      var pattern = getPattern(filePath, queryObj);
      if (!queryArgs.isEmpty()) { // bound input arguments
        var numFormal = pattern.getParameters().size();
        var numActual = queryArgs.size();
        var diffArgs = numFormal - numActual;
        if (diffArgs < 0) { // too many actual
          throw new MMINTException(MessageFormat.format("Pattern {0} has {1} parameters but {2} were passed",
                                                        pattern.getName(), numFormal, numActual));
        }
        if (diffArgs > 0) { // partially bound, add extra null arguments
          for (var i = 0; i < diffArgs; i++) {
            queryArgs.add(null);
          }
        }
      }
      // find query matches within scope
      engine = AdvancedViatraQueryEngine.createUnmanagedEngine(new EMFScope(scopeRoot));
      var builder = new SpecificationBuilder();
      var spec = builder.getOrCreateSpecification(pattern);
      var matcher = (GenericPatternMatcher) engine.getMatcher(spec);
      if (matcher == null) {
        throw new MMINTException("Can't initialize matching engine");
      }
      var vMatches = (queryArgs.isEmpty()) ?
        matcher.getAllMatches() :
        matcher.getAllMatches(matcher.newMatch(queryArgs.toArray()));
      return getMatches(vMatches);
    }
    finally {
      if (engine != null) {
        engine.dispose();
      }
    }

  }

  @Override
  public List<Object> evaluateQuery(String filePath, Object queryObj, EObject context,
                                    List<? extends EObject> queryArgs) throws Exception {
    Notifier scopeRoot = context;
    if (context instanceof MID instanceMID) {
      // preload all model roots into the same resource set as a side effect of getEMFInstanceRoot()
      scopeRoot = context.eResource().getResourceSet();
      instanceMID.getModels().stream().filter(m -> !(m instanceof ModelRel)).forEach(m -> m.getEMFInstanceRoot());
    }
    return evaluateQuery(filePath, queryObj, scopeRoot, queryArgs);
  }
}

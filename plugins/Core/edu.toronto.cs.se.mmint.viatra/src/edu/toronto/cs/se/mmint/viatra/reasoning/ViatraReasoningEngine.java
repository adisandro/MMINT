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
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.viatra.query.patternlanguage.emf.helper.PatternLanguageHelper;
import org.eclipse.viatra.query.patternlanguage.emf.specification.SpecificationBuilder;
import org.eclipse.viatra.query.patternlanguage.emf.vql.PatternModel;
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine;
import org.eclipse.viatra.query.runtime.emf.EMFScope;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.reasoning.IReasoningEngine;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;

public class ViatraReasoningEngine implements IReasoningEngine {

  @Override
  public @Nullable Object evaluateQuery(String queryFilePath, @Nullable String queryName,
                                        EObject context, List<? extends EObject> queryArguments) {
    try {
      var engine = AdvancedViatraQueryEngine.createUnmanagedEngine(new EMFScope(context));
      var queryRoot = FileUtils.readModelFile(queryFilePath, true);
      if (!(queryRoot instanceof PatternModel)) {
        throw new MMINTException("Bad query file");
      }
      var pattern = ((PatternModel) queryRoot).getPatterns().stream()
        .filter(p -> queryName.equals(PatternLanguageHelper.getFullyQualifiedName(p)))
        .findFirst()
        .get();
      if (pattern == null) {
        throw new MMINTException(MessageFormat.format("Pattern {0} not found", queryName));
      }
      var builder = new SpecificationBuilder();
      var matcher = engine.getMatcher(builder.getOrCreateSpecification(pattern));
      if (matcher == null) {
        //TODO?
      }
      var matches = matcher.getAllMatches();
    }
    catch (Exception e) {
      MMINTException.print(IStatus.ERROR, "VIATRA query error: " + queryFilePath, e);
      return null;
    }

    return null;
  }

}

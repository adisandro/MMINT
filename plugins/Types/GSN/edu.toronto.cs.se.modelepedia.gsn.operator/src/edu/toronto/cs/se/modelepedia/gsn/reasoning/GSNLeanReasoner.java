/*******************************************************************************
 * Copyright (c) 2020, 2021 Alessio Di Sandro.
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
package edu.toronto.cs.se.modelepedia.gsn.reasoning;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.ECollections;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.lean.reasoning.LeanReasoner;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.modelepedia.gsn.reasoning.IGSNLeanEncoder.PropertyTemplate;

public class GSNLeanReasoner extends LeanReasoner implements IGSNDecompositionTrait {

  protected IGSNLeanEncoder getEncoder(Model model) throws MMINTException {
    var encoder = MIDTypeHierarchy.getPolyOperator(LeanReasoner.ENCODER_ID, ECollections.newBasicEList(model));
    if (!(encoder instanceof IGSNLeanEncoder)) {
      throw new MMINTException("The Lean encoder for model '" + model.getName() +
                               "' does not support GSN property decompositions");
    }

    return (IGSNLeanEncoder) encoder;
  }

  @Override
  public String getName() {
    return "Lean (+ GSN library)";
  }

  @Override
  public Map<String, List<PropertyTemplate>> getTemplateProperties(Model model) throws MMINTException {
    var encoder = getEncoder(model);
    var templates = new LinkedHashMap<String, List<PropertyTemplate>>();
    encoder.getTemplateProperties().forEach(t -> templates.computeIfAbsent(t.category, k -> new ArrayList<>()).add(t));
    templates.computeIfAbsent(PropertyTemplate.CUSTOM.category, k -> new ArrayList<>()).add(PropertyTemplate.CUSTOM);

    return templates;
  }

  @Override
  public void validatePropertyDecomposition(Model model, String property, List<String> subProperties) throws Exception {
    var encoder = getEncoder(model);
    var propEncoding = encoder.encodePropertyDecomposition(model, property, subProperties);
    var workingPath = FileUtils.replaceLastSegmentInPath(model.getUri(), LeanReasoner.LEAN_DIR);
    var valid = checkProperty(model, propEncoding, workingPath);
    if (!valid) {
      throw new MMINTException("The property decomposition is not valid");
    }
  }
}

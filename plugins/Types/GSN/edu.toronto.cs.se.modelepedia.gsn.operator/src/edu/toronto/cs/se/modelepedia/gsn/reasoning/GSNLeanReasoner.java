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

import java.nio.file.Files;
import java.nio.file.Path;
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

  @Override
  public String getName() {
    return "Lean (+ GSN library)";
  }

  @Override
  public Map<String, List<PropertyTemplate>> getTemplateProperties(Model model) throws MMINTException {
    var templates = new LinkedHashMap<String, List<PropertyTemplate>>();
    var encoder = MIDTypeHierarchy.getPolyOperator(LeanReasoner.ENCODER_ID, ECollections.newBasicEList(model));
    if (encoder instanceof IGSNLeanEncoder) {
      ((IGSNLeanEncoder) encoder).getTemplateProperties()
        .forEach(t -> templates.computeIfAbsent(t.category, k -> new ArrayList<>()).add(t));
    }
    templates.computeIfAbsent(PropertyTemplate.CUSTOM.category, k -> new ArrayList<>()).add(PropertyTemplate.CUSTOM);

    return templates;
  }

  @Override
  public void validatePropertyDecomposition(Model model, String property, List<String> subProperties) throws Exception {
    var encoder = MIDTypeHierarchy.getPolyOperator(LeanReasoner.ENCODER_ID, ECollections.newBasicEList(model));
    var gsnEncoder = (encoder instanceof IGSNLeanEncoder) ? (IGSNLeanEncoder) encoder : new IGSNLeanEncoder() {};
    var propEncoding = gsnEncoder.encodePropertyDecomposition(model, property, subProperties);
    var relWorkingPath = FileUtils.replaceLastSegmentInPath(model.getUri(), System.currentTimeMillis() +
                                                                            LeanReasoner.LEAN_DIR);
    Files.createDirectory(Path.of(FileUtils.prependWorkspacePath(relWorkingPath)));
    var valid = checkProperty(model, propEncoding, relWorkingPath);
    if (!valid) {
      throw new MMINTException("The property decomposition is not valid");
    }
  }
}

/**
 * Copyright (c) 2012-2022 Alessio Di Sandro, Marsha Chechik.
 * All rights reserved. This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Alessio Di Sandro - Implementation
 */
package edu.toronto.cs.se.mmint.operator.constraint;

import java.util.stream.Collectors;

import edu.toronto.cs.se.mmint.java.reasoning.IJavaModelConstraint;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

/**
 * The corresponding model rel type "Not Mergeable" is an example of using an abstract type for filtering purposes only.
 */
public class NotMergeableConstraint implements IJavaModelConstraint {

  @Override
  public boolean check(Model model) {
    // A model rel is not mergeable (i.e. can't be an argument of ModelRelMerge)
    // if there are other rels with the same model endpoints, up to 2.
    if (!(model instanceof ModelRel)) {
      return false;
    }
    var rel = (ModelRel) model;
    var endpoints = rel.getModelEndpoints().stream()
      .map(ModelEndpoint::getTargetUri)
      .collect(Collectors.toSet());
    if (endpoints.size() > 2) {
      return true;
    }
    for (var otherRel : model.getMIDContainer().getModelRels()) {
      if (rel.equals(otherRel)) { // the same rel, really
        continue;
      }
      var otherEndpoints = otherRel.getModelEndpoints().stream()
        .map(ModelEndpoint::getTargetUri)
        .collect(Collectors.toSet());
      if (endpoints.equals(otherEndpoints)) {
        return false;
      }
    }
    return true;
  }
}

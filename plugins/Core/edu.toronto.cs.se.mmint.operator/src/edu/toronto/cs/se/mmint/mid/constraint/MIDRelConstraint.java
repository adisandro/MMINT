/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.constraint;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.java.reasoning.IJavaModelConstraint;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public class MIDRelConstraint implements IJavaModelConstraint {

  @Override
  public boolean check(Model model) {

    EObject modelObjRoot = model.getEMFInstanceRoot();
    if (!(modelObjRoot instanceof MID)) {
        // a MIDRel is a MID too
        return false;
    }
    MID instanceMID = (MID) modelObjRoot;
    if (instanceMID.getOperators().size() > 0) {
      // a MIDRel contains only model rels
      return false;
    }
    var modelRels = 0;
    for (Model instanceMIDModel : instanceMID.getModels()) {
      if (!(instanceMIDModel instanceof ModelRel)) {
        // a MIDRel contains only model rels
        return false;
      }
      modelRels++;
    }
    if (modelRels == 0) {
      // an empty MID is not a MIDRel
      return false;
    }
    return true;
  }

}

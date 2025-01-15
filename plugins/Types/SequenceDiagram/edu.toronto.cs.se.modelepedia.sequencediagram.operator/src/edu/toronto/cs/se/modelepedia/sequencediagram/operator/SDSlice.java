/**
 * Copyright (c) 2012-2025 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Nick Fung.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 *    Nick Fung - Implementation.
 */
package edu.toronto.cs.se.modelepedia.sequencediagram.operator;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.operator.slice.Slice;
import edu.toronto.cs.se.modelepedia.sequencediagram.ActivationBox;
import edu.toronto.cs.se.modelepedia.sequencediagram.Lifeline;
import edu.toronto.cs.se.modelepedia.sequencediagram.Message;
import edu.toronto.cs.se.modelepedia.sequencediagram.Object;
import edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagram;
import edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagramPackage;

public class SDSlice extends Slice {

  public static final String REL_TYPE_ID = "http://se.cs.toronto.edu/modelepedia/SDSliceRel";

  @Override
  protected void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws MMINTException {
    basicInit(inputsByName, outputMIDsByName);
    var sdSliceRelType = MIDTypeRegistry.<ModelRel>getType(SDSlice.REL_TYPE_ID);
    if (sdSliceRelType == null) {
      throw new MMINTException("Missing SD slice rel type " + SDSlice.REL_TYPE_ID);
    }
    this.output.sliceRel = sdSliceRelType.createInstanceAndEndpoints(null, Output.OUT_MODELREL,
                                                                     ECollections.asEList(this.input.model),
                                                                     this.output.mid);
  }

  // Return the set of activation boxes that are ancestors of the input box (including itself).
  public Set<ActivationBox> getAncestors(ActivationBox box) {
    var ancestors = new HashSet<ActivationBox>();
    while (box != null) {
      ancestors.add(box);
      box = box.getOwnerActivationBox();
    }
    return ancestors;
  }

  // Return the set of activation boxes that are contained within the input box (including itself).
  public Set<ActivationBox> getDescendants(ActivationBox box) {
    var descendants = new HashSet<ActivationBox>();
    descendants.add(box);
    for (var descendant : box.getActivationBoxes()) {
      descendants.addAll(getDescendants(descendant));
    }
    return descendants;
  }

  // Return the message (if any) that precedes or succeeds the input message and is on the input activation boxes.
  public Message getMessage(Set<ActivationBox> boxes, Message msg, EStructuralFeature follow) {
    while (msg != null) {
      if (boxes.contains(msg.getSource()) || boxes.contains(msg.getTarget())) {
        break;
      }
      else {
        msg = (Message) msg.eGet(follow);
      }
    }
    return msg;
  }

  @Override
  protected SliceStep getDirectlySlicedElements(EObject modelObj, SliceInfo info) {
    var slicedObjs = new HashSet<EObject>();

    // If input is a sequence diagram, then the following are impacted:
    // 1) Owned objects and messages.
    if (modelObj instanceof SequenceDiagram) {
      var d = (SequenceDiagram) modelObj;
      slicedObjs.addAll(d.getObjects());
      slicedObjs.addAll(d.getMessages());
    }
    // If input is an object, then the following are impacted:
    // 1) Owned lifeline.
    if (modelObj instanceof Object) {
      var o = (Object) modelObj;
      if (o.getLifeline() != null) {
        slicedObjs.add(o.getLifeline());
      }
    }
    // If input is a lifeline, then the following are impacted:
    // 1) Owned activation boxes.
    if (modelObj instanceof Lifeline) {
      var l = (Lifeline) modelObj;
      slicedObjs.addAll(l.getActivationBoxes());
    }
    // If input is an activation box, then the following are impacted:
    // 1) Owned activation boxes.
    // 2) All messages as source and as target.
    if (modelObj instanceof ActivationBox) {
      var a = (ActivationBox) modelObj;
      slicedObjs.addAll(a.getActivationBoxes());
      slicedObjs.addAll(a.getMessagesAsSource());
      slicedObjs.addAll(a.getMessagesAsTarget());
    }
    // If input is a message, then the following are impacted:
    // 1) The next message on the source activation box (or its descendants or ancestors).
    // 2) The next message on the target activation box (or its descendants or ancestors).
    // 3) The source activation box if it (or its descendants) does not have any other preceding messages.
    // 4) The target activation box if it (or its descendants) does not have any other preceding messages.
    if (modelObj instanceof Message) {
      var m = (Message) modelObj;
      // Get all descendants and ancestors of the source activation box.
      // Note: The original box is considered its own descendant and ancestor.
      var sourceBoxes = new HashSet<ActivationBox>();
      var sourceAncestors = getAncestors(m.getSource());
      var sourceDescendants = getDescendants(m.getSource());
      sourceBoxes.addAll(sourceAncestors);
      sourceBoxes.addAll(sourceDescendants);
      // Get the next message related to the source activation box (if any).
      var nextSourceMessage = getMessage(sourceBoxes, m.getSuccessor(), SequenceDiagramPackage.eINSTANCE.getMessage_Successor());
      if (nextSourceMessage != null) {
        slicedObjs.add(nextSourceMessage);
      }
      // Check if source activation box (or its descendants) has any preceding messages.
      var previousSourceMessage = getMessage(sourceDescendants, m.getPredecessor(), SequenceDiagramPackage.eINSTANCE.getMessage_Predecessor());
      if (previousSourceMessage == null) {
        slicedObjs.add(m.getSource());
      }
      // Get all descendants and ancestors of the target activation box.
      // Note: The original box is considered its own descendant and ancestor.
      var targetBoxes = new HashSet<ActivationBox>();
      var targetAncestors = getAncestors(m.getTarget());
      var targetDescendants = getDescendants(m.getTarget());
      targetBoxes.addAll(targetDescendants);
      targetBoxes.addAll(targetAncestors);
      // Get the next message related to the target activation box (if any).
      var nextTargetMessage = getMessage(targetBoxes, m.getSuccessor(), SequenceDiagramPackage.eINSTANCE.getMessage_Successor());
      if (nextTargetMessage != null) {
        slicedObjs.add(nextTargetMessage);
      }
      // Check if target activation box (or its descendants) has any preceding messages.
      var previousTargetMessage = getMessage(targetDescendants, m.getPredecessor(), SequenceDiagramPackage.eINSTANCE.getMessage_Predecessor());
      if (previousTargetMessage == null)  {
        slicedObjs.add(m.getTarget());
      }
    }

    var newInfo = new SliceInfo(SliceType.RECHECK, modelObj, "sd");
    var sliced = slicedObjs.stream()
      .filter(s -> !this.allSliced.containsKey(s))
      .collect(Collectors.toMap(s -> s, s -> newInfo, this.typesOrder));
    return new SliceStep(sliced, sliced);
  }
}

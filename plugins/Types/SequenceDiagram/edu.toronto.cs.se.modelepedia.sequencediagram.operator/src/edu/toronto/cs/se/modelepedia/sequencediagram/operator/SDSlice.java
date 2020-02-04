/**
 * Copyright (c) 2012-2019 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.operator.slice.Slice;
import edu.toronto.cs.se.modelepedia.sequencediagram.ActivationBox;
import edu.toronto.cs.se.modelepedia.sequencediagram.Lifeline;
import edu.toronto.cs.se.modelepedia.sequencediagram.Message;
import edu.toronto.cs.se.modelepedia.sequencediagram.Object;
import edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagram;

public class SDSlice extends Slice {

  // Get impacted model elements directly reachable from the input element.
  @Override
  protected Set<EObject> getDirectlyImpactedElements(EObject modelObj, Set<EObject> alreadyImpacted) {
    var impacted = new HashSet<EObject>();

    // If input is a sequence diagram, then the following are impacted:
    // 1) Owned objects and messages.
    if (modelObj instanceof SequenceDiagram) {
      var d = (SequenceDiagram) modelObj;
      impacted.addAll(d.getObjects());
      impacted.addAll(d.getMessages());
    }

    // If input is an object, then the following are impacted:
    // 1) Owned lifeline.
    if (modelObj instanceof Object) {
      var o = (Object) modelObj;
      if (o.getLifeline() != null) {
        impacted.add(o.getLifeline());
      }
    }

    // If input is a lifeline, then the following are impacted:
    // 1) Owned activation boxes.
    if (modelObj instanceof Lifeline) {
      var l = (Lifeline) modelObj;
      impacted.addAll(l.getActivationBoxes());
    }

    // If input is an activation box, then the following are impacted:
    // 1) Owned activation boxes.
    // 2) All messages as source and as target.
    if (modelObj instanceof ActivationBox) {
      var a = (ActivationBox) modelObj;
      impacted.addAll(a.getActivationBoxes());
      impacted.addAll(a.getMessagesAsSource());
      impacted.addAll(a.getMessagesAsTarget());
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
      var sourceAncestors = getAncestorBoxes(m.getSource());
      var sourceDescendants = getDescendantBoxes(m.getSource());
      sourceBoxes.addAll(sourceDescendants);
      sourceBoxes.addAll(sourceAncestors);

      // Get the next message related to the source activation box (if any).
      var nextSourceMessage = getNextMessageOnBoxes(sourceBoxes, m);
      if (nextSourceMessage != null) {
        impacted.add(nextSourceMessage);
      }

      // Check if source activation box (or its descendants) has any preceding messages.
      var previousSourceMessage = getPreviousMessageOnBoxes(sourceDescendants, m);
      if (previousSourceMessage == null)  {
        impacted.add(m.getSource());
      }

      // Get all descendants and ancestors of the target activation box.
      // Note: The original box is considered its own descendant and ancestor.
      Set<ActivationBox> targetBoxes = new HashSet<>();
      Set<ActivationBox> targetAncestors = getAncestorBoxes(m.getTarget());
      Set<ActivationBox> targetDescendants = getDescendantBoxes(m.getTarget());
      targetBoxes.addAll(targetDescendants);
      targetBoxes.addAll(targetAncestors);

      // Get the next message related to the source activation box (if any).
      var nextTargetMessage = getNextMessageOnBoxes(targetBoxes, m);
      if (nextTargetMessage != null) {
        impacted.add(nextTargetMessage);
      }

      // Check if source activation box (or its descendants) has any preceding messages.
      var previousTargetMessage = getPreviousMessageOnBoxes(targetDescendants, m);
      if (previousTargetMessage == null)  {
        impacted.add(m.getTarget());
      }
    }

    impacted.removeAll(alreadyImpacted);
    return impacted;
  }

  // Return the set of activation boxes that are contained within the input box (including itself).
  public Set<ActivationBox> getDescendantBoxes(ActivationBox ancestor) {
    Set<ActivationBox> descendantsAll = new HashSet<>();
    Set<ActivationBox> descendantsCur = new HashSet<>();
    Set<ActivationBox> descendantsNext = new HashSet<>();

    // Iterate through the current set of newly added descendants
    // to identify the next generation of descendants.
    descendantsAll.add(ancestor);
    descendantsCur.add(ancestor);
    while (!descendantsCur.isEmpty()) {
      for (ActivationBox curElem : descendantsCur) {
        if (!curElem.getActivationBoxes().isEmpty()) {
          descendantsNext.addAll(curElem.getActivationBoxes());
        }
      }

      descendantsCur.clear();
      for (ActivationBox newElem : descendantsNext) {
        if (!descendantsAll.contains(newElem)) {
          descendantsAll.add(newElem);
          descendantsCur.add(newElem);
        }
      }

      descendantsNext.clear();
    }

    return descendantsAll;
  }

  // Return the set of activation boxes that are ancestors of the input box (including itself).
  public Set<ActivationBox> getAncestorBoxes(ActivationBox descendant) {
    ActivationBox nextAncestor = descendant;
    Set<ActivationBox> ancestorsAll = new HashSet<>();

    do {
      ancestorsAll.add(nextAncestor);
      nextAncestor = nextAncestor.getOwnerActivationBox();
    } while (nextAncestor != null);

    return ancestorsAll;
  }

  // Return the message (if any) that succeeds the input message and is on the input activation boxes.
  public Message getNextMessageOnBoxes(Set<ActivationBox> boxes, Message m) {
    ActivationBox nextSource;
    ActivationBox nextTarget;
    Message nextMessage = m.getSuccessor();

    while (nextMessage != null) {
      nextSource = nextMessage.getSource();
      nextTarget = nextMessage.getTarget();

      if (boxes.contains(nextSource) || boxes.contains(nextTarget)) {
        break;
      } else {
        nextMessage = nextMessage.getSuccessor();
      }
    }

    return nextMessage;
  }

  // Return the message (if any) that precedes the input message and is on the input activation boxes.
  public Message getPreviousMessageOnBoxes(Set<ActivationBox> boxes, Message m) {
    ActivationBox previousSource;
    ActivationBox previousTarget;
    Message previousMessage = m.getPredecessor();

    while (previousMessage != null) {
      previousSource = previousMessage.getSource();
      previousTarget = previousMessage.getTarget();

      if (boxes.contains(previousSource) || boxes.contains(previousTarget)) {
        break;
      } else {
        previousMessage = previousMessage.getPredecessor();
      }
    }

    return previousMessage;
  }

}

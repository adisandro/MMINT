/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
package edu.toronto.cs.se.modelepedia.classdiagram.operator;

import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.operator.slice.Slice;
import edu.toronto.cs.se.modelepedia.classdiagram.Association;
import edu.toronto.cs.se.modelepedia.classdiagram.Attribute;
import edu.toronto.cs.se.modelepedia.classdiagram.Class;
import edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagram;
import edu.toronto.cs.se.modelepedia.classdiagram.Composition;
import edu.toronto.cs.se.modelepedia.classdiagram.Dependency;
import edu.toronto.cs.se.modelepedia.classdiagram.Operation;
import edu.toronto.cs.se.modelepedia.classdiagram.Typeable;

public class CDSlice extends Slice {

  public static final String REL_TYPE_ID = "http://se.cs.toronto.edu/modelepedia/CDSliceRel";

  @Override
  protected void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws MMINTException {
    basicInit(inputsByName, outputMIDsByName);
    var cdSliceRelType = MIDTypeRegistry.<ModelRel>getType(CDSlice.REL_TYPE_ID);
    if (cdSliceRelType == null) {
      throw new MMINTException("Missing CD slice rel type " + CDSlice.REL_TYPE_ID);
    }
    this.output.sliceRel = cdSliceRelType.createInstanceAndEndpoints(null, Output.OUT_MODELREL,
                                                                     ECollections.asEList(this.input.model),
                                                                     this.output.mid);
  }

  @Override
  protected SliceStep getDirectlySlicedElements(EObject modelObj, SliceInfo info) {
    var slicedObjs = new HashSet<EObject>();

    // If input is a class diagram, then the following are also impacted:
    // 1) Owned classes, associations, dependencies, data types and compositions.
    if (modelObj instanceof ClassDiagram) {
      var cd = (ClassDiagram) modelObj;
      slicedObjs.addAll(cd.getClasses());
      slicedObjs.addAll(cd.getAssociations());
      slicedObjs.addAll(cd.getDependencies());
      slicedObjs.addAll(cd.getDatatypes());
      slicedObjs.addAll(cd.getCompositions());
    }
    // If input is a class, then the following are also impacted:
    // 1) Owned attributes and operations.
    // 2) All associations, dependencies and compositions connected to it.
    // 3) Attributes and operations whose type is the input.
    // 4) Classes directly nested in or extending from the input.
    // 5) The class that the input is nested in (if any).
    // Note: Since instances of Class are also instances of Typeable,
    // the dependency rules for Typeable will also be triggered.
    if (modelObj instanceof Class) {
      var c = (Class) modelObj;
      slicedObjs.addAll(c.getOwnedAttributes());
      slicedObjs.addAll(c.getOwnedOperations());
      slicedObjs.addAll(c.getAssociationsAsSource());
      slicedObjs.addAll(c.getAssociationsAsTarget());
      slicedObjs.addAll(c.getDependenciesAsDependee());
      slicedObjs.addAll(c.getDependenciesAsDepender());
      slicedObjs.addAll(c.getCompositionsAsComposite());
      slicedObjs.addAll(c.getCompositionsAsConstituent());
      slicedObjs.addAll(c.getNested());
      slicedObjs.addAll(c.getSubclasses());
      if (c.getNestedIn() != null) {
        slicedObjs.add(c.getNestedIn());
      }
    }
    // If input is a typeable (i.e. a class or a data type),
    // then the following are also impacted:
    // 1) All attributes and operations with the input type.
    // 2) All operations with the input as one of its parameter types.
    if (modelObj instanceof Typeable) {
      var t = (Typeable) modelObj;
      // Get all attributes and operations from the class diagram
      // for checking their type.
      var cd = (ClassDiagram) t.eContainer();
      for (var c : cd.getClasses()) {
        for (var a : c.getOwnedAttributes()) {
          if (a.getType() == t) {
            slicedObjs.add(a);
          }
        }
        for (var o : c.getOwnedOperations()) {
          if (o.getType() == t) {
            slicedObjs.add(o);
            continue;
          }
          for (var p : o.getParameterTypes()) {
            if (p == t) {
              slicedObjs.add(o);
              break;
            }
          }
        }
      }
    }
    // If input is an attribute, then its class is also impacted.
    if (modelObj instanceof Attribute) {
      var a = (Attribute) modelObj;
      if (a.getOwner() != null) {
        slicedObjs.add(a.getOwner());
      }
    }
    // If input is an operation, then its class is also impacted.
    if (modelObj instanceof Operation) {
      var o = (Operation) modelObj;
      if (o.getOwner() != null) {
        slicedObjs.add(o.getOwner());
      }
    }
    // If input is an association, then its source class is also impacted.
    if (modelObj instanceof Association) {
      var a = (Association) modelObj;
      if (a.getSource() != null) {
        slicedObjs.add(a.getSource());
      }
    }
    // If input is a dependency, then its depender class is also impacted.
    if (modelObj instanceof Dependency) {
      var d = (Dependency) modelObj;
      if (d.getDepender() != null) {
        slicedObjs.add(d.getDepender());
      }
    }
    // If input is a composition, then its composite class is also impacted.
    if (modelObj instanceof Composition) {
      var c = (Composition) modelObj;
      if (c.getComposite() != null) {
        slicedObjs.add(c.getComposite());
      }
    }

    var newInfo = new SliceInfo(SliceType.RECHECK, modelObj, "cd");
    var sliced = slicedObjs.stream()
      .filter(s -> !this.allSliced.containsKey(s))
      .collect(Collectors.toMap(s -> s, s -> newInfo, this.typesOrder));
    return new SliceStep(sliced, sliced);
  }
}

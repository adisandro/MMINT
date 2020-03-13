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
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

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

  @Override
  protected Set<EObject> getDirectlyImpactedElements(EObject modelObj, Set<EObject> alreadyImpacted) {
    var impacted = new HashSet<EObject>();

    // If input is a class diagram, then the following are also impacted:
    // 1) Owned classes, associations, dependencies, data types and compositions.
    if (modelObj instanceof ClassDiagram) {
      var cd = (ClassDiagram) modelObj;
      impacted.addAll(cd.getClasses());
      impacted.addAll(cd.getAssociations());
      impacted.addAll(cd.getDependencies());
      impacted.addAll(cd.getDatatypes());
      impacted.addAll(cd.getCompositions());
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
      impacted.addAll(c.getOwnedAttributes());
      impacted.addAll(c.getOwnedOperations());
      impacted.addAll(c.getAssociationsAsSource());
      impacted.addAll(c.getAssociationsAsTarget());
      impacted.addAll(c.getDependenciesAsDependee());
      impacted.addAll(c.getDependenciesAsDepender());
      impacted.addAll(c.getCompositionsAsComposite());
      impacted.addAll(c.getCompositionsAsConstituent());
      impacted.addAll(c.getNested());
      impacted.addAll(c.getSubclasses());
      if (c.getNestedIn() != null) {
        impacted.add(c.getNestedIn());
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
            impacted.add(a);
          }
        }
        for (var o : c.getOwnedOperations()) {
          if (o.getType() == t) {
            impacted.add(o);
            continue;
          }
          for (var p : o.getParameterTypes()) {
            if (p == t) {
              impacted.add(o);
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
        impacted.add(a.getOwner());
      }
    }

    // If input is an operation, then its class is also impacted.
    if (modelObj instanceof Operation) {
      var o = (Operation) modelObj;
      if (o.getOwner() != null) {
        impacted.add(o.getOwner());
      }
    }

    // If input is an association, then its source class is also impacted.
    if (modelObj instanceof Association) {
      var a = (Association) modelObj;
      if (a.getSource() != null) {
        impacted.add(a.getSource());
      }
    }

    // If input is a dependency, then its depender class is also impacted.
    if (modelObj instanceof Dependency) {
      var d = (Dependency) modelObj;
      if (d.getDepender() != null) {
        impacted.add(d.getDepender());
      }
    }

    // If input is a composition, then its composite class is also impacted.
    if (modelObj instanceof Composition) {
      var c = (Composition) modelObj;
      if (c.getComposite() != null) {
        impacted.add(c.getComposite());
      }
    }

    impacted.removeAll(alreadyImpacted);
    return impacted;
  }
}

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
package edu.toronto.cs.se.modelepedia.safetycase.operator;

import edu.toronto.cs.se.mmint.operator.slice.Slice;

public class GSNSliceRevise2Content extends Slice {

//  @Override
//  protected Map<EObject, EObject> getAllSlicedElements(EObject critModelObj, Set<EObject> alreadySliced) {
//    //TODO Does this function mean that there is no slicing recursion, e.g. for goals
//    var sliced = new HashMap<EObject, EObject>();
//    sliced.put(critModelObj, null);
//    alreadySliced.add(critModelObj);
//    // Identify all elements (including supported-by connectors) that are
//    // dependent on the revised element.
//    var impactedModelObjs = getDirectlySlicedElements(critModelObj, alreadySliced);
//    alreadySliced.addAll(impactedModelObjs);
//    // Iterate through newly impacted supported-by connectors and check
//    // whether their sources are impacted as well. Repeat the process
//    // until a fixed point is reached.
//    var connectors = new HashSet<SupportConnector>();
//    for (var elem : alreadySliced) {
//      if (elem instanceof SupportConnector) {
//        connectors.add((SupportConnector) elem);
//      }
//    }
//    var connectorDependants = new HashSet<Supportable>();
//    for (var dependant : GSNUtils.getConnectorDependants(connectors, alreadySliced)) {
//      if (dependant instanceof CoreElement) {
//        connectorDependants.add(dependant);
//      }
//    }
//    impactedModelObjs.addAll(connectorDependants);
//    // Remove supported-by connectors from the impacted elements.
//    impactedModelObjs.removeIf(elem -> elem instanceof SupportConnector);
//    // Return the impacted elements (excluding supported-by connectors).
//    impactedModelObjs.stream().forEach(i -> sliced.put(i, critModelObj));
//
//    return sliced;
//  }
}

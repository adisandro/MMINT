/*******************************************************************************
 * Copyright (c) 2021, 2023 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.productline.mid;

import edu.toronto.cs.se.mmint.MIDHeavyTypeFactory;
import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.extensions.ExtensionPointType;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.ProductLinePackage;

public class ProductLineMIDHeavyTypeFactory extends MIDHeavyTypeFactory {

  public static ProductLine getProductLine(PLMapping plMapping) {
    return plMapping.getModelElemEndpoints().stream()
      .map(mee -> (Model) mee.getTarget().eContainer())
      .filter(m -> MIDTypeHierarchy.instanceOf(m, ProductLinePackage.eNS_URI, false))
      .map(m -> (ProductLine) m.getEMFInstanceRoot())
      .findAny() // assumption: all product line models connected by a rel share the same features and constraints
      .get();
  }

  @Override
  public ModelRel createHeavyModelRelType(ExtensionPointType extensionType, boolean isBinary) throws MMINTException {
    var newPLModelRelType = (isBinary) ?
      ProductLineMIDFactory.eINSTANCE.createPLBinaryModelRel() :
      ProductLineMIDFactory.eINSTANCE.createPLModelRel();
    super.addHeavyModelRelType(newPLModelRelType, extensionType.getUri(), extensionType.getSupertypeUri(),
                               extensionType.getName(), extensionType.isAbstract());

    return newPLModelRelType;
  }

  @Override
  public MappingReference createHeavyMappingTypeAndMappingTypeReference(
                            ExtensionPointType extensionType, boolean isBinary, ModelRel containerModelRelType)
                              throws MMINTException {
    var newPLMappingType = (isBinary) ?
      ProductLineMIDFactory.eINSTANCE.createPLBinaryMapping() :
      ProductLineMIDFactory.eINSTANCE.createPLMapping();

    return super.addHeavyMappingTypeAndMappingTypeReference(newPLMappingType, extensionType.getUri(),
                                                            extensionType.getSupertypeUri(), extensionType.getName(),
                                                            containerModelRelType);
  }
}

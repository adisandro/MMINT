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
package edu.toronto.cs.se.mmint.papyrus.uml;

import edu.toronto.cs.se.mmint.MIDHeavyTypeFactory;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.extensions.ExtensionPointType;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.papyrus.PapyrusFactory;

public class UMLMIDHeavyTypeFactory extends MIDHeavyTypeFactory {
  public static final String NOTATION_FILEEXT = "notation";

  @Override
  public Model createHeavyModelType(ExtensionPointType extensionType) throws MMINTException {
    var newModelType = PapyrusFactory.eINSTANCE.createUMLModel();
    super.addHeavyModelType(newModelType, extensionType.getUri(), extensionType.getSupertypeUri(), extensionType.getName(), extensionType.isAbstract());

    return newModelType;
  }
}

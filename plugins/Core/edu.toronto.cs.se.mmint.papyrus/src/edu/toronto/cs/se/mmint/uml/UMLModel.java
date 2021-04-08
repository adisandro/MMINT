/*******************************************************************************
 * Copyright (c) 2021, 2021 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.uml;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.impl.ModelImpl;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;

public class UMLModel extends ModelImpl {

  @Override
  public void deleteInstanceAndFile() throws MMINTException {
    var notationPath = FileUtils.replaceFileExtensionInPath(getUri(), UMLMIDHeavyTypeFactory.NOTATION_FILEEXT);
    if (FileUtils.isFile(notationPath, true)) {
      FileUtils.deleteFile(notationPath, true);
    }
    super.deleteInstanceAndFile();
  }
}

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
package edu.toronto.cs.se.mmint.papyrus.impl;

import org.eclipse.emf.ecore.EClass;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.impl.ModelImpl;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.papyrus.PapyrusPackage;
import edu.toronto.cs.se.mmint.papyrus.UMLModel;
import edu.toronto.cs.se.mmint.papyrus.uml.UMLMIDHeavyTypeFactory;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>UML Model</b></em>'. <!-- end-user-doc -->
 *
 * @generated
 */
public class UMLModelImpl extends ModelImpl implements UMLModel {
  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected UMLModelImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return PapyrusPackage.Literals.UML_MODEL;
  }

  /**
   * @generated NOT
   */
  @Override
  public void deleteInstanceAndFile() throws MMINTException {
    var notationPath = FileUtils.replaceFileExtensionInPath(getUri(), UMLMIDHeavyTypeFactory.NOTATION_FILEEXT);
    if (FileUtils.isFile(notationPath, true)) {
      FileUtils.deleteFile(notationPath, true);
    }
    super.deleteInstanceAndFile();
  }
} // UMLModelImpl

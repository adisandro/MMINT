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
package edu.toronto.cs.se.mmint.primitive.file.impl;

import java.io.IOException;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.impl.ModelImpl;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.primitive.file.FileModel;
import edu.toronto.cs.se.mmint.primitive.file.FilePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class FileModelImpl extends ModelImpl implements FileModel {
	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected FileModelImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return FilePackage.Literals.FILE_MODEL;
  }

	/**
	 * @generated NOT
	 */
	@Override
	public void openInstance() throws Exception {

		MMINTException.mustBeInstance(this);

		IPath path = new Path(this.getUri());
		var file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(), file);
	}

  /**
   * @generated NOT
   */
  @Override
  public Model createInstance(EObject rootModelObj, String newModelPath, MID instanceMID) throws MMINTException,
                                                                                                 IOException {
    var newModel = super.createInstance(rootModelObj, newModelPath, instanceMID);
    newModel.setName(FileUtils.getLastSegmentFromPath(newModelPath));

    return newModel;
  }

} //FileModelImpl

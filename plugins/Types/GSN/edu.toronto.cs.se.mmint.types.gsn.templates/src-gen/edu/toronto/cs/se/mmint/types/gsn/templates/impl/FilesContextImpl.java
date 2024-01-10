/*******************************************************************************
 * Copyright (c) 2023, 2024 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.types.gsn.templates.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.types.gsn.templates.FilesContext;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage;
import edu.toronto.cs.se.modelepedia.gsn.impl.ContextImpl;
import edu.toronto.cs.se.modelepedia.gsn.util.GSNBuilder;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Files Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.FilesContextImpl#getPaths <em>Paths</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FilesContextImpl extends ContextImpl implements FilesContext {
  /**
   * The cached value of the '{@link #getPaths() <em>Paths</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPaths()
   * @generated
   * @ordered
   */
  protected EList<String> paths;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FilesContextImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return GSNTemplatesPackage.Literals.FILES_CONTEXT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<String> getPaths() {
    if (this.paths == null) {
      this.paths = new EDataTypeUniqueEList<>(String.class, this, GSNTemplatesPackage.FILES_CONTEXT__PATHS);
    }
    return this.paths;
  }

  /**
   * @generated NOT
   */
  @Override
  public void instantiate() throws Exception {
    super.instantiate();
    var paths = getPaths();
    var title = "Instantiate Files Context";
    var msg = "Select a file or directory";
    if (paths.size() == 0) {
      paths.add(FileUtils.prependWorkspacePath(GSNBuilder.askForPath(title, msg)));
    }
    else {
      for (var i = 0; i < paths.size(); i++) {
        var path = paths.get(i);
        if (!FileUtils.isFileOrDirectory(path, false)) {
          paths.set(i, FileUtils.prependWorkspacePath(
                         GSNBuilder.askForPath(title, msg + " to replace '" + path + "'")));
        }
      }
    }
  }

  /**
   * @generated NOT
   */
  @Override
  public void validate() throws Exception {
    super.validate();
    var paths = getPaths();
    if (paths.size() == 0) {
      setValid(false);
      throw new MMINTException("There is no path associated with this context");
    }
    for (var path : paths) {
      if (!FileUtils.isFileOrDirectory(path, false)) {
        setValid(false);
        throw new MMINTException("There are no files or directories at '" + path + "'");
      }
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case GSNTemplatesPackage.FILES_CONTEXT__PATHS:
        return getPaths();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case GSNTemplatesPackage.FILES_CONTEXT__PATHS:
        getPaths().clear();
        getPaths().addAll((Collection<? extends String>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
      case GSNTemplatesPackage.FILES_CONTEXT__PATHS:
        getPaths().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
      case GSNTemplatesPackage.FILES_CONTEXT__PATHS:
        return this.paths != null && !this.paths.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) {
      return super.toString();
    }

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (paths: ");
    result.append(this.paths);
    result.append(')');
    return result.toString();
  }

} //FilesContextImpl

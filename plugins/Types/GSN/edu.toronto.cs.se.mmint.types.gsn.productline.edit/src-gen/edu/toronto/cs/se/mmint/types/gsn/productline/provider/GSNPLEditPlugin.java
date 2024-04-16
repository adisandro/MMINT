/*******************************************************************************
 * Copyright (c) 2024, 2024 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.types.gsn.productline.provider;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;

import edu.toronto.cs.se.mmint.productline.provider.PLEditPlugin;
import edu.toronto.cs.se.mmint.types.gsn.templates.provider.GSNTemplatesEditPlugin;
import edu.toronto.cs.se.modelepedia.gsn.provider.GSNEditPlugin;

/**
 * This is the central singleton for the GSNPL edit plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class GSNPLEditPlugin extends EMFPlugin {
  /**
   * Keep track of the singleton.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final GSNPLEditPlugin INSTANCE = new GSNPLEditPlugin();

  /**
   * Keep track of the singleton.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static Implementation plugin;

  /**
   * Create the instance.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GSNPLEditPlugin() {
    super
      (new ResourceLocator [] {
         GSNEditPlugin.INSTANCE,
         GSNTemplatesEditPlugin.INSTANCE,
         PLEditPlugin.INSTANCE,
       });
  }

  /**
   * Returns the singleton instance of the Eclipse plugin.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the singleton instance.
   * @generated
   */
  @Override
  public ResourceLocator getPluginResourceLocator() {
    return GSNPLEditPlugin.plugin;
  }

  /**
   * Returns the singleton instance of the Eclipse plugin.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the singleton instance.
   * @generated
   */
  public static Implementation getPlugin() {
    return GSNPLEditPlugin.plugin;
  }

  /**
   * The actual implementation of the Eclipse <b>Plugin</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static class Implementation extends EclipsePlugin {
    /**
     * Creates an instance.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Implementation() {
      super();

      // Remember the static instance.
      //
      GSNPLEditPlugin.plugin = this;
    }
  }

}

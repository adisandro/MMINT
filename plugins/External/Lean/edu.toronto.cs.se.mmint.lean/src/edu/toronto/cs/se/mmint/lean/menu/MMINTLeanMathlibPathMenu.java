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
package edu.toronto.cs.se.mmint.lean.menu;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTConstants;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;

public class MMINTLeanMathlibPathMenu extends AbstractHandler {

  public final static String PREFERENCE_MENU_LEAN_MATHLIB_PATH = MMINTConstants.PREFERENCE_MENU_ID +
                                                            ".LeanMathlib";

  @Override
  public @Nullable Object execute(ExecutionEvent event) throws ExecutionException {
    var prevMathlibPath = MMINT.getPreference(MMINTLeanMathlibPathMenu.PREFERENCE_MENU_LEAN_MATHLIB_PATH);
    try {
      var newMathlibPath = MIDDialogs.getStringInput("Lean configuration", "Insert the path to the Mathlib directory",
                                                     prevMathlibPath);
      MMINT.setPreference(MMINTLeanMathlibPathMenu.PREFERENCE_MENU_LEAN_MATHLIB_PATH, newMathlibPath);
    }
    catch (MIDDialogCancellation e) {
      // do nothing
    }
    return null;
  }
}

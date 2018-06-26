/**
 * Copyright (c) 2012-2018 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.diagram.menu;

import org.eclipse.jface.action.ContributionItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTConstants;

public class MMINTLanguageReasonersMenu extends ContributionItem {

	@Override
	public boolean isDynamic() {

		return true;
	}

	@Override
	public void fill(Menu menu, int index) {

		MenuItem reasonersItem = new MenuItem(menu, SWT.CASCADE, index);
		reasonersItem.setText("Reasoners");
		Menu reasonersMenu = new Menu(menu);
		reasonersItem.setMenu(reasonersMenu);
		for (final String languageId : MMINT.getReasonerLanguages()) {
			MenuItem languageItem = new MenuItem(reasonersMenu, SWT.CASCADE);
			languageItem.setText(languageId);
			Menu languageMenu = new Menu(menu);
			languageItem.setMenu(languageMenu);
			for (final String reasonerName : MMINT.getLanguageReasoners(languageId).keySet()) {
				final MenuItem languageSubitem = new MenuItem(languageMenu, SWT.CHECK);
				languageSubitem.setText(reasonerName);
				final boolean selection = (MMINT.getPreference(MMINTConstants.PREFERENCE_MENU_LANGUAGE_REASONER + languageId).equals(reasonerName)) ?
					true :
					false;
				languageSubitem.setSelection(selection);
				languageSubitem.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						if (selection) {
							return;
						}
						MMINT.setPreference(MMINTConstants.PREFERENCE_MENU_LANGUAGE_REASONER + languageId, reasonerName);
						languageSubitem.setSelection(true);
						for (MenuItem otherLanguageSubitem : languageSubitem.getParent().getItems()) {
							if (otherLanguageSubitem != languageSubitem && otherLanguageSubitem.getSelection()) {
								otherLanguageSubitem.setSelection(false);
							}
						}
					}
				});
			}
		}
	}

}

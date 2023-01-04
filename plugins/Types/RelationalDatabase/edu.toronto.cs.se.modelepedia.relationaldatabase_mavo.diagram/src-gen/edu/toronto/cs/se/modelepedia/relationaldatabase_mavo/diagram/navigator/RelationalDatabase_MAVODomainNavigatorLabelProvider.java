/*
* Copyright (c) 2012-2023 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
* Rick Salay.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
* 
* Contributors:
*    Alessio Di Sandro - Implementation.
*/
package edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.navigator;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

/**
 * @generated
 */
public class RelationalDatabase_MAVODomainNavigatorLabelProvider implements ICommonLabelProvider {

	/**
	* @generated
	*/
	private AdapterFactoryLabelProvider myAdapterFactoryLabelProvider = new AdapterFactoryLabelProvider(
			edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVODiagramEditorPlugin
					.getInstance().getItemProvidersAdapterFactory());

	/**
	* @generated
	*/
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	* @generated
	*/
	public Image getImage(Object element) {
		if (element instanceof edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.navigator.RelationalDatabase_MAVODomainNavigatorItem) {
			return myAdapterFactoryLabelProvider.getImage(
					((edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.navigator.RelationalDatabase_MAVODomainNavigatorItem) element)
							.getEObject());
		}
		return null;
	}

	/**
	* @generated
	*/
	public String getText(Object element) {
		if (element instanceof edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.navigator.RelationalDatabase_MAVODomainNavigatorItem) {
			return myAdapterFactoryLabelProvider.getText(
					((edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.navigator.RelationalDatabase_MAVODomainNavigatorItem) element)
							.getEObject());
		}
		return null;
	}

	/**
	* @generated
	*/
	public void addListener(ILabelProviderListener listener) {
		myAdapterFactoryLabelProvider.addListener(listener);
	}

	/**
	* @generated
	*/
	public void dispose() {
		myAdapterFactoryLabelProvider.dispose();
	}

	/**
	* @generated
	*/
	public boolean isLabelProperty(Object element, String property) {
		return myAdapterFactoryLabelProvider.isLabelProperty(element, property);
	}

	/**
	* @generated
	*/
	public void removeListener(ILabelProviderListener listener) {
		myAdapterFactoryLabelProvider.removeListener(listener);
	}

	/**
	* @generated
	*/
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	* @generated
	*/
	public String getDescription(Object anElement) {
		return null;
	}

}

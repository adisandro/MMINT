/*
* Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
* Rick Salay.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
* 
* Contributors:
*    Alessio Di Sandro - Implementation.
*/
package edu.toronto.cs.se.modelepedia.istar_mavo.diagram.navigator;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class IStar_MAVONavigatorItem
		extends edu.toronto.cs.se.modelepedia.istar_mavo.diagram.navigator.IStar_MAVOAbstractNavigatorItem {

	/**
	* @generated
	*/
	static {
		final Class[] supportedTypes = new Class[] { View.class, EObject.class };
		Platform.getAdapterManager().registerAdapters(new IAdapterFactory() {

			public Object getAdapter(Object adaptableObject, Class adapterType) {
				if (adaptableObject instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.navigator.IStar_MAVONavigatorItem
						&& (adapterType == View.class || adapterType == EObject.class)) {
					return ((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.navigator.IStar_MAVONavigatorItem) adaptableObject)
							.getView();
				}
				return null;
			}

			public Class[] getAdapterList() {
				return supportedTypes;
			}
		}, edu.toronto.cs.se.modelepedia.istar_mavo.diagram.navigator.IStar_MAVONavigatorItem.class);
	}

	/**
	* @generated
	*/
	private View myView;

	/**
	* @generated
	*/
	private boolean myLeaf = false;

	/**
	* @generated
	*/
	public IStar_MAVONavigatorItem(View view, Object parent, boolean isLeaf) {
		super(parent);
		myView = view;
		myLeaf = isLeaf;
	}

	/**
	* @generated
	*/
	public View getView() {
		return myView;
	}

	/**
	* @generated
	*/
	public boolean isLeaf() {
		return myLeaf;
	}

	/**
	* @generated
	*/
	public boolean equals(Object obj) {
		if (obj instanceof edu.toronto.cs.se.modelepedia.istar_mavo.diagram.navigator.IStar_MAVONavigatorItem) {
			return EcoreUtil.getURI(getView())
					.equals(EcoreUtil
							.getURI(((edu.toronto.cs.se.modelepedia.istar_mavo.diagram.navigator.IStar_MAVONavigatorItem) obj)
									.getView()));
		}
		return super.equals(obj);
	}

	/**
	* @generated
	*/
	public int hashCode() {
		return EcoreUtil.getURI(getView()).hashCode();
	}

}

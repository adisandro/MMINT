/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.relationship.diagram.part;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;

import edu.toronto.cs.se.mmtf.MMTF;
import edu.toronto.cs.se.mmtf.repository.MMTFConstants;

public class RelationshipDiagramOutlineContentProvider extends AdapterFactoryContentProvider {

	private boolean isInstancesLevel;

	public RelationshipDiagramOutlineContentProvider(AdapterFactory adapterFactory, boolean isInstancesLevel) {

		super(adapterFactory);
		this.isInstancesLevel = isInstancesLevel;
	}

	@Override
	public boolean hasChildren(Object object) {

		boolean hasChildren;
		if (isInstancesLevel && (boolean) MMTF.getSetting(MMTFConstants.SETTING_MENU_ALTERNATIVE_MODEL_TREE_ENABLED) && object instanceof EObject) {
			RelationshipDiagramOutlineItemProvider alternativeProvider = new RelationshipDiagramOutlineItemProvider(adapterFactory);
			hasChildren = alternativeProvider.hasChildren(object);
		}
		else if (!isInstancesLevel && object instanceof EClass) {
			RelationshipDiagramOutlineEClassItemProvider alternativeProvider = new RelationshipDiagramOutlineEClassItemProvider(adapterFactory);
			hasChildren = alternativeProvider.hasChildren(object);
		}
		else {
			hasChildren = super.hasChildren(object);
		}

		return hasChildren;
	}

	@Override
	public Object[] getChildren(Object object) {

		Object[] children;
		if (isInstancesLevel && (boolean) MMTF.getSetting(MMTFConstants.SETTING_MENU_ALTERNATIVE_MODEL_TREE_ENABLED) && object instanceof EObject) {
			RelationshipDiagramOutlineItemProvider alternativeProvider = new RelationshipDiagramOutlineItemProvider(adapterFactory);
			children = alternativeProvider.getChildren(object).toArray();
		}
		else if (!isInstancesLevel && object instanceof EClass) {
			RelationshipDiagramOutlineEClassItemProvider alternativeProvider = new RelationshipDiagramOutlineEClassItemProvider(adapterFactory);
			children = alternativeProvider.getChildren(object).toArray();
		}
		else {
			children = super.getChildren(object);
		}

		return children;
	}

}

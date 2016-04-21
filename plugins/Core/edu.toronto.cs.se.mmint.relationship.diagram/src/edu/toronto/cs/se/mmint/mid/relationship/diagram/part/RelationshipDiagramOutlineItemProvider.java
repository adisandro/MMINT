/**
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.relationship.diagram.part;

import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;

public class RelationshipDiagramOutlineItemProvider extends ItemProviderAdapter {

	public RelationshipDiagramOutlineItemProvider(AdapterFactory adapterFactory) {

		super(adapterFactory);
	}

	@Override
	protected Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {

		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			EClass objectEClass = ((EObject) object).eClass();
			childrenFeatures.addAll(objectEClass.getEAllContainments());
			childrenFeatures.addAll(objectEClass.getEAllAttributes());
		}

		return childrenFeatures;
	}

}

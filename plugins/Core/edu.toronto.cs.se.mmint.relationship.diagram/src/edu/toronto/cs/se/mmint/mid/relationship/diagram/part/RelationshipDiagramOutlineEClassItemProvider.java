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
package edu.toronto.cs.se.mmint.mid.relationship.diagram.part;

import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.provider.EClassItemProvider;

public class RelationshipDiagramOutlineEClassItemProvider extends EClassItemProvider {

	public RelationshipDiagramOutlineEClassItemProvider(AdapterFactory adapterFactory) {

		super(adapterFactory);
	}

	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {

		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			int replaceIndex = childrenFeatures.indexOf(EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES);
			childrenFeatures.remove(replaceIndex);
			childrenFeatures.add(replaceIndex, EcorePackage.Literals.ECLASS__EALL_STRUCTURAL_FEATURES);
		}

		return childrenFeatures;
	}

}

/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;

public class RelationshipDiagramOutlineItemProvider extends ItemProviderAdapter {

	private EClass xx;

	public RelationshipDiagramOutlineItemProvider(AdapterFactory adapterFactory, EClass x) {

		super(adapterFactory);
		xx = x;
	}

	@Override
	protected Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {

		super.getChildrenFeatures(object);
		for (EStructuralFeature eStructuralFeature : xx.getEAllStructuralFeatures()) {
			//TODO MMTF: looks like there are already all EReferences
			//TODO MMTF: refine, these should be the missing features, based on the default provider
			//TODO MMTF: some EAttributes are missing, some are there
			if (eStructuralFeature instanceof EAttribute || (eStructuralFeature instanceof EReference && !((EReference) eStructuralFeature).isContainment())) {
				childrenFeatures.add(eStructuralFeature);
			}
		}

		return childrenFeatures;
	}

	@Override
	public String getText(Object object) {

		//TODO MMTF: add label for the additional children (or for all?) to identify things, e.g. [featureName] featureValue 
		return super.getText(object);
	}

}

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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;

public class ExtendedItemProvider
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {

	private AdapterFactory adapterFactory;
	private EPackage modelTypePackage;

	public ExtendedItemProvider(AdapterFactory adapterFactory, EPackage modelTypePackage) {

		super(adapterFactory);
		this.adapterFactory = adapterFactory;
		this.modelTypePackage = modelTypePackage;
	}

	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {

		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			for (EClassifier eClassifier : modelTypePackage.getEClassifiers()) {
				if (!(eClassifier instanceof EClass)) {
					continue;
				}
				for (EStructuralFeature eStructuralFeature : ((EClass) eClassifier).getEStructuralFeatures()) {
					//TODO MMTF: EAllStructuralFeatures?
					if (!childrenFeatures.contains(eStructuralFeature)) {
						childrenFeatures.add(eStructuralFeature);
					}
				}
			}
			//eAdapters()?
		}

		return childrenFeatures;
	}

	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {

		return super.getChildFeature(object, child);
	}

}

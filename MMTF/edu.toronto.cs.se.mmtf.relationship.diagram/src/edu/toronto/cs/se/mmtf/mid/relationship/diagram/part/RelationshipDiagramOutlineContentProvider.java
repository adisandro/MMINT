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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;

import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;

public class RelationshipDiagramOutlineContentProvider extends AdapterFactoryContentProvider {

	private ModelRel modelRel;

	public RelationshipDiagramOutlineContentProvider(AdapterFactory adapterFactory, ModelRel modelRel) {

		//TODO MMTF: modelRel is useless?
		super(adapterFactory);
		this.modelRel = modelRel;
	}

	@Override
	public Object[] getChildren(Object object) {

		//TODO MMTF: add setting to show the complete thing, since it might get huge and recursive
		Object[] children;
		ITreeItemContentProvider defaultContentProvider = (ITreeItemContentProvider) adapterFactory.adapt(object, ITreeItemContentProvider.class);
		if (defaultContentProvider != null) {
			Collection<?> defaultChildren = defaultContentProvider.getChildren(object);
			if (defaultContentProvider instanceof ItemProviderAdapter && object instanceof EObject) {
				RelationshipDiagramOutlineItemProvider additionalContentProvider = new RelationshipDiagramOutlineItemProvider(adapterFactory, ((EObject) object).eClass());
				Collection<?> additionalChildren = additionalContentProvider.getChildren(object);
				children = new Object[defaultChildren.size() + additionalChildren.size()];
				System.arraycopy(defaultChildren.toArray(), 0, children, 0, defaultChildren.size());
				System.arraycopy(additionalChildren.toArray(), 0, children, defaultChildren.size(), additionalChildren.size());
			}
			else {
				children = defaultChildren.toArray();
			}
		}
		else {
			children = new Object[0];
		}

		return children;
	}

}

/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Naama Ben-David.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Naama Ben-David - Implementation.
 */
package edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;

import edu.toronto.cs.se.mavo.MAVOAlternative;
import edu.toronto.cs.se.mavo.MAVODecision;
import edu.toronto.cs.se.mavo.MAVOModel;
import edu.toronto.cs.se.mavo.MayDecision;
import edu.toronto.cs.se.mavo.VarDecision;

public class MAVODecisionTreeContentProvider extends
		AdapterFactoryContentProvider {

	public MAVODecisionTreeContentProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public boolean hasChildren(Object object) {
		boolean hasChildren = false;
		if (object instanceof Resource) {
			MAVOModel model = (MAVOModel) ((Resource) object).getContents()
					.get(0);
			if (!model.getDecisions().isEmpty()) {
				hasChildren = true;
			}
		} else if (object instanceof MAVOModel) {
			MAVOModel model = (MAVOModel) object;
			if (!model.getDecisions().isEmpty()) {
				hasChildren = true;
			}
		} else if (object instanceof MAVODecision) {
			if (object instanceof MayDecision) {
				MayDecision decision = (MayDecision) object;
				if (!decision.getAlternatives().isEmpty()) {
					hasChildren = true;
				}
			} else if (object instanceof VarDecision) {
				VarDecision decision = (VarDecision) object;
				if (decision.getDomain() != null) {
					hasChildren = true;
				}
			}
		} else if (object instanceof MAVOAlternative) {
			MAVOAlternative alternative = (MAVOAlternative) object;
			if (!alternative.getMavoElements().isEmpty()) {
				hasChildren = true;
			}
		}
		return hasChildren;
	}

	@Override
	public Object[] getElements(Object inputElement) {

		return getChildren(inputElement);
	}

	@Override
	public Object[] getChildren(Object object) {
		Object[] children = new Object[] {};
		if (object instanceof Resource) {
			children = new Object[] { ((Resource) object).getContents().get(0) };
		} else if (object instanceof MAVOModel) {
			MAVOModel model = (MAVOModel) object;
			children = model.getDecisions().toArray();
		} else if (object instanceof MAVODecision) {
			if (object instanceof MayDecision) {
				MayDecision decision = (MayDecision) object;
				children = decision.getAlternatives().toArray();
			} else if (object instanceof VarDecision) {
				VarDecision decision = (VarDecision) object;
				children = new Object[] { decision.getDomain() };
			}
		} else if (object instanceof MAVOAlternative) {
			MAVOAlternative alternative = (MAVOAlternative) object;
			children = alternative.getMavoElements().toArray();
		}

		return children;
	}

}

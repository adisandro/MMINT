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
package edu.toronto.cs.se.modelepedia.operator.match;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.ReferenceChange;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import edu.toronto.cs.se.mmint.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.ModelOrigin;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.impl.ModelElementImpl;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.Link;
import edu.toronto.cs.se.mmint.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public class EMFModelNameMatch extends OperatorImpl {

	private final static String NAME_FEATURE = "name";
	private final static String MODELREL_NAME = "nameMatch";

	private IComparisonScope scope;
	private Comparison comparison;

	private void match(Model srcModel, Model tgtModel) {

		ResourceSet srcResourceSet = new ResourceSetImpl();
		srcResourceSet.getResource(URI.createPlatformResourceURI(srcModel.getUri(), true), true);
		ResourceSet tgtResourceSet = new ResourceSetImpl();
		tgtResourceSet.getResource(URI.createPlatformResourceURI(tgtModel.getUri(), true), true);
		scope = new DefaultComparisonScope(srcResourceSet, tgtResourceSet, null);
		comparison = EMFCompare.builder().build().compare(scope);
	}

	public IComparisonScope getScope() {

		return scope;
	}

	public Comparison getComparison() {

		return comparison;
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		Model srcModel = actualParameters.get(0);
		Model tgtModel = actualParameters.get(1);

		// create match model relationship
		MultiModel multiModel = MultiModelRegistry.getMultiModel(srcModel);
		ModelRel rootModelRelType = MultiModelTypeHierarchy.getRootModelRelType();
		ModelRel matchRel = rootModelRelType.createInstance(null, true, ModelOrigin.CREATED, multiModel);
		matchRel.setName(MODELREL_NAME);
		// create model endpoints
		ModelEndpoint rootModelTypeEndpoint = MultiModelTypeHierarchy.getRootModelTypeEndpoint();
		ModelEndpointReference srcModelEndpointRef = rootModelTypeEndpoint.createInstanceAndReference(srcModel, matchRel);
		ModelEndpointReference tgtModelEndpointRef = rootModelTypeEndpoint.createInstanceAndReference(tgtModel, matchRel);

		// create model relationship structure
		Link rootLinkType = MultiModelTypeHierarchy.getRootLinkType();
		ModelElementEndpoint rootModelElemTypeEndpoint = MultiModelTypeHierarchy.getRootModelElementTypeEndpoint();
		match(srcModel, tgtModel);
		for (Match rootMatch : comparison.getMatches()) {
nextMatch:
			for (Match match : rootMatch.getAllSubmatches()) {
				if (match.getLeft() == null || match.getRight() == null) {
					continue;
				}
				if (match.getDifferences().size() > 0) {
					for (Diff diff : match.getDifferences()) {
						if (!(diff instanceof ReferenceChange)) {
							continue nextMatch;
						}
					}
				}
				EStructuralFeature feature = match.getLeft().eClass().getEStructuralFeature(NAME_FEATURE);
				if (feature == null || !(feature instanceof EAttribute) || !(match.getLeft().eGet(feature) instanceof String)) {
					continue;
				}
				// create link
				LinkReference matchLinkRef = rootLinkType.createInstanceAndReference(true, matchRel);
				matchLinkRef.getObject().setName((String) match.getLeft().eGet(feature));
				// create model elements
				ModelElementReference srcModelElemRef = ModelElementImpl.createMAVOInstanceAndReference(match.getLeft(), null, srcModelEndpointRef);
				ModelElementReference tgtModelElemRef = ModelElementImpl.createMAVOInstanceAndReference(match.getRight(), null, tgtModelEndpointRef);
				// create model element endpoints
				rootModelElemTypeEndpoint.createInstanceAndReference(srcModelElemRef, matchLinkRef);
				rootModelElemTypeEndpoint.createInstanceAndReference(tgtModelElemRef, matchLinkRef);
			}
		}

		EList<Model> result = new BasicEList<Model>();
		result.add(matchRel);
		return result;
	}

}

/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
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
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import edu.toronto.cs.se.mmtf.mavo.library.MultiModelMAVOInstanceFactory;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelInstanceFactory;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorExecutableImpl;
import edu.toronto.cs.se.mmtf.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;

public class ModelNameMatch extends OperatorExecutableImpl {

	private final static String NAME_FEATURE = "name";
	private final static String MODELREL_NAME = "nameMatch";

	private IComparisonScope scope;
	private Comparison comparison;

	private void match(Model srcModel, Model tgtModel) {

		ResourceSet srcResourceSet = new ResourceSetImpl();
		srcResourceSet.getResource(URI.createPlatformResourceURI(srcModel.getUri(), true), true);
		ResourceSet tgtResourceSet = new ResourceSetImpl();
		tgtResourceSet.getResource(URI.createPlatformResourceURI(tgtModel.getUri(), true), true);
		scope = EMFCompare.createDefaultScope(srcResourceSet, tgtResourceSet);
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
		ModelRel matchRel = MultiModelInstanceFactory.createModelRel(
			null,
			null,
			ModelOrigin.CREATED,
			RelationshipPackage.eINSTANCE.getBinaryModelRel(),
			multiModel
		);
		matchRel.setName(MODELREL_NAME);
		// create model endpoints
		ModelEndpointReference srcModelEndpointRef = MultiModelInstanceFactory.createModelEndpointAndModelEndpointReference(
			null,
			matchRel,
			srcModel,
			false
		);
		ModelEndpointReference tgtModelEndpointRef = MultiModelInstanceFactory.createModelEndpointAndModelEndpointReference(
			null,
			matchRel,
			tgtModel,
			false
		);

		// create model relationship structure
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
				LinkReference matchLinkRef = MultiModelInstanceFactory.createLinkAndLinkReference(
					null,
					matchRel,
					RelationshipPackage.eINSTANCE.getBinaryLink(),
					RelationshipPackage.eINSTANCE.getBinaryLinkReference()
				);
				matchLinkRef.getObject().setName((String) match.getLeft().eGet(feature));
				// create model elements
				ModelElementReference srcModelElemRef = MultiModelMAVOInstanceFactory.createModelElementAndModelElementReference(
					srcModelEndpointRef,
					null,
					match.getLeft()
				);
				ModelElementReference tgtModelElemRef = MultiModelMAVOInstanceFactory.createModelElementAndModelElementReference(
					tgtModelEndpointRef,
					null,
					match.getRight()
				);
				// create model element endpoints
				MultiModelInstanceFactory.createModelElementEndpointAndModelElementEndpointReference(
					null,
					matchLinkRef,
					srcModelElemRef,
					false
				);
				MultiModelInstanceFactory.createModelElementEndpointAndModelElementEndpointReference(
					null,
					matchLinkRef,
					tgtModelElemRef,
					false
				);
			}
		}

		EList<Model> result = new BasicEList<Model>();
		result.add(matchRel);
		return result;
	}

}

/*
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.powerwindow.operator;

import java.util.Collections;
import java.util.Date;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;
import edu.toronto.cs.se.mmtf.mid.operator.impl.ConversionOperatorExecutableImpl;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelFactoryUtils;
import edu.toronto.cs.se.modelepedia.petrinet.PetriNet;
import edu.toronto.cs.se.modelepedia.petrinet.PetrinetFactory;
import edu.toronto.cs.se.modelepedia.petrinet.PetrinetPackage;
import edu.toronto.cs.se.modelepedia.petrinet.Place;
import edu.toronto.cs.se.modelepedia.powerwindow.Window;

public class PowerWindowToPetriNet extends ConversionOperatorExecutableImpl {

	private static final int DELAY_BOUND = 50;
	private static final String FILE_SUFFIX = "_pw2pn_";
	private Model newElement;

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		if (actualParameters.size() != 1 || !(actualParameters.get(0) instanceof Model)) {
			throw new MMTFException("Bad operator parameters");
		}

		// convert
		Model windowModel = actualParameters.get(0);
		Window window = (Window) windowModel.getRoot();
		PetriNet petriNet = PetrinetFactory.eINSTANCE.createPetriNet();
		if (window.getSensor() != null && window.getSensor().getDelay() < DELAY_BOUND) {
			Place place = PetrinetFactory.eINSTANCE.createPlace();
			petriNet.getNodes().add(place);
		}

		// serialize
		String uri = windowModel.getUri();
		uri = uri.substring(0, uri.lastIndexOf(IPath.SEPARATOR)+1) +
			windowModel.getName() +
			FILE_SUFFIX +
			(new Date()).getTime() +
			"." + PetrinetPackage.eNAME;
		URI modelUri = URI.createPlatformResourceURI(uri, true);
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(modelUri);
		resource.getContents().add(petriNet);
		resource.save(Collections.EMPTY_MAP);

		// create model
		MultiModel owner = (MultiModel) windowModel.eContainer();
		MultiModelFactoryUtils.assertModelUnique(owner, modelUri);
		newElement = MultiModelFactoryUtils.createModel(null, ModelOrigin.CREATED, owner, modelUri);
		Editor editor = MultiModelFactoryUtils.createEditor(newElement);
		if (editor != null) {
			MultiModelFactoryUtils.addModelEditor(editor, owner);
		}

		EList<Model> result = new BasicEList<Model>();
		result.add(newElement);

		return result;
	}

	@Override
	public void cleanup() throws Exception {

		if (newElement != null) {
			MultiModelFactoryUtils.removeModel(newElement);
			((MultiModel) newElement.eContainer()).getModels().remove(newElement);
			IPath path = new Path(newElement.getUri());
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			file.delete(true, null);
			newElement = null;
		}
	}

}

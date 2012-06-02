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
package edu.toronto.cs.se.modelepedia.petrinet.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;

import edu.toronto.cs.se.modelepedia.petrinet.PetrinetPackage;
import edu.toronto.cs.se.modelepedia.petrinet.diagram.edit.parts.ArcWeightEditPart;
import edu.toronto.cs.se.modelepedia.petrinet.diagram.edit.parts.PlaceNameTokensEditPart;
import edu.toronto.cs.se.modelepedia.petrinet.diagram.edit.parts.TransitionNameEditPart;
import edu.toronto.cs.se.modelepedia.petrinet.diagram.parsers.MessageFormatParser;
import edu.toronto.cs.se.modelepedia.petrinet.diagram.part.PetrinetVisualIDRegistry;

/**
 * @generated
 */
public class PetrinetParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser transitionName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getTransitionName_5001Parser() {
		if (transitionName_5001Parser == null) {
			EAttribute[] features = new EAttribute[] { PetrinetPackage.eINSTANCE
					.getNode_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			transitionName_5001Parser = parser;
		}
		return transitionName_5001Parser;
	}

	/**
	 * @generated
	 */
	private IParser placeNameTokens_5002Parser;

	/**
	 * @generated
	 */
	private IParser getPlaceNameTokens_5002Parser() {
		if (placeNameTokens_5002Parser == null) {
			EAttribute[] features = new EAttribute[] {
					PetrinetPackage.eINSTANCE.getNode_Name(),
					PetrinetPackage.eINSTANCE.getPlace_Tokens() };
			EAttribute[] editableFeatures = new EAttribute[] {
					PetrinetPackage.eINSTANCE.getNode_Name(),
					PetrinetPackage.eINSTANCE.getPlace_Tokens() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			parser.setViewPattern("{0} [{1}]"); //$NON-NLS-1$
			parser.setEditorPattern("{0} [{1}]"); //$NON-NLS-1$
			parser.setEditPattern("{0} [{1}]"); //$NON-NLS-1$
			placeNameTokens_5002Parser = parser;
		}
		return placeNameTokens_5002Parser;
	}

	/**
	 * @generated
	 */
	private IParser arcWeight_6001Parser;

	/**
	 * @generated
	 */
	private IParser getArcWeight_6001Parser() {
		if (arcWeight_6001Parser == null) {
			EAttribute[] features = new EAttribute[] { PetrinetPackage.eINSTANCE
					.getArc_Weight() };
			MessageFormatParser parser = new MessageFormatParser(features);
			arcWeight_6001Parser = parser;
		}
		return arcWeight_6001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case TransitionNameEditPart.VISUAL_ID:
			return getTransitionName_5001Parser();
		case PlaceNameTokensEditPart.VISUAL_ID:
			return getPlaceNameTokens_5002Parser();
		case ArcWeightEditPart.VISUAL_ID:
			return getArcWeight_6001Parser();
		}
		return null;
	}

	/**
	 * Utility method that consults ParserService
	 * @generated
	 */
	public static IParser getParser(IElementType type, EObject object,
			String parserHint) {
		return ParserService.getInstance().getParser(
				new HintAdapter(type, object, parserHint));
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(PetrinetVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(PetrinetVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (PetrinetElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * @generated
	 */
	private static class HintAdapter extends ParserHintAdapter {

		/**
		 * @generated
		 */
		private final IElementType elementType;

		/**
		 * @generated
		 */
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		 * @generated
		 */
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}

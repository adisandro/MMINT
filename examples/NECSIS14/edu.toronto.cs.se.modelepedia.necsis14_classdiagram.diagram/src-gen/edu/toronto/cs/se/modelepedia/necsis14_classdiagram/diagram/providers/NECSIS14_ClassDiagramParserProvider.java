/*
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.providers;

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

/**
 * @generated
 */
public class NECSIS14_ClassDiagramParserProvider extends AbstractProvider
		implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser className_5002Parser;

	/**
	 * @generated
	 */
	private IParser getClassName_5002Parser() {
		if (className_5002Parser == null) {
			EAttribute[] features = new EAttribute[] { edu.toronto.cs.se.modelepedia.necsis14_classdiagram.NECSIS14_ClassDiagramPackage.eINSTANCE
					.getNamedElement_Name() };
			edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.parsers.MessageFormatParser parser = new edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.parsers.MessageFormatParser(
					features);
			className_5002Parser = parser;
		}
		return className_5002Parser;
	}

	/**
	 * @generated
	 */
	private IParser attributeName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getAttributeName_5001Parser() {
		if (attributeName_5001Parser == null) {
			EAttribute[] features = new EAttribute[] { edu.toronto.cs.se.modelepedia.necsis14_classdiagram.NECSIS14_ClassDiagramPackage.eINSTANCE
					.getNamedElement_Name() };
			edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.parsers.MessageFormatParser parser = new edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.parsers.MessageFormatParser(
					features);
			attributeName_5001Parser = parser;
		}
		return attributeName_5001Parser;
	}

	/**
	 * @generated
	 */
	private IParser associationName_6001Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationName_6001Parser() {
		if (associationName_6001Parser == null) {
			EAttribute[] features = new EAttribute[] { edu.toronto.cs.se.modelepedia.necsis14_classdiagram.NECSIS14_ClassDiagramPackage.eINSTANCE
					.getNamedElement_Name() };
			edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.parsers.MessageFormatParser parser = new edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.parsers.MessageFormatParser(
					features);
			associationName_6001Parser = parser;
		}
		return associationName_6001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.ClassNameEditPart.VISUAL_ID:
			return getClassName_5002Parser();
		case edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.AttributeNameEditPart.VISUAL_ID:
			return getAttributeName_5001Parser();
		case edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.AssociationNameEditPart.VISUAL_ID:
			return getAssociationName_6001Parser();
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
			return getParser(edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramVisualIDRegistry
					.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramVisualIDRegistry
					.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.providers.NECSIS14_ClassDiagramElementTypes
					.getElement(hint) == null) {
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

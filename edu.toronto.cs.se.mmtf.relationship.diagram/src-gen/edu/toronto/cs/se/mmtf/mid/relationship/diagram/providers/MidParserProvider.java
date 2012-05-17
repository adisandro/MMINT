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
package edu.toronto.cs.se.mmtf.mid.relationship.diagram.providers;

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

import edu.toronto.cs.se.mmtf.mid.MidPackage;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.BinaryLinkNameTypeEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.LinkNameTypeEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelElementReferenceNameTypeEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelReferenceNameTypeEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.parsers.MessageFormatParser;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.part.MidVisualIDRegistry;

/**
 * @generated
 */
public class MidParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser modelReferenceNameType_5002Parser;

	/**
	 * @generated
	 */
	private IParser getModelReferenceNameType_5002Parser() {
		if (modelReferenceNameType_5002Parser == null) {
			EAttribute[] features = new EAttribute[] {
					RelationshipPackage.eINSTANCE
							.getTypedElementReference_Name(),
					RelationshipPackage.eINSTANCE
							.getTypedElementReference_Type() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0} : {1}"); //$NON-NLS-1$
			parser.setEditorPattern("{0} : {1}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			modelReferenceNameType_5002Parser = parser;
		}
		return modelReferenceNameType_5002Parser;
	}

	/**
	 * @generated
	 */
	private IParser linkNameType_5003Parser;

	/**
	 * @generated
	 */
	private IParser getLinkNameType_5003Parser() {
		if (linkNameType_5003Parser == null) {
			EAttribute[] features = new EAttribute[] {
					MidPackage.eINSTANCE.getTypedElement_Name(),
					MidPackage.eINSTANCE.getTypedElement_Type() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0} : {1}"); //$NON-NLS-1$
			parser.setEditorPattern("{0} : {1}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			linkNameType_5003Parser = parser;
		}
		return linkNameType_5003Parser;
	}

	/**
	 * @generated
	 */
	private IParser modelElementReferenceNameType_5001Parser;

	/**
	 * @generated
	 */
	private IParser getModelElementReferenceNameType_5001Parser() {
		if (modelElementReferenceNameType_5001Parser == null) {
			EAttribute[] features = new EAttribute[] {
					RelationshipPackage.eINSTANCE
							.getTypedElementReference_Name(),
					RelationshipPackage.eINSTANCE
							.getTypedElementReference_Type() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0} : {1}"); //$NON-NLS-1$
			parser.setEditorPattern("{0} : {1}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			modelElementReferenceNameType_5001Parser = parser;
		}
		return modelElementReferenceNameType_5001Parser;
	}

	/**
	 * @generated
	 */
	private IParser binaryLinkNameType_6001Parser;

	/**
	 * @generated
	 */
	private IParser getBinaryLinkNameType_6001Parser() {
		if (binaryLinkNameType_6001Parser == null) {
			EAttribute[] features = new EAttribute[] {
					MidPackage.eINSTANCE.getTypedElement_Name(),
					MidPackage.eINSTANCE.getTypedElement_Type() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0} : {1}"); //$NON-NLS-1$
			parser.setEditorPattern("{0} : {1}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			binaryLinkNameType_6001Parser = parser;
		}
		return binaryLinkNameType_6001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case ModelReferenceNameTypeEditPart.VISUAL_ID:
			return getModelReferenceNameType_5002Parser();
		case LinkNameTypeEditPart.VISUAL_ID:
			return getLinkNameType_5003Parser();
		case ModelElementReferenceNameTypeEditPart.VISUAL_ID:
			return getModelElementReferenceNameType_5001Parser();
		case BinaryLinkNameTypeEditPart.VISUAL_ID:
			return getBinaryLinkNameType_6001Parser();
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
			return getParser(MidVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(MidVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (MidElementTypes.getElement(hint) == null) {
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

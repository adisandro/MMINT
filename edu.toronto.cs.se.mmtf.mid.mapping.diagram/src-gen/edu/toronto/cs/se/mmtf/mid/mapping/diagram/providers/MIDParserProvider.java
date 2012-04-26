/*
 * Copyright (C) 2012 Marsha Chechik, Alessio Di Sandro, Rick Salay
 * 
 * This file is part of MMTF ver. 0.9.0.
 * 
 * MMTF is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * MMTF is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MMTF.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.toronto.cs.se.mmtf.mid.mapping.diagram.providers;

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
import edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.parts.BinaryMappingLinkNameTypeEditPart;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.parts.MappingLinkNameTypeEditPart;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.parts.ModelContainerNameEditPart;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.parts.ModelElementReferenceNameEditPart;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.parsers.MessageFormatParser;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.part.MIDVisualIDRegistry;

/**
 * @generated
 */
public class MIDParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser modelContainerNameType_5005Parser;

	/**
	 * @generated
	 */
	private IParser getModelContainerNameType_5005Parser() {
		if (modelContainerNameType_5005Parser == null) {
			EAttribute[] features = new EAttribute[] {
					MappingPackage.eINSTANCE.getModelContainer_Name(),
					MappingPackage.eINSTANCE.getModelContainer_Type() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0} : {1}"); //$NON-NLS-1$
			parser.setEditorPattern("{0} : {1}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			modelContainerNameType_5005Parser = parser;
		}
		return modelContainerNameType_5005Parser;
	}

	/**
	 * @generated
	 */
	private IParser mappingLinkNameType_5007Parser;

	/**
	 * @generated
	 */
	private IParser getMappingLinkNameType_5007Parser() {
		if (mappingLinkNameType_5007Parser == null) {
			EAttribute[] features = new EAttribute[] {
					MidPackage.eINSTANCE.getNamedElement_Name(),
					MidPackage.eINSTANCE.getNamedElement_Type() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0} : {1}"); //$NON-NLS-1$
			parser.setEditorPattern("{0} : {1}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			mappingLinkNameType_5007Parser = parser;
		}
		return mappingLinkNameType_5007Parser;
	}

	/**
	 * @generated
	 */
	private IParser modelElementReferenceNameType_5006Parser;

	/**
	 * @generated
	 */
	private IParser getModelElementReferenceNameType_5006Parser() {
		if (modelElementReferenceNameType_5006Parser == null) {
			EAttribute[] features = new EAttribute[] {
					MidPackage.eINSTANCE.getNamedElement_Name(),
					MidPackage.eINSTANCE.getNamedElement_Type() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0} : {1}"); //$NON-NLS-1$
			parser.setEditorPattern("{0} : {1}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			modelElementReferenceNameType_5006Parser = parser;
		}
		return modelElementReferenceNameType_5006Parser;
	}

	/**
	 * @generated
	 */
	private IParser binaryMappingLinkNameType_6002Parser;

	/**
	 * @generated
	 */
	private IParser getBinaryMappingLinkNameType_6002Parser() {
		if (binaryMappingLinkNameType_6002Parser == null) {
			EAttribute[] features = new EAttribute[] {
					MidPackage.eINSTANCE.getNamedElement_Name(),
					MidPackage.eINSTANCE.getNamedElement_Type() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0} : {1}"); //$NON-NLS-1$
			parser.setEditorPattern("{0} : {1}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			binaryMappingLinkNameType_6002Parser = parser;
		}
		return binaryMappingLinkNameType_6002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case ModelContainerNameEditPart.VISUAL_ID:
			return getModelContainerNameType_5005Parser();
		case MappingLinkNameTypeEditPart.VISUAL_ID:
			return getMappingLinkNameType_5007Parser();
		case ModelElementReferenceNameEditPart.VISUAL_ID:
			return getModelElementReferenceNameType_5006Parser();
		case BinaryMappingLinkNameTypeEditPart.VISUAL_ID:
			return getBinaryMappingLinkNameType_6002Parser();
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
			return getParser(MIDVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(MIDVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (MIDElementTypes.getElement(hint) == null) {
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

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
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.parts.BinaryMappingNameEditPart;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.parts.MappingNameEditPart;
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
	private IParser modelContainerName_5005Parser;

	/**
	 * @generated
	 */
	private IParser getModelContainerName_5005Parser() {
		if (modelContainerName_5005Parser == null) {
			EAttribute[] features = new EAttribute[] { MappingPackage.eINSTANCE
					.getModelContainer_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			modelContainerName_5005Parser = parser;
		}
		return modelContainerName_5005Parser;
	}

	/**
	 * @generated
	 */
	private IParser mappingName_5004Parser;

	/**
	 * @generated
	 */
	private IParser getMappingName_5004Parser() {
		if (mappingName_5004Parser == null) {
			EAttribute[] features = new EAttribute[] { MidPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			mappingName_5004Parser = parser;
		}
		return mappingName_5004Parser;
	}

	/**
	 * @generated
	 */
	private IParser modelElementReferenceName_5006Parser;

	/**
	 * @generated
	 */
	private IParser getModelElementReferenceName_5006Parser() {
		if (modelElementReferenceName_5006Parser == null) {
			EAttribute[] features = new EAttribute[] { MidPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			modelElementReferenceName_5006Parser = parser;
		}
		return modelElementReferenceName_5006Parser;
	}

	/**
	 * @generated
	 */
	private IParser binaryMappingName_6001Parser;

	/**
	 * @generated
	 */
	private IParser getBinaryMappingName_6001Parser() {
		if (binaryMappingName_6001Parser == null) {
			EAttribute[] features = new EAttribute[] { MidPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			binaryMappingName_6001Parser = parser;
		}
		return binaryMappingName_6001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case ModelContainerNameEditPart.VISUAL_ID:
			return getModelContainerName_5005Parser();
		case MappingNameEditPart.VISUAL_ID:
			return getMappingName_5004Parser();
		case ModelElementReferenceNameEditPart.VISUAL_ID:
			return getModelElementReferenceName_5006Parser();
		case BinaryMappingNameEditPart.VISUAL_ID:
			return getBinaryMappingName_6001Parser();
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

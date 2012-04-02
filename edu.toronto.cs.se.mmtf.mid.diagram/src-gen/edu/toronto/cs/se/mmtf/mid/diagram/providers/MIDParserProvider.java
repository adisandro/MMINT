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
package edu.toronto.cs.se.mmtf.mid.diagram.providers;

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
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.BinaryMappingReferenceNameEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.MappingReferenceNameEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelReferenceName2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelReferenceNameEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.parsers.MessageFormatParser;
import edu.toronto.cs.se.mmtf.mid.diagram.part.MIDVisualIDRegistry;

/**
 * @generated
 */
public class MIDParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser mappingReferenceName_5004Parser;

	/**
	 * @generated
	 */
	private IParser getMappingReferenceName_5004Parser() {
		if (mappingReferenceName_5004Parser == null) {
			EAttribute[] features = new EAttribute[] { MidPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			mappingReferenceName_5004Parser = parser;
		}
		return mappingReferenceName_5004Parser;
	}

	/**
	 * @generated
	 */
	private IParser modelReferenceName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getModelReferenceName_5002Parser() {
		if (modelReferenceName_5002Parser == null) {
			EAttribute[] features = new EAttribute[] { MidPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			modelReferenceName_5002Parser = parser;
		}
		return modelReferenceName_5002Parser;
	}

	/**
	 * @generated
	 */
	private IParser modelReferenceName_5003Parser;

	/**
	 * @generated
	 */
	private IParser getModelReferenceName_5003Parser() {
		if (modelReferenceName_5003Parser == null) {
			EAttribute[] features = new EAttribute[] { MidPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			modelReferenceName_5003Parser = parser;
		}
		return modelReferenceName_5003Parser;
	}

	/**
	 * @generated
	 */
	private IParser binaryMappingReferenceName_6001Parser;

	/**
	 * @generated
	 */
	private IParser getBinaryMappingReferenceName_6001Parser() {
		if (binaryMappingReferenceName_6001Parser == null) {
			EAttribute[] features = new EAttribute[] { MidPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			binaryMappingReferenceName_6001Parser = parser;
		}
		return binaryMappingReferenceName_6001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case MappingReferenceNameEditPart.VISUAL_ID:
			return getMappingReferenceName_5004Parser();
		case ModelReferenceNameEditPart.VISUAL_ID:
			return getModelReferenceName_5002Parser();
		case ModelReferenceName2EditPart.VISUAL_ID:
			return getModelReferenceName_5003Parser();
		case BinaryMappingReferenceNameEditPart.VISUAL_ID:
			return getBinaryMappingReferenceName_6001Parser();
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

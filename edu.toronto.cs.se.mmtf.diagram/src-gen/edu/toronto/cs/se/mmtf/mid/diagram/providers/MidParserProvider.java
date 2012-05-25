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
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.BinaryModelRelNameTypeEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelNameType2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelNameTypeEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelParameterName2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelParameterNameEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelRelNameType2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelRelNameTypeEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.OperatorNameEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.parsers.MessageFormatParser;
import edu.toronto.cs.se.mmtf.mid.diagram.part.MidVisualIDRegistry;
import edu.toronto.cs.se.mmtf.mid.operator.OperatorPackage;

/**
 * @generated
 */
public class MidParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser modelNameType_5001Parser;

	/**
	 * @generated
	 */
	private IParser getModelNameType_5001Parser() {
		if (modelNameType_5001Parser == null) {
			EAttribute[] features = new EAttribute[] {
					MidPackage.eINSTANCE.getTypedElement_Name(),
					MidPackage.eINSTANCE.getTypedElement_Type() };
			EAttribute[] editableFeatures = new EAttribute[] { MidPackage.eINSTANCE
					.getTypedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			parser.setViewPattern("{0} : {1}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			modelNameType_5001Parser = parser;
		}
		return modelNameType_5001Parser;
	}

	/**
	 * @generated
	 */
	private IParser modelNameType_5002Parser;

	/**
	 * @generated
	 */
	private IParser getModelNameType_5002Parser() {
		if (modelNameType_5002Parser == null) {
			EAttribute[] features = new EAttribute[] {
					MidPackage.eINSTANCE.getTypedElement_Name(),
					MidPackage.eINSTANCE.getTypedElement_Type() };
			EAttribute[] editableFeatures = new EAttribute[] { MidPackage.eINSTANCE
					.getTypedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			parser.setViewPattern("{0} : {1}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			modelNameType_5002Parser = parser;
		}
		return modelNameType_5002Parser;
	}

	/**
	 * @generated
	 */
	private IParser modelRelNameType_5003Parser;

	/**
	 * @generated
	 */
	private IParser getModelRelNameType_5003Parser() {
		if (modelRelNameType_5003Parser == null) {
			EAttribute[] features = new EAttribute[] {
					MidPackage.eINSTANCE.getTypedElement_Name(),
					MidPackage.eINSTANCE.getTypedElement_Type() };
			EAttribute[] editableFeatures = new EAttribute[] { MidPackage.eINSTANCE
					.getTypedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			parser.setViewPattern("{0} : {1}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			modelRelNameType_5003Parser = parser;
		}
		return modelRelNameType_5003Parser;
	}

	/**
	 * @generated
	 */
	private IParser modelRelNameType_5004Parser;

	/**
	 * @generated
	 */
	private IParser getModelRelNameType_5004Parser() {
		if (modelRelNameType_5004Parser == null) {
			EAttribute[] features = new EAttribute[] {
					MidPackage.eINSTANCE.getTypedElement_Name(),
					MidPackage.eINSTANCE.getTypedElement_Type() };
			EAttribute[] editableFeatures = new EAttribute[] { MidPackage.eINSTANCE
					.getTypedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			parser.setViewPattern("{0} : {1}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			modelRelNameType_5004Parser = parser;
		}
		return modelRelNameType_5004Parser;
	}

	/**
	 * @generated
	 */
	private IParser operatorName_5005Parser;

	/**
	 * @generated
	 */
	private IParser getOperatorName_5005Parser() {
		if (operatorName_5005Parser == null) {
			EAttribute[] features = new EAttribute[] { MidPackage.eINSTANCE
					.getTypedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			operatorName_5005Parser = parser;
		}
		return operatorName_5005Parser;
	}

	/**
	 * @generated
	 */
	private IParser binaryModelRelNameType_6001Parser;

	/**
	 * @generated
	 */
	private IParser getBinaryModelRelNameType_6001Parser() {
		if (binaryModelRelNameType_6001Parser == null) {
			EAttribute[] features = new EAttribute[] {
					MidPackage.eINSTANCE.getTypedElement_Name(),
					MidPackage.eINSTANCE.getTypedElement_Type() };
			EAttribute[] editableFeatures = new EAttribute[] { MidPackage.eINSTANCE
					.getTypedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			parser.setViewPattern("{0} : {1}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			binaryModelRelNameType_6001Parser = parser;
		}
		return binaryModelRelNameType_6001Parser;
	}

	/**
	 * @generated
	 */
	private IParser modelParameterName_6002Parser;

	/**
	 * @generated
	 */
	private IParser getModelParameterName_6002Parser() {
		if (modelParameterName_6002Parser == null) {
			EAttribute[] features = new EAttribute[] { OperatorPackage.eINSTANCE
					.getParameter_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			modelParameterName_6002Parser = parser;
		}
		return modelParameterName_6002Parser;
	}

	/**
	 * @generated
	 */
	private IParser modelParameterName_6003Parser;

	/**
	 * @generated
	 */
	private IParser getModelParameterName_6003Parser() {
		if (modelParameterName_6003Parser == null) {
			EAttribute[] features = new EAttribute[] { OperatorPackage.eINSTANCE
					.getParameter_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			modelParameterName_6003Parser = parser;
		}
		return modelParameterName_6003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case ModelNameTypeEditPart.VISUAL_ID:
			return getModelNameType_5001Parser();
		case ModelNameType2EditPart.VISUAL_ID:
			return getModelNameType_5002Parser();
		case ModelRelNameTypeEditPart.VISUAL_ID:
			return getModelRelNameType_5003Parser();
		case ModelRelNameType2EditPart.VISUAL_ID:
			return getModelRelNameType_5004Parser();
		case OperatorNameEditPart.VISUAL_ID:
			return getOperatorName_5005Parser();
		case BinaryModelRelNameTypeEditPart.VISUAL_ID:
			return getBinaryModelRelNameType_6001Parser();
		case ModelParameterNameEditPart.VISUAL_ID:
			return getModelParameterName_6002Parser();
		case ModelParameterName2EditPart.VISUAL_ID:
			return getModelParameterName_6003Parser();
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

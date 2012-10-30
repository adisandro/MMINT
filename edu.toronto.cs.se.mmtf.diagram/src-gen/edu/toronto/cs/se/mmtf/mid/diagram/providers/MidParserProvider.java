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

import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ParameterName2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ParameterNameEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.WrappingLabel2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.WrappingLabel3EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.WrappingLabel4EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.WrappingLabel5EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.WrappingLabel6EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.WrappingLabel7EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.WrappingLabel8EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.WrappingLabel9EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.WrappingLabelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.parsers.BinaryModelRelLabelExpressionLabelParser;
import edu.toronto.cs.se.mmtf.mid.diagram.parsers.BinaryModelRelSourceModelEndpointLabelExpressionLabelParser;
import edu.toronto.cs.se.mmtf.mid.diagram.parsers.BinaryModelRelTargetModelEndpointLabelExpressionLabelParser;
import edu.toronto.cs.se.mmtf.mid.diagram.parsers.MessageFormatParser;
import edu.toronto.cs.se.mmtf.mid.diagram.parsers.ModelEndpointLabelExpressionLabelParser;
import edu.toronto.cs.se.mmtf.mid.diagram.parsers.ModelLabelExpressionLabelParser;
import edu.toronto.cs.se.mmtf.mid.diagram.parsers.ModelRelLabelExpressionLabelParser;
import edu.toronto.cs.se.mmtf.mid.diagram.parsers.OperatorLabelExpressionLabelParser;
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
	private ModelLabelExpressionLabelParser modelLabel_5011Parser;

	/**
	 * @generated
	 */
	private IParser getModelLabel_5011Parser() {
		if (modelLabel_5011Parser == null) {
			modelLabel_5011Parser = new ModelLabelExpressionLabelParser();
		}
		return modelLabel_5011Parser;
	}

	/**
	 * @generated
	 */
	private ModelLabelExpressionLabelParser modelLabel_5012Parser;

	/**
	 * @generated
	 */
	private IParser getModelLabel_5012Parser() {
		if (modelLabel_5012Parser == null) {
			modelLabel_5012Parser = new ModelLabelExpressionLabelParser();
		}
		return modelLabel_5012Parser;
	}

	/**
	 * @generated
	 */
	private ModelRelLabelExpressionLabelParser modelRelLabel_5013Parser;

	/**
	 * @generated
	 */
	private IParser getModelRelLabel_5013Parser() {
		if (modelRelLabel_5013Parser == null) {
			modelRelLabel_5013Parser = new ModelRelLabelExpressionLabelParser();
		}
		return modelRelLabel_5013Parser;
	}

	/**
	 * @generated
	 */
	private ModelRelLabelExpressionLabelParser modelRelLabel_5014Parser;

	/**
	 * @generated
	 */
	private IParser getModelRelLabel_5014Parser() {
		if (modelRelLabel_5014Parser == null) {
			modelRelLabel_5014Parser = new ModelRelLabelExpressionLabelParser();
		}
		return modelRelLabel_5014Parser;
	}

	/**
	 * @generated
	 */
	private IParser getOperatorLabel_5015Parser() {
		return new OperatorLabelExpressionLabelParser();
	}

	/**
	 * @generated
	 */
	private ModelEndpointLabelExpressionLabelParser modelEndpointLabel_6011Parser;

	/**
	 * @generated
	 */
	private IParser getModelEndpointLabel_6011Parser() {
		if (modelEndpointLabel_6011Parser == null) {
			modelEndpointLabel_6011Parser = new ModelEndpointLabelExpressionLabelParser();
		}
		return modelEndpointLabel_6011Parser;
	}

	/**
	 * @generated
	 */
	private BinaryModelRelLabelExpressionLabelParser binaryModelRelLabel_6012Parser;

	/**
	 * @generated
	 */
	private IParser getBinaryModelRelLabel_6012Parser() {
		if (binaryModelRelLabel_6012Parser == null) {
			binaryModelRelLabel_6012Parser = new BinaryModelRelLabelExpressionLabelParser();
		}
		return binaryModelRelLabel_6012Parser;
	}

	/**
	 * @generated
	 */
	private BinaryModelRelSourceModelEndpointLabelExpressionLabelParser binaryModelRelLabel_6013Parser;

	/**
	 * @generated
	 */
	private IParser getBinaryModelRelLabel_6013Parser() {
		if (binaryModelRelLabel_6013Parser == null) {
			binaryModelRelLabel_6013Parser = new BinaryModelRelSourceModelEndpointLabelExpressionLabelParser();
		}
		return binaryModelRelLabel_6013Parser;
	}

	/**
	 * @generated
	 */
	private BinaryModelRelTargetModelEndpointLabelExpressionLabelParser binaryModelRelLabel_6014Parser;

	/**
	 * @generated
	 */
	private IParser getBinaryModelRelLabel_6014Parser() {
		if (binaryModelRelLabel_6014Parser == null) {
			binaryModelRelLabel_6014Parser = new BinaryModelRelTargetModelEndpointLabelExpressionLabelParser();
		}
		return binaryModelRelLabel_6014Parser;
	}

	/**
	 * @generated
	 */
	private IParser parameterName_6015Parser;

	/**
	 * @generated
	 */
	private IParser getParameterName_6015Parser() {
		if (parameterName_6015Parser == null) {
			EAttribute[] features = new EAttribute[] { OperatorPackage.eINSTANCE
					.getParameter_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { OperatorPackage.eINSTANCE
					.getParameter_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			parser.setViewPattern("(in) {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			parameterName_6015Parser = parser;
		}
		return parameterName_6015Parser;
	}

	/**
	 * @generated
	 */
	private IParser parameterName_6016Parser;

	/**
	 * @generated
	 */
	private IParser getParameterName_6016Parser() {
		if (parameterName_6016Parser == null) {
			EAttribute[] features = new EAttribute[] { OperatorPackage.eINSTANCE
					.getParameter_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { OperatorPackage.eINSTANCE
					.getParameter_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			parser.setViewPattern("(out) {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			parameterName_6016Parser = parser;
		}
		return parameterName_6016Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case WrappingLabelEditPart.VISUAL_ID:
			return getModelLabel_5011Parser();
		case WrappingLabel2EditPart.VISUAL_ID:
			return getModelLabel_5012Parser();
		case WrappingLabel3EditPart.VISUAL_ID:
			return getModelRelLabel_5013Parser();
		case WrappingLabel4EditPart.VISUAL_ID:
			return getModelRelLabel_5014Parser();
		case WrappingLabel5EditPart.VISUAL_ID:
			return getOperatorLabel_5015Parser();
		case WrappingLabel6EditPart.VISUAL_ID:
			return getModelEndpointLabel_6011Parser();
		case WrappingLabel7EditPart.VISUAL_ID:
			return getBinaryModelRelLabel_6012Parser();
		case WrappingLabel8EditPart.VISUAL_ID:
			return getBinaryModelRelLabel_6013Parser();
		case WrappingLabel9EditPart.VISUAL_ID:
			return getBinaryModelRelLabel_6014Parser();
		case ParameterNameEditPart.VISUAL_ID:
			return getParameterName_6015Parser();
		case ParameterName2EditPart.VISUAL_ID:
			return getParameterName_6016Parser();
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

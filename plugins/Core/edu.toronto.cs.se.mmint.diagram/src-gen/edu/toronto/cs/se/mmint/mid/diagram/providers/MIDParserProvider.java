/*
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.diagram.providers;

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

import edu.toronto.cs.se.mmint.mavo.library.MAVOElementLabelParser;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelEndpointName2EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelEndpointNameEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.WrappingLabel10EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.WrappingLabel11EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.WrappingLabel12EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.WrappingLabel13EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.WrappingLabel14EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.WrappingLabel15EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.WrappingLabel2EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.WrappingLabel3EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.WrappingLabel4EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.WrappingLabel5EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.WrappingLabel6EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.WrappingLabel7EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.WrappingLabel8EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.WrappingLabel9EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.WrappingLabelEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.library.BinaryModelRelSourceModelEndpointLabelParser;
import edu.toronto.cs.se.mmint.mid.diagram.library.BinaryModelRelTargetModelEndpointLabelParser;
import edu.toronto.cs.se.mmint.mid.diagram.library.ExtendibleElementEndpointLabelParser;
import edu.toronto.cs.se.mmint.mid.diagram.library.ExtendibleElementLabelParser;
import edu.toronto.cs.se.mmint.mid.diagram.parsers.MessageFormatParser;
import edu.toronto.cs.se.mmint.mid.diagram.part.MIDVisualIDRegistry;

/**
 * @generated
 */
public class MIDParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private ExtendibleElementLabelParser modelLabel_5011Parser;

	/**
	 * @generated
	 */
	private IParser getModelLabel_5011Parser() {
		if (modelLabel_5011Parser == null) {
			modelLabel_5011Parser = new ExtendibleElementLabelParser();
		}
		return modelLabel_5011Parser;
	}

	/**
	 * @generated
	 */
	private MAVOElementLabelParser modelLabel_5016Parser;

	/**
	 * @generated
	 */
	private IParser getModelLabel_5016Parser() {
		if (modelLabel_5016Parser == null) {
			modelLabel_5016Parser = new MAVOElementLabelParser();
		}
		return modelLabel_5016Parser;
	}

	/**
	 * @generated
	 */
	private ExtendibleElementLabelParser modelLabel_5012Parser;

	/**
	 * @generated
	 */
	private IParser getModelLabel_5012Parser() {
		if (modelLabel_5012Parser == null) {
			modelLabel_5012Parser = new ExtendibleElementLabelParser();
		}
		return modelLabel_5012Parser;
	}

	/**
	 * @generated
	 */
	private MAVOElementLabelParser modelLabel_5017Parser;

	/**
	 * @generated
	 */
	private IParser getModelLabel_5017Parser() {
		if (modelLabel_5017Parser == null) {
			modelLabel_5017Parser = new MAVOElementLabelParser();
		}
		return modelLabel_5017Parser;
	}

	/**
	 * @generated
	 */
	private ExtendibleElementLabelParser modelRelLabel_5013Parser;

	/**
	 * @generated
	 */
	private IParser getModelRelLabel_5013Parser() {
		if (modelRelLabel_5013Parser == null) {
			modelRelLabel_5013Parser = new ExtendibleElementLabelParser();
		}
		return modelRelLabel_5013Parser;
	}

	/**
	 * @generated
	 */
	private MAVOElementLabelParser modelRelLabel_5018Parser;

	/**
	 * @generated
	 */
	private IParser getModelRelLabel_5018Parser() {
		if (modelRelLabel_5018Parser == null) {
			modelRelLabel_5018Parser = new MAVOElementLabelParser();
		}
		return modelRelLabel_5018Parser;
	}

	/**
	 * @generated
	 */
	private ExtendibleElementLabelParser modelRelLabel_5014Parser;

	/**
	 * @generated
	 */
	private IParser getModelRelLabel_5014Parser() {
		if (modelRelLabel_5014Parser == null) {
			modelRelLabel_5014Parser = new ExtendibleElementLabelParser();
		}
		return modelRelLabel_5014Parser;
	}

	/**
	 * @generated
	 */
	private MAVOElementLabelParser modelRelLabel_5019Parser;

	/**
	 * @generated
	 */
	private IParser getModelRelLabel_5019Parser() {
		if (modelRelLabel_5019Parser == null) {
			modelRelLabel_5019Parser = new MAVOElementLabelParser();
		}
		return modelRelLabel_5019Parser;
	}

	/**
	 * @generated
	 */
	private ExtendibleElementLabelParser operatorLabel_5015Parser;

	/**
	 * @generated
	 */
	private IParser getOperatorLabel_5015Parser() {
		if (operatorLabel_5015Parser == null) {
			operatorLabel_5015Parser = new ExtendibleElementLabelParser();
		}
		return operatorLabel_5015Parser;
	}

	/**
	 * @generated
	 */
	private ExtendibleElementEndpointLabelParser modelEndpointLabel_6011Parser;

	/**
	 * @generated
	 */
	private IParser getModelEndpointLabel_6011Parser() {
		if (modelEndpointLabel_6011Parser == null) {
			modelEndpointLabel_6011Parser = new ExtendibleElementEndpointLabelParser();
		}
		return modelEndpointLabel_6011Parser;
	}

	/**
	 * @generated
	 */
	private MAVOElementLabelParser modelEndpointLabel_6017Parser;

	/**
	 * @generated
	 */
	private IParser getModelEndpointLabel_6017Parser() {
		if (modelEndpointLabel_6017Parser == null) {
			modelEndpointLabel_6017Parser = new MAVOElementLabelParser();
		}
		return modelEndpointLabel_6017Parser;
	}

	/**
	 * @generated
	 */
	private ExtendibleElementLabelParser binaryModelRelLabel_6012Parser;

	/**
	 * @generated
	 */
	private IParser getBinaryModelRelLabel_6012Parser() {
		if (binaryModelRelLabel_6012Parser == null) {
			binaryModelRelLabel_6012Parser = new ExtendibleElementLabelParser();
		}
		return binaryModelRelLabel_6012Parser;
	}

	/**
	 * @generated
	 */
	private MAVOElementLabelParser binaryModelRelLabel_6013Parser;

	/**
	 * @generated
	 */
	private IParser getBinaryModelRelLabel_6013Parser() {
		if (binaryModelRelLabel_6013Parser == null) {
			binaryModelRelLabel_6013Parser = new MAVOElementLabelParser();
		}
		return binaryModelRelLabel_6013Parser;
	}

	/**
	 * @generated
	 */
	private BinaryModelRelSourceModelEndpointLabelParser binaryModelRelLabel_6014Parser;

	/**
	 * @generated
	 */
	private IParser getBinaryModelRelLabel_6014Parser() {
		if (binaryModelRelLabel_6014Parser == null) {
			binaryModelRelLabel_6014Parser = new BinaryModelRelSourceModelEndpointLabelParser();
		}
		return binaryModelRelLabel_6014Parser;
	}

	/**
	 * @generated
	 */
	private BinaryModelRelTargetModelEndpointLabelParser binaryModelRelLabel_6018Parser;

	/**
	 * @generated
	 */
	private IParser getBinaryModelRelLabel_6018Parser() {
		if (binaryModelRelLabel_6018Parser == null) {
			binaryModelRelLabel_6018Parser = new BinaryModelRelTargetModelEndpointLabelParser();
		}
		return binaryModelRelLabel_6018Parser;
	}

	/**
	 * @generated
	 */
	private IParser modelEndpointName_6019Parser;

	/**
	 * @generated
	 */
	private IParser getModelEndpointName_6019Parser() {
		if (modelEndpointName_6019Parser == null) {
			EAttribute[] features = new EAttribute[] { MIDPackage.eINSTANCE.getExtendibleElement_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { MIDPackage.eINSTANCE.getExtendibleElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features, editableFeatures);
			parser.setViewPattern("(in) {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			modelEndpointName_6019Parser = parser;
		}
		return modelEndpointName_6019Parser;
	}

	/**
	 * @generated
	 */
	private IParser modelEndpointName_6020Parser;

	/**
	 * @generated
	 */
	private IParser getModelEndpointName_6020Parser() {
		if (modelEndpointName_6020Parser == null) {
			EAttribute[] features = new EAttribute[] { MIDPackage.eINSTANCE.getExtendibleElement_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { MIDPackage.eINSTANCE.getExtendibleElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features, editableFeatures);
			parser.setViewPattern("(out) {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			modelEndpointName_6020Parser = parser;
		}
		return modelEndpointName_6020Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
			case WrappingLabelEditPart.VISUAL_ID:
				return getModelLabel_5011Parser();
			case WrappingLabel10EditPart.VISUAL_ID:
				return getModelLabel_5016Parser();
			case WrappingLabel2EditPart.VISUAL_ID:
				return getModelLabel_5012Parser();
			case WrappingLabel11EditPart.VISUAL_ID:
				return getModelLabel_5017Parser();
			case WrappingLabel3EditPart.VISUAL_ID:
				return getModelRelLabel_5013Parser();
			case WrappingLabel12EditPart.VISUAL_ID:
				return getModelRelLabel_5018Parser();
			case WrappingLabel4EditPart.VISUAL_ID:
				return getModelRelLabel_5014Parser();
			case WrappingLabel13EditPart.VISUAL_ID:
				return getModelRelLabel_5019Parser();
			case WrappingLabel5EditPart.VISUAL_ID:
				return getOperatorLabel_5015Parser();
			case WrappingLabel6EditPart.VISUAL_ID:
				return getModelEndpointLabel_6011Parser();
			case WrappingLabel14EditPart.VISUAL_ID:
				return getModelEndpointLabel_6017Parser();
			case WrappingLabel7EditPart.VISUAL_ID:
				return getBinaryModelRelLabel_6012Parser();
			case WrappingLabel8EditPart.VISUAL_ID:
				return getBinaryModelRelLabel_6013Parser();
			case WrappingLabel9EditPart.VISUAL_ID:
				return getBinaryModelRelLabel_6014Parser();
			case WrappingLabel15EditPart.VISUAL_ID:
				return getBinaryModelRelLabel_6018Parser();
			case ModelEndpointNameEditPart.VISUAL_ID:
				return getModelEndpointName_6019Parser();
			case ModelEndpointName2EditPart.VISUAL_ID:
				return getModelEndpointName_6020Parser();
		}
		return null;
	}

	/**
	 * Utility method that consults ParserService
	 * @generated
	 */
	public static IParser getParser(IElementType type, EObject object, String parserHint) {
		return ParserService.getInstance().getParser(new HintAdapter(type, object, parserHint));
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

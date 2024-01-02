/*
 * Copyright (c) 2012-2024 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDDiagramCustomLabelParser;
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
	private ExtendibleElementLabelParser modelLabel_5001Parser;

	/**
	 * @generated
	 */
	private IParser getModelLabel_5001Parser() {
		if (modelLabel_5001Parser == null) {
			modelLabel_5001Parser = new ExtendibleElementLabelParser();
		}
		return modelLabel_5001Parser;
	}

	/**
	 * @generated
	 */
	private MIDDiagramCustomLabelParser modelLabel_5002Parser;

	/**
	 * @generated
	 */
	private IParser getModelLabel_5002Parser() {
		if (modelLabel_5002Parser == null) {
			modelLabel_5002Parser = new MIDDiagramCustomLabelParser();
		}
		return modelLabel_5002Parser;
	}

	/**
	 * @generated
	 */
	private ExtendibleElementLabelParser modelLabel_5003Parser;

	/**
	 * @generated
	 */
	private IParser getModelLabel_5003Parser() {
		if (modelLabel_5003Parser == null) {
			modelLabel_5003Parser = new ExtendibleElementLabelParser();
		}
		return modelLabel_5003Parser;
	}

	/**
	 * @generated
	 */
	private MIDDiagramCustomLabelParser modelLabel_5004Parser;

	/**
	 * @generated
	 */
	private IParser getModelLabel_5004Parser() {
		if (modelLabel_5004Parser == null) {
			modelLabel_5004Parser = new MIDDiagramCustomLabelParser();
		}
		return modelLabel_5004Parser;
	}

	/**
	 * @generated
	 */
	private ExtendibleElementLabelParser modelRelLabel_5005Parser;

	/**
	 * @generated
	 */
	private IParser getModelRelLabel_5005Parser() {
		if (modelRelLabel_5005Parser == null) {
			modelRelLabel_5005Parser = new ExtendibleElementLabelParser();
		}
		return modelRelLabel_5005Parser;
	}

	/**
	 * @generated
	 */
	private MIDDiagramCustomLabelParser modelRelLabel_5006Parser;

	/**
	 * @generated
	 */
	private IParser getModelRelLabel_5006Parser() {
		if (modelRelLabel_5006Parser == null) {
			modelRelLabel_5006Parser = new MIDDiagramCustomLabelParser();
		}
		return modelRelLabel_5006Parser;
	}

	/**
	 * @generated
	 */
	private ExtendibleElementLabelParser modelRelLabel_5007Parser;

	/**
	 * @generated
	 */
	private IParser getModelRelLabel_5007Parser() {
		if (modelRelLabel_5007Parser == null) {
			modelRelLabel_5007Parser = new ExtendibleElementLabelParser();
		}
		return modelRelLabel_5007Parser;
	}

	/**
	 * @generated
	 */
	private MIDDiagramCustomLabelParser modelRelLabel_5008Parser;

	/**
	 * @generated
	 */
	private IParser getModelRelLabel_5008Parser() {
		if (modelRelLabel_5008Parser == null) {
			modelRelLabel_5008Parser = new MIDDiagramCustomLabelParser();
		}
		return modelRelLabel_5008Parser;
	}

	/**
	 * @generated
	 */
	private ExtendibleElementLabelParser operatorLabel_5009Parser;

	/**
	 * @generated
	 */
	private IParser getOperatorLabel_5009Parser() {
		if (operatorLabel_5009Parser == null) {
			operatorLabel_5009Parser = new ExtendibleElementLabelParser();
		}
		return operatorLabel_5009Parser;
	}

	/**
	 * @generated
	 */
	private ExtendibleElementEndpointLabelParser modelEndpointLabel_6001Parser;

	/**
	 * @generated
	 */
	private IParser getModelEndpointLabel_6001Parser() {
		if (modelEndpointLabel_6001Parser == null) {
			modelEndpointLabel_6001Parser = new ExtendibleElementEndpointLabelParser();
		}
		return modelEndpointLabel_6001Parser;
	}

	/**
	 * @generated
	 */
	private MIDDiagramCustomLabelParser modelEndpointLabel_6002Parser;

	/**
	 * @generated
	 */
	private IParser getModelEndpointLabel_6002Parser() {
		if (modelEndpointLabel_6002Parser == null) {
			modelEndpointLabel_6002Parser = new MIDDiagramCustomLabelParser();
		}
		return modelEndpointLabel_6002Parser;
	}

	/**
	 * @generated
	 */
	private ExtendibleElementLabelParser binaryModelRelLabel_6003Parser;

	/**
	 * @generated
	 */
	private IParser getBinaryModelRelLabel_6003Parser() {
		if (binaryModelRelLabel_6003Parser == null) {
			binaryModelRelLabel_6003Parser = new ExtendibleElementLabelParser();
		}
		return binaryModelRelLabel_6003Parser;
	}

	/**
	 * @generated
	 */
	private MIDDiagramCustomLabelParser binaryModelRelLabel_6004Parser;

	/**
	 * @generated
	 */
	private IParser getBinaryModelRelLabel_6004Parser() {
		if (binaryModelRelLabel_6004Parser == null) {
			binaryModelRelLabel_6004Parser = new MIDDiagramCustomLabelParser();
		}
		return binaryModelRelLabel_6004Parser;
	}

	/**
	 * @generated
	 */
	private BinaryModelRelSourceModelEndpointLabelParser binaryModelRelLabel_6005Parser;

	/**
	 * @generated
	 */
	private IParser getBinaryModelRelLabel_6005Parser() {
		if (binaryModelRelLabel_6005Parser == null) {
			binaryModelRelLabel_6005Parser = new BinaryModelRelSourceModelEndpointLabelParser();
		}
		return binaryModelRelLabel_6005Parser;
	}

	/**
	 * @generated
	 */
	private BinaryModelRelTargetModelEndpointLabelParser binaryModelRelLabel_6006Parser;

	/**
	 * @generated
	 */
	private IParser getBinaryModelRelLabel_6006Parser() {
		if (binaryModelRelLabel_6006Parser == null) {
			binaryModelRelLabel_6006Parser = new BinaryModelRelTargetModelEndpointLabelParser();
		}
		return binaryModelRelLabel_6006Parser;
	}

	/**
	 * @generated
	 */
	private IParser modelEndpointName_6007Parser;

	/**
	 * @generated
	 */
	private IParser getModelEndpointName_6007Parser() {
		if (modelEndpointName_6007Parser == null) {
			EAttribute[] features = new EAttribute[] { MIDPackage.eINSTANCE.getExtendibleElement_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { MIDPackage.eINSTANCE.getExtendibleElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features, editableFeatures);
			parser.setViewPattern("(in) {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			modelEndpointName_6007Parser = parser;
		}
		return modelEndpointName_6007Parser;
	}

	/**
	 * @generated
	 */
	private IParser modelEndpointName_6008Parser;

	/**
	 * @generated
	 */
	private IParser getModelEndpointName_6008Parser() {
		if (modelEndpointName_6008Parser == null) {
			EAttribute[] features = new EAttribute[] { MIDPackage.eINSTANCE.getExtendibleElement_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { MIDPackage.eINSTANCE.getExtendibleElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features, editableFeatures);
			parser.setViewPattern("(out) {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			modelEndpointName_6008Parser = parser;
		}
		return modelEndpointName_6008Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
			case WrappingLabelEditPart.VISUAL_ID:
				return getModelLabel_5001Parser();
			case WrappingLabel2EditPart.VISUAL_ID:
				return getModelLabel_5002Parser();
			case WrappingLabel3EditPart.VISUAL_ID:
				return getModelLabel_5003Parser();
			case WrappingLabel4EditPart.VISUAL_ID:
				return getModelLabel_5004Parser();
			case WrappingLabel5EditPart.VISUAL_ID:
				return getModelRelLabel_5005Parser();
			case WrappingLabel6EditPart.VISUAL_ID:
				return getModelRelLabel_5006Parser();
			case WrappingLabel7EditPart.VISUAL_ID:
				return getModelRelLabel_5007Parser();
			case WrappingLabel8EditPart.VISUAL_ID:
				return getModelRelLabel_5008Parser();
			case WrappingLabel9EditPart.VISUAL_ID:
				return getOperatorLabel_5009Parser();
			case WrappingLabel10EditPart.VISUAL_ID:
				return getModelEndpointLabel_6001Parser();
			case WrappingLabel11EditPart.VISUAL_ID:
				return getModelEndpointLabel_6002Parser();
			case WrappingLabel12EditPart.VISUAL_ID:
				return getBinaryModelRelLabel_6003Parser();
			case WrappingLabel13EditPart.VISUAL_ID:
				return getBinaryModelRelLabel_6004Parser();
			case WrappingLabel14EditPart.VISUAL_ID:
				return getBinaryModelRelLabel_6005Parser();
			case WrappingLabel15EditPart.VISUAL_ID:
				return getBinaryModelRelLabel_6006Parser();
			case ModelEndpointNameEditPart.VISUAL_ID:
				return getModelEndpointName_6007Parser();
			case ModelEndpointName2EditPart.VISUAL_ID:
				return getModelEndpointName_6008Parser();
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

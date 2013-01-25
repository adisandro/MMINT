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

import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel10EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel11EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel12EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel13EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel14EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel15EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel2EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel3EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel4EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel5EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel6EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel7EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel8EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel9EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabelEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.parsers.BinaryLinkReferenceLabelExpressionLabelParser;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.parsers.BinaryLinkReferenceSourceModelElementEndpointReferenceLabelExpressionLabelParser;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.parsers.BinaryLinkReferenceSuperLabelExpressionLabelParser;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.parsers.BinaryLinkReferenceSuperSourceModelElementEndpointReferenceLabelExpressionLabelParser;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.parsers.BinaryLinkReferenceSuperTargetModelElementEndpointReferenceLabelExpressionLabelParser;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.parsers.BinaryLinkReferenceTargetModelElementEndpointReferenceLabelExpressionLabelParser;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.parsers.LinkReferenceLabelExpressionLabelParser;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.parsers.LinkReferenceSuperLabelExpressionLabelParser;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.parsers.ModelElementEndpointReferenceLabelExpressionLabelParser;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.parsers.ModelElementEndpointReferenceSuperLabelExpressionLabelParser;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.parsers.ModelElementReferenceLabelExpressionLabelParser;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.parsers.ModelElementReferenceSuperLabelExpressionLabelParser;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.parsers.ModelEndpointReferenceLabelExpressionLabelParser;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.parsers.ModelEndpointReferenceSuperLabelExpressionLabelParser;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.part.MidVisualIDRegistry;

/**
 * @generated
 */
public class MidParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private ModelEndpointReferenceLabelExpressionLabelParser modelEndpointReferenceLabel_5012Parser;

	/**
	 * @generated
	 */
	private IParser getModelEndpointReferenceLabel_5012Parser() {
		if (modelEndpointReferenceLabel_5012Parser == null) {
			modelEndpointReferenceLabel_5012Parser = new ModelEndpointReferenceLabelExpressionLabelParser();
		}
		return modelEndpointReferenceLabel_5012Parser;
	}

	/**
	 * @generated
	 */
	private LinkReferenceLabelExpressionLabelParser linkReferenceLabel_5013Parser;

	/**
	 * @generated
	 */
	private IParser getLinkReferenceLabel_5013Parser() {
		if (linkReferenceLabel_5013Parser == null) {
			linkReferenceLabel_5013Parser = new LinkReferenceLabelExpressionLabelParser();
		}
		return linkReferenceLabel_5013Parser;
	}

	/**
	 * @generated
	 */
	private LinkReferenceSuperLabelExpressionLabelParser linkReferenceLabel_5014Parser;

	/**
	 * @generated
	 */
	private IParser getLinkReferenceLabel_5014Parser() {
		if (linkReferenceLabel_5014Parser == null) {
			linkReferenceLabel_5014Parser = new LinkReferenceSuperLabelExpressionLabelParser();
		}
		return linkReferenceLabel_5014Parser;
	}

	/**
	 * @generated
	 */
	private ModelEndpointReferenceSuperLabelExpressionLabelParser modelEndpointReferenceLabel_5017Parser;

	/**
	 * @generated
	 */
	private IParser getModelEndpointReferenceLabel_5017Parser() {
		if (modelEndpointReferenceLabel_5017Parser == null) {
			modelEndpointReferenceLabel_5017Parser = new ModelEndpointReferenceSuperLabelExpressionLabelParser();
		}
		return modelEndpointReferenceLabel_5017Parser;
	}

	/**
	 * @generated
	 */
	private ModelElementReferenceLabelExpressionLabelParser modelElementReferenceLabel_5011Parser;

	/**
	 * @generated
	 */
	private IParser getModelElementReferenceLabel_5011Parser() {
		if (modelElementReferenceLabel_5011Parser == null) {
			modelElementReferenceLabel_5011Parser = new ModelElementReferenceLabelExpressionLabelParser();
		}
		return modelElementReferenceLabel_5011Parser;
	}

	/**
	 * @generated
	 */
	private ModelElementReferenceLabelExpressionLabelParser modelElementReferenceLabel_5015Parser;

	/**
	 * @generated
	 */
	private IParser getModelElementReferenceLabel_5015Parser() {
		if (modelElementReferenceLabel_5015Parser == null) {
			modelElementReferenceLabel_5015Parser = new ModelElementReferenceLabelExpressionLabelParser();
		}
		return modelElementReferenceLabel_5015Parser;
	}

	/**
	 * @generated
	 */
	private ModelElementReferenceSuperLabelExpressionLabelParser modelElementReferenceLabel_5016Parser;

	/**
	 * @generated
	 */
	private IParser getModelElementReferenceLabel_5016Parser() {
		if (modelElementReferenceLabel_5016Parser == null) {
			modelElementReferenceLabel_5016Parser = new ModelElementReferenceSuperLabelExpressionLabelParser();
		}
		return modelElementReferenceLabel_5016Parser;
	}

	/**
	 * @generated
	 */
	private ModelElementEndpointReferenceLabelExpressionLabelParser modelElementEndpointReferenceLabel_6007Parser;

	/**
	 * @generated
	 */
	private IParser getModelElementEndpointReferenceLabel_6007Parser() {
		if (modelElementEndpointReferenceLabel_6007Parser == null) {
			modelElementEndpointReferenceLabel_6007Parser = new ModelElementEndpointReferenceLabelExpressionLabelParser();
		}
		return modelElementEndpointReferenceLabel_6007Parser;
	}

	/**
	 * @generated
	 */
	private BinaryLinkReferenceLabelExpressionLabelParser binaryLinkReferenceLabel_6008Parser;

	/**
	 * @generated
	 */
	private IParser getBinaryLinkReferenceLabel_6008Parser() {
		if (binaryLinkReferenceLabel_6008Parser == null) {
			binaryLinkReferenceLabel_6008Parser = new BinaryLinkReferenceLabelExpressionLabelParser();
		}
		return binaryLinkReferenceLabel_6008Parser;
	}

	/**
	 * @generated
	 */
	private BinaryLinkReferenceSourceModelElementEndpointReferenceLabelExpressionLabelParser binaryLinkReferenceLabel_6009Parser;

	/**
	 * @generated
	 */
	private IParser getBinaryLinkReferenceLabel_6009Parser() {
		if (binaryLinkReferenceLabel_6009Parser == null) {
			binaryLinkReferenceLabel_6009Parser = new BinaryLinkReferenceSourceModelElementEndpointReferenceLabelExpressionLabelParser();
		}
		return binaryLinkReferenceLabel_6009Parser;
	}

	/**
	 * @generated
	 */
	private BinaryLinkReferenceTargetModelElementEndpointReferenceLabelExpressionLabelParser binaryLinkReferenceLabel_6010Parser;

	/**
	 * @generated
	 */
	private IParser getBinaryLinkReferenceLabel_6010Parser() {
		if (binaryLinkReferenceLabel_6010Parser == null) {
			binaryLinkReferenceLabel_6010Parser = new BinaryLinkReferenceTargetModelElementEndpointReferenceLabelExpressionLabelParser();
		}
		return binaryLinkReferenceLabel_6010Parser;
	}

	/**
	 * @generated
	 */
	private BinaryLinkReferenceSuperLabelExpressionLabelParser binaryLinkReferenceLabel_6011Parser;

	/**
	 * @generated
	 */
	private IParser getBinaryLinkReferenceLabel_6011Parser() {
		if (binaryLinkReferenceLabel_6011Parser == null) {
			binaryLinkReferenceLabel_6011Parser = new BinaryLinkReferenceSuperLabelExpressionLabelParser();
		}
		return binaryLinkReferenceLabel_6011Parser;
	}

	/**
	 * @generated
	 */
	private BinaryLinkReferenceSuperSourceModelElementEndpointReferenceLabelExpressionLabelParser binaryLinkReferenceLabel_6012Parser;

	/**
	 * @generated
	 */
	private IParser getBinaryLinkReferenceLabel_6012Parser() {
		if (binaryLinkReferenceLabel_6012Parser == null) {
			binaryLinkReferenceLabel_6012Parser = new BinaryLinkReferenceSuperSourceModelElementEndpointReferenceLabelExpressionLabelParser();
		}
		return binaryLinkReferenceLabel_6012Parser;
	}

	/**
	 * @generated
	 */
	private BinaryLinkReferenceSuperTargetModelElementEndpointReferenceLabelExpressionLabelParser binaryLinkReferenceLabel_6013Parser;

	/**
	 * @generated
	 */
	private IParser getBinaryLinkReferenceLabel_6013Parser() {
		if (binaryLinkReferenceLabel_6013Parser == null) {
			binaryLinkReferenceLabel_6013Parser = new BinaryLinkReferenceSuperTargetModelElementEndpointReferenceLabelExpressionLabelParser();
		}
		return binaryLinkReferenceLabel_6013Parser;
	}

	/**
	 * @generated
	 */
	private ModelElementEndpointReferenceSuperLabelExpressionLabelParser modelElementEndpointReferenceLabel_6014Parser;

	/**
	 * @generated
	 */
	private IParser getModelElementEndpointReferenceLabel_6014Parser() {
		if (modelElementEndpointReferenceLabel_6014Parser == null) {
			modelElementEndpointReferenceLabel_6014Parser = new ModelElementEndpointReferenceSuperLabelExpressionLabelParser();
		}
		return modelElementEndpointReferenceLabel_6014Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case WrappingLabelEditPart.VISUAL_ID:
			return getModelEndpointReferenceLabel_5012Parser();
		case WrappingLabel2EditPart.VISUAL_ID:
			return getLinkReferenceLabel_5013Parser();
		case WrappingLabel3EditPart.VISUAL_ID:
			return getLinkReferenceLabel_5014Parser();
		case WrappingLabel4EditPart.VISUAL_ID:
			return getModelEndpointReferenceLabel_5017Parser();
		case WrappingLabel5EditPart.VISUAL_ID:
			return getModelElementReferenceLabel_5011Parser();
		case WrappingLabel6EditPart.VISUAL_ID:
			return getModelElementReferenceLabel_5015Parser();
		case WrappingLabel7EditPart.VISUAL_ID:
			return getModelElementReferenceLabel_5016Parser();
		case WrappingLabel8EditPart.VISUAL_ID:
			return getModelElementEndpointReferenceLabel_6007Parser();
		case WrappingLabel9EditPart.VISUAL_ID:
			return getBinaryLinkReferenceLabel_6008Parser();
		case WrappingLabel10EditPart.VISUAL_ID:
			return getBinaryLinkReferenceLabel_6009Parser();
		case WrappingLabel11EditPart.VISUAL_ID:
			return getBinaryLinkReferenceLabel_6010Parser();
		case WrappingLabel12EditPart.VISUAL_ID:
			return getBinaryLinkReferenceLabel_6011Parser();
		case WrappingLabel13EditPart.VISUAL_ID:
			return getBinaryLinkReferenceLabel_6012Parser();
		case WrappingLabel14EditPart.VISUAL_ID:
			return getBinaryLinkReferenceLabel_6013Parser();
		case WrappingLabel15EditPart.VISUAL_ID:
			return getModelElementEndpointReferenceLabel_6014Parser();
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

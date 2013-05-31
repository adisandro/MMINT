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

import edu.toronto.cs.se.mmtf.mavo.library.MAVOElementReferenceLabelParser;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel10EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel11EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel12EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel13EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel14EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel15EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel16EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel17EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel18EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel19EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel20EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel21EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel22EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel23EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel24EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel25EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel26EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel2EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel3EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel4EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel5EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel6EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel7EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel8EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel9EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabelEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.library.BinaryLinkReferenceSourceModelElementEndpointReferenceLabelParser;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.library.BinaryLinkReferenceTargetModelElementEndpointReferenceLabelParser;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.library.ExtendibleElementEndpointReferenceLabelParser;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.library.ExtendibleElementReferenceLabelParser;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.part.MidVisualIDRegistry;

/**
 * @generated
 */
public class MidParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private ExtendibleElementEndpointReferenceLabelParser modelEndpointReferenceLabel_5012Parser;

	/**
	 * @generated
	 */
	private IParser getModelEndpointReferenceLabel_5012Parser() {
		if (modelEndpointReferenceLabel_5012Parser == null) {
			modelEndpointReferenceLabel_5012Parser = new ExtendibleElementEndpointReferenceLabelParser();
		}
		return modelEndpointReferenceLabel_5012Parser;
	}

	/**
	 * @generated
	 */
	private MAVOElementReferenceLabelParser modelEndpointReferenceLabel_5019Parser;

	/**
	 * @generated
	 */
	private IParser getModelEndpointReferenceLabel_5019Parser() {
		if (modelEndpointReferenceLabel_5019Parser == null) {
			modelEndpointReferenceLabel_5019Parser = new MAVOElementReferenceLabelParser();
		}
		return modelEndpointReferenceLabel_5019Parser;
	}

	/**
	 * @generated
	 */
	private ExtendibleElementReferenceLabelParser linkReferenceLabel_5013Parser;

	/**
	 * @generated
	 */
	private IParser getLinkReferenceLabel_5013Parser() {
		if (linkReferenceLabel_5013Parser == null) {
			linkReferenceLabel_5013Parser = new ExtendibleElementReferenceLabelParser();
		}
		return linkReferenceLabel_5013Parser;
	}

	/**
	 * @generated
	 */
	private MAVOElementReferenceLabelParser linkReferenceLabel_5020Parser;

	/**
	 * @generated
	 */
	private IParser getLinkReferenceLabel_5020Parser() {
		if (linkReferenceLabel_5020Parser == null) {
			linkReferenceLabel_5020Parser = new MAVOElementReferenceLabelParser();
		}
		return linkReferenceLabel_5020Parser;
	}

	/**
	 * @generated
	 */
	private ExtendibleElementReferenceLabelParser linkReferenceLabel_5014Parser;

	/**
	 * @generated
	 */
	private IParser getLinkReferenceLabel_5014Parser() {
		if (linkReferenceLabel_5014Parser == null) {
			linkReferenceLabel_5014Parser = new ExtendibleElementReferenceLabelParser();
		}
		return linkReferenceLabel_5014Parser;
	}

	/**
	 * @generated
	 */
	private MAVOElementReferenceLabelParser linkReferenceLabel_5021Parser;

	/**
	 * @generated
	 */
	private IParser getLinkReferenceLabel_5021Parser() {
		if (linkReferenceLabel_5021Parser == null) {
			linkReferenceLabel_5021Parser = new MAVOElementReferenceLabelParser();
		}
		return linkReferenceLabel_5021Parser;
	}

	/**
	 * @generated
	 */
	private ExtendibleElementEndpointReferenceLabelParser modelEndpointReferenceLabel_5017Parser;

	/**
	 * @generated
	 */
	private IParser getModelEndpointReferenceLabel_5017Parser() {
		if (modelEndpointReferenceLabel_5017Parser == null) {
			modelEndpointReferenceLabel_5017Parser = new ExtendibleElementEndpointReferenceLabelParser();
		}
		return modelEndpointReferenceLabel_5017Parser;
	}

	/**
	 * @generated
	 */
	private MAVOElementReferenceLabelParser modelEndpointReferenceLabel_5024Parser;

	/**
	 * @generated
	 */
	private IParser getModelEndpointReferenceLabel_5024Parser() {
		if (modelEndpointReferenceLabel_5024Parser == null) {
			modelEndpointReferenceLabel_5024Parser = new MAVOElementReferenceLabelParser();
		}
		return modelEndpointReferenceLabel_5024Parser;
	}

	/**
	 * @generated
	 */
	private ExtendibleElementReferenceLabelParser modelElementReferenceLabel_5011Parser;

	/**
	 * @generated
	 */
	private IParser getModelElementReferenceLabel_5011Parser() {
		if (modelElementReferenceLabel_5011Parser == null) {
			modelElementReferenceLabel_5011Parser = new ExtendibleElementReferenceLabelParser();
		}
		return modelElementReferenceLabel_5011Parser;
	}

	/**
	 * @generated
	 */
	private MAVOElementReferenceLabelParser modelElementReferenceLabel_5018Parser;

	/**
	 * @generated
	 */
	private IParser getModelElementReferenceLabel_5018Parser() {
		if (modelElementReferenceLabel_5018Parser == null) {
			modelElementReferenceLabel_5018Parser = new MAVOElementReferenceLabelParser();
		}
		return modelElementReferenceLabel_5018Parser;
	}

	/**
	 * @generated
	 */
	private ExtendibleElementReferenceLabelParser modelElementReferenceLabel_5015Parser;

	/**
	 * @generated
	 */
	private IParser getModelElementReferenceLabel_5015Parser() {
		if (modelElementReferenceLabel_5015Parser == null) {
			modelElementReferenceLabel_5015Parser = new ExtendibleElementReferenceLabelParser();
		}
		return modelElementReferenceLabel_5015Parser;
	}

	/**
	 * @generated
	 */
	private MAVOElementReferenceLabelParser modelElementReferenceLabel_5022Parser;

	/**
	 * @generated
	 */
	private IParser getModelElementReferenceLabel_5022Parser() {
		if (modelElementReferenceLabel_5022Parser == null) {
			modelElementReferenceLabel_5022Parser = new MAVOElementReferenceLabelParser();
		}
		return modelElementReferenceLabel_5022Parser;
	}

	/**
	 * @generated
	 */
	private ExtendibleElementReferenceLabelParser modelElementReferenceLabel_5016Parser;

	/**
	 * @generated
	 */
	private IParser getModelElementReferenceLabel_5016Parser() {
		if (modelElementReferenceLabel_5016Parser == null) {
			modelElementReferenceLabel_5016Parser = new ExtendibleElementReferenceLabelParser();
		}
		return modelElementReferenceLabel_5016Parser;
	}

	/**
	 * @generated
	 */
	private MAVOElementReferenceLabelParser modelElementReferenceLabel_5023Parser;

	/**
	 * @generated
	 */
	private IParser getModelElementReferenceLabel_5023Parser() {
		if (modelElementReferenceLabel_5023Parser == null) {
			modelElementReferenceLabel_5023Parser = new MAVOElementReferenceLabelParser();
		}
		return modelElementReferenceLabel_5023Parser;
	}

	/**
	 * @generated
	 */
	private ExtendibleElementEndpointReferenceLabelParser modelElementEndpointReferenceLabel_6007Parser;

	/**
	 * @generated
	 */
	private IParser getModelElementEndpointReferenceLabel_6007Parser() {
		if (modelElementEndpointReferenceLabel_6007Parser == null) {
			modelElementEndpointReferenceLabel_6007Parser = new ExtendibleElementEndpointReferenceLabelParser();
		}
		return modelElementEndpointReferenceLabel_6007Parser;
	}

	/**
	 * @generated
	 */
	private MAVOElementReferenceLabelParser modelElementEndpointReferenceLabel_6015Parser;

	/**
	 * @generated
	 */
	private IParser getModelElementEndpointReferenceLabel_6015Parser() {
		if (modelElementEndpointReferenceLabel_6015Parser == null) {
			modelElementEndpointReferenceLabel_6015Parser = new MAVOElementReferenceLabelParser();
		}
		return modelElementEndpointReferenceLabel_6015Parser;
	}

	/**
	 * @generated
	 */
	private ExtendibleElementReferenceLabelParser binaryLinkReferenceLabel_6008Parser;

	/**
	 * @generated
	 */
	private IParser getBinaryLinkReferenceLabel_6008Parser() {
		if (binaryLinkReferenceLabel_6008Parser == null) {
			binaryLinkReferenceLabel_6008Parser = new ExtendibleElementReferenceLabelParser();
		}
		return binaryLinkReferenceLabel_6008Parser;
	}

	/**
	 * @generated
	 */
	private MAVOElementReferenceLabelParser binaryLinkReferenceLabel_6009Parser;

	/**
	 * @generated
	 */
	private IParser getBinaryLinkReferenceLabel_6009Parser() {
		if (binaryLinkReferenceLabel_6009Parser == null) {
			binaryLinkReferenceLabel_6009Parser = new MAVOElementReferenceLabelParser();
		}
		return binaryLinkReferenceLabel_6009Parser;
	}

	/**
	 * @generated
	 */
	private BinaryLinkReferenceSourceModelElementEndpointReferenceLabelParser binaryLinkReferenceLabel_6010Parser;

	/**
	 * @generated
	 */
	private IParser getBinaryLinkReferenceLabel_6010Parser() {
		if (binaryLinkReferenceLabel_6010Parser == null) {
			binaryLinkReferenceLabel_6010Parser = new BinaryLinkReferenceSourceModelElementEndpointReferenceLabelParser();
		}
		return binaryLinkReferenceLabel_6010Parser;
	}

	/**
	 * @generated
	 */
	private BinaryLinkReferenceTargetModelElementEndpointReferenceLabelParser binaryLinkReferenceLabel_6016Parser;

	/**
	 * @generated
	 */
	private IParser getBinaryLinkReferenceLabel_6016Parser() {
		if (binaryLinkReferenceLabel_6016Parser == null) {
			binaryLinkReferenceLabel_6016Parser = new BinaryLinkReferenceTargetModelElementEndpointReferenceLabelParser();
		}
		return binaryLinkReferenceLabel_6016Parser;
	}

	/**
	 * @generated
	 */
	private ExtendibleElementReferenceLabelParser binaryLinkReferenceLabel_6011Parser;

	/**
	 * @generated
	 */
	private IParser getBinaryLinkReferenceLabel_6011Parser() {
		if (binaryLinkReferenceLabel_6011Parser == null) {
			binaryLinkReferenceLabel_6011Parser = new ExtendibleElementReferenceLabelParser();
		}
		return binaryLinkReferenceLabel_6011Parser;
	}

	/**
	 * @generated
	 */
	private MAVOElementReferenceLabelParser binaryLinkReferenceLabel_6012Parser;

	/**
	 * @generated
	 */
	private IParser getBinaryLinkReferenceLabel_6012Parser() {
		if (binaryLinkReferenceLabel_6012Parser == null) {
			binaryLinkReferenceLabel_6012Parser = new MAVOElementReferenceLabelParser();
		}
		return binaryLinkReferenceLabel_6012Parser;
	}

	/**
	 * @generated
	 */
	private BinaryLinkReferenceSourceModelElementEndpointReferenceLabelParser binaryLinkReferenceLabel_6013Parser;

	/**
	 * @generated
	 */
	private IParser getBinaryLinkReferenceLabel_6013Parser() {
		if (binaryLinkReferenceLabel_6013Parser == null) {
			binaryLinkReferenceLabel_6013Parser = new BinaryLinkReferenceSourceModelElementEndpointReferenceLabelParser();
		}
		return binaryLinkReferenceLabel_6013Parser;
	}

	/**
	 * @generated
	 */
	private BinaryLinkReferenceTargetModelElementEndpointReferenceLabelParser binaryLinkReferenceLabel_6017Parser;

	/**
	 * @generated
	 */
	private IParser getBinaryLinkReferenceLabel_6017Parser() {
		if (binaryLinkReferenceLabel_6017Parser == null) {
			binaryLinkReferenceLabel_6017Parser = new BinaryLinkReferenceTargetModelElementEndpointReferenceLabelParser();
		}
		return binaryLinkReferenceLabel_6017Parser;
	}

	/**
	 * @generated
	 */
	private ExtendibleElementEndpointReferenceLabelParser modelElementEndpointReferenceLabel_6014Parser;

	/**
	 * @generated
	 */
	private IParser getModelElementEndpointReferenceLabel_6014Parser() {
		if (modelElementEndpointReferenceLabel_6014Parser == null) {
			modelElementEndpointReferenceLabel_6014Parser = new ExtendibleElementEndpointReferenceLabelParser();
		}
		return modelElementEndpointReferenceLabel_6014Parser;
	}

	/**
	 * @generated
	 */
	private MAVOElementReferenceLabelParser modelElementEndpointReferenceLabel_6018Parser;

	/**
	 * @generated
	 */
	private IParser getModelElementEndpointReferenceLabel_6018Parser() {
		if (modelElementEndpointReferenceLabel_6018Parser == null) {
			modelElementEndpointReferenceLabel_6018Parser = new MAVOElementReferenceLabelParser();
		}
		return modelElementEndpointReferenceLabel_6018Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case WrappingLabelEditPart.VISUAL_ID:
			return getModelEndpointReferenceLabel_5012Parser();
		case WrappingLabel16EditPart.VISUAL_ID:
			return getModelEndpointReferenceLabel_5019Parser();
		case WrappingLabel2EditPart.VISUAL_ID:
			return getLinkReferenceLabel_5013Parser();
		case WrappingLabel17EditPart.VISUAL_ID:
			return getLinkReferenceLabel_5020Parser();
		case WrappingLabel3EditPart.VISUAL_ID:
			return getLinkReferenceLabel_5014Parser();
		case WrappingLabel18EditPart.VISUAL_ID:
			return getLinkReferenceLabel_5021Parser();
		case WrappingLabel4EditPart.VISUAL_ID:
			return getModelEndpointReferenceLabel_5017Parser();
		case WrappingLabel19EditPart.VISUAL_ID:
			return getModelEndpointReferenceLabel_5024Parser();
		case WrappingLabel5EditPart.VISUAL_ID:
			return getModelElementReferenceLabel_5011Parser();
		case WrappingLabel20EditPart.VISUAL_ID:
			return getModelElementReferenceLabel_5018Parser();
		case WrappingLabel6EditPart.VISUAL_ID:
			return getModelElementReferenceLabel_5015Parser();
		case WrappingLabel21EditPart.VISUAL_ID:
			return getModelElementReferenceLabel_5022Parser();
		case WrappingLabel7EditPart.VISUAL_ID:
			return getModelElementReferenceLabel_5016Parser();
		case WrappingLabel22EditPart.VISUAL_ID:
			return getModelElementReferenceLabel_5023Parser();
		case WrappingLabel8EditPart.VISUAL_ID:
			return getModelElementEndpointReferenceLabel_6007Parser();
		case WrappingLabel23EditPart.VISUAL_ID:
			return getModelElementEndpointReferenceLabel_6015Parser();
		case WrappingLabel9EditPart.VISUAL_ID:
			return getBinaryLinkReferenceLabel_6008Parser();
		case WrappingLabel10EditPart.VISUAL_ID:
			return getBinaryLinkReferenceLabel_6009Parser();
		case WrappingLabel11EditPart.VISUAL_ID:
			return getBinaryLinkReferenceLabel_6010Parser();
		case WrappingLabel24EditPart.VISUAL_ID:
			return getBinaryLinkReferenceLabel_6016Parser();
		case WrappingLabel12EditPart.VISUAL_ID:
			return getBinaryLinkReferenceLabel_6011Parser();
		case WrappingLabel13EditPart.VISUAL_ID:
			return getBinaryLinkReferenceLabel_6012Parser();
		case WrappingLabel14EditPart.VISUAL_ID:
			return getBinaryLinkReferenceLabel_6013Parser();
		case WrappingLabel25EditPart.VISUAL_ID:
			return getBinaryLinkReferenceLabel_6017Parser();
		case WrappingLabel15EditPart.VISUAL_ID:
			return getModelElementEndpointReferenceLabel_6014Parser();
		case WrappingLabel26EditPart.VISUAL_ID:
			return getModelElementEndpointReferenceLabel_6018Parser();
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

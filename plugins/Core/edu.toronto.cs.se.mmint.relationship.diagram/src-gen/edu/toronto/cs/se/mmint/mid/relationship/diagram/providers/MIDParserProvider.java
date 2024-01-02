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
package edu.toronto.cs.se.mmint.mid.relationship.diagram.providers;

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

import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel10EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel11EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel12EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel13EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel14EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel15EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel16EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel17EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel18EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel19EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel20EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel21EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel22EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel23EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel24EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel25EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel26EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel2EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel3EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel4EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel5EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel6EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel7EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel8EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabel9EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.WrappingLabelEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.library.BinaryMappingReferenceSourceModelElementEndpointReferenceLabelParser;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.library.BinaryMappingReferenceTargetModelElementEndpointReferenceLabelParser;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.library.ExtendibleElementEndpointReferenceLabelParser;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.library.ExtendibleElementReferenceLabelParser;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.library.RelationshipDiagramCustomLabelParser;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.part.MIDVisualIDRegistry;

/**
 * @generated
 */
public class MIDParserProvider extends AbstractProvider implements IParserProvider {

	/**
	* @generated
	*/
	private ExtendibleElementEndpointReferenceLabelParser modelEndpointReferenceLabel_5003Parser;

	/**
	* @generated
	*/
	private IParser getModelEndpointReferenceLabel_5003Parser() {
		if (modelEndpointReferenceLabel_5003Parser == null) {
			modelEndpointReferenceLabel_5003Parser = new ExtendibleElementEndpointReferenceLabelParser();
		}
		return modelEndpointReferenceLabel_5003Parser;
	}

	/**
	* @generated
	*/
	private RelationshipDiagramCustomLabelParser modelEndpointReferenceLabel_5004Parser;

	/**
	* @generated
	*/
	private IParser getModelEndpointReferenceLabel_5004Parser() {
		if (modelEndpointReferenceLabel_5004Parser == null) {
			modelEndpointReferenceLabel_5004Parser = new RelationshipDiagramCustomLabelParser();
		}
		return modelEndpointReferenceLabel_5004Parser;
	}

	/**
	* @generated
	*/
	private ExtendibleElementReferenceLabelParser mappingReferenceLabel_5005Parser;

	/**
	* @generated
	*/
	private IParser getMappingReferenceLabel_5005Parser() {
		if (mappingReferenceLabel_5005Parser == null) {
			mappingReferenceLabel_5005Parser = new ExtendibleElementReferenceLabelParser();
		}
		return mappingReferenceLabel_5005Parser;
	}

	/**
	* @generated
	*/
	private RelationshipDiagramCustomLabelParser mappingReferenceLabel_5006Parser;

	/**
	* @generated
	*/
	private IParser getMappingReferenceLabel_5006Parser() {
		if (mappingReferenceLabel_5006Parser == null) {
			mappingReferenceLabel_5006Parser = new RelationshipDiagramCustomLabelParser();
		}
		return mappingReferenceLabel_5006Parser;
	}

	/**
	* @generated
	*/
	private ExtendibleElementReferenceLabelParser mappingReferenceLabel_5007Parser;

	/**
	* @generated
	*/
	private IParser getMappingReferenceLabel_5007Parser() {
		if (mappingReferenceLabel_5007Parser == null) {
			mappingReferenceLabel_5007Parser = new ExtendibleElementReferenceLabelParser();
		}
		return mappingReferenceLabel_5007Parser;
	}

	/**
	* @generated
	*/
	private RelationshipDiagramCustomLabelParser mappingReferenceLabel_5008Parser;

	/**
	* @generated
	*/
	private IParser getMappingReferenceLabel_5008Parser() {
		if (mappingReferenceLabel_5008Parser == null) {
			mappingReferenceLabel_5008Parser = new RelationshipDiagramCustomLabelParser();
		}
		return mappingReferenceLabel_5008Parser;
	}

	/**
	* @generated
	*/
	private ExtendibleElementEndpointReferenceLabelParser modelEndpointReferenceLabel_5013Parser;

	/**
	* @generated
	*/
	private IParser getModelEndpointReferenceLabel_5013Parser() {
		if (modelEndpointReferenceLabel_5013Parser == null) {
			modelEndpointReferenceLabel_5013Parser = new ExtendibleElementEndpointReferenceLabelParser();
		}
		return modelEndpointReferenceLabel_5013Parser;
	}

	/**
	* @generated
	*/
	private RelationshipDiagramCustomLabelParser modelEndpointReferenceLabel_5014Parser;

	/**
	* @generated
	*/
	private IParser getModelEndpointReferenceLabel_5014Parser() {
		if (modelEndpointReferenceLabel_5014Parser == null) {
			modelEndpointReferenceLabel_5014Parser = new RelationshipDiagramCustomLabelParser();
		}
		return modelEndpointReferenceLabel_5014Parser;
	}

	/**
	* @generated
	*/
	private ExtendibleElementReferenceLabelParser modelElementReferenceLabel_5001Parser;

	/**
	* @generated
	*/
	private IParser getModelElementReferenceLabel_5001Parser() {
		if (modelElementReferenceLabel_5001Parser == null) {
			modelElementReferenceLabel_5001Parser = new ExtendibleElementReferenceLabelParser();
		}
		return modelElementReferenceLabel_5001Parser;
	}

	/**
	* @generated
	*/
	private RelationshipDiagramCustomLabelParser modelElementReferenceLabel_5002Parser;

	/**
	* @generated
	*/
	private IParser getModelElementReferenceLabel_5002Parser() {
		if (modelElementReferenceLabel_5002Parser == null) {
			modelElementReferenceLabel_5002Parser = new RelationshipDiagramCustomLabelParser();
		}
		return modelElementReferenceLabel_5002Parser;
	}

	/**
	* @generated
	*/
	private ExtendibleElementReferenceLabelParser modelElementReferenceLabel_5009Parser;

	/**
	* @generated
	*/
	private IParser getModelElementReferenceLabel_5009Parser() {
		if (modelElementReferenceLabel_5009Parser == null) {
			modelElementReferenceLabel_5009Parser = new ExtendibleElementReferenceLabelParser();
		}
		return modelElementReferenceLabel_5009Parser;
	}

	/**
	* @generated
	*/
	private RelationshipDiagramCustomLabelParser modelElementReferenceLabel_5010Parser;

	/**
	* @generated
	*/
	private IParser getModelElementReferenceLabel_5010Parser() {
		if (modelElementReferenceLabel_5010Parser == null) {
			modelElementReferenceLabel_5010Parser = new RelationshipDiagramCustomLabelParser();
		}
		return modelElementReferenceLabel_5010Parser;
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
	private RelationshipDiagramCustomLabelParser modelElementReferenceLabel_5012Parser;

	/**
	* @generated
	*/
	private IParser getModelElementReferenceLabel_5012Parser() {
		if (modelElementReferenceLabel_5012Parser == null) {
			modelElementReferenceLabel_5012Parser = new RelationshipDiagramCustomLabelParser();
		}
		return modelElementReferenceLabel_5012Parser;
	}

	/**
	* @generated
	*/
	private ExtendibleElementEndpointReferenceLabelParser modelElementEndpointReferenceLabel_6001Parser;

	/**
	* @generated
	*/
	private IParser getModelElementEndpointReferenceLabel_6001Parser() {
		if (modelElementEndpointReferenceLabel_6001Parser == null) {
			modelElementEndpointReferenceLabel_6001Parser = new ExtendibleElementEndpointReferenceLabelParser();
		}
		return modelElementEndpointReferenceLabel_6001Parser;
	}

	/**
	* @generated
	*/
	private RelationshipDiagramCustomLabelParser modelElementEndpointReferenceLabel_6002Parser;

	/**
	* @generated
	*/
	private IParser getModelElementEndpointReferenceLabel_6002Parser() {
		if (modelElementEndpointReferenceLabel_6002Parser == null) {
			modelElementEndpointReferenceLabel_6002Parser = new RelationshipDiagramCustomLabelParser();
		}
		return modelElementEndpointReferenceLabel_6002Parser;
	}

	/**
	* @generated
	*/
	private ExtendibleElementReferenceLabelParser binaryMappingReferenceLabel_6003Parser;

	/**
	* @generated
	*/
	private IParser getBinaryMappingReferenceLabel_6003Parser() {
		if (binaryMappingReferenceLabel_6003Parser == null) {
			binaryMappingReferenceLabel_6003Parser = new ExtendibleElementReferenceLabelParser();
		}
		return binaryMappingReferenceLabel_6003Parser;
	}

	/**
	* @generated
	*/
	private RelationshipDiagramCustomLabelParser binaryMappingReferenceLabel_6004Parser;

	/**
	* @generated
	*/
	private IParser getBinaryMappingReferenceLabel_6004Parser() {
		if (binaryMappingReferenceLabel_6004Parser == null) {
			binaryMappingReferenceLabel_6004Parser = new RelationshipDiagramCustomLabelParser();
		}
		return binaryMappingReferenceLabel_6004Parser;
	}

	/**
	* @generated
	*/
	private BinaryMappingReferenceSourceModelElementEndpointReferenceLabelParser binaryMappingReferenceLabel_6005Parser;

	/**
	* @generated
	*/
	private IParser getBinaryMappingReferenceLabel_6005Parser() {
		if (binaryMappingReferenceLabel_6005Parser == null) {
			binaryMappingReferenceLabel_6005Parser = new BinaryMappingReferenceSourceModelElementEndpointReferenceLabelParser();
		}
		return binaryMappingReferenceLabel_6005Parser;
	}

	/**
	* @generated
	*/
	private BinaryMappingReferenceTargetModelElementEndpointReferenceLabelParser binaryMappingReferenceLabel_6006Parser;

	/**
	* @generated
	*/
	private IParser getBinaryMappingReferenceLabel_6006Parser() {
		if (binaryMappingReferenceLabel_6006Parser == null) {
			binaryMappingReferenceLabel_6006Parser = new BinaryMappingReferenceTargetModelElementEndpointReferenceLabelParser();
		}
		return binaryMappingReferenceLabel_6006Parser;
	}

	/**
	* @generated
	*/
	private ExtendibleElementReferenceLabelParser binaryMappingReferenceLabel_6007Parser;

	/**
	* @generated
	*/
	private IParser getBinaryMappingReferenceLabel_6007Parser() {
		if (binaryMappingReferenceLabel_6007Parser == null) {
			binaryMappingReferenceLabel_6007Parser = new ExtendibleElementReferenceLabelParser();
		}
		return binaryMappingReferenceLabel_6007Parser;
	}

	/**
	* @generated
	*/
	private RelationshipDiagramCustomLabelParser binaryMappingReferenceLabel_6008Parser;

	/**
	* @generated
	*/
	private IParser getBinaryMappingReferenceLabel_6008Parser() {
		if (binaryMappingReferenceLabel_6008Parser == null) {
			binaryMappingReferenceLabel_6008Parser = new RelationshipDiagramCustomLabelParser();
		}
		return binaryMappingReferenceLabel_6008Parser;
	}

	/**
	* @generated
	*/
	private BinaryMappingReferenceSourceModelElementEndpointReferenceLabelParser binaryMappingReferenceLabel_6009Parser;

	/**
	* @generated
	*/
	private IParser getBinaryMappingReferenceLabel_6009Parser() {
		if (binaryMappingReferenceLabel_6009Parser == null) {
			binaryMappingReferenceLabel_6009Parser = new BinaryMappingReferenceSourceModelElementEndpointReferenceLabelParser();
		}
		return binaryMappingReferenceLabel_6009Parser;
	}

	/**
	* @generated
	*/
	private BinaryMappingReferenceTargetModelElementEndpointReferenceLabelParser binaryMappingReferenceLabel_6010Parser;

	/**
	* @generated
	*/
	private IParser getBinaryMappingReferenceLabel_6010Parser() {
		if (binaryMappingReferenceLabel_6010Parser == null) {
			binaryMappingReferenceLabel_6010Parser = new BinaryMappingReferenceTargetModelElementEndpointReferenceLabelParser();
		}
		return binaryMappingReferenceLabel_6010Parser;
	}

	/**
	* @generated
	*/
	private ExtendibleElementEndpointReferenceLabelParser modelElementEndpointReferenceLabel_6011Parser;

	/**
	* @generated
	*/
	private IParser getModelElementEndpointReferenceLabel_6011Parser() {
		if (modelElementEndpointReferenceLabel_6011Parser == null) {
			modelElementEndpointReferenceLabel_6011Parser = new ExtendibleElementEndpointReferenceLabelParser();
		}
		return modelElementEndpointReferenceLabel_6011Parser;
	}

	/**
	* @generated
	*/
	private RelationshipDiagramCustomLabelParser modelElementEndpointReferenceLabel_6012Parser;

	/**
	* @generated
	*/
	private IParser getModelElementEndpointReferenceLabel_6012Parser() {
		if (modelElementEndpointReferenceLabel_6012Parser == null) {
			modelElementEndpointReferenceLabel_6012Parser = new RelationshipDiagramCustomLabelParser();
		}
		return modelElementEndpointReferenceLabel_6012Parser;
	}

	/**
	* @generated
	*/
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case WrappingLabelEditPart.VISUAL_ID:
			return getModelEndpointReferenceLabel_5003Parser();
		case WrappingLabel2EditPart.VISUAL_ID:
			return getModelEndpointReferenceLabel_5004Parser();
		case WrappingLabel3EditPart.VISUAL_ID:
			return getMappingReferenceLabel_5005Parser();
		case WrappingLabel4EditPart.VISUAL_ID:
			return getMappingReferenceLabel_5006Parser();
		case WrappingLabel5EditPart.VISUAL_ID:
			return getMappingReferenceLabel_5007Parser();
		case WrappingLabel6EditPart.VISUAL_ID:
			return getMappingReferenceLabel_5008Parser();
		case WrappingLabel7EditPart.VISUAL_ID:
			return getModelEndpointReferenceLabel_5013Parser();
		case WrappingLabel8EditPart.VISUAL_ID:
			return getModelEndpointReferenceLabel_5014Parser();
		case WrappingLabel9EditPart.VISUAL_ID:
			return getModelElementReferenceLabel_5001Parser();
		case WrappingLabel10EditPart.VISUAL_ID:
			return getModelElementReferenceLabel_5002Parser();
		case WrappingLabel11EditPart.VISUAL_ID:
			return getModelElementReferenceLabel_5009Parser();
		case WrappingLabel12EditPart.VISUAL_ID:
			return getModelElementReferenceLabel_5010Parser();
		case WrappingLabel13EditPart.VISUAL_ID:
			return getModelElementReferenceLabel_5011Parser();
		case WrappingLabel14EditPart.VISUAL_ID:
			return getModelElementReferenceLabel_5012Parser();
		case WrappingLabel15EditPart.VISUAL_ID:
			return getModelElementEndpointReferenceLabel_6001Parser();
		case WrappingLabel16EditPart.VISUAL_ID:
			return getModelElementEndpointReferenceLabel_6002Parser();
		case WrappingLabel17EditPart.VISUAL_ID:
			return getBinaryMappingReferenceLabel_6003Parser();
		case WrappingLabel18EditPart.VISUAL_ID:
			return getBinaryMappingReferenceLabel_6004Parser();
		case WrappingLabel19EditPart.VISUAL_ID:
			return getBinaryMappingReferenceLabel_6005Parser();
		case WrappingLabel20EditPart.VISUAL_ID:
			return getBinaryMappingReferenceLabel_6006Parser();
		case WrappingLabel21EditPart.VISUAL_ID:
			return getBinaryMappingReferenceLabel_6007Parser();
		case WrappingLabel22EditPart.VISUAL_ID:
			return getBinaryMappingReferenceLabel_6008Parser();
		case WrappingLabel23EditPart.VISUAL_ID:
			return getBinaryMappingReferenceLabel_6009Parser();
		case WrappingLabel24EditPart.VISUAL_ID:
			return getBinaryMappingReferenceLabel_6010Parser();
		case WrappingLabel25EditPart.VISUAL_ID:
			return getModelElementEndpointReferenceLabel_6011Parser();
		case WrappingLabel26EditPart.VISUAL_ID:
			return getModelElementEndpointReferenceLabel_6012Parser();
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

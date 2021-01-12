/*
 * Copyright (c) 2012-2021 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers;

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

/**
 * @generated
 */
public class ICSE15_SequenceDiagram_MAVOParserProvider extends AbstractProvider implements IParserProvider {

	/**
	* @generated
	*/
	private IParser lifelineName_5001Parser;

	/**
	* @generated
	*/
	private IParser getLifelineName_5001Parser() {
		if (lifelineName_5001Parser == null) {
			EAttribute[] features = new EAttribute[] {
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage.eINSTANCE
							.getNamedElement_Name() };
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.parsers.MessageFormatParser parser = new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.parsers.MessageFormatParser(
					features);
			lifelineName_5001Parser = parser;
		}
		return lifelineName_5001Parser;
	}

	/**
	* @generated
	*/
	private MAVOElementLabelParser lifelineLabel_5002Parser;

	/**
	* @generated
	*/
	private IParser getLifelineLabel_5002Parser() {
		if (lifelineLabel_5002Parser == null) {
			lifelineLabel_5002Parser = new MAVOElementLabelParser();
		}
		return lifelineLabel_5002Parser;
	}

	/**
	* @generated
	*/
	private IParser className_5005Parser;

	/**
	* @generated
	*/
	private IParser getClassName_5005Parser() {
		if (className_5005Parser == null) {
			EAttribute[] features = new EAttribute[] {
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage.eINSTANCE
							.getNamedElement_Name() };
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.parsers.MessageFormatParser parser = new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.parsers.MessageFormatParser(
					features);
			className_5005Parser = parser;
		}
		return className_5005Parser;
	}

	/**
	* @generated
	*/
	private MAVOElementLabelParser classLabel_5006Parser;

	/**
	* @generated
	*/
	private IParser getClassLabel_5006Parser() {
		if (classLabel_5006Parser == null) {
			classLabel_5006Parser = new MAVOElementLabelParser();
		}
		return classLabel_5006Parser;
	}

	/**
	* @generated
	*/
	private IParser messageName_5007Parser;

	/**
	* @generated
	*/
	private IParser getMessageName_5007Parser() {
		if (messageName_5007Parser == null) {
			EAttribute[] features = new EAttribute[] {
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage.eINSTANCE
							.getNamedElement_Name() };
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.parsers.MessageFormatParser parser = new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.parsers.MessageFormatParser(
					features);
			messageName_5007Parser = parser;
		}
		return messageName_5007Parser;
	}

	/**
	* @generated
	*/
	private MAVOElementLabelParser messageLabel_5008Parser;

	/**
	* @generated
	*/
	private IParser getMessageLabel_5008Parser() {
		if (messageLabel_5008Parser == null) {
			messageLabel_5008Parser = new MAVOElementLabelParser();
		}
		return messageLabel_5008Parser;
	}

	/**
	* @generated
	*/
	private IParser operationName_5003Parser;

	/**
	* @generated
	*/
	private IParser getOperationName_5003Parser() {
		if (operationName_5003Parser == null) {
			EAttribute[] features = new EAttribute[] {
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage.eINSTANCE
							.getNamedElement_Name() };
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.parsers.MessageFormatParser parser = new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.parsers.MessageFormatParser(
					features);
			operationName_5003Parser = parser;
		}
		return operationName_5003Parser;
	}

	/**
	* @generated
	*/
	private MAVOElementLabelParser operationLabel_5004Parser;

	/**
	* @generated
	*/
	private IParser getOperationLabel_5004Parser() {
		if (operationLabel_5004Parser == null) {
			operationLabel_5004Parser = new MAVOElementLabelParser();
		}
		return operationLabel_5004Parser;
	}

	/**
	* @generated
	*/
	private MAVOElementLabelParser classReferenceLabel_6001Parser;

	/**
	* @generated
	*/
	private IParser getClassReferenceLabel_6001Parser() {
		if (classReferenceLabel_6001Parser == null) {
			classReferenceLabel_6001Parser = new MAVOElementLabelParser();
		}
		return classReferenceLabel_6001Parser;
	}

	/**
	* @generated
	*/
	private MAVOElementLabelParser operationReferenceLabel_6002Parser;

	/**
	* @generated
	*/
	private IParser getOperationReferenceLabel_6002Parser() {
		if (operationReferenceLabel_6002Parser == null) {
			operationReferenceLabel_6002Parser = new MAVOElementLabelParser();
		}
		return operationReferenceLabel_6002Parser;
	}

	/**
	* @generated
	*/
	private MAVOElementLabelParser sourceLifelineReferenceLabel_6003Parser;

	/**
	* @generated
	*/
	private IParser getSourceLifelineReferenceLabel_6003Parser() {
		if (sourceLifelineReferenceLabel_6003Parser == null) {
			sourceLifelineReferenceLabel_6003Parser = new MAVOElementLabelParser();
		}
		return sourceLifelineReferenceLabel_6003Parser;
	}

	/**
	* @generated
	*/
	private MAVOElementLabelParser targetLifelineReferenceLabel_6004Parser;

	/**
	* @generated
	*/
	private IParser getTargetLifelineReferenceLabel_6004Parser() {
		if (targetLifelineReferenceLabel_6004Parser == null) {
			targetLifelineReferenceLabel_6004Parser = new MAVOElementLabelParser();
		}
		return targetLifelineReferenceLabel_6004Parser;
	}

	/**
	* @generated
	*/
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.LifelineNameEditPart.VISUAL_ID:
			return getLifelineName_5001Parser();
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.WrappingLabelEditPart.VISUAL_ID:
			return getLifelineLabel_5002Parser();
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.ClassNameEditPart.VISUAL_ID:
			return getClassName_5005Parser();
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.WrappingLabel2EditPart.VISUAL_ID:
			return getClassLabel_5006Parser();
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.MessageNameEditPart.VISUAL_ID:
			return getMessageName_5007Parser();
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.WrappingLabel3EditPart.VISUAL_ID:
			return getMessageLabel_5008Parser();
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.OperationNameEditPart.VISUAL_ID:
			return getOperationName_5003Parser();
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.WrappingLabel4EditPart.VISUAL_ID:
			return getOperationLabel_5004Parser();
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.WrappingLabel5EditPart.VISUAL_ID:
			return getClassReferenceLabel_6001Parser();
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.WrappingLabel6EditPart.VISUAL_ID:
			return getOperationReferenceLabel_6002Parser();
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.WrappingLabel7EditPart.VISUAL_ID:
			return getSourceLifelineReferenceLabel_6003Parser();
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.WrappingLabel8EditPart.VISUAL_ID:
			return getTargetLifelineReferenceLabel_6004Parser();
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
			return getParser(
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
							.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
							.getVisualID(view));
		}
		return null;
	}

	/**
	* @generated
	*/
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes
					.getElement(hint) == null) {
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

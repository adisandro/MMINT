/*
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers;

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
public class StateMachine_MAVOParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private MAVOElementLabelParser initialStateLabel_5001Parser;

	/**
	 * @generated
	 */
	private IParser getInitialStateLabel_5001Parser() {
		if (initialStateLabel_5001Parser == null) {
			initialStateLabel_5001Parser = new MAVOElementLabelParser();
		}
		return initialStateLabel_5001Parser;
	}

	/**
	 * @generated
	 */
	private MAVOElementLabelParser finalStateLabel_5002Parser;

	/**
	 * @generated
	 */
	private IParser getFinalStateLabel_5002Parser() {
		if (finalStateLabel_5002Parser == null) {
			finalStateLabel_5002Parser = new MAVOElementLabelParser();
		}
		return finalStateLabel_5002Parser;
	}

	/**
	 * @generated
	 */
	private IParser stateName_5007Parser;

	/**
	 * @generated
	 */
	private IParser getStateName_5007Parser() {
		if (stateName_5007Parser == null) {
			EAttribute[] features = new EAttribute[] { edu.toronto.cs.se.modelepedia.statemachine_mavo.StateMachine_MAVOPackage.eINSTANCE
					.getNamedElement_Name() };
			edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.parsers.MessageFormatParser parser = new edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.parsers.MessageFormatParser(
					features);
			stateName_5007Parser = parser;
		}
		return stateName_5007Parser;
	}

	/**
	 * @generated
	 */
	private MAVOElementLabelParser stateLabel_5008Parser;

	/**
	 * @generated
	 */
	private IParser getStateLabel_5008Parser() {
		if (stateLabel_5008Parser == null) {
			stateLabel_5008Parser = new MAVOElementLabelParser();
		}
		return stateLabel_5008Parser;
	}

	/**
	 * @generated
	 */
	private MAVOElementLabelParser initialStateLabel_5003Parser;

	/**
	 * @generated
	 */
	private IParser getInitialStateLabel_5003Parser() {
		if (initialStateLabel_5003Parser == null) {
			initialStateLabel_5003Parser = new MAVOElementLabelParser();
		}
		return initialStateLabel_5003Parser;
	}

	/**
	 * @generated
	 */
	private MAVOElementLabelParser finalStateLabel_5004Parser;

	/**
	 * @generated
	 */
	private IParser getFinalStateLabel_5004Parser() {
		if (finalStateLabel_5004Parser == null) {
			finalStateLabel_5004Parser = new MAVOElementLabelParser();
		}
		return finalStateLabel_5004Parser;
	}

	/**
	 * @generated
	 */
	private IParser stateName_5005Parser;

	/**
	 * @generated
	 */
	private IParser getStateName_5005Parser() {
		if (stateName_5005Parser == null) {
			EAttribute[] features = new EAttribute[] { edu.toronto.cs.se.modelepedia.statemachine_mavo.StateMachine_MAVOPackage.eINSTANCE
					.getNamedElement_Name() };
			edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.parsers.MessageFormatParser parser = new edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.parsers.MessageFormatParser(
					features);
			stateName_5005Parser = parser;
		}
		return stateName_5005Parser;
	}

	/**
	 * @generated
	 */
	private MAVOElementLabelParser stateLabel_5006Parser;

	/**
	 * @generated
	 */
	private IParser getStateLabel_5006Parser() {
		if (stateLabel_5006Parser == null) {
			stateLabel_5006Parser = new MAVOElementLabelParser();
		}
		return stateLabel_5006Parser;
	}

	/**
	 * @generated
	 */
	private IParser transitionName_6001Parser;

	/**
	 * @generated
	 */
	private IParser getTransitionName_6001Parser() {
		if (transitionName_6001Parser == null) {
			EAttribute[] features = new EAttribute[] { edu.toronto.cs.se.modelepedia.statemachine_mavo.StateMachine_MAVOPackage.eINSTANCE
					.getNamedElement_Name() };
			edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.parsers.MessageFormatParser parser = new edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.parsers.MessageFormatParser(
					features);
			transitionName_6001Parser = parser;
		}
		return transitionName_6001Parser;
	}

	/**
	 * @generated
	 */
	private MAVOElementLabelParser transitionLabel_6002Parser;

	/**
	 * @generated
	 */
	private IParser getTransitionLabel_6002Parser() {
		if (transitionLabel_6002Parser == null) {
			transitionLabel_6002Parser = new MAVOElementLabelParser();
		}
		return transitionLabel_6002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.WrappingLabelEditPart.VISUAL_ID:
			return getInitialStateLabel_5001Parser();
		case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.WrappingLabel2EditPart.VISUAL_ID:
			return getFinalStateLabel_5002Parser();
		case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.StateNameEditPart.VISUAL_ID:
			return getStateName_5007Parser();
		case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.WrappingLabel3EditPart.VISUAL_ID:
			return getStateLabel_5008Parser();
		case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.WrappingLabel4EditPart.VISUAL_ID:
			return getInitialStateLabel_5003Parser();
		case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.WrappingLabel5EditPart.VISUAL_ID:
			return getFinalStateLabel_5004Parser();
		case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.StateName2EditPart.VISUAL_ID:
			return getStateName_5005Parser();
		case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.WrappingLabel6EditPart.VISUAL_ID:
			return getStateLabel_5006Parser();
		case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.TransitionNameEditPart.VISUAL_ID:
			return getTransitionName_6001Parser();
		case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.WrappingLabel7EditPart.VISUAL_ID:
			return getTransitionLabel_6002Parser();
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
			return getParser(edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOVisualIDRegistry
					.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOVisualIDRegistry
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
			if (edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes
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

/*
 * Copyright Text ->
 * 
 * Copyright (c) 2012-2022 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.statemachine.diagram.providers;

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

import edu.toronto.cs.se.modelepedia.statemachine.StateMachinePackage;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.StateActionTriggerActionEditPart;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.StateNameEditPart;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.TransitionTriggerActionEditPart;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.parsers.MessageFormatParser;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.part.StateMachineVisualIDRegistry;

/**
 * @generated
 */
public class StateMachineParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser stateName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getStateName_5002Parser() {
		if (stateName_5002Parser == null) {
			EAttribute[] features = new EAttribute[] { StateMachinePackage.eINSTANCE
					.getAbstractState_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			stateName_5002Parser = parser;
		}
		return stateName_5002Parser;
	}

	/**
	 * @generated
	 */
	private IParser stateActionTriggerAction_5001Parser;

	/**
	 * @generated
	 */
	private IParser getStateActionTriggerAction_5001Parser() {
		if (stateActionTriggerAction_5001Parser == null) {
			EAttribute[] features = new EAttribute[] {
					StateMachinePackage.eINSTANCE.getFiringElement_Trigger(),
					StateMachinePackage.eINSTANCE.getFiringElement_Action() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}/{1}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}/{1}"); //$NON-NLS-1$
			parser.setEditPattern("{0}/{1}"); //$NON-NLS-1$
			stateActionTriggerAction_5001Parser = parser;
		}
		return stateActionTriggerAction_5001Parser;
	}

	/**
	 * @generated
	 */
	private IParser transitionTriggerAction_6001Parser;

	/**
	 * @generated
	 */
	private IParser getTransitionTriggerAction_6001Parser() {
		if (transitionTriggerAction_6001Parser == null) {
			EAttribute[] features = new EAttribute[] {
					StateMachinePackage.eINSTANCE.getFiringElement_Trigger(),
					StateMachinePackage.eINSTANCE.getFiringElement_Action() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}/{1}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}/{1}"); //$NON-NLS-1$
			parser.setEditPattern("{0}/{1}"); //$NON-NLS-1$
			transitionTriggerAction_6001Parser = parser;
		}
		return transitionTriggerAction_6001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case StateNameEditPart.VISUAL_ID:
			return getStateName_5002Parser();
		case StateActionTriggerActionEditPart.VISUAL_ID:
			return getStateActionTriggerAction_5001Parser();
		case TransitionTriggerActionEditPart.VISUAL_ID:
			return getTransitionTriggerAction_6001Parser();
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
			return getParser(StateMachineVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(StateMachineVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (StateMachineElementTypes.getElement(hint) == null) {
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

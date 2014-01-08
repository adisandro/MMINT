/*
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.istar.diagram.providers;

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

import edu.toronto.cs.se.modelepedia.istar.IStarPackage;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.ActorNameEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.GoalName2EditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.GoalNameEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.ResourceName2EditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.ResourceNameEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.SoftGoalName2EditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.SoftGoalNameEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.TaskName2EditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.TaskNameEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.parsers.MessageFormatParser;
import edu.toronto.cs.se.modelepedia.istar.diagram.part.IStarVisualIDRegistry;

/**
 * @generated
 */
public class IStarParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser softGoalName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getSoftGoalName_5001Parser() {
		if (softGoalName_5001Parser == null) {
			EAttribute[] features = new EAttribute[] { IStarPackage.eINSTANCE
					.getDependencyEndpoint_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			softGoalName_5001Parser = parser;
		}
		return softGoalName_5001Parser;
	}

	/**
	 * @generated
	 */
	private IParser taskName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getTaskName_5002Parser() {
		if (taskName_5002Parser == null) {
			EAttribute[] features = new EAttribute[] { IStarPackage.eINSTANCE
					.getDependencyEndpoint_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			taskName_5002Parser = parser;
		}
		return taskName_5002Parser;
	}

	/**
	 * @generated
	 */
	private IParser resourceName_5003Parser;

	/**
	 * @generated
	 */
	private IParser getResourceName_5003Parser() {
		if (resourceName_5003Parser == null) {
			EAttribute[] features = new EAttribute[] { IStarPackage.eINSTANCE
					.getDependencyEndpoint_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			resourceName_5003Parser = parser;
		}
		return resourceName_5003Parser;
	}

	/**
	 * @generated
	 */
	private IParser goalName_5004Parser;

	/**
	 * @generated
	 */
	private IParser getGoalName_5004Parser() {
		if (goalName_5004Parser == null) {
			EAttribute[] features = new EAttribute[] { IStarPackage.eINSTANCE
					.getDependencyEndpoint_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			goalName_5004Parser = parser;
		}
		return goalName_5004Parser;
	}

	/**
	 * @generated
	 */
	private IParser actorName_5009Parser;

	/**
	 * @generated
	 */
	private IParser getActorName_5009Parser() {
		if (actorName_5009Parser == null) {
			EAttribute[] features = new EAttribute[] { IStarPackage.eINSTANCE
					.getDependencyEndpoint_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			actorName_5009Parser = parser;
		}
		return actorName_5009Parser;
	}

	/**
	 * @generated
	 */
	private IParser softGoalName_5005Parser;

	/**
	 * @generated
	 */
	private IParser getSoftGoalName_5005Parser() {
		if (softGoalName_5005Parser == null) {
			EAttribute[] features = new EAttribute[] { IStarPackage.eINSTANCE
					.getDependencyEndpoint_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			softGoalName_5005Parser = parser;
		}
		return softGoalName_5005Parser;
	}

	/**
	 * @generated
	 */
	private IParser taskName_5006Parser;

	/**
	 * @generated
	 */
	private IParser getTaskName_5006Parser() {
		if (taskName_5006Parser == null) {
			EAttribute[] features = new EAttribute[] { IStarPackage.eINSTANCE
					.getDependencyEndpoint_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			taskName_5006Parser = parser;
		}
		return taskName_5006Parser;
	}

	/**
	 * @generated
	 */
	private IParser resourceName_5007Parser;

	/**
	 * @generated
	 */
	private IParser getResourceName_5007Parser() {
		if (resourceName_5007Parser == null) {
			EAttribute[] features = new EAttribute[] { IStarPackage.eINSTANCE
					.getDependencyEndpoint_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			resourceName_5007Parser = parser;
		}
		return resourceName_5007Parser;
	}

	/**
	 * @generated
	 */
	private IParser goalName_5008Parser;

	/**
	 * @generated
	 */
	private IParser getGoalName_5008Parser() {
		if (goalName_5008Parser == null) {
			EAttribute[] features = new EAttribute[] { IStarPackage.eINSTANCE
					.getDependencyEndpoint_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			goalName_5008Parser = parser;
		}
		return goalName_5008Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case SoftGoalNameEditPart.VISUAL_ID:
			return getSoftGoalName_5001Parser();
		case TaskNameEditPart.VISUAL_ID:
			return getTaskName_5002Parser();
		case ResourceNameEditPart.VISUAL_ID:
			return getResourceName_5003Parser();
		case GoalNameEditPart.VISUAL_ID:
			return getGoalName_5004Parser();
		case ActorNameEditPart.VISUAL_ID:
			return getActorName_5009Parser();
		case SoftGoalName2EditPart.VISUAL_ID:
			return getSoftGoalName_5005Parser();
		case TaskName2EditPart.VISUAL_ID:
			return getTaskName_5006Parser();
		case ResourceName2EditPart.VISUAL_ID:
			return getResourceName_5007Parser();
		case GoalName2EditPart.VISUAL_ID:
			return getGoalName_5008Parser();
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
			return getParser(IStarVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(IStarVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (IStarElementTypes.getElement(hint) == null) {
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

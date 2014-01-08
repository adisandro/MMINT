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
package edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers;

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

import edu.toronto.cs.se.mmtf.mavo.library.MAVOElementLabelParser;

/**
 * @generated
 */
public class IStar_MAVOParserProvider extends AbstractProvider implements
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
			EAttribute[] features = new EAttribute[] { edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE
					.getDependencyEndpoint_Name() };
			edu.toronto.cs.se.modelepedia.istar_mavo.diagram.parsers.MessageFormatParser parser = new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.parsers.MessageFormatParser(
					features);
			softGoalName_5001Parser = parser;
		}
		return softGoalName_5001Parser;
	}

	/**
	 * @generated
	 */
	private MAVOElementLabelParser softGoalLabel_5002Parser;

	/**
	 * @generated
	 */
	private IParser getSoftGoalLabel_5002Parser() {
		if (softGoalLabel_5002Parser == null) {
			softGoalLabel_5002Parser = new MAVOElementLabelParser();
		}
		return softGoalLabel_5002Parser;
	}

	/**
	 * @generated
	 */
	private IParser taskName_5003Parser;

	/**
	 * @generated
	 */
	private IParser getTaskName_5003Parser() {
		if (taskName_5003Parser == null) {
			EAttribute[] features = new EAttribute[] { edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE
					.getDependencyEndpoint_Name() };
			edu.toronto.cs.se.modelepedia.istar_mavo.diagram.parsers.MessageFormatParser parser = new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.parsers.MessageFormatParser(
					features);
			taskName_5003Parser = parser;
		}
		return taskName_5003Parser;
	}

	/**
	 * @generated
	 */
	private MAVOElementLabelParser taskLabel_5004Parser;

	/**
	 * @generated
	 */
	private IParser getTaskLabel_5004Parser() {
		if (taskLabel_5004Parser == null) {
			taskLabel_5004Parser = new MAVOElementLabelParser();
		}
		return taskLabel_5004Parser;
	}

	/**
	 * @generated
	 */
	private IParser resourceName_5005Parser;

	/**
	 * @generated
	 */
	private IParser getResourceName_5005Parser() {
		if (resourceName_5005Parser == null) {
			EAttribute[] features = new EAttribute[] { edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE
					.getDependencyEndpoint_Name() };
			edu.toronto.cs.se.modelepedia.istar_mavo.diagram.parsers.MessageFormatParser parser = new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.parsers.MessageFormatParser(
					features);
			resourceName_5005Parser = parser;
		}
		return resourceName_5005Parser;
	}

	/**
	 * @generated
	 */
	private MAVOElementLabelParser resourceLabel_5006Parser;

	/**
	 * @generated
	 */
	private IParser getResourceLabel_5006Parser() {
		if (resourceLabel_5006Parser == null) {
			resourceLabel_5006Parser = new MAVOElementLabelParser();
		}
		return resourceLabel_5006Parser;
	}

	/**
	 * @generated
	 */
	private IParser goalName_5007Parser;

	/**
	 * @generated
	 */
	private IParser getGoalName_5007Parser() {
		if (goalName_5007Parser == null) {
			EAttribute[] features = new EAttribute[] { edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE
					.getDependencyEndpoint_Name() };
			edu.toronto.cs.se.modelepedia.istar_mavo.diagram.parsers.MessageFormatParser parser = new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.parsers.MessageFormatParser(
					features);
			goalName_5007Parser = parser;
		}
		return goalName_5007Parser;
	}

	/**
	 * @generated
	 */
	private MAVOElementLabelParser goalLabel_5008Parser;

	/**
	 * @generated
	 */
	private IParser getGoalLabel_5008Parser() {
		if (goalLabel_5008Parser == null) {
			goalLabel_5008Parser = new MAVOElementLabelParser();
		}
		return goalLabel_5008Parser;
	}

	/**
	 * @generated
	 */
	private IParser actorName_5017Parser;

	/**
	 * @generated
	 */
	private IParser getActorName_5017Parser() {
		if (actorName_5017Parser == null) {
			EAttribute[] features = new EAttribute[] { edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE
					.getDependencyEndpoint_Name() };
			edu.toronto.cs.se.modelepedia.istar_mavo.diagram.parsers.MessageFormatParser parser = new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.parsers.MessageFormatParser(
					features);
			actorName_5017Parser = parser;
		}
		return actorName_5017Parser;
	}

	/**
	 * @generated
	 */
	private MAVOElementLabelParser actorLabel_5018Parser;

	/**
	 * @generated
	 */
	private IParser getActorLabel_5018Parser() {
		if (actorLabel_5018Parser == null) {
			actorLabel_5018Parser = new MAVOElementLabelParser();
		}
		return actorLabel_5018Parser;
	}

	/**
	 * @generated
	 */
	private IParser softGoalName_5009Parser;

	/**
	 * @generated
	 */
	private IParser getSoftGoalName_5009Parser() {
		if (softGoalName_5009Parser == null) {
			EAttribute[] features = new EAttribute[] { edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE
					.getDependencyEndpoint_Name() };
			edu.toronto.cs.se.modelepedia.istar_mavo.diagram.parsers.MessageFormatParser parser = new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.parsers.MessageFormatParser(
					features);
			softGoalName_5009Parser = parser;
		}
		return softGoalName_5009Parser;
	}

	/**
	 * @generated
	 */
	private MAVOElementLabelParser softGoalLabel_5010Parser;

	/**
	 * @generated
	 */
	private IParser getSoftGoalLabel_5010Parser() {
		if (softGoalLabel_5010Parser == null) {
			softGoalLabel_5010Parser = new MAVOElementLabelParser();
		}
		return softGoalLabel_5010Parser;
	}

	/**
	 * @generated
	 */
	private IParser taskName_5011Parser;

	/**
	 * @generated
	 */
	private IParser getTaskName_5011Parser() {
		if (taskName_5011Parser == null) {
			EAttribute[] features = new EAttribute[] { edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE
					.getDependencyEndpoint_Name() };
			edu.toronto.cs.se.modelepedia.istar_mavo.diagram.parsers.MessageFormatParser parser = new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.parsers.MessageFormatParser(
					features);
			taskName_5011Parser = parser;
		}
		return taskName_5011Parser;
	}

	/**
	 * @generated
	 */
	private MAVOElementLabelParser taskLabel_5012Parser;

	/**
	 * @generated
	 */
	private IParser getTaskLabel_5012Parser() {
		if (taskLabel_5012Parser == null) {
			taskLabel_5012Parser = new MAVOElementLabelParser();
		}
		return taskLabel_5012Parser;
	}

	/**
	 * @generated
	 */
	private IParser resourceName_5013Parser;

	/**
	 * @generated
	 */
	private IParser getResourceName_5013Parser() {
		if (resourceName_5013Parser == null) {
			EAttribute[] features = new EAttribute[] { edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE
					.getDependencyEndpoint_Name() };
			edu.toronto.cs.se.modelepedia.istar_mavo.diagram.parsers.MessageFormatParser parser = new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.parsers.MessageFormatParser(
					features);
			resourceName_5013Parser = parser;
		}
		return resourceName_5013Parser;
	}

	/**
	 * @generated
	 */
	private MAVOElementLabelParser resourceLabel_5014Parser;

	/**
	 * @generated
	 */
	private IParser getResourceLabel_5014Parser() {
		if (resourceLabel_5014Parser == null) {
			resourceLabel_5014Parser = new MAVOElementLabelParser();
		}
		return resourceLabel_5014Parser;
	}

	/**
	 * @generated
	 */
	private IParser goalName_5015Parser;

	/**
	 * @generated
	 */
	private IParser getGoalName_5015Parser() {
		if (goalName_5015Parser == null) {
			EAttribute[] features = new EAttribute[] { edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE
					.getDependencyEndpoint_Name() };
			edu.toronto.cs.se.modelepedia.istar_mavo.diagram.parsers.MessageFormatParser parser = new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.parsers.MessageFormatParser(
					features);
			goalName_5015Parser = parser;
		}
		return goalName_5015Parser;
	}

	/**
	 * @generated
	 */
	private MAVOElementLabelParser goalLabel_5016Parser;

	/**
	 * @generated
	 */
	private IParser getGoalLabel_5016Parser() {
		if (goalLabel_5016Parser == null) {
			goalLabel_5016Parser = new MAVOElementLabelParser();
		}
		return goalLabel_5016Parser;
	}

	/**
	 * @generated
	 */
	private MAVOElementLabelParser meansEndLabel_6001Parser;

	/**
	 * @generated
	 */
	private IParser getMeansEndLabel_6001Parser() {
		if (meansEndLabel_6001Parser == null) {
			meansEndLabel_6001Parser = new MAVOElementLabelParser();
		}
		return meansEndLabel_6001Parser;
	}

	/**
	 * @generated
	 */
	private MAVOElementLabelParser decompositionLabel_6002Parser;

	/**
	 * @generated
	 */
	private IParser getDecompositionLabel_6002Parser() {
		if (decompositionLabel_6002Parser == null) {
			decompositionLabel_6002Parser = new MAVOElementLabelParser();
		}
		return decompositionLabel_6002Parser;
	}

	/**
	 * @generated
	 */
	private MAVOElementLabelParser contributionLabel_6003Parser;

	/**
	 * @generated
	 */
	private IParser getContributionLabel_6003Parser() {
		if (contributionLabel_6003Parser == null) {
			contributionLabel_6003Parser = new MAVOElementLabelParser();
		}
		return contributionLabel_6003Parser;
	}

	/**
	 * @generated
	 */
	private MAVOElementLabelParser dependerLinkLabel_6004Parser;

	/**
	 * @generated
	 */
	private IParser getDependerLinkLabel_6004Parser() {
		if (dependerLinkLabel_6004Parser == null) {
			dependerLinkLabel_6004Parser = new MAVOElementLabelParser();
		}
		return dependerLinkLabel_6004Parser;
	}

	/**
	 * @generated
	 */
	private MAVOElementLabelParser dependeeLinkLabel_6005Parser;

	/**
	 * @generated
	 */
	private IParser getDependeeLinkLabel_6005Parser() {
		if (dependeeLinkLabel_6005Parser == null) {
			dependeeLinkLabel_6005Parser = new MAVOElementLabelParser();
		}
		return dependeeLinkLabel_6005Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoalNameEditPart.VISUAL_ID:
			return getSoftGoalName_5001Parser();
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabelEditPart.VISUAL_ID:
			return getSoftGoalLabel_5002Parser();
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.TaskNameEditPart.VISUAL_ID:
			return getTaskName_5003Parser();
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel2EditPart.VISUAL_ID:
			return getTaskLabel_5004Parser();
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ResourceNameEditPart.VISUAL_ID:
			return getResourceName_5005Parser();
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel3EditPart.VISUAL_ID:
			return getResourceLabel_5006Parser();
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.GoalNameEditPart.VISUAL_ID:
			return getGoalName_5007Parser();
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel4EditPart.VISUAL_ID:
			return getGoalLabel_5008Parser();
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ActorNameEditPart.VISUAL_ID:
			return getActorName_5017Parser();
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel5EditPart.VISUAL_ID:
			return getActorLabel_5018Parser();
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoalName2EditPart.VISUAL_ID:
			return getSoftGoalName_5009Parser();
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel6EditPart.VISUAL_ID:
			return getSoftGoalLabel_5010Parser();
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.TaskName2EditPart.VISUAL_ID:
			return getTaskName_5011Parser();
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel7EditPart.VISUAL_ID:
			return getTaskLabel_5012Parser();
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ResourceName2EditPart.VISUAL_ID:
			return getResourceName_5013Parser();
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel8EditPart.VISUAL_ID:
			return getResourceLabel_5014Parser();
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.GoalName2EditPart.VISUAL_ID:
			return getGoalName_5015Parser();
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel9EditPart.VISUAL_ID:
			return getGoalLabel_5016Parser();
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel10EditPart.VISUAL_ID:
			return getMeansEndLabel_6001Parser();
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel11EditPart.VISUAL_ID:
			return getDecompositionLabel_6002Parser();
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel12EditPart.VISUAL_ID:
			return getContributionLabel_6003Parser();
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel13EditPart.VISUAL_ID:
			return getDependerLinkLabel_6004Parser();
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel14EditPart.VISUAL_ID:
			return getDependeeLinkLabel_6005Parser();
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
			return getParser(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry
					.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry
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
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes
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

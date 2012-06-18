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
package edu.toronto.cs.se.modelepedia.powerwindow.diagram.providers;

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

import edu.toronto.cs.se.modelepedia.powerwindow.PowerwindowPackage;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.parts.ForceDetectingDelayEditPart;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.parts.InfraredDelayEditPart;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.parts.LockOutNameEditPart;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.parts.PushPullNameEditPart;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.parts.RockerNameEditPart;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.parsers.MessageFormatParser;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.part.PowerwindowVisualIDRegistry;

/**
 * @generated
 */
public class PowerwindowParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser pushPullName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getPushPullName_5001Parser() {
		if (pushPullName_5001Parser == null) {
			EAttribute[] features = new EAttribute[] { PowerwindowPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			pushPullName_5001Parser = parser;
		}
		return pushPullName_5001Parser;
	}

	/**
	 * @generated
	 */
	private IParser rockerName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getRockerName_5002Parser() {
		if (rockerName_5002Parser == null) {
			EAttribute[] features = new EAttribute[] { PowerwindowPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			rockerName_5002Parser = parser;
		}
		return rockerName_5002Parser;
	}

	/**
	 * @generated
	 */
	private IParser infraredDelay_5003Parser;

	/**
	 * @generated
	 */
	private IParser getInfraredDelay_5003Parser() {
		if (infraredDelay_5003Parser == null) {
			EAttribute[] features = new EAttribute[] { PowerwindowPackage.eINSTANCE
					.getSensor_Delay() };
			MessageFormatParser parser = new MessageFormatParser(features);
			infraredDelay_5003Parser = parser;
		}
		return infraredDelay_5003Parser;
	}

	/**
	 * @generated
	 */
	private IParser lockOutName_5004Parser;

	/**
	 * @generated
	 */
	private IParser getLockOutName_5004Parser() {
		if (lockOutName_5004Parser == null) {
			EAttribute[] features = new EAttribute[] { PowerwindowPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			lockOutName_5004Parser = parser;
		}
		return lockOutName_5004Parser;
	}

	/**
	 * @generated
	 */
	private IParser forceDetectingDelay_5005Parser;

	/**
	 * @generated
	 */
	private IParser getForceDetectingDelay_5005Parser() {
		if (forceDetectingDelay_5005Parser == null) {
			EAttribute[] features = new EAttribute[] { PowerwindowPackage.eINSTANCE
					.getSensor_Delay() };
			MessageFormatParser parser = new MessageFormatParser(features);
			forceDetectingDelay_5005Parser = parser;
		}
		return forceDetectingDelay_5005Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case PushPullNameEditPart.VISUAL_ID:
			return getPushPullName_5001Parser();
		case RockerNameEditPart.VISUAL_ID:
			return getRockerName_5002Parser();
		case InfraredDelayEditPart.VISUAL_ID:
			return getInfraredDelay_5003Parser();
		case LockOutNameEditPart.VISUAL_ID:
			return getLockOutName_5004Parser();
		case ForceDetectingDelayEditPart.VISUAL_ID:
			return getForceDetectingDelay_5005Parser();
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
			return getParser(PowerwindowVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(PowerwindowVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (PowerwindowElementTypes.getElement(hint) == null) {
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

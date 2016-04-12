/*
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.graph_mavo.diagram.providers;

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
public class Graph_MAVOParserProvider extends AbstractProvider implements IParserProvider {

	/**
	* @generated
	*/
	private IParser nodeName_5001Parser;

	/**
	* @generated
	*/
	private IParser getNodeName_5001Parser() {
		if (nodeName_5001Parser == null) {
			EAttribute[] features = new EAttribute[] {
					edu.toronto.cs.se.modelepedia.graph_mavo.Graph_MAVOPackage.eINSTANCE.getNamedElement_Name() };
			edu.toronto.cs.se.modelepedia.graph_mavo.diagram.parsers.MessageFormatParser parser = new edu.toronto.cs.se.modelepedia.graph_mavo.diagram.parsers.MessageFormatParser(
					features);
			nodeName_5001Parser = parser;
		}
		return nodeName_5001Parser;
	}

	/**
	* @generated
	*/
	private MAVOElementLabelParser nodeLabel_5002Parser;

	/**
	* @generated
	*/
	private IParser getNodeLabel_5002Parser() {
		if (nodeLabel_5002Parser == null) {
			nodeLabel_5002Parser = new MAVOElementLabelParser();
		}
		return nodeLabel_5002Parser;
	}

	/**
	* @generated
	*/
	private IParser edgeName_6001Parser;

	/**
	* @generated
	*/
	private IParser getEdgeName_6001Parser() {
		if (edgeName_6001Parser == null) {
			EAttribute[] features = new EAttribute[] {
					edu.toronto.cs.se.modelepedia.graph_mavo.Graph_MAVOPackage.eINSTANCE.getNamedElement_Name() };
			edu.toronto.cs.se.modelepedia.graph_mavo.diagram.parsers.MessageFormatParser parser = new edu.toronto.cs.se.modelepedia.graph_mavo.diagram.parsers.MessageFormatParser(
					features);
			edgeName_6001Parser = parser;
		}
		return edgeName_6001Parser;
	}

	/**
	* @generated
	*/
	private MAVOElementLabelParser edgeLabel_6002Parser;

	/**
	* @generated
	*/
	private IParser getEdgeLabel_6002Parser() {
		if (edgeLabel_6002Parser == null) {
			edgeLabel_6002Parser = new MAVOElementLabelParser();
		}
		return edgeLabel_6002Parser;
	}

	/**
	* @generated
	*/
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.NodeNameEditPart.VISUAL_ID:
			return getNodeName_5001Parser();
		case edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.WrappingLabelEditPart.VISUAL_ID:
			return getNodeLabel_5002Parser();
		case edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.EdgeNameEditPart.VISUAL_ID:
			return getEdgeName_6001Parser();
		case edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.WrappingLabel2EditPart.VISUAL_ID:
			return getEdgeLabel_6002Parser();
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
					edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(
					edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	* @generated
	*/
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (edu.toronto.cs.se.modelepedia.graph_mavo.diagram.providers.Graph_MAVOElementTypes
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

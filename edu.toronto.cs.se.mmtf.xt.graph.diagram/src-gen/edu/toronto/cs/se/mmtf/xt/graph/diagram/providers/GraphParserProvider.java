/*
 * Copyright (C) 2012 Marsha Chechik, Alessio Di Sandro, Rick Salay
 * 
 * This file is part of MMTF ver. 0.9.0.
 * 
 * MMTF is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * MMTF is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MMTF.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.toronto.cs.se.mmtf.xt.graph.diagram.providers;

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

import edu.toronto.cs.se.mmtf.xt.graph.GraphPackage;
import edu.toronto.cs.se.mmtf.xt.graph.diagram.edit.parts.EdgeNameEditPart;
import edu.toronto.cs.se.mmtf.xt.graph.diagram.edit.parts.NodeNameEditPart;
import edu.toronto.cs.se.mmtf.xt.graph.diagram.parsers.MessageFormatParser;
import edu.toronto.cs.se.mmtf.xt.graph.diagram.part.GraphVisualIDRegistry;

/**
 * @generated
 */
public class GraphParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser nodeName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getNodeName_5001Parser() {
		if (nodeName_5001Parser == null) {
			EAttribute[] features = new EAttribute[] { GraphPackage.eINSTANCE
					.getNode_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			nodeName_5001Parser = parser;
		}
		return nodeName_5001Parser;
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
			EAttribute[] features = new EAttribute[] { GraphPackage.eINSTANCE
					.getEdge_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			edgeName_6001Parser = parser;
		}
		return edgeName_6001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case NodeNameEditPart.VISUAL_ID:
			return getNodeName_5001Parser();
		case EdgeNameEditPart.VISUAL_ID:
			return getEdgeName_6001Parser();
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
			return getParser(GraphVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(GraphVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (GraphElementTypes.getElement(hint) == null) {
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

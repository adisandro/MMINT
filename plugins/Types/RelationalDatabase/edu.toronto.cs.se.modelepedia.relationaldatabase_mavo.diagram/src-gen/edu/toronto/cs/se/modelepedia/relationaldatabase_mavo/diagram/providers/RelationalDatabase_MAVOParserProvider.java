/*
 * Copyright (c) 2012-2018 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.providers;

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
public class RelationalDatabase_MAVOParserProvider extends AbstractProvider implements IParserProvider {

	/**
	* @generated
	*/
	private IParser tableName_5005Parser;

	/**
	* @generated
	*/
	private IParser getTableName_5005Parser() {
		if (tableName_5005Parser == null) {
			EAttribute[] features = new EAttribute[] {
					edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.RelationalDatabase_MAVOPackage.eINSTANCE
							.getNamedElement_Name() };
			edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.parsers.MessageFormatParser parser = new edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.parsers.MessageFormatParser(
					features);
			tableName_5005Parser = parser;
		}
		return tableName_5005Parser;
	}

	/**
	* @generated
	*/
	private MAVOElementLabelParser tableLabel_5006Parser;

	/**
	* @generated
	*/
	private IParser getTableLabel_5006Parser() {
		if (tableLabel_5006Parser == null) {
			tableLabel_5006Parser = new MAVOElementLabelParser();
		}
		return tableLabel_5006Parser;
	}

	/**
	* @generated
	*/
	private IParser columnName_5001Parser;

	/**
	* @generated
	*/
	private IParser getColumnName_5001Parser() {
		if (columnName_5001Parser == null) {
			EAttribute[] features = new EAttribute[] {
					edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.RelationalDatabase_MAVOPackage.eINSTANCE
							.getNamedElement_Name() };
			edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.parsers.MessageFormatParser parser = new edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.parsers.MessageFormatParser(
					features);
			columnName_5001Parser = parser;
		}
		return columnName_5001Parser;
	}

	/**
	* @generated
	*/
	private MAVOElementLabelParser columnLabel_5002Parser;

	/**
	* @generated
	*/
	private IParser getColumnLabel_5002Parser() {
		if (columnLabel_5002Parser == null) {
			columnLabel_5002Parser = new MAVOElementLabelParser();
		}
		return columnLabel_5002Parser;
	}

	/**
	* @generated
	*/
	private IParser foreignKeyName_5003Parser;

	/**
	* @generated
	*/
	private IParser getForeignKeyName_5003Parser() {
		if (foreignKeyName_5003Parser == null) {
			EAttribute[] features = new EAttribute[] {
					edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.RelationalDatabase_MAVOPackage.eINSTANCE
							.getNamedElement_Name() };
			edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.parsers.MessageFormatParser parser = new edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.parsers.MessageFormatParser(
					features);
			foreignKeyName_5003Parser = parser;
		}
		return foreignKeyName_5003Parser;
	}

	/**
	* @generated
	*/
	private MAVOElementLabelParser foreignKeyLabel_5004Parser;

	/**
	* @generated
	*/
	private IParser getForeignKeyLabel_5004Parser() {
		if (foreignKeyLabel_5004Parser == null) {
			foreignKeyLabel_5004Parser = new MAVOElementLabelParser();
		}
		return foreignKeyLabel_5004Parser;
	}

	/**
	* @generated
	*/
	private MAVOElementLabelParser tableColumnReferenceLabel_6001Parser;

	/**
	* @generated
	*/
	private IParser getTableColumnReferenceLabel_6001Parser() {
		if (tableColumnReferenceLabel_6001Parser == null) {
			tableColumnReferenceLabel_6001Parser = new MAVOElementLabelParser();
		}
		return tableColumnReferenceLabel_6001Parser;
	}

	/**
	* @generated
	*/
	private MAVOElementLabelParser foreignColumnReferenceLabel_6002Parser;

	/**
	* @generated
	*/
	private IParser getForeignColumnReferenceLabel_6002Parser() {
		if (foreignColumnReferenceLabel_6002Parser == null) {
			foreignColumnReferenceLabel_6002Parser = new MAVOElementLabelParser();
		}
		return foreignColumnReferenceLabel_6002Parser;
	}

	/**
	* @generated
	*/
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.TableNameEditPart.VISUAL_ID:
			return getTableName_5005Parser();
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.WrappingLabelEditPart.VISUAL_ID:
			return getTableLabel_5006Parser();
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ColumnNameEditPart.VISUAL_ID:
			return getColumnName_5001Parser();
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.WrappingLabel2EditPart.VISUAL_ID:
			return getColumnLabel_5002Parser();
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ForeignKeyNameEditPart.VISUAL_ID:
			return getForeignKeyName_5003Parser();
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.WrappingLabel3EditPart.VISUAL_ID:
			return getForeignKeyLabel_5004Parser();
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.WrappingLabel4EditPart.VISUAL_ID:
			return getTableColumnReferenceLabel_6001Parser();
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.WrappingLabel5EditPart.VISUAL_ID:
			return getForeignColumnReferenceLabel_6002Parser();
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
					edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOVisualIDRegistry
							.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(
					edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOVisualIDRegistry
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
			if (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.providers.RelationalDatabase_MAVOElementTypes
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

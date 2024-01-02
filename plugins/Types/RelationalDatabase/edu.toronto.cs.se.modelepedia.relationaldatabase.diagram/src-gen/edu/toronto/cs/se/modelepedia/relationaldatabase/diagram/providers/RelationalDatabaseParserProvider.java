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
package edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.providers;

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

import edu.toronto.cs.se.modelepedia.relationaldatabase.RelationalDatabasePackage;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.parts.ColumnNameEditPart;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.parts.ForeignKeyNameEditPart;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.parts.TableNameEditPart;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.parsers.MessageFormatParser;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.part.RelationalDatabaseVisualIDRegistry;

/**
 * @generated
 */
public class RelationalDatabaseParserProvider extends AbstractProvider
		implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser tableName_5003Parser;

	/**
	 * @generated
	 */
	private IParser getTableName_5003Parser() {
		if (tableName_5003Parser == null) {
			EAttribute[] features = new EAttribute[] { RelationalDatabasePackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			tableName_5003Parser = parser;
		}
		return tableName_5003Parser;
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
			EAttribute[] features = new EAttribute[] { RelationalDatabasePackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			columnName_5001Parser = parser;
		}
		return columnName_5001Parser;
	}

	/**
	 * @generated
	 */
	private IParser foreignKeyName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getForeignKeyName_5002Parser() {
		if (foreignKeyName_5002Parser == null) {
			EAttribute[] features = new EAttribute[] { RelationalDatabasePackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			foreignKeyName_5002Parser = parser;
		}
		return foreignKeyName_5002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case TableNameEditPart.VISUAL_ID:
			return getTableName_5003Parser();
		case ColumnNameEditPart.VISUAL_ID:
			return getColumnName_5001Parser();
		case ForeignKeyNameEditPart.VISUAL_ID:
			return getForeignKeyName_5002Parser();
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
			return getParser(RelationalDatabaseVisualIDRegistry
					.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(RelationalDatabaseVisualIDRegistry
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
			if (RelationalDatabaseElementTypes.getElement(hint) == null) {
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

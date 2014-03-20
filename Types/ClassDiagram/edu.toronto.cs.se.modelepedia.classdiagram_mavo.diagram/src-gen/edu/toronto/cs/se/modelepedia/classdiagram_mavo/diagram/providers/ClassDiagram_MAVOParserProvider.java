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
package edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers;

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
public class ClassDiagram_MAVOParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser className_5005Parser;

	/**
	 * @generated
	 */
	private IParser getClassName_5005Parser() {
		if (className_5005Parser == null) {
			EAttribute[] features = new EAttribute[] { edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage.eINSTANCE
					.getNamedElement_Name() };
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.parsers.MessageFormatParser parser = new edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.parsers.MessageFormatParser(
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
	private IParser attributeName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getAttributeName_5001Parser() {
		if (attributeName_5001Parser == null) {
			EAttribute[] features = new EAttribute[] { edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage.eINSTANCE
					.getNamedElement_Name() };
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.parsers.MessageFormatParser parser = new edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.parsers.MessageFormatParser(
					features);
			attributeName_5001Parser = parser;
		}
		return attributeName_5001Parser;
	}

	/**
	 * @generated
	 */
	private MAVOElementLabelParser attributeLabel_5002Parser;

	/**
	 * @generated
	 */
	private IParser getAttributeLabel_5002Parser() {
		if (attributeLabel_5002Parser == null) {
			attributeLabel_5002Parser = new MAVOElementLabelParser();
		}
		return attributeLabel_5002Parser;
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
			EAttribute[] features = new EAttribute[] { edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage.eINSTANCE
					.getNamedElement_Name() };
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.parsers.MessageFormatParser parser = new edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.parsers.MessageFormatParser(
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
	private IParser associationName_6001Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationName_6001Parser() {
		if (associationName_6001Parser == null) {
			EAttribute[] features = new EAttribute[] { edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage.eINSTANCE
					.getNamedElement_Name() };
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.parsers.MessageFormatParser parser = new edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.parsers.MessageFormatParser(
					features);
			associationName_6001Parser = parser;
		}
		return associationName_6001Parser;
	}

	/**
	 * @generated
	 */
	private MAVOElementLabelParser associationLabel_6002Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationLabel_6002Parser() {
		if (associationLabel_6002Parser == null) {
			associationLabel_6002Parser = new MAVOElementLabelParser();
		}
		return associationLabel_6002Parser;
	}

	/**
	 * @generated
	 */
	private MAVOElementLabelParser nestedInReferenceLabel_6003Parser;

	/**
	 * @generated
	 */
	private IParser getNestedInReferenceLabel_6003Parser() {
		if (nestedInReferenceLabel_6003Parser == null) {
			nestedInReferenceLabel_6003Parser = new MAVOElementLabelParser();
		}
		return nestedInReferenceLabel_6003Parser;
	}

	/**
	 * @generated
	 */
	private MAVOElementLabelParser superclassReferenceLabel_6004Parser;

	/**
	 * @generated
	 */
	private IParser getSuperclassReferenceLabel_6004Parser() {
		if (superclassReferenceLabel_6004Parser == null) {
			superclassReferenceLabel_6004Parser = new MAVOElementLabelParser();
		}
		return superclassReferenceLabel_6004Parser;
	}

	/**
	 * @generated
	 */
	private MAVOElementLabelParser dependencyLabel_6005Parser;

	/**
	 * @generated
	 */
	private IParser getDependencyLabel_6005Parser() {
		if (dependencyLabel_6005Parser == null) {
			dependencyLabel_6005Parser = new MAVOElementLabelParser();
		}
		return dependencyLabel_6005Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.ClassNameEditPart.VISUAL_ID:
			return getClassName_5005Parser();
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.WrappingLabelEditPart.VISUAL_ID:
			return getClassLabel_5006Parser();
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.AttributeNameEditPart.VISUAL_ID:
			return getAttributeName_5001Parser();
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.WrappingLabel2EditPart.VISUAL_ID:
			return getAttributeLabel_5002Parser();
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.OperationNameEditPart.VISUAL_ID:
			return getOperationName_5003Parser();
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.WrappingLabel3EditPart.VISUAL_ID:
			return getOperationLabel_5004Parser();
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.AssociationNameEditPart.VISUAL_ID:
			return getAssociationName_6001Parser();
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.WrappingLabel4EditPart.VISUAL_ID:
			return getAssociationLabel_6002Parser();
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.WrappingLabel5EditPart.VISUAL_ID:
			return getNestedInReferenceLabel_6003Parser();
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.WrappingLabel6EditPart.VISUAL_ID:
			return getSuperclassReferenceLabel_6004Parser();
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.WrappingLabel7EditPart.VISUAL_ID:
			return getDependencyLabel_6005Parser();
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
			return getParser(edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOVisualIDRegistry
					.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOVisualIDRegistry
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
			if (edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes
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

/**
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
package edu.toronto.cs.se.mmint.repository;

/**
 * The list of all MMINT constants.
 * 
 * @author Alessio Di Sandro
 * 
 */
public interface MMINTConstants {

	public final static String URI_SEPARATOR = "/";
	public final static String MODEL_URI_SEPARATOR = "#";
	public final static String ECORE_MODEL_URI_SEPARATOR = MODEL_URI_SEPARATOR + URI_SEPARATOR;
	public final static String MODEL_FILENAMESUFFIX_SEPARATOR = "_";
	public final static String MODEL_FILEEXTENSION_SEPARATOR = ".";
	public final static String ENDPOINT_SEPARATOR = "-";
	public final static String EDITOR_SEPARATOR = "_";
	public final static String MODELELEMENT_EMFVALUE_PLACEHOLDER = "$1";
	public final static String MODELELEMENT_PRIMITIVEVALUE_PLACEHOLDER = "$2";
	public final static String MODELELEMENT_FEATURE_SEPARATOR1 = "[";
	public final static String MODELELEMENT_FEATURE_SEPARATOR2 = "]";
	public final static String MODELELEMENT_REFERENCE_SEPARATOR = "->";
	public final static String BINARY_MODELREL_LINK_SEPARATOR = "_To_";
	//TODO MMINT[MODELELEM] refine everywhere used when introducing additional model element level
	public final static String ROLE_SEPARATOR = "_AS_";
	/** The empty uri. */
	public final static String EMPTY_URI = "";
	/** The empty name. */
	public final static String EMPTY_NAME = "";
	/** The empty file extension for a model. */
	public final static String EMPTY_MODEL_FILE_EXTENSION = "";
	/** The base root uri. */
	public final static String ROOT_URI = "http://se.cs.toronto.edu/mmint";
	/** The uri of the root model type. */
	public final static String ROOT_MODEL_URI = ROOT_URI + URI_SEPARATOR + "Model";
	/** The uri of the root model relationship type. */
	public final static String ROOT_MODELREL_URI = ROOT_URI + URI_SEPARATOR + "ModelRel";
	/** The uri of the root model type endpoint. */
	public final static String ROOT_MODELENDPOINT_URI = ROOT_URI + URI_SEPARATOR + "ModelRel" + ENDPOINT_SEPARATOR + "Model" + URI_SEPARATOR + "ModelEndpoint";
	/** The uri of the root model element type. */
	public final static String ROOT_MODELELEM_URI = ROOT_MODEL_URI + ECORE_MODEL_URI_SEPARATOR + URI_SEPARATOR + "ModelElement";
	/** The uri of the root link type. */
	public final static String ROOT_LINK_URI = ROOT_MODELREL_URI + URI_SEPARATOR + "Link";
	/** The uri of the root model element type endpoint. */
	public final static String ROOT_MODELELEMENDPOINT_URI = ROOT_MODELREL_URI + URI_SEPARATOR + "Link" + ENDPOINT_SEPARATOR + "ModelElem" + URI_SEPARATOR + "ModelElemEndpoint";
	/** The uri of the root editor type. */
	public final static String ROOT_EDITOR_URI = ROOT_MODEL_URI + EDITOR_SEPARATOR + "tree";
	/** The name of the root editor type. */
	public final static String ROOT_EDITOR_NAME = "Ecore Reflective tree";
	/** The id of the root editor type. */
	public final static String ROOT_EDITOR_ID = "org.eclipse.emf.ecore.presentation.ReflectiveEditorID";

	/** An extension point's type child. */
	public final static String CHILD_TYPE = "type";
	/** An extension point's type child's name attribute. */
	public final static String TYPE_ATTR_NAME = "name";
	/** An extension point's type child's uri attribute. */
	public final static String TYPE_ATTR_URI = "uri";
	/** An extension point's type child's class attribute. */
	public final static String TYPE_ATTR_CLASS = "class";
	/** An extension point's type superType child. */
	public final static String TYPE_CHILD_SUPERTYPE = "superType";
	/** An extension point's type superType child's uri attribute. */
	public final static String TYPE_SUPERTYPE_ATTR_URI = "uri";
	/** An extension point's binaryType child. */
	public final static String CHILD_BINARYTYPE = "binaryType";
	/** An extension point's binaryType child's sourceTypeUri attribute. */
	public final static String BINARYTYPE_ATTR_SOURCETYPEURI = "sourceTypeUri";
	/** An extension point's binaryType child's targetTypeUri attribute. */
	public final static String BINARYTYPE_ATTR_TARGETTYPEURI = "targetTypeUri";

	/** An extension point's typeEndpoint child. */
	public final static String CHILD_TYPEENDPOINT = "typeEndpoint";
	/** An extension point's typeEndpoint child's lowerBound attribute. */
	public final static String TYPEENDPOINT_ATTR_LOWERBOUND = "lowerBound";
	/** An extension point's typeEndpoint child's upperBound attribute. */
	public final static String TYPEENDPOINT_ATTR_UPPERBOUND = "upperBound";
	/** An extension point's typeEndpoint child's targetTypeUri attribute. */
	public final static String TYPEENDPOINT_ATTR_TARGETTYPEURI = "targetTypeUri";

	/** The Models extension point's id. */
	public final static String MODELS_EXT_POINT = "edu.toronto.cs.se.mmint.models";
	/** The Models extension point's modelType child. */
	public final static String MODELS_CHILD_MODELTYPE = "modelType";
	/** The Models extension point's modelType's abstract attribute. */
	public final static String MODELS_MODELTYPE_ATTR_ABSTRACT = "isAbstract";
	/** The Models extension point's modelType's constraint child. */
	public final static String MODELS_MODELTYPE_CHILD_CONSTRAINT = "constraint";
	/** The Models extension point's modelType's constraint child's language attribute. */
	public final static String MODELS_MODELTYPE_CONSTRAINT_ATTR_LANGUAGE = "language";
	/** The Models extension point's modelType's constraint child's implementation attribute. */
	public final static String MODELS_MODELTYPE_CONSTRAINT_ATTR_IMPLEMENTATION = "implementation";

	/** The Editors extension point's id. */
	public final static String EDITORS_EXT_POINT = "edu.toronto.cs.se.mmint.editors";
	/** The Editors extension point's modelTypeUri attribute. */
	public final static String EDITORS_ATTR_MODELTYPEURI = "modelTypeUri";
	/** The Editors extension point's id attribute. */
	public final static String EDITORS_ATTR_ID = "id";
	/** The Editors extension point's isDiagram attribute. */
	public final static String EDITORS_ATTR_ISDIAGRAM = "isDiagram";
	/** The Editors extension point's wizardId attribute. */
	public final static String EDITORS_ATTR_WIZARDID = "wizardId";
	/** The Editors extension point's wizardDialogClass attribute. */
	public final static String EDITORS_ATTR_WIZARDDIALOGCLASS = "wizardDialogClass";

	/** The ModelRels extension point's id. */
	public final static String MODELRELS_EXT_POINT = "edu.toronto.cs.se.mmint.relationships";
	/** The ModelRels extension point's modelTypeEndpoint child. */
	public final static String MODELRELS_CHILD_MODELTYPEENDPOINT = "modelTypeEndpoint";
	/** The ModelRels extension point's modelTypeEndpoint's modelElemType child. */
	public final static String MODELRELS_MODELTYPEENDPOINT_CHILD_MODELELEMTYPE = "modelElemType";
	/** The ModelRels extension point's linkType child. */
	public final static String MODELRELS_CHILD_LINKTYPE = "linkType";
	/** The ModelRels extension point's linkType's modelElemTypeEndpoint child. */
	public final static String MODELRELS_LINKTYPE_CHILD_MODELELEMTYPEENDPOINT = "modelElemTypeEndpoint";

	/** The Operators extension point's id. */
	public final static String OPERATORS_EXT_POINT = "edu.toronto.cs.se.mmint.operators";
	/** The Operators extension point's generics child. */
	public final static String OPERATORS_CHILD_GENERICS = "generics";
	/** The Operators extension point's inputs child. */
	public final static String OPERATORS_CHILD_INPUTS = "inputs";
	/** The Operators extension point's outputs child. */
	public final static String OPERATORS_CHILD_OUTPUTS = "outputs";
	/** The Operators extension point's generics/inputs/outputs's parameter child. */
	public final static String OPERATORS_GENINOUT_CHILD_PARAMETER = "parameter";

	/** The Eclipse's Editors extension point's id. */
	public final static String ECLIPSE_EDITORS_EXT_POINT = "org.eclipse.ui.editors";
	/** The Eclipse's Editors extension's id attribute. */
	public final static String ECLIPSE_EDITORS_ATTR_ID = "id";
	/** The Eclipse's Editors extension's extensions attribute. */
	public final static String ECLIPSE_EDITORS_ATTR_EXTENSIONS = "extensions";

	/** The Reasoners extension point's id. */
	public final static String REASONERS_EXT_POINT = "edu.toronto.cs.se.mmint.reasoners";
	/** The Reasoners extension point's reasoner child. */
	public final static String REASONERS_CHILD_REASONER = "reasoner";
	/** The Reasoners extension point's reasoner's name attribute. */
	public final static String REASONERS_REASONER_ATTR_NAME = "name";
	/** The Reasoners extension point's reasoner's class attribute. */
	public final static String REASONERS_REASONER_ATTR_CLASS = "class";
	/** The Reasoners extension point's reasoner's language child. */
	public final static String REASONERS_REASONER_CHILD_LANGUAGE = "language";
	/** The Reasoners extension point's reasoner's language child's id attribute. */
	public final static String REASONERS_REASONER_LANGUAGE_ATTR_ID = "id";

	public final static String PREFERENCE_MMINT_ID = "edu.toronto.cs.se.mmint";
	public final static String PREFERENCE_MENU_ID = PREFERENCE_MMINT_ID + ".mid.diagram.menu";
	public final static String PREFERENCE_MENU_ICONS_ENABLED = PREFERENCE_MENU_ID + ".IconsEnabled";
	public final static String PREFERENCE_MENU_MODELRELS_ENABLED = PREFERENCE_MENU_ID + ".ModelRelsEnabled";
	public final static String PREFERENCE_MENU_MODELRELENDPOINTS_ENABLED = PREFERENCE_MENU_ID + ".ModelRelEndpointsEnabled";
	public final static String PREFERENCE_MENU_OPERATORENDPOINTS_ENABLED = PREFERENCE_MENU_ID + ".OperatorEndpointsEnabled";
	public final static String PREFERENCE_MENU_LANGUAGE_REASONER = PREFERENCE_MENU_ID + ".Reasoner";
	public final static String PREFERENCE_TESTS_ENABLED = PREFERENCE_MMINT_ID + ".TestsEnabled";

}

/**
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint;

import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

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
	public final static String BINARY_MODELREL_SEPARATOR = "->";
	//TODO MMINT[MODELELEMENT] refine everywhere used when introducing additional model element level
	public final static String ROLE_SEPARATOR = "_AS_";
	/** The empty uri/id. */
	public final static String EMPTY_ID = "";
	/** The empty name. */
	public final static String EMPTY_NAME = "";
	/** The empty file extension for a model. */
	public final static String EMPTY_MODEL_FILE_EXTENSION = "";
	/** The base root uri. */
	public final static String ROOT_URI = "http://se.cs.toronto.edu/mmint";
	/** The uri of the root model type. */
	public final static String ROOT_MODEL_URI = ROOT_URI + URI_SEPARATOR + Model.class.getSimpleName();
	/** The uri of the root model relationship type. */
	public final static String ROOT_MODELREL_URI = ROOT_URI + URI_SEPARATOR + ModelRel.class.getSimpleName();
	/** The uri of the root model type endpoint. */
	public final static String ROOT_MODELENDPOINT_URI = ROOT_MODELREL_URI + ENDPOINT_SEPARATOR + Model.class.getSimpleName() + URI_SEPARATOR + ModelEndpoint.class.getSimpleName();
	/** The uri of the root model element type. */
	public final static String ROOT_MODELELEM_URI = ROOT_MODEL_URI + ECORE_MODEL_URI_SEPARATOR + URI_SEPARATOR + ModelElement.class.getSimpleName();
	/** The uri of the root link type. */
	public final static String ROOT_MAPPING_URI = ROOT_MODELREL_URI + URI_SEPARATOR + Mapping.class.getSimpleName();
	/** The uri of the root model element type endpoint. */
	//TODO MMINT[MISC] Migrate to use class names
	public final static String ROOT_MODELELEMENDPOINT_URI = ROOT_MAPPING_URI + ENDPOINT_SEPARATOR + "ModelElem" + URI_SEPARATOR + "ModelElemEndpoint";
	/** The uri of the root operator type. */
	public final static String ROOT_OPERATOR_URI = ROOT_URI + URI_SEPARATOR + Operator.class.getSimpleName();
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
	/** An extension point's type child's abstract attribute. */
	public final static String TYPE_ATTR_ISABSTRACT = "isAbstract";
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

	/** An extension point's constraint child. */
	public final static String CHILD_CONSTRAINT = "constraint";
	/** An extension point's constraint child's language attribute. */
	public final static String CONSTRAINT_ATTR_LANGUAGE = "language";
	/** An extension point's constraint child's implementation attribute. */
	public final static String CONSTRAINT_ATTR_IMPLEMENTATION = "implementation";

	/** An extension point's endpointConstraint child. */
	public final static String CHILD_ENDPOINTCONSTRAINT = "endpointConstraint";
	/** An extension point's endpointConstraint child's parameterName attribute. */
	public final static String ENDPOINTCONSTRAINT_ATTR_PARAMETERNAME = "parameterName";
	/** An extension point's endpointConstraint child's endpointIndex attribute. */
	public final static String ENDPOINTCONSTRAINT_ATTR_ENDPOINTINDEX = "endpointIndex";

	/** The Models extension point's id. */
	public final static String MODELS_EXT_POINT = "edu.toronto.cs.se.mmint.models";
	/** The Models extension point's modelType child. */
	public final static String MODELS_CHILD_MODELTYPE = "modelType";

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
	/** The ModelRels extension point's mappingType child. */
	public final static String MODELRELS_CHILD_MAPPINGTYPE = "mappingType";
	/** The ModelRels extension point's mappingType's modelElemTypeEndpoint child. */
	public final static String MODELRELS_MAPPINGTYPE_CHILD_MODELELEMTYPEENDPOINT = "modelElemTypeEndpoint";

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
	public final static String PREFERENCE_MENU_OPERATORS_ENABLED = PREFERENCE_MENU_ID + ".OperatorsEnabled";
	public final static String PREFERENCE_MENU_OPERATORENDPOINTS_ENABLED = PREFERENCE_MENU_ID + ".OperatorEndpointsEnabled";
	public final static String PREFERENCE_MENU_OPENMODELEDITORS_ENABLED = PREFERENCE_MENU_ID + ".OpenModelEditorsEnabled";
	public final static String PREFERENCE_MENU_POLYMORPHISM_ENABLED = PREFERENCE_MENU_ID + ".PolymorphismEnabled";
	public final static String PREFERENCE_MENU_DELETEMODELFILE_ENABLED = PREFERENCE_MENU_ID + ".DeleteModelFileEnabled";
	public final static String PREFERENCE_MENU_LANGUAGE_REASONER = PREFERENCE_MENU_ID + ".Reasoner";
	public final static String PREFERENCE_TESTS_ENABLED = PREFERENCE_MMINT_ID + ".TestsEnabled";

}

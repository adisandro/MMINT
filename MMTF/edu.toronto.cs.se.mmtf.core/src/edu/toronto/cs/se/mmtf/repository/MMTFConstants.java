/**
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
package edu.toronto.cs.se.mmtf.repository;

/**
 * The list of all MMTF constants.
 * 
 * @author Alessio Di Sandro
 * 
 */
public interface MMTFConstants {

	public final static String URI_SEPARATOR = "/";
	public final static String ENDPOINT_SEPARATOR = "-";
	public final static String ROOT_URI = "http://se.cs.toronto.edu/mmtf";
	/** The uri of the root model type. */
	public final static String ROOT_MODEL_URI = ROOT_URI + URI_SEPARATOR + "Model";
	/** The uri of the root model relationship type. */
	public final static String ROOT_MODELREL_URI = ROOT_URI + URI_SEPARATOR + "ModelRel";
	/** The uri of the root model type endpoint. */
	public final static String ROOT_MODELENDPOINT_URI = ROOT_URI + URI_SEPARATOR + "ModelRel" + ENDPOINT_SEPARATOR + "Model" + URI_SEPARATOR + "ModelEndpoint";
	/** The uri of the root model element type of category entity. */
	public final static String ROOT_MODELELEMENT_ENTITY_URI = ROOT_MODEL_URI + URI_SEPARATOR + "EntityElem";
	/** The uri of the root model element type of category relationship. */
	public final static String ROOT_MODELELEMENT_RELATIONSHIP_URI = ROOT_MODEL_URI + URI_SEPARATOR + "RelElem";
	/** The uri of the root link type. */
	public final static String ROOT_MODELREL_LINK_URI = ROOT_MODELREL_URI + URI_SEPARATOR + "Link";
	/** The uri of the root link type endpoint of category entity. */
	public final static String ROOT_MODELREL_LINKENDPOINT_ENTITY_URI = ROOT_MODELREL_URI + URI_SEPARATOR + "Link" + ENDPOINT_SEPARATOR + "EntityElem" + URI_SEPARATOR + "EntityElemEndpoint";
	/** The uri of the root link type endpoint of category relationship. */
	public final static String ROOT_MODELREL_LINKENDPOINT_RELATIONSHIP_URI = ROOT_MODELREL_URI + URI_SEPARATOR + "Link" + ENDPOINT_SEPARATOR + "RelElem" + URI_SEPARATOR + "RelElemEndpoint";

	/** An extension point's extendibleType child. */
	public final static String CHILD_EXTENDIBLETYPE = "extendibleType";
	/** An extension point's extendibleType child's name attribute. */
	public final static String EXTENDIBLETYPE_ATTR_NAME = "name";
	/** An extension point's extendibleType child's uri attribute. */
	public final static String EXTENDIBLETYPE_ATTR_URI = "uri";
	/** An extension point's extendibleType child's supertypeUri attribute. */
	public final static String EXTENDIBLETYPE_ATTR_SUPERTYPEURI = "supertypeUri";

	/** An extension point's typeEndpoint child. */
	public final static String CHILD_TYPEENDPOINT = "typeEndpoint";
	/** An extension point's typeEndpoint child's lowerBound attribute. */
	public final static String TYPEENDPOINT_ATTR_LOWERBOUND = "lowerBound";
	/** An extension point's typeEndpoint child's upperBound attribute. */
	public final static String TYPEENDPOINT_ATTR_UPPERBOUND = "upperBound";
	/** An extension point's typeEndpoint child's targetTypeUri attribute. */
	public final static String TYPEENDPOINT_ATTR_TARGETTYPEURI = "targetTypeUri";

	/** The Models extension point's id. */
	public final static String MODELS_EXT_POINT = "edu.toronto.cs.se.mmtf.models";
	/** The Models extension point's modelType child. */
	public final static String MODELS_CHILD_MODELTYPE = "modelType";
	/** The Models extension point's modelType child's constraint attribute. */
	public final static String MODELS_MODELTYPE_ATTR_CONSTRAINT = "constraint";

	/** The Editors extension point's id. */
	public final static String EDITORS_EXT_POINT = "edu.toronto.cs.se.mmtf.editors";
	/** The Editors extension point's modelTypeUri attribute. */
	public final static String EDITORS_ATTR_MODELTYPEURI = "modelTypeUri";
	/** The Editors extension point's id attribute. */
	public final static String EDITORS_ATTR_ID = "id";
	/** The Editors extension point's isDiagram attribute. */
	public final static String EDITORS_ATTR_ISDIAGRAM = "isDiagram";
	/** The Editors extension point's wizardId attribute. */
	public final static String EDITORS_ATTR_WIZARDID = "wizardId";

	/** The ModelRels extension point's id. */
	public final static String MODELRELS_EXT_POINT = "edu.toronto.cs.se.mmtf.relationships";
	/** The ModelRels extension point's modelTypeEndpoint child. */
	public final static String MODELRELS_CHILD_MODELTYPEENDPOINT = "modelTypeEndpoint";
	/** The ModelRels extension point's modelTypeEndpoint's modelElemType child. */
	public final static String MODELRELS_MODELTYPEENDPOINT_CHILD_MODELELEMTYPE = "modelElemType";
	/** The ModelRels extension point's modelTypeEndpoint's modelElemType child's category attribute. */
	public final static String MODELRELS_MODELTYPEENDPOINT_MODELELEMTYPE_ATTR_CATEGORY = "category";
	/** The ModelRels extension point's modelTypeEndpoint's modelElemType child's classLiteral attribute. */
	public final static String MODELRELS_MODELTYPEENDPOINT_MODELELEMTYPE_ATTR_CLASSLITERAL = "classLiteral";
	/** The ModelRels extension point's linkType child. */
	public final static String MODELRELS_CHILD_LINKTYPE = "linkType";
	/** The ModelRels extension point's linkType's modelElemTypeEndpoint child. */
	public final static String MODELRELS_LINKTYPE_CHILD_MODELELEMTYPEENDPOINT = "modelElemTypeEndpoint";

	/** The Operators extension point's id. */
	public final static String OPERATORS_EXT_POINT = "edu.toronto.cs.se.mmtf.operators";
	/** The Operators extension point's class attribute. */
	public final static String OPERATORS_ATTR_CLASS = "class";
	/** The Operators extension point's isConversion attribute. */
	public final static String OPERATORS_ATTR_ISCONVERSION = "isConversion";
	/** The Operators extension point's input child. */
	public final static String OPERATORS_CHILD_INPUT = "input";
	/** The Operators extension point's output child. */
	public final static String OPERATORS_CHILD_OUTPUT = "output";
	/** The Operators extension point's input/output's parameter child. */
	public final static String OPERATORS_INPUTOUTPUT_CHILD_PARAMETER = "parameter";
	/** The Operators extension point's input/output's parameter child's name attribute. */
	public final static String OPERATORS_INPUTOUTPUT_PARAMETER_ATTR_NAME = "name";
	/** The Operators extension point's input/output's parameter child's isVararg attribute. */
	public final static String OPERATORS_INPUTOUTPUT_PARAMETER_ATTR_ISVARARG = "isVararg";
	/** The Operators extension point's input/output's parameter child's modelTypeUri attribute. */
	public final static String OPERATORS_INPUTOUTPUT_PARAMETER_ATTR_MODELTYPEURI = "modelTypeUri";

	/** The Eclipse's Editors extension point's id. */
	public final static String ECLIPSE_EDITORS_EXT_POINT = "org.eclipse.ui.editors";
	/** The Eclipse's Editors extension's id attribute. */
	public final static String ECLIPSE_EDITORS_ATTR_ID = "id";
	/** The Eclipse's Editors extension's extensions attribute. */
	public final static String ECLIPSE_EDITORS_ATTR_EXTENSIONS = "extensions";

}

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
 * The list of all the fields in MMTF's extension points.
 * 
 * @author Alessio Di Sandro
 * 
 */
public interface MMTFExtensionPoints {

	/** The uri of the root model type. */
	public final static String ROOT_MODEL_URI = "http:///edu/toronto/cs/se/mmtf/Model";
	/** The uri of the root model relationship. */
	public final static String ROOT_MODELREL_URI = "http:///edu/toronto/cs/se/mmtf/ModelRel";
	/** The uri of the root model element of category entity. */
	public final static String ROOT_MODELELEMENT_ENTITY_URI = "http:///edu/toronto/cs/se/mmtf/ModelRel/ModelElementEntityWildcard";
	/** The uri of the root model element of category relationship. */
	public final static String ROOT_MODELELEMENT_RELATIONSHIP_URI = "http:///edu/toronto/cs/se/mmtf/ModelRel/ModelElementEntityWildcard/modelElementRelationshipWildcard";
	/** The uri of the root link among model elements. */
	public final static String ROOT_MODELREL_LINK_URI = "http:///edu/toronto/cs/se/mmtf/ModelRel/Link";

	/** An extension point's extendibleElement child. */
	public final static String CHILD_EXTENDIBLEELEMENT = "extendibleElement";
	/** An extension point's extendibleElement child's uri attribute. */
	public final static String EXTENDIBLEELEMENT_ATTR_URI = "uri";
	/** An extension point's extendibleElement child's supertypeUri attribute. */
	public final static String EXTENDIBLEELEMENT_ATTR_SUPERTYPEURI = "supertypeUri";

	/** The Models extension point's id. */
	public final static String MODELS_EXT_POINT = "edu.toronto.cs.se.mmtf.models";

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
	/** The ModelRels extension point's isNary attribute. */
	public final static String MODELRELS_ATTR_ISNARY = "isNary";
	/** The ModelRels extension point's model child. */
	public final static String MODELRELS_CHILD_MODEL = "model";
	/** The ModelRels extension point's model child's modelTypeUri attribute. */
	public final static String MODELRELS_MODEL_ATTR_MODELTYPEURI = "modelTypeUri";
	/** The ModelRels extension point's model's modelElement child. */
	public final static String MODELRELS_MODEL_CHILD_MODELELEMENT = "modelElement";
	/** The ModelRels extension point's model's modelElement child's name attribute. */
	public final static String MODELRELS_MODEL_MODELELEMENT_ATTR_NAME = "name";
	/** The ModelRels extension point's model's modelElement child's category attribute. */
	public final static String MODELRELS_MODEL_MODELELEMENT_ATTR_CATEGORY = "category";
	/** The ModelRels extension point's model's modelElement child's classLiteral attribute. */
	public final static String MODELRELS_MODEL_MODELELEMENT_ATTR_CLASSLITERAL = "classLiteral";
	/** The ModelRels extension point's link child. */
	public final static String MODELRELS_CHILD_LINK = "link";
	/** The ModelRels extension point's link child's isNary attribute. */
	public final static String MODELRELS_LINK_ATTR_ISNARY = "isNary";
	/** The ModelRels extension point's link child's name attribute. */
	public final static String MODELRELS_LINK_ATTR_NAME = "name";
	/** The ModelRels extension point's link's linkElement child. */
	public final static String MODELRELS_LINK_CHILD_LINKELEMENT = "linkElement";
	/** The ModelRels extension point's link's linkElement child's elementName attribute. */
	public final static String MODELRELS_LINK_LINKELEMENT_ATTR_ELEMENTNAME = "elementName";

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

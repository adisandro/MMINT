/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.randommodel;

import edu.toronto.cs.se.mmtf.mavo.MavoPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.modelepedia.randommodel.RandomModelFactory
 * @model kind="package"
 * @generated
 */
public interface RandomModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "randommodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://se.cs.toronto.edu/modelepedia/RandomModel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "randommodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RandomModelPackage eINSTANCE = edu.toronto.cs.se.modelepedia.randommodel.impl.RandomModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.randommodel.impl.RandomModelImpl <em>Random Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.randommodel.impl.RandomModelImpl
	 * @see edu.toronto.cs.se.modelepedia.randommodel.impl.RandomModelPackageImpl#getRandomModel()
	 * @generated
	 */
	int RANDOM_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Inc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_MODEL__INC = MavoPackage.MAVO_MODEL__INC;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_MODEL__NODES = MavoPackage.MAVO_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_MODEL__EDGES = MavoPackage.MAVO_MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_MODEL__NAME = MavoPackage.MAVO_MODEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_MODEL__TYPE = MavoPackage.MAVO_MODEL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Default Minimum Number Of Instances</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_MODEL__DEFAULT_MINIMUM_NUMBER_OF_INSTANCES = MavoPackage.MAVO_MODEL_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Default Maximum Number Of Instances</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_MODEL__DEFAULT_MAXIMUM_NUMBER_OF_INSTANCES = MavoPackage.MAVO_MODEL_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Random Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_MODEL_FEATURE_COUNT = MavoPackage.MAVO_MODEL_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Random Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_MODEL_OPERATION_COUNT = MavoPackage.MAVO_MODEL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.randommodel.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.randommodel.impl.NamedElementImpl
	 * @see edu.toronto.cs.se.modelepedia.randommodel.impl.RandomModelPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__MAY = MavoPackage.MAVO_ELEMENT__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__SET = MavoPackage.MAVO_ELEMENT__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__VAR = MavoPackage.MAVO_ELEMENT__VAR;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = MavoPackage.MAVO_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__TYPE = MavoPackage.MAVO_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Minimum Number Of Instances</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__MINIMUM_NUMBER_OF_INSTANCES = MavoPackage.MAVO_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Maximum Number Of Instances</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__MAXIMUM_NUMBER_OF_INSTANCES = MavoPackage.MAVO_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = MavoPackage.MAVO_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_OPERATION_COUNT = MavoPackage.MAVO_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.randommodel.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.randommodel.impl.NodeImpl
	 * @see edu.toronto.cs.se.modelepedia.randommodel.impl.RandomModelPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 1;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__MAY = NAMED_ELEMENT__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__SET = NAMED_ELEMENT__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__VAR = NAMED_ELEMENT__VAR;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__TYPE = NAMED_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Minimum Number Of Instances</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__MINIMUM_NUMBER_OF_INSTANCES = NAMED_ELEMENT__MINIMUM_NUMBER_OF_INSTANCES;

	/**
	 * The feature id for the '<em><b>Maximum Number Of Instances</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__MAXIMUM_NUMBER_OF_INSTANCES = NAMED_ELEMENT__MAXIMUM_NUMBER_OF_INSTANCES;

	/**
	 * The feature id for the '<em><b>Edges As Src</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__EDGES_AS_SRC = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Edges As Tgt</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__EDGES_AS_TGT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.randommodel.impl.EdgeImpl <em>Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.randommodel.impl.EdgeImpl
	 * @see edu.toronto.cs.se.modelepedia.randommodel.impl.RandomModelPackageImpl#getEdge()
	 * @generated
	 */
	int EDGE = 2;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__MAY = NAMED_ELEMENT__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__SET = NAMED_ELEMENT__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__VAR = NAMED_ELEMENT__VAR;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__TYPE = NAMED_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Minimum Number Of Instances</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__MINIMUM_NUMBER_OF_INSTANCES = NAMED_ELEMENT__MINIMUM_NUMBER_OF_INSTANCES;

	/**
	 * The feature id for the '<em><b>Maximum Number Of Instances</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__MAXIMUM_NUMBER_OF_INSTANCES = NAMED_ELEMENT__MAXIMUM_NUMBER_OF_INSTANCES;

	/**
	 * The feature id for the '<em><b>Src</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__SRC = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tgt</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__TGT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.randommodel.RandomModel <em>Random Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Random Model</em>'.
	 * @see edu.toronto.cs.se.modelepedia.randommodel.RandomModel
	 * @generated
	 */
	EClass getRandomModel();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.randommodel.RandomModel#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see edu.toronto.cs.se.modelepedia.randommodel.RandomModel#getNodes()
	 * @see #getRandomModel()
	 * @generated
	 */
	EReference getRandomModel_Nodes();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.randommodel.RandomModel#getEdges <em>Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Edges</em>'.
	 * @see edu.toronto.cs.se.modelepedia.randommodel.RandomModel#getEdges()
	 * @see #getRandomModel()
	 * @generated
	 */
	EReference getRandomModel_Edges();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.randommodel.RandomModel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.toronto.cs.se.modelepedia.randommodel.RandomModel#getName()
	 * @see #getRandomModel()
	 * @generated
	 */
	EAttribute getRandomModel_Name();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.randommodel.RandomModel#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see edu.toronto.cs.se.modelepedia.randommodel.RandomModel#getType()
	 * @see #getRandomModel()
	 * @generated
	 */
	EAttribute getRandomModel_Type();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.randommodel.RandomModel#getDefaultMinimumNumberOfInstances <em>Default Minimum Number Of Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Minimum Number Of Instances</em>'.
	 * @see edu.toronto.cs.se.modelepedia.randommodel.RandomModel#getDefaultMinimumNumberOfInstances()
	 * @see #getRandomModel()
	 * @generated
	 */
	EAttribute getRandomModel_DefaultMinimumNumberOfInstances();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.randommodel.RandomModel#getDefaultMaximumNumberOfInstances <em>Default Maximum Number Of Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Maximum Number Of Instances</em>'.
	 * @see edu.toronto.cs.se.modelepedia.randommodel.RandomModel#getDefaultMaximumNumberOfInstances()
	 * @see #getRandomModel()
	 * @generated
	 */
	EAttribute getRandomModel_DefaultMaximumNumberOfInstances();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.randommodel.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see edu.toronto.cs.se.modelepedia.randommodel.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.randommodel.Node#getEdgesAsSrc <em>Edges As Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Edges As Src</em>'.
	 * @see edu.toronto.cs.se.modelepedia.randommodel.Node#getEdgesAsSrc()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_EdgesAsSrc();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.randommodel.Node#getEdgesAsTgt <em>Edges As Tgt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Edges As Tgt</em>'.
	 * @see edu.toronto.cs.se.modelepedia.randommodel.Node#getEdgesAsTgt()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_EdgesAsTgt();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.randommodel.Edge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge</em>'.
	 * @see edu.toronto.cs.se.modelepedia.randommodel.Edge
	 * @generated
	 */
	EClass getEdge();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.randommodel.Edge#getSrc <em>Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Src</em>'.
	 * @see edu.toronto.cs.se.modelepedia.randommodel.Edge#getSrc()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Src();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.randommodel.Edge#getTgt <em>Tgt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Tgt</em>'.
	 * @see edu.toronto.cs.se.modelepedia.randommodel.Edge#getTgt()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Tgt();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.randommodel.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see edu.toronto.cs.se.modelepedia.randommodel.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.randommodel.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.toronto.cs.se.modelepedia.randommodel.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.randommodel.NamedElement#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see edu.toronto.cs.se.modelepedia.randommodel.NamedElement#getType()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Type();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.randommodel.NamedElement#getMinimumNumberOfInstances <em>Minimum Number Of Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum Number Of Instances</em>'.
	 * @see edu.toronto.cs.se.modelepedia.randommodel.NamedElement#getMinimumNumberOfInstances()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_MinimumNumberOfInstances();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.randommodel.NamedElement#getMaximumNumberOfInstances <em>Maximum Number Of Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum Number Of Instances</em>'.
	 * @see edu.toronto.cs.se.modelepedia.randommodel.NamedElement#getMaximumNumberOfInstances()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_MaximumNumberOfInstances();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RandomModelFactory getRandomModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.randommodel.impl.RandomModelImpl <em>Random Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.randommodel.impl.RandomModelImpl
		 * @see edu.toronto.cs.se.modelepedia.randommodel.impl.RandomModelPackageImpl#getRandomModel()
		 * @generated
		 */
		EClass RANDOM_MODEL = eINSTANCE.getRandomModel();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RANDOM_MODEL__NODES = eINSTANCE.getRandomModel_Nodes();

		/**
		 * The meta object literal for the '<em><b>Edges</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RANDOM_MODEL__EDGES = eINSTANCE.getRandomModel_Edges();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANDOM_MODEL__NAME = eINSTANCE.getRandomModel_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANDOM_MODEL__TYPE = eINSTANCE.getRandomModel_Type();

		/**
		 * The meta object literal for the '<em><b>Default Minimum Number Of Instances</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANDOM_MODEL__DEFAULT_MINIMUM_NUMBER_OF_INSTANCES = eINSTANCE.getRandomModel_DefaultMinimumNumberOfInstances();

		/**
		 * The meta object literal for the '<em><b>Default Maximum Number Of Instances</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANDOM_MODEL__DEFAULT_MAXIMUM_NUMBER_OF_INSTANCES = eINSTANCE.getRandomModel_DefaultMaximumNumberOfInstances();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.randommodel.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.randommodel.impl.NodeImpl
		 * @see edu.toronto.cs.se.modelepedia.randommodel.impl.RandomModelPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Edges As Src</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__EDGES_AS_SRC = eINSTANCE.getNode_EdgesAsSrc();

		/**
		 * The meta object literal for the '<em><b>Edges As Tgt</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__EDGES_AS_TGT = eINSTANCE.getNode_EdgesAsTgt();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.randommodel.impl.EdgeImpl <em>Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.randommodel.impl.EdgeImpl
		 * @see edu.toronto.cs.se.modelepedia.randommodel.impl.RandomModelPackageImpl#getEdge()
		 * @generated
		 */
		EClass EDGE = eINSTANCE.getEdge();

		/**
		 * The meta object literal for the '<em><b>Src</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__SRC = eINSTANCE.getEdge_Src();

		/**
		 * The meta object literal for the '<em><b>Tgt</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__TGT = eINSTANCE.getEdge_Tgt();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.randommodel.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.randommodel.impl.NamedElementImpl
		 * @see edu.toronto.cs.se.modelepedia.randommodel.impl.RandomModelPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__TYPE = eINSTANCE.getNamedElement_Type();

		/**
		 * The meta object literal for the '<em><b>Minimum Number Of Instances</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__MINIMUM_NUMBER_OF_INSTANCES = eINSTANCE.getNamedElement_MinimumNumberOfInstances();

		/**
		 * The meta object literal for the '<em><b>Maximum Number Of Instances</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__MAXIMUM_NUMBER_OF_INSTANCES = eINSTANCE.getNamedElement_MaximumNumberOfInstances();

	}

} //RandomModelPackage

/**
 * Copyright (c) 2012-2019 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Nick Fung.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 *    Nick Fung - Implementation.
 */
package edu.toronto.cs.se.modelepedia.safetycase;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage
 * @generated
 */
public interface SafetyCaseFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SafetyCaseFactory eINSTANCE = edu.toronto.cs.se.modelepedia.safetycase.impl.SafetyCaseFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Safety Case</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Safety Case</em>'.
	 * @generated
	 */
	SafetyCase createSafetyCase();

	/**
	 * Returns a new object of class '<em>Supported By</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Supported By</em>'.
	 * @generated
	 */
	SupportedBy createSupportedBy();

	/**
	 * Returns a new object of class '<em>In Context Of</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>In Context Of</em>'.
	 * @generated
	 */
	InContextOf createInContextOf();

	/**
	 * Returns a new object of class '<em>Basic Goal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Basic Goal</em>'.
	 * @generated
	 */
	BasicGoal createBasicGoal();

	/**
	 * Returns a new object of class '<em>Independence Goal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Independence Goal</em>'.
	 * @generated
	 */
	IndependenceGoal createIndependenceGoal();

	/**
	 * Returns a new object of class '<em>Basic Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Basic Strategy</em>'.
	 * @generated
	 */
	BasicStrategy createBasicStrategy();

	/**
	 * Returns a new object of class '<em>ASIL Decomposition Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ASIL Decomposition Strategy</em>'.
	 * @generated
	 */
	ASILDecompositionStrategy createASILDecompositionStrategy();

	/**
	 * Returns a new object of class '<em>Solution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Solution</em>'.
	 * @generated
	 */
	Solution createSolution();

	/**
	 * Returns a new object of class '<em>Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Context</em>'.
	 * @generated
	 */
	Context createContext();

	/**
	 * Returns a new object of class '<em>Justification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Justification</em>'.
	 * @generated
	 */
	Justification createJustification();

	/**
	 * Returns a new object of class '<em>Assumption</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assumption</em>'.
	 * @generated
	 */
	Assumption createAssumption();

	/**
	 * Returns a new object of class '<em>ASIL</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ASIL</em>'.
	 * @generated
	 */
	ASIL createASIL();

	/**
	 * Returns a new object of class '<em>Impact Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Impact Annotation</em>'.
	 * @generated
	 */
	ImpactAnnotation createImpactAnnotation();

	/**
	 * Returns a new object of class '<em>And Supporter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>And Supporter</em>'.
	 * @generated
	 */
	AndSupporter createAndSupporter();

	/**
	 * Returns a new object of class '<em>Or Supporter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Or Supporter</em>'.
	 * @generated
	 */
	OrSupporter createOrSupporter();

	/**
	 * Returns a new object of class '<em>Xor Supporter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Xor Supporter</em>'.
	 * @generated
	 */
	XorSupporter createXorSupporter();

	/**
	 * Returns a new object of class '<em>Mof NSupporter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mof NSupporter</em>'.
	 * @generated
	 */
	MofNSupporter createMofNSupporter();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SafetyCasePackage getSafetyCasePackage();

} //SafetyCaseFactory

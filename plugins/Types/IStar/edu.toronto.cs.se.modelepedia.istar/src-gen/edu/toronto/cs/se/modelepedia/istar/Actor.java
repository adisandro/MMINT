/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.istar;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.Actor#getIntentions <em>Intentions</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.modelepedia.istar.IStarPackage#getActor()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='noDependums'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot noDependums='intentions->forAll(dependerLinks->isEmpty() and dependeeLinks->isEmpty())'"
 *        annotation="gmf.node figure='ellipse' border.style='dash' border.width='2'"
 * @generated
 */
public interface Actor extends DependencyEndpoint {
	/**
	 * Returns the value of the '<em><b>Intentions</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.istar.Intention}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Intentions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intentions</em>' containment reference list.
	 * @see edu.toronto.cs.se.modelepedia.istar.IStarPackage#getActor_Intentions()
	 * @model containment="true"
	 *        annotation="gmf.compartment layout='free'"
	 * @generated
	 */
	EList<Intention> getIntentions();

} // Actor

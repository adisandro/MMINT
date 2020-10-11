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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IStar</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.IStar#getActors <em>Actors</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.IStar#getDependums <em>Dependums</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.modelepedia.istar.IStarPackage#getIStar()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='onlyDependums'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot onlyDependums='dependums->forAll(linksAsSrc->isEmpty() and linksAsTgt->isEmpty())'"
 * @generated
 */
public interface IStar extends EObject {
	/**
	 * Returns the value of the '<em><b>Actors</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.istar.Actor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actors</em>' containment reference list.
	 * @see edu.toronto.cs.se.modelepedia.istar.IStarPackage#getIStar_Actors()
	 * @model containment="true"
	 * @generated
	 */
	EList<Actor> getActors();

	/**
	 * Returns the value of the '<em><b>Dependums</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.istar.Intention}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependums</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependums</em>' containment reference list.
	 * @see edu.toronto.cs.se.modelepedia.istar.IStarPackage#getIStar_Dependums()
	 * @model containment="true"
	 * @generated
	 */
	EList<Intention> getDependums();

} // IStar

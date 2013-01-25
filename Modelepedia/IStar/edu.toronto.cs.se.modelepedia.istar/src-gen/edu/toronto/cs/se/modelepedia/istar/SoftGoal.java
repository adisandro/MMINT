/**
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro, Vivien Suen - Implementation.
 */
package edu.toronto.cs.se.modelepedia.istar;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Soft Goal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar.SoftGoal#getContributionsAsContributee <em>Contributions As Contributee</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.modelepedia.istar.IStarPackage#getSoftGoal()
 * @model
 * @generated
 */
public interface SoftGoal extends Goal {
	/**
	 * Returns the value of the '<em><b>Contributions As Contributee</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.istar.Contribution}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.istar.Contribution#getContributee <em>Contributee</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contributions As Contributee</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contributions As Contributee</em>' reference list.
	 * @see edu.toronto.cs.se.modelepedia.istar.IStarPackage#getSoftGoal_ContributionsAsContributee()
	 * @see edu.toronto.cs.se.modelepedia.istar.Contribution#getContributee
	 * @model opposite="contributee"
	 * @generated
	 */
	EList<Contribution> getContributionsAsContributee();

} // SoftGoal

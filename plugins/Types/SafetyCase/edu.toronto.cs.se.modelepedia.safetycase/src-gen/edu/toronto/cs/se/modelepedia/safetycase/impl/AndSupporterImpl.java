/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
package edu.toronto.cs.se.modelepedia.safetycase.impl;

import edu.toronto.cs.se.modelepedia.safetycase.AndSupporter;
import edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>And Supporter</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class AndSupporterImpl extends SupportConnectorImpl implements AndSupporter {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AndSupporterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SafetyCasePackage.Literals.AND_SUPPORTER;
	}

} //AndSupporterImpl

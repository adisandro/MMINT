/**
 * Copyright (c) 2012-2023 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.classdiagram_mavo;

import edu.toronto.cs.se.mavo.MAVOReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Superclass Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.SuperclassReference#getSource <em>Source</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.SuperclassReference#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage#getSuperclassReference()
 * @model annotation="gmf.link target.decoration='closedarrow' source='source' target='target'"
 * @generated
 */
public interface SuperclassReference extends MAVOReference {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class#getSuperclass <em>Superclass</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' container reference.
	 * @see #setSource(edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class)
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage#getSuperclassReference_Source()
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class#getSuperclass
	 * @model opposite="superclass" required="true" transient="false"
	 * @generated
	 */
	edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class getSource();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.SuperclassReference#getSource <em>Source</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' container reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class#getSubclasses <em>Subclasses</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class)
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage#getSuperclassReference_Target()
	 * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class#getSubclasses
	 * @model opposite="subclasses" required="true"
	 * @generated
	 */
	edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class getTarget();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.SuperclassReference#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class value);

} // SuperclassReference

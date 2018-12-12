/**
 * Copyright (c) 2012-2019 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Class#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Class#getOperations <em>Operations</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Class#getLifelines <em>Lifelines</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage#getClass_()
 * @model annotation="gmf.node label='name'"
 * @generated
 */
public interface Class extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Attribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage#getClass_Attributes()
	 * @model containment="true"
	 *        annotation="gmf.compartment layout='list'"
	 * @generated
	 */
	EList<Attribute> getAttributes();

	/**
	 * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Operation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operations</em>' containment reference list.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage#getClass_Operations()
	 * @model containment="true"
	 *        annotation="gmf.compartment layout='list'"
	 * @generated
	 */
	EList<Operation> getOperations();

	/**
	 * Returns the value of the '<em><b>Lifelines</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ClassReference}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ClassReference#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lifelines</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lifelines</em>' reference list.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage#getClass_Lifelines()
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ClassReference#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<ClassReference> getLifelines();

} // Class

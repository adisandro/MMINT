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
package edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Attribute#getMessages <em>Messages</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage#getAttribute()
 * @model annotation="gmf.node label='name'"
 * @generated
 */
public interface Attribute extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Messages</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.AttributeReference}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.AttributeReference#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Messages</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Messages</em>' reference list.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage#getAttribute_Messages()
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.AttributeReference#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<AttributeReference> getMessages();

} // Attribute

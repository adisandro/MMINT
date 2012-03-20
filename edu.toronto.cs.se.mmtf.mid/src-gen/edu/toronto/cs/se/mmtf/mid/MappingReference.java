/**
 * Copyright (C) 2012 Marsha Chechik, Alessio Di Sandro, Rick Salay
 * 
 * This file is part of MMTF ver. 0.9.0.
 * 
 * MMTF is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * MMTF is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MMTF.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.toronto.cs.se.mmtf.mid;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.MappingReference#getModels <em>Models</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getMappingReference()
 * @model
 * @generated
 */
public interface MappingReference extends ModelReference {
	/**
	 * Returns the value of the '<em><b>Models</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmtf.mid.ModelReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Models</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Models</em>' reference list.
	 * @see edu.toronto.cs.se.mmtf.mid.MidPackage#getMappingReference_Models()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http:///edu/toronto/cs/se/mmtf/mid/model/mid.ecore!MappingReference!models'"
	 * @generated
	 */
	EList<ModelReference> getModels();

} // MappingReference

/**
 * Copyright (c) 2012-2025 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.classdiagram;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagram#getClasses <em>Classes</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagram#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagram#getAssociations <em>Associations</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagram#getDatatypes <em>Datatypes</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagram#getCompositions <em>Compositions</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage#getClassDiagram()
 * @model annotation="gmf.diagram"
 * @generated
 */
public interface ClassDiagram extends EObject {
	/**
   * Returns the value of the '<em><b>Classes</b></em>' containment reference list.
   * The list contents are of type {@link edu.toronto.cs.se.modelepedia.classdiagram.Class}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Classes</em>' containment reference list.
   * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage#getClassDiagram_Classes()
   * @model containment="true"
   * @generated
   */
	EList<edu.toronto.cs.se.modelepedia.classdiagram.Class> getClasses();

	/**
   * Returns the value of the '<em><b>Dependencies</b></em>' containment reference list.
   * The list contents are of type {@link edu.toronto.cs.se.modelepedia.classdiagram.Dependency}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependencies</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Dependencies</em>' containment reference list.
   * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage#getClassDiagram_Dependencies()
   * @model containment="true"
   * @generated
   */
	EList<Dependency> getDependencies();

	/**
   * Returns the value of the '<em><b>Associations</b></em>' containment reference list.
   * The list contents are of type {@link edu.toronto.cs.se.modelepedia.classdiagram.Association}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Associations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Associations</em>' containment reference list.
   * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage#getClassDiagram_Associations()
   * @model containment="true"
   * @generated
   */
	EList<Association> getAssociations();

	/**
   * Returns the value of the '<em><b>Datatypes</b></em>' containment reference list.
   * The list contents are of type {@link edu.toronto.cs.se.modelepedia.classdiagram.DataType}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Datatypes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Datatypes</em>' containment reference list.
   * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage#getClassDiagram_Datatypes()
   * @model containment="true"
   * @generated
   */
	EList<DataType> getDatatypes();

	/**
   * Returns the value of the '<em><b>Compositions</b></em>' containment reference list.
   * The list contents are of type {@link edu.toronto.cs.se.modelepedia.classdiagram.Composition}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compositions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Compositions</em>' containment reference list.
   * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage#getClassDiagram_Compositions()
   * @model containment="true"
   * @generated
   */
	EList<Composition> getCompositions();

} // ClassDiagram

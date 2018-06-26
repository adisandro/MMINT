/**
 * Copyright (c) 2012-2018 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid;

import edu.toronto.cs.se.mmint.mid.editor.Editor;

import edu.toronto.cs.se.mmint.mid.operator.Operator;

import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MID</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The model management root.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.MID#getModels <em>Models</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.MID#getEditors <em>Editors</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.MID#getOperators <em>Operators</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.MID#getExtendibleTable <em>Extendible Table</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.MID#getLevel <em>Level</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.mid.MIDPackage#getMID()
 * @model
 * @generated
 */
public interface MID extends EObject {
    /**
     * Returns the value of the '<em><b>Models</b></em>' containment reference list.
     * The list contents are of type {@link edu.toronto.cs.se.mmint.mid.Model}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The list of managed model types or model instances.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Models</em>' containment reference list.
     * @see edu.toronto.cs.se.mmint.mid.MIDPackage#getMID_Models()
     * @model containment="true"
     * @generated
     */
    EList<Model> getModels();

    /**
     * Returns the value of the '<em><b>Editors</b></em>' containment reference list.
     * The list contents are of type {@link edu.toronto.cs.se.mmint.mid.editor.Editor}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The list of managed editor types or editor instances.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Editors</em>' containment reference list.
     * @see edu.toronto.cs.se.mmint.mid.MIDPackage#getMID_Editors()
     * @model containment="true"
     * @generated
     */
    EList<Editor> getEditors();

    /**
     * Returns the value of the '<em><b>Operators</b></em>' containment reference list.
     * The list contents are of type {@link edu.toronto.cs.se.mmint.mid.operator.Operator}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The list of managed operator types or operator instances.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Operators</em>' containment reference list.
     * @see edu.toronto.cs.se.mmint.mid.MIDPackage#getMID_Operators()
     * @model containment="true"
     * @generated
     */
    EList<Operator> getOperators();

    /**
     * Returns the value of the '<em><b>Extendible Table</b></em>' map.
     * The key is of type {@link java.lang.String},
     * and the value is of type {@link edu.toronto.cs.se.mmint.mid.ExtendibleElement},
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The hash map for all element types or element instances in the MID, using the uri as key.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Extendible Table</em>' map.
     * @see edu.toronto.cs.se.mmint.mid.MIDPackage#getMID_ExtendibleTable()
     * @model mapType="edu.toronto.cs.se.mmint.mid.EStringToExtendibleElementMap<org.eclipse.emf.ecore.EString, edu.toronto.cs.se.mmint.mid.ExtendibleElement>"
     * @generated
     */
    EMap<String, ExtendibleElement> getExtendibleTable();

    /**
     * Returns the value of the '<em><b>Level</b></em>' attribute.
     * The literals are from the enumeration {@link edu.toronto.cs.se.mmint.mid.MIDLevel}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The metalevel (types: TYPES; instances: INSTANCES).
     * <!-- end-model-doc -->
     * @return the value of the '<em>Level</em>' attribute.
     * @see edu.toronto.cs.se.mmint.mid.MIDLevel
     * @see #setLevel(MIDLevel)
     * @see edu.toronto.cs.se.mmint.mid.MIDPackage#getMID_Level()
     * @model required="true"
     * @generated
     */
    MIDLevel getLevel();

    /**
     * Sets the value of the '{@link edu.toronto.cs.se.mmint.mid.MID#getLevel <em>Level</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Level</em>' attribute.
     * @see edu.toronto.cs.se.mmint.mid.MIDLevel
     * @see #getLevel()
     * @generated
     */
    void setLevel(MIDLevel value);

    /**
     * <!-- begin-user-doc --> Checks whether this is a Type MID.
     * 
     * @return True if this is a Type MID, false otherwise. <!-- end-user-doc -->
     * @model kind="operation" required="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getLevel() == MIDLevel.TYPES;'"
     * @generated
     */
    boolean isTypesLevel();

    /**
     * <!-- begin-user-doc --> Checks whether this is an Instance MID.
     * 
     * @return True if this is an Instance MID, false otherwise. <!-- end-user-doc -->
     * @model kind="operation" required="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getLevel() == MIDLevel.INSTANCES;'"
     * @generated
     */
    boolean isInstancesLevel();

    /**
     * <!-- begin-user-doc --> Checks whether this is a Workflow MID.
     * 
     * @return True if this is a Workflow MID, false otherwise. <!-- end-user-doc -->
     * @model kind="operation" required="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getLevel() == MIDLevel.WORKFLOWS;'"
     * @generated
     */
    boolean isWorkflowsLevel();

    /**
     * <!-- begin-user-doc --> Gets an extendible element from this MID.
     * 
     * @param uri
     *            The uri of the element.
     * @return The element, null if the uri is not found or found not to be of the desired class of elements.
     * <!-- end-user-doc -->
     * @model uriRequired="true"
     * @generated
     */
    <T extends ExtendibleElement> T getExtendibleElement(String uri);

    /**
     * <!-- begin-user-doc -->Gets the model rels contained in this MID.
     * 
     * @return The model rels contained in this MID. <!-- end-user-doc -->
     * @model kind="operation"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EList<ModelRel> modelRels = new BasicEList<>();\nfor (Model model : this.getModels()) {\n\tif (model instanceof ModelRel) {\n\t\tmodelRels.add((ModelRel) model);\n\t}\n}\nreturn modelRels;'"
     * @generated
     */
    EList<ModelRel> getModelRels();

} // MID

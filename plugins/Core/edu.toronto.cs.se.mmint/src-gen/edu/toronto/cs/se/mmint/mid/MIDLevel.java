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
package edu.toronto.cs.se.mmint.mid;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Level</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * The levels for a MID.
 * <!-- end-model-doc -->
 * @see edu.toronto.cs.se.mmint.mid.MIDPackage#getMIDLevel()
 * @model
 * @generated
 */
public enum MIDLevel implements Enumerator {
    /**
     * The '<em><b>INSTANCES</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #INSTANCES_VALUE
     * @generated
     * @ordered
     */
    INSTANCES(0, "INSTANCES", "INSTANCES"),

    /**
     * The '<em><b>TYPES</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #TYPES_VALUE
     * @generated
     * @ordered
     */
    TYPES(1, "TYPES", "TYPES"), /**
     * The '<em><b>WORKFLOWS</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #WORKFLOWS_VALUE
     * @generated
     * @ordered
     */
    WORKFLOWS(2, "WORKFLOWS", "WORKFLOWS");

    /**
     * The '<em><b>INSTANCES</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The instances level, where models are defined.
     * <!-- end-model-doc -->
     * @see #INSTANCES
     * @model
     * @generated
     * @ordered
     */
    public static final int INSTANCES_VALUE = 0;

    /**
     * The '<em><b>TYPES</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The types level, where metamodels are defined.
     * <!-- end-model-doc -->
     * @see #TYPES
     * @model
     * @generated
     * @ordered
     */
    public static final int TYPES_VALUE = 1;

    /**
     * The '<em><b>WORKFLOWS</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The workflows level, where non-instantiated models are defined.
     * <!-- end-model-doc -->
     * @see #WORKFLOWS
     * @model
     * @generated
     * @ordered
     */
    public static final int WORKFLOWS_VALUE = 2;

    /**
     * An array of all the '<em><b>Level</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final MIDLevel[] VALUES_ARRAY =
        new MIDLevel[] {
            INSTANCES,
            TYPES,
            WORKFLOWS,
        };

    /**
     * A public read-only list of all the '<em><b>Level</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<MIDLevel> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Level</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param literal the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static MIDLevel get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            MIDLevel result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Level</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param name the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static MIDLevel getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            MIDLevel result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Level</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static MIDLevel get(int value) {
        switch (value) {
            case INSTANCES_VALUE: return INSTANCES;
            case TYPES_VALUE: return TYPES;
            case WORKFLOWS_VALUE: return WORKFLOWS;
        }
        return null;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private final int value;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private final String name;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private final String literal;

    /**
     * Only this class can construct instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private MIDLevel(int value, String name, String literal) {
        this.value = value;
        this.name = name;
        this.literal = literal;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getValue() {
      return value;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName() {
      return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLiteral() {
      return literal;
    }

    /**
     * Returns the literal value of the enumerator, which is its string representation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        return literal;
    }
    
} //MIDLevel

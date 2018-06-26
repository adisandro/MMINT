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
package edu.toronto.cs.se.modelepedia.istar_mavo;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Intention</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar_mavo.Intention#isFullySatisfied <em>Fully Satisfied</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar_mavo.Intention#isPartiallySatisfied <em>Partially Satisfied</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar_mavo.Intention#isUnknown <em>Unknown</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar_mavo.Intention#isConflict <em>Conflict</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar_mavo.Intention#isPartiallyDenied <em>Partially Denied</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar_mavo.Intention#isFullyDenied <em>Fully Denied</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar_mavo.Intention#isNoLabel <em>No Label</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar_mavo.Intention#getLinksAsSrc <em>Links As Src</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar_mavo.Intention#getLinksAsTgt <em>Links As Tgt</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar_mavo.Intention#getDependerLinks <em>Depender Links</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar_mavo.Intention#getDependeeLinks <em>Dependee Links</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage#getIntention()
 * @model abstract="true"
 * @generated
 */
public interface Intention extends DependencyEndpoint {
	/**
	 * Returns the value of the '<em><b>Fully Satisfied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fully Satisfied</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fully Satisfied</em>' attribute.
	 * @see #setFullySatisfied(boolean)
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage#getIntention_FullySatisfied()
	 * @model
	 * @generated
	 */
	boolean isFullySatisfied();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Intention#isFullySatisfied <em>Fully Satisfied</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fully Satisfied</em>' attribute.
	 * @see #isFullySatisfied()
	 * @generated
	 */
	void setFullySatisfied(boolean value);

	/**
	 * Returns the value of the '<em><b>Partially Satisfied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Partially Satisfied</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partially Satisfied</em>' attribute.
	 * @see #setPartiallySatisfied(boolean)
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage#getIntention_PartiallySatisfied()
	 * @model
	 * @generated
	 */
	boolean isPartiallySatisfied();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Intention#isPartiallySatisfied <em>Partially Satisfied</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Partially Satisfied</em>' attribute.
	 * @see #isPartiallySatisfied()
	 * @generated
	 */
	void setPartiallySatisfied(boolean value);

	/**
	 * Returns the value of the '<em><b>Unknown</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unknown</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unknown</em>' attribute.
	 * @see #setUnknown(boolean)
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage#getIntention_Unknown()
	 * @model
	 * @generated
	 */
	boolean isUnknown();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Intention#isUnknown <em>Unknown</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unknown</em>' attribute.
	 * @see #isUnknown()
	 * @generated
	 */
	void setUnknown(boolean value);

	/**
	 * Returns the value of the '<em><b>Conflict</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conflict</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conflict</em>' attribute.
	 * @see #setConflict(boolean)
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage#getIntention_Conflict()
	 * @model
	 * @generated
	 */
	boolean isConflict();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Intention#isConflict <em>Conflict</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conflict</em>' attribute.
	 * @see #isConflict()
	 * @generated
	 */
	void setConflict(boolean value);

	/**
	 * Returns the value of the '<em><b>Partially Denied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Partially Denied</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partially Denied</em>' attribute.
	 * @see #setPartiallyDenied(boolean)
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage#getIntention_PartiallyDenied()
	 * @model
	 * @generated
	 */
	boolean isPartiallyDenied();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Intention#isPartiallyDenied <em>Partially Denied</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Partially Denied</em>' attribute.
	 * @see #isPartiallyDenied()
	 * @generated
	 */
	void setPartiallyDenied(boolean value);

	/**
	 * Returns the value of the '<em><b>Fully Denied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fully Denied</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fully Denied</em>' attribute.
	 * @see #setFullyDenied(boolean)
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage#getIntention_FullyDenied()
	 * @model
	 * @generated
	 */
	boolean isFullyDenied();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Intention#isFullyDenied <em>Fully Denied</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fully Denied</em>' attribute.
	 * @see #isFullyDenied()
	 * @generated
	 */
	void setFullyDenied(boolean value);

	/**
	 * Returns the value of the '<em><b>No Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>No Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>No Label</em>' attribute.
	 * @see #setNoLabel(boolean)
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage#getIntention_NoLabel()
	 * @model
	 * @generated
	 */
	boolean isNoLabel();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Intention#isNoLabel <em>No Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>No Label</em>' attribute.
	 * @see #isNoLabel()
	 * @generated
	 */
	void setNoLabel(boolean value);

	/**
	 * Returns the value of the '<em><b>Links As Src</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.istar_mavo.IntentionLink}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.istar_mavo.IntentionLink#getSrc <em>Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Links As Src</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Links As Src</em>' containment reference list.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage#getIntention_LinksAsSrc()
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IntentionLink#getSrc
	 * @model opposite="src" containment="true"
	 * @generated
	 */
	EList<IntentionLink> getLinksAsSrc();

	/**
	 * Returns the value of the '<em><b>Links As Tgt</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.istar_mavo.IntentionLink}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.istar_mavo.IntentionLink#getTgt <em>Tgt</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Links As Tgt</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Links As Tgt</em>' reference list.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage#getIntention_LinksAsTgt()
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IntentionLink#getTgt
	 * @model opposite="tgt"
	 * @generated
	 */
	EList<IntentionLink> getLinksAsTgt();

	/**
	 * Returns the value of the '<em><b>Depender Links</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.istar_mavo.DependerLink}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.istar_mavo.DependerLink#getDependum <em>Dependum</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depender Links</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depender Links</em>' containment reference list.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage#getIntention_DependerLinks()
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.DependerLink#getDependum
	 * @model opposite="dependum" containment="true"
	 * @generated
	 */
	EList<DependerLink> getDependerLinks();

	/**
	 * Returns the value of the '<em><b>Dependee Links</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.istar_mavo.DependeeLink}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.istar_mavo.DependeeLink#getDependum <em>Dependum</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependee Links</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependee Links</em>' containment reference list.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage#getIntention_DependeeLinks()
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.DependeeLink#getDependum
	 * @model opposite="dependum" containment="true"
	 * @generated
	 */
	EList<DependeeLink> getDependeeLinks();

} // Intention

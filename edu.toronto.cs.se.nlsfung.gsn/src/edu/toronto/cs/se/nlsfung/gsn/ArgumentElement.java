/**
 */
package edu.toronto.cs.se.nlsfung.gsn;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Argument Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.ArgumentElement#getId <em>Id</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.ArgumentElement#getName <em>Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.ArgumentElement#getDescription <em>Description</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.ArgumentElement#getStatus <em>Status</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getArgumentElement()
 * @model abstract="true"
 * @generated
 */
public interface ArgumentElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getArgumentElement_Id()
	 * @model default="" required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.nlsfung.gsn.ArgumentElement#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getArgumentElement_Name()
	 * @model annotation="gmf.label label='description'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.nlsfung.gsn.ArgumentElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getArgumentElement_Description()
	 * @model annotation="gmf.label label='description'"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.nlsfung.gsn.ArgumentElement#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * The default value is <code>"Undetermined"</code>.
	 * The literals are from the enumeration {@link edu.toronto.cs.se.nlsfung.gsn.Status}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see edu.toronto.cs.se.nlsfung.gsn.Status
	 * @see #setStatus(Status)
	 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getArgumentElement_Status()
	 * @model default="Undetermined"
	 * @generated
	 */
	Status getStatus();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.nlsfung.gsn.ArgumentElement#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see edu.toronto.cs.se.nlsfung.gsn.Status
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(Status value);

} // ArgumentElement

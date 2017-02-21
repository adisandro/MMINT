/**
 */
package edu.toronto.cs.se.nlsfung.gsn;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Basic Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.BasicNode#getId <em>Id</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.BasicNode#getName <em>Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.BasicNode#getAssessstatus <em>Assessstatus</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.BasicNode#getHasComment <em>Has Comment</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.BasicNode#getDescription <em>Description</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.BasicNode#getQualityLevel <em>Quality Level</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.BasicNode#getConfidencePercentage <em>Confidence Percentage</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.BasicNode#getWeight <em>Weight</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.BasicNode#getBeliefDegree <em>Belief Degree</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getBasicNode()
 * @model abstract="true"
 * @generated
 */
public interface BasicNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getBasicNode_Id()
	 * @model id="true" ordered="false"
	 *        extendedMetaData="name='id' namespace='http://sdq.ipd.uka.de/Identifier/1.0'"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.nlsfung.gsn.BasicNode#getId <em>Id</em>}' attribute.
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
	 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getBasicNode_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.nlsfung.gsn.BasicNode#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Assessstatus</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.toronto.cs.se.nlsfung.gsn.AssessStatus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assessstatus</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assessstatus</em>' attribute.
	 * @see edu.toronto.cs.se.nlsfung.gsn.AssessStatus
	 * @see #setAssessstatus(AssessStatus)
	 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getBasicNode_Assessstatus()
	 * @model
	 * @generated
	 */
	AssessStatus getAssessstatus();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.nlsfung.gsn.BasicNode#getAssessstatus <em>Assessstatus</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assessstatus</em>' attribute.
	 * @see edu.toronto.cs.se.nlsfung.gsn.AssessStatus
	 * @see #getAssessstatus()
	 * @generated
	 */
	void setAssessstatus(AssessStatus value);

	/**
	 * Returns the value of the '<em><b>Has Comment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Comment</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Comment</em>' reference.
	 * @see #setHasComment(Recommendation)
	 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getBasicNode_HasComment()
	 * @model annotation="gmf.link style='solid' width='1' tool.small.bundle='AGSN.edit' tool.small.path='icons/full/obj16/BasicNodeHasComment.gif'"
	 * @generated
	 */
	Recommendation getHasComment();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.nlsfung.gsn.BasicNode#getHasComment <em>Has Comment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Comment</em>' reference.
	 * @see #getHasComment()
	 * @generated
	 */
	void setHasComment(Recommendation value);

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
	 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getBasicNode_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.nlsfung.gsn.BasicNode#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Quality Level</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.toronto.cs.se.nlsfung.gsn.Level}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quality Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quality Level</em>' attribute.
	 * @see edu.toronto.cs.se.nlsfung.gsn.Level
	 * @see #setQualityLevel(Level)
	 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getBasicNode_QualityLevel()
	 * @model
	 * @generated
	 */
	Level getQualityLevel();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.nlsfung.gsn.BasicNode#getQualityLevel <em>Quality Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quality Level</em>' attribute.
	 * @see edu.toronto.cs.se.nlsfung.gsn.Level
	 * @see #getQualityLevel()
	 * @generated
	 */
	void setQualityLevel(Level value);

	/**
	 * Returns the value of the '<em><b>Confidence Percentage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Confidence Percentage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Confidence Percentage</em>' attribute.
	 * @see #setConfidencePercentage(Integer)
	 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getBasicNode_ConfidencePercentage()
	 * @model dataType="edu.toronto.cs.se.nlsfung.gsn.percentage"
	 * @generated
	 */
	Integer getConfidencePercentage();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.nlsfung.gsn.BasicNode#getConfidencePercentage <em>Confidence Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Confidence Percentage</em>' attribute.
	 * @see #getConfidencePercentage()
	 * @generated
	 */
	void setConfidencePercentage(Integer value);

	/**
	 * Returns the value of the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weight</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weight</em>' attribute.
	 * @see #setWeight(double)
	 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getBasicNode_Weight()
	 * @model
	 * @generated
	 */
	double getWeight();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.nlsfung.gsn.BasicNode#getWeight <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Weight</em>' attribute.
	 * @see #getWeight()
	 * @generated
	 */
	void setWeight(double value);

	/**
	 * Returns the value of the '<em><b>Belief Degree</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Belief Degree</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Belief Degree</em>' attribute.
	 * @see #setBeliefDegree(double[])
	 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getBasicNode_BeliefDegree()
	 * @model dataType="edu.toronto.cs.se.nlsfung.gsn.beliefDegree"
	 * @generated
	 */
	double[] getBeliefDegree();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.nlsfung.gsn.BasicNode#getBeliefDegree <em>Belief Degree</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Belief Degree</em>' attribute.
	 * @see #getBeliefDegree()
	 * @generated
	 */
	void setBeliefDegree(double[] value);

} // BasicNode

/**
 */
package edu.toronto.cs.se.nlsfung.gsn.impl;

import edu.toronto.cs.se.nlsfung.gsn.AssessStatus;
import edu.toronto.cs.se.nlsfung.gsn.BasicNode;
import edu.toronto.cs.se.nlsfung.gsn.GSNPackage;
import edu.toronto.cs.se.nlsfung.gsn.Level;
import edu.toronto.cs.se.nlsfung.gsn.Recommendation;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Basic Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.impl.BasicNodeImpl#getId <em>Id</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.impl.BasicNodeImpl#getName <em>Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.impl.BasicNodeImpl#getAssessstatus <em>Assessstatus</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.impl.BasicNodeImpl#getHasComment <em>Has Comment</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.impl.BasicNodeImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.impl.BasicNodeImpl#getQualityLevel <em>Quality Level</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.impl.BasicNodeImpl#getConfidencePercentage <em>Confidence Percentage</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.impl.BasicNodeImpl#getWeight <em>Weight</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.impl.BasicNodeImpl#getBeliefDegree <em>Belief Degree</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class BasicNodeImpl extends EObjectImpl implements BasicNode {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getAssessstatus() <em>Assessstatus</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssessstatus()
	 * @generated
	 * @ordered
	 */
	protected static final AssessStatus ASSESSSTATUS_EDEFAULT = AssessStatus.NOT_REVIEWED;

	/**
	 * The cached value of the '{@link #getAssessstatus() <em>Assessstatus</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssessstatus()
	 * @generated
	 * @ordered
	 */
	protected AssessStatus assessstatus = ASSESSSTATUS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getHasComment() <em>Has Comment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHasComment()
	 * @generated
	 * @ordered
	 */
	protected Recommendation hasComment;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getQualityLevel() <em>Quality Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualityLevel()
	 * @generated
	 * @ordered
	 */
	protected static final Level QUALITY_LEVEL_EDEFAULT = Level.VERY_LOW;

	/**
	 * The cached value of the '{@link #getQualityLevel() <em>Quality Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualityLevel()
	 * @generated
	 * @ordered
	 */
	protected Level qualityLevel = QUALITY_LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getConfidencePercentage() <em>Confidence Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfidencePercentage()
	 * @generated
	 * @ordered
	 */
	protected static final Integer CONFIDENCE_PERCENTAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConfidencePercentage() <em>Confidence Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfidencePercentage()
	 * @generated
	 * @ordered
	 */
	protected Integer confidencePercentage = CONFIDENCE_PERCENTAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getWeight() <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeight()
	 * @generated
	 * @ordered
	 */
	protected static final double WEIGHT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getWeight() <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeight()
	 * @generated
	 * @ordered
	 */
	protected double weight = WEIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getBeliefDegree() <em>Belief Degree</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBeliefDegree()
	 * @generated
	 * @ordered
	 */
	protected static final double[] BELIEF_DEGREE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBeliefDegree() <em>Belief Degree</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBeliefDegree()
	 * @generated
	 * @ordered
	 */
	protected double[] beliefDegree = BELIEF_DEGREE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BasicNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GSNPackage.Literals.BASIC_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.BASIC_NODE__ID, oldId, id));
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
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.BASIC_NODE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssessStatus getAssessstatus() {
		return assessstatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssessstatus(AssessStatus newAssessstatus) {
		AssessStatus oldAssessstatus = assessstatus;
		assessstatus = newAssessstatus == null ? ASSESSSTATUS_EDEFAULT : newAssessstatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.BASIC_NODE__ASSESSSTATUS, oldAssessstatus, assessstatus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Recommendation getHasComment() {
		if (hasComment != null && hasComment.eIsProxy()) {
			InternalEObject oldHasComment = (InternalEObject)hasComment;
			hasComment = (Recommendation)eResolveProxy(oldHasComment);
			if (hasComment != oldHasComment) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GSNPackage.BASIC_NODE__HAS_COMMENT, oldHasComment, hasComment));
			}
		}
		return hasComment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Recommendation basicGetHasComment() {
		return hasComment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasComment(Recommendation newHasComment) {
		Recommendation oldHasComment = hasComment;
		hasComment = newHasComment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.BASIC_NODE__HAS_COMMENT, oldHasComment, hasComment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.BASIC_NODE__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Level getQualityLevel() {
		return qualityLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQualityLevel(Level newQualityLevel) {
		Level oldQualityLevel = qualityLevel;
		qualityLevel = newQualityLevel == null ? QUALITY_LEVEL_EDEFAULT : newQualityLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.BASIC_NODE__QUALITY_LEVEL, oldQualityLevel, qualityLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getConfidencePercentage() {
		return confidencePercentage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfidencePercentage(Integer newConfidencePercentage) {
		Integer oldConfidencePercentage = confidencePercentage;
		confidencePercentage = newConfidencePercentage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.BASIC_NODE__CONFIDENCE_PERCENTAGE, oldConfidencePercentage, confidencePercentage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWeight(double newWeight) {
		double oldWeight = weight;
		weight = newWeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.BASIC_NODE__WEIGHT, oldWeight, weight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double[] getBeliefDegree() {
		return beliefDegree;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBeliefDegree(double[] newBeliefDegree) {
		double[] oldBeliefDegree = beliefDegree;
		beliefDegree = newBeliefDegree;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.BASIC_NODE__BELIEF_DEGREE, oldBeliefDegree, beliefDegree));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GSNPackage.BASIC_NODE__ID:
				return getId();
			case GSNPackage.BASIC_NODE__NAME:
				return getName();
			case GSNPackage.BASIC_NODE__ASSESSSTATUS:
				return getAssessstatus();
			case GSNPackage.BASIC_NODE__HAS_COMMENT:
				if (resolve) return getHasComment();
				return basicGetHasComment();
			case GSNPackage.BASIC_NODE__DESCRIPTION:
				return getDescription();
			case GSNPackage.BASIC_NODE__QUALITY_LEVEL:
				return getQualityLevel();
			case GSNPackage.BASIC_NODE__CONFIDENCE_PERCENTAGE:
				return getConfidencePercentage();
			case GSNPackage.BASIC_NODE__WEIGHT:
				return getWeight();
			case GSNPackage.BASIC_NODE__BELIEF_DEGREE:
				return getBeliefDegree();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GSNPackage.BASIC_NODE__ID:
				setId((String)newValue);
				return;
			case GSNPackage.BASIC_NODE__NAME:
				setName((String)newValue);
				return;
			case GSNPackage.BASIC_NODE__ASSESSSTATUS:
				setAssessstatus((AssessStatus)newValue);
				return;
			case GSNPackage.BASIC_NODE__HAS_COMMENT:
				setHasComment((Recommendation)newValue);
				return;
			case GSNPackage.BASIC_NODE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case GSNPackage.BASIC_NODE__QUALITY_LEVEL:
				setQualityLevel((Level)newValue);
				return;
			case GSNPackage.BASIC_NODE__CONFIDENCE_PERCENTAGE:
				setConfidencePercentage((Integer)newValue);
				return;
			case GSNPackage.BASIC_NODE__WEIGHT:
				setWeight((Double)newValue);
				return;
			case GSNPackage.BASIC_NODE__BELIEF_DEGREE:
				setBeliefDegree((double[])newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GSNPackage.BASIC_NODE__ID:
				setId(ID_EDEFAULT);
				return;
			case GSNPackage.BASIC_NODE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GSNPackage.BASIC_NODE__ASSESSSTATUS:
				setAssessstatus(ASSESSSTATUS_EDEFAULT);
				return;
			case GSNPackage.BASIC_NODE__HAS_COMMENT:
				setHasComment((Recommendation)null);
				return;
			case GSNPackage.BASIC_NODE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case GSNPackage.BASIC_NODE__QUALITY_LEVEL:
				setQualityLevel(QUALITY_LEVEL_EDEFAULT);
				return;
			case GSNPackage.BASIC_NODE__CONFIDENCE_PERCENTAGE:
				setConfidencePercentage(CONFIDENCE_PERCENTAGE_EDEFAULT);
				return;
			case GSNPackage.BASIC_NODE__WEIGHT:
				setWeight(WEIGHT_EDEFAULT);
				return;
			case GSNPackage.BASIC_NODE__BELIEF_DEGREE:
				setBeliefDegree(BELIEF_DEGREE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GSNPackage.BASIC_NODE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case GSNPackage.BASIC_NODE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GSNPackage.BASIC_NODE__ASSESSSTATUS:
				return assessstatus != ASSESSSTATUS_EDEFAULT;
			case GSNPackage.BASIC_NODE__HAS_COMMENT:
				return hasComment != null;
			case GSNPackage.BASIC_NODE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case GSNPackage.BASIC_NODE__QUALITY_LEVEL:
				return qualityLevel != QUALITY_LEVEL_EDEFAULT;
			case GSNPackage.BASIC_NODE__CONFIDENCE_PERCENTAGE:
				return CONFIDENCE_PERCENTAGE_EDEFAULT == null ? confidencePercentage != null : !CONFIDENCE_PERCENTAGE_EDEFAULT.equals(confidencePercentage);
			case GSNPackage.BASIC_NODE__WEIGHT:
				return weight != WEIGHT_EDEFAULT;
			case GSNPackage.BASIC_NODE__BELIEF_DEGREE:
				return BELIEF_DEGREE_EDEFAULT == null ? beliefDegree != null : !BELIEF_DEGREE_EDEFAULT.equals(beliefDegree);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", name: ");
		result.append(name);
		result.append(", assessstatus: ");
		result.append(assessstatus);
		result.append(", description: ");
		result.append(description);
		result.append(", qualityLevel: ");
		result.append(qualityLevel);
		result.append(", confidencePercentage: ");
		result.append(confidencePercentage);
		result.append(", weight: ");
		result.append(weight);
		result.append(", beliefDegree: ");
		result.append(beliefDegree);
		result.append(')');
		return result.toString();
	}

} //BasicNodeImpl

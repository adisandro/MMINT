/**
 * Copyright (c) 2012-2021 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.istar.util;

import edu.toronto.cs.se.modelepedia.istar.*;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.modelepedia.istar.IStarPackage
 * @generated
 */
public class IStarValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final IStarValidator INSTANCE = new IStarValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "edu.toronto.cs.se.modelepedia.istar";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IStarValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return IStarPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case IStarPackage.ISTAR:
				return validateIStar((IStar)value, diagnostics, context);
			case IStarPackage.ACTOR:
				return validateActor((Actor)value, diagnostics, context);
			case IStarPackage.INTENTION:
				return validateIntention((Intention)value, diagnostics, context);
			case IStarPackage.TASK:
				return validateTask((Task)value, diagnostics, context);
			case IStarPackage.RESOURCE:
				return validateResource((Resource)value, diagnostics, context);
			case IStarPackage.GOAL:
				return validateGoal((Goal)value, diagnostics, context);
			case IStarPackage.SOFT_GOAL:
				return validateSoftGoal((SoftGoal)value, diagnostics, context);
			case IStarPackage.DEPENDENCY_ENDPOINT:
				return validateDependencyEndpoint((DependencyEndpoint)value, diagnostics, context);
			case IStarPackage.INTENTION_LINK:
				return validateIntentionLink((IntentionLink)value, diagnostics, context);
			case IStarPackage.MEANS_END:
				return validateMeansEnd((MeansEnd)value, diagnostics, context);
			case IStarPackage.DECOMPOSITION:
				return validateDecomposition((Decomposition)value, diagnostics, context);
			case IStarPackage.CONTRIBUTION:
				return validateContribution((Contribution)value, diagnostics, context);
			case IStarPackage.DEPENDER_LINK:
				return validateDependerLink((DependerLink)value, diagnostics, context);
			case IStarPackage.DEPENDEE_LINK:
				return validateDependeeLink((DependeeLink)value, diagnostics, context);
			case IStarPackage.CONTRIBUTION_TYPE:
				return validateContributionType((ContributionType)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIStar(IStar iStar, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(iStar, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(iStar, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(iStar, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(iStar, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(iStar, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(iStar, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(iStar, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(iStar, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(iStar, diagnostics, context);
		if (result || diagnostics != null) result &= validateIStar_onlyDependums(iStar, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the onlyDependums constraint of '<em>IStar</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String ISTAR__ONLY_DEPENDUMS__EEXPRESSION = "dependums->forAll(linksAsSrc->isEmpty() and linksAsTgt->isEmpty())";

	/**
	 * Validates the onlyDependums constraint of '<em>IStar</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIStar_onlyDependums(IStar iStar, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(IStarPackage.Literals.ISTAR,
				 iStar,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "onlyDependums",
				 ISTAR__ONLY_DEPENDUMS__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActor(Actor actor, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(actor, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(actor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(actor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(actor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(actor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(actor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(actor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(actor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(actor, diagnostics, context);
		if (result || diagnostics != null) result &= validateActor_noDependums(actor, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the noDependums constraint of '<em>Actor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String ACTOR__NO_DEPENDUMS__EEXPRESSION = "intentions->forAll(dependerLinks->isEmpty() and dependeeLinks->isEmpty())";

	/**
	 * Validates the noDependums constraint of '<em>Actor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActor_noDependums(Actor actor, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(IStarPackage.Literals.ACTOR,
				 actor,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "noDependums",
				 ACTOR__NO_DEPENDUMS__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIntention(Intention intention, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(intention, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTask(Task task, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(task, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResource(Resource resource, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(resource, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGoal(Goal goal, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(goal, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSoftGoal(SoftGoal softGoal, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(softGoal, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDependencyEndpoint(DependencyEndpoint dependencyEndpoint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(dependencyEndpoint, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIntentionLink(IntentionLink intentionLink, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(intentionLink, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMeansEnd(MeansEnd meansEnd, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(meansEnd, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(meansEnd, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(meansEnd, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(meansEnd, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(meansEnd, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(meansEnd, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(meansEnd, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(meansEnd, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(meansEnd, diagnostics, context);
		if (result || diagnostics != null) result &= validateMeansEnd_srcTask(meansEnd, diagnostics, context);
		if (result || diagnostics != null) result &= validateMeansEnd_tgtGoal(meansEnd, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the srcTask constraint of '<em>Means End</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String MEANS_END__SRC_TASK__EEXPRESSION = "src.oclIsTypeOf(Task)";

	/**
	 * Validates the srcTask constraint of '<em>Means End</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMeansEnd_srcTask(MeansEnd meansEnd, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(IStarPackage.Literals.MEANS_END,
				 meansEnd,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "srcTask",
				 MEANS_END__SRC_TASK__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the tgtGoal constraint of '<em>Means End</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String MEANS_END__TGT_GOAL__EEXPRESSION = "tgt.oclIsTypeOf(Goal)";

	/**
	 * Validates the tgtGoal constraint of '<em>Means End</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMeansEnd_tgtGoal(MeansEnd meansEnd, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(IStarPackage.Literals.MEANS_END,
				 meansEnd,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "tgtGoal",
				 MEANS_END__TGT_GOAL__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDecomposition(Decomposition decomposition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(decomposition, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(decomposition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(decomposition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(decomposition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(decomposition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(decomposition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(decomposition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(decomposition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(decomposition, diagnostics, context);
		if (result || diagnostics != null) result &= validateDecomposition_tgtTask(decomposition, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the tgtTask constraint of '<em>Decomposition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String DECOMPOSITION__TGT_TASK__EEXPRESSION = "tgt.oclIsTypeOf(Task)";

	/**
	 * Validates the tgtTask constraint of '<em>Decomposition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDecomposition_tgtTask(Decomposition decomposition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(IStarPackage.Literals.DECOMPOSITION,
				 decomposition,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "tgtTask",
				 DECOMPOSITION__TGT_TASK__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContribution(Contribution contribution, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(contribution, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(contribution, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(contribution, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(contribution, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(contribution, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(contribution, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(contribution, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(contribution, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(contribution, diagnostics, context);
		if (result || diagnostics != null) result &= validateContribution_tgtSoftgoal(contribution, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the tgtSoftgoal constraint of '<em>Contribution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String CONTRIBUTION__TGT_SOFTGOAL__EEXPRESSION = "tgt.oclIsTypeOf(SoftGoal)";

	/**
	 * Validates the tgtSoftgoal constraint of '<em>Contribution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContribution_tgtSoftgoal(Contribution contribution, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(IStarPackage.Literals.CONTRIBUTION,
				 contribution,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "tgtSoftgoal",
				 CONTRIBUTION__TGT_SOFTGOAL__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDependerLink(DependerLink dependerLink, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(dependerLink, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDependeeLink(DependeeLink dependeeLink, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(dependeeLink, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContributionType(ContributionType contributionType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //IStarValidator

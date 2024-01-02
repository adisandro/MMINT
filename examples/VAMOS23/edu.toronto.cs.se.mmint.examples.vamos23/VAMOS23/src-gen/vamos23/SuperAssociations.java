/**
 * 
 *   Copyright (c) 2022, 2024 Alessio Di Sandro.
 *  
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License 2.0 which is available at
 *   https://www.eclipse.org/legal/epl-2.0/
 *  
 *   SPDX-License-Identifier: EPL-2.0
 *  
 *   Contributors:
 *       Alessio Di Sandro - Implementation
 *  
 */
package vamos23;

import edu.toronto.cs.se.modelepedia.classdiagram.Association;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Inequality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PVisibility;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuples;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

/**
 * A pattern-specific query specification that can instantiate Matcher in a type-safe way.
 * 
 * <p>Original source:
 *         <code><pre>
 *         // Finds two superclasses connected by an association,
 *         // each with a subclass
 *         pattern superAssociations(super1: Class, super2: Class,
 *                                   association: Association) {
 *           super1 != super2;
 *           Class.superclass(sub1, super1);
 *           Class.superclass(sub2, super2);
 *           sub1 != sub2;
 *           Class.associationsAsSource(super1, association);
 *           Class.associationsAsTarget(super2, association);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class SuperAssociations extends BaseGeneratedEMFQuerySpecification<SuperAssociations.Matcher> {
  /**
   * Pattern-specific match representation of the vamos23.superAssociations pattern,
   * to be used in conjunction with {@link Matcher}.
   * 
   * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
   * Each instance is a (possibly partial) substitution of pattern parameters,
   * usable to represent a match of the pattern in the result of a query,
   * or to specify the bound (fixed) input parameters when issuing a query.
   * 
   * @see Matcher
   * 
   */
  public static abstract class Match extends BasePatternMatch {
    private edu.toronto.cs.se.modelepedia.classdiagram.Class fSuper1;

    private edu.toronto.cs.se.modelepedia.classdiagram.Class fSuper2;

    private Association fAssociation;

    private static List<String> parameterNames = makeImmutableList("super1", "super2", "association");

    private Match(final edu.toronto.cs.se.modelepedia.classdiagram.Class pSuper1, final edu.toronto.cs.se.modelepedia.classdiagram.Class pSuper2, final Association pAssociation) {
      this.fSuper1 = pSuper1;
      this.fSuper2 = pSuper2;
      this.fAssociation = pAssociation;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "super1": return this.fSuper1;
          case "super2": return this.fSuper2;
          case "association": return this.fAssociation;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fSuper1;
          case 1: return this.fSuper2;
          case 2: return this.fAssociation;
          default: return null;
      }
    }

    public edu.toronto.cs.se.modelepedia.classdiagram.Class getSuper1() {
      return this.fSuper1;
    }

    public edu.toronto.cs.se.modelepedia.classdiagram.Class getSuper2() {
      return this.fSuper2;
    }

    public Association getAssociation() {
      return this.fAssociation;
    }

    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("super1".equals(parameterName) ) {
          this.fSuper1 = (edu.toronto.cs.se.modelepedia.classdiagram.Class) newValue;
          return true;
      }
      if ("super2".equals(parameterName) ) {
          this.fSuper2 = (edu.toronto.cs.se.modelepedia.classdiagram.Class) newValue;
          return true;
      }
      if ("association".equals(parameterName) ) {
          this.fAssociation = (Association) newValue;
          return true;
      }
      return false;
    }

    public void setSuper1(final edu.toronto.cs.se.modelepedia.classdiagram.Class pSuper1) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fSuper1 = pSuper1;
    }

    public void setSuper2(final edu.toronto.cs.se.modelepedia.classdiagram.Class pSuper2) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fSuper2 = pSuper2;
    }

    public void setAssociation(final Association pAssociation) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fAssociation = pAssociation;
    }

    @Override
    public String patternName() {
      return "vamos23.superAssociations";
    }

    @Override
    public List<String> parameterNames() {
      return SuperAssociations.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fSuper1, fSuper2, fAssociation};
    }

    @Override
    public SuperAssociations.Match toImmutable() {
      return isMutable() ? newMatch(fSuper1, fSuper2, fAssociation) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"super1\"=" + prettyPrintValue(fSuper1) + ", ");
      result.append("\"super2\"=" + prettyPrintValue(fSuper2) + ", ");
      result.append("\"association\"=" + prettyPrintValue(fAssociation));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fSuper1, fSuper2, fAssociation);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof SuperAssociations.Match)) {
          SuperAssociations.Match other = (SuperAssociations.Match) obj;
          return Objects.equals(fSuper1, other.fSuper1) && Objects.equals(fSuper2, other.fSuper2) && Objects.equals(fAssociation, other.fAssociation);
      } else {
          // this should be infrequent
          if (!(obj instanceof IPatternMatch)) {
              return false;
          }
          IPatternMatch otherSig  = (IPatternMatch) obj;
          return Objects.equals(specification(), otherSig.specification()) && Arrays.deepEquals(toArray(), otherSig.toArray());
      }
    }

    @Override
    public SuperAssociations specification() {
      return SuperAssociations.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static SuperAssociations.Match newEmptyMatch() {
      return new Mutable(null, null, null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pSuper1 the fixed value of pattern parameter super1, or null if not bound.
     * @param pSuper2 the fixed value of pattern parameter super2, or null if not bound.
     * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static SuperAssociations.Match newMutableMatch(final edu.toronto.cs.se.modelepedia.classdiagram.Class pSuper1, final edu.toronto.cs.se.modelepedia.classdiagram.Class pSuper2, final Association pAssociation) {
      return new Mutable(pSuper1, pSuper2, pAssociation);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pSuper1 the fixed value of pattern parameter super1, or null if not bound.
     * @param pSuper2 the fixed value of pattern parameter super2, or null if not bound.
     * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static SuperAssociations.Match newMatch(final edu.toronto.cs.se.modelepedia.classdiagram.Class pSuper1, final edu.toronto.cs.se.modelepedia.classdiagram.Class pSuper2, final Association pAssociation) {
      return new Immutable(pSuper1, pSuper2, pAssociation);
    }

    private static final class Mutable extends SuperAssociations.Match {
      Mutable(final edu.toronto.cs.se.modelepedia.classdiagram.Class pSuper1, final edu.toronto.cs.se.modelepedia.classdiagram.Class pSuper2, final Association pAssociation) {
        super(pSuper1, pSuper2, pAssociation);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends SuperAssociations.Match {
      Immutable(final edu.toronto.cs.se.modelepedia.classdiagram.Class pSuper1, final edu.toronto.cs.se.modelepedia.classdiagram.Class pSuper2, final Association pAssociation) {
        super(pSuper1, pSuper2, pAssociation);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the vamos23.superAssociations pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * // Finds two superclasses connected by an association,
   * // each with a subclass
   * pattern superAssociations(super1: Class, super2: Class,
   *                           association: Association) {
   *   super1 != super2;
   *   Class.superclass(sub1, super1);
   *   Class.superclass(sub2, super2);
   *   sub1 != sub2;
   *   Class.associationsAsSource(super1, association);
   *   Class.associationsAsTarget(super2, association);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see SuperAssociations
   * 
   */
  public static class Matcher extends BaseMatcher<SuperAssociations.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static SuperAssociations.Matcher on(final ViatraQueryEngine engine) {
      // check if matcher already exists
      Matcher matcher = engine.getExistingMatcher(querySpecification());
      if (matcher == null) {
          matcher = (Matcher)engine.getMatcher(querySpecification());
      }
      return matcher;
    }

    /**
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * @return an initialized matcher
     * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
     * 
     */
    public static SuperAssociations.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_SUPER1 = 0;

    private static final int POSITION_SUPER2 = 1;

    private static final int POSITION_ASSOCIATION = 2;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(SuperAssociations.Matcher.class);

    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    private Matcher() {
      super(querySpecification());
    }

    /**
     * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pSuper1 the fixed value of pattern parameter super1, or null if not bound.
     * @param pSuper2 the fixed value of pattern parameter super2, or null if not bound.
     * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<SuperAssociations.Match> getAllMatches(final edu.toronto.cs.se.modelepedia.classdiagram.Class pSuper1, final edu.toronto.cs.se.modelepedia.classdiagram.Class pSuper2, final Association pAssociation) {
      return rawStreamAllMatches(new Object[]{pSuper1, pSuper2, pAssociation}).collect(Collectors.toSet());
    }

    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pSuper1 the fixed value of pattern parameter super1, or null if not bound.
     * @param pSuper2 the fixed value of pattern parameter super2, or null if not bound.
     * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<SuperAssociations.Match> streamAllMatches(final edu.toronto.cs.se.modelepedia.classdiagram.Class pSuper1, final edu.toronto.cs.se.modelepedia.classdiagram.Class pSuper2, final Association pAssociation) {
      return rawStreamAllMatches(new Object[]{pSuper1, pSuper2, pAssociation});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pSuper1 the fixed value of pattern parameter super1, or null if not bound.
     * @param pSuper2 the fixed value of pattern parameter super2, or null if not bound.
     * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<SuperAssociations.Match> getOneArbitraryMatch(final edu.toronto.cs.se.modelepedia.classdiagram.Class pSuper1, final edu.toronto.cs.se.modelepedia.classdiagram.Class pSuper2, final Association pAssociation) {
      return rawGetOneArbitraryMatch(new Object[]{pSuper1, pSuper2, pAssociation});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pSuper1 the fixed value of pattern parameter super1, or null if not bound.
     * @param pSuper2 the fixed value of pattern parameter super2, or null if not bound.
     * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final edu.toronto.cs.se.modelepedia.classdiagram.Class pSuper1, final edu.toronto.cs.se.modelepedia.classdiagram.Class pSuper2, final Association pAssociation) {
      return rawHasMatch(new Object[]{pSuper1, pSuper2, pAssociation});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pSuper1 the fixed value of pattern parameter super1, or null if not bound.
     * @param pSuper2 the fixed value of pattern parameter super2, or null if not bound.
     * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final edu.toronto.cs.se.modelepedia.classdiagram.Class pSuper1, final edu.toronto.cs.se.modelepedia.classdiagram.Class pSuper2, final Association pAssociation) {
      return rawCountMatches(new Object[]{pSuper1, pSuper2, pAssociation});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pSuper1 the fixed value of pattern parameter super1, or null if not bound.
     * @param pSuper2 the fixed value of pattern parameter super2, or null if not bound.
     * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final edu.toronto.cs.se.modelepedia.classdiagram.Class pSuper1, final edu.toronto.cs.se.modelepedia.classdiagram.Class pSuper2, final Association pAssociation, final Consumer<? super SuperAssociations.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pSuper1, pSuper2, pAssociation}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pSuper1 the fixed value of pattern parameter super1, or null if not bound.
     * @param pSuper2 the fixed value of pattern parameter super2, or null if not bound.
     * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public SuperAssociations.Match newMatch(final edu.toronto.cs.se.modelepedia.classdiagram.Class pSuper1, final edu.toronto.cs.se.modelepedia.classdiagram.Class pSuper2, final Association pAssociation) {
      return SuperAssociations.Match.newMatch(pSuper1, pSuper2, pAssociation);
    }

    /**
     * Retrieve the set of values that occur in matches for super1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<edu.toronto.cs.se.modelepedia.classdiagram.Class> rawStreamAllValuesOfsuper1(final Object[] parameters) {
      return rawStreamAllValues(POSITION_SUPER1, parameters).map(edu.toronto.cs.se.modelepedia.classdiagram.Class.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for super1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.modelepedia.classdiagram.Class> getAllValuesOfsuper1() {
      return rawStreamAllValuesOfsuper1(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for super1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.modelepedia.classdiagram.Class> streamAllValuesOfsuper1() {
      return rawStreamAllValuesOfsuper1(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for super1.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.modelepedia.classdiagram.Class> streamAllValuesOfsuper1(final SuperAssociations.Match partialMatch) {
      return rawStreamAllValuesOfsuper1(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for super1.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.modelepedia.classdiagram.Class> streamAllValuesOfsuper1(final edu.toronto.cs.se.modelepedia.classdiagram.Class pSuper2, final Association pAssociation) {
      return rawStreamAllValuesOfsuper1(new Object[]{null, pSuper2, pAssociation});
    }

    /**
     * Retrieve the set of values that occur in matches for super1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.modelepedia.classdiagram.Class> getAllValuesOfsuper1(final SuperAssociations.Match partialMatch) {
      return rawStreamAllValuesOfsuper1(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for super1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.modelepedia.classdiagram.Class> getAllValuesOfsuper1(final edu.toronto.cs.se.modelepedia.classdiagram.Class pSuper2, final Association pAssociation) {
      return rawStreamAllValuesOfsuper1(new Object[]{null, pSuper2, pAssociation}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for super2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<edu.toronto.cs.se.modelepedia.classdiagram.Class> rawStreamAllValuesOfsuper2(final Object[] parameters) {
      return rawStreamAllValues(POSITION_SUPER2, parameters).map(edu.toronto.cs.se.modelepedia.classdiagram.Class.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for super2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.modelepedia.classdiagram.Class> getAllValuesOfsuper2() {
      return rawStreamAllValuesOfsuper2(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for super2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.modelepedia.classdiagram.Class> streamAllValuesOfsuper2() {
      return rawStreamAllValuesOfsuper2(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for super2.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.modelepedia.classdiagram.Class> streamAllValuesOfsuper2(final SuperAssociations.Match partialMatch) {
      return rawStreamAllValuesOfsuper2(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for super2.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.modelepedia.classdiagram.Class> streamAllValuesOfsuper2(final edu.toronto.cs.se.modelepedia.classdiagram.Class pSuper1, final Association pAssociation) {
      return rawStreamAllValuesOfsuper2(new Object[]{pSuper1, null, pAssociation});
    }

    /**
     * Retrieve the set of values that occur in matches for super2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.modelepedia.classdiagram.Class> getAllValuesOfsuper2(final SuperAssociations.Match partialMatch) {
      return rawStreamAllValuesOfsuper2(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for super2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.modelepedia.classdiagram.Class> getAllValuesOfsuper2(final edu.toronto.cs.se.modelepedia.classdiagram.Class pSuper1, final Association pAssociation) {
      return rawStreamAllValuesOfsuper2(new Object[]{pSuper1, null, pAssociation}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for association.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Association> rawStreamAllValuesOfassociation(final Object[] parameters) {
      return rawStreamAllValues(POSITION_ASSOCIATION, parameters).map(Association.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for association.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Association> getAllValuesOfassociation() {
      return rawStreamAllValuesOfassociation(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for association.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Association> streamAllValuesOfassociation() {
      return rawStreamAllValuesOfassociation(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for association.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Association> streamAllValuesOfassociation(final SuperAssociations.Match partialMatch) {
      return rawStreamAllValuesOfassociation(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for association.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Association> streamAllValuesOfassociation(final edu.toronto.cs.se.modelepedia.classdiagram.Class pSuper1, final edu.toronto.cs.se.modelepedia.classdiagram.Class pSuper2) {
      return rawStreamAllValuesOfassociation(new Object[]{pSuper1, pSuper2, null});
    }

    /**
     * Retrieve the set of values that occur in matches for association.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Association> getAllValuesOfassociation(final SuperAssociations.Match partialMatch) {
      return rawStreamAllValuesOfassociation(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for association.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Association> getAllValuesOfassociation(final edu.toronto.cs.se.modelepedia.classdiagram.Class pSuper1, final edu.toronto.cs.se.modelepedia.classdiagram.Class pSuper2) {
      return rawStreamAllValuesOfassociation(new Object[]{pSuper1, pSuper2, null}).collect(Collectors.toSet());
    }

    @Override
    protected SuperAssociations.Match tupleToMatch(final Tuple t) {
      try {
          return SuperAssociations.Match.newMatch((edu.toronto.cs.se.modelepedia.classdiagram.Class) t.get(POSITION_SUPER1), (edu.toronto.cs.se.modelepedia.classdiagram.Class) t.get(POSITION_SUPER2), (Association) t.get(POSITION_ASSOCIATION));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected SuperAssociations.Match arrayToMatch(final Object[] match) {
      try {
          return SuperAssociations.Match.newMatch((edu.toronto.cs.se.modelepedia.classdiagram.Class) match[POSITION_SUPER1], (edu.toronto.cs.se.modelepedia.classdiagram.Class) match[POSITION_SUPER2], (Association) match[POSITION_ASSOCIATION]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected SuperAssociations.Match arrayToMatchMutable(final Object[] match) {
      try {
          return SuperAssociations.Match.newMutableMatch((edu.toronto.cs.se.modelepedia.classdiagram.Class) match[POSITION_SUPER1], (edu.toronto.cs.se.modelepedia.classdiagram.Class) match[POSITION_SUPER2], (Association) match[POSITION_ASSOCIATION]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    /**
     * @return the singleton instance of the query specification of this pattern
     * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
     * 
     */
    public static IQuerySpecification<SuperAssociations.Matcher> querySpecification() {
      return SuperAssociations.instance();
    }
  }

  private SuperAssociations() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static SuperAssociations instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected SuperAssociations.Matcher instantiate(final ViatraQueryEngine engine) {
    return SuperAssociations.Matcher.on(engine);
  }

  @Override
  public SuperAssociations.Matcher instantiate() {
    return SuperAssociations.Matcher.create();
  }

  @Override
  public SuperAssociations.Match newEmptyMatch() {
    return SuperAssociations.Match.newEmptyMatch();
  }

  @Override
  public SuperAssociations.Match newMatch(final Object... parameters) {
    return SuperAssociations.Match.newMatch((edu.toronto.cs.se.modelepedia.classdiagram.Class) parameters[0], (edu.toronto.cs.se.modelepedia.classdiagram.Class) parameters[1], (edu.toronto.cs.se.modelepedia.classdiagram.Association) parameters[2]);
  }

  /**
   * Inner class allowing the singleton instance of {@link SuperAssociations} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link SuperAssociations#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final SuperAssociations INSTANCE = new SuperAssociations();

    /**
     * Statically initializes the query specification <b>after</b> the field {@link #INSTANCE} is assigned.
     * This initialization order is required to support indirect recursion.
     * 
     * <p> The static initializer is defined using a helper field to work around limitations of the code generator.
     * 
     */
    private static final Object STATIC_INITIALIZER = ensureInitialized();

    public static Object ensureInitialized() {
      INSTANCE.ensureInitializedInternal();
      return null;
    }
  }

  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private static final SuperAssociations.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_super1 = new PParameter("super1", "edu.toronto.cs.se.modelepedia.classdiagram.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Class")), PParameterDirection.INOUT);

    private final PParameter parameter_super2 = new PParameter("super2", "edu.toronto.cs.se.modelepedia.classdiagram.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Class")), PParameterDirection.INOUT);

    private final PParameter parameter_association = new PParameter("association", "edu.toronto.cs.se.modelepedia.classdiagram.Association", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Association")), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_super1, parameter_super2, parameter_association);

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "vamos23.superAssociations";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("super1","super2","association");
    }

    @Override
    public List<PParameter> getParameters() {
      return parameters;
    }

    @Override
    public Set<PBody> doGetContainedBodies() {
      setEvaluationHints(new QueryEvaluationHint(null, QueryEvaluationHint.BackendRequirement.UNSPECIFIED));
      Set<PBody> bodies = new LinkedHashSet<>();
      {
          PBody body = new PBody(this);
          PVariable var_super1 = body.getOrCreateVariableByName("super1");
          PVariable var_super2 = body.getOrCreateVariableByName("super2");
          PVariable var_association = body.getOrCreateVariableByName("association");
          PVariable var_sub1 = body.getOrCreateVariableByName("sub1");
          PVariable var_sub2 = body.getOrCreateVariableByName("sub2");
          new TypeConstraint(body, Tuples.flatTupleOf(var_super1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Class")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_super2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Class")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_association), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Association")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_super1, parameter_super1),
             new ExportedParameter(body, var_super2, parameter_super2),
             new ExportedParameter(body, var_association, parameter_association)
          ));
          //   super1 != super2
          new Inequality(body, var_super1, var_super2);
          //   Class.superclass(sub1, super1)
          new TypeConstraint(body, Tuples.flatTupleOf(var_sub1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Class")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_sub1, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Class", "superclass")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Class")));
          new Equality(body, var__virtual_0_, var_super1);
          //   Class.superclass(sub2, super2)
          new TypeConstraint(body, Tuples.flatTupleOf(var_sub2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Class")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_sub2, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Class", "superclass")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Class")));
          new Equality(body, var__virtual_1_, var_super2);
          //   sub1 != sub2
          new Inequality(body, var_sub1, var_sub2);
          //   Class.associationsAsSource(super1, association)
          new TypeConstraint(body, Tuples.flatTupleOf(var_super1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Class")));
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_super1, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Class", "associationsAsSource")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Association")));
          new Equality(body, var__virtual_2_, var_association);
          //   Class.associationsAsTarget(super2, association)
          new TypeConstraint(body, Tuples.flatTupleOf(var_super2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Class")));
          PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_super2, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Class", "associationsAsTarget")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_3_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Association")));
          new Equality(body, var__virtual_3_, var_association);
          bodies.add(body);
      }
      return bodies;
    }
  }
}

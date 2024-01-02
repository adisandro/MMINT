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
package edu.toronto.cs.se.mmint.productline.viatra.tests;

import edu.toronto.cs.se.mmint.viatra.mid.ConnectedEMFObjects;
import edu.toronto.cs.se.modelepedia.gsn.Goal;
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
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.emf.types.EDataTypeInSlotsKey;
import org.eclipse.viatra.query.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.ConstantValue;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
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
 *         pattern asilBConnectedClassesCD(goal: Goal, clazz: Class) {
 *           Goal.asil.value(goal, ASILLevel::B);
 *           find connectedEMFObjects(goal, clazz);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class AsilBConnectedClassesCD extends BaseGeneratedEMFQuerySpecification<AsilBConnectedClassesCD.Matcher> {
  /**
   * Pattern-specific match representation of the edu.toronto.cs.se.mmint.productline.viatra.tests.asilBConnectedClassesCD pattern,
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
    private Goal fGoal;

    private edu.toronto.cs.se.modelepedia.classdiagram.Class fClazz;

    private static List<String> parameterNames = makeImmutableList("goal", "clazz");

    private Match(final Goal pGoal, final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz) {
      this.fGoal = pGoal;
      this.fClazz = pClazz;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "goal": return this.fGoal;
          case "clazz": return this.fClazz;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fGoal;
          case 1: return this.fClazz;
          default: return null;
      }
    }

    public Goal getGoal() {
      return this.fGoal;
    }

    public edu.toronto.cs.se.modelepedia.classdiagram.Class getClazz() {
      return this.fClazz;
    }

    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("goal".equals(parameterName) ) {
          this.fGoal = (Goal) newValue;
          return true;
      }
      if ("clazz".equals(parameterName) ) {
          this.fClazz = (edu.toronto.cs.se.modelepedia.classdiagram.Class) newValue;
          return true;
      }
      return false;
    }

    public void setGoal(final Goal pGoal) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fGoal = pGoal;
    }

    public void setClazz(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fClazz = pClazz;
    }

    @Override
    public String patternName() {
      return "edu.toronto.cs.se.mmint.productline.viatra.tests.asilBConnectedClassesCD";
    }

    @Override
    public List<String> parameterNames() {
      return AsilBConnectedClassesCD.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fGoal, fClazz};
    }

    @Override
    public AsilBConnectedClassesCD.Match toImmutable() {
      return isMutable() ? newMatch(fGoal, fClazz) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"goal\"=" + prettyPrintValue(fGoal) + ", ");
      result.append("\"clazz\"=" + prettyPrintValue(fClazz));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fGoal, fClazz);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof AsilBConnectedClassesCD.Match)) {
          AsilBConnectedClassesCD.Match other = (AsilBConnectedClassesCD.Match) obj;
          return Objects.equals(fGoal, other.fGoal) && Objects.equals(fClazz, other.fClazz);
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
    public AsilBConnectedClassesCD specification() {
      return AsilBConnectedClassesCD.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static AsilBConnectedClassesCD.Match newEmptyMatch() {
      return new Mutable(null, null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pGoal the fixed value of pattern parameter goal, or null if not bound.
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static AsilBConnectedClassesCD.Match newMutableMatch(final Goal pGoal, final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz) {
      return new Mutable(pGoal, pClazz);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pGoal the fixed value of pattern parameter goal, or null if not bound.
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static AsilBConnectedClassesCD.Match newMatch(final Goal pGoal, final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz) {
      return new Immutable(pGoal, pClazz);
    }

    private static final class Mutable extends AsilBConnectedClassesCD.Match {
      Mutable(final Goal pGoal, final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz) {
        super(pGoal, pClazz);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends AsilBConnectedClassesCD.Match {
      Immutable(final Goal pGoal, final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz) {
        super(pGoal, pClazz);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the edu.toronto.cs.se.mmint.productline.viatra.tests.asilBConnectedClassesCD pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern asilBConnectedClassesCD(goal: Goal, clazz: Class) {
   *   Goal.asil.value(goal, ASILLevel::B);
   *   find connectedEMFObjects(goal, clazz);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see AsilBConnectedClassesCD
   * 
   */
  public static class Matcher extends BaseMatcher<AsilBConnectedClassesCD.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static AsilBConnectedClassesCD.Matcher on(final ViatraQueryEngine engine) {
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
    public static AsilBConnectedClassesCD.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_GOAL = 0;

    private static final int POSITION_CLAZZ = 1;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(AsilBConnectedClassesCD.Matcher.class);

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
     * @param pGoal the fixed value of pattern parameter goal, or null if not bound.
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<AsilBConnectedClassesCD.Match> getAllMatches(final Goal pGoal, final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz) {
      return rawStreamAllMatches(new Object[]{pGoal, pClazz}).collect(Collectors.toSet());
    }

    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pGoal the fixed value of pattern parameter goal, or null if not bound.
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<AsilBConnectedClassesCD.Match> streamAllMatches(final Goal pGoal, final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz) {
      return rawStreamAllMatches(new Object[]{pGoal, pClazz});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pGoal the fixed value of pattern parameter goal, or null if not bound.
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<AsilBConnectedClassesCD.Match> getOneArbitraryMatch(final Goal pGoal, final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz) {
      return rawGetOneArbitraryMatch(new Object[]{pGoal, pClazz});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pGoal the fixed value of pattern parameter goal, or null if not bound.
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final Goal pGoal, final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz) {
      return rawHasMatch(new Object[]{pGoal, pClazz});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pGoal the fixed value of pattern parameter goal, or null if not bound.
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final Goal pGoal, final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz) {
      return rawCountMatches(new Object[]{pGoal, pClazz});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pGoal the fixed value of pattern parameter goal, or null if not bound.
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final Goal pGoal, final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz, final Consumer<? super AsilBConnectedClassesCD.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pGoal, pClazz}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pGoal the fixed value of pattern parameter goal, or null if not bound.
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public AsilBConnectedClassesCD.Match newMatch(final Goal pGoal, final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz) {
      return AsilBConnectedClassesCD.Match.newMatch(pGoal, pClazz);
    }

    /**
     * Retrieve the set of values that occur in matches for goal.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Goal> rawStreamAllValuesOfgoal(final Object[] parameters) {
      return rawStreamAllValues(POSITION_GOAL, parameters).map(Goal.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for goal.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Goal> getAllValuesOfgoal() {
      return rawStreamAllValuesOfgoal(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for goal.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Goal> streamAllValuesOfgoal() {
      return rawStreamAllValuesOfgoal(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for goal.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Goal> streamAllValuesOfgoal(final AsilBConnectedClassesCD.Match partialMatch) {
      return rawStreamAllValuesOfgoal(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for goal.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Goal> streamAllValuesOfgoal(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz) {
      return rawStreamAllValuesOfgoal(new Object[]{null, pClazz});
    }

    /**
     * Retrieve the set of values that occur in matches for goal.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Goal> getAllValuesOfgoal(final AsilBConnectedClassesCD.Match partialMatch) {
      return rawStreamAllValuesOfgoal(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for goal.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Goal> getAllValuesOfgoal(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz) {
      return rawStreamAllValuesOfgoal(new Object[]{null, pClazz}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for clazz.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<edu.toronto.cs.se.modelepedia.classdiagram.Class> rawStreamAllValuesOfclazz(final Object[] parameters) {
      return rawStreamAllValues(POSITION_CLAZZ, parameters).map(edu.toronto.cs.se.modelepedia.classdiagram.Class.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for clazz.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.modelepedia.classdiagram.Class> getAllValuesOfclazz() {
      return rawStreamAllValuesOfclazz(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for clazz.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.modelepedia.classdiagram.Class> streamAllValuesOfclazz() {
      return rawStreamAllValuesOfclazz(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for clazz.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.modelepedia.classdiagram.Class> streamAllValuesOfclazz(final AsilBConnectedClassesCD.Match partialMatch) {
      return rawStreamAllValuesOfclazz(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for clazz.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.modelepedia.classdiagram.Class> streamAllValuesOfclazz(final Goal pGoal) {
      return rawStreamAllValuesOfclazz(new Object[]{pGoal, null});
    }

    /**
     * Retrieve the set of values that occur in matches for clazz.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.modelepedia.classdiagram.Class> getAllValuesOfclazz(final AsilBConnectedClassesCD.Match partialMatch) {
      return rawStreamAllValuesOfclazz(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for clazz.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.modelepedia.classdiagram.Class> getAllValuesOfclazz(final Goal pGoal) {
      return rawStreamAllValuesOfclazz(new Object[]{pGoal, null}).collect(Collectors.toSet());
    }

    @Override
    protected AsilBConnectedClassesCD.Match tupleToMatch(final Tuple t) {
      try {
          return AsilBConnectedClassesCD.Match.newMatch((Goal) t.get(POSITION_GOAL), (edu.toronto.cs.se.modelepedia.classdiagram.Class) t.get(POSITION_CLAZZ));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected AsilBConnectedClassesCD.Match arrayToMatch(final Object[] match) {
      try {
          return AsilBConnectedClassesCD.Match.newMatch((Goal) match[POSITION_GOAL], (edu.toronto.cs.se.modelepedia.classdiagram.Class) match[POSITION_CLAZZ]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected AsilBConnectedClassesCD.Match arrayToMatchMutable(final Object[] match) {
      try {
          return AsilBConnectedClassesCD.Match.newMutableMatch((Goal) match[POSITION_GOAL], (edu.toronto.cs.se.modelepedia.classdiagram.Class) match[POSITION_CLAZZ]);
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
    public static IQuerySpecification<AsilBConnectedClassesCD.Matcher> querySpecification() {
      return AsilBConnectedClassesCD.instance();
    }
  }

  private AsilBConnectedClassesCD() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static AsilBConnectedClassesCD instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected AsilBConnectedClassesCD.Matcher instantiate(final ViatraQueryEngine engine) {
    return AsilBConnectedClassesCD.Matcher.on(engine);
  }

  @Override
  public AsilBConnectedClassesCD.Matcher instantiate() {
    return AsilBConnectedClassesCD.Matcher.create();
  }

  @Override
  public AsilBConnectedClassesCD.Match newEmptyMatch() {
    return AsilBConnectedClassesCD.Match.newEmptyMatch();
  }

  @Override
  public AsilBConnectedClassesCD.Match newMatch(final Object... parameters) {
    return AsilBConnectedClassesCD.Match.newMatch((edu.toronto.cs.se.modelepedia.gsn.Goal) parameters[0], (edu.toronto.cs.se.modelepedia.classdiagram.Class) parameters[1]);
  }

  /**
   * Inner class allowing the singleton instance of {@link AsilBConnectedClassesCD} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link AsilBConnectedClassesCD#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final AsilBConnectedClassesCD INSTANCE = new AsilBConnectedClassesCD();

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
    private static final AsilBConnectedClassesCD.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_goal = new PParameter("goal", "edu.toronto.cs.se.modelepedia.gsn.Goal", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://se.cs.toronto.edu/modelepedia/GSN", "Goal")), PParameterDirection.INOUT);

    private final PParameter parameter_clazz = new PParameter("clazz", "edu.toronto.cs.se.modelepedia.classdiagram.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Class")), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_goal, parameter_clazz);

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "edu.toronto.cs.se.mmint.productline.viatra.tests.asilBConnectedClassesCD";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("goal","clazz");
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
          PVariable var_goal = body.getOrCreateVariableByName("goal");
          PVariable var_clazz = body.getOrCreateVariableByName("clazz");
          new TypeConstraint(body, Tuples.flatTupleOf(var_goal), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/GSN", "Goal")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_clazz), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Class")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_goal, parameter_goal),
             new ExportedParameter(body, var_clazz, parameter_clazz)
          ));
          //   Goal.asil.value(goal, ASILLevel::B)
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new ConstantValue(body, var__virtual_0_, edu.toronto.cs.se.modelepedia.gsn.ASILLevel.get("B"));
          new TypeConstraint(body, Tuples.flatTupleOf(var_goal), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/GSN", "Goal")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_goal, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://se.cs.toronto.edu/modelepedia/GSN", "ASILfulElement", "asil")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/GSN", "ASIL")));
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://se.cs.toronto.edu/modelepedia/GSN", "ASIL", "value")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/GSN", "ASILLevel")));
          new Equality(body, var__virtual_2_, var__virtual_0_);
          //   find connectedEMFObjects(goal, clazz)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_goal, var_clazz), ConnectedEMFObjects.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      return bodies;
    }
  }
}

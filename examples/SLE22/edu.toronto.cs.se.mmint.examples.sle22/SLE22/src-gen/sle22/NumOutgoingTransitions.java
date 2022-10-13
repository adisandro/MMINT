/**
 * 
 *   Copyright (c) 2022, 2022 Alessio Di Sandro.
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
package sle22;

import edu.toronto.cs.se.modelepedia.statemachine.State;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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
import org.eclipse.viatra.query.runtime.matchers.context.common.JavaTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.PatternMatchCounter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.TypeFilterConstraint;
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
 *         pattern numOutgoingTransitions(state: State,
 *                                        transitions: java Integer) {
 *           transitions == count Transition.source(_, state);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class NumOutgoingTransitions extends BaseGeneratedEMFQuerySpecification<NumOutgoingTransitions.Matcher> {
  /**
   * Pattern-specific match representation of the sle22.numOutgoingTransitions pattern,
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
    private State fState;

    private Integer fTransitions;

    private static List<String> parameterNames = makeImmutableList("state", "transitions");

    private Match(final State pState, final Integer pTransitions) {
      this.fState = pState;
      this.fTransitions = pTransitions;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "state": return this.fState;
          case "transitions": return this.fTransitions;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fState;
          case 1: return this.fTransitions;
          default: return null;
      }
    }

    public State getState() {
      return this.fState;
    }

    public Integer getTransitions() {
      return this.fTransitions;
    }

    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("state".equals(parameterName) ) {
          this.fState = (State) newValue;
          return true;
      }
      if ("transitions".equals(parameterName) ) {
          this.fTransitions = (Integer) newValue;
          return true;
      }
      return false;
    }

    public void setState(final State pState) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fState = pState;
    }

    public void setTransitions(final Integer pTransitions) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fTransitions = pTransitions;
    }

    @Override
    public String patternName() {
      return "sle22.numOutgoingTransitions";
    }

    @Override
    public List<String> parameterNames() {
      return NumOutgoingTransitions.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fState, fTransitions};
    }

    @Override
    public NumOutgoingTransitions.Match toImmutable() {
      return isMutable() ? newMatch(fState, fTransitions) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"state\"=" + prettyPrintValue(fState) + ", ");
      result.append("\"transitions\"=" + prettyPrintValue(fTransitions));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fState, fTransitions);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof NumOutgoingTransitions.Match)) {
          NumOutgoingTransitions.Match other = (NumOutgoingTransitions.Match) obj;
          return Objects.equals(fState, other.fState) && Objects.equals(fTransitions, other.fTransitions);
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
    public NumOutgoingTransitions specification() {
      return NumOutgoingTransitions.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static NumOutgoingTransitions.Match newEmptyMatch() {
      return new Mutable(null, null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pState the fixed value of pattern parameter state, or null if not bound.
     * @param pTransitions the fixed value of pattern parameter transitions, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static NumOutgoingTransitions.Match newMutableMatch(final State pState, final Integer pTransitions) {
      return new Mutable(pState, pTransitions);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pState the fixed value of pattern parameter state, or null if not bound.
     * @param pTransitions the fixed value of pattern parameter transitions, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static NumOutgoingTransitions.Match newMatch(final State pState, final Integer pTransitions) {
      return new Immutable(pState, pTransitions);
    }

    private static final class Mutable extends NumOutgoingTransitions.Match {
      Mutable(final State pState, final Integer pTransitions) {
        super(pState, pTransitions);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends NumOutgoingTransitions.Match {
      Immutable(final State pState, final Integer pTransitions) {
        super(pState, pTransitions);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the sle22.numOutgoingTransitions pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern numOutgoingTransitions(state: State,
   *                                transitions: java Integer) {
   *   transitions == count Transition.source(_, state);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see NumOutgoingTransitions
   * 
   */
  public static class Matcher extends BaseMatcher<NumOutgoingTransitions.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static NumOutgoingTransitions.Matcher on(final ViatraQueryEngine engine) {
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
    public static NumOutgoingTransitions.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_STATE = 0;

    private static final int POSITION_TRANSITIONS = 1;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(NumOutgoingTransitions.Matcher.class);

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
     * @param pState the fixed value of pattern parameter state, or null if not bound.
     * @param pTransitions the fixed value of pattern parameter transitions, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<NumOutgoingTransitions.Match> getAllMatches(final State pState, final Integer pTransitions) {
      return rawStreamAllMatches(new Object[]{pState, pTransitions}).collect(Collectors.toSet());
    }

    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pState the fixed value of pattern parameter state, or null if not bound.
     * @param pTransitions the fixed value of pattern parameter transitions, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<NumOutgoingTransitions.Match> streamAllMatches(final State pState, final Integer pTransitions) {
      return rawStreamAllMatches(new Object[]{pState, pTransitions});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pState the fixed value of pattern parameter state, or null if not bound.
     * @param pTransitions the fixed value of pattern parameter transitions, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<NumOutgoingTransitions.Match> getOneArbitraryMatch(final State pState, final Integer pTransitions) {
      return rawGetOneArbitraryMatch(new Object[]{pState, pTransitions});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pState the fixed value of pattern parameter state, or null if not bound.
     * @param pTransitions the fixed value of pattern parameter transitions, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final State pState, final Integer pTransitions) {
      return rawHasMatch(new Object[]{pState, pTransitions});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pState the fixed value of pattern parameter state, or null if not bound.
     * @param pTransitions the fixed value of pattern parameter transitions, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final State pState, final Integer pTransitions) {
      return rawCountMatches(new Object[]{pState, pTransitions});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pState the fixed value of pattern parameter state, or null if not bound.
     * @param pTransitions the fixed value of pattern parameter transitions, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final State pState, final Integer pTransitions, final Consumer<? super NumOutgoingTransitions.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pState, pTransitions}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pState the fixed value of pattern parameter state, or null if not bound.
     * @param pTransitions the fixed value of pattern parameter transitions, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public NumOutgoingTransitions.Match newMatch(final State pState, final Integer pTransitions) {
      return NumOutgoingTransitions.Match.newMatch(pState, pTransitions);
    }

    /**
     * Retrieve the set of values that occur in matches for state.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<State> rawStreamAllValuesOfstate(final Object[] parameters) {
      return rawStreamAllValues(POSITION_STATE, parameters).map(State.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for state.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<State> getAllValuesOfstate() {
      return rawStreamAllValuesOfstate(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for state.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<State> streamAllValuesOfstate() {
      return rawStreamAllValuesOfstate(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for state.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<State> streamAllValuesOfstate(final NumOutgoingTransitions.Match partialMatch) {
      return rawStreamAllValuesOfstate(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for state.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<State> streamAllValuesOfstate(final Integer pTransitions) {
      return rawStreamAllValuesOfstate(new Object[]{null, pTransitions});
    }

    /**
     * Retrieve the set of values that occur in matches for state.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<State> getAllValuesOfstate(final NumOutgoingTransitions.Match partialMatch) {
      return rawStreamAllValuesOfstate(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for state.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<State> getAllValuesOfstate(final Integer pTransitions) {
      return rawStreamAllValuesOfstate(new Object[]{null, pTransitions}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for transitions.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Integer> rawStreamAllValuesOftransitions(final Object[] parameters) {
      return rawStreamAllValues(POSITION_TRANSITIONS, parameters).map(Integer.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for transitions.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Integer> getAllValuesOftransitions() {
      return rawStreamAllValuesOftransitions(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for transitions.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Integer> streamAllValuesOftransitions() {
      return rawStreamAllValuesOftransitions(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for transitions.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Integer> streamAllValuesOftransitions(final NumOutgoingTransitions.Match partialMatch) {
      return rawStreamAllValuesOftransitions(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for transitions.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Integer> streamAllValuesOftransitions(final State pState) {
      return rawStreamAllValuesOftransitions(new Object[]{pState, null});
    }

    /**
     * Retrieve the set of values that occur in matches for transitions.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Integer> getAllValuesOftransitions(final NumOutgoingTransitions.Match partialMatch) {
      return rawStreamAllValuesOftransitions(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for transitions.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Integer> getAllValuesOftransitions(final State pState) {
      return rawStreamAllValuesOftransitions(new Object[]{pState, null}).collect(Collectors.toSet());
    }

    @Override
    protected NumOutgoingTransitions.Match tupleToMatch(final Tuple t) {
      try {
          return NumOutgoingTransitions.Match.newMatch((State) t.get(POSITION_STATE), (Integer) t.get(POSITION_TRANSITIONS));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected NumOutgoingTransitions.Match arrayToMatch(final Object[] match) {
      try {
          return NumOutgoingTransitions.Match.newMatch((State) match[POSITION_STATE], (Integer) match[POSITION_TRANSITIONS]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected NumOutgoingTransitions.Match arrayToMatchMutable(final Object[] match) {
      try {
          return NumOutgoingTransitions.Match.newMutableMatch((State) match[POSITION_STATE], (Integer) match[POSITION_TRANSITIONS]);
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
    public static IQuerySpecification<NumOutgoingTransitions.Matcher> querySpecification() {
      return NumOutgoingTransitions.instance();
    }
  }

  private NumOutgoingTransitions() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static NumOutgoingTransitions instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected NumOutgoingTransitions.Matcher instantiate(final ViatraQueryEngine engine) {
    return NumOutgoingTransitions.Matcher.on(engine);
  }

  @Override
  public NumOutgoingTransitions.Matcher instantiate() {
    return NumOutgoingTransitions.Matcher.create();
  }

  @Override
  public NumOutgoingTransitions.Match newEmptyMatch() {
    return NumOutgoingTransitions.Match.newEmptyMatch();
  }

  @Override
  public NumOutgoingTransitions.Match newMatch(final Object... parameters) {
    return NumOutgoingTransitions.Match.newMatch((edu.toronto.cs.se.modelepedia.statemachine.State) parameters[0], (java.lang.Integer) parameters[1]);
  }

  /**
   * Inner class allowing the singleton instance of {@link NumOutgoingTransitions} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link NumOutgoingTransitions#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final NumOutgoingTransitions INSTANCE = new NumOutgoingTransitions();

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
    private static final NumOutgoingTransitions.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_state = new PParameter("state", "edu.toronto.cs.se.modelepedia.statemachine.State", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://se.cs.toronto.edu/modelepedia/StateMachine", "State")), PParameterDirection.INOUT);

    private final PParameter parameter_transitions = new PParameter("transitions", "java.lang.Integer", new JavaTransitiveInstancesKey(java.lang.Integer.class), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_state, parameter_transitions);

    private class Embedded_1_Transition_source extends BaseGeneratedEMFPQuery {
      private final PParameter parameter_p0 = new PParameter("p0", "edu.toronto.cs.se.modelepedia.statemachine.Transition", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://se.cs.toronto.edu/modelepedia/StateMachine", "Transition")), PParameterDirection.INOUT);

      private final PParameter parameter_p1 = new PParameter("p1", "edu.toronto.cs.se.modelepedia.statemachine.AbstractState", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://se.cs.toronto.edu/modelepedia/StateMachine", "AbstractState")), PParameterDirection.INOUT);

      private final List<PParameter> embeddedParameters = Arrays.asList(parameter_p0, parameter_p1);

      public Embedded_1_Transition_source() {
        super(PVisibility.EMBEDDED);
      }

      @Override
      public String getFullyQualifiedName() {
        return GeneratedPQuery.this.getFullyQualifiedName() + "$Embedded_1_Transition_source";
      }

      @Override
      public List<PParameter> getParameters() {
        return embeddedParameters;
      }

      @Override
      public Set<PBody> doGetContainedBodies() {
        PBody body = new PBody(this);
        PVariable var_p0 = body.getOrCreateVariableByName("p0");
        PVariable var_p1 = body.getOrCreateVariableByName("p1");
        body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
           new ExportedParameter(body, var_p0, parameter_p0),
           new ExportedParameter(body, var_p1, parameter_p1)
        ));
        //  Transition.source(_, state)
        new TypeConstraint(body, Tuples.flatTupleOf(var_p0), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/StateMachine", "Transition")));
        PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
        new TypeConstraint(body, Tuples.flatTupleOf(var_p0, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://se.cs.toronto.edu/modelepedia/StateMachine", "Transition", "source")));
        new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/StateMachine", "AbstractState")));
        new Equality(body, var__virtual_0_, var_p1);
        return Collections.singleton(body);
      }
    }

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "sle22.numOutgoingTransitions";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("state","transitions");
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
          PVariable var_state = body.getOrCreateVariableByName("state");
          PVariable var_transitions = body.getOrCreateVariableByName("transitions");
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          new TypeConstraint(body, Tuples.flatTupleOf(var_state), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/StateMachine", "State")));
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_transitions), new JavaTransitiveInstancesKey(java.lang.Integer.class));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_state, parameter_state),
             new ExportedParameter(body, var_transitions, parameter_transitions)
          ));
          //   transitions == count Transition.source(_, state)
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new PatternMatchCounter(body, Tuples.flatTupleOf(var___0_, var_state), new NumOutgoingTransitions.GeneratedPQuery.Embedded_1_Transition_source(), var__virtual_0_);
          new Equality(body, var_transitions, var__virtual_0_);
          bodies.add(body);
      }
      return bodies;
    }
  }
}

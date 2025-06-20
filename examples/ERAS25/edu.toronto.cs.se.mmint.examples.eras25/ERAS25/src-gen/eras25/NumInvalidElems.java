/**
 * 
 *   Copyright (c) 2024, 2025 Alessio Di Sandro.
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
package eras25;

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
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.context.common.JavaTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.PatternMatchCounter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.TypeFilterConstraint;
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
 *         pattern numInvalidElems(invalid: java Integer) {
 *           invalid == count find invalidElems(_);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class NumInvalidElems extends BaseGeneratedEMFQuerySpecification<NumInvalidElems.Matcher> {
  /**
   * Pattern-specific match representation of the eras25.numInvalidElems pattern,
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
    private Integer fInvalid;

    private static List<String> parameterNames = makeImmutableList("invalid");

    private Match(final Integer pInvalid) {
      this.fInvalid = pInvalid;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "invalid": return this.fInvalid;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fInvalid;
          default: return null;
      }
    }

    public Integer getInvalid() {
      return this.fInvalid;
    }

    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("invalid".equals(parameterName) ) {
          this.fInvalid = (Integer) newValue;
          return true;
      }
      return false;
    }

    public void setInvalid(final Integer pInvalid) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fInvalid = pInvalid;
    }

    @Override
    public String patternName() {
      return "eras25.numInvalidElems";
    }

    @Override
    public List<String> parameterNames() {
      return NumInvalidElems.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fInvalid};
    }

    @Override
    public NumInvalidElems.Match toImmutable() {
      return isMutable() ? newMatch(fInvalid) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"invalid\"=" + prettyPrintValue(fInvalid));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fInvalid);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof NumInvalidElems.Match)) {
          NumInvalidElems.Match other = (NumInvalidElems.Match) obj;
          return Objects.equals(fInvalid, other.fInvalid);
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
    public NumInvalidElems specification() {
      return NumInvalidElems.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static NumInvalidElems.Match newEmptyMatch() {
      return new Mutable(null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pInvalid the fixed value of pattern parameter invalid, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static NumInvalidElems.Match newMutableMatch(final Integer pInvalid) {
      return new Mutable(pInvalid);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pInvalid the fixed value of pattern parameter invalid, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static NumInvalidElems.Match newMatch(final Integer pInvalid) {
      return new Immutable(pInvalid);
    }

    private static final class Mutable extends NumInvalidElems.Match {
      Mutable(final Integer pInvalid) {
        super(pInvalid);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends NumInvalidElems.Match {
      Immutable(final Integer pInvalid) {
        super(pInvalid);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the eras25.numInvalidElems pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern numInvalidElems(invalid: java Integer) {
   *   invalid == count find invalidElems(_);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see NumInvalidElems
   * 
   */
  public static class Matcher extends BaseMatcher<NumInvalidElems.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static NumInvalidElems.Matcher on(final ViatraQueryEngine engine) {
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
    public static NumInvalidElems.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_INVALID = 0;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(NumInvalidElems.Matcher.class);

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
     * @param pInvalid the fixed value of pattern parameter invalid, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<NumInvalidElems.Match> getAllMatches(final Integer pInvalid) {
      return rawStreamAllMatches(new Object[]{pInvalid}).collect(Collectors.toSet());
    }

    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pInvalid the fixed value of pattern parameter invalid, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<NumInvalidElems.Match> streamAllMatches(final Integer pInvalid) {
      return rawStreamAllMatches(new Object[]{pInvalid});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pInvalid the fixed value of pattern parameter invalid, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<NumInvalidElems.Match> getOneArbitraryMatch(final Integer pInvalid) {
      return rawGetOneArbitraryMatch(new Object[]{pInvalid});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pInvalid the fixed value of pattern parameter invalid, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final Integer pInvalid) {
      return rawHasMatch(new Object[]{pInvalid});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pInvalid the fixed value of pattern parameter invalid, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final Integer pInvalid) {
      return rawCountMatches(new Object[]{pInvalid});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pInvalid the fixed value of pattern parameter invalid, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final Integer pInvalid, final Consumer<? super NumInvalidElems.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pInvalid}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pInvalid the fixed value of pattern parameter invalid, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public NumInvalidElems.Match newMatch(final Integer pInvalid) {
      return NumInvalidElems.Match.newMatch(pInvalid);
    }

    /**
     * Retrieve the set of values that occur in matches for invalid.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Integer> rawStreamAllValuesOfinvalid(final Object[] parameters) {
      return rawStreamAllValues(POSITION_INVALID, parameters).map(Integer.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for invalid.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Integer> getAllValuesOfinvalid() {
      return rawStreamAllValuesOfinvalid(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for invalid.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Integer> streamAllValuesOfinvalid() {
      return rawStreamAllValuesOfinvalid(emptyArray());
    }

    @Override
    protected NumInvalidElems.Match tupleToMatch(final Tuple t) {
      try {
          return NumInvalidElems.Match.newMatch((Integer) t.get(POSITION_INVALID));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected NumInvalidElems.Match arrayToMatch(final Object[] match) {
      try {
          return NumInvalidElems.Match.newMatch((Integer) match[POSITION_INVALID]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected NumInvalidElems.Match arrayToMatchMutable(final Object[] match) {
      try {
          return NumInvalidElems.Match.newMutableMatch((Integer) match[POSITION_INVALID]);
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
    public static IQuerySpecification<NumInvalidElems.Matcher> querySpecification() {
      return NumInvalidElems.instance();
    }
  }

  private NumInvalidElems() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static NumInvalidElems instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected NumInvalidElems.Matcher instantiate(final ViatraQueryEngine engine) {
    return NumInvalidElems.Matcher.on(engine);
  }

  @Override
  public NumInvalidElems.Matcher instantiate() {
    return NumInvalidElems.Matcher.create();
  }

  @Override
  public NumInvalidElems.Match newEmptyMatch() {
    return NumInvalidElems.Match.newEmptyMatch();
  }

  @Override
  public NumInvalidElems.Match newMatch(final Object... parameters) {
    return NumInvalidElems.Match.newMatch((Integer) parameters[0]);
  }

  /**
   * Inner class allowing the singleton instance of {@link NumInvalidElems} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link NumInvalidElems#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final NumInvalidElems INSTANCE = new NumInvalidElems();

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
    private static final NumInvalidElems.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_invalid = new PParameter("invalid", "java.lang.Integer", new JavaTransitiveInstancesKey(java.lang.Integer.class), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_invalid);

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "eras25.numInvalidElems";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("invalid");
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
          PVariable var_invalid = body.getOrCreateVariableByName("invalid");
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_invalid), new JavaTransitiveInstancesKey(java.lang.Integer.class));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_invalid, parameter_invalid)
          ));
          //   invalid == count find invalidElems(_)
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new PatternMatchCounter(body, Tuples.flatTupleOf(var___0_), InvalidElems.instance().getInternalQueryRepresentation(), var__virtual_0_);
          new Equality(body, var_invalid, var__virtual_0_);
          bodies.add(body);
      }
      return bodies;
    }
  }
}

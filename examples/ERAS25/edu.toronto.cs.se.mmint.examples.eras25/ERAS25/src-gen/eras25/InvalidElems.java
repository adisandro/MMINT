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

import edu.toronto.cs.se.modelepedia.gsn.ArgumentElement;
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
 *         pattern invalidElems(elem: ArgumentElement) {
 *           ArgumentElement.valid(elem, false);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class InvalidElems extends BaseGeneratedEMFQuerySpecification<InvalidElems.Matcher> {
  /**
   * Pattern-specific match representation of the eras25.invalidElems pattern,
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
    private ArgumentElement fElem;

    private static List<String> parameterNames = makeImmutableList("elem");

    private Match(final ArgumentElement pElem) {
      this.fElem = pElem;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "elem": return this.fElem;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fElem;
          default: return null;
      }
    }

    public ArgumentElement getElem() {
      return this.fElem;
    }

    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("elem".equals(parameterName) ) {
          this.fElem = (ArgumentElement) newValue;
          return true;
      }
      return false;
    }

    public void setElem(final ArgumentElement pElem) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fElem = pElem;
    }

    @Override
    public String patternName() {
      return "eras25.invalidElems";
    }

    @Override
    public List<String> parameterNames() {
      return InvalidElems.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fElem};
    }

    @Override
    public InvalidElems.Match toImmutable() {
      return isMutable() ? newMatch(fElem) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"elem\"=" + prettyPrintValue(fElem));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fElem);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof InvalidElems.Match)) {
          InvalidElems.Match other = (InvalidElems.Match) obj;
          return Objects.equals(fElem, other.fElem);
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
    public InvalidElems specification() {
      return InvalidElems.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static InvalidElems.Match newEmptyMatch() {
      return new Mutable(null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pElem the fixed value of pattern parameter elem, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static InvalidElems.Match newMutableMatch(final ArgumentElement pElem) {
      return new Mutable(pElem);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pElem the fixed value of pattern parameter elem, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static InvalidElems.Match newMatch(final ArgumentElement pElem) {
      return new Immutable(pElem);
    }

    private static final class Mutable extends InvalidElems.Match {
      Mutable(final ArgumentElement pElem) {
        super(pElem);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends InvalidElems.Match {
      Immutable(final ArgumentElement pElem) {
        super(pElem);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the eras25.invalidElems pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern invalidElems(elem: ArgumentElement) {
   *   ArgumentElement.valid(elem, false);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see InvalidElems
   * 
   */
  public static class Matcher extends BaseMatcher<InvalidElems.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static InvalidElems.Matcher on(final ViatraQueryEngine engine) {
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
    public static InvalidElems.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_ELEM = 0;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(InvalidElems.Matcher.class);

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
     * @param pElem the fixed value of pattern parameter elem, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<InvalidElems.Match> getAllMatches(final ArgumentElement pElem) {
      return rawStreamAllMatches(new Object[]{pElem}).collect(Collectors.toSet());
    }

    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pElem the fixed value of pattern parameter elem, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<InvalidElems.Match> streamAllMatches(final ArgumentElement pElem) {
      return rawStreamAllMatches(new Object[]{pElem});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pElem the fixed value of pattern parameter elem, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<InvalidElems.Match> getOneArbitraryMatch(final ArgumentElement pElem) {
      return rawGetOneArbitraryMatch(new Object[]{pElem});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pElem the fixed value of pattern parameter elem, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final ArgumentElement pElem) {
      return rawHasMatch(new Object[]{pElem});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pElem the fixed value of pattern parameter elem, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final ArgumentElement pElem) {
      return rawCountMatches(new Object[]{pElem});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pElem the fixed value of pattern parameter elem, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final ArgumentElement pElem, final Consumer<? super InvalidElems.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pElem}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pElem the fixed value of pattern parameter elem, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public InvalidElems.Match newMatch(final ArgumentElement pElem) {
      return InvalidElems.Match.newMatch(pElem);
    }

    /**
     * Retrieve the set of values that occur in matches for elem.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<ArgumentElement> rawStreamAllValuesOfelem(final Object[] parameters) {
      return rawStreamAllValues(POSITION_ELEM, parameters).map(ArgumentElement.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for elem.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ArgumentElement> getAllValuesOfelem() {
      return rawStreamAllValuesOfelem(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for elem.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<ArgumentElement> streamAllValuesOfelem() {
      return rawStreamAllValuesOfelem(emptyArray());
    }

    @Override
    protected InvalidElems.Match tupleToMatch(final Tuple t) {
      try {
          return InvalidElems.Match.newMatch((ArgumentElement) t.get(POSITION_ELEM));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected InvalidElems.Match arrayToMatch(final Object[] match) {
      try {
          return InvalidElems.Match.newMatch((ArgumentElement) match[POSITION_ELEM]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected InvalidElems.Match arrayToMatchMutable(final Object[] match) {
      try {
          return InvalidElems.Match.newMutableMatch((ArgumentElement) match[POSITION_ELEM]);
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
    public static IQuerySpecification<InvalidElems.Matcher> querySpecification() {
      return InvalidElems.instance();
    }
  }

  private InvalidElems() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static InvalidElems instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected InvalidElems.Matcher instantiate(final ViatraQueryEngine engine) {
    return InvalidElems.Matcher.on(engine);
  }

  @Override
  public InvalidElems.Matcher instantiate() {
    return InvalidElems.Matcher.create();
  }

  @Override
  public InvalidElems.Match newEmptyMatch() {
    return InvalidElems.Match.newEmptyMatch();
  }

  @Override
  public InvalidElems.Match newMatch(final Object... parameters) {
    return InvalidElems.Match.newMatch((ArgumentElement) parameters[0]);
  }

  /**
   * Inner class allowing the singleton instance of {@link InvalidElems} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link InvalidElems#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final InvalidElems INSTANCE = new InvalidElems();

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
    private static final InvalidElems.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_elem = new PParameter("elem", "edu.toronto.cs.se.modelepedia.gsn.ArgumentElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://se.cs.toronto.edu/modelepedia/GSN", "ArgumentElement")), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_elem);

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "eras25.invalidElems";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("elem");
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
          PVariable var_elem = body.getOrCreateVariableByName("elem");
          new TypeConstraint(body, Tuples.flatTupleOf(var_elem), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/GSN", "ArgumentElement")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_elem, parameter_elem)
          ));
          //   ArgumentElement.valid(elem, false)
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new ConstantValue(body, var__virtual_0_, false);
          new TypeConstraint(body, Tuples.flatTupleOf(var_elem), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/GSN", "ArgumentElement")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_elem, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://se.cs.toronto.edu/modelepedia/GSN", "ArgumentElement", "valid")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EBoolean")));
          new Equality(body, var__virtual_1_, var__virtual_0_);
          bodies.add(body);
      }
      return bodies;
    }
  }

  private static boolean evaluateExpression_1_1() {
    return false;
  }
}

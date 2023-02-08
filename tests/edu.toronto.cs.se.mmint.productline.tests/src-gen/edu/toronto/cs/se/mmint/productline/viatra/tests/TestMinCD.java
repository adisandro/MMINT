/**
 * 
 *   Copyright (c) 2022, 2023 Alessio Di Sandro.
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
import org.eclipse.viatra.query.runtime.matchers.aggregators.min;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.context.common.JavaTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.AggregatorConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
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
 *         pattern testMinCD(minName: java String) {
 *           minName == min Class.name(_, #name);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class TestMinCD extends BaseGeneratedEMFQuerySpecification<TestMinCD.Matcher> {
  /**
   * Pattern-specific match representation of the edu.toronto.cs.se.mmint.productline.viatra.tests.testMinCD pattern,
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
    private String fMinName;

    private static List<String> parameterNames = makeImmutableList("minName");

    private Match(final String pMinName) {
      this.fMinName = pMinName;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "minName": return this.fMinName;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fMinName;
          default: return null;
      }
    }

    public String getMinName() {
      return this.fMinName;
    }

    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("minName".equals(parameterName) ) {
          this.fMinName = (String) newValue;
          return true;
      }
      return false;
    }

    public void setMinName(final String pMinName) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fMinName = pMinName;
    }

    @Override
    public String patternName() {
      return "edu.toronto.cs.se.mmint.productline.viatra.tests.testMinCD";
    }

    @Override
    public List<String> parameterNames() {
      return TestMinCD.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fMinName};
    }

    @Override
    public TestMinCD.Match toImmutable() {
      return isMutable() ? newMatch(fMinName) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"minName\"=" + prettyPrintValue(fMinName));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fMinName);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof TestMinCD.Match)) {
          TestMinCD.Match other = (TestMinCD.Match) obj;
          return Objects.equals(fMinName, other.fMinName);
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
    public TestMinCD specification() {
      return TestMinCD.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static TestMinCD.Match newEmptyMatch() {
      return new Mutable(null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pMinName the fixed value of pattern parameter minName, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static TestMinCD.Match newMutableMatch(final String pMinName) {
      return new Mutable(pMinName);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pMinName the fixed value of pattern parameter minName, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static TestMinCD.Match newMatch(final String pMinName) {
      return new Immutable(pMinName);
    }

    private static final class Mutable extends TestMinCD.Match {
      Mutable(final String pMinName) {
        super(pMinName);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends TestMinCD.Match {
      Immutable(final String pMinName) {
        super(pMinName);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the edu.toronto.cs.se.mmint.productline.viatra.tests.testMinCD pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern testMinCD(minName: java String) {
   *   minName == min Class.name(_, #name);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see TestMinCD
   * 
   */
  public static class Matcher extends BaseMatcher<TestMinCD.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static TestMinCD.Matcher on(final ViatraQueryEngine engine) {
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
    public static TestMinCD.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_MINNAME = 0;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(TestMinCD.Matcher.class);

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
     * @param pMinName the fixed value of pattern parameter minName, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<TestMinCD.Match> getAllMatches(final String pMinName) {
      return rawStreamAllMatches(new Object[]{pMinName}).collect(Collectors.toSet());
    }

    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pMinName the fixed value of pattern parameter minName, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<TestMinCD.Match> streamAllMatches(final String pMinName) {
      return rawStreamAllMatches(new Object[]{pMinName});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pMinName the fixed value of pattern parameter minName, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<TestMinCD.Match> getOneArbitraryMatch(final String pMinName) {
      return rawGetOneArbitraryMatch(new Object[]{pMinName});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pMinName the fixed value of pattern parameter minName, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final String pMinName) {
      return rawHasMatch(new Object[]{pMinName});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pMinName the fixed value of pattern parameter minName, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final String pMinName) {
      return rawCountMatches(new Object[]{pMinName});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pMinName the fixed value of pattern parameter minName, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final String pMinName, final Consumer<? super TestMinCD.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pMinName}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pMinName the fixed value of pattern parameter minName, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public TestMinCD.Match newMatch(final String pMinName) {
      return TestMinCD.Match.newMatch(pMinName);
    }

    /**
     * Retrieve the set of values that occur in matches for minName.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<String> rawStreamAllValuesOfminName(final Object[] parameters) {
      return rawStreamAllValues(POSITION_MINNAME, parameters).map(String.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for minName.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfminName() {
      return rawStreamAllValuesOfminName(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for minName.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfminName() {
      return rawStreamAllValuesOfminName(emptyArray());
    }

    @Override
    protected TestMinCD.Match tupleToMatch(final Tuple t) {
      try {
          return TestMinCD.Match.newMatch((String) t.get(POSITION_MINNAME));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected TestMinCD.Match arrayToMatch(final Object[] match) {
      try {
          return TestMinCD.Match.newMatch((String) match[POSITION_MINNAME]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected TestMinCD.Match arrayToMatchMutable(final Object[] match) {
      try {
          return TestMinCD.Match.newMutableMatch((String) match[POSITION_MINNAME]);
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
    public static IQuerySpecification<TestMinCD.Matcher> querySpecification() {
      return TestMinCD.instance();
    }
  }

  private TestMinCD() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static TestMinCD instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected TestMinCD.Matcher instantiate(final ViatraQueryEngine engine) {
    return TestMinCD.Matcher.on(engine);
  }

  @Override
  public TestMinCD.Matcher instantiate() {
    return TestMinCD.Matcher.create();
  }

  @Override
  public TestMinCD.Match newEmptyMatch() {
    return TestMinCD.Match.newEmptyMatch();
  }

  @Override
  public TestMinCD.Match newMatch(final Object... parameters) {
    return TestMinCD.Match.newMatch((java.lang.String) parameters[0]);
  }

  /**
   * Inner class allowing the singleton instance of {@link TestMinCD} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link TestMinCD#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final TestMinCD INSTANCE = new TestMinCD();

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
    private static final TestMinCD.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_minName = new PParameter("minName", "java.lang.String", new JavaTransitiveInstancesKey(java.lang.String.class), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_minName);

    private class Embedded_1_Class_name extends BaseGeneratedEMFPQuery {
      private final PParameter parameter_p0 = new PParameter("p0", "edu.toronto.cs.se.modelepedia.classdiagram.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Class")), PParameterDirection.INOUT);

      private final PParameter parameter_p1 = new PParameter("p1", "java.lang.String", new EDataTypeInSlotsKey((EDataType)getClassifierLiteralSafe("http://www.eclipse.org/emf/2002/Ecore", "EString")), PParameterDirection.INOUT);

      private final List<PParameter> embeddedParameters = Arrays.asList(parameter_p0, parameter_p1);

      public Embedded_1_Class_name() {
        super(PVisibility.EMBEDDED);
      }

      @Override
      public String getFullyQualifiedName() {
        return GeneratedPQuery.this.getFullyQualifiedName() + "$Embedded_1_Class_name";
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
        //  Class.name(_, #name)
        new TypeConstraint(body, Tuples.flatTupleOf(var_p0), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Class")));
        PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
        new TypeConstraint(body, Tuples.flatTupleOf(var_p0, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "NamedElement", "name")));
        new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EString")));
        new Equality(body, var__virtual_0_, var_p1);
        return Collections.singleton(body);
      }
    }

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "edu.toronto.cs.se.mmint.productline.viatra.tests.testMinCD";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("minName");
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
          PVariable var_minName = body.getOrCreateVariableByName("minName");
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          PVariable var__name = body.getOrCreateVariableByName("#name");
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_minName), new JavaTransitiveInstancesKey(java.lang.String.class));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_minName, parameter_minName)
          ));
          //   minName == min Class.name(_, #name)
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new AggregatorConstraint(new min().getAggregatorLogic(String.class), body, Tuples.flatTupleOf(var___0_, var__name), new TestMinCD.GeneratedPQuery.Embedded_1_Class_name(), var__virtual_0_, 1);
          new Equality(body, var_minName, var__virtual_0_);
          bodies.add(body);
      }
      return bodies;
    }
  }
}

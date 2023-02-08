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
 *         pattern testMultipleEdgesCD(clazz: Class) {
 *           Class.superclass.name(clazz, "parent2");
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class TestMultipleEdgesCD extends BaseGeneratedEMFQuerySpecification<TestMultipleEdgesCD.Matcher> {
  /**
   * Pattern-specific match representation of the edu.toronto.cs.se.mmint.productline.viatra.tests.testMultipleEdgesCD pattern,
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
    private edu.toronto.cs.se.modelepedia.classdiagram.Class fClazz;

    private static List<String> parameterNames = makeImmutableList("clazz");

    private Match(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz) {
      this.fClazz = pClazz;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "clazz": return this.fClazz;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fClazz;
          default: return null;
      }
    }

    public edu.toronto.cs.se.modelepedia.classdiagram.Class getClazz() {
      return this.fClazz;
    }

    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("clazz".equals(parameterName) ) {
          this.fClazz = (edu.toronto.cs.se.modelepedia.classdiagram.Class) newValue;
          return true;
      }
      return false;
    }

    public void setClazz(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fClazz = pClazz;
    }

    @Override
    public String patternName() {
      return "edu.toronto.cs.se.mmint.productline.viatra.tests.testMultipleEdgesCD";
    }

    @Override
    public List<String> parameterNames() {
      return TestMultipleEdgesCD.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fClazz};
    }

    @Override
    public TestMultipleEdgesCD.Match toImmutable() {
      return isMutable() ? newMatch(fClazz) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"clazz\"=" + prettyPrintValue(fClazz));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fClazz);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof TestMultipleEdgesCD.Match)) {
          TestMultipleEdgesCD.Match other = (TestMultipleEdgesCD.Match) obj;
          return Objects.equals(fClazz, other.fClazz);
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
    public TestMultipleEdgesCD specification() {
      return TestMultipleEdgesCD.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static TestMultipleEdgesCD.Match newEmptyMatch() {
      return new Mutable(null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static TestMultipleEdgesCD.Match newMutableMatch(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz) {
      return new Mutable(pClazz);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static TestMultipleEdgesCD.Match newMatch(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz) {
      return new Immutable(pClazz);
    }

    private static final class Mutable extends TestMultipleEdgesCD.Match {
      Mutable(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz) {
        super(pClazz);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends TestMultipleEdgesCD.Match {
      Immutable(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz) {
        super(pClazz);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the edu.toronto.cs.se.mmint.productline.viatra.tests.testMultipleEdgesCD pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern testMultipleEdgesCD(clazz: Class) {
   *   Class.superclass.name(clazz, "parent2");
   * }
   * </pre></code>
   * 
   * @see Match
   * @see TestMultipleEdgesCD
   * 
   */
  public static class Matcher extends BaseMatcher<TestMultipleEdgesCD.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static TestMultipleEdgesCD.Matcher on(final ViatraQueryEngine engine) {
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
    public static TestMultipleEdgesCD.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_CLAZZ = 0;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(TestMultipleEdgesCD.Matcher.class);

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
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<TestMultipleEdgesCD.Match> getAllMatches(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz) {
      return rawStreamAllMatches(new Object[]{pClazz}).collect(Collectors.toSet());
    }

    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<TestMultipleEdgesCD.Match> streamAllMatches(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz) {
      return rawStreamAllMatches(new Object[]{pClazz});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<TestMultipleEdgesCD.Match> getOneArbitraryMatch(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz) {
      return rawGetOneArbitraryMatch(new Object[]{pClazz});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz) {
      return rawHasMatch(new Object[]{pClazz});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz) {
      return rawCountMatches(new Object[]{pClazz});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz, final Consumer<? super TestMultipleEdgesCD.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pClazz}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public TestMultipleEdgesCD.Match newMatch(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz) {
      return TestMultipleEdgesCD.Match.newMatch(pClazz);
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

    @Override
    protected TestMultipleEdgesCD.Match tupleToMatch(final Tuple t) {
      try {
          return TestMultipleEdgesCD.Match.newMatch((edu.toronto.cs.se.modelepedia.classdiagram.Class) t.get(POSITION_CLAZZ));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected TestMultipleEdgesCD.Match arrayToMatch(final Object[] match) {
      try {
          return TestMultipleEdgesCD.Match.newMatch((edu.toronto.cs.se.modelepedia.classdiagram.Class) match[POSITION_CLAZZ]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected TestMultipleEdgesCD.Match arrayToMatchMutable(final Object[] match) {
      try {
          return TestMultipleEdgesCD.Match.newMutableMatch((edu.toronto.cs.se.modelepedia.classdiagram.Class) match[POSITION_CLAZZ]);
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
    public static IQuerySpecification<TestMultipleEdgesCD.Matcher> querySpecification() {
      return TestMultipleEdgesCD.instance();
    }
  }

  private TestMultipleEdgesCD() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static TestMultipleEdgesCD instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected TestMultipleEdgesCD.Matcher instantiate(final ViatraQueryEngine engine) {
    return TestMultipleEdgesCD.Matcher.on(engine);
  }

  @Override
  public TestMultipleEdgesCD.Matcher instantiate() {
    return TestMultipleEdgesCD.Matcher.create();
  }

  @Override
  public TestMultipleEdgesCD.Match newEmptyMatch() {
    return TestMultipleEdgesCD.Match.newEmptyMatch();
  }

  @Override
  public TestMultipleEdgesCD.Match newMatch(final Object... parameters) {
    return TestMultipleEdgesCD.Match.newMatch((edu.toronto.cs.se.modelepedia.classdiagram.Class) parameters[0]);
  }

  /**
   * Inner class allowing the singleton instance of {@link TestMultipleEdgesCD} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link TestMultipleEdgesCD#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final TestMultipleEdgesCD INSTANCE = new TestMultipleEdgesCD();

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
    private static final TestMultipleEdgesCD.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_clazz = new PParameter("clazz", "edu.toronto.cs.se.modelepedia.classdiagram.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Class")), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_clazz);

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "edu.toronto.cs.se.mmint.productline.viatra.tests.testMultipleEdgesCD";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("clazz");
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
          PVariable var_clazz = body.getOrCreateVariableByName("clazz");
          new TypeConstraint(body, Tuples.flatTupleOf(var_clazz), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Class")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_clazz, parameter_clazz)
          ));
          //   Class.superclass.name(clazz, "parent2")
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new ConstantValue(body, var__virtual_0_, "parent2");
          new TypeConstraint(body, Tuples.flatTupleOf(var_clazz), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Class")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_clazz, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Class", "superclass")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Class")));
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "NamedElement", "name")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EString")));
          new Equality(body, var__virtual_2_, var__virtual_0_);
          bodies.add(body);
      }
      return bodies;
    }
  }
}

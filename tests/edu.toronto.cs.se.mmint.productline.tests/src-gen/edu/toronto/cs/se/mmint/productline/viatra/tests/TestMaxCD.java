/**
 * Generated from platform:/resource/edu.toronto.cs.se.mmint.productline.tests/src/edu/toronto/cs/se/mmint/productline/viatra/tests/orig.vql
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
import org.eclipse.viatra.query.runtime.matchers.aggregators.max;
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
 *         pattern testMaxCD(maxName: java String) {
 *           maxName == max Class.name(_, #name);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class TestMaxCD extends BaseGeneratedEMFQuerySpecification<TestMaxCD.Matcher> {
  /**
   * Pattern-specific match representation of the edu.toronto.cs.se.mmint.productline.viatra.tests.testMaxCD pattern,
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
    private String fMaxName;
    
    private static List<String> parameterNames = makeImmutableList("maxName");
    
    private Match(final String pMaxName) {
      this.fMaxName = pMaxName;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "maxName": return this.fMaxName;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fMaxName;
          default: return null;
      }
    }
    
    public String getMaxName() {
      return this.fMaxName;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("maxName".equals(parameterName) ) {
          this.fMaxName = (String) newValue;
          return true;
      }
      return false;
    }
    
    public void setMaxName(final String pMaxName) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fMaxName = pMaxName;
    }
    
    @Override
    public String patternName() {
      return "edu.toronto.cs.se.mmint.productline.viatra.tests.testMaxCD";
    }
    
    @Override
    public List<String> parameterNames() {
      return TestMaxCD.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fMaxName};
    }
    
    @Override
    public TestMaxCD.Match toImmutable() {
      return isMutable() ? newMatch(fMaxName) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"maxName\"=" + prettyPrintValue(fMaxName));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fMaxName);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof TestMaxCD.Match)) {
          TestMaxCD.Match other = (TestMaxCD.Match) obj;
          return Objects.equals(fMaxName, other.fMaxName);
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
    public TestMaxCD specification() {
      return TestMaxCD.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static TestMaxCD.Match newEmptyMatch() {
      return new Mutable(null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pMaxName the fixed value of pattern parameter maxName, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static TestMaxCD.Match newMutableMatch(final String pMaxName) {
      return new Mutable(pMaxName);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pMaxName the fixed value of pattern parameter maxName, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static TestMaxCD.Match newMatch(final String pMaxName) {
      return new Immutable(pMaxName);
    }
    
    private static final class Mutable extends TestMaxCD.Match {
      Mutable(final String pMaxName) {
        super(pMaxName);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends TestMaxCD.Match {
      Immutable(final String pMaxName) {
        super(pMaxName);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the edu.toronto.cs.se.mmint.productline.viatra.tests.testMaxCD pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern testMaxCD(maxName: java String) {
   *   maxName == max Class.name(_, #name);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see TestMaxCD
   * 
   */
  public static class Matcher extends BaseMatcher<TestMaxCD.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static TestMaxCD.Matcher on(final ViatraQueryEngine engine) {
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
    public static TestMaxCD.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_MAXNAME = 0;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(TestMaxCD.Matcher.class);
    
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
     * @param pMaxName the fixed value of pattern parameter maxName, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<TestMaxCD.Match> getAllMatches(final String pMaxName) {
      return rawStreamAllMatches(new Object[]{pMaxName}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pMaxName the fixed value of pattern parameter maxName, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<TestMaxCD.Match> streamAllMatches(final String pMaxName) {
      return rawStreamAllMatches(new Object[]{pMaxName});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pMaxName the fixed value of pattern parameter maxName, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<TestMaxCD.Match> getOneArbitraryMatch(final String pMaxName) {
      return rawGetOneArbitraryMatch(new Object[]{pMaxName});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pMaxName the fixed value of pattern parameter maxName, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final String pMaxName) {
      return rawHasMatch(new Object[]{pMaxName});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pMaxName the fixed value of pattern parameter maxName, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final String pMaxName) {
      return rawCountMatches(new Object[]{pMaxName});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pMaxName the fixed value of pattern parameter maxName, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final String pMaxName, final Consumer<? super TestMaxCD.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pMaxName}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pMaxName the fixed value of pattern parameter maxName, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public TestMaxCD.Match newMatch(final String pMaxName) {
      return TestMaxCD.Match.newMatch(pMaxName);
    }
    
    /**
     * Retrieve the set of values that occur in matches for maxName.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<String> rawStreamAllValuesOfmaxName(final Object[] parameters) {
      return rawStreamAllValues(POSITION_MAXNAME, parameters).map(String.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for maxName.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfmaxName() {
      return rawStreamAllValuesOfmaxName(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for maxName.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfmaxName() {
      return rawStreamAllValuesOfmaxName(emptyArray());
    }
    
    @Override
    protected TestMaxCD.Match tupleToMatch(final Tuple t) {
      try {
          return TestMaxCD.Match.newMatch((String) t.get(POSITION_MAXNAME));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected TestMaxCD.Match arrayToMatch(final Object[] match) {
      try {
          return TestMaxCD.Match.newMatch((String) match[POSITION_MAXNAME]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected TestMaxCD.Match arrayToMatchMutable(final Object[] match) {
      try {
          return TestMaxCD.Match.newMutableMatch((String) match[POSITION_MAXNAME]);
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
    public static IQuerySpecification<TestMaxCD.Matcher> querySpecification() {
      return TestMaxCD.instance();
    }
  }
  
  private TestMaxCD() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static TestMaxCD instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected TestMaxCD.Matcher instantiate(final ViatraQueryEngine engine) {
    return TestMaxCD.Matcher.on(engine);
  }
  
  @Override
  public TestMaxCD.Matcher instantiate() {
    return TestMaxCD.Matcher.create();
  }
  
  @Override
  public TestMaxCD.Match newEmptyMatch() {
    return TestMaxCD.Match.newEmptyMatch();
  }
  
  @Override
  public TestMaxCD.Match newMatch(final Object... parameters) {
    return TestMaxCD.Match.newMatch((java.lang.String) parameters[0]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link TestMaxCD} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link TestMaxCD#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final TestMaxCD INSTANCE = new TestMaxCD();
    
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
    private static final TestMaxCD.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_maxName = new PParameter("maxName", "java.lang.String", new JavaTransitiveInstancesKey(java.lang.String.class), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_maxName);
    
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
      return "edu.toronto.cs.se.mmint.productline.viatra.tests.testMaxCD";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("maxName");
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
          PVariable var_maxName = body.getOrCreateVariableByName("maxName");
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          PVariable var__name = body.getOrCreateVariableByName("#name");
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_maxName), new JavaTransitiveInstancesKey(java.lang.String.class));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_maxName, parameter_maxName)
          ));
          //   maxName == max Class.name(_, #name)
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new AggregatorConstraint(new max().getAggregatorLogic(String.class), body, Tuples.flatTupleOf(var___0_, var__name), new TestMaxCD.GeneratedPQuery.Embedded_1_Class_name(), var__virtual_0_, 1);
          new Equality(body, var_maxName, var__virtual_0_);
          bodies.add(body);
      }
      return bodies;
    }
  }
}

/**
 * Generated from platform:/resource/edu.toronto.cs.se.mmint.jase20.paper/src/jase20/iso26262.vql
 */
package jase20;

import edu.toronto.cs.se.mmint.jase20.iso26262.hara.OperationalSituation;
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
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
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
 *         pattern a2(situation: OperationalSituation) {
 *           Hazard(hazard);
 *           neg OperationalSituation.events.hazard(situation, hazard);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class A2 extends BaseGeneratedEMFQuerySpecification<A2.Matcher> {
  /**
   * Pattern-specific match representation of the jase20.a2 pattern,
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
    private OperationalSituation fSituation;
    
    private static List<String> parameterNames = makeImmutableList("situation");
    
    private Match(final OperationalSituation pSituation) {
      this.fSituation = pSituation;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "situation": return this.fSituation;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fSituation;
          default: return null;
      }
    }
    
    public OperationalSituation getSituation() {
      return this.fSituation;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("situation".equals(parameterName) ) {
          this.fSituation = (OperationalSituation) newValue;
          return true;
      }
      return false;
    }
    
    public void setSituation(final OperationalSituation pSituation) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fSituation = pSituation;
    }
    
    @Override
    public String patternName() {
      return "jase20.a2";
    }
    
    @Override
    public List<String> parameterNames() {
      return A2.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fSituation};
    }
    
    @Override
    public A2.Match toImmutable() {
      return isMutable() ? newMatch(fSituation) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"situation\"=" + prettyPrintValue(fSituation));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fSituation);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof A2.Match)) {
          A2.Match other = (A2.Match) obj;
          return Objects.equals(fSituation, other.fSituation);
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
    public A2 specification() {
      return A2.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static A2.Match newEmptyMatch() {
      return new Mutable(null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pSituation the fixed value of pattern parameter situation, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static A2.Match newMutableMatch(final OperationalSituation pSituation) {
      return new Mutable(pSituation);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pSituation the fixed value of pattern parameter situation, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static A2.Match newMatch(final OperationalSituation pSituation) {
      return new Immutable(pSituation);
    }
    
    private static final class Mutable extends A2.Match {
      Mutable(final OperationalSituation pSituation) {
        super(pSituation);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends A2.Match {
      Immutable(final OperationalSituation pSituation) {
        super(pSituation);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the jase20.a2 pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern a2(situation: OperationalSituation) {
   *   Hazard(hazard);
   *   neg OperationalSituation.events.hazard(situation, hazard);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see A2
   * 
   */
  public static class Matcher extends BaseMatcher<A2.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static A2.Matcher on(final ViatraQueryEngine engine) {
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
    public static A2.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_SITUATION = 0;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(A2.Matcher.class);
    
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
     * @param pSituation the fixed value of pattern parameter situation, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<A2.Match> getAllMatches(final OperationalSituation pSituation) {
      return rawStreamAllMatches(new Object[]{pSituation}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pSituation the fixed value of pattern parameter situation, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<A2.Match> streamAllMatches(final OperationalSituation pSituation) {
      return rawStreamAllMatches(new Object[]{pSituation});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pSituation the fixed value of pattern parameter situation, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<A2.Match> getOneArbitraryMatch(final OperationalSituation pSituation) {
      return rawGetOneArbitraryMatch(new Object[]{pSituation});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pSituation the fixed value of pattern parameter situation, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final OperationalSituation pSituation) {
      return rawHasMatch(new Object[]{pSituation});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pSituation the fixed value of pattern parameter situation, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final OperationalSituation pSituation) {
      return rawCountMatches(new Object[]{pSituation});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pSituation the fixed value of pattern parameter situation, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final OperationalSituation pSituation, final Consumer<? super A2.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pSituation}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pSituation the fixed value of pattern parameter situation, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public A2.Match newMatch(final OperationalSituation pSituation) {
      return A2.Match.newMatch(pSituation);
    }
    
    /**
     * Retrieve the set of values that occur in matches for situation.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<OperationalSituation> rawStreamAllValuesOfsituation(final Object[] parameters) {
      return rawStreamAllValues(POSITION_SITUATION, parameters).map(OperationalSituation.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for situation.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<OperationalSituation> getAllValuesOfsituation() {
      return rawStreamAllValuesOfsituation(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for situation.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<OperationalSituation> streamAllValuesOfsituation() {
      return rawStreamAllValuesOfsituation(emptyArray());
    }
    
    @Override
    protected A2.Match tupleToMatch(final Tuple t) {
      try {
          return A2.Match.newMatch((OperationalSituation) t.get(POSITION_SITUATION));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected A2.Match arrayToMatch(final Object[] match) {
      try {
          return A2.Match.newMatch((OperationalSituation) match[POSITION_SITUATION]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected A2.Match arrayToMatchMutable(final Object[] match) {
      try {
          return A2.Match.newMutableMatch((OperationalSituation) match[POSITION_SITUATION]);
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
    public static IQuerySpecification<A2.Matcher> querySpecification() {
      return A2.instance();
    }
  }
  
  private A2() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static A2 instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected A2.Matcher instantiate(final ViatraQueryEngine engine) {
    return A2.Matcher.on(engine);
  }
  
  @Override
  public A2.Matcher instantiate() {
    return A2.Matcher.create();
  }
  
  @Override
  public A2.Match newEmptyMatch() {
    return A2.Match.newEmptyMatch();
  }
  
  @Override
  public A2.Match newMatch(final Object... parameters) {
    return A2.Match.newMatch((edu.toronto.cs.se.mmint.jase20.iso26262.hara.OperationalSituation) parameters[0]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link A2} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link A2#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final A2 INSTANCE = new A2();
    
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
    private static final A2.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_situation = new PParameter("situation", "edu.toronto.cs.se.mmint.jase20.iso26262.hara.OperationalSituation", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("edu.toronto.cs.se.mmint.jase20.iso26262.hara", "OperationalSituation")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_situation);
    
    private class Embedded_1_OperationalSituation_events_hazard extends BaseGeneratedEMFPQuery {
      private final PParameter parameter_p0 = new PParameter("p0", "edu.toronto.cs.se.mmint.jase20.iso26262.hara.OperationalSituation", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("edu.toronto.cs.se.mmint.jase20.iso26262.hara", "OperationalSituation")), PParameterDirection.INOUT);
      
      private final PParameter parameter_p1 = new PParameter("p1", "edu.toronto.cs.se.mmint.jase20.iso26262.hara.Hazard", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("edu.toronto.cs.se.mmint.jase20.iso26262.hara", "Hazard")), PParameterDirection.INOUT);
      
      private final List<PParameter> embeddedParameters = Arrays.asList(parameter_p0, parameter_p1);
      
      public Embedded_1_OperationalSituation_events_hazard() {
        super(PVisibility.EMBEDDED);
      }
      
      @Override
      public String getFullyQualifiedName() {
        return GeneratedPQuery.this.getFullyQualifiedName() + "$Embedded_1_OperationalSituation_events_hazard";
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
        //  OperationalSituation.events.hazard(situation, hazard)
        new TypeConstraint(body, Tuples.flatTupleOf(var_p0), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("edu.toronto.cs.se.mmint.jase20.iso26262.hara", "OperationalSituation")));
        PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
        new TypeConstraint(body, Tuples.flatTupleOf(var_p0, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("edu.toronto.cs.se.mmint.jase20.iso26262.hara", "OperationalSituation", "events")));
        new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("edu.toronto.cs.se.mmint.jase20.iso26262.hara", "HazardousEvent")));
        PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
        new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("edu.toronto.cs.se.mmint.jase20.iso26262.hara", "HazardousEvent", "hazard")));
        new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("edu.toronto.cs.se.mmint.jase20.iso26262.hara", "Hazard")));
        new Equality(body, var__virtual_1_, var_p1);
        return Collections.singleton(body);
      }
    }
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "jase20.a2";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("situation");
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
          PVariable var_situation = body.getOrCreateVariableByName("situation");
          PVariable var_hazard = body.getOrCreateVariableByName("hazard");
          new TypeConstraint(body, Tuples.flatTupleOf(var_situation), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("edu.toronto.cs.se.mmint.jase20.iso26262.hara", "OperationalSituation")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_situation, parameter_situation)
          ));
          //   Hazard(hazard)
          new TypeConstraint(body, Tuples.flatTupleOf(var_hazard), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("edu.toronto.cs.se.mmint.jase20.iso26262.hara", "Hazard")));
          //   neg OperationalSituation.events.hazard(situation, hazard)
          new NegativePatternCall(body, Tuples.flatTupleOf(var_situation, var_hazard), new A2.GeneratedPQuery.Embedded_1_OperationalSituation_events_hazard());
          bodies.add(body);
      }
      return bodies;
    }
  }
}

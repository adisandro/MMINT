/**
 * Generated from platform:/resource/edu.toronto.cs.se.mmint.jase20.paper/src/jase20/iso26262.vql
 */
package jase20;

import edu.toronto.cs.se.mmint.jase20.iso26262.hara.HazardousEvent;
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
import org.eclipse.viatra.query.runtime.matchers.context.common.JavaTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
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
 *         pattern e_asil(event: HazardousEvent, asil: java String) {
 *           HazardousEvent.ASIL(event, asil);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class E_asil extends BaseGeneratedEMFQuerySpecification<E_asil.Matcher> {
  /**
   * Pattern-specific match representation of the jase20.e_asil pattern,
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
    private HazardousEvent fEvent;
    
    private String fAsil;
    
    private static List<String> parameterNames = makeImmutableList("event", "asil");
    
    private Match(final HazardousEvent pEvent, final String pAsil) {
      this.fEvent = pEvent;
      this.fAsil = pAsil;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "event": return this.fEvent;
          case "asil": return this.fAsil;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fEvent;
          case 1: return this.fAsil;
          default: return null;
      }
    }
    
    public HazardousEvent getEvent() {
      return this.fEvent;
    }
    
    public String getAsil() {
      return this.fAsil;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("event".equals(parameterName) ) {
          this.fEvent = (HazardousEvent) newValue;
          return true;
      }
      if ("asil".equals(parameterName) ) {
          this.fAsil = (String) newValue;
          return true;
      }
      return false;
    }
    
    public void setEvent(final HazardousEvent pEvent) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fEvent = pEvent;
    }
    
    public void setAsil(final String pAsil) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fAsil = pAsil;
    }
    
    @Override
    public String patternName() {
      return "jase20.e_asil";
    }
    
    @Override
    public List<String> parameterNames() {
      return E_asil.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fEvent, fAsil};
    }
    
    @Override
    public E_asil.Match toImmutable() {
      return isMutable() ? newMatch(fEvent, fAsil) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"event\"=" + prettyPrintValue(fEvent) + ", ");
      result.append("\"asil\"=" + prettyPrintValue(fAsil));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fEvent, fAsil);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof E_asil.Match)) {
          E_asil.Match other = (E_asil.Match) obj;
          return Objects.equals(fEvent, other.fEvent) && Objects.equals(fAsil, other.fAsil);
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
    public E_asil specification() {
      return E_asil.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static E_asil.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pEvent the fixed value of pattern parameter event, or null if not bound.
     * @param pAsil the fixed value of pattern parameter asil, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static E_asil.Match newMutableMatch(final HazardousEvent pEvent, final String pAsil) {
      return new Mutable(pEvent, pAsil);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pEvent the fixed value of pattern parameter event, or null if not bound.
     * @param pAsil the fixed value of pattern parameter asil, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static E_asil.Match newMatch(final HazardousEvent pEvent, final String pAsil) {
      return new Immutable(pEvent, pAsil);
    }
    
    private static final class Mutable extends E_asil.Match {
      Mutable(final HazardousEvent pEvent, final String pAsil) {
        super(pEvent, pAsil);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends E_asil.Match {
      Immutable(final HazardousEvent pEvent, final String pAsil) {
        super(pEvent, pAsil);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the jase20.e_asil pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern e_asil(event: HazardousEvent, asil: java String) {
   *   HazardousEvent.ASIL(event, asil);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see E_asil
   * 
   */
  public static class Matcher extends BaseMatcher<E_asil.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static E_asil.Matcher on(final ViatraQueryEngine engine) {
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
    public static E_asil.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_EVENT = 0;
    
    private static final int POSITION_ASIL = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(E_asil.Matcher.class);
    
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
     * @param pEvent the fixed value of pattern parameter event, or null if not bound.
     * @param pAsil the fixed value of pattern parameter asil, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<E_asil.Match> getAllMatches(final HazardousEvent pEvent, final String pAsil) {
      return rawStreamAllMatches(new Object[]{pEvent, pAsil}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pEvent the fixed value of pattern parameter event, or null if not bound.
     * @param pAsil the fixed value of pattern parameter asil, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<E_asil.Match> streamAllMatches(final HazardousEvent pEvent, final String pAsil) {
      return rawStreamAllMatches(new Object[]{pEvent, pAsil});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pEvent the fixed value of pattern parameter event, or null if not bound.
     * @param pAsil the fixed value of pattern parameter asil, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<E_asil.Match> getOneArbitraryMatch(final HazardousEvent pEvent, final String pAsil) {
      return rawGetOneArbitraryMatch(new Object[]{pEvent, pAsil});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pEvent the fixed value of pattern parameter event, or null if not bound.
     * @param pAsil the fixed value of pattern parameter asil, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final HazardousEvent pEvent, final String pAsil) {
      return rawHasMatch(new Object[]{pEvent, pAsil});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pEvent the fixed value of pattern parameter event, or null if not bound.
     * @param pAsil the fixed value of pattern parameter asil, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final HazardousEvent pEvent, final String pAsil) {
      return rawCountMatches(new Object[]{pEvent, pAsil});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pEvent the fixed value of pattern parameter event, or null if not bound.
     * @param pAsil the fixed value of pattern parameter asil, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final HazardousEvent pEvent, final String pAsil, final Consumer<? super E_asil.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pEvent, pAsil}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pEvent the fixed value of pattern parameter event, or null if not bound.
     * @param pAsil the fixed value of pattern parameter asil, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public E_asil.Match newMatch(final HazardousEvent pEvent, final String pAsil) {
      return E_asil.Match.newMatch(pEvent, pAsil);
    }
    
    /**
     * Retrieve the set of values that occur in matches for event.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<HazardousEvent> rawStreamAllValuesOfevent(final Object[] parameters) {
      return rawStreamAllValues(POSITION_EVENT, parameters).map(HazardousEvent.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for event.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<HazardousEvent> getAllValuesOfevent() {
      return rawStreamAllValuesOfevent(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for event.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<HazardousEvent> streamAllValuesOfevent() {
      return rawStreamAllValuesOfevent(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for event.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<HazardousEvent> streamAllValuesOfevent(final E_asil.Match partialMatch) {
      return rawStreamAllValuesOfevent(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for event.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<HazardousEvent> streamAllValuesOfevent(final String pAsil) {
      return rawStreamAllValuesOfevent(new Object[]{null, pAsil});
    }
    
    /**
     * Retrieve the set of values that occur in matches for event.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<HazardousEvent> getAllValuesOfevent(final E_asil.Match partialMatch) {
      return rawStreamAllValuesOfevent(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for event.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<HazardousEvent> getAllValuesOfevent(final String pAsil) {
      return rawStreamAllValuesOfevent(new Object[]{null, pAsil}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for asil.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<String> rawStreamAllValuesOfasil(final Object[] parameters) {
      return rawStreamAllValues(POSITION_ASIL, parameters).map(String.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for asil.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfasil() {
      return rawStreamAllValuesOfasil(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for asil.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfasil() {
      return rawStreamAllValuesOfasil(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for asil.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfasil(final E_asil.Match partialMatch) {
      return rawStreamAllValuesOfasil(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for asil.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfasil(final HazardousEvent pEvent) {
      return rawStreamAllValuesOfasil(new Object[]{pEvent, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for asil.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfasil(final E_asil.Match partialMatch) {
      return rawStreamAllValuesOfasil(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for asil.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfasil(final HazardousEvent pEvent) {
      return rawStreamAllValuesOfasil(new Object[]{pEvent, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected E_asil.Match tupleToMatch(final Tuple t) {
      try {
          return E_asil.Match.newMatch((HazardousEvent) t.get(POSITION_EVENT), (String) t.get(POSITION_ASIL));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected E_asil.Match arrayToMatch(final Object[] match) {
      try {
          return E_asil.Match.newMatch((HazardousEvent) match[POSITION_EVENT], (String) match[POSITION_ASIL]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected E_asil.Match arrayToMatchMutable(final Object[] match) {
      try {
          return E_asil.Match.newMutableMatch((HazardousEvent) match[POSITION_EVENT], (String) match[POSITION_ASIL]);
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
    public static IQuerySpecification<E_asil.Matcher> querySpecification() {
      return E_asil.instance();
    }
  }
  
  private E_asil() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static E_asil instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected E_asil.Matcher instantiate(final ViatraQueryEngine engine) {
    return E_asil.Matcher.on(engine);
  }
  
  @Override
  public E_asil.Matcher instantiate() {
    return E_asil.Matcher.create();
  }
  
  @Override
  public E_asil.Match newEmptyMatch() {
    return E_asil.Match.newEmptyMatch();
  }
  
  @Override
  public E_asil.Match newMatch(final Object... parameters) {
    return E_asil.Match.newMatch((edu.toronto.cs.se.mmint.jase20.iso26262.hara.HazardousEvent) parameters[0], (java.lang.String) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link E_asil} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link E_asil#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final E_asil INSTANCE = new E_asil();
    
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
    private static final E_asil.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_event = new PParameter("event", "edu.toronto.cs.se.mmint.jase20.iso26262.hara.HazardousEvent", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("edu.toronto.cs.se.mmint.jase20.iso26262.hara", "HazardousEvent")), PParameterDirection.INOUT);
    
    private final PParameter parameter_asil = new PParameter("asil", "java.lang.String", new JavaTransitiveInstancesKey(java.lang.String.class), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_event, parameter_asil);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "jase20.e_asil";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("event","asil");
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
          PVariable var_event = body.getOrCreateVariableByName("event");
          PVariable var_asil = body.getOrCreateVariableByName("asil");
          new TypeConstraint(body, Tuples.flatTupleOf(var_event), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("edu.toronto.cs.se.mmint.jase20.iso26262.hara", "HazardousEvent")));
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_asil), new JavaTransitiveInstancesKey(java.lang.String.class));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_event, parameter_event),
             new ExportedParameter(body, var_asil, parameter_asil)
          ));
          //   HazardousEvent.ASIL(event, asil)
          new TypeConstraint(body, Tuples.flatTupleOf(var_event), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("edu.toronto.cs.se.mmint.jase20.iso26262.hara", "HazardousEvent")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_event, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("edu.toronto.cs.se.mmint.jase20.iso26262.hara", "HazardousEvent", "ASIL")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EString")));
          new Equality(body, var__virtual_0_, var_asil);
          bodies.add(body);
      }
      return bodies;
    }
  }
}

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
 *         pattern c_rulesASILC(event: HazardousEvent) {
 *           HazardousEvent.severity(event, "S2");
 *           HazardousEvent.exposure(event, "E4");
 *           HazardousEvent.controllability(event, "C3");
 *         } or {
 *           HazardousEvent.severity(event, "S3");
 *           HazardousEvent.exposure(event, "E4");
 *           HazardousEvent.controllability(event, "C2");
 *         } or {
 *           HazardousEvent.severity(event, "S3");
 *           HazardousEvent.exposure(event, "E3");
 *           HazardousEvent.controllability(event, "C3");
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class C_rulesASILC extends BaseGeneratedEMFQuerySpecification<C_rulesASILC.Matcher> {
  /**
   * Pattern-specific match representation of the jase20.c_rulesASILC pattern,
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
    
    private static List<String> parameterNames = makeImmutableList("event");
    
    private Match(final HazardousEvent pEvent) {
      this.fEvent = pEvent;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "event": return this.fEvent;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fEvent;
          default: return null;
      }
    }
    
    public HazardousEvent getEvent() {
      return this.fEvent;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("event".equals(parameterName) ) {
          this.fEvent = (HazardousEvent) newValue;
          return true;
      }
      return false;
    }
    
    public void setEvent(final HazardousEvent pEvent) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fEvent = pEvent;
    }
    
    @Override
    public String patternName() {
      return "jase20.c_rulesASILC";
    }
    
    @Override
    public List<String> parameterNames() {
      return C_rulesASILC.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fEvent};
    }
    
    @Override
    public C_rulesASILC.Match toImmutable() {
      return isMutable() ? newMatch(fEvent) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"event\"=" + prettyPrintValue(fEvent));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fEvent);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof C_rulesASILC.Match)) {
          C_rulesASILC.Match other = (C_rulesASILC.Match) obj;
          return Objects.equals(fEvent, other.fEvent);
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
    public C_rulesASILC specification() {
      return C_rulesASILC.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static C_rulesASILC.Match newEmptyMatch() {
      return new Mutable(null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pEvent the fixed value of pattern parameter event, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static C_rulesASILC.Match newMutableMatch(final HazardousEvent pEvent) {
      return new Mutable(pEvent);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pEvent the fixed value of pattern parameter event, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static C_rulesASILC.Match newMatch(final HazardousEvent pEvent) {
      return new Immutable(pEvent);
    }
    
    private static final class Mutable extends C_rulesASILC.Match {
      Mutable(final HazardousEvent pEvent) {
        super(pEvent);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends C_rulesASILC.Match {
      Immutable(final HazardousEvent pEvent) {
        super(pEvent);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the jase20.c_rulesASILC pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern c_rulesASILC(event: HazardousEvent) {
   *   HazardousEvent.severity(event, "S2");
   *   HazardousEvent.exposure(event, "E4");
   *   HazardousEvent.controllability(event, "C3");
   * } or {
   *   HazardousEvent.severity(event, "S3");
   *   HazardousEvent.exposure(event, "E4");
   *   HazardousEvent.controllability(event, "C2");
   * } or {
   *   HazardousEvent.severity(event, "S3");
   *   HazardousEvent.exposure(event, "E3");
   *   HazardousEvent.controllability(event, "C3");
   * }
   * </pre></code>
   * 
   * @see Match
   * @see C_rulesASILC
   * 
   */
  public static class Matcher extends BaseMatcher<C_rulesASILC.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static C_rulesASILC.Matcher on(final ViatraQueryEngine engine) {
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
    public static C_rulesASILC.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_EVENT = 0;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(C_rulesASILC.Matcher.class);
    
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
     * @return matches represented as a Match object.
     * 
     */
    public Collection<C_rulesASILC.Match> getAllMatches(final HazardousEvent pEvent) {
      return rawStreamAllMatches(new Object[]{pEvent}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pEvent the fixed value of pattern parameter event, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<C_rulesASILC.Match> streamAllMatches(final HazardousEvent pEvent) {
      return rawStreamAllMatches(new Object[]{pEvent});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pEvent the fixed value of pattern parameter event, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<C_rulesASILC.Match> getOneArbitraryMatch(final HazardousEvent pEvent) {
      return rawGetOneArbitraryMatch(new Object[]{pEvent});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pEvent the fixed value of pattern parameter event, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final HazardousEvent pEvent) {
      return rawHasMatch(new Object[]{pEvent});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pEvent the fixed value of pattern parameter event, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final HazardousEvent pEvent) {
      return rawCountMatches(new Object[]{pEvent});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pEvent the fixed value of pattern parameter event, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final HazardousEvent pEvent, final Consumer<? super C_rulesASILC.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pEvent}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pEvent the fixed value of pattern parameter event, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public C_rulesASILC.Match newMatch(final HazardousEvent pEvent) {
      return C_rulesASILC.Match.newMatch(pEvent);
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
    
    @Override
    protected C_rulesASILC.Match tupleToMatch(final Tuple t) {
      try {
          return C_rulesASILC.Match.newMatch((HazardousEvent) t.get(POSITION_EVENT));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected C_rulesASILC.Match arrayToMatch(final Object[] match) {
      try {
          return C_rulesASILC.Match.newMatch((HazardousEvent) match[POSITION_EVENT]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected C_rulesASILC.Match arrayToMatchMutable(final Object[] match) {
      try {
          return C_rulesASILC.Match.newMutableMatch((HazardousEvent) match[POSITION_EVENT]);
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
    public static IQuerySpecification<C_rulesASILC.Matcher> querySpecification() {
      return C_rulesASILC.instance();
    }
  }
  
  private C_rulesASILC() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static C_rulesASILC instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected C_rulesASILC.Matcher instantiate(final ViatraQueryEngine engine) {
    return C_rulesASILC.Matcher.on(engine);
  }
  
  @Override
  public C_rulesASILC.Matcher instantiate() {
    return C_rulesASILC.Matcher.create();
  }
  
  @Override
  public C_rulesASILC.Match newEmptyMatch() {
    return C_rulesASILC.Match.newEmptyMatch();
  }
  
  @Override
  public C_rulesASILC.Match newMatch(final Object... parameters) {
    return C_rulesASILC.Match.newMatch((edu.toronto.cs.se.mmint.jase20.iso26262.hara.HazardousEvent) parameters[0]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link C_rulesASILC} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link C_rulesASILC#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final C_rulesASILC INSTANCE = new C_rulesASILC();
    
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
    private static final C_rulesASILC.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_event = new PParameter("event", "edu.toronto.cs.se.mmint.jase20.iso26262.hara.HazardousEvent", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("edu.toronto.cs.se.mmint.jase20.iso26262.hara", "HazardousEvent")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_event);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "jase20.c_rulesASILC";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("event");
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
          new TypeConstraint(body, Tuples.flatTupleOf(var_event), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("edu.toronto.cs.se.mmint.jase20.iso26262.hara", "HazardousEvent")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_event, parameter_event)
          ));
          //   HazardousEvent.severity(event, "S2")
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new ConstantValue(body, var__virtual_0_, "S2");
          new TypeConstraint(body, Tuples.flatTupleOf(var_event), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("edu.toronto.cs.se.mmint.jase20.iso26262.hara", "HazardousEvent")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_event, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("edu.toronto.cs.se.mmint.jase20.iso26262.hara", "HazardousEvent", "severity")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EString")));
          new Equality(body, var__virtual_1_, var__virtual_0_);
          //   HazardousEvent.exposure(event, "E4")
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new ConstantValue(body, var__virtual_2_, "E4");
          new TypeConstraint(body, Tuples.flatTupleOf(var_event), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("edu.toronto.cs.se.mmint.jase20.iso26262.hara", "HazardousEvent")));
          PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_event, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("edu.toronto.cs.se.mmint.jase20.iso26262.hara", "HazardousEvent", "exposure")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_3_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EString")));
          new Equality(body, var__virtual_3_, var__virtual_2_);
          //   HazardousEvent.controllability(event, "C3")
          PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
          new ConstantValue(body, var__virtual_4_, "C3");
          new TypeConstraint(body, Tuples.flatTupleOf(var_event), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("edu.toronto.cs.se.mmint.jase20.iso26262.hara", "HazardousEvent")));
          PVariable var__virtual_5_ = body.getOrCreateVariableByName(".virtual{5}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_event, var__virtual_5_), new EStructuralFeatureInstancesKey(getFeatureLiteral("edu.toronto.cs.se.mmint.jase20.iso26262.hara", "HazardousEvent", "controllability")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_5_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EString")));
          new Equality(body, var__virtual_5_, var__virtual_4_);
          bodies.add(body);
      }
      {
          PBody body = new PBody(this);
          PVariable var_event = body.getOrCreateVariableByName("event");
          new TypeConstraint(body, Tuples.flatTupleOf(var_event), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("edu.toronto.cs.se.mmint.jase20.iso26262.hara", "HazardousEvent")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_event, parameter_event)
          ));
          //   HazardousEvent.severity(event, "S3")
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new ConstantValue(body, var__virtual_0_, "S3");
          new TypeConstraint(body, Tuples.flatTupleOf(var_event), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("edu.toronto.cs.se.mmint.jase20.iso26262.hara", "HazardousEvent")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_event, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("edu.toronto.cs.se.mmint.jase20.iso26262.hara", "HazardousEvent", "severity")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EString")));
          new Equality(body, var__virtual_1_, var__virtual_0_);
          //   HazardousEvent.exposure(event, "E4")
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new ConstantValue(body, var__virtual_2_, "E4");
          new TypeConstraint(body, Tuples.flatTupleOf(var_event), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("edu.toronto.cs.se.mmint.jase20.iso26262.hara", "HazardousEvent")));
          PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_event, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("edu.toronto.cs.se.mmint.jase20.iso26262.hara", "HazardousEvent", "exposure")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_3_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EString")));
          new Equality(body, var__virtual_3_, var__virtual_2_);
          //   HazardousEvent.controllability(event, "C2")
          PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
          new ConstantValue(body, var__virtual_4_, "C2");
          new TypeConstraint(body, Tuples.flatTupleOf(var_event), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("edu.toronto.cs.se.mmint.jase20.iso26262.hara", "HazardousEvent")));
          PVariable var__virtual_5_ = body.getOrCreateVariableByName(".virtual{5}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_event, var__virtual_5_), new EStructuralFeatureInstancesKey(getFeatureLiteral("edu.toronto.cs.se.mmint.jase20.iso26262.hara", "HazardousEvent", "controllability")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_5_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EString")));
          new Equality(body, var__virtual_5_, var__virtual_4_);
          bodies.add(body);
      }
      {
          PBody body = new PBody(this);
          PVariable var_event = body.getOrCreateVariableByName("event");
          new TypeConstraint(body, Tuples.flatTupleOf(var_event), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("edu.toronto.cs.se.mmint.jase20.iso26262.hara", "HazardousEvent")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_event, parameter_event)
          ));
          //   HazardousEvent.severity(event, "S3")
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new ConstantValue(body, var__virtual_0_, "S3");
          new TypeConstraint(body, Tuples.flatTupleOf(var_event), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("edu.toronto.cs.se.mmint.jase20.iso26262.hara", "HazardousEvent")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_event, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("edu.toronto.cs.se.mmint.jase20.iso26262.hara", "HazardousEvent", "severity")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EString")));
          new Equality(body, var__virtual_1_, var__virtual_0_);
          //   HazardousEvent.exposure(event, "E3")
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new ConstantValue(body, var__virtual_2_, "E3");
          new TypeConstraint(body, Tuples.flatTupleOf(var_event), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("edu.toronto.cs.se.mmint.jase20.iso26262.hara", "HazardousEvent")));
          PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_event, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("edu.toronto.cs.se.mmint.jase20.iso26262.hara", "HazardousEvent", "exposure")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_3_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EString")));
          new Equality(body, var__virtual_3_, var__virtual_2_);
          //   HazardousEvent.controllability(event, "C3")
          PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
          new ConstantValue(body, var__virtual_4_, "C3");
          new TypeConstraint(body, Tuples.flatTupleOf(var_event), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("edu.toronto.cs.se.mmint.jase20.iso26262.hara", "HazardousEvent")));
          PVariable var__virtual_5_ = body.getOrCreateVariableByName(".virtual{5}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_event, var__virtual_5_), new EStructuralFeatureInstancesKey(getFeatureLiteral("edu.toronto.cs.se.mmint.jase20.iso26262.hara", "HazardousEvent", "controllability")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_5_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EString")));
          new Equality(body, var__virtual_5_, var__virtual_4_);
          bodies.add(body);
      }
      return bodies;
    }
  }
}

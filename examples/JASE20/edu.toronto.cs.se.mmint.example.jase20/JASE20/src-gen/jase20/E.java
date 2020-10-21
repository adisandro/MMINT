/**
 * Generated from platform:/resource/JASE20/src/jase20/iso26262.vql
 */
package jase20;

import edu.toronto.cs.se.mmint.example.jase20.iso26262.gsn.SafetyGoal;
import jase20.E_eventASIL;
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
import org.eclipse.viatra.query.runtime.matchers.aggregators.max;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.AggregatorConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Inequality;
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
 *         pattern e(goal: SafetyGoal) {
 *           SafetyGoal.ASIL(goal, goalASIL);
 *           maxASIL == max find e_eventASIL(goal, _event, #asil);
 *           maxASIL != goalASIL;
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class E extends BaseGeneratedEMFQuerySpecification<E.Matcher> {
  /**
   * Pattern-specific match representation of the jase20.e pattern,
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
    private SafetyGoal fGoal;
    
    private static List<String> parameterNames = makeImmutableList("goal");
    
    private Match(final SafetyGoal pGoal) {
      this.fGoal = pGoal;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "goal": return this.fGoal;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fGoal;
          default: return null;
      }
    }
    
    public SafetyGoal getGoal() {
      return this.fGoal;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("goal".equals(parameterName) ) {
          this.fGoal = (SafetyGoal) newValue;
          return true;
      }
      return false;
    }
    
    public void setGoal(final SafetyGoal pGoal) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fGoal = pGoal;
    }
    
    @Override
    public String patternName() {
      return "jase20.e";
    }
    
    @Override
    public List<String> parameterNames() {
      return E.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fGoal};
    }
    
    @Override
    public E.Match toImmutable() {
      return isMutable() ? newMatch(fGoal) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"goal\"=" + prettyPrintValue(fGoal));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fGoal);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof E.Match)) {
          E.Match other = (E.Match) obj;
          return Objects.equals(fGoal, other.fGoal);
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
    public E specification() {
      return E.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static E.Match newEmptyMatch() {
      return new Mutable(null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pGoal the fixed value of pattern parameter goal, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static E.Match newMutableMatch(final SafetyGoal pGoal) {
      return new Mutable(pGoal);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pGoal the fixed value of pattern parameter goal, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static E.Match newMatch(final SafetyGoal pGoal) {
      return new Immutable(pGoal);
    }
    
    private static final class Mutable extends E.Match {
      Mutable(final SafetyGoal pGoal) {
        super(pGoal);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends E.Match {
      Immutable(final SafetyGoal pGoal) {
        super(pGoal);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the jase20.e pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern e(goal: SafetyGoal) {
   *   SafetyGoal.ASIL(goal, goalASIL);
   *   maxASIL == max find e_eventASIL(goal, _event, #asil);
   *   maxASIL != goalASIL;
   * }
   * </pre></code>
   * 
   * @see Match
   * @see E
   * 
   */
  public static class Matcher extends BaseMatcher<E.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static E.Matcher on(final ViatraQueryEngine engine) {
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
    public static E.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_GOAL = 0;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(E.Matcher.class);
    
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
     * @return matches represented as a Match object.
     * 
     */
    public Collection<E.Match> getAllMatches(final SafetyGoal pGoal) {
      return rawStreamAllMatches(new Object[]{pGoal}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pGoal the fixed value of pattern parameter goal, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<E.Match> streamAllMatches(final SafetyGoal pGoal) {
      return rawStreamAllMatches(new Object[]{pGoal});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pGoal the fixed value of pattern parameter goal, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<E.Match> getOneArbitraryMatch(final SafetyGoal pGoal) {
      return rawGetOneArbitraryMatch(new Object[]{pGoal});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pGoal the fixed value of pattern parameter goal, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final SafetyGoal pGoal) {
      return rawHasMatch(new Object[]{pGoal});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pGoal the fixed value of pattern parameter goal, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final SafetyGoal pGoal) {
      return rawCountMatches(new Object[]{pGoal});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pGoal the fixed value of pattern parameter goal, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final SafetyGoal pGoal, final Consumer<? super E.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pGoal}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pGoal the fixed value of pattern parameter goal, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public E.Match newMatch(final SafetyGoal pGoal) {
      return E.Match.newMatch(pGoal);
    }
    
    /**
     * Retrieve the set of values that occur in matches for goal.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<SafetyGoal> rawStreamAllValuesOfgoal(final Object[] parameters) {
      return rawStreamAllValues(POSITION_GOAL, parameters).map(SafetyGoal.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for goal.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<SafetyGoal> getAllValuesOfgoal() {
      return rawStreamAllValuesOfgoal(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for goal.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<SafetyGoal> streamAllValuesOfgoal() {
      return rawStreamAllValuesOfgoal(emptyArray());
    }
    
    @Override
    protected E.Match tupleToMatch(final Tuple t) {
      try {
          return E.Match.newMatch((SafetyGoal) t.get(POSITION_GOAL));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected E.Match arrayToMatch(final Object[] match) {
      try {
          return E.Match.newMatch((SafetyGoal) match[POSITION_GOAL]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected E.Match arrayToMatchMutable(final Object[] match) {
      try {
          return E.Match.newMutableMatch((SafetyGoal) match[POSITION_GOAL]);
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
    public static IQuerySpecification<E.Matcher> querySpecification() {
      return E.instance();
    }
  }
  
  private E() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static E instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected E.Matcher instantiate(final ViatraQueryEngine engine) {
    return E.Matcher.on(engine);
  }
  
  @Override
  public E.Matcher instantiate() {
    return E.Matcher.create();
  }
  
  @Override
  public E.Match newEmptyMatch() {
    return E.Match.newEmptyMatch();
  }
  
  @Override
  public E.Match newMatch(final Object... parameters) {
    return E.Match.newMatch((edu.toronto.cs.se.mmint.example.jase20.iso26262.gsn.SafetyGoal) parameters[0]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link E} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link E#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final E INSTANCE = new E();
    
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
    private static final E.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_goal = new PParameter("goal", "edu.toronto.cs.se.mmint.example.jase20.iso26262.gsn.SafetyGoal", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("edu.toronto.cs.se.mmint.example.jase20.iso26262.gsn", "SafetyGoal")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_goal);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "jase20.e";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("goal");
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
          PVariable var_goalASIL = body.getOrCreateVariableByName("goalASIL");
          PVariable var_maxASIL = body.getOrCreateVariableByName("maxASIL");
          PVariable var__event = body.getOrCreateVariableByName("_event");
          PVariable var__asil = body.getOrCreateVariableByName("#asil");
          new TypeConstraint(body, Tuples.flatTupleOf(var_goal), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("edu.toronto.cs.se.mmint.example.jase20.iso26262.gsn", "SafetyGoal")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_goal, parameter_goal)
          ));
          //   SafetyGoal.ASIL(goal, goalASIL)
          new TypeConstraint(body, Tuples.flatTupleOf(var_goal), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("edu.toronto.cs.se.mmint.example.jase20.iso26262.gsn", "SafetyGoal")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_goal, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("edu.toronto.cs.se.mmint.example.jase20.iso26262.gsn", "SafetyGoal", "ASIL")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EString")));
          new Equality(body, var__virtual_0_, var_goalASIL);
          //   maxASIL == max find e_eventASIL(goal, _event, #asil)
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new AggregatorConstraint(new max().getAggregatorLogic(String.class), body, Tuples.flatTupleOf(var_goal, var__event, var__asil), E_eventASIL.instance().getInternalQueryRepresentation(), var__virtual_1_, 2);
          new Equality(body, var_maxASIL, var__virtual_1_);
          //   maxASIL != goalASIL
          new Inequality(body, var_maxASIL, var_goalASIL);
          bodies.add(body);
      }
      return bodies;
    }
  }
}

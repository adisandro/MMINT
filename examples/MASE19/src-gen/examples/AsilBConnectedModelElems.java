/**
 * Generated from platform:/resource/MASE19/src/examples/queries.vql
 */
package examples;

import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.modelepedia.safetycase.Goal;
import examples.ConnectedModelElems;
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
import org.eclipse.viatra.query.runtime.matchers.psystem.IExpressionEvaluator;
import org.eclipse.viatra.query.runtime.matchers.psystem.IValueProvider;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExpressionEvaluation;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.ConstantValue;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
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
 *         pattern asilBConnectedModelElems(goal: Goal,
 *                                          modelElem: ModelElement) {
 *           Goal.asil.value(goal, ASILLevel::B);
 *           Goal.id(goal, goalId);
 *           ModelElement.name(goalElem, goalName);
 *           check(goalName.endsWith(goalId));
 *           find connectedModelElems(goalElem, modelElem);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class AsilBConnectedModelElems extends BaseGeneratedEMFQuerySpecification<AsilBConnectedModelElems.Matcher> {
  /**
   * Pattern-specific match representation of the examples.asilBConnectedModelElems pattern,
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
    private Goal fGoal;
    
    private ModelElement fModelElem;
    
    private static List<String> parameterNames = makeImmutableList("goal", "modelElem");
    
    private Match(final Goal pGoal, final ModelElement pModelElem) {
      this.fGoal = pGoal;
      this.fModelElem = pModelElem;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("goal".equals(parameterName)) return this.fGoal;
      if ("modelElem".equals(parameterName)) return this.fModelElem;
      return null;
    }
    
    public Goal getGoal() {
      return this.fGoal;
    }
    
    public ModelElement getModelElem() {
      return this.fModelElem;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("goal".equals(parameterName) ) {
          this.fGoal = (Goal) newValue;
          return true;
      }
      if ("modelElem".equals(parameterName) ) {
          this.fModelElem = (ModelElement) newValue;
          return true;
      }
      return false;
    }
    
    public void setGoal(final Goal pGoal) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fGoal = pGoal;
    }
    
    public void setModelElem(final ModelElement pModelElem) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fModelElem = pModelElem;
    }
    
    @Override
    public String patternName() {
      return "examples.asilBConnectedModelElems";
    }
    
    @Override
    public List<String> parameterNames() {
      return AsilBConnectedModelElems.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fGoal, fModelElem};
    }
    
    @Override
    public AsilBConnectedModelElems.Match toImmutable() {
      return isMutable() ? newMatch(fGoal, fModelElem) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"goal\"=" + prettyPrintValue(fGoal) + ", ");
      result.append("\"modelElem\"=" + prettyPrintValue(fModelElem));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fGoal, fModelElem);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof AsilBConnectedModelElems.Match)) {
          AsilBConnectedModelElems.Match other = (AsilBConnectedModelElems.Match) obj;
          return Objects.equals(fGoal, other.fGoal) && Objects.equals(fModelElem, other.fModelElem);
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
    public AsilBConnectedModelElems specification() {
      return AsilBConnectedModelElems.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static AsilBConnectedModelElems.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pGoal the fixed value of pattern parameter goal, or null if not bound.
     * @param pModelElem the fixed value of pattern parameter modelElem, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static AsilBConnectedModelElems.Match newMutableMatch(final Goal pGoal, final ModelElement pModelElem) {
      return new Mutable(pGoal, pModelElem);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pGoal the fixed value of pattern parameter goal, or null if not bound.
     * @param pModelElem the fixed value of pattern parameter modelElem, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static AsilBConnectedModelElems.Match newMatch(final Goal pGoal, final ModelElement pModelElem) {
      return new Immutable(pGoal, pModelElem);
    }
    
    private static final class Mutable extends AsilBConnectedModelElems.Match {
      Mutable(final Goal pGoal, final ModelElement pModelElem) {
        super(pGoal, pModelElem);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends AsilBConnectedModelElems.Match {
      Immutable(final Goal pGoal, final ModelElement pModelElem) {
        super(pGoal, pModelElem);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the examples.asilBConnectedModelElems pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern asilBConnectedModelElems(goal: Goal,
   *                                  modelElem: ModelElement) {
   *   Goal.asil.value(goal, ASILLevel::B);
   *   Goal.id(goal, goalId);
   *   ModelElement.name(goalElem, goalName);
   *   check(goalName.endsWith(goalId));
   *   find connectedModelElems(goalElem, modelElem);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see AsilBConnectedModelElems
   * 
   */
  public static class Matcher extends BaseMatcher<AsilBConnectedModelElems.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static AsilBConnectedModelElems.Matcher on(final ViatraQueryEngine engine) {
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
    public static AsilBConnectedModelElems.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_GOAL = 0;
    
    private static final int POSITION_MODELELEM = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(AsilBConnectedModelElems.Matcher.class);
    
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
     * @param pModelElem the fixed value of pattern parameter modelElem, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<AsilBConnectedModelElems.Match> getAllMatches(final Goal pGoal, final ModelElement pModelElem) {
      return rawStreamAllMatches(new Object[]{pGoal, pModelElem}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pGoal the fixed value of pattern parameter goal, or null if not bound.
     * @param pModelElem the fixed value of pattern parameter modelElem, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<AsilBConnectedModelElems.Match> streamAllMatches(final Goal pGoal, final ModelElement pModelElem) {
      return rawStreamAllMatches(new Object[]{pGoal, pModelElem});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pGoal the fixed value of pattern parameter goal, or null if not bound.
     * @param pModelElem the fixed value of pattern parameter modelElem, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<AsilBConnectedModelElems.Match> getOneArbitraryMatch(final Goal pGoal, final ModelElement pModelElem) {
      return rawGetOneArbitraryMatch(new Object[]{pGoal, pModelElem});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pGoal the fixed value of pattern parameter goal, or null if not bound.
     * @param pModelElem the fixed value of pattern parameter modelElem, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final Goal pGoal, final ModelElement pModelElem) {
      return rawHasMatch(new Object[]{pGoal, pModelElem});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pGoal the fixed value of pattern parameter goal, or null if not bound.
     * @param pModelElem the fixed value of pattern parameter modelElem, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final Goal pGoal, final ModelElement pModelElem) {
      return rawCountMatches(new Object[]{pGoal, pModelElem});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pGoal the fixed value of pattern parameter goal, or null if not bound.
     * @param pModelElem the fixed value of pattern parameter modelElem, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final Goal pGoal, final ModelElement pModelElem, final Consumer<? super AsilBConnectedModelElems.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pGoal, pModelElem}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pGoal the fixed value of pattern parameter goal, or null if not bound.
     * @param pModelElem the fixed value of pattern parameter modelElem, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public AsilBConnectedModelElems.Match newMatch(final Goal pGoal, final ModelElement pModelElem) {
      return AsilBConnectedModelElems.Match.newMatch(pGoal, pModelElem);
    }
    
    /**
     * Retrieve the set of values that occur in matches for goal.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Goal> rawStreamAllValuesOfgoal(final Object[] parameters) {
      return rawStreamAllValues(POSITION_GOAL, parameters).map(Goal.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for goal.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Goal> getAllValuesOfgoal() {
      return rawStreamAllValuesOfgoal(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for goal.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Goal> streamAllValuesOfgoal() {
      return rawStreamAllValuesOfgoal(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for goal.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Goal> streamAllValuesOfgoal(final AsilBConnectedModelElems.Match partialMatch) {
      return rawStreamAllValuesOfgoal(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for goal.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Goal> streamAllValuesOfgoal(final ModelElement pModelElem) {
      return rawStreamAllValuesOfgoal(new Object[]{null, pModelElem});
    }
    
    /**
     * Retrieve the set of values that occur in matches for goal.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Goal> getAllValuesOfgoal(final AsilBConnectedModelElems.Match partialMatch) {
      return rawStreamAllValuesOfgoal(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for goal.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Goal> getAllValuesOfgoal(final ModelElement pModelElem) {
      return rawStreamAllValuesOfgoal(new Object[]{null, pModelElem}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelElem.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<ModelElement> rawStreamAllValuesOfmodelElem(final Object[] parameters) {
      return rawStreamAllValues(POSITION_MODELELEM, parameters).map(ModelElement.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelElem.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ModelElement> getAllValuesOfmodelElem() {
      return rawStreamAllValuesOfmodelElem(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelElem.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<ModelElement> streamAllValuesOfmodelElem() {
      return rawStreamAllValuesOfmodelElem(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelElem.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<ModelElement> streamAllValuesOfmodelElem(final AsilBConnectedModelElems.Match partialMatch) {
      return rawStreamAllValuesOfmodelElem(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelElem.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<ModelElement> streamAllValuesOfmodelElem(final Goal pGoal) {
      return rawStreamAllValuesOfmodelElem(new Object[]{pGoal, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelElem.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ModelElement> getAllValuesOfmodelElem(final AsilBConnectedModelElems.Match partialMatch) {
      return rawStreamAllValuesOfmodelElem(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelElem.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ModelElement> getAllValuesOfmodelElem(final Goal pGoal) {
      return rawStreamAllValuesOfmodelElem(new Object[]{pGoal, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected AsilBConnectedModelElems.Match tupleToMatch(final Tuple t) {
      try {
          return AsilBConnectedModelElems.Match.newMatch((Goal) t.get(POSITION_GOAL), (ModelElement) t.get(POSITION_MODELELEM));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected AsilBConnectedModelElems.Match arrayToMatch(final Object[] match) {
      try {
          return AsilBConnectedModelElems.Match.newMatch((Goal) match[POSITION_GOAL], (ModelElement) match[POSITION_MODELELEM]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected AsilBConnectedModelElems.Match arrayToMatchMutable(final Object[] match) {
      try {
          return AsilBConnectedModelElems.Match.newMutableMatch((Goal) match[POSITION_GOAL], (ModelElement) match[POSITION_MODELELEM]);
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
    public static IQuerySpecification<AsilBConnectedModelElems.Matcher> querySpecification() {
      return AsilBConnectedModelElems.instance();
    }
  }
  
  private AsilBConnectedModelElems() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static AsilBConnectedModelElems instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected AsilBConnectedModelElems.Matcher instantiate(final ViatraQueryEngine engine) {
    return AsilBConnectedModelElems.Matcher.on(engine);
  }
  
  @Override
  public AsilBConnectedModelElems.Matcher instantiate() {
    return AsilBConnectedModelElems.Matcher.create();
  }
  
  @Override
  public AsilBConnectedModelElems.Match newEmptyMatch() {
    return AsilBConnectedModelElems.Match.newEmptyMatch();
  }
  
  @Override
  public AsilBConnectedModelElems.Match newMatch(final Object... parameters) {
    return AsilBConnectedModelElems.Match.newMatch((edu.toronto.cs.se.modelepedia.safetycase.Goal) parameters[0], (edu.toronto.cs.se.mmint.mid.ModelElement) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: examples.AsilBConnectedModelElems (visibility: PUBLIC, simpleName: AsilBConnectedModelElems, identifier: examples.AsilBConnectedModelElems, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: examples) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: examples.AsilBConnectedModelElems (visibility: PUBLIC, simpleName: AsilBConnectedModelElems, identifier: examples.AsilBConnectedModelElems, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: examples) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final AsilBConnectedModelElems INSTANCE = new AsilBConnectedModelElems();
    
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
    private static final AsilBConnectedModelElems.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_goal = new PParameter("goal", "edu.toronto.cs.se.modelepedia.safetycase.Goal", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://se.cs.toronto.edu/modelepedia/SafetyCase", "Goal")), PParameterDirection.INOUT);
    
    private final PParameter parameter_modelElem = new PParameter("modelElem", "edu.toronto.cs.se.mmint.mid.ModelElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://se.cs.toronto.edu/mmint/MID", "ModelElement")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_goal, parameter_modelElem);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "examples.asilBConnectedModelElems";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("goal","modelElem");
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
          PVariable var_modelElem = body.getOrCreateVariableByName("modelElem");
          PVariable var_goalId = body.getOrCreateVariableByName("goalId");
          PVariable var_goalElem = body.getOrCreateVariableByName("goalElem");
          PVariable var_goalName = body.getOrCreateVariableByName("goalName");
          new TypeConstraint(body, Tuples.flatTupleOf(var_goal), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/SafetyCase", "Goal")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_modelElem), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/mmint/MID", "ModelElement")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_goal, parameter_goal),
             new ExportedParameter(body, var_modelElem, parameter_modelElem)
          ));
          //   Goal.asil.value(goal, ASILLevel::B)
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new ConstantValue(body, var__virtual_0_, edu.toronto.cs.se.modelepedia.safetycase.ASILLevel.get("B"));
          new TypeConstraint(body, Tuples.flatTupleOf(var_goal), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/SafetyCase", "Goal")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_goal, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://se.cs.toronto.edu/modelepedia/SafetyCase", "ASILfulElement", "asil")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/SafetyCase", "ASIL")));
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://se.cs.toronto.edu/modelepedia/SafetyCase", "ASIL", "value")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/SafetyCase", "ASILLevel")));
          new Equality(body, var__virtual_2_, var__virtual_0_);
          //   Goal.id(goal, goalId)
          new TypeConstraint(body, Tuples.flatTupleOf(var_goal), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/SafetyCase", "Goal")));
          PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_goal, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://se.cs.toronto.edu/modelepedia/SafetyCase", "ArgumentElement", "id")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_3_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EString")));
          new Equality(body, var__virtual_3_, var_goalId);
          //   ModelElement.name(goalElem, goalName)
          new TypeConstraint(body, Tuples.flatTupleOf(var_goalElem), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/mmint/MID", "ModelElement")));
          PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_goalElem, var__virtual_4_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://se.cs.toronto.edu/mmint/MID", "ExtendibleElement", "name")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_4_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EString")));
          new Equality(body, var__virtual_4_, var_goalName);
          //   check(goalName.endsWith(goalId))
          new ExpressionEvaluation(body, new IExpressionEvaluator() {
          
              @Override
              public String getShortDescription() {
                  return "Expression evaluation from pattern asilBConnectedModelElems";
              }
              
              @Override
              public Iterable<String> getInputParameterNames() {
                  return Arrays.asList("goalId", "goalName");}
          
              @Override
              public Object evaluateExpression(IValueProvider provider) throws Exception {
                  String goalId = (String) provider.getValue("goalId");
                  String goalName = (String) provider.getValue("goalName");
                  return evaluateExpression_1_1(goalId, goalName);
              }
          },  null); 
          //   find connectedModelElems(goalElem, modelElem)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_goalElem, var_modelElem), ConnectedModelElems.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      return bodies;
    }
  }
  
  private static boolean evaluateExpression_1_1(final String goalId, final String goalName) {
    boolean _endsWith = goalName.endsWith(goalId);
    return _endsWith;
  }
}

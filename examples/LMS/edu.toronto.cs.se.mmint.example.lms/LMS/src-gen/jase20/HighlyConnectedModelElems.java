/**
 * Generated from platform:/resource/LMS/src/jase20/scenarios.vql
 */
package jase20;

import edu.toronto.cs.se.mmint.mid.ModelElement;
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
import library.ConnectedModelElems;
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
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.context.common.JavaTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.psystem.IExpressionEvaluator;
import org.eclipse.viatra.query.runtime.matchers.psystem.IValueProvider;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExpressionEvaluation;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.PatternMatchCounter;
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
 *         pattern highlyConnectedModelElems(modelElem: ModelElement,
 *                                           connections: java Integer) {
 *           connections == count
 *             find library.connectedModelElems(modelElem, _);
 *           check(connections {@literal >} 5);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class HighlyConnectedModelElems extends BaseGeneratedEMFQuerySpecification<HighlyConnectedModelElems.Matcher> {
  /**
   * Pattern-specific match representation of the jase20.highlyConnectedModelElems pattern,
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
    private ModelElement fModelElem;
    
    private Integer fConnections;
    
    private static List<String> parameterNames = makeImmutableList("modelElem", "connections");
    
    private Match(final ModelElement pModelElem, final Integer pConnections) {
      this.fModelElem = pModelElem;
      this.fConnections = pConnections;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "modelElem": return this.fModelElem;
          case "connections": return this.fConnections;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fModelElem;
          case 1: return this.fConnections;
          default: return null;
      }
    }
    
    public ModelElement getModelElem() {
      return this.fModelElem;
    }
    
    public Integer getConnections() {
      return this.fConnections;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("modelElem".equals(parameterName) ) {
          this.fModelElem = (ModelElement) newValue;
          return true;
      }
      if ("connections".equals(parameterName) ) {
          this.fConnections = (Integer) newValue;
          return true;
      }
      return false;
    }
    
    public void setModelElem(final ModelElement pModelElem) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fModelElem = pModelElem;
    }
    
    public void setConnections(final Integer pConnections) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fConnections = pConnections;
    }
    
    @Override
    public String patternName() {
      return "jase20.highlyConnectedModelElems";
    }
    
    @Override
    public List<String> parameterNames() {
      return HighlyConnectedModelElems.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fModelElem, fConnections};
    }
    
    @Override
    public HighlyConnectedModelElems.Match toImmutable() {
      return isMutable() ? newMatch(fModelElem, fConnections) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"modelElem\"=" + prettyPrintValue(fModelElem) + ", ");
      result.append("\"connections\"=" + prettyPrintValue(fConnections));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fModelElem, fConnections);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof HighlyConnectedModelElems.Match)) {
          HighlyConnectedModelElems.Match other = (HighlyConnectedModelElems.Match) obj;
          return Objects.equals(fModelElem, other.fModelElem) && Objects.equals(fConnections, other.fConnections);
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
    public HighlyConnectedModelElems specification() {
      return HighlyConnectedModelElems.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static HighlyConnectedModelElems.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pModelElem the fixed value of pattern parameter modelElem, or null if not bound.
     * @param pConnections the fixed value of pattern parameter connections, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static HighlyConnectedModelElems.Match newMutableMatch(final ModelElement pModelElem, final Integer pConnections) {
      return new Mutable(pModelElem, pConnections);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pModelElem the fixed value of pattern parameter modelElem, or null if not bound.
     * @param pConnections the fixed value of pattern parameter connections, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static HighlyConnectedModelElems.Match newMatch(final ModelElement pModelElem, final Integer pConnections) {
      return new Immutable(pModelElem, pConnections);
    }
    
    private static final class Mutable extends HighlyConnectedModelElems.Match {
      Mutable(final ModelElement pModelElem, final Integer pConnections) {
        super(pModelElem, pConnections);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends HighlyConnectedModelElems.Match {
      Immutable(final ModelElement pModelElem, final Integer pConnections) {
        super(pModelElem, pConnections);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the jase20.highlyConnectedModelElems pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern highlyConnectedModelElems(modelElem: ModelElement,
   *                                   connections: java Integer) {
   *   connections == count
   *     find library.connectedModelElems(modelElem, _);
   *   check(connections {@literal >} 5);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see HighlyConnectedModelElems
   * 
   */
  public static class Matcher extends BaseMatcher<HighlyConnectedModelElems.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static HighlyConnectedModelElems.Matcher on(final ViatraQueryEngine engine) {
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
    public static HighlyConnectedModelElems.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_MODELELEM = 0;
    
    private static final int POSITION_CONNECTIONS = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(HighlyConnectedModelElems.Matcher.class);
    
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
     * @param pModelElem the fixed value of pattern parameter modelElem, or null if not bound.
     * @param pConnections the fixed value of pattern parameter connections, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<HighlyConnectedModelElems.Match> getAllMatches(final ModelElement pModelElem, final Integer pConnections) {
      return rawStreamAllMatches(new Object[]{pModelElem, pConnections}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pModelElem the fixed value of pattern parameter modelElem, or null if not bound.
     * @param pConnections the fixed value of pattern parameter connections, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<HighlyConnectedModelElems.Match> streamAllMatches(final ModelElement pModelElem, final Integer pConnections) {
      return rawStreamAllMatches(new Object[]{pModelElem, pConnections});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pModelElem the fixed value of pattern parameter modelElem, or null if not bound.
     * @param pConnections the fixed value of pattern parameter connections, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<HighlyConnectedModelElems.Match> getOneArbitraryMatch(final ModelElement pModelElem, final Integer pConnections) {
      return rawGetOneArbitraryMatch(new Object[]{pModelElem, pConnections});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pModelElem the fixed value of pattern parameter modelElem, or null if not bound.
     * @param pConnections the fixed value of pattern parameter connections, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final ModelElement pModelElem, final Integer pConnections) {
      return rawHasMatch(new Object[]{pModelElem, pConnections});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pModelElem the fixed value of pattern parameter modelElem, or null if not bound.
     * @param pConnections the fixed value of pattern parameter connections, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final ModelElement pModelElem, final Integer pConnections) {
      return rawCountMatches(new Object[]{pModelElem, pConnections});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pModelElem the fixed value of pattern parameter modelElem, or null if not bound.
     * @param pConnections the fixed value of pattern parameter connections, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final ModelElement pModelElem, final Integer pConnections, final Consumer<? super HighlyConnectedModelElems.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pModelElem, pConnections}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pModelElem the fixed value of pattern parameter modelElem, or null if not bound.
     * @param pConnections the fixed value of pattern parameter connections, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public HighlyConnectedModelElems.Match newMatch(final ModelElement pModelElem, final Integer pConnections) {
      return HighlyConnectedModelElems.Match.newMatch(pModelElem, pConnections);
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
    public Stream<ModelElement> streamAllValuesOfmodelElem(final HighlyConnectedModelElems.Match partialMatch) {
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
    public Stream<ModelElement> streamAllValuesOfmodelElem(final Integer pConnections) {
      return rawStreamAllValuesOfmodelElem(new Object[]{null, pConnections});
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelElem.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ModelElement> getAllValuesOfmodelElem(final HighlyConnectedModelElems.Match partialMatch) {
      return rawStreamAllValuesOfmodelElem(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelElem.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ModelElement> getAllValuesOfmodelElem(final Integer pConnections) {
      return rawStreamAllValuesOfmodelElem(new Object[]{null, pConnections}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for connections.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Integer> rawStreamAllValuesOfconnections(final Object[] parameters) {
      return rawStreamAllValues(POSITION_CONNECTIONS, parameters).map(Integer.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for connections.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Integer> getAllValuesOfconnections() {
      return rawStreamAllValuesOfconnections(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for connections.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Integer> streamAllValuesOfconnections() {
      return rawStreamAllValuesOfconnections(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for connections.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Integer> streamAllValuesOfconnections(final HighlyConnectedModelElems.Match partialMatch) {
      return rawStreamAllValuesOfconnections(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for connections.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Integer> streamAllValuesOfconnections(final ModelElement pModelElem) {
      return rawStreamAllValuesOfconnections(new Object[]{pModelElem, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for connections.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Integer> getAllValuesOfconnections(final HighlyConnectedModelElems.Match partialMatch) {
      return rawStreamAllValuesOfconnections(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for connections.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Integer> getAllValuesOfconnections(final ModelElement pModelElem) {
      return rawStreamAllValuesOfconnections(new Object[]{pModelElem, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected HighlyConnectedModelElems.Match tupleToMatch(final Tuple t) {
      try {
          return HighlyConnectedModelElems.Match.newMatch((ModelElement) t.get(POSITION_MODELELEM), (Integer) t.get(POSITION_CONNECTIONS));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected HighlyConnectedModelElems.Match arrayToMatch(final Object[] match) {
      try {
          return HighlyConnectedModelElems.Match.newMatch((ModelElement) match[POSITION_MODELELEM], (Integer) match[POSITION_CONNECTIONS]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected HighlyConnectedModelElems.Match arrayToMatchMutable(final Object[] match) {
      try {
          return HighlyConnectedModelElems.Match.newMutableMatch((ModelElement) match[POSITION_MODELELEM], (Integer) match[POSITION_CONNECTIONS]);
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
    public static IQuerySpecification<HighlyConnectedModelElems.Matcher> querySpecification() {
      return HighlyConnectedModelElems.instance();
    }
  }
  
  private HighlyConnectedModelElems() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static HighlyConnectedModelElems instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected HighlyConnectedModelElems.Matcher instantiate(final ViatraQueryEngine engine) {
    return HighlyConnectedModelElems.Matcher.on(engine);
  }
  
  @Override
  public HighlyConnectedModelElems.Matcher instantiate() {
    return HighlyConnectedModelElems.Matcher.create();
  }
  
  @Override
  public HighlyConnectedModelElems.Match newEmptyMatch() {
    return HighlyConnectedModelElems.Match.newEmptyMatch();
  }
  
  @Override
  public HighlyConnectedModelElems.Match newMatch(final Object... parameters) {
    return HighlyConnectedModelElems.Match.newMatch((edu.toronto.cs.se.mmint.mid.ModelElement) parameters[0], (java.lang.Integer) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link HighlyConnectedModelElems} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link HighlyConnectedModelElems#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final HighlyConnectedModelElems INSTANCE = new HighlyConnectedModelElems();
    
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
    private static final HighlyConnectedModelElems.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_modelElem = new PParameter("modelElem", "edu.toronto.cs.se.mmint.mid.ModelElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://se.cs.toronto.edu/mmint/MID", "ModelElement")), PParameterDirection.INOUT);
    
    private final PParameter parameter_connections = new PParameter("connections", "java.lang.Integer", new JavaTransitiveInstancesKey(java.lang.Integer.class), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_modelElem, parameter_connections);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "jase20.highlyConnectedModelElems";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("modelElem","connections");
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
          PVariable var_modelElem = body.getOrCreateVariableByName("modelElem");
          PVariable var_connections = body.getOrCreateVariableByName("connections");
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          new TypeConstraint(body, Tuples.flatTupleOf(var_modelElem), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/mmint/MID", "ModelElement")));
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_connections), new JavaTransitiveInstancesKey(java.lang.Integer.class));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_modelElem, parameter_modelElem),
             new ExportedParameter(body, var_connections, parameter_connections)
          ));
          //   connections == count    find library.connectedModelElems(modelElem, _)
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new PatternMatchCounter(body, Tuples.flatTupleOf(var_modelElem, var___0_), ConnectedModelElems.instance().getInternalQueryRepresentation(), var__virtual_0_);
          new Equality(body, var_connections, var__virtual_0_);
          //   check(connections > 5)
          new ExpressionEvaluation(body, new IExpressionEvaluator() {
          
              @Override
              public String getShortDescription() {
                  return "Expression evaluation from pattern highlyConnectedModelElems";
              }
              
              @Override
              public Iterable<String> getInputParameterNames() {
                  return Arrays.asList("connections");}
          
              @Override
              public Object evaluateExpression(IValueProvider provider) throws Exception {
                  Integer connections = (Integer) provider.getValue("connections");
                  return evaluateExpression_1_1(connections);
              }
          },  null); 
          bodies.add(body);
      }
      return bodies;
    }
  }
  
  private static boolean evaluateExpression_1_1(final Integer connections) {
    return ((connections).intValue() > 5);
  }
}

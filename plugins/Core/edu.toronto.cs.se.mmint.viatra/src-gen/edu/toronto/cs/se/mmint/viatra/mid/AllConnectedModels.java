/**
 * Generated from platform:/resource/edu.toronto.cs.se.mmint.viatra/src/edu/toronto/cs/se/mmint/viatra/mid/mid.vql
 */
package edu.toronto.cs.se.mmint.viatra.mid;

import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.viatra.mid.ConnectedModels;
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
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Inequality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.BinaryTransitiveClosure;
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
 *         pattern allConnectedModels(modelSrc: Model, modelTgt: Model) {
 *           modelSrc != modelTgt;
 *           find connectedModels+(modelSrc, modelTgt);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class AllConnectedModels extends BaseGeneratedEMFQuerySpecification<AllConnectedModels.Matcher> {
  /**
   * Pattern-specific match representation of the edu.toronto.cs.se.mmint.viatra.mid.allConnectedModels pattern,
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
    private Model fModelSrc;
    
    private Model fModelTgt;
    
    private static List<String> parameterNames = makeImmutableList("modelSrc", "modelTgt");
    
    private Match(final Model pModelSrc, final Model pModelTgt) {
      this.fModelSrc = pModelSrc;
      this.fModelTgt = pModelTgt;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "modelSrc": return this.fModelSrc;
          case "modelTgt": return this.fModelTgt;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fModelSrc;
          case 1: return this.fModelTgt;
          default: return null;
      }
    }
    
    public Model getModelSrc() {
      return this.fModelSrc;
    }
    
    public Model getModelTgt() {
      return this.fModelTgt;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("modelSrc".equals(parameterName) ) {
          this.fModelSrc = (Model) newValue;
          return true;
      }
      if ("modelTgt".equals(parameterName) ) {
          this.fModelTgt = (Model) newValue;
          return true;
      }
      return false;
    }
    
    public void setModelSrc(final Model pModelSrc) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fModelSrc = pModelSrc;
    }
    
    public void setModelTgt(final Model pModelTgt) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fModelTgt = pModelTgt;
    }
    
    @Override
    public String patternName() {
      return "edu.toronto.cs.se.mmint.viatra.mid.allConnectedModels";
    }
    
    @Override
    public List<String> parameterNames() {
      return AllConnectedModels.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fModelSrc, fModelTgt};
    }
    
    @Override
    public AllConnectedModels.Match toImmutable() {
      return isMutable() ? newMatch(fModelSrc, fModelTgt) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"modelSrc\"=" + prettyPrintValue(fModelSrc) + ", ");
      result.append("\"modelTgt\"=" + prettyPrintValue(fModelTgt));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fModelSrc, fModelTgt);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof AllConnectedModels.Match)) {
          AllConnectedModels.Match other = (AllConnectedModels.Match) obj;
          return Objects.equals(fModelSrc, other.fModelSrc) && Objects.equals(fModelTgt, other.fModelTgt);
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
    public AllConnectedModels specification() {
      return AllConnectedModels.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static AllConnectedModels.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pModelSrc the fixed value of pattern parameter modelSrc, or null if not bound.
     * @param pModelTgt the fixed value of pattern parameter modelTgt, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static AllConnectedModels.Match newMutableMatch(final Model pModelSrc, final Model pModelTgt) {
      return new Mutable(pModelSrc, pModelTgt);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pModelSrc the fixed value of pattern parameter modelSrc, or null if not bound.
     * @param pModelTgt the fixed value of pattern parameter modelTgt, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static AllConnectedModels.Match newMatch(final Model pModelSrc, final Model pModelTgt) {
      return new Immutable(pModelSrc, pModelTgt);
    }
    
    private static final class Mutable extends AllConnectedModels.Match {
      Mutable(final Model pModelSrc, final Model pModelTgt) {
        super(pModelSrc, pModelTgt);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends AllConnectedModels.Match {
      Immutable(final Model pModelSrc, final Model pModelTgt) {
        super(pModelSrc, pModelTgt);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the edu.toronto.cs.se.mmint.viatra.mid.allConnectedModels pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern allConnectedModels(modelSrc: Model, modelTgt: Model) {
   *   modelSrc != modelTgt;
   *   find connectedModels+(modelSrc, modelTgt);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see AllConnectedModels
   * 
   */
  public static class Matcher extends BaseMatcher<AllConnectedModels.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static AllConnectedModels.Matcher on(final ViatraQueryEngine engine) {
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
    public static AllConnectedModels.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_MODELSRC = 0;
    
    private static final int POSITION_MODELTGT = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(AllConnectedModels.Matcher.class);
    
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
     * @param pModelSrc the fixed value of pattern parameter modelSrc, or null if not bound.
     * @param pModelTgt the fixed value of pattern parameter modelTgt, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<AllConnectedModels.Match> getAllMatches(final Model pModelSrc, final Model pModelTgt) {
      return rawStreamAllMatches(new Object[]{pModelSrc, pModelTgt}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pModelSrc the fixed value of pattern parameter modelSrc, or null if not bound.
     * @param pModelTgt the fixed value of pattern parameter modelTgt, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<AllConnectedModels.Match> streamAllMatches(final Model pModelSrc, final Model pModelTgt) {
      return rawStreamAllMatches(new Object[]{pModelSrc, pModelTgt});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pModelSrc the fixed value of pattern parameter modelSrc, or null if not bound.
     * @param pModelTgt the fixed value of pattern parameter modelTgt, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<AllConnectedModels.Match> getOneArbitraryMatch(final Model pModelSrc, final Model pModelTgt) {
      return rawGetOneArbitraryMatch(new Object[]{pModelSrc, pModelTgt});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pModelSrc the fixed value of pattern parameter modelSrc, or null if not bound.
     * @param pModelTgt the fixed value of pattern parameter modelTgt, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final Model pModelSrc, final Model pModelTgt) {
      return rawHasMatch(new Object[]{pModelSrc, pModelTgt});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pModelSrc the fixed value of pattern parameter modelSrc, or null if not bound.
     * @param pModelTgt the fixed value of pattern parameter modelTgt, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final Model pModelSrc, final Model pModelTgt) {
      return rawCountMatches(new Object[]{pModelSrc, pModelTgt});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pModelSrc the fixed value of pattern parameter modelSrc, or null if not bound.
     * @param pModelTgt the fixed value of pattern parameter modelTgt, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final Model pModelSrc, final Model pModelTgt, final Consumer<? super AllConnectedModels.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pModelSrc, pModelTgt}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pModelSrc the fixed value of pattern parameter modelSrc, or null if not bound.
     * @param pModelTgt the fixed value of pattern parameter modelTgt, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public AllConnectedModels.Match newMatch(final Model pModelSrc, final Model pModelTgt) {
      return AllConnectedModels.Match.newMatch(pModelSrc, pModelTgt);
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelSrc.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Model> rawStreamAllValuesOfmodelSrc(final Object[] parameters) {
      return rawStreamAllValues(POSITION_MODELSRC, parameters).map(Model.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelSrc.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Model> getAllValuesOfmodelSrc() {
      return rawStreamAllValuesOfmodelSrc(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelSrc.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Model> streamAllValuesOfmodelSrc() {
      return rawStreamAllValuesOfmodelSrc(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelSrc.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Model> streamAllValuesOfmodelSrc(final AllConnectedModels.Match partialMatch) {
      return rawStreamAllValuesOfmodelSrc(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelSrc.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Model> streamAllValuesOfmodelSrc(final Model pModelTgt) {
      return rawStreamAllValuesOfmodelSrc(new Object[]{null, pModelTgt});
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelSrc.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Model> getAllValuesOfmodelSrc(final AllConnectedModels.Match partialMatch) {
      return rawStreamAllValuesOfmodelSrc(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelSrc.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Model> getAllValuesOfmodelSrc(final Model pModelTgt) {
      return rawStreamAllValuesOfmodelSrc(new Object[]{null, pModelTgt}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelTgt.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Model> rawStreamAllValuesOfmodelTgt(final Object[] parameters) {
      return rawStreamAllValues(POSITION_MODELTGT, parameters).map(Model.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelTgt.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Model> getAllValuesOfmodelTgt() {
      return rawStreamAllValuesOfmodelTgt(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelTgt.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Model> streamAllValuesOfmodelTgt() {
      return rawStreamAllValuesOfmodelTgt(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelTgt.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Model> streamAllValuesOfmodelTgt(final AllConnectedModels.Match partialMatch) {
      return rawStreamAllValuesOfmodelTgt(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelTgt.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Model> streamAllValuesOfmodelTgt(final Model pModelSrc) {
      return rawStreamAllValuesOfmodelTgt(new Object[]{pModelSrc, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelTgt.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Model> getAllValuesOfmodelTgt(final AllConnectedModels.Match partialMatch) {
      return rawStreamAllValuesOfmodelTgt(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelTgt.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Model> getAllValuesOfmodelTgt(final Model pModelSrc) {
      return rawStreamAllValuesOfmodelTgt(new Object[]{pModelSrc, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected AllConnectedModels.Match tupleToMatch(final Tuple t) {
      try {
          return AllConnectedModels.Match.newMatch((Model) t.get(POSITION_MODELSRC), (Model) t.get(POSITION_MODELTGT));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected AllConnectedModels.Match arrayToMatch(final Object[] match) {
      try {
          return AllConnectedModels.Match.newMatch((Model) match[POSITION_MODELSRC], (Model) match[POSITION_MODELTGT]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected AllConnectedModels.Match arrayToMatchMutable(final Object[] match) {
      try {
          return AllConnectedModels.Match.newMutableMatch((Model) match[POSITION_MODELSRC], (Model) match[POSITION_MODELTGT]);
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
    public static IQuerySpecification<AllConnectedModels.Matcher> querySpecification() {
      return AllConnectedModels.instance();
    }
  }
  
  private AllConnectedModels() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static AllConnectedModels instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected AllConnectedModels.Matcher instantiate(final ViatraQueryEngine engine) {
    return AllConnectedModels.Matcher.on(engine);
  }
  
  @Override
  public AllConnectedModels.Matcher instantiate() {
    return AllConnectedModels.Matcher.create();
  }
  
  @Override
  public AllConnectedModels.Match newEmptyMatch() {
    return AllConnectedModels.Match.newEmptyMatch();
  }
  
  @Override
  public AllConnectedModels.Match newMatch(final Object... parameters) {
    return AllConnectedModels.Match.newMatch((edu.toronto.cs.se.mmint.mid.Model) parameters[0], (edu.toronto.cs.se.mmint.mid.Model) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link AllConnectedModels} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link AllConnectedModels#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final AllConnectedModels INSTANCE = new AllConnectedModels();
    
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
    private static final AllConnectedModels.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_modelSrc = new PParameter("modelSrc", "edu.toronto.cs.se.mmint.mid.Model", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://se.cs.toronto.edu/mmint/MID", "Model")), PParameterDirection.INOUT);
    
    private final PParameter parameter_modelTgt = new PParameter("modelTgt", "edu.toronto.cs.se.mmint.mid.Model", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://se.cs.toronto.edu/mmint/MID", "Model")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_modelSrc, parameter_modelTgt);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "edu.toronto.cs.se.mmint.viatra.mid.allConnectedModels";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("modelSrc","modelTgt");
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
          PVariable var_modelSrc = body.getOrCreateVariableByName("modelSrc");
          PVariable var_modelTgt = body.getOrCreateVariableByName("modelTgt");
          new TypeConstraint(body, Tuples.flatTupleOf(var_modelSrc), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/mmint/MID", "Model")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_modelTgt), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/mmint/MID", "Model")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_modelSrc, parameter_modelSrc),
             new ExportedParameter(body, var_modelTgt, parameter_modelTgt)
          ));
          //   modelSrc != modelTgt
          new Inequality(body, var_modelSrc, var_modelTgt);
          //   find connectedModels+(modelSrc, modelTgt)
          new BinaryTransitiveClosure(body, Tuples.flatTupleOf(var_modelSrc, var_modelTgt), ConnectedModels.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      return bodies;
    }
  }
}

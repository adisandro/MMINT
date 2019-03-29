/**
 * Generated from platform:/resource/edu.toronto.cs.se.mmint.viatra/src/edu/toronto/cs/se/mmint/viatra/mid/mid.vql
 */
package edu.toronto.cs.se.mmint.viatra.mid;

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
 *         pattern connectedModelElements(in modelElemSrc: ModelElement, out modelElemTgt: ModelElement) {
 *           modelElemSrc != modelElemTgt;
 *           Mapping.modelElemEndpoints.target(mapping, modelElemSrc);
 *           Mapping.modelElemEndpoints.target(mapping, modelElemTgt);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class ConnectedModelElements extends BaseGeneratedEMFQuerySpecification<ConnectedModelElements.Matcher> {
  /**
   * Pattern-specific match representation of the edu.toronto.cs.se.mmint.viatra.mid.connectedModelElements pattern,
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
    private ModelElement fModelElemSrc;
    
    private ModelElement fModelElemTgt;
    
    private static List<String> parameterNames = makeImmutableList("modelElemSrc", "modelElemTgt");
    
    private Match(final ModelElement pModelElemSrc, final ModelElement pModelElemTgt) {
      this.fModelElemSrc = pModelElemSrc;
      this.fModelElemTgt = pModelElemTgt;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("modelElemSrc".equals(parameterName)) return this.fModelElemSrc;
      if ("modelElemTgt".equals(parameterName)) return this.fModelElemTgt;
      return null;
    }
    
    public ModelElement getModelElemSrc() {
      return this.fModelElemSrc;
    }
    
    public ModelElement getModelElemTgt() {
      return this.fModelElemTgt;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("modelElemSrc".equals(parameterName) ) {
          this.fModelElemSrc = (ModelElement) newValue;
          return true;
      }
      if ("modelElemTgt".equals(parameterName) ) {
          this.fModelElemTgt = (ModelElement) newValue;
          return true;
      }
      return false;
    }
    
    public void setModelElemSrc(final ModelElement pModelElemSrc) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fModelElemSrc = pModelElemSrc;
    }
    
    public void setModelElemTgt(final ModelElement pModelElemTgt) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fModelElemTgt = pModelElemTgt;
    }
    
    @Override
    public String patternName() {
      return "edu.toronto.cs.se.mmint.viatra.mid.connectedModelElements";
    }
    
    @Override
    public List<String> parameterNames() {
      return ConnectedModelElements.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fModelElemSrc, fModelElemTgt};
    }
    
    @Override
    public ConnectedModelElements.Match toImmutable() {
      return isMutable() ? newMatch(fModelElemSrc, fModelElemTgt) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"modelElemSrc\"=" + prettyPrintValue(fModelElemSrc) + ", ");
      result.append("\"modelElemTgt\"=" + prettyPrintValue(fModelElemTgt));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fModelElemSrc, fModelElemTgt);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof ConnectedModelElements.Match)) {
          ConnectedModelElements.Match other = (ConnectedModelElements.Match) obj;
          return Objects.equals(fModelElemSrc, other.fModelElemSrc) && Objects.equals(fModelElemTgt, other.fModelElemTgt);
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
    public ConnectedModelElements specification() {
      return ConnectedModelElements.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static ConnectedModelElements.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pModelElemSrc the fixed value of pattern parameter modelElemSrc, or null if not bound.
     * @param pModelElemTgt the fixed value of pattern parameter modelElemTgt, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static ConnectedModelElements.Match newMutableMatch(final ModelElement pModelElemSrc, final ModelElement pModelElemTgt) {
      return new Mutable(pModelElemSrc, pModelElemTgt);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pModelElemSrc the fixed value of pattern parameter modelElemSrc, or null if not bound.
     * @param pModelElemTgt the fixed value of pattern parameter modelElemTgt, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static ConnectedModelElements.Match newMatch(final ModelElement pModelElemSrc, final ModelElement pModelElemTgt) {
      return new Immutable(pModelElemSrc, pModelElemTgt);
    }
    
    private static final class Mutable extends ConnectedModelElements.Match {
      Mutable(final ModelElement pModelElemSrc, final ModelElement pModelElemTgt) {
        super(pModelElemSrc, pModelElemTgt);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends ConnectedModelElements.Match {
      Immutable(final ModelElement pModelElemSrc, final ModelElement pModelElemTgt) {
        super(pModelElemSrc, pModelElemTgt);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the edu.toronto.cs.se.mmint.viatra.mid.connectedModelElements pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern connectedModelElements(in modelElemSrc: ModelElement, out modelElemTgt: ModelElement) {
   *   modelElemSrc != modelElemTgt;
   *   Mapping.modelElemEndpoints.target(mapping, modelElemSrc);
   *   Mapping.modelElemEndpoints.target(mapping, modelElemTgt);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see ConnectedModelElements
   * 
   */
  public static class Matcher extends BaseMatcher<ConnectedModelElements.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static ConnectedModelElements.Matcher on(final ViatraQueryEngine engine) {
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
    public static ConnectedModelElements.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_MODELELEMSRC = 0;
    
    private static final int POSITION_MODELELEMTGT = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(ConnectedModelElements.Matcher.class);
    
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
     * @param pModelElemSrc the fixed value of pattern parameter modelElemSrc, or null if not bound.
     * @param pModelElemTgt the fixed value of pattern parameter modelElemTgt, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<ConnectedModelElements.Match> getAllMatches(final ModelElement pModelElemSrc, final ModelElement pModelElemTgt) {
      return rawStreamAllMatches(new Object[]{pModelElemSrc, pModelElemTgt}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pModelElemSrc the fixed value of pattern parameter modelElemSrc, or null if not bound.
     * @param pModelElemTgt the fixed value of pattern parameter modelElemTgt, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<ConnectedModelElements.Match> streamAllMatches(final ModelElement pModelElemSrc, final ModelElement pModelElemTgt) {
      return rawStreamAllMatches(new Object[]{pModelElemSrc, pModelElemTgt});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pModelElemSrc the fixed value of pattern parameter modelElemSrc, or null if not bound.
     * @param pModelElemTgt the fixed value of pattern parameter modelElemTgt, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<ConnectedModelElements.Match> getOneArbitraryMatch(final ModelElement pModelElemSrc, final ModelElement pModelElemTgt) {
      return rawGetOneArbitraryMatch(new Object[]{pModelElemSrc, pModelElemTgt});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pModelElemSrc the fixed value of pattern parameter modelElemSrc, or null if not bound.
     * @param pModelElemTgt the fixed value of pattern parameter modelElemTgt, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final ModelElement pModelElemSrc, final ModelElement pModelElemTgt) {
      return rawHasMatch(new Object[]{pModelElemSrc, pModelElemTgt});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pModelElemSrc the fixed value of pattern parameter modelElemSrc, or null if not bound.
     * @param pModelElemTgt the fixed value of pattern parameter modelElemTgt, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final ModelElement pModelElemSrc, final ModelElement pModelElemTgt) {
      return rawCountMatches(new Object[]{pModelElemSrc, pModelElemTgt});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pModelElemSrc the fixed value of pattern parameter modelElemSrc, or null if not bound.
     * @param pModelElemTgt the fixed value of pattern parameter modelElemTgt, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final ModelElement pModelElemSrc, final ModelElement pModelElemTgt, final Consumer<? super ConnectedModelElements.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pModelElemSrc, pModelElemTgt}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pModelElemSrc the fixed value of pattern parameter modelElemSrc, or null if not bound.
     * @param pModelElemTgt the fixed value of pattern parameter modelElemTgt, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public ConnectedModelElements.Match newMatch(final ModelElement pModelElemSrc, final ModelElement pModelElemTgt) {
      return ConnectedModelElements.Match.newMatch(pModelElemSrc, pModelElemTgt);
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelElemSrc.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<ModelElement> rawStreamAllValuesOfmodelElemSrc(final Object[] parameters) {
      return rawStreamAllValues(POSITION_MODELELEMSRC, parameters).map(ModelElement.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelElemSrc.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ModelElement> getAllValuesOfmodelElemSrc() {
      return rawStreamAllValuesOfmodelElemSrc(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelElemSrc.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<ModelElement> streamAllValuesOfmodelElemSrc() {
      return rawStreamAllValuesOfmodelElemSrc(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelElemSrc.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<ModelElement> streamAllValuesOfmodelElemSrc(final ConnectedModelElements.Match partialMatch) {
      return rawStreamAllValuesOfmodelElemSrc(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelElemSrc.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<ModelElement> streamAllValuesOfmodelElemSrc(final ModelElement pModelElemTgt) {
      return rawStreamAllValuesOfmodelElemSrc(new Object[]{null, pModelElemTgt});
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelElemSrc.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ModelElement> getAllValuesOfmodelElemSrc(final ConnectedModelElements.Match partialMatch) {
      return rawStreamAllValuesOfmodelElemSrc(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelElemSrc.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ModelElement> getAllValuesOfmodelElemSrc(final ModelElement pModelElemTgt) {
      return rawStreamAllValuesOfmodelElemSrc(new Object[]{null, pModelElemTgt}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelElemTgt.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<ModelElement> rawStreamAllValuesOfmodelElemTgt(final Object[] parameters) {
      return rawStreamAllValues(POSITION_MODELELEMTGT, parameters).map(ModelElement.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelElemTgt.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ModelElement> getAllValuesOfmodelElemTgt() {
      return rawStreamAllValuesOfmodelElemTgt(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelElemTgt.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<ModelElement> streamAllValuesOfmodelElemTgt() {
      return rawStreamAllValuesOfmodelElemTgt(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelElemTgt.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<ModelElement> streamAllValuesOfmodelElemTgt(final ConnectedModelElements.Match partialMatch) {
      return rawStreamAllValuesOfmodelElemTgt(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelElemTgt.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<ModelElement> streamAllValuesOfmodelElemTgt(final ModelElement pModelElemSrc) {
      return rawStreamAllValuesOfmodelElemTgt(new Object[]{pModelElemSrc, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelElemTgt.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ModelElement> getAllValuesOfmodelElemTgt(final ConnectedModelElements.Match partialMatch) {
      return rawStreamAllValuesOfmodelElemTgt(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelElemTgt.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ModelElement> getAllValuesOfmodelElemTgt(final ModelElement pModelElemSrc) {
      return rawStreamAllValuesOfmodelElemTgt(new Object[]{pModelElemSrc, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected ConnectedModelElements.Match tupleToMatch(final Tuple t) {
      try {
          return ConnectedModelElements.Match.newMatch((ModelElement) t.get(POSITION_MODELELEMSRC), (ModelElement) t.get(POSITION_MODELELEMTGT));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected ConnectedModelElements.Match arrayToMatch(final Object[] match) {
      try {
          return ConnectedModelElements.Match.newMatch((ModelElement) match[POSITION_MODELELEMSRC], (ModelElement) match[POSITION_MODELELEMTGT]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected ConnectedModelElements.Match arrayToMatchMutable(final Object[] match) {
      try {
          return ConnectedModelElements.Match.newMutableMatch((ModelElement) match[POSITION_MODELELEMSRC], (ModelElement) match[POSITION_MODELELEMTGT]);
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
    public static IQuerySpecification<ConnectedModelElements.Matcher> querySpecification() {
      return ConnectedModelElements.instance();
    }
  }
  
  private ConnectedModelElements() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static ConnectedModelElements instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected ConnectedModelElements.Matcher instantiate(final ViatraQueryEngine engine) {
    return ConnectedModelElements.Matcher.on(engine);
  }
  
  @Override
  public ConnectedModelElements.Matcher instantiate() {
    return ConnectedModelElements.Matcher.create();
  }
  
  @Override
  public ConnectedModelElements.Match newEmptyMatch() {
    return ConnectedModelElements.Match.newEmptyMatch();
  }
  
  @Override
  public ConnectedModelElements.Match newMatch(final Object... parameters) {
    return ConnectedModelElements.Match.newMatch((edu.toronto.cs.se.mmint.mid.ModelElement) parameters[0], (edu.toronto.cs.se.mmint.mid.ModelElement) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: edu.toronto.cs.se.mmint.viatra.mid.ConnectedModelElements (visibility: PUBLIC, simpleName: ConnectedModelElements, identifier: edu.toronto.cs.se.mmint.viatra.mid.ConnectedModelElements, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: edu.toronto.cs.se.mmint.viatra.mid) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: edu.toronto.cs.se.mmint.viatra.mid.ConnectedModelElements (visibility: PUBLIC, simpleName: ConnectedModelElements, identifier: edu.toronto.cs.se.mmint.viatra.mid.ConnectedModelElements, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: edu.toronto.cs.se.mmint.viatra.mid) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final ConnectedModelElements INSTANCE = new ConnectedModelElements();
    
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
    private static final ConnectedModelElements.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_modelElemSrc = new PParameter("modelElemSrc", "edu.toronto.cs.se.mmint.mid.ModelElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://se.cs.toronto.edu/mmint/MID", "ModelElement")), PParameterDirection.INOUT);
    
    private final PParameter parameter_modelElemTgt = new PParameter("modelElemTgt", "edu.toronto.cs.se.mmint.mid.ModelElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://se.cs.toronto.edu/mmint/MID", "ModelElement")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_modelElemSrc, parameter_modelElemTgt);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "edu.toronto.cs.se.mmint.viatra.mid.connectedModelElements";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("modelElemSrc","modelElemTgt");
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
          PVariable var_modelElemSrc = body.getOrCreateVariableByName("modelElemSrc");
          PVariable var_modelElemTgt = body.getOrCreateVariableByName("modelElemTgt");
          PVariable var_mapping = body.getOrCreateVariableByName("mapping");
          new TypeConstraint(body, Tuples.flatTupleOf(var_modelElemSrc), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/mmint/MID", "ModelElement")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_modelElemTgt), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/mmint/MID", "ModelElement")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_modelElemSrc, parameter_modelElemSrc),
             new ExportedParameter(body, var_modelElemTgt, parameter_modelElemTgt)
          ));
          //   modelElemSrc != modelElemTgt
          new Inequality(body, var_modelElemSrc, var_modelElemTgt);
          //   Mapping.modelElemEndpoints.target(mapping, modelElemSrc)
          new TypeConstraint(body, Tuples.flatTupleOf(var_mapping), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/mmint/MID/Relationship", "Mapping")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_mapping, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://se.cs.toronto.edu/mmint/MID/Relationship", "Mapping", "modelElemEndpoints")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/mmint/MID/Relationship", "ModelElementEndpoint")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://se.cs.toronto.edu/mmint/MID", "ExtendibleElementEndpoint", "target")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/mmint/MID", "ExtendibleElement")));
          new Equality(body, var__virtual_1_, var_modelElemSrc);
          //   Mapping.modelElemEndpoints.target(mapping, modelElemTgt)
          new TypeConstraint(body, Tuples.flatTupleOf(var_mapping), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/mmint/MID/Relationship", "Mapping")));
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_mapping, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://se.cs.toronto.edu/mmint/MID/Relationship", "Mapping", "modelElemEndpoints")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/mmint/MID/Relationship", "ModelElementEndpoint")));
          PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://se.cs.toronto.edu/mmint/MID", "ExtendibleElementEndpoint", "target")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_3_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/mmint/MID", "ExtendibleElement")));
          new Equality(body, var__virtual_3_, var_modelElemTgt);
          bodies.add(body);
      }
      return bodies;
    }
  }
}

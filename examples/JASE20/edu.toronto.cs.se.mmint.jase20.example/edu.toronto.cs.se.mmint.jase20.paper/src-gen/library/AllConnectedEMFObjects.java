/**
 * Generated from platform:/resource/edu.toronto.cs.se.mmint.jase20.paper/src/library/MID.vql
 */
package library;

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
import library.AllConnectedModelElems;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
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
 *         pattern allConnectedEMFObjects(modelObjSrc: EObject,
 *                                        modelObjTgt: EObject) {
 *           modelObjSrc != modelObjTgt;
 *           ModelElement.EMFInstanceObject(modelElemSrc, modelObjSrc);
 *           ModelElement.EMFInstanceObject(modelElemTgt, modelObjTgt);
 *           find allConnectedModelElems(modelElemSrc, modelElemTgt);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class AllConnectedEMFObjects extends BaseGeneratedEMFQuerySpecification<AllConnectedEMFObjects.Matcher> {
  /**
   * Pattern-specific match representation of the library.allConnectedEMFObjects pattern,
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
    private EObject fModelObjSrc;
    
    private EObject fModelObjTgt;
    
    private static List<String> parameterNames = makeImmutableList("modelObjSrc", "modelObjTgt");
    
    private Match(final EObject pModelObjSrc, final EObject pModelObjTgt) {
      this.fModelObjSrc = pModelObjSrc;
      this.fModelObjTgt = pModelObjTgt;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "modelObjSrc": return this.fModelObjSrc;
          case "modelObjTgt": return this.fModelObjTgt;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fModelObjSrc;
          case 1: return this.fModelObjTgt;
          default: return null;
      }
    }
    
    public EObject getModelObjSrc() {
      return this.fModelObjSrc;
    }
    
    public EObject getModelObjTgt() {
      return this.fModelObjTgt;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("modelObjSrc".equals(parameterName) ) {
          this.fModelObjSrc = (EObject) newValue;
          return true;
      }
      if ("modelObjTgt".equals(parameterName) ) {
          this.fModelObjTgt = (EObject) newValue;
          return true;
      }
      return false;
    }
    
    public void setModelObjSrc(final EObject pModelObjSrc) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fModelObjSrc = pModelObjSrc;
    }
    
    public void setModelObjTgt(final EObject pModelObjTgt) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fModelObjTgt = pModelObjTgt;
    }
    
    @Override
    public String patternName() {
      return "library.allConnectedEMFObjects";
    }
    
    @Override
    public List<String> parameterNames() {
      return AllConnectedEMFObjects.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fModelObjSrc, fModelObjTgt};
    }
    
    @Override
    public AllConnectedEMFObjects.Match toImmutable() {
      return isMutable() ? newMatch(fModelObjSrc, fModelObjTgt) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"modelObjSrc\"=" + prettyPrintValue(fModelObjSrc) + ", ");
      result.append("\"modelObjTgt\"=" + prettyPrintValue(fModelObjTgt));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fModelObjSrc, fModelObjTgt);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof AllConnectedEMFObjects.Match)) {
          AllConnectedEMFObjects.Match other = (AllConnectedEMFObjects.Match) obj;
          return Objects.equals(fModelObjSrc, other.fModelObjSrc) && Objects.equals(fModelObjTgt, other.fModelObjTgt);
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
    public AllConnectedEMFObjects specification() {
      return AllConnectedEMFObjects.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static AllConnectedEMFObjects.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pModelObjSrc the fixed value of pattern parameter modelObjSrc, or null if not bound.
     * @param pModelObjTgt the fixed value of pattern parameter modelObjTgt, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static AllConnectedEMFObjects.Match newMutableMatch(final EObject pModelObjSrc, final EObject pModelObjTgt) {
      return new Mutable(pModelObjSrc, pModelObjTgt);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pModelObjSrc the fixed value of pattern parameter modelObjSrc, or null if not bound.
     * @param pModelObjTgt the fixed value of pattern parameter modelObjTgt, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static AllConnectedEMFObjects.Match newMatch(final EObject pModelObjSrc, final EObject pModelObjTgt) {
      return new Immutable(pModelObjSrc, pModelObjTgt);
    }
    
    private static final class Mutable extends AllConnectedEMFObjects.Match {
      Mutable(final EObject pModelObjSrc, final EObject pModelObjTgt) {
        super(pModelObjSrc, pModelObjTgt);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends AllConnectedEMFObjects.Match {
      Immutable(final EObject pModelObjSrc, final EObject pModelObjTgt) {
        super(pModelObjSrc, pModelObjTgt);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the library.allConnectedEMFObjects pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern allConnectedEMFObjects(modelObjSrc: EObject,
   *                                modelObjTgt: EObject) {
   *   modelObjSrc != modelObjTgt;
   *   ModelElement.EMFInstanceObject(modelElemSrc, modelObjSrc);
   *   ModelElement.EMFInstanceObject(modelElemTgt, modelObjTgt);
   *   find allConnectedModelElems(modelElemSrc, modelElemTgt);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see AllConnectedEMFObjects
   * 
   */
  public static class Matcher extends BaseMatcher<AllConnectedEMFObjects.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static AllConnectedEMFObjects.Matcher on(final ViatraQueryEngine engine) {
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
    public static AllConnectedEMFObjects.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_MODELOBJSRC = 0;
    
    private static final int POSITION_MODELOBJTGT = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(AllConnectedEMFObjects.Matcher.class);
    
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
     * @param pModelObjSrc the fixed value of pattern parameter modelObjSrc, or null if not bound.
     * @param pModelObjTgt the fixed value of pattern parameter modelObjTgt, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<AllConnectedEMFObjects.Match> getAllMatches(final EObject pModelObjSrc, final EObject pModelObjTgt) {
      return rawStreamAllMatches(new Object[]{pModelObjSrc, pModelObjTgt}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pModelObjSrc the fixed value of pattern parameter modelObjSrc, or null if not bound.
     * @param pModelObjTgt the fixed value of pattern parameter modelObjTgt, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<AllConnectedEMFObjects.Match> streamAllMatches(final EObject pModelObjSrc, final EObject pModelObjTgt) {
      return rawStreamAllMatches(new Object[]{pModelObjSrc, pModelObjTgt});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pModelObjSrc the fixed value of pattern parameter modelObjSrc, or null if not bound.
     * @param pModelObjTgt the fixed value of pattern parameter modelObjTgt, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<AllConnectedEMFObjects.Match> getOneArbitraryMatch(final EObject pModelObjSrc, final EObject pModelObjTgt) {
      return rawGetOneArbitraryMatch(new Object[]{pModelObjSrc, pModelObjTgt});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pModelObjSrc the fixed value of pattern parameter modelObjSrc, or null if not bound.
     * @param pModelObjTgt the fixed value of pattern parameter modelObjTgt, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final EObject pModelObjSrc, final EObject pModelObjTgt) {
      return rawHasMatch(new Object[]{pModelObjSrc, pModelObjTgt});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pModelObjSrc the fixed value of pattern parameter modelObjSrc, or null if not bound.
     * @param pModelObjTgt the fixed value of pattern parameter modelObjTgt, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final EObject pModelObjSrc, final EObject pModelObjTgt) {
      return rawCountMatches(new Object[]{pModelObjSrc, pModelObjTgt});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pModelObjSrc the fixed value of pattern parameter modelObjSrc, or null if not bound.
     * @param pModelObjTgt the fixed value of pattern parameter modelObjTgt, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final EObject pModelObjSrc, final EObject pModelObjTgt, final Consumer<? super AllConnectedEMFObjects.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pModelObjSrc, pModelObjTgt}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pModelObjSrc the fixed value of pattern parameter modelObjSrc, or null if not bound.
     * @param pModelObjTgt the fixed value of pattern parameter modelObjTgt, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public AllConnectedEMFObjects.Match newMatch(final EObject pModelObjSrc, final EObject pModelObjTgt) {
      return AllConnectedEMFObjects.Match.newMatch(pModelObjSrc, pModelObjTgt);
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelObjSrc.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<EObject> rawStreamAllValuesOfmodelObjSrc(final Object[] parameters) {
      return rawStreamAllValues(POSITION_MODELOBJSRC, parameters).map(EObject.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelObjSrc.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<EObject> getAllValuesOfmodelObjSrc() {
      return rawStreamAllValuesOfmodelObjSrc(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelObjSrc.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<EObject> streamAllValuesOfmodelObjSrc() {
      return rawStreamAllValuesOfmodelObjSrc(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelObjSrc.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<EObject> streamAllValuesOfmodelObjSrc(final AllConnectedEMFObjects.Match partialMatch) {
      return rawStreamAllValuesOfmodelObjSrc(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelObjSrc.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<EObject> streamAllValuesOfmodelObjSrc(final EObject pModelObjTgt) {
      return rawStreamAllValuesOfmodelObjSrc(new Object[]{null, pModelObjTgt});
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelObjSrc.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<EObject> getAllValuesOfmodelObjSrc(final AllConnectedEMFObjects.Match partialMatch) {
      return rawStreamAllValuesOfmodelObjSrc(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelObjSrc.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<EObject> getAllValuesOfmodelObjSrc(final EObject pModelObjTgt) {
      return rawStreamAllValuesOfmodelObjSrc(new Object[]{null, pModelObjTgt}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelObjTgt.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<EObject> rawStreamAllValuesOfmodelObjTgt(final Object[] parameters) {
      return rawStreamAllValues(POSITION_MODELOBJTGT, parameters).map(EObject.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelObjTgt.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<EObject> getAllValuesOfmodelObjTgt() {
      return rawStreamAllValuesOfmodelObjTgt(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelObjTgt.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<EObject> streamAllValuesOfmodelObjTgt() {
      return rawStreamAllValuesOfmodelObjTgt(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelObjTgt.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<EObject> streamAllValuesOfmodelObjTgt(final AllConnectedEMFObjects.Match partialMatch) {
      return rawStreamAllValuesOfmodelObjTgt(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelObjTgt.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<EObject> streamAllValuesOfmodelObjTgt(final EObject pModelObjSrc) {
      return rawStreamAllValuesOfmodelObjTgt(new Object[]{pModelObjSrc, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelObjTgt.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<EObject> getAllValuesOfmodelObjTgt(final AllConnectedEMFObjects.Match partialMatch) {
      return rawStreamAllValuesOfmodelObjTgt(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for modelObjTgt.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<EObject> getAllValuesOfmodelObjTgt(final EObject pModelObjSrc) {
      return rawStreamAllValuesOfmodelObjTgt(new Object[]{pModelObjSrc, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected AllConnectedEMFObjects.Match tupleToMatch(final Tuple t) {
      try {
          return AllConnectedEMFObjects.Match.newMatch((EObject) t.get(POSITION_MODELOBJSRC), (EObject) t.get(POSITION_MODELOBJTGT));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected AllConnectedEMFObjects.Match arrayToMatch(final Object[] match) {
      try {
          return AllConnectedEMFObjects.Match.newMatch((EObject) match[POSITION_MODELOBJSRC], (EObject) match[POSITION_MODELOBJTGT]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected AllConnectedEMFObjects.Match arrayToMatchMutable(final Object[] match) {
      try {
          return AllConnectedEMFObjects.Match.newMutableMatch((EObject) match[POSITION_MODELOBJSRC], (EObject) match[POSITION_MODELOBJTGT]);
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
    public static IQuerySpecification<AllConnectedEMFObjects.Matcher> querySpecification() {
      return AllConnectedEMFObjects.instance();
    }
  }
  
  private AllConnectedEMFObjects() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static AllConnectedEMFObjects instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected AllConnectedEMFObjects.Matcher instantiate(final ViatraQueryEngine engine) {
    return AllConnectedEMFObjects.Matcher.on(engine);
  }
  
  @Override
  public AllConnectedEMFObjects.Matcher instantiate() {
    return AllConnectedEMFObjects.Matcher.create();
  }
  
  @Override
  public AllConnectedEMFObjects.Match newEmptyMatch() {
    return AllConnectedEMFObjects.Match.newEmptyMatch();
  }
  
  @Override
  public AllConnectedEMFObjects.Match newMatch(final Object... parameters) {
    return AllConnectedEMFObjects.Match.newMatch((org.eclipse.emf.ecore.EObject) parameters[0], (org.eclipse.emf.ecore.EObject) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link AllConnectedEMFObjects} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link AllConnectedEMFObjects#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final AllConnectedEMFObjects INSTANCE = new AllConnectedEMFObjects();
    
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
    private static final AllConnectedEMFObjects.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_modelObjSrc = new PParameter("modelObjSrc", "org.eclipse.emf.ecore.EObject", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/emf/2002/Ecore", "EObject")), PParameterDirection.INOUT);
    
    private final PParameter parameter_modelObjTgt = new PParameter("modelObjTgt", "org.eclipse.emf.ecore.EObject", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/emf/2002/Ecore", "EObject")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_modelObjSrc, parameter_modelObjTgt);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "library.allConnectedEMFObjects";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("modelObjSrc","modelObjTgt");
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
          PVariable var_modelObjSrc = body.getOrCreateVariableByName("modelObjSrc");
          PVariable var_modelObjTgt = body.getOrCreateVariableByName("modelObjTgt");
          PVariable var_modelElemSrc = body.getOrCreateVariableByName("modelElemSrc");
          PVariable var_modelElemTgt = body.getOrCreateVariableByName("modelElemTgt");
          new TypeConstraint(body, Tuples.flatTupleOf(var_modelObjSrc), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EObject")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_modelObjTgt), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EObject")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_modelObjSrc, parameter_modelObjSrc),
             new ExportedParameter(body, var_modelObjTgt, parameter_modelObjTgt)
          ));
          //   modelObjSrc != modelObjTgt
          new Inequality(body, var_modelObjSrc, var_modelObjTgt);
          //   ModelElement.EMFInstanceObject(modelElemSrc, modelObjSrc)
          new TypeConstraint(body, Tuples.flatTupleOf(var_modelElemSrc), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/mmint/MID", "ModelElement")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_modelElemSrc, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://se.cs.toronto.edu/mmint/MID", "ModelElement", "EMFInstanceObject")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EObject")));
          new Equality(body, var__virtual_0_, var_modelObjSrc);
          //   ModelElement.EMFInstanceObject(modelElemTgt, modelObjTgt)
          new TypeConstraint(body, Tuples.flatTupleOf(var_modelElemTgt), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/mmint/MID", "ModelElement")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_modelElemTgt, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://se.cs.toronto.edu/mmint/MID", "ModelElement", "EMFInstanceObject")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EObject")));
          new Equality(body, var__virtual_1_, var_modelObjTgt);
          //   find allConnectedModelElems(modelElemSrc, modelElemTgt)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_modelElemSrc, var_modelElemTgt), AllConnectedModelElems.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      return bodies;
    }
  }
}

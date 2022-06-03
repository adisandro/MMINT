/**
 * Generated from platform:/resource/edu.toronto.cs.se.mmint.viatra/src/edu/toronto/cs/se/mmint/viatra/mid/mid.vql
 */
package edu.toronto.cs.se.mmint.viatra.mid;

import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
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
 *         pattern connectedEMFObjectsWithMapping(modelObjSrc: EObject, modelObjTgt: EObject, mapping: Mapping) {
 *           modelObjSrc != modelObjTgt;
 *           ModelElement.EMFInstanceObject(modelElemSrc, modelObjSrc);
 *           ModelElement.EMFInstanceObject(modelElemTgt, modelObjTgt);
 *           find connectedModelElementsWithMapping(modelElemSrc, modelElemTgt, mapping);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class ConnectedEMFObjectsWithMapping extends BaseGeneratedEMFQuerySpecification<ConnectedEMFObjectsWithMapping.Matcher> {
  /**
   * Pattern-specific match representation of the edu.toronto.cs.se.mmint.viatra.mid.connectedEMFObjectsWithMapping pattern,
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

    private Mapping fMapping;

    private static List<String> parameterNames = makeImmutableList("modelObjSrc", "modelObjTgt", "mapping");

    private Match(final EObject pModelObjSrc, final EObject pModelObjTgt, final Mapping pMapping) {
      this.fModelObjSrc = pModelObjSrc;
      this.fModelObjTgt = pModelObjTgt;
      this.fMapping = pMapping;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "modelObjSrc": return this.fModelObjSrc;
          case "modelObjTgt": return this.fModelObjTgt;
          case "mapping": return this.fMapping;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fModelObjSrc;
          case 1: return this.fModelObjTgt;
          case 2: return this.fMapping;
          default: return null;
      }
    }

    public EObject getModelObjSrc() {
      return this.fModelObjSrc;
    }

    public EObject getModelObjTgt() {
      return this.fModelObjTgt;
    }

    public Mapping getMapping() {
      return this.fMapping;
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
      if ("mapping".equals(parameterName) ) {
          this.fMapping = (Mapping) newValue;
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

    public void setMapping(final Mapping pMapping) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fMapping = pMapping;
    }

    @Override
    public String patternName() {
      return "edu.toronto.cs.se.mmint.viatra.mid.connectedEMFObjectsWithMapping";
    }

    @Override
    public List<String> parameterNames() {
      return ConnectedEMFObjectsWithMapping.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fModelObjSrc, fModelObjTgt, fMapping};
    }

    @Override
    public ConnectedEMFObjectsWithMapping.Match toImmutable() {
      return isMutable() ? newMatch(fModelObjSrc, fModelObjTgt, fMapping) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"modelObjSrc\"=" + prettyPrintValue(fModelObjSrc) + ", ");
      result.append("\"modelObjTgt\"=" + prettyPrintValue(fModelObjTgt) + ", ");
      result.append("\"mapping\"=" + prettyPrintValue(fMapping));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fModelObjSrc, fModelObjTgt, fMapping);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof ConnectedEMFObjectsWithMapping.Match)) {
          ConnectedEMFObjectsWithMapping.Match other = (ConnectedEMFObjectsWithMapping.Match) obj;
          return Objects.equals(fModelObjSrc, other.fModelObjSrc) && Objects.equals(fModelObjTgt, other.fModelObjTgt) && Objects.equals(fMapping, other.fMapping);
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
    public ConnectedEMFObjectsWithMapping specification() {
      return ConnectedEMFObjectsWithMapping.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static ConnectedEMFObjectsWithMapping.Match newEmptyMatch() {
      return new Mutable(null, null, null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pModelObjSrc the fixed value of pattern parameter modelObjSrc, or null if not bound.
     * @param pModelObjTgt the fixed value of pattern parameter modelObjTgt, or null if not bound.
     * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static ConnectedEMFObjectsWithMapping.Match newMutableMatch(final EObject pModelObjSrc, final EObject pModelObjTgt, final Mapping pMapping) {
      return new Mutable(pModelObjSrc, pModelObjTgt, pMapping);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pModelObjSrc the fixed value of pattern parameter modelObjSrc, or null if not bound.
     * @param pModelObjTgt the fixed value of pattern parameter modelObjTgt, or null if not bound.
     * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static ConnectedEMFObjectsWithMapping.Match newMatch(final EObject pModelObjSrc, final EObject pModelObjTgt, final Mapping pMapping) {
      return new Immutable(pModelObjSrc, pModelObjTgt, pMapping);
    }

    private static final class Mutable extends ConnectedEMFObjectsWithMapping.Match {
      Mutable(final EObject pModelObjSrc, final EObject pModelObjTgt, final Mapping pMapping) {
        super(pModelObjSrc, pModelObjTgt, pMapping);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends ConnectedEMFObjectsWithMapping.Match {
      Immutable(final EObject pModelObjSrc, final EObject pModelObjTgt, final Mapping pMapping) {
        super(pModelObjSrc, pModelObjTgt, pMapping);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the edu.toronto.cs.se.mmint.viatra.mid.connectedEMFObjectsWithMapping pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern connectedEMFObjectsWithMapping(modelObjSrc: EObject, modelObjTgt: EObject, mapping: Mapping) {
   *   modelObjSrc != modelObjTgt;
   *   ModelElement.EMFInstanceObject(modelElemSrc, modelObjSrc);
   *   ModelElement.EMFInstanceObject(modelElemTgt, modelObjTgt);
   *   find connectedModelElementsWithMapping(modelElemSrc, modelElemTgt, mapping);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see ConnectedEMFObjectsWithMapping
   * 
   */
  public static class Matcher extends BaseMatcher<ConnectedEMFObjectsWithMapping.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static ConnectedEMFObjectsWithMapping.Matcher on(final ViatraQueryEngine engine) {
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
    public static ConnectedEMFObjectsWithMapping.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_MODELOBJSRC = 0;

    private static final int POSITION_MODELOBJTGT = 1;

    private static final int POSITION_MAPPING = 2;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(ConnectedEMFObjectsWithMapping.Matcher.class);

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
     * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<ConnectedEMFObjectsWithMapping.Match> getAllMatches(final EObject pModelObjSrc, final EObject pModelObjTgt, final Mapping pMapping) {
      return rawStreamAllMatches(new Object[]{pModelObjSrc, pModelObjTgt, pMapping}).collect(Collectors.toSet());
    }

    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pModelObjSrc the fixed value of pattern parameter modelObjSrc, or null if not bound.
     * @param pModelObjTgt the fixed value of pattern parameter modelObjTgt, or null if not bound.
     * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<ConnectedEMFObjectsWithMapping.Match> streamAllMatches(final EObject pModelObjSrc, final EObject pModelObjTgt, final Mapping pMapping) {
      return rawStreamAllMatches(new Object[]{pModelObjSrc, pModelObjTgt, pMapping});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pModelObjSrc the fixed value of pattern parameter modelObjSrc, or null if not bound.
     * @param pModelObjTgt the fixed value of pattern parameter modelObjTgt, or null if not bound.
     * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<ConnectedEMFObjectsWithMapping.Match> getOneArbitraryMatch(final EObject pModelObjSrc, final EObject pModelObjTgt, final Mapping pMapping) {
      return rawGetOneArbitraryMatch(new Object[]{pModelObjSrc, pModelObjTgt, pMapping});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pModelObjSrc the fixed value of pattern parameter modelObjSrc, or null if not bound.
     * @param pModelObjTgt the fixed value of pattern parameter modelObjTgt, or null if not bound.
     * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final EObject pModelObjSrc, final EObject pModelObjTgt, final Mapping pMapping) {
      return rawHasMatch(new Object[]{pModelObjSrc, pModelObjTgt, pMapping});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pModelObjSrc the fixed value of pattern parameter modelObjSrc, or null if not bound.
     * @param pModelObjTgt the fixed value of pattern parameter modelObjTgt, or null if not bound.
     * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final EObject pModelObjSrc, final EObject pModelObjTgt, final Mapping pMapping) {
      return rawCountMatches(new Object[]{pModelObjSrc, pModelObjTgt, pMapping});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pModelObjSrc the fixed value of pattern parameter modelObjSrc, or null if not bound.
     * @param pModelObjTgt the fixed value of pattern parameter modelObjTgt, or null if not bound.
     * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final EObject pModelObjSrc, final EObject pModelObjTgt, final Mapping pMapping, final Consumer<? super ConnectedEMFObjectsWithMapping.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pModelObjSrc, pModelObjTgt, pMapping}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pModelObjSrc the fixed value of pattern parameter modelObjSrc, or null if not bound.
     * @param pModelObjTgt the fixed value of pattern parameter modelObjTgt, or null if not bound.
     * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public ConnectedEMFObjectsWithMapping.Match newMatch(final EObject pModelObjSrc, final EObject pModelObjTgt, final Mapping pMapping) {
      return ConnectedEMFObjectsWithMapping.Match.newMatch(pModelObjSrc, pModelObjTgt, pMapping);
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
    public Stream<EObject> streamAllValuesOfmodelObjSrc(final ConnectedEMFObjectsWithMapping.Match partialMatch) {
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
    public Stream<EObject> streamAllValuesOfmodelObjSrc(final EObject pModelObjTgt, final Mapping pMapping) {
      return rawStreamAllValuesOfmodelObjSrc(new Object[]{null, pModelObjTgt, pMapping});
    }

    /**
     * Retrieve the set of values that occur in matches for modelObjSrc.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<EObject> getAllValuesOfmodelObjSrc(final ConnectedEMFObjectsWithMapping.Match partialMatch) {
      return rawStreamAllValuesOfmodelObjSrc(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for modelObjSrc.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<EObject> getAllValuesOfmodelObjSrc(final EObject pModelObjTgt, final Mapping pMapping) {
      return rawStreamAllValuesOfmodelObjSrc(new Object[]{null, pModelObjTgt, pMapping}).collect(Collectors.toSet());
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
    public Stream<EObject> streamAllValuesOfmodelObjTgt(final ConnectedEMFObjectsWithMapping.Match partialMatch) {
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
    public Stream<EObject> streamAllValuesOfmodelObjTgt(final EObject pModelObjSrc, final Mapping pMapping) {
      return rawStreamAllValuesOfmodelObjTgt(new Object[]{pModelObjSrc, null, pMapping});
    }

    /**
     * Retrieve the set of values that occur in matches for modelObjTgt.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<EObject> getAllValuesOfmodelObjTgt(final ConnectedEMFObjectsWithMapping.Match partialMatch) {
      return rawStreamAllValuesOfmodelObjTgt(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for modelObjTgt.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<EObject> getAllValuesOfmodelObjTgt(final EObject pModelObjSrc, final Mapping pMapping) {
      return rawStreamAllValuesOfmodelObjTgt(new Object[]{pModelObjSrc, null, pMapping}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for mapping.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Mapping> rawStreamAllValuesOfmapping(final Object[] parameters) {
      return rawStreamAllValues(POSITION_MAPPING, parameters).map(Mapping.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for mapping.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Mapping> getAllValuesOfmapping() {
      return rawStreamAllValuesOfmapping(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for mapping.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Mapping> streamAllValuesOfmapping() {
      return rawStreamAllValuesOfmapping(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for mapping.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Mapping> streamAllValuesOfmapping(final ConnectedEMFObjectsWithMapping.Match partialMatch) {
      return rawStreamAllValuesOfmapping(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for mapping.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Mapping> streamAllValuesOfmapping(final EObject pModelObjSrc, final EObject pModelObjTgt) {
      return rawStreamAllValuesOfmapping(new Object[]{pModelObjSrc, pModelObjTgt, null});
    }

    /**
     * Retrieve the set of values that occur in matches for mapping.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Mapping> getAllValuesOfmapping(final ConnectedEMFObjectsWithMapping.Match partialMatch) {
      return rawStreamAllValuesOfmapping(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for mapping.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Mapping> getAllValuesOfmapping(final EObject pModelObjSrc, final EObject pModelObjTgt) {
      return rawStreamAllValuesOfmapping(new Object[]{pModelObjSrc, pModelObjTgt, null}).collect(Collectors.toSet());
    }

    @Override
    protected ConnectedEMFObjectsWithMapping.Match tupleToMatch(final Tuple t) {
      try {
          return ConnectedEMFObjectsWithMapping.Match.newMatch((EObject) t.get(POSITION_MODELOBJSRC), (EObject) t.get(POSITION_MODELOBJTGT), (Mapping) t.get(POSITION_MAPPING));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected ConnectedEMFObjectsWithMapping.Match arrayToMatch(final Object[] match) {
      try {
          return ConnectedEMFObjectsWithMapping.Match.newMatch((EObject) match[POSITION_MODELOBJSRC], (EObject) match[POSITION_MODELOBJTGT], (Mapping) match[POSITION_MAPPING]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected ConnectedEMFObjectsWithMapping.Match arrayToMatchMutable(final Object[] match) {
      try {
          return ConnectedEMFObjectsWithMapping.Match.newMutableMatch((EObject) match[POSITION_MODELOBJSRC], (EObject) match[POSITION_MODELOBJTGT], (Mapping) match[POSITION_MAPPING]);
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
    public static IQuerySpecification<ConnectedEMFObjectsWithMapping.Matcher> querySpecification() {
      return ConnectedEMFObjectsWithMapping.instance();
    }
  }

  private ConnectedEMFObjectsWithMapping() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static ConnectedEMFObjectsWithMapping instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected ConnectedEMFObjectsWithMapping.Matcher instantiate(final ViatraQueryEngine engine) {
    return ConnectedEMFObjectsWithMapping.Matcher.on(engine);
  }

  @Override
  public ConnectedEMFObjectsWithMapping.Matcher instantiate() {
    return ConnectedEMFObjectsWithMapping.Matcher.create();
  }

  @Override
  public ConnectedEMFObjectsWithMapping.Match newEmptyMatch() {
    return ConnectedEMFObjectsWithMapping.Match.newEmptyMatch();
  }

  @Override
  public ConnectedEMFObjectsWithMapping.Match newMatch(final Object... parameters) {
    return ConnectedEMFObjectsWithMapping.Match.newMatch((org.eclipse.emf.ecore.EObject) parameters[0], (org.eclipse.emf.ecore.EObject) parameters[1], (edu.toronto.cs.se.mmint.mid.relationship.Mapping) parameters[2]);
  }

  /**
   * Inner class allowing the singleton instance of {@link ConnectedEMFObjectsWithMapping} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link ConnectedEMFObjectsWithMapping#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final ConnectedEMFObjectsWithMapping INSTANCE = new ConnectedEMFObjectsWithMapping();

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
    private static final ConnectedEMFObjectsWithMapping.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_modelObjSrc = new PParameter("modelObjSrc", "org.eclipse.emf.ecore.EObject", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/emf/2002/Ecore", "EObject")), PParameterDirection.INOUT);

    private final PParameter parameter_modelObjTgt = new PParameter("modelObjTgt", "org.eclipse.emf.ecore.EObject", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/emf/2002/Ecore", "EObject")), PParameterDirection.INOUT);

    private final PParameter parameter_mapping = new PParameter("mapping", "edu.toronto.cs.se.mmint.mid.relationship.Mapping", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://se.cs.toronto.edu/mmint/MID/Relationship", "Mapping")), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_modelObjSrc, parameter_modelObjTgt, parameter_mapping);

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "edu.toronto.cs.se.mmint.viatra.mid.connectedEMFObjectsWithMapping";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("modelObjSrc","modelObjTgt","mapping");
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
          PVariable var_mapping = body.getOrCreateVariableByName("mapping");
          PVariable var_modelElemSrc = body.getOrCreateVariableByName("modelElemSrc");
          PVariable var_modelElemTgt = body.getOrCreateVariableByName("modelElemTgt");
          new TypeConstraint(body, Tuples.flatTupleOf(var_modelObjSrc), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EObject")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_modelObjTgt), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EObject")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_mapping), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/mmint/MID/Relationship", "Mapping")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_modelObjSrc, parameter_modelObjSrc),
             new ExportedParameter(body, var_modelObjTgt, parameter_modelObjTgt),
             new ExportedParameter(body, var_mapping, parameter_mapping)
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
          //   find connectedModelElementsWithMapping(modelElemSrc, modelElemTgt, mapping)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_modelElemSrc, var_modelElemTgt, var_mapping), ConnectedModelElementsWithMapping.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      return bodies;
    }
  }
}

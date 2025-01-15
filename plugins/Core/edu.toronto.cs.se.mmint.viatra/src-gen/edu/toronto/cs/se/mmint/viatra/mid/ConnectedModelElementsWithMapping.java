/**
 * 
 *   Copyright (c) 2019, 2025 Alessio Di Sandro.
 *  
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License 2.0 which is available at
 *   https://www.eclipse.org/legal/epl-2.0/
 *  
 *   SPDX-License-Identifier: EPL-2.0
 *  
 *   Contributors:
 *       Alessio Di Sandro - Implementation
 *  
 */
package edu.toronto.cs.se.mmint.viatra.mid;

import edu.toronto.cs.se.mmint.mid.ModelElement;
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
 *         pattern connectedModelElementsWithMapping(modelElemSrc: ModelElement, modelElemTgt: ModelElement, mapping: Mapping) {
 *           modelElemSrc != modelElemTgt;
 *           Model.modelElems(modelSrc, modelElemSrc);
 *           Model.modelElems(modelTgt, modelElemTgt);
 *           modelSrc != modelTgt;
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
public final class ConnectedModelElementsWithMapping extends BaseGeneratedEMFQuerySpecification<ConnectedModelElementsWithMapping.Matcher> {
  /**
   * Pattern-specific match representation of the edu.toronto.cs.se.mmint.viatra.mid.connectedModelElementsWithMapping pattern,
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

    private Mapping fMapping;

    private static List<String> parameterNames = makeImmutableList("modelElemSrc", "modelElemTgt", "mapping");

    private Match(final ModelElement pModelElemSrc, final ModelElement pModelElemTgt, final Mapping pMapping) {
      this.fModelElemSrc = pModelElemSrc;
      this.fModelElemTgt = pModelElemTgt;
      this.fMapping = pMapping;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "modelElemSrc": return this.fModelElemSrc;
          case "modelElemTgt": return this.fModelElemTgt;
          case "mapping": return this.fMapping;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fModelElemSrc;
          case 1: return this.fModelElemTgt;
          case 2: return this.fMapping;
          default: return null;
      }
    }

    public ModelElement getModelElemSrc() {
      return this.fModelElemSrc;
    }

    public ModelElement getModelElemTgt() {
      return this.fModelElemTgt;
    }

    public Mapping getMapping() {
      return this.fMapping;
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
      if ("mapping".equals(parameterName) ) {
          this.fMapping = (Mapping) newValue;
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

    public void setMapping(final Mapping pMapping) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fMapping = pMapping;
    }

    @Override
    public String patternName() {
      return "edu.toronto.cs.se.mmint.viatra.mid.connectedModelElementsWithMapping";
    }

    @Override
    public List<String> parameterNames() {
      return ConnectedModelElementsWithMapping.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fModelElemSrc, fModelElemTgt, fMapping};
    }

    @Override
    public ConnectedModelElementsWithMapping.Match toImmutable() {
      return isMutable() ? newMatch(fModelElemSrc, fModelElemTgt, fMapping) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"modelElemSrc\"=" + prettyPrintValue(fModelElemSrc) + ", ");
      result.append("\"modelElemTgt\"=" + prettyPrintValue(fModelElemTgt) + ", ");
      result.append("\"mapping\"=" + prettyPrintValue(fMapping));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fModelElemSrc, fModelElemTgt, fMapping);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof ConnectedModelElementsWithMapping.Match)) {
          ConnectedModelElementsWithMapping.Match other = (ConnectedModelElementsWithMapping.Match) obj;
          return Objects.equals(fModelElemSrc, other.fModelElemSrc) && Objects.equals(fModelElemTgt, other.fModelElemTgt) && Objects.equals(fMapping, other.fMapping);
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
    public ConnectedModelElementsWithMapping specification() {
      return ConnectedModelElementsWithMapping.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static ConnectedModelElementsWithMapping.Match newEmptyMatch() {
      return new Mutable(null, null, null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pModelElemSrc the fixed value of pattern parameter modelElemSrc, or null if not bound.
     * @param pModelElemTgt the fixed value of pattern parameter modelElemTgt, or null if not bound.
     * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static ConnectedModelElementsWithMapping.Match newMutableMatch(final ModelElement pModelElemSrc, final ModelElement pModelElemTgt, final Mapping pMapping) {
      return new Mutable(pModelElemSrc, pModelElemTgt, pMapping);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pModelElemSrc the fixed value of pattern parameter modelElemSrc, or null if not bound.
     * @param pModelElemTgt the fixed value of pattern parameter modelElemTgt, or null if not bound.
     * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static ConnectedModelElementsWithMapping.Match newMatch(final ModelElement pModelElemSrc, final ModelElement pModelElemTgt, final Mapping pMapping) {
      return new Immutable(pModelElemSrc, pModelElemTgt, pMapping);
    }

    private static final class Mutable extends ConnectedModelElementsWithMapping.Match {
      Mutable(final ModelElement pModelElemSrc, final ModelElement pModelElemTgt, final Mapping pMapping) {
        super(pModelElemSrc, pModelElemTgt, pMapping);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends ConnectedModelElementsWithMapping.Match {
      Immutable(final ModelElement pModelElemSrc, final ModelElement pModelElemTgt, final Mapping pMapping) {
        super(pModelElemSrc, pModelElemTgt, pMapping);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the edu.toronto.cs.se.mmint.viatra.mid.connectedModelElementsWithMapping pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern connectedModelElementsWithMapping(modelElemSrc: ModelElement, modelElemTgt: ModelElement, mapping: Mapping) {
   *   modelElemSrc != modelElemTgt;
   *   Model.modelElems(modelSrc, modelElemSrc);
   *   Model.modelElems(modelTgt, modelElemTgt);
   *   modelSrc != modelTgt;
   *   Mapping.modelElemEndpoints.target(mapping, modelElemSrc);
   *   Mapping.modelElemEndpoints.target(mapping, modelElemTgt);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see ConnectedModelElementsWithMapping
   * 
   */
  public static class Matcher extends BaseMatcher<ConnectedModelElementsWithMapping.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static ConnectedModelElementsWithMapping.Matcher on(final ViatraQueryEngine engine) {
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
    public static ConnectedModelElementsWithMapping.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_MODELELEMSRC = 0;

    private static final int POSITION_MODELELEMTGT = 1;

    private static final int POSITION_MAPPING = 2;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(ConnectedModelElementsWithMapping.Matcher.class);

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
     * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<ConnectedModelElementsWithMapping.Match> getAllMatches(final ModelElement pModelElemSrc, final ModelElement pModelElemTgt, final Mapping pMapping) {
      return rawStreamAllMatches(new Object[]{pModelElemSrc, pModelElemTgt, pMapping}).collect(Collectors.toSet());
    }

    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pModelElemSrc the fixed value of pattern parameter modelElemSrc, or null if not bound.
     * @param pModelElemTgt the fixed value of pattern parameter modelElemTgt, or null if not bound.
     * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<ConnectedModelElementsWithMapping.Match> streamAllMatches(final ModelElement pModelElemSrc, final ModelElement pModelElemTgt, final Mapping pMapping) {
      return rawStreamAllMatches(new Object[]{pModelElemSrc, pModelElemTgt, pMapping});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pModelElemSrc the fixed value of pattern parameter modelElemSrc, or null if not bound.
     * @param pModelElemTgt the fixed value of pattern parameter modelElemTgt, or null if not bound.
     * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<ConnectedModelElementsWithMapping.Match> getOneArbitraryMatch(final ModelElement pModelElemSrc, final ModelElement pModelElemTgt, final Mapping pMapping) {
      return rawGetOneArbitraryMatch(new Object[]{pModelElemSrc, pModelElemTgt, pMapping});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pModelElemSrc the fixed value of pattern parameter modelElemSrc, or null if not bound.
     * @param pModelElemTgt the fixed value of pattern parameter modelElemTgt, or null if not bound.
     * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final ModelElement pModelElemSrc, final ModelElement pModelElemTgt, final Mapping pMapping) {
      return rawHasMatch(new Object[]{pModelElemSrc, pModelElemTgt, pMapping});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pModelElemSrc the fixed value of pattern parameter modelElemSrc, or null if not bound.
     * @param pModelElemTgt the fixed value of pattern parameter modelElemTgt, or null if not bound.
     * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final ModelElement pModelElemSrc, final ModelElement pModelElemTgt, final Mapping pMapping) {
      return rawCountMatches(new Object[]{pModelElemSrc, pModelElemTgt, pMapping});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pModelElemSrc the fixed value of pattern parameter modelElemSrc, or null if not bound.
     * @param pModelElemTgt the fixed value of pattern parameter modelElemTgt, or null if not bound.
     * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final ModelElement pModelElemSrc, final ModelElement pModelElemTgt, final Mapping pMapping, final Consumer<? super ConnectedModelElementsWithMapping.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pModelElemSrc, pModelElemTgt, pMapping}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pModelElemSrc the fixed value of pattern parameter modelElemSrc, or null if not bound.
     * @param pModelElemTgt the fixed value of pattern parameter modelElemTgt, or null if not bound.
     * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public ConnectedModelElementsWithMapping.Match newMatch(final ModelElement pModelElemSrc, final ModelElement pModelElemTgt, final Mapping pMapping) {
      return ConnectedModelElementsWithMapping.Match.newMatch(pModelElemSrc, pModelElemTgt, pMapping);
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
    public Stream<ModelElement> streamAllValuesOfmodelElemSrc(final ConnectedModelElementsWithMapping.Match partialMatch) {
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
    public Stream<ModelElement> streamAllValuesOfmodelElemSrc(final ModelElement pModelElemTgt, final Mapping pMapping) {
      return rawStreamAllValuesOfmodelElemSrc(new Object[]{null, pModelElemTgt, pMapping});
    }

    /**
     * Retrieve the set of values that occur in matches for modelElemSrc.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ModelElement> getAllValuesOfmodelElemSrc(final ConnectedModelElementsWithMapping.Match partialMatch) {
      return rawStreamAllValuesOfmodelElemSrc(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for modelElemSrc.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ModelElement> getAllValuesOfmodelElemSrc(final ModelElement pModelElemTgt, final Mapping pMapping) {
      return rawStreamAllValuesOfmodelElemSrc(new Object[]{null, pModelElemTgt, pMapping}).collect(Collectors.toSet());
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
    public Stream<ModelElement> streamAllValuesOfmodelElemTgt(final ConnectedModelElementsWithMapping.Match partialMatch) {
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
    public Stream<ModelElement> streamAllValuesOfmodelElemTgt(final ModelElement pModelElemSrc, final Mapping pMapping) {
      return rawStreamAllValuesOfmodelElemTgt(new Object[]{pModelElemSrc, null, pMapping});
    }

    /**
     * Retrieve the set of values that occur in matches for modelElemTgt.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ModelElement> getAllValuesOfmodelElemTgt(final ConnectedModelElementsWithMapping.Match partialMatch) {
      return rawStreamAllValuesOfmodelElemTgt(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for modelElemTgt.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ModelElement> getAllValuesOfmodelElemTgt(final ModelElement pModelElemSrc, final Mapping pMapping) {
      return rawStreamAllValuesOfmodelElemTgt(new Object[]{pModelElemSrc, null, pMapping}).collect(Collectors.toSet());
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
    public Stream<Mapping> streamAllValuesOfmapping(final ConnectedModelElementsWithMapping.Match partialMatch) {
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
    public Stream<Mapping> streamAllValuesOfmapping(final ModelElement pModelElemSrc, final ModelElement pModelElemTgt) {
      return rawStreamAllValuesOfmapping(new Object[]{pModelElemSrc, pModelElemTgt, null});
    }

    /**
     * Retrieve the set of values that occur in matches for mapping.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Mapping> getAllValuesOfmapping(final ConnectedModelElementsWithMapping.Match partialMatch) {
      return rawStreamAllValuesOfmapping(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for mapping.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Mapping> getAllValuesOfmapping(final ModelElement pModelElemSrc, final ModelElement pModelElemTgt) {
      return rawStreamAllValuesOfmapping(new Object[]{pModelElemSrc, pModelElemTgt, null}).collect(Collectors.toSet());
    }

    @Override
    protected ConnectedModelElementsWithMapping.Match tupleToMatch(final Tuple t) {
      try {
          return ConnectedModelElementsWithMapping.Match.newMatch((ModelElement) t.get(POSITION_MODELELEMSRC), (ModelElement) t.get(POSITION_MODELELEMTGT), (Mapping) t.get(POSITION_MAPPING));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected ConnectedModelElementsWithMapping.Match arrayToMatch(final Object[] match) {
      try {
          return ConnectedModelElementsWithMapping.Match.newMatch((ModelElement) match[POSITION_MODELELEMSRC], (ModelElement) match[POSITION_MODELELEMTGT], (Mapping) match[POSITION_MAPPING]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected ConnectedModelElementsWithMapping.Match arrayToMatchMutable(final Object[] match) {
      try {
          return ConnectedModelElementsWithMapping.Match.newMutableMatch((ModelElement) match[POSITION_MODELELEMSRC], (ModelElement) match[POSITION_MODELELEMTGT], (Mapping) match[POSITION_MAPPING]);
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
    public static IQuerySpecification<ConnectedModelElementsWithMapping.Matcher> querySpecification() {
      return ConnectedModelElementsWithMapping.instance();
    }
  }

  private ConnectedModelElementsWithMapping() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static ConnectedModelElementsWithMapping instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected ConnectedModelElementsWithMapping.Matcher instantiate(final ViatraQueryEngine engine) {
    return ConnectedModelElementsWithMapping.Matcher.on(engine);
  }

  @Override
  public ConnectedModelElementsWithMapping.Matcher instantiate() {
    return ConnectedModelElementsWithMapping.Matcher.create();
  }

  @Override
  public ConnectedModelElementsWithMapping.Match newEmptyMatch() {
    return ConnectedModelElementsWithMapping.Match.newEmptyMatch();
  }

  @Override
  public ConnectedModelElementsWithMapping.Match newMatch(final Object... parameters) {
    return ConnectedModelElementsWithMapping.Match.newMatch((ModelElement) parameters[0], (ModelElement) parameters[1], (Mapping) parameters[2]);
  }

  /**
   * Inner class allowing the singleton instance of {@link ConnectedModelElementsWithMapping} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link ConnectedModelElementsWithMapping#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final ConnectedModelElementsWithMapping INSTANCE = new ConnectedModelElementsWithMapping();

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
    private static final ConnectedModelElementsWithMapping.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_modelElemSrc = new PParameter("modelElemSrc", "edu.toronto.cs.se.mmint.mid.ModelElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://se.cs.toronto.edu/mmint/MID", "ModelElement")), PParameterDirection.INOUT);

    private final PParameter parameter_modelElemTgt = new PParameter("modelElemTgt", "edu.toronto.cs.se.mmint.mid.ModelElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://se.cs.toronto.edu/mmint/MID", "ModelElement")), PParameterDirection.INOUT);

    private final PParameter parameter_mapping = new PParameter("mapping", "edu.toronto.cs.se.mmint.mid.relationship.Mapping", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://se.cs.toronto.edu/mmint/MID/Relationship", "Mapping")), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_modelElemSrc, parameter_modelElemTgt, parameter_mapping);

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "edu.toronto.cs.se.mmint.viatra.mid.connectedModelElementsWithMapping";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("modelElemSrc","modelElemTgt","mapping");
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
          PVariable var_modelSrc = body.getOrCreateVariableByName("modelSrc");
          PVariable var_modelTgt = body.getOrCreateVariableByName("modelTgt");
          new TypeConstraint(body, Tuples.flatTupleOf(var_modelElemSrc), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/mmint/MID", "ModelElement")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_modelElemTgt), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/mmint/MID", "ModelElement")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_mapping), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/mmint/MID/Relationship", "Mapping")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_modelElemSrc, parameter_modelElemSrc),
             new ExportedParameter(body, var_modelElemTgt, parameter_modelElemTgt),
             new ExportedParameter(body, var_mapping, parameter_mapping)
          ));
          //   modelElemSrc != modelElemTgt
          new Inequality(body, var_modelElemSrc, var_modelElemTgt);
          //   Model.modelElems(modelSrc, modelElemSrc)
          new TypeConstraint(body, Tuples.flatTupleOf(var_modelSrc), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/mmint/MID", "Model")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_modelSrc, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://se.cs.toronto.edu/mmint/MID", "Model", "modelElems")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/mmint/MID", "ModelElement")));
          new Equality(body, var__virtual_0_, var_modelElemSrc);
          //   Model.modelElems(modelTgt, modelElemTgt)
          new TypeConstraint(body, Tuples.flatTupleOf(var_modelTgt), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/mmint/MID", "Model")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_modelTgt, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://se.cs.toronto.edu/mmint/MID", "Model", "modelElems")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/mmint/MID", "ModelElement")));
          new Equality(body, var__virtual_1_, var_modelElemTgt);
          //   modelSrc != modelTgt
          new Inequality(body, var_modelSrc, var_modelTgt);
          //   Mapping.modelElemEndpoints.target(mapping, modelElemSrc)
          new TypeConstraint(body, Tuples.flatTupleOf(var_mapping), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/mmint/MID/Relationship", "Mapping")));
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_mapping, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://se.cs.toronto.edu/mmint/MID/Relationship", "Mapping", "modelElemEndpoints")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/mmint/MID/Relationship", "ModelElementEndpoint")));
          PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://se.cs.toronto.edu/mmint/MID", "ExtendibleElementEndpoint", "target")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_3_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/mmint/MID", "ExtendibleElement")));
          new Equality(body, var__virtual_3_, var_modelElemSrc);
          //   Mapping.modelElemEndpoints.target(mapping, modelElemTgt)
          new TypeConstraint(body, Tuples.flatTupleOf(var_mapping), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/mmint/MID/Relationship", "Mapping")));
          PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_mapping, var__virtual_4_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://se.cs.toronto.edu/mmint/MID/Relationship", "Mapping", "modelElemEndpoints")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_4_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/mmint/MID/Relationship", "ModelElementEndpoint")));
          PVariable var__virtual_5_ = body.getOrCreateVariableByName(".virtual{5}");
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_4_, var__virtual_5_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://se.cs.toronto.edu/mmint/MID", "ExtendibleElementEndpoint", "target")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_5_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/mmint/MID", "ExtendibleElement")));
          new Equality(body, var__virtual_5_, var_modelElemTgt);
          bodies.add(body);
      }
      return bodies;
    }
  }
}

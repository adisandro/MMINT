/**
 * 
 *   Copyright (c) 2022, 2025 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.productline.viatra.tests;

import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.viatra.mid.ConnectedEMFObjectsWithMapping;
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
 *         pattern highlyConnectedModelObjsPL(modelObj: Class, otherModelObj: Class, mapping: Mapping) {
 *           find connectedEMFObjectsWithMapping(modelObj, otherModelObj, mapping);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class HighlyConnectedModelObjsPL extends BaseGeneratedEMFQuerySpecification<HighlyConnectedModelObjsPL.Matcher> {
  /**
   * Pattern-specific match representation of the edu.toronto.cs.se.mmint.productline.viatra.tests.highlyConnectedModelObjsPL pattern,
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
    private edu.toronto.cs.se.mmint.productline.Class fModelObj;

    private edu.toronto.cs.se.mmint.productline.Class fOtherModelObj;

    private Mapping fMapping;

    private static List<String> parameterNames = makeImmutableList("modelObj", "otherModelObj", "mapping");

    private Match(final edu.toronto.cs.se.mmint.productline.Class pModelObj, final edu.toronto.cs.se.mmint.productline.Class pOtherModelObj, final Mapping pMapping) {
      this.fModelObj = pModelObj;
      this.fOtherModelObj = pOtherModelObj;
      this.fMapping = pMapping;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "modelObj": return this.fModelObj;
          case "otherModelObj": return this.fOtherModelObj;
          case "mapping": return this.fMapping;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fModelObj;
          case 1: return this.fOtherModelObj;
          case 2: return this.fMapping;
          default: return null;
      }
    }

    public edu.toronto.cs.se.mmint.productline.Class getModelObj() {
      return this.fModelObj;
    }

    public edu.toronto.cs.se.mmint.productline.Class getOtherModelObj() {
      return this.fOtherModelObj;
    }

    public Mapping getMapping() {
      return this.fMapping;
    }

    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("modelObj".equals(parameterName) ) {
          this.fModelObj = (edu.toronto.cs.se.mmint.productline.Class) newValue;
          return true;
      }
      if ("otherModelObj".equals(parameterName) ) {
          this.fOtherModelObj = (edu.toronto.cs.se.mmint.productline.Class) newValue;
          return true;
      }
      if ("mapping".equals(parameterName) ) {
          this.fMapping = (Mapping) newValue;
          return true;
      }
      return false;
    }

    public void setModelObj(final edu.toronto.cs.se.mmint.productline.Class pModelObj) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fModelObj = pModelObj;
    }

    public void setOtherModelObj(final edu.toronto.cs.se.mmint.productline.Class pOtherModelObj) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fOtherModelObj = pOtherModelObj;
    }

    public void setMapping(final Mapping pMapping) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fMapping = pMapping;
    }

    @Override
    public String patternName() {
      return "edu.toronto.cs.se.mmint.productline.viatra.tests.highlyConnectedModelObjsPL";
    }

    @Override
    public List<String> parameterNames() {
      return HighlyConnectedModelObjsPL.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fModelObj, fOtherModelObj, fMapping};
    }

    @Override
    public HighlyConnectedModelObjsPL.Match toImmutable() {
      return isMutable() ? newMatch(fModelObj, fOtherModelObj, fMapping) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"modelObj\"=" + prettyPrintValue(fModelObj) + ", ");
      result.append("\"otherModelObj\"=" + prettyPrintValue(fOtherModelObj) + ", ");
      result.append("\"mapping\"=" + prettyPrintValue(fMapping));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fModelObj, fOtherModelObj, fMapping);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof HighlyConnectedModelObjsPL.Match)) {
          HighlyConnectedModelObjsPL.Match other = (HighlyConnectedModelObjsPL.Match) obj;
          return Objects.equals(fModelObj, other.fModelObj) && Objects.equals(fOtherModelObj, other.fOtherModelObj) && Objects.equals(fMapping, other.fMapping);
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
    public HighlyConnectedModelObjsPL specification() {
      return HighlyConnectedModelObjsPL.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static HighlyConnectedModelObjsPL.Match newEmptyMatch() {
      return new Mutable(null, null, null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pModelObj the fixed value of pattern parameter modelObj, or null if not bound.
     * @param pOtherModelObj the fixed value of pattern parameter otherModelObj, or null if not bound.
     * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static HighlyConnectedModelObjsPL.Match newMutableMatch(final edu.toronto.cs.se.mmint.productline.Class pModelObj, final edu.toronto.cs.se.mmint.productline.Class pOtherModelObj, final Mapping pMapping) {
      return new Mutable(pModelObj, pOtherModelObj, pMapping);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pModelObj the fixed value of pattern parameter modelObj, or null if not bound.
     * @param pOtherModelObj the fixed value of pattern parameter otherModelObj, or null if not bound.
     * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static HighlyConnectedModelObjsPL.Match newMatch(final edu.toronto.cs.se.mmint.productline.Class pModelObj, final edu.toronto.cs.se.mmint.productline.Class pOtherModelObj, final Mapping pMapping) {
      return new Immutable(pModelObj, pOtherModelObj, pMapping);
    }

    private static final class Mutable extends HighlyConnectedModelObjsPL.Match {
      Mutable(final edu.toronto.cs.se.mmint.productline.Class pModelObj, final edu.toronto.cs.se.mmint.productline.Class pOtherModelObj, final Mapping pMapping) {
        super(pModelObj, pOtherModelObj, pMapping);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends HighlyConnectedModelObjsPL.Match {
      Immutable(final edu.toronto.cs.se.mmint.productline.Class pModelObj, final edu.toronto.cs.se.mmint.productline.Class pOtherModelObj, final Mapping pMapping) {
        super(pModelObj, pOtherModelObj, pMapping);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the edu.toronto.cs.se.mmint.productline.viatra.tests.highlyConnectedModelObjsPL pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern highlyConnectedModelObjsPL(modelObj: Class, otherModelObj: Class, mapping: Mapping) {
   *   find connectedEMFObjectsWithMapping(modelObj, otherModelObj, mapping);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see HighlyConnectedModelObjsPL
   * 
   */
  public static class Matcher extends BaseMatcher<HighlyConnectedModelObjsPL.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static HighlyConnectedModelObjsPL.Matcher on(final ViatraQueryEngine engine) {
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
    public static HighlyConnectedModelObjsPL.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_MODELOBJ = 0;

    private static final int POSITION_OTHERMODELOBJ = 1;

    private static final int POSITION_MAPPING = 2;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(HighlyConnectedModelObjsPL.Matcher.class);

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
     * @param pModelObj the fixed value of pattern parameter modelObj, or null if not bound.
     * @param pOtherModelObj the fixed value of pattern parameter otherModelObj, or null if not bound.
     * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<HighlyConnectedModelObjsPL.Match> getAllMatches(final edu.toronto.cs.se.mmint.productline.Class pModelObj, final edu.toronto.cs.se.mmint.productline.Class pOtherModelObj, final Mapping pMapping) {
      return rawStreamAllMatches(new Object[]{pModelObj, pOtherModelObj, pMapping}).collect(Collectors.toSet());
    }

    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pModelObj the fixed value of pattern parameter modelObj, or null if not bound.
     * @param pOtherModelObj the fixed value of pattern parameter otherModelObj, or null if not bound.
     * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<HighlyConnectedModelObjsPL.Match> streamAllMatches(final edu.toronto.cs.se.mmint.productline.Class pModelObj, final edu.toronto.cs.se.mmint.productline.Class pOtherModelObj, final Mapping pMapping) {
      return rawStreamAllMatches(new Object[]{pModelObj, pOtherModelObj, pMapping});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pModelObj the fixed value of pattern parameter modelObj, or null if not bound.
     * @param pOtherModelObj the fixed value of pattern parameter otherModelObj, or null if not bound.
     * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<HighlyConnectedModelObjsPL.Match> getOneArbitraryMatch(final edu.toronto.cs.se.mmint.productline.Class pModelObj, final edu.toronto.cs.se.mmint.productline.Class pOtherModelObj, final Mapping pMapping) {
      return rawGetOneArbitraryMatch(new Object[]{pModelObj, pOtherModelObj, pMapping});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pModelObj the fixed value of pattern parameter modelObj, or null if not bound.
     * @param pOtherModelObj the fixed value of pattern parameter otherModelObj, or null if not bound.
     * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final edu.toronto.cs.se.mmint.productline.Class pModelObj, final edu.toronto.cs.se.mmint.productline.Class pOtherModelObj, final Mapping pMapping) {
      return rawHasMatch(new Object[]{pModelObj, pOtherModelObj, pMapping});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pModelObj the fixed value of pattern parameter modelObj, or null if not bound.
     * @param pOtherModelObj the fixed value of pattern parameter otherModelObj, or null if not bound.
     * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final edu.toronto.cs.se.mmint.productline.Class pModelObj, final edu.toronto.cs.se.mmint.productline.Class pOtherModelObj, final Mapping pMapping) {
      return rawCountMatches(new Object[]{pModelObj, pOtherModelObj, pMapping});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pModelObj the fixed value of pattern parameter modelObj, or null if not bound.
     * @param pOtherModelObj the fixed value of pattern parameter otherModelObj, or null if not bound.
     * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final edu.toronto.cs.se.mmint.productline.Class pModelObj, final edu.toronto.cs.se.mmint.productline.Class pOtherModelObj, final Mapping pMapping, final Consumer<? super HighlyConnectedModelObjsPL.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pModelObj, pOtherModelObj, pMapping}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pModelObj the fixed value of pattern parameter modelObj, or null if not bound.
     * @param pOtherModelObj the fixed value of pattern parameter otherModelObj, or null if not bound.
     * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public HighlyConnectedModelObjsPL.Match newMatch(final edu.toronto.cs.se.mmint.productline.Class pModelObj, final edu.toronto.cs.se.mmint.productline.Class pOtherModelObj, final Mapping pMapping) {
      return HighlyConnectedModelObjsPL.Match.newMatch(pModelObj, pOtherModelObj, pMapping);
    }

    /**
     * Retrieve the set of values that occur in matches for modelObj.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<edu.toronto.cs.se.mmint.productline.Class> rawStreamAllValuesOfmodelObj(final Object[] parameters) {
      return rawStreamAllValues(POSITION_MODELOBJ, parameters).map(edu.toronto.cs.se.mmint.productline.Class.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for modelObj.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Class> getAllValuesOfmodelObj() {
      return rawStreamAllValuesOfmodelObj(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for modelObj.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.mmint.productline.Class> streamAllValuesOfmodelObj() {
      return rawStreamAllValuesOfmodelObj(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for modelObj.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.mmint.productline.Class> streamAllValuesOfmodelObj(final HighlyConnectedModelObjsPL.Match partialMatch) {
      return rawStreamAllValuesOfmodelObj(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for modelObj.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.mmint.productline.Class> streamAllValuesOfmodelObj(final edu.toronto.cs.se.mmint.productline.Class pOtherModelObj, final Mapping pMapping) {
      return rawStreamAllValuesOfmodelObj(new Object[]{null, pOtherModelObj, pMapping});
    }

    /**
     * Retrieve the set of values that occur in matches for modelObj.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Class> getAllValuesOfmodelObj(final HighlyConnectedModelObjsPL.Match partialMatch) {
      return rawStreamAllValuesOfmodelObj(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for modelObj.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Class> getAllValuesOfmodelObj(final edu.toronto.cs.se.mmint.productline.Class pOtherModelObj, final Mapping pMapping) {
      return rawStreamAllValuesOfmodelObj(new Object[]{null, pOtherModelObj, pMapping}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for otherModelObj.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<edu.toronto.cs.se.mmint.productline.Class> rawStreamAllValuesOfotherModelObj(final Object[] parameters) {
      return rawStreamAllValues(POSITION_OTHERMODELOBJ, parameters).map(edu.toronto.cs.se.mmint.productline.Class.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for otherModelObj.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Class> getAllValuesOfotherModelObj() {
      return rawStreamAllValuesOfotherModelObj(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for otherModelObj.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.mmint.productline.Class> streamAllValuesOfotherModelObj() {
      return rawStreamAllValuesOfotherModelObj(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for otherModelObj.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.mmint.productline.Class> streamAllValuesOfotherModelObj(final HighlyConnectedModelObjsPL.Match partialMatch) {
      return rawStreamAllValuesOfotherModelObj(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for otherModelObj.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.mmint.productline.Class> streamAllValuesOfotherModelObj(final edu.toronto.cs.se.mmint.productline.Class pModelObj, final Mapping pMapping) {
      return rawStreamAllValuesOfotherModelObj(new Object[]{pModelObj, null, pMapping});
    }

    /**
     * Retrieve the set of values that occur in matches for otherModelObj.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Class> getAllValuesOfotherModelObj(final HighlyConnectedModelObjsPL.Match partialMatch) {
      return rawStreamAllValuesOfotherModelObj(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for otherModelObj.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Class> getAllValuesOfotherModelObj(final edu.toronto.cs.se.mmint.productline.Class pModelObj, final Mapping pMapping) {
      return rawStreamAllValuesOfotherModelObj(new Object[]{pModelObj, null, pMapping}).collect(Collectors.toSet());
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
    public Stream<Mapping> streamAllValuesOfmapping(final HighlyConnectedModelObjsPL.Match partialMatch) {
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
    public Stream<Mapping> streamAllValuesOfmapping(final edu.toronto.cs.se.mmint.productline.Class pModelObj, final edu.toronto.cs.se.mmint.productline.Class pOtherModelObj) {
      return rawStreamAllValuesOfmapping(new Object[]{pModelObj, pOtherModelObj, null});
    }

    /**
     * Retrieve the set of values that occur in matches for mapping.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Mapping> getAllValuesOfmapping(final HighlyConnectedModelObjsPL.Match partialMatch) {
      return rawStreamAllValuesOfmapping(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for mapping.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Mapping> getAllValuesOfmapping(final edu.toronto.cs.se.mmint.productline.Class pModelObj, final edu.toronto.cs.se.mmint.productline.Class pOtherModelObj) {
      return rawStreamAllValuesOfmapping(new Object[]{pModelObj, pOtherModelObj, null}).collect(Collectors.toSet());
    }

    @Override
    protected HighlyConnectedModelObjsPL.Match tupleToMatch(final Tuple t) {
      try {
          return HighlyConnectedModelObjsPL.Match.newMatch((edu.toronto.cs.se.mmint.productline.Class) t.get(POSITION_MODELOBJ), (edu.toronto.cs.se.mmint.productline.Class) t.get(POSITION_OTHERMODELOBJ), (Mapping) t.get(POSITION_MAPPING));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected HighlyConnectedModelObjsPL.Match arrayToMatch(final Object[] match) {
      try {
          return HighlyConnectedModelObjsPL.Match.newMatch((edu.toronto.cs.se.mmint.productline.Class) match[POSITION_MODELOBJ], (edu.toronto.cs.se.mmint.productline.Class) match[POSITION_OTHERMODELOBJ], (Mapping) match[POSITION_MAPPING]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected HighlyConnectedModelObjsPL.Match arrayToMatchMutable(final Object[] match) {
      try {
          return HighlyConnectedModelObjsPL.Match.newMutableMatch((edu.toronto.cs.se.mmint.productline.Class) match[POSITION_MODELOBJ], (edu.toronto.cs.se.mmint.productline.Class) match[POSITION_OTHERMODELOBJ], (Mapping) match[POSITION_MAPPING]);
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
    public static IQuerySpecification<HighlyConnectedModelObjsPL.Matcher> querySpecification() {
      return HighlyConnectedModelObjsPL.instance();
    }
  }

  private HighlyConnectedModelObjsPL() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static HighlyConnectedModelObjsPL instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected HighlyConnectedModelObjsPL.Matcher instantiate(final ViatraQueryEngine engine) {
    return HighlyConnectedModelObjsPL.Matcher.on(engine);
  }

  @Override
  public HighlyConnectedModelObjsPL.Matcher instantiate() {
    return HighlyConnectedModelObjsPL.Matcher.create();
  }

  @Override
  public HighlyConnectedModelObjsPL.Match newEmptyMatch() {
    return HighlyConnectedModelObjsPL.Match.newEmptyMatch();
  }

  @Override
  public HighlyConnectedModelObjsPL.Match newMatch(final Object... parameters) {
    return HighlyConnectedModelObjsPL.Match.newMatch((edu.toronto.cs.se.mmint.productline.Class) parameters[0], (edu.toronto.cs.se.mmint.productline.Class) parameters[1], (Mapping) parameters[2]);
  }

  /**
   * Inner class allowing the singleton instance of {@link HighlyConnectedModelObjsPL} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link HighlyConnectedModelObjsPL#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final HighlyConnectedModelObjsPL INSTANCE = new HighlyConnectedModelObjsPL();

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
    private static final HighlyConnectedModelObjsPL.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_modelObj = new PParameter("modelObj", "edu.toronto.cs.se.mmint.productline.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("model://edu.toronto.cs.se.mmint.productline", "Class")), PParameterDirection.INOUT);

    private final PParameter parameter_otherModelObj = new PParameter("otherModelObj", "edu.toronto.cs.se.mmint.productline.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("model://edu.toronto.cs.se.mmint.productline", "Class")), PParameterDirection.INOUT);

    private final PParameter parameter_mapping = new PParameter("mapping", "edu.toronto.cs.se.mmint.mid.relationship.Mapping", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://se.cs.toronto.edu/mmint/MID/Relationship", "Mapping")), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_modelObj, parameter_otherModelObj, parameter_mapping);

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "edu.toronto.cs.se.mmint.productline.viatra.tests.highlyConnectedModelObjsPL";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("modelObj","otherModelObj","mapping");
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
          PVariable var_modelObj = body.getOrCreateVariableByName("modelObj");
          PVariable var_otherModelObj = body.getOrCreateVariableByName("otherModelObj");
          PVariable var_mapping = body.getOrCreateVariableByName("mapping");
          new TypeConstraint(body, Tuples.flatTupleOf(var_modelObj), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "Class")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_otherModelObj), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "Class")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_mapping), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/mmint/MID/Relationship", "Mapping")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_modelObj, parameter_modelObj),
             new ExportedParameter(body, var_otherModelObj, parameter_otherModelObj),
             new ExportedParameter(body, var_mapping, parameter_mapping)
          ));
          //   find connectedEMFObjectsWithMapping(modelObj, otherModelObj, mapping)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_modelObj, var_otherModelObj, var_mapping), ConnectedEMFObjectsWithMapping.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      return bodies;
    }
  }
}

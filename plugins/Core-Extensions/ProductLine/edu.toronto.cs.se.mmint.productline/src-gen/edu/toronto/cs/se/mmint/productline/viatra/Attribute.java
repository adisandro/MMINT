/**
 * 
 *   Copyright (c) 2021, 2021 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.productline.viatra;

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
import org.eclipse.viatra.query.runtime.matchers.context.common.JavaTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.TypeFilterConstraint;
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
 *         pattern attribute(plElem: Class, elemType: java String,
 *                           plAttr: Attribute, attrType: java String, attrValue: java String) {
 *           find classType(plElem, elemType);
 *           Class.attributes(plElem, plAttr);
 *           Attribute.type.name(plAttr, attrType);
 *           Attribute.value(plAttr, attrValue);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class Attribute extends BaseGeneratedEMFQuerySpecification<Attribute.Matcher> {
  /**
   * Pattern-specific match representation of the edu.toronto.cs.se.mmint.productline.viatra.attribute pattern,
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
    private edu.toronto.cs.se.mmint.productline.Class fPlElem;
    
    private String fElemType;
    
    private edu.toronto.cs.se.mmint.productline.Attribute fPlAttr;
    
    private String fAttrType;
    
    private String fAttrValue;
    
    private static List<String> parameterNames = makeImmutableList("plElem", "elemType", "plAttr", "attrType", "attrValue");
    
    private Match(final edu.toronto.cs.se.mmint.productline.Class pPlElem, final String pElemType, final edu.toronto.cs.se.mmint.productline.Attribute pPlAttr, final String pAttrType, final String pAttrValue) {
      this.fPlElem = pPlElem;
      this.fElemType = pElemType;
      this.fPlAttr = pPlAttr;
      this.fAttrType = pAttrType;
      this.fAttrValue = pAttrValue;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "plElem": return this.fPlElem;
          case "elemType": return this.fElemType;
          case "plAttr": return this.fPlAttr;
          case "attrType": return this.fAttrType;
          case "attrValue": return this.fAttrValue;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fPlElem;
          case 1: return this.fElemType;
          case 2: return this.fPlAttr;
          case 3: return this.fAttrType;
          case 4: return this.fAttrValue;
          default: return null;
      }
    }
    
    public edu.toronto.cs.se.mmint.productline.Class getPlElem() {
      return this.fPlElem;
    }
    
    public String getElemType() {
      return this.fElemType;
    }
    
    public edu.toronto.cs.se.mmint.productline.Attribute getPlAttr() {
      return this.fPlAttr;
    }
    
    public String getAttrType() {
      return this.fAttrType;
    }
    
    public String getAttrValue() {
      return this.fAttrValue;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("plElem".equals(parameterName) ) {
          this.fPlElem = (edu.toronto.cs.se.mmint.productline.Class) newValue;
          return true;
      }
      if ("elemType".equals(parameterName) ) {
          this.fElemType = (String) newValue;
          return true;
      }
      if ("plAttr".equals(parameterName) ) {
          this.fPlAttr = (edu.toronto.cs.se.mmint.productline.Attribute) newValue;
          return true;
      }
      if ("attrType".equals(parameterName) ) {
          this.fAttrType = (String) newValue;
          return true;
      }
      if ("attrValue".equals(parameterName) ) {
          this.fAttrValue = (String) newValue;
          return true;
      }
      return false;
    }
    
    public void setPlElem(final edu.toronto.cs.se.mmint.productline.Class pPlElem) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fPlElem = pPlElem;
    }
    
    public void setElemType(final String pElemType) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fElemType = pElemType;
    }
    
    public void setPlAttr(final edu.toronto.cs.se.mmint.productline.Attribute pPlAttr) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fPlAttr = pPlAttr;
    }
    
    public void setAttrType(final String pAttrType) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fAttrType = pAttrType;
    }
    
    public void setAttrValue(final String pAttrValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fAttrValue = pAttrValue;
    }
    
    @Override
    public String patternName() {
      return "edu.toronto.cs.se.mmint.productline.viatra.attribute";
    }
    
    @Override
    public List<String> parameterNames() {
      return Attribute.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fPlElem, fElemType, fPlAttr, fAttrType, fAttrValue};
    }
    
    @Override
    public Attribute.Match toImmutable() {
      return isMutable() ? newMatch(fPlElem, fElemType, fPlAttr, fAttrType, fAttrValue) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"plElem\"=" + prettyPrintValue(fPlElem) + ", ");
      result.append("\"elemType\"=" + prettyPrintValue(fElemType) + ", ");
      result.append("\"plAttr\"=" + prettyPrintValue(fPlAttr) + ", ");
      result.append("\"attrType\"=" + prettyPrintValue(fAttrType) + ", ");
      result.append("\"attrValue\"=" + prettyPrintValue(fAttrValue));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fPlElem, fElemType, fPlAttr, fAttrType, fAttrValue);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof Attribute.Match)) {
          Attribute.Match other = (Attribute.Match) obj;
          return Objects.equals(fPlElem, other.fPlElem) && Objects.equals(fElemType, other.fElemType) && Objects.equals(fPlAttr, other.fPlAttr) && Objects.equals(fAttrType, other.fAttrType) && Objects.equals(fAttrValue, other.fAttrValue);
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
    public Attribute specification() {
      return Attribute.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static Attribute.Match newEmptyMatch() {
      return new Mutable(null, null, null, null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pPlElem the fixed value of pattern parameter plElem, or null if not bound.
     * @param pElemType the fixed value of pattern parameter elemType, or null if not bound.
     * @param pPlAttr the fixed value of pattern parameter plAttr, or null if not bound.
     * @param pAttrType the fixed value of pattern parameter attrType, or null if not bound.
     * @param pAttrValue the fixed value of pattern parameter attrValue, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static Attribute.Match newMutableMatch(final edu.toronto.cs.se.mmint.productline.Class pPlElem, final String pElemType, final edu.toronto.cs.se.mmint.productline.Attribute pPlAttr, final String pAttrType, final String pAttrValue) {
      return new Mutable(pPlElem, pElemType, pPlAttr, pAttrType, pAttrValue);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pPlElem the fixed value of pattern parameter plElem, or null if not bound.
     * @param pElemType the fixed value of pattern parameter elemType, or null if not bound.
     * @param pPlAttr the fixed value of pattern parameter plAttr, or null if not bound.
     * @param pAttrType the fixed value of pattern parameter attrType, or null if not bound.
     * @param pAttrValue the fixed value of pattern parameter attrValue, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static Attribute.Match newMatch(final edu.toronto.cs.se.mmint.productline.Class pPlElem, final String pElemType, final edu.toronto.cs.se.mmint.productline.Attribute pPlAttr, final String pAttrType, final String pAttrValue) {
      return new Immutable(pPlElem, pElemType, pPlAttr, pAttrType, pAttrValue);
    }
    
    private static final class Mutable extends Attribute.Match {
      Mutable(final edu.toronto.cs.se.mmint.productline.Class pPlElem, final String pElemType, final edu.toronto.cs.se.mmint.productline.Attribute pPlAttr, final String pAttrType, final String pAttrValue) {
        super(pPlElem, pElemType, pPlAttr, pAttrType, pAttrValue);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends Attribute.Match {
      Immutable(final edu.toronto.cs.se.mmint.productline.Class pPlElem, final String pElemType, final edu.toronto.cs.se.mmint.productline.Attribute pPlAttr, final String pAttrType, final String pAttrValue) {
        super(pPlElem, pElemType, pPlAttr, pAttrType, pAttrValue);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the edu.toronto.cs.se.mmint.productline.viatra.attribute pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern attribute(plElem: Class, elemType: java String,
   *                   plAttr: Attribute, attrType: java String, attrValue: java String) {
   *   find classType(plElem, elemType);
   *   Class.attributes(plElem, plAttr);
   *   Attribute.type.name(plAttr, attrType);
   *   Attribute.value(plAttr, attrValue);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see Attribute
   * 
   */
  public static class Matcher extends BaseMatcher<Attribute.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static Attribute.Matcher on(final ViatraQueryEngine engine) {
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
    public static Attribute.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_PLELEM = 0;
    
    private static final int POSITION_ELEMTYPE = 1;
    
    private static final int POSITION_PLATTR = 2;
    
    private static final int POSITION_ATTRTYPE = 3;
    
    private static final int POSITION_ATTRVALUE = 4;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(Attribute.Matcher.class);
    
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
     * @param pPlElem the fixed value of pattern parameter plElem, or null if not bound.
     * @param pElemType the fixed value of pattern parameter elemType, or null if not bound.
     * @param pPlAttr the fixed value of pattern parameter plAttr, or null if not bound.
     * @param pAttrType the fixed value of pattern parameter attrType, or null if not bound.
     * @param pAttrValue the fixed value of pattern parameter attrValue, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<Attribute.Match> getAllMatches(final edu.toronto.cs.se.mmint.productline.Class pPlElem, final String pElemType, final edu.toronto.cs.se.mmint.productline.Attribute pPlAttr, final String pAttrType, final String pAttrValue) {
      return rawStreamAllMatches(new Object[]{pPlElem, pElemType, pPlAttr, pAttrType, pAttrValue}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pPlElem the fixed value of pattern parameter plElem, or null if not bound.
     * @param pElemType the fixed value of pattern parameter elemType, or null if not bound.
     * @param pPlAttr the fixed value of pattern parameter plAttr, or null if not bound.
     * @param pAttrType the fixed value of pattern parameter attrType, or null if not bound.
     * @param pAttrValue the fixed value of pattern parameter attrValue, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<Attribute.Match> streamAllMatches(final edu.toronto.cs.se.mmint.productline.Class pPlElem, final String pElemType, final edu.toronto.cs.se.mmint.productline.Attribute pPlAttr, final String pAttrType, final String pAttrValue) {
      return rawStreamAllMatches(new Object[]{pPlElem, pElemType, pPlAttr, pAttrType, pAttrValue});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pPlElem the fixed value of pattern parameter plElem, or null if not bound.
     * @param pElemType the fixed value of pattern parameter elemType, or null if not bound.
     * @param pPlAttr the fixed value of pattern parameter plAttr, or null if not bound.
     * @param pAttrType the fixed value of pattern parameter attrType, or null if not bound.
     * @param pAttrValue the fixed value of pattern parameter attrValue, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<Attribute.Match> getOneArbitraryMatch(final edu.toronto.cs.se.mmint.productline.Class pPlElem, final String pElemType, final edu.toronto.cs.se.mmint.productline.Attribute pPlAttr, final String pAttrType, final String pAttrValue) {
      return rawGetOneArbitraryMatch(new Object[]{pPlElem, pElemType, pPlAttr, pAttrType, pAttrValue});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pPlElem the fixed value of pattern parameter plElem, or null if not bound.
     * @param pElemType the fixed value of pattern parameter elemType, or null if not bound.
     * @param pPlAttr the fixed value of pattern parameter plAttr, or null if not bound.
     * @param pAttrType the fixed value of pattern parameter attrType, or null if not bound.
     * @param pAttrValue the fixed value of pattern parameter attrValue, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final edu.toronto.cs.se.mmint.productline.Class pPlElem, final String pElemType, final edu.toronto.cs.se.mmint.productline.Attribute pPlAttr, final String pAttrType, final String pAttrValue) {
      return rawHasMatch(new Object[]{pPlElem, pElemType, pPlAttr, pAttrType, pAttrValue});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pPlElem the fixed value of pattern parameter plElem, or null if not bound.
     * @param pElemType the fixed value of pattern parameter elemType, or null if not bound.
     * @param pPlAttr the fixed value of pattern parameter plAttr, or null if not bound.
     * @param pAttrType the fixed value of pattern parameter attrType, or null if not bound.
     * @param pAttrValue the fixed value of pattern parameter attrValue, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final edu.toronto.cs.se.mmint.productline.Class pPlElem, final String pElemType, final edu.toronto.cs.se.mmint.productline.Attribute pPlAttr, final String pAttrType, final String pAttrValue) {
      return rawCountMatches(new Object[]{pPlElem, pElemType, pPlAttr, pAttrType, pAttrValue});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pPlElem the fixed value of pattern parameter plElem, or null if not bound.
     * @param pElemType the fixed value of pattern parameter elemType, or null if not bound.
     * @param pPlAttr the fixed value of pattern parameter plAttr, or null if not bound.
     * @param pAttrType the fixed value of pattern parameter attrType, or null if not bound.
     * @param pAttrValue the fixed value of pattern parameter attrValue, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final edu.toronto.cs.se.mmint.productline.Class pPlElem, final String pElemType, final edu.toronto.cs.se.mmint.productline.Attribute pPlAttr, final String pAttrType, final String pAttrValue, final Consumer<? super Attribute.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pPlElem, pElemType, pPlAttr, pAttrType, pAttrValue}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pPlElem the fixed value of pattern parameter plElem, or null if not bound.
     * @param pElemType the fixed value of pattern parameter elemType, or null if not bound.
     * @param pPlAttr the fixed value of pattern parameter plAttr, or null if not bound.
     * @param pAttrType the fixed value of pattern parameter attrType, or null if not bound.
     * @param pAttrValue the fixed value of pattern parameter attrValue, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public Attribute.Match newMatch(final edu.toronto.cs.se.mmint.productline.Class pPlElem, final String pElemType, final edu.toronto.cs.se.mmint.productline.Attribute pPlAttr, final String pAttrType, final String pAttrValue) {
      return Attribute.Match.newMatch(pPlElem, pElemType, pPlAttr, pAttrType, pAttrValue);
    }
    
    /**
     * Retrieve the set of values that occur in matches for plElem.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<edu.toronto.cs.se.mmint.productline.Class> rawStreamAllValuesOfplElem(final Object[] parameters) {
      return rawStreamAllValues(POSITION_PLELEM, parameters).map(edu.toronto.cs.se.mmint.productline.Class.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for plElem.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Class> getAllValuesOfplElem() {
      return rawStreamAllValuesOfplElem(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plElem.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.mmint.productline.Class> streamAllValuesOfplElem() {
      return rawStreamAllValuesOfplElem(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plElem.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.mmint.productline.Class> streamAllValuesOfplElem(final Attribute.Match partialMatch) {
      return rawStreamAllValuesOfplElem(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plElem.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.mmint.productline.Class> streamAllValuesOfplElem(final String pElemType, final edu.toronto.cs.se.mmint.productline.Attribute pPlAttr, final String pAttrType, final String pAttrValue) {
      return rawStreamAllValuesOfplElem(new Object[]{null, pElemType, pPlAttr, pAttrType, pAttrValue});
    }
    
    /**
     * Retrieve the set of values that occur in matches for plElem.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Class> getAllValuesOfplElem(final Attribute.Match partialMatch) {
      return rawStreamAllValuesOfplElem(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plElem.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Class> getAllValuesOfplElem(final String pElemType, final edu.toronto.cs.se.mmint.productline.Attribute pPlAttr, final String pAttrType, final String pAttrValue) {
      return rawStreamAllValuesOfplElem(new Object[]{null, pElemType, pPlAttr, pAttrType, pAttrValue}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for elemType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<String> rawStreamAllValuesOfelemType(final Object[] parameters) {
      return rawStreamAllValues(POSITION_ELEMTYPE, parameters).map(String.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for elemType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfelemType() {
      return rawStreamAllValuesOfelemType(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for elemType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfelemType() {
      return rawStreamAllValuesOfelemType(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for elemType.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfelemType(final Attribute.Match partialMatch) {
      return rawStreamAllValuesOfelemType(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for elemType.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfelemType(final edu.toronto.cs.se.mmint.productline.Class pPlElem, final edu.toronto.cs.se.mmint.productline.Attribute pPlAttr, final String pAttrType, final String pAttrValue) {
      return rawStreamAllValuesOfelemType(new Object[]{pPlElem, null, pPlAttr, pAttrType, pAttrValue});
    }
    
    /**
     * Retrieve the set of values that occur in matches for elemType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfelemType(final Attribute.Match partialMatch) {
      return rawStreamAllValuesOfelemType(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for elemType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfelemType(final edu.toronto.cs.se.mmint.productline.Class pPlElem, final edu.toronto.cs.se.mmint.productline.Attribute pPlAttr, final String pAttrType, final String pAttrValue) {
      return rawStreamAllValuesOfelemType(new Object[]{pPlElem, null, pPlAttr, pAttrType, pAttrValue}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plAttr.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<edu.toronto.cs.se.mmint.productline.Attribute> rawStreamAllValuesOfplAttr(final Object[] parameters) {
      return rawStreamAllValues(POSITION_PLATTR, parameters).map(edu.toronto.cs.se.mmint.productline.Attribute.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for plAttr.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Attribute> getAllValuesOfplAttr() {
      return rawStreamAllValuesOfplAttr(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plAttr.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.mmint.productline.Attribute> streamAllValuesOfplAttr() {
      return rawStreamAllValuesOfplAttr(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plAttr.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.mmint.productline.Attribute> streamAllValuesOfplAttr(final Attribute.Match partialMatch) {
      return rawStreamAllValuesOfplAttr(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plAttr.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.mmint.productline.Attribute> streamAllValuesOfplAttr(final edu.toronto.cs.se.mmint.productline.Class pPlElem, final String pElemType, final String pAttrType, final String pAttrValue) {
      return rawStreamAllValuesOfplAttr(new Object[]{pPlElem, pElemType, null, pAttrType, pAttrValue});
    }
    
    /**
     * Retrieve the set of values that occur in matches for plAttr.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Attribute> getAllValuesOfplAttr(final Attribute.Match partialMatch) {
      return rawStreamAllValuesOfplAttr(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plAttr.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Attribute> getAllValuesOfplAttr(final edu.toronto.cs.se.mmint.productline.Class pPlElem, final String pElemType, final String pAttrType, final String pAttrValue) {
      return rawStreamAllValuesOfplAttr(new Object[]{pPlElem, pElemType, null, pAttrType, pAttrValue}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for attrType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<String> rawStreamAllValuesOfattrType(final Object[] parameters) {
      return rawStreamAllValues(POSITION_ATTRTYPE, parameters).map(String.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for attrType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfattrType() {
      return rawStreamAllValuesOfattrType(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for attrType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfattrType() {
      return rawStreamAllValuesOfattrType(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for attrType.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfattrType(final Attribute.Match partialMatch) {
      return rawStreamAllValuesOfattrType(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for attrType.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfattrType(final edu.toronto.cs.se.mmint.productline.Class pPlElem, final String pElemType, final edu.toronto.cs.se.mmint.productline.Attribute pPlAttr, final String pAttrValue) {
      return rawStreamAllValuesOfattrType(new Object[]{pPlElem, pElemType, pPlAttr, null, pAttrValue});
    }
    
    /**
     * Retrieve the set of values that occur in matches for attrType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfattrType(final Attribute.Match partialMatch) {
      return rawStreamAllValuesOfattrType(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for attrType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfattrType(final edu.toronto.cs.se.mmint.productline.Class pPlElem, final String pElemType, final edu.toronto.cs.se.mmint.productline.Attribute pPlAttr, final String pAttrValue) {
      return rawStreamAllValuesOfattrType(new Object[]{pPlElem, pElemType, pPlAttr, null, pAttrValue}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for attrValue.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<String> rawStreamAllValuesOfattrValue(final Object[] parameters) {
      return rawStreamAllValues(POSITION_ATTRVALUE, parameters).map(String.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for attrValue.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfattrValue() {
      return rawStreamAllValuesOfattrValue(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for attrValue.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfattrValue() {
      return rawStreamAllValuesOfattrValue(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for attrValue.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfattrValue(final Attribute.Match partialMatch) {
      return rawStreamAllValuesOfattrValue(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for attrValue.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfattrValue(final edu.toronto.cs.se.mmint.productline.Class pPlElem, final String pElemType, final edu.toronto.cs.se.mmint.productline.Attribute pPlAttr, final String pAttrType) {
      return rawStreamAllValuesOfattrValue(new Object[]{pPlElem, pElemType, pPlAttr, pAttrType, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for attrValue.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfattrValue(final Attribute.Match partialMatch) {
      return rawStreamAllValuesOfattrValue(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for attrValue.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfattrValue(final edu.toronto.cs.se.mmint.productline.Class pPlElem, final String pElemType, final edu.toronto.cs.se.mmint.productline.Attribute pPlAttr, final String pAttrType) {
      return rawStreamAllValuesOfattrValue(new Object[]{pPlElem, pElemType, pPlAttr, pAttrType, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected Attribute.Match tupleToMatch(final Tuple t) {
      try {
          return Attribute.Match.newMatch((edu.toronto.cs.se.mmint.productline.Class) t.get(POSITION_PLELEM), (String) t.get(POSITION_ELEMTYPE), (edu.toronto.cs.se.mmint.productline.Attribute) t.get(POSITION_PLATTR), (String) t.get(POSITION_ATTRTYPE), (String) t.get(POSITION_ATTRVALUE));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected Attribute.Match arrayToMatch(final Object[] match) {
      try {
          return Attribute.Match.newMatch((edu.toronto.cs.se.mmint.productline.Class) match[POSITION_PLELEM], (String) match[POSITION_ELEMTYPE], (edu.toronto.cs.se.mmint.productline.Attribute) match[POSITION_PLATTR], (String) match[POSITION_ATTRTYPE], (String) match[POSITION_ATTRVALUE]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected Attribute.Match arrayToMatchMutable(final Object[] match) {
      try {
          return Attribute.Match.newMutableMatch((edu.toronto.cs.se.mmint.productline.Class) match[POSITION_PLELEM], (String) match[POSITION_ELEMTYPE], (edu.toronto.cs.se.mmint.productline.Attribute) match[POSITION_PLATTR], (String) match[POSITION_ATTRTYPE], (String) match[POSITION_ATTRVALUE]);
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
    public static IQuerySpecification<Attribute.Matcher> querySpecification() {
      return Attribute.instance();
    }
  }
  
  private Attribute() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static Attribute instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected Attribute.Matcher instantiate(final ViatraQueryEngine engine) {
    return Attribute.Matcher.on(engine);
  }
  
  @Override
  public Attribute.Matcher instantiate() {
    return Attribute.Matcher.create();
  }
  
  @Override
  public Attribute.Match newEmptyMatch() {
    return Attribute.Match.newEmptyMatch();
  }
  
  @Override
  public Attribute.Match newMatch(final Object... parameters) {
    return Attribute.Match.newMatch((edu.toronto.cs.se.mmint.productline.Class) parameters[0], (java.lang.String) parameters[1], (edu.toronto.cs.se.mmint.productline.Attribute) parameters[2], (java.lang.String) parameters[3], (java.lang.String) parameters[4]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link Attribute} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link Attribute#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final Attribute INSTANCE = new Attribute();
    
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
    private static final Attribute.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_plElem = new PParameter("plElem", "edu.toronto.cs.se.mmint.productline.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("model://edu.toronto.cs.se.mmint.productline", "Class")), PParameterDirection.INOUT);
    
    private final PParameter parameter_elemType = new PParameter("elemType", "java.lang.String", new JavaTransitiveInstancesKey(java.lang.String.class), PParameterDirection.INOUT);
    
    private final PParameter parameter_plAttr = new PParameter("plAttr", "edu.toronto.cs.se.mmint.productline.Attribute", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("model://edu.toronto.cs.se.mmint.productline", "Attribute")), PParameterDirection.INOUT);
    
    private final PParameter parameter_attrType = new PParameter("attrType", "java.lang.String", new JavaTransitiveInstancesKey(java.lang.String.class), PParameterDirection.INOUT);
    
    private final PParameter parameter_attrValue = new PParameter("attrValue", "java.lang.String", new JavaTransitiveInstancesKey(java.lang.String.class), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_plElem, parameter_elemType, parameter_plAttr, parameter_attrType, parameter_attrValue);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "edu.toronto.cs.se.mmint.productline.viatra.attribute";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("plElem","elemType","plAttr","attrType","attrValue");
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
          PVariable var_plElem = body.getOrCreateVariableByName("plElem");
          PVariable var_elemType = body.getOrCreateVariableByName("elemType");
          PVariable var_plAttr = body.getOrCreateVariableByName("plAttr");
          PVariable var_attrType = body.getOrCreateVariableByName("attrType");
          PVariable var_attrValue = body.getOrCreateVariableByName("attrValue");
          new TypeConstraint(body, Tuples.flatTupleOf(var_plElem), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "Class")));
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_elemType), new JavaTransitiveInstancesKey(java.lang.String.class));
          new TypeConstraint(body, Tuples.flatTupleOf(var_plAttr), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "Attribute")));
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_attrType), new JavaTransitiveInstancesKey(java.lang.String.class));
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_attrValue), new JavaTransitiveInstancesKey(java.lang.String.class));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_plElem, parameter_plElem),
             new ExportedParameter(body, var_elemType, parameter_elemType),
             new ExportedParameter(body, var_plAttr, parameter_plAttr),
             new ExportedParameter(body, var_attrType, parameter_attrType),
             new ExportedParameter(body, var_attrValue, parameter_attrValue)
          ));
          //   find classType(plElem, elemType)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_plElem, var_elemType), ClassType.instance().getInternalQueryRepresentation());
          //   Class.attributes(plElem, plAttr)
          new TypeConstraint(body, Tuples.flatTupleOf(var_plElem), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "Class")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_plElem, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("model://edu.toronto.cs.se.mmint.productline", "Class", "attributes")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "Attribute")));
          new Equality(body, var__virtual_0_, var_plAttr);
          //   Attribute.type.name(plAttr, attrType)
          new TypeConstraint(body, Tuples.flatTupleOf(var_plAttr), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "Attribute")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_plAttr, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("model://edu.toronto.cs.se.mmint.productline", "Attribute", "type")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EAttribute")));
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/emf/2002/Ecore", "ENamedElement", "name")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EString")));
          new Equality(body, var__virtual_2_, var_attrType);
          //   Attribute.value(plAttr, attrValue)
          new TypeConstraint(body, Tuples.flatTupleOf(var_plAttr), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "Attribute")));
          PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_plAttr, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("model://edu.toronto.cs.se.mmint.productline", "Attribute", "value")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_3_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EString")));
          new Equality(body, var__virtual_3_, var_attrValue);
          bodies.add(body);
      }
      return bodies;
    }
  }
}

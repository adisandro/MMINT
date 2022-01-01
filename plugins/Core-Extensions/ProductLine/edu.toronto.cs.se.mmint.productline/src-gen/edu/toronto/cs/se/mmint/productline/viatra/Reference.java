/**
 * 
 *   Copyright (c) 2021, 2022 Alessio Di Sandro.
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
 *         pattern reference(plSrc: Class, srcType: java String, plDst: Class, dstType: java String,
 *                           plRef: Reference, refType: java String) {
 *           find classType(plSrc, srcType);
 *           Class.referencesAsSource(plSrc, plRef);
 *           Reference.type.name(plRef, refType);
 *           Reference.targets(plRef, plDst);
 *           find classType(plDst, dstType);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class Reference extends BaseGeneratedEMFQuerySpecification<Reference.Matcher> {
  /**
   * Pattern-specific match representation of the edu.toronto.cs.se.mmint.productline.viatra.reference pattern,
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
    private edu.toronto.cs.se.mmint.productline.Class fPlSrc;
    
    private String fSrcType;
    
    private edu.toronto.cs.se.mmint.productline.Class fPlDst;
    
    private String fDstType;
    
    private edu.toronto.cs.se.mmint.productline.Reference fPlRef;
    
    private String fRefType;
    
    private static List<String> parameterNames = makeImmutableList("plSrc", "srcType", "plDst", "dstType", "plRef", "refType");
    
    private Match(final edu.toronto.cs.se.mmint.productline.Class pPlSrc, final String pSrcType, final edu.toronto.cs.se.mmint.productline.Class pPlDst, final String pDstType, final edu.toronto.cs.se.mmint.productline.Reference pPlRef, final String pRefType) {
      this.fPlSrc = pPlSrc;
      this.fSrcType = pSrcType;
      this.fPlDst = pPlDst;
      this.fDstType = pDstType;
      this.fPlRef = pPlRef;
      this.fRefType = pRefType;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "plSrc": return this.fPlSrc;
          case "srcType": return this.fSrcType;
          case "plDst": return this.fPlDst;
          case "dstType": return this.fDstType;
          case "plRef": return this.fPlRef;
          case "refType": return this.fRefType;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fPlSrc;
          case 1: return this.fSrcType;
          case 2: return this.fPlDst;
          case 3: return this.fDstType;
          case 4: return this.fPlRef;
          case 5: return this.fRefType;
          default: return null;
      }
    }
    
    public edu.toronto.cs.se.mmint.productline.Class getPlSrc() {
      return this.fPlSrc;
    }
    
    public String getSrcType() {
      return this.fSrcType;
    }
    
    public edu.toronto.cs.se.mmint.productline.Class getPlDst() {
      return this.fPlDst;
    }
    
    public String getDstType() {
      return this.fDstType;
    }
    
    public edu.toronto.cs.se.mmint.productline.Reference getPlRef() {
      return this.fPlRef;
    }
    
    public String getRefType() {
      return this.fRefType;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("plSrc".equals(parameterName) ) {
          this.fPlSrc = (edu.toronto.cs.se.mmint.productline.Class) newValue;
          return true;
      }
      if ("srcType".equals(parameterName) ) {
          this.fSrcType = (String) newValue;
          return true;
      }
      if ("plDst".equals(parameterName) ) {
          this.fPlDst = (edu.toronto.cs.se.mmint.productline.Class) newValue;
          return true;
      }
      if ("dstType".equals(parameterName) ) {
          this.fDstType = (String) newValue;
          return true;
      }
      if ("plRef".equals(parameterName) ) {
          this.fPlRef = (edu.toronto.cs.se.mmint.productline.Reference) newValue;
          return true;
      }
      if ("refType".equals(parameterName) ) {
          this.fRefType = (String) newValue;
          return true;
      }
      return false;
    }
    
    public void setPlSrc(final edu.toronto.cs.se.mmint.productline.Class pPlSrc) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fPlSrc = pPlSrc;
    }
    
    public void setSrcType(final String pSrcType) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fSrcType = pSrcType;
    }
    
    public void setPlDst(final edu.toronto.cs.se.mmint.productline.Class pPlDst) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fPlDst = pPlDst;
    }
    
    public void setDstType(final String pDstType) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fDstType = pDstType;
    }
    
    public void setPlRef(final edu.toronto.cs.se.mmint.productline.Reference pPlRef) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fPlRef = pPlRef;
    }
    
    public void setRefType(final String pRefType) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fRefType = pRefType;
    }
    
    @Override
    public String patternName() {
      return "edu.toronto.cs.se.mmint.productline.viatra.reference";
    }
    
    @Override
    public List<String> parameterNames() {
      return Reference.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fPlSrc, fSrcType, fPlDst, fDstType, fPlRef, fRefType};
    }
    
    @Override
    public Reference.Match toImmutable() {
      return isMutable() ? newMatch(fPlSrc, fSrcType, fPlDst, fDstType, fPlRef, fRefType) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"plSrc\"=" + prettyPrintValue(fPlSrc) + ", ");
      result.append("\"srcType\"=" + prettyPrintValue(fSrcType) + ", ");
      result.append("\"plDst\"=" + prettyPrintValue(fPlDst) + ", ");
      result.append("\"dstType\"=" + prettyPrintValue(fDstType) + ", ");
      result.append("\"plRef\"=" + prettyPrintValue(fPlRef) + ", ");
      result.append("\"refType\"=" + prettyPrintValue(fRefType));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fPlSrc, fSrcType, fPlDst, fDstType, fPlRef, fRefType);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof Reference.Match)) {
          Reference.Match other = (Reference.Match) obj;
          return Objects.equals(fPlSrc, other.fPlSrc) && Objects.equals(fSrcType, other.fSrcType) && Objects.equals(fPlDst, other.fPlDst) && Objects.equals(fDstType, other.fDstType) && Objects.equals(fPlRef, other.fPlRef) && Objects.equals(fRefType, other.fRefType);
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
    public Reference specification() {
      return Reference.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static Reference.Match newEmptyMatch() {
      return new Mutable(null, null, null, null, null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pPlSrc the fixed value of pattern parameter plSrc, or null if not bound.
     * @param pSrcType the fixed value of pattern parameter srcType, or null if not bound.
     * @param pPlDst the fixed value of pattern parameter plDst, or null if not bound.
     * @param pDstType the fixed value of pattern parameter dstType, or null if not bound.
     * @param pPlRef the fixed value of pattern parameter plRef, or null if not bound.
     * @param pRefType the fixed value of pattern parameter refType, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static Reference.Match newMutableMatch(final edu.toronto.cs.se.mmint.productline.Class pPlSrc, final String pSrcType, final edu.toronto.cs.se.mmint.productline.Class pPlDst, final String pDstType, final edu.toronto.cs.se.mmint.productline.Reference pPlRef, final String pRefType) {
      return new Mutable(pPlSrc, pSrcType, pPlDst, pDstType, pPlRef, pRefType);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pPlSrc the fixed value of pattern parameter plSrc, or null if not bound.
     * @param pSrcType the fixed value of pattern parameter srcType, or null if not bound.
     * @param pPlDst the fixed value of pattern parameter plDst, or null if not bound.
     * @param pDstType the fixed value of pattern parameter dstType, or null if not bound.
     * @param pPlRef the fixed value of pattern parameter plRef, or null if not bound.
     * @param pRefType the fixed value of pattern parameter refType, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static Reference.Match newMatch(final edu.toronto.cs.se.mmint.productline.Class pPlSrc, final String pSrcType, final edu.toronto.cs.se.mmint.productline.Class pPlDst, final String pDstType, final edu.toronto.cs.se.mmint.productline.Reference pPlRef, final String pRefType) {
      return new Immutable(pPlSrc, pSrcType, pPlDst, pDstType, pPlRef, pRefType);
    }
    
    private static final class Mutable extends Reference.Match {
      Mutable(final edu.toronto.cs.se.mmint.productline.Class pPlSrc, final String pSrcType, final edu.toronto.cs.se.mmint.productline.Class pPlDst, final String pDstType, final edu.toronto.cs.se.mmint.productline.Reference pPlRef, final String pRefType) {
        super(pPlSrc, pSrcType, pPlDst, pDstType, pPlRef, pRefType);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends Reference.Match {
      Immutable(final edu.toronto.cs.se.mmint.productline.Class pPlSrc, final String pSrcType, final edu.toronto.cs.se.mmint.productline.Class pPlDst, final String pDstType, final edu.toronto.cs.se.mmint.productline.Reference pPlRef, final String pRefType) {
        super(pPlSrc, pSrcType, pPlDst, pDstType, pPlRef, pRefType);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the edu.toronto.cs.se.mmint.productline.viatra.reference pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern reference(plSrc: Class, srcType: java String, plDst: Class, dstType: java String,
   *                   plRef: Reference, refType: java String) {
   *   find classType(plSrc, srcType);
   *   Class.referencesAsSource(plSrc, plRef);
   *   Reference.type.name(plRef, refType);
   *   Reference.targets(plRef, plDst);
   *   find classType(plDst, dstType);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see Reference
   * 
   */
  public static class Matcher extends BaseMatcher<Reference.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static Reference.Matcher on(final ViatraQueryEngine engine) {
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
    public static Reference.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_PLSRC = 0;
    
    private static final int POSITION_SRCTYPE = 1;
    
    private static final int POSITION_PLDST = 2;
    
    private static final int POSITION_DSTTYPE = 3;
    
    private static final int POSITION_PLREF = 4;
    
    private static final int POSITION_REFTYPE = 5;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(Reference.Matcher.class);
    
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
     * @param pPlSrc the fixed value of pattern parameter plSrc, or null if not bound.
     * @param pSrcType the fixed value of pattern parameter srcType, or null if not bound.
     * @param pPlDst the fixed value of pattern parameter plDst, or null if not bound.
     * @param pDstType the fixed value of pattern parameter dstType, or null if not bound.
     * @param pPlRef the fixed value of pattern parameter plRef, or null if not bound.
     * @param pRefType the fixed value of pattern parameter refType, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<Reference.Match> getAllMatches(final edu.toronto.cs.se.mmint.productline.Class pPlSrc, final String pSrcType, final edu.toronto.cs.se.mmint.productline.Class pPlDst, final String pDstType, final edu.toronto.cs.se.mmint.productline.Reference pPlRef, final String pRefType) {
      return rawStreamAllMatches(new Object[]{pPlSrc, pSrcType, pPlDst, pDstType, pPlRef, pRefType}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pPlSrc the fixed value of pattern parameter plSrc, or null if not bound.
     * @param pSrcType the fixed value of pattern parameter srcType, or null if not bound.
     * @param pPlDst the fixed value of pattern parameter plDst, or null if not bound.
     * @param pDstType the fixed value of pattern parameter dstType, or null if not bound.
     * @param pPlRef the fixed value of pattern parameter plRef, or null if not bound.
     * @param pRefType the fixed value of pattern parameter refType, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<Reference.Match> streamAllMatches(final edu.toronto.cs.se.mmint.productline.Class pPlSrc, final String pSrcType, final edu.toronto.cs.se.mmint.productline.Class pPlDst, final String pDstType, final edu.toronto.cs.se.mmint.productline.Reference pPlRef, final String pRefType) {
      return rawStreamAllMatches(new Object[]{pPlSrc, pSrcType, pPlDst, pDstType, pPlRef, pRefType});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pPlSrc the fixed value of pattern parameter plSrc, or null if not bound.
     * @param pSrcType the fixed value of pattern parameter srcType, or null if not bound.
     * @param pPlDst the fixed value of pattern parameter plDst, or null if not bound.
     * @param pDstType the fixed value of pattern parameter dstType, or null if not bound.
     * @param pPlRef the fixed value of pattern parameter plRef, or null if not bound.
     * @param pRefType the fixed value of pattern parameter refType, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<Reference.Match> getOneArbitraryMatch(final edu.toronto.cs.se.mmint.productline.Class pPlSrc, final String pSrcType, final edu.toronto.cs.se.mmint.productline.Class pPlDst, final String pDstType, final edu.toronto.cs.se.mmint.productline.Reference pPlRef, final String pRefType) {
      return rawGetOneArbitraryMatch(new Object[]{pPlSrc, pSrcType, pPlDst, pDstType, pPlRef, pRefType});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pPlSrc the fixed value of pattern parameter plSrc, or null if not bound.
     * @param pSrcType the fixed value of pattern parameter srcType, or null if not bound.
     * @param pPlDst the fixed value of pattern parameter plDst, or null if not bound.
     * @param pDstType the fixed value of pattern parameter dstType, or null if not bound.
     * @param pPlRef the fixed value of pattern parameter plRef, or null if not bound.
     * @param pRefType the fixed value of pattern parameter refType, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final edu.toronto.cs.se.mmint.productline.Class pPlSrc, final String pSrcType, final edu.toronto.cs.se.mmint.productline.Class pPlDst, final String pDstType, final edu.toronto.cs.se.mmint.productline.Reference pPlRef, final String pRefType) {
      return rawHasMatch(new Object[]{pPlSrc, pSrcType, pPlDst, pDstType, pPlRef, pRefType});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pPlSrc the fixed value of pattern parameter plSrc, or null if not bound.
     * @param pSrcType the fixed value of pattern parameter srcType, or null if not bound.
     * @param pPlDst the fixed value of pattern parameter plDst, or null if not bound.
     * @param pDstType the fixed value of pattern parameter dstType, or null if not bound.
     * @param pPlRef the fixed value of pattern parameter plRef, or null if not bound.
     * @param pRefType the fixed value of pattern parameter refType, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final edu.toronto.cs.se.mmint.productline.Class pPlSrc, final String pSrcType, final edu.toronto.cs.se.mmint.productline.Class pPlDst, final String pDstType, final edu.toronto.cs.se.mmint.productline.Reference pPlRef, final String pRefType) {
      return rawCountMatches(new Object[]{pPlSrc, pSrcType, pPlDst, pDstType, pPlRef, pRefType});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pPlSrc the fixed value of pattern parameter plSrc, or null if not bound.
     * @param pSrcType the fixed value of pattern parameter srcType, or null if not bound.
     * @param pPlDst the fixed value of pattern parameter plDst, or null if not bound.
     * @param pDstType the fixed value of pattern parameter dstType, or null if not bound.
     * @param pPlRef the fixed value of pattern parameter plRef, or null if not bound.
     * @param pRefType the fixed value of pattern parameter refType, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final edu.toronto.cs.se.mmint.productline.Class pPlSrc, final String pSrcType, final edu.toronto.cs.se.mmint.productline.Class pPlDst, final String pDstType, final edu.toronto.cs.se.mmint.productline.Reference pPlRef, final String pRefType, final Consumer<? super Reference.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pPlSrc, pSrcType, pPlDst, pDstType, pPlRef, pRefType}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pPlSrc the fixed value of pattern parameter plSrc, or null if not bound.
     * @param pSrcType the fixed value of pattern parameter srcType, or null if not bound.
     * @param pPlDst the fixed value of pattern parameter plDst, or null if not bound.
     * @param pDstType the fixed value of pattern parameter dstType, or null if not bound.
     * @param pPlRef the fixed value of pattern parameter plRef, or null if not bound.
     * @param pRefType the fixed value of pattern parameter refType, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public Reference.Match newMatch(final edu.toronto.cs.se.mmint.productline.Class pPlSrc, final String pSrcType, final edu.toronto.cs.se.mmint.productline.Class pPlDst, final String pDstType, final edu.toronto.cs.se.mmint.productline.Reference pPlRef, final String pRefType) {
      return Reference.Match.newMatch(pPlSrc, pSrcType, pPlDst, pDstType, pPlRef, pRefType);
    }
    
    /**
     * Retrieve the set of values that occur in matches for plSrc.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<edu.toronto.cs.se.mmint.productline.Class> rawStreamAllValuesOfplSrc(final Object[] parameters) {
      return rawStreamAllValues(POSITION_PLSRC, parameters).map(edu.toronto.cs.se.mmint.productline.Class.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for plSrc.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Class> getAllValuesOfplSrc() {
      return rawStreamAllValuesOfplSrc(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plSrc.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.mmint.productline.Class> streamAllValuesOfplSrc() {
      return rawStreamAllValuesOfplSrc(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plSrc.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.mmint.productline.Class> streamAllValuesOfplSrc(final Reference.Match partialMatch) {
      return rawStreamAllValuesOfplSrc(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plSrc.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.mmint.productline.Class> streamAllValuesOfplSrc(final String pSrcType, final edu.toronto.cs.se.mmint.productline.Class pPlDst, final String pDstType, final edu.toronto.cs.se.mmint.productline.Reference pPlRef, final String pRefType) {
      return rawStreamAllValuesOfplSrc(new Object[]{null, pSrcType, pPlDst, pDstType, pPlRef, pRefType});
    }
    
    /**
     * Retrieve the set of values that occur in matches for plSrc.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Class> getAllValuesOfplSrc(final Reference.Match partialMatch) {
      return rawStreamAllValuesOfplSrc(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plSrc.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Class> getAllValuesOfplSrc(final String pSrcType, final edu.toronto.cs.se.mmint.productline.Class pPlDst, final String pDstType, final edu.toronto.cs.se.mmint.productline.Reference pPlRef, final String pRefType) {
      return rawStreamAllValuesOfplSrc(new Object[]{null, pSrcType, pPlDst, pDstType, pPlRef, pRefType}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for srcType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<String> rawStreamAllValuesOfsrcType(final Object[] parameters) {
      return rawStreamAllValues(POSITION_SRCTYPE, parameters).map(String.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for srcType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfsrcType() {
      return rawStreamAllValuesOfsrcType(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for srcType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfsrcType() {
      return rawStreamAllValuesOfsrcType(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for srcType.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfsrcType(final Reference.Match partialMatch) {
      return rawStreamAllValuesOfsrcType(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for srcType.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfsrcType(final edu.toronto.cs.se.mmint.productline.Class pPlSrc, final edu.toronto.cs.se.mmint.productline.Class pPlDst, final String pDstType, final edu.toronto.cs.se.mmint.productline.Reference pPlRef, final String pRefType) {
      return rawStreamAllValuesOfsrcType(new Object[]{pPlSrc, null, pPlDst, pDstType, pPlRef, pRefType});
    }
    
    /**
     * Retrieve the set of values that occur in matches for srcType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfsrcType(final Reference.Match partialMatch) {
      return rawStreamAllValuesOfsrcType(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for srcType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfsrcType(final edu.toronto.cs.se.mmint.productline.Class pPlSrc, final edu.toronto.cs.se.mmint.productline.Class pPlDst, final String pDstType, final edu.toronto.cs.se.mmint.productline.Reference pPlRef, final String pRefType) {
      return rawStreamAllValuesOfsrcType(new Object[]{pPlSrc, null, pPlDst, pDstType, pPlRef, pRefType}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plDst.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<edu.toronto.cs.se.mmint.productline.Class> rawStreamAllValuesOfplDst(final Object[] parameters) {
      return rawStreamAllValues(POSITION_PLDST, parameters).map(edu.toronto.cs.se.mmint.productline.Class.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for plDst.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Class> getAllValuesOfplDst() {
      return rawStreamAllValuesOfplDst(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plDst.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.mmint.productline.Class> streamAllValuesOfplDst() {
      return rawStreamAllValuesOfplDst(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plDst.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.mmint.productline.Class> streamAllValuesOfplDst(final Reference.Match partialMatch) {
      return rawStreamAllValuesOfplDst(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plDst.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.mmint.productline.Class> streamAllValuesOfplDst(final edu.toronto.cs.se.mmint.productline.Class pPlSrc, final String pSrcType, final String pDstType, final edu.toronto.cs.se.mmint.productline.Reference pPlRef, final String pRefType) {
      return rawStreamAllValuesOfplDst(new Object[]{pPlSrc, pSrcType, null, pDstType, pPlRef, pRefType});
    }
    
    /**
     * Retrieve the set of values that occur in matches for plDst.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Class> getAllValuesOfplDst(final Reference.Match partialMatch) {
      return rawStreamAllValuesOfplDst(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plDst.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Class> getAllValuesOfplDst(final edu.toronto.cs.se.mmint.productline.Class pPlSrc, final String pSrcType, final String pDstType, final edu.toronto.cs.se.mmint.productline.Reference pPlRef, final String pRefType) {
      return rawStreamAllValuesOfplDst(new Object[]{pPlSrc, pSrcType, null, pDstType, pPlRef, pRefType}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for dstType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<String> rawStreamAllValuesOfdstType(final Object[] parameters) {
      return rawStreamAllValues(POSITION_DSTTYPE, parameters).map(String.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for dstType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfdstType() {
      return rawStreamAllValuesOfdstType(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for dstType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfdstType() {
      return rawStreamAllValuesOfdstType(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for dstType.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfdstType(final Reference.Match partialMatch) {
      return rawStreamAllValuesOfdstType(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for dstType.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfdstType(final edu.toronto.cs.se.mmint.productline.Class pPlSrc, final String pSrcType, final edu.toronto.cs.se.mmint.productline.Class pPlDst, final edu.toronto.cs.se.mmint.productline.Reference pPlRef, final String pRefType) {
      return rawStreamAllValuesOfdstType(new Object[]{pPlSrc, pSrcType, pPlDst, null, pPlRef, pRefType});
    }
    
    /**
     * Retrieve the set of values that occur in matches for dstType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfdstType(final Reference.Match partialMatch) {
      return rawStreamAllValuesOfdstType(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for dstType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfdstType(final edu.toronto.cs.se.mmint.productline.Class pPlSrc, final String pSrcType, final edu.toronto.cs.se.mmint.productline.Class pPlDst, final edu.toronto.cs.se.mmint.productline.Reference pPlRef, final String pRefType) {
      return rawStreamAllValuesOfdstType(new Object[]{pPlSrc, pSrcType, pPlDst, null, pPlRef, pRefType}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plRef.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<edu.toronto.cs.se.mmint.productline.Reference> rawStreamAllValuesOfplRef(final Object[] parameters) {
      return rawStreamAllValues(POSITION_PLREF, parameters).map(edu.toronto.cs.se.mmint.productline.Reference.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for plRef.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Reference> getAllValuesOfplRef() {
      return rawStreamAllValuesOfplRef(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plRef.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.mmint.productline.Reference> streamAllValuesOfplRef() {
      return rawStreamAllValuesOfplRef(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plRef.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.mmint.productline.Reference> streamAllValuesOfplRef(final Reference.Match partialMatch) {
      return rawStreamAllValuesOfplRef(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plRef.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.mmint.productline.Reference> streamAllValuesOfplRef(final edu.toronto.cs.se.mmint.productline.Class pPlSrc, final String pSrcType, final edu.toronto.cs.se.mmint.productline.Class pPlDst, final String pDstType, final String pRefType) {
      return rawStreamAllValuesOfplRef(new Object[]{pPlSrc, pSrcType, pPlDst, pDstType, null, pRefType});
    }
    
    /**
     * Retrieve the set of values that occur in matches for plRef.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Reference> getAllValuesOfplRef(final Reference.Match partialMatch) {
      return rawStreamAllValuesOfplRef(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plRef.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Reference> getAllValuesOfplRef(final edu.toronto.cs.se.mmint.productline.Class pPlSrc, final String pSrcType, final edu.toronto.cs.se.mmint.productline.Class pPlDst, final String pDstType, final String pRefType) {
      return rawStreamAllValuesOfplRef(new Object[]{pPlSrc, pSrcType, pPlDst, pDstType, null, pRefType}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for refType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<String> rawStreamAllValuesOfrefType(final Object[] parameters) {
      return rawStreamAllValues(POSITION_REFTYPE, parameters).map(String.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for refType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfrefType() {
      return rawStreamAllValuesOfrefType(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for refType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfrefType() {
      return rawStreamAllValuesOfrefType(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for refType.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfrefType(final Reference.Match partialMatch) {
      return rawStreamAllValuesOfrefType(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for refType.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfrefType(final edu.toronto.cs.se.mmint.productline.Class pPlSrc, final String pSrcType, final edu.toronto.cs.se.mmint.productline.Class pPlDst, final String pDstType, final edu.toronto.cs.se.mmint.productline.Reference pPlRef) {
      return rawStreamAllValuesOfrefType(new Object[]{pPlSrc, pSrcType, pPlDst, pDstType, pPlRef, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for refType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfrefType(final Reference.Match partialMatch) {
      return rawStreamAllValuesOfrefType(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for refType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfrefType(final edu.toronto.cs.se.mmint.productline.Class pPlSrc, final String pSrcType, final edu.toronto.cs.se.mmint.productline.Class pPlDst, final String pDstType, final edu.toronto.cs.se.mmint.productline.Reference pPlRef) {
      return rawStreamAllValuesOfrefType(new Object[]{pPlSrc, pSrcType, pPlDst, pDstType, pPlRef, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected Reference.Match tupleToMatch(final Tuple t) {
      try {
          return Reference.Match.newMatch((edu.toronto.cs.se.mmint.productline.Class) t.get(POSITION_PLSRC), (String) t.get(POSITION_SRCTYPE), (edu.toronto.cs.se.mmint.productline.Class) t.get(POSITION_PLDST), (String) t.get(POSITION_DSTTYPE), (edu.toronto.cs.se.mmint.productline.Reference) t.get(POSITION_PLREF), (String) t.get(POSITION_REFTYPE));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected Reference.Match arrayToMatch(final Object[] match) {
      try {
          return Reference.Match.newMatch((edu.toronto.cs.se.mmint.productline.Class) match[POSITION_PLSRC], (String) match[POSITION_SRCTYPE], (edu.toronto.cs.se.mmint.productline.Class) match[POSITION_PLDST], (String) match[POSITION_DSTTYPE], (edu.toronto.cs.se.mmint.productline.Reference) match[POSITION_PLREF], (String) match[POSITION_REFTYPE]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected Reference.Match arrayToMatchMutable(final Object[] match) {
      try {
          return Reference.Match.newMutableMatch((edu.toronto.cs.se.mmint.productline.Class) match[POSITION_PLSRC], (String) match[POSITION_SRCTYPE], (edu.toronto.cs.se.mmint.productline.Class) match[POSITION_PLDST], (String) match[POSITION_DSTTYPE], (edu.toronto.cs.se.mmint.productline.Reference) match[POSITION_PLREF], (String) match[POSITION_REFTYPE]);
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
    public static IQuerySpecification<Reference.Matcher> querySpecification() {
      return Reference.instance();
    }
  }
  
  private Reference() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static Reference instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected Reference.Matcher instantiate(final ViatraQueryEngine engine) {
    return Reference.Matcher.on(engine);
  }
  
  @Override
  public Reference.Matcher instantiate() {
    return Reference.Matcher.create();
  }
  
  @Override
  public Reference.Match newEmptyMatch() {
    return Reference.Match.newEmptyMatch();
  }
  
  @Override
  public Reference.Match newMatch(final Object... parameters) {
    return Reference.Match.newMatch((edu.toronto.cs.se.mmint.productline.Class) parameters[0], (java.lang.String) parameters[1], (edu.toronto.cs.se.mmint.productline.Class) parameters[2], (java.lang.String) parameters[3], (edu.toronto.cs.se.mmint.productline.Reference) parameters[4], (java.lang.String) parameters[5]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link Reference} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link Reference#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final Reference INSTANCE = new Reference();
    
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
    private static final Reference.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_plSrc = new PParameter("plSrc", "edu.toronto.cs.se.mmint.productline.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("model://edu.toronto.cs.se.mmint.productline", "Class")), PParameterDirection.INOUT);
    
    private final PParameter parameter_srcType = new PParameter("srcType", "java.lang.String", new JavaTransitiveInstancesKey(java.lang.String.class), PParameterDirection.INOUT);
    
    private final PParameter parameter_plDst = new PParameter("plDst", "edu.toronto.cs.se.mmint.productline.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("model://edu.toronto.cs.se.mmint.productline", "Class")), PParameterDirection.INOUT);
    
    private final PParameter parameter_dstType = new PParameter("dstType", "java.lang.String", new JavaTransitiveInstancesKey(java.lang.String.class), PParameterDirection.INOUT);
    
    private final PParameter parameter_plRef = new PParameter("plRef", "edu.toronto.cs.se.mmint.productline.Reference", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("model://edu.toronto.cs.se.mmint.productline", "Reference")), PParameterDirection.INOUT);
    
    private final PParameter parameter_refType = new PParameter("refType", "java.lang.String", new JavaTransitiveInstancesKey(java.lang.String.class), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_plSrc, parameter_srcType, parameter_plDst, parameter_dstType, parameter_plRef, parameter_refType);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "edu.toronto.cs.se.mmint.productline.viatra.reference";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("plSrc","srcType","plDst","dstType","plRef","refType");
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
          PVariable var_plSrc = body.getOrCreateVariableByName("plSrc");
          PVariable var_srcType = body.getOrCreateVariableByName("srcType");
          PVariable var_plDst = body.getOrCreateVariableByName("plDst");
          PVariable var_dstType = body.getOrCreateVariableByName("dstType");
          PVariable var_plRef = body.getOrCreateVariableByName("plRef");
          PVariable var_refType = body.getOrCreateVariableByName("refType");
          new TypeConstraint(body, Tuples.flatTupleOf(var_plSrc), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "Class")));
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_srcType), new JavaTransitiveInstancesKey(java.lang.String.class));
          new TypeConstraint(body, Tuples.flatTupleOf(var_plDst), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "Class")));
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_dstType), new JavaTransitiveInstancesKey(java.lang.String.class));
          new TypeConstraint(body, Tuples.flatTupleOf(var_plRef), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "Reference")));
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_refType), new JavaTransitiveInstancesKey(java.lang.String.class));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_plSrc, parameter_plSrc),
             new ExportedParameter(body, var_srcType, parameter_srcType),
             new ExportedParameter(body, var_plDst, parameter_plDst),
             new ExportedParameter(body, var_dstType, parameter_dstType),
             new ExportedParameter(body, var_plRef, parameter_plRef),
             new ExportedParameter(body, var_refType, parameter_refType)
          ));
          //   find classType(plSrc, srcType)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_plSrc, var_srcType), ClassType.instance().getInternalQueryRepresentation());
          //   Class.referencesAsSource(plSrc, plRef)
          new TypeConstraint(body, Tuples.flatTupleOf(var_plSrc), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "Class")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_plSrc, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("model://edu.toronto.cs.se.mmint.productline", "Class", "referencesAsSource")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "Reference")));
          new Equality(body, var__virtual_0_, var_plRef);
          //   Reference.type.name(plRef, refType)
          new TypeConstraint(body, Tuples.flatTupleOf(var_plRef), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "Reference")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_plRef, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("model://edu.toronto.cs.se.mmint.productline", "Reference", "type")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EReference")));
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/emf/2002/Ecore", "ENamedElement", "name")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EString")));
          new Equality(body, var__virtual_2_, var_refType);
          //   Reference.targets(plRef, plDst)
          new TypeConstraint(body, Tuples.flatTupleOf(var_plRef), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "Reference")));
          PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_plRef, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("model://edu.toronto.cs.se.mmint.productline", "Reference", "targets")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_3_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "Class")));
          new Equality(body, var__virtual_3_, var_plDst);
          //   find classType(plDst, dstType)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_plDst, var_dstType), ClassType.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      return bodies;
    }
  }
}

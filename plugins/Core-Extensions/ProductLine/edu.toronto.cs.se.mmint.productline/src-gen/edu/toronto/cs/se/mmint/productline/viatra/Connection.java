/**
 * Generated from platform:/resource/edu.toronto.cs.se.mmint.productline/src/edu/toronto/cs/se/mmint/productline/viatra/pl.vql
 */
package edu.toronto.cs.se.mmint.productline.viatra;

import edu.toronto.cs.se.mmint.productline.Reference;
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
 *         pattern connection(plClassSrc: Class, srcType: java String, plClassTgt: Class, tgtType: java String, plReference: Reference, refType: java String) {
 *           find classType(plClassSrc, srcType);
 *           Class.referencesAsSource(plClassSrc, plReference);
 *           find referenceType(plReference, refType);
 *           Reference.targets(plReference, plClassTgt);
 *           find classType(plClassTgt, tgtType);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class Connection extends BaseGeneratedEMFQuerySpecification<Connection.Matcher> {
  /**
   * Pattern-specific match representation of the edu.toronto.cs.se.mmint.productline.viatra.connection pattern,
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
    private edu.toronto.cs.se.mmint.productline.Class fPlClassSrc;
    
    private String fSrcType;
    
    private edu.toronto.cs.se.mmint.productline.Class fPlClassTgt;
    
    private String fTgtType;
    
    private Reference fPlReference;
    
    private String fRefType;
    
    private static List<String> parameterNames = makeImmutableList("plClassSrc", "srcType", "plClassTgt", "tgtType", "plReference", "refType");
    
    private Match(final edu.toronto.cs.se.mmint.productline.Class pPlClassSrc, final String pSrcType, final edu.toronto.cs.se.mmint.productline.Class pPlClassTgt, final String pTgtType, final Reference pPlReference, final String pRefType) {
      this.fPlClassSrc = pPlClassSrc;
      this.fSrcType = pSrcType;
      this.fPlClassTgt = pPlClassTgt;
      this.fTgtType = pTgtType;
      this.fPlReference = pPlReference;
      this.fRefType = pRefType;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "plClassSrc": return this.fPlClassSrc;
          case "srcType": return this.fSrcType;
          case "plClassTgt": return this.fPlClassTgt;
          case "tgtType": return this.fTgtType;
          case "plReference": return this.fPlReference;
          case "refType": return this.fRefType;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fPlClassSrc;
          case 1: return this.fSrcType;
          case 2: return this.fPlClassTgt;
          case 3: return this.fTgtType;
          case 4: return this.fPlReference;
          case 5: return this.fRefType;
          default: return null;
      }
    }
    
    public edu.toronto.cs.se.mmint.productline.Class getPlClassSrc() {
      return this.fPlClassSrc;
    }
    
    public String getSrcType() {
      return this.fSrcType;
    }
    
    public edu.toronto.cs.se.mmint.productline.Class getPlClassTgt() {
      return this.fPlClassTgt;
    }
    
    public String getTgtType() {
      return this.fTgtType;
    }
    
    public Reference getPlReference() {
      return this.fPlReference;
    }
    
    public String getRefType() {
      return this.fRefType;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("plClassSrc".equals(parameterName) ) {
          this.fPlClassSrc = (edu.toronto.cs.se.mmint.productline.Class) newValue;
          return true;
      }
      if ("srcType".equals(parameterName) ) {
          this.fSrcType = (String) newValue;
          return true;
      }
      if ("plClassTgt".equals(parameterName) ) {
          this.fPlClassTgt = (edu.toronto.cs.se.mmint.productline.Class) newValue;
          return true;
      }
      if ("tgtType".equals(parameterName) ) {
          this.fTgtType = (String) newValue;
          return true;
      }
      if ("plReference".equals(parameterName) ) {
          this.fPlReference = (Reference) newValue;
          return true;
      }
      if ("refType".equals(parameterName) ) {
          this.fRefType = (String) newValue;
          return true;
      }
      return false;
    }
    
    public void setPlClassSrc(final edu.toronto.cs.se.mmint.productline.Class pPlClassSrc) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fPlClassSrc = pPlClassSrc;
    }
    
    public void setSrcType(final String pSrcType) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fSrcType = pSrcType;
    }
    
    public void setPlClassTgt(final edu.toronto.cs.se.mmint.productline.Class pPlClassTgt) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fPlClassTgt = pPlClassTgt;
    }
    
    public void setTgtType(final String pTgtType) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fTgtType = pTgtType;
    }
    
    public void setPlReference(final Reference pPlReference) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fPlReference = pPlReference;
    }
    
    public void setRefType(final String pRefType) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fRefType = pRefType;
    }
    
    @Override
    public String patternName() {
      return "edu.toronto.cs.se.mmint.productline.viatra.connection";
    }
    
    @Override
    public List<String> parameterNames() {
      return Connection.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fPlClassSrc, fSrcType, fPlClassTgt, fTgtType, fPlReference, fRefType};
    }
    
    @Override
    public Connection.Match toImmutable() {
      return isMutable() ? newMatch(fPlClassSrc, fSrcType, fPlClassTgt, fTgtType, fPlReference, fRefType) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"plClassSrc\"=" + prettyPrintValue(fPlClassSrc) + ", ");
      result.append("\"srcType\"=" + prettyPrintValue(fSrcType) + ", ");
      result.append("\"plClassTgt\"=" + prettyPrintValue(fPlClassTgt) + ", ");
      result.append("\"tgtType\"=" + prettyPrintValue(fTgtType) + ", ");
      result.append("\"plReference\"=" + prettyPrintValue(fPlReference) + ", ");
      result.append("\"refType\"=" + prettyPrintValue(fRefType));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fPlClassSrc, fSrcType, fPlClassTgt, fTgtType, fPlReference, fRefType);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof Connection.Match)) {
          Connection.Match other = (Connection.Match) obj;
          return Objects.equals(fPlClassSrc, other.fPlClassSrc) && Objects.equals(fSrcType, other.fSrcType) && Objects.equals(fPlClassTgt, other.fPlClassTgt) && Objects.equals(fTgtType, other.fTgtType) && Objects.equals(fPlReference, other.fPlReference) && Objects.equals(fRefType, other.fRefType);
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
    public Connection specification() {
      return Connection.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static Connection.Match newEmptyMatch() {
      return new Mutable(null, null, null, null, null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pPlClassSrc the fixed value of pattern parameter plClassSrc, or null if not bound.
     * @param pSrcType the fixed value of pattern parameter srcType, or null if not bound.
     * @param pPlClassTgt the fixed value of pattern parameter plClassTgt, or null if not bound.
     * @param pTgtType the fixed value of pattern parameter tgtType, or null if not bound.
     * @param pPlReference the fixed value of pattern parameter plReference, or null if not bound.
     * @param pRefType the fixed value of pattern parameter refType, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static Connection.Match newMutableMatch(final edu.toronto.cs.se.mmint.productline.Class pPlClassSrc, final String pSrcType, final edu.toronto.cs.se.mmint.productline.Class pPlClassTgt, final String pTgtType, final Reference pPlReference, final String pRefType) {
      return new Mutable(pPlClassSrc, pSrcType, pPlClassTgt, pTgtType, pPlReference, pRefType);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pPlClassSrc the fixed value of pattern parameter plClassSrc, or null if not bound.
     * @param pSrcType the fixed value of pattern parameter srcType, or null if not bound.
     * @param pPlClassTgt the fixed value of pattern parameter plClassTgt, or null if not bound.
     * @param pTgtType the fixed value of pattern parameter tgtType, or null if not bound.
     * @param pPlReference the fixed value of pattern parameter plReference, or null if not bound.
     * @param pRefType the fixed value of pattern parameter refType, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static Connection.Match newMatch(final edu.toronto.cs.se.mmint.productline.Class pPlClassSrc, final String pSrcType, final edu.toronto.cs.se.mmint.productline.Class pPlClassTgt, final String pTgtType, final Reference pPlReference, final String pRefType) {
      return new Immutable(pPlClassSrc, pSrcType, pPlClassTgt, pTgtType, pPlReference, pRefType);
    }
    
    private static final class Mutable extends Connection.Match {
      Mutable(final edu.toronto.cs.se.mmint.productline.Class pPlClassSrc, final String pSrcType, final edu.toronto.cs.se.mmint.productline.Class pPlClassTgt, final String pTgtType, final Reference pPlReference, final String pRefType) {
        super(pPlClassSrc, pSrcType, pPlClassTgt, pTgtType, pPlReference, pRefType);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends Connection.Match {
      Immutable(final edu.toronto.cs.se.mmint.productline.Class pPlClassSrc, final String pSrcType, final edu.toronto.cs.se.mmint.productline.Class pPlClassTgt, final String pTgtType, final Reference pPlReference, final String pRefType) {
        super(pPlClassSrc, pSrcType, pPlClassTgt, pTgtType, pPlReference, pRefType);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the edu.toronto.cs.se.mmint.productline.viatra.connection pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern connection(plClassSrc: Class, srcType: java String, plClassTgt: Class, tgtType: java String, plReference: Reference, refType: java String) {
   *   find classType(plClassSrc, srcType);
   *   Class.referencesAsSource(plClassSrc, plReference);
   *   find referenceType(plReference, refType);
   *   Reference.targets(plReference, plClassTgt);
   *   find classType(plClassTgt, tgtType);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see Connection
   * 
   */
  public static class Matcher extends BaseMatcher<Connection.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static Connection.Matcher on(final ViatraQueryEngine engine) {
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
    public static Connection.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_PLCLASSSRC = 0;
    
    private static final int POSITION_SRCTYPE = 1;
    
    private static final int POSITION_PLCLASSTGT = 2;
    
    private static final int POSITION_TGTTYPE = 3;
    
    private static final int POSITION_PLREFERENCE = 4;
    
    private static final int POSITION_REFTYPE = 5;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(Connection.Matcher.class);
    
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
     * @param pPlClassSrc the fixed value of pattern parameter plClassSrc, or null if not bound.
     * @param pSrcType the fixed value of pattern parameter srcType, or null if not bound.
     * @param pPlClassTgt the fixed value of pattern parameter plClassTgt, or null if not bound.
     * @param pTgtType the fixed value of pattern parameter tgtType, or null if not bound.
     * @param pPlReference the fixed value of pattern parameter plReference, or null if not bound.
     * @param pRefType the fixed value of pattern parameter refType, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<Connection.Match> getAllMatches(final edu.toronto.cs.se.mmint.productline.Class pPlClassSrc, final String pSrcType, final edu.toronto.cs.se.mmint.productline.Class pPlClassTgt, final String pTgtType, final Reference pPlReference, final String pRefType) {
      return rawStreamAllMatches(new Object[]{pPlClassSrc, pSrcType, pPlClassTgt, pTgtType, pPlReference, pRefType}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pPlClassSrc the fixed value of pattern parameter plClassSrc, or null if not bound.
     * @param pSrcType the fixed value of pattern parameter srcType, or null if not bound.
     * @param pPlClassTgt the fixed value of pattern parameter plClassTgt, or null if not bound.
     * @param pTgtType the fixed value of pattern parameter tgtType, or null if not bound.
     * @param pPlReference the fixed value of pattern parameter plReference, or null if not bound.
     * @param pRefType the fixed value of pattern parameter refType, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<Connection.Match> streamAllMatches(final edu.toronto.cs.se.mmint.productline.Class pPlClassSrc, final String pSrcType, final edu.toronto.cs.se.mmint.productline.Class pPlClassTgt, final String pTgtType, final Reference pPlReference, final String pRefType) {
      return rawStreamAllMatches(new Object[]{pPlClassSrc, pSrcType, pPlClassTgt, pTgtType, pPlReference, pRefType});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pPlClassSrc the fixed value of pattern parameter plClassSrc, or null if not bound.
     * @param pSrcType the fixed value of pattern parameter srcType, or null if not bound.
     * @param pPlClassTgt the fixed value of pattern parameter plClassTgt, or null if not bound.
     * @param pTgtType the fixed value of pattern parameter tgtType, or null if not bound.
     * @param pPlReference the fixed value of pattern parameter plReference, or null if not bound.
     * @param pRefType the fixed value of pattern parameter refType, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<Connection.Match> getOneArbitraryMatch(final edu.toronto.cs.se.mmint.productline.Class pPlClassSrc, final String pSrcType, final edu.toronto.cs.se.mmint.productline.Class pPlClassTgt, final String pTgtType, final Reference pPlReference, final String pRefType) {
      return rawGetOneArbitraryMatch(new Object[]{pPlClassSrc, pSrcType, pPlClassTgt, pTgtType, pPlReference, pRefType});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pPlClassSrc the fixed value of pattern parameter plClassSrc, or null if not bound.
     * @param pSrcType the fixed value of pattern parameter srcType, or null if not bound.
     * @param pPlClassTgt the fixed value of pattern parameter plClassTgt, or null if not bound.
     * @param pTgtType the fixed value of pattern parameter tgtType, or null if not bound.
     * @param pPlReference the fixed value of pattern parameter plReference, or null if not bound.
     * @param pRefType the fixed value of pattern parameter refType, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final edu.toronto.cs.se.mmint.productline.Class pPlClassSrc, final String pSrcType, final edu.toronto.cs.se.mmint.productline.Class pPlClassTgt, final String pTgtType, final Reference pPlReference, final String pRefType) {
      return rawHasMatch(new Object[]{pPlClassSrc, pSrcType, pPlClassTgt, pTgtType, pPlReference, pRefType});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pPlClassSrc the fixed value of pattern parameter plClassSrc, or null if not bound.
     * @param pSrcType the fixed value of pattern parameter srcType, or null if not bound.
     * @param pPlClassTgt the fixed value of pattern parameter plClassTgt, or null if not bound.
     * @param pTgtType the fixed value of pattern parameter tgtType, or null if not bound.
     * @param pPlReference the fixed value of pattern parameter plReference, or null if not bound.
     * @param pRefType the fixed value of pattern parameter refType, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final edu.toronto.cs.se.mmint.productline.Class pPlClassSrc, final String pSrcType, final edu.toronto.cs.se.mmint.productline.Class pPlClassTgt, final String pTgtType, final Reference pPlReference, final String pRefType) {
      return rawCountMatches(new Object[]{pPlClassSrc, pSrcType, pPlClassTgt, pTgtType, pPlReference, pRefType});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pPlClassSrc the fixed value of pattern parameter plClassSrc, or null if not bound.
     * @param pSrcType the fixed value of pattern parameter srcType, or null if not bound.
     * @param pPlClassTgt the fixed value of pattern parameter plClassTgt, or null if not bound.
     * @param pTgtType the fixed value of pattern parameter tgtType, or null if not bound.
     * @param pPlReference the fixed value of pattern parameter plReference, or null if not bound.
     * @param pRefType the fixed value of pattern parameter refType, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final edu.toronto.cs.se.mmint.productline.Class pPlClassSrc, final String pSrcType, final edu.toronto.cs.se.mmint.productline.Class pPlClassTgt, final String pTgtType, final Reference pPlReference, final String pRefType, final Consumer<? super Connection.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pPlClassSrc, pSrcType, pPlClassTgt, pTgtType, pPlReference, pRefType}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pPlClassSrc the fixed value of pattern parameter plClassSrc, or null if not bound.
     * @param pSrcType the fixed value of pattern parameter srcType, or null if not bound.
     * @param pPlClassTgt the fixed value of pattern parameter plClassTgt, or null if not bound.
     * @param pTgtType the fixed value of pattern parameter tgtType, or null if not bound.
     * @param pPlReference the fixed value of pattern parameter plReference, or null if not bound.
     * @param pRefType the fixed value of pattern parameter refType, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public Connection.Match newMatch(final edu.toronto.cs.se.mmint.productline.Class pPlClassSrc, final String pSrcType, final edu.toronto.cs.se.mmint.productline.Class pPlClassTgt, final String pTgtType, final Reference pPlReference, final String pRefType) {
      return Connection.Match.newMatch(pPlClassSrc, pSrcType, pPlClassTgt, pTgtType, pPlReference, pRefType);
    }
    
    /**
     * Retrieve the set of values that occur in matches for plClassSrc.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<edu.toronto.cs.se.mmint.productline.Class> rawStreamAllValuesOfplClassSrc(final Object[] parameters) {
      return rawStreamAllValues(POSITION_PLCLASSSRC, parameters).map(edu.toronto.cs.se.mmint.productline.Class.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for plClassSrc.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Class> getAllValuesOfplClassSrc() {
      return rawStreamAllValuesOfplClassSrc(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plClassSrc.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.mmint.productline.Class> streamAllValuesOfplClassSrc() {
      return rawStreamAllValuesOfplClassSrc(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plClassSrc.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.mmint.productline.Class> streamAllValuesOfplClassSrc(final Connection.Match partialMatch) {
      return rawStreamAllValuesOfplClassSrc(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plClassSrc.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.mmint.productline.Class> streamAllValuesOfplClassSrc(final String pSrcType, final edu.toronto.cs.se.mmint.productline.Class pPlClassTgt, final String pTgtType, final Reference pPlReference, final String pRefType) {
      return rawStreamAllValuesOfplClassSrc(new Object[]{null, pSrcType, pPlClassTgt, pTgtType, pPlReference, pRefType});
    }
    
    /**
     * Retrieve the set of values that occur in matches for plClassSrc.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Class> getAllValuesOfplClassSrc(final Connection.Match partialMatch) {
      return rawStreamAllValuesOfplClassSrc(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plClassSrc.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Class> getAllValuesOfplClassSrc(final String pSrcType, final edu.toronto.cs.se.mmint.productline.Class pPlClassTgt, final String pTgtType, final Reference pPlReference, final String pRefType) {
      return rawStreamAllValuesOfplClassSrc(new Object[]{null, pSrcType, pPlClassTgt, pTgtType, pPlReference, pRefType}).collect(Collectors.toSet());
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
    public Stream<String> streamAllValuesOfsrcType(final Connection.Match partialMatch) {
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
    public Stream<String> streamAllValuesOfsrcType(final edu.toronto.cs.se.mmint.productline.Class pPlClassSrc, final edu.toronto.cs.se.mmint.productline.Class pPlClassTgt, final String pTgtType, final Reference pPlReference, final String pRefType) {
      return rawStreamAllValuesOfsrcType(new Object[]{pPlClassSrc, null, pPlClassTgt, pTgtType, pPlReference, pRefType});
    }
    
    /**
     * Retrieve the set of values that occur in matches for srcType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfsrcType(final Connection.Match partialMatch) {
      return rawStreamAllValuesOfsrcType(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for srcType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfsrcType(final edu.toronto.cs.se.mmint.productline.Class pPlClassSrc, final edu.toronto.cs.se.mmint.productline.Class pPlClassTgt, final String pTgtType, final Reference pPlReference, final String pRefType) {
      return rawStreamAllValuesOfsrcType(new Object[]{pPlClassSrc, null, pPlClassTgt, pTgtType, pPlReference, pRefType}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plClassTgt.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<edu.toronto.cs.se.mmint.productline.Class> rawStreamAllValuesOfplClassTgt(final Object[] parameters) {
      return rawStreamAllValues(POSITION_PLCLASSTGT, parameters).map(edu.toronto.cs.se.mmint.productline.Class.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for plClassTgt.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Class> getAllValuesOfplClassTgt() {
      return rawStreamAllValuesOfplClassTgt(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plClassTgt.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.mmint.productline.Class> streamAllValuesOfplClassTgt() {
      return rawStreamAllValuesOfplClassTgt(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plClassTgt.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.mmint.productline.Class> streamAllValuesOfplClassTgt(final Connection.Match partialMatch) {
      return rawStreamAllValuesOfplClassTgt(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plClassTgt.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.mmint.productline.Class> streamAllValuesOfplClassTgt(final edu.toronto.cs.se.mmint.productline.Class pPlClassSrc, final String pSrcType, final String pTgtType, final Reference pPlReference, final String pRefType) {
      return rawStreamAllValuesOfplClassTgt(new Object[]{pPlClassSrc, pSrcType, null, pTgtType, pPlReference, pRefType});
    }
    
    /**
     * Retrieve the set of values that occur in matches for plClassTgt.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Class> getAllValuesOfplClassTgt(final Connection.Match partialMatch) {
      return rawStreamAllValuesOfplClassTgt(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plClassTgt.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Class> getAllValuesOfplClassTgt(final edu.toronto.cs.se.mmint.productline.Class pPlClassSrc, final String pSrcType, final String pTgtType, final Reference pPlReference, final String pRefType) {
      return rawStreamAllValuesOfplClassTgt(new Object[]{pPlClassSrc, pSrcType, null, pTgtType, pPlReference, pRefType}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for tgtType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<String> rawStreamAllValuesOftgtType(final Object[] parameters) {
      return rawStreamAllValues(POSITION_TGTTYPE, parameters).map(String.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for tgtType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOftgtType() {
      return rawStreamAllValuesOftgtType(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for tgtType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOftgtType() {
      return rawStreamAllValuesOftgtType(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for tgtType.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOftgtType(final Connection.Match partialMatch) {
      return rawStreamAllValuesOftgtType(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for tgtType.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOftgtType(final edu.toronto.cs.se.mmint.productline.Class pPlClassSrc, final String pSrcType, final edu.toronto.cs.se.mmint.productline.Class pPlClassTgt, final Reference pPlReference, final String pRefType) {
      return rawStreamAllValuesOftgtType(new Object[]{pPlClassSrc, pSrcType, pPlClassTgt, null, pPlReference, pRefType});
    }
    
    /**
     * Retrieve the set of values that occur in matches for tgtType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOftgtType(final Connection.Match partialMatch) {
      return rawStreamAllValuesOftgtType(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for tgtType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOftgtType(final edu.toronto.cs.se.mmint.productline.Class pPlClassSrc, final String pSrcType, final edu.toronto.cs.se.mmint.productline.Class pPlClassTgt, final Reference pPlReference, final String pRefType) {
      return rawStreamAllValuesOftgtType(new Object[]{pPlClassSrc, pSrcType, pPlClassTgt, null, pPlReference, pRefType}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plReference.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Reference> rawStreamAllValuesOfplReference(final Object[] parameters) {
      return rawStreamAllValues(POSITION_PLREFERENCE, parameters).map(Reference.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for plReference.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Reference> getAllValuesOfplReference() {
      return rawStreamAllValuesOfplReference(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plReference.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Reference> streamAllValuesOfplReference() {
      return rawStreamAllValuesOfplReference(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plReference.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Reference> streamAllValuesOfplReference(final Connection.Match partialMatch) {
      return rawStreamAllValuesOfplReference(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plReference.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Reference> streamAllValuesOfplReference(final edu.toronto.cs.se.mmint.productline.Class pPlClassSrc, final String pSrcType, final edu.toronto.cs.se.mmint.productline.Class pPlClassTgt, final String pTgtType, final String pRefType) {
      return rawStreamAllValuesOfplReference(new Object[]{pPlClassSrc, pSrcType, pPlClassTgt, pTgtType, null, pRefType});
    }
    
    /**
     * Retrieve the set of values that occur in matches for plReference.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Reference> getAllValuesOfplReference(final Connection.Match partialMatch) {
      return rawStreamAllValuesOfplReference(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plReference.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Reference> getAllValuesOfplReference(final edu.toronto.cs.se.mmint.productline.Class pPlClassSrc, final String pSrcType, final edu.toronto.cs.se.mmint.productline.Class pPlClassTgt, final String pTgtType, final String pRefType) {
      return rawStreamAllValuesOfplReference(new Object[]{pPlClassSrc, pSrcType, pPlClassTgt, pTgtType, null, pRefType}).collect(Collectors.toSet());
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
    public Stream<String> streamAllValuesOfrefType(final Connection.Match partialMatch) {
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
    public Stream<String> streamAllValuesOfrefType(final edu.toronto.cs.se.mmint.productline.Class pPlClassSrc, final String pSrcType, final edu.toronto.cs.se.mmint.productline.Class pPlClassTgt, final String pTgtType, final Reference pPlReference) {
      return rawStreamAllValuesOfrefType(new Object[]{pPlClassSrc, pSrcType, pPlClassTgt, pTgtType, pPlReference, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for refType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfrefType(final Connection.Match partialMatch) {
      return rawStreamAllValuesOfrefType(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for refType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfrefType(final edu.toronto.cs.se.mmint.productline.Class pPlClassSrc, final String pSrcType, final edu.toronto.cs.se.mmint.productline.Class pPlClassTgt, final String pTgtType, final Reference pPlReference) {
      return rawStreamAllValuesOfrefType(new Object[]{pPlClassSrc, pSrcType, pPlClassTgt, pTgtType, pPlReference, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected Connection.Match tupleToMatch(final Tuple t) {
      try {
          return Connection.Match.newMatch((edu.toronto.cs.se.mmint.productline.Class) t.get(POSITION_PLCLASSSRC), (String) t.get(POSITION_SRCTYPE), (edu.toronto.cs.se.mmint.productline.Class) t.get(POSITION_PLCLASSTGT), (String) t.get(POSITION_TGTTYPE), (Reference) t.get(POSITION_PLREFERENCE), (String) t.get(POSITION_REFTYPE));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected Connection.Match arrayToMatch(final Object[] match) {
      try {
          return Connection.Match.newMatch((edu.toronto.cs.se.mmint.productline.Class) match[POSITION_PLCLASSSRC], (String) match[POSITION_SRCTYPE], (edu.toronto.cs.se.mmint.productline.Class) match[POSITION_PLCLASSTGT], (String) match[POSITION_TGTTYPE], (Reference) match[POSITION_PLREFERENCE], (String) match[POSITION_REFTYPE]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected Connection.Match arrayToMatchMutable(final Object[] match) {
      try {
          return Connection.Match.newMutableMatch((edu.toronto.cs.se.mmint.productline.Class) match[POSITION_PLCLASSSRC], (String) match[POSITION_SRCTYPE], (edu.toronto.cs.se.mmint.productline.Class) match[POSITION_PLCLASSTGT], (String) match[POSITION_TGTTYPE], (Reference) match[POSITION_PLREFERENCE], (String) match[POSITION_REFTYPE]);
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
    public static IQuerySpecification<Connection.Matcher> querySpecification() {
      return Connection.instance();
    }
  }
  
  private Connection() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static Connection instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected Connection.Matcher instantiate(final ViatraQueryEngine engine) {
    return Connection.Matcher.on(engine);
  }
  
  @Override
  public Connection.Matcher instantiate() {
    return Connection.Matcher.create();
  }
  
  @Override
  public Connection.Match newEmptyMatch() {
    return Connection.Match.newEmptyMatch();
  }
  
  @Override
  public Connection.Match newMatch(final Object... parameters) {
    return Connection.Match.newMatch((edu.toronto.cs.se.mmint.productline.Class) parameters[0], (java.lang.String) parameters[1], (edu.toronto.cs.se.mmint.productline.Class) parameters[2], (java.lang.String) parameters[3], (edu.toronto.cs.se.mmint.productline.Reference) parameters[4], (java.lang.String) parameters[5]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link Connection} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link Connection#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final Connection INSTANCE = new Connection();
    
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
    private static final Connection.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_plClassSrc = new PParameter("plClassSrc", "edu.toronto.cs.se.mmint.productline.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("model://edu.toronto.cs.se.mmint.productline", "Class")), PParameterDirection.INOUT);
    
    private final PParameter parameter_srcType = new PParameter("srcType", "java.lang.String", new JavaTransitiveInstancesKey(java.lang.String.class), PParameterDirection.INOUT);
    
    private final PParameter parameter_plClassTgt = new PParameter("plClassTgt", "edu.toronto.cs.se.mmint.productline.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("model://edu.toronto.cs.se.mmint.productline", "Class")), PParameterDirection.INOUT);
    
    private final PParameter parameter_tgtType = new PParameter("tgtType", "java.lang.String", new JavaTransitiveInstancesKey(java.lang.String.class), PParameterDirection.INOUT);
    
    private final PParameter parameter_plReference = new PParameter("plReference", "edu.toronto.cs.se.mmint.productline.Reference", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("model://edu.toronto.cs.se.mmint.productline", "Reference")), PParameterDirection.INOUT);
    
    private final PParameter parameter_refType = new PParameter("refType", "java.lang.String", new JavaTransitiveInstancesKey(java.lang.String.class), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_plClassSrc, parameter_srcType, parameter_plClassTgt, parameter_tgtType, parameter_plReference, parameter_refType);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "edu.toronto.cs.se.mmint.productline.viatra.connection";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("plClassSrc","srcType","plClassTgt","tgtType","plReference","refType");
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
          PVariable var_plClassSrc = body.getOrCreateVariableByName("plClassSrc");
          PVariable var_srcType = body.getOrCreateVariableByName("srcType");
          PVariable var_plClassTgt = body.getOrCreateVariableByName("plClassTgt");
          PVariable var_tgtType = body.getOrCreateVariableByName("tgtType");
          PVariable var_plReference = body.getOrCreateVariableByName("plReference");
          PVariable var_refType = body.getOrCreateVariableByName("refType");
          new TypeConstraint(body, Tuples.flatTupleOf(var_plClassSrc), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "Class")));
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_srcType), new JavaTransitiveInstancesKey(java.lang.String.class));
          new TypeConstraint(body, Tuples.flatTupleOf(var_plClassTgt), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "Class")));
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_tgtType), new JavaTransitiveInstancesKey(java.lang.String.class));
          new TypeConstraint(body, Tuples.flatTupleOf(var_plReference), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "Reference")));
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_refType), new JavaTransitiveInstancesKey(java.lang.String.class));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_plClassSrc, parameter_plClassSrc),
             new ExportedParameter(body, var_srcType, parameter_srcType),
             new ExportedParameter(body, var_plClassTgt, parameter_plClassTgt),
             new ExportedParameter(body, var_tgtType, parameter_tgtType),
             new ExportedParameter(body, var_plReference, parameter_plReference),
             new ExportedParameter(body, var_refType, parameter_refType)
          ));
          //   find classType(plClassSrc, srcType)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_plClassSrc, var_srcType), ClassType.instance().getInternalQueryRepresentation());
          //   Class.referencesAsSource(plClassSrc, plReference)
          new TypeConstraint(body, Tuples.flatTupleOf(var_plClassSrc), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "Class")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_plClassSrc, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("model://edu.toronto.cs.se.mmint.productline", "Class", "referencesAsSource")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "Reference")));
          new Equality(body, var__virtual_0_, var_plReference);
          //   find referenceType(plReference, refType)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_plReference, var_refType), ReferenceType.instance().getInternalQueryRepresentation());
          //   Reference.targets(plReference, plClassTgt)
          new TypeConstraint(body, Tuples.flatTupleOf(var_plReference), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "Reference")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_plReference, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("model://edu.toronto.cs.se.mmint.productline", "Reference", "targets")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "Class")));
          new Equality(body, var__virtual_1_, var_plClassTgt);
          //   find classType(plClassTgt, tgtType)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_plClassTgt, var_tgtType), ClassType.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      return bodies;
    }
  }
}

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

import edu.toronto.cs.se.mmint.productline.PLElement;
import edu.toronto.cs.se.mmint.productline.viatra.Attribute;
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
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.ConstantValue;
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
 *         pattern testAttribute2PL(clazz: Class, attr: PLElement, name: EString) {
 *           find attribute(clazz, "Class", attr, "name", name);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class TestAttribute2PL extends BaseGeneratedEMFQuerySpecification<TestAttribute2PL.Matcher> {
  /**
   * Pattern-specific match representation of the edu.toronto.cs.se.mmint.productline.viatra.tests.testAttribute2PL pattern,
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
    private edu.toronto.cs.se.mmint.productline.Class fClazz;

    private PLElement fAttr;

    private String fName;

    private static List<String> parameterNames = makeImmutableList("clazz", "attr", "name");

    private Match(final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pAttr, final String pName) {
      this.fClazz = pClazz;
      this.fAttr = pAttr;
      this.fName = pName;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "clazz": return this.fClazz;
          case "attr": return this.fAttr;
          case "name": return this.fName;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fClazz;
          case 1: return this.fAttr;
          case 2: return this.fName;
          default: return null;
      }
    }

    public edu.toronto.cs.se.mmint.productline.Class getClazz() {
      return this.fClazz;
    }

    public PLElement getAttr() {
      return this.fAttr;
    }

    public String getName() {
      return this.fName;
    }

    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("clazz".equals(parameterName) ) {
          this.fClazz = (edu.toronto.cs.se.mmint.productline.Class) newValue;
          return true;
      }
      if ("attr".equals(parameterName) ) {
          this.fAttr = (PLElement) newValue;
          return true;
      }
      if ("name".equals(parameterName) ) {
          this.fName = (String) newValue;
          return true;
      }
      return false;
    }

    public void setClazz(final edu.toronto.cs.se.mmint.productline.Class pClazz) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fClazz = pClazz;
    }

    public void setAttr(final PLElement pAttr) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fAttr = pAttr;
    }

    public void setName(final String pName) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fName = pName;
    }

    @Override
    public String patternName() {
      return "edu.toronto.cs.se.mmint.productline.viatra.tests.testAttribute2PL";
    }

    @Override
    public List<String> parameterNames() {
      return TestAttribute2PL.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fClazz, fAttr, fName};
    }

    @Override
    public TestAttribute2PL.Match toImmutable() {
      return isMutable() ? newMatch(fClazz, fAttr, fName) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"clazz\"=" + prettyPrintValue(fClazz) + ", ");
      result.append("\"attr\"=" + prettyPrintValue(fAttr) + ", ");
      result.append("\"name\"=" + prettyPrintValue(fName));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fClazz, fAttr, fName);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof TestAttribute2PL.Match)) {
          TestAttribute2PL.Match other = (TestAttribute2PL.Match) obj;
          return Objects.equals(fClazz, other.fClazz) && Objects.equals(fAttr, other.fAttr) && Objects.equals(fName, other.fName);
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
    public TestAttribute2PL specification() {
      return TestAttribute2PL.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static TestAttribute2PL.Match newEmptyMatch() {
      return new Mutable(null, null, null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @param pAttr the fixed value of pattern parameter attr, or null if not bound.
     * @param pName the fixed value of pattern parameter name, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static TestAttribute2PL.Match newMutableMatch(final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pAttr, final String pName) {
      return new Mutable(pClazz, pAttr, pName);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @param pAttr the fixed value of pattern parameter attr, or null if not bound.
     * @param pName the fixed value of pattern parameter name, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static TestAttribute2PL.Match newMatch(final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pAttr, final String pName) {
      return new Immutable(pClazz, pAttr, pName);
    }

    private static final class Mutable extends TestAttribute2PL.Match {
      Mutable(final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pAttr, final String pName) {
        super(pClazz, pAttr, pName);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends TestAttribute2PL.Match {
      Immutable(final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pAttr, final String pName) {
        super(pClazz, pAttr, pName);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the edu.toronto.cs.se.mmint.productline.viatra.tests.testAttribute2PL pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern testAttribute2PL(clazz: Class, attr: PLElement, name: EString) {
   *   find attribute(clazz, "Class", attr, "name", name);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see TestAttribute2PL
   * 
   */
  public static class Matcher extends BaseMatcher<TestAttribute2PL.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static TestAttribute2PL.Matcher on(final ViatraQueryEngine engine) {
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
    public static TestAttribute2PL.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_CLAZZ = 0;

    private static final int POSITION_ATTR = 1;

    private static final int POSITION_NAME = 2;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(TestAttribute2PL.Matcher.class);

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
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @param pAttr the fixed value of pattern parameter attr, or null if not bound.
     * @param pName the fixed value of pattern parameter name, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<TestAttribute2PL.Match> getAllMatches(final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pAttr, final String pName) {
      return rawStreamAllMatches(new Object[]{pClazz, pAttr, pName}).collect(Collectors.toSet());
    }

    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @param pAttr the fixed value of pattern parameter attr, or null if not bound.
     * @param pName the fixed value of pattern parameter name, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<TestAttribute2PL.Match> streamAllMatches(final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pAttr, final String pName) {
      return rawStreamAllMatches(new Object[]{pClazz, pAttr, pName});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @param pAttr the fixed value of pattern parameter attr, or null if not bound.
     * @param pName the fixed value of pattern parameter name, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<TestAttribute2PL.Match> getOneArbitraryMatch(final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pAttr, final String pName) {
      return rawGetOneArbitraryMatch(new Object[]{pClazz, pAttr, pName});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @param pAttr the fixed value of pattern parameter attr, or null if not bound.
     * @param pName the fixed value of pattern parameter name, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pAttr, final String pName) {
      return rawHasMatch(new Object[]{pClazz, pAttr, pName});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @param pAttr the fixed value of pattern parameter attr, or null if not bound.
     * @param pName the fixed value of pattern parameter name, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pAttr, final String pName) {
      return rawCountMatches(new Object[]{pClazz, pAttr, pName});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @param pAttr the fixed value of pattern parameter attr, or null if not bound.
     * @param pName the fixed value of pattern parameter name, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pAttr, final String pName, final Consumer<? super TestAttribute2PL.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pClazz, pAttr, pName}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @param pAttr the fixed value of pattern parameter attr, or null if not bound.
     * @param pName the fixed value of pattern parameter name, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public TestAttribute2PL.Match newMatch(final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pAttr, final String pName) {
      return TestAttribute2PL.Match.newMatch(pClazz, pAttr, pName);
    }

    /**
     * Retrieve the set of values that occur in matches for clazz.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<edu.toronto.cs.se.mmint.productline.Class> rawStreamAllValuesOfclazz(final Object[] parameters) {
      return rawStreamAllValues(POSITION_CLAZZ, parameters).map(edu.toronto.cs.se.mmint.productline.Class.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for clazz.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Class> getAllValuesOfclazz() {
      return rawStreamAllValuesOfclazz(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for clazz.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.mmint.productline.Class> streamAllValuesOfclazz() {
      return rawStreamAllValuesOfclazz(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for clazz.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.mmint.productline.Class> streamAllValuesOfclazz(final TestAttribute2PL.Match partialMatch) {
      return rawStreamAllValuesOfclazz(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for clazz.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.mmint.productline.Class> streamAllValuesOfclazz(final PLElement pAttr, final String pName) {
      return rawStreamAllValuesOfclazz(new Object[]{null, pAttr, pName});
    }

    /**
     * Retrieve the set of values that occur in matches for clazz.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Class> getAllValuesOfclazz(final TestAttribute2PL.Match partialMatch) {
      return rawStreamAllValuesOfclazz(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for clazz.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Class> getAllValuesOfclazz(final PLElement pAttr, final String pName) {
      return rawStreamAllValuesOfclazz(new Object[]{null, pAttr, pName}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for attr.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<PLElement> rawStreamAllValuesOfattr(final Object[] parameters) {
      return rawStreamAllValues(POSITION_ATTR, parameters).map(PLElement.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for attr.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<PLElement> getAllValuesOfattr() {
      return rawStreamAllValuesOfattr(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for attr.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<PLElement> streamAllValuesOfattr() {
      return rawStreamAllValuesOfattr(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for attr.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<PLElement> streamAllValuesOfattr(final TestAttribute2PL.Match partialMatch) {
      return rawStreamAllValuesOfattr(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for attr.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<PLElement> streamAllValuesOfattr(final edu.toronto.cs.se.mmint.productline.Class pClazz, final String pName) {
      return rawStreamAllValuesOfattr(new Object[]{pClazz, null, pName});
    }

    /**
     * Retrieve the set of values that occur in matches for attr.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<PLElement> getAllValuesOfattr(final TestAttribute2PL.Match partialMatch) {
      return rawStreamAllValuesOfattr(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for attr.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<PLElement> getAllValuesOfattr(final edu.toronto.cs.se.mmint.productline.Class pClazz, final String pName) {
      return rawStreamAllValuesOfattr(new Object[]{pClazz, null, pName}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for name.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<String> rawStreamAllValuesOfname(final Object[] parameters) {
      return rawStreamAllValues(POSITION_NAME, parameters).map(String.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for name.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfname() {
      return rawStreamAllValuesOfname(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for name.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfname() {
      return rawStreamAllValuesOfname(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for name.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfname(final TestAttribute2PL.Match partialMatch) {
      return rawStreamAllValuesOfname(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for name.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfname(final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pAttr) {
      return rawStreamAllValuesOfname(new Object[]{pClazz, pAttr, null});
    }

    /**
     * Retrieve the set of values that occur in matches for name.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfname(final TestAttribute2PL.Match partialMatch) {
      return rawStreamAllValuesOfname(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for name.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfname(final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pAttr) {
      return rawStreamAllValuesOfname(new Object[]{pClazz, pAttr, null}).collect(Collectors.toSet());
    }

    @Override
    protected TestAttribute2PL.Match tupleToMatch(final Tuple t) {
      try {
          return TestAttribute2PL.Match.newMatch((edu.toronto.cs.se.mmint.productline.Class) t.get(POSITION_CLAZZ), (PLElement) t.get(POSITION_ATTR), (String) t.get(POSITION_NAME));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected TestAttribute2PL.Match arrayToMatch(final Object[] match) {
      try {
          return TestAttribute2PL.Match.newMatch((edu.toronto.cs.se.mmint.productline.Class) match[POSITION_CLAZZ], (PLElement) match[POSITION_ATTR], (String) match[POSITION_NAME]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected TestAttribute2PL.Match arrayToMatchMutable(final Object[] match) {
      try {
          return TestAttribute2PL.Match.newMutableMatch((edu.toronto.cs.se.mmint.productline.Class) match[POSITION_CLAZZ], (PLElement) match[POSITION_ATTR], (String) match[POSITION_NAME]);
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
    public static IQuerySpecification<TestAttribute2PL.Matcher> querySpecification() {
      return TestAttribute2PL.instance();
    }
  }

  private TestAttribute2PL() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static TestAttribute2PL instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected TestAttribute2PL.Matcher instantiate(final ViatraQueryEngine engine) {
    return TestAttribute2PL.Matcher.on(engine);
  }

  @Override
  public TestAttribute2PL.Matcher instantiate() {
    return TestAttribute2PL.Matcher.create();
  }

  @Override
  public TestAttribute2PL.Match newEmptyMatch() {
    return TestAttribute2PL.Match.newEmptyMatch();
  }

  @Override
  public TestAttribute2PL.Match newMatch(final Object... parameters) {
    return TestAttribute2PL.Match.newMatch((edu.toronto.cs.se.mmint.productline.Class) parameters[0], (PLElement) parameters[1], (String) parameters[2]);
  }

  /**
   * Inner class allowing the singleton instance of {@link TestAttribute2PL} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link TestAttribute2PL#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final TestAttribute2PL INSTANCE = new TestAttribute2PL();

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
    private static final TestAttribute2PL.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_clazz = new PParameter("clazz", "edu.toronto.cs.se.mmint.productline.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("model://edu.toronto.cs.se.mmint.productline", "Class")), PParameterDirection.INOUT);

    private final PParameter parameter_attr = new PParameter("attr", "edu.toronto.cs.se.mmint.productline.PLElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("model://edu.toronto.cs.se.mmint.productline", "PLElement")), PParameterDirection.INOUT);

    private final PParameter parameter_name = new PParameter("name", "java.lang.String", new EDataTypeInSlotsKey((EDataType)getClassifierLiteralSafe("http://www.eclipse.org/emf/2002/Ecore", "EString")), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_clazz, parameter_attr, parameter_name);

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "edu.toronto.cs.se.mmint.productline.viatra.tests.testAttribute2PL";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("clazz","attr","name");
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
          PVariable var_clazz = body.getOrCreateVariableByName("clazz");
          PVariable var_attr = body.getOrCreateVariableByName("attr");
          PVariable var_name = body.getOrCreateVariableByName("name");
          new TypeConstraint(body, Tuples.flatTupleOf(var_clazz), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "Class")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_attr), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "PLElement")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_name), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EString")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_clazz, parameter_clazz),
             new ExportedParameter(body, var_attr, parameter_attr),
             new ExportedParameter(body, var_name, parameter_name)
          ));
          //   find attribute(clazz, "Class", attr, "name", name)
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new ConstantValue(body, var__virtual_0_, "Class");
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new ConstantValue(body, var__virtual_1_, "name");
          new PositivePatternCall(body, Tuples.flatTupleOf(var_clazz, var__virtual_0_, var_attr, var__virtual_1_, var_name), Attribute.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      return bodies;
    }
  }
}

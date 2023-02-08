/**
 * 
 *   Copyright (c) 2022, 2023 Alessio Di Sandro.
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
import edu.toronto.cs.se.mmint.productline.viatra.Reference;
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
 *         pattern testMultipleEdgesPL(clazz: Class, parent: PLElement, ref: PLElement, attr: PLElement) {
 *           find reference(clazz, "Class", parent, "Class", ref, "superclass");
 *           find attribute(parent, "NamedElement", attr, "name", "parent2");
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class TestMultipleEdgesPL extends BaseGeneratedEMFQuerySpecification<TestMultipleEdgesPL.Matcher> {
  /**
   * Pattern-specific match representation of the edu.toronto.cs.se.mmint.productline.viatra.tests.testMultipleEdgesPL pattern,
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

    private PLElement fParent;

    private PLElement fRef;

    private PLElement fAttr;

    private static List<String> parameterNames = makeImmutableList("clazz", "parent", "ref", "attr");

    private Match(final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pParent, final PLElement pRef, final PLElement pAttr) {
      this.fClazz = pClazz;
      this.fParent = pParent;
      this.fRef = pRef;
      this.fAttr = pAttr;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "clazz": return this.fClazz;
          case "parent": return this.fParent;
          case "ref": return this.fRef;
          case "attr": return this.fAttr;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fClazz;
          case 1: return this.fParent;
          case 2: return this.fRef;
          case 3: return this.fAttr;
          default: return null;
      }
    }

    public edu.toronto.cs.se.mmint.productline.Class getClazz() {
      return this.fClazz;
    }

    public PLElement getParent() {
      return this.fParent;
    }

    public PLElement getRef() {
      return this.fRef;
    }

    public PLElement getAttr() {
      return this.fAttr;
    }

    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("clazz".equals(parameterName) ) {
          this.fClazz = (edu.toronto.cs.se.mmint.productline.Class) newValue;
          return true;
      }
      if ("parent".equals(parameterName) ) {
          this.fParent = (PLElement) newValue;
          return true;
      }
      if ("ref".equals(parameterName) ) {
          this.fRef = (PLElement) newValue;
          return true;
      }
      if ("attr".equals(parameterName) ) {
          this.fAttr = (PLElement) newValue;
          return true;
      }
      return false;
    }

    public void setClazz(final edu.toronto.cs.se.mmint.productline.Class pClazz) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fClazz = pClazz;
    }

    public void setParent(final PLElement pParent) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fParent = pParent;
    }

    public void setRef(final PLElement pRef) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fRef = pRef;
    }

    public void setAttr(final PLElement pAttr) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fAttr = pAttr;
    }

    @Override
    public String patternName() {
      return "edu.toronto.cs.se.mmint.productline.viatra.tests.testMultipleEdgesPL";
    }

    @Override
    public List<String> parameterNames() {
      return TestMultipleEdgesPL.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fClazz, fParent, fRef, fAttr};
    }

    @Override
    public TestMultipleEdgesPL.Match toImmutable() {
      return isMutable() ? newMatch(fClazz, fParent, fRef, fAttr) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"clazz\"=" + prettyPrintValue(fClazz) + ", ");
      result.append("\"parent\"=" + prettyPrintValue(fParent) + ", ");
      result.append("\"ref\"=" + prettyPrintValue(fRef) + ", ");
      result.append("\"attr\"=" + prettyPrintValue(fAttr));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fClazz, fParent, fRef, fAttr);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof TestMultipleEdgesPL.Match)) {
          TestMultipleEdgesPL.Match other = (TestMultipleEdgesPL.Match) obj;
          return Objects.equals(fClazz, other.fClazz) && Objects.equals(fParent, other.fParent) && Objects.equals(fRef, other.fRef) && Objects.equals(fAttr, other.fAttr);
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
    public TestMultipleEdgesPL specification() {
      return TestMultipleEdgesPL.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static TestMultipleEdgesPL.Match newEmptyMatch() {
      return new Mutable(null, null, null, null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @param pParent the fixed value of pattern parameter parent, or null if not bound.
     * @param pRef the fixed value of pattern parameter ref, or null if not bound.
     * @param pAttr the fixed value of pattern parameter attr, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static TestMultipleEdgesPL.Match newMutableMatch(final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pParent, final PLElement pRef, final PLElement pAttr) {
      return new Mutable(pClazz, pParent, pRef, pAttr);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @param pParent the fixed value of pattern parameter parent, or null if not bound.
     * @param pRef the fixed value of pattern parameter ref, or null if not bound.
     * @param pAttr the fixed value of pattern parameter attr, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static TestMultipleEdgesPL.Match newMatch(final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pParent, final PLElement pRef, final PLElement pAttr) {
      return new Immutable(pClazz, pParent, pRef, pAttr);
    }

    private static final class Mutable extends TestMultipleEdgesPL.Match {
      Mutable(final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pParent, final PLElement pRef, final PLElement pAttr) {
        super(pClazz, pParent, pRef, pAttr);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends TestMultipleEdgesPL.Match {
      Immutable(final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pParent, final PLElement pRef, final PLElement pAttr) {
        super(pClazz, pParent, pRef, pAttr);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the edu.toronto.cs.se.mmint.productline.viatra.tests.testMultipleEdgesPL pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern testMultipleEdgesPL(clazz: Class, parent: PLElement, ref: PLElement, attr: PLElement) {
   *   find reference(clazz, "Class", parent, "Class", ref, "superclass");
   *   find attribute(parent, "NamedElement", attr, "name", "parent2");
   * }
   * </pre></code>
   * 
   * @see Match
   * @see TestMultipleEdgesPL
   * 
   */
  public static class Matcher extends BaseMatcher<TestMultipleEdgesPL.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static TestMultipleEdgesPL.Matcher on(final ViatraQueryEngine engine) {
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
    public static TestMultipleEdgesPL.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_CLAZZ = 0;

    private static final int POSITION_PARENT = 1;

    private static final int POSITION_REF = 2;

    private static final int POSITION_ATTR = 3;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(TestMultipleEdgesPL.Matcher.class);

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
     * @param pParent the fixed value of pattern parameter parent, or null if not bound.
     * @param pRef the fixed value of pattern parameter ref, or null if not bound.
     * @param pAttr the fixed value of pattern parameter attr, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<TestMultipleEdgesPL.Match> getAllMatches(final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pParent, final PLElement pRef, final PLElement pAttr) {
      return rawStreamAllMatches(new Object[]{pClazz, pParent, pRef, pAttr}).collect(Collectors.toSet());
    }

    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @param pParent the fixed value of pattern parameter parent, or null if not bound.
     * @param pRef the fixed value of pattern parameter ref, or null if not bound.
     * @param pAttr the fixed value of pattern parameter attr, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<TestMultipleEdgesPL.Match> streamAllMatches(final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pParent, final PLElement pRef, final PLElement pAttr) {
      return rawStreamAllMatches(new Object[]{pClazz, pParent, pRef, pAttr});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @param pParent the fixed value of pattern parameter parent, or null if not bound.
     * @param pRef the fixed value of pattern parameter ref, or null if not bound.
     * @param pAttr the fixed value of pattern parameter attr, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<TestMultipleEdgesPL.Match> getOneArbitraryMatch(final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pParent, final PLElement pRef, final PLElement pAttr) {
      return rawGetOneArbitraryMatch(new Object[]{pClazz, pParent, pRef, pAttr});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @param pParent the fixed value of pattern parameter parent, or null if not bound.
     * @param pRef the fixed value of pattern parameter ref, or null if not bound.
     * @param pAttr the fixed value of pattern parameter attr, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pParent, final PLElement pRef, final PLElement pAttr) {
      return rawHasMatch(new Object[]{pClazz, pParent, pRef, pAttr});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @param pParent the fixed value of pattern parameter parent, or null if not bound.
     * @param pRef the fixed value of pattern parameter ref, or null if not bound.
     * @param pAttr the fixed value of pattern parameter attr, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pParent, final PLElement pRef, final PLElement pAttr) {
      return rawCountMatches(new Object[]{pClazz, pParent, pRef, pAttr});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @param pParent the fixed value of pattern parameter parent, or null if not bound.
     * @param pRef the fixed value of pattern parameter ref, or null if not bound.
     * @param pAttr the fixed value of pattern parameter attr, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pParent, final PLElement pRef, final PLElement pAttr, final Consumer<? super TestMultipleEdgesPL.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pClazz, pParent, pRef, pAttr}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @param pParent the fixed value of pattern parameter parent, or null if not bound.
     * @param pRef the fixed value of pattern parameter ref, or null if not bound.
     * @param pAttr the fixed value of pattern parameter attr, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public TestMultipleEdgesPL.Match newMatch(final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pParent, final PLElement pRef, final PLElement pAttr) {
      return TestMultipleEdgesPL.Match.newMatch(pClazz, pParent, pRef, pAttr);
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
    public Stream<edu.toronto.cs.se.mmint.productline.Class> streamAllValuesOfclazz(final TestMultipleEdgesPL.Match partialMatch) {
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
    public Stream<edu.toronto.cs.se.mmint.productline.Class> streamAllValuesOfclazz(final PLElement pParent, final PLElement pRef, final PLElement pAttr) {
      return rawStreamAllValuesOfclazz(new Object[]{null, pParent, pRef, pAttr});
    }

    /**
     * Retrieve the set of values that occur in matches for clazz.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Class> getAllValuesOfclazz(final TestMultipleEdgesPL.Match partialMatch) {
      return rawStreamAllValuesOfclazz(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for clazz.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Class> getAllValuesOfclazz(final PLElement pParent, final PLElement pRef, final PLElement pAttr) {
      return rawStreamAllValuesOfclazz(new Object[]{null, pParent, pRef, pAttr}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for parent.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<PLElement> rawStreamAllValuesOfparent(final Object[] parameters) {
      return rawStreamAllValues(POSITION_PARENT, parameters).map(PLElement.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for parent.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<PLElement> getAllValuesOfparent() {
      return rawStreamAllValuesOfparent(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for parent.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<PLElement> streamAllValuesOfparent() {
      return rawStreamAllValuesOfparent(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for parent.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<PLElement> streamAllValuesOfparent(final TestMultipleEdgesPL.Match partialMatch) {
      return rawStreamAllValuesOfparent(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for parent.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<PLElement> streamAllValuesOfparent(final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pRef, final PLElement pAttr) {
      return rawStreamAllValuesOfparent(new Object[]{pClazz, null, pRef, pAttr});
    }

    /**
     * Retrieve the set of values that occur in matches for parent.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<PLElement> getAllValuesOfparent(final TestMultipleEdgesPL.Match partialMatch) {
      return rawStreamAllValuesOfparent(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for parent.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<PLElement> getAllValuesOfparent(final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pRef, final PLElement pAttr) {
      return rawStreamAllValuesOfparent(new Object[]{pClazz, null, pRef, pAttr}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for ref.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<PLElement> rawStreamAllValuesOfref(final Object[] parameters) {
      return rawStreamAllValues(POSITION_REF, parameters).map(PLElement.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for ref.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<PLElement> getAllValuesOfref() {
      return rawStreamAllValuesOfref(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for ref.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<PLElement> streamAllValuesOfref() {
      return rawStreamAllValuesOfref(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for ref.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<PLElement> streamAllValuesOfref(final TestMultipleEdgesPL.Match partialMatch) {
      return rawStreamAllValuesOfref(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for ref.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<PLElement> streamAllValuesOfref(final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pParent, final PLElement pAttr) {
      return rawStreamAllValuesOfref(new Object[]{pClazz, pParent, null, pAttr});
    }

    /**
     * Retrieve the set of values that occur in matches for ref.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<PLElement> getAllValuesOfref(final TestMultipleEdgesPL.Match partialMatch) {
      return rawStreamAllValuesOfref(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for ref.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<PLElement> getAllValuesOfref(final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pParent, final PLElement pAttr) {
      return rawStreamAllValuesOfref(new Object[]{pClazz, pParent, null, pAttr}).collect(Collectors.toSet());
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
    public Stream<PLElement> streamAllValuesOfattr(final TestMultipleEdgesPL.Match partialMatch) {
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
    public Stream<PLElement> streamAllValuesOfattr(final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pParent, final PLElement pRef) {
      return rawStreamAllValuesOfattr(new Object[]{pClazz, pParent, pRef, null});
    }

    /**
     * Retrieve the set of values that occur in matches for attr.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<PLElement> getAllValuesOfattr(final TestMultipleEdgesPL.Match partialMatch) {
      return rawStreamAllValuesOfattr(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for attr.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<PLElement> getAllValuesOfattr(final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pParent, final PLElement pRef) {
      return rawStreamAllValuesOfattr(new Object[]{pClazz, pParent, pRef, null}).collect(Collectors.toSet());
    }

    @Override
    protected TestMultipleEdgesPL.Match tupleToMatch(final Tuple t) {
      try {
          return TestMultipleEdgesPL.Match.newMatch((edu.toronto.cs.se.mmint.productline.Class) t.get(POSITION_CLAZZ), (PLElement) t.get(POSITION_PARENT), (PLElement) t.get(POSITION_REF), (PLElement) t.get(POSITION_ATTR));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected TestMultipleEdgesPL.Match arrayToMatch(final Object[] match) {
      try {
          return TestMultipleEdgesPL.Match.newMatch((edu.toronto.cs.se.mmint.productline.Class) match[POSITION_CLAZZ], (PLElement) match[POSITION_PARENT], (PLElement) match[POSITION_REF], (PLElement) match[POSITION_ATTR]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected TestMultipleEdgesPL.Match arrayToMatchMutable(final Object[] match) {
      try {
          return TestMultipleEdgesPL.Match.newMutableMatch((edu.toronto.cs.se.mmint.productline.Class) match[POSITION_CLAZZ], (PLElement) match[POSITION_PARENT], (PLElement) match[POSITION_REF], (PLElement) match[POSITION_ATTR]);
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
    public static IQuerySpecification<TestMultipleEdgesPL.Matcher> querySpecification() {
      return TestMultipleEdgesPL.instance();
    }
  }

  private TestMultipleEdgesPL() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static TestMultipleEdgesPL instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected TestMultipleEdgesPL.Matcher instantiate(final ViatraQueryEngine engine) {
    return TestMultipleEdgesPL.Matcher.on(engine);
  }

  @Override
  public TestMultipleEdgesPL.Matcher instantiate() {
    return TestMultipleEdgesPL.Matcher.create();
  }

  @Override
  public TestMultipleEdgesPL.Match newEmptyMatch() {
    return TestMultipleEdgesPL.Match.newEmptyMatch();
  }

  @Override
  public TestMultipleEdgesPL.Match newMatch(final Object... parameters) {
    return TestMultipleEdgesPL.Match.newMatch((edu.toronto.cs.se.mmint.productline.Class) parameters[0], (edu.toronto.cs.se.mmint.productline.PLElement) parameters[1], (edu.toronto.cs.se.mmint.productline.PLElement) parameters[2], (edu.toronto.cs.se.mmint.productline.PLElement) parameters[3]);
  }

  /**
   * Inner class allowing the singleton instance of {@link TestMultipleEdgesPL} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link TestMultipleEdgesPL#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final TestMultipleEdgesPL INSTANCE = new TestMultipleEdgesPL();

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
    private static final TestMultipleEdgesPL.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_clazz = new PParameter("clazz", "edu.toronto.cs.se.mmint.productline.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("model://edu.toronto.cs.se.mmint.productline", "Class")), PParameterDirection.INOUT);

    private final PParameter parameter_parent = new PParameter("parent", "edu.toronto.cs.se.mmint.productline.PLElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("model://edu.toronto.cs.se.mmint.productline", "PLElement")), PParameterDirection.INOUT);

    private final PParameter parameter_ref = new PParameter("ref", "edu.toronto.cs.se.mmint.productline.PLElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("model://edu.toronto.cs.se.mmint.productline", "PLElement")), PParameterDirection.INOUT);

    private final PParameter parameter_attr = new PParameter("attr", "edu.toronto.cs.se.mmint.productline.PLElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("model://edu.toronto.cs.se.mmint.productline", "PLElement")), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_clazz, parameter_parent, parameter_ref, parameter_attr);

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "edu.toronto.cs.se.mmint.productline.viatra.tests.testMultipleEdgesPL";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("clazz","parent","ref","attr");
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
          PVariable var_parent = body.getOrCreateVariableByName("parent");
          PVariable var_ref = body.getOrCreateVariableByName("ref");
          PVariable var_attr = body.getOrCreateVariableByName("attr");
          new TypeConstraint(body, Tuples.flatTupleOf(var_clazz), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "Class")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_parent), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "PLElement")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_ref), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "PLElement")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_attr), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "PLElement")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_clazz, parameter_clazz),
             new ExportedParameter(body, var_parent, parameter_parent),
             new ExportedParameter(body, var_ref, parameter_ref),
             new ExportedParameter(body, var_attr, parameter_attr)
          ));
          //   find reference(clazz, "Class", parent, "Class", ref, "superclass")
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new ConstantValue(body, var__virtual_0_, "Class");
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new ConstantValue(body, var__virtual_1_, "Class");
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new ConstantValue(body, var__virtual_2_, "superclass");
          new PositivePatternCall(body, Tuples.flatTupleOf(var_clazz, var__virtual_0_, var_parent, var__virtual_1_, var_ref, var__virtual_2_), Reference.instance().getInternalQueryRepresentation());
          //   find attribute(parent, "NamedElement", attr, "name", "parent2")
          PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
          new ConstantValue(body, var__virtual_3_, "NamedElement");
          PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
          new ConstantValue(body, var__virtual_4_, "name");
          PVariable var__virtual_5_ = body.getOrCreateVariableByName(".virtual{5}");
          new ConstantValue(body, var__virtual_5_, "parent2");
          new PositivePatternCall(body, Tuples.flatTupleOf(var_parent, var__virtual_3_, var_attr, var__virtual_4_, var__virtual_5_), Attribute.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      return bodies;
    }
  }
}

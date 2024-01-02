/**
 * 
 *   Copyright (c) 2022, 2024 Alessio Di Sandro.
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
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Inequality;
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
 *         pattern multipleInheritancePL(child: Class, parent1: PLElement, parent2: PLElement, ref1: PLElement, ref2: PLElement) {
 *           find reference(child, "Class", parent1, "Class", ref1, "superclass");
 *           find reference(child, "Class", parent2, "Class", ref2, "superclass");
 *           parent1 != parent2;
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class MultipleInheritancePL extends BaseGeneratedEMFQuerySpecification<MultipleInheritancePL.Matcher> {
  /**
   * Pattern-specific match representation of the edu.toronto.cs.se.mmint.productline.viatra.tests.multipleInheritancePL pattern,
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
    private edu.toronto.cs.se.mmint.productline.Class fChild;

    private PLElement fParent1;

    private PLElement fParent2;

    private PLElement fRef1;

    private PLElement fRef2;

    private static List<String> parameterNames = makeImmutableList("child", "parent1", "parent2", "ref1", "ref2");

    private Match(final edu.toronto.cs.se.mmint.productline.Class pChild, final PLElement pParent1, final PLElement pParent2, final PLElement pRef1, final PLElement pRef2) {
      this.fChild = pChild;
      this.fParent1 = pParent1;
      this.fParent2 = pParent2;
      this.fRef1 = pRef1;
      this.fRef2 = pRef2;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "child": return this.fChild;
          case "parent1": return this.fParent1;
          case "parent2": return this.fParent2;
          case "ref1": return this.fRef1;
          case "ref2": return this.fRef2;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fChild;
          case 1: return this.fParent1;
          case 2: return this.fParent2;
          case 3: return this.fRef1;
          case 4: return this.fRef2;
          default: return null;
      }
    }

    public edu.toronto.cs.se.mmint.productline.Class getChild() {
      return this.fChild;
    }

    public PLElement getParent1() {
      return this.fParent1;
    }

    public PLElement getParent2() {
      return this.fParent2;
    }

    public PLElement getRef1() {
      return this.fRef1;
    }

    public PLElement getRef2() {
      return this.fRef2;
    }

    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("child".equals(parameterName) ) {
          this.fChild = (edu.toronto.cs.se.mmint.productline.Class) newValue;
          return true;
      }
      if ("parent1".equals(parameterName) ) {
          this.fParent1 = (PLElement) newValue;
          return true;
      }
      if ("parent2".equals(parameterName) ) {
          this.fParent2 = (PLElement) newValue;
          return true;
      }
      if ("ref1".equals(parameterName) ) {
          this.fRef1 = (PLElement) newValue;
          return true;
      }
      if ("ref2".equals(parameterName) ) {
          this.fRef2 = (PLElement) newValue;
          return true;
      }
      return false;
    }

    public void setChild(final edu.toronto.cs.se.mmint.productline.Class pChild) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fChild = pChild;
    }

    public void setParent1(final PLElement pParent1) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fParent1 = pParent1;
    }

    public void setParent2(final PLElement pParent2) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fParent2 = pParent2;
    }

    public void setRef1(final PLElement pRef1) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fRef1 = pRef1;
    }

    public void setRef2(final PLElement pRef2) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fRef2 = pRef2;
    }

    @Override
    public String patternName() {
      return "edu.toronto.cs.se.mmint.productline.viatra.tests.multipleInheritancePL";
    }

    @Override
    public List<String> parameterNames() {
      return MultipleInheritancePL.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fChild, fParent1, fParent2, fRef1, fRef2};
    }

    @Override
    public MultipleInheritancePL.Match toImmutable() {
      return isMutable() ? newMatch(fChild, fParent1, fParent2, fRef1, fRef2) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"child\"=" + prettyPrintValue(fChild) + ", ");
      result.append("\"parent1\"=" + prettyPrintValue(fParent1) + ", ");
      result.append("\"parent2\"=" + prettyPrintValue(fParent2) + ", ");
      result.append("\"ref1\"=" + prettyPrintValue(fRef1) + ", ");
      result.append("\"ref2\"=" + prettyPrintValue(fRef2));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fChild, fParent1, fParent2, fRef1, fRef2);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof MultipleInheritancePL.Match)) {
          MultipleInheritancePL.Match other = (MultipleInheritancePL.Match) obj;
          return Objects.equals(fChild, other.fChild) && Objects.equals(fParent1, other.fParent1) && Objects.equals(fParent2, other.fParent2) && Objects.equals(fRef1, other.fRef1) && Objects.equals(fRef2, other.fRef2);
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
    public MultipleInheritancePL specification() {
      return MultipleInheritancePL.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static MultipleInheritancePL.Match newEmptyMatch() {
      return new Mutable(null, null, null, null, null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pChild the fixed value of pattern parameter child, or null if not bound.
     * @param pParent1 the fixed value of pattern parameter parent1, or null if not bound.
     * @param pParent2 the fixed value of pattern parameter parent2, or null if not bound.
     * @param pRef1 the fixed value of pattern parameter ref1, or null if not bound.
     * @param pRef2 the fixed value of pattern parameter ref2, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static MultipleInheritancePL.Match newMutableMatch(final edu.toronto.cs.se.mmint.productline.Class pChild, final PLElement pParent1, final PLElement pParent2, final PLElement pRef1, final PLElement pRef2) {
      return new Mutable(pChild, pParent1, pParent2, pRef1, pRef2);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pChild the fixed value of pattern parameter child, or null if not bound.
     * @param pParent1 the fixed value of pattern parameter parent1, or null if not bound.
     * @param pParent2 the fixed value of pattern parameter parent2, or null if not bound.
     * @param pRef1 the fixed value of pattern parameter ref1, or null if not bound.
     * @param pRef2 the fixed value of pattern parameter ref2, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static MultipleInheritancePL.Match newMatch(final edu.toronto.cs.se.mmint.productline.Class pChild, final PLElement pParent1, final PLElement pParent2, final PLElement pRef1, final PLElement pRef2) {
      return new Immutable(pChild, pParent1, pParent2, pRef1, pRef2);
    }

    private static final class Mutable extends MultipleInheritancePL.Match {
      Mutable(final edu.toronto.cs.se.mmint.productline.Class pChild, final PLElement pParent1, final PLElement pParent2, final PLElement pRef1, final PLElement pRef2) {
        super(pChild, pParent1, pParent2, pRef1, pRef2);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends MultipleInheritancePL.Match {
      Immutable(final edu.toronto.cs.se.mmint.productline.Class pChild, final PLElement pParent1, final PLElement pParent2, final PLElement pRef1, final PLElement pRef2) {
        super(pChild, pParent1, pParent2, pRef1, pRef2);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the edu.toronto.cs.se.mmint.productline.viatra.tests.multipleInheritancePL pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern multipleInheritancePL(child: Class, parent1: PLElement, parent2: PLElement, ref1: PLElement, ref2: PLElement) {
   *   find reference(child, "Class", parent1, "Class", ref1, "superclass");
   *   find reference(child, "Class", parent2, "Class", ref2, "superclass");
   *   parent1 != parent2;
   * }
   * </pre></code>
   * 
   * @see Match
   * @see MultipleInheritancePL
   * 
   */
  public static class Matcher extends BaseMatcher<MultipleInheritancePL.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static MultipleInheritancePL.Matcher on(final ViatraQueryEngine engine) {
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
    public static MultipleInheritancePL.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_CHILD = 0;

    private static final int POSITION_PARENT1 = 1;

    private static final int POSITION_PARENT2 = 2;

    private static final int POSITION_REF1 = 3;

    private static final int POSITION_REF2 = 4;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(MultipleInheritancePL.Matcher.class);

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
     * @param pChild the fixed value of pattern parameter child, or null if not bound.
     * @param pParent1 the fixed value of pattern parameter parent1, or null if not bound.
     * @param pParent2 the fixed value of pattern parameter parent2, or null if not bound.
     * @param pRef1 the fixed value of pattern parameter ref1, or null if not bound.
     * @param pRef2 the fixed value of pattern parameter ref2, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<MultipleInheritancePL.Match> getAllMatches(final edu.toronto.cs.se.mmint.productline.Class pChild, final PLElement pParent1, final PLElement pParent2, final PLElement pRef1, final PLElement pRef2) {
      return rawStreamAllMatches(new Object[]{pChild, pParent1, pParent2, pRef1, pRef2}).collect(Collectors.toSet());
    }

    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pChild the fixed value of pattern parameter child, or null if not bound.
     * @param pParent1 the fixed value of pattern parameter parent1, or null if not bound.
     * @param pParent2 the fixed value of pattern parameter parent2, or null if not bound.
     * @param pRef1 the fixed value of pattern parameter ref1, or null if not bound.
     * @param pRef2 the fixed value of pattern parameter ref2, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<MultipleInheritancePL.Match> streamAllMatches(final edu.toronto.cs.se.mmint.productline.Class pChild, final PLElement pParent1, final PLElement pParent2, final PLElement pRef1, final PLElement pRef2) {
      return rawStreamAllMatches(new Object[]{pChild, pParent1, pParent2, pRef1, pRef2});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pChild the fixed value of pattern parameter child, or null if not bound.
     * @param pParent1 the fixed value of pattern parameter parent1, or null if not bound.
     * @param pParent2 the fixed value of pattern parameter parent2, or null if not bound.
     * @param pRef1 the fixed value of pattern parameter ref1, or null if not bound.
     * @param pRef2 the fixed value of pattern parameter ref2, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<MultipleInheritancePL.Match> getOneArbitraryMatch(final edu.toronto.cs.se.mmint.productline.Class pChild, final PLElement pParent1, final PLElement pParent2, final PLElement pRef1, final PLElement pRef2) {
      return rawGetOneArbitraryMatch(new Object[]{pChild, pParent1, pParent2, pRef1, pRef2});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pChild the fixed value of pattern parameter child, or null if not bound.
     * @param pParent1 the fixed value of pattern parameter parent1, or null if not bound.
     * @param pParent2 the fixed value of pattern parameter parent2, or null if not bound.
     * @param pRef1 the fixed value of pattern parameter ref1, or null if not bound.
     * @param pRef2 the fixed value of pattern parameter ref2, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final edu.toronto.cs.se.mmint.productline.Class pChild, final PLElement pParent1, final PLElement pParent2, final PLElement pRef1, final PLElement pRef2) {
      return rawHasMatch(new Object[]{pChild, pParent1, pParent2, pRef1, pRef2});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pChild the fixed value of pattern parameter child, or null if not bound.
     * @param pParent1 the fixed value of pattern parameter parent1, or null if not bound.
     * @param pParent2 the fixed value of pattern parameter parent2, or null if not bound.
     * @param pRef1 the fixed value of pattern parameter ref1, or null if not bound.
     * @param pRef2 the fixed value of pattern parameter ref2, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final edu.toronto.cs.se.mmint.productline.Class pChild, final PLElement pParent1, final PLElement pParent2, final PLElement pRef1, final PLElement pRef2) {
      return rawCountMatches(new Object[]{pChild, pParent1, pParent2, pRef1, pRef2});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pChild the fixed value of pattern parameter child, or null if not bound.
     * @param pParent1 the fixed value of pattern parameter parent1, or null if not bound.
     * @param pParent2 the fixed value of pattern parameter parent2, or null if not bound.
     * @param pRef1 the fixed value of pattern parameter ref1, or null if not bound.
     * @param pRef2 the fixed value of pattern parameter ref2, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final edu.toronto.cs.se.mmint.productline.Class pChild, final PLElement pParent1, final PLElement pParent2, final PLElement pRef1, final PLElement pRef2, final Consumer<? super MultipleInheritancePL.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pChild, pParent1, pParent2, pRef1, pRef2}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pChild the fixed value of pattern parameter child, or null if not bound.
     * @param pParent1 the fixed value of pattern parameter parent1, or null if not bound.
     * @param pParent2 the fixed value of pattern parameter parent2, or null if not bound.
     * @param pRef1 the fixed value of pattern parameter ref1, or null if not bound.
     * @param pRef2 the fixed value of pattern parameter ref2, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public MultipleInheritancePL.Match newMatch(final edu.toronto.cs.se.mmint.productline.Class pChild, final PLElement pParent1, final PLElement pParent2, final PLElement pRef1, final PLElement pRef2) {
      return MultipleInheritancePL.Match.newMatch(pChild, pParent1, pParent2, pRef1, pRef2);
    }

    /**
     * Retrieve the set of values that occur in matches for child.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<edu.toronto.cs.se.mmint.productline.Class> rawStreamAllValuesOfchild(final Object[] parameters) {
      return rawStreamAllValues(POSITION_CHILD, parameters).map(edu.toronto.cs.se.mmint.productline.Class.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for child.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Class> getAllValuesOfchild() {
      return rawStreamAllValuesOfchild(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for child.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.mmint.productline.Class> streamAllValuesOfchild() {
      return rawStreamAllValuesOfchild(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for child.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.mmint.productline.Class> streamAllValuesOfchild(final MultipleInheritancePL.Match partialMatch) {
      return rawStreamAllValuesOfchild(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for child.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.mmint.productline.Class> streamAllValuesOfchild(final PLElement pParent1, final PLElement pParent2, final PLElement pRef1, final PLElement pRef2) {
      return rawStreamAllValuesOfchild(new Object[]{null, pParent1, pParent2, pRef1, pRef2});
    }

    /**
     * Retrieve the set of values that occur in matches for child.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Class> getAllValuesOfchild(final MultipleInheritancePL.Match partialMatch) {
      return rawStreamAllValuesOfchild(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for child.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Class> getAllValuesOfchild(final PLElement pParent1, final PLElement pParent2, final PLElement pRef1, final PLElement pRef2) {
      return rawStreamAllValuesOfchild(new Object[]{null, pParent1, pParent2, pRef1, pRef2}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for parent1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<PLElement> rawStreamAllValuesOfparent1(final Object[] parameters) {
      return rawStreamAllValues(POSITION_PARENT1, parameters).map(PLElement.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for parent1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<PLElement> getAllValuesOfparent1() {
      return rawStreamAllValuesOfparent1(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for parent1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<PLElement> streamAllValuesOfparent1() {
      return rawStreamAllValuesOfparent1(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for parent1.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<PLElement> streamAllValuesOfparent1(final MultipleInheritancePL.Match partialMatch) {
      return rawStreamAllValuesOfparent1(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for parent1.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<PLElement> streamAllValuesOfparent1(final edu.toronto.cs.se.mmint.productline.Class pChild, final PLElement pParent2, final PLElement pRef1, final PLElement pRef2) {
      return rawStreamAllValuesOfparent1(new Object[]{pChild, null, pParent2, pRef1, pRef2});
    }

    /**
     * Retrieve the set of values that occur in matches for parent1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<PLElement> getAllValuesOfparent1(final MultipleInheritancePL.Match partialMatch) {
      return rawStreamAllValuesOfparent1(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for parent1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<PLElement> getAllValuesOfparent1(final edu.toronto.cs.se.mmint.productline.Class pChild, final PLElement pParent2, final PLElement pRef1, final PLElement pRef2) {
      return rawStreamAllValuesOfparent1(new Object[]{pChild, null, pParent2, pRef1, pRef2}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for parent2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<PLElement> rawStreamAllValuesOfparent2(final Object[] parameters) {
      return rawStreamAllValues(POSITION_PARENT2, parameters).map(PLElement.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for parent2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<PLElement> getAllValuesOfparent2() {
      return rawStreamAllValuesOfparent2(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for parent2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<PLElement> streamAllValuesOfparent2() {
      return rawStreamAllValuesOfparent2(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for parent2.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<PLElement> streamAllValuesOfparent2(final MultipleInheritancePL.Match partialMatch) {
      return rawStreamAllValuesOfparent2(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for parent2.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<PLElement> streamAllValuesOfparent2(final edu.toronto.cs.se.mmint.productline.Class pChild, final PLElement pParent1, final PLElement pRef1, final PLElement pRef2) {
      return rawStreamAllValuesOfparent2(new Object[]{pChild, pParent1, null, pRef1, pRef2});
    }

    /**
     * Retrieve the set of values that occur in matches for parent2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<PLElement> getAllValuesOfparent2(final MultipleInheritancePL.Match partialMatch) {
      return rawStreamAllValuesOfparent2(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for parent2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<PLElement> getAllValuesOfparent2(final edu.toronto.cs.se.mmint.productline.Class pChild, final PLElement pParent1, final PLElement pRef1, final PLElement pRef2) {
      return rawStreamAllValuesOfparent2(new Object[]{pChild, pParent1, null, pRef1, pRef2}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for ref1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<PLElement> rawStreamAllValuesOfref1(final Object[] parameters) {
      return rawStreamAllValues(POSITION_REF1, parameters).map(PLElement.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for ref1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<PLElement> getAllValuesOfref1() {
      return rawStreamAllValuesOfref1(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for ref1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<PLElement> streamAllValuesOfref1() {
      return rawStreamAllValuesOfref1(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for ref1.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<PLElement> streamAllValuesOfref1(final MultipleInheritancePL.Match partialMatch) {
      return rawStreamAllValuesOfref1(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for ref1.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<PLElement> streamAllValuesOfref1(final edu.toronto.cs.se.mmint.productline.Class pChild, final PLElement pParent1, final PLElement pParent2, final PLElement pRef2) {
      return rawStreamAllValuesOfref1(new Object[]{pChild, pParent1, pParent2, null, pRef2});
    }

    /**
     * Retrieve the set of values that occur in matches for ref1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<PLElement> getAllValuesOfref1(final MultipleInheritancePL.Match partialMatch) {
      return rawStreamAllValuesOfref1(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for ref1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<PLElement> getAllValuesOfref1(final edu.toronto.cs.se.mmint.productline.Class pChild, final PLElement pParent1, final PLElement pParent2, final PLElement pRef2) {
      return rawStreamAllValuesOfref1(new Object[]{pChild, pParent1, pParent2, null, pRef2}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for ref2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<PLElement> rawStreamAllValuesOfref2(final Object[] parameters) {
      return rawStreamAllValues(POSITION_REF2, parameters).map(PLElement.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for ref2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<PLElement> getAllValuesOfref2() {
      return rawStreamAllValuesOfref2(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for ref2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<PLElement> streamAllValuesOfref2() {
      return rawStreamAllValuesOfref2(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for ref2.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<PLElement> streamAllValuesOfref2(final MultipleInheritancePL.Match partialMatch) {
      return rawStreamAllValuesOfref2(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for ref2.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<PLElement> streamAllValuesOfref2(final edu.toronto.cs.se.mmint.productline.Class pChild, final PLElement pParent1, final PLElement pParent2, final PLElement pRef1) {
      return rawStreamAllValuesOfref2(new Object[]{pChild, pParent1, pParent2, pRef1, null});
    }

    /**
     * Retrieve the set of values that occur in matches for ref2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<PLElement> getAllValuesOfref2(final MultipleInheritancePL.Match partialMatch) {
      return rawStreamAllValuesOfref2(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for ref2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<PLElement> getAllValuesOfref2(final edu.toronto.cs.se.mmint.productline.Class pChild, final PLElement pParent1, final PLElement pParent2, final PLElement pRef1) {
      return rawStreamAllValuesOfref2(new Object[]{pChild, pParent1, pParent2, pRef1, null}).collect(Collectors.toSet());
    }

    @Override
    protected MultipleInheritancePL.Match tupleToMatch(final Tuple t) {
      try {
          return MultipleInheritancePL.Match.newMatch((edu.toronto.cs.se.mmint.productline.Class) t.get(POSITION_CHILD), (PLElement) t.get(POSITION_PARENT1), (PLElement) t.get(POSITION_PARENT2), (PLElement) t.get(POSITION_REF1), (PLElement) t.get(POSITION_REF2));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected MultipleInheritancePL.Match arrayToMatch(final Object[] match) {
      try {
          return MultipleInheritancePL.Match.newMatch((edu.toronto.cs.se.mmint.productline.Class) match[POSITION_CHILD], (PLElement) match[POSITION_PARENT1], (PLElement) match[POSITION_PARENT2], (PLElement) match[POSITION_REF1], (PLElement) match[POSITION_REF2]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected MultipleInheritancePL.Match arrayToMatchMutable(final Object[] match) {
      try {
          return MultipleInheritancePL.Match.newMutableMatch((edu.toronto.cs.se.mmint.productline.Class) match[POSITION_CHILD], (PLElement) match[POSITION_PARENT1], (PLElement) match[POSITION_PARENT2], (PLElement) match[POSITION_REF1], (PLElement) match[POSITION_REF2]);
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
    public static IQuerySpecification<MultipleInheritancePL.Matcher> querySpecification() {
      return MultipleInheritancePL.instance();
    }
  }

  private MultipleInheritancePL() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static MultipleInheritancePL instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected MultipleInheritancePL.Matcher instantiate(final ViatraQueryEngine engine) {
    return MultipleInheritancePL.Matcher.on(engine);
  }

  @Override
  public MultipleInheritancePL.Matcher instantiate() {
    return MultipleInheritancePL.Matcher.create();
  }

  @Override
  public MultipleInheritancePL.Match newEmptyMatch() {
    return MultipleInheritancePL.Match.newEmptyMatch();
  }

  @Override
  public MultipleInheritancePL.Match newMatch(final Object... parameters) {
    return MultipleInheritancePL.Match.newMatch((edu.toronto.cs.se.mmint.productline.Class) parameters[0], (edu.toronto.cs.se.mmint.productline.PLElement) parameters[1], (edu.toronto.cs.se.mmint.productline.PLElement) parameters[2], (edu.toronto.cs.se.mmint.productline.PLElement) parameters[3], (edu.toronto.cs.se.mmint.productline.PLElement) parameters[4]);
  }

  /**
   * Inner class allowing the singleton instance of {@link MultipleInheritancePL} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link MultipleInheritancePL#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final MultipleInheritancePL INSTANCE = new MultipleInheritancePL();

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
    private static final MultipleInheritancePL.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_child = new PParameter("child", "edu.toronto.cs.se.mmint.productline.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("model://edu.toronto.cs.se.mmint.productline", "Class")), PParameterDirection.INOUT);

    private final PParameter parameter_parent1 = new PParameter("parent1", "edu.toronto.cs.se.mmint.productline.PLElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("model://edu.toronto.cs.se.mmint.productline", "PLElement")), PParameterDirection.INOUT);

    private final PParameter parameter_parent2 = new PParameter("parent2", "edu.toronto.cs.se.mmint.productline.PLElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("model://edu.toronto.cs.se.mmint.productline", "PLElement")), PParameterDirection.INOUT);

    private final PParameter parameter_ref1 = new PParameter("ref1", "edu.toronto.cs.se.mmint.productline.PLElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("model://edu.toronto.cs.se.mmint.productline", "PLElement")), PParameterDirection.INOUT);

    private final PParameter parameter_ref2 = new PParameter("ref2", "edu.toronto.cs.se.mmint.productline.PLElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("model://edu.toronto.cs.se.mmint.productline", "PLElement")), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_child, parameter_parent1, parameter_parent2, parameter_ref1, parameter_ref2);

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "edu.toronto.cs.se.mmint.productline.viatra.tests.multipleInheritancePL";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("child","parent1","parent2","ref1","ref2");
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
          PVariable var_child = body.getOrCreateVariableByName("child");
          PVariable var_parent1 = body.getOrCreateVariableByName("parent1");
          PVariable var_parent2 = body.getOrCreateVariableByName("parent2");
          PVariable var_ref1 = body.getOrCreateVariableByName("ref1");
          PVariable var_ref2 = body.getOrCreateVariableByName("ref2");
          new TypeConstraint(body, Tuples.flatTupleOf(var_child), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "Class")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_parent1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "PLElement")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_parent2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "PLElement")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_ref1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "PLElement")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_ref2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "PLElement")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_child, parameter_child),
             new ExportedParameter(body, var_parent1, parameter_parent1),
             new ExportedParameter(body, var_parent2, parameter_parent2),
             new ExportedParameter(body, var_ref1, parameter_ref1),
             new ExportedParameter(body, var_ref2, parameter_ref2)
          ));
          //   find reference(child, "Class", parent1, "Class", ref1, "superclass")
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new ConstantValue(body, var__virtual_0_, "Class");
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new ConstantValue(body, var__virtual_1_, "Class");
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new ConstantValue(body, var__virtual_2_, "superclass");
          new PositivePatternCall(body, Tuples.flatTupleOf(var_child, var__virtual_0_, var_parent1, var__virtual_1_, var_ref1, var__virtual_2_), Reference.instance().getInternalQueryRepresentation());
          //   find reference(child, "Class", parent2, "Class", ref2, "superclass")
          PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
          new ConstantValue(body, var__virtual_3_, "Class");
          PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
          new ConstantValue(body, var__virtual_4_, "Class");
          PVariable var__virtual_5_ = body.getOrCreateVariableByName(".virtual{5}");
          new ConstantValue(body, var__virtual_5_, "superclass");
          new PositivePatternCall(body, Tuples.flatTupleOf(var_child, var__virtual_3_, var_parent2, var__virtual_4_, var_ref2, var__virtual_5_), Reference.instance().getInternalQueryRepresentation());
          //   parent1 != parent2
          new Inequality(body, var_parent1, var_parent2);
          bodies.add(body);
      }
      return bodies;
    }
  }
}

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

import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.productline.PLElement;
import edu.toronto.cs.se.mmint.productline.viatra.Attribute;
import edu.toronto.cs.se.mmint.productline.viatra.ClassType;
import edu.toronto.cs.se.mmint.productline.viatra.Reference;
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
 *         pattern asilBConnectedClassesPL(goal: Class, clazz: Class, asil: PLElement, ref: PLElement, attr: PLElement, mapping: Mapping) {
 *           find reference(goal, "Goal", asil, "ASIL", ref, "asil");
 *           find attribute(asil, "ASIL", attr, "value", "B");
 *           find connectedEMFObjectsWithMapping(goal, clazz, mapping);
 *           find classType(goal, "Goal");
 *           find classType(clazz, "Class");
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class AsilBConnectedClassesPL extends BaseGeneratedEMFQuerySpecification<AsilBConnectedClassesPL.Matcher> {
  /**
   * Pattern-specific match representation of the edu.toronto.cs.se.mmint.productline.viatra.tests.asilBConnectedClassesPL pattern,
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
    private edu.toronto.cs.se.mmint.productline.Class fGoal;

    private edu.toronto.cs.se.mmint.productline.Class fClazz;

    private PLElement fAsil;

    private PLElement fRef;

    private PLElement fAttr;

    private Mapping fMapping;

    private static List<String> parameterNames = makeImmutableList("goal", "clazz", "asil", "ref", "attr", "mapping");

    private Match(final edu.toronto.cs.se.mmint.productline.Class pGoal, final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pAsil, final PLElement pRef, final PLElement pAttr, final Mapping pMapping) {
      this.fGoal = pGoal;
      this.fClazz = pClazz;
      this.fAsil = pAsil;
      this.fRef = pRef;
      this.fAttr = pAttr;
      this.fMapping = pMapping;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "goal": return this.fGoal;
          case "clazz": return this.fClazz;
          case "asil": return this.fAsil;
          case "ref": return this.fRef;
          case "attr": return this.fAttr;
          case "mapping": return this.fMapping;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fGoal;
          case 1: return this.fClazz;
          case 2: return this.fAsil;
          case 3: return this.fRef;
          case 4: return this.fAttr;
          case 5: return this.fMapping;
          default: return null;
      }
    }

    public edu.toronto.cs.se.mmint.productline.Class getGoal() {
      return this.fGoal;
    }

    public edu.toronto.cs.se.mmint.productline.Class getClazz() {
      return this.fClazz;
    }

    public PLElement getAsil() {
      return this.fAsil;
    }

    public PLElement getRef() {
      return this.fRef;
    }

    public PLElement getAttr() {
      return this.fAttr;
    }

    public Mapping getMapping() {
      return this.fMapping;
    }

    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("goal".equals(parameterName) ) {
          this.fGoal = (edu.toronto.cs.se.mmint.productline.Class) newValue;
          return true;
      }
      if ("clazz".equals(parameterName) ) {
          this.fClazz = (edu.toronto.cs.se.mmint.productline.Class) newValue;
          return true;
      }
      if ("asil".equals(parameterName) ) {
          this.fAsil = (PLElement) newValue;
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
      if ("mapping".equals(parameterName) ) {
          this.fMapping = (Mapping) newValue;
          return true;
      }
      return false;
    }

    public void setGoal(final edu.toronto.cs.se.mmint.productline.Class pGoal) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fGoal = pGoal;
    }

    public void setClazz(final edu.toronto.cs.se.mmint.productline.Class pClazz) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fClazz = pClazz;
    }

    public void setAsil(final PLElement pAsil) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fAsil = pAsil;
    }

    public void setRef(final PLElement pRef) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fRef = pRef;
    }

    public void setAttr(final PLElement pAttr) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fAttr = pAttr;
    }

    public void setMapping(final Mapping pMapping) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fMapping = pMapping;
    }

    @Override
    public String patternName() {
      return "edu.toronto.cs.se.mmint.productline.viatra.tests.asilBConnectedClassesPL";
    }

    @Override
    public List<String> parameterNames() {
      return AsilBConnectedClassesPL.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fGoal, fClazz, fAsil, fRef, fAttr, fMapping};
    }

    @Override
    public AsilBConnectedClassesPL.Match toImmutable() {
      return isMutable() ? newMatch(fGoal, fClazz, fAsil, fRef, fAttr, fMapping) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"goal\"=" + prettyPrintValue(fGoal) + ", ");
      result.append("\"clazz\"=" + prettyPrintValue(fClazz) + ", ");
      result.append("\"asil\"=" + prettyPrintValue(fAsil) + ", ");
      result.append("\"ref\"=" + prettyPrintValue(fRef) + ", ");
      result.append("\"attr\"=" + prettyPrintValue(fAttr) + ", ");
      result.append("\"mapping\"=" + prettyPrintValue(fMapping));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fGoal, fClazz, fAsil, fRef, fAttr, fMapping);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof AsilBConnectedClassesPL.Match)) {
          AsilBConnectedClassesPL.Match other = (AsilBConnectedClassesPL.Match) obj;
          return Objects.equals(fGoal, other.fGoal) && Objects.equals(fClazz, other.fClazz) && Objects.equals(fAsil, other.fAsil) && Objects.equals(fRef, other.fRef) && Objects.equals(fAttr, other.fAttr) && Objects.equals(fMapping, other.fMapping);
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
    public AsilBConnectedClassesPL specification() {
      return AsilBConnectedClassesPL.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static AsilBConnectedClassesPL.Match newEmptyMatch() {
      return new Mutable(null, null, null, null, null, null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pGoal the fixed value of pattern parameter goal, or null if not bound.
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @param pAsil the fixed value of pattern parameter asil, or null if not bound.
     * @param pRef the fixed value of pattern parameter ref, or null if not bound.
     * @param pAttr the fixed value of pattern parameter attr, or null if not bound.
     * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static AsilBConnectedClassesPL.Match newMutableMatch(final edu.toronto.cs.se.mmint.productline.Class pGoal, final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pAsil, final PLElement pRef, final PLElement pAttr, final Mapping pMapping) {
      return new Mutable(pGoal, pClazz, pAsil, pRef, pAttr, pMapping);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pGoal the fixed value of pattern parameter goal, or null if not bound.
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @param pAsil the fixed value of pattern parameter asil, or null if not bound.
     * @param pRef the fixed value of pattern parameter ref, or null if not bound.
     * @param pAttr the fixed value of pattern parameter attr, or null if not bound.
     * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static AsilBConnectedClassesPL.Match newMatch(final edu.toronto.cs.se.mmint.productline.Class pGoal, final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pAsil, final PLElement pRef, final PLElement pAttr, final Mapping pMapping) {
      return new Immutable(pGoal, pClazz, pAsil, pRef, pAttr, pMapping);
    }

    private static final class Mutable extends AsilBConnectedClassesPL.Match {
      Mutable(final edu.toronto.cs.se.mmint.productline.Class pGoal, final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pAsil, final PLElement pRef, final PLElement pAttr, final Mapping pMapping) {
        super(pGoal, pClazz, pAsil, pRef, pAttr, pMapping);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends AsilBConnectedClassesPL.Match {
      Immutable(final edu.toronto.cs.se.mmint.productline.Class pGoal, final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pAsil, final PLElement pRef, final PLElement pAttr, final Mapping pMapping) {
        super(pGoal, pClazz, pAsil, pRef, pAttr, pMapping);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the edu.toronto.cs.se.mmint.productline.viatra.tests.asilBConnectedClassesPL pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern asilBConnectedClassesPL(goal: Class, clazz: Class, asil: PLElement, ref: PLElement, attr: PLElement, mapping: Mapping) {
   *   find reference(goal, "Goal", asil, "ASIL", ref, "asil");
   *   find attribute(asil, "ASIL", attr, "value", "B");
   *   find connectedEMFObjectsWithMapping(goal, clazz, mapping);
   *   find classType(goal, "Goal");
   *   find classType(clazz, "Class");
   * }
   * </pre></code>
   * 
   * @see Match
   * @see AsilBConnectedClassesPL
   * 
   */
  public static class Matcher extends BaseMatcher<AsilBConnectedClassesPL.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static AsilBConnectedClassesPL.Matcher on(final ViatraQueryEngine engine) {
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
    public static AsilBConnectedClassesPL.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_GOAL = 0;

    private static final int POSITION_CLAZZ = 1;

    private static final int POSITION_ASIL = 2;

    private static final int POSITION_REF = 3;

    private static final int POSITION_ATTR = 4;

    private static final int POSITION_MAPPING = 5;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(AsilBConnectedClassesPL.Matcher.class);

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
     * @param pGoal the fixed value of pattern parameter goal, or null if not bound.
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @param pAsil the fixed value of pattern parameter asil, or null if not bound.
     * @param pRef the fixed value of pattern parameter ref, or null if not bound.
     * @param pAttr the fixed value of pattern parameter attr, or null if not bound.
     * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<AsilBConnectedClassesPL.Match> getAllMatches(final edu.toronto.cs.se.mmint.productline.Class pGoal, final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pAsil, final PLElement pRef, final PLElement pAttr, final Mapping pMapping) {
      return rawStreamAllMatches(new Object[]{pGoal, pClazz, pAsil, pRef, pAttr, pMapping}).collect(Collectors.toSet());
    }

    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pGoal the fixed value of pattern parameter goal, or null if not bound.
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @param pAsil the fixed value of pattern parameter asil, or null if not bound.
     * @param pRef the fixed value of pattern parameter ref, or null if not bound.
     * @param pAttr the fixed value of pattern parameter attr, or null if not bound.
     * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<AsilBConnectedClassesPL.Match> streamAllMatches(final edu.toronto.cs.se.mmint.productline.Class pGoal, final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pAsil, final PLElement pRef, final PLElement pAttr, final Mapping pMapping) {
      return rawStreamAllMatches(new Object[]{pGoal, pClazz, pAsil, pRef, pAttr, pMapping});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pGoal the fixed value of pattern parameter goal, or null if not bound.
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @param pAsil the fixed value of pattern parameter asil, or null if not bound.
     * @param pRef the fixed value of pattern parameter ref, or null if not bound.
     * @param pAttr the fixed value of pattern parameter attr, or null if not bound.
     * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<AsilBConnectedClassesPL.Match> getOneArbitraryMatch(final edu.toronto.cs.se.mmint.productline.Class pGoal, final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pAsil, final PLElement pRef, final PLElement pAttr, final Mapping pMapping) {
      return rawGetOneArbitraryMatch(new Object[]{pGoal, pClazz, pAsil, pRef, pAttr, pMapping});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pGoal the fixed value of pattern parameter goal, or null if not bound.
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @param pAsil the fixed value of pattern parameter asil, or null if not bound.
     * @param pRef the fixed value of pattern parameter ref, or null if not bound.
     * @param pAttr the fixed value of pattern parameter attr, or null if not bound.
     * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final edu.toronto.cs.se.mmint.productline.Class pGoal, final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pAsil, final PLElement pRef, final PLElement pAttr, final Mapping pMapping) {
      return rawHasMatch(new Object[]{pGoal, pClazz, pAsil, pRef, pAttr, pMapping});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pGoal the fixed value of pattern parameter goal, or null if not bound.
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @param pAsil the fixed value of pattern parameter asil, or null if not bound.
     * @param pRef the fixed value of pattern parameter ref, or null if not bound.
     * @param pAttr the fixed value of pattern parameter attr, or null if not bound.
     * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final edu.toronto.cs.se.mmint.productline.Class pGoal, final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pAsil, final PLElement pRef, final PLElement pAttr, final Mapping pMapping) {
      return rawCountMatches(new Object[]{pGoal, pClazz, pAsil, pRef, pAttr, pMapping});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pGoal the fixed value of pattern parameter goal, or null if not bound.
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @param pAsil the fixed value of pattern parameter asil, or null if not bound.
     * @param pRef the fixed value of pattern parameter ref, or null if not bound.
     * @param pAttr the fixed value of pattern parameter attr, or null if not bound.
     * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final edu.toronto.cs.se.mmint.productline.Class pGoal, final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pAsil, final PLElement pRef, final PLElement pAttr, final Mapping pMapping, final Consumer<? super AsilBConnectedClassesPL.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pGoal, pClazz, pAsil, pRef, pAttr, pMapping}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pGoal the fixed value of pattern parameter goal, or null if not bound.
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @param pAsil the fixed value of pattern parameter asil, or null if not bound.
     * @param pRef the fixed value of pattern parameter ref, or null if not bound.
     * @param pAttr the fixed value of pattern parameter attr, or null if not bound.
     * @param pMapping the fixed value of pattern parameter mapping, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public AsilBConnectedClassesPL.Match newMatch(final edu.toronto.cs.se.mmint.productline.Class pGoal, final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pAsil, final PLElement pRef, final PLElement pAttr, final Mapping pMapping) {
      return AsilBConnectedClassesPL.Match.newMatch(pGoal, pClazz, pAsil, pRef, pAttr, pMapping);
    }

    /**
     * Retrieve the set of values that occur in matches for goal.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<edu.toronto.cs.se.mmint.productline.Class> rawStreamAllValuesOfgoal(final Object[] parameters) {
      return rawStreamAllValues(POSITION_GOAL, parameters).map(edu.toronto.cs.se.mmint.productline.Class.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for goal.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Class> getAllValuesOfgoal() {
      return rawStreamAllValuesOfgoal(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for goal.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.mmint.productline.Class> streamAllValuesOfgoal() {
      return rawStreamAllValuesOfgoal(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for goal.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.mmint.productline.Class> streamAllValuesOfgoal(final AsilBConnectedClassesPL.Match partialMatch) {
      return rawStreamAllValuesOfgoal(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for goal.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.mmint.productline.Class> streamAllValuesOfgoal(final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pAsil, final PLElement pRef, final PLElement pAttr, final Mapping pMapping) {
      return rawStreamAllValuesOfgoal(new Object[]{null, pClazz, pAsil, pRef, pAttr, pMapping});
    }

    /**
     * Retrieve the set of values that occur in matches for goal.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Class> getAllValuesOfgoal(final AsilBConnectedClassesPL.Match partialMatch) {
      return rawStreamAllValuesOfgoal(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for goal.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Class> getAllValuesOfgoal(final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pAsil, final PLElement pRef, final PLElement pAttr, final Mapping pMapping) {
      return rawStreamAllValuesOfgoal(new Object[]{null, pClazz, pAsil, pRef, pAttr, pMapping}).collect(Collectors.toSet());
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
    public Stream<edu.toronto.cs.se.mmint.productline.Class> streamAllValuesOfclazz(final AsilBConnectedClassesPL.Match partialMatch) {
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
    public Stream<edu.toronto.cs.se.mmint.productline.Class> streamAllValuesOfclazz(final edu.toronto.cs.se.mmint.productline.Class pGoal, final PLElement pAsil, final PLElement pRef, final PLElement pAttr, final Mapping pMapping) {
      return rawStreamAllValuesOfclazz(new Object[]{pGoal, null, pAsil, pRef, pAttr, pMapping});
    }

    /**
     * Retrieve the set of values that occur in matches for clazz.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Class> getAllValuesOfclazz(final AsilBConnectedClassesPL.Match partialMatch) {
      return rawStreamAllValuesOfclazz(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for clazz.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Class> getAllValuesOfclazz(final edu.toronto.cs.se.mmint.productline.Class pGoal, final PLElement pAsil, final PLElement pRef, final PLElement pAttr, final Mapping pMapping) {
      return rawStreamAllValuesOfclazz(new Object[]{pGoal, null, pAsil, pRef, pAttr, pMapping}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for asil.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<PLElement> rawStreamAllValuesOfasil(final Object[] parameters) {
      return rawStreamAllValues(POSITION_ASIL, parameters).map(PLElement.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for asil.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<PLElement> getAllValuesOfasil() {
      return rawStreamAllValuesOfasil(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for asil.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<PLElement> streamAllValuesOfasil() {
      return rawStreamAllValuesOfasil(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for asil.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<PLElement> streamAllValuesOfasil(final AsilBConnectedClassesPL.Match partialMatch) {
      return rawStreamAllValuesOfasil(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for asil.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<PLElement> streamAllValuesOfasil(final edu.toronto.cs.se.mmint.productline.Class pGoal, final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pRef, final PLElement pAttr, final Mapping pMapping) {
      return rawStreamAllValuesOfasil(new Object[]{pGoal, pClazz, null, pRef, pAttr, pMapping});
    }

    /**
     * Retrieve the set of values that occur in matches for asil.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<PLElement> getAllValuesOfasil(final AsilBConnectedClassesPL.Match partialMatch) {
      return rawStreamAllValuesOfasil(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for asil.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<PLElement> getAllValuesOfasil(final edu.toronto.cs.se.mmint.productline.Class pGoal, final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pRef, final PLElement pAttr, final Mapping pMapping) {
      return rawStreamAllValuesOfasil(new Object[]{pGoal, pClazz, null, pRef, pAttr, pMapping}).collect(Collectors.toSet());
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
    public Stream<PLElement> streamAllValuesOfref(final AsilBConnectedClassesPL.Match partialMatch) {
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
    public Stream<PLElement> streamAllValuesOfref(final edu.toronto.cs.se.mmint.productline.Class pGoal, final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pAsil, final PLElement pAttr, final Mapping pMapping) {
      return rawStreamAllValuesOfref(new Object[]{pGoal, pClazz, pAsil, null, pAttr, pMapping});
    }

    /**
     * Retrieve the set of values that occur in matches for ref.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<PLElement> getAllValuesOfref(final AsilBConnectedClassesPL.Match partialMatch) {
      return rawStreamAllValuesOfref(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for ref.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<PLElement> getAllValuesOfref(final edu.toronto.cs.se.mmint.productline.Class pGoal, final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pAsil, final PLElement pAttr, final Mapping pMapping) {
      return rawStreamAllValuesOfref(new Object[]{pGoal, pClazz, pAsil, null, pAttr, pMapping}).collect(Collectors.toSet());
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
    public Stream<PLElement> streamAllValuesOfattr(final AsilBConnectedClassesPL.Match partialMatch) {
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
    public Stream<PLElement> streamAllValuesOfattr(final edu.toronto.cs.se.mmint.productline.Class pGoal, final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pAsil, final PLElement pRef, final Mapping pMapping) {
      return rawStreamAllValuesOfattr(new Object[]{pGoal, pClazz, pAsil, pRef, null, pMapping});
    }

    /**
     * Retrieve the set of values that occur in matches for attr.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<PLElement> getAllValuesOfattr(final AsilBConnectedClassesPL.Match partialMatch) {
      return rawStreamAllValuesOfattr(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for attr.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<PLElement> getAllValuesOfattr(final edu.toronto.cs.se.mmint.productline.Class pGoal, final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pAsil, final PLElement pRef, final Mapping pMapping) {
      return rawStreamAllValuesOfattr(new Object[]{pGoal, pClazz, pAsil, pRef, null, pMapping}).collect(Collectors.toSet());
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
    public Stream<Mapping> streamAllValuesOfmapping(final AsilBConnectedClassesPL.Match partialMatch) {
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
    public Stream<Mapping> streamAllValuesOfmapping(final edu.toronto.cs.se.mmint.productline.Class pGoal, final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pAsil, final PLElement pRef, final PLElement pAttr) {
      return rawStreamAllValuesOfmapping(new Object[]{pGoal, pClazz, pAsil, pRef, pAttr, null});
    }

    /**
     * Retrieve the set of values that occur in matches for mapping.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Mapping> getAllValuesOfmapping(final AsilBConnectedClassesPL.Match partialMatch) {
      return rawStreamAllValuesOfmapping(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for mapping.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Mapping> getAllValuesOfmapping(final edu.toronto.cs.se.mmint.productline.Class pGoal, final edu.toronto.cs.se.mmint.productline.Class pClazz, final PLElement pAsil, final PLElement pRef, final PLElement pAttr) {
      return rawStreamAllValuesOfmapping(new Object[]{pGoal, pClazz, pAsil, pRef, pAttr, null}).collect(Collectors.toSet());
    }

    @Override
    protected AsilBConnectedClassesPL.Match tupleToMatch(final Tuple t) {
      try {
          return AsilBConnectedClassesPL.Match.newMatch((edu.toronto.cs.se.mmint.productline.Class) t.get(POSITION_GOAL), (edu.toronto.cs.se.mmint.productline.Class) t.get(POSITION_CLAZZ), (PLElement) t.get(POSITION_ASIL), (PLElement) t.get(POSITION_REF), (PLElement) t.get(POSITION_ATTR), (Mapping) t.get(POSITION_MAPPING));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected AsilBConnectedClassesPL.Match arrayToMatch(final Object[] match) {
      try {
          return AsilBConnectedClassesPL.Match.newMatch((edu.toronto.cs.se.mmint.productline.Class) match[POSITION_GOAL], (edu.toronto.cs.se.mmint.productline.Class) match[POSITION_CLAZZ], (PLElement) match[POSITION_ASIL], (PLElement) match[POSITION_REF], (PLElement) match[POSITION_ATTR], (Mapping) match[POSITION_MAPPING]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected AsilBConnectedClassesPL.Match arrayToMatchMutable(final Object[] match) {
      try {
          return AsilBConnectedClassesPL.Match.newMutableMatch((edu.toronto.cs.se.mmint.productline.Class) match[POSITION_GOAL], (edu.toronto.cs.se.mmint.productline.Class) match[POSITION_CLAZZ], (PLElement) match[POSITION_ASIL], (PLElement) match[POSITION_REF], (PLElement) match[POSITION_ATTR], (Mapping) match[POSITION_MAPPING]);
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
    public static IQuerySpecification<AsilBConnectedClassesPL.Matcher> querySpecification() {
      return AsilBConnectedClassesPL.instance();
    }
  }

  private AsilBConnectedClassesPL() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static AsilBConnectedClassesPL instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected AsilBConnectedClassesPL.Matcher instantiate(final ViatraQueryEngine engine) {
    return AsilBConnectedClassesPL.Matcher.on(engine);
  }

  @Override
  public AsilBConnectedClassesPL.Matcher instantiate() {
    return AsilBConnectedClassesPL.Matcher.create();
  }

  @Override
  public AsilBConnectedClassesPL.Match newEmptyMatch() {
    return AsilBConnectedClassesPL.Match.newEmptyMatch();
  }

  @Override
  public AsilBConnectedClassesPL.Match newMatch(final Object... parameters) {
    return AsilBConnectedClassesPL.Match.newMatch((edu.toronto.cs.se.mmint.productline.Class) parameters[0], (edu.toronto.cs.se.mmint.productline.Class) parameters[1], (edu.toronto.cs.se.mmint.productline.PLElement) parameters[2], (edu.toronto.cs.se.mmint.productline.PLElement) parameters[3], (edu.toronto.cs.se.mmint.productline.PLElement) parameters[4], (edu.toronto.cs.se.mmint.mid.relationship.Mapping) parameters[5]);
  }

  /**
   * Inner class allowing the singleton instance of {@link AsilBConnectedClassesPL} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link AsilBConnectedClassesPL#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final AsilBConnectedClassesPL INSTANCE = new AsilBConnectedClassesPL();

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
    private static final AsilBConnectedClassesPL.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_goal = new PParameter("goal", "edu.toronto.cs.se.mmint.productline.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("model://edu.toronto.cs.se.mmint.productline", "Class")), PParameterDirection.INOUT);

    private final PParameter parameter_clazz = new PParameter("clazz", "edu.toronto.cs.se.mmint.productline.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("model://edu.toronto.cs.se.mmint.productline", "Class")), PParameterDirection.INOUT);

    private final PParameter parameter_asil = new PParameter("asil", "edu.toronto.cs.se.mmint.productline.PLElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("model://edu.toronto.cs.se.mmint.productline", "PLElement")), PParameterDirection.INOUT);

    private final PParameter parameter_ref = new PParameter("ref", "edu.toronto.cs.se.mmint.productline.PLElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("model://edu.toronto.cs.se.mmint.productline", "PLElement")), PParameterDirection.INOUT);

    private final PParameter parameter_attr = new PParameter("attr", "edu.toronto.cs.se.mmint.productline.PLElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("model://edu.toronto.cs.se.mmint.productline", "PLElement")), PParameterDirection.INOUT);

    private final PParameter parameter_mapping = new PParameter("mapping", "edu.toronto.cs.se.mmint.mid.relationship.Mapping", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://se.cs.toronto.edu/mmint/MID/Relationship", "Mapping")), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_goal, parameter_clazz, parameter_asil, parameter_ref, parameter_attr, parameter_mapping);

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "edu.toronto.cs.se.mmint.productline.viatra.tests.asilBConnectedClassesPL";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("goal","clazz","asil","ref","attr","mapping");
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
          PVariable var_goal = body.getOrCreateVariableByName("goal");
          PVariable var_clazz = body.getOrCreateVariableByName("clazz");
          PVariable var_asil = body.getOrCreateVariableByName("asil");
          PVariable var_ref = body.getOrCreateVariableByName("ref");
          PVariable var_attr = body.getOrCreateVariableByName("attr");
          PVariable var_mapping = body.getOrCreateVariableByName("mapping");
          new TypeConstraint(body, Tuples.flatTupleOf(var_goal), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "Class")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_clazz), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "Class")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_asil), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "PLElement")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_ref), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "PLElement")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_attr), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "PLElement")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_mapping), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/mmint/MID/Relationship", "Mapping")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_goal, parameter_goal),
             new ExportedParameter(body, var_clazz, parameter_clazz),
             new ExportedParameter(body, var_asil, parameter_asil),
             new ExportedParameter(body, var_ref, parameter_ref),
             new ExportedParameter(body, var_attr, parameter_attr),
             new ExportedParameter(body, var_mapping, parameter_mapping)
          ));
          //   find reference(goal, "Goal", asil, "ASIL", ref, "asil")
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new ConstantValue(body, var__virtual_0_, "Goal");
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new ConstantValue(body, var__virtual_1_, "ASIL");
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new ConstantValue(body, var__virtual_2_, "asil");
          new PositivePatternCall(body, Tuples.flatTupleOf(var_goal, var__virtual_0_, var_asil, var__virtual_1_, var_ref, var__virtual_2_), Reference.instance().getInternalQueryRepresentation());
          //   find attribute(asil, "ASIL", attr, "value", "B")
          PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
          new ConstantValue(body, var__virtual_3_, "ASIL");
          PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
          new ConstantValue(body, var__virtual_4_, "value");
          PVariable var__virtual_5_ = body.getOrCreateVariableByName(".virtual{5}");
          new ConstantValue(body, var__virtual_5_, "B");
          new PositivePatternCall(body, Tuples.flatTupleOf(var_asil, var__virtual_3_, var_attr, var__virtual_4_, var__virtual_5_), Attribute.instance().getInternalQueryRepresentation());
          //   find connectedEMFObjectsWithMapping(goal, clazz, mapping)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_goal, var_clazz, var_mapping), ConnectedEMFObjectsWithMapping.instance().getInternalQueryRepresentation());
          //   find classType(goal, "Goal")
          PVariable var__virtual_6_ = body.getOrCreateVariableByName(".virtual{6}");
          new ConstantValue(body, var__virtual_6_, "Goal");
          new PositivePatternCall(body, Tuples.flatTupleOf(var_goal, var__virtual_6_), ClassType.instance().getInternalQueryRepresentation());
          //   find classType(clazz, "Class")
          PVariable var__virtual_7_ = body.getOrCreateVariableByName(".virtual{7}");
          new ConstantValue(body, var__virtual_7_, "Class");
          new PositivePatternCall(body, Tuples.flatTupleOf(var_clazz, var__virtual_7_), ClassType.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      return bodies;
    }
  }
}

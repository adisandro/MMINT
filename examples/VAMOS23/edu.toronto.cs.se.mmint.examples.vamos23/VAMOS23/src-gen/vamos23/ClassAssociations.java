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
package vamos23;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.PatternMatchCounter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.TypeFilterConstraint;
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
 *         // Counts the number of incoming associations of each class
 *         pattern classAssociations(clazz: Class,
 *                                   associations: java Integer) {
 *           associations == count Class.associationsAsTarget(clazz, _);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class ClassAssociations extends BaseGeneratedEMFQuerySpecification<ClassAssociations.Matcher> {
  /**
   * Pattern-specific match representation of the vamos23.classAssociations pattern,
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
    private edu.toronto.cs.se.modelepedia.classdiagram.Class fClazz;

    private Integer fAssociations;

    private static List<String> parameterNames = makeImmutableList("clazz", "associations");

    private Match(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz, final Integer pAssociations) {
      this.fClazz = pClazz;
      this.fAssociations = pAssociations;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "clazz": return this.fClazz;
          case "associations": return this.fAssociations;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fClazz;
          case 1: return this.fAssociations;
          default: return null;
      }
    }

    public edu.toronto.cs.se.modelepedia.classdiagram.Class getClazz() {
      return this.fClazz;
    }

    public Integer getAssociations() {
      return this.fAssociations;
    }

    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("clazz".equals(parameterName) ) {
          this.fClazz = (edu.toronto.cs.se.modelepedia.classdiagram.Class) newValue;
          return true;
      }
      if ("associations".equals(parameterName) ) {
          this.fAssociations = (Integer) newValue;
          return true;
      }
      return false;
    }

    public void setClazz(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fClazz = pClazz;
    }

    public void setAssociations(final Integer pAssociations) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fAssociations = pAssociations;
    }

    @Override
    public String patternName() {
      return "vamos23.classAssociations";
    }

    @Override
    public List<String> parameterNames() {
      return ClassAssociations.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fClazz, fAssociations};
    }

    @Override
    public ClassAssociations.Match toImmutable() {
      return isMutable() ? newMatch(fClazz, fAssociations) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"clazz\"=" + prettyPrintValue(fClazz) + ", ");
      result.append("\"associations\"=" + prettyPrintValue(fAssociations));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fClazz, fAssociations);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof ClassAssociations.Match)) {
          ClassAssociations.Match other = (ClassAssociations.Match) obj;
          return Objects.equals(fClazz, other.fClazz) && Objects.equals(fAssociations, other.fAssociations);
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
    public ClassAssociations specification() {
      return ClassAssociations.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static ClassAssociations.Match newEmptyMatch() {
      return new Mutable(null, null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @param pAssociations the fixed value of pattern parameter associations, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static ClassAssociations.Match newMutableMatch(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz, final Integer pAssociations) {
      return new Mutable(pClazz, pAssociations);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @param pAssociations the fixed value of pattern parameter associations, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static ClassAssociations.Match newMatch(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz, final Integer pAssociations) {
      return new Immutable(pClazz, pAssociations);
    }

    private static final class Mutable extends ClassAssociations.Match {
      Mutable(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz, final Integer pAssociations) {
        super(pClazz, pAssociations);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends ClassAssociations.Match {
      Immutable(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz, final Integer pAssociations) {
        super(pClazz, pAssociations);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the vamos23.classAssociations pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * // Counts the number of incoming associations of each class
   * pattern classAssociations(clazz: Class,
   *                           associations: java Integer) {
   *   associations == count Class.associationsAsTarget(clazz, _);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see ClassAssociations
   * 
   */
  public static class Matcher extends BaseMatcher<ClassAssociations.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static ClassAssociations.Matcher on(final ViatraQueryEngine engine) {
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
    public static ClassAssociations.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_CLAZZ = 0;

    private static final int POSITION_ASSOCIATIONS = 1;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(ClassAssociations.Matcher.class);

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
     * @param pAssociations the fixed value of pattern parameter associations, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<ClassAssociations.Match> getAllMatches(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz, final Integer pAssociations) {
      return rawStreamAllMatches(new Object[]{pClazz, pAssociations}).collect(Collectors.toSet());
    }

    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @param pAssociations the fixed value of pattern parameter associations, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<ClassAssociations.Match> streamAllMatches(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz, final Integer pAssociations) {
      return rawStreamAllMatches(new Object[]{pClazz, pAssociations});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @param pAssociations the fixed value of pattern parameter associations, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<ClassAssociations.Match> getOneArbitraryMatch(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz, final Integer pAssociations) {
      return rawGetOneArbitraryMatch(new Object[]{pClazz, pAssociations});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @param pAssociations the fixed value of pattern parameter associations, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz, final Integer pAssociations) {
      return rawHasMatch(new Object[]{pClazz, pAssociations});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @param pAssociations the fixed value of pattern parameter associations, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz, final Integer pAssociations) {
      return rawCountMatches(new Object[]{pClazz, pAssociations});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @param pAssociations the fixed value of pattern parameter associations, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz, final Integer pAssociations, final Consumer<? super ClassAssociations.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pClazz, pAssociations}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pClazz the fixed value of pattern parameter clazz, or null if not bound.
     * @param pAssociations the fixed value of pattern parameter associations, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public ClassAssociations.Match newMatch(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz, final Integer pAssociations) {
      return ClassAssociations.Match.newMatch(pClazz, pAssociations);
    }

    /**
     * Retrieve the set of values that occur in matches for clazz.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<edu.toronto.cs.se.modelepedia.classdiagram.Class> rawStreamAllValuesOfclazz(final Object[] parameters) {
      return rawStreamAllValues(POSITION_CLAZZ, parameters).map(edu.toronto.cs.se.modelepedia.classdiagram.Class.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for clazz.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.modelepedia.classdiagram.Class> getAllValuesOfclazz() {
      return rawStreamAllValuesOfclazz(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for clazz.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.modelepedia.classdiagram.Class> streamAllValuesOfclazz() {
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
    public Stream<edu.toronto.cs.se.modelepedia.classdiagram.Class> streamAllValuesOfclazz(final ClassAssociations.Match partialMatch) {
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
    public Stream<edu.toronto.cs.se.modelepedia.classdiagram.Class> streamAllValuesOfclazz(final Integer pAssociations) {
      return rawStreamAllValuesOfclazz(new Object[]{null, pAssociations});
    }

    /**
     * Retrieve the set of values that occur in matches for clazz.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.modelepedia.classdiagram.Class> getAllValuesOfclazz(final ClassAssociations.Match partialMatch) {
      return rawStreamAllValuesOfclazz(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for clazz.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.modelepedia.classdiagram.Class> getAllValuesOfclazz(final Integer pAssociations) {
      return rawStreamAllValuesOfclazz(new Object[]{null, pAssociations}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for associations.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Integer> rawStreamAllValuesOfassociations(final Object[] parameters) {
      return rawStreamAllValues(POSITION_ASSOCIATIONS, parameters).map(Integer.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for associations.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Integer> getAllValuesOfassociations() {
      return rawStreamAllValuesOfassociations(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for associations.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Integer> streamAllValuesOfassociations() {
      return rawStreamAllValuesOfassociations(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for associations.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Integer> streamAllValuesOfassociations(final ClassAssociations.Match partialMatch) {
      return rawStreamAllValuesOfassociations(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for associations.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Integer> streamAllValuesOfassociations(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz) {
      return rawStreamAllValuesOfassociations(new Object[]{pClazz, null});
    }

    /**
     * Retrieve the set of values that occur in matches for associations.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Integer> getAllValuesOfassociations(final ClassAssociations.Match partialMatch) {
      return rawStreamAllValuesOfassociations(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for associations.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Integer> getAllValuesOfassociations(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClazz) {
      return rawStreamAllValuesOfassociations(new Object[]{pClazz, null}).collect(Collectors.toSet());
    }

    @Override
    protected ClassAssociations.Match tupleToMatch(final Tuple t) {
      try {
          return ClassAssociations.Match.newMatch((edu.toronto.cs.se.modelepedia.classdiagram.Class) t.get(POSITION_CLAZZ), (Integer) t.get(POSITION_ASSOCIATIONS));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected ClassAssociations.Match arrayToMatch(final Object[] match) {
      try {
          return ClassAssociations.Match.newMatch((edu.toronto.cs.se.modelepedia.classdiagram.Class) match[POSITION_CLAZZ], (Integer) match[POSITION_ASSOCIATIONS]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected ClassAssociations.Match arrayToMatchMutable(final Object[] match) {
      try {
          return ClassAssociations.Match.newMutableMatch((edu.toronto.cs.se.modelepedia.classdiagram.Class) match[POSITION_CLAZZ], (Integer) match[POSITION_ASSOCIATIONS]);
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
    public static IQuerySpecification<ClassAssociations.Matcher> querySpecification() {
      return ClassAssociations.instance();
    }
  }

  private ClassAssociations() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static ClassAssociations instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected ClassAssociations.Matcher instantiate(final ViatraQueryEngine engine) {
    return ClassAssociations.Matcher.on(engine);
  }

  @Override
  public ClassAssociations.Matcher instantiate() {
    return ClassAssociations.Matcher.create();
  }

  @Override
  public ClassAssociations.Match newEmptyMatch() {
    return ClassAssociations.Match.newEmptyMatch();
  }

  @Override
  public ClassAssociations.Match newMatch(final Object... parameters) {
    return ClassAssociations.Match.newMatch((edu.toronto.cs.se.modelepedia.classdiagram.Class) parameters[0], (java.lang.Integer) parameters[1]);
  }

  /**
   * Inner class allowing the singleton instance of {@link ClassAssociations} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link ClassAssociations#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final ClassAssociations INSTANCE = new ClassAssociations();

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
    private static final ClassAssociations.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_clazz = new PParameter("clazz", "edu.toronto.cs.se.modelepedia.classdiagram.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Class")), PParameterDirection.INOUT);

    private final PParameter parameter_associations = new PParameter("associations", "java.lang.Integer", new JavaTransitiveInstancesKey(java.lang.Integer.class), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_clazz, parameter_associations);

    private class Embedded_1_Class_associationsAsTarget extends BaseGeneratedEMFPQuery {
      private final PParameter parameter_p0 = new PParameter("p0", "edu.toronto.cs.se.modelepedia.classdiagram.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Class")), PParameterDirection.INOUT);

      private final PParameter parameter_p1 = new PParameter("p1", "edu.toronto.cs.se.modelepedia.classdiagram.Association", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Association")), PParameterDirection.INOUT);

      private final List<PParameter> embeddedParameters = Arrays.asList(parameter_p0, parameter_p1);

      public Embedded_1_Class_associationsAsTarget() {
        super(PVisibility.EMBEDDED);
      }

      @Override
      public String getFullyQualifiedName() {
        return GeneratedPQuery.this.getFullyQualifiedName() + "$Embedded_1_Class_associationsAsTarget";
      }

      @Override
      public List<PParameter> getParameters() {
        return embeddedParameters;
      }

      @Override
      public Set<PBody> doGetContainedBodies() {
        PBody body = new PBody(this);
        PVariable var_p0 = body.getOrCreateVariableByName("p0");
        PVariable var_p1 = body.getOrCreateVariableByName("p1");
        body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
           new ExportedParameter(body, var_p0, parameter_p0),
           new ExportedParameter(body, var_p1, parameter_p1)
        ));
        //  Class.associationsAsTarget(clazz, _)
        new TypeConstraint(body, Tuples.flatTupleOf(var_p0), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Class")));
        PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
        new TypeConstraint(body, Tuples.flatTupleOf(var_p0, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Class", "associationsAsTarget")));
        new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Association")));
        new Equality(body, var__virtual_0_, var_p1);
        return Collections.singleton(body);
      }
    }

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "vamos23.classAssociations";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("clazz","associations");
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
          PVariable var_associations = body.getOrCreateVariableByName("associations");
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          new TypeConstraint(body, Tuples.flatTupleOf(var_clazz), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Class")));
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_associations), new JavaTransitiveInstancesKey(java.lang.Integer.class));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_clazz, parameter_clazz),
             new ExportedParameter(body, var_associations, parameter_associations)
          ));
          //   associations == count Class.associationsAsTarget(clazz, _)
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new PatternMatchCounter(body, Tuples.flatTupleOf(var_clazz, var___0_), new ClassAssociations.GeneratedPQuery.Embedded_1_Class_associationsAsTarget(), var__virtual_0_);
          new Equality(body, var_associations, var__virtual_0_);
          bodies.add(body);
      }
      return bodies;
    }
  }
}

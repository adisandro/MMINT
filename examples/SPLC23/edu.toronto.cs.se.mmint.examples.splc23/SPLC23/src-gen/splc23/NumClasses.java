/**
 * 
 *   Copyright (c) 2023, 2023 Alessio Di Sandro.
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
package splc23;

import edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagram;
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
 *         // Counts the number of classes
 *         pattern numClasses(cd: ClassDiagram, classes: java Integer) {
 *           classes == count ClassDiagram.classes(cd, _);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class NumClasses extends BaseGeneratedEMFQuerySpecification<NumClasses.Matcher> {
  /**
   * Pattern-specific match representation of the splc23.numClasses pattern,
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
    private ClassDiagram fCd;

    private Integer fClasses;

    private static List<String> parameterNames = makeImmutableList("cd", "classes");

    private Match(final ClassDiagram pCd, final Integer pClasses) {
      this.fCd = pCd;
      this.fClasses = pClasses;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "cd": return this.fCd;
          case "classes": return this.fClasses;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fCd;
          case 1: return this.fClasses;
          default: return null;
      }
    }

    public ClassDiagram getCd() {
      return this.fCd;
    }

    public Integer getClasses() {
      return this.fClasses;
    }

    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("cd".equals(parameterName) ) {
          this.fCd = (ClassDiagram) newValue;
          return true;
      }
      if ("classes".equals(parameterName) ) {
          this.fClasses = (Integer) newValue;
          return true;
      }
      return false;
    }

    public void setCd(final ClassDiagram pCd) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fCd = pCd;
    }

    public void setClasses(final Integer pClasses) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fClasses = pClasses;
    }

    @Override
    public String patternName() {
      return "splc23.numClasses";
    }

    @Override
    public List<String> parameterNames() {
      return NumClasses.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fCd, fClasses};
    }

    @Override
    public NumClasses.Match toImmutable() {
      return isMutable() ? newMatch(fCd, fClasses) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"cd\"=" + prettyPrintValue(fCd) + ", ");
      result.append("\"classes\"=" + prettyPrintValue(fClasses));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fCd, fClasses);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof NumClasses.Match)) {
          NumClasses.Match other = (NumClasses.Match) obj;
          return Objects.equals(fCd, other.fCd) && Objects.equals(fClasses, other.fClasses);
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
    public NumClasses specification() {
      return NumClasses.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static NumClasses.Match newEmptyMatch() {
      return new Mutable(null, null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pCd the fixed value of pattern parameter cd, or null if not bound.
     * @param pClasses the fixed value of pattern parameter classes, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static NumClasses.Match newMutableMatch(final ClassDiagram pCd, final Integer pClasses) {
      return new Mutable(pCd, pClasses);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pCd the fixed value of pattern parameter cd, or null if not bound.
     * @param pClasses the fixed value of pattern parameter classes, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static NumClasses.Match newMatch(final ClassDiagram pCd, final Integer pClasses) {
      return new Immutable(pCd, pClasses);
    }

    private static final class Mutable extends NumClasses.Match {
      Mutable(final ClassDiagram pCd, final Integer pClasses) {
        super(pCd, pClasses);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends NumClasses.Match {
      Immutable(final ClassDiagram pCd, final Integer pClasses) {
        super(pCd, pClasses);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the splc23.numClasses pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * // Counts the number of classes
   * pattern numClasses(cd: ClassDiagram, classes: java Integer) {
   *   classes == count ClassDiagram.classes(cd, _);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see NumClasses
   * 
   */
  public static class Matcher extends BaseMatcher<NumClasses.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static NumClasses.Matcher on(final ViatraQueryEngine engine) {
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
    public static NumClasses.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_CD = 0;

    private static final int POSITION_CLASSES = 1;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(NumClasses.Matcher.class);

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
     * @param pCd the fixed value of pattern parameter cd, or null if not bound.
     * @param pClasses the fixed value of pattern parameter classes, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<NumClasses.Match> getAllMatches(final ClassDiagram pCd, final Integer pClasses) {
      return rawStreamAllMatches(new Object[]{pCd, pClasses}).collect(Collectors.toSet());
    }

    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pCd the fixed value of pattern parameter cd, or null if not bound.
     * @param pClasses the fixed value of pattern parameter classes, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<NumClasses.Match> streamAllMatches(final ClassDiagram pCd, final Integer pClasses) {
      return rawStreamAllMatches(new Object[]{pCd, pClasses});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pCd the fixed value of pattern parameter cd, or null if not bound.
     * @param pClasses the fixed value of pattern parameter classes, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<NumClasses.Match> getOneArbitraryMatch(final ClassDiagram pCd, final Integer pClasses) {
      return rawGetOneArbitraryMatch(new Object[]{pCd, pClasses});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pCd the fixed value of pattern parameter cd, or null if not bound.
     * @param pClasses the fixed value of pattern parameter classes, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final ClassDiagram pCd, final Integer pClasses) {
      return rawHasMatch(new Object[]{pCd, pClasses});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pCd the fixed value of pattern parameter cd, or null if not bound.
     * @param pClasses the fixed value of pattern parameter classes, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final ClassDiagram pCd, final Integer pClasses) {
      return rawCountMatches(new Object[]{pCd, pClasses});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pCd the fixed value of pattern parameter cd, or null if not bound.
     * @param pClasses the fixed value of pattern parameter classes, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final ClassDiagram pCd, final Integer pClasses, final Consumer<? super NumClasses.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pCd, pClasses}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pCd the fixed value of pattern parameter cd, or null if not bound.
     * @param pClasses the fixed value of pattern parameter classes, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public NumClasses.Match newMatch(final ClassDiagram pCd, final Integer pClasses) {
      return NumClasses.Match.newMatch(pCd, pClasses);
    }

    /**
     * Retrieve the set of values that occur in matches for cd.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<ClassDiagram> rawStreamAllValuesOfcd(final Object[] parameters) {
      return rawStreamAllValues(POSITION_CD, parameters).map(ClassDiagram.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for cd.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ClassDiagram> getAllValuesOfcd() {
      return rawStreamAllValuesOfcd(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for cd.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<ClassDiagram> streamAllValuesOfcd() {
      return rawStreamAllValuesOfcd(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for cd.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<ClassDiagram> streamAllValuesOfcd(final NumClasses.Match partialMatch) {
      return rawStreamAllValuesOfcd(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for cd.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<ClassDiagram> streamAllValuesOfcd(final Integer pClasses) {
      return rawStreamAllValuesOfcd(new Object[]{null, pClasses});
    }

    /**
     * Retrieve the set of values that occur in matches for cd.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ClassDiagram> getAllValuesOfcd(final NumClasses.Match partialMatch) {
      return rawStreamAllValuesOfcd(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for cd.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<ClassDiagram> getAllValuesOfcd(final Integer pClasses) {
      return rawStreamAllValuesOfcd(new Object[]{null, pClasses}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for classes.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Integer> rawStreamAllValuesOfclasses(final Object[] parameters) {
      return rawStreamAllValues(POSITION_CLASSES, parameters).map(Integer.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for classes.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Integer> getAllValuesOfclasses() {
      return rawStreamAllValuesOfclasses(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for classes.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Integer> streamAllValuesOfclasses() {
      return rawStreamAllValuesOfclasses(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for classes.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Integer> streamAllValuesOfclasses(final NumClasses.Match partialMatch) {
      return rawStreamAllValuesOfclasses(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for classes.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Integer> streamAllValuesOfclasses(final ClassDiagram pCd) {
      return rawStreamAllValuesOfclasses(new Object[]{pCd, null});
    }

    /**
     * Retrieve the set of values that occur in matches for classes.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Integer> getAllValuesOfclasses(final NumClasses.Match partialMatch) {
      return rawStreamAllValuesOfclasses(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for classes.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Integer> getAllValuesOfclasses(final ClassDiagram pCd) {
      return rawStreamAllValuesOfclasses(new Object[]{pCd, null}).collect(Collectors.toSet());
    }

    @Override
    protected NumClasses.Match tupleToMatch(final Tuple t) {
      try {
          return NumClasses.Match.newMatch((ClassDiagram) t.get(POSITION_CD), (Integer) t.get(POSITION_CLASSES));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected NumClasses.Match arrayToMatch(final Object[] match) {
      try {
          return NumClasses.Match.newMatch((ClassDiagram) match[POSITION_CD], (Integer) match[POSITION_CLASSES]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected NumClasses.Match arrayToMatchMutable(final Object[] match) {
      try {
          return NumClasses.Match.newMutableMatch((ClassDiagram) match[POSITION_CD], (Integer) match[POSITION_CLASSES]);
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
    public static IQuerySpecification<NumClasses.Matcher> querySpecification() {
      return NumClasses.instance();
    }
  }

  private NumClasses() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static NumClasses instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected NumClasses.Matcher instantiate(final ViatraQueryEngine engine) {
    return NumClasses.Matcher.on(engine);
  }

  @Override
  public NumClasses.Matcher instantiate() {
    return NumClasses.Matcher.create();
  }

  @Override
  public NumClasses.Match newEmptyMatch() {
    return NumClasses.Match.newEmptyMatch();
  }

  @Override
  public NumClasses.Match newMatch(final Object... parameters) {
    return NumClasses.Match.newMatch((edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagram) parameters[0], (java.lang.Integer) parameters[1]);
  }

  /**
   * Inner class allowing the singleton instance of {@link NumClasses} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link NumClasses#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final NumClasses INSTANCE = new NumClasses();

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
    private static final NumClasses.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_cd = new PParameter("cd", "edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagram", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "ClassDiagram")), PParameterDirection.INOUT);

    private final PParameter parameter_classes = new PParameter("classes", "java.lang.Integer", new JavaTransitiveInstancesKey(java.lang.Integer.class), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_cd, parameter_classes);

    private class Embedded_1_ClassDiagram_classes extends BaseGeneratedEMFPQuery {
      private final PParameter parameter_p0 = new PParameter("p0", "edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagram", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "ClassDiagram")), PParameterDirection.INOUT);

      private final PParameter parameter_p1 = new PParameter("p1", "edu.toronto.cs.se.modelepedia.classdiagram.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Class")), PParameterDirection.INOUT);

      private final List<PParameter> embeddedParameters = Arrays.asList(parameter_p0, parameter_p1);

      public Embedded_1_ClassDiagram_classes() {
        super(PVisibility.EMBEDDED);
      }

      @Override
      public String getFullyQualifiedName() {
        return GeneratedPQuery.this.getFullyQualifiedName() + "$Embedded_1_ClassDiagram_classes";
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
        //  ClassDiagram.classes(cd, _)
        new TypeConstraint(body, Tuples.flatTupleOf(var_p0), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "ClassDiagram")));
        PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
        new TypeConstraint(body, Tuples.flatTupleOf(var_p0, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "ClassDiagram", "classes")));
        new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Class")));
        new Equality(body, var__virtual_0_, var_p1);
        return Collections.singleton(body);
      }
    }

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "splc23.numClasses";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("cd","classes");
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
          PVariable var_cd = body.getOrCreateVariableByName("cd");
          PVariable var_classes = body.getOrCreateVariableByName("classes");
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          new TypeConstraint(body, Tuples.flatTupleOf(var_cd), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "ClassDiagram")));
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_classes), new JavaTransitiveInstancesKey(java.lang.Integer.class));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_cd, parameter_cd),
             new ExportedParameter(body, var_classes, parameter_classes)
          ));
          //   classes == count ClassDiagram.classes(cd, _)
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new PatternMatchCounter(body, Tuples.flatTupleOf(var_cd, var___0_), new NumClasses.GeneratedPQuery.Embedded_1_ClassDiagram_classes(), var__virtual_0_);
          new Equality(body, var_classes, var__virtual_0_);
          bodies.add(body);
      }
      return bodies;
    }
  }
}

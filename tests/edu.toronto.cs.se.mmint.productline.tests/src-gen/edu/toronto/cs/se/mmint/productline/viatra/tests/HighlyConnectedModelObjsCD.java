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

import edu.toronto.cs.se.mmint.viatra.mid.ConnectedEMFObjects;
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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
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
 *         pattern highlyConnectedModelObjsCD(modelObj: EObject, connections: java Integer) {
 *           connections == count find connectedEMFObjects(modelObj, _);
 *         //  check(connections {@literal >} 0);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class HighlyConnectedModelObjsCD extends BaseGeneratedEMFQuerySpecification<HighlyConnectedModelObjsCD.Matcher> {
  /**
   * Pattern-specific match representation of the edu.toronto.cs.se.mmint.productline.viatra.tests.highlyConnectedModelObjsCD pattern,
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
    private EObject fModelObj;

    private Integer fConnections;

    private static List<String> parameterNames = makeImmutableList("modelObj", "connections");

    private Match(final EObject pModelObj, final Integer pConnections) {
      this.fModelObj = pModelObj;
      this.fConnections = pConnections;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "modelObj": return this.fModelObj;
          case "connections": return this.fConnections;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fModelObj;
          case 1: return this.fConnections;
          default: return null;
      }
    }

    public EObject getModelObj() {
      return this.fModelObj;
    }

    public Integer getConnections() {
      return this.fConnections;
    }

    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("modelObj".equals(parameterName) ) {
          this.fModelObj = (EObject) newValue;
          return true;
      }
      if ("connections".equals(parameterName) ) {
          this.fConnections = (Integer) newValue;
          return true;
      }
      return false;
    }

    public void setModelObj(final EObject pModelObj) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fModelObj = pModelObj;
    }

    public void setConnections(final Integer pConnections) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fConnections = pConnections;
    }

    @Override
    public String patternName() {
      return "edu.toronto.cs.se.mmint.productline.viatra.tests.highlyConnectedModelObjsCD";
    }

    @Override
    public List<String> parameterNames() {
      return HighlyConnectedModelObjsCD.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fModelObj, fConnections};
    }

    @Override
    public HighlyConnectedModelObjsCD.Match toImmutable() {
      return isMutable() ? newMatch(fModelObj, fConnections) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"modelObj\"=" + prettyPrintValue(fModelObj) + ", ");
      result.append("\"connections\"=" + prettyPrintValue(fConnections));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fModelObj, fConnections);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof HighlyConnectedModelObjsCD.Match)) {
          HighlyConnectedModelObjsCD.Match other = (HighlyConnectedModelObjsCD.Match) obj;
          return Objects.equals(fModelObj, other.fModelObj) && Objects.equals(fConnections, other.fConnections);
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
    public HighlyConnectedModelObjsCD specification() {
      return HighlyConnectedModelObjsCD.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static HighlyConnectedModelObjsCD.Match newEmptyMatch() {
      return new Mutable(null, null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pModelObj the fixed value of pattern parameter modelObj, or null if not bound.
     * @param pConnections the fixed value of pattern parameter connections, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static HighlyConnectedModelObjsCD.Match newMutableMatch(final EObject pModelObj, final Integer pConnections) {
      return new Mutable(pModelObj, pConnections);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pModelObj the fixed value of pattern parameter modelObj, or null if not bound.
     * @param pConnections the fixed value of pattern parameter connections, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static HighlyConnectedModelObjsCD.Match newMatch(final EObject pModelObj, final Integer pConnections) {
      return new Immutable(pModelObj, pConnections);
    }

    private static final class Mutable extends HighlyConnectedModelObjsCD.Match {
      Mutable(final EObject pModelObj, final Integer pConnections) {
        super(pModelObj, pConnections);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends HighlyConnectedModelObjsCD.Match {
      Immutable(final EObject pModelObj, final Integer pConnections) {
        super(pModelObj, pConnections);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the edu.toronto.cs.se.mmint.productline.viatra.tests.highlyConnectedModelObjsCD pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern highlyConnectedModelObjsCD(modelObj: EObject, connections: java Integer) {
   *   connections == count find connectedEMFObjects(modelObj, _);
   * //  check(connections {@literal >} 0);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see HighlyConnectedModelObjsCD
   * 
   */
  public static class Matcher extends BaseMatcher<HighlyConnectedModelObjsCD.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static HighlyConnectedModelObjsCD.Matcher on(final ViatraQueryEngine engine) {
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
    public static HighlyConnectedModelObjsCD.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_MODELOBJ = 0;

    private static final int POSITION_CONNECTIONS = 1;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(HighlyConnectedModelObjsCD.Matcher.class);

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
     * @param pConnections the fixed value of pattern parameter connections, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<HighlyConnectedModelObjsCD.Match> getAllMatches(final EObject pModelObj, final Integer pConnections) {
      return rawStreamAllMatches(new Object[]{pModelObj, pConnections}).collect(Collectors.toSet());
    }

    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pModelObj the fixed value of pattern parameter modelObj, or null if not bound.
     * @param pConnections the fixed value of pattern parameter connections, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<HighlyConnectedModelObjsCD.Match> streamAllMatches(final EObject pModelObj, final Integer pConnections) {
      return rawStreamAllMatches(new Object[]{pModelObj, pConnections});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pModelObj the fixed value of pattern parameter modelObj, or null if not bound.
     * @param pConnections the fixed value of pattern parameter connections, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<HighlyConnectedModelObjsCD.Match> getOneArbitraryMatch(final EObject pModelObj, final Integer pConnections) {
      return rawGetOneArbitraryMatch(new Object[]{pModelObj, pConnections});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pModelObj the fixed value of pattern parameter modelObj, or null if not bound.
     * @param pConnections the fixed value of pattern parameter connections, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final EObject pModelObj, final Integer pConnections) {
      return rawHasMatch(new Object[]{pModelObj, pConnections});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pModelObj the fixed value of pattern parameter modelObj, or null if not bound.
     * @param pConnections the fixed value of pattern parameter connections, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final EObject pModelObj, final Integer pConnections) {
      return rawCountMatches(new Object[]{pModelObj, pConnections});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pModelObj the fixed value of pattern parameter modelObj, or null if not bound.
     * @param pConnections the fixed value of pattern parameter connections, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final EObject pModelObj, final Integer pConnections, final Consumer<? super HighlyConnectedModelObjsCD.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pModelObj, pConnections}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pModelObj the fixed value of pattern parameter modelObj, or null if not bound.
     * @param pConnections the fixed value of pattern parameter connections, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public HighlyConnectedModelObjsCD.Match newMatch(final EObject pModelObj, final Integer pConnections) {
      return HighlyConnectedModelObjsCD.Match.newMatch(pModelObj, pConnections);
    }

    /**
     * Retrieve the set of values that occur in matches for modelObj.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<EObject> rawStreamAllValuesOfmodelObj(final Object[] parameters) {
      return rawStreamAllValues(POSITION_MODELOBJ, parameters).map(EObject.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for modelObj.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<EObject> getAllValuesOfmodelObj() {
      return rawStreamAllValuesOfmodelObj(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for modelObj.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<EObject> streamAllValuesOfmodelObj() {
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
    public Stream<EObject> streamAllValuesOfmodelObj(final HighlyConnectedModelObjsCD.Match partialMatch) {
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
    public Stream<EObject> streamAllValuesOfmodelObj(final Integer pConnections) {
      return rawStreamAllValuesOfmodelObj(new Object[]{null, pConnections});
    }

    /**
     * Retrieve the set of values that occur in matches for modelObj.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<EObject> getAllValuesOfmodelObj(final HighlyConnectedModelObjsCD.Match partialMatch) {
      return rawStreamAllValuesOfmodelObj(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for modelObj.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<EObject> getAllValuesOfmodelObj(final Integer pConnections) {
      return rawStreamAllValuesOfmodelObj(new Object[]{null, pConnections}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for connections.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Integer> rawStreamAllValuesOfconnections(final Object[] parameters) {
      return rawStreamAllValues(POSITION_CONNECTIONS, parameters).map(Integer.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for connections.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Integer> getAllValuesOfconnections() {
      return rawStreamAllValuesOfconnections(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for connections.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Integer> streamAllValuesOfconnections() {
      return rawStreamAllValuesOfconnections(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for connections.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Integer> streamAllValuesOfconnections(final HighlyConnectedModelObjsCD.Match partialMatch) {
      return rawStreamAllValuesOfconnections(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for connections.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Integer> streamAllValuesOfconnections(final EObject pModelObj) {
      return rawStreamAllValuesOfconnections(new Object[]{pModelObj, null});
    }

    /**
     * Retrieve the set of values that occur in matches for connections.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Integer> getAllValuesOfconnections(final HighlyConnectedModelObjsCD.Match partialMatch) {
      return rawStreamAllValuesOfconnections(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for connections.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Integer> getAllValuesOfconnections(final EObject pModelObj) {
      return rawStreamAllValuesOfconnections(new Object[]{pModelObj, null}).collect(Collectors.toSet());
    }

    @Override
    protected HighlyConnectedModelObjsCD.Match tupleToMatch(final Tuple t) {
      try {
          return HighlyConnectedModelObjsCD.Match.newMatch((EObject) t.get(POSITION_MODELOBJ), (Integer) t.get(POSITION_CONNECTIONS));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected HighlyConnectedModelObjsCD.Match arrayToMatch(final Object[] match) {
      try {
          return HighlyConnectedModelObjsCD.Match.newMatch((EObject) match[POSITION_MODELOBJ], (Integer) match[POSITION_CONNECTIONS]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected HighlyConnectedModelObjsCD.Match arrayToMatchMutable(final Object[] match) {
      try {
          return HighlyConnectedModelObjsCD.Match.newMutableMatch((EObject) match[POSITION_MODELOBJ], (Integer) match[POSITION_CONNECTIONS]);
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
    public static IQuerySpecification<HighlyConnectedModelObjsCD.Matcher> querySpecification() {
      return HighlyConnectedModelObjsCD.instance();
    }
  }

  private HighlyConnectedModelObjsCD() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static HighlyConnectedModelObjsCD instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected HighlyConnectedModelObjsCD.Matcher instantiate(final ViatraQueryEngine engine) {
    return HighlyConnectedModelObjsCD.Matcher.on(engine);
  }

  @Override
  public HighlyConnectedModelObjsCD.Matcher instantiate() {
    return HighlyConnectedModelObjsCD.Matcher.create();
  }

  @Override
  public HighlyConnectedModelObjsCD.Match newEmptyMatch() {
    return HighlyConnectedModelObjsCD.Match.newEmptyMatch();
  }

  @Override
  public HighlyConnectedModelObjsCD.Match newMatch(final Object... parameters) {
    return HighlyConnectedModelObjsCD.Match.newMatch((EObject) parameters[0], (Integer) parameters[1]);
  }

  /**
   * Inner class allowing the singleton instance of {@link HighlyConnectedModelObjsCD} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link HighlyConnectedModelObjsCD#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final HighlyConnectedModelObjsCD INSTANCE = new HighlyConnectedModelObjsCD();

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
    private static final HighlyConnectedModelObjsCD.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_modelObj = new PParameter("modelObj", "org.eclipse.emf.ecore.EObject", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/emf/2002/Ecore", "EObject")), PParameterDirection.INOUT);

    private final PParameter parameter_connections = new PParameter("connections", "java.lang.Integer", new JavaTransitiveInstancesKey(java.lang.Integer.class), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_modelObj, parameter_connections);

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "edu.toronto.cs.se.mmint.productline.viatra.tests.highlyConnectedModelObjsCD";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("modelObj","connections");
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
          PVariable var_connections = body.getOrCreateVariableByName("connections");
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          new TypeConstraint(body, Tuples.flatTupleOf(var_modelObj), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EObject")));
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_connections), new JavaTransitiveInstancesKey(java.lang.Integer.class));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_modelObj, parameter_modelObj),
             new ExportedParameter(body, var_connections, parameter_connections)
          ));
          //   connections == count find connectedEMFObjects(modelObj, _)
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new PatternMatchCounter(body, Tuples.flatTupleOf(var_modelObj, var___0_), ConnectedEMFObjects.instance().getInternalQueryRepresentation(), var__virtual_0_);
          new Equality(body, var_connections, var__virtual_0_);
          bodies.add(body);
      }
      return bodies;
    }
  }
}

/**
 * 
 *   Copyright (c) 2019, 2025 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.viatra.mid;

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
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
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
 *         pattern connectedEMFObjects(modelObjSrc: EObject, modelObjTgt: EObject) {
 *           find connectedEMFObjectsWithMapping(modelObjSrc, modelObjTgt, _);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class ConnectedEMFObjects extends BaseGeneratedEMFQuerySpecification<ConnectedEMFObjects.Matcher> {
  /**
   * Pattern-specific match representation of the edu.toronto.cs.se.mmint.viatra.mid.connectedEMFObjects pattern,
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
    private EObject fModelObjSrc;

    private EObject fModelObjTgt;

    private static List<String> parameterNames = makeImmutableList("modelObjSrc", "modelObjTgt");

    private Match(final EObject pModelObjSrc, final EObject pModelObjTgt) {
      this.fModelObjSrc = pModelObjSrc;
      this.fModelObjTgt = pModelObjTgt;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "modelObjSrc": return this.fModelObjSrc;
          case "modelObjTgt": return this.fModelObjTgt;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fModelObjSrc;
          case 1: return this.fModelObjTgt;
          default: return null;
      }
    }

    public EObject getModelObjSrc() {
      return this.fModelObjSrc;
    }

    public EObject getModelObjTgt() {
      return this.fModelObjTgt;
    }

    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("modelObjSrc".equals(parameterName) ) {
          this.fModelObjSrc = (EObject) newValue;
          return true;
      }
      if ("modelObjTgt".equals(parameterName) ) {
          this.fModelObjTgt = (EObject) newValue;
          return true;
      }
      return false;
    }

    public void setModelObjSrc(final EObject pModelObjSrc) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fModelObjSrc = pModelObjSrc;
    }

    public void setModelObjTgt(final EObject pModelObjTgt) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fModelObjTgt = pModelObjTgt;
    }

    @Override
    public String patternName() {
      return "edu.toronto.cs.se.mmint.viatra.mid.connectedEMFObjects";
    }

    @Override
    public List<String> parameterNames() {
      return ConnectedEMFObjects.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fModelObjSrc, fModelObjTgt};
    }

    @Override
    public ConnectedEMFObjects.Match toImmutable() {
      return isMutable() ? newMatch(fModelObjSrc, fModelObjTgt) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"modelObjSrc\"=" + prettyPrintValue(fModelObjSrc) + ", ");
      result.append("\"modelObjTgt\"=" + prettyPrintValue(fModelObjTgt));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fModelObjSrc, fModelObjTgt);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof ConnectedEMFObjects.Match)) {
          ConnectedEMFObjects.Match other = (ConnectedEMFObjects.Match) obj;
          return Objects.equals(fModelObjSrc, other.fModelObjSrc) && Objects.equals(fModelObjTgt, other.fModelObjTgt);
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
    public ConnectedEMFObjects specification() {
      return ConnectedEMFObjects.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static ConnectedEMFObjects.Match newEmptyMatch() {
      return new Mutable(null, null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pModelObjSrc the fixed value of pattern parameter modelObjSrc, or null if not bound.
     * @param pModelObjTgt the fixed value of pattern parameter modelObjTgt, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static ConnectedEMFObjects.Match newMutableMatch(final EObject pModelObjSrc, final EObject pModelObjTgt) {
      return new Mutable(pModelObjSrc, pModelObjTgt);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pModelObjSrc the fixed value of pattern parameter modelObjSrc, or null if not bound.
     * @param pModelObjTgt the fixed value of pattern parameter modelObjTgt, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static ConnectedEMFObjects.Match newMatch(final EObject pModelObjSrc, final EObject pModelObjTgt) {
      return new Immutable(pModelObjSrc, pModelObjTgt);
    }

    private static final class Mutable extends ConnectedEMFObjects.Match {
      Mutable(final EObject pModelObjSrc, final EObject pModelObjTgt) {
        super(pModelObjSrc, pModelObjTgt);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends ConnectedEMFObjects.Match {
      Immutable(final EObject pModelObjSrc, final EObject pModelObjTgt) {
        super(pModelObjSrc, pModelObjTgt);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the edu.toronto.cs.se.mmint.viatra.mid.connectedEMFObjects pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern connectedEMFObjects(modelObjSrc: EObject, modelObjTgt: EObject) {
   *   find connectedEMFObjectsWithMapping(modelObjSrc, modelObjTgt, _);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see ConnectedEMFObjects
   * 
   */
  public static class Matcher extends BaseMatcher<ConnectedEMFObjects.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static ConnectedEMFObjects.Matcher on(final ViatraQueryEngine engine) {
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
    public static ConnectedEMFObjects.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_MODELOBJSRC = 0;

    private static final int POSITION_MODELOBJTGT = 1;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(ConnectedEMFObjects.Matcher.class);

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
     * @param pModelObjSrc the fixed value of pattern parameter modelObjSrc, or null if not bound.
     * @param pModelObjTgt the fixed value of pattern parameter modelObjTgt, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<ConnectedEMFObjects.Match> getAllMatches(final EObject pModelObjSrc, final EObject pModelObjTgt) {
      return rawStreamAllMatches(new Object[]{pModelObjSrc, pModelObjTgt}).collect(Collectors.toSet());
    }

    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pModelObjSrc the fixed value of pattern parameter modelObjSrc, or null if not bound.
     * @param pModelObjTgt the fixed value of pattern parameter modelObjTgt, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<ConnectedEMFObjects.Match> streamAllMatches(final EObject pModelObjSrc, final EObject pModelObjTgt) {
      return rawStreamAllMatches(new Object[]{pModelObjSrc, pModelObjTgt});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pModelObjSrc the fixed value of pattern parameter modelObjSrc, or null if not bound.
     * @param pModelObjTgt the fixed value of pattern parameter modelObjTgt, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<ConnectedEMFObjects.Match> getOneArbitraryMatch(final EObject pModelObjSrc, final EObject pModelObjTgt) {
      return rawGetOneArbitraryMatch(new Object[]{pModelObjSrc, pModelObjTgt});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pModelObjSrc the fixed value of pattern parameter modelObjSrc, or null if not bound.
     * @param pModelObjTgt the fixed value of pattern parameter modelObjTgt, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final EObject pModelObjSrc, final EObject pModelObjTgt) {
      return rawHasMatch(new Object[]{pModelObjSrc, pModelObjTgt});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pModelObjSrc the fixed value of pattern parameter modelObjSrc, or null if not bound.
     * @param pModelObjTgt the fixed value of pattern parameter modelObjTgt, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final EObject pModelObjSrc, final EObject pModelObjTgt) {
      return rawCountMatches(new Object[]{pModelObjSrc, pModelObjTgt});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pModelObjSrc the fixed value of pattern parameter modelObjSrc, or null if not bound.
     * @param pModelObjTgt the fixed value of pattern parameter modelObjTgt, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final EObject pModelObjSrc, final EObject pModelObjTgt, final Consumer<? super ConnectedEMFObjects.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pModelObjSrc, pModelObjTgt}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pModelObjSrc the fixed value of pattern parameter modelObjSrc, or null if not bound.
     * @param pModelObjTgt the fixed value of pattern parameter modelObjTgt, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public ConnectedEMFObjects.Match newMatch(final EObject pModelObjSrc, final EObject pModelObjTgt) {
      return ConnectedEMFObjects.Match.newMatch(pModelObjSrc, pModelObjTgt);
    }

    /**
     * Retrieve the set of values that occur in matches for modelObjSrc.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<EObject> rawStreamAllValuesOfmodelObjSrc(final Object[] parameters) {
      return rawStreamAllValues(POSITION_MODELOBJSRC, parameters).map(EObject.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for modelObjSrc.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<EObject> getAllValuesOfmodelObjSrc() {
      return rawStreamAllValuesOfmodelObjSrc(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for modelObjSrc.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<EObject> streamAllValuesOfmodelObjSrc() {
      return rawStreamAllValuesOfmodelObjSrc(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for modelObjSrc.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<EObject> streamAllValuesOfmodelObjSrc(final ConnectedEMFObjects.Match partialMatch) {
      return rawStreamAllValuesOfmodelObjSrc(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for modelObjSrc.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<EObject> streamAllValuesOfmodelObjSrc(final EObject pModelObjTgt) {
      return rawStreamAllValuesOfmodelObjSrc(new Object[]{null, pModelObjTgt});
    }

    /**
     * Retrieve the set of values that occur in matches for modelObjSrc.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<EObject> getAllValuesOfmodelObjSrc(final ConnectedEMFObjects.Match partialMatch) {
      return rawStreamAllValuesOfmodelObjSrc(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for modelObjSrc.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<EObject> getAllValuesOfmodelObjSrc(final EObject pModelObjTgt) {
      return rawStreamAllValuesOfmodelObjSrc(new Object[]{null, pModelObjTgt}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for modelObjTgt.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<EObject> rawStreamAllValuesOfmodelObjTgt(final Object[] parameters) {
      return rawStreamAllValues(POSITION_MODELOBJTGT, parameters).map(EObject.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for modelObjTgt.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<EObject> getAllValuesOfmodelObjTgt() {
      return rawStreamAllValuesOfmodelObjTgt(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for modelObjTgt.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<EObject> streamAllValuesOfmodelObjTgt() {
      return rawStreamAllValuesOfmodelObjTgt(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for modelObjTgt.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<EObject> streamAllValuesOfmodelObjTgt(final ConnectedEMFObjects.Match partialMatch) {
      return rawStreamAllValuesOfmodelObjTgt(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for modelObjTgt.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<EObject> streamAllValuesOfmodelObjTgt(final EObject pModelObjSrc) {
      return rawStreamAllValuesOfmodelObjTgt(new Object[]{pModelObjSrc, null});
    }

    /**
     * Retrieve the set of values that occur in matches for modelObjTgt.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<EObject> getAllValuesOfmodelObjTgt(final ConnectedEMFObjects.Match partialMatch) {
      return rawStreamAllValuesOfmodelObjTgt(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for modelObjTgt.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<EObject> getAllValuesOfmodelObjTgt(final EObject pModelObjSrc) {
      return rawStreamAllValuesOfmodelObjTgt(new Object[]{pModelObjSrc, null}).collect(Collectors.toSet());
    }

    @Override
    protected ConnectedEMFObjects.Match tupleToMatch(final Tuple t) {
      try {
          return ConnectedEMFObjects.Match.newMatch((EObject) t.get(POSITION_MODELOBJSRC), (EObject) t.get(POSITION_MODELOBJTGT));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected ConnectedEMFObjects.Match arrayToMatch(final Object[] match) {
      try {
          return ConnectedEMFObjects.Match.newMatch((EObject) match[POSITION_MODELOBJSRC], (EObject) match[POSITION_MODELOBJTGT]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected ConnectedEMFObjects.Match arrayToMatchMutable(final Object[] match) {
      try {
          return ConnectedEMFObjects.Match.newMutableMatch((EObject) match[POSITION_MODELOBJSRC], (EObject) match[POSITION_MODELOBJTGT]);
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
    public static IQuerySpecification<ConnectedEMFObjects.Matcher> querySpecification() {
      return ConnectedEMFObjects.instance();
    }
  }

  private ConnectedEMFObjects() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static ConnectedEMFObjects instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected ConnectedEMFObjects.Matcher instantiate(final ViatraQueryEngine engine) {
    return ConnectedEMFObjects.Matcher.on(engine);
  }

  @Override
  public ConnectedEMFObjects.Matcher instantiate() {
    return ConnectedEMFObjects.Matcher.create();
  }

  @Override
  public ConnectedEMFObjects.Match newEmptyMatch() {
    return ConnectedEMFObjects.Match.newEmptyMatch();
  }

  @Override
  public ConnectedEMFObjects.Match newMatch(final Object... parameters) {
    return ConnectedEMFObjects.Match.newMatch((EObject) parameters[0], (EObject) parameters[1]);
  }

  /**
   * Inner class allowing the singleton instance of {@link ConnectedEMFObjects} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link ConnectedEMFObjects#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final ConnectedEMFObjects INSTANCE = new ConnectedEMFObjects();

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
    private static final ConnectedEMFObjects.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_modelObjSrc = new PParameter("modelObjSrc", "org.eclipse.emf.ecore.EObject", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/emf/2002/Ecore", "EObject")), PParameterDirection.INOUT);

    private final PParameter parameter_modelObjTgt = new PParameter("modelObjTgt", "org.eclipse.emf.ecore.EObject", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/emf/2002/Ecore", "EObject")), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_modelObjSrc, parameter_modelObjTgt);

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "edu.toronto.cs.se.mmint.viatra.mid.connectedEMFObjects";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("modelObjSrc","modelObjTgt");
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
          PVariable var_modelObjSrc = body.getOrCreateVariableByName("modelObjSrc");
          PVariable var_modelObjTgt = body.getOrCreateVariableByName("modelObjTgt");
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          new TypeConstraint(body, Tuples.flatTupleOf(var_modelObjSrc), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EObject")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_modelObjTgt), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EObject")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_modelObjSrc, parameter_modelObjSrc),
             new ExportedParameter(body, var_modelObjTgt, parameter_modelObjTgt)
          ));
          //   find connectedEMFObjectsWithMapping(modelObjSrc, modelObjTgt, _)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_modelObjSrc, var_modelObjTgt, var___0_), ConnectedEMFObjectsWithMapping.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      return bodies;
    }
  }
}

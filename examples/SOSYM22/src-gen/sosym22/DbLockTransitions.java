/**
 * 
 *   Copyright (c) 2022, 2022 Alessio Di Sandro.
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
package sosym22;

import edu.toronto.cs.se.mmint.types.lts.Transition;
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
import org.eclipse.viatra.query.runtime.matchers.psystem.IExpressionEvaluator;
import org.eclipse.viatra.query.runtime.matchers.psystem.IValueProvider;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExpressionEvaluation;
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
 *         pattern dbLockTransitions(transition: Transition) {
 *           Transition.label(transition, label);
 *           check(label.startsWith("dbMonitor.condDB.lock"));
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class DbLockTransitions extends BaseGeneratedEMFQuerySpecification<DbLockTransitions.Matcher> {
  /**
   * Pattern-specific match representation of the sosym22.dbLockTransitions pattern,
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
    private Transition fTransition;
    
    private static List<String> parameterNames = makeImmutableList("transition");
    
    private Match(final Transition pTransition) {
      this.fTransition = pTransition;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "transition": return this.fTransition;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fTransition;
          default: return null;
      }
    }
    
    public Transition getTransition() {
      return this.fTransition;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("transition".equals(parameterName) ) {
          this.fTransition = (Transition) newValue;
          return true;
      }
      return false;
    }
    
    public void setTransition(final Transition pTransition) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fTransition = pTransition;
    }
    
    @Override
    public String patternName() {
      return "sosym22.dbLockTransitions";
    }
    
    @Override
    public List<String> parameterNames() {
      return DbLockTransitions.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fTransition};
    }
    
    @Override
    public DbLockTransitions.Match toImmutable() {
      return isMutable() ? newMatch(fTransition) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"transition\"=" + prettyPrintValue(fTransition));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fTransition);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof DbLockTransitions.Match)) {
          DbLockTransitions.Match other = (DbLockTransitions.Match) obj;
          return Objects.equals(fTransition, other.fTransition);
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
    public DbLockTransitions specification() {
      return DbLockTransitions.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static DbLockTransitions.Match newEmptyMatch() {
      return new Mutable(null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static DbLockTransitions.Match newMutableMatch(final Transition pTransition) {
      return new Mutable(pTransition);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static DbLockTransitions.Match newMatch(final Transition pTransition) {
      return new Immutable(pTransition);
    }
    
    private static final class Mutable extends DbLockTransitions.Match {
      Mutable(final Transition pTransition) {
        super(pTransition);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends DbLockTransitions.Match {
      Immutable(final Transition pTransition) {
        super(pTransition);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the sosym22.dbLockTransitions pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern dbLockTransitions(transition: Transition) {
   *   Transition.label(transition, label);
   *   check(label.startsWith("dbMonitor.condDB.lock"));
   * }
   * </pre></code>
   * 
   * @see Match
   * @see DbLockTransitions
   * 
   */
  public static class Matcher extends BaseMatcher<DbLockTransitions.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static DbLockTransitions.Matcher on(final ViatraQueryEngine engine) {
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
    public static DbLockTransitions.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_TRANSITION = 0;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(DbLockTransitions.Matcher.class);
    
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
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<DbLockTransitions.Match> getAllMatches(final Transition pTransition) {
      return rawStreamAllMatches(new Object[]{pTransition}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<DbLockTransitions.Match> streamAllMatches(final Transition pTransition) {
      return rawStreamAllMatches(new Object[]{pTransition});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<DbLockTransitions.Match> getOneArbitraryMatch(final Transition pTransition) {
      return rawGetOneArbitraryMatch(new Object[]{pTransition});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final Transition pTransition) {
      return rawHasMatch(new Object[]{pTransition});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final Transition pTransition) {
      return rawCountMatches(new Object[]{pTransition});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final Transition pTransition, final Consumer<? super DbLockTransitions.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pTransition}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public DbLockTransitions.Match newMatch(final Transition pTransition) {
      return DbLockTransitions.Match.newMatch(pTransition);
    }
    
    /**
     * Retrieve the set of values that occur in matches for transition.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Transition> rawStreamAllValuesOftransition(final Object[] parameters) {
      return rawStreamAllValues(POSITION_TRANSITION, parameters).map(Transition.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for transition.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Transition> getAllValuesOftransition() {
      return rawStreamAllValuesOftransition(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for transition.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Transition> streamAllValuesOftransition() {
      return rawStreamAllValuesOftransition(emptyArray());
    }
    
    @Override
    protected DbLockTransitions.Match tupleToMatch(final Tuple t) {
      try {
          return DbLockTransitions.Match.newMatch((Transition) t.get(POSITION_TRANSITION));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected DbLockTransitions.Match arrayToMatch(final Object[] match) {
      try {
          return DbLockTransitions.Match.newMatch((Transition) match[POSITION_TRANSITION]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected DbLockTransitions.Match arrayToMatchMutable(final Object[] match) {
      try {
          return DbLockTransitions.Match.newMutableMatch((Transition) match[POSITION_TRANSITION]);
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
    public static IQuerySpecification<DbLockTransitions.Matcher> querySpecification() {
      return DbLockTransitions.instance();
    }
  }
  
  private DbLockTransitions() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static DbLockTransitions instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected DbLockTransitions.Matcher instantiate(final ViatraQueryEngine engine) {
    return DbLockTransitions.Matcher.on(engine);
  }
  
  @Override
  public DbLockTransitions.Matcher instantiate() {
    return DbLockTransitions.Matcher.create();
  }
  
  @Override
  public DbLockTransitions.Match newEmptyMatch() {
    return DbLockTransitions.Match.newEmptyMatch();
  }
  
  @Override
  public DbLockTransitions.Match newMatch(final Object... parameters) {
    return DbLockTransitions.Match.newMatch((edu.toronto.cs.se.mmint.types.lts.Transition) parameters[0]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link DbLockTransitions} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link DbLockTransitions#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final DbLockTransitions INSTANCE = new DbLockTransitions();
    
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
    private static final DbLockTransitions.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_transition = new PParameter("transition", "edu.toronto.cs.se.mmint.types.lts.Transition", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("model://edu.toronto.cs.se.mmint.types.lts", "Transition")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_transition);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "sosym22.dbLockTransitions";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("transition");
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
          PVariable var_transition = body.getOrCreateVariableByName("transition");
          PVariable var_label = body.getOrCreateVariableByName("label");
          new TypeConstraint(body, Tuples.flatTupleOf(var_transition), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.types.lts", "Transition")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_transition, parameter_transition)
          ));
          //   Transition.label(transition, label)
          new TypeConstraint(body, Tuples.flatTupleOf(var_transition), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.types.lts", "Transition")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_transition, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("model://edu.toronto.cs.se.mmint.types.lts", "LabeledElement", "label")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EString")));
          new Equality(body, var__virtual_0_, var_label);
          //   check(label.startsWith("dbMonitor.condDB.lock"))
          new ExpressionEvaluation(body, new IExpressionEvaluator() {
          
              @Override
              public String getShortDescription() {
                  return "Expression evaluation from pattern dbLockTransitions";
              }
              
              @Override
              public Iterable<String> getInputParameterNames() {
                  return Arrays.asList("label");}
          
              @Override
              public Object evaluateExpression(IValueProvider provider) throws Exception {
                  String label = (String) provider.getValue("label");
                  return evaluateExpression_1_1(label);
              }
          },  null); 
          bodies.add(body);
      }
      return bodies;
    }
  }
  
  private static boolean evaluateExpression_1_1(final String label) {
    boolean _startsWith = label.startsWith("dbMonitor.condDB.lock");
    return _startsWith;
  }
}

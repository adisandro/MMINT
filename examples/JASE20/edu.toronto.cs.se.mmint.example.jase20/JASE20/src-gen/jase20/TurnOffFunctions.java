/**
 * Generated from platform:/resource/JASE20/src/jase20/scenarios.vql
 */
package jase20;

import edu.toronto.cs.se.modelepedia.classdiagram.Operation;
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
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.ConstantValue;
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
 *         pattern turnOffFunctions(class: Class,
 *                                  operation: Operation) {
 *           Class.ownedOperations(class, operation);
 *           Operation.name(operation, "TurnOff()");
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class TurnOffFunctions extends BaseGeneratedEMFQuerySpecification<TurnOffFunctions.Matcher> {
  /**
   * Pattern-specific match representation of the jase20.turnOffFunctions pattern,
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
    private edu.toronto.cs.se.modelepedia.classdiagram.Class fClass;
    
    private Operation fOperation;
    
    private static List<String> parameterNames = makeImmutableList("class", "operation");
    
    private Match(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClass, final Operation pOperation) {
      this.fClass = pClass;
      this.fOperation = pOperation;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "class": return this.fClass;
          case "operation": return this.fOperation;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fClass;
          case 1: return this.fOperation;
          default: return null;
      }
    }
    
    public edu.toronto.cs.se.modelepedia.classdiagram.Class getValueOfClass() {
      return this.fClass;
    }
    
    public Operation getOperation() {
      return this.fOperation;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("class".equals(parameterName) ) {
          this.fClass = (edu.toronto.cs.se.modelepedia.classdiagram.Class) newValue;
          return true;
      }
      if ("operation".equals(parameterName) ) {
          this.fOperation = (Operation) newValue;
          return true;
      }
      return false;
    }
    
    public void setClass(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClass) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fClass = pClass;
    }
    
    public void setOperation(final Operation pOperation) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fOperation = pOperation;
    }
    
    @Override
    public String patternName() {
      return "jase20.turnOffFunctions";
    }
    
    @Override
    public List<String> parameterNames() {
      return TurnOffFunctions.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fClass, fOperation};
    }
    
    @Override
    public TurnOffFunctions.Match toImmutable() {
      return isMutable() ? newMatch(fClass, fOperation) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"class\"=" + prettyPrintValue(fClass) + ", ");
      result.append("\"operation\"=" + prettyPrintValue(fOperation));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fClass, fOperation);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof TurnOffFunctions.Match)) {
          TurnOffFunctions.Match other = (TurnOffFunctions.Match) obj;
          return Objects.equals(fClass, other.fClass) && Objects.equals(fOperation, other.fOperation);
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
    public TurnOffFunctions specification() {
      return TurnOffFunctions.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static TurnOffFunctions.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pClass the fixed value of pattern parameter class, or null if not bound.
     * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static TurnOffFunctions.Match newMutableMatch(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClass, final Operation pOperation) {
      return new Mutable(pClass, pOperation);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pClass the fixed value of pattern parameter class, or null if not bound.
     * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static TurnOffFunctions.Match newMatch(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClass, final Operation pOperation) {
      return new Immutable(pClass, pOperation);
    }
    
    private static final class Mutable extends TurnOffFunctions.Match {
      Mutable(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClass, final Operation pOperation) {
        super(pClass, pOperation);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends TurnOffFunctions.Match {
      Immutable(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClass, final Operation pOperation) {
        super(pClass, pOperation);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the jase20.turnOffFunctions pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern turnOffFunctions(class: Class,
   *                          operation: Operation) {
   *   Class.ownedOperations(class, operation);
   *   Operation.name(operation, "TurnOff()");
   * }
   * </pre></code>
   * 
   * @see Match
   * @see TurnOffFunctions
   * 
   */
  public static class Matcher extends BaseMatcher<TurnOffFunctions.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static TurnOffFunctions.Matcher on(final ViatraQueryEngine engine) {
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
    public static TurnOffFunctions.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_CLASS = 0;
    
    private static final int POSITION_OPERATION = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(TurnOffFunctions.Matcher.class);
    
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
     * @param pClass the fixed value of pattern parameter class, or null if not bound.
     * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<TurnOffFunctions.Match> getAllMatches(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClass, final Operation pOperation) {
      return rawStreamAllMatches(new Object[]{pClass, pOperation}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pClass the fixed value of pattern parameter class, or null if not bound.
     * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<TurnOffFunctions.Match> streamAllMatches(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClass, final Operation pOperation) {
      return rawStreamAllMatches(new Object[]{pClass, pOperation});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pClass the fixed value of pattern parameter class, or null if not bound.
     * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<TurnOffFunctions.Match> getOneArbitraryMatch(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClass, final Operation pOperation) {
      return rawGetOneArbitraryMatch(new Object[]{pClass, pOperation});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pClass the fixed value of pattern parameter class, or null if not bound.
     * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClass, final Operation pOperation) {
      return rawHasMatch(new Object[]{pClass, pOperation});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pClass the fixed value of pattern parameter class, or null if not bound.
     * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClass, final Operation pOperation) {
      return rawCountMatches(new Object[]{pClass, pOperation});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pClass the fixed value of pattern parameter class, or null if not bound.
     * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClass, final Operation pOperation, final Consumer<? super TurnOffFunctions.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pClass, pOperation}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pClass the fixed value of pattern parameter class, or null if not bound.
     * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public TurnOffFunctions.Match newMatch(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClass, final Operation pOperation) {
      return TurnOffFunctions.Match.newMatch(pClass, pOperation);
    }
    
    /**
     * Retrieve the set of values that occur in matches for class.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<edu.toronto.cs.se.modelepedia.classdiagram.Class> rawStreamAllValuesOfclass(final Object[] parameters) {
      return rawStreamAllValues(POSITION_CLASS, parameters).map(edu.toronto.cs.se.modelepedia.classdiagram.Class.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for class.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.modelepedia.classdiagram.Class> getAllValuesOfclass() {
      return rawStreamAllValuesOfclass(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for class.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.modelepedia.classdiagram.Class> streamAllValuesOfclass() {
      return rawStreamAllValuesOfclass(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for class.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.modelepedia.classdiagram.Class> streamAllValuesOfclass(final TurnOffFunctions.Match partialMatch) {
      return rawStreamAllValuesOfclass(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for class.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.modelepedia.classdiagram.Class> streamAllValuesOfclass(final Operation pOperation) {
      return rawStreamAllValuesOfclass(new Object[]{null, pOperation});
    }
    
    /**
     * Retrieve the set of values that occur in matches for class.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.modelepedia.classdiagram.Class> getAllValuesOfclass(final TurnOffFunctions.Match partialMatch) {
      return rawStreamAllValuesOfclass(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for class.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.modelepedia.classdiagram.Class> getAllValuesOfclass(final Operation pOperation) {
      return rawStreamAllValuesOfclass(new Object[]{null, pOperation}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for operation.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Operation> rawStreamAllValuesOfoperation(final Object[] parameters) {
      return rawStreamAllValues(POSITION_OPERATION, parameters).map(Operation.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for operation.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Operation> getAllValuesOfoperation() {
      return rawStreamAllValuesOfoperation(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for operation.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Operation> streamAllValuesOfoperation() {
      return rawStreamAllValuesOfoperation(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for operation.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Operation> streamAllValuesOfoperation(final TurnOffFunctions.Match partialMatch) {
      return rawStreamAllValuesOfoperation(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for operation.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Operation> streamAllValuesOfoperation(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClass) {
      return rawStreamAllValuesOfoperation(new Object[]{pClass, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for operation.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Operation> getAllValuesOfoperation(final TurnOffFunctions.Match partialMatch) {
      return rawStreamAllValuesOfoperation(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for operation.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Operation> getAllValuesOfoperation(final edu.toronto.cs.se.modelepedia.classdiagram.Class pClass) {
      return rawStreamAllValuesOfoperation(new Object[]{pClass, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected TurnOffFunctions.Match tupleToMatch(final Tuple t) {
      try {
          return TurnOffFunctions.Match.newMatch((edu.toronto.cs.se.modelepedia.classdiagram.Class) t.get(POSITION_CLASS), (Operation) t.get(POSITION_OPERATION));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected TurnOffFunctions.Match arrayToMatch(final Object[] match) {
      try {
          return TurnOffFunctions.Match.newMatch((edu.toronto.cs.se.modelepedia.classdiagram.Class) match[POSITION_CLASS], (Operation) match[POSITION_OPERATION]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected TurnOffFunctions.Match arrayToMatchMutable(final Object[] match) {
      try {
          return TurnOffFunctions.Match.newMutableMatch((edu.toronto.cs.se.modelepedia.classdiagram.Class) match[POSITION_CLASS], (Operation) match[POSITION_OPERATION]);
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
    public static IQuerySpecification<TurnOffFunctions.Matcher> querySpecification() {
      return TurnOffFunctions.instance();
    }
  }
  
  private TurnOffFunctions() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static TurnOffFunctions instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected TurnOffFunctions.Matcher instantiate(final ViatraQueryEngine engine) {
    return TurnOffFunctions.Matcher.on(engine);
  }
  
  @Override
  public TurnOffFunctions.Matcher instantiate() {
    return TurnOffFunctions.Matcher.create();
  }
  
  @Override
  public TurnOffFunctions.Match newEmptyMatch() {
    return TurnOffFunctions.Match.newEmptyMatch();
  }
  
  @Override
  public TurnOffFunctions.Match newMatch(final Object... parameters) {
    return TurnOffFunctions.Match.newMatch((edu.toronto.cs.se.modelepedia.classdiagram.Class) parameters[0], (edu.toronto.cs.se.modelepedia.classdiagram.Operation) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link TurnOffFunctions} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link TurnOffFunctions#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final TurnOffFunctions INSTANCE = new TurnOffFunctions();
    
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
    private static final TurnOffFunctions.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_class = new PParameter("class", "edu.toronto.cs.se.modelepedia.classdiagram.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Class")), PParameterDirection.INOUT);
    
    private final PParameter parameter_operation = new PParameter("operation", "edu.toronto.cs.se.modelepedia.classdiagram.Operation", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Operation")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_class, parameter_operation);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "jase20.turnOffFunctions";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("class","operation");
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
          PVariable var_class = body.getOrCreateVariableByName("class");
          PVariable var_operation = body.getOrCreateVariableByName("operation");
          new TypeConstraint(body, Tuples.flatTupleOf(var_class), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Class")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_operation), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Operation")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_class, parameter_class),
             new ExportedParameter(body, var_operation, parameter_operation)
          ));
          //   Class.ownedOperations(class, operation)
          new TypeConstraint(body, Tuples.flatTupleOf(var_class), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Class")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_class, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Class", "ownedOperations")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Operation")));
          new Equality(body, var__virtual_0_, var_operation);
          //   Operation.name(operation, "TurnOff()")
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new ConstantValue(body, var__virtual_1_, "TurnOff()");
          new TypeConstraint(body, Tuples.flatTupleOf(var_operation), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Operation")));
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_operation, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "NamedElement", "name")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EString")));
          new Equality(body, var__virtual_2_, var__virtual_1_);
          bodies.add(body);
      }
      return bodies;
    }
  }
}

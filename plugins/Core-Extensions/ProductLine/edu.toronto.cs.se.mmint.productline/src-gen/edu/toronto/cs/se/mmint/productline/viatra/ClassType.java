/**
 * Generated from platform:/resource/edu.toronto.cs.se.mmint.productline/src/edu/toronto/cs/se/mmint/productline/viatra/pl.vql
 */
package edu.toronto.cs.se.mmint.productline.viatra;

import edu.toronto.cs.se.mmint.productline.viatra.internal.SuperType;
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
import org.eclipse.viatra.query.runtime.matchers.context.common.JavaTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.TypeFilterConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.BinaryReflexiveTransitiveClosure;
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
 *         pattern classType(plClass: Class, type: java String) {
 *           Class.type(plClass, class);
 *           find superType(class, superClass);
 *           EClass.name(superClass, type);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class ClassType extends BaseGeneratedEMFQuerySpecification<ClassType.Matcher> {
  /**
   * Pattern-specific match representation of the edu.toronto.cs.se.mmint.productline.viatra.classType pattern,
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
    private edu.toronto.cs.se.mmint.productline.Class fPlClass;
    
    private String fType;
    
    private static List<String> parameterNames = makeImmutableList("plClass", "type");
    
    private Match(final edu.toronto.cs.se.mmint.productline.Class pPlClass, final String pType) {
      this.fPlClass = pPlClass;
      this.fType = pType;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "plClass": return this.fPlClass;
          case "type": return this.fType;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fPlClass;
          case 1: return this.fType;
          default: return null;
      }
    }
    
    public edu.toronto.cs.se.mmint.productline.Class getPlClass() {
      return this.fPlClass;
    }
    
    public String getType() {
      return this.fType;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("plClass".equals(parameterName) ) {
          this.fPlClass = (edu.toronto.cs.se.mmint.productline.Class) newValue;
          return true;
      }
      if ("type".equals(parameterName) ) {
          this.fType = (String) newValue;
          return true;
      }
      return false;
    }
    
    public void setPlClass(final edu.toronto.cs.se.mmint.productline.Class pPlClass) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fPlClass = pPlClass;
    }
    
    public void setType(final String pType) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fType = pType;
    }
    
    @Override
    public String patternName() {
      return "edu.toronto.cs.se.mmint.productline.viatra.classType";
    }
    
    @Override
    public List<String> parameterNames() {
      return ClassType.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fPlClass, fType};
    }
    
    @Override
    public ClassType.Match toImmutable() {
      return isMutable() ? newMatch(fPlClass, fType) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"plClass\"=" + prettyPrintValue(fPlClass) + ", ");
      result.append("\"type\"=" + prettyPrintValue(fType));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fPlClass, fType);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof ClassType.Match)) {
          ClassType.Match other = (ClassType.Match) obj;
          return Objects.equals(fPlClass, other.fPlClass) && Objects.equals(fType, other.fType);
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
    public ClassType specification() {
      return ClassType.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static ClassType.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pPlClass the fixed value of pattern parameter plClass, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static ClassType.Match newMutableMatch(final edu.toronto.cs.se.mmint.productline.Class pPlClass, final String pType) {
      return new Mutable(pPlClass, pType);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pPlClass the fixed value of pattern parameter plClass, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static ClassType.Match newMatch(final edu.toronto.cs.se.mmint.productline.Class pPlClass, final String pType) {
      return new Immutable(pPlClass, pType);
    }
    
    private static final class Mutable extends ClassType.Match {
      Mutable(final edu.toronto.cs.se.mmint.productline.Class pPlClass, final String pType) {
        super(pPlClass, pType);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends ClassType.Match {
      Immutable(final edu.toronto.cs.se.mmint.productline.Class pPlClass, final String pType) {
        super(pPlClass, pType);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the edu.toronto.cs.se.mmint.productline.viatra.classType pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern classType(plClass: Class, type: java String) {
   *   Class.type(plClass, class);
   *   find superType(class, superClass);
   *   EClass.name(superClass, type);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see ClassType
   * 
   */
  public static class Matcher extends BaseMatcher<ClassType.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static ClassType.Matcher on(final ViatraQueryEngine engine) {
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
    public static ClassType.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_PLCLASS = 0;
    
    private static final int POSITION_TYPE = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(ClassType.Matcher.class);
    
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
     * @param pPlClass the fixed value of pattern parameter plClass, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<ClassType.Match> getAllMatches(final edu.toronto.cs.se.mmint.productline.Class pPlClass, final String pType) {
      return rawStreamAllMatches(new Object[]{pPlClass, pType}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pPlClass the fixed value of pattern parameter plClass, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<ClassType.Match> streamAllMatches(final edu.toronto.cs.se.mmint.productline.Class pPlClass, final String pType) {
      return rawStreamAllMatches(new Object[]{pPlClass, pType});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pPlClass the fixed value of pattern parameter plClass, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<ClassType.Match> getOneArbitraryMatch(final edu.toronto.cs.se.mmint.productline.Class pPlClass, final String pType) {
      return rawGetOneArbitraryMatch(new Object[]{pPlClass, pType});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pPlClass the fixed value of pattern parameter plClass, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final edu.toronto.cs.se.mmint.productline.Class pPlClass, final String pType) {
      return rawHasMatch(new Object[]{pPlClass, pType});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pPlClass the fixed value of pattern parameter plClass, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final edu.toronto.cs.se.mmint.productline.Class pPlClass, final String pType) {
      return rawCountMatches(new Object[]{pPlClass, pType});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pPlClass the fixed value of pattern parameter plClass, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final edu.toronto.cs.se.mmint.productline.Class pPlClass, final String pType, final Consumer<? super ClassType.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pPlClass, pType}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pPlClass the fixed value of pattern parameter plClass, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public ClassType.Match newMatch(final edu.toronto.cs.se.mmint.productline.Class pPlClass, final String pType) {
      return ClassType.Match.newMatch(pPlClass, pType);
    }
    
    /**
     * Retrieve the set of values that occur in matches for plClass.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<edu.toronto.cs.se.mmint.productline.Class> rawStreamAllValuesOfplClass(final Object[] parameters) {
      return rawStreamAllValues(POSITION_PLCLASS, parameters).map(edu.toronto.cs.se.mmint.productline.Class.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for plClass.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Class> getAllValuesOfplClass() {
      return rawStreamAllValuesOfplClass(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plClass.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.mmint.productline.Class> streamAllValuesOfplClass() {
      return rawStreamAllValuesOfplClass(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plClass.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.mmint.productline.Class> streamAllValuesOfplClass(final ClassType.Match partialMatch) {
      return rawStreamAllValuesOfplClass(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plClass.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<edu.toronto.cs.se.mmint.productline.Class> streamAllValuesOfplClass(final String pType) {
      return rawStreamAllValuesOfplClass(new Object[]{null, pType});
    }
    
    /**
     * Retrieve the set of values that occur in matches for plClass.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Class> getAllValuesOfplClass(final ClassType.Match partialMatch) {
      return rawStreamAllValuesOfplClass(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plClass.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<edu.toronto.cs.se.mmint.productline.Class> getAllValuesOfplClass(final String pType) {
      return rawStreamAllValuesOfplClass(new Object[]{null, pType}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for type.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<String> rawStreamAllValuesOftype(final Object[] parameters) {
      return rawStreamAllValues(POSITION_TYPE, parameters).map(String.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for type.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOftype() {
      return rawStreamAllValuesOftype(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for type.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOftype() {
      return rawStreamAllValuesOftype(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for type.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOftype(final ClassType.Match partialMatch) {
      return rawStreamAllValuesOftype(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for type.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOftype(final edu.toronto.cs.se.mmint.productline.Class pPlClass) {
      return rawStreamAllValuesOftype(new Object[]{pPlClass, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for type.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOftype(final ClassType.Match partialMatch) {
      return rawStreamAllValuesOftype(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for type.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOftype(final edu.toronto.cs.se.mmint.productline.Class pPlClass) {
      return rawStreamAllValuesOftype(new Object[]{pPlClass, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected ClassType.Match tupleToMatch(final Tuple t) {
      try {
          return ClassType.Match.newMatch((edu.toronto.cs.se.mmint.productline.Class) t.get(POSITION_PLCLASS), (String) t.get(POSITION_TYPE));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected ClassType.Match arrayToMatch(final Object[] match) {
      try {
          return ClassType.Match.newMatch((edu.toronto.cs.se.mmint.productline.Class) match[POSITION_PLCLASS], (String) match[POSITION_TYPE]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected ClassType.Match arrayToMatchMutable(final Object[] match) {
      try {
          return ClassType.Match.newMutableMatch((edu.toronto.cs.se.mmint.productline.Class) match[POSITION_PLCLASS], (String) match[POSITION_TYPE]);
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
    public static IQuerySpecification<ClassType.Matcher> querySpecification() {
      return ClassType.instance();
    }
  }
  
  private ClassType() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static ClassType instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected ClassType.Matcher instantiate(final ViatraQueryEngine engine) {
    return ClassType.Matcher.on(engine);
  }
  
  @Override
  public ClassType.Matcher instantiate() {
    return ClassType.Matcher.create();
  }
  
  @Override
  public ClassType.Match newEmptyMatch() {
    return ClassType.Match.newEmptyMatch();
  }
  
  @Override
  public ClassType.Match newMatch(final Object... parameters) {
    return ClassType.Match.newMatch((edu.toronto.cs.se.mmint.productline.Class) parameters[0], (java.lang.String) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link ClassType} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link ClassType#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final ClassType INSTANCE = new ClassType();
    
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
    private static final ClassType.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_plClass = new PParameter("plClass", "edu.toronto.cs.se.mmint.productline.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("model://edu.toronto.cs.se.mmint.productline", "Class")), PParameterDirection.INOUT);
    
    private final PParameter parameter_type = new PParameter("type", "java.lang.String", new JavaTransitiveInstancesKey(java.lang.String.class), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_plClass, parameter_type);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "edu.toronto.cs.se.mmint.productline.viatra.classType";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("plClass","type");
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
          PVariable var_plClass = body.getOrCreateVariableByName("plClass");
          PVariable var_type = body.getOrCreateVariableByName("type");
          PVariable var_class = body.getOrCreateVariableByName("class");
          PVariable var_superClass = body.getOrCreateVariableByName("superClass");
          new TypeConstraint(body, Tuples.flatTupleOf(var_plClass), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "Class")));
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_type), new JavaTransitiveInstancesKey(java.lang.String.class));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_plClass, parameter_plClass),
             new ExportedParameter(body, var_type, parameter_type)
          ));
          //   Class.type(plClass, class)
          new TypeConstraint(body, Tuples.flatTupleOf(var_plClass), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "Class")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_plClass, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("model://edu.toronto.cs.se.mmint.productline", "Class", "type")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EClass")));
          new Equality(body, var__virtual_0_, var_class);
          //   find superType*(class, superClass)
          new BinaryReflexiveTransitiveClosure(body, Tuples.flatTupleOf(var_class, var_superClass), SuperType.instance().getInternalQueryRepresentation(), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EClass")));
          //   EClass.name(superClass, type)
          new TypeConstraint(body, Tuples.flatTupleOf(var_superClass), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EClass")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_superClass, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/emf/2002/Ecore", "ENamedElement", "name")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EString")));
          new Equality(body, var__virtual_1_, var_type);
          bodies.add(body);
      }
      return bodies;
    }
  }
}

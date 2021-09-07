/**
 * Generated from platform:/resource/edu.toronto.cs.se.mmint.productline/src/edu/toronto/cs/se/mmint/productline/viatra/pl.vql
 */
package edu.toronto.cs.se.mmint.productline.viatra;

import edu.toronto.cs.se.mmint.productline.Reference;
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
 *         pattern referenceType(plReference: Reference, type: java String) {
 *           Reference.type.name(plReference, type);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class ReferenceType extends BaseGeneratedEMFQuerySpecification<ReferenceType.Matcher> {
  /**
   * Pattern-specific match representation of the edu.toronto.cs.se.mmint.productline.viatra.referenceType pattern,
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
    private Reference fPlReference;
    
    private String fType;
    
    private static List<String> parameterNames = makeImmutableList("plReference", "type");
    
    private Match(final Reference pPlReference, final String pType) {
      this.fPlReference = pPlReference;
      this.fType = pType;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "plReference": return this.fPlReference;
          case "type": return this.fType;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fPlReference;
          case 1: return this.fType;
          default: return null;
      }
    }
    
    public Reference getPlReference() {
      return this.fPlReference;
    }
    
    public String getType() {
      return this.fType;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("plReference".equals(parameterName) ) {
          this.fPlReference = (Reference) newValue;
          return true;
      }
      if ("type".equals(parameterName) ) {
          this.fType = (String) newValue;
          return true;
      }
      return false;
    }
    
    public void setPlReference(final Reference pPlReference) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fPlReference = pPlReference;
    }
    
    public void setType(final String pType) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fType = pType;
    }
    
    @Override
    public String patternName() {
      return "edu.toronto.cs.se.mmint.productline.viatra.referenceType";
    }
    
    @Override
    public List<String> parameterNames() {
      return ReferenceType.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fPlReference, fType};
    }
    
    @Override
    public ReferenceType.Match toImmutable() {
      return isMutable() ? newMatch(fPlReference, fType) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"plReference\"=" + prettyPrintValue(fPlReference) + ", ");
      result.append("\"type\"=" + prettyPrintValue(fType));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fPlReference, fType);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof ReferenceType.Match)) {
          ReferenceType.Match other = (ReferenceType.Match) obj;
          return Objects.equals(fPlReference, other.fPlReference) && Objects.equals(fType, other.fType);
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
    public ReferenceType specification() {
      return ReferenceType.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static ReferenceType.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pPlReference the fixed value of pattern parameter plReference, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static ReferenceType.Match newMutableMatch(final Reference pPlReference, final String pType) {
      return new Mutable(pPlReference, pType);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pPlReference the fixed value of pattern parameter plReference, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static ReferenceType.Match newMatch(final Reference pPlReference, final String pType) {
      return new Immutable(pPlReference, pType);
    }
    
    private static final class Mutable extends ReferenceType.Match {
      Mutable(final Reference pPlReference, final String pType) {
        super(pPlReference, pType);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends ReferenceType.Match {
      Immutable(final Reference pPlReference, final String pType) {
        super(pPlReference, pType);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the edu.toronto.cs.se.mmint.productline.viatra.referenceType pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern referenceType(plReference: Reference, type: java String) {
   *   Reference.type.name(plReference, type);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see ReferenceType
   * 
   */
  public static class Matcher extends BaseMatcher<ReferenceType.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static ReferenceType.Matcher on(final ViatraQueryEngine engine) {
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
    public static ReferenceType.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_PLREFERENCE = 0;
    
    private static final int POSITION_TYPE = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(ReferenceType.Matcher.class);
    
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
     * @param pPlReference the fixed value of pattern parameter plReference, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<ReferenceType.Match> getAllMatches(final Reference pPlReference, final String pType) {
      return rawStreamAllMatches(new Object[]{pPlReference, pType}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pPlReference the fixed value of pattern parameter plReference, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<ReferenceType.Match> streamAllMatches(final Reference pPlReference, final String pType) {
      return rawStreamAllMatches(new Object[]{pPlReference, pType});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pPlReference the fixed value of pattern parameter plReference, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<ReferenceType.Match> getOneArbitraryMatch(final Reference pPlReference, final String pType) {
      return rawGetOneArbitraryMatch(new Object[]{pPlReference, pType});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pPlReference the fixed value of pattern parameter plReference, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final Reference pPlReference, final String pType) {
      return rawHasMatch(new Object[]{pPlReference, pType});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pPlReference the fixed value of pattern parameter plReference, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final Reference pPlReference, final String pType) {
      return rawCountMatches(new Object[]{pPlReference, pType});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pPlReference the fixed value of pattern parameter plReference, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final Reference pPlReference, final String pType, final Consumer<? super ReferenceType.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pPlReference, pType}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pPlReference the fixed value of pattern parameter plReference, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public ReferenceType.Match newMatch(final Reference pPlReference, final String pType) {
      return ReferenceType.Match.newMatch(pPlReference, pType);
    }
    
    /**
     * Retrieve the set of values that occur in matches for plReference.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Reference> rawStreamAllValuesOfplReference(final Object[] parameters) {
      return rawStreamAllValues(POSITION_PLREFERENCE, parameters).map(Reference.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for plReference.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Reference> getAllValuesOfplReference() {
      return rawStreamAllValuesOfplReference(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plReference.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Reference> streamAllValuesOfplReference() {
      return rawStreamAllValuesOfplReference(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plReference.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Reference> streamAllValuesOfplReference(final ReferenceType.Match partialMatch) {
      return rawStreamAllValuesOfplReference(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plReference.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Reference> streamAllValuesOfplReference(final String pType) {
      return rawStreamAllValuesOfplReference(new Object[]{null, pType});
    }
    
    /**
     * Retrieve the set of values that occur in matches for plReference.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Reference> getAllValuesOfplReference(final ReferenceType.Match partialMatch) {
      return rawStreamAllValuesOfplReference(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for plReference.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Reference> getAllValuesOfplReference(final String pType) {
      return rawStreamAllValuesOfplReference(new Object[]{null, pType}).collect(Collectors.toSet());
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
    public Stream<String> streamAllValuesOftype(final ReferenceType.Match partialMatch) {
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
    public Stream<String> streamAllValuesOftype(final Reference pPlReference) {
      return rawStreamAllValuesOftype(new Object[]{pPlReference, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for type.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOftype(final ReferenceType.Match partialMatch) {
      return rawStreamAllValuesOftype(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for type.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOftype(final Reference pPlReference) {
      return rawStreamAllValuesOftype(new Object[]{pPlReference, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected ReferenceType.Match tupleToMatch(final Tuple t) {
      try {
          return ReferenceType.Match.newMatch((Reference) t.get(POSITION_PLREFERENCE), (String) t.get(POSITION_TYPE));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected ReferenceType.Match arrayToMatch(final Object[] match) {
      try {
          return ReferenceType.Match.newMatch((Reference) match[POSITION_PLREFERENCE], (String) match[POSITION_TYPE]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected ReferenceType.Match arrayToMatchMutable(final Object[] match) {
      try {
          return ReferenceType.Match.newMutableMatch((Reference) match[POSITION_PLREFERENCE], (String) match[POSITION_TYPE]);
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
    public static IQuerySpecification<ReferenceType.Matcher> querySpecification() {
      return ReferenceType.instance();
    }
  }
  
  private ReferenceType() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static ReferenceType instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected ReferenceType.Matcher instantiate(final ViatraQueryEngine engine) {
    return ReferenceType.Matcher.on(engine);
  }
  
  @Override
  public ReferenceType.Matcher instantiate() {
    return ReferenceType.Matcher.create();
  }
  
  @Override
  public ReferenceType.Match newEmptyMatch() {
    return ReferenceType.Match.newEmptyMatch();
  }
  
  @Override
  public ReferenceType.Match newMatch(final Object... parameters) {
    return ReferenceType.Match.newMatch((edu.toronto.cs.se.mmint.productline.Reference) parameters[0], (java.lang.String) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link ReferenceType} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link ReferenceType#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final ReferenceType INSTANCE = new ReferenceType();
    
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
    private static final ReferenceType.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_plReference = new PParameter("plReference", "edu.toronto.cs.se.mmint.productline.Reference", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("model://edu.toronto.cs.se.mmint.productline", "Reference")), PParameterDirection.INOUT);
    
    private final PParameter parameter_type = new PParameter("type", "java.lang.String", new JavaTransitiveInstancesKey(java.lang.String.class), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_plReference, parameter_type);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "edu.toronto.cs.se.mmint.productline.viatra.referenceType";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("plReference","type");
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
          PVariable var_plReference = body.getOrCreateVariableByName("plReference");
          PVariable var_type = body.getOrCreateVariableByName("type");
          new TypeConstraint(body, Tuples.flatTupleOf(var_plReference), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "Reference")));
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_type), new JavaTransitiveInstancesKey(java.lang.String.class));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_plReference, parameter_plReference),
             new ExportedParameter(body, var_type, parameter_type)
          ));
          //   Reference.type.name(plReference, type)
          new TypeConstraint(body, Tuples.flatTupleOf(var_plReference), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("model://edu.toronto.cs.se.mmint.productline", "Reference")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_plReference, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("model://edu.toronto.cs.se.mmint.productline", "Reference", "type")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EReference")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/emf/2002/Ecore", "ENamedElement", "name")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EString")));
          new Equality(body, var__virtual_1_, var_type);
          bodies.add(body);
      }
      return bodies;
    }
  }
}

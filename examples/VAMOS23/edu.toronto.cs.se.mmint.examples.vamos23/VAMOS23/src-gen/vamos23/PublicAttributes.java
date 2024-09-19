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
package vamos23;

import edu.toronto.cs.se.modelepedia.classdiagram.Attribute;
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
 *         // Finds public attributes
 *         pattern publicAttributes(attribute: Attribute) {
 *           Attribute.public(attribute, true);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class PublicAttributes extends BaseGeneratedEMFQuerySpecification<PublicAttributes.Matcher> {
  /**
   * Pattern-specific match representation of the vamos23.publicAttributes pattern,
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
    private Attribute fAttribute;

    private static List<String> parameterNames = makeImmutableList("attribute");

    private Match(final Attribute pAttribute) {
      this.fAttribute = pAttribute;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "attribute": return this.fAttribute;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fAttribute;
          default: return null;
      }
    }

    public Attribute getAttribute() {
      return this.fAttribute;
    }

    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("attribute".equals(parameterName) ) {
          this.fAttribute = (Attribute) newValue;
          return true;
      }
      return false;
    }

    public void setAttribute(final Attribute pAttribute) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fAttribute = pAttribute;
    }

    @Override
    public String patternName() {
      return "vamos23.publicAttributes";
    }

    @Override
    public List<String> parameterNames() {
      return PublicAttributes.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fAttribute};
    }

    @Override
    public PublicAttributes.Match toImmutable() {
      return isMutable() ? newMatch(fAttribute) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"attribute\"=" + prettyPrintValue(fAttribute));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fAttribute);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof PublicAttributes.Match)) {
          PublicAttributes.Match other = (PublicAttributes.Match) obj;
          return Objects.equals(fAttribute, other.fAttribute);
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
    public PublicAttributes specification() {
      return PublicAttributes.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static PublicAttributes.Match newEmptyMatch() {
      return new Mutable(null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static PublicAttributes.Match newMutableMatch(final Attribute pAttribute) {
      return new Mutable(pAttribute);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static PublicAttributes.Match newMatch(final Attribute pAttribute) {
      return new Immutable(pAttribute);
    }

    private static final class Mutable extends PublicAttributes.Match {
      Mutable(final Attribute pAttribute) {
        super(pAttribute);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends PublicAttributes.Match {
      Immutable(final Attribute pAttribute) {
        super(pAttribute);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the vamos23.publicAttributes pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * // Finds public attributes
   * pattern publicAttributes(attribute: Attribute) {
   *   Attribute.public(attribute, true);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see PublicAttributes
   * 
   */
  public static class Matcher extends BaseMatcher<PublicAttributes.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static PublicAttributes.Matcher on(final ViatraQueryEngine engine) {
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
    public static PublicAttributes.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_ATTRIBUTE = 0;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(PublicAttributes.Matcher.class);

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
     * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<PublicAttributes.Match> getAllMatches(final Attribute pAttribute) {
      return rawStreamAllMatches(new Object[]{pAttribute}).collect(Collectors.toSet());
    }

    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<PublicAttributes.Match> streamAllMatches(final Attribute pAttribute) {
      return rawStreamAllMatches(new Object[]{pAttribute});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<PublicAttributes.Match> getOneArbitraryMatch(final Attribute pAttribute) {
      return rawGetOneArbitraryMatch(new Object[]{pAttribute});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final Attribute pAttribute) {
      return rawHasMatch(new Object[]{pAttribute});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final Attribute pAttribute) {
      return rawCountMatches(new Object[]{pAttribute});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final Attribute pAttribute, final Consumer<? super PublicAttributes.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pAttribute}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public PublicAttributes.Match newMatch(final Attribute pAttribute) {
      return PublicAttributes.Match.newMatch(pAttribute);
    }

    /**
     * Retrieve the set of values that occur in matches for attribute.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Attribute> rawStreamAllValuesOfattribute(final Object[] parameters) {
      return rawStreamAllValues(POSITION_ATTRIBUTE, parameters).map(Attribute.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for attribute.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Attribute> getAllValuesOfattribute() {
      return rawStreamAllValuesOfattribute(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for attribute.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Attribute> streamAllValuesOfattribute() {
      return rawStreamAllValuesOfattribute(emptyArray());
    }

    @Override
    protected PublicAttributes.Match tupleToMatch(final Tuple t) {
      try {
          return PublicAttributes.Match.newMatch((Attribute) t.get(POSITION_ATTRIBUTE));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected PublicAttributes.Match arrayToMatch(final Object[] match) {
      try {
          return PublicAttributes.Match.newMatch((Attribute) match[POSITION_ATTRIBUTE]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected PublicAttributes.Match arrayToMatchMutable(final Object[] match) {
      try {
          return PublicAttributes.Match.newMutableMatch((Attribute) match[POSITION_ATTRIBUTE]);
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
    public static IQuerySpecification<PublicAttributes.Matcher> querySpecification() {
      return PublicAttributes.instance();
    }
  }

  private PublicAttributes() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static PublicAttributes instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected PublicAttributes.Matcher instantiate(final ViatraQueryEngine engine) {
    return PublicAttributes.Matcher.on(engine);
  }

  @Override
  public PublicAttributes.Matcher instantiate() {
    return PublicAttributes.Matcher.create();
  }

  @Override
  public PublicAttributes.Match newEmptyMatch() {
    return PublicAttributes.Match.newEmptyMatch();
  }

  @Override
  public PublicAttributes.Match newMatch(final Object... parameters) {
    return PublicAttributes.Match.newMatch((Attribute) parameters[0]);
  }

  /**
   * Inner class allowing the singleton instance of {@link PublicAttributes} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link PublicAttributes#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final PublicAttributes INSTANCE = new PublicAttributes();

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
    private static final PublicAttributes.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_attribute = new PParameter("attribute", "edu.toronto.cs.se.modelepedia.classdiagram.Attribute", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Attribute")), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_attribute);

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "vamos23.publicAttributes";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("attribute");
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
          PVariable var_attribute = body.getOrCreateVariableByName("attribute");
          new TypeConstraint(body, Tuples.flatTupleOf(var_attribute), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Attribute")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_attribute, parameter_attribute)
          ));
          //   Attribute.public(attribute, true)
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new ConstantValue(body, var__virtual_0_, true);
          new TypeConstraint(body, Tuples.flatTupleOf(var_attribute), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "Attribute")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_attribute, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://se.cs.toronto.edu/modelepedia/ClassDiagram", "TypedElement", "public")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EBoolean")));
          new Equality(body, var__virtual_1_, var__virtual_0_);
          bodies.add(body);
      }
      return bodies;
    }
  }

  private static boolean evaluateExpression_1_1() {
    return true;
  }
}

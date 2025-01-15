/**
 * Copyright (c) 2012-2025 Alessio Di Sandro, Marsha Chechik.
 * All rights reserved. This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Alessio Di Sandro - Implementation
 */
package edu.toronto.cs.se.mmint.mid.reasoning;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;

/**
 * The specification of a reasoning trait to query megamodels.
 *
 * @author Alessio Di Sandro
 */
public interface IQueryTrait extends IReasoner {

  /**
   * The specification of a query: the reasoner implementing the query engine, the path to the query file, the object
   * representing the query to be evaluated within the file (e.g. a query name).
   */
  public record QuerySpec(IQueryTrait reasoner, String filePath, Object query) {
    public QuerySpec(IQueryTrait reasoner, String filePath, Object query) {
      this.reasoner = Objects.requireNonNull(reasoner);
      this.filePath = Objects.requireNonNull(filePath);
      this.query = Objects.requireNonNull(query);
    }
    /**
     * Evaluates a query to find elements within a megamodel.
     *
     * @param context
     *          The context where the query is executed, i.e. a megamodel, or one of its contained elements.
     * @param args
     *          The actual arguments to the query.
     * @return A list of megamodel elements that match the query.
     * @throws Exception
     *           If there is an error evaluating the query.
     */
    public List<Object> evaluateQuery(EObject context, List<? extends EObject> args) throws Exception {
      return this.reasoner.evaluateQuery(this.filePath, this.query, context, args);
    }
  }

  /**
   * Gets the file extensions of the supported query files.
   *
   * @return The query file extensions.
   */
  Set<String> getQueryFileExtensions();

  /**
   * Selects a query from a file. The returned object must be accepted as a valid {@code query} parameter by
   * {@link evaluateQuery}
   *
   * @param filePath
   *          The path to the query file.
   * @return The selected query.
   * @throws Exception
   *           If there is an error selecting the query.
   */
  default Object selectQuery(String filePath) throws Exception {
    // the default implementation simply asks the user for a query name and returns it
    return MIDDialogs.getStringInput("Evaluate query", "Insert query name to run", null);
  }

  /**
   * Evaluates a query to find elements within a megamodel.
   *
   * @param filePath
   *          The path to the query file.
   * @param query
   *          The query to be evaluated within the file. All implementing classes should support the simplest case where
   *          this is the query name string, but can extend it by supporting specific query engine objects.
   *          {@link #selectQuery} must return an object that is valid here.
   * @param context
   *          The context where the query is executed, i.e. a megamodel, or one of its contained elements.
   * @param args
   *          The actual arguments to the query.
   * @return A list of megamodel elements that match the query.
   * @throws Exception
   *           If there is an error evaluating the query.
   */
  List<Object> evaluateQuery(String filePath, Object query, EObject context, List<? extends EObject> args)
                            throws Exception;
}

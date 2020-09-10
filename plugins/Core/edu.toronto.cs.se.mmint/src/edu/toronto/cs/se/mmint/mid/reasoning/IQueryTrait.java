/**
 * Copyright (c) 2012-2020 Alessio Di Sandro, Marsha Chechik.
 * All rights reserved. This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Alessio Di Sandro - Implementation
 */
package edu.toronto.cs.se.mmint.mid.reasoning;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

/**
 * The specification of a reasoning trait to query megamodels.
 *
 * @author Alessio Di Sandro
 */
public interface IQueryTrait {

  /**
   * Gets the extensions of the supported query files.
   *
   * @return The query file extensions.
   */
  Set<String> getQueryFileExtensions();

  /**
   * Evaluates a query to find elements within a megamodel.
   *
   * @param queryFilePath
   *          The path to the query file.
   * @param queryName
   *          The name of the query to be evaluated (a query file can contain multiple queries).
   * @param context
   *          The context where the query is executed, i.e. a megamodel, or one of its contained elements.
   * @param queryArgs
   *          The actual arguments to the query.
   * @return A list of megamodel elements that match the query.
   */
  List<Object> evaluateQuery(String queryFilePath, String queryName, EObject context,
                             List<? extends EObject> queryArgs);

}

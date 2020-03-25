/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.safetycase.operator;

import edu.toronto.cs.se.mmint.mid.operator.impl.WorkflowOperatorImpl;

/**
 * Defaults to using GSNSlice.mid as the implementation.
 * TODO: Does it need a constraint for the input?
 * TODO: Nesting operators don't create shortcuts for rels' endpoints, should they? (it clutters a bit)
 *       workflow - Implemented, but Identity causes problems
 *       map - Not implemented
 * TODO: Previously, model rel as outputs in workflows MUST had their model endpoints as outputs too:
 *       makes sense if those models are created too, but then they would be outputs by construction
 *       if those models exist already, then they should simply be shortcuts (what if they are created within the workflow?)
 */
public class GSNSlice extends WorkflowOperatorImpl {}

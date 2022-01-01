/**
 * Copyright (c) 2012-2022 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.operator.mid.propagate;

import edu.toronto.cs.se.mmint.mid.operator.impl.WorkflowOperatorImpl;

/**
 * Defaults to using ChangeImpact.mid as the implementation.
 * TODO MMINT[IMPACT]:
 * - Add rules for propagation: e.g. mapping of slice types, using the rel direction to filter unwanted propagation
 * - Should EAttributes be sliceable/annotateable?
 * - Allow ADD/DEL/MOD of trace links as criterion to trigger change impact
 */
public class ChangeImpact extends WorkflowOperatorImpl {

}

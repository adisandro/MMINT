/**
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint;

import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;

/*
 * A root Operator is needed to serve as the wildcard GenericElement to select any operator type (although operator
 * types don't have the root Operator as supertype).
 * Then, a root operator implementation is needed because OperatorImpl can only be instanciated through a factory,
 * i.e. one can't just do "new OperatorImpl()", which is needed when initializing and syncing the Type MID.
 */
/* TODO MMINT[OPERATOR] Unify operator type behavior with other types now that we can create dynamic subtypes:
 * - Set root Operator as supertype and add filter in gmfmap to avoid drawing the inheritance link
 * - Add 2 model type endpoints to Model with cardinality 0..n, and they need to be always overridden
 * - Try to remove this class and maybe try to detect if there is an efactory for it?
 */
public class RootOperator extends OperatorImpl {

}

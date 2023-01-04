/**
 * Copyright (c) 2012-2023 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.operator.mid;

import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.mid.Model;

public class FilterNot extends Filter {

    @Override
    protected boolean isFiltered(@NonNull Model model) {

        return !super.isFiltered(model);
    }

}

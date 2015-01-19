/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mavo.reasoning;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mavo.MAVOCollection;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.editor.Diagram;

public interface IMAVOReasoningEngine {

	public @Nullable Model refineByMayAlternative(@NonNull Model model, @NonNull MAVOCollection mayAlternative);

	public @Nullable Model refineByMayModelObject(@NonNull Model model, @NonNull MAVOElement mayModelObj);

	public void highlightMAVOCollection(@NonNull Diagram modelDiagram, @NonNull MAVOCollection mavoCollection);

}

/**
 * Copyright (c) 2012-2026 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.sequencediagram.design;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagram;

/**
 * The services class used by VSM.
 */
public class Services {

    /**
    * See http://help.eclipse.org/neon/index.jsp?topic=%2Forg.eclipse.sirius.doc%2Fdoc%2Findex.html&cp=24 for documentation on how to write service methods.
    */
    public EObject myService(EObject self, String arg) {
       // TODO Auto-generated code
      return self;
    }

    public EObject getSequenceDiagram(EObject self) {
    	var curObject = self;
    	while (!(curObject == null || curObject instanceof SequenceDiagram)) {
    		curObject = curObject.eContainer();
    	}

    	return curObject;
    }
}

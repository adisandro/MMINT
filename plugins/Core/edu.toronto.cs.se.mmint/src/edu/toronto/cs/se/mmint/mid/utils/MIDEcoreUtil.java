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
package edu.toronto.cs.se.mmint.mid.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.mid.operator.Operator;

public class MIDEcoreUtil extends EcoreUtil {

	public static <T extends EObject> T copy(T eObject) {

		Copier copier = new MIDCopier();
		EObject result = copier.copy(eObject);
		copier.copyReferences();

		@SuppressWarnings("unchecked") T t = (T) result;
		return t;
	}

	public static class MIDCopier extends Copier {

		private static final long serialVersionUID = 1L;

		@Override
		protected EObject createCopy(EObject eObject) {

			if (eObject instanceof Operator) {
				try {
					Operator operatorType = MIDTypeRegistry.getType(((Operator) eObject).getUri());
					if (operatorType != null) {
						Operator operatorTypeCopy = operatorType.getClass().newInstance();
						return operatorTypeCopy;
					}
				}
				catch (Exception e) {
					// goto else
				}
			}

			return super.createCopy(eObject);
		}
	}

}

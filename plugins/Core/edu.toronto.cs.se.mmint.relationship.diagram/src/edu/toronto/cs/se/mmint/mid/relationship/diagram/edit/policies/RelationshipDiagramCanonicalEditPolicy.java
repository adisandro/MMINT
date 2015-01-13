/*
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
package edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.policies;

import org.eclipse.emf.common.notify.Notification;

import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.policies.ModelRelCanonicalEditPolicy;

/**
 * The canonical edit policy for the Relationship diagram (i.e. a model
 * relationship).
 * 
 * @author Alessio Di Sandro
 * 
 */
public class RelationshipDiagramCanonicalEditPolicy extends ModelRelCanonicalEditPolicy {

	/**
	 * Workaround for bug #148021.
	 * 
	 * @param event
	 *            The notification event.
	 * @return False.
	 */
	@Override
	protected boolean shouldHandleNotificationEvent(Notification event) {

		return false;
	}

}

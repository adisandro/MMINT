/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

public class NewOperatorTypeOverrideDialogContentProvider implements ITreeContentProvider {

    private String newOperatorName;
    private MID workflowMID;
    private List<Operator> filteredOperators;

    public NewOperatorTypeOverrideDialogContentProvider(@NonNull String workflowMIDPath,
                                                        @NonNull String newOperatorName)
                                                        throws Exception {

        this.workflowMID = (MID) FileUtils.readModelFile(workflowMIDPath, true);
        this.newOperatorName = newOperatorName;
        this.filteredOperators = null;
    }

    private boolean overrides(@NonNull Operator operator, @NonNull MID workflowMID) {

        Map<Model, String> inoutWorkflowModels = MIDRegistry.getInputOutputWorkflowModels(workflowMID);

        return true;
    }

    public @NonNull List<Operator> loadContents(@NonNull MID typeMID) {

        filteredOperators = new ArrayList<>();
        for (Operator operator : typeMID.getOperators()) {
            if (operator.getName().equals(this.newOperatorName) && this.overrides(operator, workflowMID)) {
                filteredOperators.add(operator);
            }
        }

        return filteredOperators;
    }

    /**
     * {@inheritDoc}
     * This implementation does nothing.
     */
    @Override
    public void dispose() {
        // do nothing
    }

    /**
     * {@inheritDoc}
     * This implementation does nothing.
     */
    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object[] getElements(Object inputElement) {

        return getChildren(inputElement);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object[] getChildren(Object parentElement) {

        if (parentElement instanceof MID) {
            if (filteredOperators == null) {
                this.loadContents((MID) parentElement);
            }
            return filteredOperators.toArray();
        }

        return new Object[] {};
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getParent(Object element) {

        if (element instanceof Operator) {
            return ((MID) element).eContainer();
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasChildren(Object element) {

        if (element instanceof MID) {
            if (filteredOperators == null) {
                this.loadContents((MID) element);
            }
            return !filteredOperators.isEmpty();
        }

        return false;
    }

}

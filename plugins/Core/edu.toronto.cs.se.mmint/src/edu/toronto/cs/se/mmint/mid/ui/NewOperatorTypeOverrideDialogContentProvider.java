/**
 * Copyright (c) 2012-2019 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmint.mid.operator.WorkflowOperator;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

public class NewOperatorTypeOverrideDialogContentProvider implements ITreeContentProvider {

    private String newOperatorName;
    private MID workflowMID;
    private List<Operator> overridableOperators;

    public NewOperatorTypeOverrideDialogContentProvider(@NonNull String workflowMIDPath,
                                                        @NonNull String newOperatorName)
                                                        throws Exception {

        this.workflowMID = (MID) FileUtils.readModelFile(workflowMIDPath, null, true);
        this.newOperatorName = newOperatorName;
        this.overridableOperators = null;
    }

    private boolean overrides(@NonNull Operator operatorType, @NonNull LinkedHashMap<Model, String> inoutWorkflowModels,
                              @NonNull MID typeMID) {

        //TODO MMINT[WORKFLOW] Reuse for heavy types? (and check overlap with MIDTypeHierarchy.getOverriddenModelTypeEndpoint())
        int i = 0;
        for (Entry<Model, String> inoutWorkflowModel : inoutWorkflowModels.entrySet()) {
            if (inoutWorkflowModel.getValue().equals(OperatorPackage.eINSTANCE.getOperator_Outputs().getName())) {
                continue;
            }
            String subtypeUri = inoutWorkflowModel.getKey().getMetatypeUri();
            String supertypeUri;
            try {
                //TODO MMINT[WORKFLOW] Handle varargs
                supertypeUri = operatorType.getInputs().get(i).getTargetUri();
            }
            catch (IndexOutOfBoundsException e) {
                return false;
            }
            if (!subtypeUri.equals(supertypeUri) && !MIDTypeHierarchy.isSubtypeOf(subtypeUri, supertypeUri, typeMID)) {
                return false;
            }
            i++;
        }

        return true;
    }

    private void loadOperators(@NonNull MID typeMID) {

        this.overridableOperators = new ArrayList<>();
        this.overridableOperators.add(typeMID.<Operator>getExtendibleElement(MMINT.ROOT_URI + MMINT.URI_SEPARATOR +
                                                                             WorkflowOperator.class.getSimpleName()));
        LinkedHashMap<Model, String> inoutWorkflowModels = MIDRegistry.getInputOutputWorkflowModels(workflowMID);
        for (Operator operatorType : typeMID.getOperators()) {
            if (
                operatorType.getName().equals(this.newOperatorName) &&
                this.overrides(operatorType, inoutWorkflowModels, typeMID)
            ) {
                this.overridableOperators.add(operatorType);
            }
        }
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
            if (this.overridableOperators == null) {
                this.loadOperators((MID) parentElement);
            }
            return this.overridableOperators.toArray();
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
            if (this.overridableOperators == null) {
                this.loadOperators((MID) element);
            }
            return !this.overridableOperators.isEmpty();
        }

        return false;
    }

}

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
package edu.toronto.cs.se.mmint.mid.operator.impl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDFactory;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.NestingOperator;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorGeneric;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipFactory;
import edu.toronto.cs.se.mmint.mid.ui.GMFUtils;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Nesting Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.impl.NestingOperatorImpl#getNestedMIDPath <em>Nested MID Path</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NestingOperatorImpl extends OperatorImpl implements NestingOperator {
    /**
   * The default value of the '{@link #getNestedMIDPath() <em>Nested MID Path</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getNestedMIDPath()
   * @generated
   * @ordered
   */
    protected static final String NESTED_MID_PATH_EDEFAULT = null;

    /**
   * The cached value of the '{@link #getNestedMIDPath() <em>Nested MID Path</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getNestedMIDPath()
   * @generated
   * @ordered
   */
    protected String nestedMIDPath = NestingOperatorImpl.NESTED_MID_PATH_EDEFAULT;

    /**
     * The nested MID, kept in memory for performance reasons (different from
     * {@link edu.toronto.cs.se.mmint.mid.impl.ModelImpl#inMemoryRootModelObj}, this is NOT for making it work when
     * there is no serialization).
     *
     * @generated NOT
     */
    protected MID inMemoryNestedMID;

    /**
     * The nested MID gmf diagram, kept in memory for performance reasons (different from
     * {@link edu.toronto.cs.se.mmint.mid.impl.ModelImpl#inMemoryRootModelObj}, this is NOT for making it work when
     * there is no serialization).
     *
     * @generated NOT
     */
    protected Diagram inMemoryNestedMIDDiagramRoot;

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    protected NestingOperatorImpl() {
    super();
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    protected EClass eStaticClass() {
    return OperatorPackage.Literals.NESTING_OPERATOR;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public String getNestedMIDPath() {
    return this.nestedMIDPath;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void setNestedMIDPath(String newNestedMIDPath) {
    String oldNestedMIDPath = this.nestedMIDPath;
    this.nestedMIDPath = newNestedMIDPath;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OperatorPackage.NESTING_OPERATOR__NESTED_MID_PATH, oldNestedMIDPath, this.nestedMIDPath));
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case OperatorPackage.NESTING_OPERATOR__NESTED_MID_PATH:
        return getNestedMIDPath();
    }
    return super.eGet(featureID, resolve, coreType);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case OperatorPackage.NESTING_OPERATOR__NESTED_MID_PATH:
        setNestedMIDPath((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void eUnset(int featureID) {
    switch (featureID) {
      case OperatorPackage.NESTING_OPERATOR__NESTED_MID_PATH:
        setNestedMIDPath(NestingOperatorImpl.NESTED_MID_PATH_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public boolean eIsSet(int featureID) {
    switch (featureID) {
      case OperatorPackage.NESTING_OPERATOR__NESTED_MID_PATH:
        return NestingOperatorImpl.NESTED_MID_PATH_EDEFAULT == null ? this.nestedMIDPath != null : !NestingOperatorImpl.NESTED_MID_PATH_EDEFAULT.equals(this.nestedMIDPath);
    }
    return super.eIsSet(featureID);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    @SuppressWarnings("unchecked")
    public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
    switch (operationID) {
      case OperatorPackage.NESTING_OPERATOR___GET_NESTED_INSTANCE_MID:
        try {
          return getNestedInstanceMID();
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case OperatorPackage.NESTING_OPERATOR___START_NESTED_INSTANCE__OPERATOR_ELIST_PROPERTIES_ELIST_MAP:
        try {
          return startNestedInstance((Operator)arguments.get(0), (EList<OperatorInput>)arguments.get(1), (Properties)arguments.get(2), (EList<OperatorGeneric>)arguments.get(3), (Map<String, MID>)arguments.get(4));
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
    }
    return super.eInvoke(operationID, arguments);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public String toStringGen() {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (nestedMIDPath: ");
    result.append(this.nestedMIDPath);
    result.append(')');
    return result.toString();
  }

    /**
     * @generated NOT
     */
    @Override
    public MID getNestedInstanceMID() throws MMINTException {

        MMINTException.mustBeInstance(this);

        if (this.inMemoryNestedMID != null) {
            return this.inMemoryNestedMID;
        }

        try {
            String nestedMIDPath = this.getNestedMIDPath();
            if (nestedMIDPath == null) {
                return null;
            }
            MID nestedMID = (MID) FileUtils.readModelFile(nestedMIDPath, null, true);
            this.inMemoryNestedMID = nestedMID;
            return nestedMID;
        }
        catch (Exception e) {
            this.inMemoryNestedMID = null;
            return null;
        }
    }

    /**
     * @generated NOT
     */
    protected Diagram getNestedInstanceMIDDiagramRoot() throws MMINTException {

        MMINTException.mustBeInstance(this);

        if (this.inMemoryNestedMIDDiagramRoot != null) {
            return this.inMemoryNestedMIDDiagramRoot;
        }

        try {
            String nestedMIDPath = this.getNestedMIDPath();
            if (nestedMIDPath == null) {
                return null;
            }
            String nestedMIDDiagramPath = nestedMIDPath + GMFUtils.DIAGRAM_SUFFIX;
            Diagram nestedMIDDiagramRoot = (Diagram) FileUtils.readModelFile(nestedMIDDiagramPath, null, true);
            this.inMemoryNestedMIDDiagramRoot = nestedMIDDiagramRoot;
            return nestedMIDDiagramRoot;
        }
        catch (Exception e) {
            this.inMemoryNestedMIDDiagramRoot = null;
            return null;
        }
    }

    /**
     * @generated NOT
     */
    @Override
    protected void addInstance(@NonNull Operator newOperator, @NonNull MIDLevel midLevel, @Nullable MID instanceMID) {

        super.addInstance(newOperator, midLevel, instanceMID);
        if (instanceMID == null || midLevel == MIDLevel.WORKFLOWS) {
            /* TODO MMINT[OPERATOR] Could we put a nestedMID in memory when not serialized too, or will it defeat the purpose of having a null instanceMID?
             * (could be useful for experiments, to keep track of random states and fetch execution times)
             * (normal operators that receive the nestedMID need to be able to create models in it without serializing them: need two different flags)
             */
            return;
        }

        String nestedMIDPath = FileUtils.getUniquePath(
            FileUtils.replaceFileNameInPath(
                MIDRegistry.getModelUri(instanceMID),
                newOperator.getName()),
            true,
            false);
        MID nestedMID = MIDFactory.eINSTANCE.createMID();
        nestedMID.setLevel(MIDLevel.INSTANCES);
        try {
            FileUtils.writeModelFile(nestedMID, nestedMIDPath, true);
            Diagram nestedMIDDiagramRoot = GMFUtils.createGMFDiagramAndFile(
                nestedMIDPath,
                nestedMIDPath + GMFUtils.DIAGRAM_SUFFIX,
                MIDTypeRegistry.getMIDModelType().getName(),
                MIDTypeRegistry.getTypeBundle(MIDTypeRegistry.getMIDDiagramType().getUri()).getSymbolicName(),
                true);
            ((NestingOperator) newOperator).setNestedMIDPath(nestedMIDPath);
            ((NestingOperatorImpl) newOperator).inMemoryNestedMID = nestedMID;
            ((NestingOperatorImpl) newOperator).inMemoryNestedMIDDiagramRoot = nestedMIDDiagramRoot;
        }
        catch (Exception e) {
            MMINTException.print(IStatus.WARNING, "Can't store the Instance MID to contain this nesting operator's intermediate artifacts, skipping it", e);
        }
    }

    /**
     * Create shortcuts to external models into the nested Instance MID.
     *
     * @param models
     *            The external models.
     * @throws MMINTException
     *             If this is not an operator instance, or if this operator was created without a nested Instance MID.
     * @generated NOT
     */
    protected void createNestedInstanceMIDModelShortcuts(@NonNull Set<Model> models) throws MMINTException {

        MMINTException.mustBeInstance(this);

        var nestedMIDPath = this.getNestedMIDPath();
        if (nestedMIDPath == null) {
            throw new MMINTException("The nested MID is not serialized");
        }
        if (models.isEmpty()) {
            return;
        }

        var nestedMID = this.getNestedInstanceMID();
        var nestedMIDDiagramRoot = this.getNestedInstanceMIDDiagramRoot();
        var midModelType = MIDTypeRegistry.getMIDModelType();
        var midDiagramPluginId = MIDTypeRegistry.getTypeBundle(MIDTypeRegistry.getMIDDiagramType().getUri()).getSymbolicName();
        var midViewProvider = MIDTypeRegistry.getCachedMIDViewProvider();
        var allShortcuts = models.stream() // collect model endpoints of rels
            .filter(m -> m instanceof ModelRel)
            .flatMap(r -> ((ModelRel) r).getModelEndpoints().stream())
            .map(ModelEndpoint::getTarget)
            .collect(Collectors.toSet());
        allShortcuts.addAll(models);
        // models first, then rels
        //TODO MMINT[NESTED] Is the double loop really needed?
        for (var model : allShortcuts) {
            if (model instanceof ModelRel || nestedMID.getExtendibleElement(model.getUri()) != null) {
                continue;
            }
            GMFUtils.createGMFNodeShortcut(model, nestedMIDDiagramRoot, midDiagramPluginId, midModelType.getName(),
                                           midViewProvider);
            nestedMID.getExtendibleTable().put(model.getUri(), model);
        }
        for (var modelRel : allShortcuts) {
            //TODO MMINT[NESTED] Is there a way to detect duplicate rel shortcuts, like in the model case?
            if (!(modelRel instanceof ModelRel)) {
                continue;
            }
            if (modelRel instanceof BinaryModelRel) {
                // gmf shortcuts can't be created for links, fake the shortcut as an nary rel
                String gmfTypeHint = GMFUtils.getGMFRegistryType(RelationshipFactory.eINSTANCE.createModelRel(), midDiagramPluginId + ".TypeContext");
                Node gmfNode = (midViewProvider == null) ?
                    ViewService.createNode(nestedMIDDiagramRoot, modelRel, gmfTypeHint, new PreferencesHint(midDiagramPluginId)) :
                    midViewProvider.createNode(new EObjectAdapter(modelRel), nestedMIDDiagramRoot, gmfTypeHint, -1, true, new PreferencesHint(midDiagramPluginId));
                GMFUtils.addGMFShortcut(gmfNode, midModelType.getName());
                //TODO MMINT[NESTED] Can't create model rel endpoints, but maybe can use some simple connectors
            }
            else {
                GMFUtils.createGMFNodeShortcut(modelRel, nestedMIDDiagramRoot, midDiagramPluginId,
                                               midModelType.getName(), midViewProvider);
            }
        }
    }

    /**
     * @generated NOT
     */
    protected @NonNull Map<Model, Model> replaceNestedModelsWithShortcuts(@NonNull Operator operator, @NonNull Map<String, MID> instanceMIDsByOperatorOutputs) throws MMINTException {

        MMINTException.mustBeInstance(this);

        MID nestedMID = this.getNestedInstanceMID();
        Map<Model, Model> nestedToCopiedModels = new HashMap<>();
        // models first
        for (int i = 0; i < operator.getOutputs().size(); i++) {
            ModelEndpoint nestedOutput = operator.getOutputs().get(i);
            Model nestedModel = nestedOutput.getTarget();
            if (nestedModel instanceof ModelRel) {
                continue;
            }
            try {
                Model copiedModel = nestedModel.getMetatype().importInstanceAndEditor(
                    nestedModel.getUri(), instanceMIDsByOperatorOutputs.get(nestedOutput.getName()));
                nestedOutput.setTarget(copiedModel);
                if (nestedMID != null) {
                    nestedMID.getModels().remove(nestedModel);
                    nestedMID.getExtendibleTable().put(copiedModel.getUri(), copiedModel);
                    nestedToCopiedModels.put(nestedModel, copiedModel);
                }
            }
            //TODO MMINT[NESTED] This is to catch operators that don't generate a new model (like Identity), should be more elegant
            catch (MMINTException e) {}
        }
        // model rels now
        for (int i = 0; i < operator.getOutputs().size(); i++) {
            ModelEndpoint nestedOutput = operator.getOutputs().get(i);
            if (!(nestedOutput.getTarget() instanceof ModelRel)) {
                continue;
            }
            ModelRel nestedModelRel = (ModelRel) nestedOutput.getTarget();
            try {
                ModelRel copiedModelRel = (ModelRel) nestedModelRel.getMetatype().copyInstance(
                    nestedModelRel, nestedModelRel.getName(), instanceMIDsByOperatorOutputs.get(nestedOutput.getName()));
                nestedOutput.setTarget(copiedModelRel);
                if (nestedMID != null) {
                    nestedMID.getModels().remove(nestedModelRel);
                    nestedToCopiedModels.put(nestedModelRel, copiedModelRel);
                }
            }
            //TODO MMINT[NESTED] This is to catch operators that don't generate a new model (like Identity), should be more elegant
            catch (Exception e) {}
        }

        if (nestedMID != null) {
            this.createNestedInstanceMIDModelShortcuts(new HashSet<>(nestedToCopiedModels.values()));
        }

        return nestedToCopiedModels;
    }

    /**
     * Writes the nested Instance MID to file.
     *
     * @throws MMINTException
     *             If this is not an operator instance, or if this operator was created without a nested Instance MID.
     * @throws IOException
     *             If the nested Instance MID could not be created or overwritten.
     * @generated NOT
     */
    protected void writeNestedInstanceMID() throws MMINTException, IOException {

        MMINTException.mustBeInstance(this);

        String nestedMIDPath = this.getNestedMIDPath();
        if (nestedMIDPath == null) {
            throw new MMINTException("The nested MID is not serialized");
        }

        String nestedMIDDiagramPath = nestedMIDPath + GMFUtils.DIAGRAM_SUFFIX;
        FileUtils.writeModelFile(this.getNestedInstanceMID(), nestedMIDPath, true);
        FileUtils.writeModelFile(this.getNestedInstanceMIDDiagramRoot(), nestedMIDDiagramPath, true);
        this.inMemoryNestedMID = null;
        this.inMemoryNestedMIDDiagramRoot = null;
    }

    /**
     * @generated NOT
     */
    @Override
    public Operator startNestedInstance(Operator nestedOperatorType, EList<OperatorInput> inputs, Properties inputProperties, EList<OperatorGeneric> generics, Map<String, MID> outputMIDsByName) throws Exception {

        //TODO MMINT[NESTED] Add option to detect when the nested MID is enabled, different from when operator instances are enabled (WorkflowOperator too)
        MMINTException.mustBeInstance(this);

        // create shortcuts to input models
        String nestedMIDPath = this.getNestedMIDPath();
        if (nestedMIDPath != null) {
            var inputModels = inputs.stream()
                .map(OperatorInput::getModel)
                .collect(Collectors.toSet());
            this.createNestedInstanceMIDModelShortcuts(inputModels);
        }
        // run nested operator
        MID nestedMID = this.getNestedInstanceMID();
        Map<String, MID> nestedOutputMIDsByName = MIDOperatorIOUtils.mixOutputMIDsByName(
            nestedOperatorType,
            nestedMID,
            outputMIDsByName);
        Operator newNestedOperator = nestedOperatorType.startInstance(
            inputs,
            inputProperties,
            generics,
            nestedOutputMIDsByName,
            nestedMID);
        // store nested MID
        if (nestedMIDPath != null) {
            this.writeNestedInstanceMID();
        }

        return newNestedOperator;
    }

    /**
     * @generated NOT
     */
    @Override
    public void deleteInstance() throws MMINTException {

        super.deleteInstance();
        String nestedMIDPath = this.getNestedMIDPath();
        if (nestedMIDPath != null) {
            MID nestedMID = this.getNestedInstanceMID();
            for (Model nestedModel : new ArrayList<>(nestedMID.getModels())) {
                nestedModel.deleteInstanceAndFile();
            }
            for (Operator nestedOperator : new ArrayList<>(nestedMID.getOperators())) {
                nestedOperator.deleteInstance();
            }
            FileUtils.deleteFile(nestedMIDPath, true);
            FileUtils.deleteFile(nestedMIDPath + GMFUtils.DIAGRAM_SUFFIX, true);
        }
    }

    /**
     * Opens the Instance MID with the nested artifacts generated by this operator instance, if it exists.
     *
     * @throws Exception
     *             If this is not an operator instance, or if the MID diagram can't be opened.
     * @generated NOT
     */
    @Override
    public void openInstance() throws Exception {

        MMINTException.mustBeInstance(this);

        String nestedMIDPath = this.getNestedMIDPath();
        if (nestedMIDPath != null) {
            FileUtils.openEclipseEditor(nestedMIDPath + GMFUtils.DIAGRAM_SUFFIX, MIDTypeRegistry.getMIDDiagramType().getId(), true);
        }
    }

} //NestingOperatorImpl

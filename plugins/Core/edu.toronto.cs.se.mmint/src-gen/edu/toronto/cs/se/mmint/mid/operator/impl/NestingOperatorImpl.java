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
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
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
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.impl.NestingOperatorImpl#getNestedMID <em>Nested MID</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.impl.NestingOperatorImpl#getNestedMIDGMFDiagram <em>Nested MIDGMF Diagram</em>}</li>
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
   * The cached value of the '{@link #getNestedMID() <em>Nested MID</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNestedMID()
   * @generated
   * @ordered
   */
  protected MID nestedMID;

    /**
   * The default value of the '{@link #getNestedMIDGMFDiagram() <em>Nested MIDGMF Diagram</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNestedMIDGMFDiagram()
   * @generated
   * @ordered
   */
  protected static final Diagram NESTED_MIDGMF_DIAGRAM_EDEFAULT = null;

    /**
   * The cached value of the '{@link #getNestedMIDGMFDiagram() <em>Nested MIDGMF Diagram</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNestedMIDGMFDiagram()
   * @generated
   * @ordered
   */
  protected Diagram nestedMIDGMFDiagram = NestingOperatorImpl.NESTED_MIDGMF_DIAGRAM_EDEFAULT;

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
    var oldNestedMIDPath = this.nestedMIDPath;
    this.nestedMIDPath = newNestedMIDPath;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OperatorPackage.NESTING_OPERATOR__NESTED_MID_PATH, oldNestedMIDPath, this.nestedMIDPath));
  }

    /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MID getNestedMIDGen() {
    if (this.nestedMID != null && this.nestedMID.eIsProxy()) {
      var oldNestedMID = (InternalEObject)this.nestedMID;
      this.nestedMID = (MID)eResolveProxy(oldNestedMID);
      if (this.nestedMID != oldNestedMID) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperatorPackage.NESTING_OPERATOR__NESTED_MID, oldNestedMID, this.nestedMID));
      }
    }
    return this.nestedMID;
  }

  /**
   * @generated NOT
   */
  @Override
  public MID getNestedMID() {
    try {
      MMINTException.mustBeInstance(this);
      var nestedMID = getNestedMIDGen();
      if (nestedMID == null) {
        var nestedMIDPath = getNestedMIDPath();
        if (nestedMIDPath == null) {
          return null;
        }
        nestedMID = (MID) FileUtils.readModelFile(nestedMIDPath, getMIDContainer().getEMFInstanceResourceSet(), true);
        // bypass EMF notifications and the need for a write transaction
        this.nestedMID = nestedMID;
      }
      return nestedMID;
    }
    catch (Exception e) {
      MMINTException.print(IStatus.WARNING, "Can't load nested MID, returning null", e);
      return null;
    }
  }

    /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MID basicGetNestedMID() {
    return this.nestedMID;
  }

    /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setNestedMID(MID newNestedMID) {
    var oldNestedMID = this.nestedMID;
    this.nestedMID = newNestedMID;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OperatorPackage.NESTING_OPERATOR__NESTED_MID, oldNestedMID, this.nestedMID));
  }

    /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Diagram getNestedMIDGMFDiagramGen() {
    return this.nestedMIDGMFDiagram;
  }

  /**
   * @generated NOT
   */
  @Override
  public Diagram getNestedMIDGMFDiagram() {
    try {
      MMINTException.mustBeInstance(this);
      var nestedGMFDiagram = getNestedMIDGMFDiagramGen();
      if (nestedGMFDiagram == null) {
        var nestedMIDPath = getNestedMIDPath();
        if (nestedMIDPath == null) {
          return null;
        }
        var nestedGMFDiagramPath = nestedMIDPath + GMFUtils.DIAGRAM_SUFFIX;
        nestedGMFDiagram = (Diagram) FileUtils.readModelFile(nestedGMFDiagramPath,
                                                          getMIDContainer().getEMFInstanceResourceSet(), true);
        // bypass EMF notifications and the need for a write transaction
        this.nestedMIDGMFDiagram = nestedGMFDiagram;
      }
      return nestedGMFDiagram;
    }
    catch (Exception e) {
      MMINTException.print(IStatus.WARNING, "Can't load nested MID GMF diagram, returning null", e);
      return null;
    }
  }

    /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setNestedMIDGMFDiagram(Diagram newNestedMIDGMFDiagram) {
    var oldNestedMIDGMFDiagram = this.nestedMIDGMFDiagram;
    this.nestedMIDGMFDiagram = newNestedMIDGMFDiagram;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OperatorPackage.NESTING_OPERATOR__NESTED_MIDGMF_DIAGRAM, oldNestedMIDGMFDiagram, this.nestedMIDGMFDiagram));
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
      case OperatorPackage.NESTING_OPERATOR__NESTED_MID:
        if (resolve) return getNestedMID();
        return basicGetNestedMID();
      case OperatorPackage.NESTING_OPERATOR__NESTED_MIDGMF_DIAGRAM:
        return getNestedMIDGMFDiagram();
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
      case OperatorPackage.NESTING_OPERATOR__NESTED_MID:
        setNestedMID((MID)newValue);
        return;
      case OperatorPackage.NESTING_OPERATOR__NESTED_MIDGMF_DIAGRAM:
        setNestedMIDGMFDiagram((Diagram)newValue);
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
      case OperatorPackage.NESTING_OPERATOR__NESTED_MID:
        setNestedMID((MID)null);
        return;
      case OperatorPackage.NESTING_OPERATOR__NESTED_MIDGMF_DIAGRAM:
        setNestedMIDGMFDiagram(NestingOperatorImpl.NESTED_MIDGMF_DIAGRAM_EDEFAULT);
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
      case OperatorPackage.NESTING_OPERATOR__NESTED_MID:
        return this.nestedMID != null;
      case OperatorPackage.NESTING_OPERATOR__NESTED_MIDGMF_DIAGRAM:
        return NestingOperatorImpl.NESTED_MIDGMF_DIAGRAM_EDEFAULT == null ? this.nestedMIDGMFDiagram != null : !NestingOperatorImpl.NESTED_MIDGMF_DIAGRAM_EDEFAULT.equals(this.nestedMIDGMFDiagram);
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
          return getNestedMID();
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
    result.append(", nestedMIDGMFDiagram: ");
    result.append(this.nestedMIDGMFDiagram);
    result.append(')');
    return result.toString();
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

    //TODO Is a diagram field really necessary?
    //TODO Review createNestedInstanceMIDModelShortcuts
    //TODO Map serialize outputs: look at nested mapper case
    //TODO Map review createOutputMIDRelShortcuts
    var nestedMIDPath = FileUtils.getUniquePath(
      FileUtils.replaceFileNameInPath(MIDRegistry.getModelUri(instanceMID), newOperator.getName()), true, false);
    var nestedGMFDiagramPath = nestedMIDPath + GMFUtils.DIAGRAM_SUFFIX;
    ((NestingOperator) newOperator).setNestedMIDPath(nestedMIDPath);
    var nestedMID = MIDFactory.eINSTANCE.createMID();
    nestedMID.setLevel(MIDLevel.INSTANCES);
    try {
      // the nested MID is serialized in advance because implementors may run standard operators:
      // they will use nested MID == instance MID and assume it is already a file
      var resourceSet = instanceMID.getEMFInstanceResourceSet();
      FileUtils.writeModelFile(nestedMID, nestedMIDPath, resourceSet, true);
      nestedMID.setEMFInstanceResourceSet(resourceSet);
      ((NestingOperator) newOperator).setNestedMID(nestedMID);
      var nestedGMFDiagram = GMFUtils.createGMFDiagramAndFile(
        nestedMID, nestedGMFDiagramPath, MIDTypeRegistry.getMIDModelType().getName(),
        MIDTypeRegistry.getTypeBundle(MIDTypeRegistry.getMIDDiagramType().getUri()).getSymbolicName(), true);
      ((NestingOperator) newOperator).setNestedMIDGMFDiagram(nestedGMFDiagram);
    }
    catch (Exception e) {
      MMINTException.print(IStatus.WARNING, "Can't store the nested MID to contain this nesting operator's" +
                           " intermediate artifacts, skipping it", e);
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

        var nestedMID = getNestedMID();
        var nestedMIDDiagramRoot = getNestedMIDGMFDiagram();
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
                var gmfNode = (midViewProvider == null) ?
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

        var nestedMID = getNestedMID();
        Map<Model, Model> nestedToCopiedModels = new HashMap<>();
        // models first
        for (var i = 0; i < operator.getOutputs().size(); i++) {
            var nestedOutput = operator.getOutputs().get(i);
            var nestedModel = nestedOutput.getTarget();
            if (nestedModel instanceof ModelRel) {
                continue;
            }
            try {
                var copiedModel = nestedModel.getMetatype().importInstanceAndEditor(
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
        for (var i = 0; i < operator.getOutputs().size(); i++) {
            var nestedOutput = operator.getOutputs().get(i);
            if (!(nestedOutput.getTarget() instanceof ModelRel)) {
                continue;
            }
            var nestedModelRel = (ModelRel) nestedOutput.getTarget();
            try {
                var copiedModelRel = (ModelRel) nestedModelRel.getMetatype().copyInstance(
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
  protected void writeNestedInstanceMID() throws Exception {
    MMINTException.mustBeInstance(this);
    var nestedMIDPath = getNestedMIDPath();
    if (nestedMIDPath == null) {
      throw new MMINTException("The nested MID is not serialized");
    }

    // nested resources already exist, handle them appropriately
    getNestedMID().eResource().save(FileUtils.SAVE_OPTIONS);
    getNestedMIDGMFDiagram().eResource().save(FileUtils.SAVE_OPTIONS);
  }

    /**
     * @generated NOT
     */
    @Override
    public Operator startNestedInstance(Operator nestedOperatorType, EList<OperatorInput> inputs, Properties inputProperties, EList<OperatorGeneric> generics, Map<String, MID> outputMIDsByName) throws Exception {
        //TODO MMINT[NESTED] Add option to detect when the nested MID is enabled, different from when operator instances are enabled (WorkflowOperator too)
        MMINTException.mustBeInstance(this);

        // create shortcuts to input models
        var nestedMIDPath = getNestedMIDPath();
        if (nestedMIDPath != null) {
            var inputModels = inputs.stream()
                .map(OperatorInput::getModel)
                .collect(Collectors.toSet());
            this.createNestedInstanceMIDModelShortcuts(inputModels);
        }
        // run nested operator
        var nestedMID = getNestedMID();
        Map<String, MID> nestedOutputMIDsByName = MIDOperatorIOUtils.mixOutputMIDsByName(
            nestedOperatorType,
            nestedMID,
            outputMIDsByName);
        var newNestedOperator = nestedOperatorType.startInstance(
            inputs,
            inputProperties,
            generics,
            nestedOutputMIDsByName,
            nestedMID);
        // store nested MID
        if (nestedMIDPath != null) {
            writeNestedInstanceMID();
        }

        return newNestedOperator;
    }

    /**
     * @generated NOT
     */
    @Override
    public void deleteInstance() throws MMINTException {

        super.deleteInstance();
        var nestedMIDPath = getNestedMIDPath();
        if (nestedMIDPath != null) {
            var nestedMID = getNestedMID();
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

        var nestedMIDPath = getNestedMIDPath();
        if (nestedMIDPath != null) {
            FileUtils.openEclipseEditor(nestedMIDPath + GMFUtils.DIAGRAM_SUFFIX,
                                        MIDTypeRegistry.getMIDDiagramType().getId(), true);
        }
    }

} //NestingOperatorImpl

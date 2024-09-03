/*******************************************************************************
 * Copyright (c) 2024, 2024 Alessio Di Sandro.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.mmint.productline.design;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.diagram.description.ContainerMapping;
import org.eclipse.sirius.diagram.description.DiagramDescription;
import org.eclipse.sirius.diagram.description.DiagramElementMapping;
import org.eclipse.sirius.diagram.description.EdgeMapping;
import org.eclipse.sirius.diagram.description.NodeMapping;
import org.eclipse.sirius.diagram.description.style.StyleFactory;
import org.eclipse.sirius.diagram.description.tool.ContainerCreationDescription;
import org.eclipse.sirius.diagram.description.tool.EdgeCreationDescription;
import org.eclipse.sirius.diagram.description.tool.NodeCreationDescription;
import org.eclipse.sirius.diagram.description.tool.ToolFactory;
import org.eclipse.sirius.viewpoint.description.DescriptionFactory;
import org.eclipse.sirius.viewpoint.description.Group;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;

public class ToProductLine extends OperatorImpl {
  private In in;
  private Out out;

  private static class In {
    public final static String MODEL = "siriusSpec";
    public Model specModel;

    public In(Map<String, Model> inputsByName) {
      this.specModel = inputsByName.get(In.MODEL);
    }
  }

  private static class Out {
    public final static String MODEL = "plSiriusSpec";
    public static final String SUFFIX = "_pl";
    public Model modelType;
    public Group plSiriusSpec;
    public DescriptionFactory vDescFactory;
    public org.eclipse.sirius.diagram.description.DescriptionFactory dDescFactory;
    public StyleFactory dStyleFactory;
    public ToolFactory dToolFactory;
    public org.eclipse.sirius.viewpoint.description.tool.ToolFactory vToolFactory;
    public String path;
    public MID mid;

    public Out(Map<String, MID> outputMIDsByName, String workingPath, In in) throws MMINTException {
      this.modelType = in.specModel.getMetatype();
      this.vDescFactory = DescriptionFactory.eINSTANCE;
      this.dDescFactory = org.eclipse.sirius.diagram.description.DescriptionFactory.eINSTANCE;
      this.dStyleFactory = StyleFactory.eINSTANCE;
      this.dToolFactory = ToolFactory.eINSTANCE;
      this.vToolFactory = org.eclipse.sirius.viewpoint.description.tool.ToolFactory.eINSTANCE;
      this.plSiriusSpec = this.vDescFactory.createGroup();
      this.path = workingPath + IPath.SEPARATOR + in.specModel.getName() + Out.SUFFIX + "." +
                  in.specModel.getFileExtension();
      this.mid = outputMIDsByName.get(Out.MODEL);
    }

    public Map<String, Model> packed() throws MMINTException, IOException {
      var plSpecModel = this.modelType.createInstanceAndEditor(this.plSiriusSpec,
                                                               FileUtils.getUniquePath(this.path, true, false),
                                                               this.mid);
      return Map.of(Out.MODEL, plSpecModel);
    }
  }

  private void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws MMINTException {
    this.in = new In(inputsByName);
    this.out = new Out(outputMIDsByName, getWorkingPath(), this.in);
  }

  private void toProductLine() throws Exception {

    var siriusSpec = (Group) this.in.specModel.getEMFInstanceRoot();
    this.out.plSiriusSpec.setName(siriusSpec.getName() + ".productline");

    var viewpoint = this.out.vDescFactory.createViewpoint();
    viewpoint.setName("StateMachineProductLineViewpoint");

    var diagramExtensionDescription = this.out.dDescFactory.createDiagramExtensionDescription();
    diagramExtensionDescription.setName("StateMachineProductLineDiagram");

    Map<String, DiagramElementMapping> map = new HashMap<>();

    for (var originalViewpoint : siriusSpec.getOwnedViewpoints()) {
      for (var representation : originalViewpoint.getOwnedRepresentations()) {
        var originalDiagram = (DiagramDescription) representation;

        // Handle default layer
        var defaultLayer = originalDiagram.getDefaultLayer();
        var newLayer = this.out.dDescFactory.createAdditionalLayer();
        newLayer.setName("State Machine Product Line");
        diagramExtensionDescription.getLayers().add(newLayer);

        // Node Mappings
        for (var originalNodeMapping : defaultLayer.getNodeMappings()) {
          var productLineNodeMapping = createProductLineNodeMapping(originalNodeMapping);
          newLayer.getNodeMappings().add(productLineNodeMapping);
          map.put(originalNodeMapping.getName(), productLineNodeMapping);
        }
        // Edge Mappings
        for (var originalEdgeMapping : defaultLayer.getEdgeMappings()) {
          var productLineEdgeMapping = createProductLineEdgeMapping(originalEdgeMapping, map);
          newLayer.getEdgeMappings().add(productLineEdgeMapping);
          map.put(originalEdgeMapping.getName(), productLineEdgeMapping);
        }
        // Container mappings
        for (var originalContainerMapping : defaultLayer.getContainerMappings()) {
          var productLineContainerMapping = createProductLineContainerMapping(originalContainerMapping);
          newLayer.getContainerMappings().add(productLineContainerMapping);
          map.put(originalContainerMapping.getName(), productLineContainerMapping);

          // Sub-Node Mappings
          for (var originalSubNodeMapping : originalContainerMapping.getSubNodeMappings()) {
            var productLineSubNodeMapping = createProductLineNodeMapping(originalSubNodeMapping);
            productLineContainerMapping.getSubNodeMappings().add(productLineSubNodeMapping);
            map.put(originalSubNodeMapping.getName(), productLineSubNodeMapping);
          }

        }
        // Creation Tools
        for (var section : defaultLayer.getToolSections()) {
          var newSection = this.out.dToolFactory.createToolSection();
          newSection.setName("CreateStateMachine");
          newSection.setLabel("Create State Machine");
          newLayer.getToolSections().add(newSection);

          for (var createTool : section.getOwnedTools()) {
            // Node Creation Tools
            if (createTool instanceof NodeCreationDescription) {
              var productLineCreateTool = createProductLineNodeCreationTool((NodeCreationDescription) createTool, map);
              newSection.getOwnedTools().add(productLineCreateTool);
            }
            // Edge Creation Tools
            if (createTool instanceof EdgeCreationDescription) {
              var productLineCreateTool = createProductLineEdgeCreationTool((EdgeCreationDescription) createTool, map);
              newSection.getOwnedTools().add(productLineCreateTool);
            }
            // Container Creation Tools
            if (createTool instanceof ContainerCreationDescription) {
              var productLineCreateTool = createProductLineContainerCreationTool((ContainerCreationDescription) createTool, map);
              newSection.getOwnedTools().add(productLineCreateTool);
            }
          }
        }
      }
    }

    viewpoint.getOwnedRepresentationExtensions().add(diagramExtensionDescription);
    this.out.plSiriusSpec.getOwnedViewpoints().add(viewpoint);
  }

  private NodeMapping createProductLineNodeMapping(NodeMapping originalNodeMapping) {
    var nodeMapping = this.out.dDescFactory.createNodeMapping();
    nodeMapping.setName("PL" + originalNodeMapping.getName());
    nodeMapping.setLabel("PL" + originalNodeMapping.getLabel());
    nodeMapping.setDomainClass("productline.class");
    nodeMapping.setSemanticCandidatesExpression("feature:classes");
    nodeMapping.setPreconditionExpression("aql: self.type.name = " + originalNodeMapping.getName());
    nodeMapping.setSynchronizationLock(originalNodeMapping.isSynchronizationLock());

    // Copy styles and update label expressions
    var newStyle = EcoreUtil.copy(originalNodeMapping.getStyle());
    nodeMapping.setStyle(newStyle);
    newStyle.setLabelExpression("service: getStateMachinePLElementLabel");

    return nodeMapping;
  }

  private EdgeMapping createProductLineEdgeMapping(EdgeMapping originalEdgeMapping, Map<String, DiagramElementMapping> map) {
    var edgeMapping = this.out.dDescFactory.createEdgeMapping();
    edgeMapping.setName("PL" + originalEdgeMapping.getName());
    edgeMapping.setLabel(originalEdgeMapping.getLabel());
    edgeMapping.setDomainClass("productline.class");
    edgeMapping.setSemanticCandidatesExpression("feature:classes");
    edgeMapping.setPreconditionExpression("aql: self.type.name = " + originalEdgeMapping.getName());
    edgeMapping.setSourceFinderExpression("aql: self.references->select(r | r.type.name = 'source')->collect(r | r.target)->union(self.referencesAsTarget->select(r | r.type.name = 'transitionsAsSource')->collect(r | r.eContainer()))");
    edgeMapping.setTargetFinderExpression("aql: self.references->select(r | r.type.name = 'target')->collect(r | r.target)->union(self.referencesAsTarget->select(r | r.type.name = 'transitionsAsTarget')->collect(r | r.eContainer()))");
    edgeMapping.setSynchronizationLock(originalEdgeMapping.isSynchronizationLock());
    for (var originalSourceMapping : originalEdgeMapping.getSourceMapping()) {
      var newSourceMapping = map.get(originalSourceMapping.getName());
      edgeMapping.getSourceMapping().add(newSourceMapping);
    }
    for (var originalTargetMapping : originalEdgeMapping.getTargetMapping()) {
      var newTargetMapping = map.get(originalTargetMapping.getName());
      edgeMapping.getTargetMapping().add(newTargetMapping);
    }

    // Copy styles and update label expressions
    var newStyle = EcoreUtil.copy(originalEdgeMapping.getStyle());
    edgeMapping.setStyle(newStyle);
    newStyle.getCenterLabelStyleDescription().setLabelExpression("service: getStateMachinePLElementLabel");

    return edgeMapping;
  }

  private ContainerMapping createProductLineContainerMapping(ContainerMapping originalContainerMapping) {
    var containerMapping = this.out.dDescFactory.createContainerMapping();
    containerMapping.setName("PL" + originalContainerMapping.getName());
    containerMapping.setLabel("PL" + originalContainerMapping.getLabel());
    containerMapping.setDomainClass("productline.class");
    containerMapping.setSemanticCandidatesExpression("feature:classes");
    containerMapping.setChildrenPresentation(originalContainerMapping.getChildrenPresentation());
    containerMapping.setPreconditionExpression("aql: self.type.name = " + originalContainerMapping.getName());
    containerMapping.setSynchronizationLock(originalContainerMapping.isSynchronizationLock());

    // Copy styles and update label expressions
    var newStyle = EcoreUtil.copy(originalContainerMapping.getStyle());
    containerMapping.setStyle(newStyle);
    newStyle.setLabelExpression("service: getStateMachinePLElementLabel");

    return containerMapping;
  }

  private NodeCreationDescription createProductLineNodeCreationTool(NodeCreationDescription originalCreateTool, Map<String, DiagramElementMapping> map) {
    var createTool = this.out.dToolFactory.createNodeCreationDescription();
    createTool.setName("PL" + originalCreateTool.getName());
    createTool.setLabel("PL" + originalCreateTool.getLabel());

    for (var originalMapping : originalCreateTool.getNodeMappings()) {
      var newMapping = (NodeMapping) map.get(originalMapping.getName());
      createTool.getNodeMappings().add(newMapping);
    }
    /*
     * QUESTION 1: How do I add these to the actual creation tool? Are these the right elements in the first
     * place?
     */
    var container = this.out.vToolFactory.createNameVariable();
    // or do we use createSelectContainerVariable()? or createElementVariable()?
    var containerView = this.out.vToolFactory.createContainerViewVariable();

    container.setName("container");
    containerView.setName("containerView");
    // createTool.setVariable(container);
    createTool.setViewVariable(containerView);

    /*
     * QUESTION 2: We didn't discuss this in the meeting but I'm assuming the initial operation does need
     * to be created before we can get it?
     *
     * EDIIT: I THINK THIS NOW MAKES SENSE. DON'T NEED TO CAST
     */
    var initialOperation = this.out.vToolFactory.createInitialNodeCreationOperation();
    createTool.setInitialOperation(initialOperation);

    var changeContext = this.out.vToolFactory.createChangeContext();
    changeContext.setBrowseExpression("var:container");
    createTool.getInitialOperation().setFirstModelOperations(changeContext);
    var javaAction = this.out.vToolFactory.createExternalJavaAction();
    javaAction.setName("PL"+originalCreateTool.getName());
    javaAction.setLabel("PL"+originalCreateTool.getName());
    javaAction.setId("edu.toronto.cs.se.mmint.types.statemachine.productline.design.tools.StateMachinePLCreateNode");
    var parameter = this.out.vToolFactory.createExternalJavaActionParameter();
    parameter.setName("classType");
    var value = originalCreateTool.getName().substring(6); //Removing Create (6 letters)
    parameter.setValue(value);
    javaAction.getParameters().add(parameter);
    changeContext.getSubModelOperations().add(javaAction);

    var newString = originalCreateTool.getLabel().replace(" ", "");
    createTool.setIconPath("/edu.toronto.cs.se.modelepedia.statemachine.edit/icons/full/obj16/"+newString+".gif");
    createTool.setForceRefresh(true);

    return createTool;
  }

  private EdgeCreationDescription createProductLineEdgeCreationTool(EdgeCreationDescription originalCreateTool, Map<String, DiagramElementMapping> map) {
    var createTool = this.out.dToolFactory.createEdgeCreationDescription();
    createTool.setName("PL" + originalCreateTool.getName());
    createTool.setLabel("PL" + originalCreateTool.getLabel());

    for (var originalMapping : originalCreateTool.getEdgeMappings()) {
      var newMapping = (EdgeMapping) map.get(originalMapping.getName());
      createTool.getEdgeMappings().add(newMapping);
    }
    /*
     * QUESTION 3:
     * Are source and target variables and source and target view variables the same type as above?
     * If not what are they?
     */
    var source = this.out.vToolFactory.createNameVariable();
    var sourceView = this.out.vToolFactory.createContainerViewVariable();
    var target = this.out.vToolFactory.createNameVariable();
    var targetView = this.out.vToolFactory.createContainerViewVariable();

    source.setName("source");
    sourceView.setName("sourceView");
    target.setName("target");
    targetView.setName("targetView");

    var initialOperation = this.out.vToolFactory.createInitEdgeCreationOperation();
    createTool.setInitialOperation(initialOperation);

    var changeContext = this.out.vToolFactory.createChangeContext();
    changeContext.setBrowseExpression("var:container");
    createTool.getInitialOperation().setFirstModelOperations(changeContext);
    var javaAction = this.out.vToolFactory.createExternalJavaAction();
    javaAction.setName("PL"+originalCreateTool.getName());
    javaAction.setLabel("PL"+originalCreateTool.getName());
    javaAction.setId("edu.toronto.cs.se.mmint.types.statemachine.productline.design.tools.StateMachinePLCreateEdge");
    var parameterSource = this.out.vToolFactory.createExternalJavaActionParameter();
    var parameterTarget = this.out.vToolFactory.createExternalJavaActionParameter();
    var parameter = this.out.vToolFactory.createExternalJavaActionParameter();
    parameter.setName("classType");
    var value = originalCreateTool.getName().substring(6); //Removing Create (6 letters)
    parameter.setValue(value);
    parameterSource.setName("source");
    parameterSource.setValue("var:source");
    parameterTarget.setName("target");
    parameterTarget.setValue("var:target");
    javaAction.getParameters().add(parameter);
    javaAction.getParameters().add(parameterSource);
    javaAction.getParameters().add(parameterTarget);
    changeContext.getSubModelOperations().add(javaAction);

    var newString = originalCreateTool.getLabel().replace(" ", "");
    createTool.setIconPath("/edu.toronto.cs.se.modelepedia.statemachine.edit/icons/full/obj16/"+newString+".gif");

    createTool.setForceRefresh(true);
    return createTool;
  }

  private ContainerCreationDescription createProductLineContainerCreationTool(ContainerCreationDescription originalCreateTool, Map<String, DiagramElementMapping> map) {
    var createTool = this.out.dToolFactory.createContainerCreationDescription();
    createTool.setName("PL" + originalCreateTool.getName());
    createTool.setLabel("PL" + originalCreateTool.getLabel());

    for (var originalMapping : originalCreateTool.getContainerMappings()) {
      var newMapping = (ContainerMapping) map.get(originalMapping.getName());
      createTool.getContainerMappings().add(newMapping);
    }

    var container = this.out.vToolFactory.createNameVariable();
    var containerView = this.out.vToolFactory.createContainerViewVariable();
    container.setName("container");
    containerView.setName("containerView");

    var initialOperation = this.out.vToolFactory.createInitialNodeCreationOperation();
    createTool.setInitialOperation(initialOperation);

    var changeContext = this.out.vToolFactory.createChangeContext();
    changeContext.setBrowseExpression("var:container");
    createTool.getInitialOperation().setFirstModelOperations(changeContext);
    var javaAction = this.out.vToolFactory.createExternalJavaAction();
    javaAction.setName("PL"+originalCreateTool.getName());
    javaAction.setLabel("PL"+originalCreateTool.getName());
    javaAction.setId("edu.toronto.cs.se.mmint.types.statemachine.productline.design.tools.StateMachinePLCreateNode");
    var parameter = this.out.vToolFactory.createExternalJavaActionParameter();
    parameter.setName("classType");
    var value = originalCreateTool.getName().substring(6); //Removing Create (6 letters)
    parameter.setValue(value);
    javaAction.getParameters().add(parameter);
    changeContext.getSubModelOperations().add(javaAction);

    var newString = originalCreateTool.getLabel().replace(" ", "");
    createTool.setIconPath("/edu.toronto.cs.se.modelepedia.statemachine.edit/icons/full/obj16/"+newString+".gif");
    createTool.setForceRefresh(true);

    return createTool;
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    init(inputsByName, outputMIDsByName);
    toProductLine();
    return this.out.packed();
  }
}

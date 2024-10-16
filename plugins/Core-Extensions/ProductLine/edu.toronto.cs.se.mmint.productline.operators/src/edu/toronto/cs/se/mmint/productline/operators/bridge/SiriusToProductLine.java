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
package edu.toronto.cs.se.mmint.productline.operators.bridge;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.diagram.description.ContainerMapping;
import org.eclipse.sirius.diagram.description.DescriptionFactory;
import org.eclipse.sirius.diagram.description.DiagramDescription;
import org.eclipse.sirius.diagram.description.DiagramElementMapping;
import org.eclipse.sirius.diagram.description.EdgeMapping;
import org.eclipse.sirius.diagram.description.NodeMapping;
import org.eclipse.sirius.diagram.description.style.StyleFactory;
import org.eclipse.sirius.diagram.description.tool.ContainerCreationDescription;
import org.eclipse.sirius.diagram.description.tool.EdgeCreationDescription;
import org.eclipse.sirius.diagram.description.tool.NodeCreationDescription;
import org.eclipse.sirius.diagram.description.tool.ToolFactory;
import org.eclipse.sirius.viewpoint.description.Group;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;

public class SiriusToProductLine extends OperatorImpl {
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
    public static final String ID_PREFIX = "PL";
    public static final String LABEL_PREFIX = "Product Line ";
    public static final String SUFFIX = "_pl";
    public Model modelType;
    public Group plSiriusSpec;
    public DescriptionFactory dDescFactory;
    public ToolFactory dToolFactory;
    public StyleFactory dStyleFactory;
    public org.eclipse.sirius.viewpoint.description.DescriptionFactory vDescFactory;
    public org.eclipse.sirius.viewpoint.description.tool.ToolFactory vToolFactory;
    public String path;
    public MID mid;

    public Out(Map<String, MID> outputMIDsByName, String workingPath, In in) throws MMINTException {
      this.modelType = in.specModel.getMetatype();
      this.dDescFactory = DescriptionFactory.eINSTANCE;
      this.dToolFactory = ToolFactory.eINSTANCE;
      this.dStyleFactory = StyleFactory.eINSTANCE;
      this.vDescFactory = org.eclipse.sirius.viewpoint.description.DescriptionFactory.eINSTANCE;
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
    var mappings = new HashMap<String, DiagramElementMapping>();
    // .odesign root
    var siriusSpec = (Group) this.in.specModel.getEMFInstanceRoot();
    this.out.plSiriusSpec.setName(siriusSpec.getName() + ".productline");
    // viewpoints
    for (var viewpoint : siriusSpec.getOwnedViewpoints()) {
      var plViewpoint = this.out.vDescFactory.createViewpoint();
      plViewpoint.setName(Out.ID_PREFIX + viewpoint.getName());
      plViewpoint.setLabel(Out.LABEL_PREFIX + viewpoint.getLabel());
      this.out.plSiriusSpec.getOwnedViewpoints().add(plViewpoint);
      // representations
      for (var representation : viewpoint.getOwnedRepresentations()) {
        if (!(representation instanceof DiagramDescription diagram)) {
          continue;
        }
        // diagram extension
        var plDiagramExt = this.out.dDescFactory.createDiagramExtensionDescription();
        plDiagramExt.setName(Out.ID_PREFIX + representation.getName());
        plDiagramExt.setViewpointURI("viewpoint:/edu.toronto.cs.se.mmint.productline.design/ProductLineViewpoint");
        plDiagramExt.setRepresentationName("ProductLineDiagram");
        plViewpoint.getOwnedRepresentationExtensions().add(plDiagramExt);
        // default layer
        var layer = diagram.getDefaultLayer();
        var plLayer = this.out.dDescFactory.createAdditionalLayer();
        plLayer.setName(Out.ID_PREFIX + layer.getName());
        plLayer.setLabel(Out.LABEL_PREFIX + layer.getLabel());
        plDiagramExt.getLayers().add(plLayer);
        // node mappings
        for (var nodeMapping : layer.getNodeMappings()) {
          var plNodeMapping = createPLNodeMapping(nodeMapping);
          plLayer.getNodeMappings().add(plNodeMapping);
          mappings.put(nodeMapping.getName(), plNodeMapping);
        }
        // edge mappings
        for (var edgeMapping : layer.getEdgeMappings()) {
          var plEdgeMapping = createPLEdgeMapping(edgeMapping, mappings);
          plLayer.getEdgeMappings().add(plEdgeMapping);
          mappings.put(edgeMapping.getName(), plEdgeMapping);
        }
        // container mappings
        for (var containerMapping : layer.getContainerMappings()) {
          var plContainerMapping = createPLContainerMapping(containerMapping);
          plLayer.getContainerMappings().add(plContainerMapping);
          mappings.put(containerMapping.getName(), plContainerMapping);
          // subnode Mappings
          for (var subnodeMapping : containerMapping.getSubNodeMappings()) {
            var plSubnodeMapping = createPLNodeMapping(subnodeMapping);
            plContainerMapping.getSubNodeMappings().add(plSubnodeMapping);
            mappings.put(subnodeMapping.getName(), plSubnodeMapping);
          }
        }
        // tool sections
        for (var section : layer.getToolSections()) {
          var plSection = this.out.dToolFactory.createToolSection();
          plSection.setName("CreateStateMachine");
          plSection.setLabel("Create State Machine");
          plLayer.getToolSections().add(plSection);
          // creation tools
          for (var tool : section.getOwnedTools()) {
            // nodes
            if (tool instanceof NodeCreationDescription nodeTool) {
              var plTool = createPLNodeCreationTool(nodeTool, mappings);
              plSection.getOwnedTools().add(plTool);
            }
            // edges
            if (tool instanceof EdgeCreationDescription edgeTool) {
              var plTool = createPLEdgeCreationTool(edgeTool, mappings);
              plSection.getOwnedTools().add(plTool);
            }
            // containers
            if (tool instanceof ContainerCreationDescription containerTool) {
              var plTool = createPLContainerCreationTool(containerTool, mappings);
              plSection.getOwnedTools().add(plTool);
            }
          }
        }
      }
    }
  }

  private NodeMapping createPLNodeMapping(NodeMapping nodeMapping) {
    var domainClass = nodeMapping.getDomainClass();
    var classType = domainClass.substring(domainClass.lastIndexOf(".") + 1);
    var plNodeMapping = this.out.dDescFactory.createNodeMapping();
    plNodeMapping.setName(Out.ID_PREFIX + nodeMapping.getName());
    plNodeMapping.setLabel(nodeMapping.getLabel());
    plNodeMapping.setDomainClass("productline.Class");
    plNodeMapping.setSemanticCandidatesExpression("feature:classes");
    plNodeMapping.setLabelDirectEdit(null);
    plNodeMapping.setPreconditionExpression("aql: self.type.name = " + classType);
    var plStyle = EcoreUtil.copy(nodeMapping.getStyle());
    plStyle.setLabelExpression("service: getPLStateMachineElementLabel"); //TODO
    plNodeMapping.setStyle(plStyle);

    return plNodeMapping;
  }

  private EdgeMapping createPLEdgeMapping(EdgeMapping edgeMapping, Map<String, DiagramElementMapping> mappings) {
    var plEdgeMapping = this.out.dDescFactory.createEdgeMapping();
    plEdgeMapping.setName("PL" + edgeMapping.getName());
    plEdgeMapping.setLabel(edgeMapping.getLabel());
    plEdgeMapping.setDomainClass("productline.class");
    plEdgeMapping.setSemanticCandidatesExpression("feature:classes");
    plEdgeMapping.setPreconditionExpression("aql: self.type.name = " + edgeMapping.getName());
    plEdgeMapping.setSourceFinderExpression("aql: self.references->select(r | r.type.name = 'source')->collect(r | r.target)->union(self.referencesAsTarget->select(r | r.type.name = 'transitionsAsSource')->collect(r | r.eContainer()))");
    plEdgeMapping.setTargetFinderExpression("aql: self.references->select(r | r.type.name = 'target')->collect(r | r.target)->union(self.referencesAsTarget->select(r | r.type.name = 'transitionsAsTarget')->collect(r | r.eContainer()))");
    plEdgeMapping.setSynchronizationLock(edgeMapping.isSynchronizationLock());
    for (var srcMapping : edgeMapping.getSourceMapping()) {
      var plSrcMapping = mappings.get(srcMapping.getName());
      plEdgeMapping.getSourceMapping().add(plSrcMapping);
    }
    for (var tgtMapping : edgeMapping.getTargetMapping()) {
      var plTgtMapping = mappings.get(tgtMapping.getName());
      plEdgeMapping.getTargetMapping().add(plTgtMapping);
    }
    // Copy styles and update label expressions
    var plStyle = EcoreUtil.copy(edgeMapping.getStyle());
    plEdgeMapping.setStyle(plStyle);
    plStyle.getCenterLabelStyleDescription().setLabelExpression("service: getStateMachinePLElementLabel");

    return plEdgeMapping;
  }

  private ContainerMapping createPLContainerMapping(ContainerMapping containerMapping) {
    var plContainerMapping = this.out.dDescFactory.createContainerMapping();
    plContainerMapping.setName("PL" + containerMapping.getName());
    plContainerMapping.setLabel("PL" + containerMapping.getLabel());
    plContainerMapping.setDomainClass("productline.class");
    plContainerMapping.setSemanticCandidatesExpression("feature:classes");
    plContainerMapping.setChildrenPresentation(containerMapping.getChildrenPresentation());
    plContainerMapping.setPreconditionExpression("aql: self.type.name = " + containerMapping.getName());
    plContainerMapping.setSynchronizationLock(containerMapping.isSynchronizationLock());
    // Copy styles and update label expressions
    var plStyle = EcoreUtil.copy(containerMapping.getStyle());
    plContainerMapping.setStyle(plStyle);
    plStyle.setLabelExpression("service: getStateMachinePLElementLabel");

    return plContainerMapping;
  }

  private NodeCreationDescription createPLNodeCreationTool(NodeCreationDescription originalCreateTool, Map<String, DiagramElementMapping> map) {
    var createTool = this.out.dToolFactory.createNodeCreationDescription();
    createTool.setName("PL" + originalCreateTool.getName());
    createTool.setLabel("PL" + originalCreateTool.getLabel());
    createTool.setVariable(null);

    for (var originalMapping : originalCreateTool.getNodeMappings()) {
      var newMapping = (NodeMapping) map.get(originalMapping.getName());
      createTool.getNodeMappings().add(newMapping);
    }
    var container = this.out.dToolFactory.createNodeCreationVariable();
    var containerView = this.out.vToolFactory.createContainerViewVariable();

    container.setName("container");
    containerView.setName("containerView");
    createTool.setVariable(container);
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

  private EdgeCreationDescription createPLEdgeCreationTool(EdgeCreationDescription originalCreateTool, Map<String, DiagramElementMapping> map) {
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

  private ContainerCreationDescription createPLContainerCreationTool(ContainerCreationDescription originalCreateTool, Map<String, DiagramElementMapping> map) {
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

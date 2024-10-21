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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.sirius.diagram.description.AbstractNodeMapping;
import org.eclipse.sirius.diagram.description.ContainerMapping;
import org.eclipse.sirius.diagram.description.DescriptionFactory;
import org.eclipse.sirius.diagram.description.DiagramDescription;
import org.eclipse.sirius.diagram.description.DiagramElementMapping;
import org.eclipse.sirius.diagram.description.EdgeMapping;
import org.eclipse.sirius.diagram.description.NodeMapping;
import org.eclipse.sirius.diagram.description.style.StyleFactory;
import org.eclipse.sirius.diagram.description.tool.ContainerCreationDescription;
import org.eclipse.sirius.diagram.description.tool.DirectEditLabel;
import org.eclipse.sirius.diagram.description.tool.EdgeCreationDescription;
import org.eclipse.sirius.diagram.description.tool.NodeCreationDescription;
import org.eclipse.sirius.diagram.description.tool.ToolFactory;
import org.eclipse.sirius.viewpoint.description.Group;
import org.eclipse.sirius.viewpoint.description.IdentifiedElement;
import org.eclipse.sirius.viewpoint.description.style.BasicLabelStyleDescription;
import org.eclipse.sirius.viewpoint.description.tool.ChangeContext;
import org.eclipse.sirius.viewpoint.description.tool.CreateInstance;
import org.eclipse.sirius.viewpoint.description.tool.InitialNodeCreationOperation;
import org.eclipse.sirius.viewpoint.description.tool.ModelOperation;

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.editor.Diagram;
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
    public static final String SUFFIX = ".productline";
    public Model modelType;
    public Group plBaseSpec;
    public DirectEditLabel plLabel;
    public Group plSpec;
    public DescriptionFactory dDescFactory;
    public ToolFactory dToolFactory;
    public StyleFactory dStyleFactory;
    public org.eclipse.sirius.viewpoint.description.DescriptionFactory vDescFactory;
    public org.eclipse.sirius.viewpoint.description.tool.ToolFactory vToolFactory;
    public String path;
    public MID mid;

    public Out(Map<String, MID> outputMIDsByName, String workingPath, In in) throws Exception {
      this.modelType = in.specModel.getMetatype();
      this.dDescFactory = DescriptionFactory.eINSTANCE;
      this.dToolFactory = ToolFactory.eINSTANCE;
      this.dStyleFactory = StyleFactory.eINSTANCE;
      this.vDescFactory = org.eclipse.sirius.viewpoint.description.DescriptionFactory.eINSTANCE;
      this.vToolFactory = org.eclipse.sirius.viewpoint.description.tool.ToolFactory.eINSTANCE;
      var plBaseDiagram = MIDTypeRegistry.<Diagram>getType("edu.toronto.cs.se.mmint.productline.design");
      var plBaseSpecPath = MIDTypeRegistry.getBundlePath(plBaseDiagram, "description" + IPath.SEPARATOR +
                                                                        "productline.odesign");
      this.plBaseSpec = (Group) FileUtils.readModelFile(plBaseSpecPath, null, false);
      this.plLabel = (DirectEditLabel)
        ((DiagramDescription) this.plBaseSpec.getOwnedViewpoints().get(0).getOwnedRepresentations().get(0))
          .getDefaultLayer().getToolSections().get(0).getOwnedTools().get(3);
      this.plSpec = this.vDescFactory.createGroup();
      this.path = workingPath + IPath.SEPARATOR + in.specModel.getName() + Out.SUFFIX + "." +
                  in.specModel.getFileExtension();
      this.mid = outputMIDsByName.get(Out.MODEL);
    }

    public Map<String, Model> packed() throws MMINTException, IOException {
      var plSpecModel = this.modelType.createInstanceAndEditor(this.plSpec,
                                                               FileUtils.getUniquePath(this.path, true, false),
                                                               this.mid);
      return Map.of(Out.MODEL, plSpecModel);
    }
  }

  private void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws Exception {
    this.in = new In(inputsByName);
    this.out = new Out(outputMIDsByName, getWorkingPath(), this.in);
  }

  private void toProductLine() throws Exception {
    var plMappings = new HashMap<String, DiagramElementMapping>();
    // .odesign root
    var spec = (Group) this.in.specModel.getEMFInstanceRoot();
    this.out.plSpec.setName(spec.getName() + ".productline");
    // viewpoints
    for (var viewpoint : spec.getOwnedViewpoints()) {
      var plViewpoint = this.out.vDescFactory.createViewpoint();
      addPLIdentifiedElement(viewpoint, plViewpoint, Out.LABEL_PREFIX);
      this.out.plSpec.getOwnedViewpoints().add(plViewpoint);
      // representations
      for (var representation : viewpoint.getOwnedRepresentations()) {
        if (!(representation instanceof DiagramDescription diagram)) {
          continue;
        }
        // diagram extension
        var plDiagramExt = this.out.dDescFactory.createDiagramExtensionDescription();
        plDiagramExt.setName(Out.ID_PREFIX +
          ((representation.getLabel() == null) ? representation.getName() : representation.getLabel()));
        plDiagramExt.setViewpointURI("viewpoint:/edu.toronto.cs.se.mmint.productline.design/ProductLineViewpoint");
        plDiagramExt.setRepresentationName("ProductLineDiagram");
        plViewpoint.getOwnedRepresentationExtensions().add(plDiagramExt);
        // default layer
        var layer = diagram.getDefaultLayer();
        var plLayer = this.out.dDescFactory.createAdditionalLayer();
        addPLIdentifiedElement(layer, plLayer, Out.LABEL_PREFIX);
        plDiagramExt.getLayers().add(plLayer);
        // node mappings
        for (var nodeMapping : layer.getNodeMappings()) {
          var plNodeMapping = createPLNodeMapping(nodeMapping);
          plLayer.getNodeMappings().add(plNodeMapping);
          plMappings.put(nodeMapping.getName(), plNodeMapping);
        }
        // container mappings
        for (var containerMapping : layer.getContainerMappings()) {
          var plContainerMapping = createPLContainerMapping(containerMapping);
          plLayer.getContainerMappings().add(plContainerMapping);
          plMappings.put(containerMapping.getName(), plContainerMapping);
          // subnode Mappings
          for (var subnodeMapping : containerMapping.getSubNodeMappings()) {
            var plSubnodeMapping = createPLSubnodeMapping(subnodeMapping);
            plContainerMapping.getSubNodeMappings().add(plSubnodeMapping);
            plMappings.put(subnodeMapping.getName(), plSubnodeMapping);
          }
        }
        // edge mappings
        for (var edgeMapping : layer.getEdgeMappings()) {
          var plEdgeMapping = createPLEdgeMapping(edgeMapping, plMappings);
          plLayer.getEdgeMappings().add(plEdgeMapping);
          plMappings.put(edgeMapping.getName(), plEdgeMapping);
        }
        // tool sections
        for (var section : layer.getToolSections()) {
          var plSection = this.out.dToolFactory.createToolSection();
          addPLIdentifiedElement(section, plSection, null);
          plLayer.getToolSections().add(plSection);
          for (var tool : section.getOwnedTools()) {
            // node creation
            if (tool instanceof NodeCreationDescription nodeTool) {
              var plTool = createPLNodeCreationTool(nodeTool, plMappings);
              plSection.getOwnedTools().add(plTool);
            }
            // container creation
            if (tool instanceof ContainerCreationDescription containerTool) {
              var plTool = createPLContainerCreationTool(containerTool, plMappings);
              plSection.getOwnedTools().add(plTool);
            }
//            // edge creation
//            if (tool instanceof EdgeCreationDescription edgeTool) {
//              var plTool = createPLEdgeCreationTool(edgeTool, plMappings);
//              plSection.getOwnedTools().add(plTool);
//            }
          }
        }
      }
    }
  }

  private String getClassType(String domainClass) {
    var i = domainClass.lastIndexOf(".");
    return (i < 0) ? domainClass : domainClass.substring(i+1);
  }

  private void addPLIdentifiedElement(IdentifiedElement elem, IdentifiedElement plElem, @Nullable String labelPrefix) {
    plElem.setName(Out.ID_PREFIX + elem.getName());
    if (elem.getLabel() != null) {
      var plLabel = elem.getLabel();
      if (labelPrefix != null) {
        plLabel = labelPrefix + plLabel;
      }
      plElem.setLabel(plLabel);
    }
  }

  private void addPLDiagramMapping(DiagramElementMapping diagMapping, DiagramElementMapping plDiagMapping,
                                   String classType) {
    addPLIdentifiedElement(diagMapping, plDiagMapping, null);
    plDiagMapping.setSemanticCandidatesExpression("feature:classes");
    plDiagMapping.setLabelDirectEdit(this.out.plLabel);
    plDiagMapping.setPreconditionExpression("aql: self.type.name = '" + classType + "'");
  }

  private void addPLNodeMapping(AbstractNodeMapping nodeMapping, AbstractNodeMapping plNodeMapping) {
    plNodeMapping.setDomainClass("productline.Class");
    addPLDiagramMapping(nodeMapping, plNodeMapping, getClassType(nodeMapping.getDomainClass()));
  }

  private void addPLStyleExpression(BasicLabelStyleDescription plStyle) {
    plStyle.setLabelExpression("service: getPLStateMachineElementLabel"); //TODO settle on a name
  }

  private NodeMapping createPLNodeMapping(NodeMapping nodeMapping) {
    var plNodeMapping = this.out.dDescFactory.createNodeMapping();
    addPLNodeMapping(nodeMapping, plNodeMapping);
    var plStyle = EcoreUtil.copy(nodeMapping.getStyle());
    addPLStyleExpression(plStyle);
    plNodeMapping.setStyle(plStyle);

    return plNodeMapping;
  }

  private ContainerMapping createPLContainerMapping(ContainerMapping containerMapping) {
    var plContainerMapping = this.out.dDescFactory.createContainerMapping();
    addPLNodeMapping(containerMapping, plContainerMapping);
    plContainerMapping.setChildrenPresentation(containerMapping.getChildrenPresentation());
    var plStyle = EcoreUtil.copy(containerMapping.getStyle());
    addPLStyleExpression(plStyle);
    plContainerMapping.setStyle(plStyle);

    return plContainerMapping;
  }

  private NodeMapping createPLSubnodeMapping(NodeMapping subnodeMapping) {
    var plSubnodeMapping = createPLNodeMapping(subnodeMapping);
    plSubnodeMapping.setSemanticCandidatesExpression("aql: self.eContainer(productline::ProductLine).classes");
    plSubnodeMapping.setPreconditionExpression(plSubnodeMapping.getPreconditionExpression() +
      " and self.referencesAsTarget.eContainer(productline::Class)->includes(container)");

    return plSubnodeMapping;
  }

  private EdgeMapping createPLEdgeMapping(EdgeMapping edgeMapping, Map<String, DiagramElementMapping> plMappings) {
    var plEdgeMapping = this.out.dDescFactory.createEdgeMapping();
    addPLDiagramMapping(edgeMapping, plEdgeMapping, getClassType(edgeMapping.getDomainClass()));
    plEdgeMapping.setDomainClass("productline.Class");
    plEdgeMapping.setUseDomainElement(edgeMapping.isUseDomainElement());
    for (var srcMapping : edgeMapping.getSourceMapping()) {
      plEdgeMapping.getSourceMapping().add(plMappings.get(srcMapping.getName()));
    }
    plEdgeMapping.setSourceFinderExpression("aql: self.references->select(r | r.type.name = 'source')->collect(r | r.target)->union(self.referencesAsTarget->select(r | r.type.name = 'transitionsAsSource')->collect(r | r.eContainer()))");
    for (var tgtMapping : edgeMapping.getTargetMapping()) {
      plEdgeMapping.getTargetMapping().add(plMappings.get(tgtMapping.getName()));
    }
    plEdgeMapping.setTargetFinderExpression("aql: self.references->select(r | r.type.name = 'target')->collect(r | r.target)->union(self.referencesAsTarget->select(r | r.type.name = 'transitionsAsTarget')->collect(r | r.eContainer()))");
    var plStyle = EcoreUtil.copy(edgeMapping.getStyle());
    plEdgeMapping.setStyle(plStyle);
    var plBeginLabel = plStyle.getBeginLabelStyleDescription();
    if (plBeginLabel != null) {
      addPLStyleExpression(plBeginLabel);
    }
    var plCenterLabel = plStyle.getCenterLabelStyleDescription();
    if (plCenterLabel != null) {
      addPLStyleExpression(plCenterLabel);
    }
    var plEndLabel = plStyle.getEndLabelStyleDescription();
    if (plEndLabel != null) {
      addPLStyleExpression(plEndLabel);
    }

    return plEdgeMapping;
  }

  private record PLCreateOp(InitialNodeCreationOperation op, @Nullable String classType) {};
  private PLCreateOp addPLCreateOp(ModelOperation firstOp) {
    var plInitialOp = this.out.vToolFactory.createInitialNodeCreationOperation();
    var plChangeOp = this.out.vToolFactory.createChangeContext();
    plChangeOp.setBrowseExpression("var:container");
    plInitialOp.setFirstModelOperations(plChangeOp);
    String classType = null;
    if (firstOp instanceof CreateInstance creationOp) {
      classType = getClassType(creationOp.getTypeName());
    }
    else if (firstOp instanceof ChangeContext changeOp) {
      for (var subOp : changeOp.getSubModelOperations()) {
        if (subOp instanceof CreateInstance creationOp) {
          classType = getClassType(creationOp.getTypeName());
          break;
        }
      }
    }
    if (classType != null) {
      var plJavaOp = this.out.vToolFactory.createExternalJavaAction();
      plJavaOp.setName(Out.ID_PREFIX + "Create" + classType);
      plJavaOp.setId("edu.toronto.cs.se.mmint.types.statemachine.productline.design.tools.PLStateMachineCreateNode"); //TODO
      var plParam = this.out.vToolFactory.createExternalJavaActionParameter();
      plParam.setName("classType");
      plParam.setValue(classType);
      plJavaOp.getParameters().add(plParam);
      plChangeOp.getSubModelOperations().add(plJavaOp);
    }

    return new PLCreateOp(plInitialOp, classType);
  }

  private NodeCreationDescription createPLNodeCreationTool(NodeCreationDescription nodeTool,
                                                           Map<String, DiagramElementMapping> plMappings) {
    var plNodeTool = this.out.dToolFactory.createNodeCreationDescription();
    addPLIdentifiedElement(nodeTool, plNodeTool, null);
    if (nodeTool.getIconPath() != null) {
      plNodeTool.setIconPath(nodeTool.getIconPath());
    }
    for (var nodeMapping : nodeTool.getNodeMappings()) {
      plNodeTool.getNodeMappings().add((NodeMapping) plMappings.get(nodeMapping.getName()));
    }
    // tool vars
    var toolVar = nodeTool.getVariable();
    if (toolVar != null) {
      var plToolVar = this.out.dToolFactory.createNodeCreationVariable();
      plToolVar.setName(toolVar.getName());
      plNodeTool.setVariable(plToolVar);
    }
    var toolViewVar = nodeTool.getViewVariable();
    if (toolViewVar != null) {
      var plToolViewVar = this.out.vToolFactory.createContainerViewVariable();
      plToolViewVar.setName(toolViewVar.getName());
      plNodeTool.setViewVariable(plToolViewVar);
    }
    // tool ops
    var plCreateOp = addPLCreateOp(nodeTool.getInitialOperation().getFirstModelOperations());
    plNodeTool.setInitialOperation(plCreateOp.op());
    // tool icon
    if (nodeTool.getIconPath() != null) {
      plNodeTool.setIconPath(nodeTool.getIconPath());
    }
    else if (plCreateOp.classType() != null) {
      //TODO
      plNodeTool.setIconPath("/edu.toronto.cs.se.modelepedia.statemachine.edit/icons/full/obj16/" + plCreateOp.classType() + ".gif");
    }

    return plNodeTool;
  }

  private ContainerCreationDescription createPLContainerCreationTool(ContainerCreationDescription containerTool,
                                                                     Map<String, DiagramElementMapping> plMappings) {
    var plContainerTool = this.out.dToolFactory.createContainerCreationDescription();
    addPLIdentifiedElement(containerTool, plContainerTool, null);
    for (var containerMapping : containerTool.getContainerMappings()) {
      plContainerTool.getContainerMappings().add((ContainerMapping) plMappings.get(containerMapping.getName()));
    }
    // tool vars
    var toolVar = containerTool.getVariable();
    if (toolVar != null) {
      var plToolVar = this.out.dToolFactory.createNodeCreationVariable();
      plToolVar.setName(toolVar.getName());
      plContainerTool.setVariable(plToolVar);
    }
    var toolViewVar = containerTool.getViewVariable();
    if (toolViewVar != null) {
      var plToolViewVar = this.out.vToolFactory.createContainerViewVariable();
      plToolViewVar.setName(toolViewVar.getName());
      plContainerTool.setViewVariable(plToolViewVar);
    }
    // tool ops
    var plCreateOp = addPLCreateOp(containerTool.getInitialOperation().getFirstModelOperations());
    plContainerTool.setInitialOperation(plCreateOp.op());
    // tool icon
    if (containerTool.getIconPath() != null) {
      plContainerTool.setIconPath(containerTool.getIconPath());
    }
    else if (plCreateOp.classType() != null) {
      //TODO
      plContainerTool.setIconPath("/edu.toronto.cs.se.modelepedia.statemachine.edit/icons/full/obj16/" + plCreateOp.classType() + ".gif");
    }

    return plContainerTool;
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

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    init(inputsByName, outputMIDsByName);
    toProductLine();
    return this.out.packed();
  }
}

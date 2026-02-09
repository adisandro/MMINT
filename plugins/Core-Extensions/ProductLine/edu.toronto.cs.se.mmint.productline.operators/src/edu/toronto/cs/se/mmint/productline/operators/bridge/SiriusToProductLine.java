/*******************************************************************************
 * Copyright (c) 2024, 2026 Alessio Di Sandro.
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

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
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
import org.eclipse.sirius.diagram.description.tool.DeleteElementDescription;
import org.eclipse.sirius.diagram.description.tool.DirectEditLabel;
import org.eclipse.sirius.diagram.description.tool.EdgeCreationDescription;
import org.eclipse.sirius.diagram.description.tool.NodeCreationDescription;
import org.eclipse.sirius.diagram.description.tool.ToolFactory;
import org.eclipse.sirius.viewpoint.description.Group;
import org.eclipse.sirius.viewpoint.description.IdentifiedElement;
import org.eclipse.sirius.viewpoint.description.style.BasicLabelStyleDescription;
import org.eclipse.sirius.viewpoint.description.tool.ChangeContext;
import org.eclipse.sirius.viewpoint.description.tool.CreateInstance;
import org.eclipse.sirius.viewpoint.description.tool.ExternalJavaAction;
import org.eclipse.sirius.viewpoint.description.tool.ModelOperation;
import org.eclipse.sirius.viewpoint.description.tool.SetValue;

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.OperatorParameter;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.editor.Diagram;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;

public class SiriusToProductLine extends OperatorImpl {
  public final static OperatorParameter IN0 = new OperatorParameter("siriusSpec",
                                                                    "http://www.eclipse.org/sirius/description/1.1.0");
  public Group in0;
  public final static OperatorParameter OUT0 = new OperatorParameter("plSiriusSpec",
                                                                     "http://www.eclipse.org/sirius/description/1.1.0",
                                                                     "odesign", ".productline");
  public Group out0;
  public final static String PROP_SERVICESJAVA = "servicesJava";
  public final static String PROP_SERVICESJAVA_DEFAULT = "edu.toronto.cs.se.mmint.productline.design.PLServices";
  protected String servicesJava;
  public final static String PROP_NODESJAVA = "nodesJava";
  public final static String PROP_NODESJAVA_DEFAULT = "edu.toronto.cs.se.mmint.productline.design.tools.CreateNode";
  protected String nodesJava;
  public final static String PROP_EDGESJAVA = "edgesJava";
  public final static String PROP_EDGESJAVA_DEFAULT = "edu.toronto.cs.se.mmint.productline.design.tools.CreateEdge";
  protected String edgesJava;
  public final static String ID_PREFIX = "PL";
  public final static String LABEL_PREFIX = "Product Line ";
  protected DeleteElementDescription plDelete;
  protected DirectEditLabel plLabel;
  protected DescriptionFactory dDescFactory;
  protected ToolFactory dToolFactory;
  protected StyleFactory dStyleFactory;
  protected org.eclipse.sirius.viewpoint.description.DescriptionFactory vDescFactory;
  protected org.eclipse.sirius.viewpoint.description.tool.ToolFactory vToolFactory;

  @Override
  public void init(Properties inputProperties, Map<String, Model> inputsByName) throws Exception {
    this.servicesJava = MIDOperatorIOUtils.getStringProp(inputProperties, SiriusToProductLine.PROP_SERVICESJAVA,
                                                         Optional.of(SiriusToProductLine.PROP_SERVICESJAVA_DEFAULT));
    this.nodesJava = MIDOperatorIOUtils.getStringProp(inputProperties, SiriusToProductLine.PROP_NODESJAVA,
                                                      Optional.of(SiriusToProductLine.PROP_NODESJAVA_DEFAULT));
    this.edgesJava = MIDOperatorIOUtils.getStringProp(inputProperties, SiriusToProductLine.PROP_EDGESJAVA,
                                                      Optional.of(SiriusToProductLine.PROP_EDGESJAVA_DEFAULT));
    var specModel = inputsByName.get(SiriusToProductLine.IN0.name());
    this.in0 = (Group) specModel.getEMFInstanceRoot();
    var plBaseDiagram = MIDTypeRegistry.<Diagram>getType("edu.toronto.cs.se.mmint.productline.design");
    var plBaseSpecPath = MIDTypeRegistry.getBundlePath(plBaseDiagram, "description" + IPath.SEPARATOR +
                                                                      "productline.odesign");
    var plBaseSpec = (Group) FileUtils.readModelFile(plBaseSpecPath, null, false);
    var plTools = ((DiagramDescription) plBaseSpec.getOwnedViewpoints().get(0).getOwnedRepresentations().get(0))
      .getDefaultLayer().getToolSections().get(0).getOwnedTools();
    this.plLabel = (DirectEditLabel) plTools.get(3);
    this.plDelete = (DeleteElementDescription) plTools.get(4);
    this.dDescFactory = DescriptionFactory.eINSTANCE;
    this.dToolFactory = ToolFactory.eINSTANCE;
    this.dStyleFactory = StyleFactory.eINSTANCE;
    this.vDescFactory = org.eclipse.sirius.viewpoint.description.DescriptionFactory.eINSTANCE;
    this.vToolFactory = org.eclipse.sirius.viewpoint.description.tool.ToolFactory.eINSTANCE;
    this.out0 = this.vDescFactory.createGroup();
  }

  private void toProductLine() throws Exception {
    var plMappings = new HashMap<String, DiagramElementMapping>();
    this.out0.setName(this.in0.getName() + ".productline");
    // viewpoints
    for (var viewpoint : this.in0.getOwnedViewpoints()) {
      var plViewpoint = this.vDescFactory.createViewpoint();
      addPLIdentifiedElement(viewpoint, plViewpoint, SiriusToProductLine.LABEL_PREFIX);
      plViewpoint.setModelFileExtension("productline");
      this.out0.getOwnedViewpoints().add(plViewpoint);
      var plJavaExt = this.vDescFactory.createJavaExtension();
      plJavaExt.setQualifiedClassName(this.servicesJava);
      plViewpoint.getOwnedJavaExtensions().add(plJavaExt);
      // representations
      for (var representation : viewpoint.getOwnedRepresentations()) {
        if (!(representation instanceof DiagramDescription diagram)) {
          continue;
        }
        var modelType = MIDTypeRegistry.<Model>getType(diagram.getMetamodel().get(0).getNsURI());
        var modelTypeName = modelType.getName();
        var bundleName = IPath.SEPARATOR + MIDTypeRegistry.getTypeBundle(modelType.getUri()).getSymbolicName();
        // diagram extension
        var plDiagramExt = this.dDescFactory.createDiagramExtensionDescription();
        plDiagramExt.setName(SiriusToProductLine.ID_PREFIX +
          ((representation.getLabel() == null) ? representation.getName() : " " + representation.getLabel()));
        plDiagramExt.setViewpointURI("viewpoint:/edu.toronto.cs.se.mmint.productline.design/ProductLineViewpoint");
        plDiagramExt.setRepresentationName("ProductLineDiagram");
        plViewpoint.getOwnedRepresentationExtensions().add(plDiagramExt);
        // default layer
        var layer = diagram.getDefaultLayer();
        var plLayer = this.dDescFactory.createAdditionalLayer();
        addPLIdentifiedElement(layer, plLayer, SiriusToProductLine.ID_PREFIX + " ");
        plDiagramExt.getLayers().add(plLayer);
        // node mappings
        for (var nodeMapping : layer.getNodeMappings()) {
          var plNodeMapping = createPLNodeMapping(nodeMapping, modelTypeName);
          plLayer.getNodeMappings().add(plNodeMapping);
          plMappings.put(nodeMapping.getName(), plNodeMapping);
          // border node mappings
          for (var borderNodeMapping : nodeMapping.getBorderedNodeMappings()) {
            var plBorderNodeMapping = createPLSubnodeMapping(borderNodeMapping, modelTypeName);
            plNodeMapping.getBorderedNodeMappings().add(plBorderNodeMapping);
            plMappings.put(borderNodeMapping.getName(), plBorderNodeMapping);
          }
        }
        // container mappings
        for (var containerMapping : layer.getContainerMappings()) {
          var plContainerMapping = createPLContainerMapping(containerMapping, modelTypeName);
          plLayer.getContainerMappings().add(plContainerMapping);
          plMappings.put(containerMapping.getName(), plContainerMapping);
          // subnode mappings
          for (var subnodeMapping : containerMapping.getSubNodeMappings()) {
            var plSubnodeMapping = createPLSubnodeMapping(subnodeMapping, modelTypeName);
            plContainerMapping.getSubNodeMappings().add(plSubnodeMapping);
            plMappings.put(subnodeMapping.getName(), plSubnodeMapping);
          }
        }
        // edge mappings
        for (var edgeMapping : layer.getEdgeMappings()) {
          var plEdgeMapping = createPLEdgeMapping(edgeMapping, plMappings, modelType);
          plLayer.getEdgeMappings().add(plEdgeMapping);
          plMappings.put(edgeMapping.getName(), plEdgeMapping);
        }
        // tool sections
        for (var section : layer.getToolSections()) {
          var plSection = this.dToolFactory.createToolSection();
          addPLIdentifiedElement(section, plSection, null);
          plLayer.getToolSections().add(plSection);
          for (var tool : section.getOwnedTools()) {
            // node creation
            if (tool instanceof NodeCreationDescription nodeTool) {
              var plTool = createPLNodeCreationTool(nodeTool, plMappings, bundleName);
              plSection.getOwnedTools().add(plTool);
            }
            // container creation
            if (tool instanceof ContainerCreationDescription containerTool) {
              var plTool = createPLContainerCreationTool(containerTool, plMappings, bundleName);
              plSection.getOwnedTools().add(plTool);
            }
            // edge creation
            if (tool instanceof EdgeCreationDescription edgeTool) {
              var plTool = createPLEdgeCreationTool(edgeTool, plMappings, bundleName);
              plSection.getOwnedTools().add(plTool);
            }
          }
        }
      }
    }
  }

  private String getType(String expression) {
    var separator = (expression.contains(":")) ? ":" : ".";
    var i = expression.lastIndexOf(separator);
    return (i < 0) ? expression : expression.substring(i+1);
  }

  private void addPLIdentifiedElement(IdentifiedElement elem, IdentifiedElement plElem, @Nullable String labelPrefix) {
    plElem.setName(SiriusToProductLine.ID_PREFIX + elem.getName());
    if (elem.getLabel() != null) {
      var plLabel = elem.getLabel();
      if (labelPrefix != null) {
        plLabel = labelPrefix + plLabel;
      }
      plElem.setLabel(plLabel);
    }
  }

  private void addPLStyleExpression(BasicLabelStyleDescription plStyle, String modelTypeName) {
    plStyle.setLabelExpression("service: getPL" + modelTypeName + "ElementLabel");
  }

  private void addPLDiagramMapping(DiagramElementMapping diagMapping, DiagramElementMapping plDiagMapping,
                                   String semanticExpr, String precondition) {
    addPLIdentifiedElement(diagMapping, plDiagMapping, null);
    plDiagMapping.setSemanticCandidatesExpression(semanticExpr);
    plDiagMapping.setLabelDirectEdit(this.plLabel);
    plDiagMapping.setPreconditionExpression(precondition);
  }

  private void addPLNodeMapping(AbstractNodeMapping nodeMapping, AbstractNodeMapping plNodeMapping) {
    plNodeMapping.setDomainClass("productline.Class");
    var type = getType(nodeMapping.getDomainClass());
    var semanticExpr = "feature:classes";
    var precondition = "aql: self.type.name = '" + type + "' or self.type.eAllSuperTypes->exists(s | s.name = '" +
                       type + "')";
    addPLDiagramMapping(nodeMapping, plNodeMapping, semanticExpr, precondition);
    plNodeMapping.setDeletionDescription(this.plDelete);
  }

  private NodeMapping createPLNodeMapping(NodeMapping nodeMapping, String modelTypeName) {
    var plNodeMapping = this.dDescFactory.createNodeMapping();
    addPLNodeMapping(nodeMapping, plNodeMapping);
    var plStyle = EcoreUtil.copy(nodeMapping.getStyle());
    addPLStyleExpression(plStyle, modelTypeName);
    plNodeMapping.setStyle(plStyle);

    return plNodeMapping;
  }

  private ContainerMapping createPLContainerMapping(ContainerMapping containerMapping, String modelTypeName) {
    var plContainerMapping = this.dDescFactory.createContainerMapping();
    addPLNodeMapping(containerMapping, plContainerMapping);
    plContainerMapping.setChildrenPresentation(containerMapping.getChildrenPresentation());
    var plStyle = EcoreUtil.copy(containerMapping.getStyle());
    addPLStyleExpression(plStyle, modelTypeName);
    plContainerMapping.setStyle(plStyle);

    return plContainerMapping;
  }

  private NodeMapping createPLSubnodeMapping(NodeMapping subnodeMapping, String modelTypeName) {
    var plSubnodeMapping = createPLNodeMapping(subnodeMapping, modelTypeName);
    var refType = getType(subnodeMapping.getSemanticCandidatesExpression());
    var expr = "aql: self.references->select(r | r.type.name = '" + refType + "')->collect(r | r.target)";
    plSubnodeMapping.setSemanticCandidatesExpression(expr);

    return plSubnodeMapping;
  }

  private void addPLEdgeMapping(EdgeMapping edgeMapping, EdgeMapping plEdgeMapping, String domainClass,
                                String srcFinder, String tgtFinder, String semanticExpr, String precondition) {
    plEdgeMapping.setDomainClass(domainClass);
    plEdgeMapping.setUseDomainElement(true);
    plEdgeMapping.setSourceFinderExpression(srcFinder);
    plEdgeMapping.setTargetFinderExpression(tgtFinder);
    addPLDiagramMapping(edgeMapping, plEdgeMapping, semanticExpr, precondition);
  }

  private void addPLRefEdgeMapping(EdgeMapping edgeMapping, EdgeMapping plEdgeMapping, EPackage metamodel)
                                   throws MMINTException {
    var refType = getType(edgeMapping.getTargetFinderExpression());
    var classType = getType(((NodeMapping) edgeMapping.getSourceMapping().get(0)).getDomainClass());
    var eOpposite =
      ((EReference) ((EClass) metamodel.getEClassifier(classType)).getEStructuralFeature(refType)).getEOpposite();
    var domainClass = "productline.Reference";
    var srcFinder = "aql: if self.type.name = '" + refType + "' then self.eContainer() else self.target endif";
    var tgtFinder = "aql: if self.type.name = '" + refType + "' then self.target else self.eContainer() endif";
    var semanticExpr = "aql: self.eAllContents(productline::Reference)";
    var precondition = "aql: self.type.name = '" + refType + "'";
    if (eOpposite != null) {
      precondition += " or self.type.name = '" + eOpposite.getName() + "'";
    }
    addPLEdgeMapping(edgeMapping, plEdgeMapping, domainClass, srcFinder, tgtFinder, semanticExpr, precondition);
  }

  private void addPLClassEdgeMapping(EdgeMapping edgeMapping, EdgeMapping plEdgeMapping, EPackage metamodel) {
    var classType = getType(edgeMapping.getDomainClass());
    var eClass = ((EClass) metamodel.getEClassifier(classType));
    var srcRefType = getType(edgeMapping.getSourceFinderExpression());
    var eSrcOpposite = ((EReference) eClass.getEStructuralFeature(srcRefType)).getEOpposite();
    var tgtRefType = getType(edgeMapping.getTargetFinderExpression());
    var eTgtOpposite = ((EReference) eClass.getEStructuralFeature(tgtRefType)).getEOpposite();
    var domainClass = "productline.Class";
    var srcFinder = "aql: self.references->select(r | r.type.name = '" + srcRefType + "')->collect(r | r.target)";
    if (eSrcOpposite != null) {
      srcFinder += "->union(self.referencesAsTarget->select(r | r.type.name = '" + eSrcOpposite.getName() +
                   "')->collect(r | r.eContainer()))";
    }
    var tgtFinder = "aql: self.references->select(r | r.type.name = '" + tgtRefType + "')->collect(r | r.target)->union(self.referencesAsTarget->select(r | r.type.name = 'transitionsAsTarget')->collect(r | r.eContainer()))";
    if (eTgtOpposite != null) {
      tgtFinder += "->union(self.referencesAsTarget->select(r | r.type.name = '" + eTgtOpposite.getName() +
                   "')->collect(r | r.eContainer()))";
    }
    var semanticExpr = "feature:classes";
    var precondition = "aql: self.type.name = '" + classType + "'";
    addPLEdgeMapping(edgeMapping, plEdgeMapping, domainClass, srcFinder, tgtFinder, semanticExpr, precondition);
    plEdgeMapping.setDeletionDescription(this.plDelete);
  }

  private EdgeMapping createPLEdgeMapping(EdgeMapping edgeMapping, Map<String, DiagramElementMapping> plMappings,
                                          Model modelType) throws MMINTException {
    var modelTypeName = modelType.getName();
    var metamodel = modelType.getEMFTypeRoot();
    var plEdgeMapping = this.dDescFactory.createEdgeMapping();
    if (edgeMapping.isUseDomainElement()) { // elem-based edge
      addPLClassEdgeMapping(edgeMapping, plEdgeMapping, metamodel);
    }
    else { // rel-based edge
      addPLRefEdgeMapping(edgeMapping, plEdgeMapping, metamodel);
    }
    for (var srcMapping : edgeMapping.getSourceMapping()) {
      plEdgeMapping.getSourceMapping().add(plMappings.get(srcMapping.getName()));
    }
    for (var tgtMapping : edgeMapping.getTargetMapping()) {
      plEdgeMapping.getTargetMapping().add(plMappings.get(tgtMapping.getName()));
    }
    var plStyle = EcoreUtil.copy(edgeMapping.getStyle());
    plEdgeMapping.setStyle(plStyle);
    var plBeginLabel = plStyle.getBeginLabelStyleDescription();
    if (plBeginLabel != null) {
      addPLStyleExpression(plBeginLabel, modelTypeName);
    }
    var plCenterLabel = plStyle.getCenterLabelStyleDescription();
    if (plCenterLabel != null) {
      addPLStyleExpression(plCenterLabel, modelTypeName);
    }
    var plEndLabel = plStyle.getEndLabelStyleDescription();
    if (plEndLabel != null) {
      addPLStyleExpression(plEndLabel, modelTypeName);
    }

    return plEdgeMapping;
  }

  private record PLCreateOp(ChangeContext op, @Nullable String type) {};
  private PLCreateOp addPLCreateOp(ModelOperation firstOp, String javaClass) {
    var plChangeOp = this.vToolFactory.createChangeContext();
    var changeExpr = "var:container";
    String type = null;
    if (firstOp instanceof CreateInstance creationOp) {
      type = getType(creationOp.getTypeName());
    }
    else if (firstOp instanceof ChangeContext changeOp) {
      changeExpr = changeOp.getBrowseExpression();
      for (var subOp : changeOp.getSubModelOperations()) {
        if (subOp instanceof CreateInstance creationOp) {
          type = getType(creationOp.getTypeName());
          break;
        }
        else if (subOp instanceof SetValue setOp) {
          type = getType(setOp.getFeatureName());
        }
      }
    }
    plChangeOp.setBrowseExpression(changeExpr);
    if (type != null) {
      var plJavaOp = this.vToolFactory.createExternalJavaAction();
      plJavaOp.setName(SiriusToProductLine.ID_PREFIX + "Create" + type.substring(0, 1).toUpperCase() +
                       type.substring(1));
      plJavaOp.setId(javaClass);
      var plParam = this.vToolFactory.createExternalJavaActionParameter();
      plParam.setName("type");
      plParam.setValue(type);
      plJavaOp.getParameters().add(plParam);
      plChangeOp.getSubModelOperations().add(plJavaOp);
    }

    return new PLCreateOp(plChangeOp, type);
  }

  private NodeCreationDescription createPLNodeCreationTool(NodeCreationDescription nodeTool,
                                                           Map<String, DiagramElementMapping> plMappings,
                                                           String bundleName) {
    var plNodeTool = this.dToolFactory.createNodeCreationDescription();
    addPLIdentifiedElement(nodeTool, plNodeTool, null);
    for (var nodeMapping : nodeTool.getNodeMappings()) {
      plNodeTool.getNodeMappings().add((NodeMapping) plMappings.get(nodeMapping.getName()));
    }
    // tool vars
    var toolVar = nodeTool.getVariable();
    if (toolVar != null) {
      var plToolVar = this.dToolFactory.createNodeCreationVariable();
      plToolVar.setName(toolVar.getName());
      plNodeTool.setVariable(plToolVar);
    }
    var toolViewVar = nodeTool.getViewVariable();
    if (toolViewVar != null) {
      var plToolViewVar = this.vToolFactory.createContainerViewVariable();
      plToolViewVar.setName(toolViewVar.getName());
      plNodeTool.setViewVariable(plToolViewVar);
    }
    // tool ops
    var plInitialOp = this.vToolFactory.createInitialNodeCreationOperation();
    plNodeTool.setInitialOperation(plInitialOp);
    var plCreateOp = addPLCreateOp(nodeTool.getInitialOperation().getFirstModelOperations(), this.nodesJava);
    plInitialOp.setFirstModelOperations(plCreateOp.op());
    // tool icon
    if (!nodeTool.getIconPath().isBlank()) {
      plNodeTool.setIconPath(nodeTool.getIconPath());
    }
    else if (plCreateOp.type() != null) {
      plNodeTool.setIconPath(bundleName + ".edit/icons/full/obj16/" + plCreateOp.type() + ".gif");
    }

    return plNodeTool;
  }

  private ContainerCreationDescription createPLContainerCreationTool(ContainerCreationDescription containerTool,
                                                                     Map<String, DiagramElementMapping> plMappings,
                                                                     String bundleName) {
    var plContainerTool = this.dToolFactory.createContainerCreationDescription();
    addPLIdentifiedElement(containerTool, plContainerTool, null);
    for (var containerMapping : containerTool.getContainerMappings()) {
      plContainerTool.getContainerMappings().add((ContainerMapping) plMappings.get(containerMapping.getName()));
    }
    // tool vars
    var toolVar = containerTool.getVariable();
    if (toolVar != null) {
      var plToolVar = this.dToolFactory.createNodeCreationVariable();
      plToolVar.setName(toolVar.getName());
      plContainerTool.setVariable(plToolVar);
    }
    var toolViewVar = containerTool.getViewVariable();
    if (toolViewVar != null) {
      var plToolViewVar = this.vToolFactory.createContainerViewVariable();
      plToolViewVar.setName(toolViewVar.getName());
      plContainerTool.setViewVariable(plToolViewVar);
    }
    // tool ops
    var plInitialOp = this.vToolFactory.createInitialNodeCreationOperation();
    plContainerTool.setInitialOperation(plInitialOp);
    var plCreateOp = addPLCreateOp(containerTool.getInitialOperation().getFirstModelOperations(), this.nodesJava);
    plInitialOp.setFirstModelOperations(plCreateOp.op());
    // tool icon
    if (!containerTool.getIconPath().isBlank()) {
      plContainerTool.setIconPath(containerTool.getIconPath());
    }
    else if (plCreateOp.type() != null) {
      plContainerTool.setIconPath(bundleName + ".edit/icons/full/obj16/" + plCreateOp.type() + ".gif");
    }

    return plContainerTool;
  }

  private EdgeCreationDescription createPLEdgeCreationTool(EdgeCreationDescription edgeTool,
                                                           Map<String, DiagramElementMapping> plMappings,
                                                           String bundleName) {
    var plEdgeTool = this.dToolFactory.createEdgeCreationDescription();
    addPLIdentifiedElement(edgeTool, plEdgeTool, null);
    for (var edgeMapping : edgeTool.getEdgeMappings()) {
      plEdgeTool.getEdgeMappings().add((EdgeMapping) plMappings.get(edgeMapping.getName()));
    }
    // tool vars
    var srcVar = edgeTool.getSourceVariable();
    if (srcVar != null) {
      var plSrcVar = this.dToolFactory.createSourceEdgeCreationVariable();
      plSrcVar.setName(srcVar.getName());
      plEdgeTool.setSourceVariable(plSrcVar);
    }
    var tgtVar = edgeTool.getTargetVariable();
    if (tgtVar != null) {
      var plTgtVar = this.dToolFactory.createTargetEdgeCreationVariable();
      plTgtVar.setName(tgtVar.getName());
      plEdgeTool.setTargetVariable(plTgtVar);
    }
    var srcViewVar = edgeTool.getSourceViewVariable();
    if (srcViewVar != null) {
      var plSrcViewVar = this.dToolFactory.createSourceEdgeViewCreationVariable();
      plSrcViewVar.setName(srcViewVar.getName());
      plEdgeTool.setSourceViewVariable(plSrcViewVar);
    }
    var tgtViewVar = edgeTool.getTargetViewVariable();
    if (tgtViewVar != null) {
      var plTgtViewVar = this.dToolFactory.createTargetEdgeViewCreationVariable();
      plTgtViewVar.setName(tgtViewVar.getName());
      plEdgeTool.setTargetViewVariable(plTgtViewVar);
    }
    // tool ops
    var plInitialOp = this.vToolFactory.createInitEdgeCreationOperation();
    plEdgeTool.setInitialOperation(plInitialOp);
    var plCreateOp = addPLCreateOp(edgeTool.getInitialOperation().getFirstModelOperations(), this.edgesJava);
    var plChangeOp = plCreateOp.op();
    plInitialOp.setFirstModelOperations(plChangeOp);
    var plJavaOp = (ExternalJavaAction) plChangeOp.getSubModelOperations().get(0);
    var edgeMapping = edgeTool.getEdgeMappings().get(0);
    if (!edgeMapping.isUseDomainElement()) { // rel-based edge
      var classType = getType(((NodeMapping) edgeMapping.getSourceMapping().get(0)).getDomainClass());
      plJavaOp.getParameters().get(0).setValue(classType + "." + plJavaOp.getParameters().get(0).getValue());
    }
    var plParam = this.vToolFactory.createExternalJavaActionParameter();
    plParam.setName("source");
    plParam.setValue("var:source");
    plJavaOp.getParameters().add(plParam);
    plParam = this.vToolFactory.createExternalJavaActionParameter();
    plParam.setName("target");
    plParam.setValue("var:target");
    plJavaOp.getParameters().add(plParam);
    // tool icon
    if (!edgeTool.getIconPath().isBlank()) {
      plEdgeTool.setIconPath(edgeTool.getIconPath());
    }
    else if (plCreateOp.type() != null) {
      plEdgeTool.setIconPath(bundleName + ".edit/icons/full/obj16/" + plCreateOp.type() + ".gif");
    }

    return plEdgeTool;
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    toProductLine();

    return outputFromInput(0, 0, inputsByName, outputMIDsByName);
  }
}

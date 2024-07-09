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
import java.util.Map;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.diagram.description.DiagramDescription;
import org.eclipse.sirius.diagram.description.EdgeMapping;
import org.eclipse.sirius.diagram.description.NodeMapping;
import org.eclipse.sirius.diagram.description.style.StyleFactory;
import org.eclipse.sirius.viewpoint.description.DescriptionFactory;
import org.eclipse.sirius.viewpoint.description.Group;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;

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
    public String path;
    public MID mid;

    public Out(Map<String, MID> outputMIDsByName, String workingPath, In in) throws MMINTException {
      this.modelType = in.specModel.getMetatype();
      this.vDescFactory = DescriptionFactory.eINSTANCE;
      this.dDescFactory = org.eclipse.sirius.diagram.description.DescriptionFactory.eINSTANCE;
      this.dStyleFactory = StyleFactory.eINSTANCE;
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
//    var layers = diagramExtensionDescription.getLayers();

    //TRying to create the layer
    var group = this.out.vDescFactory.createGroup();
    group.setName("StateMachineProductLine");

    for (var originalViewpoint : siriusSpec.getOwnedViewpoints()) {
      for (var representation : originalViewpoint.getOwnedRepresentations()) {
        var originalDiagram = (DiagramDescription) representation;
        /** READ ME
         *  here are the layers: you should get the mappings from them, not directly from the originalDiagram
         *  you can just assume a single default layer for now
         */
//        var defaultLayer = originalDiagram.getDefaultLayer();
//        var newDefaultLayer = this.out.dDescFactory.createLayer();
//        var additionalLayers = originalDiagram.getAdditionalLayers();
//        var additionalLayer = this.out.dDescFactory.createAdditionalLayer();
        for (var originalNodeMapping : originalDiagram.getNodeMappings()) {
          var productLineNodeMapping = createProductLineNodeMapping(originalNodeMapping);
          ((DiagramDescription) diagramExtensionDescription).getNodeMappings().add(productLineNodeMapping);
        }
        for (var originalEdgeMapping : originalDiagram.getEdgeMappings()) {
          var productLineEdgeMapping = createProductLineEdgeMapping(originalEdgeMapping);
          ((DiagramDescription) diagramExtensionDescription).getEdgeMappings().add(productLineEdgeMapping);
        }
      }
    }

    viewpoint.getOwnedRepresentations().add((RepresentationDescription) diagramExtensionDescription);
    this.out.plSiriusSpec.getOwnedViewpoints().add(viewpoint);
  }

  private NodeMapping createProductLineNodeMapping(NodeMapping originalNodeMapping) {
    var nodeMapping = this.out.dDescFactory.createNodeMapping();
    nodeMapping.setName("PL" + originalNodeMapping.getName());
    nodeMapping.setDomainClass(originalNodeMapping.getDomainClass());
    nodeMapping.setSemanticCandidatesExpression(originalNodeMapping.getSemanticCandidatesExpression());

    // Copy styles and tools from the original node mapping
    /** READ ME
     *  doing a copy like the following is tricky, do not try it for other elements:
     *  here it works because a style is a self-contained leaf element in the diagram, and it's the most efficient solution
     *  (you still need to update things such as label expressions)
     */
    var newStyle = EcoreUtil.copy(originalNodeMapping.getStyle());
    nodeMapping.setStyle(newStyle);
    /** READ ME
     *  tools are under layers and then under sections, you can't get them from the mappings
     */
//    for (NodeCreationDescription createTool : originalNodeMapping.getCreate()) {
//      var productLineCreateTool = ToolFactory.eINSTANCE.createNodeCreationDescription();
//      productLineCreateTool.setName("PL" + createTool.getName());
//      productLineCreateTool.setForceRefresh(createTool.isForceRefresh());
//      productLineCreateTool.setName(createTool.getName());
//      nodeMapping.getCreate().add(productLineCreateTool);
//    }

    return nodeMapping;
  }

  private EdgeMapping createProductLineEdgeMapping(EdgeMapping originalEdgeMapping) {
    var edgeMapping = this.out.dDescFactory.createEdgeMapping();
    edgeMapping.setName("PL" + originalEdgeMapping.getName());
    edgeMapping.setDomainClass(originalEdgeMapping.getDomainClass());
    edgeMapping.setSemanticCandidatesExpression(originalEdgeMapping.getSemanticCandidatesExpression());

    // Copy styles and tools from the original edge mapping
//    edgeMapping.setStyle(originalEdgeMapping.getStyle());
//    for (EdgeCreationDescription createTool : originalEdgeMapping.getCreate()) {
//      var productLineCreateTool = ToolFactory.eINSTANCE.createEdgeCreationDescription();
//      productLineCreateTool.setName("PL" + createTool.getName());
//      productLineCreateTool.setForceRefresh(createTool.isForceRefresh());
//      productLineCreateTool.setName(createTool.getName());
//      edgeMapping.getCreate().add(productLineCreateTool);
//    }

    return edgeMapping;
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    init(inputsByName, outputMIDsByName);
    toProductLine();

    return this.out.packed();
  }
}

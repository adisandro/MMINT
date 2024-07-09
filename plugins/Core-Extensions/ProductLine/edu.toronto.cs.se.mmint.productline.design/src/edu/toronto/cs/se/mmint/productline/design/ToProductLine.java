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
import org.eclipse.sirius.diagram.description.DiagramDescription;
import org.eclipse.sirius.diagram.description.EdgeMapping;
import org.eclipse.sirius.diagram.description.NodeMapping;
import org.eclipse.sirius.diagram.description.tool.EdgeCreationDescription;
import org.eclipse.sirius.diagram.description.tool.NodeCreationDescription;
import org.eclipse.sirius.diagram.description.tool.ToolFactory;
import org.eclipse.sirius.viewpoint.description.DescriptionFactory;
import org.eclipse.sirius.viewpoint.description.Group;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.sirius.viewpoint.description.RepresentationElementMapping;
import org.eclipse.sirius.viewpoint.description.Viewpoint;

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
    public String path;
    public MID mid;

    public Out(Map<String, MID> outputMIDsByName, String workingPath, In in) throws MMINTException {
      this.modelType = in.specModel.getMetatype();
      this.plSiriusSpec = DescriptionFactory.eINSTANCE.createGroup();
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

    var viewpoint = DescriptionFactory.eINSTANCE.createViewpoint();
    viewpoint.setName("StateMachineProductLineViewpoint");

    var diagramExtensionDescription = org.eclipse.sirius.diagram.description.DescriptionFactory.eINSTANCE.createDiagramExtensionDescription();
    diagramExtensionDescription.setName("StateMachineProductLineDiagram");
    
    //TRying to create the layer
    var group = DescriptionFactory.eINSTANCE.createGroup();
    group.setName("StateMachineProductLine");
    
    for (Viewpoint originalViewpoint : siriusSpec.getOwnedViewpoints()) {
    	for (RepresentationDescription representation : originalViewpoint.getOwnedRepresentations()) {
                DiagramDescription originalDiagram = (DiagramDescription) representation;
                for (NodeMapping originalNodeMapping : originalDiagram.getNodeMappings()) {
                    NodeMapping productLineNodeMapping = createProductLineNodeMapping(originalNodeMapping);
                    ((DiagramDescription) diagramExtensionDescription).getNodeMappings().add(productLineNodeMapping);
                }
                for (EdgeMapping originalEdgeMapping : originalDiagram.getEdgeMappings()) {
                    EdgeMapping productLineEdgeMapping = createProductLineEdgeMapping(originalEdgeMapping);
                    ((DiagramDescription) diagramExtensionDescription).getEdgeMappings().add(productLineEdgeMapping);
                }
        }
    }

    viewpoint.getOwnedRepresentations().add((RepresentationDescription) diagramExtensionDescription);
    this.out.plSiriusSpec.getOwnedViewpoints().add(viewpoint);
  }

  private NodeMapping createProductLineNodeMapping(NodeMapping originalNodeMapping) {
	    var nodeMapping = org.eclipse.sirius.diagram.description.DescriptionFactory.eINSTANCE.createNodeMapping();
	    nodeMapping.setName("PL" + originalNodeMapping.getName());
	    nodeMapping.setDomainClass(originalNodeMapping.getDomainClass());
	    nodeMapping.setSemanticCandidatesExpression(originalNodeMapping.getSemanticCandidatesExpression());
	    
	    // Copy styles and tools from the original node mapping
//	    nodeMapping.setStyle(originalNodeMapping.getStyle());
//	    for (NodeCreationDescription createTool : originalNodeMapping.getCreate()) {
//	        var productLineCreateTool = ToolFactory.eINSTANCE.createNodeCreationDescription();
//	        productLineCreateTool.setName("PL" + createTool.getName());
//	        productLineCreateTool.setForceRefresh(createTool.isForceRefresh());
//	        productLineCreateTool.setName(createTool.getName());
//	        nodeMapping.getCreate().add(productLineCreateTool);
//	    }

	    return nodeMapping;
	}
  
  private EdgeMapping createProductLineEdgeMapping(EdgeMapping originalEdgeMapping) {
	    var edgeMapping = ((org.eclipse.sirius.diagram.description.DescriptionFactory) DescriptionFactory.eINSTANCE).createEdgeMapping();
	    edgeMapping.setName("PL" + originalEdgeMapping.getName());
	    edgeMapping.setDomainClass(originalEdgeMapping.getDomainClass());
	    edgeMapping.setSemanticCandidatesExpression(originalEdgeMapping.getSemanticCandidatesExpression());
	    
	    // Copy styles and tools from the original edge mapping
//	    edgeMapping.setStyle(originalEdgeMapping.getStyle());
//	    for (EdgeCreationDescription createTool : originalEdgeMapping.getCreate()) {
//	        var productLineCreateTool = ToolFactory.eINSTANCE.createEdgeCreationDescription();
//	        productLineCreateTool.setName("PL" + createTool.getName());
//	        productLineCreateTool.setForceRefresh(createTool.isForceRefresh());
//	        productLineCreateTool.setName(createTool.getName());
//	        edgeMapping.getCreate().add(productLineCreateTool);
//	    }

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

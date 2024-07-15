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
import org.eclipse.sirius.diagram.description.ContainerMapping;
import org.eclipse.sirius.diagram.description.DiagramDescription;
import org.eclipse.sirius.diagram.description.EdgeMapping;
import org.eclipse.sirius.diagram.description.NodeMapping;
import org.eclipse.sirius.diagram.description.style.StyleFactory;
import org.eclipse.sirius.diagram.description.tool.ContainerCreationDescription;
import org.eclipse.sirius.diagram.description.tool.EdgeCreationDescription;
import org.eclipse.sirius.diagram.description.tool.NodeCreationDescription;
import org.eclipse.sirius.diagram.description.tool.ToolFactory;
import org.eclipse.sirius.viewpoint.description.DescriptionFactory;
import org.eclipse.sirius.viewpoint.description.Group;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.sirius.viewpoint.description.style.BasicLabelStyleDescription;

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
    public String path;
    public MID mid;

    public Out(Map<String, MID> outputMIDsByName, String workingPath, In in) throws MMINTException {
      this.modelType = in.specModel.getMetatype();
      this.vDescFactory = DescriptionFactory.eINSTANCE;
      this.dDescFactory = org.eclipse.sirius.diagram.description.DescriptionFactory.eINSTANCE;
      this.dStyleFactory = StyleFactory.eINSTANCE;
      this.dToolFactory = ToolFactory.eINSTANCE;
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

    for (var originalViewpoint : siriusSpec.getOwnedViewpoints()) {
      for (var representation : originalViewpoint.getOwnedRepresentations()) {
        var originalDiagram = (DiagramDescription) representation;
        
        // Handle default layer
        var defaultLayer = originalDiagram.getDefaultLayer();
        var newDefaultLayer = this.out.dDescFactory.createLayer();
        newDefaultLayer.setName("State Machine Product Line");
        ((DiagramDescription) diagramExtensionDescription).setDefaultLayer(newDefaultLayer);
        
        // Node Mappings
        for (var originalNodeMapping : defaultLayer.getNodeMappings()) {
            var productLineNodeMapping = createProductLineNodeMapping(originalNodeMapping);
            newDefaultLayer.getNodeMappings().add(productLineNodeMapping);
        }
        // Edge Mappings
        for (var originalEdgeMapping : defaultLayer.getEdgeMappings()) {
            var productLineEdgeMapping = createProductLineEdgeMapping(originalEdgeMapping);
            newDefaultLayer.getEdgeMappings().add(productLineEdgeMapping);
        }
        // Container mappings
        for (var originalContainerMapping : defaultLayer.getContainerMappings()) {
            var productLineContainerMapping = createProductLineContainerMapping(originalContainerMapping);
            newDefaultLayer.getContainerMappings().add(productLineContainerMapping);
            
         // Sub-Node Mappings
            for (var originalSubNodeMapping : originalContainerMapping.getSubNodeMappings()) {
            	/*
            	 * QUESTION 7
            	 */
                var productLineSubNodeMapping = createProductLineNodeMapping(originalSubNodeMapping);
                productLineContainerMapping.getSubNodeMappings().add(productLineSubNodeMapping);
            }
        }
        // Creation Tools
        /*
         * QUESTION 4
         */
        for (var section : defaultLayer.getToolSections()) {
            var newSection = this.out.dToolFactory.createToolSection();
            newSection.setName(section.getName());
            newDefaultLayer.getToolSections().add(newSection);

            // Node Creation Tools
            for (var createTool : section.getOwnedTools()) {
            	if (createTool instanceof NodeCreationDescription) {
            		var productLineCreateTool = createProductLineNodeCreationTool((NodeCreationDescription) createTool);
                    newSection.getOwnedTools().add(productLineCreateTool);
            	}
            	/*
            	 * QUESTION 6
            	 */
//            	var productLineCreateTool = EcoreUtil.copy((NodeCreationDescription) createTool);
//                productLineCreateTool.setName("PL" + createTool.getName());
//                newSection.getOwnedTools().add(productLineCreateTool);
            }

            // Edge Creation Tools
            for (var createTool : section.getOwnedTools()) {
            	if (createTool instanceof EdgeCreationDescription) {
            		var productLineCreateTool = createProductLineEdgeCreationTool((EdgeCreationDescription) createTool);
                    newSection.getOwnedTools().add(productLineCreateTool);
            	}
            }

            // Container Creation Tools
            for (var createTool : section.getOwnedTools()) {
                var productLineCreateTool = createProductLineContainerCreationTool((ContainerCreationDescription) createTool);
                newSection.getOwnedTools().add(productLineCreateTool);
            }
        }
      }
    }

    viewpoint.getOwnedRepresentations().add((RepresentationDescription) diagramExtensionDescription);
    this.out.plSiriusSpec.getOwnedViewpoints().add(viewpoint);
  }

  private NodeMapping createProductLineNodeMapping(NodeMapping originalNodeMapping) {
    var nodeMapping = this.out.dDescFactory.createNodeMapping();
    nodeMapping.setName("PL" + originalNodeMapping.getName());
    nodeMapping.setLabel("PL" + originalNodeMapping.getLabel());
    nodeMapping.setDomainClass("productline.class");
    nodeMapping.setSemanticCandidatesExpression("feature:classes");
    nodeMapping.setPreconditionExpression("aql: self.type.name = " + originalNodeMapping.getName());
    /*
     * QUESTION 1
     */
    // nodeMapping.setSynchronizationLock(originalNodeMapping.getSynchronizationLock());

    // Copy styles and update label expressions
    var newStyle = EcoreUtil.copy(originalNodeMapping.getStyle());
    nodeMapping.setStyle(newStyle);
    newStyle.setLabelExpression("service: getStateMachinePLElementLabel");

    return nodeMapping;
  }

  private EdgeMapping createProductLineEdgeMapping(EdgeMapping originalEdgeMapping) {
    var edgeMapping = this.out.dDescFactory.createEdgeMapping();
    edgeMapping.setName("PL" + originalEdgeMapping.getName());
    edgeMapping.setLabel(originalEdgeMapping.getLabel());
    edgeMapping.setDomainClass("productline.class");
    edgeMapping.setSemanticCandidatesExpression("feature:classes");
    edgeMapping.setPreconditionExpression("aql: self.type.name = " + originalEdgeMapping.getName());
    edgeMapping.setSourceFinderExpression(originalEdgeMapping.getSourceFinderExpression());
    edgeMapping.setTargetFinderExpression(originalEdgeMapping.getTargetFinderExpression());
    /*
     * QUESTION 2
     */
//    edgeMapping.setSourceMapping(originalEdgeMapping.getSourceMapping());
    
 // Copy styles and update label expressions
    /*
     * QUESTION 3
     */
    var newStyle = EcoreUtil.copy(originalEdgeMapping.getStyle());
    edgeMapping.setStyle(newStyle);
    /*
     * QUESTION 5
     */
    ((BasicLabelStyleDescription) newStyle).setLabelExpression(((BasicLabelStyleDescription) originalEdgeMapping.getStyle()).getLabelExpression());

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
	    

//	    // Container Style
//	    if (originalContainerMapping.getName().equals("State")) {
//	        var style = this.out.dStyleFactory.;
//	        style.setColor("light_yellow");
//	        style.setGradientColor("light_yellow_to_light_yellow");
//	        containerMapping.setStyle(style);
//	    }

	    return containerMapping;
	}
  
  private NodeCreationDescription createProductLineNodeCreationTool(NodeCreationDescription originalCreateTool) {
	    var createTool = this.out.dToolFactory.createNodeCreationDescription();
	    createTool.setName("PL" + originalCreateTool.getName());
	    createTool.setForceRefresh(originalCreateTool.isForceRefresh());

	    return createTool;
	}

	private EdgeCreationDescription createProductLineEdgeCreationTool(EdgeCreationDescription originalCreateTool) {
	    var createTool = this.out.dToolFactory.createEdgeCreationDescription();
	    createTool.setName("PL" + originalCreateTool.getName());
	    createTool.setForceRefresh(originalCreateTool.isForceRefresh());

	    return createTool;
	}

	private ContainerCreationDescription createProductLineContainerCreationTool(ContainerCreationDescription originalCreateTool) {
	    var createTool = this.out.dToolFactory.createContainerCreationDescription();
	    createTool.setName("PL" + originalCreateTool.getName());
	    createTool.setForceRefresh(originalCreateTool.isForceRefresh());

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

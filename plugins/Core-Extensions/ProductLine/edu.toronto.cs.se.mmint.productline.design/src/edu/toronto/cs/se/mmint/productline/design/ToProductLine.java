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
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.diagram.description.AdditionalLayer;
import org.eclipse.sirius.diagram.description.ContainerMapping;
import org.eclipse.sirius.diagram.description.DiagramDescription;
import org.eclipse.sirius.diagram.description.EdgeMapping;
import org.eclipse.sirius.diagram.description.NodeMapping;
import org.eclipse.sirius.diagram.description.style.StyleFactory;
import org.eclipse.sirius.diagram.description.tool.ContainerCreationDescription;
import org.eclipse.sirius.diagram.description.tool.DirectEditLabel;
import org.eclipse.sirius.diagram.description.tool.EdgeCreationDescription;
import org.eclipse.sirius.diagram.description.tool.NodeCreationDescription;
import org.eclipse.sirius.diagram.description.tool.ToolFactory;
import org.eclipse.sirius.viewpoint.description.DescriptionFactory;
import org.eclipse.sirius.viewpoint.description.Group;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.sirius.viewpoint.description.style.BasicLabelStyleDescription;
// import org.eclipse.sirius.viewpoint.description.tool.ToolFactory;

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
    
    Map<String, Object> map = new HashMap<>();

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
            map.put(originalNodeMapping.getLabel(), productLineNodeMapping);
        }
        // Edge Mappings
        for (var originalEdgeMapping : defaultLayer.getEdgeMappings()) {
            var productLineEdgeMapping = createProductLineEdgeMapping(originalEdgeMapping);
            newLayer.getEdgeMappings().add(productLineEdgeMapping);
            /*
             * QUESTION 3
             */
            map.put(originalEdgeMapping.getLabel(), productLineEdgeMapping);
        }
        // Container mappings
        for (var originalContainerMapping : defaultLayer.getContainerMappings()) {
            var productLineContainerMapping = createProductLineContainerMapping(originalContainerMapping);
            newLayer.getContainerMappings().add(productLineContainerMapping);
            map.put(originalContainerMapping.getLabel(), productLineContainerMapping);
            
         // Sub-Node Mappings
            for (var originalSubNodeMapping : originalContainerMapping.getSubNodeMappings()) {
                var productLineSubNodeMapping = createProductLineNodeMapping(originalSubNodeMapping);
                productLineContainerMapping.getSubNodeMappings().add(productLineSubNodeMapping);
                map.put(originalSubNodeMapping.getLabel(), productLineSubNodeMapping);
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

  private EdgeMapping createProductLineEdgeMapping(EdgeMapping originalEdgeMapping) {
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
        var newSourceMapping = this.out.dDescFactory.createNodeMapping();
        newSourceMapping.setName("PL" + originalSourceMapping.getName());
        edgeMapping.getSourceMapping().add(newSourceMapping);
    }
    for (var originalTargetMapping : originalEdgeMapping.getTargetMapping()) {
        var newTargetMapping = this.out.dDescFactory.createNodeMapping();
        newTargetMapping.setName("PL" + originalTargetMapping.getName());
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
	    /*
	     * QUESTION 2
	     */
	    DirectEditLabel label = this.out.dToolFactory.createDirectEditLabel();
	    label.setInputLabelExpression("Direct Label Edit EditPresenceCondition");
	    containerMapping.setLabelDirectEdit(label);
	    // Copy styles and update label expressions
	    var newStyle = EcoreUtil.copy(originalContainerMapping.getStyle());
	    containerMapping.setStyle(newStyle);
	    newStyle.setLabelExpression("service: getStateMachinePLElementLabel");

	    return containerMapping;
	}
  
  private NodeCreationDescription createProductLineNodeCreationTool(NodeCreationDescription originalCreateTool, Map<String, Object> map) {
	    var createTool = this.out.dToolFactory.createNodeCreationDescription();
	    createTool.setName("PL" + originalCreateTool.getName());
	    createTool.setLabel("PL" + originalCreateTool.getLabel());
	    String newString = originalCreateTool.getLabel().replace(" ", "");
	    /*
	     * QUESTION 4
	     */
	    for (var originalMapping : originalCreateTool.getNodeMappings()) {
	    	/*
	    	 * QUESTION 5
	    	 */
	    	NodeMapping newMapping = (NodeMapping) map.get(originalMapping.getName());
	    	createTool.getNodeMappings().add(newMapping);
	    }
	    
	    createTool.setIconPath("/edu.toronto.cs.se.modelepedia.statemachine.edit/icons/full/obj16/"+newString+".gif");
//	    originalCreateTool.getInitialOperation().getFirstModelOperations();
	    /*
	     * QUESTION 7
	     */
//	    var initialOperation = this.out.vToolFactory.createInitialOperation().getFirstModelOperations();
//	    var operations = this.out.vToolFactory.createFirstModelOperations();
//	    operations.setBrowseExpression("var:container");
//	    var subOperations = this.out.vToolFactory.createCreateInstance();
//	    subOperations.setTypeName(originalCreateTool.getTypeName());
//	    subOperations.setReferenceName(originalCreateTool.getReferenceName());
//	    operations.getSubModelOperations().add(subOperations);
//	    initialOperation.setFirstModelOperations(operations);
//	    createTool.setInitialOperation(initialOperation);
	    
//	    createTool.setForceRefresh(originalCreateTool.isForceRefresh());

	    return createTool;
	}

	private EdgeCreationDescription createProductLineEdgeCreationTool(EdgeCreationDescription originalCreateTool, Map<String, Object> map) {
	    var createTool = this.out.dToolFactory.createEdgeCreationDescription();
	    createTool.setName("PL" + originalCreateTool.getName());
	    createTool.setName("PL" + originalCreateTool.getName());
	    createTool.setLabel("PL" + originalCreateTool.getLabel());
	    /*
	     * QUESTION 6
	     */
	    String newString = originalCreateTool.getLabel().replace(" ", "");
	    EdgeMapping newMapping = (EdgeMapping) map.get(newString);
	    createTool.getEdgeMappings().add(newMapping);
	    createTool.setIconPath("/edu.toronto.cs.se.modelepedia.statemachine.edit/icons/full/obj16/"+newString+".gif");
	    
	    return createTool;
	}

	private ContainerCreationDescription createProductLineContainerCreationTool(ContainerCreationDescription originalCreateTool, Map<String, Object> map) {
	    var createTool = this.out.dToolFactory.createContainerCreationDescription();
	    createTool.setName("PL" + originalCreateTool.getName());
//	    createTool.setForceRefresh(originalCreateTool.isForceRefresh());

	    return createTool;
	}

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    init(inputsByName, outputMIDsByName);
    toProductLine();
    /*
     * ISSUE 1
     */
    return this.out.packed();
  }
}

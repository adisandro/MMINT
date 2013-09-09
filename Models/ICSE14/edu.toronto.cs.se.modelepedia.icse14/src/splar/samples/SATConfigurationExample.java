package splar.samples;

import java.util.List;

import splar.core.fm.FeatureGroup;
import splar.core.fm.FeatureTreeNode;
import splar.core.fm.configuration.ConfigurationEngine;
import splar.core.fm.configuration.ConfigurationStep;
import splar.plugins.configuration.sat.sat4j.SATConfigurationEngine;



/**
 * SPLAR library - Feature Model Reasoning and Configuration API
 * SPLOT portal - Software Product Lines Online Tools (www.splot-research.org)
 * 
 * ***************************************************************************
 *  
 * @author Marcilio Mendonca
 * University of Waterloo, Canada
 * July, 2009
 * 
 * This class illustrates how to use the SAT-based configuration engine
 */
public class SATConfigurationExample {

	public static void main(String args[]) {
		new SATConfigurationExample().run();
	}
	
	public void run() {

		try {
			
			// Feature model path
			String featureModelURL = "file:///c:\\users\\marcilio\\eclipse\\splar\\resources\\models\\simple_bike_fm.xml";
			
			// Creates the SAT configuration engine
			ConfigurationEngine satConfEngine = new SATConfigurationEngine(featureModelURL);
			
			// Initializes the engine
			satConfEngine.reset();
			
			/***********************************************************************************************
			 *  CONFIGURATION STEP: selects feature '_pedal_pedalb'
			 ************************************************************************************************/						
			ConfigurationStep step = satConfEngine.configure("_pedal_pedalb", 1);
			System.out.println("> Feature '" + satConfEngine.getModel().getNodeByID("_pedal_pedalb").getName() + "' has been selected");
			
			// Check which other features were impacted by propagation
			for( FeatureTreeNode propagatedNode: step.getPropagations() ) {
				System.out.println("--> Propagated: " + propagatedNode.getName() + " = " + propagatedNode.getValue());
			}
					
			/***********************************************************************************************
			 *  CONFLICT DETECTION: what if feature '_frame_aluminium' that was DESELECTED automatically 
			 *                      in the previous step is now toggled (SELECTED)?
			 ************************************************************************************************/						
			List<FeatureTreeNode> conflicts = satConfEngine.detectConflicts("_frame_aluminium");
			
			System.out.println("> Conflicts if feature '" + satConfEngine.getModel().getNodeByID("_frame_aluminium").getName() + "' is toggled");
			if ( conflicts.size() == 0 ) {
				System.out.println("No conflicts toggling feature " + satConfEngine.getModel().getNodeByID("_frame_aluminium").getName() );
			}
			// List all MANUAL previous decisions impacted by the toggling
			else {
				for( FeatureTreeNode conflictingFeature: satConfEngine.detectConflicts("_frame_aluminium") ) {
					System.out.println("---> Conflict: " + conflictingFeature.getName() );
				}				
			}
			
			/***********************************************************************************************
			 *  TOGGLE: go ahead and toggles feature '_frame_aluminium' to SELECTED state
			 ************************************************************************************************/						
			System.out.println("> Toggling feature '" + satConfEngine.getModel().getNodeByID("_frame_aluminium").getName() + "'");			
			satConfEngine.toggleDecision("_frame_aluminium");
			
			// Check current state of the features in the feature model
			System.out.println("> Current State of the Feature Model ---------------------------");
			
			for( FeatureTreeNode featureNode: satConfEngine.getModel().getNodes()) {
				if ( !(featureNode instanceof FeatureGroup) ) {
					System.out.println("--> " + featureNode.getName() + " = " + (featureNode.getValue()==1 ? "true" : (featureNode.getValue()==0?"false":"undefined")) );
				}
			}			
			
			/***********************************************************************************************
			 *  UNDO STEP: Retract decision made in the previous step (toggle)
			 ************************************************************************************************/				
			satConfEngine.undoLastStep();

			System.out.println("> Undoing previous step");			
			// Check current state of the features in the feature model
			System.out.println("> Current State of the Feature Model ---------------------------");
			
			for( FeatureTreeNode featureNode: satConfEngine.getModel().getNodes()) {
				if ( !(featureNode instanceof FeatureGroup) ) {
					System.out.println("--> " + featureNode.getName() + " = " + (featureNode.getValue()==1 ? "true" : (featureNode.getValue()==0?"false":"undefined")) );
				}
			}
			
			
			/***********************************************************************************************
			 *  AUTO-COMPLETION: automatically completes the configuration by attempting to select all "undefined" features
			 *  use 'false' argument to deselect all 'undefined' features
			 ************************************************************************************************/				
			satConfEngine.autoComplete(true);
			System.out.println("> Auto-completing configuration");
			
			// Check current state of the features in the feature model
			System.out.println("> Current State of the Feature Model ---------------------------");
			
			for( FeatureTreeNode featureNode: satConfEngine.getModel().getNodes()) {
				if ( !(featureNode instanceof FeatureGroup) ) {
					System.out.println("--> " + featureNode.getName() + " = " + (featureNode.getValue()==1 ? "true" : (featureNode.getValue()==0?"false":"undefined")) );
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

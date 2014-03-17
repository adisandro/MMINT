/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.diagram.edit.commands;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.osgi.framework.FrameworkUtil;

import com.parctechnologies.eclipse.CompoundTerm;

import edu.toronto.cs.se.mmtf.MMTF;
import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelTypeFactory;
import edu.toronto.cs.se.mmtf.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmtf.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElementConstraintLanguage;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.diagram.library.MidDiagramUtils;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;
import fr.inria.atlanmod.emftocsp.ICspSolver;
import fr.inria.atlanmod.emftocsp.IModelProperty;
import fr.inria.atlanmod.emftocsp.IModelReader;
import fr.inria.atlanmod.emftocsp.IModelToCspSolver;
import fr.inria.atlanmod.emftocsp.IModelToCspSolverFactory;
import fr.inria.atlanmod.emftocsp.eclipsecs.EclipseSolver;
import fr.inria.atlanmod.emftocsp.emf.impl.EAssociation;
import fr.inria.atlanmod.emftocsp.emf.impl.EmfModelToCspSolverFactory;
import fr.inria.atlanmod.emftocsp.emftoecl.EmfToEclCodeGenerator;
import fr.inria.atlanmod.emftocsp.impl.StrongSatisfiabilityModelProperty;
import fr.inria.atlanmod.emftocsp.ui.main.Activator;

/**
 * The command to create a model.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelNewModelCommand extends ModelCreateCommand {

	/**
	 * Constructor: initialises the superclass.
	 * 
	 * @param req
	 *            The request.
	 */
	public ModelNewModelCommand(CreateElementRequest req) {

		super(req);
	}

    /**
     * Overrides superclass to re-initialize diagram type hierarchy.
     */
	protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		IStatus status = super.doUndo(monitor, info);
		MultiModel multiModel = (MultiModel) getElementToEdit();
		if (!MultiModelConstraintChecker.isInstancesLevel(multiModel)) {
			MMTF.createTypeHierarchy(multiModel);
		}

		return status;
    }

    /**
     * Overrides superclass to re-initialize diagram type hierarchy.
     */
	protected IStatus doRedo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		IStatus status = super.doRedo(monitor, info);
		MultiModel multiModel = (MultiModel) getElementToEdit();
		if (!MultiModelConstraintChecker.isInstancesLevel(multiModel)) {
			MMTF.createTypeHierarchy(multiModel);
		}

		return status;
    }

	/**
	 * Checks if a model can be created.
	 * 
	 * @return True if a model can be created, false otherwise.
	 */
	@Override
	public boolean canExecute() {

		return super.canExecute();
	}

	protected Model doExecuteInstancesLevel() throws Exception {

		MultiModel multiModel = (MultiModel) getElementToEdit();
		Editor newEditor = MidDiagramUtils.selectModelTypeToCreate(multiModel);
		Model modelType = MultiModelTypeRegistry.getType(newEditor.getMetatype().getModelUri());
		Model newModel = modelType.createInstance(newEditor.getModelUri(), ModelOrigin.CREATED, multiModel);
		newModel.getEditors().add(newEditor);

		return newModel;
	}

	private boolean checkOCLConstraintConsistency(Model modelType, String oclConstraint) throws MMTFException {

		//TODO MMTF[EMF2CSP] detect if available at runtime
		// create and-ed global constraint
		Model baseModelType = modelType;
		while (!MultiModelTypeHierarchy.isRootType(modelType)) {
			ExtendibleElementConstraint constraint = modelType.getConstraint();
			if (constraint != null && constraint.getLanguage() == ExtendibleElementConstraintLanguage.OCL) {
				oclConstraint += " and " + constraint.getImplementation();
			}
			modelType = modelType.getSupertype();
		}
		// add constraint as annotation into the metamodel
		EPackage modelTypeObj = baseModelType.getEMFTypeRoot();
		EAnnotation newEAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		newEAnnotation.setSource(EcorePackage.eNS_URI);
		EMap<String, String> newEAnnotationDetails = newEAnnotation.getDetails();
		newEAnnotationDetails.put(MultiModelTypeFactory.ECORE_VALIDATION_DELEGATE, MultiModelTypeFactory.ECORE_PIVOT_URI);
		modelTypeObj.getEAnnotations().add(newEAnnotation);
		EClass modelTypeRootObj = (EClass) modelTypeObj.getEClassifiers().get(0);
		newEAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		newEAnnotation.setSource(EcorePackage.eNS_URI);
		newEAnnotationDetails = newEAnnotation.getDetails();
		newEAnnotationDetails.put("constraints", "consistencyConstraint");
		modelTypeRootObj.getEAnnotations().add(newEAnnotation);
		newEAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		newEAnnotation.setSource(MultiModelTypeFactory.ECORE_PIVOT_URI);
		newEAnnotationDetails = newEAnnotation.getDetails();
		newEAnnotationDetails.put("consistencyConstraint", oclConstraint);
		modelTypeRootObj.getEAnnotations().add(newEAnnotation);
		//TODO MMTF[EMF2CSP] remove added annotations from metamodel at the end
		// use EMFtoCSP to check strong satisfiability
		// EMFtoCSP init
		String eclipsePath = Activator.getDefault().getPreferenceStore().getString("EclipsePath");
		String graphvizPath = Activator.getDefault().getPreferenceStore().getString("GraphvizPath");
		ICspSolver solver = new EclipseSolver(eclipsePath, graphvizPath);
		IModelToCspSolverFactory<Resource, CompoundTerm> modelSolverFactory = new EmfModelToCspSolverFactory();
		IModelToCspSolver<Resource, CompoundTerm> modelSolver = modelSolverFactory.getModelToCspSolver();
		modelSolver.setModelFileName(baseModelType.getName());
		modelSolver.setModel(modelTypeObj.eResource());
		modelSolver.setSolver(solver);
		modelSolver.setCspCodeGenerator(new EmfToEclCodeGenerator(modelSolver));
		modelSolver.getBuilder();
		// EMFtoCSP ui screen 1
		IFile oclFile = null;
		modelSolver.setConstraintsDocument(oclFile);
		// EMFtoCSP ui screen 2
		Map<String, String> modelElementsDomain = new HashMap<String, String>();
		modelSolver.setModelElementsDomain(modelElementsDomain);
		IModelReader<Resource, EPackage, EClass, EAssociation, EAttribute, EOperation> modelReader = (IModelReader<Resource, EPackage, EClass, EAssociation, EAttribute, EOperation>) modelSolver.getModelReader();    
		for (EClass c : modelReader.getClasses()) {
			modelElementsDomain.put(c.getEPackage().getName() + "." + c.getName(), "0..5");
			for (EAttribute at : modelReader.getClassAttributes(c)) { 
				if (at.getEAttributeType().getName().equalsIgnoreCase("boolean") || at.getEAttributeType().getName().equalsIgnoreCase("boolean")) {
					modelElementsDomain.put(at.getEContainingClass().getName() + "." + at.getName(), "0..1");
				}
				else if (at.getEAttributeType().getName().equalsIgnoreCase("string") || at.getEAttributeType().getName().equalsIgnoreCase("estring") ) {
					modelElementsDomain.put(at.getEContainingClass().getName() + "." + at.getName() + ".length", "0..10");
					modelElementsDomain.put(at.getEContainingClass().getName() + "." + at.getName() + ".domain", "");
				}
				else {
					modelElementsDomain.put(at.getEContainingClass().getName() + "." + at.getName(), "[1,10,20]");
				}
			}
		}
		for (String asName : modelReader.getAssociationsNames()) {
			modelElementsDomain.put(asName, "0..10");
		}
		// EMFtoCSP ui screen 3
		List<IModelProperty> modelProperties = new ArrayList<IModelProperty>();
		modelProperties.add(new StrongSatisfiabilityModelProperty());
		modelSolver.setModelProperties(modelProperties);
		// EMFtoCSP ui screen 4
		//TODO create own temporary project, copy the metamodel there, and then delete everything
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("Demos");
		IFolder resultLocation = project.getFolder("emf2csp");
		modelSolver.setResultLocation(resultLocation);
		// EMFtoCSP performFinish()
		File importsFolder;
		try {
			importsFolder = new File(FileLocator.toFileURL(FrameworkUtil.getBundle(fr.inria.atlanmod.emftocsp.eclipsecs.EclipseSolver.class).getEntry("/libs")).toURI());
		}
		catch (Exception e) {
			throw new MMTFException("Screwed");
		}
		File[] libs = importsFolder.listFiles(
			new FilenameFilter() {
				public boolean accept(File dir, String name) {    
					return name.matches(".*\\.ecl$");
				}
			}
		);
		ArrayList<File> libList = new ArrayList<File>();
		for(int i = 0; i < libs.length; i++) {
			libList.add(libs[i]);
		}
		boolean isConsistent = modelSolver.solveModel(libList);
		// EMFtoCSP cleanup
		modelTypeObj.getEAnnotations().remove(modelTypeObj.getEAnnotations().size()-1);
		modelTypeRootObj.getEAnnotations().remove(modelTypeRootObj.getEAnnotations().size()-1);
		modelTypeRootObj.getEAnnotations().remove(modelTypeRootObj.getEAnnotations().size()-1);

		return isConsistent;
	}

	protected Model doExecuteTypesLevel() throws MMTFException {

		MultiModel multiModel = (MultiModel) getElementToEdit();
		Model modelType = MidDiagramUtils.selectModelTypeToExtend(multiModel);
		String newModelTypeName = MidDiagramUtils.getStringInput("Create new light model type", "Insert new model type name", null);
		String[] constraint = MidDiagramUtils.getConstraintInput("Create new light model type", null);

		if (ExtendibleElementConstraintLanguage.valueOf(constraint[0]) == ExtendibleElementConstraintLanguage.OCL) {
			if (!checkOCLConstraintConsistency(modelType, constraint[1])) {
				throw new MMTFException("Inconsistent");
			}
		}

		boolean isMetamodelExtension = (MultiModelTypeHierarchy.isRootType(modelType)) ?
			true :
			MidDiagramUtils.getBooleanInput("Create new light model type", "Extend metamodel?");
		Model newModelType = modelType.createSubtype(newModelTypeName, constraint[0], constraint[1], isMetamodelExtension);
		MMTF.createTypeHierarchy(multiModel);

		return newModelType;
	}

	/**
	 * Creates a new model.
	 * 
	 * @param monitor
	 *            The progress monitor.
	 * @param info
	 *            Additional parameter, not used.
	 * @return The ok result, or the error result if the model could not be
	 *         created.
	 * @throws ExecutionException
	 *             If configuration command execution goes wrong.
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		try {
			Model newElement = (MultiModelConstraintChecker.isInstancesLevel((MultiModel) getElementToEdit())) ?
				doExecuteInstancesLevel() :
				doExecuteTypesLevel();
			doConfigure(newElement, monitor, info);
			((CreateElementRequest) getRequest()).setNewElement(newElement);

			return CommandResult.newOKCommandResult(newElement);
		}
		catch (ExecutionException ee) {
			throw ee;
		}
		catch (Exception e) {
			MMTFException.print(MMTFException.Type.WARNING, "No model created", e);
			return CommandResult.newErrorCommandResult("No model created");
		}
	}

}

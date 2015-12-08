/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.emftocsp.reasoning;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osgi.framework.FrameworkUtil;

import com.parctechnologies.eclipse.CompoundTerm;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeFactory;
import edu.toronto.cs.se.mmint.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.modelepedia.ocl.reasoning.OCLReasoningEngine;
import fr.inria.atlanmod.emftocsp.ICspSolver;
import fr.inria.atlanmod.emftocsp.IModelProperty;
import fr.inria.atlanmod.emftocsp.IModelReader;
import fr.inria.atlanmod.emftocsp.IModelToCspSolver;
import fr.inria.atlanmod.emftocsp.IModelToCspSolverFactory;
import fr.inria.atlanmod.emftocsp.ProcessingException;
import fr.inria.atlanmod.emftocsp.eclipsecs.EclipseSolver;
import fr.inria.atlanmod.emftocsp.emf.impl.EAssociation;
import fr.inria.atlanmod.emftocsp.emf.impl.EmfModelToCspSolverFactory;
import fr.inria.atlanmod.emftocsp.emftoecl.EmfToEclCodeGenerator;
import fr.inria.atlanmod.emftocsp.impl.StrongSatisfiabilityModelProperty;
import fr.inria.atlanmod.emftocsp.ui.main.Activator;

public class EMFtoCSPReasoningEngine extends OCLReasoningEngine {

	private final static String ECORE_PIVOT_CONSISTENCYCONSTRAINT = "consistencyConstraint";
	private final static String EMFTOCSP_PREFERENCE_ECLIPSEPATH = "EclipsePath";
	private final static String EMFTOCSP_PREFERENCE_GRAPHVIZPATH = "GraphvizPath";
	private final static String EMFTOCSP_TEMPPROJECT = "edu.toronto.cs.se.mmint.emftocsp";
	private final static String EMFTOCSP_TEMPFOLDER = "consistency";

	private void flattenEPackage(EPackage flatPackage) {

		Map<String, EClass> flatClasses = new HashMap<String, EClass>();
		// first pass: pre-populate classes in the package
		for (EClassifier flatClassifier : flatPackage.getEClassifiers()) {
			if (!(flatClassifier instanceof EClass)) {
				continue;
			}
			flatClasses.put(flatClassifier.getName(), (EClass) flatClassifier);
		}
		// second pass: flatten
		for (EClassifier flatClassifier : flatPackage.getEClassifiers()) {
			if (!(flatClassifier instanceof EClass)) {
				continue;
			}
			flattenEClass((EClass) flatClassifier, flatPackage, flatClasses);
		}
		flatPackage.getEClassifiers().addAll(flatClasses.values());
	}

	private void flattenEClass(EClass flatClass, EPackage flatPackage, Map<String, EClass> flatClasses) {

		// first pass: flatten superclasses
		for (EClass superClass : flatClass.getEAllSuperTypes()) {
			for (EStructuralFeature flatFeature : superClass.getEStructuralFeatures()) {
				flatClass.getEStructuralFeatures().add(EcoreUtil.copy(flatFeature));
			}
			checkAndReflatten(superClass, flatPackage, flatClasses);
		}
		flatClass.getESuperTypes().clear();
		// second pass: flatten types
		for (EStructuralFeature flatFeature : flatClass.getEStructuralFeatures()) {
			if (!(flatFeature instanceof EReference)) {
				continue;
			}
			EClassifier flatFeatureClassifier = flatFeature.getEType();
			if (!(flatFeatureClassifier instanceof EClass)) {
				continue;
			}
			EClass flatFeatureClass = checkAndReflatten((EClass) flatFeatureClassifier, flatPackage, flatClasses);
			flatFeature.setEType(flatFeatureClass);
		}
	}

	private EClass checkAndReflatten(EClass checkedClass, EPackage flatPackage, Map<String, EClass> flatClasses) {

		if (checkedClass.getEPackage() != flatPackage && !flatClasses.containsKey(checkedClass.getName())) { // not in same package (assuming package == file)
			EClass flatClass = EcoreUtil.copy(checkedClass);
			flatClasses.put(flatClass.getName(), flatClass);
			flattenEClass(flatClass, flatPackage, flatClasses);

			return flatClass;
		}

		return flatClasses.get(checkedClass.getName());
	}

	private void cleanupCheckOCLConstraintConsistency(IProject tempProject) {

		try {
			if (tempProject != null) {
				tempProject.delete(true, true, null);
			}
		}
		catch (CoreException e) {
			MMINTException.print(IStatus.WARNING, "Can't delete EMFtoCSP temporary project", e);
		}
	}

	@Override
	public boolean checkConstraintConsistency(Model modelType, String oclConstraint) {

		EPackage modelTypeObj;
		try {
			modelTypeObj = (EPackage) getConstraintContext(modelType, oclConstraint, MIDLevel.TYPES);
		}
		catch (MMINTException e) {
			MMINTException.print(IStatus.ERROR, "Can't get context for OCL constraint, evaluating to false", e);
			return false;
		}
		String modelTypeName = modelType.getName();
		//TODO MMINT[CONSTRAINT] find language to express more complex contraints on model rels
		// create and-ed global constraint
		//TODO MMINT[CONSTRAINT] when invoked from add/remove don't consider the constraint on itself
		String oclConsistencyConstraint = (modelType instanceof ModelRel && oclConstraint.startsWith(OCL_MODELENDPOINT_VARIABLE)) ?
			oclConstraint.substring(oclConstraint.indexOf(OCL_VARIABLE_SEPARATOR) + 1, oclConstraint.length()) :
			oclConstraint;
		while (!MultiModelTypeHierarchy.isRootType(modelType)) {
			ExtendibleElementConstraint constraint = modelType.getConstraint();
			if (constraint != null && constraint.getLanguage().equals("OCL") && constraint.getImplementation() != null && !constraint.getImplementation().equals("")) {
				oclConsistencyConstraint += " and ";
				oclConsistencyConstraint += (modelType instanceof ModelRel && oclConstraint.startsWith(OCL_MODELENDPOINT_VARIABLE)) ?
					constraint.getImplementation().substring(constraint.getImplementation().indexOf(OCL_VARIABLE_SEPARATOR) + 1, constraint.getImplementation().length()) :
					constraint.getImplementation();
			}
			modelType = modelType.getSupertype();
		}
		// a constraint on model rel must be consistent with endpoints
		if (modelType instanceof ModelRel && oclConstraint.startsWith(OCL_MODELENDPOINT_VARIABLE)) {
			return checkConstraintConsistency(MultiModelTypeRegistry.<Model>getType(modelTypeObj.getNsURI()), oclConsistencyConstraint);
		}
		// flatten hierarchy and add constraint as annotation into the metamodel
		ResourceSet flatResourceSet = new ResourceSetImpl();
		String flatUri = EMFTOCSP_TEMPPROJECT + IPath.SEPARATOR + EMFTOCSP_TEMPFOLDER + IPath.SEPARATOR + modelTypeName + MMINT.MODEL_FILEEXTENSION_SEPARATOR + EcorePackage.eNAME;
		Resource flatResource = flatResourceSet.createResource(URI.createPlatformResourceURI(flatUri, true));
		EPackage flatModelTypeObj = EcoreUtil.copy(modelTypeObj);
		flatResource.getContents().add(flatModelTypeObj);
		flattenEPackage(flatModelTypeObj);
		EAnnotation newEAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		newEAnnotation.setSource(EcorePackage.eNS_URI);
		EMap<String, String> newEAnnotationDetails = newEAnnotation.getDetails();
		newEAnnotationDetails.put(MultiModelTypeFactory.ECORE_VALIDATION_DELEGATE, MultiModelTypeFactory.ECORE_PIVOT_URI);
		flatModelTypeObj.getEAnnotations().add(newEAnnotation);
		EClass modelTypeRootObj = (EClass) flatModelTypeObj.getEClassifiers().get(0);
		newEAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		newEAnnotation.setSource(EcorePackage.eNS_URI);
		newEAnnotationDetails = newEAnnotation.getDetails();
		newEAnnotationDetails.put(MultiModelTypeFactory.ECORE_VALIDATION_CONSTRAINTS, ECORE_PIVOT_CONSISTENCYCONSTRAINT);
		modelTypeRootObj.getEAnnotations().add(newEAnnotation);
		newEAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		newEAnnotation.setSource(MultiModelTypeFactory.ECORE_PIVOT_URI);
		newEAnnotationDetails = newEAnnotation.getDetails();
		newEAnnotationDetails.put(ECORE_PIVOT_CONSISTENCYCONSTRAINT, oclConsistencyConstraint);
		modelTypeRootObj.getEAnnotations().add(newEAnnotation);
		// use EMFtoCSP to check strong satisfiability
		EPackage modelTypeObjToRestore = EPackage.Registry.INSTANCE.getEPackage(flatModelTypeObj.getNsURI()); // EMFtoCSP will mess this up, save it to restore later
		// EMFtoCSP ui screen 4 (preview)
		IProject tempProject = ResourcesPlugin.getWorkspace().getRoot().getProject(EMFTOCSP_TEMPPROJECT);
		IFolder resultLocation;
		try {
			if (!tempProject.exists()) {
				tempProject.create(null);
			}
			if (!tempProject.isOpen()) {
				tempProject.open(null);
			}
			resultLocation = tempProject.getFolder(EMFTOCSP_TEMPFOLDER);
			if (!resultLocation.exists()) {
				resultLocation.create(true, true, null);
			}
			MultiModelUtils.writeModelFile(flatModelTypeObj, flatUri, true);
		}
		catch (Exception e) {
			MMINTException.print(IStatus.WARNING, "Can't create EMFtoCSP temporary project, skipping consistency check", e);
			cleanupCheckOCLConstraintConsistency(tempProject);
			return true;
		}
		// EMFtoCSP init
		String eclipsePath = Activator.getDefault().getPreferenceStore().getString(EMFTOCSP_PREFERENCE_ECLIPSEPATH);
		String graphvizPath = Activator.getDefault().getPreferenceStore().getString(EMFTOCSP_PREFERENCE_GRAPHVIZPATH);
		ICspSolver<?> solver = new EclipseSolver(eclipsePath, graphvizPath);
		IModelToCspSolverFactory<Resource, CompoundTerm> modelSolverFactory = new EmfModelToCspSolverFactory();
		IModelToCspSolver<Resource, CompoundTerm> modelSolver = modelSolverFactory.getModelToCspSolver();
		modelSolver.setModelFileName(modelTypeName);
		modelSolver.setModel(flatModelTypeObj.eResource());
		modelSolver.setSolver(solver);
		modelSolver.setCspCodeGenerator(new EmfToEclCodeGenerator(modelSolver));
		modelSolver.getBuilder();
		// EMFtoCSP ui screen 1
		IFile oclFile = null;
		modelSolver.setConstraintsDocument(oclFile);
		// EMFtoCSP ui screen 2
		Map<String, String> modelElementsDomain = new HashMap<String, String>();
		modelSolver.setModelElementsDomain(modelElementsDomain);
		@SuppressWarnings("unchecked")
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
		// EMFtoCSP ui screen 4 (reprise)
		modelSolver.setResultLocation(resultLocation);
		// EMFtoCSP performFinish()
		File importsFolder;
		try {
			importsFolder = new File(FileLocator.toFileURL(FrameworkUtil.getBundle(fr.inria.atlanmod.emftocsp.eclipsecs.EclipseSolver.class).getEntry("/libs")).getFile());
		}
		catch (Exception e) {
			MMINTException.print(IStatus.WARNING, "Can't find EMFtoCSP libs, skipping consistency check", e);
			cleanupCheckOCLConstraintConsistency(tempProject);
			return true;
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
		boolean isConsistent = true;
		try {
			isConsistent = modelSolver.solveModel(libList);
		}
		catch (ProcessingException e) {
			MMINTException.print(IStatus.WARNING, "EMFtoCSP processing error, skipping consistency check", e);
		}
		finally {
			EPackage.Registry.INSTANCE.put(flatModelTypeObj.getNsURI(), modelTypeObjToRestore); // EMFtoCSP messed this up, restore it
			cleanupCheckOCLConstraintConsistency(tempProject);
		}

		return isConsistent;
	}

}

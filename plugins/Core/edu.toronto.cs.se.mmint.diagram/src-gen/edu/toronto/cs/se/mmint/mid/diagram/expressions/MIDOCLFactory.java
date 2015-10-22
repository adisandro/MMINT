/*
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
package edu.toronto.cs.se.mmint.mid.diagram.expressions;

import java.util.Collections;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.options.ParsingOptions;

import edu.toronto.cs.se.mmint.mid.diagram.part.MIDDiagramEditorPlugin;

/**
 * @generated
 */
public class MIDOCLFactory {

	/**
	* @generated
	*/
	private final MIDAbstractExpression[] expressions;

	/**
	* @generated
	*/
	private final String[] expressionBodies;

	/**
	* @generated
	*/
	protected MIDOCLFactory() {
		this.expressions = new MIDAbstractExpression[6];
		this.expressionBodies = new String[] {
				"not self.oclIsKindOf(relationship::ModelRel) and self.origin = ModelOrigin::CREATED", //$NON-NLS-1$
				"not self.oclIsKindOf(relationship::ModelRel) and self.origin = ModelOrigin::IMPORTED", //$NON-NLS-1$
				"not self.oclIsKindOf(relationship::BinaryModelRel) and self.origin = ModelOrigin::CREATED", //$NON-NLS-1$
				"not self.oclIsKindOf(relationship::BinaryModelRel) and self.origin = ModelOrigin::IMPORTED", //$NON-NLS-1$
				"not self.oclIsKindOf(relationship::BinaryModelRel)", //$NON-NLS-1$
				"self.oclIsKindOf(Model)", //$NON-NLS-1$
		};
	}

	/**
	* @generated
	*/
	private static MIDOCLFactory getInstance() {
		MIDOCLFactory instance = MIDDiagramEditorPlugin.getInstance().getMIDOCLFactory();
		if (instance == null) {
			MIDDiagramEditorPlugin.getInstance().setMIDOCLFactory(instance = new MIDOCLFactory());
		}
		return instance;
	}

	/**
	* @generated
	*/
	public static String getExpressionBody(int index) {
		return getInstance().expressionBodies[index];
	}

	/**
	* @generated
	*/
	public static MIDAbstractExpression getExpression(
			int index, EClassifier context, Map<String, EClassifier> environment) {
		MIDOCLFactory cached = getInstance();
		if (index < 0 || index >= cached.expressions.length) {
			throw new IllegalArgumentException();
		}
		if (cached.expressions[index] == null) {
			cached.expressions[index] = getExpression(
				cached.expressionBodies[index],
				context,
				environment == null ? Collections.<String, EClassifier> emptyMap() : environment);
		}
		return cached.expressions[index];
	}

	/**
	* This is factory method, callers are responsible to keep reference to the return value if they want to reuse parsed expression
	* @generated
	*/
	public static MIDAbstractExpression getExpression(
			String body, EClassifier context, Map<String, EClassifier> environment) {
		return new Expression(body, context, environment);
	}

	/**
	* This method will become private in the next release
	* @generated
	*/
	public static MIDAbstractExpression getExpression(String body, EClassifier context) {
		return getExpression(body, context, Collections.<String, EClassifier> emptyMap());
	}

	/**
	* @generated
	*/
	private static class Expression extends MIDAbstractExpression {

		/**
		* @generated
		*/
		private final org.eclipse.ocl.ecore.OCL oclInstance;

		/**
		* @generated
		*/
		private OCLExpression oclExpression;

		/**
		* @generated
		*/
		public Expression(String body, EClassifier context, Map<String, EClassifier> environment) {
			super(body, context);
			oclInstance = org.eclipse.ocl.ecore.OCL.newInstance();
			initCustomEnv(oclInstance.getEnvironment(), environment);
			Helper oclHelper = oclInstance.createOCLHelper();
			oclHelper.setContext(context());
			try {
				oclExpression = oclHelper.createQuery(body());
				setStatus(IStatus.OK, null, null);
			}
			catch (ParserException e) {
				setStatus(IStatus.ERROR, e.getMessage(), e);
			}
		}

		/**
		* @generated
		*/
		@SuppressWarnings("rawtypes")
		protected Object doEvaluate(Object context, Map env) {
			if (oclExpression == null) {
				return null;
			}
			// on the first call, both evalEnvironment and extentMap are clear, for later we have finally, below.
			EvaluationEnvironment<?, ?, ?, ?, ?> evalEnv = oclInstance.getEvaluationEnvironment();
			// initialize environment
			for (Object nextKey : env.keySet()) {
				evalEnv.replace((String) nextKey, env.get(nextKey));
			}
			try {
				Object result = oclInstance.evaluate(context, oclExpression);
				return oclInstance.isInvalid(result) ? null : result;
			}
			finally {
				evalEnv.clear();
				oclInstance.setExtentMap(null); // clear allInstances cache, and get the oclInstance ready for the next call
			}
		}

		/**
		* @generated
		*/
		private static void initCustomEnv(
				Environment<?, EClassifier, ?, ?, ?, EParameter, ?, ?, ?, ?, ?, ?> ecoreEnv,
				Map<String, EClassifier> environment) {
			// Use EObject as implicit root class for any object, to allow eContainer() and other EObject operations from OCL expressions
			ParsingOptions
				.setOption(ecoreEnv, ParsingOptions.implicitRootClass(ecoreEnv), EcorePackage.eINSTANCE.getEObject());
			for (String varName : environment.keySet()) {
				EClassifier varType = environment.get(varName);
				ecoreEnv.addElement(varName, createVar(ecoreEnv, varName, varType), false);
			}
		}

		/**
		* @generated
		*/
		private static Variable createVar(
				Environment<?, EClassifier, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> ecoreEnv, String name, EClassifier type) {
			Variable var = EcoreFactory.eINSTANCE.createVariable();
			var.setName(name);
			var.setType(ecoreEnv.getUMLReflection().getOCLType(type));
			return var;
		}
	}
}

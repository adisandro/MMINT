/*
 * Copyright (c) 2012-2025 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.relationship.diagram.expressions;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.util.EcoreUtil;

import edu.toronto.cs.se.mmint.mid.relationship.diagram.part.MIDDiagramEditorPlugin;

/**
 * @generated
 */
public abstract class MIDAbstractExpression {

	/**
	* @generated
	*/
	private IStatus status = Status.OK_STATUS;

	/**
	* @generated
	*/
	protected void setStatus(int severity, String message, Throwable throwable) {
		String pluginID = MIDDiagramEditorPlugin.ID;
		this.status = new Status(severity, pluginID, -1, (message != null) ? message : "", throwable); //$NON-NLS-1$
		if (!this.status.isOK()) {
			MIDDiagramEditorPlugin.getInstance().logError("Expression problem:" + message + "body:" + body(), //$NON-NLS-1$//$NON-NLS-2$
					throwable);
		}
	}

	/**
	* @generated
	*/
	public IStatus getStatus() {
		return status;
	}

	/**
	* @generated
	*/
	private final String myBody;

	/**
	* @generated
	*/
	public String body() {
		return myBody;
	}

	/**
	* @generated
	*/
	private final EClassifier myContext;

	/**
	* @generated
	*/
	public EClassifier context() {
		return myContext;
	}

	/**
	* @generated
	*/
	protected MIDAbstractExpression(String body, EClassifier context) {
		myBody = body;
		myContext = context;
	}

	/**
	* @generated
	*/
	@SuppressWarnings("rawtypes")
	protected abstract Object doEvaluate(Object context, Map env);

	/**
	* @generated
	*/
	public Object evaluate(Object context) {
		return evaluate(context, Collections.EMPTY_MAP);
	}

	/**
	* @generated
	*/
	@SuppressWarnings("rawtypes")
	public Object evaluate(Object context, Map env) {
		if (context().isInstance(context)) {
			try {
				return doEvaluate(context, env);
			} catch (Exception e) {
				MIDDiagramEditorPlugin.getInstance().logError("Expression evaluation failure: " + body(), e); //$NON-NLS-1$
			}
		}
		return null;
	}

	/**
	* Expression may return number value which is not directly compatible with feature type (e.g. Double when Integer is expected), or EEnumLiteral meta-object when literal instance is expected
	* @generated
	*/
	public static Object performCast(Object value, EDataType targetType) {
		if (targetType instanceof EEnum) {
			if (value instanceof EEnumLiteral) {
				EEnumLiteral literal = (EEnumLiteral) value;
				return (literal.getInstance() != null) ? literal.getInstance() : literal;
			}
		}
		if (false == value instanceof Number || targetType == null || targetType.getInstanceClass() == null) {
			return value;
		}
		Class<?> targetClass = targetType.getInstanceClass();
		Number num = (Number) value;
		Class<?> valClass = value.getClass();
		Class<?> targetWrapperClass = targetClass;
		if (targetClass.isPrimitive()) {
			targetWrapperClass = EcoreUtil.wrapperClassFor(targetClass);
		}
		if (valClass.equals(targetWrapperClass)) {
			return value;
		}
		if (Number.class.isAssignableFrom(targetWrapperClass)) {
			if (targetWrapperClass.equals(Byte.class))
				return new Byte(num.byteValue());
			if (targetWrapperClass.equals(Integer.class))
				return new Integer(num.intValue());
			if (targetWrapperClass.equals(Short.class))
				return new Short(num.shortValue());
			if (targetWrapperClass.equals(Long.class))
				return new Long(num.longValue());
			if (targetWrapperClass.equals(BigInteger.class))
				return BigInteger.valueOf(num.longValue());
			if (targetWrapperClass.equals(Float.class))
				return new Float(num.floatValue());
			if (targetWrapperClass.equals(Double.class))
				return new Double(num.doubleValue());
			if (targetWrapperClass.equals(BigDecimal.class))
				return new BigDecimal(num.doubleValue());
		}
		return value;
	}

}

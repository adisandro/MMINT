/**
 * Copyright (c) 2012-2023 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl;

import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Attribute;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.AttributeReference;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ClassReference;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOFactory;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.NamedElement;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Operation;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.OperationReference;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SequenceDiagram;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SourceLifelineReference;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.TargetLifelineReference;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ICSE15_SequenceDiagram_MAVOFactoryImpl extends EFactoryImpl implements ICSE15_SequenceDiagram_MAVOFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ICSE15_SequenceDiagram_MAVOFactory init() {
		try {
			ICSE15_SequenceDiagram_MAVOFactory theICSE15_SequenceDiagram_MAVOFactory = (ICSE15_SequenceDiagram_MAVOFactory)EPackage.Registry.INSTANCE.getEFactory(ICSE15_SequenceDiagram_MAVOPackage.eNS_URI);
			if (theICSE15_SequenceDiagram_MAVOFactory != null) {
				return theICSE15_SequenceDiagram_MAVOFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ICSE15_SequenceDiagram_MAVOFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ICSE15_SequenceDiagram_MAVOFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ICSE15_SequenceDiagram_MAVOPackage.SEQUENCE_DIAGRAM: return createSequenceDiagram();
			case ICSE15_SequenceDiagram_MAVOPackage.NAMED_ELEMENT: return createNamedElement();
			case ICSE15_SequenceDiagram_MAVOPackage.LIFELINE: return createLifeline();
			case ICSE15_SequenceDiagram_MAVOPackage.CLASS: return createClass();
			case ICSE15_SequenceDiagram_MAVOPackage.ATTRIBUTE: return createAttribute();
			case ICSE15_SequenceDiagram_MAVOPackage.OPERATION: return createOperation();
			case ICSE15_SequenceDiagram_MAVOPackage.MESSAGE: return createMessage();
			case ICSE15_SequenceDiagram_MAVOPackage.CLASS_REFERENCE: return createClassReference();
			case ICSE15_SequenceDiagram_MAVOPackage.ATTRIBUTE_REFERENCE: return createAttributeReference();
			case ICSE15_SequenceDiagram_MAVOPackage.OPERATION_REFERENCE: return createOperationReference();
			case ICSE15_SequenceDiagram_MAVOPackage.SOURCE_LIFELINE_REFERENCE: return createSourceLifelineReference();
			case ICSE15_SequenceDiagram_MAVOPackage.TARGET_LIFELINE_REFERENCE: return createTargetLifelineReference();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceDiagram createSequenceDiagram() {
		SequenceDiagramImpl sequenceDiagram = new SequenceDiagramImpl();
		return sequenceDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement createNamedElement() {
		NamedElementImpl namedElement = new NamedElementImpl();
		return namedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Lifeline createLifeline() {
		LifelineImpl lifeline = new LifelineImpl();
		return lifeline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Class createClass() {
		ClassImpl class_ = new ClassImpl();
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute createAttribute() {
		AttributeImpl attribute = new AttributeImpl();
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation createOperation() {
		OperationImpl operation = new OperationImpl();
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Message createMessage() {
		MessageImpl message = new MessageImpl();
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassReference createClassReference() {
		ClassReferenceImpl classReference = new ClassReferenceImpl();
		return classReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeReference createAttributeReference() {
		AttributeReferenceImpl attributeReference = new AttributeReferenceImpl();
		return attributeReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationReference createOperationReference() {
		OperationReferenceImpl operationReference = new OperationReferenceImpl();
		return operationReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceLifelineReference createSourceLifelineReference() {
		SourceLifelineReferenceImpl sourceLifelineReference = new SourceLifelineReferenceImpl();
		return sourceLifelineReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetLifelineReference createTargetLifelineReference() {
		TargetLifelineReferenceImpl targetLifelineReference = new TargetLifelineReferenceImpl();
		return targetLifelineReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ICSE15_SequenceDiagram_MAVOPackage getICSE15_SequenceDiagram_MAVOPackage() {
		return (ICSE15_SequenceDiagram_MAVOPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ICSE15_SequenceDiagram_MAVOPackage getPackage() {
		return ICSE15_SequenceDiagram_MAVOPackage.eINSTANCE;
	}

} //ICSE15_SequenceDiagram_MAVOFactoryImpl

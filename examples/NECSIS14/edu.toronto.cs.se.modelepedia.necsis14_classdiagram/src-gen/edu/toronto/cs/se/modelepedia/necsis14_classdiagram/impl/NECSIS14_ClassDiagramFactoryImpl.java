/**
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
package edu.toronto.cs.se.modelepedia.necsis14_classdiagram.impl;

import edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Association;
import edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Attribute;
import edu.toronto.cs.se.modelepedia.necsis14_classdiagram.ClassDiagram;
import edu.toronto.cs.se.modelepedia.necsis14_classdiagram.NECSIS14_ClassDiagramFactory;
import edu.toronto.cs.se.modelepedia.necsis14_classdiagram.NECSIS14_ClassDiagramPackage;

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
public class NECSIS14_ClassDiagramFactoryImpl extends EFactoryImpl implements NECSIS14_ClassDiagramFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static NECSIS14_ClassDiagramFactory init() {
		try {
			NECSIS14_ClassDiagramFactory theNECSIS14_ClassDiagramFactory = (NECSIS14_ClassDiagramFactory)EPackage.Registry.INSTANCE.getEFactory(NECSIS14_ClassDiagramPackage.eNS_URI);
			if (theNECSIS14_ClassDiagramFactory != null) {
				return theNECSIS14_ClassDiagramFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new NECSIS14_ClassDiagramFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NECSIS14_ClassDiagramFactoryImpl() {
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
			case NECSIS14_ClassDiagramPackage.CLASS_DIAGRAM: return createClassDiagram();
			case NECSIS14_ClassDiagramPackage.CLASS: return createClass();
			case NECSIS14_ClassDiagramPackage.ASSOCIATION: return createAssociation();
			case NECSIS14_ClassDiagramPackage.ATTRIBUTE: return createAttribute();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassDiagram createClassDiagram() {
		ClassDiagramImpl classDiagram = new ClassDiagramImpl();
		return classDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Class createClass() {
		ClassImpl class_ = new ClassImpl();
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Association createAssociation() {
		AssociationImpl association = new AssociationImpl();
		return association;
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
	public NECSIS14_ClassDiagramPackage getNECSIS14_ClassDiagramPackage() {
		return (NECSIS14_ClassDiagramPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static NECSIS14_ClassDiagramPackage getPackage() {
		return NECSIS14_ClassDiagramPackage.eINSTANCE;
	}

} //NECSIS14_ClassDiagramFactoryImpl

/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl;

import edu.toronto.cs.se.modelepedia.classdiagram_mavo.Association;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.Attribute;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOFactory;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.Dependency;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.NestedInReference;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.Operation;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.SuperclassReference;
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
public class ClassDiagram_MAVOFactoryImpl extends EFactoryImpl implements ClassDiagram_MAVOFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ClassDiagram_MAVOFactory init() {
		try {
			ClassDiagram_MAVOFactory theClassDiagram_MAVOFactory = (ClassDiagram_MAVOFactory)EPackage.Registry.INSTANCE.getEFactory(ClassDiagram_MAVOPackage.eNS_URI);
			if (theClassDiagram_MAVOFactory != null) {
				return theClassDiagram_MAVOFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ClassDiagram_MAVOFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassDiagram_MAVOFactoryImpl() {
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
			case ClassDiagram_MAVOPackage.CLASS_DIAGRAM: return createClassDiagram();
			case ClassDiagram_MAVOPackage.CLASS: return createClass();
			case ClassDiagram_MAVOPackage.ATTRIBUTE: return createAttribute();
			case ClassDiagram_MAVOPackage.OPERATION: return createOperation();
			case ClassDiagram_MAVOPackage.DEPENDENCY: return createDependency();
			case ClassDiagram_MAVOPackage.ASSOCIATION: return createAssociation();
			case ClassDiagram_MAVOPackage.NESTED_IN_REFERENCE: return createNestedInReference();
			case ClassDiagram_MAVOPackage.SUPERCLASS_REFERENCE: return createSuperclassReference();
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
	public edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class createClass() {
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
	public Dependency createDependency() {
		DependencyImpl dependency = new DependencyImpl();
		return dependency;
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
	public NestedInReference createNestedInReference() {
		NestedInReferenceImpl nestedInReference = new NestedInReferenceImpl();
		return nestedInReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SuperclassReference createSuperclassReference() {
		SuperclassReferenceImpl superclassReference = new SuperclassReferenceImpl();
		return superclassReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassDiagram_MAVOPackage getClassDiagram_MAVOPackage() {
		return (ClassDiagram_MAVOPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ClassDiagram_MAVOPackage getPackage() {
		return ClassDiagram_MAVOPackage.eINSTANCE;
	}

} //ClassDiagram_MAVOFactoryImpl

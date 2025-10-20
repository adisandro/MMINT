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
package edu.toronto.cs.se.mmint.mid.relationship.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import edu.toronto.cs.se.mmint.mid.relationship.BinaryMapping;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipFactory;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RelationshipFactoryImpl extends EFactoryImpl implements RelationshipFactory {
    /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public static RelationshipFactory init() {
    try {
      var theRelationshipFactory = (RelationshipFactory)EPackage.Registry.INSTANCE.getEFactory(RelationshipPackage.eNS_URI);
      if (theRelationshipFactory != null) {
        return theRelationshipFactory;
      }
    }
    catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new RelationshipFactoryImpl();
  }

    /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public RelationshipFactoryImpl() {
    super();
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EObject create(EClass eClass) {
    return switch (eClass.getClassifierID()) {
    case RelationshipPackage.MODEL_REL -> createModelRel();
    case RelationshipPackage.BINARY_MODEL_REL -> createBinaryModelRel();
    case RelationshipPackage.MODEL_ENDPOINT_REFERENCE -> createModelEndpointReference();
    case RelationshipPackage.MODEL_ELEMENT_REFERENCE -> createModelElementReference();
    case RelationshipPackage.MAPPING -> createMapping();
    case RelationshipPackage.BINARY_MAPPING -> createBinaryMapping();
    case RelationshipPackage.MODEL_ELEMENT_ENDPOINT -> createModelElementEndpoint();
    case RelationshipPackage.MAPPING_REFERENCE -> createMappingReference();
    case RelationshipPackage.BINARY_MAPPING_REFERENCE -> createBinaryMappingReference();
    case RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE -> createModelElementEndpointReference();
    default -> throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    };
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public ModelRel createModelRel() {
    ModelRelImpl modelRel = new ModelRelImpl();
    return modelRel;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public BinaryModelRel createBinaryModelRel() {
    BinaryModelRelImpl binaryModelRel = new BinaryModelRelImpl();
    return binaryModelRel;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public ModelEndpointReference createModelEndpointReference() {
    ModelEndpointReferenceImpl modelEndpointReference = new ModelEndpointReferenceImpl();
    return modelEndpointReference;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public ModelElementReference createModelElementReference() {
    ModelElementReferenceImpl modelElementReference = new ModelElementReferenceImpl();
    return modelElementReference;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public Mapping createMapping() {
    MappingImpl mapping = new MappingImpl();
    return mapping;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public BinaryMapping createBinaryMapping() {
    BinaryMappingImpl binaryMapping = new BinaryMappingImpl();
    return binaryMapping;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public ModelElementEndpoint createModelElementEndpoint() {
    ModelElementEndpointImpl modelElementEndpoint = new ModelElementEndpointImpl();
    return modelElementEndpoint;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public MappingReference createMappingReference() {
    MappingReferenceImpl mappingReference = new MappingReferenceImpl();
    return mappingReference;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public BinaryMappingReference createBinaryMappingReference() {
    BinaryMappingReferenceImpl binaryMappingReference = new BinaryMappingReferenceImpl();
    return binaryMappingReference;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public ModelElementEndpointReference createModelElementEndpointReference() {
    ModelElementEndpointReferenceImpl modelElementEndpointReference = new ModelElementEndpointReferenceImpl();
    return modelElementEndpointReference;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public RelationshipPackage getRelationshipPackage() {
    return (RelationshipPackage)getEPackage();
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
    @Deprecated
    public static RelationshipPackage getPackage() {
    return RelationshipPackage.eINSTANCE;
  }

} //RelationshipFactoryImpl

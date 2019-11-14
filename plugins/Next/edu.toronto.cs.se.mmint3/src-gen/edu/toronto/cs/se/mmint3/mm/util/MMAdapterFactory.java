/**
 */
package edu.toronto.cs.se.mmint3.mm.util;

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import edu.toronto.cs.se.mmint3.mm.Element;
import edu.toronto.cs.se.mmint3.mm.Instance;
import edu.toronto.cs.se.mmint3.mm.InstanceMegaModel;
import edu.toronto.cs.se.mmint3.mm.MMElement;
import edu.toronto.cs.se.mmint3.mm.MMInstance;
import edu.toronto.cs.se.mmint3.mm.MMPackage;
import edu.toronto.cs.se.mmint3.mm.MMType;
import edu.toronto.cs.se.mmint3.mm.MegaModel;
import edu.toronto.cs.se.mmint3.mm.Model;
import edu.toronto.cs.se.mmint3.mm.ModelInstance;
import edu.toronto.cs.se.mmint3.mm.ModelType;
import edu.toronto.cs.se.mmint3.mm.Type;
import edu.toronto.cs.se.mmint3.mm.TypeMegaModel;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter <code>createXXX</code>
 * method for each class of the model. <!-- end-user-doc -->
 *
 * @see edu.toronto.cs.se.mmint3.mm.MMPackage
 * @generated
 */
public class MMAdapterFactory extends AdapterFactoryImpl {
  /**
   * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected static MMPackage modelPackage;

  /**
   * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public MMAdapterFactory() {
    if (MMAdapterFactory.modelPackage == null) {
      MMAdapterFactory.modelPackage = MMPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object. <!-- begin-user-doc --> This implementation
   * returns <code>true</code> if the object is either the model's package or is an instance object of the model. <!--
   * end-user-doc -->
   *
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object) {
    if (object == MMAdapterFactory.modelPackage) {
      return true;
    }
    if (object instanceof EObject) {
      return ((EObject) object).eClass().getEPackage() == MMAdapterFactory.modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected MMSwitch<Adapter> modelSwitch = new MMSwitch<>() {
    @Override
    public Adapter caseMegaModel(MegaModel object) {
      return createMegaModelAdapter();
    }

    @Override
    public Adapter caseMMElement(MMElement object) {
      return createMMElementAdapter();
    }

    @Override
    public Adapter caseTypeMegaModel(TypeMegaModel object) {
      return createTypeMegaModelAdapter();
    }

    @Override
    public Adapter caseInstanceMegaModel(InstanceMegaModel object) {
      return createInstanceMegaModelAdapter();
    }

    @Override
    public Adapter caseModel(Model object) {
      return createModelAdapter();
    }

    @Override
    public Adapter caseModelType(ModelType object) {
      return createModelTypeAdapter();
    }

    @Override
    public Adapter caseModelInstance(ModelInstance object) {
      return createModelInstanceAdapter();
    }

    @Override
    public Adapter caseMMInstance(MMInstance object) {
      return createMMInstanceAdapter();
    }

    @Override
    public Adapter caseMMType(MMType object) {
      return createMMTypeAdapter();
    }

    @Override
    public Adapter caseInstance(Instance object) {
      return createInstanceAdapter();
    }

    @Override
    public Adapter caseElement(Element object) {
      return createElementAdapter();
    }

    @Override
    public Adapter caseType(Type object) {
      return createTypeAdapter();
    }

    @Override
    public Adapter caseEStringToElementMap(Map.Entry<String, Element> object) {
      return createEStringToElementMapAdapter();
    }

    @Override
    public Adapter caseInternalEObject(InternalEObject object) {
      return createInternalEObjectAdapter();
    }

    @Override
    public Adapter defaultCase(EObject object) {
      return createEObjectAdapter();
    }
  };

  /**
   * Creates an adapter for the <code>target</code>. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @param target
   *          the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target) {
    return this.modelSwitch.doSwitch((EObject) target);
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint3.mm.MegaModel <em>Mega Model</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint3.mm.MegaModel
   * @generated
   */
  public Adapter createMegaModelAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint3.mm.MMElement <em>Element</em>}'. <!--
   * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint3.mm.MMElement
   * @generated
   */
  public Adapter createMMElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint3.mm.TypeMegaModel <em>Type Mega
   * Model</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint3.mm.TypeMegaModel
   * @generated
   */
  public Adapter createTypeMegaModelAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint3.mm.InstanceMegaModel <em>Instance
   * Mega Model</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
   * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint3.mm.InstanceMegaModel
   * @generated
   */
  public Adapter createInstanceMegaModelAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint3.mm.Model <em>Model</em>}'. <!--
   * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint3.mm.Model
   * @generated
   */
  public Adapter createModelAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint3.mm.ModelType <em>Model Type</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint3.mm.ModelType
   * @generated
   */
  public Adapter createModelTypeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint3.mm.ModelInstance <em>Model
   * Instance</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
   * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint3.mm.ModelInstance
   * @generated
   */
  public Adapter createModelInstanceAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint3.mm.MMInstance <em>Instance</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint3.mm.MMInstance
   * @generated
   */
  public Adapter createMMInstanceAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint3.mm.MMType <em>Type</em>}'. <!--
   * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint3.mm.MMType
   * @generated
   */
  public Adapter createMMTypeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint3.mm.Instance <em>Instance</em>}'. <!--
   * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint3.mm.Instance
   * @generated
   */
  public Adapter createInstanceAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint3.mm.Element <em>Element</em>}'. <!--
   * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint3.mm.Element
   * @generated
   */
  public Adapter createElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.toronto.cs.se.mmint3.mm.Type <em>Type</em>}'. <!--
   * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see edu.toronto.cs.se.mmint3.mm.Type
   * @generated
   */
  public Adapter createTypeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>EString To Element Map</em>}'. <!--
   * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see java.util.Map.Entry
   * @generated
   */
  public Adapter createEStringToElementMapAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecore.InternalEObject <em>Internal
   * EObject</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
   * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   *
   * @return the new adapter.
   * @see org.eclipse.emf.ecore.InternalEObject
   * @generated
   */
  public Adapter createInternalEObjectAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for the default case. <!-- begin-user-doc --> This default implementation returns null. <!--
   * end-user-doc -->
   *
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter() {
    return null;
  }

} // MMAdapterFactory

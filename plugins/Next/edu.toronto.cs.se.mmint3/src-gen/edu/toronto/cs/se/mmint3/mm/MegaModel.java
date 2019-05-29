/**
 */
package edu.toronto.cs.se.mmint3.mm;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mega Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint3.mm.MegaModel#getModels <em>Models</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getMegaModel()
 * @model abstract="true"
 * @generated
 */
public interface MegaModel extends EObject {
  /**
   * Returns the value of the '<em><b>Models</b></em>' containment reference list.
   * The list contents are of type {@link edu.toronto.cs.se.mmint3.mm.Model}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Models</em>' containment reference list.
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getMegaModel_Models()
   * @model containment="true"
   * @generated
   */
  EList<Model> getModels();

} // MegaModel

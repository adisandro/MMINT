/**
 */
package edu.toronto.cs.se.mmint.types.gsn.productline.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNPackage;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNRelationshipDecorator;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.util.GSNBuilder;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relationship Decorator</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class PLGSNRelationshipDecoratorImpl extends PLGSNArgumentElementImpl implements PLGSNRelationshipDecorator {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PLGSNRelationshipDecoratorImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return PLGSNPackage.Literals.PLGSN_RELATIONSHIP_DECORATOR;
  }

  /**
   * @generated NOT
   */
  private void instantiateOptional(Class decorated, boolean isSupported, @Nullable String hint) {

  }

  /**
   * @generated NOT
   */
  private void instantiateChoice(Class decorated, boolean isSupported, int cardinality, @Nullable String hint) {

  }

  /**
   * @generated NOT
   */
  private void instantiateMultiple(Class decorated, boolean isSupported, int cardinality, @Nullable String hint,
                                   PLGSNTemplate template)
                                  throws MMINTException {
    var n = GSNBuilder.askForMultiple(decorated.getType().getName() + " " +
                                      decorated.getAttribute(GSNPackage.eINSTANCE.getArgumentElement_Id()), cardinality,
                                      hint);
    if (n == 1) { // fast path, equivalent to optional
      decorated.getReferences().addAll(
        getReferences().stream()
          .filter(r -> r.getType() != GSNPackage.eINSTANCE.getArgumentElement_Template())
          .toList());
    }
    else {
      for (var i = 0; i < n; i++) {
        var idSuffix = "." + (i+1);
        getReference(GSNPackage.eINSTANCE.getSupportable_SupportedBy());
      }
    }
  }

  /**
   * @generated NOT
   */
  @Override
  public void instantiate() throws Exception {
    var decorated = getEContainer();
    var cardinality = Integer.valueOf(getAttribute(GSNPackage.eINSTANCE.getRelationshipDecorator_Cardinality()));
    var isSupported = !getReference(GSNPackage.eINSTANCE.getSupportable_SupportedBy()).isEmpty();
    var hint = getAttribute(GSNPackage.eINSTANCE.getArgumentElement_Description());
    switch(getAttribute(GSNPackage.eINSTANCE.getRelationshipDecorator_Type())) {
      case "OPTIONAL" -> instantiateOptional(decorated, isSupported, hint);
      case "CHOICE" -> instantiateChoice(decorated, isSupported, cardinality, hint);
      case "MULTIPLE" -> instantiateMultiple(decorated, isSupported, cardinality, hint, null);
    }
    delete();
  }

  /**
   * @generated NOT
   */
  @Override
  public void validate() throws Exception {
    setAttribute(GSNPackage.eINSTANCE.getArgumentElement_Valid(), Boolean.FALSE.toString());
    throw new MMINTException("Relationship decorators must be instantiated");
  }

} //PLGSNRelationshipDecoratorImpl

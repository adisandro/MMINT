/**
 */
package edu.toronto.cs.se.mmint.types.gsn.productline.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNArgumentElement;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNPackage;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNRelationshipDecorator;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate;
import edu.toronto.cs.se.mmint.types.gsn.productline.util.PLGSNBuilder;
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
  private void _dropSubtree(PLGSNArgumentElement elem) {
    var gsn = GSNPackage.eINSTANCE;
    if (elem.instanceOf(gsn.getSupportable())) {
      elem.getReference(gsn.getSupportable_SupportedBy()).forEach(sb ->
        dropSubtree((PLGSNArgumentElement) sb.getReference(gsn.getSupportedBy_Target()).get(0)));
    }
    if (elem.instanceOf(gsn.getContextualizable())) {
      elem.getReference(gsn.getContextualizable_InContextOf()).forEach(ico ->
        dropSubtree((PLGSNArgumentElement) ico.getReference(gsn.getInContextOf_Context()).get(0)));
    }
    if (elem.instanceOf(gsn.getDecoratable())) {
      elem.getReference(gsn.getDecoratable_Decorators()).forEach(d ->
        _dropSubtree((PLGSNArgumentElement) d));
    }
  }

  /**
   * @generated NOT
   */
  private void dropSubtree(PLGSNArgumentElement elem) {
    elem.delete();
    _dropSubtree(elem);
  }

  /**
   * @generated NOT
   */
  private void _copySubtree(PLGSNArgumentElement elem, PLGSNArgumentElement copyElem, String idSuffix, Class safetyCase,
                            PLGSNTemplate template, PLGSNBuilder builder) {
    var gsn = GSNPackage.eINSTANCE;
    if (elem.instanceOf(gsn.getSupportable())) {
      for (var supportedBy : elem.getReference(gsn.getSupportable_SupportedBy())) {
        var copySupporter = copySubtree(
          (PLGSNArgumentElement) supportedBy.getReference(gsn.getSupportedBy_Target()).get(0), idSuffix, safetyCase,
          template, builder);
        builder.support(copyElem, copySupporter, supportedBy.getPresenceCondition());
      }
    }
    if (elem.instanceOf(gsn.getContextualizable())) {
      for (var inContextOf : elem.getReference(gsn.getContextualizable_InContextOf())) {
        var copyContextual = copySubtree(
          (PLGSNArgumentElement) inContextOf.getReference(gsn.getInContextOf_Context()).get(0), idSuffix, safetyCase,
          template, builder);
        builder.contextualize(copyElem, copyContextual, inContextOf.getPresenceCondition());
      }
    }
    if (elem.instanceOf(gsn.getDecoratable())) {
      for (var decorator : elem.getReference(gsn.getDecoratable_Decorators())) {
        var copyDecorator = copySubtree((PLGSNArgumentElement) decorator, idSuffix, safetyCase, template, builder);
        copyElem.addReference(builder.getContainmentType(copyDecorator), copyDecorator,
                              decorator.getPresenceCondition());
      }
    }
  }

  /**
   * @generated NOT
   */
  private PLGSNArgumentElement copySubtree(PLGSNArgumentElement elem, String idSuffix, Class safetyCase,
                                           PLGSNTemplate template, PLGSNBuilder builder) {
    var gsn = GSNPackage.eINSTANCE;
    var copyElem = EcoreUtil.copy(elem); // use it to copy attributes only
    copyElem.getReferences().clear();
    getProductLine().getClasses().add(copyElem);
    copyElem.setAttribute(gsn.getArgumentElement_Id(),
                          elem.getAttribute(gsn.getArgumentElement_Id()) + idSuffix);
    copyElem.setAttribute(gsn.getArgumentElement_TemplateId(),
                          elem.getAttribute(gsn.getArgumentElement_TemplateId()) + idSuffix);
    copyElem.setAttribute(gsn.getArgumentElement_Description(),
                          GSNBuilder.addSuffixToPlaceholders(
                            elem.getAttribute(gsn.getArgumentElement_Description()), idSuffix));
    if (!elem.instanceOf(gsn.getRelationshipDecorator())) {
      safetyCase.addReference(builder.getContainmentType(copyElem), copyElem);
    }
    template.addReference(gsn.getTemplate_Elements(), copyElem);
    _copySubtree(elem, copyElem, idSuffix, safetyCase, template, builder);

    return copyElem;
  }

  /**
   * @generated NOT
   */
  private void instantiateMultiple(PLGSNArgumentElement decorated, boolean isSupported, int cardinality,
                                   @Nullable String hint, PLGSNTemplate template) throws MMINTException {
    var gsn = GSNPackage.eINSTANCE;
    var n = GSNBuilder.askForMultiple(decorated.getType().getName() + " " +
                                      decorated.getAttribute(gsn.getArgumentElement_Id()), cardinality,
                                      hint);
    if (n == 1) { // fast path, equivalent to optional
      decorated.getReferences().addAll(
        getReferences().stream()
          .filter(r -> r.getType() != gsn.getArgumentElement_Template())
          .toList());
    }
    else {
      var pl = getProductLine();
      var builder = new PLGSNBuilder(pl);
      var safetyCase = pl.getRoot();
      for (var i = 0; i < n; i++) {
        var idSuffix = "." + (i+1);
        if (isSupported) {
          getReference(gsn.getSupportable_SupportedBy()).forEach(sb -> {
            var sub = copySubtree((PLGSNArgumentElement) sb.getReference(gsn.getSupportedBy_Target()).get(0),
                                  idSuffix, safetyCase, template, builder);
            builder.support(decorated, sub, sb.getPresenceCondition());
          });
        }
        else {
          getReference(gsn.getContextualizable_InContextOf()).forEach(ico -> {
            var sub = copySubtree((PLGSNArgumentElement) ico.getReference(gsn.getInContextOf_Context()).get(0),
                                  idSuffix, safetyCase, template, builder);
            builder.contextualize(decorated, sub, ico.getPresenceCondition());
          });
        }
      }
      if (isSupported) {
        getReference(gsn.getSupportable_SupportedBy()).forEach(sb ->
          dropSubtree((PLGSNArgumentElement) sb.getReference(gsn.getSupportedBy_Target()).get(0)));
      }
      else {
        getReference(gsn.getContextualizable_InContextOf()).forEach(ico ->
          dropSubtree((PLGSNArgumentElement) ico.getReference(gsn.getInContextOf_Context()).get(0)));
      }
    }
  }

  /**
   * @generated NOT
   */
  @Override
  public void instantiate() throws Exception {
    var gsn = GSNPackage.eINSTANCE;
    var decorated = (PLGSNArgumentElement) getEContainer();
    var isSupported = !getReference(gsn.getSupportable_SupportedBy()).isEmpty();
    var cardinality = Integer.valueOf(getAttribute(gsn.getRelationshipDecorator_Cardinality()));
    var hint = getAttribute(gsn.getArgumentElement_Description());
    var template = (PLGSNTemplate) getReference(gsn.getArgumentElement_Template()).get(0);
    switch(getAttribute(gsn.getRelationshipDecorator_Type())) {
      case "OPTIONAL" -> instantiateOptional(decorated, isSupported, hint);
      case "CHOICE" -> instantiateChoice(decorated, isSupported, cardinality, hint);
      case "MULTIPLE" -> instantiateMultiple(decorated, isSupported, cardinality, hint, template);
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

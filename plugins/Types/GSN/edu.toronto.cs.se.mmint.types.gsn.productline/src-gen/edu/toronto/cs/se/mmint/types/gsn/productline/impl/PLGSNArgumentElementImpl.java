/*******************************************************************************
 * Copyright (c) 2024, 2025 Alessio Di Sandro.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.mmint.types.gsn.productline.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.productline.PLFactory;
import edu.toronto.cs.se.mmint.productline.impl.ClassImpl;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNArgumentElement;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.ImpactType;
import edu.toronto.cs.se.modelepedia.gsn.util.GSNBuilder;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Argument Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class PLGSNArgumentElementImpl extends ClassImpl implements PLGSNArgumentElement {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PLGSNArgumentElementImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return PLGSNPackage.Literals.PLGSN_ARGUMENT_ELEMENT;
  }

  /**
   * @generated NOT
   */
  @Override
  public void instantiate() throws Exception {
    var title = "Instantiate placeholder text";
    //TODO abstract into function
    var node = getType().getName() + " " + String.join(",", getAttribute(GSNPackage.eINSTANCE.getArgumentElement_Id()));
    for (var attr : getAttributes()) {
      if (attr.getType() != GSNPackage.eINSTANCE.getArgumentElement_Description()) {
        continue;
      }
      while (true) {
        var desc = attr.getValue();
        var pattern = GSNBuilder.findPlaceholder(desc);
        if (pattern.isEmpty()) {
          break;
        }
        var toReplace = pattern.get();
        var msg = "Replace '" + toReplace + "' in " + node + " with:";
        var replacement = MIDDialogs.getStringInput(title, msg, null);
        attr.setValue(desc.replace(GSNBuilder.PATTERN1 + toReplace + GSNBuilder.PATTERN2, replacement));
      }
    }
  }

  /**
   * @generated NOT
   */
  @Override
  public void validate() throws Exception {
    var validAttrs = getAttributes().stream()
      .filter(a -> a.getType() == GSNPackage.eINSTANCE.getArgumentElement_Valid());
    if (getAttributes().stream()
          .filter(a -> a.getType() == GSNPackage.eINSTANCE.getArgumentElement_Description())
          .anyMatch(a -> GSNBuilder.findPlaceholder(a.getValue()).isPresent())) {
      //TODO abstract into function
      var node = getType().getName() + " " +
                 String.join(",", getAttribute(GSNPackage.eINSTANCE.getArgumentElement_Id()));
      validAttrs.forEach(a -> a.setValue(Boolean.FALSE.toString()));
      throw new MMINTException(node + " description contains placeholder text to be instantiated");
    }
    validAttrs.forEach(a -> a.setValue(Boolean.TRUE.toString()));
  }

  /**
   * @generated NOT
   */
  @Override
  public Map<ImpactType, Optional<String>> getImpact() {
    var impactMap = getStreamOfReference(GSNPackage.eINSTANCE.getArgumentElement_Status())
      .collect(Collectors.toMap(
        impact -> ImpactType.valueOf(impact.getAttribute(GSNPackage.eINSTANCE.getImpactAnnotation_Type()).get(0)),
        impact -> Optional.of(impact.getPresenceCondition())));
    ImpactType.VALUES.forEach(t -> impactMap.computeIfAbsent(t, _ -> Optional.empty()));

    return impactMap;
  }

  /**
   * @generated NOT
   */
  @Override
  public void setImpact(Map<ImpactType, Optional<String>> impactTypes) {
    if (impactTypes.size() != 3) {
      throw new IllegalArgumentException("All 3 impact types must be passed");
    }
    var addImpactTypes = new HashSet<>(ImpactType.VALUES);
    getStreamOfReference(GSNPackage.eINSTANCE.getArgumentElement_Status())
      .collect(Collectors.toList())
      .forEach(impact -> {
        var impactType = ImpactType.valueOf(impact.getAttribute(GSNPackage.eINSTANCE.getImpactAnnotation_Type()).get(0));
        impactTypes.get(impactType).ifPresentOrElse(pc -> impact.setPresenceCondition(pc), () -> impact.delete());
        addImpactTypes.remove(impactType);
      });
    addImpactTypes.forEach(t -> impactTypes.get(t).ifPresent(pc -> {
      var c = PLFactory.eINSTANCE.createClass();
      c.setPresenceCondition(pc);
      c.setType(GSNPackage.eINSTANCE.getImpactAnnotation());
      getProductLine().getClasses().add(c);
      c.addAttribute(GSNPackage.eINSTANCE.getImpactAnnotation_Type(), t.toString());
      addReference(GSNPackage.eINSTANCE.getArgumentElement_Status(), c);
    }));
  }

  /**
   * @generated NOT
   */
  @Override
  public void setImpact(ImpactType impactType) {
    var pc = "$true"; //TODO reasoner.getTrueLiteral()
    var impactTypes = switch (impactType) {
      case REUSE   -> Map.of(ImpactType.REUSE,   Optional.of(pc),
                             ImpactType.RECHECK, Optional.<String>empty(),
                             ImpactType.REVISE,  Optional.<String>empty());
      case RECHECK -> Map.of(ImpactType.REUSE,   Optional.<String>empty(),
                             ImpactType.RECHECK, Optional.of(pc),
                             ImpactType.REVISE,  Optional.<String>empty());
      case REVISE  -> Map.of(ImpactType.REUSE,   Optional.<String>empty(),
                             ImpactType.RECHECK, Optional.<String>empty(),
                             ImpactType.REVISE,  Optional.of(pc));
    };
    setImpact(impactTypes);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  @SuppressWarnings("unchecked")
  public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
    switch (operationID) {
      case PLGSNPackage.PLGSN_ARGUMENT_ELEMENT___INSTANTIATE:
        try {
          instantiate();
          return null;
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case PLGSNPackage.PLGSN_ARGUMENT_ELEMENT___VALIDATE:
        try {
          validate();
          return null;
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case PLGSNPackage.PLGSN_ARGUMENT_ELEMENT___GET_IMPACT:
        return getImpact();
      case PLGSNPackage.PLGSN_ARGUMENT_ELEMENT___SET_IMPACT__MAP:
        setImpact((Map<ImpactType, Optional<String>>)arguments.get(0));
        return null;
      case PLGSNPackage.PLGSN_ARGUMENT_ELEMENT___SET_IMPACT__IMPACTTYPE:
        setImpact((ImpactType)arguments.get(0));
        return null;
    }
    return super.eInvoke(operationID, arguments);
  }

} //GSNPLArgumentElementImpl

package edu.toronto.cs.se.mmint3.design.actions;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;

import edu.toronto.cs.se.mmint3.mm.InstanceMegaModel;
import edu.toronto.cs.se.mmint3.mm.MMFactory;

public class ModelInstanceCreate extends AbstractExternalJavaAction {

  @Override
  public boolean canExecute(Collection<? extends EObject> arg0) {
    return true;
  }

  @Override
  public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
    var mm = (InstanceMegaModel) arg1.get("mm");
    var type = MMFactory.eINSTANCE.createMMType();
    type.setId("ID");
    type.setName("NAME");
    var modelT = MMFactory.eINSTANCE.createModelType();
    modelT.setT(type);
    var modelPath = "/next/model.xmi";
    var model = modelT.createInstance(null, modelPath, false, mm);
  }

}

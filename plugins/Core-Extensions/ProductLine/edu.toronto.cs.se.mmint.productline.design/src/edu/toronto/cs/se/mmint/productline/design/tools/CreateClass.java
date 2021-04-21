package edu.toronto.cs.se.mmint.productline.design.tools;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.business.api.session.SessionManager;

import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.ProductLineFactory;

public class CreateClass extends AbstractExternalJavaAction {

  @Override
  public boolean canExecute(Collection<? extends EObject> arg0) {
    return true;
  }

  @Override
  public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
    var productLine = (ProductLine) arg0.iterator().next();
    var sSession = SessionManager.INSTANCE.getSession(productLine);
    var sDomain = sSession.getTransactionalEditingDomain();
    sDomain.getCommandStack().execute(new CreateClassCommand(sDomain, productLine));
  }

  private class CreateClassCommand extends RecordingCommand {
    private ProductLine productLine;

    public CreateClassCommand(TransactionalEditingDomain domain, ProductLine productLine) {
      super(domain);
      this.productLine = productLine;
    }

    @Override
    protected void doExecute() {
      try {
        var labelProvider = LabelProvider.createTextProvider(c -> ((EClass) c).getName());
        var contentProvider = new ArrayContentProvider();
        var classes = this.productLine.getMetamodel().getEClassifiers().stream()
          .filter(c -> c instanceof EClass)
          .map(c -> (EClass) c)
          .filter(c -> !c.isAbstract() && !c.isInterface())
          .toArray(EClass[]::new);
        var type = MIDDialogs.<EClass>openListDialog("Create Class", "Select Class", classes, contentProvider,
                                                     labelProvider);
        var clazz = ProductLineFactory.eINSTANCE.createClass();
        clazz.setType(type);
        this.productLine.getClasses().add(clazz);
      }
      catch (MIDDialogCancellation e) {
        // do nothing
      }
    }
  }
}

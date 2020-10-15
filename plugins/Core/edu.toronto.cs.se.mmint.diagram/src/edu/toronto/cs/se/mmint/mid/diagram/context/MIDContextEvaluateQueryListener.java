/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 *    Naama Ben-David - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.diagram.context;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.swt.events.SelectionEvent;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDContextMenuListener;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDDiagramUtils;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;

public class MIDContextEvaluateQueryListener extends MIDContextMenuListener {

  private EObject context;
  private List<? extends ExtendibleElement> queryArgs;

  public MIDContextEvaluateQueryListener(String menuLabel, EObject context,
                                         List<? extends ExtendibleElement> queryArgs) {
    super(menuLabel);
    this.context = context;
    this.queryArgs = queryArgs;
  }

  @Override
  public void widgetSelected(SelectionEvent e) {
    var command = new MIDContextEvaluateQueryCommand(TransactionUtil.getEditingDomain(this.context), this.menuLabel,
                                                     MIDDiagramUtils.getActiveInstanceMIDFiles());
    runListenerCommand(command);
  }

  protected class MIDContextEvaluateQueryCommand extends AbstractTransactionalCommand {

    public MIDContextEvaluateQueryCommand(TransactionalEditingDomain domain, String label, List<IFile> affectedFiles) {
      super(domain, label, affectedFiles);
    }

    @Override
    protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
      try {
        SiriusEvaluateQuery.runUI(MIDContextEvaluateQueryListener.this.context,
                                  MIDContextEvaluateQueryListener.this.queryArgs);
        return CommandResult.newOKCommandResult();
      }
      catch (MIDDialogCancellation e) {
        return CommandResult.newCancelledCommandResult();
      }
      catch (Exception e) {
        MMINTException.print(IStatus.ERROR, "Query evaluation failed", e);
        return CommandResult.newErrorCommandResult(e);
      }
    }

  }

}

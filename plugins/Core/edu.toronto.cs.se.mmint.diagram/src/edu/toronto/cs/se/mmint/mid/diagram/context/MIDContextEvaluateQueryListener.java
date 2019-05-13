/**
 * Copyright (c) 2012-2019 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDContextMenuListener;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDDiagramUtils;
import edu.toronto.cs.se.mmint.mid.reasoning.MIDConstraintChecker;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;

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

    private String prettyPrint(Object result) {
      if (result instanceof EObject) {
        try {
          var name = FileUtils.getModelObjectFeature((EObject) result, "name");
          if (name != null) {
            result = name;
          }
        }
        catch (MMINTException e) {}
      }
      return result.toString();
    }

    @Override
    protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
      try {
        var queryFilePath = MIDDialogs.selectQueryFileToEvaluate();
        var queryName = MIDDialogs.getStringInput("Evaluate query", "Insert query name to run", null);
        var queryResults = MIDConstraintChecker.evaluateQuery(queryFilePath, queryName,
                                                              MIDContextEvaluateQueryListener.this.context,
                                                              MIDContextEvaluateQueryListener.this.queryArgs);
        //TODO MMINT[QUERY] Display results in a better way (ui?)
        var printResults = new ArrayList<String>();
        for (var result : queryResults) {
          var printResult = (result instanceof Collection) ?
            ((Collection) result).stream().map(o -> prettyPrint(o)).collect(Collectors.toList()).toString() :
            prettyPrint(result);
          printResults.add(printResult);
        }
        Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
        MessageDialog.openInformation(shell, "Query Results", String.join("\n", printResults));
        return CommandResult.newOKCommandResult();
      }
      catch (MIDDialogCancellation e) {
        return CommandResult.newCancelledCommandResult();
      }
    }

  }

}

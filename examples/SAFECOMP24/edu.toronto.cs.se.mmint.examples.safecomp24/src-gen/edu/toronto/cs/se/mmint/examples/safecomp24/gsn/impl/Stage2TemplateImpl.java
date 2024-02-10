/*******************************************************************************
 * Copyright (c) 2024, 2024 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.examples.safecomp24.gsn.impl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EClass;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.examples.safecomp24.gsn.AMLASrPackage;
import edu.toronto.cs.se.mmint.examples.safecomp24.gsn.Stage2Template;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDDiagramUtils;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.types.gsn.templates.FilesContext;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.impl.TemplateImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stage2 Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class Stage2TemplateImpl extends TemplateImpl implements Stage2Template {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Stage2TemplateImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return AMLASrPackage.Literals.STAGE2_TEMPLATE;
  }

  /**
   * @generated NOT
   */
  @Override
  public void validate() throws Exception {
    super.validate();
    var gsnModel = MIDDiagramUtils.getInstanceMIDModelFromModelEditor(this);
    //TODO MMINT[SAFECOMP24] Use the already existing "files" directory for simplicity
    var workingPath = FileUtils.replaceLastSegmentInPath(gsnModel.getUri(), "files");
    var absWorkingPath = FileUtils.prependWorkspacePath(workingPath);
    var scopingTemplate = ((SafetyCase) eContainer()).getTemplates().stream()
      .filter(t -> t.getId().equals("ML Scoping"))
      .findFirst().get();
    var pyMain = Stream.concat(scopingTemplate.getElements().stream(), getElements().stream())
      .filter(e -> e instanceof FilesContext)
      .flatMap(c -> ((FilesContext) c).getPaths().stream())
      .map(p -> "from " + FileUtils.getFileNameFromPath(p) + " import *")
      .collect(Collectors.joining("\n"));
    pyMain += """
      \nif __name__ == '__main__':
          for req_rel in ReqRel:
              (sID, s_sat, rID, R_sat, relData) = req_rel
              print(s_sat(testset, model, model_accuracy))
              print(R_sat(relData, model, model_accuracy))""";
    Files.writeString(Path.of(absWorkingPath, "run_eval.py"), pyMain, StandardOpenOption.CREATE);
    final var RUN_FILE = "run.sh";
    var result = FileUtils.runShell(absWorkingPath, "bash", RUN_FILE);
    var lines = result.split("\n");
    var safeReq = Boolean.parseBoolean(lines[lines.length-3]);
    if (!safeReq) {
      throw new MMINTException("Safety requirement not satisfied");
    }
    var relReq = Boolean.parseBoolean(lines[lines.length-1]);
    if (!relReq) {
      throw new MMINTException("Reliability requirement not satisfied");
    }
    //TODO Invalidate nodes
  }

} //Stage1TemplateImpl

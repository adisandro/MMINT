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
import java.nio.file.Paths;
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
    final var MAIN_PY_FILE = "run_eval.py";
    final var RUN_SH_FILE = "run.sh";
    final var MAIN_PY = """
      \nif __name__ == '__main__':
          for req_rel in ReqRel:
              (sID, s_sat, rID, R_sat, relData) = req_rel
              print(s_sat(testset, model, model_accuracy))
              print(R_sat(relData, model, model_accuracy))""";
    final var RUN_SH = """
      python3 -m venv venv
      source venv/bin/activate
      pip3 install numpy albumentations matplotlib > /dev/null
      pip3 install torch torchvision --index-url https://download.pytorch.org/whl/cpu > /dev/null
      mkdir -p state_dicts
      wget -P state_dicts https://github.com/adisandro/adisandro.github.io/raw/main/files/resnet18.pt > /dev/null
      python3\s""" + MAIN_PY_FILE;
    var gsnModel = MIDDiagramUtils.getInstanceMIDModelFromModelEditor(this);
    //TODO MMINT[SAFECOMP24] Use the already existing "files" directory for simplicity
    var absWorkingPath = Paths.get(FileUtils.prependWorkspacePath(gsnModel.getUri()))
      .getParent().getParent().resolve("files").toString();
    var scopingTemplate = ((SafetyCase) eContainer()).getTemplates().stream()
      .filter(t -> t.getId().equals("ML Scoping"))
      .findFirst().get();
    var py = Stream.concat(scopingTemplate.getElements().stream(), getElements().stream())
      .filter(e -> e instanceof FilesContext)
      .flatMap(c -> ((FilesContext) c).getPaths().stream())
      .map(p -> "from " + FileUtils.getFileNameFromPath(p) + " import *")
      .collect(Collectors.joining("\n")) +
      MAIN_PY;
    Files.writeString(Path.of(absWorkingPath, MAIN_PY_FILE), py, StandardOpenOption.CREATE,
                      StandardOpenOption.TRUNCATE_EXISTING);
    Files.writeString(Path.of(absWorkingPath, RUN_SH_FILE), RUN_SH, StandardOpenOption.CREATE,
                      StandardOpenOption.TRUNCATE_EXISTING);
    var result = FileUtils.runShell(absWorkingPath, "bash", RUN_SH_FILE);
    var lines = result.split("\n");
    var safeOk = Boolean.parseBoolean(lines[lines.length-3]);
    //TODO MMINT[GSN] Find by id is tricky as they could be changed -> Add templateId to all template elements.
    if (!safeOk) {
      var safeGoal = getElements().stream().filter(e -> e.getId().equals("G2.92")).findFirst().get();
      safeGoal.setValid(false);
    }
    var relOk = Boolean.parseBoolean(lines[lines.length-1]);
    if (!relOk) {
      // TODO MMINT[SAFECOMP24] Handle multiple reliability requirements
      var relGoal = getElements().stream().filter(e -> e.getId().equals("G2.96")).findFirst().get();
      relGoal.setValid(false);
    }
    if (!safeOk && !relOk) {
      throw new MMINTException("Safety and reliability requirements not satisfied");
    }
    if (!safeOk) {
      throw new MMINTException("Safety requirement not satisfied");
    }
    if (!relOk) {
      throw new MMINTException("Reliability requirement not satisfied");
    }
  }

} //Stage1TemplateImpl

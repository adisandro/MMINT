package edu.toronto.cs.se.mmint.types.simulink.operators;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.operator.slice.AnnotateSlice;

public class SimulinkAnnotateSlice extends AnnotateSlice {

  @Override
  protected void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) {
    super.init(inputsByName, outputMIDsByName);
    this.output.filePath = FileUtils.replaceFileExtensionInPath(this.output.filePath, ".m");
  }

  @Override
  protected void annotate() throws Exception {
    var systemFilePath = FileUtils.prependWorkspacePath(this.output.filePath);
    try (var buffer = Files.newBufferedWriter(Paths.get(systemFilePath), Charset.forName("UTF-8"))) {
      buffer.write("r = ReachCoreach('TODO');");
      // TODO collect all mappings, use it as first argument
      buffer.write("r.reachAll({''}, []);");
    }
  }
}

package aspects.xpt.editor

import xpt.editor.Editor
import org.eclipse.gmf.codegen.gmfgen.GenEditorView

class MAVOEditor extends Editor {

	override extendsList(GenEditorView it) '''extends edu.toronto.cs.se.mmint.mavo.diagram.MAVODiagramEditor'''

}
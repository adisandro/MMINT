package edu.toronto.cs.se.mmtf.mid.diagram.edit.policies;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.notation.HintedDiagramLinkStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;

import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.ModelReferenceOpenDiagramCommand;

public class ModelReferenceOpenExternalDiagramEditPolicy extends ModelReferenceOpenDiagramEditPolicy {

	protected Command getOpenCommand(Request request) {

		EditPart targetEditPart = getTargetEditPart(request);
		if (false == targetEditPart.getModel() instanceof View) {
			return null;
		}
		View view = (View) targetEditPart.getModel();
		Style link = view.getStyle(NotationPackage.eINSTANCE
				.getHintedDiagramLinkStyle());
		if (false == link instanceof HintedDiagramLinkStyle) {
			return null;
		}
		return new ICommandProxy(new ModelReferenceOpenDiagramCommand(
				(HintedDiagramLinkStyle) link));
	}

}

package edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part;

import org.eclipse.swt.events.SelectionAdapter;
import edu.toronto.cs.se.mavo.MAVOAlternative;

public class MAVOAlternativeHighlightMenuListener extends SelectionAdapter {

	private MAVOAlternative alternative;
	
	public MAVOAlternativeHighlightMenuListener(MAVOAlternative alternative){
		this.alternative = alternative;
	}
}

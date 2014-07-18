package edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import edu.toronto.cs.se.mavo.LogicElement;
import edu.toronto.cs.se.mavo.MAVOModel;

public class MAVODecisionLabelProvider extends AdapterFactoryLabelProvider{

	public MAVODecisionLabelProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}
	
	@Override
	public String getText(Object object){
		String label;
		if (object instanceof MAVOModel){
			MAVOModel model = (MAVOModel) object;
			label = model.eResource().getURI().toString();
		}
		else if (object instanceof LogicElement){
			LogicElement element = (LogicElement) object;
			label = element.getFormulaVariable();
		}
		else {
			label = super.getText(object);
		}
		
		return label;
	}

}

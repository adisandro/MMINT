package edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;

import edu.toronto.cs.se.mavo.MAVOAlternative;
import edu.toronto.cs.se.mavo.MAVODecision;
import edu.toronto.cs.se.mavo.MAVOModel;

public class MAVODecisionTreeContentProvider extends AdapterFactoryContentProvider{

	public MAVODecisionTreeContentProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean hasChildren(Object object){
		boolean hasChildren = false;
		if (object instanceof MAVOModel){
			hasChildren = true;
		}
		else if (object instanceof MAVODecision){
			MAVODecision decision = (MAVODecision) object;
			if (!decision.getAlternatives().isEmpty()){
				hasChildren = true;
			}
		}
		else if (object instanceof MAVOAlternative){
			MAVOAlternative alternative = (MAVOAlternative) object;
			if (!alternative.getMavoElements().isEmpty()){
				hasChildren = true;
			}
		}
		
		return hasChildren;
	}
	
	@Override
	public Object[] getChildren(Object object){
		Object[] children;
		if (object instanceof MAVOModel){
			MAVOModel model = (MAVOModel) object;
			children = model.getDecisions().toArray();
		}
		else if (object instanceof MAVODecision){
			MAVODecision decision = (MAVODecision) object;
			children = decision.getAlternatives().toArray();
		}
		else if (object instanceof MAVOAlternative){
			MAVOAlternative alternative = (MAVOAlternative) object;
			children = alternative.getMavoElements().toArray();
		}
		else{
			children = super.getChildren(object);
		}
		return children;
	}

}

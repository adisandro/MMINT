package edu.toronto.cs.se.mmtf.mid.diagram.edit.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;

import edu.toronto.cs.se.mmtf.MMTFActivator;
import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MMTF.MMTFRegistry;
import edu.toronto.cs.se.mmtf.MMTFException.Type;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelTypeIntrospection;

public class SyncRepositoryHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		MultiModel root = null;
		try {			
			String path = MMTFActivator.getDefault().getStateLocation().toOSString();
			URI uri = URI.createFileURI(path+"/types.mid");
			root = (MultiModel) MultiModelTypeIntrospection.getRoot(uri);
		}
		catch (Exception e) {
			MMTFException.print(Type.WARNING, "Could not locate types.mid", e);
			return null;
		}
		
		MMTFRegistry.updateRepository(root);
		return null;
	}

}

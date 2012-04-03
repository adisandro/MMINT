package edu.toronto.cs.se.mmtf.mid.mapping.diagram.part;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mid.ModelReference;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingReference;

public class MappingDiagramOutlinePage extends ContentOutlinePage {

	protected TreeViewer contentOutlineViewer;
	protected ComposedAdapterFactory adapterFactory;
	protected Diagram diagram;

	public MappingDiagramOutlinePage(Diagram diagram) {

		super();

		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		this.diagram = diagram;
	}

	@Override
	public void createControl(Composite parent) {

		super.createControl(parent);

		contentOutlineViewer = getTreeViewer();
		contentOutlineViewer.addSelectionChangedListener(this);
		contentOutlineViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
		contentOutlineViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		// add drag support
		int ops = DND.DROP_LINK | DND.DROP_MOVE;
		Transfer[] transfers = new Transfer[] { LocalSelectionTransfer.getTransfer() };
		contentOutlineViewer.addDragSupport(ops, transfers, new MappingDiagramOutlineDragListener(contentOutlineViewer));

		// loads only the resources of this mapping reference
		ResourceSet resourceSet = new ResourceSetImpl();
		MappingReference root = (MappingReference) diagram.getElement();
		for (ModelReference model : root.getModels()) {
			try {
				resourceSet.getResource(URI.createPlatformResourceURI(model.getUri(), true), true);
			}
			catch (Exception e) {
				MMTFException.print(MMTFException.Type.WARNING, "Model " + model.getUri() + " unavailable", e);
			}
		}

		contentOutlineViewer.setInput(resourceSet);
	}

}

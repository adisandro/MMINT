package edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;

import edu.toronto.cs.se.mavo.MAVOModel;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MMINTException.Type;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ui.GMFDiagramUtils;


public class MAVODiagramDecisionTree extends ContentOutlinePage{
	
	private MAVOModel model;
	/** The tree viewer of the outline. */
	protected TreeViewer contentOutlineViewer;
	/** The adapter factory for content and labels of the tree viewer. */
	protected ComposedAdapterFactory adapterFactory;
	
	public MAVODiagramDecisionTree(Diagram diagram){
		super();
		model = (MAVOModel) diagram.getElement();
		adapterFactory = GMFDiagramUtils.getAdapterFactory();
	}
	
	/**
	 * {@inheritDoc}<br />
	 * Initialises the tree viewer with a content and label provider, enables
	 * drag and drop, sets the input of the tree viewer.
	 * 
	 * @param parent
	 *            The parent.
	 */
	@Override
	public void createControl(Composite parent) {

		super.createControl(parent);

		contentOutlineViewer = getTreeViewer();
		contentOutlineViewer.addSelectionChangedListener(this);
		contentOutlineViewer.setContentProvider(new MAVODecisionTreeContentProvider(adapterFactory));
		contentOutlineViewer.setLabelProvider(new MAVODecisionLabelProvider(adapterFactory));
		contentOutlineViewer.setInput(model);

		// add drag support
		/*int ops = DND.DROP_LINK | DND.DROP_MOVE;
		Transfer[] transfers = new Transfer[] { LocalSelectionTransfer.getTransfer() };
		contentOutlineViewer.addDragSupport(ops, transfers, new RelationshipDiagramOutlineDragListener(contentOutlineViewer, modelRel));
		*/

		// populate tree viewer
		//loadOutlineModels();
	}
	
	/**
	 * Adds a new model to the outline tree viewer.
	 * 
	 * @param model
	 *            The model to be added.
	 */
	public void addInput(Model model) {

		ResourceSet resourceSet = (ResourceSet) contentOutlineViewer.getInput();
		try {
			resourceSet.getResources().add(model.getEMFInstanceRoot().eResource());
		}
		catch (MMINTException e) {
			MMINTException.print(Type.WARNING, "Can't get model root, skipping addition to outline", e);;
		}
	}

}

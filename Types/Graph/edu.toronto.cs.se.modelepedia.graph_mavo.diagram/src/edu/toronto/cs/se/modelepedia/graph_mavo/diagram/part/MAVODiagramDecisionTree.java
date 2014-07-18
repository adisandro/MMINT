package edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;

import edu.toronto.cs.se.mavo.MAVOModel;
import edu.toronto.cs.se.mmint.mid.ui.GMFDiagramUtils;

public class MAVODiagramDecisionTree extends ContentOutlinePage {

	private MAVOModel model;
	/** The tree viewer of the outline. */
	protected TreeViewer contentOutlineViewer;
	/** The adapter factory for content and labels of the tree viewer. */
	protected ComposedAdapterFactory adapterFactory;

	public MAVODiagramDecisionTree(Diagram diagram) {
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
		contentOutlineViewer
				.addSelectionChangedListener(new ISelectionChangedListener() {
					public void selectionChanged(SelectionChangedEvent event) {
						contentOutlineViewer.refresh();
					}
				});
		contentOutlineViewer
				.setContentProvider(new MAVODecisionTreeContentProvider(
						adapterFactory));
		contentOutlineViewer.setLabelProvider(new MAVODecisionLabelProvider(
				adapterFactory));
		contentOutlineViewer.setInput(model.eResource());

		MenuManager manager = new MenuManager();
		manager.setRemoveAllWhenShown(true);
		manager.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				manager.add(new MAVODecisionTreeContributionItem(
						contentOutlineViewer));
				manager.add(new MAVOAlternativeHighlightContributionItem(contentOutlineViewer));
			}
		});

		contentOutlineViewer.getControl().setMenu(
				manager.createContextMenu(contentOutlineViewer.getControl()));

	}

}

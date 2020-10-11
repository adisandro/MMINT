package splar.core.fm;

import java.awt.Component;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

public class FeatureTreeCellRenderer extends DefaultTreeCellRenderer {

	public FeatureTreeCellRenderer() {
		super();
	}
	
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
		if ( value != null ) {
			if ( value instanceof FeatureTreeNode ){
				IFNodeRenderer renderer = ((FeatureTreeNode)value).getRenderer();
				return renderer.getRenderedComponent(((FeatureTreeNode)value));
			}
		}
		return null;
	}	
}

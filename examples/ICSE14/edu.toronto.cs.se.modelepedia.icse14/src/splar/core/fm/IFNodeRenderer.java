package splar.core.fm;

import java.awt.Color;

import javax.swing.JComponent;

public interface IFNodeRenderer {
	public JComponent getRenderedComponent(FeatureTreeNode node);
	public void setBackgroundColor(Color bgColor);
	public void setForegroundColor(Color fgColor);
	public Color getBackgroundColor();
	public Color getForegroundColor();
	public void resetDefaults();
}

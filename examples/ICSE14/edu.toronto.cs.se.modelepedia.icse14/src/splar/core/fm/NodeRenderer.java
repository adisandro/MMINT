package splar.core.fm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class NodeRenderer implements IFNodeRenderer {

	private static final Color trueNodeColor = new Color(50,160,50);
	private static final Color falseNodeColor = new Color(140, 140, 160);
	
	private ImageIcon imageIcon = null; 
	private String imgPath = null;
	private JLabel nodeDescriptionLabel = null;
	private JLabel nodeValueLabel = null;
	private JLabel nodeImageLabel = null;
	
	private JPanel nodeDescriptionPanel = null;
	private JPanel nodeValuePanel = null;
	private JPanel nodeImagePanel = null;
	
	private JPanel panel = null;
	private Color bgDefaultColor = Color.WHITE;
	private Color fgDefaultColor = Color.BLACK;
	private Color bgColor = bgDefaultColor;
	private Color fgColor = fgDefaultColor;
	
	private boolean displayTruthValue;
	
	public NodeRenderer( String imgPath, String imgFile, String description, boolean displayTruthValue) {
		
		this.imgPath = imgPath;
		this.displayTruthValue = displayTruthValue; 
		panel = new JPanel(new BorderLayout());
//		imageIcon = createImageIcon(imgPath+imgFile, description);
		
		if ( displayTruthValue ) {
			nodeValueLabel = new JLabel( "",  JLabel.LEFT );
			nodeValuePanel = new JPanel(new BorderLayout());
			nodeValuePanel.add(nodeValueLabel, BorderLayout.CENTER);
		}

		nodeDescriptionLabel = new JLabel( "", JLabel.LEFT );
		nodeImageLabel = new JLabel( "", imageIcon, JLabel.LEFT );
		
		nodeDescriptionPanel = new JPanel(new BorderLayout());
		nodeDescriptionPanel.add(nodeDescriptionLabel,BorderLayout.CENTER);
		nodeImagePanel = new JPanel(new BorderLayout());
		nodeImagePanel.add(nodeImageLabel,BorderLayout.CENTER);
				
		nodeImagePanel.setBackground(Color.white);
		
		JPanel nodePanel = new JPanel(new BorderLayout(3,3));
		nodePanel.setBackground(Color.white);
		
		nodePanel.add(nodeImagePanel, BorderLayout.WEST);
		if (displayTruthValue) {
			nodePanel.add(nodeValuePanel, BorderLayout.CENTER);
			nodePanel.add(nodeDescriptionPanel, BorderLayout.EAST);
		}
		else {
			nodePanel.add(nodeDescriptionPanel, BorderLayout.CENTER);
		}
		
		panel.add(nodePanel, BorderLayout.CENTER);
	}

	public void setBackgroundColor(Color bgColor) {
		this.bgColor = bgColor;
	}
	
	public void setForegroundColor(Color fgColor) {
		this.fgColor = fgColor;		
	}
	
	public Color getBackgroundColor() {
		return bgColor;
	}
	
	public Color getForegroundColor() {
		return fgColor;
	}

	public void resetDefaults() {
		bgColor = bgDefaultColor;
		fgColor = fgDefaultColor;
		nodeValueLabel.setForeground(fgColor);
		nodeValueLabel.setBackground(bgColor);
		nodeDescriptionLabel.setForeground(fgColor);
		nodeDescriptionLabel.setBackground(bgColor);
	}
	
	protected static ImageIcon createImageIcon(String path, String description) {
		try {
			java.net.URL imgURL = new URL(path);
			if (imgURL != null) {
				return new ImageIcon(imgURL, description);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
		
	public JComponent getRenderedComponent(FeatureTreeNode node) {
		if ( displayTruthValue ) {
//			nodeValueLabel.setText((node.getValue() == FeatureTreeNode.UNKNOWN ? "(?)" : (node.getValue() == FeatureTreeNode.SELECTED ? "(T)" : "(F)")));
			ImageIcon valueIcon = null;
			if (node.getValue() == FeatureTreeNode.UNKNOWN ) {
				valueIcon = createImageIcon(imgPath+"unknown.jpg", "");
				nodeValuePanel.setBackground(bgColor);
				nodeValueLabel.setIcon(valueIcon);
			} 
			else if (node.getValue() == FeatureTreeNode.SELECTED ) {
				valueIcon = createImageIcon(imgPath+"true.jpg", "");
				nodeDescriptionLabel.setForeground(trueNodeColor);
			} 
			else if (node.getValue() == FeatureTreeNode.DESELECTED ) {
				valueIcon = createImageIcon(imgPath+"false.jpg", "");
				nodeDescriptionLabel.setForeground(falseNodeColor);
			}
			nodeValueLabel.setIcon(valueIcon);
		}
		nodeDescriptionLabel.setText(node.getDescription());
		nodeDescriptionPanel.setBackground(bgColor);
		panel.setBackground(bgColor);
		return panel;
	}
}

package splar.apps.generator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class FMGeneratorGUI extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3698662440079433924L;

	private static final String remarkMessage = "This software generates 3-CNF Feature Models, i.e., models in which the " +
			"cross-tree constraints (CTC) are represented by a Random 3-CNF Formula" ;
	
	private static final String initialMessage = 
		"This software generates 3-CNF Feature Models. For details please see publication below:" + 
		"\n\n M. Mendonca, A. Wasowski, K. Czarnecki: SAT-Based Analysis of Feature Models is Easy, Proceedings of SPLC 2009, San Francisco, USA" +
		"\n\n" +
		"IMPORTANT: The models are generated based on the parameters indicated above." +
			"It is important to note that some of these parameters are conflicting. For instance, if the clause density is to high " +
			"it might not be possible to generate consistent models. Also, conflicts can cause a significant delay in the generation " +
			"process as the system will attempt unproductively to produce a model that matches the specified parameters." +
			"The user should try to adjust parameters to avoid such scenarios." +
			"\n\n" +
			"Your suggestions for improvement and feedback are important. Contact us at http://www.splot-research.org";
	
	private Color foreColor1 = new Color(50,50,250);
	private Color foreColor2 = new Color(250,50,50);
	private Color errorBgColor = new Color(250,50,50);
	private Font font1 = new Font("Default", Font.BOLD, 16);
	private Font font2 = new Font("Default", Font.BOLD, 12);
	
	JTextField collectionNameTextField = new JTextField("MyCollection");
	JTextField collectionSizeTextField = new JTextField("10");
	JTextField collectionPathTextField = new JTextField("c:\\my_feature_models\\");
	JTextField featureTreeSizeTextField = new JTextField("100");
	JTextField featureTreeMandatoryTextField = new JTextField("25");
	JTextField featureTreeOptionalTextField = new JTextField("25");
	JTextField featureTreeAlternativeTextField = new JTextField("25");
	JTextField featureTreeExclusiveTextField = new JTextField("25");
	JTextField featureTreeMinBranchingFactorTextField = new JTextField("1");
	JTextField featureTreeMaxBranchingFactorTextField  = new JTextField("6");
	JTextField featureTreeMaxFeatureGroupSizeTextField = new JTextField("6");
	JTextField ctcrTextField = new JTextField("20");
//	JTextField ctcrToleranceTextField = new JTextField("5");
	JTextField ctcClauseDensityTextField = new JTextField("1.0");
	
	String[] data = {"Generate CONSISTENT models ONLY", "Generate INCONSISTENT models ONLY", "I DON'T CARE"};
	JComboBox consistentyList = new JComboBox(data);
	
	JButton generateButton = new JButton("Generate");
	JButton cancelButton = new JButton("Cancel");
	
	JLabel messagesLabel = new JLabel(">> <<");
	JTextArea messageOutputTextArea = new JTextArea(initialMessage);
	
	private List<FMGeneratorGUIListener> listeners;
	
	public FMGeneratorGUI(String title) {
		super(title);
		init();
	}
	
	protected void init() {
		listeners = new LinkedList<FMGeneratorGUIListener>();
		buildGUI();
		addTooltips();
		generateButton.addActionListener(this);
		cancelButton.addActionListener(this);
	}
	
	private void addTooltips() {
		collectionNameTextField.setToolTipText("What is the name of this collection of models (used as a prefix to name generated files)?");
		collectionSizeTextField.setToolTipText("How many feature models do you want to generate in this collection?");
		collectionPathTextField.setToolTipText("What is the path for saving your models? ");
		featureTreeSizeTextField.setToolTipText("What is the desired size for generated models?");
		featureTreeMandatoryTextField.setToolTipText("What is the percentage of mandatory features?");
		featureTreeOptionalTextField.setToolTipText("What is the percentage of optional features?");
		featureTreeAlternativeTextField.setToolTipText("What is the percentage of alternative (OR) features?");
		featureTreeExclusiveTextField.setToolTipText("What is the percentage of exclusive (XOR) features?");
		featureTreeMinBranchingFactorTextField.setToolTipText("What is the minimum branching factor (# of children per parent node)?");
		featureTreeMaxBranchingFactorTextField.setToolTipText("What is the maximum branching factor (# of children per parent node)?");
		featureTreeMaxFeatureGroupSizeTextField.setToolTipText("What is the maximum number of grouped features in a Feature Group?");
		ctcrTextField.setToolTipText("What percentage of the features in the feature tree should be considered to build the Random 3-CNF formula?");
//		ctcrToleranceTextField.setToolTipText("How much do you accept the CTCR to differ from the desired value (e.g., for 5% just type 5)?");
		ctcClauseDensityTextField.setToolTipText("What is the desired clause density for the Random 3-CNF formula (density = #clauses / #features)?");
		consistentyList.setToolTipText("What is the desired consistency for your models?");
	}
	
	private Border createTitleBorder(String title) {
		return BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED), 
				title, TitledBorder.LEFT, TitledBorder.TOP, font1, foreColor1);
	}
	
	private JPanel generateRemarkPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		JTextArea textArea = new JTextArea(remarkMessage);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setForeground(foreColor1);
		textArea.setFont(font1);
		textArea.setWrapStyleWord(true);
		textArea.setRows(2);

		JPanel tempPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		tempPanel.setBackground(Color.white);
		JLabel label = new JLabel("Hover mouse over textfields to see tooltip descriptions");
		label.setForeground(foreColor2);
		label.setFont(font2);
		tempPanel.add(label);
		
		panel.add(textArea, BorderLayout.CENTER);
		panel.add(tempPanel, BorderLayout.SOUTH);
		
		return panel;
	}
	
	public void buildGUI() {
		
		setLayout( new BorderLayout());
		
		// Collection Information
		
		JPanel collectionPanel = new JPanel( new GridLayout(3,1));
		
		collectionPanel.setBorder(createTitleBorder("Collection Information"));
		
		JPanel panel1 = new JPanel(new BorderLayout());
		panel1.add(new JLabel("Name: "), BorderLayout.WEST);
		panel1.add( collectionNameTextField, BorderLayout.CENTER);
		
		JPanel panel2 = new JPanel(new BorderLayout());
		panel2.add(new JLabel("Size: "), BorderLayout.WEST);
		panel2.add(collectionSizeTextField, BorderLayout.CENTER);
		
		JPanel panel3 = new JPanel(new BorderLayout());
		panel3.add(new JLabel("Output Directory: "), BorderLayout.WEST);
		panel3.add( collectionPathTextField, BorderLayout.CENTER);
				
		collectionPanel.add(panel1);
		collectionPanel.add(panel2);
		collectionPanel.add(panel3);

		// Feature Tree Information
		
		JPanel featureTreePanel = new JPanel( new GridLayout(8,1));
		
		featureTreePanel.setBorder(createTitleBorder("Feature Tree Information"));
		
		JPanel panel4 = new JPanel(new BorderLayout());
		panel4.add(new JLabel("Size (# of features) [>1]: "), BorderLayout.WEST);
		panel4.add( featureTreeSizeTextField, BorderLayout.CENTER);
		
		JPanel panel5 = new JPanel(new BorderLayout());
		panel5.add(new JLabel("% of Mandatory features [0-100]: "), BorderLayout.WEST);
		panel5.add( featureTreeMandatoryTextField, BorderLayout.CENTER);
		
		JPanel panel6 = new JPanel(new BorderLayout());
		panel6.add(new JLabel("% of Optional features [0-100]: "), BorderLayout.WEST);
		panel6.add( featureTreeOptionalTextField, BorderLayout.CENTER);

		JPanel panel7 = new JPanel(new BorderLayout());
		panel7.add(new JLabel("% of Alternative (OR) features [0-100]: "), BorderLayout.WEST);
		panel7.add( featureTreeAlternativeTextField, BorderLayout.CENTER);
				
		JPanel panel8 = new JPanel(new BorderLayout());
		panel8.add(new JLabel("% of Exclusive (XOR) features [0-100]: "), BorderLayout.WEST);
		panel8.add( featureTreeExclusiveTextField, BorderLayout.CENTER);

		JPanel panel9 = new JPanel(new BorderLayout());
		panel9.add(new JLabel("Minimum Branching Factor [>= 0]: "), BorderLayout.WEST);
		panel9.add( featureTreeMinBranchingFactorTextField, BorderLayout.CENTER);

		JPanel panel10 = new JPanel(new BorderLayout());
		panel10.add(new JLabel("Maximum Branching Factor [>= Minimum factor]: "), BorderLayout.WEST);
		panel10.add( featureTreeMaxBranchingFactorTextField, BorderLayout.CENTER);

		JPanel panel11 = new JPanel(new BorderLayout());
		panel11.add(new JLabel("Maximum Size for Feature Groups [> 1]: "), BorderLayout.WEST);
		panel11.add( featureTreeMaxFeatureGroupSizeTextField, BorderLayout.CENTER);

		featureTreePanel.add(panel4);
		featureTreePanel.add(panel5);
		featureTreePanel.add(panel6);
		featureTreePanel.add(panel7);
		featureTreePanel.add(panel8);
		featureTreePanel.add(panel9);
		featureTreePanel.add(panel10);
		featureTreePanel.add(panel11);

		
		// Cross-tree Constraints Information

		JPanel crosstreePanel = new JPanel( new GridLayout(3,1));
		
		crosstreePanel.setBorder(createTitleBorder("Cross-Tree Constraints Information (Random 3-CNF Formula)"));
		
		JPanel panel12 = new JPanel(new BorderLayout());
		panel12.add(new JLabel("% of Feature Tree Variables To Be Considered [0-100]: "), BorderLayout.WEST);
		panel12.add( ctcrTextField, BorderLayout.CENTER);
		
//		JPanel panel13 = new JPanel(new BorderLayout());
//		panel13.add(new JLabel("CTCR Tolerance[0-100]: "), BorderLayout.WEST);
//		panel13.add( ctcrToleranceTextField, BorderLayout.CENTER);
		
		JPanel panel14 = new JPanel(new BorderLayout());
		panel14.add(new JLabel("Clause Density [>= 0.0]: "), BorderLayout.WEST);
		panel14.add( ctcClauseDensityTextField, BorderLayout.CENTER);

		JPanel panel15 = new JPanel(new BorderLayout());
		panel15.add(new JLabel("Model Consistency: "), BorderLayout.WEST);
		panel15.add( consistentyList, BorderLayout.CENTER);
				

		crosstreePanel.add(panel12);
//		crosstreePanel.add(panel13);
		crosstreePanel.add(panel14);
		crosstreePanel.add(panel15);
		
		JPanel buttonPanel = new JPanel(new GridLayout(1,3));
		buttonPanel.add( generateButton);
		buttonPanel.add( cancelButton);
		cancelButton.setEnabled(false);
		
		JPanel centerPanel = new JPanel( new BorderLayout());
		
		JPanel tempPanel = new JPanel();
		tempPanel.setLayout(new BoxLayout(tempPanel, BoxLayout.PAGE_AXIS));
				
		JPanel errorMessagesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		errorMessagesPanel.add(messagesLabel);
		
		tempPanel.add(collectionPanel);
		tempPanel.add(featureTreePanel);
		tempPanel.add(crosstreePanel);
		tempPanel.add(errorMessagesPanel);
		tempPanel.add(buttonPanel);
		
		JScrollPane pane = new JScrollPane(messageOutputTextArea);
		
		centerPanel.add(tempPanel, BorderLayout.NORTH);
		centerPanel.add(pane, BorderLayout.CENTER);
		messageOutputTextArea.setEditable(false);
		messageOutputTextArea.setLineWrap(true);
		messageOutputTextArea.setWrapStyleWord(true);
		
		add( generateRemarkPanel(), BorderLayout.NORTH);
		add( centerPanel, BorderLayout.CENTER);
		
//		add( new JPanel(), BorderLayout.CENTER);
	}

	public String getCollectionName() {
		return collectionNameTextField.getText().trim(); 
	}
	
	public int getCollectionSize() {
		return Integer.parseInt(collectionSizeTextField.getText().trim()); 
	}
	
	public String getCollectionPath() {
		return collectionPathTextField.getText().trim(); 
	}
	
	public int getFeatureTreeSize() {
		return Integer.parseInt(featureTreeSizeTextField.getText().trim()); 
	}
	
	public int getFeatureTreeMandatoryPercentage() {
		return Integer.parseInt(featureTreeMandatoryTextField.getText().trim()); 
	}
	
	public int getFeatureTreeOptionalPercentage() {
		return Integer.parseInt(featureTreeOptionalTextField.getText().trim()); 
	}
	
	public int getFeatureTreeExclusiveORPercentage() {
		return Integer.parseInt(featureTreeExclusiveTextField.getText().trim()); 
	}
	
	public int getFeatureTreeInclusiveORPercentage() {
		return Integer.parseInt(featureTreeAlternativeTextField.getText().trim()); 
	}
	
	public int getFeatureTreeMinBranchingFactor() {
		return Integer.parseInt(featureTreeMinBranchingFactorTextField.getText().trim()); 
	}
	
	public int getFeatureTreeMaxBranchingFactor() {
		return Integer.parseInt(featureTreeMaxBranchingFactorTextField.getText().trim()); 
	}
	
	public int getFeatureTreeMaxFeatureGroupSize() {
		return Integer.parseInt(featureTreeMaxFeatureGroupSizeTextField.getText().trim()); 
	}
	
	public int getCTCR() {
		return Integer.parseInt(ctcrTextField.getText().trim()); 
	}
	
//	public int getCTCRange() {
//		return Integer.parseInt(ctcrToleranceTextField.getText().trim()); 
//	}
	
	public float getCTCClauseDensity() {
		return Float.parseFloat(ctcClauseDensityTextField.getText().trim()); 
	}
	
	public int getConsistentyOption() {
		return (consistentyList.getSelectedIndex() == 0) ? 1 : ((consistentyList.getSelectedIndex() == 1) ? -1 : 0); 
	}

	public void actionPerformed(ActionEvent event) {
		if ( event.getSource() == generateButton ) {
			validParametersState();
			clearErrorMessage();
			if ( validateParameters() ) {
				FMGeneratorGUIEvent gEvent = new FMGeneratorGUIEvent(this);
				for( FMGeneratorGUIListener listener : listeners ) {
					listener.startGeneration(gEvent);
				}
			}
		}
		else if ( event.getSource() == cancelButton ) {
			for( FMGeneratorGUIListener listener : listeners ) {
				listener.cancelGeneration();
			}
		} 
	}
	
	public void addListener(FMGeneratorGUIListener listener) {
		listeners.add(listener);
	}
	
	public void disableGeneration() {
		generateButton.setEnabled(false);
	}

	public void enableGeneration() {
		generateButton.setEnabled(true);
	}
	
	public void disableCancelGeneration() {
		cancelButton.setEnabled(false);
	}

	public void enableCancelGeneration() {
		cancelButton.setEnabled(true);
	}

	public void addMessage(String message) {
		messageOutputTextArea.append(message + "\r\n");
	}
	
	public void clearMessages() {
		messageOutputTextArea.setText("");
	}
	
	public void setMessage(String message) {
		messagesLabel.setText(message);
		messagesLabel.setFont(font2);
		messagesLabel.setForeground(errorBgColor);
	}
	
	private void clearErrorMessage() {
		messagesLabel.setText("");
	}
	
	private void validParametersState() {
		collectionNameTextField.setBackground(Color.white);
		collectionSizeTextField.setBackground(Color.white);
		collectionPathTextField.setBackground(Color.white);
		featureTreeSizeTextField.setBackground(Color.white);
		featureTreeMandatoryTextField.setBackground(Color.white);
		featureTreeOptionalTextField.setBackground(Color.white);
		featureTreeAlternativeTextField.setBackground(Color.white);
		featureTreeExclusiveTextField.setBackground(Color.white);
		featureTreeMinBranchingFactorTextField.setBackground(Color.white);
		featureTreeMaxBranchingFactorTextField.setBackground(Color.white);
		featureTreeMaxFeatureGroupSizeTextField.setBackground(Color.white);
		ctcrTextField.setBackground(Color.white);
//		ctcrToleranceTextField.setBackground(Color.white);
		ctcClauseDensityTextField.setBackground(Color.white);
		consistentyList.setBackground(Color.white);
	}
	
	private boolean validateParameters() {
		collectionNameTextField.getText().trim();
		if ( collectionNameTextField.getText().trim().isEmpty() ) {
			setMessage("Collection name cannot be empty");
			collectionNameTextField.setBackground(errorBgColor);
			return false;
		}
		try {
			if (Integer.parseInt(collectionSizeTextField.getText().trim()) < 1 ) {
				throw new Exception();
			}
		} catch (Exception e) {
			setMessage("Collection size must be a positive integer");
			collectionSizeTextField.setBackground(errorBgColor);
			return false;
		}
		
		File file = new File(collectionPathTextField.getText().trim());
		if ( collectionPathTextField.getText().trim().isEmpty() || !file.exists() ) {
			setMessage("Collection path must point to a valid directory path");
			collectionPathTextField.setBackground(errorBgColor);
			return false;
		}				

		try {
			if( Integer.parseInt(featureTreeSizeTextField.getText().trim()) < 1) { 
				throw new Exception();
			}
		} catch (Exception e) {
			setMessage("Feature tree size must be a positive integer");
			featureTreeSizeTextField.setBackground(errorBgColor);
			return false;
		}
		try {
			if( Integer.parseInt(featureTreeMandatoryTextField.getText().trim()) < 0 || Integer.parseInt(featureTreeMandatoryTextField.getText().trim()) > 100) { 
				throw new Exception();
			}
		} catch (Exception e) {
			setMessage("% of mandatory features must be between 0 and 100");
			featureTreeMandatoryTextField.setBackground(errorBgColor);
			return false;
		}
		try {
			if( Integer.parseInt(featureTreeOptionalTextField.getText().trim()) < 0 || Integer.parseInt(featureTreeOptionalTextField.getText().trim()) > 100) {
				throw new Exception();
			}
		} catch (Exception e) {
			setMessage("% of optional features must be between 0 and 100");
			featureTreeOptionalTextField.setBackground(errorBgColor);
			return false;
		}
		try {
			if( Integer.parseInt(featureTreeExclusiveTextField.getText().trim()) < 0 || Integer.parseInt(featureTreeExclusiveTextField.getText().trim()) > 100) {
				throw new Exception();
			}
		} catch (Exception e) {
			setMessage("% of exclusive (XOR) features must be between 0 and 100");
			featureTreeExclusiveTextField.setBackground(errorBgColor);
			return false;
		}
		try {
			if( Integer.parseInt(featureTreeAlternativeTextField.getText().trim()) < 0 || Integer.parseInt(featureTreeAlternativeTextField.getText().trim()) > 100) {
				throw new Exception();
			}
		} catch (Exception e) {
			setMessage("% of alternative (OR) features must be between 0 and 100");
			featureTreeAlternativeTextField.setBackground(errorBgColor);
			return false;
		}
		try {
			if ( Integer.parseInt(featureTreeMinBranchingFactorTextField.getText().trim()) < 0 ) {
				throw new Exception();
			}
		} catch (Exception e) {
			setMessage("Minimum branching factor must be greater or equal to 0");
			featureTreeMinBranchingFactorTextField.setBackground(errorBgColor);
			return false;
		}
		try {
			if ( Integer.parseInt(featureTreeMaxBranchingFactorTextField.getText().trim()) < Integer.parseInt(featureTreeMinBranchingFactorTextField.getText().trim()) ) {
				throw new Exception();
			}
		} catch (Exception e) {
			setMessage("Maximum branching factor must be greater than minimum factor");
			featureTreeMaxBranchingFactorTextField.setBackground(errorBgColor);
			return false;
		}
		try {
			if ( Integer.parseInt(featureTreeMaxFeatureGroupSizeTextField.getText().trim()) < 0 ) {
				throw new Exception();
			}
		} catch (Exception e) {
			setMessage("Maximum group size must be a positive integer");
			featureTreeMaxFeatureGroupSizeTextField.setBackground(errorBgColor);
			return false;
		}
		try {
			if( Integer.parseInt(ctcrTextField.getText().trim()) < 0 || Integer.parseInt(ctcrTextField.getText().trim()) > 100) {
				throw new Exception();
			}
		} catch (Exception e) {
			setMessage("CTCR % must be between 0 and 100");
			ctcrTextField.setBackground(errorBgColor);
			return false;
		}
//		try {
//			if( Integer.parseInt(ctcrToleranceTextField.getText().trim()) < 0 || Integer.parseInt(ctcrToleranceTextField.getText().trim()) > 20) {
//				throw new Exception();
//			}
//		} catch (Exception e) {
//			setMessage("CTCR tolerance % must be between 0 and 20 (e.g., 10)");
//			ctcrToleranceTextField.setBackground(errorBgColor);
//			return false;
//		}
		try {
			if ( Float.parseFloat(ctcClauseDensityTextField.getText().trim()) < 0 ) {
				throw new Exception();
			}
		} catch (Exception e) {
			setMessage("CTC Clause Density must be a non-negative float number (e.g., 0.5, 1.3)");
			ctcClauseDensityTextField.setBackground(errorBgColor);
			return false;
		}
		clearErrorMessage();
		return true;
	}
	
}



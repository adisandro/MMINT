package splar.apps.generator;

import java.util.EventObject;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class FMGeneratorGUIEvent extends EventObject {

	protected Map<String,Comparable> attributes;
	
	public FMGeneratorGUIEvent(Object source) {
		super(source);
		attributes = new HashMap<String, Comparable>();
	}
	
	public void addAttribute(String name, Comparable value) {
		attributes.put(name, value);
	}
	
	public Comparable getAttribute(String name) {
		return attributes.get(name);
	}
}

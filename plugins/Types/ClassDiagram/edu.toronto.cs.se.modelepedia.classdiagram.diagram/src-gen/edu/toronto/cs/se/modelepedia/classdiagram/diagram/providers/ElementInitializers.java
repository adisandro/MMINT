/*
 * 
 */
package edu.toronto.cs.se.modelepedia.classdiagram.diagram.providers;

import edu.toronto.cs.se.modelepedia.classdiagram.diagram.part.ClassDiagramDiagramEditorPlugin;

/**
 * @generated
 */
public class ElementInitializers {

	protected ElementInitializers() {
		// use #getInstance to access cached instance
	}

	/**
	 * @generated
	 */
	public static ElementInitializers getInstance() {
		ElementInitializers cached = ClassDiagramDiagramEditorPlugin
				.getInstance().getElementInitializers();
		if (cached == null) {
			ClassDiagramDiagramEditorPlugin.getInstance()
					.setElementInitializers(cached = new ElementInitializers());
		}
		return cached;
	}
}

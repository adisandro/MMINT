/*
* Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
* Rick Salay.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
* 
* Contributors:
*    Alessio Di Sandro - Implementation.
*/
package edu.toronto.cs.se.modelepedia.classdiagram.diagram.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.ui.services.parser.CommonParserHint;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

import edu.toronto.cs.se.modelepedia.classdiagram.Dependency;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.AssociationEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.AssociationNameEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.AttributeEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.AttributeNameEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.ClassDiagramEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.ClassEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.ClassNameEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.ClassNestedInEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.ClassSuperclassEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.DependencyEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.OperationEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.OperationNameEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.part.ClassDiagramDiagramEditorPlugin;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.part.ClassDiagramVisualIDRegistry;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.providers.ClassDiagramElementTypes;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.providers.ClassDiagramParserProvider;

/**
 * @generated
 */
public class ClassDiagramNavigatorLabelProvider extends LabelProvider
		implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	* @generated
	*/
	static {
		ClassDiagramDiagramEditorPlugin.getInstance().getImageRegistry().put(
			"Navigator?UnknownElement", //$NON-NLS-1$
			ImageDescriptor.getMissingImageDescriptor());
		ClassDiagramDiagramEditorPlugin.getInstance().getImageRegistry().put(
			"Navigator?ImageNotFound", //$NON-NLS-1$
			ImageDescriptor.getMissingImageDescriptor());
	}

	/**
	* @generated
	*/
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof ClassDiagramNavigatorItem
				&& !isOwnView(((ClassDiagramNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	* @generated
	*/
	public Image getImage(Object element) {
		if (element instanceof ClassDiagramNavigatorGroup) {
			ClassDiagramNavigatorGroup group = (ClassDiagramNavigatorGroup) element;
			return ClassDiagramDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof ClassDiagramNavigatorItem) {
			ClassDiagramNavigatorItem navigatorItem = (ClassDiagramNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getImage(view);
			}
		}

		return super.getImage(element);
	}

	/**
	* @generated
	*/
	public Image getImage(View view) {
		switch (ClassDiagramVisualIDRegistry.getVisualID(view)) {
			case ClassDiagramEditPart.VISUAL_ID:
				return getImage(
					"Navigator?Diagram?http://se.cs.toronto.edu/modelepedia/ClassDiagram?ClassDiagram", //$NON-NLS-1$
					ClassDiagramElementTypes.ClassDiagram_1000);
			case ClassEditPart.VISUAL_ID:
				return getImage(
					"Navigator?TopLevelNode?http://se.cs.toronto.edu/modelepedia/ClassDiagram?Class", //$NON-NLS-1$
					ClassDiagramElementTypes.Class_2001);
			case AttributeEditPart.VISUAL_ID:
				return getImage(
					"Navigator?Node?http://se.cs.toronto.edu/modelepedia/ClassDiagram?Attribute", //$NON-NLS-1$
					ClassDiagramElementTypes.Attribute_3001);
			case OperationEditPart.VISUAL_ID:
				return getImage(
					"Navigator?Node?http://se.cs.toronto.edu/modelepedia/ClassDiagram?Operation", //$NON-NLS-1$
					ClassDiagramElementTypes.Operation_3002);
			case AssociationEditPart.VISUAL_ID:
				return getImage(
					"Navigator?Link?http://se.cs.toronto.edu/modelepedia/ClassDiagram?Association", //$NON-NLS-1$
					ClassDiagramElementTypes.Association_4001);
			case DependencyEditPart.VISUAL_ID:
				return getImage(
					"Navigator?Link?http://se.cs.toronto.edu/modelepedia/ClassDiagram?Dependency", //$NON-NLS-1$
					ClassDiagramElementTypes.Dependency_4002);
			case ClassNestedInEditPart.VISUAL_ID:
				return getImage(
					"Navigator?Link?http://se.cs.toronto.edu/modelepedia/ClassDiagram?Class?nestedIn", //$NON-NLS-1$
					ClassDiagramElementTypes.ClassNestedIn_4003);
			case ClassSuperclassEditPart.VISUAL_ID:
				return getImage(
					"Navigator?Link?http://se.cs.toronto.edu/modelepedia/ClassDiagram?Class?superclass", //$NON-NLS-1$
					ClassDiagramElementTypes.ClassSuperclass_4004);
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = ClassDiagramDiagramEditorPlugin.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null && ClassDiagramElementTypes.isKnownElementType(elementType)) {
			image = ClassDiagramElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	* @generated
	*/
	public String getText(Object element) {
		if (element instanceof ClassDiagramNavigatorGroup) {
			ClassDiagramNavigatorGroup group = (ClassDiagramNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof ClassDiagramNavigatorItem) {
			ClassDiagramNavigatorItem navigatorItem = (ClassDiagramNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getText(view);
			}
		}

		return super.getText(element);
	}

	/**
	* @generated
	*/
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (ClassDiagramVisualIDRegistry.getVisualID(view)) {
			case ClassDiagramEditPart.VISUAL_ID:
				return getClassDiagram_1000Text(view);
			case ClassEditPart.VISUAL_ID:
				return getClass_2001Text(view);
			case AttributeEditPart.VISUAL_ID:
				return getAttribute_3001Text(view);
			case OperationEditPart.VISUAL_ID:
				return getOperation_3002Text(view);
			case AssociationEditPart.VISUAL_ID:
				return getAssociation_4001Text(view);
			case DependencyEditPart.VISUAL_ID:
				return getDependency_4002Text(view);
			case ClassNestedInEditPart.VISUAL_ID:
				return getClassNestedIn_4003Text(view);
			case ClassSuperclassEditPart.VISUAL_ID:
				return getClassSuperclass_4004Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	* @generated
	*/
	private String getClassDiagram_1000Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private String getClass_2001Text(View view) {
		IParser parser = ClassDiagramParserProvider.getParser(
			ClassDiagramElementTypes.Class_2001,
			view.getElement() != null ? view.getElement() : view,
			ClassDiagramVisualIDRegistry.getType(ClassNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(
				new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		}
		else {
			ClassDiagramDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getAttribute_3001Text(View view) {
		IParser parser = ClassDiagramParserProvider.getParser(
			ClassDiagramElementTypes.Attribute_3001,
			view.getElement() != null ? view.getElement() : view,
			ClassDiagramVisualIDRegistry.getType(AttributeNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(
				new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		}
		else {
			ClassDiagramDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getOperation_3002Text(View view) {
		IParser parser = ClassDiagramParserProvider.getParser(
			ClassDiagramElementTypes.Operation_3002,
			view.getElement() != null ? view.getElement() : view,
			ClassDiagramVisualIDRegistry.getType(OperationNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(
				new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		}
		else {
			ClassDiagramDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getAssociation_4001Text(View view) {
		IParser parser = ClassDiagramParserProvider.getParser(
			ClassDiagramElementTypes.Association_4001,
			view.getElement() != null ? view.getElement() : view,
			ClassDiagramVisualIDRegistry.getType(AssociationNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(
				new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		}
		else {
			ClassDiagramDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getDependency_4002Text(View view) {
		Dependency domainModelElement = (Dependency) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		}
		else {
			ClassDiagramDiagramEditorPlugin
				.getInstance()
				.logError("No domain element for view with visualID = " + 4002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getClassNestedIn_4003Text(View view) {
		IParser parser = ClassDiagramParserProvider.getParser(
			ClassDiagramElementTypes.ClassNestedIn_4003,
			view.getElement() != null ? view.getElement() : view,
			CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(
				new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		}
		else {
			ClassDiagramDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getClassSuperclass_4004Text(View view) {
		IParser parser = ClassDiagramParserProvider.getParser(
			ClassDiagramElementTypes.ClassSuperclass_4004,
			view.getElement() != null ? view.getElement() : view,
			CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(
				new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
				ParserOptions.NONE.intValue());
		}
		else {
			ClassDiagramDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	* @generated
	*/
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	* @generated
	*/
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	* @generated
	*/
	public void restoreState(IMemento aMemento) {
	}

	/**
	* @generated
	*/
	public void saveState(IMemento aMemento) {
	}

	/**
	* @generated
	*/
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	* @generated
	*/
	private boolean isOwnView(View view) {
		return ClassDiagramEditPart.MODEL_ID.equals(ClassDiagramVisualIDRegistry.getModelID(view));
	}

}

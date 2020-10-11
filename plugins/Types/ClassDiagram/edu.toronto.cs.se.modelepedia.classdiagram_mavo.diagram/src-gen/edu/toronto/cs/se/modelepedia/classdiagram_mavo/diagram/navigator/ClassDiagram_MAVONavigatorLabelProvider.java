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
package edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.navigator;

import org.eclipse.core.runtime.IAdaptable;
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

/**
 * @generated
 */
public class ClassDiagram_MAVONavigatorLabelProvider extends LabelProvider
		implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	* @generated
	*/
	static {
		edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVODiagramEditorPlugin.getInstance()
				.getImageRegistry().put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVODiagramEditorPlugin.getInstance()
				.getImageRegistry().put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.navigator.ClassDiagram_MAVONavigatorItem
				&& !isOwnView(
						((edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.navigator.ClassDiagram_MAVONavigatorItem) element)
								.getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	* @generated
	*/
	public Image getImage(Object element) {
		if (element instanceof edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.navigator.ClassDiagram_MAVONavigatorGroup) {
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.navigator.ClassDiagram_MAVONavigatorGroup group = (edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.navigator.ClassDiagram_MAVONavigatorGroup) element;
			return edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVODiagramEditorPlugin
					.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.navigator.ClassDiagram_MAVONavigatorItem) {
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.navigator.ClassDiagram_MAVONavigatorItem navigatorItem = (edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.navigator.ClassDiagram_MAVONavigatorItem) element;
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
		switch (edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOVisualIDRegistry
				.getVisualID(view)) {
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.ClassDiagramEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?http://se.cs.toronto.edu/modelepedia/ClassDiagram_MAVO?ClassDiagram", //$NON-NLS-1$
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.ClassDiagram_1000);
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.ClassEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://se.cs.toronto.edu/modelepedia/ClassDiagram_MAVO?Class", //$NON-NLS-1$
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Class_2001);
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.AttributeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://se.cs.toronto.edu/modelepedia/ClassDiagram_MAVO?Attribute", //$NON-NLS-1$
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Attribute_3001);
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.OperationEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://se.cs.toronto.edu/modelepedia/ClassDiagram_MAVO?Operation", //$NON-NLS-1$
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Operation_3002);
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.AssociationEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://se.cs.toronto.edu/modelepedia/ClassDiagram_MAVO?Association", //$NON-NLS-1$
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Association_4001);
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.NestedInReferenceEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://se.cs.toronto.edu/modelepedia/ClassDiagram_MAVO?NestedInReference", //$NON-NLS-1$
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.NestedInReference_4002);
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.SuperclassReferenceEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://se.cs.toronto.edu/modelepedia/ClassDiagram_MAVO?SuperclassReference", //$NON-NLS-1$
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.SuperclassReference_4003);
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.DependencyEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://se.cs.toronto.edu/modelepedia/ClassDiagram_MAVO?Dependency", //$NON-NLS-1$
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Dependency_4004);
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVODiagramEditorPlugin
				.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes
						.isKnownElementType(elementType)) {
			image = edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes
					.getImage(elementType);
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
		if (element instanceof edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.navigator.ClassDiagram_MAVONavigatorGroup) {
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.navigator.ClassDiagram_MAVONavigatorGroup group = (edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.navigator.ClassDiagram_MAVONavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.navigator.ClassDiagram_MAVONavigatorItem) {
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.navigator.ClassDiagram_MAVONavigatorItem navigatorItem = (edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.navigator.ClassDiagram_MAVONavigatorItem) element;
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
		switch (edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOVisualIDRegistry
				.getVisualID(view)) {
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.ClassDiagramEditPart.VISUAL_ID:
			return getClassDiagram_1000Text(view);
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.ClassEditPart.VISUAL_ID:
			return getClass_2001Text(view);
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.AttributeEditPart.VISUAL_ID:
			return getAttribute_3001Text(view);
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.OperationEditPart.VISUAL_ID:
			return getOperation_3002Text(view);
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.AssociationEditPart.VISUAL_ID:
			return getAssociation_4001Text(view);
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.NestedInReferenceEditPart.VISUAL_ID:
			return getNestedInReference_4002Text(view);
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.SuperclassReferenceEditPart.VISUAL_ID:
			return getSuperclassReference_4003Text(view);
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.DependencyEditPart.VISUAL_ID:
			return getDependency_4004Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	* @generated
	*/
	private String getClassDiagram_1000Text(View view) {
		edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram domainModelElement = (edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram) view
				.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isInc());
		} else {
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVODiagramEditorPlugin
					.getInstance().logError("No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getClass_2001Text(View view) {
		IParser parser = edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOParserProvider
				.getParser(
						edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Class_2001,
						view.getElement() != null ? view.getElement() : view,
						edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOVisualIDRegistry
								.getType(
										edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.ClassNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVODiagramEditorPlugin
					.getInstance().logError("Parser was not found for label " + 5005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getAttribute_3001Text(View view) {
		IParser parser = edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOParserProvider
				.getParser(
						edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Attribute_3001,
						view.getElement() != null ? view.getElement() : view,
						edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOVisualIDRegistry
								.getType(
										edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.AttributeNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVODiagramEditorPlugin
					.getInstance().logError("Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getOperation_3002Text(View view) {
		IParser parser = edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOParserProvider
				.getParser(
						edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Operation_3002,
						view.getElement() != null ? view.getElement() : view,
						edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOVisualIDRegistry
								.getType(
										edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.OperationNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVODiagramEditorPlugin
					.getInstance().logError("Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getAssociation_4001Text(View view) {
		IParser parser = edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOParserProvider
				.getParser(
						edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Association_4001,
						view.getElement() != null ? view.getElement() : view,
						edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOVisualIDRegistry
								.getType(
										edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.AssociationNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVODiagramEditorPlugin
					.getInstance().logError("Parser was not found for label " + 6001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getNestedInReference_4002Text(View view) {
		IParser parser = edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOParserProvider
				.getParser(
						edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.NestedInReference_4002,
						view.getElement() != null ? view.getElement() : view,
						edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOVisualIDRegistry
								.getType(
										edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.WrappingLabel5EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVODiagramEditorPlugin
					.getInstance().logError("Parser was not found for label " + 6003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getSuperclassReference_4003Text(View view) {
		IParser parser = edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOParserProvider
				.getParser(
						edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.SuperclassReference_4003,
						view.getElement() != null ? view.getElement() : view,
						edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOVisualIDRegistry
								.getType(
										edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.WrappingLabel6EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVODiagramEditorPlugin
					.getInstance().logError("Parser was not found for label " + 6004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getDependency_4004Text(View view) {
		IParser parser = edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOParserProvider
				.getParser(
						edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Dependency_4004,
						view.getElement() != null ? view.getElement() : view,
						edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOVisualIDRegistry
								.getType(
										edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.WrappingLabel7EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVODiagramEditorPlugin
					.getInstance().logError("Parser was not found for label " + 6005); //$NON-NLS-1$
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
		return edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.ClassDiagramEditPart.MODEL_ID
				.equals(edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOVisualIDRegistry
						.getModelID(view));
	}

}

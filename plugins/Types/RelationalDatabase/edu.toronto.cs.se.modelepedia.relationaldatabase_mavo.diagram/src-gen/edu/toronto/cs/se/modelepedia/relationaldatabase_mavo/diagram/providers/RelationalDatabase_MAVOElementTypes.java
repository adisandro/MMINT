/*
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.providers.DiagramElementTypeImages;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.providers.DiagramElementTypes;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

/**
 * @generated
 */
public class RelationalDatabase_MAVOElementTypes {

	/**
	* @generated
	*/
	private RelationalDatabase_MAVOElementTypes() {
	}

	/**
	* @generated
	*/
	private static Map<IElementType, ENamedElement> elements;

	/**
	* @generated
	*/
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(
			edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVODiagramEditorPlugin
					.getInstance().getItemProvidersAdapterFactory());

	/**
	* @generated
	*/
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	* @generated
	*/
	public static final IElementType RelationalDatabase_1000 = getElementType(
			"edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.RelationalDatabase_1000"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Table_2001 = getElementType(
			"edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.Table_2001"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Column_3001 = getElementType(
			"edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.Column_3001"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType ForeignKey_3002 = getElementType(
			"edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.ForeignKey_3002"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType TableColumnReference_4001 = getElementType(
			"edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.TableColumnReference_4001"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType ForeignColumnReference_4002 = getElementType(
			"edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.ForeignColumnReference_4002"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		return elementTypeImages.getImageDescriptor(element);
	}

	/**
	* @generated
	*/
	public static Image getImage(ENamedElement element) {
		return elementTypeImages.getImage(element);
	}

	/**
	* @generated
	*/
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		return getImageDescriptor(getElement(hint));
	}

	/**
	* @generated
	*/
	public static Image getImage(IAdaptable hint) {
		return getImage(getElement(hint));
	}

	/**
	* Returns 'type' of the ecore object associated with the hint.
	* 
	* @generated
	*/
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap<IElementType, ENamedElement>();

			elements.put(RelationalDatabase_1000,
					edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.RelationalDatabase_MAVOPackage.eINSTANCE
							.getRelationalDatabase());

			elements.put(Table_2001,
					edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.RelationalDatabase_MAVOPackage.eINSTANCE
							.getTable());

			elements.put(Column_3001,
					edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.RelationalDatabase_MAVOPackage.eINSTANCE
							.getColumn());

			elements.put(ForeignKey_3002,
					edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.RelationalDatabase_MAVOPackage.eINSTANCE
							.getForeignKey());

			elements.put(TableColumnReference_4001,
					edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.RelationalDatabase_MAVOPackage.eINSTANCE
							.getTableColumnReference());

			elements.put(ForeignColumnReference_4002,
					edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.RelationalDatabase_MAVOPackage.eINSTANCE
							.getForeignColumnReference());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	* @generated
	*/
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	* @generated
	*/
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(RelationalDatabase_1000);
			KNOWN_ELEMENT_TYPES.add(Table_2001);
			KNOWN_ELEMENT_TYPES.add(Column_3001);
			KNOWN_ELEMENT_TYPES.add(ForeignKey_3002);
			KNOWN_ELEMENT_TYPES.add(TableColumnReference_4001);
			KNOWN_ELEMENT_TYPES.add(ForeignColumnReference_4002);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	* @generated
	*/
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.RelationalDatabaseEditPart.VISUAL_ID:
			return RelationalDatabase_1000;
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.TableEditPart.VISUAL_ID:
			return Table_2001;
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ColumnEditPart.VISUAL_ID:
			return Column_3001;
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ForeignKeyEditPart.VISUAL_ID:
			return ForeignKey_3002;
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.TableColumnReferenceEditPart.VISUAL_ID:
			return TableColumnReference_4001;
		case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ForeignColumnReferenceEditPart.VISUAL_ID:
			return ForeignColumnReference_4002;
		}
		return null;
	}

	/**
	* @generated
	*/
	public static final DiagramElementTypes TYPED_INSTANCE = new DiagramElementTypes(elementTypeImages) {

		/**
		* @generated
		*/
		@Override

		public boolean isKnownElementType(IElementType elementType) {
			return edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.providers.RelationalDatabase_MAVOElementTypes
					.isKnownElementType(elementType);
		}

		/**
		* @generated
		*/
		@Override

		public IElementType getElementTypeForVisualId(int visualID) {
			return edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.providers.RelationalDatabase_MAVOElementTypes
					.getElementType(visualID);
		}

		/**
		* @generated
		*/
		@Override

		public ENamedElement getDefiningNamedElement(IAdaptable elementTypeAdapter) {
			return edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.providers.RelationalDatabase_MAVOElementTypes
					.getElement(elementTypeAdapter);
		}
	};

}

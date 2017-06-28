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
package edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.providers;

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
public class NECSIS14_DatabaseSchemaElementTypes {

	/**
	 * @generated
	 */
	private NECSIS14_DatabaseSchemaElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map<IElementType, ENamedElement> elements;

	/**
	 * @generated
	 */
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(
			edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaDiagramEditorPlugin
					.getInstance().getItemProvidersAdapterFactory());

	/**
	 * @generated
	 */
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType DatabaseSchema_1000 = getElementType("edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.DatabaseSchema_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Table_2001 = getElementType("edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.Table_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Column_3001 = getElementType("edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.Column_3001"); //$NON-NLS-1$

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

			elements.put(
					DatabaseSchema_1000,
					edu.toronto.cs.se.modelepedia.necsis14_databaseschema.NECSIS14_DatabaseSchemaPackage.eINSTANCE
							.getDatabaseSchema());

			elements.put(
					Table_2001,
					edu.toronto.cs.se.modelepedia.necsis14_databaseschema.NECSIS14_DatabaseSchemaPackage.eINSTANCE
							.getTable());

			elements.put(
					Column_3001,
					edu.toronto.cs.se.modelepedia.necsis14_databaseschema.NECSIS14_DatabaseSchemaPackage.eINSTANCE
							.getColumn());
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
			KNOWN_ELEMENT_TYPES.add(DatabaseSchema_1000);
			KNOWN_ELEMENT_TYPES.add(Table_2001);
			KNOWN_ELEMENT_TYPES.add(Column_3001);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.edit.parts.DatabaseSchemaEditPart.VISUAL_ID:
			return DatabaseSchema_1000;
		case edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.edit.parts.TableEditPart.VISUAL_ID:
			return Table_2001;
		case edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.edit.parts.ColumnEditPart.VISUAL_ID:
			return Column_3001;
		}
		return null;
	}

	/**
	 * @generated
	 */
	public static final DiagramElementTypes TYPED_INSTANCE = new DiagramElementTypes(
			elementTypeImages) {

		/**
		 * @generated
		 */
		@Override
		public boolean isKnownElementType(IElementType elementType) {
			return edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.providers.NECSIS14_DatabaseSchemaElementTypes
					.isKnownElementType(elementType);
		}

		/**
		 * @generated
		 */
		@Override
		public IElementType getElementTypeForVisualId(int visualID) {
			return edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.providers.NECSIS14_DatabaseSchemaElementTypes
					.getElementType(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public ENamedElement getDefiningNamedElement(
				IAdaptable elementTypeAdapter) {
			return edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.providers.NECSIS14_DatabaseSchemaElementTypes
					.getElement(elementTypeAdapter);
		}
	};

}

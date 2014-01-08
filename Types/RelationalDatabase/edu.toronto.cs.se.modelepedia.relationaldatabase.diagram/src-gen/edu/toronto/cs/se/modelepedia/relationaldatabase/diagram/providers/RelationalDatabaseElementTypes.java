/*
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

import edu.toronto.cs.se.modelepedia.relationaldatabase.RelationalDatabasePackage;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.parts.ColumnEditPart;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.parts.ForeignKeyEditPart;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.parts.ForeignKeyForeignColumnEditPart;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.parts.ForeignKeyTableColumnEditPart;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.parts.RelationalDatabaseEditPart;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.parts.TableEditPart;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.part.RelationalDatabaseDiagramEditorPlugin;

/**
 * @generated
 */
public class RelationalDatabaseElementTypes {

	/**
	 * @generated
	 */
	private RelationalDatabaseElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map<IElementType, ENamedElement> elements;

	/**
	 * @generated
	 */
	private static ImageRegistry imageRegistry;

	/**
	 * @generated
	 */
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType RelationalDatabase_1000 = getElementType("edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.RelationalDatabase_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Table_2001 = getElementType("edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.Table_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Column_3001 = getElementType("edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.Column_3001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ForeignKey_3002 = getElementType("edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.ForeignKey_3002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ForeignKeyTableColumn_4001 = getElementType("edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.ForeignKeyTableColumn_4001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ForeignKeyForeignColumn_4002 = getElementType("edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.ForeignKeyForeignColumn_4002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static ImageRegistry getImageRegistry() {
		if (imageRegistry == null) {
			imageRegistry = new ImageRegistry();
		}
		return imageRegistry;
	}

	/**
	 * @generated
	 */
	private static String getImageRegistryKey(ENamedElement element) {
		return element.getName();
	}

	/**
	 * @generated
	 */
	private static ImageDescriptor getProvidedImageDescriptor(
			ENamedElement element) {
		if (element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature) element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if (eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if (eType instanceof EClass
					&& !((EClass) eType).isAbstract()) {
				element = eType;
			}
		}
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (!eClass.isAbstract()) {
				return RelationalDatabaseDiagramEditorPlugin.getInstance()
						.getItemImageDescriptor(
								eClass.getEPackage().getEFactoryInstance()
										.create(eClass));
			}
		}
		// TODO : support structural features
		return null;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		String key = getImageRegistryKey(element);
		ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);
		if (imageDescriptor == null) {
			imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
		}
		return imageDescriptor;
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		String key = getImageRegistryKey(element);
		Image image = getImageRegistry().get(key);
		if (image == null) {
			ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
			image = getImageRegistry().get(key);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImage(element);
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
					RelationalDatabasePackage.eINSTANCE.getRelationalDatabase());

			elements.put(Table_2001,
					RelationalDatabasePackage.eINSTANCE.getTable());

			elements.put(Column_3001,
					RelationalDatabasePackage.eINSTANCE.getColumn());

			elements.put(ForeignKey_3002,
					RelationalDatabasePackage.eINSTANCE.getForeignKey());

			elements.put(ForeignKeyTableColumn_4001,
					RelationalDatabasePackage.eINSTANCE
							.getForeignKey_TableColumn());

			elements.put(ForeignKeyForeignColumn_4002,
					RelationalDatabasePackage.eINSTANCE
							.getForeignKey_ForeignColumn());
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
			KNOWN_ELEMENT_TYPES.add(ForeignKeyTableColumn_4001);
			KNOWN_ELEMENT_TYPES.add(ForeignKeyForeignColumn_4002);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case RelationalDatabaseEditPart.VISUAL_ID:
			return RelationalDatabase_1000;
		case TableEditPart.VISUAL_ID:
			return Table_2001;
		case ColumnEditPart.VISUAL_ID:
			return Column_3001;
		case ForeignKeyEditPart.VISUAL_ID:
			return ForeignKey_3002;
		case ForeignKeyTableColumnEditPart.VISUAL_ID:
			return ForeignKeyTableColumn_4001;
		case ForeignKeyForeignColumnEditPart.VISUAL_ID:
			return ForeignKeyForeignColumn_4002;
		}
		return null;
	}

}

/**
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.common.util.EList;

import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.editor.Editor;
import edu.toronto.cs.se.mmint.mid.library.MIDRegistry;
import edu.toronto.cs.se.mmint.mid.operator.ConversionOperator;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogUtils;
import edu.toronto.cs.se.mmint.repository.ExtensionType;

/**
 * Utilities to deal with the hierarchy of types.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MIDTypeHierarchy {
	//TODO MMINT[MISC] are type and type ref iterators really needed, or are the lists already ordered by construction?

	/**
	 * The comparator for a hierarchy of types from registered extensions.
	 * 
	 * @author Alessio Di Sandro
	 *
	 */
	private static class ExtensionHierarchyComparator implements Comparator<IConfigurationElement> {

		/** The map from a uri to its supertype uri within the hierarchy of extensions. */
		private HashMap<String, String> extensionUris;
		/** The name of the xml child to be used in the extensions. */
		private String childName;
		/** The root uri in the hierarchy. */
		private String rootUri;

		/**
		 * Constructor: initializes the comparator.
		 * 
		 * @param extensionUris
		 *            The map from a uri to its supertype uri within the
		 *            hierarchy of extensions.
		 * @param childName
		 *            The name of the xml child to be used in the extensions.
		 * @param rootUri
		 *            The root uri in the hierarchy.
		 */
		public ExtensionHierarchyComparator(HashMap<String, String> extensionUris, String childName, String rootUri) {

			this.extensionUris = extensionUris;
			this.childName = childName;
			this.rootUri = rootUri;
		}

		/**
		 * Compares two extensions based on their position in the type
		 * hierarchy, i.e. by counting the number of supertypes of the type
		 * declared in the extension. {@inheritDoc}
		 */
		@Override
		public int compare(IConfigurationElement extension1, IConfigurationElement extension2) {

			if (childName != null) {
				extension1 = extension1.getChildren(childName)[0];
				extension2 = extension2.getChildren(childName)[0];
			}
			ExtensionType type1 = new ExtensionType(extension1);
			String uri1 = type1.getUri();
			String tempUri1 = uri1;
			String tempSupertypeUri1 = extensionUris.get(uri1);
			int supertypes1 = (rootUri != null && uri1.equals(rootUri)) ? -1 : 0;
			while (tempSupertypeUri1 != null) {
				supertypes1++;
				tempUri1 = tempSupertypeUri1;
				tempSupertypeUri1 = extensionUris.get(tempUri1);
			}
			ExtensionType type2 = new ExtensionType(extension2);
			String uri2 = type2.getUri();
			String tempUri2 = uri2;
			String tempSupertypeUri2 = extensionUris.get(uri2);
			int supertypes2 = (rootUri != null && uri2.equals(rootUri)) ? -1 : 0;
			while (tempSupertypeUri2 != null) {
				supertypes2++;
				tempUri2 = tempSupertypeUri2;
				tempSupertypeUri2 = extensionUris.get(tempUri2);
			}

			int relativeOrder = supertypes1 - supertypes2;
			if (relativeOrder == 0) {
				relativeOrder = uri1.compareTo(uri2);
			}

			return relativeOrder;
		}

	}

	/**
	 * The comparator for a hierarchy of types.
	 * 
	 * @author Alessio Di Sandro
	 *
	 */
	private static class TypeHierarchyComparator implements Comparator<ExtendibleElement> {

		private List<? extends ExtendibleElement> types;

		public TypeHierarchyComparator(EList<? extends ExtendibleElement> types) {

			this.types = types;
		}

		/**
		 * Compares two types based on their position in the type hierarchy,
		 * i.e. by counting the number of their supertypes.
		 */
		@Override
		public int compare(ExtendibleElement type1, ExtendibleElement type2) {

			ExtendibleElement initialType1 = type1;
			int supertypes1 = 0;
			while (type1.getSupertype() != null) {
				supertypes1++;
				type1 = type1.getSupertype();
			}
			ExtendibleElement initialType2 = type2;
			int supertypes2 = 0;
			while (type2.getSupertype() != null) {
				supertypes2++;
				type2 = type2.getSupertype();
			}

			int relativeOrder = supertypes1 - supertypes2;
			if (relativeOrder == 0) {
				relativeOrder = types.indexOf(initialType1) - types.indexOf(initialType2);
			}

			return relativeOrder;
		}
	}

	/**
	 * The comparator for a hierarchy of references to types.
	 * 
	 * @author Alessio Di Sandro
	 *
	 */
	private static class TypeRefHierarchyComparator implements Comparator<ExtendibleElementReference> {

		private List<? extends ExtendibleElementReference> typeRefs;

		public TypeRefHierarchyComparator(EList<? extends ExtendibleElementReference> typeRefs) {

			this.typeRefs = typeRefs;
		}

		/**
		 * Compares two references to types based on their position in the type
		 * hierarchy, i.e. by counting the number of references to their
		 * supertypes. {@inheritDoc}
		 */
		@Override
		public int compare(ExtendibleElementReference typeRef1, ExtendibleElementReference typeRef2) {

			ExtendibleElementReference initialTypeRef1 = typeRef1;
			int supertypes1 = 0;
			while (typeRef1.getSupertypeRef() != null) {
				supertypes1++;
				typeRef1 = typeRef1.getSupertypeRef();
			}
			ExtendibleElementReference initialTypeRef2 = typeRef2;
			int supertypes2 = 0;
			while (typeRef2.getSupertypeRef() != null) {
				supertypes2++;
				typeRef2 = typeRef2.getSupertypeRef();
			}


			int relativeOrder = supertypes1 - supertypes2;
			if (relativeOrder == 0) {
				relativeOrder = typeRefs.indexOf(initialTypeRef1) - typeRefs.indexOf(initialTypeRef2);
			}

			return relativeOrder;
		}
	}

	/**
	 * Gets an iterator to loop an array of extensions sorted according to their
	 * type hierarchy, starting from the one that declares a type with the least
	 * number of supertypes.
	 * 
	 * @param extensions
	 *            The array of extensions to be looped.
	 * @param childName
	 *            The name of the xml child to be used in the extensions.
	 * @param rootUri
	 *            The root uri in the hierarchy.
	 * @return The iterator.
	 */
	public static Iterator<IConfigurationElement> getExtensionHierarchyIterator(IConfigurationElement[] extensions, String childName, String rootUri) {

		HashMap<String, String> extensionUris = new HashMap<String, String>();
		for (IConfigurationElement extension : extensions) {
			if (childName != null) {
				extension = extension.getChildren(childName)[0];
			}
			ExtensionType type = new ExtensionType(extension);
			extensionUris.put(type.getUri(), type.getSupertypeUri());
		}
		TreeSet<IConfigurationElement> hierarchy = new TreeSet<IConfigurationElement>(
			new ExtensionHierarchyComparator(extensionUris, childName, rootUri)
		);
		for (IConfigurationElement extension : extensions) {
			hierarchy.add(extension);
		}

		return hierarchy.iterator();
	}

	/**
	 * Gets a tree set representing the type hierarchy of an array of types.
	 * 
	 * @param types
	 *            The list of types.
	 * @return The tree set.
	 */
	private static <T extends ExtendibleElement> TreeSet<T> getTypeHierarchy(EList<T> types) {

		TreeSet<T> hierarchy = new TreeSet<T>(
			new TypeHierarchyComparator(types)
		);
		for (T type : types) {
			hierarchy.add(type);
		}

		return hierarchy;
	}

	/**
	 * Gets an iterator to loop an array of types according to their type
	 * hierarchy, starting from the one with the least number of supertypes.
	 * 
	 * @param types
	 *            The list of types to be looped.
	 * @return The iterator.
	 */
	public static <T extends ExtendibleElement> Iterator<T> getTypeHierarchyIterator(EList<T> types) {

		TreeSet<T> hierarchy = getTypeHierarchy(types);

		return hierarchy.iterator();
	}

	/**
	 * Gets an iterator to loop an array of types according to their type
	 * hierarchy, starting from the one with the most number of supertypes.
	 * 
	 * @param types
	 *            The list of types to be looped.
	 * @return The iterator.
	 */
	public static <T extends ExtendibleElement> Iterator<T> getInverseTypeHierarchyIterator(EList<T> types) {

		TreeSet<T> hierarchy = getTypeHierarchy(types);

		return hierarchy.descendingIterator();
	}

	/**
	 * Gets a tree set representing the type hierarchy of an array of references
	 * to types.
	 * 
	 * @param types
	 *            The list of references to types.
	 * @return The tree set.
	 */
	private static <T extends ExtendibleElementReference> TreeSet<T> getTypeRefHierarchy(EList<T> typeRefs) {

		TreeSet<T> hierarchy = new TreeSet<T>(
			new TypeRefHierarchyComparator(typeRefs)
		);
		for (T typeRef : typeRefs) {
			hierarchy.add(typeRef);
		}

		return hierarchy;
	}

	/**
	 * Gets an iterator to loop an array of references to types according to
	 * their type hierarchy, starting from the one with the least number of
	 * references to supertypes.
	 * 
	 * @param types
	 *            The list of references to types to be looped.
	 * @return The iterator.
	 */
	public static <T extends ExtendibleElementReference> Iterator<T> getTypeRefHierarchyIterator(EList<T> typeRefs) {

		TreeSet<T> hierarchy = getTypeRefHierarchy(typeRefs);

		return hierarchy.iterator();
	}

	/**
	 * Gets an iterator to loop an array of references to types according to
	 * their type hierarchy, starting from the one with the most number of
	 * references to supertypes.
	 * 
	 * @param types
	 *            The list of references to types to be looped.
	 * @return The iterator.
	 */
	public static <T extends ExtendibleElementReference> Iterator<T> getInverseTypeRefHierarchyIterator(EList<T> typeRefs) {

		TreeSet<T> hierarchy = getTypeRefHierarchy(typeRefs);

		return hierarchy.descendingIterator();
	}

	/**
	 * Gets an extendible element in a list of extendible elements.
	 * 
	 * @param elementUri
	 *            The uri of the extendible element.
	 * @param elements
	 *            The list of extendible elements.
	 * @return The extendible element, null if it can't be found.
	 */
	public static <T extends ExtendibleElement> T get(String elementUri, EList<T> elements) {

		if (elementUri == null) {
			return null;
		}

		for (T element : elements) {
			if (elementUri.equals(element.getUri())) {
				return element;
			}
		}

		return null;
	}

	/**
	 * Gets an extendible element in a list of extendible elements.
	 * 
	 * @param correspondingElement
	 *            The corresponding extendible element, i.e. an extendible
	 *            element with the same uri of the one to get.
	 * @param elements
	 *            The list of extendible elements.
	 * @return The extendible element, null if it can't be found.
	 */
	public static <T extends ExtendibleElement> T get(T correspondingElement, EList<T> elements) {

		if (correspondingElement == null) {
			return null;
		}

		return get(correspondingElement.getUri(), elements);
	}

	/**
	 * Gets a reference to an extendible element in a list of references to
	 * extendible elements.
	 * 
	 * @param elementUri
	 *            The uri of the extendible element.
	 * @param elementRefs
	 *            The list of references to extendible elements.
	 * @return The reference to the extendible element, null if it can't be
	 *         found.
	 */
	public static <T extends ExtendibleElementReference> T getReference(String elementUri, EList<T> elementRefs) {

		if (elementUri == null) {
			return null;
		}

		for (T elementRef : elementRefs) {
			if (elementUri.equals(elementRef.getUri())) {
				return elementRef;
			}
		}

		return null;
	}

	/**
	 * Gets a reference to an extendible element in a list of references to
	 * extendible elements.
	 * 
	 * @param correspondingElementRef
	 *            The corresponding reference to extendible element, i.e. a
	 *            reference to an extendible element with the same uri of the
	 *            one to get.
	 * @param elementRefs
	 *            The list of references to extendible elements.
	 * @return The reference to the extendible element, null if it can't be
	 *         found.
	 */
	public static <T extends ExtendibleElementReference> T getReference(T correspondingElementRef, EList<T> elementRefs) {

		if (correspondingElementRef == null) {
			return null;
		}

		return getReference(correspondingElementRef.getUri(), elementRefs);
	}

	/**
	 * Gets the extendible element endpoints in a list of extendible element
	 * endpoints.
	 * 
	 * @param targetUri
	 *            The uri of the extendible element which is the target of the
	 *            endpoint.
	 * @param endpoints
	 *            The list of extendible element endpoints.
	 * @return The extendible element endpoints.
	 */
	public static <T extends ExtendibleElementEndpoint> List<T> getEndpoints(String targetUri, EList<T> endpoints) {

		if (targetUri == null) {
			return null;
		}

		List<T> targetEndpoints = new ArrayList<T>();
		for (T endpoint : endpoints) {
			if (targetUri.equals(endpoint.getTargetUri())) {
				targetEndpoints.add(endpoint);
			}
		}

		return targetEndpoints;
	}

	/**
	 * Gets the references to an extendible element endpoint in a list of
	 * references to extendible element endpoints.
	 * 
	 * @param targetUri
	 *            The uri of the extendible element which is the target of the
	 *            endpoint.
	 * @param endpointRefs
	 *            The list of references to extendible element endpoints.
	 * @return The references to the extendible element endpoints.
	 */
	public static <T extends ExtendibleElementEndpointReference> List<T> getEndpointReferences(String targetUri, EList<T> endpointRefs) {

		if (targetUri == null) {
			return null;
		}

		List<T> targetEndpointRefs = new ArrayList<T>();
		for (T endpointRef : endpointRefs) {
			if (targetUri.equals(endpointRef.getTargetUri())) {
				targetEndpointRefs.add(endpointRef);
			}
		}

		return targetEndpointRefs;
	}

	/**
	 * Gets the table for subtyping in the Type MID.
	 * 
	 * @param typeMID
	 *            The Type MID.
	 * @return The table for subtyping.
	 */
	private static Map<String, Set<String>> getSubtypeTable(MID typeMID) {

		return (typeMID == MMINT.cachedTypeMID) ?
			MMINT.subtypes :
			MMINT.subtypesMID;
	}

	/**
	 * Gets the table for model type conversion in the Type
	 * MID.
	 * 
	 * @param typeMID
	 *            The Type MID.
	 * @return The table for model type conversion.
	 */
	private static Map<String, Map<String, Set<List<String>>>> getConversionTable(MID typeMID) {

		return (typeMID == MMINT.cachedTypeMID) ?
			MMINT.conversions :
			MMINT.conversionsMID;
	}

	public static Map<Model, Set<List<ConversionOperator>>> getMultiplePathConversions(String srcModelTypeUri) {

		Map<String, Set<List<String>>> srcModelTypeConversionUris = getConversionTable(MMINT.cachedTypeMID).get(srcModelTypeUri);
		Map<Model, Set<List<ConversionOperator>>> multiplePathConversions = new HashMap<Model, Set<List<ConversionOperator>>>();
		for (Map.Entry<String, Set<List<String>>> srcModelTypeConversionUrisEntry : srcModelTypeConversionUris.entrySet()) {
			if (srcModelTypeConversionUrisEntry.getValue().size() == 1) {
				continue;
			}
			Set<List<ConversionOperator>> conversionPaths = new HashSet<List<ConversionOperator>>();
			multiplePathConversions.put(MIDTypeRegistry.<Model>getType(srcModelTypeConversionUrisEntry.getKey()), conversionPaths);
			for (List<String> conversionPathUris : srcModelTypeConversionUrisEntry.getValue()) {
				List<ConversionOperator> conversionPath = new ArrayList<ConversionOperator>();
				conversionPaths.add(conversionPath);
				for (String conversionUri : conversionPathUris) {
					conversionPath.add(MIDTypeRegistry.<ConversionOperator>getType(conversionUri));
				}
			}
		}

		return multiplePathConversions;
	}

	/**
	 * Determines if a subtype-supertype relationship holds for two types.
	 * 
	 * @param subtypeUri
	 *            The uri of the subtype.
	 * @param supertypeUri
	 *            The uri of the supertype.
	 * @param typeMID
	 *            The Type MID.
	 * @return True if the subtype-supertype relationship holds, false
	 *         otherwise.
	 */
	public static boolean isSubtypeOf(String subtypeUri, String supertypeUri, MID typeMID) {

		Map<String, Set<String>> subtypeTable = getSubtypeTable(typeMID);
		if (subtypeTable == null) {
			return false;
		}
		Set<String> subtypes = subtypeTable.get(supertypeUri);
		if (subtypes == null) {
			return false;
		}

		return subtypes.contains(subtypeUri);
	}

	/**
	 * Determines if a subtype-supertype relationship holds for two types in the
	 * repository.
	 * 
	 * @param subtypeUri
	 *            The uri of the subtype.
	 * @param supertypeUri
	 *            The uri of the supertype.
	 * @return True if the subtype-supertype relationship holds, false
	 *         otherwise.
	 */
	public static boolean isSubtypeOf(String subtypeUri, String supertypeUri) {

		return isSubtypeOf(subtypeUri, supertypeUri, MMINT.cachedTypeMID);
	}

	/**
	 * Determines if an element is an instance of a type (conversions included).
	 * 
	 * @param element
	 *            The element.
	 * @param typeUri
	 *            The uri of the type.
	 * @return An empty list if the element is an instance of the type or one of its subtypes, a list of conversion
	 *         operators to be run to convert the element into an equivalent one which in turn is an instance of the
	 *         type or one of its subtypes, or null otherwise.
	 */
	public static List<ConversionOperator> instanceOf(ExtendibleElement element, String typeUri) {

		List<ConversionOperator> conversionOperatorTypes = new ArrayList<>();
		// static check
		if (element.getMetatypeUri().equals(typeUri) || isSubtypeOf(element.getMetatypeUri(), typeUri)) {
			return conversionOperatorTypes;
		}
		// polymorphic check
		List<ExtendibleElement> runtimeTypes;
		try {
			runtimeTypes = element.getRuntimeTypes();
		}
		catch (MMINTException e) {
			return null;
		}
		for (ExtendibleElement runtimeType : runtimeTypes) {
			if (runtimeType.getUri().equals(typeUri) || isSubtypeOf(runtimeType.getUri(), typeUri)) {
				return conversionOperatorTypes;
			}
		}
		// conversion check
		for (ExtendibleElement runtimeType : runtimeTypes) {
			Map<String, Set<List<String>>> conversions = getConversionTable(MMINT.cachedTypeMID).get(runtimeType.getUri());
			for (Map.Entry<String, Set<List<String>>> conversion : conversions.entrySet()) {
				String convertedRuntimeTypeUri = conversion.getKey();
				if (typeUri.equals(convertedRuntimeTypeUri) || isSubtypeOf(convertedRuntimeTypeUri, typeUri)) {
					for (List<String> conversionOperatorPath : conversion.getValue()) {
						for (String conversionOperatorTypeUri : conversionOperatorPath) {
							ConversionOperator conversionOperatorType = MIDTypeRegistry.getType(conversionOperatorTypeUri);
							conversionOperatorTypes.add(conversionOperatorType);
						}
						break; // use first conversion found
					}
					return conversionOperatorTypes;
				}
			}
		}

		return null;
	}

	/**
	 * Determines if an element is an instance of a type.
	 * 
	 * @param element
	 *            The element.
	 * @param typeUri
	 *            The uri of the type.
	 * @param includeConversions
	 *            True if conversions should be included, false otherwise.
	 * @return True if the element is an instance of the type or one of its subtypes.
	 */
	public static boolean instanceOf(ExtendibleElement element, String typeUri, boolean includeConversions) {

		List<ConversionOperator> conversionOperatorTypes = instanceOf(element, typeUri);
		
		return (conversionOperatorTypes == null || (!includeConversions && !conversionOperatorTypes.isEmpty())) ?
			false :
			true;
	}

	/**
	 * Gets all the subtypes of a type.
	 * 
	 * @param type
	 *            The type.
	 * @param typeMID
	 *            The Type MID.
	 * @return The list of subtypes of the type.
	 */
	public static <T extends ExtendibleElement> List<T> getSubtypes(T type, MID typeMID) {

		List<T> subtypes = new ArrayList<>();
		Map<String, Set<String>> subtypeTable = getSubtypeTable(typeMID);
		if (subtypeTable == null) {
			return subtypes;
		}

		for (String subtypeUri : subtypeTable.get(type.getUri())) {
			T subtype = MIDRegistry.getExtendibleElement(subtypeUri, typeMID);
			if (subtype != null) {
				subtypes.add(subtype);
			}
		}
		return subtypes;
	}

	/**
	 * Gets all the direct subtypes of a type.
	 * 
	 * @param type
	 *            The type.
	 * @param typeMID
	 *            The Type MID.
	 * @return The list of direct subtypes of the type.
	 */
	public static <T extends ExtendibleElement> List<T> getDirectSubtypes(T type, MID typeMID) {

		List<T> subtypes = new ArrayList<T>();
		Map<String, Set<String>> subtypeTable = getSubtypeTable(typeMID);
		if (subtypeTable == null) {
			return subtypes;
		}

		for (String subtypeUri : subtypeTable.get(type.getUri())) {
			T subtype = MIDRegistry.getExtendibleElement(subtypeUri, typeMID);
			if (subtype != null && subtype.getSupertype() == type) {
				subtypes.add(subtype);
			}
		}
		return subtypes;
	}

	/**
	 * Gets all the subtypes of a type in the repository.
	 * 
	 * @param type
	 *            The type.
	 * @return The list of subtypes of the type.
	 */
	public static <T extends ExtendibleElement> List<T> getSubtypes(T type) {

		return getSubtypes(type, MMINT.cachedTypeMID);
	}

	public static List<GenericElement> getGenericSubtypes(GenericElement type) {

		/*TODO MMINT[OPERATOR]
		 * This should really be unified with the above one, which is easy if we assign Operator as root of all operators
		 * (and avoid to show inheritance arrows for it in the Type MID)
		 */
		if (type instanceof Operator && isRootType(type)) { // wildcard to select all operators
			List<GenericElement> allOperatorTypes = new ArrayList<>(MIDTypeRegistry.getOperatorTypes());
			allOperatorTypes.remove(type);
			return allOperatorTypes;
		}
		return getSubtypes(type, MMINT.cachedTypeMID);
	}

	/**
	 * Gets something hacky related to the multiple inheritance of a type in the
	 * repository.
	 * 
	 * @param typeUri
	 *            The uri of the type.
	 * @return That something hacky.
	 */
	public static Set<String> getMultipleInheritanceUris(String typeUri) {

		Set<String> uris = MMINT.multipleInheritanceTable.get(typeUri);
		if (uris == null) {
			uris = new HashSet<String>();
		}

		return uris;
	}

	/**
	 * Gets the uri of the root type for a certain class of types.
	 * 
	 * @param type
	 *            The type from which to understand the class of types.
	 * @return The uri of the root type.
	 */
	public static String getRootTypeUri(ExtendibleElement type) {
	
		String rootUri = "";
		if (type instanceof ModelRel) {
			rootUri = MMINT.ROOT_MODELREL_URI;
		}
		else if (type instanceof Model) {
			rootUri = MMINT.ROOT_MODEL_URI;
		}
		else if (type instanceof ModelEndpoint) {
			rootUri = MMINT.ROOT_MODELENDPOINT_URI;
		}
		else if (type instanceof ModelElement) {
			rootUri = MMINT.ROOT_MODELELEM_URI;
		}
		else if (type instanceof Mapping) {
			rootUri = MMINT.ROOT_MAPPING_URI;
		}
		else if (type instanceof ModelElementEndpoint) {
			rootUri = MMINT.ROOT_MODELELEMENDPOINT_URI;
		}
		else if (type instanceof Operator) {
			rootUri = MMINT.ROOT_OPERATOR_URI;
		}
		else if (type instanceof Editor) {
			rootUri = MMINT.ROOT_EDITOR_URI;
		}
	
		return rootUri;
	}

	public static Model getRootModelType() {

		return MIDTypeRegistry.getType(MMINT.ROOT_MODEL_URI);
	}

	public static ModelRel getRootModelRelType() {

		return MIDTypeRegistry.getType(MMINT.ROOT_MODELREL_URI);
	}

	public static ModelEndpoint getRootModelTypeEndpoint() {

		return MIDTypeRegistry.getType(MMINT.ROOT_MODELENDPOINT_URI);
	}

	public static ModelElement getRootModelElementType() {

		return MIDTypeRegistry.getType(MMINT.ROOT_MODELELEM_URI);
	}

	public static Mapping getRootMappingType() {

		return MIDTypeRegistry.getType(MMINT.ROOT_MAPPING_URI);
	}

	public static ModelElementEndpoint getRootModelElementTypeEndpoint() {

		return MIDTypeRegistry.getType(MMINT.ROOT_MODELELEMENDPOINT_URI);
	}

	public static Editor getRootEditorType() {

		return MIDTypeRegistry.getType(MMINT.ROOT_EDITOR_URI);
	}

	/**
	 * Checks if the given type is the root type for its class.
	 * 
	 * @param type
	 *            The type to be checked.
	 * @return True if the given type is the root type, false otherwise.
	 */
	public static boolean isRootType(ExtendibleElement type) {

		return type.getUri().equals(getRootTypeUri(type));
	}

	//TODO[MODELENDPOINT] returns null for non-overriding, or overridden model type endpoint (which can be the root one)
	public static ModelEndpoint getOverriddenModelTypeEndpoint(ModelRel modelRelType, Model targetModelType) {

		boolean isBinary = (modelRelType instanceof BinaryModelRel);
		MID typeMID = MIDRegistry.getMultiModel(modelRelType);
		modelRelType = (ModelRel) modelRelType.getSupertype();
		while (!isRootType(modelRelType)) {
			for (ModelEndpoint modelTypeEndpoint : modelRelType.getModelEndpoints()) {
				if (isBinary && targetModelType.getUri().equals(modelTypeEndpoint.getTargetUri())) {
					return null;
				}
				if (MIDTypeHierarchy.isSubtypeOf(targetModelType.getUri(), modelTypeEndpoint.getTargetUri(), typeMID)) {
					if (!isBinary) {
						if (!MIDDialogUtils.getBooleanInput("Override model type endpoint", "Override " + modelTypeEndpoint.getName() + "?")) {
							continue;
						}
					}
					return modelTypeEndpoint;
				}
			}
			modelRelType = (ModelRel) modelRelType.getSupertype();
		}

		return MIDRegistry.getExtendibleElement(MMINT.ROOT_MODELENDPOINT_URI, typeMID);
	}

	public static ModelElementEndpoint getOverriddenModelElementTypeEndpoint(MappingReference mappingTypeRef, ModelElementReference targetModelElemTypeRef) {

		boolean isBinary = (mappingTypeRef instanceof BinaryMappingReference);
		MID typeMID = MIDRegistry.getMultiModel(mappingTypeRef);
		Mapping mappingType = mappingTypeRef.getObject().getSupertype();
		while (!isRootType(mappingType)) {
			for (ModelElementEndpoint modelElemTypeEndpoint : mappingType.getModelElemEndpoints()) {
				if (isBinary && targetModelElemTypeRef.getUri().equals(modelElemTypeEndpoint.getTargetUri())) {
					return null;
				}
				if (MIDTypeHierarchy.isSubtypeOf(targetModelElemTypeRef.getUri(), modelElemTypeEndpoint.getTargetUri(), typeMID)) {
					if (!isBinary) {
						if (!MIDDialogUtils.getBooleanInput("Override model element type endpoint", "Override " + modelElemTypeEndpoint.getName() + "?")) {
							continue;
						}
					}
					return modelElemTypeEndpoint;
				}
			}
			mappingType = mappingType.getSupertype();
		}

		return MIDRegistry.getExtendibleElement(MMINT.ROOT_MODELELEMENDPOINT_URI, typeMID);
	}

	public static List<? extends ExtendibleElement> getCachedRuntimeTypes(ExtendibleElement instance) {

		return MMINT.cachedRuntimeTypes.get(instance);
	}

	public static void addCachedRuntimeTypes(ExtendibleElement instance, List<? extends ExtendibleElement> cachedTypes) {

		MMINT.cachedRuntimeTypes.put(instance, cachedTypes);
	}

	//TODO MMINT[OO] Make it a safe caching mechanism, not to be invalidated explicitly
	public static void clearCachedRuntimeTypes() {

		MMINT.cachedRuntimeTypes.clear();
	}

}

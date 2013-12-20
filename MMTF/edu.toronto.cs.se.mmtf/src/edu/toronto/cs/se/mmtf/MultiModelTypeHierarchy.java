/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf;

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

import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElementEndpoint;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.operator.ConversionOperator;
import edu.toronto.cs.se.mmtf.mid.operator.Operator;
import edu.toronto.cs.se.mmtf.mid.operator.Parameter;
import edu.toronto.cs.se.mmtf.mid.relationship.ExtendibleElementEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ExtendibleElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.repository.ExtensionType;

/**
 * Utilities to deal with the hierarchy of types.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MultiModelTypeHierarchy {
	//TODO MMTF: are type and type ref iterators really needed, or are the lists already ordered by construction?

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

		/**
		 * Compares two types based on their position in the type hierarchy,
		 * i.e. by counting the number of their supertypes. {@inheritDoc}
		 */
		@Override
		public int compare(ExtendibleElement type1, ExtendibleElement type2) {

			int supertypes1 = 0;
			while (type1.getSupertype() != null) {
				supertypes1++;
				type1 = type1.getSupertype();
			}
			int supertypes2 = 0;
			while (type2.getSupertype() != null) {
				supertypes2++;
				type2 = type2.getSupertype();
			}

			int relativeOrder = supertypes1 - supertypes2;
			if (relativeOrder == 0) {
				relativeOrder = type1.getUri().compareTo(type2.getUri());
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

		/**
		 * Compares two references to types based on their position in the type
		 * hierarchy, i.e. by counting the number of references to their
		 * supertypes. {@inheritDoc}
		 */
		@Override
		public int compare(ExtendibleElementReference typeRef1, ExtendibleElementReference typeRef2) {

			int supertypes1 = 0;
			while (typeRef1.getSupertypeRef() != null) {
				supertypes1++;
				typeRef1 = typeRef1.getSupertypeRef();
			}
			int supertypes2 = 0;
			while (typeRef2.getSupertypeRef() != null) {
				supertypes2++;
				typeRef2 = typeRef2.getSupertypeRef();
			}


			int relativeOrder = supertypes1 - supertypes2;
			if (relativeOrder == 0) {
				relativeOrder = typeRef1.getUri().compareTo(typeRef2.getUri());
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
			new TypeHierarchyComparator()
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
			new TypeRefHierarchyComparator()
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
	 * Gets an extendible element endpoint in a list of extendible element
	 * endpoints.
	 * 
	 * @param targetUri
	 *            The uri of the extendible element which is the target of the
	 *            endpoint.
	 * @param endpoints
	 *            The list of extendible element endpoints.
	 * @return The extendible element endpoint, null if it can't be found.
	 */
	public static <T extends ExtendibleElementEndpoint> T getEndpoint(String targetUri, EList<T> endpoints) {

		if (targetUri == null) {
			return null;
		}

		for (T endpoint : endpoints) {
			if (targetUri.equals(endpoint.getTargetUri())) {
				return endpoint;
			}
		}

		return null;
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
	 * @return The references to the extendible element endpoint, null if it
	 *         can't be found.
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
	 * Gets the table for subtyping in the repository or the Type MID.
	 * 
	 * @param multiModel
	 *            The repository, or the Type MID.
	 * @return The table for subtyping.
	 */
	private static Map<String, Set<String>> getSubtypeTable(MultiModel multiModel) {

		return (multiModel == MMTF.repository) ?
			MMTF.subtypeTable :
			MMTF.subtypeTableMID;
	}

	/**
	 * Gets the table for model type conversion in the repository or the Type
	 * MID.
	 * 
	 * @param multiModel
	 *            The repository, or the Type MID.
	 * @return The table for model type conversion.
	 */
	private static Map<String, Map<String, List<String>>> getConversionTable(MultiModel multiModel) {

		return (multiModel == MMTF.repository) ?
			MMTF.conversionTable :
			MMTF.conversionTableMID;
	}

	/**
	 * Determines if a subtype-supertype relationship holds for two types.
	 * 
	 * @param subtypeUri
	 *            The uri of the subtype.
	 * @param supertypeUri
	 *            The uri of the supertype.
	 * @param multiModel
	 *            The repository, or the Type MID.
	 * @return True if the subtype-supertype relationship holds, false
	 *         otherwise.
	 */
	public static boolean isSubtypeOf(String subtypeUri, String supertypeUri, MultiModel multiModel) {

		Map<String, Set<String>> subtypeTable = getSubtypeTable(multiModel);

		return (subtypeTable == null) ? false : subtypeTable.get(supertypeUri).contains(subtypeUri);
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

		return isSubtypeOf(subtypeUri, supertypeUri, MMTF.repository);
	}

	/**
	 * Gets all the subtypes of a type.
	 * 
	 * @param type
	 *            The type.
	 * @param multiModel
	 *            The repository, or the Type MID.
	 * @return The list of subtypes of the type.
	 */
	public static <T extends ExtendibleElement> List<T> getSubtypes(T type, MultiModel multiModel) {

		List<T> subtypes = new ArrayList<T>();
		Map<String, Set<String>> subtypeTable = getSubtypeTable(multiModel);
		if (subtypeTable == null) {
			return subtypes;
		}

		for (String subtypeUri : subtypeTable.get(type.getUri())) {
			T subtype = MultiModelRegistry.getExtendibleElement(subtypeUri, multiModel);
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
	 * @param multiModel
	 *            The repository, or the Type MID.
	 * @return The list of direct subtypes of the type.
	 */
	public static <T extends ExtendibleElement> List<T> getDirectSubtypes(T type, MultiModel multiModel) {

		List<T> subtypes = new ArrayList<T>();
		Map<String, Set<String>> subtypeTable = getSubtypeTable(multiModel);
		if (subtypeTable == null) {
			return subtypes;
		}

		for (String subtypeUri : subtypeTable.get(type.getUri())) {
			T subtype = MultiModelRegistry.getExtendibleElement(subtypeUri, multiModel);
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

		return getSubtypes(type, MMTF.repository);
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

		Set<String> uris = MMTF.multipleInheritanceTable.get(typeUri);
		if (uris == null) {
			uris = new HashSet<String>();
		}

		return uris;
	}

	/**
	 * Determines if an actual parameter is eligible for the invocation of an
	 * operator.
	 * 
	 * @param actualModelTypes
	 *            The list of model types obtained through polymorphism from the
	 *            single actual model parameter.
	 * @param formalModelType
	 *            The formal model type parameter in the operator signature.
	 * @return If the actual parameter is eligible, a list of conversion
	 *         operators that need to be run to convert the actual parameter
	 *         into an equivalent one, or an empty list to use the actual
	 *         parameter as is; null if the actual parameter is not eligible.
	 */
	private static List<ConversionOperator> isEligibleParameter(List<Model> actualModelTypes, Model formalModelType) {

		// polymorphism
		List<String> actualModelTypeUris = new ArrayList<String>();
		for (Model actualModelType : actualModelTypes) {
			actualModelTypeUris.add(actualModelType.getUri());
		}
		String formalModelTypeUri = formalModelType.getUri();
		if (actualModelTypeUris.contains(formalModelTypeUri)) {
			return new ArrayList<ConversionOperator>();
		}

		// convertible type
		for (String actualModelTypeUri : actualModelTypeUris) {
			Map<String, List<String>> conversions = getConversionTable(MMTF.repository).get(actualModelTypeUri);
			for (Map.Entry<String, List<String>> conversion : conversions.entrySet()) {
				// use first substitution found
				String convertedActualModelTypeUri = conversion.getKey();
				if (formalModelTypeUri.equals(convertedActualModelTypeUri) || isSubtypeOf(convertedActualModelTypeUri, formalModelTypeUri)) {
					List<ConversionOperator> conversionOperatorTypes = new ArrayList<ConversionOperator>();
					for (String conversionOperatorTypeUri : conversion.getValue()) {
						ConversionOperator conversionOperatorType = MultiModelTypeRegistry.getType(conversionOperatorTypeUri);
						conversionOperatorTypes.add(conversionOperatorType);
					}
					return conversionOperatorTypes;
				}
			}
		}

		return null;
	}

	/**
	 * Gets the list of executable operators given a list of actual parameters
	 * to be used for their invocation.
	 * 
	 * @param actualModels
	 *            The list of actual model parameters.
	 * @param actualModelTypes
	 *            A list of model types obtained through polymorphism for each
	 *            actual model parameter.
	 * @param conversions
	 *            Used as output, a list of conversion operators for each
	 *            executable operator and for each actual model parameter to be
	 *            converted into an equivalent one. The actual model parameter
	 *            to be converted is given by the integer index of the map, to
	 *            avoid the creation of many empty lists.
	 * @return The list of executable operators.
	 */
	public static List<Operator> getExecutableOperators(EList<Model> actualModels, List<List<Model>> actualModelTypes, List<Map<Integer, List<ConversionOperator>>> conversions) {

		List<Operator> executableOperatorTypes = new ArrayList<Operator>();

nextOperatorType:
		for (Operator operatorType : MultiModelTypeRegistry.getOperatorTypes()) {
			int i = 0;
			Map<Integer, List<ConversionOperator>> conversionMap = new HashMap<Integer, List<ConversionOperator>>();
			for (Parameter parameter : operatorType.getInputs()) {
				// check 1: not enough actual parameters
				if (i >= actualModels.size()) {
					continue nextOperatorType;
				}
				// check 2: type or substitutable types
				while (i < actualModels.size()) {
					Model actualParameter = actualModels.get(i);
					Model formalParameter = parameter.getModel();
					// easy if formal parameter is root type for actual parameter
					if (!MultiModelTypeHierarchy.isRootType(formalParameter) || !formalParameter.getClass().isAssignableFrom(actualParameter.getClass())) {
						List<ConversionOperator> conversionOperatorTypes = MultiModelTypeHierarchy.isEligibleParameter(actualModelTypes.get(i), formalParameter);
						if (conversionOperatorTypes == null) {
							continue nextOperatorType;
						}
						if (!conversionOperatorTypes.isEmpty()) {
							conversionMap.put(new Integer(i), conversionOperatorTypes);
						}
					}
					i++;
					if (!parameter.isVararg()) {
						//TODO MMTF: introduce vararg with low multiplicity
						break;
					}
				}
			}
			// check 3: too many actual parameters
			if (i < actualModels.size()) {
				continue nextOperatorType;
			}
			// checks passed
			executableOperatorTypes.add(operatorType);
			conversions.add(conversionMap);
		}

		return executableOperatorTypes;
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
			rootUri = MMTF.ROOT_MODELREL_URI;
		}
		else if (type instanceof Model) {
			rootUri = MMTF.ROOT_MODEL_URI;
		}
		else if (type instanceof ModelEndpoint) {
			rootUri = MMTF.ROOT_MODELENDPOINT_URI;
		}
		else if (type instanceof ModelElement) {
			rootUri = MMTF.ROOT_MODELELEM_URI;
		}
		else if (type instanceof Link) {
			rootUri = MMTF.ROOT_LINK_URI;
		}
		else if (type instanceof ModelElementEndpoint) {
			rootUri = MMTF.ROOT_MODELELEMENDPOINT_URI;
		}
		else if (type instanceof Editor) {
			rootUri = MMTF.ROOT_EDITOR_URI;
		}
		//TODO MMTF: root operator?
	
		return rootUri;
	}

	public static ModelRel getRootModelRelType() {

		return MultiModelTypeRegistry.getType(MMTF.ROOT_MODELREL_URI);
	}

	public static ModelEndpoint getRootModelEndpointType() {

		return MultiModelTypeRegistry.getType(MMTF.ROOT_MODELENDPOINT_URI);
	}

	public static Link getRootLinkType() {

		return MultiModelTypeRegistry.getType(MMTF.ROOT_LINK_URI);
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

	public static ModelEndpoint getOverriddenModelTypeEndpoint(ModelRel modelRelType, Model newModelType) {

		//TODO MMTF[MODELENDPOINT] very dumb first approach to the override problem
		while (!isRootType(modelRelType)) {
			for (ModelEndpointReference modelTypeEndpointRef : modelRelType.getModelEndpointRefs()) {
				if (MultiModelTypeHierarchy.isSubtypeOf(newModelType.getUri(), modelTypeEndpointRef.getTargetUri())) {
					//TODO MMTF[MODELENDPOINT] ask to override or not
					return modelTypeEndpointRef.getObject();
				}
			}
			modelRelType = (ModelRel) modelRelType.getSupertype();
		}

		return null;
	}

}

/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
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
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.operator.ConversionOperator;
import edu.toronto.cs.se.mmtf.mid.operator.Operator;
import edu.toronto.cs.se.mmtf.mid.operator.Parameter;
import edu.toronto.cs.se.mmtf.mid.relationship.ExtendibleElementEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ExtendibleElementReference;
import edu.toronto.cs.se.mmtf.repository.ExtensionType;
import edu.toronto.cs.se.mmtf.repository.MMTFConstants;

public class MultiModelTypeHierarchy implements MMTFConstants {

	private static class ExtensionHierarchyComparator implements Comparator<IConfigurationElement> {

		private HashMap<String, String> extensionUris;
		private String childName;
		private String rootUri;

		public ExtensionHierarchyComparator(HashMap<String, String> extensionUris, String childName, String rootUri) {

			this.extensionUris = extensionUris;
			this.childName = childName;
			this.rootUri = rootUri;
		}

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

	private static class TypeHierarchyComparator implements Comparator<ExtendibleElement> {

		@Override
		public int compare(ExtendibleElement elementType1, ExtendibleElement elementType2) {

			int supertypes1 = 0;
			while (elementType1.getSupertype() != null) {
				supertypes1++;
				elementType1 = elementType1.getSupertype();
			}
			int supertypes2 = 0;
			while (elementType2.getSupertype() != null) {
				supertypes2++;
				elementType2 = elementType2.getSupertype();
			}

			int relativeOrder = supertypes1 - supertypes2;
			if (relativeOrder == 0) {
				relativeOrder = elementType1.getUri().compareTo(elementType2.getUri());
			}

			return relativeOrder;
		}
	}

	private static class TypeRefHierarchyComparator implements Comparator<ExtendibleElementReference> {

		@Override
		public int compare(ExtendibleElementReference elementTypeRef1, ExtendibleElementReference elementTypeRef2) {

			int supertypes1 = 0;
			while (elementTypeRef1.getSupertypeRef() != null) {
				supertypes1++;
				elementTypeRef1 = elementTypeRef1.getSupertypeRef();
			}
			int supertypes2 = 0;
			while (elementTypeRef2.getSupertypeRef() != null) {
				supertypes2++;
				elementTypeRef2 = elementTypeRef2.getSupertypeRef();
			}


			int relativeOrder = supertypes1 - supertypes2;
			if (relativeOrder == 0) {
				relativeOrder = elementTypeRef1.getUri().compareTo(elementTypeRef2.getUri());
			}

			return relativeOrder;
		}
	}

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

	//TODO MMTF: are type and type ref iterators really needed, or are the lists already ordered by construction?
	private static <T extends ExtendibleElement> TreeSet<T> getTypeHierarchy(EList<T> elementTypes) {

		TreeSet<T> hierarchy = new TreeSet<T>(
			new TypeHierarchyComparator()
		);
		for (T elementType : elementTypes) {
			hierarchy.add(elementType);
		}

		return hierarchy;
	}

	public static <T extends ExtendibleElement> Iterator<T> getTypeHierarchyIterator(EList<T> elementTypes) {

		TreeSet<T> hierarchy = getTypeHierarchy(elementTypes);

		return hierarchy.iterator();
	}

	public static <T extends ExtendibleElement> Iterator<T> getInverseTypeHierarchyIterator(EList<T> elementTypes) {

		TreeSet<T> hierarchy = getTypeHierarchy(elementTypes);

		return hierarchy.descendingIterator();
	}

	private static <T extends ExtendibleElementReference> TreeSet<T> getTypeRefHierarchy(EList<T> elementTypeRefs) {

		TreeSet<T> hierarchy = new TreeSet<T>(
			new TypeRefHierarchyComparator()
		);
		for (T elementTypeRef : elementTypeRefs) {
			hierarchy.add(elementTypeRef);
		}

		return hierarchy;
	}

	public static <T extends ExtendibleElementReference> Iterator<T> getTypeRefHierarchyIterator(EList<T> elementTypeRefs) {

		TreeSet<T> hierarchy = getTypeRefHierarchy(elementTypeRefs);

		return hierarchy.iterator();
	}

	public static <T extends ExtendibleElementReference> Iterator<T> getInverseTypeRefHierarchyIterator(EList<T> elementTypeRefs) {

		TreeSet<T> hierarchy = getTypeRefHierarchy(elementTypeRefs);

		return hierarchy.descendingIterator();
	}

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

	public static <T extends ExtendibleElement> T get(T correspondingElement, EList<T> elements) {

		if (correspondingElement == null) {
			return null;
		}

		return get(correspondingElement.getUri(), elements);
	}

	public static <T extends ExtendibleElementReference> T getReference(String elementRefUri, EList<T> elementRefs) {

		if (elementRefUri == null) {
			return null;
		}

		for (T elementRef : elementRefs) {
			if (elementRefUri.equals(elementRef.getUri())) {
				return elementRef;
			}
		}

		return null;
	}

	public static <T extends ExtendibleElementReference> T getReference(T correspondingElementRef, EList<T> elementRefs) {

		if (correspondingElementRef == null) {
			return null;
		}

		return getReference(correspondingElementRef.getUri(), elementRefs);
	}

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

	private static Map<String, Set<String>> getSubtypeTable(MultiModel multiModel) {

		return (multiModel == MMTF.repository) ?
			MMTF.subtypeTable :
			MMTF.subtypeTableMID;
	}

	private static Map<String, Map<String, List<String>>> getConversionTable(MultiModel multiModel) {

		return (multiModel == MMTF.repository) ?
			MMTF.conversionTable :
			MMTF.conversionTableMID;
	}

	public static boolean isSubtypeOf(MultiModel multiModel, String subtypeUri, String supertypeUri) {

		Map<String, Set<String>> subtypeTable = getSubtypeTable(multiModel);

		return (subtypeTable == null) ? false : subtypeTable.get(supertypeUri).contains(subtypeUri);
	}

	public static boolean isSubtypeOf(String subtypeUri, String supertypeUri) {

		return isSubtypeOf(MMTF.repository, subtypeUri, supertypeUri);
	}

	public static <T extends ExtendibleElement> List<T> getSubtypes(MultiModel multiModel, T supertype) {

		List<T> subtypes = new ArrayList<T>();
		Map<String, Set<String>> subtypeTable = getSubtypeTable(multiModel);
		if (subtypeTable == null) {
			return subtypes;
		}

		for (String subtypeUri : subtypeTable.get(supertype.getUri())) {
			T subtype = MultiModelRegistry.getExtendibleElement(multiModel, subtypeUri);
			if (subtype != null) {
				subtypes.add(subtype);
			}
		}
		return subtypes;
	}

	public static <T extends ExtendibleElement> List<T> getSubtypes(T supertype) {

		return getSubtypes(MMTF.repository, supertype);
	}

	public static Set<String> getMultipleInheritanceUris(String supertypeUri) {

		return MMTF.multipleInheritanceTable.get(supertypeUri);
	}

	private static List<ConversionOperator> isEligibleParameter(Model actualModel, List<Model> actualModelTypes, Model formalModelType) {

		// polymorphism
		List<String> actualModelTypeUris = new ArrayList<String>();
		for (Model actualModelType : actualModelTypes) {
			actualModelTypeUris.add(actualModelType.getUri());
		}
		String formalModelTypeUri = formalModelType.getUri();
		for (String actualModelTypeUri : actualModelTypeUris) {
			if (actualModelTypeUri.equals(formalModelTypeUri)) {
				return new ArrayList<ConversionOperator>();
			}
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
						ConversionOperator conversionOperatorType = MultiModelTypeRegistry.getExtendibleElementType(conversionOperatorTypeUri);
						conversionOperatorTypes.add(conversionOperatorType);
					}
					return conversionOperatorTypes;
				}
			}
		}

		return null;
	}

	public static List<Operator> getExecutableOperators(EList<Model> actualParameters, List<List<Model>> runtimeModelTypes, List<Map<Integer, List<ConversionOperator>>> conversions) {

		List<Operator> executableOperatorTypes = new ArrayList<Operator>();

nextOperatorType:
		for (Operator operatorType : MultiModelTypeRegistry.getOperatorTypes()) {
			int i = 0;
			Map<Integer, List<ConversionOperator>> conversionMap = new HashMap<Integer, List<ConversionOperator>>();
			for (Parameter parameter : operatorType.getInputs()) {
				// check 1: not enough actual parameters
				if (i >= actualParameters.size()) {
					continue nextOperatorType;
				}
				// check 2: type or substitutable types
				while (i < actualParameters.size()) {
					Model actualParameter = actualParameters.get(i);
					Model formalParameter = parameter.getModel();
					// easy if formal parameter is root type for actual parameter
					if (!MultiModelTypeRegistry.isRootType(formalParameter) || !formalParameter.getClass().isAssignableFrom(actualParameter.getClass())) {
						List<ConversionOperator> conversionOperatorTypes = MultiModelTypeHierarchy.isEligibleParameter(actualParameter, runtimeModelTypes.get(i), formalParameter);
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
			if (i < actualParameters.size()) {
				continue nextOperatorType;
			}
			// checks passed
			executableOperatorTypes.add(operatorType);
			conversions.add(conversionMap);
		}

		return executableOperatorTypes;
	}

}

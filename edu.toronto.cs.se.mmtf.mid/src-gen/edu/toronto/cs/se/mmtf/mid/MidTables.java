/**
 * Copyright (C) 2012 Marsha Chechik, Alessio Di Sandro, Rick Salay
 * 
 * This file is part of MMTF ver. 0.9.0.
 * 
 * MMTF is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * MMTF is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MMTF.  If not, see <http://www.gnu.org/licenses/>.
 *************************************************************************
 * This code is 100% auto-generated
 * from: mid
 * using: org.eclipse.ocl.examples.codegen.tables.model2tables.mtl
 *
 * Do not edit it.
 */
package edu.toronto.cs.se.mmtf.mid;

import edu.toronto.cs.se.mmtf.mid.MidTables;
import org.eclipse.ocl.examples.library.ecore.EcoreExecutorEnumeration;
import org.eclipse.ocl.examples.library.ecore.EcoreExecutorEnumerationLiteral;
import org.eclipse.ocl.examples.library.ecore.EcoreExecutorPackage;
import org.eclipse.ocl.examples.library.ecore.EcoreExecutorType;
import org.eclipse.ocl.examples.library.ecore.EcoreLibraryOppositeProperty;
import org.eclipse.ocl.examples.library.ecore.EcoreLibraryProperty;
import org.eclipse.ocl.examples.library.executor.ExecutorFragment;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorProperty;
import org.eclipse.ocl.examples.library.executor.ExecutorStandardLibrary;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;

/**
 * MidTables provides the dispatch tables for the mid for use by the OCL dispatcher.
 *
 * In order to ensure correct static initialization, a top level class element must be accessed
 * before any nested class element. Therefore an access to PACKAGE.getClass() is recommended.
 */
@SuppressWarnings("nls")
public class MidTables
{
	/**
	 *	The package descriptor for the package.
	 */
	public static final EcoreExecutorPackage PACKAGE = new EcoreExecutorPackage(MidPackage.eINSTANCE);

/**
	 *	The library of all packages and types.
	 */
	public static final ExecutorStandardLibrary LIBRARY = new ExecutorStandardLibrary(PACKAGE); 

	/**
	 *	The type descriptors for each type.
	 */
	public static class Types {
	    public static final EcoreExecutorType _BinaryMappingReference = new EcoreExecutorType(MidPackage.Literals.BINARY_MAPPING_REFERENCE, PACKAGE, 0);
	    public static final EcoreExecutorType _MappingReference = new EcoreExecutorType(MidPackage.Literals.MAPPING_REFERENCE, PACKAGE, 0);
	    public static final EcoreExecutorType _ModelReference = new EcoreExecutorType(MidPackage.Literals.MODEL_REFERENCE, PACKAGE, 0);
	    public static final EcoreExecutorEnumeration _ModelReferenceOrigin = new EcoreExecutorEnumeration(MidPackage.Literals.MODEL_REFERENCE_ORIGIN, PACKAGE, 0);
	    public static final EcoreExecutorType _MultiModel = new EcoreExecutorType(MidPackage.Literals.MULTI_MODEL, PACKAGE, 0);
	
		private static final EcoreExecutorType[] types = {
		    _BinaryMappingReference,
		    _MappingReference,
		    _ModelReference,
		    _ModelReferenceOrigin,
		    _MultiModel
		};
	
		/*
		 *	Install the type descriptors in the package descriptor.
		 */
		static {
			PACKAGE.init(LIBRARY, types);
			TypeFragments.init();
			FragmentOperations.init();
			FragmentProperties.init();
			EnumerationLiterals.init();
		}
	}

	/**
	 *	The fragment descriptors for the local elements of each type and its supertypes.
	 */
	public static class Fragments {
		public static final ExecutorFragment _BinaryMappingReference__BinaryMappingReference = new ExecutorFragment(Types._BinaryMappingReference, MidTables.Types._BinaryMappingReference);
		public static final ExecutorFragment _BinaryMappingReference__MappingReference = new ExecutorFragment(Types._BinaryMappingReference, MidTables.Types._MappingReference);
		public static final ExecutorFragment _BinaryMappingReference__ModelReference = new ExecutorFragment(Types._BinaryMappingReference, MidTables.Types._ModelReference);
		public static final ExecutorFragment _BinaryMappingReference__OclAny = new ExecutorFragment(Types._BinaryMappingReference, OCLstdlibTables.Types._OclAny);
		public static final ExecutorFragment _BinaryMappingReference__OclElement = new ExecutorFragment(Types._BinaryMappingReference, OCLstdlibTables.Types._OclElement);
		
		public static final ExecutorFragment _MappingReference__MappingReference = new ExecutorFragment(Types._MappingReference, MidTables.Types._MappingReference);
		public static final ExecutorFragment _MappingReference__ModelReference = new ExecutorFragment(Types._MappingReference, MidTables.Types._ModelReference);
		public static final ExecutorFragment _MappingReference__OclAny = new ExecutorFragment(Types._MappingReference, OCLstdlibTables.Types._OclAny);
		public static final ExecutorFragment _MappingReference__OclElement = new ExecutorFragment(Types._MappingReference, OCLstdlibTables.Types._OclElement);
		
		public static final ExecutorFragment _ModelReference__ModelReference = new ExecutorFragment(Types._ModelReference, MidTables.Types._ModelReference);
		public static final ExecutorFragment _ModelReference__OclAny = new ExecutorFragment(Types._ModelReference, OCLstdlibTables.Types._OclAny);
		public static final ExecutorFragment _ModelReference__OclElement = new ExecutorFragment(Types._ModelReference, OCLstdlibTables.Types._OclElement);
		
		public static final ExecutorFragment _ModelReferenceOrigin__ModelReferenceOrigin = new ExecutorFragment(Types._ModelReferenceOrigin, MidTables.Types._ModelReferenceOrigin);
		
		public static final ExecutorFragment _MultiModel__MultiModel = new ExecutorFragment(Types._MultiModel, MidTables.Types._MultiModel);
		public static final ExecutorFragment _MultiModel__OclAny = new ExecutorFragment(Types._MultiModel, OCLstdlibTables.Types._OclAny);
		public static final ExecutorFragment _MultiModel__OclElement = new ExecutorFragment(Types._MultiModel, OCLstdlibTables.Types._OclElement);
		
	}

	/**
	 *	The operation descriptors for each operation of each type.
	 */
	public static class Operations {}

	/**
	 *	The property descriptors for each property of each type.
	 */
	public static class Properties {
		public static final ExecutorProperty _MappingReference__models = new ExecutorProperty("models", Types._MappingReference, 0, new EcoreLibraryProperty(MidPackage.Literals.MAPPING_REFERENCE__MODELS));
	
		public static final ExecutorProperty _ModelReference__MappingReference = new ExecutorProperty("MappingReference", Types._ModelReference, 0, new EcoreLibraryOppositeProperty(MidPackage.Literals.MAPPING_REFERENCE__MODELS));
		public static final ExecutorProperty _ModelReference__MultiModel = new ExecutorProperty("MultiModel", Types._ModelReference, 1, new EcoreLibraryOppositeProperty(MidPackage.Literals.MULTI_MODEL__ELEMENTS));
		public static final ExecutorProperty _ModelReference__name = new ExecutorProperty("name", Types._ModelReference, 2, new EcoreLibraryProperty(MidPackage.Literals.MODEL_REFERENCE__NAME));
		public static final ExecutorProperty _ModelReference__origin = new ExecutorProperty("origin", Types._ModelReference, 3, new EcoreLibraryProperty(MidPackage.Literals.MODEL_REFERENCE__ORIGIN));
		public static final ExecutorProperty _ModelReference__root = new ExecutorProperty("root", Types._ModelReference, 4, new EcoreLibraryProperty(MidPackage.Literals.MODEL_REFERENCE__ROOT));
		public static final ExecutorProperty _ModelReference__uri = new ExecutorProperty("uri", Types._ModelReference, 5, new EcoreLibraryProperty(MidPackage.Literals.MODEL_REFERENCE__URI));
	
		public static final ExecutorProperty _MultiModel__elements = new ExecutorProperty("elements", Types._MultiModel, 0, new EcoreLibraryProperty(MidPackage.Literals.MULTI_MODEL__ELEMENTS));
	}

	/**
	 *	The fragments for all base types in depth order: OclAny first, OclSelf last.
	 */
	public static class TypeFragments {
		private static final ExecutorFragment[] _BinaryMappingReference =
		{
		    Fragments._BinaryMappingReference__OclAny /* 0 */,
		    Fragments._BinaryMappingReference__OclElement /* 1 */,
		    Fragments._BinaryMappingReference__ModelReference /* 2 */,
		    Fragments._BinaryMappingReference__MappingReference /* 3 */,
		    Fragments._BinaryMappingReference__BinaryMappingReference /* 4 */
		};
		private static final int[] __BinaryMappingReference = { 1,1,1,1,1 };
	
		private static final ExecutorFragment[] _MappingReference =
		{
		    Fragments._MappingReference__OclAny /* 0 */,
		    Fragments._MappingReference__OclElement /* 1 */,
		    Fragments._MappingReference__ModelReference /* 2 */,
		    Fragments._MappingReference__MappingReference /* 3 */
		};
		private static final int[] __MappingReference = { 1,1,1,1 };
	
		private static final ExecutorFragment[] _ModelReference =
		{
		    Fragments._ModelReference__OclAny /* 0 */,
		    Fragments._ModelReference__OclElement /* 1 */,
		    Fragments._ModelReference__ModelReference /* 2 */
		};
		private static final int[] __ModelReference = { 1,1,1 };
	
		private static final ExecutorFragment[] _ModelReferenceOrigin =
		{
		    Fragments._ModelReferenceOrigin__ModelReferenceOrigin /* 0 */
		};
		private static final int[] __ModelReferenceOrigin = { 1 };
	
		private static final ExecutorFragment[] _MultiModel =
		{
		    Fragments._MultiModel__OclAny /* 0 */,
		    Fragments._MultiModel__OclElement /* 1 */,
		    Fragments._MultiModel__MultiModel /* 2 */
		};
		private static final int[] __MultiModel = { 1,1,1 };
	
		/**
		 *	Install the fragment descriptors in the class descriptors.
		 */
		static {
			Types._BinaryMappingReference.initFragments(_BinaryMappingReference, __BinaryMappingReference);
			Types._MappingReference.initFragments(_MappingReference, __MappingReference);
			Types._ModelReference.initFragments(_ModelReference, __ModelReference);
			Types._ModelReferenceOrigin.initFragments(_ModelReferenceOrigin, __ModelReferenceOrigin);
			Types._MultiModel.initFragments(_MultiModel, __MultiModel);
		}
	
		public static void init() {}
	}
	

	/**
	 *	The lists of local operations or local operation overrides for each fragment of each type.
	 */
	public static class FragmentOperations {
		private static final ExecutorOperation[] _BinaryMappingReference__BinaryMappingReference = {};
		private static final ExecutorOperation[] _BinaryMappingReference__MappingReference = {};
		private static final ExecutorOperation[] _BinaryMappingReference__ModelReference = {};
		private static final ExecutorOperation[] _BinaryMappingReference__OclAny = {
		    OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
		    OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
		    OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
		    OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType<TT>(AnyClassifier<TT>) */,
		    OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
		    OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
		    OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf<T>(AnyClassifier<T>) */,
		    OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
		    OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf<T>(AnyClassifier<T>) */,
		    OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
		    OCLstdlibTables.Operations._OclAny__oclType /* oclType() */
		};
		private static final ExecutorOperation[] _BinaryMappingReference__OclElement = {
		    OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
		    OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
		    OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
	
		private static final ExecutorOperation[] _MappingReference__MappingReference = {};
		private static final ExecutorOperation[] _MappingReference__ModelReference = {};
		private static final ExecutorOperation[] _MappingReference__OclAny = {
		    OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
		    OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
		    OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
		    OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType<TT>(AnyClassifier<TT>) */,
		    OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
		    OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
		    OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf<T>(AnyClassifier<T>) */,
		    OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
		    OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf<T>(AnyClassifier<T>) */,
		    OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
		    OCLstdlibTables.Operations._OclAny__oclType /* oclType() */
		};
		private static final ExecutorOperation[] _MappingReference__OclElement = {
		    OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
		    OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
		    OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
	
		private static final ExecutorOperation[] _ModelReference__ModelReference = {};
		private static final ExecutorOperation[] _ModelReference__OclAny = {
		    OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
		    OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
		    OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
		    OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType<TT>(AnyClassifier<TT>) */,
		    OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
		    OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
		    OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf<T>(AnyClassifier<T>) */,
		    OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
		    OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf<T>(AnyClassifier<T>) */,
		    OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
		    OCLstdlibTables.Operations._OclAny__oclType /* oclType() */
		};
		private static final ExecutorOperation[] _ModelReference__OclElement = {
		    OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
		    OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
		    OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
	
		private static final ExecutorOperation[] _ModelReferenceOrigin__ModelReferenceOrigin = {};
	
		private static final ExecutorOperation[] _MultiModel__MultiModel = {};
		private static final ExecutorOperation[] _MultiModel__OclAny = {
		    OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf) */,
		    OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf) */,
		    OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
		    OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType<TT>(AnyClassifier<TT>) */,
		    OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState) */,
		    OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
		    OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf<T>(AnyClassifier<T>) */,
		    OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
		    OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf<T>(AnyClassifier<T>) */,
		    OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
		    OCLstdlibTables.Operations._OclAny__oclType /* oclType() */
		};
		private static final ExecutorOperation[] _MultiModel__OclElement = {
		    OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
		    OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
		    OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
	
		/*
		 *	Install the operation descriptors in the fragment descriptors.
		 */
		static {
			Fragments._BinaryMappingReference__BinaryMappingReference.initOperations(_BinaryMappingReference__BinaryMappingReference);
			Fragments._BinaryMappingReference__MappingReference.initOperations(_BinaryMappingReference__MappingReference);
			Fragments._BinaryMappingReference__ModelReference.initOperations(_BinaryMappingReference__ModelReference);
			Fragments._BinaryMappingReference__OclAny.initOperations(_BinaryMappingReference__OclAny);
			Fragments._BinaryMappingReference__OclElement.initOperations(_BinaryMappingReference__OclElement);
	
			Fragments._MappingReference__MappingReference.initOperations(_MappingReference__MappingReference);
			Fragments._MappingReference__ModelReference.initOperations(_MappingReference__ModelReference);
			Fragments._MappingReference__OclAny.initOperations(_MappingReference__OclAny);
			Fragments._MappingReference__OclElement.initOperations(_MappingReference__OclElement);
	
			Fragments._ModelReference__ModelReference.initOperations(_ModelReference__ModelReference);
			Fragments._ModelReference__OclAny.initOperations(_ModelReference__OclAny);
			Fragments._ModelReference__OclElement.initOperations(_ModelReference__OclElement);
	
			Fragments._ModelReferenceOrigin__ModelReferenceOrigin.initOperations(_ModelReferenceOrigin__ModelReferenceOrigin);
	
			Fragments._MultiModel__MultiModel.initOperations(_MultiModel__MultiModel);
			Fragments._MultiModel__OclAny.initOperations(_MultiModel__OclAny);
			Fragments._MultiModel__OclElement.initOperations(_MultiModel__OclElement);
		}
	
		public static void init() {}
	}

	/**
	 *	The lists of local properties for the local fragment of each type.
	 */
	public static class FragmentProperties {
		private static final ExecutorProperty[] _BinaryMappingReference = {
		    MidTables.Properties._ModelReference__MappingReference,
		    MidTables.Properties._ModelReference__MultiModel,
		    MidTables.Properties._MappingReference__models,
		    MidTables.Properties._ModelReference__name,
		    MidTables.Properties._ModelReference__origin,
		    MidTables.Properties._ModelReference__root,
		    MidTables.Properties._ModelReference__uri
		};
	
		private static final ExecutorProperty[] _MappingReference = {
		    MidTables.Properties._ModelReference__MappingReference,
		    MidTables.Properties._ModelReference__MultiModel,
		    MidTables.Properties._MappingReference__models,
		    MidTables.Properties._ModelReference__name,
		    MidTables.Properties._ModelReference__origin,
		    MidTables.Properties._ModelReference__root,
		    MidTables.Properties._ModelReference__uri
		};
	
		private static final ExecutorProperty[] _ModelReference = {
		    MidTables.Properties._ModelReference__MappingReference,
		    MidTables.Properties._ModelReference__MultiModel,
		    MidTables.Properties._ModelReference__name,
		    MidTables.Properties._ModelReference__origin,
		    MidTables.Properties._ModelReference__root,
		    MidTables.Properties._ModelReference__uri
		};
	
		private static final ExecutorProperty[] _ModelReferenceOrigin = {};
	
		private static final ExecutorProperty[] _MultiModel = {
		    MidTables.Properties._MultiModel__elements
		};
	
		/**
		 *	Install the property descriptors in the fragment descriptors.
		 */
		static {
	  	 	Fragments._BinaryMappingReference__BinaryMappingReference.initProperties(_BinaryMappingReference);
	  	 	Fragments._MappingReference__MappingReference.initProperties(_MappingReference);
	  	 	Fragments._ModelReference__ModelReference.initProperties(_ModelReference);
	  	 	Fragments._ModelReferenceOrigin__ModelReferenceOrigin.initProperties(_ModelReferenceOrigin);
	  	 	Fragments._MultiModel__MultiModel.initProperties(_MultiModel);
		}
	
		public static void init() {}
	}
	
	/**
	 *	The lists of enumeration literals for each enumeration.
	 */
	public static class EnumerationLiterals {
		public static EcoreExecutorEnumerationLiteral _ModelReferenceOrigin__IMPORTED = new EcoreExecutorEnumerationLiteral(MidPackage.Literals.MODEL_REFERENCE_ORIGIN.getEEnumLiteral("IMPORTED"), Types._ModelReferenceOrigin, 0);
		public static EcoreExecutorEnumerationLiteral _ModelReferenceOrigin__CREATED = new EcoreExecutorEnumerationLiteral(MidPackage.Literals.MODEL_REFERENCE_ORIGIN.getEEnumLiteral("CREATED"), Types._ModelReferenceOrigin, 1);
		
		private static final EcoreExecutorEnumerationLiteral[] _ModelReferenceOrigin = {
		    _ModelReferenceOrigin__IMPORTED,
		    _ModelReferenceOrigin__CREATED
		};
	
		/**
		 *	Install the enumeration literals in the enumerations.
		 */
		static {
	  	 	Types._ModelReferenceOrigin.initLiterals(_ModelReferenceOrigin);
		}
	
		public static void init() {}
	}
	
	static {
		Types.types[0].getClass();
	}
}


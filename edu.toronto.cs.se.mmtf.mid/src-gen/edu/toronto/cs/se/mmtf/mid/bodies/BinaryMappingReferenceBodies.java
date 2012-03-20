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
package edu.toronto.cs.se.mmtf.mid.bodies;

import edu.toronto.cs.se.mmtf.mid.MidTables;
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.InvalidValueException;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation;
import org.eclipse.ocl.examples.domain.library.LibraryProperty;
import org.eclipse.ocl.examples.domain.library.LibraryUnaryOperation;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.ValueFactory;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.library.executor.ExecutorProperty;
import org.eclipse.ocl.examples.library.executor.ExecutorType;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables;

/**
 * BinaryMappingReferenceBodies provides the Java implementation bodies of OCL-defined BinaryMappingReference operations and properties.
 */
@SuppressWarnings("nls")
public class BinaryMappingReferenceBodies
{

	/** 
	 * Implementation of the BinaryMappingReference 'isBinary' invariant.
	 */
	public static class _invariant_isBinary extends AbstractUnaryOperation
	{
		public static _invariant_isBinary INSTANCE = new _invariant_isBinary();
	
		/*
		models->size() = 2
		*/
		public Value evaluate(DomainEvaluator evaluator, DomainType returnType, final Value self) throws InvalidValueException {
			final ValueFactory valueFactory = evaluator.getValueFactory();
			final DomainStandardLibrary standardLibrary = valueFactory.getStandardLibrary();
			final ExecutorType T_Boolean = OCLstdlibTables.Types._Boolean;
			final ExecutorOperation O_Real__eq_ = OCLstdlibTables.Operations._Real___eq_;
			final ExecutorType T_Integer = OCLstdlibTables.Types._Integer;
			final ExecutorOperation O_Collection_size = OCLstdlibTables.Operations._Collection__size;
			final ExecutorType T_mid_ecore__mid__ModelReference = MidTables.Types._ModelReference;
			final DomainCollectionType T_OrderedSet_mid_ecore__mid__ModelReference_ = standardLibrary.getOrderedSetType(T_mid_ecore__mid__ModelReference);
			final ExecutorProperty P_MappingReference_models = MidTables.Properties._MappingReference__models;
			final LibraryProperty IP_MappingReference_models = P_MappingReference_models.getImplementation();
			final IntegerValue I_2 = valueFactory.integerValueOf(2);
			
			
			Value A_symbol_0 = IP_MappingReference_models.evaluate(evaluator, T_OrderedSet_mid_ecore__mid__ModelReference_, self, P_MappingReference_models);
			
			DomainType static_A_symbol_1 = valueFactory.typeOf(A_symbol_0);
			LibraryUnaryOperation dynamic_A_symbol_1 = (LibraryUnaryOperation)static_A_symbol_1.lookupImplementation(standardLibrary, O_Collection_size);
			Value A_symbol_1 = dynamic_A_symbol_1.evaluate(evaluator, T_Integer, A_symbol_0);
			DomainType static_A_symbol_2 = valueFactory.typeOf(A_symbol_1, I_2);
			LibraryBinaryOperation dynamic_A_symbol_2 = (LibraryBinaryOperation)static_A_symbol_2.lookupImplementation(standardLibrary, O_Real__eq_);
			Value A_symbol_2 = dynamic_A_symbol_2.evaluate(evaluator, T_Boolean, A_symbol_1, I_2);
			return A_symbol_2;
		}
	}
}


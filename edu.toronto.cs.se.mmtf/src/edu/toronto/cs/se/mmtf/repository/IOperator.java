package edu.toronto.cs.se.mmtf.repository;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmtf.MMTFException;

public interface IOperator {

	public EObject[] invoke(EObject[] parameters) throws MMTFException;

}

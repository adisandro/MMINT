package edu.toronto.cs.se.mmint.types.simulink.operators;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.operator.slice.Slice;

public class SimulinkSlice extends Slice {

  @Override
  protected SliceStep getDirectlySlicedElements(EObject modelObj, SliceInfo info) {
    // do nothing
    var empty = Map.<EObject, SliceInfo>of();
    return new SliceStep(empty, empty);
  }

}

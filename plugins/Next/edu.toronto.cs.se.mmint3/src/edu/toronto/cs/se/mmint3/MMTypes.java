package edu.toronto.cs.se.mmint3;

import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint3.mm.Type;

/**
 * Contains queries for the Type MegaModel.
 * @author Alessio Di Sandro
 */
public class MMTypes {
  public static <T extends Type> @Nullable T getType(String typeId) {
    return MMINT.I.getType(typeId);
  }
}

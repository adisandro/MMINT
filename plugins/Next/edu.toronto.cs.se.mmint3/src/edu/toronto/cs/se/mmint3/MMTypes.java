package edu.toronto.cs.se.mmint3;

import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint3.mm.Type;

/**
 * Contains queries for the Type MegaModel.
 * @author Alessio Di Sandro
 */
public class MMTypes {

  /**
   * Gets a type from the type megamodel, given its unique identifier.
   * @param <T> A subclass of the {@link edu.toronto.cs.se.mmint3.Type} interface.
   * @param typeId The unique identifier of the type.
   * @return The type, null if the unique identifier is not found.
   */
  public static <T extends Type> @Nullable T getType(String typeId) {
    return MMINT.I.getType(typeId);
  }
}

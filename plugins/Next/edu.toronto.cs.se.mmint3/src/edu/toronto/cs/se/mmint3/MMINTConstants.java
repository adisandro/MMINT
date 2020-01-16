package edu.toronto.cs.se.mmint3;

/**
 * MMINT's constants.
 * @author Alessio Di Sandro
 */
public interface MMINTConstants {
  /** The configuration element for a type. */
  String EXT_TYPE = "type";
  /** The configuration attribute for the id of a type. */
  String EXT_TYPE_ID = "id";
  /** The configuration attribute for the name of a type. */
  String EXT_TYPE_NAME = "name";

  /** The extension point for model types. */
  String EXT_MODELS = "edu.toronto.cs.se.mmint3.models";
  /** The configuration element for a model type. */
  String EXT_MODELS_MODELTYPE = "modelType";
  /** The extension point for editor types. */

  String EXT_EDITORS = "edu.toronto.cs.se.mmint3.editors";
  /** The configuration element for an editor type. */
  String EXT_EDITORS_EDITORTYPE = "editorType";
  /** The configuration attribute for the model type id of an editor type. */
  String EXT_EDITORTYPE_MODELTYPEID = "modelTypeId";
  /** The configuration attribute for the wizard id of an editor type. */
  String EXT_EDITORTYPE_WIZARDID = "wizardId";
  /** The configuration attribute for the kind of an editor type. */
  String EXT_EDITORTYPE_KIND = "kind";
}

package edu.toronto.cs.se.mmint3;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint3.mm.EditorKind;
import edu.toronto.cs.se.mmint3.mm.EditorType;
import edu.toronto.cs.se.mmint3.mm.MMFactory;
import edu.toronto.cs.se.mmint3.mm.MMType;
import edu.toronto.cs.se.mmint3.mm.ModelType;
import edu.toronto.cs.se.mmint3.mm.Type;
import edu.toronto.cs.se.mmint3.mm.TypeMegaModel;

/**
 * MMINT: INTeractive Model Management.
 * @author Alessio Di Sandro
 */
public class MMINT {

  /** The singleton instance of this class. */
  public static final MMINT I = new MMINT();
  /** The Type MegaModel in memory. */
  private TypeMegaModel typeMM;

  /**
   * Creates a type from an edu.toronto.cs.se.mmint3.types extension.
   * @param config The extension configuration.
   * @return The type.
   * @throws Exception If the extension configuration is malformed.
   */
  private MMType createType(IConfigurationElement config) throws Exception {
    var msg = "Malformed type extension";
    var typeConfig = config.getChildren(MMINTConstants.EXT_TYPE);
    if (typeConfig.length != 1) {
      throw new Exception(msg);
    }
    var id = typeConfig[0].getAttribute(MMINTConstants.EXT_TYPE_ID);
    if (id == null) {
      throw new Exception(msg);
    }
    var name = typeConfig[0].getAttribute(MMINTConstants.EXT_TYPE_NAME);
    if (name == null) {
      throw new Exception(msg);
    }
    var type = MMFactory.eINSTANCE.createMMType();
    type.setId(id);
    type.setName(name);

    return type;
  }

  /**
   * Creates a model type from an edu.toronto.cs.se.mmint3.models extension.
   * @param config The extension configuration.
   * @return The model type.
   * @throws Exception If the extension configuration is malformed.
   */
  private ModelType createModelType(IConfigurationElement config) throws Exception {
    var type = createType(config);
    var modelT = MMFactory.eINSTANCE.createModelType();
    modelT.setT(type);
    this.typeMM.getModels().add(modelT);
    this.typeMM.getElements().put(modelT.getId(), modelT);

    return modelT;
  }

  /**
   * Creates an editor type from an edu.toronto.cs.se.mmint3.editors extension.
   * @param config The extension configuration.
   * @return The editor type.
   * @throws Exception If the extension configuration is malformed.
   */
  private EditorType createEditorType(IConfigurationElement config) throws Exception {
    var msg = "Malformed editor type extension";
    var modelTId = config.getAttribute(MMINTConstants.EXT_EDITORTYPE_MODELTYPEID);
    if (modelTId == null) {
      throw new Exception(msg);
    }
    ModelType modelT = getType(modelTId);
    if (modelT == null) {
      throw new Exception(msg);
    }
    var wizardId = config.getAttribute(MMINTConstants.EXT_EDITORTYPE_WIZARDID);
    if (wizardId == null) {
      throw new Exception(msg);
    }
    var kind = config.getAttribute(MMINTConstants.EXT_EDITORTYPE_KIND);
    if (kind == null) {
      throw new Exception(msg);
    }
    var editorKind = EditorKind.get(kind.toUpperCase());
    if (editorKind == null) {
      throw new Exception(msg);
    }
    var type = createType(config);
    var editorT = MMFactory.eINSTANCE.createEditorType();
    editorT.setT(type);
    editorT.setModel(modelT);
    editorT.setWizardId(wizardId);
    editorT.setKind(editorKind);

    return editorT;
  }

  /**
   * Initializes the type megamodel.
   * @param registry The extension registry.
   */
  private void initTypeMM(IExtensionRegistry registry) {
    this.typeMM = MMFactory.eINSTANCE.createTypeMegaModel();
    var configs = registry.getConfigurationElementsFor(MMINTConstants.EXT_MODELS);
    for (var config : configs) {
      try {
        createModelType(config);
      }
      catch (Exception e) {
        e.printStackTrace();
      }
    }
    configs = registry.getConfigurationElementsFor(MMINTConstants.EXT_EDITORS);
    for (var config : configs) {
      try {
        createEditorType(config);
      }
      catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * Initializes MMINT.
   */
  private MMINT() {
    var registry = RegistryFactory.getRegistry();
    if (registry != null) {
      initTypeMM(registry);
    }
  }

  /**
   * Gets the type megamodel.
   * @return The type megamodel.
   */
  public TypeMegaModel getTypeMegaModel() {
    return this.typeMM;
  }

  /**
   * Gets a type from the type megamodel, given its unique identifier.
   * @param <T> A subclass of the {@link edu.toronto.cs.se.mmint3.Type} interface.
   * @param typeId The unique identifier of the type.
   * @return The type, null if the unique identifier is not found.
   */
  public <T extends Type> @Nullable T getType(String typeId) {
    return this.typeMM.getElement(typeId);
  }
}

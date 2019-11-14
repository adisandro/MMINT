package edu.toronto.cs.se.mmint3;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.RegistryFactory;

import edu.toronto.cs.se.mmint3.mm.MMFactory;
import edu.toronto.cs.se.mmint3.mm.MMType;
import edu.toronto.cs.se.mmint3.mm.ModelType;
import edu.toronto.cs.se.mmint3.mm.TypeMegaModel;

/**
 * MMINT: INTeractive Model Management.
 * @author Alessio Di Sandro
 */
public class MMINT {

  /** The singleton instance of this class. */
  static final MMINT I = new MMINT();
  /** The Type MegaModel in memory. */
  TypeMegaModel cachedTypeMM;

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
    this.cachedTypeMM.getModels().add(modelT);

    return modelT;
  }

  /**
   * Initializes the type megamodel.
   * @param registry The extension registry.
   */
  private void initTypeMM(IExtensionRegistry registry) {
    this.cachedTypeMM = MMFactory.eINSTANCE.createTypeMegaModel();
    var configs = registry.getConfigurationElementsFor(MMINTConstants.EXT_MODELS);
    for (var config : configs) {
      try {
        createModelType(config);
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
}

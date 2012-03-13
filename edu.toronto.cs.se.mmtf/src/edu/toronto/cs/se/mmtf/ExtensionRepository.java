package edu.toronto.cs.se.mmtf;

import java.util.ArrayList;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

/**
 * Methods in this class need to be dynamic, to support plugin uninstallations.
 * 
 * @author Alessio Di Sandro
 *
 */
public class ExtensionRepository {

	private final static String METAMODELS_EXT_POINT = "edu.toronto.cs.se.mmtf.metamodels";
	private final static String METAMODELS_ATTR_URI = "uri";
	private final static String DIAGRAMS_EXT_POINT = "edu.toronto.cs.se.mmtf.diagrams";
	private final static String DIAGRAMS_ATTR_METAMODEL_URI = "metamodelUri";
	private final static String DIAGRAMS_ATTR_EDITOR_ID = "editorId";

	private final static String EDITORS_EXT_POINT = "org.eclipse.ui.editors";
	private final static String EDITORS_EXT_POINT_GMF_ID = "gmf-editor";
	private final static String EDITORS_ATTR_ID = "id";
	private final static String EDITORS_ATTR_EXTENSIONS = "extensions";

	public static ArrayList<String> getMetamodelFilenames() {

		ArrayList<String> filenames = new ArrayList<String>();

		IExtensionRegistry registry = RegistryFactory.getRegistry();
		if (registry == null) {
			return filenames;
		}

		IConfigurationElement[] config = registry.getConfigurationElementsFor(METAMODELS_EXT_POINT);
		String metamodelUri;
		EPackage metamodelPackage;
		String metamodelPackageName;
		Map<String, Object> map = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();

		// assuming filenames for models are the same as package names from now on
		for (IConfigurationElement elem : config) {
			metamodelUri = elem.getAttribute(METAMODELS_ATTR_URI);
			metamodelPackage = EPackage.Registry.INSTANCE.getEPackage(metamodelUri);

			if (metamodelPackage != null) {
				metamodelPackageName = metamodelPackage.getName();
				filenames.add(metamodelPackageName);
				// possibly register file extension to load resources
				if (!map.containsKey(metamodelPackageName)) {
					map.put(metamodelPackageName, new XMIResourceFactoryImpl());
				}
			}
		}

		return filenames;
	}

	public static ArrayList<String> getModelReferenceDiagramFilenames(String metamodelUri) {

		ArrayList<String> diagramFilenames = new ArrayList<String>();

		IExtensionRegistry registry = RegistryFactory.getRegistry();
		if (registry == null) {
			return diagramFilenames;
		}

		IConfigurationElement[] config = registry.getConfigurationElementsFor(DIAGRAMS_EXT_POINT);
		String editorId;
		//TODO ridurre in qualche modo
		IConfigurationElement[] GMFconfig = registry.getConfigurationElementsFor(EDITORS_EXT_POINT);

		for (IConfigurationElement elem : config) {
			if (elem.getAttribute(DIAGRAMS_ATTR_METAMODEL_URI).equals(metamodelUri)) {
				editorId = elem.getAttribute(DIAGRAMS_ATTR_EDITOR_ID);
				for (IConfigurationElement GMFelem : GMFconfig) {
					if (GMFelem.getAttribute(EDITORS_ATTR_ID).equals(editorId)) {
						diagramFilenames.add(GMFelem.getAttribute(EDITORS_ATTR_EXTENSIONS));
						break;
					}
				}
			}
		}

		return diagramFilenames;
	}

}

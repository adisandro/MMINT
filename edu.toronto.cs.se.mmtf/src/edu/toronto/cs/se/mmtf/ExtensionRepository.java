package edu.toronto.cs.se.mmtf;

import java.util.ArrayList;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.gmf.runtime.notation.Diagram;

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
	private final static String DIAGRAMS_ATTR_CLASS = "class";

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
		//TODO filenames are actually decided by editors?
		for (IConfigurationElement elem : config) {
			metamodelUri = elem.getAttribute(METAMODELS_ATTR_URI);
			metamodelPackage = EPackage.Registry.INSTANCE.getEPackage(metamodelUri);

			if (metamodelPackage != null) {
				metamodelPackageName = metamodelPackage.getName();
				filenames.add(metamodelPackageName);
				// possibly register file extension to load resources
				if (!map.containsKey(metamodelPackageName)) {
					//TODO dep on xmi in plugin: map.put(metamodelPackageName, metamodelPackage.getEFactoryInstance());
					map.put(metamodelPackageName, new XMIResourceFactoryImpl());
				}
			}
		}

		return filenames;
	}

	public Diagram getModelReferenceDiagram(String metamodelUri) {
		/*TODO we need to get the DiagramEditor class listed in the diagrams extension point
		 *     there must be a pointer in the ModelReference.type that let us do this
		 *     options are: the metamodel uri, the EPackage of the model which has .eNS_URI,
		 *     the EObject representing the root of the model which has .getEPackage
		 */
		return null;
	}

}

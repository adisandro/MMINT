package edu.toronto.cs.se.mmtf;

import java.util.ArrayList;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import edu.toronto.cs.se.mmtf.repository.Metamodel;
import edu.toronto.cs.se.mmtf.repository.MetamodelsExtensionListener;
import edu.toronto.cs.se.mmtf.repository.Repository;
import edu.toronto.cs.se.mmtf.repository.RepositoryFactory;

/**
 * Methods in this class need to be dynamic, to support plugin uninstallations.
 * 
 * @author Alessio Di Sandro
 *
 */
public class MMTF {

	private final static String METAMODELS_EXT_POINT = "edu.toronto.cs.se.mmtf.metamodels";
	private final static String METAMODELS_ATTR_URI = "uri";
	private final static String EDITORS_EXT_POINT = "edu.toronto.cs.se.mmtf.editors";
	private final static String EDITORS_ATTR_METAMODEL_URI = "metamodelUri";
	private final static String EDITORS_ATTR_IS_DIAGRAM = "isDiagram";
	private final static String EDITORS_ATTR_EDITOR_ID = "editorId";
	private final static String EDITORS_ATTR_WIZARD_ID = "wizardId";

	private final static String ECLIPSE_EDITORS_EXT_POINT = "org.eclipse.ui.editors";
	private final static String ECLIPSE_EDITORS_ATTR_ID = "id";
	private final static String ECLIPSE_EDITORS_ATTR_EXTENSIONS = "extensions";

	private Repository repository;

	private void initRepository() {

		repository = RepositoryFactory.eINSTANCE.createRepository();
		IExtensionRegistry registry = RegistryFactory.getRegistry();
		IConfigurationElement[] config;

		// metamodels
		EMap<String, Metamodel> metamodels = repository.getMetamodels();
		Map<String, Object> resourceMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		EPackage metamodelPackage;
		String uri, metamodelPackageName;
		Metamodel metamodel;
		config = registry.getConfigurationElementsFor(METAMODELS_EXT_POINT);
		for (IConfigurationElement elem : config) {
			uri = elem.getAttribute(METAMODELS_ATTR_URI);
			metamodel = RepositoryFactory.eINSTANCE.createMetamodel();
			metamodelPackage = EPackage.Registry.INSTANCE.getEPackage(uri);
			metamodel.setUri(uri);
			if (metamodelPackage != null) {
				metamodelPackageName = metamodelPackage.getName();
				metamodel.setFileExtension(metamodelPackageName);
				// possibly register file extension to load resources
				if (!resourceMap.containsKey(metamodelPackageName)) {
					resourceMap.put(metamodelPackageName, new XMIResourceFactoryImpl());
				}
			}
			metamodels.put(uri, metamodel);
		}
	}

	public MMTF() {

		initRepository();
		//TODO register registry listeners
		RegistryFactory.getRegistry().addListener(new MetamodelsExtensionListener(), METAMODELS_EXT_POINT);
	}

	//TODO modify and move repository queries to own class
	public static ArrayList<String> getMetamodelFileExtensions() {

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

	public static class DiagramID {
		private String fileExtension;
		private String editorId;
		public DiagramID(String fileExtension, String editorId) {
			this.fileExtension = fileExtension;
			this.editorId = editorId;
		}
		public String getFileExtension() {
			return fileExtension;
		}
		public String getEditorId() {
			return editorId;
		}
	}

	public static ArrayList<DiagramID> getDiagramIds(String metamodelUri) {

		ArrayList<DiagramID> diagramIds = new ArrayList<DiagramID>();

		IExtensionRegistry registry = RegistryFactory.getRegistry();
		if (registry == null) {
			return diagramIds;
		}

		IConfigurationElement[] config = registry.getConfigurationElementsFor(EDITORS_EXT_POINT);
		String editorId;
		//TODO ridurre in qualche modo (credo che l'unico sia infilare i file extension nel mio point)
		IConfigurationElement[] GMFconfig = registry.getConfigurationElementsFor(ECLIPSE_EDITORS_EXT_POINT);

		for (IConfigurationElement elem : config) {
			if (elem.getAttribute(EDITORS_ATTR_METAMODEL_URI).equals(metamodelUri)) {
				editorId = elem.getAttribute(EDITORS_ATTR_EDITOR_ID);
				for (IConfigurationElement GMFelem : GMFconfig) {
					if (GMFelem.getAttribute(ECLIPSE_EDITORS_ATTR_ID).equals(editorId)) {
						for (String fileExtension : GMFelem.getAttribute(ECLIPSE_EDITORS_ATTR_EXTENSIONS).split(",")) {
							diagramIds.add(new DiagramID(fileExtension, editorId));
						}
						break;
					}
				}
			}
		}

		return diagramIds;
	}

}

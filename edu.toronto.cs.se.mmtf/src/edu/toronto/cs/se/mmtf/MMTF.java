package edu.toronto.cs.se.mmtf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;

import edu.toronto.cs.se.mmtf.repository.Editor;
import edu.toronto.cs.se.mmtf.repository.EditorsExtensionListener;
import edu.toronto.cs.se.mmtf.repository.Metamodel;
import edu.toronto.cs.se.mmtf.repository.MetamodelsExtensionListener;
import edu.toronto.cs.se.mmtf.repository.Repository;
import edu.toronto.cs.se.mmtf.repository.RepositoryFactory;
import edu.toronto.cs.se.mmtf.repository.RepositoryLabelProvider;
import edu.toronto.cs.se.mmtf.repository.RepositoryTreeContentProvider;

/**
 * 
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

	private static Repository repository;

	public Metamodel addMetamodel(IConfigurationElement extensionConfig) {

		Map<String, Object> resourceMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		String uri = extensionConfig.getAttribute(METAMODELS_ATTR_URI);
		Metamodel metamodel = RepositoryFactory.eINSTANCE.createMetamodel();
		EPackage metamodelPackage = EPackage.Registry.INSTANCE.getEPackage(uri);

		metamodel.setName(extensionConfig.getDeclaringExtension().getLabel());
		metamodel.setUri(uri);
		if (metamodelPackage != null) {
			String metamodelPackageName = metamodelPackage.getName();
			metamodel.setFileExtension(metamodelPackageName);
			// possibly register file extension to load resources
			if (!resourceMap.containsKey(metamodelPackageName)) {
				resourceMap.put(metamodelPackageName, new XMIResourceFactoryImpl());
			}
		}
		repository.getMetamodels().put(uri, metamodel);

		return metamodel;
	}

	public void addMetamodelEditors(Metamodel metamodel) {

		Editor editor;
		for (Entry<String, Editor> entry : repository.getEditors().entrySet()) {
			editor = entry.getValue();
			if (editor.getMetamodelUri().equals(metamodel.getUri())) {
				metamodel.getEditors().add(editor);
			}
		}
	}

	public void removeMetamodel(IConfigurationElement extensionConfig) {

		String uri = extensionConfig.getAttribute(METAMODELS_ATTR_URI);
		Metamodel metamodel = repository.getMetamodels().removeKey(uri);
		metamodel.getEditors().clear();
	}

	public Editor addEditor(IConfigurationElement extensionConfig) {

		String metamodelUri = extensionConfig.getAttribute(EDITORS_ATTR_METAMODEL_URI);
		String isDiagram = extensionConfig.getAttribute(EDITORS_ATTR_IS_DIAGRAM);
		String editorId = extensionConfig.getAttribute(EDITORS_ATTR_EDITOR_ID);
		String wizardId = extensionConfig.getAttribute(EDITORS_ATTR_WIZARD_ID);
		Editor editor;

		if (Boolean.parseBoolean(isDiagram)) {
			editor = RepositoryFactory.eINSTANCE.createDiagram();
		}
		else {
			editor = RepositoryFactory.eINSTANCE.createEditor();
		}
		editor.setName(extensionConfig.getDeclaringExtension().getLabel());
		editor.setMetamodelUri(metamodelUri);
		editor.setEditorId(editorId);
		editor.setWizardId(wizardId);
		repository.getEditors().put(editorId, editor);

		return editor;
	}

	public void addMetamodelEditors(Editor editor) {

		Metamodel metamodel = repository.getMetamodels().get(editor.getMetamodelUri());
		if (metamodel != null) {
			metamodel.getEditors().add(editor);
		}
	}

	public void addEditorFilenames(IExtensionRegistry registry, Editor editor) {

		IConfigurationElement[] config = registry.getConfigurationElementsFor(ECLIPSE_EDITORS_EXT_POINT);
		for (IConfigurationElement elem : config) {
			if (elem.getAttribute(ECLIPSE_EDITORS_ATTR_ID).equals(editor.getEditorId())) {
				for (String fileExtension : elem.getAttribute(ECLIPSE_EDITORS_ATTR_EXTENSIONS).split(",")) {
					editor.getFileExtensions().add(fileExtension);
				}
				break;
			}
		}
	}

	public void addEditorFilenames(IExtensionRegistry registry) {

		IConfigurationElement[] config = registry.getConfigurationElementsFor(ECLIPSE_EDITORS_EXT_POINT);
		Editor editor;
		for (IConfigurationElement elem : config) {
			editor = repository.getEditors().get(elem.getAttribute(ECLIPSE_EDITORS_ATTR_ID));
			if (editor != null) {
				for (String fileExtension : elem.getAttribute(ECLIPSE_EDITORS_ATTR_EXTENSIONS).split(",")) {
					editor.getFileExtensions().add(fileExtension);
				}
			}
		}
	}

	public void removeEditor(IConfigurationElement extensionConfig) {

		String editorId = extensionConfig.getAttribute(EDITORS_ATTR_EDITOR_ID);
		Editor editor = repository.getEditors().removeKey(editorId);
		Metamodel metamodel = repository.getMetamodels().get(editor.getMetamodelUri());
		if (metamodel != null) {
			metamodel.getEditors().remove(editor);
		}
	}

	private void initRepository(IExtensionRegistry registry) {

		repository = RepositoryFactory.eINSTANCE.createRepository();
		IConfigurationElement[] config;

		// metamodels
		config = registry.getConfigurationElementsFor(METAMODELS_EXT_POINT);
		for (IConfigurationElement elem : config) {
			addMetamodel(elem);
		}

		// editors
		config = registry.getConfigurationElementsFor(EDITORS_EXT_POINT);
		Editor editor;
		for (IConfigurationElement elem : config) {
			editor = addEditor(elem);
			addMetamodelEditors(editor);
		}
		addEditorFilenames(registry);
	}

	public MMTF() {

		IExtensionRegistry registry = RegistryFactory.getRegistry();
		if (registry != null) {
			initRepository(registry);
			registry.addListener(new MetamodelsExtensionListener(this), METAMODELS_EXT_POINT);
			registry.addListener(new EditorsExtensionListener(this), EDITORS_EXT_POINT);
		}
	}

	public static class MMTFRegistry {

		public static ArrayList<String> getMetamodelFileExtensions() {

			ArrayList<String> filenames = new ArrayList<String>();
			for (Entry<String, Metamodel> entry : repository.getMetamodels().entrySet()) {
				filenames.add(entry.getValue().getFileExtension());
			}

			return filenames;
		}

		public static EList<Editor> getEditorsForMetamodel(String metamodelUri) {

			return repository.getMetamodels().get(metamodelUri).getEditors();
		}

		public static Collection<Metamodel> getMetamodels() {

			return repository.getMetamodels().values();
		}

		public static ElementTreeSelectionDialog getRepositoryAsDialog() {

			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(
				shell,
				new RepositoryLabelProvider(),
				new RepositoryTreeContentProvider(repository)
			);
			dialog.setInput(repository);
			//TODO add selection validator

			return dialog;
		}
	}

}

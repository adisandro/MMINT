/*
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.relationship.diagram.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.LogHelper;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import edu.toronto.cs.se.mmint.mid.editor.provider.EditorItemProviderAdapterFactory;
import edu.toronto.cs.se.mmint.mid.operator.provider.OperatorItemProviderAdapterFactory;
import edu.toronto.cs.se.mmint.mid.provider.MIDItemProviderAdapterFactory;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.policies.MIDBaseItemSemanticEditPolicy;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.expressions.MIDOCLFactory;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.providers.ElementInitializers;
import edu.toronto.cs.se.mmint.mid.relationship.provider.RelationshipItemProviderAdapterFactory;
import edu.toronto.cs.se.mmint.mid.ui.GMFUtils;

/**
 * @generated
 */
public class MIDDiagramEditorPlugin extends AbstractUIPlugin {

	/**
	* @generated
	*/
	public static final String ID = "edu.toronto.cs.se.mmint.relationship.diagram"; //$NON-NLS-1$

	/**
	* @generated
	*/
	private LogHelper myLogHelper;

	/**
	* @generated
	*/
	public static final PreferencesHint DIAGRAM_PREFERENCES_HINT = new PreferencesHint(ID);

	/**
	* @generated
	*/
	private static MIDDiagramEditorPlugin instance;

	/**
	* @generated
	*/
	private ComposedAdapterFactory adapterFactory;

	/**
	* @generated
	*/
	private MIDDocumentProvider documentProvider;

	/**
	* @generated
	*/
	private MIDBaseItemSemanticEditPolicy.LinkConstraints linkConstraints;

	/**
	* @generated
	*/
	private ElementInitializers initializers;

	/**
	* @generated
	*/
	private MIDOCLFactory oclFactory;

	/**
	* @generated
	*/
	public MIDDiagramEditorPlugin() {
	}

	/**
	* @generated
	*/
	public void start(BundleContext context) throws Exception {
		super.start(context);
		instance = this;
		myLogHelper = new LogHelper(this);
		PreferencesHint.registerPreferenceStore(DIAGRAM_PREFERENCES_HINT, getPreferenceStore());
		adapterFactory = createAdapterFactory();
	}

	/**
	* @generated
	*/
	public void stop(BundleContext context) throws Exception {
		adapterFactory.dispose();
		adapterFactory = null;
		linkConstraints = null;
		initializers = null;
		oclFactory = null;
		instance = null;
		super.stop(context);
	}

	/**
	* @generated
	*/
	public static MIDDiagramEditorPlugin getInstance() {
		return instance;
	}

	/**
	* @generated
	*/
	protected ComposedAdapterFactory createAdapterFactoryGen() {
		ArrayList<AdapterFactory> factories = new ArrayList<AdapterFactory>();
		fillItemProviderFactories(factories);
		return new ComposedAdapterFactory(factories);
	}

	/**
	 * @generated NOT
	 */
	protected ComposedAdapterFactory createAdapterFactory() {

		return GMFUtils.getAdapterFactory();
	}

	/**
	* @generated
	*/
	protected void fillItemProviderFactories(List<AdapterFactory> factories) {
		factories.add(new MIDItemProviderAdapterFactory());
		factories.add(new RelationshipItemProviderAdapterFactory());
		factories.add(new EditorItemProviderAdapterFactory());
		factories.add(new OperatorItemProviderAdapterFactory());
		factories.add(new ResourceItemProviderAdapterFactory());
		factories.add(new ReflectiveItemProviderAdapterFactory());
	}

	/**
	* @generated
	*/
	public AdapterFactory getItemProvidersAdapterFactory() {
		return adapterFactory;
	}

	/**
	* @generated
	*/
	public ImageDescriptor getItemImageDescriptor(Object item) {
		IItemLabelProvider labelProvider = (IItemLabelProvider) adapterFactory.adapt(item, IItemLabelProvider.class);
		if (labelProvider != null) {
			return ExtendedImageRegistry.getInstance().getImageDescriptor(labelProvider.getImage(item));
		}
		return null;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path.
	 *
	 * @generated
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getBundledImageDescriptor(String path) {
		return AbstractUIPlugin.imageDescriptorFromPlugin(ID, path);
	}

	/**
	 * Respects images residing in any plug-in. If path is relative,
	 * then this bundle is looked up for the image, otherwise, for absolute 
	 * path, first segment is taken as id of plug-in with image
	 *
	 * @generated
	 * @param path the path to image, either absolute (with plug-in id as first segment), or relative for bundled images
	 * @return the image descriptor
	 */
	public static ImageDescriptor findImageDescriptor(String path) {
		final IPath p = new Path(path);
		if (p.isAbsolute() && p.segmentCount() > 1) {
			return AbstractUIPlugin.imageDescriptorFromPlugin(p.segment(0),
					p.removeFirstSegments(1).makeAbsolute().toString());
		} else {
			return getBundledImageDescriptor(p.makeAbsolute().toString());
		}
	}

	/**
	 * Returns an image for the image file at the given plug-in relative path.
	 * Client do not need to dispose this image. Images will be disposed automatically.
	 *
	 * @generated
	 * @param path the path
	 * @return image instance
	 */
	public Image getBundledImage(String path) {
		Image image = getImageRegistry().get(path);
		if (image == null) {
			getImageRegistry().put(path, getBundledImageDescriptor(path));
			image = getImageRegistry().get(path);
		}
		return image;
	}

	/**
	 * Returns string from plug-in's resource bundle
	 *
	 * @generated
	 */
	public static String getString(String key) {
		return Platform.getResourceString(getInstance().getBundle(), "%" + key); //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	public MIDDocumentProvider getDocumentProvider() {
		if (documentProvider == null) {
			documentProvider = new MIDDocumentProvider();
		}
		return documentProvider;
	}

	/**
	* @generated
	*/
	public MIDBaseItemSemanticEditPolicy.LinkConstraints getLinkConstraints() {
		return linkConstraints;
	}

	/**
	* @generated
	*/
	public void setLinkConstraints(MIDBaseItemSemanticEditPolicy.LinkConstraints lc) {
		this.linkConstraints = lc;
	}

	/**
	* @generated
	*/
	public ElementInitializers getElementInitializers() {
		return initializers;
	}

	/**
	* @generated
	*/
	public void setElementInitializers(ElementInitializers i) {
		this.initializers = i;
	}

	/**
	* @generated
	*/
	public MIDOCLFactory getMIDOCLFactory() {
		return oclFactory;
	}

	/**
	* @generated
	*/
	public void setMIDOCLFactory(MIDOCLFactory f) {
		this.oclFactory = f;
	}

	/**
	* @generated
	*/
	public void logError(String error) {
		getLogHelper().logError(error, null);
	}

	/**
	* @generated
	*/
	public void logError(String error, Throwable throwable) {
		getLogHelper().logError(error, throwable);
	}

	/**
	* @generated
	*/
	public void logInfo(String message) {
		getLogHelper().logInfo(message, null);
	}

	/**
	* @generated
	*/
	public void logInfo(String message, Throwable throwable) {
		getLogHelper().logInfo(message, throwable);
	}

	/**
	* @generated
	*/
	public LogHelper getLogHelper() {
		return myLogHelper;
	}

}

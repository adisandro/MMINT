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
package edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part;

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

import edu.toronto.cs.se.mavo.provider.MAVOItemProviderAdapterFactory;

/**
 * @generated
 */
public class RelationalDatabase_MAVODiagramEditorPlugin extends AbstractUIPlugin {

	/**
	* @generated
	*/
	public static final String ID = "edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram"; //$NON-NLS-1$

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
	private static RelationalDatabase_MAVODiagramEditorPlugin instance;

	/**
	* @generated
	*/
	private ComposedAdapterFactory adapterFactory;

	/**
	* @generated
	*/
	private edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVODocumentProvider documentProvider;

	/**
	* @generated
	*/
	private edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.policies.RelationalDatabase_MAVOBaseItemSemanticEditPolicy.LinkConstraints linkConstraints;

	/**
	* @generated
	*/
	private edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.providers.ElementInitializers initializers;

	/**
	* @generated
	*/
	public RelationalDatabase_MAVODiagramEditorPlugin() {
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
		instance = null;
		super.stop(context);
	}

	/**
	* @generated
	*/
	public static RelationalDatabase_MAVODiagramEditorPlugin getInstance() {
		return instance;
	}

	/**
	* @generated
	*/
	protected ComposedAdapterFactory createAdapterFactory() {
		ArrayList<AdapterFactory> factories = new ArrayList<AdapterFactory>();
		fillItemProviderFactories(factories);
		return new ComposedAdapterFactory(factories);
	}

	/**
	* @generated
	*/
	protected void fillItemProviderFactories(List<AdapterFactory> factories) {
		factories.add(
				new edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.provider.RelationalDatabase_MAVOItemProviderAdapterFactory());
		factories.add(new MAVOItemProviderAdapterFactory());
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
	public edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVODocumentProvider getDocumentProvider() {
		if (documentProvider == null) {
			documentProvider = new edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVODocumentProvider();
		}
		return documentProvider;
	}

	/**
	* @generated
	*/
	public edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.policies.RelationalDatabase_MAVOBaseItemSemanticEditPolicy.LinkConstraints getLinkConstraints() {
		return linkConstraints;
	}

	/**
	* @generated
	*/
	public void setLinkConstraints(
			edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.policies.RelationalDatabase_MAVOBaseItemSemanticEditPolicy.LinkConstraints lc) {
		this.linkConstraints = lc;
	}

	/**
	* @generated
	*/
	public edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.providers.ElementInitializers getElementInitializers() {
		return initializers;
	}

	/**
	* @generated
	*/
	public void setElementInitializers(
			edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.providers.ElementInitializers i) {
		this.initializers = i;
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

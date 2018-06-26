/**
 * Copyright (c) 2012-2018 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.diagram.providers;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.HintedDiagramLinkStyle;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.RelativeBendpoints;
import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTConstants;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.BinaryModelRelEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelEndpoint2EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelEndpoint3EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelEndpointEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelEndpointName2EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelEndpointNameEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.WrappingLabel10EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.WrappingLabel11EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.WrappingLabel12EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.WrappingLabel13EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.WrappingLabel14EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.WrappingLabel15EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.part.MIDVisualIDRegistry;
import edu.toronto.cs.se.mmint.mid.diagram.providers.MIDViewProvider;

public class MIDDiagramViewProvider extends MIDViewProvider {

	private Node createLabel(View owner, String hint) {

		try {
			Method createLabel = MIDViewProvider.class.getDeclaredMethod("createLabel", View.class, String.class);
			createLabel.setAccessible(true);
			return (Node) createLabel.invoke(this, owner, hint);
		}
		catch (Exception e) {
			MMINTException.print(IStatus.WARNING, "Failed reflection for private GMF method MIDViewProvider.createLabel()", null);
			return null;
		}
	}

	/**
	 * Customizes label creation.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Edge createModelEndpoint_4002(EObject domainElement,
			View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Edge edge = NotationFactory.eINSTANCE.createEdge();
		edge.getStyles().add(NotationFactory.eINSTANCE.createRoutingStyle());
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE
				.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(
				2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(MIDVisualIDRegistry
				.getType(ModelEndpointEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint
				.getPreferenceStore();
		FontStyle edgeFontStyle = (FontStyle) edge
				.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore,
					IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter
					.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB)
					.intValue());
		}
		Routing routing = Routing.get(prefStore
				.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge,
					NotationPackage.eINSTANCE.getRoutingStyle_Routing(),
					routing);
		}
		if (!Boolean.parseBoolean(MMINT.getPreference(MMINTConstants.PREFERENCE_MENU_MODELRELENDPOINTS_ENABLED))) {
			return edge;
		}
		Node label6001 = createLabel(edge,
				MIDVisualIDRegistry.getType(WrappingLabel10EditPart.VISUAL_ID));
		label6001.setLayoutConstraint(NotationFactory.eINSTANCE
				.createLocation());
		Location location6001 = (Location) label6001.getLayoutConstraint();
		location6001.setX(0);
		location6001.setY(40);
		if (Boolean.parseBoolean(MMINT.getPreference(MMINTConstants.PREFERENCE_MENU_ICONS_ENABLED))) {
			Node label6002 = createLabel(edge,
					MIDVisualIDRegistry.getType(WrappingLabel11EditPart.VISUAL_ID));
			label6002.setLayoutConstraint(NotationFactory.eINSTANCE
					.createLocation());
			Location location6002 = (Location) label6002.getLayoutConstraint();
			location6002.setX(0);
			location6002.setY(60);
		}
		return edge;
	}

	/**
	 * Customizes label creation.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Edge createModelEndpoint_4004(EObject domainElement,
			View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Edge edge = NotationFactory.eINSTANCE.createEdge();
		edge.getStyles().add(NotationFactory.eINSTANCE.createRoutingStyle());
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE
				.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(
				2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(MIDVisualIDRegistry
				.getType(ModelEndpoint2EditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint
				.getPreferenceStore();
		FontStyle edgeFontStyle = (FontStyle) edge
				.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore,
					IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter
					.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB)
					.intValue());
		}
		Routing routing = Routing.get(prefStore
				.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge,
					NotationPackage.eINSTANCE.getRoutingStyle_Routing(),
					routing);
		}
		if (!Boolean.parseBoolean(MMINT.getPreference(MMINTConstants.PREFERENCE_MENU_OPERATORENDPOINTS_ENABLED))) {
			return edge;
		}
		Node label6007 = createLabel(edge,
				MIDVisualIDRegistry
						.getType(ModelEndpointNameEditPart.VISUAL_ID));
		label6007.setLayoutConstraint(NotationFactory.eINSTANCE
				.createLocation());
		Location location6007 = (Location) label6007.getLayoutConstraint();
		location6007.setX(0);
		location6007.setY(40);
		return edge;
	}

	/**
	 * Customizes label creation.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Edge createModelEndpoint_4005(EObject domainElement,
			View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Edge edge = NotationFactory.eINSTANCE.createEdge();
		edge.getStyles().add(NotationFactory.eINSTANCE.createRoutingStyle());
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE
				.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(
				2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(MIDVisualIDRegistry
				.getType(ModelEndpoint3EditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint
				.getPreferenceStore();
		FontStyle edgeFontStyle = (FontStyle) edge
				.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore,
					IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter
					.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB)
					.intValue());
		}
		Routing routing = Routing.get(prefStore
				.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge,
					NotationPackage.eINSTANCE.getRoutingStyle_Routing(),
					routing);
		}
		if (!Boolean.parseBoolean(MMINT.getPreference(MMINTConstants.PREFERENCE_MENU_OPERATORENDPOINTS_ENABLED))) {
			return edge;
		}
		Node label6008 = createLabel(edge,
				MIDVisualIDRegistry
						.getType(ModelEndpointName2EditPart.VISUAL_ID));
		label6008.setLayoutConstraint(NotationFactory.eINSTANCE
				.createLocation());
		Location location6008 = (Location) label6008.getLayoutConstraint();
		location6008.setX(0);
		location6008.setY(40);
		return edge;
	}

	/**
	 * Adds missing diagram hint for binary model relationships and customizes label creation.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Edge createBinaryModelRel_4003(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {

		Edge edge = _createBinaryModelRel_4003(domainElement, containerView, index, persisted, preferencesHint);
		HintedDiagramLinkStyle diagramFacet = NotationFactory.eINSTANCE.createHintedDiagramLinkStyle();
		diagramFacet.setHint("Relationship");
		edge.getStyles().add(diagramFacet);

		return edge;
	}

	/**
	 * Customizes label creation.
	 */
	@SuppressWarnings("unchecked")
	private Edge _createBinaryModelRel_4003(EObject domainElement,
			View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Edge edge = NotationFactory.eINSTANCE.createEdge();
		edge.getStyles().add(NotationFactory.eINSTANCE.createRoutingStyle());
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE
				.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(
				2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(MIDVisualIDRegistry
				.getType(BinaryModelRelEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint
				.getPreferenceStore();
		FontStyle edgeFontStyle = (FontStyle) edge
				.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore,
					IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter
					.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB)
					.intValue());
		}
		Routing routing = Routing.get(prefStore
				.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge,
					NotationPackage.eINSTANCE.getRoutingStyle_Routing(),
					routing);
		}
		if (!Boolean.parseBoolean(MMINT.getPreference(MMINTConstants.PREFERENCE_MENU_MODELRELS_ENABLED))) {
			return edge;
		}
		Node label6003 = createLabel(edge,
				MIDVisualIDRegistry.getType(WrappingLabel12EditPart.VISUAL_ID));
		label6003.setLayoutConstraint(NotationFactory.eINSTANCE
				.createLocation());
		Location location6003 = (Location) label6003.getLayoutConstraint();
		location6003.setX(0);
		location6003.setY(40);
		if (Boolean.parseBoolean(MMINT.getPreference(MMINTConstants.PREFERENCE_MENU_ICONS_ENABLED))) {
			Node label6004 = createLabel(edge,
					MIDVisualIDRegistry.getType(WrappingLabel13EditPart.VISUAL_ID));
			label6004.setLayoutConstraint(NotationFactory.eINSTANCE
					.createLocation());
			Location location6004 = (Location) label6004.getLayoutConstraint();
			location6004.setX(0);
			location6004.setY(60);
		}
		if (!Boolean.parseBoolean(MMINT.getPreference(MMINTConstants.PREFERENCE_MENU_MODELRELENDPOINTS_ENABLED))) {
			return edge;
		}
		Node label6005 = createLabel(edge,
				MIDVisualIDRegistry.getType(WrappingLabel14EditPart.VISUAL_ID));
		label6005.setLayoutConstraint(NotationFactory.eINSTANCE
				.createLocation());
		Location location6005 = (Location) label6005.getLayoutConstraint();
		location6005.setX(0);
		location6005.setY(80);
		Node label6006 = createLabel(edge,
				MIDVisualIDRegistry.getType(WrappingLabel15EditPart.VISUAL_ID));
		label6006.setLayoutConstraint(NotationFactory.eINSTANCE
				.createLocation());
		Location location6006 = (Location) label6006.getLayoutConstraint();
		location6006.setX(0);
		location6006.setY(100);
		return edge;
	}

}

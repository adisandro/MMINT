/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.relationship.diagram.providers;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.FontStyle;
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

import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.BinaryLinkReference2EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.BinaryLinkReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelElementEndpointReference2EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelElementEndpointReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel10EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel11EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel12EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel13EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel14EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel15EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel23EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel24EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel25EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel26EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel8EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel9EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.part.MidVisualIDRegistry;

public class RelationshipDiagramViewProvider extends MidViewProvider {

	private boolean disableLinks = true;
	private boolean disableEndpoints = true;
	private boolean disableIcons = false;

	private Node createLabel(View owner, String hint) {
		DecorationNode rv = NotationFactory.eINSTANCE.createDecorationNode();
		rv.setType(hint);
		ViewUtil.insertChildView(owner, rv, ViewUtil.APPEND, true);
		return rv;
	}

	/**
	 * Customizes label creation.
	 */
	@SuppressWarnings("unchecked")
	public Edge createModelElementEndpointReference_4011(EObject domainElement,
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
		edge.setType(MidVisualIDRegistry
				.getType(ModelElementEndpointReferenceEditPart.VISUAL_ID));
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
		if (disableEndpoints) {
			return edge;
		}
		if (!disableIcons) {
			Node label6007 = createLabel(edge,
					MidVisualIDRegistry.getType(WrappingLabel8EditPart.VISUAL_ID));
			label6007.setLayoutConstraint(NotationFactory.eINSTANCE
					.createLocation());
			Location location6007 = (Location) label6007.getLayoutConstraint();
			location6007.setX(0);
			location6007.setY(40);
		}
		Node label6015 = createLabel(edge,
				MidVisualIDRegistry.getType(WrappingLabel23EditPart.VISUAL_ID));
		label6015.setLayoutConstraint(NotationFactory.eINSTANCE
				.createLocation());
		Location location6015 = (Location) label6015.getLayoutConstraint();
		location6015.setX(0);
		location6015.setY(60);
		return edge;
	}

	/**
	 * Customizes label creation.
	 */
	@SuppressWarnings("unchecked")
	public Edge createBinaryLinkReference_4012(EObject domainElement,
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
		edge.setType(MidVisualIDRegistry
				.getType(BinaryLinkReferenceEditPart.VISUAL_ID));
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
		if (disableLinks) {
			return edge;
		}
		if (!disableIcons) {
			Node label6008 = createLabel(edge,
					MidVisualIDRegistry.getType(WrappingLabel9EditPart.VISUAL_ID));
			label6008.setLayoutConstraint(NotationFactory.eINSTANCE
					.createLocation());
			Location location6008 = (Location) label6008.getLayoutConstraint();
			location6008.setX(0);
			location6008.setY(40);
		}
		Node label6009 = createLabel(edge,
				MidVisualIDRegistry.getType(WrappingLabel10EditPart.VISUAL_ID));
		label6009.setLayoutConstraint(NotationFactory.eINSTANCE
				.createLocation());
		Location location6009 = (Location) label6009.getLayoutConstraint();
		location6009.setX(0);
		location6009.setY(60);
		if (disableEndpoints) {
			return edge;
		}
		Node label6010 = createLabel(edge,
				MidVisualIDRegistry.getType(WrappingLabel11EditPart.VISUAL_ID));
		label6010.setLayoutConstraint(NotationFactory.eINSTANCE
				.createLocation());
		Location location6010 = (Location) label6010.getLayoutConstraint();
		location6010.setX(0);
		location6010.setY(80);
		Node label6016 = createLabel(edge,
				MidVisualIDRegistry.getType(WrappingLabel24EditPart.VISUAL_ID));
		label6016.setLayoutConstraint(NotationFactory.eINSTANCE
				.createLocation());
		Location location6016 = (Location) label6016.getLayoutConstraint();
		location6016.setX(0);
		location6016.setY(100);
		return edge;
	}

	/**
	 * Customizes label creation.
	 */
	@SuppressWarnings("unchecked")
	public Edge createBinaryLinkReference_4013(EObject domainElement,
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
		edge.setType(MidVisualIDRegistry
				.getType(BinaryLinkReference2EditPart.VISUAL_ID));
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
		if (disableLinks) {
			return edge;
		}
		if (!disableIcons) {
			Node label6011 = createLabel(edge,
					MidVisualIDRegistry.getType(WrappingLabel12EditPart.VISUAL_ID));
			label6011.setLayoutConstraint(NotationFactory.eINSTANCE
					.createLocation());
			Location location6011 = (Location) label6011.getLayoutConstraint();
			location6011.setX(0);
			location6011.setY(40);
		}
		Node label6012 = createLabel(edge,
				MidVisualIDRegistry.getType(WrappingLabel13EditPart.VISUAL_ID));
		label6012.setLayoutConstraint(NotationFactory.eINSTANCE
				.createLocation());
		Location location6012 = (Location) label6012.getLayoutConstraint();
		location6012.setX(0);
		location6012.setY(60);
		if (disableEndpoints) {
			return edge;
		}
		Node label6013 = createLabel(edge,
				MidVisualIDRegistry.getType(WrappingLabel14EditPart.VISUAL_ID));
		label6013.setLayoutConstraint(NotationFactory.eINSTANCE
				.createLocation());
		Location location6013 = (Location) label6013.getLayoutConstraint();
		location6013.setX(0);
		location6013.setY(80);
		Node label6017 = createLabel(edge,
				MidVisualIDRegistry.getType(WrappingLabel25EditPart.VISUAL_ID));
		label6017.setLayoutConstraint(NotationFactory.eINSTANCE
				.createLocation());
		Location location6017 = (Location) label6017.getLayoutConstraint();
		location6017.setX(0);
		location6017.setY(100);
		return edge;
	}

	/**
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public Edge createModelElementEndpointReference_4014(EObject domainElement,
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
		edge.setType(MidVisualIDRegistry
				.getType(ModelElementEndpointReference2EditPart.VISUAL_ID));
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
		if (disableEndpoints) {
			return edge;
		}
		if (!disableIcons) {
			Node label6014 = createLabel(edge,
					MidVisualIDRegistry.getType(WrappingLabel15EditPart.VISUAL_ID));
			label6014.setLayoutConstraint(NotationFactory.eINSTANCE
					.createLocation());
			Location location6014 = (Location) label6014.getLayoutConstraint();
			location6014.setX(0);
			location6014.setY(40);
		}
		Node label6018 = createLabel(edge,
				MidVisualIDRegistry.getType(WrappingLabel26EditPart.VISUAL_ID));
		label6018.setLayoutConstraint(NotationFactory.eINSTANCE
				.createLocation());
		Location location6018 = (Location) label6018.getLayoutConstraint();
		location6018.setX(0);
		location6018.setY(60);
		return edge;
	}

}

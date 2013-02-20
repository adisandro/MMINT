package edu.toronto.cs.se.modelepedia.istar.diagram.figures;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;

public class SoftGoalFigure extends Figure {
	
	@Override
	public void paint(Graphics graphics) {
		
		Rectangle r = getBounds();
		
		// Define the points of a diamond
		Point p1 = new Point(r.x, r.y + r.height);
		Point p2 = new Point(r.x + r.width/2, r.y + r.height/4 + r.height/2);
		Point p3 = new Point(r.x + r.width - 1, r.y + r.height - 1);
		Point p4 = new Point(r.x + r.width - 1, r.y);
		Point p5 = new Point(r.x + r.width/2, r.y + r.height/4);
		Point p6 = new Point(r.x, r.y);
		
		PointList pointList = new PointList();
		pointList.addPoint(p1);
		pointList.addPoint(p2);
		pointList.addPoint(p3);
		pointList.addPoint(p4);
		pointList.addPoint(p5);
		pointList.addPoint(p6);
		
		// Fill the shape
		graphics.fillPolygon(pointList);
		graphics.setLineWidth(1);
		
		// Draw the outline
		graphics.drawLine(p1, p2);
		graphics.drawLine(p2, p3);
		graphics.drawLine(p3, p4);
		graphics.drawLine(p4, p5);
		graphics.drawLine(p5, p6);
		graphics.drawLine(p6, p1);
		
		for (int i = 0; i < getChildren().size(); i++) {
			WrappingLabel label = (WrappingLabel) getChildren().get(i);
			label.paint(graphics);
		}
	}

}

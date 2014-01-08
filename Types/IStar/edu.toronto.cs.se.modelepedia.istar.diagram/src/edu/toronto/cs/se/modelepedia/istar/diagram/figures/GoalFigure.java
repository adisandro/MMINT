package edu.toronto.cs.se.modelepedia.istar.diagram.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;

public class GoalFigure extends RectangleFigure {
	
	@Override
	public void paint(Graphics graphics) {
		Rectangle r = getBounds();
		
		// Define the points of a diamond
		Point p1 = new Point(r.x + r.width/4, r.y + r.height - 1);
		Point p2 = new Point(r.x + r.width/4 + r.width/2, r.y + r.height - 1);
		Point p3 = new Point(r.x + r.width/4 + r.width/2, r.y);
		Point p4 = new Point(r.x + r.width/4, r.y);
		
		PointList pointList = new PointList();
		pointList.addPoint(p1);
		pointList.addPoint(p2);
		pointList.addPoint(p3);
		pointList.addPoint(p4);
		
		// Fill the shape
		graphics.fillPolygon(pointList);
		graphics.setLineWidth(1);
		
		// Draw the outline
		graphics.drawLine(p1, p2);
		graphics.drawArc(r.x + r.width/2 - 1, r.y, r.width/2, r.height - 1, 270, 180);
		graphics.drawLine(p3, p4);
		graphics.drawArc(r.x, r.y, r.width/2, r.height - 1, 90, 180);
		
		for (int i = 0; i < getChildren().size(); i++) {
			WrappingLabel label = (WrappingLabel) getChildren().get(i);
			label.paint(graphics);
		}
	}

}

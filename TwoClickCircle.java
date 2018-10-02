import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import javax.swing.JComponent;

public class TriangleComponent extends JComponent
{
	
	public TriangleComponent()
	{
		
		mouseClickTrack = 0;
		p1 = null;
		p2 = null;
		p3 = null;
		
		class MousePressListener extends MouseAdapter
		{
			
			
			public void mouseClicked(MouseEvent event)
			{
				
				
				if(mouseClickTrack == 0)
				{
					p1 = new Point2D.Double(event.getX(), event.getY());
					p2 = null;
					p3 = null;
				}
				if(mouseClickTrack == 1)
				{
					p2 = new Point2D.Double(event.getX(), event.getY());
				}
				if(mouseClickTrack == 2)
				{
					p3 = new Point2D.Double(event.getX(), event.getY());
				}
				mouseClickTrack++;
				repaint();
				
				/*
				double x = event.getX( );
				double y = event.getY( );
				
				p = new Point2D.Double(x, y);
				repaint( );
				*/
				
			}
			
		}
		
		MouseListener listener = new MousePressListener();
		addMouseListener(listener);
		
	}
	
	public void paintComponent(Graphics g)
	{
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g; //recovers Graphics2D
		
		//plotPoints(g2);
		
		if(p1 != null)
		{
			plotPoint(g2, p1);
			
		}
		
		if(p2 != null)
		{
			plotPoint(g2, p2);
			drawLine(g2, p1, p2);
		}
		
		if(p3 != null)
		{
			plotPoint(g2, p3);
			drawLine(g2, p1, p3);
			drawLine(g2, p2, p3);
			mouseClickTrack = 0;
		}
		
		
	}
	
	public void drawLine(Graphics2D g2, Point2D.Double point1, Point2D.Double point2)
	{
		
		Line2D.Double line = new Line2D.Double(point1, point2);
		g2.draw(line);
	}
	
	public void plotPoint(Graphics2D g2, Point2D.Double point)
	{
		
		double x = point.getX();
		double y = point.getY();
		
		Ellipse2D.Double dot = new Ellipse2D.Double(x, y, 5, 5);
		g2.fill(dot);
		
		
	}
	
	
	private int mouseClickTrack;
	
	//private Point2D.Double p;
	
	private Point2D.Double p1;
	private Point2D.Double p2;
	private Point2D.Double p3;
	
}

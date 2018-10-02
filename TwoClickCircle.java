import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class TwoClickCircleComponent extends JPanel
{
	private static final long serialVersionUID = 1L;
	public TwoClickCircleComponent()
	{
		
		track = 0;
		center = null;
		onCircle = null;
		
		class MouseSpy extends MouseAdapter
		{
			
			
			public void mouseClicked(MouseEvent event)
			{
				
				if(track == 0)
				{
					
					center = new Point2D.Double(event.getX(), event.getY());
					onCircle = null;
					
				}
				
				if (track == 1)
				{
					
					onCircle = new Point2D.Double(event.getX(), event.getY());
					
				}
				
				track++;
				repaint();
				
			}
			
		}
		
		MouseSpy listener = new MouseSpy();
		addMouseListener(listener);
		
	}
	
	public void paintCompoent(Graphics g)
	{
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g; //recovers Graphics2D
		
		if(center != null)
		{
			plotPoint(g2, center);
			
			if(onCircle != null)
			{
				plotPoint(g2, onCircle);
				/*
				double diameter = 2 * (Math.sqrt( Math.pow(onCircle.getX()-center.getX(), 2) + 
						Math.pow(onCircle.getY() - center.getY(), 2)) );
				g2.drawOval((int)(center.getX() - diameter/2),(int)( center.getX() - diameter/2),(int) diameter,(int) diameter);
				*/
				drawCircle(g2);
				
				
			}
			
		}
		
		if(onCircle != null && center != null)
		{
			track = 0;
		}
		
	}
	
	public void plotPoint(Graphics2D g2, Point2D.Double point)
	{
		
		double x = point.getX();
		double y = point.getY();
		
		Ellipse2D.Double dot = new Ellipse2D.Double(x - 5, y - 5, 10, 10);
		g2.fill(dot);
		
	}
	
	public void drawCircle(Graphics2D g2)
	{
		
		double diameter = 2 * (Math.sqrt( Math.pow(onCircle.getX()-center.getX(), 2) + 
				Math.pow(onCircle.getY() - center.getY(), 2)) );
		
		Ellipse2D.Double circle = new Ellipse2D.Double((int)(center.getX() - diameter/2), (int)( center.getX() - diameter/2),
				(int) diameter, (int) diameter);
		g2.draw(circle);
		
	}
	
	private int track;
	
	private Point2D.Double onCircle;
	private Point2D.Double center;
	
}

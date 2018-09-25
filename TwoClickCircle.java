import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import javax.swing.JPanel;

public class TwoClickCircle extends JPanel 
{
	
	public TwoClickCircle()
	{
		
		center = null;
		onCircle = null;
		
		class MousePressListener extends MouseAdapter
		{
			
			int track;
			
			public void mouseClicked(MouseEvent event)
			{
				
				if(track == 0)
				{
					
				}
				
				if (track == 1)
				{
					
				}
				
				
				
			}
			
		}
		
	}
	
	private Point2D.Double onCircle;
	private Point2D.Double center;
	
}

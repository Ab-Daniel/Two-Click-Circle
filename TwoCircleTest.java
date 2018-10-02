import javax.swing.JFrame;


public class TwoCircleTest 
{
	
	public static void main(String[] args) 
	{
		
		JFrame frame = new JFrame();					//create the frame
		TwoClickCircleComponent comp = new TwoClickCircleComponent();
		frame.add(comp);
		frame.setSize(500, 500);
		frame.setTitle("Two-Click Circle Window");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
}

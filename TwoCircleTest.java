import javax.swing.JFrame;


public class TwoClickTest 
{
	
	public static void main(String[] args) 
	{
		
		JFrame frame = new JFrame();					//create the frame
		TwoClickCircle comp = new TwoClickCircle();
		frame.add(comp);
		frame.setSize(500, 500);
		frame.setTitle("Two-Click Circle Window");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
}

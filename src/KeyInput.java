import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

	@Override
	public void keyPressed(KeyEvent e) {
		
		System.out.println("du spsat");
		
		if (e.getKeyCode() == KeyEvent.VK_Q) {
			System.out.println("Q amk");
			System.exit(1);
		}
	}
}

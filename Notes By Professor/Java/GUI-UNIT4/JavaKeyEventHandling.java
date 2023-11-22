import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class JavaKeyEventHandlingApp extends JFrame implements KeyListener{
		
	JLabel lblStatus = new JLabel("");
	int x = 200, y = 200;
		
	public JavaKeyEventHandlingApp(String title){
		super(title);
		setSize(400, 400);
		
		
		add(lblStatus, BorderLayout.NORTH);

		//Listener-Registration with source - Button generates
		//actionEvent and handled by ActionListener - interface
		//source.addTypeListener()

		this.addKeyListener(this);

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}


	public void paint(Graphics g){
		super.paint(g);
		/*Random rnd = new Random();
		Color c = new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255));
		g.setColor(c);
		g.fillOval(x, y, 30, 30);
		*/
		
	}

	// Methods of KeyListener interface
	public  void keyPressed(KeyEvent ke){
		int ch = ke.getKeyCode();
		if(ch == 'R' || ch == 'r'){
			System.out.println("Key Pressed " + ke.getKeyChar());
			lblStatus.setText("Key Pressed " + ke.getKeyChar());
			getContentPane().setBackground(Color.RED);
		}
		if(ch == 'B' || ch == 'b'){
			System.out.println("Key Pressed " + ke.getKeyChar());
			lblStatus.setText("Key Pressed " + ke.getKeyChar());
			getContentPane().setBackground(Color.BLUE);
		}
		if(ch == KeyEvent.VK_UP){
			y = y - 30;
		}if(ch == KeyEvent.VK_DOWN){
			y = y + 30;
		}if(ch == KeyEvent.VK_LEFT){
			x = x - 30;
		}if(ch == KeyEvent.VK_RIGHT){
			x = x + 30;
		}//repaint();
		Graphics g = getGraphics();
		Random rnd = new Random();
		Color c = new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255));
		g.setColor(c);
		g.fillOval(x, y, 30, 30);
	}
	
	public  void keyReleased(KeyEvent ke){
	}

	public  void keyTyped(KeyEvent ke){
	}

	public static void main(String[] args){
		JavaKeyEventHandlingApp sw1 = new JavaKeyEventHandlingApp("Greeting-App!!!");
	}
}
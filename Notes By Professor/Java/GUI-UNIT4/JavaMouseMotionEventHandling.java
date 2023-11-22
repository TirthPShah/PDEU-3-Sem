import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class JavaMouseMotionEventHandlingApp extends JFrame implements MouseMotionListener{
		
	JLabel lblStatus = new JLabel("");
	int x = 200, y = 200;
		
	public JavaMouseMotionEventHandlingApp(String title){
		super(title);
		setSize(400, 400);
		
		
		add(lblStatus, BorderLayout.NORTH);

		//Listener-Registration with source		
		//source.addTypeListener()-Following 
		// frame will be the source.

		this.addMouseMotionListener(this);

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}


	// Methods of MouseMotionListener interface
	public  void mouseDragged(MouseEvent ke){
		x = ke.getX();
		y = ke.getY();
		Graphics g = getGraphics();
		Random rnd = new Random();
		Color c = new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255));
		g.setColor(Color.RED);
		g.fillOval(x, y, 5, 5);
		//repaint();
	}

	public  void mouseMoved(MouseEvent ke){
		
	}

	public static void main(String[] args){
		JavaMouseMotionEventHandlingApp sw1 = new JavaMouseMotionEventHandlingApp("Greeting-App!!!");
	}
}
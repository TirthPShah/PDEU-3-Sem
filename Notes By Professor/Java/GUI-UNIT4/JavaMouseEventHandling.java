import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class JavaMouseEventHandlingApp extends JFrame implements MouseListener{
		
	JLabel lblStatus = new JLabel("");
	int x = 200, y = 200;
		
	public JavaMouseEventHandlingApp(String title){
		super(title);
		setSize(400, 400);
		
		
		add(lblStatus, BorderLayout.NORTH);

		//Listener-Registration with source - 
		//source.addTypeListener() - following
		// mouse will be the source.

		this.addMouseListener(this);

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}


	public void paint(Graphics g){
		super.paint(g);
		Random rnd = new Random();
		Color c = new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255));
		g.setColor(c);
		g.fillOval(x, y, 30, 30);
		
	}

	// Methods of MouseListener interface
	public  void mousePressed(MouseEvent ke){
		
	}
	
	public  void mouseReleased(MouseEvent ke){
	}

	public  void mouseClicked(MouseEvent ke){
		x = ke.getX();
		y = ke.getY();
		
		repaint();
	}

	public  void mouseEntered(MouseEvent ke){
	}
	
	public  void mouseExited(MouseEvent ke){
	}

	public static void main(String[] args){
		JavaMouseEventHandlingApp sw1 = new JavaMouseEventHandlingApp("Mouse-EventHandling-App!!!");
	}
}
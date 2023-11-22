/*Simple program to create a frame with two buttons and one label.
If Button1-Red is clicked than greeting message  displayed on label in red color or if
button2-Blue is clicked than greeting message displayed on label in blue color.*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class JavaEventHandlingApp extends JFrame implements ActionListener{
		
	JLabel lblStatus = new JLabel("");

	JButton btnRed = new JButton("RED");
	JButton btnBlue = new JButton("BLUE");
		
	public JavaEventHandlingApp(String title){
		super(title);
		setSize(400, 400);
		
		JPanel buttons = new JPanel(new FlowLayout());
		buttons.add(btnRed);		
		buttons.add(btnBlue);		
			
		add(buttons, BorderLayout.CENTER);
		add(lblStatus, BorderLayout.NORTH);

		//Listener-Registration with source - Button generates
		//actionEvent and handled by ActionListener - interface
		//source.addTypeListener()

		btnRed.addActionListener(this);
		btnBlue.addActionListener(this);

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	// Method of ActionListener interface
	public void actionPerformed(ActionEvent ae){
		lblStatus.setFont(new Font("Arial", Font.BOLD, 25));
		if(ae.getSource() == btnRed){
			lblStatus.setForeground(Color.RED);
			lblStatus.setText("Good-Morning");
		}
		if(ae.getActionCommand().equals("BLUE")){
			lblStatus.setForeground(Color.BLUE);
			lblStatus.setText("Good-Morning");
		}
	}

	public static void main(String[] args){
		JavaEventHandlingApp sw1 = new JavaEventHandlingApp("Greeting-App!!!");
	}
}
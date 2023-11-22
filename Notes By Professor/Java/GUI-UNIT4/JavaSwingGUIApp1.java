/*Code to demonstrate Usage of Flow, Grid and Border Layout.
creating panels, handling button events.When pressing '+'
will add numbers from textField1 and textField2 and display answer to
text3.Pressing clear button will clear content of all textfileds*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SwingApp1 extends JFrame implements ActionListener{
	
	JLabel lblNumber1 = new JLabel("Number1 : ");
	JLabel lblNumber2 = new JLabel("Number2 : ");
	JLabel lblAnswer = new JLabel("Answer : ");

	JTextField txtNumber1 = new JTextField();
	JTextField txtNumber2 = new JTextField();
	JTextField txtAnswer = new JTextField();

	JLabel lblStatus = new JLabel("");

	JButton btnAdd = new JButton("+");
	JButton btnSub = new JButton("-");
	JButton btnMul = new JButton("*");
	JButton btnClear = new JButton("CLEAR");
	
	public SwingApp1(String title){
		super(title);
		setSize(400, 400);
		
		// Creating panel container adding components
		// for data Input and displaying results. 
		JPanel dataIO = new JPanel(new GridLayout(3, 2));

		dataIO.add(lblNumber1);
		dataIO.add(txtNumber1);
		dataIO.add(lblNumber2);
		dataIO.add(txtNumber2);
		dataIO.add(lblAnswer);
		dataIO.add(txtAnswer);
		
		add(dataIO, BorderLayout.NORTH);
		btnAdd.addActionListener(this);
		btnClear.addActionListener(this);
		
		JPanel math1 = new JPanel(new FlowLayout());
		math1.add(btnAdd);		
		math1.add(btnSub);		
		math1.add(btnMul);		
		math1.add(btnClear);		
		
		add(math1, BorderLayout.SOUTH);

		lblStatus.setFont(new Font("Arial", Font.BOLD, 24));
		lblStatus.setForeground(Color.RED);
		add(lblStatus, BorderLayout.CENTER);

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent ae){
		lblStatus.setFont(new Font("Arial", Font.BOLD, 25));
		if(ae.getSource() == btnAdd){
			int n1 = Integer.parseInt(txtNumber1.getText());
			int n2 = Integer.parseInt(txtNumber2.getText());
			int n3 = n1 + n2;
			
			txtAnswer.setText(n3 + "");
			lblStatus.setForeground(Color.RED);
			lblStatus.setText(n1 + " + " + n2 + " = " + n3);
		}
		if(ae.getActionCommand().equals("CLEAR")){
			txtAnswer.setText("");
			txtNumber1.setText("");
			txtNumber2.setText("");
			lblStatus.setForeground(Color.BLUE);
			lblStatus.setText("Cleared!!!");
		}
	}

	public static void main(String[] args){
		SwingApp1 sw1 = new SwingApp1("Welcome to Java-GUI!!!");
	}
}
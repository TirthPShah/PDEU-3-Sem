/*WAP to design frame for entering student-name, Id and selection for choice of
elective subjects and store this record to file "Open-Elective-Sem3.txt" by
pressing "Store-Record" button.*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class StudentOpenElectiveChoiceApp extends JFrame implements ActionListener{
	
	PrintWriter pw = null;
	JLabel lblName = new JLabel("Student-Name : ");
	JLabel lblId = new JLabel("Student - Id : ");
	JLabel lblSubject = new JLabel("Open-Elective : ");

	JTextField txtName = new JTextField();
	JTextField txtId = new JTextField();
	String[] subjects = {"Subject1", "Subject2", "Subject3", "Subject4"};
	JComboBox lstSubjects = new JComboBox(subjects);

	JLabel lblStatus = new JLabel("");

	JButton btnStore = new JButton("Store-Record");
	JButton btnClear = new JButton("CLEAR");
	
	public StudentOpenElectiveChoiceApp(String title){
		super(title);
		try{
			pw = new PrintWriter(new FileWriter("Open-elective-Sem3.txt", true));
		}catch(IOException e){
			System.out.println(e);
		}
		
		
		setSize(400, 400);
		
		JPanel dataIO = new JPanel(new GridLayout(3, 2));

		dataIO.add(lblName);
		dataIO.add(txtName);
		dataIO.add(lblId);
		dataIO.add(txtId);
		dataIO.add(lblSubject);
		dataIO.add(lstSubjects);
		
		add(dataIO, BorderLayout.NORTH);
		btnStore.addActionListener(this);
		btnClear.addActionListener(this);
		
		JPanel buttons = new JPanel(new FlowLayout());
		buttons.add(btnStore);			
		buttons.add(btnClear);		
		
		add(buttons, BorderLayout.SOUTH);

		lblStatus.setFont(new Font("Arial", Font.BOLD, 24));
		lblStatus.setForeground(Color.RED);
		add(lblStatus, BorderLayout.CENTER);

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent ae){
		String name = txtName.getText();
		String id = txtId.getText();
		
		pw.println(name + " " + id + lstSubjects.getSelectedItem());
		pw.flush();
			
	}

	public static void main(String[] args){
		StudentOpenElectiveChoiceApp sw1 = new StudentOpenElectiveChoiceApp("Welcome to Java-GUI!!!");
	}
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class  JavaMenuApp extends JFrame implements ActionListener{
	
	JMenuBar jb = new JMenuBar();
	JMenu jm = new JMenu("Dialog-Option");
	JMenuItem jmn1 = new JMenuItem("Input-Dialog");
	JMenuItem jmn2 = new JMenuItem("Confirm-Dialog");

	public JavaMenuApp(String title){
		super(title);
		setSize(400, 400);
		
		jmn1.addActionListener(this);		
		jmn2.addActionListener(this);		

		jm.add(jmn1); // Add menuitems to menu
		jm.add(jmn2);
		
		jb.add(jm); // add menu to menubar
		setJMenuBar(jb);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent ae){
		if(ae.getSource() == jmn1){
			String name = null;
			name = JOptionPane.showInputDialog(this, "Enter Your Name :");
			JOptionPane.showMessageDialog(this, " Good-Morning : " + name);
		}if(ae.getSource() == jmn2){
			String name = null;
			name = JOptionPane.showInputDialog(this, "Enter Your Name :");
			int flag = JOptionPane.showConfirmDialog(this, " Interested in Participating TechEvent ?  "," Event-Confirmation", JOptionPane.YES_NO_OPTION );
			if(flag == 0){
				JOptionPane.showMessageDialog(this, " Thank you for participation: " + name);
			}
		}
	}

	public static void main(String[] args){
		JavaMenuApp sw1 = new JavaMenuApp("Welcome to Java-GUI!!!");
	}
}
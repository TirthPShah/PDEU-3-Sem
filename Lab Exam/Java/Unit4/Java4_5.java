import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Java4_5 implements ActionListener {

    private JFrame frame;
    private JTextField nameField;

    public Java4_5() {

        frame = new JFrame("Java4_5");
        frame.setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(2, 2));

        JLabel nameLabel = new JLabel("Name: ");
        nameField = new JTextField(10);

        form.add(nameLabel);
        form.add(nameField);

        JButton button1 = new JButton("Create Dialogue Box 1");
        button1.setActionCommand("Button1");
        button1.addActionListener(this);

        JButton button2 = new JButton("Create Dialogue Box 2");
        button2.setActionCommand("Button2");
        button2.addActionListener(this);

        form.add(button1);
        form.add(button2);

        frame.add(form, BorderLayout.CENTER);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String name = nameField.getText();

        String command = e.getActionCommand();

        if(command.equals("Button1")) {
            JOptionPane.showMessageDialog(frame, "Hello " + name + ", from Java4_5, Dialogue Box 1.");
        }

        else {
            JOptionPane.showMessageDialog(frame, "Hello " + name + ", from Java4_5, Dialogue Box 2.");
        }
    }

    public static void main(String[] args) {
        new Java4_5();
    }
}

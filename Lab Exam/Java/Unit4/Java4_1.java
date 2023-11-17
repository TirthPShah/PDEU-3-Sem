import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Java4_1 extends JFrame {
    
    public Java4_1() {

        super("Java4_1");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(20);

        JLabel rollNoLabel = new JLabel("Roll No:");
        JTextField rollNoField = new JTextField(10);

        JLabel cpiLabel = new JLabel("CPI:");
        JTextField cpiField = new JTextField(5);

        JLabel emailLabel = new JLabel("E-mail:");
        JTextField emailField = new JTextField(20);

        JButton submitButton = new JButton("Submit");

        submitButton.addActionListener(new SubmitButtonListener(nameField, rollNoField, cpiField, emailField, panel));

        panel.add(nameLabel);
        panel.add(nameField);

        panel.add(rollNoLabel);
        panel.add(rollNoField);

        panel.add(cpiLabel);
        panel.add(cpiField);

        panel.add(emailLabel);
        panel.add(emailField);

        panel.add(submitButton);

        add(panel);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Java4_1();
    }
}

class SubmitButtonListener implements ActionListener {
    
    private JLabel nameLabel = new JLabel("Name: ");
    private JLabel rollNoLabel = new JLabel("Roll No: ");
    private JLabel cpiLabel = new JLabel("CPI: ");
    private JLabel emailLabel = new JLabel("E-mail: ");

    private JTextField nameField;
    private JTextField rollNoField;
    private JTextField cpiField;
    private JTextField emailField;
    private JPanel panel;

    public SubmitButtonListener(JTextField nameField, JTextField rollNoField, JTextField cpiField, JTextField emailField, JPanel panel) {
        this.nameField = nameField;
        this.rollNoField = rollNoField;
        this.cpiField = cpiField;
        this.emailField = emailField;
        this.panel = panel;
    }

    public void actionPerformed(ActionEvent e) {
        panel.removeAll();

        JLabel submittedNameLabel = new JLabel(nameField.getText());
        JLabel submittedRollNoLabel = new JLabel(rollNoField.getText());
        JLabel submittedCpiLabel = new JLabel(cpiField.getText());
        JLabel submittedEmailLabel = new JLabel(emailField.getText());

        panel.add(nameLabel);
        panel.add(submittedNameLabel);

        panel.add(rollNoLabel);
        panel.add(submittedRollNoLabel);

        panel.add(cpiLabel);
        panel.add(submittedCpiLabel);

        panel.add(emailLabel);
        panel.add(submittedEmailLabel);

        panel.revalidate();
        panel.repaint();
    }
}
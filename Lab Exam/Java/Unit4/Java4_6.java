import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Java4_6 extends JFrame implements ActionListener {

    public Java4_6() {

        super("Java4_6");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        String[] buttons = {"Button1", "Button2", "Button3", "Button4", "Button5", "Button6", "Button7"};

        for (int i = 0; i < buttons.length; i++) {

            JButton button = new JButton(buttons[i]);
            button.setBackground(Color.WHITE);
            button.setOpaque(true);
            button.setBorderPainted(false);

            button.addActionListener(this);

            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.setAlignmentY(Component.CENTER_ALIGNMENT);
            buttonPanel.add(button);

        }

        add(buttonPanel);
        setSize(200, 250);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        button.setBackground(Color.LIGHT_GRAY);
    }

    public static void main(String[] args) {
        new Java4_6();
    }
}
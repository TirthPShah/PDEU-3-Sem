import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Java4_2 extends JFrame {
    
    public Java4_2() {

        super("Java4_2");
        setLayout(new BorderLayout());

        JLabel messageLabel = new JLabel("Listening for key and mouse events", SwingConstants.CENTER);
        add(messageLabel, BorderLayout.CENTER);

        addKeyListener(new KeyEventProcessor(messageLabel));
        addMouseListener(new MouseEventProcessor(messageLabel));

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Java4_2();
    }
}

class KeyEventProcessor extends KeyAdapter {

    private JLabel messageLabel;

    public KeyEventProcessor(JLabel messageLabel) {
        this.messageLabel = messageLabel;
    }

    public void keyTyped(KeyEvent e) {

        char keyChar = e.getKeyChar();
        messageLabel.setText(keyChar + " is pressed");

    }
}

class MouseEventProcessor extends MouseAdapter {

    private JLabel messageLabel;

    public MouseEventProcessor(JLabel messageLabel) {
        this.messageLabel = messageLabel;
    }

    public void mouseClicked(MouseEvent e) {

        int x = e.getX();
        int y = e.getY();
        messageLabel.setText("Mouse clicked at (" + x + ", " + y + ")");

    }
}
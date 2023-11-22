import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Java4_4 extends JFrame implements ActionListener, KeyListener{

    private JTextField display;

    private char operator = ' ';

    private boolean isNewNumber;

    private double firstNumber;
    private double secondNumber;

    public Java4_4() {

        super("Java4_4");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 20));
        display.addKeyListener(this);
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 3));
        
        String[] buttons = {
            "7", "8", "9",
            "4", "5", "6",
            "1", "2", "3",
            "C", "0", "="
        };

        for (String button : buttons) {

            JButton b = new JButton(button);
            b.addActionListener(this);
            buttonPanel.add(b);

        }

        add(buttonPanel, BorderLayout.CENTER);

        JPanel operationPanel = new JPanel(new FlowLayout());

        String[] operationButtons = {"+", "-", "*", "/"};

        for (String button : operationButtons) {

            JButton b = new JButton(button);
            b.addActionListener(this);
            operationPanel.add(b);

        }

        add(operationPanel, BorderLayout.SOUTH);

        setSize(400,300);
        setVisible(true);

        display.setFocusable(true);
        display.requestFocusInWindow();
    }

    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        if (command.equals("0") || command.equals("1") || command.equals("2") || command.equals("3") || command.equals("4") || command.equals("5") || command.equals("6") || command.equals("7") || command.equals("8") || command.equals("9")) {

            if (isNewNumber) {
                display.setText(command);
                isNewNumber = false;
            } 
            
            else {
                display.setText(display.getText() + command);
            }

        } 
        
        else if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
            
            firstNumber = Double.parseDouble(display.getText());
            operator = command.charAt(0);
            isNewNumber = true;

        } 
        
        else if (command.equals("C")) {
            
            display.setText("");
            firstNumber = 0;
            operator = ' ';

        } 
        
        else if (command.equals("=")) {

            secondNumber = Double.parseDouble(display.getText());

            switch (operator) {

            case '+':
                display.setText(Double.toString(firstNumber + secondNumber));
            break;

            case '-':
                display.setText(Double.toString(firstNumber - secondNumber));
            break;

            case '*':
                display.setText(Double.toString(firstNumber * secondNumber));
            break;

            case '/':

                if (secondNumber != 0) {
                    display.setText(Double.toString(firstNumber / secondNumber));
                    break;
                } 
                
                else {
                    display.setText(Double.toString(Double.NaN));
                    break;
                }
            }
            isNewNumber = true;
        }
    }

    public void keyPressed(KeyEvent k) {

    }

    public void keyReleased(KeyEvent k) {

    }

    public void keyTyped(KeyEvent k) {

        String command = String.valueOf(k.getKeyChar());

        if (command.equals("0") || command.equals("1") || command.equals("2") || command.equals("3") || command.equals("4") || command.equals("5") || command.equals("6") || command.equals("7") || command.equals("8") || command.equals("9")) {

            if (isNewNumber) {
                display.setText(command);
                isNewNumber = false;
            } 
            
            else {
                display.setText(display.getText() + command);
            }

        } 
        
        else if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
            
            firstNumber = Double.parseDouble(display.getText());
            operator = command.charAt(0);
            isNewNumber = true;

        } 
        
        else if (command.equals("C")) {
            
            display.setText("");
            firstNumber = 0;
            operator = ' ';

        } 
        
        else if (command.equals("=")) {

            secondNumber = Double.parseDouble(display.getText());

            switch (operator) {

            case '+':
                display.setText(Double.toString(firstNumber + secondNumber));
            break;

            case '-':
                display.setText(Double.toString(firstNumber - secondNumber));
            break;

            case '*':
                display.setText(Double.toString(firstNumber * secondNumber));
            break;

            case '/':

                if (secondNumber != 0) {
                    display.setText(Double.toString(firstNumber / secondNumber));
                    break;
                } 
                
                else {
                    display.setText(Double.toString(Double.NaN));
                    break;
                }
            }
            isNewNumber = true;
        }
    }

    public static void main(String[] args) {
        new Java4_4();
    }
}
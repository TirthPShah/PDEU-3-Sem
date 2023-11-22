import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GUIPrac extends JFrame implements ActionListener {

    private JTextField display;
    private boolean isNewNumber;
    private char operator = ' ';

    private double firstNumber;
    private double secondNumber;

    public GUIPrac(String title) {
        
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 20));

        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 3));

        String[] buttons = {
            "7", "8", "9",
            "4", "5", "6",
            "1", "2", "3",
            "C", "0", "="
        };

        for(String button : buttons) {

            JButton b = new JButton(button);
            b.addActionListener(this);
            buttonPanel.add(b);

        }

        add(buttonPanel, BorderLayout.CENTER);

        JPanel operationPanel = new JPanel(new FlowLayout());

        String[] operators = {"+", "-", "*", "/"};

        for(String operator : operators) {

            JButton b = new JButton(operator);
            b.addActionListener(this);
            operationPanel.add(b);

        }

        add(operationPanel, BorderLayout.SOUTH);

        setVisible(true);
        setSize(400, 300);
    }

    public void actionPerformed(ActionEvent ae) {

        String command = ae.getActionCommand();

        if (command.equals("0") || command.equals("1") || command.equals("2") || command.equals("3") || command.equals("4") || command.equals("5") || command.equals("6") || command.equals("7") || command.equals("8") || command.equals("9")) {

            if(isNewNumber) {
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
            secondNumber = 0;
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

                    if(secondNumber != 0) {
                        display.setText(Double.toString(firstNumber / secondNumber));
                    }

                    else {
                        display.setText(Double.toString(Double.NaN));
                    }

                break;
            }
            isNewNumber = true;
        }
    }

    public static void main(String[] args) {
        new GUIPrac("Practice");
    }
}
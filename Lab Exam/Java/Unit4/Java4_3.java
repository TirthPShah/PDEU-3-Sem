import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Java4_3 extends JFrame {

    private JTextArea codeArea;

    public Java4_3() {

        super("Java4_3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        codeArea = new JTextArea();
        codeArea.setEditable(false);
        codeArea.setFont(new Font("Courier New", Font.PLAIN, 14));

        JMenuBar menuBar = new JMenuBar();

        int[] noOfProg = {8, 4, 15, 6};

        for (int unit = 1; unit <= noOfProg.length; unit++) {

            JMenu unitMenu = new JMenu("Unit " + unit);

            for (int prog = 1; prog <= noOfProg[unit - 1]; prog++) {

                String progName = "Java" + unit + "_" + prog;

                JMenuItem menuItem = new JMenuItem("Open " + progName);
                String actionCommand = "Unit" + unit + " " + progName;

                menuItem.setActionCommand(actionCommand);
                menuItem.addActionListener(new MenuItemListener(codeArea));

                unitMenu.add(menuItem);
            }

            menuBar.add(unitMenu);
        }

        setJMenuBar(menuBar);

        JScrollPane scrollPane = new JScrollPane(codeArea);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Java4_3();
    }
}

class MenuItemListener implements ActionListener {

    private JTextArea codeArea;

    public MenuItemListener(JTextArea codeArea) {
        this.codeArea = codeArea;
    }

    public void actionPerformed(ActionEvent e) {

        String actionCommand = e.getActionCommand();

        String[] parts = actionCommand.split(" ");

        String unitName = parts[0];
        String lessonName = parts[1];
        String fileName = "../" + unitName + "/" + lessonName + ".java";

        BufferedReader reader = null;

        try {

            reader = new BufferedReader(new FileReader(fileName));

            codeArea.setText("");

            String line = reader.readLine();

            while (line != null) {
                
                codeArea.append(line);
                codeArea.append("\n");
                line = reader.readLine();

            }

        } 
        
        catch (Exception er) {
            codeArea.setText(er.toString());
        }

        finally {

            try {
                reader.close();
            }

            catch (Exception er) {
                codeArea.setText(er.toString());
            }
        }
    }
}

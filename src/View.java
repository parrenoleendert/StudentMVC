import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

    JTextField nameField = new JTextField(15);
    JTextField ageField = new JTextField(5);

    JButton addButton = new JButton("Add Student");
    JButton loadButton = new JButton("Show Students");

    JTextArea display = new JTextArea(10, 30);

    public View() {
        setTitle("Student Management");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Age:"));
        add(ageField);

        add(addButton);
        add(loadButton);
        
        add(new JScrollPane(display));

        setVisible(true);
    }
    
}
    
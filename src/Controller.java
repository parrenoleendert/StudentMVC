import java.awt.event.*;
import java.util.ArrayList;

public class Controller {

    
    private Model model;
    private View view;

    public Controller(Model model, View view) {

        this.model = model;
        this.view = view;

        view.addButton.addActionListener(new AddStudent());
        view.loadButton.addActionListener(new LoadStudents());
    }

    class AddStudent implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                String name = view.nameField.getText();
                int age = Integer.parseInt(view.ageField.getText());

                model.addStudent(name, age);

                view.display.setText("Student Added!");
            } catch (Exception ex) {
                view.display.setText("Error: " + ex.getMessage());
            }
        }
    }
    

    class LoadStudents implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            try {
                ArrayList<String> students = model.getStudents();
                view.display.setText("");
                for (String s : students)
                    view.display.append(s + "\n");
                
            } catch (Exception ex) {
                view.display.setText("Error: " + ex.getMessage());
            }
        }
    }
}

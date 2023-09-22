package CodSoft;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TASK_5 extends JFrame {
    private JTextField nameTextField;
    private JTextField rollNumberTextField;
    private JComboBox<String> gradeComboBox; 
    private JButton addStudentButton;
    private JButton editStudentButton; 
    private JButton displayAllStudentsButton;
    private List<Student> students;  
    private int selectedStudentIndex = -1; 

    // Inner Student class
    private class Student {
        private String name;
        private int rollNumber;
        private String grade; 

        public Student(String name, int rollNumber, String grade) {
            this.name = name;
            this.rollNumber = rollNumber;
            this.grade = grade;
        }

        
    }

 
    private class StudentTableModel extends AbstractTableModel {
        private List<Student> students;

        public StudentTableModel(List<Student> students) {
            this.students = students;
        }

        // Implement the necessary methods for a table model
        @Override
        public int getRowCount() {
            return students.size();
        }

        @Override
        public int getColumnCount() {
            // Define the number of columns in your table
            return 3; 
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            // Implement how data should be retrieved for each cell
            Student student = students.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return student.name;
                case 1:
                    return student.rollNumber;
                case 2:
                    return student.grade;
                default:
                    return null;
            }
        }

        // You can implement other necessary methods like getColumnNames, isCellEditable, etc.
    }

    public TASK_5() {
        super("Student Management System");

        // Initialize the list of students
        students = new ArrayList<>();

        // Create components
        nameTextField = new JTextField(20);
        rollNumberTextField = new JTextField(10);
        gradeComboBox = new JComboBox<>(new String[]{"A", "B", "C"}); // Specify grade options
        addStudentButton = new JButton("Add Student");
        editStudentButton = new JButton("Edit Student"); // New "Edit Student" button
        displayAllStudentsButton = new JButton("Display All Students");

        // Add components to the JFrame
        add(new JLabel("Name:"));
        add(nameTextField);
        add(new JLabel("Roll Number:"));
        add(rollNumberTextField);
        add(new JLabel("Grade:"));
        add(gradeComboBox); // Use gradeComboBox
        add(addStudentButton);
        add(editStudentButton); // Add "Edit Student" button
        add(displayAllStudentsButton);

        // Add event listeners to the components
        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get the student data from the text fields
                    String name = nameTextField.getText();
                    int rollNumber = Integer.parseInt(rollNumberTextField.getText());
                    String grade = (String) gradeComboBox.getSelectedItem(); // Get selected grade

                    // Create a new student object
                    Student student = new Student(name, rollNumber, grade);

                    // Add the student to the list
                    students.add(student);

                    // Clear the text fields
                    nameTextField.setText("");
                    rollNumberTextField.setText("");
                    gradeComboBox.setSelectedIndex(0); // Reset grade selection
                } catch (NumberFormatException ex) {
                    // Handle the error if non-numeric input is provided
                    JOptionPane.showMessageDialog(TASK_5.this, "Invalid input for Roll Number. Please enter a numeric value.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        editStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedStudentIndex != -1) {
                    try {
                        // Get the edited student data
                        String name = nameTextField.getText();
                        int rollNumber = Integer.parseInt(rollNumberTextField.getText());
                        String grade = (String) gradeComboBox.getSelectedItem();

                        // Update the student in the list
                        Student student = students.get(selectedStudentIndex);
                        student.name = name;
                        student.rollNumber = rollNumber;
                        student.grade = grade;

                        // Clear the text fields
                        nameTextField.setText("");
                        rollNumberTextField.setText("");
                        gradeComboBox.setSelectedIndex(0); // Reset grade selection
                        selectedStudentIndex = -1; // Reset selected index
                    } catch (NumberFormatException ex) {
                        // Handle the error if non-numeric input is provided
                        JOptionPane.showMessageDialog(TASK_5.this, "Invalid input for Roll Number. Please enter a numeric value.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(TASK_5.this, "Select a student to edit first.", "Edit Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        displayAllStudentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display the students in a table
                StudentTableModel model = new StudentTableModel(students);
                JTable studentTable = new JTable(model);
                JScrollPane scrollPane = new JScrollPane(studentTable);

                JFrame tableFrame = new JFrame("Student List");
                tableFrame.add(scrollPane);
                tableFrame.setSize(500, 500);
                tableFrame.setVisible(true);
            }
        });

        // Set the layout of the JFrame
        setLayout(new java.awt.FlowLayout());

        // Set the size of the JFrame
        setSize(500, 300);

        // Set the visibility of the JFrame
        setVisible(true);

        // Set close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TASK_5();
        });
    }
}

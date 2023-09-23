package CodSoft;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

class Student extends JFrame{

//		Top panel
	
	
		public Student() {
        JPanel topPane = new JPanel();
        topPane.setBackground(Color.LIGHT_GRAY);
        JLabel mainHead = new JLabel("Student Management System");
        Font headFont = new Font("verdana",Font.BOLD,14);
        mainHead.setFont(headFont);

//      main panel
        
        
        JPanel mainPane = new JPanel();
        mainPane.setBackground(Color.CYAN);
        mainPane.setLayout(new GridLayout(8,1));
     
//        TextFields
        
        
        JLabel nameLabel = new JLabel("Enter Your Name");
        JTextField nameField = new JTextField(30); 
        JLabel rollLabel = new JLabel("Enter Your Roll_no");
        JTextField roll_field = new JTextField(30);
        JLabel gradeLabel = new JLabel("Enter Your Grade");
        JTextField grad_field = new JTextField(30);
        
        
        
        
        mainPane.setLayout(new FlowLayout());
        
//        Buttons
        
        JButton addsT = new JButton("Add Student");
        JButton edit = new JButton("Edit Student");
        JButton display = new JButton("display Student");
        JButton del = new JButton("Delete");
        JButton del_all = new JButton("Delete All");
        
        
//		Table
        
        JTable studentTable = new JTable();
        DefaultTableModel tableModel = new DefaultTableModel(); 
        tableModel.addColumn("Name");
        tableModel.addColumn("Roll_No");
        tableModel.addColumn("Grade");
        
        studentTable.setModel(tableModel);
        
        JScrollPane jp = new JScrollPane(studentTable);
        mainPane.add(jp);
        
//        eventListning
        
        addsT.addActionListener(al->{
        	
            String name = nameField.getText();
            String rollNo = roll_field.getText();
            String grade = grad_field.getText();

            
            if (!name.isEmpty() && !rollNo.isEmpty() && !grade.isEmpty()) {
                
            	
                
            	DefaultTableModel model = (DefaultTableModel) studentTable.getModel();
                model.addRow(new Object[]{name, rollNo, grade});

                
                nameField.setText("");
                roll_field.setText("");
                grad_field.setText("");  //removing text in input fields after adding data
            } else {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            }

        });
        
        edit.addActionListener(al -> {
        	int selectedRow = studentTable.getSelectedRow();

            if (selectedRow != -1) {
                
                String name = nameField.getText();
                String rollNo = roll_field.getText();
                String grade = grad_field.getText();

                
                DefaultTableModel model = (DefaultTableModel) studentTable.getModel();
                model.setValueAt(name, selectedRow, 0);
                model.setValueAt(rollNo, selectedRow, 1);
                model.setValueAt(grade, selectedRow, 2);

                
                nameField.setText("");
                roll_field.setText("");
                grad_field.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Please select a row to edit.");
            }
        });
        
        display.addActionListener(al -> {
        	studentTable.setVisible(true);
        });
        


//      adding layouts
        
        
        topPane.add(mainHead);
        
        mainPane.add(nameLabel);
        mainPane.add(nameField);
        mainPane.add(rollLabel);
        mainPane.add(roll_field);
        mainPane.add(gradeLabel);
        mainPane.add(grad_field);
        
        
        mainPane.add(addsT);
        mainPane.add(edit);
        mainPane.add(display);
       
        

        setLayout(new BorderLayout()); 
        add(topPane, BorderLayout.NORTH);
        add(mainPane, BorderLayout.CENTER);
        
        studentTable.setVisible(false);
        setTitle("Student Management System");
        setVisible(true);
        setSize(500, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

public class TASK_5 {
    public static void main(String[] args) {
        Student obj = new Student();
    }
}


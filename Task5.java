import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class Task5 extends JFrame implements ActionListener {

    private CourseList courseList;
    private JTextArea textArea;
    private JTextField codeField, nameField, descriptionField, durationField, scheduleField;
    private JButton addButton, deleteButton;

    public Task5() {
        setTitle("Student course Registration");
        courseList = new CourseList();
        textArea = new JTextArea(20, 40);
        JScrollPane scrollPane = new JScrollPane(textArea);
        JPanel inputPanel = new JPanel(new GridLayout(10, 4));
        inputPanel.add(new JLabel("CourseCode:"));
        codeField = new JTextField(10);
        inputPanel.add(codeField);
        inputPanel.add(new JLabel("Course Name:"));
        nameField = new JTextField(10);
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Description:"));
        descriptionField = new JTextField(20);
        inputPanel.add(descriptionField);
        inputPanel.add(new JLabel("Duration hour:"));
        durationField = new JTextField(5);
        inputPanel.add(durationField);
        inputPanel.add(new JLabel("Schedule:"));
        scheduleField = new JTextField(10);
        inputPanel.add(scheduleField);

        addButton = new JButton("Add Course");
        addButton.addActionListener(this);

        deleteButton = new JButton("Delete Course");
        deleteButton.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(scrollPane, BorderLayout.SOUTH);

        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 600);  
        setLocationRelativeTo(null);  
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            addCourse();
        } else if (e.getSource() == deleteButton) {
            deleteCourse();
        }
    }
    private void addCourse() {
        String code = codeField.getText();
        String name = nameField.getText();
        String description = descriptionField.getText();
        String durationStr = durationField.getText();
        String schedule = scheduleField.getText();
        if (!code.isEmpty() && !name.isEmpty() && !description.isEmpty() && !durationStr.isEmpty() && !schedule.isEmpty()) {
            try {
                int duration = Integer.parseInt(durationStr);
                courseList.addCourse(code, name, description, duration, schedule);
                updateTextArea();
                clearFields();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Duration must be a number.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Fill all field", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteCourse() {
        String codeToDelete = JOptionPane.showInputDialog(this, "Enter Course Code to Delete:");
        if (codeToDelete != null && !codeToDelete.isEmpty()) {
            boolean removed = courseList.removeCourse(codeToDelete);
            if (removed) {
                JOptionPane.showMessageDialog(this, "Course with code " + codeToDelete + " deleted successfully.", "Course Deleted", JOptionPane.INFORMATION_MESSAGE);
                updateTextArea();
            } else {
                JOptionPane.showMessageDialog(this, "Course with code " + codeToDelete + " not found.", "Course Not Found", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void updateTextArea() {
        textArea.setText(""); 
        int totalCourses = courseList.getCourses().size();
        textArea.append("Total Courses: " + totalCourses + "\n\n");
        for (Course course : courseList.getCourses()) {
            textArea.append(course + "\n");
        }
    }

    private void clearFields() {
        codeField.setText("");
        nameField.setText("");
        descriptionField.setText("");
        durationField.setText("");
        scheduleField.setText("");
    }

    public static void main(String[] args) {
        new Task5();
    }
}

class Course {
    private String code;
    private String name;
    private String description;
    private int duration;
    private String schedule;

    public Course(String code, String name, String description, int duration, String schedule) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.schedule = schedule;
    }

    public String getCode() {
        return code;
    }

    public String toString() {
        return "Course Code: " + code + ", Name: " + name + ", Description: " + description +
               ", Duration: " + duration + " hours, Schedule: " + schedule;
    }
}

class CourseList {
    private ArrayList<Course> courses;

    public CourseList() {
        courses = new ArrayList<>();
    }

    public void addCourse(String code, String name, String description, int duration, String schedule) {
        Course course = new Course(code, name, description, duration, schedule);
        courses.add(course);
        System.out.println("Course added: " + course.getCode());
    }

    public boolean removeCourse(String codeToRemove) {
        for (Course course : courses) {
            if (course.getCode().equals(codeToRemove)) {
                courses.remove(course);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
}

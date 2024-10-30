package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_class extends JFrame implements ActionListener {

    main_class() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/uni.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1540,780,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        add(img);

        JMenuBar mb = new JMenuBar();

        //-----New Info-----
        JMenu newInfo = new JMenu("New Information");
        newInfo.setForeground(Color.BLACK);
        mb.add(newInfo);
        //faculty info
        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        newInfo.add(facultyInfo);
        //Student info
        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.WHITE);
        studentInfo.addActionListener(this);
        newInfo.add(studentInfo);


        //-----Details-----
        JMenu details = new JMenu("View Details");
        details.setForeground(Color.BLACK);
        details.addActionListener(this);
        mb.add(details);
        //faculty details
        JMenuItem facultyDetails = new JMenuItem("View Faculty Details");
        facultyDetails.setBackground(Color.WHITE);
        facultyDetails.addActionListener(this);
        details.add(facultyDetails);
        //student details
        JMenuItem studentDetails = new JMenuItem("View Student Details");
        studentDetails.setBackground(Color.WHITE);
        studentDetails.addActionListener(this);
        details.add(studentDetails);

        //-----Leave-----
        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.BLACK);
        leave.addActionListener(this);
        mb.add(leave);
        //faculty leave
        JMenuItem facultyLeave = new JMenuItem("Faculty Leave");
        facultyLeave.setBackground(Color.WHITE);
        facultyLeave.addActionListener(this);
        leave.add(facultyLeave);
        //student leave
        JMenuItem studentLeave = new JMenuItem("Student Leave");
        studentLeave.setBackground(Color.WHITE);
        studentLeave.addActionListener(this);
        leave.add(studentLeave);

        //-----Leave Details-----
        JMenu leaveDetails = new JMenu("Leave Details");
        leaveDetails.setForeground(Color.BLACK);
        leaveDetails.addActionListener(this);
        mb.add(leaveDetails);
        //faculty leave details
        JMenuItem facultyLeaveDetails = new JMenuItem("Faculty Leave Details");
        facultyLeaveDetails.setBackground(Color.WHITE);
        facultyLeaveDetails.addActionListener(this);
        leaveDetails.add(facultyLeaveDetails);
        //student leave details
        JMenuItem studentLeaveDetails = new JMenuItem("Student Leave Details");
        studentLeaveDetails.setBackground(Color.WHITE);
        studentLeaveDetails.addActionListener(this);
        leaveDetails.add(studentLeaveDetails);

        //-----Exam-----
        JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.BLACK);
        exam.addActionListener(this);
        mb.add(exam);
        //faculty leave details
        JMenuItem ExaminationDetails = new JMenuItem("Examination Result");
        ExaminationDetails.setBackground(Color.WHITE);
        ExaminationDetails.addActionListener(this);
        exam.add(ExaminationDetails);
        //student leave details
        JMenuItem EnterMarks = new JMenuItem("Enter Marks");
        EnterMarks.setBackground(Color.WHITE);
        EnterMarks.addActionListener(this);
        exam.add(EnterMarks);

        //-----Update Information-----
        JMenu updateInfo = new JMenu("Update Details");
        updateInfo.setForeground(Color.BLACK);
        updateInfo.addActionListener(this);
        mb.add(updateInfo);
        //faculty leave details
        JMenuItem updateFacultyInfo = new JMenuItem("Update Faculty Details");
        updateFacultyInfo.setBackground(Color.WHITE);
        updateFacultyInfo.addActionListener(this);
        updateInfo.add(updateFacultyInfo);
        //student leave details
        JMenuItem updateStudentInfo = new JMenuItem("Update Student Details");
        updateStudentInfo.setBackground(Color.WHITE);
        updateStudentInfo.addActionListener(this);
        updateInfo.add(updateStudentInfo);

        //-----Fees-----
        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.BLACK);
        fee.addActionListener(this);
        mb.add(fee);
        //fee structure
        JMenuItem feeStructure = new JMenuItem("Fee Structure");
        feeStructure.setBackground(Color.WHITE);
        feeStructure.addActionListener(this);
        fee.add(feeStructure);
        //student fee form
        JMenuItem feeForm = new JMenuItem("Student Fee Form");
        feeForm.setBackground(Color.WHITE);
        feeForm.addActionListener(this);
        fee.add(feeForm);

        //-----Utility-----
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.BLACK);
        mb.add(utility);
        //Calculator
        JMenuItem Calculator = new JMenuItem("Calculator");
        Calculator.setBackground(Color.WHITE);
        Calculator.addActionListener(this);
        utility.add(Calculator);
        //NotePad
        JMenuItem Notepad = new JMenuItem("Notes");
        Notepad.setBackground(Color.WHITE);
        Notepad.addActionListener(this);
        utility.add(Notepad);

        //-----About-----
        JMenu about = new JMenu("About");
        utility.setForeground(Color.BLACK);
        mb.add(about);
        //About Calculator
        JMenuItem About = new JMenuItem("About");
        About.setBackground(Color.WHITE);
        about.add(About);

        //-----Exit-----
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.BLACK);
        mb.add(exit);
        //About Calculator
        JMenuItem Exit = new JMenuItem("Exit");
        Exit.setBackground(Color.WHITE);
        Exit.addActionListener(this);
        exit.add(Exit);



        setJMenuBar(mb); //always keep it last


        setSize(1540, 850);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sm = e.getActionCommand();

        if (sm.equals("Exit")) {
            System.exit(15);
        } else if (sm.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("open -a Calculator"); //the cmd is for macbook users
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (sm.equals("Notes")){
            try {
                Runtime.getRuntime().exec("open -a Notes");    //the cmd is for macbook users
            } catch (Exception E) {
                E.printStackTrace();
            }
        }
        //----Linking----
        else if (sm.equals("New Faculty Information")) {
            new AddFaculty();
        } else if (sm.equals("New Student Information")) {
            new AddStudent();
        } else if (sm.equals("View Faculty Details")) {
            new TeacherDetails();
        } else if (sm.equals("View Student Details")) {
            new StudentDetails();
        } else if (sm.equals("Faculty Leave")) {
            new TeacherLeave();
        } else if (sm.equals("Student Leave")) {
            new StudentLeave();
        } else if (sm.equals("Faculty Leave Details")) {
            new TeacherLeaveDetails();
        } else if (sm.equals("Student Leave Details")) {
            new StudentLeaveDetails();
        } else if (sm.equals("Update Faculty Details")) {
            new UpdateTeacher();
        } else if (sm.equals("Update Student Details")) {
            new StudentDetails();
        } else if (sm.equals("Enter Marks")) {
            new EnterMarks();
        } else if (sm.equals("Examination Result")) {
            new ExamDetails();
        } else if (sm.equals("Fee Structure")) {
            new FeeStructure();
        } else if (sm.equals("Student Fee Form")) {
            new StudentFeeForm();
        }
    }

    public static void main(String[] args) {
        new main_class();
    }
}

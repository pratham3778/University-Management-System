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
        newInfo.add(facultyInfo);
        //Student info
        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.WHITE);
        newInfo.add(studentInfo);


        //-----Details-----
        JMenu details = new JMenu("View Details");
        details.setForeground(Color.BLACK);
        mb.add(details);
        //faculty details
        JMenuItem facultyDetails = new JMenuItem("View Faculty Details");
        facultyDetails.setBackground(Color.WHITE);
        details.add(facultyDetails);
        //student details
        JMenuItem studentDetails = new JMenuItem("View Student Details");
        studentDetails.setBackground(Color.WHITE);
        details.add(studentDetails);

        //-----Leave-----
        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.BLACK);
        mb.add(leave);
        //faculty leave
        JMenuItem facultyLeave = new JMenuItem("Faculty Leave");
        facultyLeave.setBackground(Color.WHITE);
        leave.add(facultyLeave);
        //student leave
        JMenuItem studentLeave = new JMenuItem("Student Leave");
        studentLeave.setBackground(Color.WHITE);
        leave.add(studentLeave);

        //-----Leave Details-----
        JMenu leaveDetails = new JMenu("Leave Details");
        leaveDetails.setForeground(Color.BLACK);
        mb.add(leaveDetails);
        //faculty leave details
        JMenuItem facultyLeaveDetails = new JMenuItem("Faculty Leave Details");
        facultyLeaveDetails.setBackground(Color.WHITE);
        leaveDetails.add(facultyLeaveDetails);
        //student leave details
        JMenuItem studentLeaveDetails = new JMenuItem("Student Leave Deatils");
        studentLeaveDetails.setBackground(Color.WHITE);
        leaveDetails.add(studentLeaveDetails);

        //-----Exam-----
        JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.BLACK);
        mb.add(exam);
        //faculty leave details
        JMenuItem ExaminationDetails = new JMenuItem("Examination Result");
        ExaminationDetails.setBackground(Color.WHITE);
        exam.add(ExaminationDetails);
        //student leave details
        JMenuItem EnterMarks = new JMenuItem("Enter Marks");
        EnterMarks.setBackground(Color.WHITE);
        exam.add(EnterMarks);

        //-----Update Information-----
        JMenu updateInfo = new JMenu("Update Details");
        updateInfo.setForeground(Color.BLACK);
        mb.add(updateInfo);
        //faculty leave details
        JMenuItem updateFacultyInfo = new JMenuItem("Update Faculty Information");
        updateFacultyInfo.setBackground(Color.WHITE);
        updateInfo.add(updateFacultyInfo);
        //student leave details
        JMenuItem updateStudentInfo = new JMenuItem("Update Student Details");
        updateStudentInfo.setBackground(Color.WHITE);
        updateInfo.add(updateStudentInfo);

        //-----Fees-----
        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.BLACK);
        mb.add(fee);
        //fee structure
        JMenuItem feeStructure = new JMenuItem("Fee Structure");
        feeStructure.setBackground(Color.WHITE);
        fee.add(feeStructure);
        //student fee form
        JMenuItem feeForm = new JMenuItem("Student Fee Form");
        feeForm.setBackground(Color.WHITE);
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
    }

    public static void main(String[] args) {
        new main_class();
    }
}

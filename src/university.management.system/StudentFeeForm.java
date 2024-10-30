package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.util.concurrent.Semaphore;

public class StudentFeeForm extends JFrame implements ActionListener {
    Choice CrollNumber;
    JLabel totalAmount;
    JButton pay, update, back;
    JComboBox courseBox, branchBox, semesterBox;

    StudentFeeForm() {
        getContentPane().setBackground(new Color(210,252,251));

        //----Take Image----
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/fee.png"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(350,80,500,300);
        add(img);

        //----LABEL ROOLLNO----
        JLabel roollNo = new JLabel("Select Roll Number");
        roollNo.setBounds(40,60,150,20);
        roollNo.setFont(new Font("Tahoma",Font.BOLD,12));
        add(roollNo);
        CrollNumber = new Choice();
        CrollNumber.setBounds(200,60,150,20);
        add(CrollNumber);
        try {
            Conn con = new Conn();
            ResultSet resultSet = con.statement.executeQuery("select * from student");
            while (resultSet.next()) {
                CrollNumber.add(resultSet.getString("rollno"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        //----Name----
        JLabel name = new JLabel("Name");
        name.setBounds(40,100,150,20);
        name.setFont(new Font("Tahoma",Font.BOLD,12));
        add(name);
        JLabel textName = new JLabel();
        textName.setBounds(200,100,150,20);
        add(textName);

        //----Father Name----
        JLabel fname = new JLabel("Father Name");
        fname.setBounds(40,140,150,20);
        fname.setFont(new Font("Tahoma",Font.BOLD,12));
        add(fname);
        JLabel textfName = new JLabel();
        textfName.setBounds(200,140,150,20);
        add(textfName);
        try {
            Conn con = new Conn();
            String Q = "select * from student where rollno = '"+CrollNumber.getSelectedItem()+"'";
            ResultSet resultSet = con.statement.executeQuery(Q);
            while (resultSet.next()) {
                textName.setText(resultSet.getString("name"));
                textfName.setText(resultSet.getString("fname"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        CrollNumber.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    Conn con = new Conn();
                    String Q = "select * from student where rollno = '"+CrollNumber.getSelectedItem()+"'";
                    ResultSet resultSet = con.statement.executeQuery(Q);
                    while (resultSet.next()) {
                        textName.setText(resultSet.getString("name"));
                        textfName.setText(resultSet.getString("fname"));
                    }
                } catch(Exception E) {
                    E.printStackTrace();
                }
            }
        });

        //----Course----
        JLabel course1 = new JLabel("Course");
        course1.setBounds(40,180,150,20);
        course1.setFont(new Font("Tahoma",Font.BOLD,12));
        add(course1);
        String course[] = {"BE","BTech","BSC","BBA","BCA"};
        courseBox = new JComboBox(course);
        courseBox.setBounds(200,180,150,20);
        courseBox.setBackground(Color.WHITE);
        add(courseBox);

        //----Branch----
        JLabel branch = new JLabel("Branch");
        branch.setBounds(40,220,150,20);
        branch.setFont(new Font("Tahoma",Font.BOLD,12));
        add(branch);
        String branchName[] = {"I.T","COMP","ENTC","MECH","CIVIL"};
        branchBox = new JComboBox(branchName);
        branchBox.setBounds(200,220,150,20);
        branchBox.setBackground(Color.WHITE);
        add(branchBox);

        //----Semester----
        JLabel textSemester = new JLabel("Semester");
        textSemester.setBounds(40,260,150,20);
        textSemester.setFont(new Font("Tahoma",Font.BOLD,12));
        add(textSemester);
        String semester [] = {"semester1", "semester2", "semester3", "semester4", "semester5", "semester6", "semester7", "semester8"};
        semesterBox = new JComboBox(semester);
        semesterBox.setBounds(200,260,150,20);
        add(semesterBox);

        //----Total Payable----
        JLabel total = new JLabel("Total Payable");
        total.setBounds(40,300,150,20);
        total.setFont(new Font("Tahoma",Font.BOLD,12));
        add(total);
        totalAmount = new JLabel();
        totalAmount.setBounds(200,300,150,20);
        add(totalAmount);

        //----UPDATE----
        update = new JButton("Update");
        update.setBounds(30,380,100,25);
        update.addActionListener(this);
        add(update);

        //---- PAY FEES----
        pay = new JButton("Pay");
        pay.setBounds(150,380,100,25);
        pay.addActionListener(this);
        add(pay);

        //----BACK----
        back = new JButton("Back");
        back.setBounds(270,380,100,25);
        back.addActionListener(this);
        add(back);


        setSize(900,500);
        setLocation(300,100);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == update) {
            String course = (String) courseBox.getSelectedItem();
            String semester = (String) semesterBox.getSelectedItem();

            try {
                Conn con = new Conn();
                ResultSet resultSet = con.statement.executeQuery("select * from fee where course = '"+course+"'");
                while (resultSet.next()) {
                    totalAmount.setText(resultSet.getString(semester));
                }

            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == pay) {
            String rollno = CrollNumber.getSelectedItem();
            String course = (String) courseBox.getSelectedItem();
            String semester = (String) semesterBox.getSelectedItem();
            String branch = (String) branchBox.getSelectedItem();
            String total = totalAmount.getText();

            try {
                Conn con = new Conn();
                String Q = "insert into feecollege values('"+rollno+"', '"+course+"', '"+branch+"', '"+semester+"', '"+total+"')";
                con.statement.executeUpdate(Q);
                JOptionPane.showMessageDialog(null, "Fee Submitted Successfully");
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentFeeForm();
    }
}

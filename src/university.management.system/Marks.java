package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Marks extends JFrame  implements ActionListener {
    String rollno;
    JButton back;

    Marks(String rollno) {
        this.rollno = rollno;

        getContentPane().setBackground(new Color(210,252,248));

        //----University name----
        JLabel heading = new JLabel("SAVITRIBAI PHULE PUNE UNIVERSITY");
        heading.setBounds(60,10,500,25);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        //----Result----
        JLabel subheading = new JLabel("Result of Examination 2025");
        subheading.setBounds(120,50,500,20);
        subheading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(subheading);

        //----Roll Number----
        JLabel lblrollno = new JLabel("Roll Number: " + rollno);
        lblrollno.setBounds(60,100,500,20);
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblrollno);

        JLabel lblsemester = new JLabel();
        lblsemester.setBounds(60,130,500,20);
        lblsemester.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblsemester);

        JLabel sub1 = new JLabel();
        sub1.setBounds(100,200,500,20);
        sub1.setFont(new Font("Tahoma", Font.PLAIN,18));
        add(sub1);

        JLabel sub2 = new JLabel();
        sub2.setBounds(100,230,500,20);
        sub2.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub2);

        JLabel sub3 = new JLabel();
        sub3.setBounds(100,260,500,20);
        sub3.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub3);

        JLabel sub4 = new JLabel();
        sub4.setBounds(100,290,500,20);
        sub4.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub4);

        JLabel sub5 = new JLabel();
        sub5.setBounds(100,320,500,20);
        sub5.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub5);

        try {
            Conn con = new Conn();
            ResultSet resultSet = con.statement.executeQuery("select * from subject where rollno = '"+rollno+"'");
            while (resultSet.next()) {
                sub1.setText(resultSet.getString("sub1"));
                sub2.setText(resultSet.getString("sub2"));
                sub3.setText(resultSet.getString("sub3"));
                sub4.setText(resultSet.getString("sub4"));
                sub5.setText(resultSet.getString("sub5"));
            }

            ResultSet resultSet1 = con.statement.executeQuery("select * from marks where rollno = '"+rollno+"'");
            while (resultSet1.next()) {
                sub1.setText(sub1.getText() + "-----------" + resultSet1.getString("mrk1"));
                sub2.setText(sub2.getText() + "-----------" + resultSet1.getString("mrk2"));
                sub3.setText(sub3.getText() + "-----------" + resultSet1.getString("mrk3"));
                sub4.setText(sub4.getText() + "-----------" + resultSet1.getString("mrk4"));
                sub5.setText(sub5.getText() + "-----------" + resultSet1.getString("mrk5"));
                lblsemester.setText("Semester " + resultSet1.getString("semester"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        back = new JButton("Back");
        back.setBounds(250,500,120,25);
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.addActionListener(this);
        back.setFont(new Font("Tahoma", Font.BOLD,15));
        add(back);


        setSize(500,600);
        setLocation(500,100);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new Marks("");
    }
}

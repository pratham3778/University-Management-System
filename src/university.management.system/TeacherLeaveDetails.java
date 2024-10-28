package university.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class TeacherLeaveDetails extends JFrame implements ActionListener {

    Choice choiceempID;
    JTable table;
    JButton search, cancel, print;
    TeacherLeaveDetails() {
        getContentPane().setBackground(new Color(250,172,206));

        //----heading----
        JLabel heading = new JLabel("Search By Employee ID");
        heading.setBounds(20,20,150,20);
        add(heading);
        choiceempID = new Choice();
        choiceempID.setBounds(180,20,150,20);
        add(choiceempID);

        try {
            Conn con = new Conn();
            ResultSet resultSet = con.statement.executeQuery("select * from teacher");
            while (resultSet.next()) {
                choiceempID.add(resultSet.getString("empID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //----Table----
        table = new JTable();
        try {
            Conn con = new Conn();
            ResultSet resultSet = con.statement.executeQuery("select * from teacherLeave");
            table.setModel((DbUtils.resultSetToTableModel(resultSet)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0,100,900,600);
        add(scrollPane);

        //search
        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);

        //print
        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        //cancel
        cancel = new JButton("Cancel");
        cancel.setBounds(220,70,80,20);
        cancel.addActionListener(this);
        add(cancel);


        //----basics setting of page----
        setSize(900,700);
        setLocation(300,100);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search) {
            String q = "select * from teacherLeave where empID = '"+choiceempID.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                ResultSet resultSet = c.statement.executeQuery(q);
                table.setModel((DbUtils.resultSetToTableModel(resultSet)));
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == print) {
            try {
                table.print();
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new TeacherLeaveDetails();
    }
}

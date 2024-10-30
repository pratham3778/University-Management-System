package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class UpdateStudent extends JFrame implements ActionListener {

    JTextField textAddress, textPhone, textEmail, textAadhaarCard, textCourse, textBranch;
    JLabel rollNoText;
    Choice cRollNo;
    JButton update, cancel;

    UpdateStudent() {
        getContentPane().setBackground(new Color(230,210,252));

        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("serif",Font.BOLD,35));
        add(heading);

        JLabel rollNo = new JLabel("Select Roll Number");
        rollNo.setBounds(50,100,200,20);
        rollNo.setFont(new Font("serif",Font.PLAIN,20));
        add(rollNo);
        cRollNo = new Choice();
        cRollNo.setBounds(250,100,200,20);
        add(cRollNo);
        try {
            Conn con = new Conn();
            ResultSet rs = con.statement.executeQuery("select * from student");
            while (rs.next()) {
                cRollNo.add(rs.getString("rollno"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        //----Name----
        JLabel name = new JLabel("Name");
        name.setBounds(50,150,200,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);
        JLabel textName = new JLabel();
        textName.setBounds(200,150,150,30);
        add(textName);

        //----Father's Name----
        JLabel fname = new JLabel("Father Name");
        fname.setBounds(400,150,200,30);
        fname.setFont(new Font("serif",Font.BOLD,20));
        add(fname);
        JLabel textFather = new JLabel();
        textFather.setBounds(600,150,150,30);
        add(textFather);

        //----ROll NUMBER----
        JLabel ROLLNO = new JLabel("Roll Number");
        ROLLNO.setBounds(50, 200, 200, 30);
        ROLLNO.setFont(new Font("serif",Font.BOLD,20));
        add(ROLLNO);
        rollNoText = new JLabel();
        rollNoText.setBounds(200,200,150,30);
        rollNoText.setFont(new Font("serif", Font.BOLD, 20));
        add(rollNoText);

        //----DOB----
        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(400, 200, 200, 30);
        dob.setFont(new Font("serif",Font.BOLD,20));
        add(dob);
        JLabel cdob = new JLabel();
        cdob.setBounds(600,200,150,30);
        add(cdob);

        //----ADDRESS----
        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 200, 30);
        address.setFont(new Font("serif",Font.BOLD,20));
        add(address);
        textAddress = new JTextField();
        textAddress.setBounds(200,250,150,30);
        add(textAddress);

        //----Phone Number----
        JLabel phoneNo = new JLabel("Phone No");
        phoneNo.setBounds(400,250,200,30);
        phoneNo.setFont(new Font("serif",Font.BOLD,20));
        add(phoneNo);
        textPhone = new JTextField();
        textPhone.setBounds(600,250,150,30);
        add(textPhone);

        //----Email----
        JLabel email = new JLabel("Email");
        email.setBounds(50,300,200,30);
        email.setFont(new Font("serif", Font.BOLD,20));
        add(email);
        textEmail = new JTextField();
        textEmail.setBounds(200,300,150,30);
        add(textEmail);

        //----Class X Marks----
        JLabel M10 = new JLabel("Class X (%)");
        M10.setBounds(400,300,200,30);
        M10.setFont(new Font("serif",Font.BOLD,20));
        add(M10);
        JLabel textM10 = new JLabel();
        textM10.setBounds(600,300,150,30);
        add(textM10);

        //----Class XII Marks----
        JLabel M12 = new JLabel("Class XII (%)");
        M12.setBounds(50,350,200,30);
        M12.setFont(new Font("serif",Font.BOLD,20));
        add(M12);
        JLabel textM12 = new JLabel();
        textM12.setBounds(200,350,150,30);
        add(textM12);

        //----Aadhaar card----
        JLabel aadhaarCard = new JLabel("Aadhaar No");
        aadhaarCard.setBounds(400,350,200,30);
        aadhaarCard.setFont(new Font("serif",Font.BOLD,20));
        add(aadhaarCard);
        textAadhaarCard = new JTextField();
        textAadhaarCard.setBounds(600,350,150,30);
        add(textAadhaarCard);

        //----Course----
        JLabel course = new JLabel("Course");
        course.setBounds(50,400,200,30);
        course.setFont(new Font("serif",Font.BOLD,20));
        add(course);
        //----Course----
        textCourse = new JTextField();
        textCourse.setBounds(200,400,150,30);
        add(textCourse);

        //----Branch----
        JLabel branch = new JLabel("Branch");
        branch.setBounds(400,400,200,30);
        branch.setFont(new Font("serif",Font.BOLD,20));
        add(branch);
        String branchName[] = {"I.T","COMP","ENTC","MECH","CIVIL"};
        textBranch =new JTextField();
        textBranch.setBounds(600,400,150,30);
        add(textBranch);

        try {
            Conn con = new Conn();
            String query = "select * from student where rollno = '"+cRollNo.getSelectedItem()+"'";
            ResultSet resultSet = con.statement.executeQuery(query);
            while (resultSet.next()) {
                textName.setText(resultSet.getString("name"));
                textFather.setText(resultSet.getString("fname"));
                cdob.setText(resultSet.getString("dob"));
                textAddress.setText(resultSet.getString("address"));
                textPhone.setText(resultSet.getString("phone"));
                textEmail.setText(resultSet.getString("email"));
                textM10.setText(resultSet.getString("class_x"));
                textM12.setText(resultSet.getString("class_xii"));
                textAadhaarCard.setText(resultSet.getString("aadhaar"));
                rollNoText.setText(resultSet.getString("rollno"));
                textCourse.setText(resultSet.getString("Course"));
                textBranch.setText(resultSet.getString("Branch"));
            }
        } catch (Exception E) {
            E.printStackTrace();
        }

        cRollNo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    Conn con = new Conn();
                    String query = "select * from student where rollno = '"+cRollNo.getSelectedItem()+"'";
                    ResultSet resultSet = con.statement.executeQuery(query);
                    while (resultSet.next()) {
                        textName.setText(resultSet.getString("name"));
                        textFather.setText(resultSet.getString("fname"));
                        cdob.setText(resultSet.getString("dob"));
                        textAddress.setText(resultSet.getString("address"));
                        textPhone.setText(resultSet.getString("phone"));
                        textEmail.setText(resultSet.getString("email"));
                        textM10.setText(resultSet.getString("class_x"));
                        textM12.setText(resultSet.getString("class_xii"));
                        textAadhaarCard.setText(resultSet.getString("aadhaar"));
                        rollNoText.setText(resultSet.getString("rollno"));
                        textCourse.setText(resultSet.getString("Course"));
                        textBranch.setText(resultSet.getString("Branch"));
                    }
                }catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        update = new JButton("UPDATE");
        update.setBounds(250,550,120,30);
        update.setBackground(Color.white);
        update.setForeground(Color.black);
        update.addActionListener(this);
        add(update);

        cancel = new JButton("CANCEL");
        cancel.setBounds(450,550,120,30);
        cancel.setBackground(Color.white);
        cancel.setForeground(Color.black);
        cancel.addActionListener(this);
        add(cancel);


        setSize(900,700);
        setLocation(350,50);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == update) {
            String rollno = rollNoText.getText();
            String address = textAddress.getText();
            String phone = textPhone.getText();
            String email = textEmail.getText();
            String course = textCourse.getText();
            String branch = textBranch.getText();
            try {
                String Q = "update student set address = '"+address+"',phone = '"+phone+"', email = '"+email+"', course = '"+course+"', branch = '"+branch+"' where rollno = '"+rollno+"'";
                Conn con = new Conn();
                con.statement.executeUpdate(Q);

                JOptionPane.showMessageDialog(null,"Details Updated");
                setVisible(false);
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateStudent();
    }
}


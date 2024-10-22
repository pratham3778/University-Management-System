package university.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddFaculty extends JFrame implements ActionListener {

    JTextField textName, textFather, textAddress, textPhone, textEmail, textM10, textM12, textAadhaarCard;
    JLabel empText;
    JDateChooser cdob;
    JComboBox courseBox, deptBox;
    JButton submit, cancel;

    Random ran = new Random();
    long f4 = Math.abs((ran.nextLong()% 9000L) + 1000L);

    AddFaculty () {
        getContentPane().setBackground(new Color(166,164,252));

        JLabel heading = new JLabel("New Teacher Deatils");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        //----Name----
        JLabel name = new JLabel("Name");
        name.setBounds(50,150,200,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);
        textName = new JTextField();
        textName.setBounds(200,150,150,30);
        add(textName);

        //----Father's Name----
        JLabel fname = new JLabel("Father Name");
        fname.setBounds(400,150,200,30);
        fname.setFont(new Font("serif",Font.BOLD,20));
        add(fname);
        textFather = new JTextField();
        textFather.setBounds(600,150,150,30);
        add(textFather);

        //----Employee ID----
        JLabel empID = new JLabel("Employee ID");
        empID.setBounds(50, 200, 200, 30);
        empID.setFont(new Font("serif",Font.BOLD,20));
        add(empID);
        empText = new JLabel("3778" + f4);
        empText.setBounds(200,200,150,30);
        empText.setFont(new Font("serif", Font.BOLD, 20));
        add(empText);

        //----DOB----
        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(400, 200, 200, 30);
        dob.setFont(new Font("serif",Font.BOLD,20));
        add(dob);
        cdob = new JDateChooser();
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
        textM10 = new JTextField();
        textM10.setBounds(600,300,150,30);
        add(textM10);

        //----Class XII Marks----
        JLabel M12 = new JLabel("Class XII (%)");
        M12.setBounds(50,350,200,30);
        M12.setFont(new Font("serif",Font.BOLD,20));
        add(M12);
        textM12 = new JTextField();
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

        //----Qualification----
        JLabel Qualification = new JLabel("Qualification");
        Qualification.setBounds(50,400,200,30);
        Qualification.setFont(new Font("serif",Font.BOLD,20));
        add(Qualification);
        String course[] = {"B.E","B.TECH","BSC","BBA","BCA"};
        courseBox = new JComboBox(course);
        courseBox.setBounds(200,400,150,30);
        courseBox.setBackground(Color.WHITE);
        add(courseBox);

        //----Department----
        JLabel dept = new JLabel("Department");
        dept.setBounds(400,400,200,30);
        dept.setFont(new Font("serif",Font.BOLD,20));
        add(dept);
        String deptName[] = {"I.T","COMP","ENTC","MECH","CIVIL"};
        deptBox = new JComboBox(deptName);
        deptBox.setBounds(600,400,150,30);
        deptBox.setBackground(Color.WHITE);
        add(deptBox);

        submit = new JButton("SUBMIT");
        submit.setBounds(250,550,120,30);
        submit.setBackground(Color.white);
        submit.setForeground(Color.black);
        submit.addActionListener(this);
        add(submit);

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
        if (e.getSource() == submit) {
            String name = textName.getText();
            String fname = textFather.getText();
            String empID = empText.getText();
            String dob = ((JTextField)cdob.getDateEditor().getUiComponent()).getText();
            String address = textAddress.getText();
            String phone = textPhone.getText();
            String email = textEmail.getText();
            String x = textM10.getText();
            String xii = textM12.getText();
            String aadhaar = textAadhaarCard.getText();
            String course = (String) courseBox.getSelectedItem();
            String dept = (String) deptBox.getSelectedItem();
            try {
                String q = "insert into teacher values('"+name+"', '"+fname+"', '"+empID+"', '"+dob+"', '"+address+"', '"+phone+"', '"+email+"', '"+x+"', '"+xii+"', '"+aadhaar+"', '"+course+"', '"+dept+"')";
                Conn c = new Conn();
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Details Inserted");
                setVisible(false);
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new AddFaculty();
    }

}

package university.management.system;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame  {
    About() {
        getContentPane().setBackground(new Color(252,228,210));

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/about.png"));
        Image i2 = i1.getImage().getScaledInstance(300,200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(350,0,300,200);
        add(img);

        JLabel heading = new JLabel("<html> SAVITRIBAI PHULE </br> PUNE UNIVERSITY</html>");
        heading.setBounds(70,20,300,120);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);

        JLabel name = new JLabel("Pratham Tanpure");
        name.setBounds(60,260,550,40);
        name.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(name);

        JLabel contact = new JLabel("pratham3778@gmail.com");
        contact.setBounds(60,300,550,40);
        contact.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(contact);

        setSize(700,500);
        setLocation(400,150);
        setLayout(null);
        setVisible(true);

    }
    public static void main(String[] args) {
        new About();
    }
}

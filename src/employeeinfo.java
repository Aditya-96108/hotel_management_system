import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.proteanit.sql.*;

import javax.swing.*;

public class employeeinfo extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    employeeinfo()
    {
        getContentPane().setBackground(Color.WHITE);
        setBounds(300,200,1000,600);


        JTable table=new JTable();
        table.setBounds(0,40,1000,400);
        add(table);
        try{
            conn c=new conn();
            String que="select * from employee";
            ResultSet set=c.s.executeQuery(que);
            table.setModel(DbUtils.resultSetToTableModel(set));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        JLabel roomno=new JLabel("NAME");
        roomno.setFont(new Font("tah-ma",Font.BOLD,10));
        roomno.setBounds(10,10,80,20);
        add(roomno);
        JLabel avail=new JLabel("AGE");
        avail.setFont(new Font("tah-ma",Font.BOLD,10));
        avail.setBounds(130,10,120,20);
        add(avail);
        JLabel cleanst=new JLabel("GENDER");
        cleanst.setFont(new Font("tah-oma",Font.BOLD,10));
        cleanst.setBounds(260,10,160,20);
        add(cleanst);
        JLabel price=new JLabel("JOB");
        price.setFont(new Font("tah-oma",Font.BOLD,10));
        price.setBounds(385,10,200,20);
        add(price);
        JLabel salary=new JLabel("SALARY");
        salary.setFont(new Font("tah-oma",Font.BOLD,10));
        salary.setBounds(510,10,240,20);
        add(salary);
        JLabel phonenumber=new JLabel("PHONE NUMBER");
        phonenumber.setFont(new Font("tah-oma",Font.BOLD,10));
        phonenumber.setBounds(640,10,280,20);
        add(phonenumber);
        JLabel email=new JLabel("EMAIL");
        email.setFont(new Font("tah-oma",Font.BOLD,10));
        email.setBounds(780,10,320,20);
        add(email);
        JLabel aadhar=new JLabel("AADHAR");
        aadhar.setFont(new Font("tah-oma",Font.BOLD,10));
        aadhar.setBounds(890,10,320,20);
        add(aadhar);
        back=new JButton("BACK");
        back.setBounds(420,500,120,30);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBackground(Color.black);
        add(back);
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==back)
        {
            setVisible(false);
            new reception();
        }

    }

    public static void main(String args[])
    {
        new employeeinfo();
    }
}

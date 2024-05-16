import java.awt.BorderLayout;
import java.awt.*;

import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class searchroom extends JFrame implements ActionListener {
    JTable table;
    JButton back,submit;
    JComboBox bedtypee;
    JCheckBox available;
    JLabel text;
    searchroom()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(300,200,1000,600);

        text=new JLabel("SEARCH ROOMS");

        text.setFont(new Font("tah-oma",Font.BOLD,20));
        text.setBounds(400,30,200,30);
        add(text);
        JLabel lblbed=new JLabel("BED TYPE");
        lblbed.setBounds(50,100,100,20);
        add(lblbed);
        bedtypee=new JComboBox(new String[]{"SINGLE BED","DOUBLE BED"});
        bedtypee.setBounds(150,100,150,25);
        bedtypee.setBackground(Color.WHITE);
        add(bedtypee);

        available =new JCheckBox("only display available");
        available.setBounds(650,100,150,25);
        available.setBackground(Color.WHITE);
        add(available);




        table=new JTable();
        table.setBounds(0,200,1000,300);
        add(table);
        try{
            conn c=new conn();
            String que="select * from room";
            ResultSet set=c.s.executeQuery(que);
            table.setModel(DbUtils.resultSetToTableModel(set));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        JLabel roomno=new JLabel("ROOM NUMBER");
        roomno.setFont(new Font("tah-ma",Font.BOLD,10));
        roomno.setBounds(50,160,100,20);
        add(roomno);
        JLabel avail=new JLabel("AVAILABILITY");
        avail.setFont(new Font("tah-ma",Font.BOLD,10));
        avail.setBounds(270,160,100,20);
        add(avail);
        JLabel cleanst=new JLabel("CLEANING STATUS");
        cleanst.setFont(new Font("tah-oma",Font.BOLD,10));
        cleanst.setBounds(450,160,100,20);
        add(cleanst);
        JLabel price=new JLabel("PRICE");
        price.setFont(new Font("tah-oma",Font.BOLD,10));
        price.setBounds(670,160,100,20);
        add(price);
        JLabel bedtype=new JLabel("BED TYPE");
        bedtype.setFont(new Font("tah-oma",Font.BOLD,10));
        bedtype.setBounds(870,160,100,20);
        add(bedtype);
        back=new JButton("BACK");
        back.setBounds(500,520,120,30);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBackground(Color.black);
        add(back);

        submit=new JButton("SUBMIT");
        submit.setBounds(300,520,120,30);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setBackground(Color.black);
        add(submit);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource() == submit)
        {

            try{

                String que1="select * from room where bed_type='"+bedtypee.getSelectedItem()+"'";
                String data = bedtypee.getSelectedItem().toString();
                System.out.println("bedtype "+data);
                text.setText(data);
                String que2="select * from room where availability='AVAILABLE' AND bed_type='"+data+"'";
                conn c=new conn();
                ResultSet rs;
                if(available.isSelected())
                {
                    rs=c.s.executeQuery(que2);

                }
                else {
                    rs = c.s.executeQuery(que1);
                }
                    table.setModel(DbUtils.resultSetToTableModel(rs));

            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==back)
        {
            setVisible(false);
            new reception();
        }
    }
    public static void main(String args[])
    {
        new searchroom();
    }
}

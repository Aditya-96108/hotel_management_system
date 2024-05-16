import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.proteanit.sql.*;
public class department extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    department()
    {
        getContentPane().setBackground(Color.WHITE);
        setBounds(300,200,1050,600);
        JTable table=new JTable();
        table.setBounds(0,40,1050,400);
        add(table);
        try{
            conn c=new conn();
            String que="select * from department";
            ResultSet set=c.s.executeQuery(que);
            table.setModel(DbUtils.resultSetToTableModel(set));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        JLabel dept=new JLabel("DEPARTMENT");
        dept.setFont(new Font("tah-ma",Font.BOLD,20));
        dept.setBounds(260,10,180,20);
        add(dept);
        JLabel budget=new JLabel("BUDGET");
        budget.setFont(new Font("tah-ma",Font.BOLD,20));
        budget.setBounds(785,10,100,20);
        add(budget);
        back=new JButton("BACK");
        back.setBounds(500,500,120,30);
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
        new department();
    }
}

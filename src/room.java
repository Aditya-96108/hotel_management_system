import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.proteanit.sql.*;
public class room extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    room()
    {
        getContentPane().setBackground(Color.WHITE);
        setBounds(300,200,1050,600);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2=i1.getImage().getScaledInstance(550,600,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(500,0,600,600);
        add(image);

        JTable table=new JTable();
        table.setBounds(0,40,500,400);
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
        roomno.setBounds(10,10,80,20);
        add(roomno);
        JLabel avail=new JLabel("AVAILAIBILITY");
        avail.setFont(new Font("tah-ma",Font.BOLD,10));
        avail.setBounds(110,10,100,20);
        add(avail);
        JLabel cleanst=new JLabel("STATUS");
        cleanst.setFont(new Font("tah-oma",Font.BOLD,10));
        cleanst.setBounds(220,10,100,20);
        add(cleanst);
        JLabel price=new JLabel("PRICE");
        price.setFont(new Font("tah-oma",Font.BOLD,10));
        price.setBounds(320,10,100,20);
        add(price);
        JLabel bedtype=new JLabel("BED TYPE");
        bedtype.setFont(new Font("tah-oma",Font.BOLD,10));
        bedtype.setBounds(400,10,100,20);
        add(bedtype);
        back=new JButton("BACK");
        back.setBounds(200,500,120,30);
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
        new room();
    }
}

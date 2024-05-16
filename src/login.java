import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class login extends JFrame implements ActionListener {

    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;

    login(){


        setLayout(null);

        l1 = new JLabel("Username");
        l1.setBounds(40,20,100,30);
        add(l1);

        l2 = new JLabel("Password");
        l2.setBounds(40,70,100,30);
        add(l2);

        t1=new JTextField();
        t1.setBounds(150,20,150,30);
        add(t1);

        t2=new JPasswordField();
        t2.setBounds(150,70,150,30);
        add(t2);

        b1 = new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,10,200,200);
        add(image);


        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
        setSize(600,300);
        setLocation(600,350);

    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
        {
            try{
                String user=t1.getText();
                String pass=t2.getText();
                conn c=new conn();
                String que = "select * from login where username='"+user+"' and password='"+pass+"'";
                ResultSet rs=c.s.executeQuery(que);
                if(rs.next())
                {
                    setVisible(false);
                    new dash().setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null,"invalid user name or password");
                    setVisible(false);

                }
            }
            catch (Exception ae)
            {
                ae.printStackTrace();
            }
        }
        else if(e.getSource()==b2)
        {
            setVisible(false);
        }

    }
    public static void main(String args[])
    {

        new login();

    }


}

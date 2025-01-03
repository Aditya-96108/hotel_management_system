import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class updatecheck extends JFrame implements ActionListener {
    Choice ccustomer;
    JTextField tfroom,tfname,tfcheckin,tfpaid,tfpending;
    JButton check,update,back;

    updatecheck(){
        getContentPane().setBackground(Color.PINK);
        setLayout(null);

        JLabel text=new JLabel("UPDATE STATUS");
        text.setFont(new Font("taho-ma",Font.BOLD,20));
        text.setBounds(90,20,200,30);
        text.setForeground(Color.WHITE);
        add(text);

        JLabel lblid=new JLabel("CUSTOMER ID");
        lblid.setBounds(30,80,100,20);
        add(lblid);

        ccustomer=new Choice();
        ccustomer.setBounds(200,80,150,25);
        add(ccustomer);

        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            while(rs.next())
            {
                ccustomer.add(rs.getString("number"));
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }

        JLabel lblroom=new JLabel("ROOM NUMBER");
        lblroom.setBounds(30,120,100,20);
        add(lblroom);
        tfroom=new JTextField();
        tfroom.setBounds(200,120,150,25);
        add(tfroom);

        JLabel lblname=new JLabel("NAME");
        lblname.setBounds(30,160,100,20);
        add(lblname);
        tfname=new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);


        JLabel lblcheckin=new JLabel("CHECKIN TIME");
        lblcheckin.setBounds(30,200,100,20);
        add(lblcheckin);
        tfcheckin=new JTextField();
        tfcheckin.setBounds(200,200,150,25);
        add(tfcheckin);



        JLabel lblpaid=new JLabel("AMOUNT PAID");
        lblpaid.setBounds(30,240,100,20);
        add(lblpaid);
        tfpaid=new JTextField();
        tfpaid.setBounds(200,240,150,25);
        add(tfpaid);

        JLabel lblpending=new JLabel("PENDING AMOUNT");
        lblpending.setBounds(30,280,150,20);
        add(lblpending);
        tfpending=new JTextField();
        tfpending.setBounds(200,280,150,25);
        add(tfpending);

        check=new JButton("CHECK");
        check.setBackground(Color.black);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        check.setBounds(30,340,100,30);
        add(check);

        update=new JButton("UPDATE");
        update.setBackground(Color.black);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        update.setBounds(150,340,100,30);
        add(update);

        back=new JButton("BACK");
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(270,340,100,30);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(400,50,500,300);
        add(image);




        setBounds(300,300,980,500);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==back)
        {
            setVisible(false);
            new reception();
        }
        else if(ae.getSource()==update)
        {
            String number=ccustomer.getSelectedItem();
            String room=tfroom.getText();
            String  name=tfname.getText();
            String checkin=tfcheckin.getText();
            String deposit=tfpaid.getText();

            try{
                conn c=new conn();
                c.s.executeUpdate("update customer set room='"+room+"',name='"+name+"', check_in_time='"+checkin+"',deposit='"+deposit+"'");
                JOptionPane.showMessageDialog(null,"DATA UPDATED SUCCESSFULLY");
                setVisible(false);
                new reception();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }






        }
        else if(ae.getSource()==check)
        {

            String id=ccustomer.getSelectedItem();
            String query="select * from customer where number ='"+id+"'";
            try{
                conn c=new conn();
                ResultSet rs=c.s.executeQuery(query);
                while(rs.next())
                {
                    tfroom.setText(rs.getString("room"));
                    tfname.setText(rs.getString("name"));
                    tfcheckin.setText(rs.getString("check_in_time"));
                    tfpaid.setText(rs.getString("deposit"));
                }
                ResultSet rs2=c.s.executeQuery("select * from room where roomnumber='"+tfroom.getText()+"'");
                while(rs2.next())
                {
                    String price=rs2.getString("price");
                    int amountpaid=Integer.parseInt(price)-Integer.parseInt(tfpaid.getText());
                    tfpending.setText(""+amountpaid);
                    if(amountpaid<=0)
                    {
                        tfpending.setText("NIL");
                    }

                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }



    }
    public static void main(String args[])
    {
        new updatecheck();
    }



}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Date.*;

public class addcustomer extends JFrame implements ActionListener {
    JComboBox comboid;
    JRadioButton male,female;
    JTextField tfnumber,tfname,tfcountry,tfdeposit;
    Choice croom;
    JButton add,back;
    JLabel checkintime;
    addcustomer()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text=new JLabel("NEW CUSTOMER FORM");
        text.setBounds(100,20,300,30);
        text.setFont(new Font("Raleway",Font.PLAIN,20));
        add(text);

        JLabel lblid=new JLabel("ID");
        lblid.setBounds(35,80,300,30);
        lblid.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblid);

        String[] options={"Aadhar Card","Passport","Driving License","Voter-ID","Ration Card"};
        comboid=new JComboBox(options);
        comboid.setBounds(200,80,150,25);
        comboid.setBackground(Color.WHITE);
        add(comboid);

        JLabel lblnumber=new JLabel("NUMBER");
        lblnumber.setBounds(35,120,100,20);
        lblnumber.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblnumber);

        tfnumber=new JTextField();
        tfnumber.setBounds(200,120,150,25);
        add(tfnumber);

        JLabel lblname=new JLabel("NAME");
        lblname.setBounds(35,160,100,20);
        lblname.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblname);

        tfname=new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);


        JLabel lblgender=new JLabel("GENDER");
        lblgender.setBounds(35,200,100,20);
        lblgender.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblgender);


        male=new JRadioButton("MALE");
        male.setBounds(200,200,80,25);
        male.setBackground(Color.WHITE);
        add(male);

         female=new JRadioButton("FEMALE");
        female.setBounds(280,200,80,25);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup bg=new ButtonGroup();
        bg.add(male);
        bg.add(female);


        JLabel lblcountry=new JLabel("COUNTRY");
        lblcountry.setBounds(35,240,100,20);
        lblcountry.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblcountry);

        tfcountry=new JTextField();
        tfcountry.setBounds(200,240,150,25);
        add(tfcountry);

        JLabel lblroom=new JLabel("ROOMNUMBER");
        lblroom.setBounds(35,280,150,20);
        lblroom.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblroom);


        croom=new Choice();
        croom.setBounds(200,280,150,25);
        add(croom);
         try{
             conn c=new conn();
             String query="select * from room";
             ResultSet set= c.s.executeQuery(query);
             while(set.next())
             {
                 croom.add(set.getString("roomnumber"));
             }
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }


        JLabel lbltime=new JLabel("CHECK IN TIME");
        lbltime.setBounds(35,320,150,20);
        lbltime.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbltime);

        Date date=new Date();
         checkintime =new JLabel(" "+date);
        checkintime.setBounds(200,320,270,20);
        checkintime.setFont(new Font("Raleway",Font.PLAIN,15));
        add(checkintime);

        JLabel lbldeposit=new JLabel("DEPOSIT");
        lbldeposit.setBounds(35,360,100,20);
        lbldeposit.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbldeposit);

        tfdeposit=new JTextField();
        tfdeposit.setBounds(200,360,150,25);
        add(tfdeposit);

         add =new JButton("ADD");
        add.addActionListener(this);
        add.setBounds(50,410,120,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        back =new JButton("BACK");
        back.addActionListener(this);
        back.setBounds(200,410,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2=i1.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,50,350,500);
        add(image);

        setBounds(350,200,800,550);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==add)
        {
            String id = (String) comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = tfname.getText();
            String gender=null;
            if(male.isSelected())
            {
                gender="MALE";
            }
            else
            {
               gender="FEMALE";
            }
            String country=tfcountry.getText();
            String room=croom.getSelectedItem();
            String time= checkintime.getText();
            String deposit=tfdeposit.getText();
            try{
                String que="insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
                String str="update room set availability='OCCUPIED' where roomnumber='"+room+ "'";
                conn c=new conn();
                c.s.executeUpdate(que);
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"NEW CUSTOMER ADDED SUCCESSFULLY");
                setVisible(false);
                new reception();
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
        new addcustomer();
    }
}

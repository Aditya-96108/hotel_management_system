import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addrooms extends JFrame implements ActionListener {
    JButton add,cancel;
    JTextField tfroom,tfprice;
    JComboBox typecombo,available,cleancombo;
    JLabel heading,lblroomno,lblavailable,lblclean,lblprice,lbltype;
    addrooms()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);

        heading=new JLabel("ADD ROOMS");
        heading.setFont(new Font("tah-oma",Font.BOLD,18));
        heading.setBounds(150,20,200,20);
        add(heading);

         lblroomno=new JLabel("ROOM NUMBER");
        lblroomno.setFont(new Font("tah-oma",Font.PLAIN,16));
        lblroomno.setBounds(60,80,140,30);
        add(lblroomno);

        tfroom=new JTextField("");
        tfroom.setBounds(220,80,150,30);
        add(tfroom);

        lblavailable=new JLabel("AVAILABLE");
        lblavailable.setFont(new Font("tah-oma",Font.PLAIN,16));
        lblavailable.setBounds(60,130,140,30);
        add(lblavailable);

        String availableoptions[] ={"AVAILABLE","OCCUPIED"};
         available=new JComboBox(availableoptions);
        available.setBounds(220,130,150,30);
        available.setBackground(Color.white);
        add(available);

         lblclean=new JLabel("CLEANING STATUS");
        lblclean.setFont(new Font("tah-oma",Font.PLAIN,16));
        lblclean.setBounds(60,180,180,30);
        add(lblclean);

        String cleanoptions[] ={"CLEANED","DIRTY"};
         cleancombo=new JComboBox(cleanoptions);
        cleancombo.setBounds(220,180,150,30);
        cleancombo.setBackground(Color.white);
        add(cleancombo);

         lblprice=new JLabel("PRICE");
        lblprice.setFont(new Font("tah-oma",Font.PLAIN,16));
        lblprice.setBounds(60,230,140,30);
        add(lblprice);

         tfprice=new JTextField("");
        tfprice.setBounds(220,230,150,30);
        add(tfprice);

         lbltype=new JLabel("BED TYPE");
        lbltype.setFont(new Font("tah-oma",Font.PLAIN,16));
        lbltype.setBounds(60,280,180,30);
        add(lbltype);

        String typeoptions[] ={"SINGLE BED","DOUBLE BED"};
         typecombo=new JComboBox(typeoptions);
        typecombo.setBounds(220,280,150,30);
        typecombo.setBackground(Color.white);
        add(typecombo);

        add=new JButton("ADD ROOM");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.addActionListener(this);
        add.setBounds(60,350,130,30);
        add(add);

        cancel=new JButton("CANCEL");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        cancel.setBounds(220,350,130,30);
        add(cancel);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        Image i2=i1.getImage().getScaledInstance(550,550,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,30,500,300);
        add(image);

        setBounds(330,200,940,470);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==add)
        {
            String roomnumber=tfroom.getText();
            String availability=(String)available.getSelectedItem();
            String status=(String) cleancombo.getSelectedItem();
            String price=tfprice.getText();
            String type=(String)typecombo.getSelectedItem();
            try{
              conn c=new conn();
              String str="insert into room values('"+roomnumber+"','"+availability+"','"+status+"','"+price+"','"+type+"')";
              c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"New Room Added Successfully");
                setVisible(false);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==cancel)
        {
            setVisible(false);
        }

    }







    public static void main(String args[])
    {
        new addrooms();
    }


}

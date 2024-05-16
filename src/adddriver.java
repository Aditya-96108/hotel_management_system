import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adddriver extends JFrame implements ActionListener {
    JButton add,cancel;
    JTextField tflocation,tfname,tfprice,tfage,tfcompany,tfmodel;
    JComboBox typecombo,available,cleancombo,agecombo,AVAILCOMBO;
    JLabel lbllocation,lblavail,heading,lblroomno,lblavailable,lblclean,lblprice,lbltype;
    adddriver()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);

        heading=new JLabel("ADD DRIVERS");
        heading.setFont(new Font("tah-oma",Font.BOLD,18));
        heading.setBounds(150,20,200,20);
        add(heading);

        lblroomno=new JLabel("NAME");
        lblroomno.setFont(new Font("tah-oma",Font.PLAIN,16));
        lblroomno.setBounds(60,80,140,30);
        add(lblroomno);

        tfname=new JTextField("");
        tfname.setBounds(220,80,150,30);
        add(tfname);

        lblavailable=new JLabel("AGE");
        lblavailable.setFont(new Font("tah-oma",Font.PLAIN,16));
        lblavailable.setBounds(60,130,140,30);
        add(lblavailable);

        tfage=new JTextField("");
        tfage.setBounds(220,130,150,30);
        add(tfage);

        lblclean=new JLabel("GENDER");
        lblclean.setFont(new Font("tah-oma",Font.PLAIN,16));
        lblclean.setBounds(60,180,180,30);
        add(lblclean);

        String cleanoptions[] ={"MALE","FEMALE"};
        agecombo=new JComboBox(cleanoptions);
        agecombo.setBounds(220,180,150,30);
        agecombo.setBackground(Color.white);
        add(agecombo);

        lblprice=new JLabel("CAR COMPANY");
        lblprice.setFont(new Font("tah-oma",Font.PLAIN,16));
        lblprice.setBounds(60,230,140,30);
        add(lblprice);

        tfcompany=new JTextField("");
        tfcompany.setBounds(220,230,150,30);
        add(tfcompany);

        lbltype=new JLabel("CAR MODEL");
        lbltype.setFont(new Font("tah-oma",Font.PLAIN,16));
        lbltype.setBounds(60,280,180,30);
        add(lbltype);

        tfmodel=new JTextField("");
        tfmodel.setBounds(220,280,150,30);
        add(tfmodel);

        lblavail=new JLabel("AVAILABLE");
        lblavail.setFont(new Font("tah-oma",Font.PLAIN,16));
        lblavail.setBounds(60,330,180,30);
        add(lblavail);

        String CBAVAIL[] ={"AVAILABLE","UNAVAILABLE"};
        AVAILCOMBO=new JComboBox(CBAVAIL);
        AVAILCOMBO.setBounds(220,330,150,30);
        AVAILCOMBO.setBackground(Color.white);
        add(AVAILCOMBO);


        lbllocation=new JLabel("LOCATION");
        lbllocation.setFont(new Font("tah-oma",Font.PLAIN,16));
        lbllocation.setBounds(60,380,140,30);
        add(lbllocation);

        tflocation=new JTextField("");
        tflocation.setBounds(220,380,150,30);
        add(tflocation);

        add=new JButton("ADD DRIVER");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.addActionListener(this);
        add.setBounds(60,430,130,30);
        add(add);

        cancel=new JButton("CANCEL");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        cancel.setBounds(220,430,130,30);
        add(cancel);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2=i1.getImage().getScaledInstance(550,450,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,30,500,400);
        add(image);

        setBounds(300,200,980,520);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==add)
        {
            String name=tfname.getText();
            String age=tfage.getText();
            String gender=(String) agecombo.getSelectedItem();
            String company=tfcompany.getText();
            String brand=tfmodel.getText();
            String available=(String)AVAILCOMBO.getSelectedItem();
            String location=tflocation.getText();


            try{
                conn c=new conn();
                String str="insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+brand+"','"+available+"','"+location+"')";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"New Driver Added Successfully");
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
        new adddriver();
    }

}


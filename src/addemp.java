import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class addemp extends  JFrame implements ActionListener{
    JTextField nametext,agetext,sal,ph,EM,add;
    JButton submit;
    JLabel name,phone,Email,age,gender,job,salary,aadhar;
    JRadioButton gen,genF;
    JComboBox cbjob;
    ButtonGroup bg;

    addemp()
    {
        setLayout(null);
        setBounds(350,200,850,540);

        name=new JLabel("NAME");
        name.setBounds(60,30,120,30);
        name.setFont(new Font("tah-oma", Font.PLAIN,17));
        add(name);
        nametext=new JTextField("");
        nametext.setBounds(200,30,150,30);
        add(nametext);

        age=new JLabel("AGE");
        age.setBounds(60,80,120,30);
        age.setFont(new Font("tah-oma", Font.PLAIN,17));
        add(age);
        agetext=new JTextField("");
        agetext.setBounds(200,80,150,30);
        add(agetext);

        gender=new JLabel("GENDER");
        gender.setBounds(60,130,120,30);
        gender.setFont(new Font("tah-oma", Font.PLAIN,17));
        add(gender);
         gen=new JRadioButton("MALE");
        gen.setBounds(200,130,70,30);
        gen.setFont(new Font("tah-oma", Font.PLAIN,17));
        gen.setBackground(Color.WHITE);
        add(gen);

         genF=new JRadioButton("FEMALE");
        genF.setBounds(280,130,100,30);
        genF.setFont(new Font("tah-oma", Font.PLAIN,17));
        genF.setBackground(Color.WHITE);
        add(genF);

         bg=new ButtonGroup();
        bg.add(gen);
        bg.add(genF);

        job=new JLabel("JOB");
        job.setBounds(60,180,80,30);
        job.setFont(new Font("tah-oma", Font.PLAIN,17));
        add(job);
        String[] str={"Housekeeper","Maintenance Supervisor","Host Or Hostess","Chef","Convention Centre Manager","Event Planner","Waiter/Waitress"};
         cbjob=new JComboBox(str);
        cbjob.setBounds(200,180,150,30);
        cbjob.setBackground(Color.WHITE);
        add(cbjob);

        salary=new JLabel("SALARY");
        salary.setBounds(60,230,120,30);
        salary.setFont(new Font("tah-oma", Font.PLAIN,17));
        add(salary);
        sal=new JTextField("Rs.");
        sal.setBounds(200,230,150,30);
        add(sal);

         phone=new JLabel("PHONE");
        phone.setBounds(60,280,120,30);
        phone.setFont(new Font("tah-oma", Font.PLAIN,17));
        add(phone);
         ph=new JTextField("+91");
        ph.setBounds(200,280,150,30);
        add(ph);

        Email=new JLabel("EMAIL");
        Email.setBounds(60,330,120,30);
        Email.setFont(new Font("tah-oma", Font.PLAIN,17));
        add(Email);
         EM=new JTextField("");
        EM.setBounds(200,330,150,30);
        add(EM);

         submit=new JButton("SUBMIT");
        submit.setBounds(200,430,150,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2=i1.getImage().getScaledInstance(450,550,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(380,60,450,550);
        add(image);

        aadhar=new JLabel("AADHAR");
        aadhar.setBounds(60,380,120,30);
        aadhar.setFont(new Font("tah-oma", Font.PLAIN,17));
        add(aadhar);
         add=new JTextField("");
        add.setBounds(200,380,150,30);
        add(add);



        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String name= nametext.getText();
        String age=agetext.getText();
        String salary=sal.getText();
        String phone=ph.getText();
        String email=EM.getText();
        String aadhar=add.getText();

        String gender=null;
        if(name.equals("") )
        {
            JOptionPane.showMessageDialog(null,"name should not be empty");
            return;
        }
        if(aadhar.equals("") )
        {
            JOptionPane.showMessageDialog(null,"aadhar should not be empty or wrong");
            return;
        }

        if(gen.isSelected())
        {
            gender="MALE";
        }
        else if(genF.isSelected())
        {
            gender="FEMALE";
        }
        String job=(String)cbjob.getSelectedItem();
        try{
            conn c=new conn();
            String que="insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
            c.s.executeUpdate(que);
            JOptionPane.showMessageDialog(null,"Employee added successfully");
            setVisible(false);
           }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String args[])
    {
        new addemp();
    }


}

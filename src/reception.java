import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class reception extends JFrame implements ActionListener {
    JButton newcustomer,rooms,department,allEmployee,managerinfo,customers,searchroom,update;
    reception()
    {
        getContentPane().setBackground(Color.WHITE);

        newcustomer=new JButton("NEW CUSTOMER FORM");
        newcustomer.setBackground(Color.BLACK);
        newcustomer.setForeground(Color.WHITE);
        newcustomer.setBounds(10,30,200,30);
        newcustomer.addActionListener(this);
        add(newcustomer);

        rooms=new JButton("ROOMS");
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.setBounds(10,70,200,30);
        rooms.addActionListener(this);
        add(rooms);

        department=new JButton("DEPARTMENT");
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        department.setBounds(10,110,200,30);
        department.addActionListener(this);
        add(department);

        allEmployee=new JButton("ALL EMPLOYEE");
        allEmployee.setBackground(Color.BLACK);
        allEmployee.setForeground(Color.WHITE);
        allEmployee.setBounds(10,150,200,30);
        allEmployee.addActionListener(this);
        add(allEmployee);

        customers=new JButton("CUSTOMER INFO");
        customers.setBackground(Color.BLACK);
        customers.setForeground(Color.WHITE);
        customers.setBounds(10,190,200,30);
        customers.addActionListener(this);
        add(customers);

        managerinfo=new JButton("MANAGER INFO");
        managerinfo.setBackground(Color.BLACK);
        managerinfo.setForeground(Color.WHITE);
        managerinfo.setBounds(10,230,200,30);
        managerinfo.addActionListener(this);
        add(managerinfo);

        update=new JButton("UPDATE STATUS");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(10,270,200,30);
        update.addActionListener(this);
        add(update);


        //JButton updateroom=new JButton("UPDATE ROOM STATUS");
        //updateroom.setBackground(Color.BLACK);
        //updateroom.setForeground(Color.WHITE);
        //updateroom.setBounds(10,310,200,30);
        //updateroom.addActionListener(this);
        //add(updateroom);

        JButton pickup=new JButton("PICK UP SERVICE");
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.WHITE);
        pickup.setBounds(10,310,200,30);
        pickup.addActionListener(this);
        add(pickup);

         searchroom=new JButton("SEARCH ROOM");
        searchroom.setBackground(Color.BLACK);
        searchroom.setForeground(Color.WHITE);
        searchroom.setBounds(10,350,200,30);
        searchroom.addActionListener(this);
        add(searchroom);

        JButton login=new JButton("LOGOUT");
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setBounds(10,390,200,30);
        login.addActionListener(this);
        add(login);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(250,30,500,470);
        add(image);

        setBounds(350,200,800,570);
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==newcustomer)
        {
            setVisible(false);
            new addcustomer();
        }
        else if(ae.getSource()==rooms)
        {
            setVisible(false);
            new room();
        }
        else if(ae.getSource()==department)
        {
            setVisible(false);
            new department();
        }
        else if(ae.getSource()==allEmployee)
        {
            setVisible(false);
            new employeeinfo();
        }
        else if(ae.getSource()== managerinfo)
        {
            setVisible(false);
            new managerinfo();
        }
        else if(ae.getSource()==customers)
        {
            setVisible(false);
            new customerinfo();
        }
        else if(ae.getSource()==searchroom)
        {
            setVisible(false);
            new searchroom();
        }
        else if(ae.getSource()==update)
        {
            setVisible(false);
            new updatecheck();
        }
    }

    public static void main(String args[])
    {

        new reception();
    }


}

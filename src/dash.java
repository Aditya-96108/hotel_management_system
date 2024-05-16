import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dash extends JFrame  implements ActionListener {

    dash() {
            setLayout(null);
            setBounds(0,0,1550,1000);

            ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/WEB.jpg"));
            Image i2=i1.getImage().getScaledInstance(1550,1000,Image.SCALE_DEFAULT);
            ImageIcon i3=new ImageIcon(i2);
            JLabel image=new JLabel(i3);
            image.setBounds(0,0,1550,1000);
            add(image);

            //JLabel text=new JLabel("TAJ GROUP WELCOMES YOU");
           // text.setBounds(425,80,1000,50);
           // text.setFont(new Font("AERIAL",Font.PLAIN ,46));
           // text.setForeground(Color.WHITE);
           // image.add(text);

            JMenuBar jb=new JMenuBar();
            jb.setBounds(0,0,1550,30);
            image.add(jb);

            JMenu hotel=new JMenu("RESERVATION");
            jb.add(hotel);

            JMenuItem reception=new JMenuItem("RECEPTION");
            reception.addActionListener(this);
            hotel.add(reception);

            JMenu admin=new JMenu("ADMIN");
            jb.add(admin);

            JMenuItem addemp=new JMenuItem("ADD EMPLOYEE");
            addemp.addActionListener(this);
            admin.add(addemp);
            JMenuItem rooms=new JMenuItem("ADD ROOMS");
            rooms.addActionListener(this);
            admin.add(rooms);
            JMenuItem drivers=new JMenuItem("ADD DRIVERS");
            drivers.addActionListener(this);
            admin.add(drivers);




            setVisible(true);
    }

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getActionCommand().equals("ADD EMPLOYEE"))
            {
                    new addemp();
            }

            else if(ae.getActionCommand().equals("ADD ROOMS"))
            {
                    new addrooms();
            }
            else if(ae.getActionCommand().equals("ADD DRIVERS"))
            {
                new adddriver();
            }
            else if(ae.getActionCommand().equals("RECEPTION"))
            {
                new reception();
            }
            try{

            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }


    public static void main(String args[]) {
            new dash();
    }


}
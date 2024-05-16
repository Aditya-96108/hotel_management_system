import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public  class hotelmanagementsystem extends JFrame implements ActionListener {
    hotelmanagementsystem()
    {
        setTitle("HOTEL MANAGEMENT SYSTEM");
        setSize(1366,565);
        setLocation(100,100);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image=new JLabel(i1);
        add(image);
        setVisible(true);

        JLabel text=new JLabel("RESERVATION SYSTEM");
        text.setBounds(20,430,1000,90);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif",Font.PLAIN,50));
        image.add(text);

        JButton but1=new JButton("NEXT");
        but1.setBounds(1150,450,150,50);
        but1.addActionListener(this);
        but1.setBackground(Color.WHITE);
        but1.setForeground(Color.MAGENTA);
        but1.setFont(new Font("serif",Font.PLAIN,24));
        image.add(but1);

        while(true) {
            text.setVisible(false);
            try {
                Thread.sleep(700);
            } catch (Exception e) {
                e.printStackTrace();
            }
            text.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new login();

    }
    public static void main(String args[])
    {

        new hotelmanagementsystem();
    }
}

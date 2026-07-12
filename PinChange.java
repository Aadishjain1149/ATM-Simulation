
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Arrays;

public class PinChange extends JFrame implements ActionListener{
    
    JPasswordField pin , repin;
    JButton change, back;
    String pinnumber;
    
    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
               
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/frame3.png"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,820);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.black);
        text.setFont(new Font("Raleway" , Font.BOLD , 19));
        text.setBounds(250,270,500,35);
        image.add(text);
        
        JLabel pintext = new JLabel("NEW PIN:");
        pintext.setForeground(Color.black);
        pintext.setFont(new Font("Raleway" , Font.BOLD , 16));
        pintext.setBounds(165,320,100,25);
        image.add(pintext);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway" , Font.BOLD , 25));
        pin.setBounds(300,320,180,25);
        image.add(pin);
        
        
        JLabel repintext = new JLabel("Re-Enter PIN:");
        repintext.setForeground(Color.black);
        repintext.setFont(new Font("Raleway" , Font.BOLD , 16));
        repintext.setBounds(165,360,180,25);
        image.add(repintext);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway" , Font.BOLD , 25));
        repin.setBounds(300,360,180,25);
        image.add(repin);
        
        change = new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                char[] npinArray = pin.getPassword();
                char[] rpinArray = repin.getPassword();
                
                if (npinArray.length == 0) {
                    JOptionPane.showMessageDialog(null, "Please enter New PIN");
                    return;
                }

                if (rpinArray.length == 0) {
                    JOptionPane.showMessageDialog(null, "Please re-enter New PIN");
                    return;
                }

                String npin = new String(npinArray);
                String rpin = new String(rpinArray);
                
                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }

                if (!npin.matches("\\d{4,6}")) {
                    JOptionPane.showMessageDialog(null, "PIN must be a 4 to 6-digit number");
                    return;
                }

                Conn conn = new Conn();
                String query1 = "UPDATE bank SET pin = ? WHERE pin = ?";
                String query2 = "UPDATE login SET pin = ? WHERE pin = ?";
                String query3 = "UPDATE signupthree SET pin = ? WHERE pin = ?";

                try (PreparedStatement stmt1 = conn.c.prepareStatement(query1);
                    PreparedStatement stmt2 = conn.c.prepareStatement(query2);
                    PreparedStatement stmt3 = conn.c.prepareStatement(query3)) {

                    stmt1.setString(1, rpin);
                    stmt1.setString(2, pinnumber);
                    stmt1.executeUpdate();

                    stmt2.setString(1, rpin);
                    stmt2.setString(2, pinnumber);
                    stmt2.executeUpdate();

                    stmt3.setString(1, rpin);
                    stmt3.setString(2, pinnumber);
                    stmt3.executeUpdate();
                }

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                
                Arrays.fill(npinArray, '0');
                Arrays.fill(rpinArray, '0');

                setVisible(false);
                new Transactions(rpin).setVisible(true);

            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        } else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new PinChange("").setVisible(true);
    }
}

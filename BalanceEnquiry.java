
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;
import java.text.NumberFormat; 
import java.util.Locale; 

public class BalanceEnquiry extends JFrame implements ActionListener{
    
    JButton back;
    String pinnumber;
    
    BalanceEnquiry(String pinnumber){
        
        this.pinnumber = pinnumber;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/frame3.png"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,820);
        add(image);
        
        back = new JButton("Back");
        back.setBounds(355,555,160,30);
        back.addActionListener(this);
        image.add(back);
        
        Conn c = new Conn();
        int balance = 0;
        try{
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }
                else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        
        try {
    
            NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
            
            JLabel text = new JLabel("Current Balance: " + format.format(balance));
            text.setFont(new Font("Raleway", Font.BOLD, 24));
            text.setForeground(Color.black);
            text.setBounds(190, 340, 400, 30);
            image.add(text);
    
        } catch (Exception e) {
            JLabel text = new JLabel("Current Balance: Rs " + balance);
            text.setForeground(Color.black);
            text.setBounds(190, 340, 400, 30);
            image.add(text);
        }

        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
    
    public static void main(String args[]){
        new BalanceEnquiry("");
    }
    
}

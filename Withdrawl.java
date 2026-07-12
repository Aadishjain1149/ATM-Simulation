
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.SQLException;

public class Withdrawl extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton withdraw , back;
    String pinnumber;
    
    Withdrawl(String pinnumber){
        
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/frame2.png"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,820);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to Withdraw");
        text.setForeground(Color.black);
        text.setFont(new Font("Raleway" , Font.BOLD , 16));
        text.setBounds(190,300,400,20);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway" , Font.BOLD , 22));
        amount.setBounds(180,350,320,25);
        image.add(amount);
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355,485,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == withdraw){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to Withdraw");
                
            }
            try {
                double amt = Double.parseDouble(number);
                if (amt <= 0) {
                    JOptionPane.showMessageDialog(null, "Please enter a positive amount");
                    return;
                }
                if (number.contains(".")) {
                    JOptionPane.showMessageDialog(null, "Please enter whole rupees only");
                    return;
                }
                try {
                    Conn conn = new Conn();
                    String query = "Insert into bank values ('"+pinnumber+"' , '"+date+"' , 'Withdrawal' , '"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. " + number + " Withdrawn Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                catch(Exception e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(null, "Transaction failed. Please try again.");
                }
            }
            catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid numeric amount");
            }
        }
        else if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Withdrawl("");
    }
}

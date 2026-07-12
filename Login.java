
package bank.management.system;

import javax.swing.*;
import java .awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton login , signup , clear;
    JTextField cardTextField ;
    JPasswordField pinTextField;
    ImageIcon backgroundImage;
    
     
    Login(){
        setTitle("Automated Teller Machine");
        
        setLayout(null);
        setUndecorated(true);
        
        backgroundImage = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image img = backgroundImage.getImage();
        Image scaledImg = img.getScaledInstance(800, 500, Image.SCALE_DEFAULT);
        backgroundImage = new ImageIcon(scaledImg);
        JLabel background = new JLabel(backgroundImage);
        background.setBounds(0, 0, 800, 500);
        setContentPane(background);

       
        
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Onward" , Font.BOLD , 38));
        text.setBounds(250,75,400,40);
        add(text);
        
        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway" , Font.BOLD , 26));
        cardno.setBounds(140,150,150,30);
        add(cardno);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial" , Font.BOLD , 14));
        add(cardTextField);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway" , Font.BOLD , 26));
        pin.setBounds(140,220,250,30);
        add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Arial" , Font.BOLD , 14));
        add(pinTextField);
        
        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(new Color(106, 13, 173));
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(new Color(106, 13, 173));
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup= new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(new Color(106, 13, 173));
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,500);
        setVisible(true);
        
        setLocation(350,200);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource() == login){
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query ="select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    
    
    public static void main(String args[]){
        new Login();
    }
}

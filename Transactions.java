package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {
    
    JButton deposit, withdrawl, fastcash, ministatement, pinchange, balanceenquiry, exit;
    String pinnumber;
    JLabel image;
    ImageIcon originalIcon;
    
    Transactions(String pinnumber) {
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        // Load and set original image
        originalIcon = new ImageIcon(ClassLoader.getSystemResource("icons/frame3.png"));
        Image originalImg = originalIcon.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        originalIcon = new ImageIcon(originalImg);
        
        image = new JLabel(originalIcon);
        image.setBounds(0, 0, 900, 820);
        add(image);
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.black);
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(text);
                
        deposit = new JButton("Deposit");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Withdrawal");
        withdrawl.setBounds(355, 415, 150, 30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170, 450, 150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(355, 450, 150, 30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange = new JButton("Pin Change");
        pinchange.setBounds(170, 485, 150, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(355, 485, 150, 30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        exit = new JButton("Exit");
        exit.setBounds(355, 520, 150, 30);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            System.exit(0);
        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (ae.getSource() == withdrawl) {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        } else if (ae.getSource() == fastcash) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if (ae.getSource() == pinchange) {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        } else if (ae.getSource() == balanceenquiry) {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        } else if (ae.getSource() == ministatement) {
            ImageIcon stmtIcon = new ImageIcon(ClassLoader.getSystemResource("icons/frame1.png"));
            Image stmtImg = stmtIcon.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
            image.setIcon(new ImageIcon(stmtImg));
            MiniStatement ms = new MiniStatement(pinnumber);
            ms.setVisible(true);
            ms.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    image.setIcon(originalIcon);
                }
            });
        }
    }
    
    public static void main(String args[]) {
        new Transactions("");
    }
}
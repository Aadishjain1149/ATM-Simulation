package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame {

    MiniStatement(String pinnumber) {
        setTitle("Mini Statement");
        setLayout(null);
        
        JLabel bank = new JLabel("Indian Bank");
        bank.setFont(new Font("Arial", Font.BOLD, 16));
        bank.setBounds(180, 20, 200, 20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 400, 20);
        add(card);

        
        JTextArea mini = new JTextArea();
        mini.setEditable(false);
        mini.setFont(new Font("Courier New", Font.PLAIN, 12)); 
        JScrollPane scrollPane = new JScrollPane(mini);
        scrollPane.setBounds(20, 140, 450, 300);
        add(scrollPane);

        JLabel balance = new JLabel();
        balance.setBounds(20, 450, 400, 20);
        add(balance);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        int bal = 0;
        try {
            Conn conn = new Conn();
            String query1 = "SELECT cardnumber FROM login WHERE pin = ?";
            try (PreparedStatement stmt1 = conn.c.prepareStatement(query1)) {
                stmt1.setString(1, pinnumber);
                ResultSet rs1 = stmt1.executeQuery();

                if (rs1.next()) {
                    String cardNumber = rs1.getString("cardnumber");
                    if (cardNumber != null && cardNumber.length() >= 8) {
                        String maskedNumber = cardNumber.substring(0, 4) + "XXXXXXXX" +cardNumber.substring(cardNumber.length()-4);
                        card.setText("Card Number: " + maskedNumber);
                    }    
                    else {
                        card.setText("Card Number: [Invalid]");
                    }
                } 
                else {
                    card.setText("Card Number: [Not Found]");
                }
            }
            String query2 = "SELECT * FROM bank WHERE pin = ?";
            try (PreparedStatement stmt2 = conn.c.prepareStatement(query2)) {
                stmt2.setString(1, pinnumber);
                ResultSet rs2 = stmt2.executeQuery();

                StringBuilder statement = new StringBuilder();
                statement.append(String.format("%-30s %-15s %-10s\n", "Date & Time", "Type", "Amount"));
                statement.append("--------------------------------------------------------------\n");

                while (rs2.next()) {
                    String date = rs2.getString("date");
                    String type = rs2.getString("type");

                   
                    if (type.equalsIgnoreCase("withdrawl")) {
                        type = "Withdrawal";
                    }

                    String amount = rs2.getString("amount");

                    statement.append(String.format("%-30s %-15s %-10s\n", date, type, amount));

                    
                    if (type.equalsIgnoreCase("Deposit")) {
                        bal += Integer.parseInt(amount);
                    } else {
                        bal -= Integer.parseInt(amount);
                    }
                }

                mini.setText(statement.toString());
                balance.setText("Current Account Balance : Rs " + bal);
                balance.setFont(new Font("Raleway" , Font.BOLD , 22));
            }

            conn.c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        setSize(500, 600);
        setLocation(100, 100);
        getContentPane().setBackground(Color.white);
        
        setVisible(true);
    }
    
    public static void main(String args[]) {
        new MiniStatement(""); 
    }
}

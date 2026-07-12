package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField pan, aadhar;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, occupation, education, income;
    String formno;
    
    private void addRequiredMarker(JComponent component, int width, int height) {
        JLabel asterisk = new JLabel("*");
        asterisk.setForeground(Color.RED);
        asterisk.setFont(new Font("Raleway", Font.BOLD, 14));
        asterisk.setBounds(component.getX() + width + 5,component.getY(),20,height);
        add(asterisk);
}

    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);
        setTitle("New ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.white);
        add(religion);

        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        String valCategory[] = {"General", "OBC", "SC", "ST", "Others"};
        category = new JComboBox(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.white);
        add(category);

        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        String incomeCategory[] = {"NULL", "Less than 1,50,000", "1,50,000 - 2,50,000", "2,50,000 - 5,00,000", "5,00,000 - 10,00,000" , "More than 10,00,000"};
        income = new JComboBox(incomeCategory);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.white);
        add(income);

        JLabel gender = new JLabel("Educational:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 315, 200, 30);
        add(email);

        String educationValues[] = {"Non-Graduation", "Post-Graduation" , "Graduate", "Post-Graduation", "Doctorate", "Others"};
        education = new JComboBox(educationValues);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.white);
        add(education);

        JLabel marital = new JLabel("Occupation:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);

        String occupationValues[] = {"Salaried", "Self Employed", "Business", "Student", "Retired", "Others"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.white);
        add(occupation);

        JLabel panLabel = new JLabel("PAN NUMBER:");
        panLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        panLabel.setBounds(100, 440, 200, 30);
        add(panLabel);

        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);
        addRequiredMarker(pan, 400, 30);
        

        JLabel aadharLabel = new JLabel("Aadhar Number:");
        aadharLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        aadharLabel.setBounds(100, 490, 200, 30);
        add(aadharLabel);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300, 490, 400, 30);
        add(aadhar);
        addRequiredMarker(aadhar, 400, 30);

        JLabel seniorCitizenLabel = new JLabel("Senior Citizen:");
        seniorCitizenLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorCitizenLabel.setBounds(100, 540, 200, 30);
        add(seniorCitizenLabel);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.white);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.white);
        add(sno);

        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(syes);
        seniorGroup.add(sno);
        
        JPanel seniorPanel = new JPanel();
        seniorPanel.setBounds(300, 540, 250, 30);
        seniorPanel.setOpaque(false);
        seniorPanel.add(syes);
        seniorPanel.add(sno);
        add(seniorPanel);
        addRequiredMarker(seniorPanel , 250 , 30);

        JLabel existingAccountLabel = new JLabel("Existing Account:");
        existingAccountLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        existingAccountLabel.setBounds(100, 590, 200, 30);
        add(existingAccountLabel);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.white);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.white);
        add(eno);

        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(eyes);
        accountGroup.add(eno);
        
        JPanel existingPanel = new JPanel();
        existingPanel.setBounds(300, 590, 250, 30);
        existingPanel.setOpaque(false);
        existingPanel.add(eyes);
        existingPanel.add(eno);
        add(existingPanel);
        addRequiredMarker(existingPanel, 250, 30);

        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);
        
        JLabel requiredNote = new JLabel("* indicates required field");
        requiredNote.setForeground(Color.RED);
        requiredNote.setFont(new Font("Raleway", Font.ITALIC, 16));
        requiredNote.setBounds(300, 730, 200, 20);
        add(requiredNote);

        getContentPane().setBackground(Color.white);
        setSize(850, 800);
        setLocation(350, 10);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorCitizen = syes.isSelected() ? "Yes" : "No";
        String existingAccount = eyes.isSelected() ? "Yes" : "No";

        String span = pan.getText();
        String saadhar = aadhar.getText();
        
        
        if (!pan.getText().matches("[A-Z]{5}[0-9]{4}[A-Z]{1}")) {
            JOptionPane.showMessageDialog(this, "Invalid PAN format (e.g., ABCDE1234F)", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!aadhar.getText().matches("\\d{12}")) {
            JOptionPane.showMessageDialog(this, "Aadhar must be 12 digits", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!syes.isSelected() && !sno.isSelected()) {
            JOptionPane.showMessageDialog(this, "Please select Senior Citizen status", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!eyes.isSelected() && !eno.isSelected()) {
            JOptionPane.showMessageDialog(this, "Please select Existing Account status", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Conn c = new Conn();
            String query = "INSERT INTO signuptwo VALUES('" + formno + "', '" + sreligion + "', '" + scategory + "', '" + sincome + "', " +
                    "'" + seducation + "', '" + soccupation + "', '" + span + "', '" + saadhar + "', '" + seniorCitizen + "', '" + existingAccount + "')";
            c.s.executeUpdate(query);
            
            setVisible(false);
            new SignupThree(formno).setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        //new SignupTwo("");
        new Login().setVisible(true);
    }
}

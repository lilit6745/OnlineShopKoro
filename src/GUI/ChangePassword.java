package GUI;

import DB.ConnectDB;
import DB.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

public class ChangePassword extends JFrame implements ActionListener {
    private Statement statement = null;
    JPasswordField password = new RoundJPasswordField(2);
    JPasswordField confirmPassword = new RoundJPasswordField(2);
    JLabel labelPassword = new JLabel("New Password");
    JLabel labelConfirmPassword = new JLabel("Confirm New Password");
    Font font1 = new Font("New Time",Font.PLAIN,16);
    Font font = new Font("New Time",Font.BOLD,20);
    JLabel label = new JLabel("Change Password");
    JButton confirm = new JButton("Confirm");
    String chValue;
    public ChangePassword(String value){
        setLayout(null);
        chValue = value;

        label.setForeground(Color.BLACK);
        label.setFont(font);
        label.setBounds(150,20,180,30);
        label.setForeground(Color.BLACK);
        add(label);

        labelPassword.setForeground(Color.BLACK);
        labelPassword.setFont(font1);
        labelPassword.setBounds(150,60,150,30);
        add(labelPassword);


        password.setBounds(150,100,200,30);
        password.setSize(200,30);
        password.setForeground(Color.BLACK);
        add(password);


        labelConfirmPassword.setForeground(Color.BLACK);
        labelConfirmPassword.setFont(font1);
        labelConfirmPassword.setBounds(150,160,200,30);
        add(labelConfirmPassword);


        confirmPassword.setBounds(150,190,200,30);
        confirmPassword.setSize(200,30);
        confirmPassword.setForeground(Color.BLACK);
        add(confirmPassword);


        confirm.setBounds(200,250,100,30);
        confirm.setSize(100,30);
        confirm.setBackground(Color.WHITE);
        confirm.setForeground(new Color(238, 104, 69));
        confirm.setBorderPainted(false);
        add(confirm);
        confirm.addActionListener(this);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,380);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        final var source = e.getSource();
        if (source == confirm) {
            if(Arrays.equals(password.getPassword(), confirmPassword.getPassword())){
                try{
                    statement = ConnectDB.connect().createStatement();
                    System.out.println(chValue);
                    String row = "UPDATE users SET password = " + "'" + password + "'" + "WHERE email = " + "'" +chValue + "'" + ';';
//                    resultSet = statement.executeQuery("UPDATE users SET password = " + "'" + password + "'" + "WHERE email = " + "'" +chValue + "'" + ';');
                    statement.executeUpdate(row);
                    setVisible(false);
                    new LogIn().setVisible(true);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else{
                JOptionPane.showMessageDialog(null, "Please Confirm your Password!");
            }
        }
    }
}

package GUI;

import DAO.UserDAO;
import DB.User;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;



public class Registration extends JFrame implements ActionListener {
    private Statement statement = null;
    private ResultSet resultSet = null;


    UserDAO userDao = new UserDAO();
    DropShadowPanel shadow = new DropShadowPanel(5);

    JPanel regPart = new JPanel();
    JPanel line = new JPanel();
    JLabel registration = new JLabel("Registration");
    Font fontReg = new Font("Serif", Font.BOLD, 36);
    Font font1 = new Font("New Time",Font.PLAIN,16);


    JLabel labelFirstName = new JLabel("First Name");
    JLabel labelLastName = new JLabel("Last Name");
    JLabel labelDateOfBirth = new JLabel("Birthdate");
    JLabel labelEmail = new JLabel("Email");
    JLabel labelPassword = new JLabel("Password");
    JLabel labelConfirmPassword = new JLabel("Confirm Password");

    JTextField firstName = new RoundJTextField(2);
    JTextField lastName = new RoundJTextField(2);
    JTextField email = new RoundJTextField(2);
    JPasswordField password = new RoundJPasswordField(2);
    JPasswordField confirmPassword = new RoundJPasswordField(2);




    JComboBox<String> year;
    JComboBox<String> month;
    JComboBox<String> day;

    JButton submit = new JButton("submit");
    JButton home = new JButton("Home");


    public Registration() throws HeadlessException {
        setLayout(null);
        setBackground(Color.white);
        shadow.setLayout(null);
        regPart.setLayout(null);
        shadow.setSize(800, 600);
        shadow.setBounds(280, 50, 805, 605);
        add(shadow);
        regPart.setBounds(5, 5, 795, 595);
        shadow.add(regPart);
        regPart.setSize(795, 595);
        regPart.setBackground(Color.white);


        registration.setBounds(300, 30, 200, 50);
        registration.setFont(fontReg);
        regPart.add(registration);

        line.setBounds(160, 80, 200, 5);
        line.setSize(480, 3);
        line.setBackground(new Color(238, 104, 69));
        regPart.add(line);


        //Full Name
        labelFirstName.setForeground(Color.BLACK);
        labelFirstName.setFont(font1);
        labelFirstName.setBounds(160,110,100,30);
        regPart.add(labelFirstName);


        firstName.setBounds(160,150,200,30);
        firstName.setSize(200,30);
        firstName.setForeground(Color.BLACK);
        regPart.add(firstName);


        labelLastName.setForeground(Color.BLACK);
        labelLastName.setFont(font1);
        labelLastName.setBounds(440,110,100,30);
        regPart.add(labelLastName);


        lastName.setBounds(440,150,200,30);
        lastName.setSize(200,30);
        lastName.setForeground(Color.BLACK);
        regPart.add(lastName);


        //Date Of Birth
        ArrayList<String> years_tmp = new ArrayList<String>();
        years_tmp.add("Year");
        for(int years = 1960; years<= Calendar.getInstance().get(Calendar.YEAR); years++) {
            years_tmp.add(years+"");
        }
        year = new JComboBox(years_tmp.toArray());

        String[] months = {"Month","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        month = new JComboBox<>(months);

        String[] days = {"Day","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        day = new JComboBox<>(days);

        labelDateOfBirth.setForeground(Color.BLACK);
        labelDateOfBirth.setFont(font1);
        labelDateOfBirth.setBounds(160,200,100,30);
        regPart.add(labelDateOfBirth);


        year.setBounds(160,240,133,30);
        year.setSize(133,30);
        year.setForeground(Color.BLACK);
        year.setBackground(Color.WHITE);
        year.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        year.setEditable(false);
        regPart.add(year);

        month.setBounds(333,240,133,30);
        month.setSize(133,30);
        month.setForeground(Color.BLACK);
        month.setBackground(Color.WHITE);
        month.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        regPart.add(month);

        day.setBounds(506,240,133,30);
        day.setSize(133,30);
        day.setForeground(Color.BLACK);
        day.setBackground(Color.WHITE);
        day.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        regPart.add(day);


        //Email and Password
        labelEmail.setForeground(Color.BLACK);
        labelEmail.setFont(font1);
        labelEmail.setBounds(160,290,100,30);
        regPart.add(labelEmail);


        email.setBounds(160,330,300,30);
        email.setSize(300,30);
        email.setForeground(Color.BLACK);
        regPart.add(email);



        labelPassword.setForeground(Color.BLACK);
        labelPassword.setFont(font1);
        labelPassword.setBounds(160,380,100,30);
        regPart.add(labelPassword);


        password.setBounds(160,420,200,30);
        password.setSize(200,30);
        password.setForeground(Color.BLACK);
        regPart.add(password);


        labelConfirmPassword.setForeground(Color.BLACK);
        labelConfirmPassword.setFont(font1);
        labelConfirmPassword.setBounds(440,380,150,30);
        regPart.add(labelConfirmPassword);


        confirmPassword.setBounds(440,420,200,30);
        confirmPassword.setSize(200,30);
        confirmPassword.setForeground(Color.BLACK);
        regPart.add(confirmPassword);


        submit.setBounds(540,500,100,30);
        submit.setSize(100,30);
        submit.setBackground(new Color(238, 104, 69));
        submit.setForeground(Color.white);
        submit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        regPart.add(submit);
        submit.addActionListener(this);

        home.setBounds(160,500,100,30);
        home.setSize(100,30);
        home.setBackground(new Color(238, 104, 69));
        home.setForeground(Color.white);
        home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        regPart.add(home);
        home.addActionListener(this);



        setSize(1360, 770);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final var source = e.getSource();
        if (source == submit) {
            if(firstName.equals("") || lastName.equals("") || year.equals("Year") || month.equals("Month") || day.equals("Day") || email.equals("") || password.equals("") || confirmPassword.equals("")){
                if(Arrays.equals(password.getPassword(), confirmPassword.getPassword())){
                    try{
                        User user = new User();
                        user.setUserFirstName(firstName.getText());
                        user.setUserLastName(lastName.getText());
                        user.setImplUserBirthDate(year.getSelectedItem()+"-"+month.getSelectedItem()+"-"+day.getSelectedItem());
                        user.setUserEmail(email.getText());
                        user.setUserPassword(String.valueOf(password.getPassword()));
                        userDao.insertUserRow(user);
                        setVisible(false);
                        new LogIn().setVisible(true);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else{
                    JOptionPane.showMessageDialog(null, "Please Confirm your Password!");
                }
            } else{
                JOptionPane.showMessageDialog(null, "Please Confirm your Password!");
            }
        } else if (source == home){
            try {
                new MainPage().setVisible(true);
                setVisible(false);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

//    @Override
//    public void focusGained(FocusEvent e) {
//        ((JTextComponent) e.getSource()).setBackground(Color.WHITE);
//    }
//
//    public void validationForPassword(JTextComponent comp)
//    {
//        String temp=comp.getText();
//        if (temp.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{8,30}$")) {
//            comp.setBackground(Color.GREEN);
//        }
//        else
//            comp.setBackground(Color.RED);
//    }
//
//    public void validationForEmail(JTextComponent comp)
//    {
//        String text=comp.getText();
//        if(text.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,5}$"))
//            comp.setBackground(Color.GREEN);
//        else
//            comp.setBackground(Color.RED);
//    }
//    @Override
//    public void focusLost(FocusEvent e) {
//        if(e.getSource().equals(email))
//        {
//            validationForEmail(email);
//        }
//        else if(e.getSource().equals(password))
//        {
//            validationForPassword(password);
//        }
//    }
}
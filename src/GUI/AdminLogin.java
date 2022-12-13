package GUI;

import DB.ConnectDB;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AdminLogin extends JFrame implements ActionListener {
    private Statement statement = null;
    private ResultSet resultSet = null;
    private ResultSet rs = null;
    BufferedImage resizeImage(BufferedImage originalImage) {
        BufferedImage resizedImage = new BufferedImage(350, 288, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(originalImage, 0, 0, 350, 288, null);
        graphics2D.dispose();
        return resizedImage;
    }
    DropShadowPanel shadow = new DropShadowPanel(5);

    JPanel loginPart = new JPanel();
    JPanel line = new JPanel();
    JLabel logIn = new JLabel("Log In");
    Font logInFont = new Font("Serif", Font.BOLD, 36);
    BufferedImage myComp;

    {
        try {
            myComp = ImageIO.read(new File("C:/Users/Ani/IdeaProjects/OnlineShopKoro/image/computer.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    BufferedImage resizeImage = resizeImage(myComp);
    JLabel compLabel = new JLabel(new ImageIcon(resizeImage));
    JLabel eMail = new JLabel("Email");
    Font fontEmail = new Font("Serif", Font.BOLD, 14);
    JTextField userName = new RoundJTextField(10);
    JLabel passWord = new JLabel("Password");
    Font fontPassword = new Font("Serif", Font.BOLD, 14);
    JPasswordField password = new RoundJPasswordField(10);
    JButton button = new JButton("Sign In");


//    JLabel errorSMS = new JLabel("Username or Password is incorrect!");
//    Font fontErrorSMS = new Font("Italic", Font.PLAIN, 12);

    public AdminLogin() throws HeadlessException {
        setLayout(null);
        setBackground(Color.white);
        shadow.setLayout(null);
        loginPart.setLayout(null);
        shadow.setSize(800, 500);
        shadow.setBounds(280, 100, 805, 505);
        add(shadow);
        loginPart.setBounds(5, 5, 795, 495);
        shadow.add(loginPart);
        loginPart.setSize(795, 495);
        loginPart.setBackground(Color.white);


        //IBM Plex Sans

        logIn.setBounds(450, 60, 200, 50);
        logIn.setFont(logInFont);
        loginPart.add(logIn);

        line.setBounds(450, 120, 200, 5);
        line.setSize(200, 5);
        line.setBackground(new Color(238, 104, 69));
        loginPart.add(line);

        eMail.setBounds(450, 150, 100, 20);
        eMail.setFont(fontEmail);
        loginPart.add(eMail);

        //username
        userName.setSize(200, 30);
        userName.setBounds(450, 180, 200, 30);
        loginPart.add(userName);
        userName.setForeground(Color.BLACK);
        userName.setForeground(Color.decode("#8F8F8F"));

        passWord.setBounds(450, 220, 100, 20);
        passWord.setFont(fontPassword);
        loginPart.add(passWord);

        //password
        password.setSize(200, 30);
        password.setBounds(450, 250, 200, 30);
        loginPart.add(password);
        password.setForeground(Color.decode("#8F8F8F"));


        button.setBackground(new Color(238, 104, 69));
        button.setForeground(Color.white);
        button.setBorderPainted(false);
        button.setBounds(450, 310, 200, 30);
        button.setSize(200, 30);
        loginPart.add(button);
        button.addActionListener(this);



        compLabel.setBounds(10, 110, 350, 288);
        loginPart.add(compLabel);


        setSize(1360, 770);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button clicked!");
        String name = userName.getText();
        String pass = String.valueOf(password.getPassword());

        int success=0;
        final var source = e.getSource();
        if (source == button) {
            String userNameDB = "";
            String passwordDB = "";
            try
            {
                statement = ConnectDB.connect().createStatement();
                resultSet = statement.executeQuery("select email, password from users"); //the table name is users and userName,password are columns. Fetching all the records and storing in a resultSet.
                while(resultSet.next()) // Until next row is present otherwise it return false
                {
                    userNameDB = resultSet.getString("email"); //fetch the values present in database
                    passwordDB = resultSet.getString("password");

                    if (name.equals(userNameDB) && pass.equals(passwordDB)) {
                        System.out.println("Success!");
                        success+=1;
                        setVisible(false);
                        new ManagerPage().setVisible(true);
                    }
                }
                if( success==0){
                    JOptionPane.showMessageDialog(null, "You have unfilled required fields");
                }

            } catch (SQLException | IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}

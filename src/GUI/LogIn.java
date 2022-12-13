package GUI;

import DB.ConnectDB;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
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


public class LogIn extends JFrame implements ActionListener, MouseListener {
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
    Font fontForgetPassword = new Font("Italic", Font.PLAIN, 10);
    JLabel forgetPassword = new JLabel("Forget Password");
    Font fontQuestion = new Font("Italic", Font.PLAIN, 12);
    JLabel question = new JLabel("Don't have an account?");
    JLabel signUp = new JLabel("Sign Up");

//    JLabel errorSMS = new JLabel("Username or Password is incorrect!");
//    Font fontErrorSMS = new Font("Italic", Font.PLAIN, 12);

    public LogIn() throws HeadlessException {
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

        forgetPassword.setBounds(570, 280, 200, 30);
        forgetPassword.setFont(fontForgetPassword);
        forgetPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginPart.add(forgetPassword);
        forgetPassword.setForeground(new Color(238, 104, 69));
        forgetPassword.addMouseListener(this);

        button.setBackground(new Color(238, 104, 69));
        button.setForeground(Color.white);
        button.setBorderPainted(false);
        button.setBounds(450, 310, 200, 30);
        button.setSize(200, 30);
        loginPart.add(button);
        button.addActionListener(this);

        question.setBounds(460, 340, 150, 30);
        question.setFont(fontQuestion);
        question.setForeground(Color.decode("#8F8F8F"));
        loginPart.add(question);

        signUp.setBounds(590, 340, 50, 30);
        signUp.setFont(fontQuestion);
        signUp.setForeground(new Color(238, 104, 69));
        loginPart.add(signUp);


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
                    resultSet = statement.executeQuery("select email, password from users");
                    while(resultSet.next())
                    {
                        userNameDB = resultSet.getString("email");
                        passwordDB = resultSet.getString("password");

                        if (name.equals(userNameDB) && pass.equals(passwordDB)) {
                            System.out.println("Success!");
                            success+=1;
                            setVisible(false);
                            new ShopMainPage().setVisible(true);
                        }
                    }
                    if( success==0){
                        JOptionPane.showMessageDialog(null, "You have unfilled required fields");
                    }

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        String userNameDB = "";
        int success = 0;
        try
        {
            String value = JOptionPane.showInputDialog("Enter your Email: ");
            statement = ConnectDB.connect().createStatement();
            resultSet = statement.executeQuery("select email from users");

            while(resultSet.next())
            {
                userNameDB = resultSet.getString("email");

                if (value.equals(userNameDB)) {
                    System.out.println("Success!");
                    success++;
                    JOptionPane.getFrameForComponent(new ChangePassword(value));
                }
            }
            if( success==0){
                JOptionPane.showMessageDialog(null, "Email is incorrect!");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
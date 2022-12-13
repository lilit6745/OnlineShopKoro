package GUI;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainPage extends JFrame implements ActionListener {
    BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight){
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        graphics2D.dispose();
        return resizedImage;
    }

    CustomPanel background = new CustomPanel();

    JPanel header =  new JPanel();

    BufferedImage myLogo = ImageIO.read(new File("C:/Users/Ani/IdeaProjects/OnlineShopKoro/image/KoroLogo.jpg"));
    BufferedImage resizeImage = resizeImage(myLogo,56,60);
    JLabel logoLabel = new JLabel(new ImageIcon(resizeImage));

    BufferedImage pic = ImageIO.read(new File("C:/Users/Ani/IdeaProjects/OnlineShopKoro/image/backgroundPic.jpg"));
    BufferedImage resizePic = resizeImage(pic,660,573);
    JLabel picLabel = new JLabel(new ImageIcon(resizePic));

    JLabel koroShop = new JLabel("Koro Shop");

    JButton logIn = new JButton("Log In");
    JButton signIn = new JButton("Sign Up");

    JLabel slogan = new JLabel("A few clicks is all it takes");

    Font font = new Font("Serif", Font.BOLD, 46);
    Font font1 = new Font("Serif", Font.PLAIN, 25);
    JLabel welcome = new JLabel("Welcome To");

    JLabel welcome1 = new JLabel("Koro Shop");
    JPanel line = new JPanel();



    public MainPage() throws IOException {
        setTitle("MainPage");

        header.setLayout(null);
        header.setBackground(Color.white);
        add(header);
        header.setSize(1360,80);

        logoLabel.setBounds(10,10,56,60);
        header.add(logoLabel);

        koroShop.setFont(new Font("Arial Rounded MT Bold [Embedded]",Font.BOLD,30));
        koroShop.setForeground(new Color(64,64,65));
        koroShop.setBounds(70,10,200,95);
        header.add(koroShop);

        signIn.setBackground(new Color(238,104,69));
        signIn.setForeground(Color.white);
        signIn.setBorderPainted(false);
        signIn.setBounds(1240,20,90,40);
        signIn.setSize(90,40);
        header.add(signIn);
        signIn.addActionListener(this);

        logIn.setBackground(Color.white);
        logIn.setForeground(new Color(238,104,69));
        logIn.setBorderPainted(true);
        logIn.setBorder(BorderFactory.createLineBorder(new Color(238,104,69), 2));
        logIn.setBounds(1130,20,90,40);
        logIn.setSize(90,40);
        header.add(logIn);
        logIn.addActionListener(this);


        background.setLayout(null);
        add(background);
        background.setSize(1360,690);

        picLabel.setBounds(30,120,660,573);
        background.add(picLabel);

        welcome.setBounds(1000,200,300,40);
        welcome.setFont(font);
        background.add(welcome);

        welcome1.setBounds(1030,270,350,50);
        welcome1.setFont(font);
        background.add(welcome1);

        line.setBackground(new Color(238,104,69));
        line.setSize(3,30);
        line.setBounds(1235,350,3,30);
        background.add(line);

        slogan.setBounds(980,350,400,30);
        slogan.setFont(font1);
        background.add(slogan);

        setSize(1360,770);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final var source = e.getSource();
        if (source == logIn) {
            new Ask().setVisible(true);
        }else if(source == signIn){
            setVisible(false);
            new Registration().setVisible(true);

        }
    }
}
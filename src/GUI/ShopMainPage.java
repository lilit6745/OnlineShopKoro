package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ShopMainPage extends JFrame {
    BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight){
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        graphics2D.dispose();
        return resizedImage;
    }

    CustomPanel background = new CustomPanel();

    JPanel header =  new JPanel();

    BufferedImage backgroundImage;

    {
        try {
            backgroundImage = ImageIO.read(new File("C:/Users/Ani/IdeaProjects/OnlineShopKoro/image/backgroundofmainpage.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    BufferedImage resizeBackImage = resizeImage(backgroundImage,1360,690);
    JLabel backImageLabel = new JLabel(new ImageIcon(resizeBackImage));
//    ImageIcon back = new ImageIcon("C:/Users/Ani/IdeaProjects/OnlineShopKoro/image/backgroundofmainpage.jpg");
//    JLabel backImageLabel = new JLabel(back);

    BufferedImage myLogo;

    {
        try {
            myLogo = ImageIO.read(new File("C:/Users/Ani/IdeaProjects/OnlineShopKoro/image/KoroLogo.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    BufferedImage resizeImage = resizeImage(myLogo,56,60);
    JLabel logoLabel = new JLabel(new ImageIcon(resizeImage));

    JPanel panel = new JPanel();

    BufferedImage personHeader;

    {
        try {
            personHeader = ImageIO.read(new File("C:/Users/Ani/IdeaProjects/OnlineShopKoro/image/person.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    BufferedImage resizePersonHeader = resizeImage(personHeader,30,30);
    JLabel personHeaderLabel = new JLabel(new ImageIcon(resizePersonHeader));


    JLabel userName = new JLabel();
    Font fontHeaderUserName = new Font("Serif", Font.BOLD, 20);



    JLabel koroShop = new JLabel("Koro Shop");

    JTextField searchField = new RoundJTextField(2);
    JButton searchButton = new JButton("Search");


    public ShopMainPage(){
        setLayout(null);
        setBackground(Color.white);

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



        background.setLayout(null);
        add(background);
        background.setSize(1360,730);

        backImageLabel.setBounds(0,88,1360,690);
        background.add(backImageLabel);

        backImageLabel.setLayout(null);

        searchField.setSize(400,30);
        searchField.setBounds(50,50,400,30);
        searchField.setSize(200,30);
        searchField.setForeground(Color.BLACK);
        backImageLabel.add(searchField);

        searchButton.setBounds(300,50,100,30);
        searchButton.setSize(100,30);
        searchButton.setBackground(Color.white);
        searchButton.setBorder(BorderFactory.createLineBorder(new Color(238,104,69), 2));
        searchButton.setForeground(new Color(238, 104, 69));
        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backImageLabel.add(searchButton);
//        searchButton.addActionListener(this);

        userName.setBounds(1163, 23,100,30);
        userName.setFont(fontHeaderUserName);
        userName.setForeground(Color.DARK_GRAY);
        header.add(userName);

        personHeaderLabel.setBounds(1130,25,30,30);
        header.add(personHeaderLabel);

        panel.setBounds(0,88,1360,690);
        panel.setBackground(Color.BLUE);
        background.add(panel);


        setSize(1360, 770);
        setVisible(true);
    }
}

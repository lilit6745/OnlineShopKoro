package GUI;

import DAO.ProductDAO;
import DB.Product;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class ManagerPage extends JFrame implements ActionListener, MouseListener{


    BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        graphics2D.dispose();
        return resizedImage;
    }


    JFileChooser fileChooser = new JFileChooser();
    CustomPanel background = new CustomPanel();
    ProductDAO productDao = new ProductDAO();

    JPanel header =  new JPanel();

    BufferedImage myPicture = ImageIO.read(new File("C:/Users/Ani/IdeaProjects/OnlineShopKoro/image/KoroLogo.jpg"));
    BufferedImage resizeImage = resizeImage(myPicture,56,60);
    JLabel picLabel = new JLabel(new ImageIcon(resizeImage));

    BufferedImage person = ImageIO.read(new File("C:/Users/Ani/IdeaProjects/OnlineShopKoro/image/person.jpg"));
    BufferedImage resizePerson = resizeImage(person,50,50);
    JLabel personLabel = new JLabel(new ImageIcon(resizePerson));

    BufferedImage personHeader = ImageIO.read(new File("C:/Users/Ani/IdeaProjects/OnlineShopKoro/image/person.jpg"));
    BufferedImage resizePersonHeader = resizeImage(personHeader,30,30);
    JLabel personHeaderLabel = new JLabel(new ImageIcon(resizePersonHeader));

    Font fontHeaderUserName = new Font("Serif", Font.BOLD, 20);

    JLabel userName = new JLabel("Manager");

    JLabel userName1 = new JLabel("Manager");

    JLabel koroShop = new JLabel("Koro Shop");
    JLabel title = new JLabel("+ Add Product");

    JPanel managerCorner = new JPanel();
    JPanel line = new JPanel();
    Font fontTitle = new Font("Serif", Font.BOLD, 30);
    Font font = new Font("Serif", Font.BOLD, 20);
    Font font2 = new Font("Serif", Font.BOLD, 25);
    Font font1 = new Font("New Time",Font.PLAIN,16);
    JLabel addProduct = new JLabel("Add Product");
    JLabel viewProducts = new JLabel("View Products");
    JLabel viewCustomers = new JLabel("View Customers");
    JLabel productName = new JLabel("Product Name");
    JTextField productNameField = new RoundJTextField(2);
    JLabel category = new JLabel("Category");
    JTextField categoryField = new RoundJTextField(2);
    JLabel gender = new JLabel("Gender");
    JTextField genderField = new RoundJTextField(2);
    JLabel manufactureDate = new JLabel("Manufacture Date");
    JTextField manufactureDateField = new RoundJTextField(2);
    JLabel size = new JLabel("Size");
    JTextField sizeDateField = new RoundJTextField(2);
    JButton button = new JButton("Select File");
    JLabel image = new JLabel("Image");
    JTextArea imageArea = new JTextArea();
    JLabel description = new JLabel("Description");
    JTextArea  descriptionField = new RoundJTextArea();
    JButton buttonAddProduct = new JButton("Add Product");
    JButton logOut = new JButton("Log Out");
    String inputImageName;
    File selectedFile;
    String destination;


    public ManagerPage() throws IOException {
        setTitle("MainPage");


        header.setLayout(null);
        header.setBackground(Color.white);
        add(header);
        header.setSize(1360,80);


        picLabel.setBounds(10,10,56,60);
        header.add(picLabel);



        koroShop.setFont(new Font("Arial Rounded MT Bold [Embedded]",Font.BOLD,30));
        koroShop.setForeground(new Color(64,64,65));
        koroShop.setBounds(70,10,200,95);
        header.add(koroShop);


        personHeaderLabel.setBounds(1130,25,30,30);
        header.add(personHeaderLabel);


        userName1.setBounds(1163, 23,100,30);
        userName1.setFont(fontHeaderUserName);
        userName1.setForeground(Color.DARK_GRAY);
        header.add(userName1);


        background.setLayout(null);
        add(background);
        background.setSize(1360,690);

        managerCorner.setLayout(null);
        managerCorner.setBackground(Color.WHITE);
        managerCorner.setBounds(30,110,306,600);
        managerCorner.setBorder(BorderFactory.createLineBorder(new Color(238,104,69), 2));
        background.add(managerCorner);
        managerCorner.setSize(306,600);


        personLabel.setBounds(40,40,50,50);
        managerCorner.add(personLabel);

        userName.setBounds(100, 40,100,30);
        userName.setFont(font2);
        userName.setForeground(Color.DARK_GRAY);
        managerCorner.add(userName);

        addProduct.setForeground(Color.decode("#8F8F8F"));
        addProduct.setBounds(40,130,150,30);
        addProduct.setFont(font);
        addProduct.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        managerCorner.add(addProduct);
        addProduct.addMouseListener(this);


        viewProducts.setForeground(Color.decode("#8F8F8F"));
        viewProducts.setBounds(40,170,150,30);
        viewProducts.setFont(font);
        viewProducts.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        managerCorner.add(viewProducts);
        viewProducts.addMouseListener(this);


        viewCustomers.setForeground(Color.decode("#8F8F8F"));
        viewCustomers.setBounds(40,210,150,30);
        viewCustomers.setFont(font);
        viewCustomers.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        managerCorner.add(viewCustomers);
        viewCustomers.addMouseListener(this);


        logOut.setBackground(Color.white);
        logOut.setForeground(new Color(238,104,69));
        logOut.setBorderPainted(true);
        logOut.setBorder(BorderFactory.createLineBorder(new Color(238,104,69), 2));
        logOut.setBounds(40,530,100,30);
        logOut.setSize(100,30);
        managerCorner.add(logOut);



        setSize(1360,770);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {


    }

    @Override
    public void mouseClicked(MouseEvent e) {
        final var source = e.getSource();
        if(source == addProduct){
            setVisible(false);
            try {
                new AddProducts().setVisible(true);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else if(source == viewProducts){
            setVisible(false);
            try {
                new ViewProduct().setVisible(true);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else if (source == viewCustomers) {
            setVisible(false);
            try {
                new ViewCustomer().setVisible(true);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public void mousePressed (MouseEvent event){

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

package GUI;

import DAO.ProductDAO;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

public class VehicleList extends  JFrame implements ActionListener {
    private final ProductDAO vehicleDAO = new ProductDAO();
    private JTextField vehicles = new JTextField();

    Object[][] data = vehicleDAO.getAllData();
    JTable table ;
    JScrollPane scrollPane ;
    JTableHeader Theader ;


    JTable table1;
    JScrollPane scrollPane1;

    JButton addVehicle = new JButton("Add Vehicle");
    JButton addService = new JButton("Add Service");

    JTextField search = new JTextField();
    JLabel searchLabel = new JLabel("Search");
    JButton searchButton = new JButton("Search");

    JButton update = new JButton("Update");


    private Statement statement = null;
    private ResultSet resultSet = null;
    public VehicleList(){
        setTitle("Vehicle List");
        setLayout(null);
        table = new JTable(data, new Object[]{"ID","Type","Manufacturer","Series", "Number", "Owner Name"});
        scrollPane = new JScrollPane(table);
        Theader = table.getTableHeader();

        add(scrollPane, BorderLayout.CENTER);
        scrollPane.setSize(1200,1000);
        scrollPane.setBounds(20,20,1200,1000);

        Theader.setForeground(Color.WHITE);
        Theader.setBackground(Color.decode("#5F727A"));
        Theader.setFont(new Font("Calibri", Font.CENTER_BASELINE,20));
        ((DefaultTableCellRenderer)Theader.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

        table.setFont(new Font("Tahome", Font.BOLD, 15));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(addVehicle);
        addVehicle.setBounds(1260,600,200,28);
        addVehicle.setFont(new Font("Calibri", Font.PLAIN, 15));
        addVehicle.setBackground(Color.decode("#5F727A"));
        addVehicle.setForeground(Color.white);
//        addVehicle.setUI(new StyledButtonUI());
        addVehicle.addActionListener(this);

        add(addService);
        addService.setBounds(1260,700,200,28);
        addService.setFont(new Font("Calibri", Font.PLAIN, 15));
        addService.setBackground(Color.decode("#5F727A"));
        addService.setForeground(Color.white);
//        addService.setUI(new StyledButtonUI());
        addService.addActionListener(this);

        add(search);
        add(searchLabel);
        add(searchButton);
        search.setBounds(1280,100,200,20);
        searchLabel.setBounds(1280,60,200,20);
        searchButton.setBounds(1300,150,100,20);
        searchButton.addActionListener(this);

        add(update);
        update.setBounds(1300,300,100,20);
        update.addActionListener(this);

        setSize(1600, 1000);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final var source = e.getSource();
        if (source == addVehicle){
            try {
                setVisible(false);
//                new Test().setVisible(true);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

        else if( source == searchButton){
            try{
                Object[][] newObject = vehicleDAO.newSearch(search.getText());
                table1 = new JTable(newObject, new Object[]{"ID","Type","Manufacturer","Series", "Number", "Owner Name"});
                scrollPane1 = new JScrollPane(table1);

                scrollPane.setVisible(false);
                add(scrollPane1, BorderLayout.CENTER);
                scrollPane1.setSize(1200,1000);
                scrollPane1.setBounds(20,20,1200,1000);




            }catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        else if( source == update){
            try{
                setVisible(false);
//                new UpdateVehicleList();
            }catch (Exception ex) {
                ex.printStackTrace();
            }
 }

}
}
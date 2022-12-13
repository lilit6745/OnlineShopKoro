package DAO;

import DB.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ProductDAO {
    final private List<Product> products = new ArrayList<>();
    private final ArrayList<Product> productList = new ArrayList<>();

    private Statement statement = null;
    private ResultSet resultSet = null;

    public String ValToSearch;
    Vector<Vector<String>> rows= new Vector<Vector<String>>();

    public void fillProducts() {
        try {
            statement = ConnectDB.connect().createStatement();
            resultSet = statement.executeQuery("Select * from products");
            while (resultSet.next()) {
                Product product = new Product();
                product.setProductName(resultSet.getString(2));
                product.setProductCategory(resultSet.getString(3));
                product.setImplManufactureDate(resultSet.getString(4));
                product.setProductSize(resultSet.getString(5));
                product.setProductImage(resultSet.getString(6));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private String toQuotedString(String s) {
        return '"' + s + '"';
    }

    public void insertProductRow(Product product) {
        try {
            statement = ConnectDB.connect().createStatement();
            String row = "insert into products values (NULL," + toQuotedString(product.getProductName()) + ','
                    + toQuotedString(product.getImplManufactureDate()) + ','
                    +  toQuotedString(product.getProductImage())  + ','
                    + toQuotedString(product.getProductSize()) + ','
                    + toQuotedString(product.getProductCategory()) + ","
                    + toQuotedString(product.getProductDescription()) + ","
                    + toQuotedString(product.getGender()) + ")";

            System.out.println(row);
            statement.executeUpdate(row);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private int getRowCount() {
        int rowCount = -1;
        try {
            statement = ConnectDB.connect().createStatement();
            String countQuery = "select count(*) from products";
            ResultSet rowCountResSet = statement.executeQuery(countQuery);
            rowCountResSet.next();
            rowCount = rowCountResSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowCount;
    }


    public Object[][] getAllData() {
        Object[][] data = null;
        try {
            statement = ConnectDB.connect().createStatement();
            resultSet = statement.executeQuery("Select * from products");
            int columnCount = resultSet.getMetaData().getColumnCount();
            System.out.println("columnCount = " + columnCount);
            int rowCount = getRowCount();
            System.out.println("row count = " + rowCount);
            data = new Object[rowCount][columnCount];
            int i = 0;
            while (resultSet.next()) {
                for (int j = 0; j < columnCount; j++) {
                    data[i][j] = resultSet.getObject(j + 1);
                    System.out.print(data[i][j] + " ");
                }
                System.out.println();
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }
//    public int toKnow (){
//        search("XXL");
//        int size = productList.size();
//        return size;
//    }

//    public Object[][] getSearchData(){
//        Object[][] data = null;
//
//        data = new Object[productList.size()][6];
//
//        for (int i = 0; i < productList.size(); i++) {
//            for (int j = 0; j < 6; j++) {
//                data[i][j] = productList.get(i);
//                System.out.print(data[i][j] + "\n");
//            }
//            System.out.println();
//            i++;
//        }
//
//        return data;
//    }
    public String getAllProducts() {
        String result = "";
        for (Product product : products) {
            result += product.toString();

        }
        return result;
    }
//    public ArrayList<Product> getSearch (){
////        search();
//        ArrayList<Product> newList = new ArrayList<>();
//        int i = 0;
//        for (Product product : productList ) {
//            newList.set(i, product);
//        }
//        return newList;
//    }

    public Vector<Vector<String>> search (String ValToSearch) {
        try {
            statement = ConnectDB.connect().createStatement();
            resultSet =  statement.executeQuery("select * from products where concat ( `product_id`, `product_name`, `manufacture_date`, `image`, `size`, `category`) like '%"+ValToSearch+"%'");

            while (resultSet.next()) {
                Product product = new Product();

                product.setProductId(resultSet.getInt(1));
                product.setProductName(resultSet.getString(2).toString());
                product.setManufactureDate(resultSet.getDate(3));
                product.setProductImage(resultSet.getString(4).toString());
                product.setProductSize(resultSet.getString(5).toString());
                product.setProductCategory(resultSet.getString(6).toString());
//                product.setImplProductDescription(resultSet.getString(7).toString());


                productList.add(product);
            }

            System.out.println("Barev");
            System.out.println(productList);
            System.out.println("yhy\n");
            for (Product x : productList) {
                Vector<String> row = new Vector<String>();
                row.add(Integer.toString(x.getProductId()));
                row.add(x.getProductName());
                row.add(x.getProductCategory());
                row.add(x.getProductSize());
                row.add(x.getImplManufactureDate());
                row.add(x.getProductImage());
                rows.add(row);
            }
            System.out.println(rows);
            Vector<String> columns = new Vector<String>();
            columns.add("id");
            columns.add("name");
            columns.add("address");
            columns.add("description");
            columns.add("est");
            columns.add("image");

            System.out.println(productList);


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return rows;
    }

    public Object[][] newSearch(String ValToSearch) {
        Object[][] data = null;
        try {
            statement = ConnectDB.connect().createStatement();
            resultSet =  statement.executeQuery("select * from products where concat ( `product_id`, `product_name`, `manufacture_date`, `image`, `size`, `category`) like '%"+ValToSearch+"%'");
            int columnCount = resultSet.getMetaData().getColumnCount();
            System.out.println("columnCount = " + columnCount);
            int rowCount = getRowCount();
            System.out.println("row count = " + rowCount);
            data = new Object[rowCount][columnCount];
            int i = 0;
            while (resultSet.next()) {
                for (int j = 0; j < columnCount; j++) {
                    data[i][j] = resultSet.getObject(j + 1);
                    System.out.print(data[i][j] + " ");
                }
                System.out.println();
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }
//    public Object[][] vectorProductData(){
////        Vector<Vector<String>> rows= new Vector<Vector<String>>();
////        for (Product x : productList) {
////            Vector<String> row = new Vector<String>();
////            row.add(Integer.toString(x.getProductId()));
////            row.add(x.getProductName());
////            row.add(x.getProductCategory());
////            row.add(x.getProductSize());
////            row.add(x.getImplManufactureDate());
////            row.add(x.getProductImage());
////            rows.add(row);
////        }
////
////        Vector<String> columns = new Vector<String>();
////        columns.add("id");
////        columns.add("name");
////        columns.add("address");
////        columns.add("description");
////        columns.add("est");
////        columns.add("image");
////
////        restaurantsTbl = new JTable(rows, columns);
////        restaurantsScrollPane = new JScrollPane(restaurantsTbl);
//        return 0;
//    }

}

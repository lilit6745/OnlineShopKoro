package DB;

import java.util.Date;

public class Product {
    private int productId;
    private String productName;
    private Date manufactureDate;
    private String implManufactureDate;
    private String productImage;
    private String productSize;
    private String productCategory;
    private String productDescription;
    private String gender;


    public Product() {
    }

    public Product(int productId, String productName, Date manufactureDate, String productImage, String productSize, String productCategory, String productDescription, String gender) {
        this.productId = productId;
        this.productName = productName;
        this.manufactureDate = manufactureDate;
        this.productImage = productImage;
        this.productSize = productSize;
        this.productCategory = productCategory;
        this.productDescription = productDescription;
        this.gender = gender;
    }

    public Product(int product_id, String product_name, java.sql.Date manufacture_date, String image, String size, String category, String description) {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public String getImplManufactureDate() {
        return implManufactureDate;
    }

    public void setImplManufactureDate(String manufactureDate) {
        this.implManufactureDate = manufactureDate;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", manufactureDate=" + manufactureDate +
                ", productImage='" + productImage + '\'' +
                ", productSize='" + productSize + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}

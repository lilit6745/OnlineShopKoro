package DB;

public class Admin {
    private int adminId;
    private String adminLogIn;
    private String adminPassword;

    public Admin() {
    }

    public Admin(int adminId, String adminLogIn, String adminPassword) {
        this.adminId = adminId;
        this.adminLogIn = adminLogIn;
        this.adminPassword = adminPassword;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminLogIn() {
        return adminLogIn;
    }

    public void setAdminLogIn(String adminLogIn) {
        this.adminLogIn = adminLogIn;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminLogIn='" + adminLogIn + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                '}';
    }
}

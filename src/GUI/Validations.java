package GUI;


public class Validations {
    public static boolean isEmail(String val) {
        String emailReg = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        if (isNotNull(val)) {
            try {
                return val.matches(emailReg);
            } catch (NumberFormatException e) {
                return false;
            }
        } else {
            return false;
        }
    }

    private static boolean isNotNull(String val) {
        if(val.isEmpty()){
            return false;
        } else{
            return true;
        }
    }

    public static boolean isPassword(String val) {
        String passRegex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[\\S])[A-Za-z0-9\\S]{6,12}$";
        if (val.matches(passRegex)) {
            return true;
        } else {
            return false;
        }
    }
}

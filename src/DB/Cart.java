package DB;

import java.time.DateTimeException;

public class Cart {
    private int cartId;
    private DateTimeException addDateTime;

    public Cart() {
    }

    public Cart(int cartId, DateTimeException addDateTime) {
        this.cartId = cartId;
        this.addDateTime = addDateTime;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public DateTimeException getAddDateTime() {
        return addDateTime;
    }

    public void setAddDateTime(DateTimeException addDateTime) {
        this.addDateTime = addDateTime;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", addDateTime=" + addDateTime +
                '}';
    }
}

package my.thanh.refreshspring;

import lombok.Data;

@Data
public class Customer {
    private final long id;
    private final String email;

    public Customer(long id, String email) {

        this.id = id;
        this.email = email;
    }
}

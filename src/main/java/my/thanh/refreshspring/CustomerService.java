package my.thanh.refreshspring;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomerService {
    private DataSource dataSource;

    public CustomerService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Collection<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        try {
            try (Connection conn = dataSource.getConnection()){
                Statement statement = conn.createStatement();
                try (ResultSet rs = statement.executeQuery("SELECT * FROM CUSTOMERS")) {
                    customers.add(new Customer(rs.getLong("ID"), rs.getString("EMAIL")));
                }
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return customers;
    }
}

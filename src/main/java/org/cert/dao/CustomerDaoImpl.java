package org.cert.dao;

import org.cert.model.Customer;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class CustomerDaoImpl implements Dao<Customer> {
  private DataSource dataSource;

  public CustomerDaoImpl(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public Optional<Customer> get(long id) {
    try (Connection connection = dataSource.getConnection()) {
      PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customer WHERE id = ?;");
      preparedStatement.setLong(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        long customerId = resultSet.getLong("id");
        String customerEmail = resultSet.getString("email");
        String customerPassword = resultSet.getString("password");

        return Optional.of(new Customer(customerId, customerEmail, customerPassword));
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    return Optional.empty();
  }

  @Override
  public boolean add(Customer customer) {
    try(Connection connection = dataSource.getConnection()) {
      PreparedStatement preparedStatement = connection.prepareStatement(
              "INSERT INTO customer (id, email, password) VALUES (?, ?, ?)");
      preparedStatement.setLong(1, customer.id());
      preparedStatement.setString(2, customer.email());
      preparedStatement.setString(3, customer.password());

      if(preparedStatement.executeUpdate() == 1) {
        return true;
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    return false;
  }
}

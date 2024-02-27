package org.cert.dao;

import org.cert.DataSourceManager;
import org.cert.model.Certificate;
import org.cert.model.Customer;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class CertificateDaoImpl implements Dao<Certificate> {

  private DataSource dataSource;

  public CertificateDaoImpl() {
    this.dataSource = DataSourceManager.getDataSource();
  }

  CertificateDaoImpl(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public static void main(String[] args) throws SQLException {
//    Connection connection =
//    CertificateDaoImpl impl = new CertificateDaoImpl();
//    CustomerDaoImpl impl1 = new CustomerDaoImpl(DataSourceManager.getDataSource());
//
//    impl1.add(new Customer(2, "test@email", "123456"));
//    impl.get(1l);
  }

  @Override
  public Optional<Certificate> get(long id) throws SQLException {
    Connection connection = null;
    Certificate cert = null;

    try {
      connection = dataSource.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM certificates WHERE id = ?;");
      preparedStatement.setLong(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        long certificateId = resultSet.getLong("id");
        String certificateDescription = resultSet.getString("description");

        cert = new Certificate(certificateId, certificateDescription);

        return Optional.of(cert);
      }

      return Optional.empty();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      if (connection != null) {
        connection.close();
      }
    }
  }

  @Override
  public boolean add(Certificate certificate) {
    //JdbcTemplate for Spring


    return false;
  }
}

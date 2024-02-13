package org.cert.dao;


import org.junit.Before;
import org.postgresql.ds.PGSimpleDataSource;

import java.sql.Connection;
import java.sql.Statement;

public class CertificateDaoImplTest {
  private Connection connection;

  @Before
  public void setUp() throws Exception {
    PGSimpleDataSource dataSource = new PGSimpleDataSource();
    // Establish connection to the test database
    dataSource.setURL("jdbc:postgresql://localhost:5432/certificates_test");
    dataSource.setUser("postgres");
    dataSource.setPassword("1234");
    connection = dataSource.getConnection();

    // Prepare test data
    try (Statement statement = connection.createStatement()) {
      statement.executeUpdate("INSERT INTO test_table (column1, column2) VALUES (1, 'test')");
    }
  }
}

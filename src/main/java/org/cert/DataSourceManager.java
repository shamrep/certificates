package org.cert;

import org.postgresql.ds.PGSimpleDataSource;
import javax.sql.DataSource;

public class DataSourceManager {
  private static PGSimpleDataSource dataSource = new PGSimpleDataSource();

   static {
     dataSource.setURL("jdbc:postgresql://localhost:5432/certificates");
     dataSource.setUser("postgres");
     dataSource.setPassword("1234");
   }

  public static DataSource getDataSource() {
    return dataSource;
  }
}

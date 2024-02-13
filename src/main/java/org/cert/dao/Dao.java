package org.cert.dao;

import java.sql.SQLException;
import java.util.Optional;

public interface Dao <T>{
  //read more about optional
  Optional<T> get(long id) throws SQLException;
  boolean add(T t);
}

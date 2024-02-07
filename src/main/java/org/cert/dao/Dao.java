package org.cert.dao;

import java.util.Optional;

public interface Dao <T>{
  //read more about optional
  Optional<T> get(long id);
  long create(T t);
}

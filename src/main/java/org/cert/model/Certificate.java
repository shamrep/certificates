package org.cert.model;

public class Certificate {
  public long id;
  public String description;

  public Certificate(long id, String description) {
    this.id = id;
    this.description = description;
  }

  public long getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }
}

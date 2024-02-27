package org.cert.controller;

import java.util.Objects;

public class Route {
  private final String path;
  private final HttpMethod method;

  public Route(String path, HttpMethod method) {
    this.path = path;
    this.method = method;
  }

  public enum HttpMethod {
    GET,
    POST
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Route route)) return false;

    if (!Objects.equals(path, route.path)) return false;
    return method == route.method;
  }

  @Override
  public int hashCode() {
    int result = path != null ? path.hashCode() : 0;
    result = 31 * result + (method != null ? method.hashCode() : 0);
    return result;
  }
}

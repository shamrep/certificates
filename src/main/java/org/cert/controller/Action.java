package org.cert.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Action {
  HttpServletResponse process(HttpServletRequest req, HttpServletResponse resp);
}

package org.cert.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/*")
public class Controller extends HttpServlet {
  private Dispatcher dispatcher;

  public Controller() {
    this.dispatcher = new Dispatcher();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    dispatcher.dispatch(new Route(getPath(req), Route.HttpMethod.GET), req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    super.doPost(req, resp);
  }

  private String getPath(HttpServletRequest request) {
    String path = request.getPathInfo();
    String[] splitPath = path.split("/");

    return splitPath[1];
  }
}

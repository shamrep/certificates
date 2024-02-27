package org.cert.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Map;

public class Dispatcher {
  private Map<Route, Action> actions;

  public Dispatcher() {
    actions = new HashMap<>();
    actions.put(new Route("certificate", Route.HttpMethod.GET), new GetCertificateAction());
  }

  public Action dispatch(Route route, HttpServletRequest req, HttpServletResponse resp) {
    Action action = actions.get(route);
    if(action != null) {
      action.process(req, resp);
    }
    System.out.println(req.getPathInfo());
    return action;
  }

}

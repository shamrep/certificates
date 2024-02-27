package org.cert.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.cert.model.Certificate;
import org.cert.service.CertificateService;
import org.cert.service.CertificateServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class GetCertificateAction implements Action {
  private CertificateService service;

  public GetCertificateAction() {
    this.service = new CertificateServiceImpl();
  }

  @Override
  public HttpServletResponse process(HttpServletRequest req, HttpServletResponse resp) {
    String url = req.getPathInfo();
    Optional<Certificate> cert = service.get(getCertificateIdFromUrl(url));
    System.out.println(cert.get());

    ObjectMapper mapper = new ObjectMapper();
    String certificateJson = "";

    try {
      certificateJson = mapper.writeValueAsString(cert.get());
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }

    System.out.println(certificateJson);

    resp.setContentType("application/json");
    resp.setCharacterEncoding("UTF-8");
    PrintWriter out = null;
    try {
      out = resp.getWriter();
      out.print(certificateJson);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    out.flush();
    return null;
  }

  private long getCertificateIdFromUrl(String url) {
    String[] paths = url.split("/");

    return Long.valueOf(paths[2]);
  }
}

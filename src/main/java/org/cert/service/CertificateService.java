package org.cert.service;

import org.cert.model.Certificate;

import java.util.List;
import java.util.Optional;

public interface CertificateService {
  List<Certificate> getAllCertificates();
  Optional<Certificate> get(long id);

}

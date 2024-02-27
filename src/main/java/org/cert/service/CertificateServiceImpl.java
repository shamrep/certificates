package org.cert.service;

import org.cert.dao.CertificateDaoImpl;
import org.cert.dao.Dao;
import org.cert.model.Certificate;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CertificateServiceImpl implements CertificateService {

  public CertificateServiceImpl() {
    this.certificateDao = new CertificateDaoImpl();
  }

  private Dao<Certificate> certificateDao;

  @Override
  public List<Certificate> getAllCertificates() {
    return List.of();
  }

  @Override
  public Optional<Certificate> get(long id) {
    try {
      return certificateDao.get(id);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
//    return null;
  }
}

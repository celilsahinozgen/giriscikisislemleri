package com.Resopsion.giriscikisislemleri.repository;

import com.Resopsion.giriscikisislemleri.model.SinifFiyatlandirma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SinifFiyatlandirmaRepository extends JpaRepository<SinifFiyatlandirma,String > {
}

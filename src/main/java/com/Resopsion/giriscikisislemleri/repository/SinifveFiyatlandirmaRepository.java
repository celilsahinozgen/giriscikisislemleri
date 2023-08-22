package com.Resopsion.giriscikisislemleri.repository;

import com.Resopsion.giriscikisislemleri.model.SinifveFiyatlandirma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface SinifveFiyatlandirmaRepository extends JpaRepository<SinifveFiyatlandirma, Long> {
    Optional<SinifveFiyatlandirma> findBySinifAdi(String sinifAdi);
}
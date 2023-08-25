package com.Resopsion.giriscikisislemleri.repository;

import com.Resopsion.giriscikisislemleri.model.OdaNumarasi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface OdaNumarasiRepository extends JpaRepository<OdaNumarasi, Long> {
    Optional<OdaNumarasi> findByOdaNumarasi(Integer odaNumarasi);

    List<OdaNumarasi> findByDolumu(int i);
}
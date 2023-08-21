package com.Resopsion.giriscikisislemleri.repository;

import com.Resopsion.giriscikisislemleri.model.OdaNumarasiData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface OdaNumarasiRepository extends JpaRepository<OdaNumarasiData, Long> {
    Optional<OdaNumarasiData> findByOdaNumarasi(Integer odaNumarasi);
}
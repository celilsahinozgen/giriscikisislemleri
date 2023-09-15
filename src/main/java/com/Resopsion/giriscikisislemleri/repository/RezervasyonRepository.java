package com.Resopsion.giriscikisislemleri.repository;

import com.Resopsion.giriscikisislemleri.model.OdaIslemleri;
import com.Resopsion.giriscikisislemleri.model.OdaNumarasi;
import com.Resopsion.giriscikisislemleri.model.Rezervasyon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RezervasyonRepository extends JpaRepository<Rezervasyon, Long> {

    Optional<OdaIslemleri> findByOdaNumarasi(OdaNumarasi odaNumarasi);

    Optional<OdaIslemleri> findTopByOdaNumarasiOrderByGirisTarihiRezervasyonDates(OdaNumarasi odaNumarasiData);
}

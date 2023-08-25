package com.Resopsion.giriscikisislemleri.repository;


import com.Resopsion.giriscikisislemleri.model.OdaIslemleri;
import com.Resopsion.giriscikisislemleri.model.OdaNumarasi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KayitIslemleriRepository extends JpaRepository<OdaIslemleri,Long> {

  Optional<OdaIslemleri> findByOdaNumarasi(OdaNumarasi OdaNumarasi);


  Optional<OdaIslemleri> findTopByOdaNumarasiOrderByCreateDateDesc(OdaNumarasi odaNumarasiData);
}

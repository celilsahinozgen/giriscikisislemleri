package com.Resopsion.giriscikisislemleri.repository;


import com.Resopsion.giriscikisislemleri.model.OdaIslemleri;
import com.Resopsion.giriscikisislemleri.model.OdaNumarasi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OdaDurumuSorgulaRepository extends JpaRepository<OdaIslemleri,Long> {


}

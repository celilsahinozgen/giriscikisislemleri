package com.Resopsion.giriscikisislemleri.service;


import com.Resopsion.giriscikisislemleri.model.OdaNumarasi;
import com.Resopsion.giriscikisislemleri.repository.OdaNumarasiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OdaNumarasiService {

    private final OdaNumarasiRepository odaNumarasiRepository;

    public OdaNumarasi findAndCheckOdaNumarasi(Integer odaNumarasi) {

        try {
            OdaNumarasi odaNumarasiData = odaNumarasiRepository.findByOdaNumarasi(odaNumarasi)
                    .orElseThrow(() -> new RuntimeException("Bu oda numarası bulunmamaktadır"));

            Integer dolumu = odaNumarasiData.getDolumu();
            if (dolumu != null && dolumu == 1) {
                throw new RuntimeException("Giris işlemi oluşturulamadı !!! ZATEN DOLU");
            }

            odaNumarasiData.setDolumu(1);
            odaNumarasiRepository.save(odaNumarasiData);
            return odaNumarasiData;
        } catch (RuntimeException e){
            throw new RuntimeException("Oda numarasinda bir problemvar" +e);

        }

    }




    public OdaNumarasi cikisIslemiKontrol(Integer odaNumarasi) {

        try {
            OdaNumarasi odaNumarasiData = odaNumarasiRepository.findByOdaNumarasi(odaNumarasi)
                    .orElseThrow(() -> new RuntimeException("Bu oda numarası bulunmamaktadır"));

            Integer dolumu = odaNumarasiData.getDolumu();
            if (dolumu != null && dolumu == 0) {
                throw new RuntimeException("Giris işlemi oluşturulamadı !!! ODA BOŞŞŞŞ");
            }
            odaNumarasiData.setDolumu(0);
            odaNumarasiRepository.save(odaNumarasiData);
            return odaNumarasiData;
        }catch (RuntimeException e){
            throw new RuntimeException("Oda numarasinda bir problemvar" +e);

        }

    }
}

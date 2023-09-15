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

    public OdaNumarasi notEklemeKontrol(Integer odaNumarasi) {
        try {
            OdaNumarasi odaNumarasiData = odaNumarasiRepository.findByOdaNumarasi(odaNumarasi)
                    .orElseThrow(()-> new RuntimeException("bu oda numarası bulunmamaktadır"));
            Integer dolumu = odaNumarasiData.getDolumu();
            if (dolumu != null && dolumu ==0){
                throw new RuntimeException("Giris işlemi oluşturulmadı !! Oda BoşŞŞş");
            }
            odaNumarasiRepository.save(odaNumarasiData);
            return odaNumarasiData;
        }catch (RuntimeException e){
            throw new RuntimeException("oda numarasinda bir problem var " + e);
        }
    }



    public OdaNumarasi hesapOzetKontrol(Integer odaNumarasi){
        try {
            OdaNumarasi odaNumarasiData = odaNumarasiRepository.findByOdaNumarasi(odaNumarasi)
                    .orElseThrow(()-> new RuntimeException("Bu oda numarası bulunmamaktadır"));
            Integer dolumu = odaNumarasiData.getDolumu();
            if (dolumu != null && ( dolumu == 0 ) || dolumu ==2) {
                throw new RuntimeException(" Giris işlemi oluşturulamadı !!! oda nuamrası boş veya rezerve");
            }
                return odaNumarasiData;
        }  catch (RuntimeException e){
        throw new RuntimeException("oda numarasinda bir problem var " + e);
    }
    }

    public OdaNumarasi rezervasyonIslemleri ( Integer odaNumarasi){
        try {
            OdaNumarasi odaNumarasiData = odaNumarasiRepository.findByOdaNumarasi(odaNumarasi)
                    .orElseThrow(()-> new RuntimeException("Bu oda numarasi bulunmamaktadir"));
            Integer dolumu = odaNumarasiData.getDolumu();

            if (dolumu != null && (dolumu == 0 || dolumu == 2)){
                throw new RuntimeException("Giris işlemi oluşturulmadı !!! ODA BOŞ ve ya Rezerve");
            }
            odaNumarasiData.setDolumu(2);
            odaNumarasiRepository.save(odaNumarasiData);
            return odaNumarasiData;
        } catch (RuntimeException e) {
            throw new RuntimeException("Oda numarasinda bir problem var " + e );
        }
    }



}

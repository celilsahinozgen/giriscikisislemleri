package com.Resopsion.giriscikisislemleri.service;

import com.Resopsion.giriscikisislemleri.dto.CikisIslemiDTO;
import com.Resopsion.giriscikisislemleri.model.OdaIslemleri;
import com.Resopsion.giriscikisislemleri.model.OdaNumarasi;
import com.Resopsion.giriscikisislemleri.repository.KayitIslemleriRepository;
import com.Resopsion.giriscikisislemleri.repository.OdaNumarasiRepository;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CikisIslemleriService {

    private final ModelMapper modelMapper;
    private final KayitIslemleriRepository kayitIslemleriRepository;
    private final SinifFiyatlandirmaService sinifFiyatlandirmaService;
    private final OdaNumarasiRepository odaNumarasiRepository;

    public CikisIslemiDTO cikisIslemi(Integer odaNumarasi, CikisIslemiDTO cikisIslemiDTO) {

        OdaNumarasi odaNumarasiData = odaNumarasiRepository.findByOdaNumarasi(odaNumarasi)
                .orElseThrow(() -> new RuntimeException("Bu oda numarası bulunmamaktadır"));

        if (odaNumarasiData.getDolumu() != 1) {
            throw new RuntimeException("Çıkış işlemi oluşturulamadı !!! ODA BOŞ");
        }

        odaNumarasiData.setDolumu(0); // Dolumu değerini 1 olarak set edin.
        odaNumarasiRepository.save(odaNumarasiData); // Değişikliği veritabanına kaydet.

        Optional<OdaIslemleri> odaNumarasiVarmi = kayitIslemleriRepository.findByOdaNumarasi(odaNumarasiData);

        if (!odaNumarasiVarmi.isPresent()) {
            throw new RuntimeException("Bu oda numarası için kayıt bulunmamaktadır");
        }


        OdaIslemleri cikisIslemleri = odaNumarasiVarmi.get();

        LocalDateTime createDate = cikisIslemleri.getCreateDate();
        LocalDateTime cikisTarihi = cikisIslemiDTO.getCikisTarihi();

        if (cikisTarihi.getHour() >= 10) {
            cikisTarihi = cikisTarihi.plusDays(1);
        }

        long gunSayisi = ChronoUnit.DAYS.between(createDate, cikisTarihi);

        // Sınıf tipini OdaIslemleri nesnesinden al
        String sinifTipi = cikisIslemleri.getSinifTipi().getSinifAdi();

        // İlgili sınıf tipine göre fiyatlandırma değerini servisten al
        int fiyatCarpani = sinifFiyatlandirmaService.getFiyat(sinifTipi);

        // Gün sayısını fiyat çarpanı ile çarp
        int hesaplananDeger = (int) gunSayisi * fiyatCarpani;

        cikisIslemiDTO.setHesaplananDeger(hesaplananDeger);

        cikisIslemleri.setCikisTarihi(cikisIslemiDTO.getCikisTarihi());
        return modelMapper.map(kayitIslemleriRepository.save(cikisIslemleri), CikisIslemiDTO.class);
    }
}
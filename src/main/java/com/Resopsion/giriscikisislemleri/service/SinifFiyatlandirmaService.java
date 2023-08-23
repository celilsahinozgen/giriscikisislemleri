package com.Resopsion.giriscikisislemleri.service;

import com.Resopsion.giriscikisislemleri.model.SinifveFiyatlandirma;
import com.Resopsion.giriscikisislemleri.repository.SinifveFiyatlandirmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SinifFiyatlandirmaService {

    private final SinifveFiyatlandirmaRepository sinifveFiyatlandirmaRepository;


    public SinifveFiyatlandirma findSinifTipi(String sinifTipiAdi) {
        return sinifveFiyatlandirmaRepository.findBySinifAdi(sinifTipiAdi)
                .orElseThrow(() -> new RuntimeException("Bu sınıf tipi bulunmamaktadır"));
    }


    public SinifveFiyatlandirma getSinif(String sinifTipi) {
        return sinifveFiyatlandirmaRepository.findBySinifAdi(sinifTipi).orElseThrow(() -> new RuntimeException("böyle bir sınıf tipi yoktur"));
    }


    public int getFiyat(String sinifTipi) {
        return sinifveFiyatlandirmaRepository.findBySinifAdi(sinifTipi)
                .map(SinifveFiyatlandirma::getFiyat)
                .orElseThrow(() -> new RuntimeException("Bu sınıf tipi bulunmamaktadır"));
    }
}

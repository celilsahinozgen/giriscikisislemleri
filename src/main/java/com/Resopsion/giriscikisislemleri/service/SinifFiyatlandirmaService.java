package com.Resopsion.giriscikisislemleri.service;

import com.Resopsion.giriscikisislemleri.model.SinifveFiyatlandirma;
import com.Resopsion.giriscikisislemleri.repository.SinifveFiyatlandirmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SinifFiyatlandirmaService {


    private SinifveFiyatlandirmaRepository repository;

    public int getFiyat(String sinifAdi) {
        return repository.findBySinifAdi(sinifAdi)
                .map(SinifveFiyatlandirma::getFiyat)
                .orElseThrow(() -> new RuntimeException("Sınıf bulunamadı: " + sinifAdi));
    }

    public void setFiyat(String sinifAdi, int yeniFiyat) {
        SinifveFiyatlandirma sinifveFiyatlandirma = repository.findBySinifAdi(sinifAdi)
                .orElseThrow(() -> new RuntimeException("Sınıf bulunamadı: " + sinifAdi));
        sinifveFiyatlandirma.setFiyat(yeniFiyat);
        repository.save(sinifveFiyatlandirma);
    }
}


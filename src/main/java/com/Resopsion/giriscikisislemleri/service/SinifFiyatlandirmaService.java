package com.Resopsion.giriscikisislemleri.service;

import com.Resopsion.giriscikisislemleri.model.SinifFiyatlandirma;
import com.Resopsion.giriscikisislemleri.repository.SinifFiyatlandirmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SinifFiyatlandirmaService {


    private SinifFiyatlandirmaRepository repository;

    public int getFiyat(String sinifAdi) {
        return repository.findById(sinifAdi)
                .map(SinifFiyatlandirma::getFiyat)
                .orElseThrow(() -> new RuntimeException("Sınıf bulunamadı: " + sinifAdi));
    }

    public void setFiyat(String sinifAdi, int yeniFiyat) {
        SinifFiyatlandirma sinifFiyatlandirma = repository.findById(sinifAdi)
                .orElseThrow(() -> new RuntimeException("Sınıf bulunamadı: " + sinifAdi));
        sinifFiyatlandirma.setFiyat(yeniFiyat);
        repository.save(sinifFiyatlandirma);
    }
}


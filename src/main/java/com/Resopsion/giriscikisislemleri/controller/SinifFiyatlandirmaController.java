package com.Resopsion.giriscikisislemleri.controller;


import com.Resopsion.giriscikisislemleri.model.SinifFiyatlandirma;
import com.Resopsion.giriscikisislemleri.repository.SinifFiyatlandirmaRepository;
import com.Resopsion.giriscikisislemleri.service.SinifFiyatlandirmaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sinif")
public class SinifFiyatlandirmaController {


        @Autowired
        private SinifFiyatlandirmaService sinifFiyatlandirmaService;

        @PostMapping("/create")
        public ResponseEntity<String> createSinifFiyatlandirma(@RequestParam String sinifAdi, @RequestParam int fiyat) {
            sinifFiyatlandirmaService.setFiyat(sinifAdi, fiyat);
            return ResponseEntity.ok("Fiyatlandırma başarıyla oluşturuldu");
        }

        @GetMapping("/getFiyat")
        public ResponseEntity<Integer> getFiyat(@RequestParam String sinifAdi) {
            int fiyat = sinifFiyatlandirmaService.getFiyat(sinifAdi);
            return ResponseEntity.ok(fiyat);
        }

        @PutMapping("/update")
        public ResponseEntity<String> updateFiyat(@RequestParam String sinifAdi, @RequestParam int yeniFiyat) {
            sinifFiyatlandirmaService.setFiyat(sinifAdi, yeniFiyat);
            return ResponseEntity.ok("Fiyat başarıyla güncellendi");
        }
    }

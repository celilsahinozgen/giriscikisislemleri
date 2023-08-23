//package com.Resopsion.giriscikisislemleri.controller;
//
//
//import com.Resopsion.giriscikisislemleri.repository.SinifveFiyatlandirmaRepository;
//import com.Resopsion.giriscikisislemleri.service.SinifveFiyatlandirmaService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/sinif")
//public class SinifveFiyatlandirmaController {
//
//
//        @Autowired
//        private SinifveFiyatlandirmaRepository sinifveFiyatlandirmaService;
//
//        @PostMapping("/create")
//        public ResponseEntity<String> createSinifFiyatlandirma(@RequestParam String sinifAdi, @RequestParam int fiyat) {
//            sinifveFiyatlandirmaService.setFiyat(sinifAdi, fiyat);
//            return ResponseEntity.ok("Fiyatlandırma başarıyla oluşturuldu");
//        }
//
//        @GetMapping("/getFiyat")
//        public ResponseEntity<Integer> getFiyat(@RequestParam String sinifAdi) {
//            int fiyat = sinifveFiyatlandirmaService.getFiyat(sinifAdi);
//            return ResponseEntity.ok(fiyat);
//        }
//
//        @PutMapping("/update")
//        public ResponseEntity<String> updateFiyat(@RequestParam String sinifAdi, @RequestParam int yeniFiyat) {
//            sinifveFiyatlandirmaService.setFiyat(sinifAdi, yeniFiyat);
//            return ResponseEntity.ok("Fiyat başarıyla güncellendi");
//        }
//    }

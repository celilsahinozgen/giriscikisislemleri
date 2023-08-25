package com.Resopsion.giriscikisislemleri.controller;

import com.Resopsion.giriscikisislemleri.dto.CikisIslemiDTO;
import com.Resopsion.giriscikisislemleri.dto.KayitIslemleriDTO;
import com.Resopsion.giriscikisislemleri.dto.OdaNotuEkleDTO;
import com.Resopsion.giriscikisislemleri.model.OdaNumarasi;
import com.Resopsion.giriscikisislemleri.model.SinifveFiyatlandirma;

import com.Resopsion.giriscikisislemleri.service.KayitIslemleriService;
import com.Resopsion.giriscikisislemleri.service.OdaNumarasiService;
import com.Resopsion.giriscikisislemleri.service.SinifFiyatlandirmaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/resepsion")
@RequiredArgsConstructor

public class KayitIslemleriController {

    private final KayitIslemleriService kayitIslemleriService;
    private final OdaNumarasiService odaNumarasiService;
    private final SinifFiyatlandirmaService sinifFiyatlandirmaService;



    @PostMapping("/create/{odaNumarasi}")
    public ResponseEntity<KayitIslemleriDTO> KayitIslemleri(@Valid @RequestBody KayitIslemleriDTO userCreateDTO, @PathVariable Integer odaNumarasi) {
        userCreateDTO.setOdaNumarasi(odaNumarasi); // Burada odaNumarasi değerini DTO'ya atıyoruz.
        OdaNumarasi odaNumarasiData = odaNumarasiService.findAndCheckOdaNumarasi(odaNumarasi);
        SinifveFiyatlandirma sinifTipi = sinifFiyatlandirmaService.getSinif(userCreateDTO.getSinifTipi());

        KayitIslemleriDTO newData = kayitIslemleriService.createUser(userCreateDTO, odaNumarasiData, sinifTipi);


        return ResponseEntity.ok(newData);
    }

    @PutMapping("/notguncelleme/{odaNumarasi}")
    public ResponseEntity<OdaNotuEkleDTO> guncelleme(@PathVariable Integer odaNumarasi, @RequestBody OdaNotuEkleDTO odaNotuEkleDTO ){
        OdaNotuEkleDTO cikisIslemi = kayitIslemleriService.odaNotuEkle(odaNumarasi,odaNotuEkleDTO);
        return ResponseEntity.ok(cikisIslemi);

    }



}

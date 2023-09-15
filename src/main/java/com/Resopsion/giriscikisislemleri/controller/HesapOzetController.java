package com.Resopsion.giriscikisislemleri.controller;

import com.Resopsion.giriscikisislemleri.dto.HesapOzetDTO;
import com.Resopsion.giriscikisislemleri.service.HesapOzetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/resepsion")
@RequiredArgsConstructor
public class HesapOzetController {

    private final HesapOzetService hesapOzetService;

    @GetMapping("/hesapozet/{odaNumarasi}")
    public ResponseEntity<HesapOzetDTO> hesapOzetHesaplama(@PathVariable Integer odaNumarasi){
        HesapOzetDTO hesapOzetDTO = hesapOzetService.hesapOzetHesapla(odaNumarasi);
        return ResponseEntity.ok(hesapOzetDTO);
    }


}

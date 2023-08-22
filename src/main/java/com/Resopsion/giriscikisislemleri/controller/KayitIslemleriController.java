package com.Resopsion.giriscikisislemleri.controller;

import com.Resopsion.giriscikisislemleri.dto.CikisIslemiDTO;
import com.Resopsion.giriscikisislemleri.dto.KayitIslemleriDTO;
import com.Resopsion.giriscikisislemleri.service.CikisIslemleriService;
import com.Resopsion.giriscikisislemleri.service.KayitIslemleriService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/resepsion")
@RequiredArgsConstructor

public class KayitIslemleriController {

    private final KayitIslemleriService kayitIslemleriService;


    @PostMapping("/create/{odaNumarasi}")
    public ResponseEntity<KayitIslemleriDTO> createUser(@Valid @RequestBody KayitIslemleriDTO userCreateDTO, @PathVariable Integer odaNumarasi) {
        KayitIslemleriDTO resultPersonel = kayitIslemleriService.createUser(userCreateDTO,odaNumarasi);
        return ResponseEntity.ok(resultPersonel);
    }



}

package com.Resopsion.giriscikisislemleri.controller;


import com.Resopsion.giriscikisislemleri.dto.ResponseOdaDurumuDTO;
import com.Resopsion.giriscikisislemleri.service.OdaDurumuSorgulaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/resepsion")
@RequiredArgsConstructor
public class OdaDurumuSorgulaController {

    private final OdaDurumuSorgulaService odaDurumuSorgulaService;


    @GetMapping("/boslarigetir")
    public ResponseEntity<List<ResponseOdaDurumuDTO>> bosolanOdalarıGetir() {
        List<ResponseOdaDurumuDTO> odaDurumuDTOList = odaDurumuSorgulaService.getBosOdalar();
        return ResponseEntity.ok(odaDurumuDTOList);
    }

    @GetMapping("/dolularigetir")
    public ResponseEntity<List<ResponseOdaDurumuDTO>> doluOdalarıGetir() {
        List<ResponseOdaDurumuDTO> odaDurumuDTOList = odaDurumuSorgulaService.getDoluOdalar();
        return ResponseEntity.ok(odaDurumuDTOList);
    }

}

package com.Resopsion.giriscikisislemleri.controller;

import com.Resopsion.giriscikisislemleri.dto.CikisIslemiDTO;
import com.Resopsion.giriscikisislemleri.dto.RezervasyonDTO;
import com.Resopsion.giriscikisislemleri.model.OdaNumarasi;
import com.Resopsion.giriscikisislemleri.service.OdaNumarasiService;
import com.Resopsion.giriscikisislemleri.service.RezervasyonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resepsion")
@RequiredArgsConstructor
public class RezervasyonController {

    private final RezervasyonService rezervasyonService;
    private final OdaNumarasiService odaNumarasiService;

    @PostMapping("/rezervasyon/{odaNumarasi}")
    public ResponseEntity<RezervasyonDTO> rezervasyonYap(@Valid @RequestBody RezervasyonDTO responseOdaDurumuDTO, @PathVariable Integer odaNumarasi){
        responseOdaDurumuDTO.setOdaNumarasi(odaNumarasi);

        OdaNumarasi odaNumarasiData= odaNumarasiService.findAndCheckOdaNumarasi(odaNumarasi);
        RezervasyonDTO newData = rezervasyonService.rezervasyonIslemleri(responseOdaDurumuDTO,odaNumarasiData);
        return ResponseEntity.ok(newData);
    }

    @PutMapping("/rezervekaldir/{odaNumarasi}")
    public ResponseEntity<CikisIslemiDTO> cikisIslemi(@PathVariable Integer odaNumarasi){
        CikisIslemiDTO cikisIslemiDTO = rezervasyonService.rezerbasyonKaldir(odaNumarasi);
        return ResponseEntity.ok(cikisIslemiDTO);
    }
}

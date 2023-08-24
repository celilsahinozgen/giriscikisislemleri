package com.Resopsion.giriscikisislemleri.controller;

import com.Resopsion.giriscikisislemleri.dto.CikisIslemiDTO;
import com.Resopsion.giriscikisislemleri.service.CikisIslemleriService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/resepsion")
@RequiredArgsConstructor
public class CikisIslemleriController {


    private final CikisIslemleriService cikisIslemleriService;



    @PutMapping("/update/{odaNumarasi}")
    public ResponseEntity<CikisIslemiDTO> cikisIslemi(@PathVariable Integer odaNumarasi, @RequestBody CikisIslemiDTO cikisIslemiDTO ){
        CikisIslemiDTO cikisIslemi = cikisIslemleriService.cikisIslemi(odaNumarasi,cikisIslemiDTO);
        return ResponseEntity.ok(cikisIslemi);

    }
}

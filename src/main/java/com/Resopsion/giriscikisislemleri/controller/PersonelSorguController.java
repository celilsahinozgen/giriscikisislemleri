package com.Resopsion.giriscikisislemleri.controller;

import com.Resopsion.giriscikisislemleri.dto.KisiDTO.PersonelSorguDto;
import com.Resopsion.giriscikisislemleri.service.PersonelSorguService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resepsion")
@RequiredArgsConstructor

public class PersonelSorguController {

    private final PersonelSorguService personelSorguService;

    @GetMapping("/personelsorgula/{sicil}")
    public PersonelSorguDto personenelBilgisiniGetir(@PathVariable("sicil") String sicil){
        return personelSorguService.kisiSorgula(sicil);
    }


}

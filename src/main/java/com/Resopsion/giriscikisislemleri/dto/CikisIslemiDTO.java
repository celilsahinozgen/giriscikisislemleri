package com.Resopsion.giriscikisislemleri.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CikisIslemiDTO {


    Integer odaNumarasi;



    LocalDateTime cikisTarihi;

    Integer dolumu=0;

    Integer hesaplananDeger;
}

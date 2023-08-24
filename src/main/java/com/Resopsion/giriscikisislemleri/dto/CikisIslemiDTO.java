package com.Resopsion.giriscikisislemleri.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static com.Resopsion.giriscikisislemleri.model.OdaIslemleri.ZAMANPATTERIN;

@Data
public class CikisIslemiDTO {




    @DateTimeFormat(pattern = ZAMANPATTERIN)
    LocalDateTime cikisTarihi;

    Integer dolumu=0;

    Integer hesaplananDeger;
}

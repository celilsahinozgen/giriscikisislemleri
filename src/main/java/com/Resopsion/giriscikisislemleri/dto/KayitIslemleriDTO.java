package com.Resopsion.giriscikisislemleri.dto;


import com.Resopsion.giriscikisislemleri.valid.TCKNConstraint;
import com.Resopsion.giriscikisislemleri.valid.UserNameConstraint;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static com.Resopsion.giriscikisislemleri.model.OdaIslemleri.ZAMANPATTERIN;

@Data
public class KayitIslemleriDTO {


    String sinifTipi; // SINIF_1, SINIF_2, SINIF_3 gibi değerler alabilir

    @UserNameConstraint
    String firstName;

    String lastName;

    @TCKNConstraint
    String tcNo;

    String mail;

    String sifre;

    Integer odaNumarasi;

    Integer dolumu=1;

    String  odaNotu;

    @DateTimeFormat(pattern = ZAMANPATTERIN)
    LocalDateTime createDate= LocalDateTime.now();



}

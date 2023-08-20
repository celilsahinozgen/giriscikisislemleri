package com.Resopsion.giriscikisislemleri.dto;


import com.Resopsion.giriscikisislemleri.valid.TCKNConstraint;
import com.Resopsion.giriscikisislemleri.valid.UserNameConstraint;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserCreateDTO {

    @UserNameConstraint
    String firstName;

    String lastName;

    @TCKNConstraint
    String tcNo;

    String mail;

    String sifre;

    Integer odaNumarasi;

    Integer dolumu=1;

    LocalDateTime createDate= LocalDateTime.now();

    String sinifTipi; // SINIF_1, SINIF_2, SINIF_3 gibi değerler alabilir


}

package com.Resopsion.giriscikisislemleri.dto;

import com.Resopsion.giriscikisislemleri.valid.TCKNConstraint;
import jakarta.persistence.Column;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class RezervasyonDTO {


    String firstName;

    String lastName;

    @TCKNConstraint
    String tckNo;

    String mail;

    Integer odaNumarasi;

    String odaNotu;

    String girisTarihi;

    String updateDate;

    String rezervasyonDate;
}

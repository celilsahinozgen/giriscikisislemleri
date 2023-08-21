package com.Resopsion.giriscikisislemleri.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "sinif_fiyatlandirma")
@Data
public class SinifFiyatlandirma {


    @Id
    private Long id;

    private String sinifAdi; // SINIF_1, SINIF_2, SINIF_3 gibi değerler alabilir

    private int fiyat;

    // Getter ve Setter
}
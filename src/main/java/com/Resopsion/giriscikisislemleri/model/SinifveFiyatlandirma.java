package com.Resopsion.giriscikisislemleri.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "sinif_fiyatlandirma")
@Data
public class SinifveFiyatlandirma {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String sinifAdi; // SINIF_1, SINIF_2, SINIF_3 gibi değerler alabilir

    private int fiyat;


}
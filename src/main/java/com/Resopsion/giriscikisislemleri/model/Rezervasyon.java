package com.Resopsion.giriscikisislemleri.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Rezervasyon {

    public static final String ZAMANPATTERIN= "yyyy-MM-dd HH:mm:ss";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    @JoinColumn(name = "odanumarasi")
    private OdaNumarasi odaNumarasi;

    @Column(name = "ISIM")
    String firstName;

    @Column(name = "SOYISIM")
    String lastName;

    @Column(name = "TCNUMARASI")
    String tckNo;

    @Column(name = "ODANOTU")
    String odaNotu;

    @Column(name = "OLUSTURMATARIHI")
    @DateTimeFormat(pattern = ZAMANPATTERIN)
    String girisTarihi;

    @Column(name = "GUNCELLEMETARIHI")
    @DateTimeFormat(pattern = ZAMANPATTERIN)
    String updateDate;

    @Column(name = "REZERVASYON")
    @DateTimeFormat(pattern = ZAMANPATTERIN)
    String rezervasyonDate;

}

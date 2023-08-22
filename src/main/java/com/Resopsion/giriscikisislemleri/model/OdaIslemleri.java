package com.Resopsion.giriscikisislemleri.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "personel")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OdaIslemleri {

    public static final String ZAMANPATTERIN= "yyyy-MM-dd HH:mm:ss";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;


    @Column(name = "ISIM")
    String firstName;

    @Column(name = "SOYISIM")
    String lastName;

    @Column(name = "TCNUMARASI")
    String tcNo;

    @Column(name = "MAIL")
    String mail;

    @Column(name = "sifre")
    Integer sifre;

    @OneToOne
    OdaNumarasi odaNumarasi;


    @Column(name = "OLUSDURMATARIHI")
    @DateTimeFormat(pattern = ZAMANPATTERIN)
    private LocalDateTime createDate;

    @Column(name = "GUNCELLEMETARIHI")
    @DateTimeFormat(pattern = ZAMANPATTERIN)
    private LocalDateTime updateDate;

    @Column(name = "CIKISTARIHI")
    @DateTimeFormat(pattern = ZAMANPATTERIN)
    private LocalDateTime cikisTarihi;

    @Column(name = "ODAFIYATIDEGERI")
    Integer hesaplananDeger;

    @OneToOne
    private SinifveFiyatlandirma sinifTipi;


}

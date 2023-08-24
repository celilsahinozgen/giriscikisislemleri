package com.Resopsion.giriscikisislemleri.model;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "personel")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class OdaIslemleri {

    public static final String ZAMANPATTERIN= "yyyy-MM-dd HH:mm:ss";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    // Diğer alanlar ...

    @ManyToOne
    @JoinColumn(name = "odanumarasi")
    private OdaNumarasi odaNumarasi;

    @OneToOne
    @JoinColumn(name = "sinif_fiyatlandirma_id")
    private SinifveFiyatlandirma sinifTipi;


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




}

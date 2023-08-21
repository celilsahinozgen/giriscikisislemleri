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
public class User {

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


    @ManyToOne
    @JoinColumn(name = "oda_numarasi_id")
    OdaNumarasiData odaNumarasi;



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

    private String sinifTipi;

//    @NotNull
//   @Size(min = 2, message = "Must be not null")
//    @Column(name = "ISIM")
//    String firstName;
//
//    @NotBlank(message = "Must be not blank")
//    @Column(name = "SOYISIM")
//    String lastName;
//
//    @Column(name = "TCNUMARASI")
//    String tcNo;
//
//    @Email(message = "Email should be valid")
//    @Column(name = "MAIL")
//    String mail;
//
//    @Pattern(regexp = "[0-9\\s]{12}")
//    @Column(name = "sifre")
//    Integer sifre;
}

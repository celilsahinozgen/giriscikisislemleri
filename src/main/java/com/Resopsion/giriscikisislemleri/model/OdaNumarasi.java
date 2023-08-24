package com.Resopsion.giriscikisislemleri.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "odanumarasi")
@Data
@Getter
@Setter
public class OdaNumarasi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "odanumarasi")
    private Integer odaNumarasi;

    @Column(name = "dolumu")
    private Integer dolumu;

    @OneToMany(mappedBy = "odaNumarasi")
    private List<OdaIslemleri> kullaniciIslemleri;
}
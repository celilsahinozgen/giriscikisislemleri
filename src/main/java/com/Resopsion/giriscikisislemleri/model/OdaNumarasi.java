package com.Resopsion.giriscikisislemleri.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "odanumarasi")
@Data
@Getter
@Setter
public class OdaNumarasi {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "OdaNumarasi")
    private Integer odaNumarasi;

    @Column(name = "Dolumu")
    private Integer dolumu;

}

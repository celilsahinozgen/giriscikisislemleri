package com.Resopsion.giriscikisislemleri.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private Long id;

    @Column(name = "OdaNumarasi")
    private Integer odaNumarasi;

    @Column(name = "Dolumu")
    private Integer dolumu;

}

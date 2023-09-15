package com.Resopsion.giriscikisislemleri.dto.KisiDTO;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ResponseDTO {

    private int status;

    @JsonProperty("data")
    private PersonelSorguDto personelSorguDto;

    // içinde baska birşey varsa datanın mesela
    @JsonProperty("sorumluluk")
    private List<String > sorumluluk;
}

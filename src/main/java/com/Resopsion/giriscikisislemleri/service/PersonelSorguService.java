package com.Resopsion.giriscikisislemleri.service;


import com.Resopsion.giriscikisislemleri.dto.KisiDTO.PersonelSorguDto;
import com.Resopsion.giriscikisislemleri.dto.KisiDTO.ResponseDTO;
import com.Resopsion.giriscikisislemleri.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
@RequiredArgsConstructor
public class PersonelSorguService {

    private final ModelMapper modelMapper;
    private final WebClient.Builder webClientBuilder;

    public PersonelSorguDto kisiSorgula(String sicil) {
        String API_URL = "http://255.255.252.0" +  sicil;

        try {
            ResponseDTO response = webClientBuilder.build()
                    .get().uri(API_URL).retrieve().bodyToMono(ResponseDTO.class).block();
            if (response.getStatus() != 200 || response.getPersonelSorguDto() ==null){
                throw new CustomException("Beklenmeyen bir Hata oluştu");
            }
            return response.getPersonelSorguDto();
        } catch (WebClientResponseException e){
            int statusCode = e.getStatusCode().value();

            if (statusCode == 404){
                return null;
            } else if (statusCode >= 500){
                throw new CustomException("Sunucu Hatası");
            } else {
                throw e;
            }
        }
    }

}

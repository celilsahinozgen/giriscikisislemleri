package com.Resopsion.giriscikisislemleri.service;


import com.Resopsion.giriscikisislemleri.dto.ResponseOdaDurumuDTO;
import com.Resopsion.giriscikisislemleri.model.OdaNumarasi;
import com.Resopsion.giriscikisislemleri.repository.OdaNumarasiRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OdaDurumuSorgulaService {


    private final OdaNumarasiRepository odaNumarasiRepository;
    private final ModelMapper modelMapper;

    public List<ResponseOdaDurumuDTO> getBosOdalar() {
        List<OdaNumarasi> bosOdalar = odaNumarasiRepository.findByDolumu(0);
        List<ResponseOdaDurumuDTO> responseDTOList = bosOdalar.stream().map(odaNumarasi -> modelMapper.map(odaNumarasi, ResponseOdaDurumuDTO.class)).collect(Collectors.toList());


        return responseDTOList;
    }

    public List<ResponseOdaDurumuDTO> getDoluOdalar() {
        List<OdaNumarasi> bosOdalar = odaNumarasiRepository.findByDolumu(1);
        List<ResponseOdaDurumuDTO> responseDTOList = bosOdalar.stream().map(odaNumarasi -> modelMapper.map(odaNumarasi, ResponseOdaDurumuDTO.class)).collect(Collectors.toList());


        return responseDTOList;
    }

}

package com.Resopsion.giriscikisislemleri.service;

import com.Resopsion.giriscikisislemleri.dto.CikisIslemiDTO;
import com.Resopsion.giriscikisislemleri.dto.RezervasyonDTO;
import com.Resopsion.giriscikisislemleri.model.OdaIslemleri;
import com.Resopsion.giriscikisislemleri.model.OdaNumarasi;
import com.Resopsion.giriscikisislemleri.model.Rezervasyon;
import com.Resopsion.giriscikisislemleri.repository.KayitIslemleriRepository;
import com.Resopsion.giriscikisislemleri.repository.OdaNumarasiRepository;
import com.Resopsion.giriscikisislemleri.repository.RezervasyonRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RezervasyonService {

    private final OdaNumarasiService odaNumarasiService;
    private final ModelMapper modelMapper;
    private final RezervasyonRepository rezervasyonRepository;
    private final OdaNumarasiRepository odaNumarasiRepository;
    private final KayitIslemleriRepository kayitIslemleriRepository;

    public RezervasyonDTO rezervasyonIslemleri(RezervasyonDTO newRezervasyon, OdaNumarasi odaNumarasiData){
        Rezervasyon rezervasyon = modelMapper.map(newRezervasyon, Rezervasyon.class);
        rezervasyon.setOdaNumarasi(odaNumarasiData);

        Rezervasyon savedRezervasyon = rezervasyonRepository.save(rezervasyon);

        RezervasyonDTO responseData = modelMapper.map(savedRezervasyon, RezervasyonDTO.class);
        modelMapper.map(savedRezervasyon, responseData);

        return responseData;

    }

    public CikisIslemiDTO rezerbasyonKaldir(Integer odaNumarasi){
        OdaNumarasi odaNumarasiData = odaNumarasiService.cikisIslemiKontrol(odaNumarasi);

        try {
            Optional<OdaIslemleri> sonOdaIslemiOptional = kayitIslemleriRepository.findTopByOdaNumarasiOrderByCreateDateDesc(odaNumarasiData);
            if (!sonOdaIslemiOptional.isPresent()){
                throw new RuntimeException("Bu oda numarasi için kayit bulunmamaktadir");
            }
            OdaIslemleri cikisIslemleri = sonOdaIslemiOptional.get();

            odaNumarasiData.setDolumu(0);
            odaNumarasiRepository.save(odaNumarasiData);

            CikisIslemiDTO cikisIslemiDTO = new CikisIslemiDTO();
            return cikisIslemiDTO;

        } catch (RuntimeException e){
            throw new RuntimeException("Rezervasyon kaldirma işlemi sıraısnda bir hata oluştu " + e.getMessage());
        }
    }


}

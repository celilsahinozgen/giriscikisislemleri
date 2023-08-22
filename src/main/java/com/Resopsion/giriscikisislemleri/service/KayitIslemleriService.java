package com.Resopsion.giriscikisislemleri.service;


import com.Resopsion.giriscikisislemleri.dto.KayitIslemleriDTO;
import com.Resopsion.giriscikisislemleri.model.OdaIslemleri;
import com.Resopsion.giriscikisislemleri.model.OdaNumarasi;
//import com.Resopsion.giriscikisislemleri.model.SinifFiyatlandirmaYEDEKENUM;
import com.Resopsion.giriscikisislemleri.model.SinifveFiyatlandirma;
import com.Resopsion.giriscikisislemleri.repository.OdaNumarasiRepository;
import com.Resopsion.giriscikisislemleri.repository.KayitIslemleriRepository;
import com.Resopsion.giriscikisislemleri.repository.SinifveFiyatlandirmaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KayitIslemleriService {

    private final ModelMapper modelMapper;
    private final KayitIslemleriRepository kayitIslemleriRepository;
    private final SinifFiyatlandirmaService sinifFiyatlandirmaService;
    private final OdaNumarasiRepository odaNumarasiRepository;
    private final SinifveFiyatlandirmaRepository sinifveFiyatlandirmaRepository; // Bu repository'yi enjekte ettiğinizi varsayıyorum



    public KayitIslemleriDTO createUser(KayitIslemleriDTO userCreateDTO, Integer odaNumarasi) {
        OdaNumarasi odaNumarasiData = odaNumarasiRepository.findByOdaNumarasi(odaNumarasi)
                .orElseThrow(() -> new RuntimeException("Bu oda numarası bulunmamaktadır"));
        Integer dolumu = odaNumarasiData.getDolumu(); // odaNumarasiData nesnesinden dolumu alanını alıyoruz

        if (dolumu != null && dolumu == 1) {
            throw new RuntimeException("Giris işlemi oluşturulamadı !!! ZATEN DOLU");
        }


        // sinifTipi değerini DTO'dan al
        String sinifTipiAdi = userCreateDTO.getSinifTipi();

        // Bu isimle eşleşen SinifveFiyatlandirma nesnesini bul
        SinifveFiyatlandirma sinifTipi = (SinifveFiyatlandirma) sinifveFiyatlandirmaRepository.findBySinifAdi(sinifTipiAdi)
                .orElseThrow(() -> new RuntimeException("Bu sınıf tipi bulunmamaktadır"));

        OdaIslemleri user = modelMapper.map(userCreateDTO, OdaIslemleri.class);
        user.setOdaNumarasi(odaNumarasiData);

        // SinifveFiyatlandirma nesnesini User nesnesine ayarla
        user.setSinifTipi(sinifTipi);

        return modelMapper.map(kayitIslemleriRepository.save(user), KayitIslemleriDTO.class);
    }






}


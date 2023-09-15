package com.Resopsion.giriscikisislemleri.service;

import com.Resopsion.giriscikisislemleri.dto.HesapOzetDTO;
import com.Resopsion.giriscikisislemleri.model.OdaIslemleri;
import com.Resopsion.giriscikisislemleri.model.OdaNumarasi;
import com.Resopsion.giriscikisislemleri.repository.KayitIslemleriRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HesapOzetService {

    private final ModelMapper modelMapper;
    private final KayitIslemleriRepository kayitIslemleriRepository;
    private SinifFiyatlandirmaService sinifFiyatlandirmaService;
    private final  OdaNumarasiService odaNumarasiService;

    public HesapOzetDTO hesapOzetHesapla(Integer odaNumarasi) {
        OdaNumarasi odaNumarasiData = odaNumarasiService.hesapOzetKontrol(odaNumarasi);

        try {
            Optional<OdaIslemleri> sonOdaIslemiOptional = kayitIslemleriRepository.findTopByOdaNumarasiOrderByCreateDateDesc(odaNumarasiData);

            if (!sonOdaIslemiOptional.isPresent()){
                throw  new RuntimeException("Bu oda numarasi için kayit yok");
            }
            OdaIslemleri cikisIslemleri = sonOdaIslemiOptional.get();

            LocalDateTime girisTarihi = cikisIslemleri.getCikisTarihi();
            LocalDateTime cikisTarihi = LocalDateTime.now();


            long gunSayisi = ChronoUnit.DAYS.between(girisTarihi, cikisTarihi);
            String sinifTipi = cikisIslemleri.getSinifTipi().getSinifAdi();
            int fiyatCarpani = sinifFiyatlandirmaService.getFiyat(sinifTipi);
            Integer hesaplananDeger = (int) gunSayisi * fiyatCarpani;

            HesapOzetDTO hesapOzetDTO = new HesapOzetDTO();
            hesapOzetDTO.setHesaplananDeger(hesaplananDeger);

            return hesapOzetDTO;
        }
        catch (RuntimeException e) {
            throw  new RuntimeException("Hesap özet hesaplanmadı: " + e.getMessage());
        }

    }
}

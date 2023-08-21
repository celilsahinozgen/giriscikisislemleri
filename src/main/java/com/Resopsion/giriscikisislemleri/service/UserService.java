package com.Resopsion.giriscikisislemleri.service;


import com.Resopsion.giriscikisislemleri.config.OdaNumarasiConverter;
import com.Resopsion.giriscikisislemleri.dto.CikisIslemiDTO;
import com.Resopsion.giriscikisislemleri.dto.UserCreateDTO;
import com.Resopsion.giriscikisislemleri.model.OdaNumarasiData;
import com.Resopsion.giriscikisislemleri.model.SinifFiyatlandirma;
//import com.Resopsion.giriscikisislemleri.model.SinifFiyatlandirmaYEDEKENUM;
import com.Resopsion.giriscikisislemleri.model.User;
import com.Resopsion.giriscikisislemleri.repository.OdaNumarasiRepository;
import com.Resopsion.giriscikisislemleri.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final SinifFiyatlandirmaService sinifFiyatlandirmaService;
    private final OdaNumarasiRepository odaNumarasiRepository;




    public UserCreateDTO createUser(UserCreateDTO userCreateDTO, Integer odaNumarasi) {
        OdaNumarasiData odaNumarasiData = odaNumarasiRepository.findByOdaNumarasi(odaNumarasi)
                .orElseThrow(() -> new RuntimeException("Bu oda numarası bulunmamaktadır"));
        Integer dolumu = odaNumarasiData.getDolumu(); // odaNumarasiData nesnesinden dolumu alanını alıyoruz

        if (dolumu != null && dolumu == 1) {
            throw new RuntimeException("Giris işlemi oluşturulamadı !!! ZATEN DOLU");
        }

        User user = modelMapper.map(userCreateDTO, User.class);
        user.setOdaNumarasi(odaNumarasiData); // odaNumarasiData nesnesini User nesnesine ayarlıyoruz

        // Kullanıcının sınıf tipini DTO'dan al
        user.setSinifTipi(userCreateDTO.getSinifTipi());

        return modelMapper.map(userRepository.save(user), UserCreateDTO.class);
    }





    public CikisIslemiDTO cikisIslemi(Integer odaNumarasi, CikisIslemiDTO cikisIslemiDTO) {
        Optional<User> optionalUser = userRepository.findByOdaNumarasi(odaNumarasi);

        if (!optionalUser.isPresent()) {
            throw new RuntimeException("Bu oda numarası bulunmamaktadır");
        }

        User user = optionalUser.get();

        LocalDateTime createDate = user.getCreateDate();
        LocalDateTime cikisTarihi = cikisIslemiDTO.getCikisTarihi();

        if (cikisTarihi.getHour() >= 10) {
            cikisTarihi = cikisTarihi.plusDays(1);
        }

        long gunSayisi = ChronoUnit.DAYS.between(createDate, cikisTarihi);

        // Sınıf tipini User nesnesinden al
        String sinifTipi = user.getSinifTipi();

        // İlgili sınıf tipine göre fiyatlandırma değerini servisten al
        int fiyatCarpani = sinifFiyatlandirmaService.getFiyat(sinifTipi);

        // Gün sayısını fiyat çarpanı ile çarp
        int hesaplananDeger = (int) gunSayisi * fiyatCarpani;

        cikisIslemiDTO.setHesaplananDeger(hesaplananDeger);

        user.setCikisTarihi(cikisIslemiDTO.getCikisTarihi());
        return modelMapper.map(userRepository.save(user), CikisIslemiDTO.class);
    }
}

/*   BURADAK ISLEMLER ENUM KULLANIRSAM DİE VAR
 // Kayıt tarihi ve çıkış tarihi arasındaki gün sayısını hesapla
        LocalDateTime createDate = user.getCreateDate();
        LocalDateTime cikisTarihi = cikisIslemiDTO.getCikisTarihi();

        if (cikisTarihi.getHour() >= 10) {
            cikisTarihi = cikisTarihi.plusDays(1);
        }

        long gunSayisi = ChronoUnit.DAYS.between(createDate, cikisTarihi);

// Sınıf tipini User nesnesinden al
        String sinifTipi = user.getSinifTipi();

// Enum'dan ilgili değeri almak için
        SinifFiyatlandirmaYEDEKENUM sinifFiyatlandirma = SinifFiyatlandirmaYEDEKENUM.valueOf(sinifTipi);

// İlgili sınıf tipine göre fiyatlandırma değerini al
        int fiyatCarpani = sinifFiyatlandirma.getFiyat();

// Gün sayısını fiyat çarpanı ile çarp
        int hesaplananDeger = (int) gunSayisi * fiyatCarpani;

        cikisIslemiDTO.setHesaplananDeger(hesaplananDeger);

        user.setCikisTarihi(cikisIslemiDTO.getCikisTarihi());
        return modelMapper.map(userRepository.save(user), CikisIslemiDTO.class);
 */
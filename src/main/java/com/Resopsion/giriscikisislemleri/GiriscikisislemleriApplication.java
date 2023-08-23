package com.Resopsion.giriscikisislemleri;

import com.Resopsion.giriscikisislemleri.model.OdaNumarasi;
import com.Resopsion.giriscikisislemleri.model.SinifveFiyatlandirma;
import com.Resopsion.giriscikisislemleri.repository.OdaNumarasiRepository;
import com.Resopsion.giriscikisislemleri.repository.SinifveFiyatlandirmaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GiriscikisislemleriApplication {

	public static void main(String[] args) {
		SpringApplication.run(GiriscikisislemleriApplication.class, args);
	}


	@Bean
	public CommandLineRunner initData(OdaNumarasiRepository odaNumarasiRepository, SinifveFiyatlandirmaRepository sinifveFiyatlandirmaRepository) {
		return (args) -> {

			OdaNumarasi oda1 = new OdaNumarasi();
			oda1.setId(1L);
			oda1.setOdaNumarasi(101);
			oda1.setDolumu(0);

			OdaNumarasi oda2 = new OdaNumarasi();
			oda2.setId(2L);
			oda2.setOdaNumarasi(102);
			oda2.setDolumu(0);

			OdaNumarasi oda3 = new OdaNumarasi();
			oda2.setId(3L);
			oda2.setOdaNumarasi(10);
			oda2.setDolumu(1);

			odaNumarasiRepository.save(oda1);
			odaNumarasiRepository.save(oda2);

			// SinifveFiyatlandirma örnekleri
			SinifveFiyatlandirma sinif1 = new SinifveFiyatlandirma();
			sinif1.setSinifAdi("ASINIFI");
			sinif1.setFiyat(100);

			SinifveFiyatlandirma sinif2 = new SinifveFiyatlandirma();
			sinif2.setSinifAdi("BSINIFI");
			sinif2.setFiyat(200);

			sinifveFiyatlandirmaRepository.save(sinif1);
			sinifveFiyatlandirmaRepository.save(sinif2);


		};
	}
}

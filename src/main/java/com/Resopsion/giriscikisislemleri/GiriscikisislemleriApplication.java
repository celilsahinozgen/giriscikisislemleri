package com.Resopsion.giriscikisislemleri;

import com.Resopsion.giriscikisislemleri.model.OdaNumarasi;
import com.Resopsion.giriscikisislemleri.model.SinifveFiyatlandirma;
import com.Resopsion.giriscikisislemleri.repository.OdaNumarasiRepository;
import com.Resopsion.giriscikisislemleri.repository.SinifveFiyatlandirmaRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "GirisCikisIlslemleri Project",
				version = "1.0.0",
				description = "Resepsion Projesidir",
				termsOfService = "runcodenow",
				contact = @Contact(
						name = "Celil",
						email = "celilsahinozgen@gmail.com"),
				license = @License(
						name = "licence",
						url = "runcodenow"
				)
		)
)
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
			oda3.setId(3L);
			oda3.setOdaNumarasi(103);
			oda3.setDolumu(1);

			odaNumarasiRepository.save(oda1);
			odaNumarasiRepository.save(oda2);
			odaNumarasiRepository.save(oda3);


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
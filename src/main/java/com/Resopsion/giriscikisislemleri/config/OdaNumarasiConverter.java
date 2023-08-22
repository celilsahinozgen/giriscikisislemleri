package com.Resopsion.giriscikisislemleri.config;

import com.Resopsion.giriscikisislemleri.model.OdaNumarasi;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

public class OdaNumarasiConverter implements Converter<OdaNumarasi, Integer> {
    @Override
    public Integer convert(MappingContext<OdaNumarasi, Integer> context) {
        // Context'ten kaynak nesneyi alır
        OdaNumarasi odaNumarasi = context.getSource();

        // Kaynak nesne null değilse, dolumu değerini döndür
        // Aksi takdirde, null döndür
        return odaNumarasi != null ? odaNumarasi.getDolumu() : null;
    }
}

package com.Resopsion.giriscikisislemleri.config;

import com.Resopsion.giriscikisislemleri.model.OdaNumarasiData;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

public class OdaNumarasiConverter implements Converter<OdaNumarasiData, Integer> {
    @Override
    public Integer convert(MappingContext<OdaNumarasiData, Integer> context) {
        // Context'ten kaynak nesneyi alır
        OdaNumarasiData odaNumarasiData = context.getSource();

        // Kaynak nesne null değilse, dolumu değerini döndür
        // Aksi takdirde, null döndür
        return odaNumarasiData != null ? odaNumarasiData.getDolumu() : null;
    }
}

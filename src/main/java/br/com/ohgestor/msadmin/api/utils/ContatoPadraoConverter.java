package br.com.ohgestor.msadmin.api.utils;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Converter;

@Converter
public class ContatoPadraoConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String atributo) {
        return atributo != null ? padraoContato(atributo) : null;
    }

    @Override
    public String convertToEntityAttribute(String data) {
        return data != null ? padraoContato(data) : null; // Pode ajustar se quiser outro formato na entidade
    }

    public String padraoContato(String atributo) {
        // Remove todos os caracteres que não sejam dígitos
        return atributo.replaceAll("[^0-9]", "").trim();
    }
}

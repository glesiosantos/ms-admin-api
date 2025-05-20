package br.com.ohgestor.msadmin.api.conversores;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class DocumentoConversor implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String atributo) {
        return atributo != null ? limparFormatacao(atributo) : null;
    }

    @Override
    public String convertToEntityAttribute(String atributo) {
        return atributo != null ? limparFormatacao(atributo) : null;
    }

    private String limparFormatacao(String documento) {
        String doc = documento.replaceAll("[\\.\\-/]", "").trim();
        return doc;
    }
}
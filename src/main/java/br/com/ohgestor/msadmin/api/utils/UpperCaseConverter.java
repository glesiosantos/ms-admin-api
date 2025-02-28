package br.com.ohgestor.msadmin.api.utils;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;

@Convert
public class UpperCaseConverter implements AttributeConverter<String, String> {
    @Override
    public String convertToDatabaseColumn(String atribute) {
        return atribute != null ? atribute.toUpperCase() : null;
    }

    @Override
    public String convertToEntityAttribute(String data) {
        return data != null ? data.toUpperCase() : null;
    }
}

package br.com.ohgestor.msadmin.api.utils;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;

@Convert
public class ContatoPadraoConverter implements AttributeConverter<String, String> {
    @Override
    public String convertToDatabaseColumn(String atribute) {
        return atribute != null ? padraoContato(atribute) : null;
    }

    @Override
    public String convertToEntityAttribute(String data) {
        return data != null ? padraoContato(data) : null;
    }

    public String padraoContato(String atributo) {
        var contato = atributo.replace("(","")
                .replace(")","")
                .replace(".", "")
                .replace(" ", "").trim();
        return String.format("+55%s", contato);
    }
}

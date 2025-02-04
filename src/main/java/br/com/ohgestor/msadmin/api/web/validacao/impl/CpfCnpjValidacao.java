package br.com.ohgestor.msadmin.api.web.validacao.impl;

import br.com.ohgestor.msadmin.api.web.validacao.CpfCnpj;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

public class CpfCnpjValidacao implements ConstraintValidator<CpfCnpj, String> {

    @Override
    public void initialize(CpfCnpj constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        if(value == null || value.trim().isEmpty()) {
            return true;
        }

        String document = value.replaceAll("[^0-9]", ""); // Remover caracteres não numéricos

        if (document.length() == 11) {
            return isValidCpf(document);
        } else if (document.length() == 14) {
            return isValidCnpj(document);
        }

        return false;
    }

    private boolean isValidCnpj(String cnpj) {
        try {
            CNPJ.class.getDeclaredMethod("validate", String.class).invoke(null, cnpj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isValidCpf(String cpf) {
        try {
            CPF.class.getDeclaredMethod("validate", String.class).invoke(null, cpf);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

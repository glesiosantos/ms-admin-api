package br.com.ohgestor.msadmin.api.web.validators;

import br.com.ohgestor.msadmin.api.utils.BR;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

public class CPFouCNPJValidation implements ConstraintValidator<CPFouCNPJ, String> {

    @Override
    public void initialize(CPFouCNPJ constraintAnnotation) {}

    @Override
    public boolean isValid(String documento, ConstraintValidatorContext context) {
        System.out.println("********** ********** "+documento);
        if(!StringUtils.hasText(documento)) return false;
        return BR.isValidCPF(documento) || BR.isValidCNPJ(documento);
    }
}
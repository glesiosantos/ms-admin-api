package br.com.ohgestor.msadmin.api.web.validacao;

import br.com.ohgestor.msadmin.api.web.validacao.impl.CpfCnpjValidacao;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CpfCnpjValidacao.class)
public @interface CpfCnpj {
    String message() default "Documento CPF ou CNPJ inválido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

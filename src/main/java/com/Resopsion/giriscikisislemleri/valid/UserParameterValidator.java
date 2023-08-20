package com.Resopsion.giriscikisislemleri.valid;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component

public class UserParameterValidator implements ConstraintValidator<UserNameConstraint, String> {


    @Override
    public void initialize(UserNameConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        // Sayı içerip içermediğini kontrol etmek için bir düzenli ifade kullanırız.
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(value);

        // Eğer değerde bir sayı bulursa, false döneriz.
        if (matcher.find()) {
            return false;
        }

        // Değerin boş olup olmadığını kontrol ederiz.
        boolean isValid = value != null && !value.trim().isEmpty();

        return isValid;
    }
}

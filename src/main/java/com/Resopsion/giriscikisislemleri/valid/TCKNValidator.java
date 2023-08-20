package com.Resopsion.giriscikisislemleri.valid;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class TCKNValidator implements ConstraintValidator<TCKNConstraint, String> {

    @Override
    public void initialize(TCKNConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }


    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null || value.length() != 11 || value.charAt(0) == '0') {
            return false;
        }

        int[] numbers = value.chars().map(Character::getNumericValue).toArray();

        int sumOdd = numbers[0] + numbers[2] + numbers[4] + numbers[6] + numbers[8];
        int sumEven = numbers[1] + numbers[3] + numbers[5] + numbers[7];
        int sumFirst10 = numbers[0] + numbers[1] + numbers[2] + numbers[3] + numbers[4] + numbers[5] + numbers[6] + numbers[7] + numbers[8] + numbers[9];

        // İlk 10 hane üzerindeki algoritma kontrolü
        if ((sumOdd * 7 - sumEven) % 10 != numbers[9] || sumFirst10 % 10 != numbers[10]) {
            return false;
        }

        return true;
    }

}

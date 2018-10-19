package com.sw.urs.validator;

import com.sw.urs.constraint.Phone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * 手机号校验实现类
 */
public class PhoneValidator implements ConstraintValidator<Phone,String> {
    // 手机号校验正则
    private Pattern pattern = Pattern.compile("1(([38]\\d)|(5[^4&&\\d])|(4[579])|(7[0135678]))\\d{8}");

    @Override
    public void initialize(Phone constraintAnnotation) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return pattern.matcher(s).matches();
    }
}

package com.imooc.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {

    //    you can autowired service here
    @Override
    public void initialize(MyConstraint myConstraint) {
        System.out.println("Custom Validator Init.");
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println(String.format("Validate %s", value));
        return false;
    }
}

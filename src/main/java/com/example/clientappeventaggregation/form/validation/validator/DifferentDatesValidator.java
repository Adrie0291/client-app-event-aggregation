package com.example.clientappeventaggregation.form.validation.validator;

import com.example.clientappeventaggregation.form.CreateRangeDateForm;
import com.example.clientappeventaggregation.form.validation.constraint.DifferentDates;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DifferentDatesValidator implements ConstraintValidator<DifferentDates, CreateRangeDateForm> {

    @Override
    public void initialize(DifferentDates constraint) {
    }

    @Override
    public boolean isValid(CreateRangeDateForm form, ConstraintValidatorContext context) {
        return form.getFromDateTime().isBefore(form.getToDateTime());
    }
}
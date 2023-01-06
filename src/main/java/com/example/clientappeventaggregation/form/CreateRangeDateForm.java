package com.example.clientappeventaggregation.form;

import com.example.clientappeventaggregation.form.validation.constraint.DifferentDates;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
@ToString
@Getter
@Setter
@DifferentDates(message ="[Incorrect dates. Date FROM must be before date TO]")
public class CreateRangeDateForm {
    private LocalDateTime fromDateTime;
    private LocalDateTime toDateTime;
}

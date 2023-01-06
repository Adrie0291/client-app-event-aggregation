package com.example.clientappeventaggregation.controller;

import com.example.clientappeventaggregation.form.CreateRangeDateForm;
import com.example.clientappeventaggregation.service.EventCustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/event")
public class EventCustomerController {

    private final EventCustomerService eventCustomerService;

    @GetMapping("/future")
    public String getAll(ModelMap modelMap) {
        modelMap.addAttribute("events", eventCustomerService.getEvent());
        modelMap.addAttribute("rangeDate", new CreateRangeDateForm());
        return "list-event";
    }

    @PostMapping("/date")
    public String getAllEvent(@ModelAttribute("rangeDate") @Valid CreateRangeDateForm form, Errors errors, ModelMap map) {
        if (errors.hasErrors()) {
            return "list-event";
        } else {
            map.addAttribute("events", eventCustomerService.getEventByDateByParametr(form.getFromDateTime(), form.getToDateTime()));
            return "list-event";
        }
    }
}
package com.neoflex.vacationcalculator.controller;

import com.neoflex.vacationcalculator.service.impl.VacationServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VacationController {
    private final VacationServiceImpl vacationService;

    public VacationController(VacationServiceImpl vacationService) {
        this.vacationService = vacationService;
    }

    @GetMapping(value = "/calculate")
    public ResponseEntity<?> displayAllEvents(
            @RequestParam(value = "averageSalary") String averageSalary,
            @RequestParam(value = "daysInVacation") String amountOfDaysInVacation) {
        return vacationService.calculateVacationLength(averageSalary,amountOfDaysInVacation);
    }

}

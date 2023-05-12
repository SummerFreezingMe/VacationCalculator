package com.neoflex.vacationcalculator.service;

import org.springframework.http.ResponseEntity;

public interface VacationService {

    ResponseEntity<?> calculateVacationLength(String averageSalaryString, String amountOfDaysString);
}

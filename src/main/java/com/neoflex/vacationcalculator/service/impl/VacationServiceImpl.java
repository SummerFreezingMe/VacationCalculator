package com.neoflex.vacationcalculator.service.impl;

import com.neoflex.vacationcalculator.service.VacationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VacationServiceImpl implements VacationService {
    @Override
    public ResponseEntity<?> calculateVacationLength(String averageSalaryString, String amountOfDaysString) {
        double averageSalary;
        int amountOfDays;
        try {
            averageSalary = Double.parseDouble(averageSalaryString);
            amountOfDays = Integer.parseInt(amountOfDaysString);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Error! Wrong Argument Format Provided",HttpStatus.BAD_REQUEST);
        }
        if (averageSalary < 0 || amountOfDays < 0) {
            return new ResponseEntity<>("Error! Negative Argument Provided",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(averageSalary*amountOfDays, HttpStatus.OK);
    }
    }

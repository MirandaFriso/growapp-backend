package com.mirran.growappbackend.controller;

import com.mirran.growappbackend.model.Month;
import com.mirran.growappbackend.repository.MonthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000") //För React app
@RestController
@RequestMapping("/growapp") //Behövs denna?
public class MonthController {

    @Autowired
    MonthRepository monthRepository;

    @GetMapping("/months")
    public List<Month> getMonths() {
        return this.monthRepository.findAll();
    }
}


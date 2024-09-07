package com.example.demo.controller;

import com.example.demo.model.CountryModel;
import com.example.demo.service.CountryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/goods/country")
public class CountryApiController {
    @Autowired
    private final CountryService countryService;

    public CountryApiController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<CountryModel> getAllCountries() {
        return countryService.findAllCountries();
    }

    @PostMapping
    public CountryModel createCountry(@RequestBody CountryModel countryModel) {
        return countryService.createCountry(countryModel);
    }

    @DeleteMapping
    public void deleteCountry(@RequestBody CountryModel countryModel) {
        countryService.deleteCountry(countryModel.getId());
    }
}

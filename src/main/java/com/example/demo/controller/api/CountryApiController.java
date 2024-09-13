package com.example.demo.controller.api;

import com.example.demo.model.CodeModel;
import com.example.demo.model.CountryModel;
import com.example.demo.service.CountryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/country")
public class CountryApiController {


    private final CountryService countryService;

    public CountryApiController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<CountryModel> getAllCountries() {
        return countryService.findAllCountries();
    }

    @GetMapping("/{id}")
    public CountryModel getCountryById(@PathVariable Long id) {
        return countryService.findCountryById(id);
    }

    @PostMapping
    public CountryModel createCountry(@Valid @RequestBody CountryModel country) {
        return countryService.createCountry(country);
    }
    @PutMapping("/{id}")
    public CountryModel updateCountry(@PathVariable Long id, @Valid @RequestBody CountryModel country) {
        country.setId(id);
        return countryService.updateCountry(country);
    }

    @DeleteMapping("/{id}")
    public void deleteCountry(@PathVariable Long id) {
        countryService.deleteCountry(id);
    }
}

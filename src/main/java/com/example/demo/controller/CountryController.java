package com.example.demo.controller;

import com.example.demo.model.CountryModel;
import com.example.demo.service.CountryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    public String getAllCountries(Model model) {
        List<CountryModel> countries = countryService.findAllCountries();
        model.addAttribute("countries", countries);
        model.addAttribute("country", new CountryModel());
        return "CountryList";
    }

    @PostMapping("/countries")
    public String createCountry(@Valid @ModelAttribute CountryModel country, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<CountryModel> countryModels = countryService.findAllCountries();
            model.addAttribute("country", country);
            model.addAttribute("countries", countryModels);
            return "CountryList";
        }
        countryService.createCountry(country);
        return "redirect:/countries";
    }

    @GetMapping("/countries/edit/{id}")
    public String editCountry(@PathVariable Long id, Model model) {
        CountryModel country = countryService.findCountryById(id);
        model.addAttribute("country", country);
        return "editCountry";
    }

    @PostMapping("/countries/update")
    public String updateCountry(@Valid @ModelAttribute CountryModel country, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<CountryModel> countryModels = countryService.findAllCountries();
            model.addAttribute("country", country);
            model.addAttribute("countries", countryModels);
            return "CountryList";
        }
        countryService.updateCountry(country);
        return "redirect:/countries";
    }

    @GetMapping("/countries/delete/{id}")
    public String deleteCountry(@PathVariable Long id) {
        countryService.deleteCountry(id);
        return "redirect:/countries";
    }


}

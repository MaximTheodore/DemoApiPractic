package com.example.demo.controller;

import com.example.demo.model.CountryModel;
import com.example.demo.model.SupplierModel;
import com.example.demo.service.CountryService;
import com.example.demo.service.SupplierService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SupplierController {
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private CountryService countryService;
    @GetMapping("/suppliers")
    public String getAllSuppliers(Model model) {
        List<SupplierModel> suppliers = supplierService.findAllSuppliers();
        List<CountryModel> countries = countryService.findAllCountries();

        model.addAttribute("suppliers", suppliers);
        model.addAttribute("countries", countries);
        model.addAttribute("supplier", new SupplierModel());

        return "SupplierList";
    }


    @PostMapping("/suppliers")
    public String createSupplier(@Valid @ModelAttribute SupplierModel supplier, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<SupplierModel> supplierModels = supplierService.findAllSuppliers();
            List<CountryModel> countries = countryService.findAllCountries();

            model.addAttribute("supplier", supplier);
            model.addAttribute("suppliers", supplierModels);
            model.addAttribute("countries", countries);

            return "SupplierList";
        }
        supplierService.createSupplier(supplier);
        return "redirect:/suppliers";
    }


    @GetMapping("/suppliers/edit/{id}")
    public String editSupplier(@PathVariable Long id, Model model) {
        SupplierModel supplier = supplierService.findSupplierById(id);
        List<CountryModel> countries = countryService.findAllCountries();

        model.addAttribute("supplier", supplier);
        model.addAttribute("countries", countries);

        return "editSupplier";
    }


    @PostMapping("/suppliers/update")
    public String updateSupplier(@Valid @ModelAttribute SupplierModel supplier, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<SupplierModel> supplierModels = supplierService.findAllSuppliers();
            model.addAttribute("supplier", supplier);
            model.addAttribute("suppliers", supplierModels);

            List<CountryModel> countries = countryService.findAllCountries();
            model.addAttribute("countries", countries);

            return "SupplierList";
        }
        supplierService.updateSupplier(supplier);
        return "redirect:/suppliers";
    }

    @GetMapping("/suppliers/delete/{id}")
    public String deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
        return "redirect:/suppliers";
    }


}

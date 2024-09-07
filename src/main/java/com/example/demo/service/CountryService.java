package com.example.demo.service;

import com.example.demo.model.CountryModel;

import java.util.List;

public interface CountryService {
    public List<CountryModel> findAllCountries();
    public CountryModel findCountryById(Long id);
    public CountryModel createCountry(CountryModel countryModel);
    public CountryModel updateCountry(CountryModel countryModel);
    public void deleteCountry(Long id);


}

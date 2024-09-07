package com.example.demo.service;

import com.example.demo.model.CountryModel;
import com.example.demo.repository.CountryRepository;
import com.example.demo.repository.InMemoryCountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class inMemoryCountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    @Autowired
    public inMemoryCountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<CountryModel> findAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public CountryModel findCountryById(Long id) {
        return countryRepository.findById(id).orElse(null);
    }

    @Override
    public CountryModel createCountry(CountryModel countryModel) {
        return countryRepository.save(countryModel);
    }

    @Override
    public CountryModel updateCountry(CountryModel countryModel) {
        return countryRepository.save(countryModel);
    }

    @Override
    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }


}

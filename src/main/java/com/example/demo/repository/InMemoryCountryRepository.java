package com.example.demo.repository;


import com.example.demo.model.CountryModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository
public class InMemoryCountryRepository {
    private final List<CountryModel> COUNTRY = new ArrayList<>();

    public CountryModel createCountry(CountryModel countryModel){
        COUNTRY.add(countryModel);
        return countryModel;
    }
    public CountryModel updateCountry(CountryModel countryModel){
        int countryIndex = IntStream.range(0, COUNTRY.size())
                .filter(index -> COUNTRY.get(index).getId() == countryModel.getId())
                .findFirst()
                .orElse(-1);

        return countryIndex == -1 ? null : COUNTRY.set(countryIndex, countryModel);
    }

    public List<CountryModel> findAllCountries() {
        return COUNTRY.stream().filter(countryModel -> !countryModel.isDeleted())
                .collect(Collectors.toList());
    }
    public CountryModel findCountryById(Long id){
        return COUNTRY.stream()
                .filter(countryModel -> countryModel.getId() == id)
                .findFirst()
                .orElse(null);
    }
    public void deleteCountry(Long id){
        var countryModel = findCountryById(id);
        if (countryModel != null) {
            COUNTRY.remove(countryModel);
        }
    }

}

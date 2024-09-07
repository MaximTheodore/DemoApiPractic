package com.example.demo.repository;

import com.example.demo.model.GoodsModel;
import com.example.demo.model.SupplierModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository
public class InMemorySupplierRepository {
    private final List<SupplierModel> SUPPLIER = new ArrayList<>();

    public SupplierModel createSupplier(SupplierModel supplierModel){

        SUPPLIER.add(supplierModel);
        return supplierModel;
    }
    public SupplierModel updateSupplier(SupplierModel supplierModel){
        int supplierIndex = IntStream.range(0, SUPPLIER.size())
                .filter(index -> SUPPLIER.get(index).getId() == supplierModel.getId())
                .findFirst()
                .orElse(-1);

        return supplierIndex == -1 ? null : SUPPLIER.set(supplierIndex, supplierModel);
    }

    public List<SupplierModel> findAllSuppliers() {
        return SUPPLIER.stream().filter(supplierModel -> !supplierModel.isDeleted())
                .collect(Collectors.toList());
    }
    public SupplierModel findSupplierById(Long id){
        return SUPPLIER.stream()
                .filter(supplierModel -> supplierModel.getId() == id)
                .findFirst()
                .orElse(null);
    }
    public void deleteSupplier(Long id){
        var countryModel = findSupplierById(id);
        if (countryModel != null) {
            SUPPLIER.remove(countryModel);
        }
    }

}

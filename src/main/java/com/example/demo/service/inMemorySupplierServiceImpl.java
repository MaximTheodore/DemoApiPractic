package com.example.demo.service;

import com.example.demo.model.SupplierModel;
import com.example.demo.repository.InMemorySupplierRepository;
import com.example.demo.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class inMemorySupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;

    @Autowired
    public inMemorySupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<SupplierModel> findAllSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    public SupplierModel findSupplierById(Long id) {
        return supplierRepository.findById(id).orElse(null);
    }

    @Override
    public SupplierModel createSupplier(SupplierModel supplierModel) {
        return supplierRepository.save(supplierModel);
    }
    @Override
    public SupplierModel updateSupplier(SupplierModel supplierModel) {
        return supplierRepository.save(supplierModel);
    }
    @Override
    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }


}

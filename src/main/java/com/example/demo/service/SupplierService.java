package com.example.demo.service;

import com.example.demo.model.SupplierModel;

import java.util.List;

public interface SupplierService {
    public List<SupplierModel> findAllSuppliers();
    public SupplierModel findSupplierById(Long id);
    public SupplierModel createSupplier(SupplierModel supplierModel);
    public SupplierModel updateSupplier(SupplierModel supplierModel);
    public void deleteSupplier(Long id);

}

package com.example.demo.controller;

import com.example.demo.model.SupplierModel;
import com.example.demo.service.SupplierService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/goods/supplier")
public class SupplierApiController {
    @Autowired
    private final SupplierService supplierService;

    public SupplierApiController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping
    public List<SupplierModel> getAllSuppliers() {
        return supplierService.findAllSuppliers();
    }

    @PostMapping
    public SupplierModel createSupplier(@RequestBody SupplierModel supplierModel) {
        return supplierService.createSupplier(supplierModel);
    }

    @DeleteMapping
    public void deleteSupplier(@RequestBody SupplierModel supplierModel) {
        supplierService.deleteSupplier(supplierModel.getId());
    }
}

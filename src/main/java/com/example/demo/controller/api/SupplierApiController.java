package com.example.demo.controller.api;

import com.example.demo.model.CodeModel;
import com.example.demo.model.SupplierModel;
import com.example.demo.service.SupplierService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/supplier")
public class SupplierApiController {


    private final SupplierService supplierService;

    public SupplierApiController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping
    public List<SupplierModel> getAllSuppliers() {
        return supplierService.findAllSuppliers();
    }

    @GetMapping("/{id}")
    public SupplierModel getSupplierById(@PathVariable Long id) {
        return supplierService.findSupplierById(id);
    }

    @PostMapping
    public SupplierModel createSupplier(@Valid @RequestBody SupplierModel supplier) {
        return supplierService.createSupplier(supplier);
    }

    @PutMapping("/{id}")
    public SupplierModel updateSupplier(@PathVariable Long id,@Valid @RequestBody SupplierModel supplier) {
        supplier.setId(id);
        return supplierService.updateSupplier(supplier);
    }

    @DeleteMapping("/{id}")
    public void deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
    }
}

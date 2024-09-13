package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "country")
public class CountryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 2, max = 50, message = "Наименование страны от 2 до 50 символов")
    @NotBlank(message = "Введите навание страны")
    private String name;
    private boolean isDeleted = false;


    @OneToMany(mappedBy = "country")
    @JsonManagedReference
    private Collection<SupplierModel> suppliers;

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<SupplierModel> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Collection<SupplierModel> suppliers) {
        this.suppliers = suppliers;
    }
}

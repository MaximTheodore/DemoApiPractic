package com.example.demo.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.Collection;

@Entity
@Table(name = "goods")
public class GoodsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1, max = 50, message = "Название товара от 1 до 50 символов")
    @NotBlank(message = "Не заполнено название продукта")
    private String name;

    @DecimalMax(value = "10.0", message = "Максимальная цена товара 10.0")
    @DecimalMin(value = "0.1", message = "Минимальная цена товара 0.1")
    @Positive(message = "Цена не должна быть отрицательной")
    private double price;

    private boolean isDeleted = false;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonBackReference
    private CategoryModel category;

    @ManyToMany
    @JoinTable(
            name = "goods_supplier",
            joinColumns = @JoinColumn(name = "goods_id"),
            inverseJoinColumns = @JoinColumn(name = "supplier_id")

    )
    @JsonManagedReference
    private Collection<SupplierModel> suppliers;

    @OneToOne()
    @JoinColumn(name = "code_id")
    @JsonManagedReference
    private CodeModel code;


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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }

    public Collection<SupplierModel> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Collection<SupplierModel> suppliers) {
        this.suppliers = suppliers;
    }

    public CodeModel getCode() {
        return code;
    }

    public void setCode(CodeModel code) {
        this.code = code;
    }
}

package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "supplier")
public class SupplierModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 1, max = 50, message = "Название поставщика от 1 до 50 символов")
    @NotBlank(message = "Введить название поставщика")
    private String supplierName;
    @Size(min = 5, max = 50, message = "Адрес поставщика от 1 до 50 символов")
    @NotBlank(message = "Введить адрес поставщика")
    private String supplierAddress;
    @Size(min = 11, max = 11, message = "Телефон поставщика от 11 до 11 символов")
    @NotBlank(message = "Введить телефон поставщика")
    private String supplierPhone;
    @Size(min = 1, max = 50, message = "Почта поставщика от 1 до 50 символов")
    @NotBlank(message = "Введить почту поставщика")
    @Email(message = "Неправильно введена почта")
    private String supplierEmail;
    private boolean isDeleted = false;


    @ManyToOne
    @JoinColumn(name = "country_id")
    @JsonBackReference
    private CountryModel country;

    @ManyToMany(mappedBy = "suppliers")
    @JsonBackReference
    private Collection<GoodsModel> goods;

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public @Email(message = "Некорректный email") @NotBlank(message = "Email не должен быть пустым") String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(@Email(message = "Некорректный email") @NotBlank(message = "Email не должен быть пустым") String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }

    public String getSupplierPhone() {
        return supplierPhone;
    }

    public void setSupplierPhone(String supplierPhone) {
        this.supplierPhone = supplierPhone;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CountryModel getCountry() {
        return country;
    }

    public void setCountry(CountryModel country) {this.country = country;}

    public Collection<GoodsModel> getGoods() {return goods;}

    public void setGoods(Collection<GoodsModel> goods) {this.goods = goods;}
}

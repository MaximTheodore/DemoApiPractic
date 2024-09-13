package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "code")
public class CodeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 500, message = "Код товара должен быть не меньше 500")
    @Max(value = 100000, message = "Код товара должен быть не больше 100000")
    private Long name;

    private boolean isDeleted = false;


    @OneToOne(mappedBy = "code")
    @JsonBackReference
    private GoodsModel good;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getName() {
        return name;
    }

    public void setName(Long name) {
        this.name = name;
    }

    public boolean isDeleted() {return isDeleted;}

    public void setDeleted(boolean deleted) {isDeleted = deleted;}

    public GoodsModel getGood() {
        return good;
    }

    public void setGood(GoodsModel good) {
        this.good = good;
    }
}

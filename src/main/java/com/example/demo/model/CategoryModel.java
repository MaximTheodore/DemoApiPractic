package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "category")
public class CategoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 3, max = 50, message = "Название категории от3 до 50 символов")
    @NotBlank(message = "Необходимо ввести наименование категории")
    private String name;
    private boolean isDeleted = false;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private Collection<GoodsModel> goods;

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

    public Collection<GoodsModel> getGoods() {
        return goods;
    }

    public void setGoods(Collection<GoodsModel> goods) {
        this.goods = goods;
    }
}

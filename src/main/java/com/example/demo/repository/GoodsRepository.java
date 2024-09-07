package com.example.demo.repository;

import com.example.demo.model.GoodsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository extends JpaRepository<GoodsModel, Long> {
}

package com.example.demo.service;

import com.example.demo.model.GoodsModel;
import com.example.demo.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class inMemoryGoodsServiceImpl implements GoodsService {


    private final GoodsRepository goodsRepository;

    @Autowired
    public inMemoryGoodsServiceImpl(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    @Override
    public List<GoodsModel> findAllGoods() {
        return goodsRepository.findAll();
    }

    @Override
    public GoodsModel findGoodsById(Long id) {
        return goodsRepository.findById(id).orElse(null);
    }

    @Override
    public GoodsModel createGoods(GoodsModel goodsModel) {
        return goodsRepository.save(goodsModel);
    }

    @Override
    public GoodsModel updateGoods(GoodsModel goodsModel) {
        return goodsRepository.save(goodsModel);
    }

    @Override
    public void deleteGoods(Long id) {
        goodsRepository.deleteById(id);
    }



}

package com.example.demo.repository;


import com.example.demo.model.GoodsModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository
public class InMemoryGoodsRepository {

    private final List<GoodsModel> GOODS = new ArrayList<>();

    public GoodsModel createGoods(GoodsModel goodsModel){
        GOODS.add(goodsModel);
        return goodsModel;
    }
    public GoodsModel updateGoods(GoodsModel goodsModel){
        int goodsIndex = IntStream.range(0, GOODS.size())
                .filter(index -> GOODS.get(index).getId() == goodsModel.getId())
                .findFirst()
                .orElse(-1);

        return goodsIndex == -1 ? null : GOODS.set(goodsIndex, goodsModel);
    }

    public List<GoodsModel> findAllGoods() {
        return GOODS.stream().filter(goodsModel -> !goodsModel.isDeleted())
                .collect(Collectors.toList());
    }
    public GoodsModel findGoodsById(Long id){
        return GOODS.stream()
                .filter(goodsModel -> goodsModel.getId() == id)
                .findFirst()
                .orElse(null);
    }
    public void deleteGoods(Long id){
        var goodsModel = findGoodsById(id);
        if (goodsModel != null) {
            GOODS.remove(goodsModel);
        }
    }



}

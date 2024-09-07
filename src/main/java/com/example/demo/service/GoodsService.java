package com.example.demo.service;



import com.example.demo.model.GoodsModel;

import java.util.List;


public interface GoodsService {
    public List<GoodsModel> findAllGoods();
    public GoodsModel findGoodsById(Long id);
    public GoodsModel createGoods(GoodsModel goodsModel);
    public GoodsModel updateGoods(GoodsModel goodsModel);
    public void deleteGoods(Long id);


}

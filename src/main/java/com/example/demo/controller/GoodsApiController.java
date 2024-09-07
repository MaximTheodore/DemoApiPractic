package com.example.demo.controller;


import com.example.demo.model.GoodsModel;
import com.example.demo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/goods")
public class GoodsApiController {
    @Autowired
    private final GoodsService goodsService;
    public GoodsApiController(GoodsService goodsService) { this.goodsService = goodsService; }

    @GetMapping
    public List<GoodsModel> getAllGoods() {
        return goodsService.findAllGoods();
    }

    @PostMapping
    public GoodsModel createGoods(@RequestBody GoodsModel goodsModel) {
        return goodsService.createGoods(goodsModel);
    }

    @DeleteMapping
    public void deleteGoods(@RequestBody GoodsModel goodsModel) {
        goodsService.deleteGoods(goodsModel.getId());
        return;
    }

}

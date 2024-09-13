package com.example.demo.controller.api;

import com.example.demo.model.CodeModel;
import com.example.demo.model.GoodsModel;
import com.example.demo.service.GoodsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/goods")
public class GoodsApiController {


    private final GoodsService goodsService;

    public GoodsApiController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @GetMapping
    public List<GoodsModel> getAllGoods() {
        return goodsService.findAllGoods();
    }

    @GetMapping("/{id}")
    public GoodsModel getGoodsById(@PathVariable Long id) {
        return goodsService.findGoodsById(id);
    }

    @PostMapping
    public GoodsModel createGoods(@Valid @RequestBody GoodsModel goods) {
        return goodsService.createGoods(goods);
    }

    @PutMapping("/{id}")
    public GoodsModel updateGoods(@PathVariable Long id, @Valid @RequestBody GoodsModel goods) {
        goods.setId(id);
        return goodsService.updateGoods(goods);
    }

    @DeleteMapping("/{id}")
    public void deleteGoods(@PathVariable Long id) {
        goodsService.deleteGoods(id);
    }
}

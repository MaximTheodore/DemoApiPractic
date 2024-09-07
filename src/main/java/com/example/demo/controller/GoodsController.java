package com.example.demo.controller;



import com.example.demo.model.CategoryModel;
import com.example.demo.model.CodeModel;
import com.example.demo.model.GoodsModel;
import com.example.demo.model.SupplierModel;
import com.example.demo.service.CategoryService;
import com.example.demo.service.CodeService;
import com.example.demo.service.GoodsService;
import com.example.demo.service.SupplierService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GoodsController {


    @Autowired
    private GoodsService goodsService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private CodeService codeService;

    @GetMapping("/goods")
    public String getAllGoods(Model model) {
        List<GoodsModel> goods = goodsService.findAllGoods();
        List<CategoryModel> categories = categoryService.findAllCategories();
        List<SupplierModel> suppliers = supplierService.findAllSuppliers();
        List<CodeModel> codes = codeService.findAllCodes();

        model.addAttribute("goods", goods);
        model.addAttribute("good", new GoodsModel());
        model.addAttribute("categories", categories);
        model.addAttribute("suppliers", suppliers);
        model.addAttribute("codes", codes);

        return "GoodsList";
    }

    @PostMapping("/goods")
    public String createGoods(@Valid @ModelAttribute GoodsModel goods, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<GoodsModel> goodsModels = goodsService.findAllGoods();
            List<CategoryModel> categories = categoryService.findAllCategories();
            List<SupplierModel> suppliers = supplierService.findAllSuppliers();
            List<CodeModel> codes = codeService.findAllCodes();

            model.addAttribute("goods", goodsModels);
            model.addAttribute("categories", categories);
            model.addAttribute("suppliers", suppliers);
            model.addAttribute("codes", codes);
            model.addAttribute("good", goods);
            return "GoodsList";
        }
        goodsService.createGoods(goods);
        return "redirect:/goods";
    }

    @GetMapping("/goods/edit/{id}")
    public String editGoods(@PathVariable Long id, Model model) {
        GoodsModel good = goodsService.findGoodsById(id);
        List<CategoryModel> categories = categoryService.findAllCategories();
        List<SupplierModel> suppliers = supplierService.findAllSuppliers();
        List<CodeModel> codes = codeService.findAllCodes();

        model.addAttribute("good", good);
        model.addAttribute("categories", categories);
        model.addAttribute("suppliers", suppliers);
        model.addAttribute("codes", codes);

        return "editGoods";
    }

    @PostMapping("/goods/update")
    public String updateGoods(@Valid @ModelAttribute GoodsModel goods, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<CategoryModel> categories = categoryService.findAllCategories();
            List<SupplierModel> suppliers = supplierService.findAllSuppliers();
            List<CodeModel> codes = codeService.findAllCodes();

            model.addAttribute("categories", categories);
            model.addAttribute("suppliers", suppliers);
            model.addAttribute("codes", codes);
            model.addAttribute("good", goods);
            return "editGoods";
        }
        goodsService.updateGoods(goods);
        return "redirect:/goods";
    }

    @GetMapping("/goods/delete/{id}")
    public String deleteGoods(@PathVariable Long id) {
        goodsService.deleteGoods(id);
        return "redirect:/goods";
    }


}

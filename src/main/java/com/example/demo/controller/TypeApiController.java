package com.example.demo.controller;

import com.example.demo.model.CodeModel;
import com.example.demo.service.CodeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/goods/code")
public class TypeApiController {
    @Autowired
    private final CodeService codeService;

    public TypeApiController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping
    public List<CodeModel> getAllTypes() {
        return codeService.findAllCodes();
    }

    @PostMapping
    public CodeModel createType(@RequestBody CodeModel codeModel) {
        return codeService.createCode(codeModel);
    }

    @DeleteMapping
    public void deleteType(@RequestBody CodeModel codeModel) {
        codeService.deleteCode(codeModel.getId());
    }
}

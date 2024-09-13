package com.example.demo.controller.api;

import com.example.demo.model.CodeModel;
import com.example.demo.service.CodeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/code")
public class CodeApiController {
    private final CodeService codeService;
    public CodeApiController(CodeService codeService) {
        this.codeService = codeService;
    }
    @GetMapping
    public List<CodeModel> getAllCodes() {
        return codeService.findAllCodes();
    }

    @PostMapping
    public CodeModel createCode(@Valid @RequestBody CodeModel code) {
        return codeService.createCode(code);
    }

    @GetMapping("/{id}")
    public CodeModel getCodeById(@PathVariable Long id) {
        return codeService.findCodeById(id);
    }


    @PutMapping("/{id}")
    public CodeModel updateCode(@PathVariable Long id, @Valid @RequestBody CodeModel code) {
        code.setId(id);
        return codeService.updateCode(code);
    }

    @DeleteMapping("/{id}")
    public void deleteCode(@PathVariable Long id) {
        codeService.deleteCode(id);
    }
}

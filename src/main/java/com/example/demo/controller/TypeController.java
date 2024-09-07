package com.example.demo.controller;

import com.example.demo.model.CodeModel;
import com.example.demo.service.CodeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TypeController {
    @Autowired
    private CodeService codeService;

    @GetMapping("/codes")
    public String getAllTypes(Model model) {
        List<CodeModel> types = codeService.findAllCodes();
        model.addAttribute("codes", types);
        model.addAttribute("code", new CodeModel());
        return "CodeList";
    }

    @PostMapping("/codes")
    public String createType(@Valid @ModelAttribute CodeModel type, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<CodeModel> codeModels = codeService.findAllCodes();
            model.addAttribute("code", type);
            model.addAttribute("codes", codeModels);
            return "CodeList";
        }
        codeService.createCode(type);
        return "redirect:/codes";
    }

    @GetMapping("/codes/edit/{id}")
    public String editType(@PathVariable Long id, Model model) {
        CodeModel type = codeService.findCodeById(id);
        model.addAttribute("code", type);
        return "editCode";
    }

    @PostMapping("/codes/update")
    public String updateType(@Valid @ModelAttribute CodeModel type, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<CodeModel> codeModels = codeService.findAllCodes();
            model.addAttribute("code", type);
            model.addAttribute("codes", codeModels);
            return "CodeList";
        }
        codeService.updateCode(type);
        return "redirect:/codes";
    }

    @GetMapping("/codes/delete/{id}")
    public String deleteType(@PathVariable Long id) {
        codeService.deleteCode(id);
        return "redirect:/codes";
    }


}

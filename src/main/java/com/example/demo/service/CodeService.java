package com.example.demo.service;

import com.example.demo.model.CodeModel;

import java.util.List;

public interface CodeService {
    public List<CodeModel> findAllCodes();
    public CodeModel findCodeById(Long id);
    public CodeModel createCode(CodeModel codeModel);
    public CodeModel updateCode(CodeModel codeModel);
    public void deleteCode(Long id);


}

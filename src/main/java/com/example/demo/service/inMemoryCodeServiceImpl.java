package com.example.demo.service;

import com.example.demo.model.CodeModel;
import com.example.demo.repository.CodeRepository;
import com.example.demo.repository.InMemoryCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class inMemoryCodeServiceImpl implements CodeService {
    private final CodeRepository codeRepository;

    @Autowired
    public inMemoryCodeServiceImpl(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    @Override
    public List<CodeModel> findAllCodes() {
        return codeRepository.findAll();
    }

    @Override
    public CodeModel findCodeById(Long id) {
        return codeRepository.findById(id).orElse(null);
    }

    @Override
    public CodeModel createCode(CodeModel codeModel) {
        return codeRepository.save(codeModel);
    }

    @Override
    public CodeModel updateCode(CodeModel codeModel) {
        return codeRepository.save(codeModel);
    }

    @Override
    public void deleteCode(Long id) {
        codeRepository.deleteById(id);
    }


}

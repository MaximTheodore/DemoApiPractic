package com.example.demo.repository;


import com.example.demo.model.CodeModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository
public class InMemoryCodeRepository {

    private final List<CodeModel> TYPE = new ArrayList<>();

    public CodeModel createCode(CodeModel codeModel){
        TYPE.add(codeModel);
        return codeModel;
    }
    public CodeModel updateCode(CodeModel codeModel){
        int typeIndex = IntStream.range(0, TYPE.size())
                .filter(index -> TYPE.get(index).getId() == codeModel.getId())
                .findFirst()
                .orElse(-1);

        return typeIndex == -1 ? null : TYPE.set(typeIndex, codeModel);
    }

    public List<CodeModel> findAllCodes() {
        return TYPE.stream().filter(typeModel -> !typeModel.isDeleted())
                .collect(Collectors.toList());
    }
    public CodeModel findCodeById(Long id){
        return TYPE.stream()
                .filter(typeModel -> typeModel.getId() == id)
                .findFirst()
                .orElse(null);
    }
    public void deleteCode(Long id){
        var typeModel = findCodeById(id);
        if (typeModel != null) {
            TYPE.remove(typeModel);
        }
    }


}

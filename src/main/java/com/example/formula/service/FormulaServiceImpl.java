package com.example.formula.service;

import com.example.formula.dto.FormulaDTO;
import com.example.formula.dto.InputDTO;
import com.example.formula.entity.Formula;
import com.example.formula.exception.FormulaIDNotFoundException;
import com.example.formula.mapper.FormulaMapper;
import com.example.formula.repo.FormulaIDRepo;
import com.example.formula.repo.FormulaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FormulaServiceImpl implements FormulaService {
    @Autowired
    private FormulaMapper formulaMapper;
    @Autowired
    private FormulaRepo formulaRepo;
    @Autowired
    private FormulaIDRepo formulaIDRepo;
    @Autowired
    private FormulaIDService formulaIDService;

    @Override
    public FormulaDTO Formula(InputDTO inputDTO) {
        Formula formula = formulaMapper.convertInputDTOToFormula(inputDTO);
        formula.setFormulaID(formulaIDService.getFormulaID());
        Formula formula1 = formulaRepo.save(formula);
        FormulaDTO formulaDTO = formulaMapper.convertFormulaToFormulaDTO(formula1);
        return formulaDTO;
    }

    @Override
    public FormulaDTO getFormulaID(String formulaID) throws FormulaIDNotFoundException {
        Formula formulaRepoByFormulaID = formulaRepo.findByFormulaID(formulaID);
        if (formulaRepoByFormulaID != null) {
            Formula formula = formulaRepo.findByFormulaID(formulaID);
            return formulaMapper.convertFormulaTOFormulaDTO(formula);
        } else {
            throw new FormulaIDNotFoundException("Incorrect FormulaID entered");
        }
    }
}

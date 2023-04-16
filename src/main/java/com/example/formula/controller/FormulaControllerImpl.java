package com.example.formula.controller;

import com.example.formula.dto.FormulaDTO;
import com.example.formula.dto.InputDTO;
import com.example.formula.exception.FormulaIDNotFoundException;
import com.example.formula.service.FormulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormulaControllerImpl implements FormulaController {
    @Autowired
    private FormulaService formulaService;

    @Override
    public ResponseEntity<FormulaDTO> Formula(InputDTO inputDTO) {
        FormulaDTO formulaDTO = formulaService.Formula(inputDTO);
        return new ResponseEntity<>(formulaDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<FormulaDTO> getFormula(String formulaID) throws FormulaIDNotFoundException {
        FormulaDTO formulaDTO = formulaService.getFormulaID(formulaID);
        return new ResponseEntity<>(formulaDTO, HttpStatus.OK);
    }
}

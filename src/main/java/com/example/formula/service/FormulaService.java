package com.example.formula.service;

import com.example.formula.dto.FormulaDTO;
import com.example.formula.dto.InputDTO;
import com.example.formula.exception.FormulaIDNotFoundException;

public interface FormulaService {

    FormulaDTO Formula(InputDTO inputDTO);

    FormulaDTO getFormulaID(String formulaID) throws FormulaIDNotFoundException;
}

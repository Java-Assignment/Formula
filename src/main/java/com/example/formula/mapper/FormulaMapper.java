package com.example.formula.mapper;


import com.example.formula.dto.FormulaDTO;
import com.example.formula.dto.InputDTO;
import com.example.formula.entity.Formula;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FormulaMapper {

    Formula convertInputDTOToFormula(InputDTO inputDTO);

    FormulaDTO convertFormulaToFormulaDTO(Formula formula1);

    FormulaDTO convertFormulaTOFormulaDTO(Formula formula);
}

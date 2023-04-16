package com.example.formula.controller;

import com.example.formula.dto.FormulaDTO;
import com.example.formula.dto.InputDTO;
import com.example.formula.exception.FormulaIDNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/formula", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Validated
@Tag(name = "Formula API", description = "This app contains formula related operations")
public interface FormulaController {
    @PostMapping
    @Operation(summary = "Formula api")
    ResponseEntity<FormulaDTO> Formula(@RequestBody @Validated InputDTO inputDTO);

    @GetMapping(value = "/{formulaID}")
    ResponseEntity<FormulaDTO> getFormula(@PathVariable("formulaID") @NotNull String formulaID) throws FormulaIDNotFoundException;

}

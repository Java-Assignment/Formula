package com.example.formula.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "Formula")
public class Formula {
    @Id
    private String formulaID;
    private String operation;
    private String FinalFormula;
}

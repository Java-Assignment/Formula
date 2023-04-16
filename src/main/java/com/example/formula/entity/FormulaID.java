package com.example.formula.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "FormulaID")
@Data
public class FormulaID {
    @Id
    private String id;
    @Version
    private Long Version;
    private Long FormulaID;
}

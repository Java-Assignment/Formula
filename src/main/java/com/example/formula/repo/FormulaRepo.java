package com.example.formula.repo;

import com.example.formula.entity.Formula;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FormulaRepo extends MongoRepository<Formula, String> {
    Formula findByFormulaID(String formulaID);
}

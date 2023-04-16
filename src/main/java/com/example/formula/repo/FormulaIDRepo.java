package com.example.formula.repo;

import com.example.formula.entity.FormulaID;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FormulaIDRepo extends MongoRepository<FormulaID, String> {
}

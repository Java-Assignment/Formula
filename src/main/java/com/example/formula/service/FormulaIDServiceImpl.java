package com.example.formula.service;

import com.example.formula.entity.FormulaID;
import com.example.formula.repo.FormulaIDRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FormulaIDServiceImpl implements FormulaIDService {
    @Autowired
    private FormulaIDRepo formulaIDRepo;

    @Override
    @Retryable(value = OptimisticLockingFailureException.class, maxAttempts = 15)
    public String getFormulaID() {
        try {
            FormulaID formulaID = formulaIDRepo.findAll().get(0);
            Long newFormulaID = formulaID.getFormulaID() + 1;
            formulaID.setFormulaID(newFormulaID);
            formulaIDRepo.save(formulaID);
            return String.valueOf(newFormulaID);
        } catch (OptimisticLockingFailureException e) {
            log.error("Exception in creating a FormulaID will retry");
            throw e;
        }
    }
}

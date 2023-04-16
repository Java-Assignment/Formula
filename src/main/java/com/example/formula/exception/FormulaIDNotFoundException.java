package com.example.formula.exception;

public class FormulaIDNotFoundException extends Throwable {
    public FormulaIDNotFoundException(String incorrectFormulaIDEntered) {
        super(incorrectFormulaIDEntered);
    }
}

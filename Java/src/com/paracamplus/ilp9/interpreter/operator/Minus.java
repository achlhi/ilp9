package com.paracamplus.ilp9.interpreter.operator;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.paracamplus.ilp9.interpreter.EvaluationException;
import com.paracamplus.ilp9.interpreter.UnaryOperator;

public class Minus extends UnaryOperator {
    
    public Minus () {
        super("-");
    }
    
    public Object apply (Object arg1) 
            throws EvaluationException {
        if ( arg1 instanceof BigInteger ) {
            BigInteger bi1 = (BigInteger) arg1;
            return BigInteger.ZERO.subtract(bi1);
        } else if ( arg1 instanceof BigDecimal ) {
            BigDecimal bd1 = (BigDecimal) arg1;
            return BigDecimal.ZERO.subtract(bd1);
        } else {
            String msg = "Non numeric argument";
            throw new EvaluationException(msg);
        }
    }
}
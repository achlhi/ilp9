package com.paracamplus.ilp9.interpreter.operator;

import java.math.BigInteger;

import com.paracamplus.ilp9.interpreter.BinaryOperator;
import com.paracamplus.ilp9.interpreter.EvaluationException;

public class Remainder extends BinaryOperator {
    
    public Remainder () {
        super("%");
    }
    
    public Object apply (Object arg1, Object arg2) 
            throws EvaluationException {
        if ( arg1 instanceof BigInteger ) {
            BigInteger bi1 = (BigInteger) arg1;
            if ( arg2 instanceof BigInteger ) {
                BigInteger bi2 = (BigInteger) arg2;
                return bi1.divideAndRemainder(bi2)[1];
            } else {
                String msg = "Non integer argument2";
                throw new EvaluationException(msg);
            }
        } else {
            String msg = "Non integer argument1";
            throw new EvaluationException(msg);
        }
    }
}

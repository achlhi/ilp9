package com.paracamplus.ilp9.interpreter.operator;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.paracamplus.ilp9.interpreter.BinaryOperator;
import com.paracamplus.ilp9.interpreter.EvaluationException;

public class Add extends BinaryOperator {
    
    public Add () {
        super("+");
    }
    
    public Object apply (Object arg1, Object arg2) 
            throws EvaluationException {
        if ( arg1 instanceof BigInteger ) {
            BigInteger bi1 = (BigInteger) arg1;
            if ( arg2 instanceof BigInteger ) {
                BigInteger bi2 = (BigInteger) arg2;
                return bi1.add(bi2);
            } else if ( arg2 instanceof BigDecimal ) {
                BigDecimal bd2 = (BigDecimal) arg2;
                BigDecimal bd1 = new BigDecimal(bi1);
                return bd1.add(bd2);
            } else {
                String msg = "Non numeric argument2";
                throw new EvaluationException(msg);
            }
        } else if ( arg1 instanceof BigDecimal ) {
            BigDecimal bd1 = (BigDecimal) arg1;
            if ( arg2 instanceof BigInteger ) {
                BigInteger bi2 = (BigInteger) arg2;
                BigDecimal bd2 = new BigDecimal(bi2);
                return bd1.add(bd2);
            } else if ( arg2 instanceof BigDecimal ) {
                BigDecimal bd2 = (BigDecimal) arg2;
                return bd1.add(bd2);
            } else {
                String msg = "Non numeric argument2";
                throw new EvaluationException(msg);
            }
        } else if ( arg1 instanceof String ) {
            String s1 = (String) arg1;
            if ( arg2 instanceof String ) {
                String s2 = (String) arg2;
                return s1 + s2;
            } else {
                String msg = "Non string argument2";
                throw new EvaluationException(msg);
            }
        } else {
            String msg = "Non numeric nor string argument1";
            throw new EvaluationException(msg);
        }
    }
}

package com.paracamplus.ilp9.interpreter.operator;

import com.paracamplus.ilp9.interpreter.BinaryOperator;
import com.paracamplus.ilp9.interpreter.EvaluationException;

public class Xor extends BinaryOperator {
    
    public Xor () {
        super("^");
    }
    
    public Object apply (Object arg1, Object arg2) 
            throws EvaluationException {
        if ( arg1 instanceof Boolean ) {
            Boolean b1 = (Boolean) arg1;
            if ( ! b1.booleanValue() ) {
              // Here arg1 is false!
              if ( arg2 instanceof Boolean ) {
                Boolean b2 = (Boolean) arg2;
                if ( ! b2.booleanValue() ) {
                  // Here arg2 is also false!
                  return Boolean.FALSE;
                }
              }
            }
            return Boolean.TRUE;
        } else {
          // Here, arg1 cannot be false!
          if ( arg2 instanceof Boolean ) {
            Boolean b2 = (Boolean) arg2;
            if ( ! b2.booleanValue() ) {
              // Here arg2 is false!
              return Boolean.TRUE;
            }
          }
          // here arg2 cannot be false
          return Boolean.FALSE;
        }
    }
}

// end of And.java

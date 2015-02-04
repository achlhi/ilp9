package com.paracamplus.ilp9.interpreter;

import com.paracamplus.ilp9.interpreter.operator.Add;
import com.paracamplus.ilp9.interpreter.operator.And;
import com.paracamplus.ilp9.interpreter.operator.Equal;
import com.paracamplus.ilp9.interpreter.operator.Greater;
import com.paracamplus.ilp9.interpreter.operator.GreaterThan;
import com.paracamplus.ilp9.interpreter.operator.Inequal;
import com.paracamplus.ilp9.interpreter.operator.Less;
import com.paracamplus.ilp9.interpreter.operator.LessThan;
import com.paracamplus.ilp9.interpreter.operator.Minus;
import com.paracamplus.ilp9.interpreter.operator.Multiply;
import com.paracamplus.ilp9.interpreter.operator.Negate;
import com.paracamplus.ilp9.interpreter.operator.Or;
import com.paracamplus.ilp9.interpreter.operator.Quotient;
import com.paracamplus.ilp9.interpreter.operator.Remainder;
import com.paracamplus.ilp9.interpreter.operator.Subtract;
import com.paracamplus.ilp9.interpreter.operator.Xor;

public class OperatorStuff {
    
    public static void fillUnaryOperators (IOperatorEnvironment env)
            throws EvaluationException {
        env.addOperator(new Negate());
        env.addOperator(new Minus());
    }
    
    public static void fillBinaryOperators (IOperatorEnvironment env) 
            throws EvaluationException {
        env.addOperator(new Add());
        env.addOperator(new Multiply());
        env.addOperator(new Quotient());
        env.addOperator(new Remainder());
        env.addOperator(new Subtract());
        // comparators
        env.addOperator(new Less());
        env.addOperator(new LessThan());
        env.addOperator(new Equal());
        env.addOperator(new Inequal());
        env.addOperator(new Greater());
        env.addOperator(new GreaterThan());
        //
        env.addOperator(new And());
        env.addOperator(new Or());
        env.addOperator(new Xor());
    }
}

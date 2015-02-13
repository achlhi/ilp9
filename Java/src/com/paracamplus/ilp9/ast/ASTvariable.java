package com.paracamplus.ilp9.ast;

import com.paracamplus.ilp9.interfaces.IASTvariable;
import com.paracamplus.ilp9.interfaces.IASTvisitor;

public class ASTvariable extends ASTnamed implements IASTvariable {

    public ASTvariable (String name) {
        super(name);
    }

    public <Result, Data, Anomaly extends Throwable> 
    Result accept(IASTvisitor<Result, Data, Anomaly> visitor, Data data)
            throws Anomaly {
        return visitor.visit(this, data);
    }
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("<");
        sb.append(this.getClass().getName()
                .replaceFirst("^com.paracamplus.ilp9.", ""));
        sb.append(" name='");
        sb.append(this.getName());
        sb.append("'/>");
        return sb.toString();
    }
}

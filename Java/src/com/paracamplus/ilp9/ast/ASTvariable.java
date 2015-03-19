/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp9.ast;

import com.paracamplus.ilp9.interfaces.IASTvariable;
import com.paracamplus.ilp9.interfaces.IASTvisitor;

/**
 * The Class ASTvariable.
 */
public class ASTvariable extends ASTnamed implements IASTvariable {

	/** Boolean :  if global key is word present. */
	private boolean globalKeyWordPresent;
	
    /**
     * Instantiates a new AS tvariable.
     *
     * @param name the name
     */
    public ASTvariable (String name) {
        super(name);
    }

    /* (non-Javadoc)
     * @see com.paracamplus.ilp9.interfaces.IASTvisitable#accept(com.paracamplus.ilp9.interfaces.IASTvisitor, java.lang.Object)
     */
    public <Result, Data, Anomaly extends Throwable> 
    Result accept(IASTvisitor<Result, Data, Anomaly> visitor, Data data)
            throws Anomaly {
        return visitor.visit(this, data);
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("<");
        sb.append(this.getClassShortName());
        sb.append(" name='");
        sb.append(this.getName());
        sb.append("'");
        sb.append(" global='");
        sb.append(this.isGlobalKeyWordPresent());
        sb.append("'/>");
        return sb.toString();
    }
    
    /* (non-Javadoc)
     * @see com.paracamplus.ilp9.interfaces.IASTvariable#setGlobalKeyWordPresent()
     */
    public void setGlobalKeyWordPresent(){
    	globalKeyWordPresent = true;
    }

	/**
	 * Checks if  global keyword is present
	 * 
	 * 
	 * @return true, if  global keyword is present
	 */
	public boolean isGlobalKeyWordPresent() {
		return globalKeyWordPresent;
	}

	 
}

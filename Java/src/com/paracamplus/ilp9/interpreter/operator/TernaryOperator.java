/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp9.interpreter.operator;

import java.beans.Expression;

import com.paracamplus.ilp9.interpreter.interfaces.EvaluationException;

public abstract class TernaryOperator extends BinaryOperator {

	public TernaryOperator() {
		super("?:");
	}

	public int getArity() {
		return 3;
	}

	public Object apply(Object arg1, Object arg2, Object arg3)
			throws EvaluationException {
//		if (arg1 instanceof String) {
//			 Boolean.va
//			
//			
//		}
		return null;
	} 

	// public Object apply(Object... argument) throws EvaluationException {
	// if ( argument.length == getArity() ) {
	// return apply(argument[0], argument[1],argument[2]);
	// } else {
	// String msg = "Wrong arity for operator " + this.getName();
	// throw new EvaluationException(msg);
	// }
	// }
 
}

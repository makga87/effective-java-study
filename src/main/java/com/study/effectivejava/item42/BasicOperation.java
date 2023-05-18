package com.study.effectivejava.item42;

import java.util.function.DoubleBinaryOperator;

import com.study.effectivejava.item38.Operation;

public enum BasicOperation implements Operation {

	PLUS("+", (x, y) -> {
//		String symbol = symbol;
		return x + y;
	}),
	MINUS("-", (x, y) -> x - y);

	private final String symbol;
	private final DoubleBinaryOperator op;

	BasicOperation(String symbol, DoubleBinaryOperator op) {
		this.symbol = symbol;
		this.op = op;
	}

	public double apply(double x, double y) {
		return op.applyAsDouble(x, y);
	}
}

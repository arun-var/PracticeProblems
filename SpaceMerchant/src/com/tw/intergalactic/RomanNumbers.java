package com.tw.intergalactic;

public enum RomanNumbers {
	I (1),
	V (5),
	X(10),
	L(50),
	C (100),
	D (500),
	M(1000);
	
	private final int decimalValue;
	
	private RomanNumbers(int value) {
		this.decimalValue = value;
	}

	public int getDecimalValue() {
		return decimalValue;
	}
	
	public int toNumber(String romanNum){
		
	}
}

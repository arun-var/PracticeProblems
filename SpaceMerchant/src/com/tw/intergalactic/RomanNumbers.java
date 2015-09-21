package com.tw.intergalactic;

import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;

public enum RomanNumbers {
	I (1),
	V (5),
	X(10),
	L(50),
	C (100),
	D (500),
	M(1000);
	
	private final int decimalValue;
	private LineClassifier lineClassifier = LineClassifier.getInstance();
	
	private RomanNumbers(int value) {
		this.decimalValue = value;
	}

	public int getDecimalValue() {
		return decimalValue;
	}
	
	public int toNumber(String romanNum){
		char[] romanNumerals = romanNum.toCharArray();
		List<Integer> numbers = new ArrayList<Integer>();
		
		if(checkRomanRules(romanNum)){
			for(char c:romanNumerals){
				switch(c){
				case 'I':
					numbers.add(RomanNumbers.I.getDecimalValue());
					break;
				case 'V':
					numbers.add(RomanNumbers.V.getDecimalValue());
					break;
				case 'X':
					numbers.add(RomanNumbers.X.getDecimalValue());
					break;
				case 'L':
					numbers.add(RomanNumbers.L.getDecimalValue());
					break;
				case 'C':
					numbers.add(RomanNumbers.C.getDecimalValue());
					break;
				case 'D':
					numbers.add(RomanNumbers.D.getDecimalValue());
					break;
				case 'M':
					numbers.add(RomanNumbers.M.getDecimalValue());
					break;
				}
			}
		}
		
		
		
		
	}
	
	private boolean checkRomanRules(String romanNum){
		String regex ="";
		String [] romanRuleRegexTests = {"(IIII+)","(XXXX+)", "(CCCC+)", "(MMMM+)", "(DD+)", "(LL+)", "(VV+)"}; 
		
		for(int i =0 ; i < romanRuleRegexTests.length; i ++)
		{
			regex = romanRuleRegexTests[i];
			Matcher m = lineClassifier.getMatcher(romanNum, regex);
			
			if(m.matches())
			{
				System.out.println("The number entered violates Roman Number repitition constraints.");
				return true;
			}
		}
		return false;
	}
}

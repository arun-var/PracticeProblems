package com.tw.intergalactic;

public enum Line
{	
	Assignment ("^([a-z]+) is ([I|V|X|L|C|D|M])$", 0),
	Credits ("((?:[a-z]+ )+)([A-Z]\\w+) is (\\d+) ([A-Z]\\w+)$", 1),
	HowMany("^how many ([a-zA-Z]\\w+) is ((?:\\w+ )+)([A-Z]\\w+) \\?$", 2),
	HowMuch("^how much is ((?:\\w+[^0-9] )+)\\?$", 3);
	
	private String regex;
	private int lineType;
	
	Line(String regex, int lineType)
	{
		this.regex = regex;
		this.lineType = lineType;
	}
	
	public int getType()
	{
		return this.lineType;
	}
	
	public String getRegex()
	{
		return this.regex;
	}
	
	
}

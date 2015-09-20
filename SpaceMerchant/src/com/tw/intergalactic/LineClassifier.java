package com.tw.intergalactic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LineClassifier {

	
	private static LineClassifier lineClassifier;
	private Matcher matcher;
	private Pattern pattern;
	
	private LineClassifier()
	{
		
	}
	
	public static LineClassifier getInstance()
	{
		 if(lineClassifier == null)
		 {
			 lineClassifier = new LineClassifier();
		 }
		 
		 return lineClassifier;
	}
	
	public int getLineType(String line){
		
		for(Line l: Line.values()){
			matcher = getMatcher(line,l.getRegex());
			if(matcher.matches()){
				return l.getType();
			}
		}
		return -1;
	}
	
	public Matcher getMatcher(String line, String regex){
		pattern = Pattern.compile(regex);
		return pattern.matcher(line);
	}
}

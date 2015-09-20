package com.tw.intergalactic;

import java.util.Scanner;

public class InputParser {

	private Scanner inputScanner;
	private LineClassifier lineClassifier = LineClassifier.getInstance();
	
	public InputParser() {
		inputScanner = new Scanner(System.in);
	}

	public void Parse(){
		
		while(inputScanner.hasNext())
		{
			processInputLine(inputScanner.nextLine());
		}

		inputScanner.close();
	}
	
	/**
	 * 
	 * @param line
	 * @return Depending on the line Type process the line
	 */
	private void processInputLine(String line){
		int lineType = lineClassifier.getLineType(line);
		switch(lineType){
		
		case 0:
			
		case 1:
			
		case 2:
			
		case 3:
			
		default:
			break;
			
		}
	}
}

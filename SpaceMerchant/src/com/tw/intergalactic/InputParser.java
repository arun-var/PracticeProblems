package com.tw.intergalactic;

import java.util.Scanner;

public class InputParser {

	private Scanner inputScanner;
	private LineClassifier lineClassifier = LineClassifier.getInstance();
	
	public InputParser() {
		inputScanner = new Scanner(System.in);
	}

	public void parse(){
		
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
			System.out.println("Assignment");
			break;
		case 1:
			System.out.println("Credits");
			break;
		case 2:
			System.out.println("how many");
			break;
		case 3:
			System.out.println("how much");
			break;
		default:
			System.out.println("Wrong");
			break;
			
		}
	}
}

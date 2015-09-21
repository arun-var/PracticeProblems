package com.tw.intergalactic;

import java.util.Scanner;
import java.util.regex.Matcher;

public class InputParser {

	private Scanner inputScanner;
	private LineClassifier lineClassifier = LineClassifier.getInstance();
	private AlienNumberSystem alienNumberSys = new AlienNumberSystem();
	private RomanNumberSystem romanNumberSys = new RomanNumberSystem();
	private Item itemDetails = new Item(alienNumberSys, romanNumberSys);
	
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
			String[] tokens = line.split(" ");
			alienNumberSys.addAlienNumberDefToMap(tokens[0], tokens[2]);
			break;
		case 1:
			System.out.println("Credits");
			itemDetails.processItemInfo(line);
			break;
		case 2:
			System.out.println("how many");
			Matcher m = lineClassifier.getMatcher(line, Line.HowMany.getRegex());
			if(m.matches()){
				String alienNumber = m.group(1);
				String[] alienNumerals = alienNumber.split(" ");
				if(alienNumberSys.checkAlienNumberDefinition(alienNumerals)){
					String romanRepresentation = alienNumberSys.getRomanNumber(alienNumerals);
					int decimal = romanNumberSys.toNumber(romanRepresentation);
					System.out.println(alienNumber+" is "+ decimal);
				}
			}
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

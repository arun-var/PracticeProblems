package com.tw.intergalactic;

import java.util.Scanner;
import java.util.regex.Matcher;

public class InputParser {

	private Scanner inputScanner;
	private LineClassifier lineClassifier = LineClassifier.getInstance();
	private AlienNumberSystem alienNumberSys;
	private RomanNumberSystem romanNumberSys;
	private Item itemDetails;
	
	public InputParser() {
		inputScanner = new Scanner(System.in);
		alienNumberSys = new AlienNumberSystem();
		romanNumberSys = new RomanNumberSystem();
		itemDetails = new Item(alienNumberSys, romanNumberSys);
	}

	public void parse(){
		
		while(inputScanner.hasNext())
		{
			processInputLine(inputScanner.nextLine());
		}

		inputScanner.close();
	}
	
	/**
	 * Assumption: The roman number definitions are present at the beginning
	 * @param line
	 * @return Depending on the line Type process the line
	 */
	private void processInputLine(String line){
		int lineType = lineClassifier.getLineType(line);
		Matcher m;
		switch(lineType){
		
		case 0:
			//System.out.println("Assignment");
			String[] tokens = line.split(" ");
			alienNumberSys.addAlienNumberDefToMap(tokens[0], tokens[2]);
			break;
		case 1:
			//System.out.println("Credits");
			itemDetails.processItemInfo(line);
			break;
		case 2:
			//System.out.println("how many");
			m = lineClassifier.getMatcher(line, Line.HowMany.getRegex());
			if(m.matches()){
				String [] alienNumerals = m.group(2).split(" ");
				String itemName = m.group(3);
				
				if(alienNumberSys.checkAlienNumberDefinition(alienNumerals) && itemDetails.hasItem(itemName)){
					String romanRepresentation = alienNumberSys.getRomanNumber(alienNumerals);
					//System.out.println("Roman is "+ romanRepresentation);
					int itemQuantity = romanNumberSys.toNumber(romanRepresentation);
					double itemValue = itemQuantity * itemDetails.getUnitItemValue(itemName);
					System.out.println(m.group(2)+" "+itemName+" is "+ itemValue+" "+m.group(1));
				}
			}
			break;
		case 3:
			//System.out.println("how much");
			m = lineClassifier.getMatcher(line, Line.HowMuch.getRegex());
			if(m.matches()){
				String alienNumber = m.group(1);
				String[] alienNumerals = alienNumber.split(" ");
				if(alienNumberSys.checkAlienNumberDefinition(alienNumerals)){
					String romanRepresentation = alienNumberSys.getRomanNumber(alienNumerals);
					//System.out.println("Roman is "+ romanRepresentation);
					int decimal = romanNumberSys.toNumber(romanRepresentation);
					System.out.println(alienNumber+" is "+ decimal);
				}
			}
			break;
		default:
			System.out.println("I have no idea what you are talking about");
			break;
			
		}
	}
}

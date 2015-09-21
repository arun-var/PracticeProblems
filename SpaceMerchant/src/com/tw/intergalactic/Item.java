package com.tw.intergalactic;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

public class Item {

	private Map<String, Double> itemValueMap;
	private LineClassifier lineClassifier;
	private AlienNumberSystem alienNumberSystem;
	private RomanNumberSystem romanNumberSystem;
	
	public Item(AlienNumberSystem alienNumberSystem,RomanNumberSystem romanNumberSystem) {
		itemValueMap = new HashMap<String, Double>();
		lineClassifier = LineClassifier.getInstance();
		this.alienNumberSystem = alienNumberSystem;
		this.romanNumberSystem = romanNumberSystem;
	}

	public void processItemInfo(String line){
		String itemRegex = Line.ItemCredits.getRegex();
		Matcher m = lineClassifier.getMatcher(line, itemRegex);
		if(m.matches())
		{
			String [] alienNums = m.group(1).split("\\s");
			String itemName = m.group(2);
			int totalValue = Integer.parseInt(m.group(3));
			
			if(!alienNumberSystem.checkAlienNumberDefinition(alienNums))
			{
				System.out.println("Undeclared definition");
				return;
			}
			
			//units is float to get barUnitValue in double. 
			float units = romanNumberSystem.toNumber(alienNumberSystem.getRomanNumber(alienNums));
			
			float barUnitValue = totalValue / units;
			addItem(itemName, barUnitValue);
		}
		
	}
	
	private void addItem(String itemName, double unitItemValue)
	{
		itemValueMap.put(itemName, unitItemValue);
	}
	
	public double getUnitItemValue(String itemName){
		double value =  itemValueMap.get(itemName);
		return value;
	}
}

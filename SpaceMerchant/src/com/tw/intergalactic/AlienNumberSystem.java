package com.tw.intergalactic;

import java.util.HashMap;

public class AlienNumberSystem {

	
	private HashMap<String, String> alienToRomanMap;
	
	public AlienNumberSystem() {
		alienToRomanMap = new HashMap<String, String>();
	}

	public void addAlienNumberDefToMap(String alienNum, String romanNum){
		if(!alienToRomanMap.containsKey(alienNum)){
			alienToRomanMap.put(alienNum, romanNum);
			//System.out.println("added "+alienNum+" to "+romanNum);
		}
	}
	
	public String getRomanNumber(String[] alienNumberDef){
		StringBuilder romanNum = new StringBuilder();
		for(String alienNum:alienNumberDef){
			romanNum.append(alienToRomanMap.get(alienNum));
		}
		return romanNum.toString();
	}
	
	/**
	 * Check if all alienNumbers defs are defined or not
	 * @param alienNumbers
	 * @return
	 */
	public boolean checkAlienNumberDefinition(String[] alienNumbers){
		for (String alienNum : alienNumbers)
		{
			if(!alienToRomanMap.containsKey(alienNum))
			{
				System.out.println("Alien Number Def has not been added.");
				return false;
			}
		}
		return true;
	}
}

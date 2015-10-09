package home.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class LargestConsecutiveSeqGenerator {

	public static void main(String args[]) {
		int[] array = {2,3,4,6,7,21,22,1,27};
		
		HashMap<Integer, Integer> consecutiveNumList = new HashMap<Integer, Integer>();
		HashSet<Integer> setNumbers = new HashSet<Integer>();
		for(int i=0;i<array.length;i++){
			setNumbers.add(array[i]);
		}
		
		for(int i=0;i<array.length;i++){
			int count=1;
			int currentNumber = array[i];
			int leastNumber = currentNumber;
			int leftNumber = currentNumber-1;
			int rightNumber = currentNumber + 1;
			System.out.println("===curr "+currentNumber);
			if(consecutiveNumList.containsKey(currentNumber)) {
				continue;
			}
			while(setNumbers.contains(leftNumber)){
				count++;
				setNumbers.remove(leftNumber);
				System.out.println("removing left "+leftNumber);
				leastNumber = leftNumber;
				leftNumber--;
			}
			while(setNumbers.contains(rightNumber)){
				count++;
				setNumbers.remove(rightNumber);
				System.out.println("removing right "+rightNumber);
				rightNumber++;
				
			}
			setNumbers.remove(currentNumber);
			System.out.println("----"+leastNumber+ " "+count);
			consecutiveNumList.put(leastNumber,count);
		}
		
		Iterator<Integer> itr = consecutiveNumList.keySet().iterator();
		int maxSize = 0;
		int minVal = 0;
		System.out.println("******************");
		while(itr.hasNext()){
			int currVal = itr.next();
			//minVal = currVal;
			int size = consecutiveNumList.get(currVal);
			System.out.println("curr size"+currVal+" "+size);
			maxSize = size>maxSize?size:maxSize;
			if(maxSize==size) minVal=currVal;
		}
		
		System.out.println("min "+minVal+" maxlen "+maxSize);
		for(int j=minVal;j<=maxSize;j++){
			System.out.println(j+" ");
		}
	}
}

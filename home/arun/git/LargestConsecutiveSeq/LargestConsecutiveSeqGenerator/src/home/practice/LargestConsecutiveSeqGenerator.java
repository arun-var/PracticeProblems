package home.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class LargestConsecutiveSeqGenerator {

	public static void main(String args[]) {
		int[] array = {2,3,4,6,7,21,22,1,27};
		
		findLargestConsecutiveSequence(array);
		
	}
	
	public static void findLargestConsecutiveSequence(int[] array){
		HashSet<Integer> setNumbers = new HashSet<Integer>();
		for(int i=0;i<array.length;i++){
			setNumbers.add(array[i]);
		}
		int max=0,start=0;
		for(int i=0;i<array.length;i++){
			int count=1;
			int currentNumber = array[i];
			//int leastNumber = currentNumber;
			int leftNumber = currentNumber-1;
			int rightNumber = currentNumber + 1;
			System.out.println("===curr "+currentNumber);
			//if(consecutiveNumList.containsKey(currentNumber)) {
			//	continue;
			//}
			while(setNumbers.contains(leftNumber)){
				count++;
				setNumbers.remove(leftNumber);
				System.out.println("removing left "+leftNumber);
				//leastNumber = leftNumber;
				leftNumber--;
			}
			while(setNumbers.contains(rightNumber)){
				count++;
				setNumbers.remove(rightNumber);
				System.out.println("removing right "+rightNumber);
				rightNumber++;
				
			}
			setNumbers.remove(currentNumber);
			System.out.println("----"+leftNumber+1+ " "+count);
			//consecutiveNumList.put(leftNumber+1,count);
			if(max<count){

	               max=count;

	               start=leftNumber+1;

	           }
		}
		

		System.out.println("min "+start+" maxlen "+max);
		for(int j=start;j<=max;j++){
			System.out.println(j+" ");
		}
	}
}

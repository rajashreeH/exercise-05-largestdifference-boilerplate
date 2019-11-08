package com.stackroute;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

public class LargestDifference {

   	private static Scanner scan;


	//Do not print anything other than what's expected/asked in problem
    public static void main(String[] args) {
   	scan = new Scanner(System.in);
    	int inputNum=scan.nextInt();
    	
    	int numbers[]=new int[inputNum];
    	for(int i=0;i<inputNum;i++) {
    		numbers[i]=scan.nextInt();
    	}
    	int index= findLargestDifference(numbers);
    	System.out.println(index);
	}
    
   
    /*6,9,2,7,6
       3,7,5,1*/
	public static int findLargestDifference(int[] numbers) {
		
		if(numbers.length>1&&numbers!=null) {
    	int numberDiff[]=new int[numbers.length-1];
		for(int i=1;i<numbers.length;i++) {
			numberDiff[i-1]=Math.abs(numbers[i]-numbers[i-1]);
		}
		
		int max=Arrays.stream(numberDiff).max().getAsInt();
		int NumMax=-1;
		int indexOfMax=-1;
		for(int i=0;i<numberDiff.length;i++) {
			if(numberDiff[i]==max) {
				if(indexOfMax==-1) {
					if(numbers[i]-numbers[i+1]>0) {
						NumMax=numbers[i];
						indexOfMax=i;
					}
					else {
						NumMax=numbers[i+1];
						indexOfMax=i+1;
					}
				}
				else {
					int num;
					int index;
					if(numbers[i]-numbers[i+1]>0) {
						num=numbers[i];
						index=i;
					}
					else {
						num=numbers[i+1];
						index=i+1;
					}
					if(num-NumMax>0) {
						NumMax=num;
						indexOfMax=index;
						
					}
				}
			}
		}
		
		return indexOfMax;
	
		}
		return 0;
		}

}

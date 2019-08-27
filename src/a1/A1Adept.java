package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int numberOfItems = scan.nextInt();
		
		String[] itemNames = new String[numberOfItems];
		double[] itemPrices = new double[numberOfItems];
		
		for (int i = 0; i < numberOfItems; i++) {
			
			itemNames[i] = scan.next();
			itemPrices[i] = scan.nextDouble();
			
		}
		
		int numberOfCustomers = scan.nextInt();
		int averageSpent = 0;
		
		String[] firstNames = new String[numberOfCustomers];
		String[] lastNames = new String[numberOfCustomers];
		int[] boughtItems = new int[numberOfCustomers];
		double[] totalCost = new double[numberOfCustomers];
		String[] totalCostRounded = new String[numberOfCustomers];
		
		for (int i = 0; i < numberOfCustomers; i++) {
			
			firstNames[i] = scan.next();
			lastNames[i] = scan.next();
			boughtItems[i] = scan.nextInt();
			totalCost[i] = 0;
			
			int[] boughtItemQuantities = new int[boughtItems[i]];
			String[] boughtItemNames = new String[boughtItems[i]];
			
			for (int j = 0; j < boughtItems[i]; j++) {
				
				boughtItemQuantities[j] = scan.nextInt();
				boughtItemNames[j] = scan.next();
				totalCost[i] += boughtItemQuantities[j] * itemPrices[getStringIndex(itemNames, boughtItemNames[j])];
				
			}
			
			totalCostRounded[i] = String.format("%.2f", totalCost[i]);
			averageSpent += totalCost[i] / numberOfCustomers;
			
		}
		
		String averageSpentRounded = String.format("%.2f", averageSpent);
		
		System.out.println("Biggest: " + firstNames[getLargestIndex(totalCost)] + lastNames[getLargestIndex(totalCost)]
						   + "(" + totalCostRounded[getLargestIndex(totalCost)] + ")");
		
		System.out.println("Smallest: " + firstNames[getSmallestIndex(totalCost)] + lastNames[getSmallestIndex(totalCost)]
				   		   + "(" + totalCostRounded[getSmallestIndex(totalCost)] + ")");
		
		System.out.println("Average: " + averageSpentRounded);
		
		scan.close();
	}
	
	public static int getStringIndex(String[] array, String findString) {
		
		int j = 0;
		
		for (int i = 0; i < array.length; i++) {
			if (findString.equals(array[i]) == true) {
				j = i;
			}
		}
		
		return j;
	}
	
	public static int getSmallestIndex(double[] array) {
		
		int j = 0;
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] < array[j]) {
				j = i;
			}
		}
		
		return j;
	}
	
	public static int getLargestIndex(double[] array) {
		
		int j = 0;
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] > array[j]) {
				j = i;
			}
		}
		
		return j;
	}
	
}

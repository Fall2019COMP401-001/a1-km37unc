package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// Initialize variables
		int numberOfItems = scan.nextInt();   // get int input
		
		String[] itemNames = new String[numberOfItems];    // array of item names
		double[] itemPrices = new double[numberOfItems];   // array of item prices
		
		for (int i = 0; i < numberOfItems; i++) {   // for each item:
			
			itemNames[i] = scan.next();          // get String input
			itemPrices[i] = scan.nextDouble();   // get double input
			
		}
		
		int numberOfCustomers = scan.nextInt();   // get int input
		double averageSpent = 0;				  // initialize variable for average spent by customer
		
		// Initialize variables
		String[] firstNames = new String[numberOfCustomers];   		 // array of customer first names
		String[] lastNames = new String[numberOfCustomers];    		 // array of customer last names
		int[] boughtItems = new int[numberOfCustomers];				 // array of number of items bought by customer
		double[] totalCost = new double[numberOfCustomers];			 // array of total costs as doubles
		String[] totalCostRounded = new String[numberOfCustomers];   // array of total costs as strings in 2 decimals
		
		for (int i = 0; i < numberOfCustomers; i++) {   // for each customer:
			
			// Get inputs
			firstNames[i] = scan.next();       // get String input
			lastNames[i] = scan.next();        // get String input
			boughtItems[i] = scan.nextInt();   // get int input
			totalCost[i] = 0;				   // initialize total cost to 0 for later
			
			// Initialize variables
			int[] boughtItemQuantities = new int[boughtItems[i]];    // array of quantities of each item bought by customer
			String[] boughtItemNames = new String[boughtItems[i]];   // array of names of each item bought by customer
			
			for (int j = 0; j < boughtItems[i]; j++) {   // for each item bought by customer:
				
				// Get inputs
				boughtItemQuantities[j] = scan.nextInt();   // get int input
				boughtItemNames[j] = scan.next();           // get String input
				
				
				totalCost[i] += boughtItemQuantities[j] * itemPrices[getStringIndex(itemNames, boughtItemNames[j])];   // look up price of item name and add to total cost
				
			}
			
			// Computations
			totalCostRounded[i] = String.format("%.2f", totalCost[i]);   // round total cost to 2 decimals
			averageSpent += totalCost[i] / numberOfCustomers;			 // compute average total cost
			
		}
		
		String averageSpentRounded = String.format("%.2f", averageSpent);   // round average total cost to 2 decimals
		
		System.out.println("Biggest: " + firstNames[getLargestIndex(totalCost)] + " " + lastNames[getLargestIndex(totalCost)]
						   + " (" + totalCostRounded[getLargestIndex(totalCost)] + ")");   // print largest customer cost
		
		System.out.println("Smallest: " + firstNames[getSmallestIndex(totalCost)] +  " " + lastNames[getSmallestIndex(totalCost)]
				   		   + " (" + totalCostRounded[getSmallestIndex(totalCost)] + ")");   // print smallest customer cost
		
		System.out.println("Average: " + averageSpentRounded);   // print average cost
		
		scan.close();
	}
	
	// getStringIndex: get index location of a specific string in an array of strings
	public static int getStringIndex(String[] array, String findString) {
		
		int j = 0;
		
		for (int i = 0; i < array.length; i++) {
			if (findString.equals(array[i]) == true) {
				j = i;
			}
		}
		
		return j;
	}
	
	// getSmallestIndex: get index location of the smallest value in an array of doubles
	public static int getSmallestIndex(double[] array) {
		
		int j = 0;
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] < array[j]) {
				j = i;
			}
		}
		
		return j;
	}
	
	// getLargestIndex: get index location of the largest value in an array of doubles
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

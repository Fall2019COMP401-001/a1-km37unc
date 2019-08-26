package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
				
		// Input number of customers
		System.out.println("Enter the total number of customers:  ");   // prompt for input
		int numberOfCustomers = scan.nextInt();   // get int input
		
		// Initialize variables
		String[] firstNames = new String[numberOfCustomers];   		 // array of customer first names
		String[] lastNames = new String[numberOfCustomers];    		 // array of customer last names
		int[] numberOfItems = new int[numberOfCustomers];      		 // array of number of items bought by customer
		double[] totalCost = new double[numberOfCustomers];    		 // array of total costs as doubles
		String[] totalCostRounded = new String[numberOfCustomers];   // array of total costs as strings in 2 decimals
		
		// Loop through each customer
		for (int i = 0; i < numberOfCustomers; i++) {
			
			System.out.println("First name:  ");   // prompt for input
			firstNames[i] = scan.next();   // get String input
			
			System.out.println("Last name:  ");   // prompt for input
			lastNames[i] = scan.next();   // get String input
			
			System.out.println("Number of items bought:  ");   // prompt for input
			numberOfItems[i] = scan.nextInt();   // get int input
			
			// Initialize variables
			int[] itemQuantities = new int[numberOfItems[i]];     // array of quantities of items
			String[] itemNames = new String[numberOfItems[i]];    // array of names of items
			double[] itemPrices = new double[numberOfItems[i]];   // array of prices of items
			
			for (int j = 0; j < numberOfItems[i]; j++) {
				
				System.out.println("Item " + (j+1) + ", Quantity bought:  ");   // prompt for input
				itemQuantities[j] = scan.nextInt();   // get int input
				
				System.out.println("Item " + (j+1) + "Name of item:  ");   // prompt for input
				itemNames[j] = scan.next();   // get String input
				
				System.out.println("Item " + (j+1) + "Price of item:  ");   // prompt for input
				itemPrices[j] = scan.nextDouble();   // get double input
				
				totalCost[i] += itemQuantities[j] * itemPrices[j];
				
			}
			
			totalCostRounded[i] = String.format("%.2f", totalCost[i]);
			
		}
		
		for (int i = 0; i < numberOfCustomers; i++) {
			System.out.println(firstNames[i].charAt(0) + ". " + lastNames[i] + ": " + totalCostRounded[i]);
		}
		
		scan.close();
	}
}

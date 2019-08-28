package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
				
		// Input number of customers
		int numberOfCustomers = scan.nextInt();   // get int input
		
		// Initialize variables
		String[] firstNames = new String[numberOfCustomers];   		 // array of customer first names
		String[] lastNames = new String[numberOfCustomers];    		 // array of customer last names
		int[] numberOfItems = new int[numberOfCustomers];      		 // array of number of items bought by customer
		double[] totalCost = new double[numberOfCustomers];    		 // array of total costs as doubles
		String[] totalCostRounded = new String[numberOfCustomers];   // array of total costs as strings in 2 decimals
		
		for (int i = 0; i < numberOfCustomers; i++) {   // for each customer:
			
			// Get inputs
			firstNames[i] = scan.next();         // get String input
			lastNames[i] = scan.next();          // get String input
			numberOfItems[i] = scan.nextInt();   // get int input
			
			// Initialize variables
			int[] itemQuantities = new int[numberOfItems[i]];     // array of quantities of items
			String[] itemNames = new String[numberOfItems[i]];    // array of names of items
			double[] itemPrices = new double[numberOfItems[i]];   // array of prices of items
			
			for (int j = 0; j < numberOfItems[i]; j++) {   // for each item:
				
				// Get inputs
				itemQuantities[j] = scan.nextInt();   // get int input
				itemNames[j] = scan.next();           // get String input
				itemPrices[j] = scan.nextDouble();    // get double input
				
				totalCost[i] += itemQuantities[j] * itemPrices[j];   // compute total spent by customer
				
			}
			
			totalCostRounded[i] = String.format("%.2f", totalCost[i]);   // round total cost to 2 decimals
			
		}
		
		for (int i = 0; i < numberOfCustomers; i++) {   // for each customer:
			System.out.println(firstNames[i].charAt(0) + ". " + lastNames[i] + ": " + totalCostRounded[i]);   // print total cost
		}
		
		scan.close();
	}
}

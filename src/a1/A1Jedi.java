package a1;

import java.util.Arrays;
import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int numberOfItems = scan.nextInt();   // get int input
		
		// Initialize variables
		String[] itemNames = new String[numberOfItems];    // array of item names
		double[] itemPrices = new double[numberOfItems];   // aray of item prices
		
		for (int i = 0; i < numberOfItems; i++) {   // for each item:
			
			// Get inputs
			itemNames[i] = scan.next();   // get String input
			itemPrices[i] = scan.nextDouble();   // get double input
			
		}
		
		int numberOfCustomers = scan.nextInt();   // get int input
		
		// Initialize variables
		String[] firstNames = new String[numberOfCustomers];   // array of customer first names
		String[] lastNames = new String[numberOfCustomers];	   // array of customer last names
		int[] boughtItems = new int[numberOfCustomers];		   // array of number of items bought by customer
		
		int[][] numberOfItemInstances = new int[numberOfCustomers][numberOfItems];   // 2D array of number of items bought among all customers
		
		for (int i = 0; i < numberOfCustomers; i++) {   // for each customer:
			
			// Get inputs
			firstNames[i] = scan.next();       // get String input
			lastNames[i] = scan.next();   	   // get String input
			boughtItems[i] = scan.nextInt();   // get int input
			
			// Initialize variables
			int[] boughtItemQuantities = new int[boughtItems[i]];
			String[] boughtItemNames = new String[boughtItems[i]];
			
			for (int j = 0; j < boughtItems[i]; j++) {   // for each item bought by customer:
				
				// Get inputs
				boughtItemQuantities[j] = scan.nextInt();   // get int input
				boughtItemNames[j] = scan.next();   		// get String input
				
				numberOfItemInstances[i][getStringIndex(itemNames, boughtItemNames[j])] += boughtItemQuantities[j];   // save number of items bought to the 2D array
				
			}		
		}
		
		for (int i = 0; i < numberOfItems; i++) {   // for each item:
			
			if (countItems(numberOfItemInstances, i) == 0) {   // if no instances of item:
				System.out.println("No customers bought " + itemNames[i]);   // print output
				
			} else {   // if there are some number of instances of item:
				
				// Initialize variables
				int itemOccurrenceCount = countItems(numberOfItemInstances, i);     // number of item instances among all customers
				int itemTotalCount = sumIntArrayColumn(numberOfItemInstances, i);   // total number of item bought among all customers
				
				System.out.println(itemOccurrenceCount + " customers bought " + itemTotalCount + " " + itemNames[i]);   // print output
			}
		}
		
		scan.close();
	}
	
	// getStringIndex: get index location of a specific string in an array of strings
	public static int getStringIndex(String[] array, String findString) {
		
		int j = 0;
		
		for (int i = 0; i < array.length; i++) {
			if (findString.equals(array[i])) {
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
	
	// sumIntArray: sum integers in an array
	public static int sumIntArray(int[] array) {
		
		int sum = 0;
		
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		
		return sum;
	}
	
	// sumIntArrayColumn: sum integers of a specific column in a 2D array
	public static int sumIntArrayColumn(int[][] array, int column) {
		
		int sum = 0;
		
		for (int i = 0; i < array.length; i++) {
			sum += array[i][column];
		}
		
		return sum;
	}

	// countItems: number of instances of non-zero number in a specific column in a 2D array
	public static int countItems(int[][] array, int column) {
		
		int count = 0;
		
		for (int i = 0; i < array.length; i++) {
			if (array[i][column] > 0) {
				count += 1;
			}
		}
		
		return count;
	}
}


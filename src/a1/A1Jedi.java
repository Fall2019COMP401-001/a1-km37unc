package a1;

import java.util.Arrays;
import java.util.Scanner;

public class A1Jedi {

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
		
		String[] firstNames = new String[numberOfCustomers];
		String[] lastNames = new String[numberOfCustomers];
		int[] boughtItems = new int[numberOfCustomers];
		
		int[][] numberOfItemInstances = new int[numberOfCustomers][numberOfItems];
		
		for (int i = 0; i < numberOfCustomers; i++) {
			
			firstNames[i] = scan.next();
			lastNames[i] = scan.next();
			boughtItems[i] = scan.nextInt();
			
			int[] boughtItemQuantities = new int[boughtItems[i]];
			String[] boughtItemNames = new String[boughtItems[i]];
			
			for (int j = 0; j < boughtItems[i]; j++) {
				
				boughtItemQuantities[j] = scan.nextInt();
				boughtItemNames[j] = scan.next();
				
				numberOfItemInstances[i][getStringIndex(itemNames, boughtItemNames[j])] = boughtItemQuantities[j];
				
			}
						
		}
		
		for (int i = 0; i < numberOfItems; i++) {
			
			if (countItems(numberOfItemInstances, i) == 0) {
				System.out.println("No customers bought " + itemNames[i]);
			} else {
				
				int itemOccurrenceCount = countItems(numberOfItemInstances, i);
				int itemTotalCount = sumIntArrayColumn(numberOfItemInstances, i);
				
				System.out.println(itemOccurrenceCount + " customers bought " + itemTotalCount + " " + itemNames[i]);
			}
			
		}
		
		scan.close();
	}
	
	public static int getStringIndex(String[] array, String findString) {
		
		int j = 0;
		
		for (int i = 0; i < array.length; i++) {
			if (findString.equals(array[i])) {
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
	
	public static int sumIntArray(int[] array) {
		
		int sum = 0;
		
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		
		return sum;
	}
	
	public static int sumIntArrayColumn(int[][] array, int column) {
		
		int sum = 0;
		
		for (int i = 0; i < array.length; i++) {
			sum += array[i][column];
		}
		
		return sum;
	}


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


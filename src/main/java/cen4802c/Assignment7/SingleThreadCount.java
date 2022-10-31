package cen4802c.Assignment7;

import java.text.DecimalFormat;

/**
 * This class is for CEN 4802C-Assignment 7. It is adopted from a class I made for CEN 3024C's Concurrency Assignment.
 *
 * @author Stephen Sturges
 * @version 10/30/2022
 */
public class SingleThreadCount {

	static int runCount = 0;
	
	/**
	 * Times the execution of the sumArray method.
	 * @param array
	 */
	public static void singleThreadSumTimed(int[] array) {
		long startTime = System.nanoTime();
		int result = sumArray(array);
		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		DecimalFormat df = new DecimalFormat("###,###,###");
		System.out.println("Single-thread:\n\tElapsed time = " + df.format(elapsedTime) + " ns\n\tSum = " + df.format(result) + " (Possible range: 200,000,000 - 2,000,000,000)");
	} // End of singleThreadSumTimed.
	
	/**
	 * Sums the elements of an integer array.
	 * @param array
	 * @return
	 */
	public static int sumArray(int[] array) {
		int result = 0;
		for (int i = 0; i < array.length; i++) {
			result += array[i];
		} // End of for loop.
		return result;
	} // End of sumArray.
	
} // End of singleThreadCount class.

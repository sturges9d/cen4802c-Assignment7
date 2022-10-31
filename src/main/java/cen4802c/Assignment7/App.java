package cen4802c.Assignment7;

import java.text.DecimalFormat;

/**
 * This class is for CEN 4802C-Assignment 7. It is adopted from a class I made for CEN 3024C's Concurrency Assignment.
 *
 * @author Stephen Sturges
 * @version 10/30/2022
 */
public class App
{
	static int sizeOfArray = 200000000;
	static int lowerBound = 1;
	static int upperBound = 10;
	static int[] randomArray = RandomIntegerArray.generateRandomArray(sizeOfArray, lowerBound, upperBound);
	static int arrayIndex = 0;
	static int count = 0;
	static long elapsedTime = 0;
	
    public static void main( String[] args )
    {
		// Multithread method:
		// First thread.
		Thread t1 = new Thread(new MultithreadSum());
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Second thread.
		Thread t2 = new Thread(new MultithreadSum());
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		DecimalFormat df = new DecimalFormat("###,###,###");
		System.out.println("Multi-thread:\n\tElapsed time = " + df.format(elapsedTime) + " ns\n\tSum = " + df.format(count) + " (Possible range: 200,000,000 - 2,000,000,000)");
		
		// Single thread method:
		SingleThreadCount.singleThreadSumTimed(randomArray);
    }
}

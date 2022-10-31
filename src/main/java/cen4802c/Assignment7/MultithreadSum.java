package cen4802c.Assignment7;

/**
 * This class is for CEN 4802C-Assignment 7. It is adopted from a class I made for CEN 3024C's Concurrency Assignment.
 *
 * @author Stephen Sturges
 * @version 10/30/2022
 */
public class MultithreadSum implements Runnable {
	
	public static synchronized void addElapsedTime(long time) {
		App.elapsedTime += time;
	} // End of addElapsedTime method.
	
	public static synchronized void countArray() {
		App.count += App.randomArray[App.arrayIndex];
	} // End of countArray method.
	
	public static synchronized void incrementArrayIndex() {
		App.arrayIndex++;
	} // End of incrementArrayIndex method.
	
	@Override
	public void run() {
		long startTime = System.nanoTime();
		while(App.arrayIndex < App.sizeOfArray) {
			countArray();
			incrementArrayIndex();
		} // End of while loop.
		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		addElapsedTime(elapsedTime);
	} // End of run method.
	
}

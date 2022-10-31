package cen4802c.Assignment7;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 * This test class is for CEN 4802C-Assignment 7. It is adopted from a test class I made for CEN 3024C's Concurrency Assignment.
 *
 * @author Stephen Sturges
 * @version 10/30/2022
 */
public class AppTest {
	
	static int[] array;
	Thread t1 = new Thread(new MultithreadSum());
	Thread t2 = new Thread(new MultithreadSum());
	
	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Start testing.");
		int n = 200000000;
		int lowerBound = 1;
		int upperBound = 10;
		array = RandomIntegerArray.generateRandomArray(n, lowerBound, upperBound);
	} // End of setUpBeforeClass method.
	
	@BeforeEach
	public void setUp() throws Exception {
		System.out.println("Start test.");
	} // End of setUp method.
	
	@Test
	void RandomArrayTest() {
		assertNotNull(array);
	} // End of RandomArrayTest.
	
	@Test
	void singleThreadSumTest() {
		int n = 200000000;
		int lB = 1;
		int uB = 10;
		int[] randomArray = RandomIntegerArray.generateRandomArray(n, lB, uB);
		int sumResult = SingleThreadCount.sumArray(randomArray);
		assertTrue(sumResult >= 200000000, "Array value is equal to or above 200,000,000.");
		assertTrue(sumResult <= 2000000000, "Array value is equal to or below 2,000,000,000.");
		if (sumResult >= 200000000 && sumResult <= 2000000000) {
			System.out.println("Single Thread Sum Test: Passed");
		} else {
			System.out.println("Single Thread Sum Test: Failed");
		}
	} // End of singleThreadSumTest.
	
	@Test
	void multithreadSumTest() {
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertTrue(App.count >= 200000000, "Array value is equal to or above 200,000,000.");
		assertTrue(App.count <= 2000000000, "Array value is equal to or below 2,000,000,000.");
		if (App.count >= 200000000 && App.count <= 2000000000) {
			System.out.println("Multi-Thread Sum Test: Passed");
		} else {
			System.out.println("Multi-Thread Sum Test: Failed");
		}
	} // End of multithreadSumTest.
	
	@AfterEach
	public void tearDown() throws Exception {
		System.out.println("End test.");
	} // End of tearDown method.
	
	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		System.out.println("End testing.");
	} // End of tearDownAfterClass method.
	
}

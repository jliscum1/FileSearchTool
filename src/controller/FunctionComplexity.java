package controller;

import java.io.*;

/**
 * 
 * Constructs an experimental graph of the
 * time complexity of some recursive functions
 *
 */
public class FunctionComplexity {

	private static String outputFileName = "data.csv";
	private static final int MAX = 49;
	private static final int MIN = 30;
	private static final double GOLDEN_RATIO = (1.0 + Math.sqrt(5.0))/2.0;

	private static int digit(int n) {
		if (n== 0 || n == 1) {
			return 1;
		}
		return digit(n/2) + 1;
	}

	private static int mystery(int n) {
		if (n==0 || n== 1) {
			return 1;
		}
		return 4 + mystery(n/2) + mystery(n/3) + mystery(n/4) + mystery(n/5);
	}
	
	private static double guess(int n) {
		return Math.pow(GOLDEN_RATIO, n);
	}
	
	private static long fib(int n) {
		if(n < 0) {
			return 0;
		}
		if (n < 2) {
			return 1;
		}
		return fib(n-1) + fib(n-2);
	}
	public static void main(String[] arg) {

		
		PrintWriter writer = null;
		try{
			writer = new PrintWriter(new File(outputFileName));
		}
		catch(FileNotFoundException err) {
			err.printStackTrace();
			System.exit(0);
		}
		long startTime;
		long stopTime;
		for(int i = MIN;i<=MAX;i++) {
			startTime = System.currentTimeMillis();
			fib(i);
			stopTime = System.currentTimeMillis();
			double value = (stopTime-startTime)/guess(i);
			writer.write(i+","+ value);
			writer.println();
			System.out.println(i+" "+ value);
		}
		writer.close();

	}

}

package com.premiumminds.internship.snail;

import java.util.concurrent.Future;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

/**
 * Created by aamado on 05-05-2023.
 */
class SnailShellPattern implements ISnailShellPattern {

	/**
	 * Method to get snailshell pattern
	 * 
	 * @param matrix matrix of numbers to go through
	 * @return order array of values thar represent a snail shell pattern
	 */
	public Future<int[]> getSnailShell(int[][] matrix) {

		int lines = matrix.length;
		int columns = matrix[0].length;
		int totalElems = lines * columns;
		int halfElemns = totalElems / 2;
		CompletableFuture<int[]> futureResult = new CompletableFuture<>();

		SnailThread snt = new SnailThread(matrix, halfElemns);
		SnailThreadInverse sntInverse = new SnailThreadInverse(matrix, halfElemns);
		snt.start();
		sntInverse.start();

		try {
			snt.join();
			sntInverse.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		int[] firstHalf = snt.getResult();
		int[] secondHalf = sntInverse.getResult();

		int[] combinedArray = new int[firstHalf.length + secondHalf.length];
		System.arraycopy(firstHalf, 0, combinedArray, 0, firstHalf.length);
		System.arraycopy(secondHalf, 0, combinedArray, firstHalf.length, secondHalf.length);
		
		for (int n: combinedArray) 
			System.out.println(n);

		futureResult.complete(combinedArray);
		return futureResult;

	}
}

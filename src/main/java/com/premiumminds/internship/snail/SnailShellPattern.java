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
	 * Method to get snailshell pattern.
	 * for small matrix, bellow 
	 * this method creates two threads in order to optimise the execution time. 
	 * for small matrixes, the solution might not me the best, but for big ones
	 * the fact that half of the work is being done at the same time should improve a lot the runtime.
	 * 
	 * @param matrix matrix of numbers to go through
	 * @return order array of values that represent a snail shell pattern
	 * @throws NotSquaredException 
	 */
	public Future<int[]> getSnailShell(int[][] matrix) {

		CompletableFuture<int[]> futureResult = new CompletableFuture<>();
		
		if (matrix.length == 0) {
			int[] result = {};
			futureResult.complete(result);
			return futureResult;
		}

		int lines = matrix.length;
		int columns = matrix[0].length;
		
		int totalElems = lines * columns;
		int halfElemns = totalElems / 2;


		SnailThread snt;
		if (totalElems <= 25) {
			
			snt = new SnailThread(matrix, totalElems);
			snt.start();
			
			try {
				snt.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			futureResult.complete(snt.getResult());
			return futureResult;
		}

		snt = new SnailThread(matrix, halfElemns);
		SnailInverseOperation sntInverse =  SnailInverseFactory.getInstance(matrix, halfElemns);
		Thread threadInverse = new Thread(sntInverse);
		
		snt.start();
		threadInverse.start();

		try {
			snt.join();
			threadInverse.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		int[] firstHalf = snt.getResult();
		int[] secondHalf = sntInverse.getResult();

		int[] combinedArray = new int[firstHalf.length + secondHalf.length];
		System.arraycopy(firstHalf, 0, combinedArray, 0, firstHalf.length);
		System.arraycopy(secondHalf, 0, combinedArray, firstHalf.length, secondHalf.length);

		futureResult.complete(combinedArray);
		return futureResult;

	}

}

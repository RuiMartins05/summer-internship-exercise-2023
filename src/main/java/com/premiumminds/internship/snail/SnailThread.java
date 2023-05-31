package com.premiumminds.internship.snail;

import java.util.ArrayList;
import java.util.List;

public class SnailThread extends Thread {

	private int[][] matrix;
	private int nToCollect;
	private int[] result;

	public SnailThread(int[][] matrix, int nToCollect) {
		this.matrix = matrix;
		this.nToCollect = nToCollect;
		this.result = new int[nToCollect];
	}

	@Override
	public void run() {

		int lines = matrix.length;
		if (lines == 0) {
			return;
		}


		int columns = matrix[0].length;

		int topRow = 0;
		int bottomRow = lines - 1;

		int rightColumn = columns - 1;
		int leftColumn = 0;

		int counter = 0;

		while (counter < this.nToCollect) {

			int i;
			for (i = leftColumn; i <= rightColumn && counter < nToCollect; i++) {
				this.result[counter] = matrix[topRow][i];
				counter++;
			}
			topRow++;

			for (i = topRow; i <= bottomRow && counter < nToCollect; i++) {
				this.result[counter] = matrix[i][rightColumn];
				counter++;
			}
			rightColumn--;

			for (i = rightColumn; i >= 0 && counter < nToCollect; i--) {
				this.result[counter] = matrix[bottomRow][i];
				counter++;
			}
			bottomRow--;

			for (i = bottomRow; i >= topRow && counter < nToCollect; i--) {
				this.result[counter] = matrix[i][leftColumn];
				counter++;
			}
			leftColumn++;

		}
		System.out.println("resultado " + this.result);
	}

	public int[] getResult() {
		return this.result;
	}

}

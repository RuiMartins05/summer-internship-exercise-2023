package com.premiumminds.internship.snail;

public class OddMatrixOperation extends SnailInverseOperation implements Runnable {

	/**
     * Constructs an EvenMatrixOperation with the given matrix and the number of matrix elements to collect.
     *
     * @param matrix     the matrix to operate on
     * @param nToCollect the number of elements to collect from the snail shell
     */
	public OddMatrixOperation(int[][] matrix, int nToCollect) {
		super(matrix, nToCollect);
	}

	/**
     * Executes the odd matrix operation.
     * Collects the values from the odd-sized matrix in an inversed snail way.
     * At the end of each while cycle, the number of positions to move
     * grows by two. This was a pattern identified in this type of problem and was crucial to its solving
     */
	@Override
	public void run() {
		int lines = this.matrix.length;
		if (lines == 0) {
			return;
		}

		int counter = nToCollect - 2;
		int positionsToMove = 2;

		int topRow = this.middleRow - 1;
		int bottomRow = this.middleRow + 1;
		int rightCol = this.middleRow + 1;
		int leftCol = this.middleRow - 1;


		int nCycle = 1;
		this.result[nToCollect-1] = matrix[middleRow][middleRow];
		while (counter >= 0) {
			int i;
			for (i = 1; i <= positionsToMove && counter >= 0; i++) {
				this.result[counter] = this.matrix[topRow + i][leftCol];
				counter--;
			}

			for (i = 1; i <= positionsToMove && counter >= 0; i++) {
				this.result[counter] = this.matrix[bottomRow][leftCol + i];
				counter--;
			}

			for (i = 1; i <= positionsToMove && counter >= 0; i++) {
				this.result[counter] = this.matrix[bottomRow - i][rightCol];
				counter--;
			}

			for (i = 1; i <= positionsToMove && counter >= 0; i++) {
				this.result[counter] = this.matrix[topRow][rightCol - i];
				counter--;
			}

			positionsToMove += 2;

			topRow--;
			bottomRow++;
			rightCol++;
			leftCol--;

		}
	}

}

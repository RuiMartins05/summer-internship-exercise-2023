package com.premiumminds.internship.snail;

public class OddMatrixOperation extends SnailInverseOperation implements Runnable {

	public OddMatrixOperation(int[][] matrix, int nToCollect) {
		super(matrix, nToCollect);
	}

	@Override
	public void run() {

		int lines = this.matrix.length;
		if (lines == 0) {
			return;
		}

		int counter = nToCollect - 2;
		int linesToMove = 2;

		int topRow = this.middleRow - 1;
		int bottomRow = this.middleRow + 1;
		int rightCol = this.middleRow + 1;
		int leftCol = this.middleRow - 1;


		int nCycle = 1;
		this.result[nToCollect-1] = matrix[middleRow][middleRow];
		while (counter >= 0) {
			int i;
			for (i = 1; i <= linesToMove && counter >= 0; i++) {
				this.result[counter] = this.matrix[topRow + i][leftCol];
				counter--;
			}

			for (i = 1; i <= linesToMove && counter >= 0; i++) {
				this.result[counter] = this.matrix[bottomRow][leftCol + i];
				counter--;
			}

			for (i = 1; i <= linesToMove && counter >= 0; i++) {
				this.result[counter] = this.matrix[bottomRow - i][rightCol];
				counter--;
			}

			for (i = 1; i <= linesToMove && counter >= 0; i++) {
				this.result[counter] = this.matrix[topRow][rightCol - i];
				counter--;
			}

			linesToMove += 2;

			topRow--;
			bottomRow++;
			rightCol++;
			leftCol--;

		}
	}

}

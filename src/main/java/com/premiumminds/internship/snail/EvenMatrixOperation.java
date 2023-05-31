package com.premiumminds.internship.snail;

public class EvenMatrixOperation extends SnailInverseOperation implements Runnable {

	private int middleCol;
	
	public EvenMatrixOperation(int[][] matrix, int nToCollect) {
		super(matrix, nToCollect);
		this.middleCol = matrix.length / 2 - 1;
	}


	@Override
	public void run() {
		
		int lines = this.matrix.length;
		if (lines == 0) {
			return;
		}

		this.result[nToCollect-1] = matrix[this.middleRow][this.middleCol];
		
		int counter = nToCollect - 2;
		int linesToMove = 2;
		
		int topRow = this.middleRow - 1;
		int bottomRow = this.middleRow + 1;
		int rightCol = this.middleCol + 1;
		int leftCol = this.middleCol - 1;
	
		int nCycle = 1;
		
		while (counter >= 0) {
			int i;
			
			for (i = 1; i <= linesToMove && counter >= 0; i++) {
				this.result[counter] = this.matrix[bottomRow - i][rightCol];
				counter--;
			}
			
			for (i = 1; i <= linesToMove && counter >= 0; i++) {
				this.result[counter] = this.matrix[topRow][rightCol - i];
				counter--;
			}
			
			for (i = 1; i <= linesToMove && counter >= 0; i++) {
				this.result[counter] = this.matrix[topRow + i][leftCol];
				counter--;
			}
			
			for (i = 1; i <= linesToMove && counter >= 0; i++) {
				this.result[counter] = this.matrix[bottomRow][leftCol + i];
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

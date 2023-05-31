package com.premiumminds.internship.snail;

public class SnailThreadInverse extends Thread {

	private int[][] matrix;
	private int nToCollect;
	private int[] result;

	public SnailThreadInverse(int[][] matrix, int nToCollect) {
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


		int middleRow = matrix.length / 2;
		int middleCol = matrix.length / 2 - 1;

		//		int columns = matrix[0].length;
		//
		//		int topRow = nToCollect;
		//		int bottomRow = lines - 1;
		//
		//		int rightColumn = columns - 1;
		//		int leftColumn = 0;


		if (this.isPar(this.matrix.length)) {	
			this.result[nToCollect-1] = matrix[middleRow][middleCol];
			this.ifpar(middleRow, middleCol);
		} else {
			this.result[nToCollect-1] = matrix[middleRow][middleRow];
			this.ifImpar(middleRow);
		}


	}
	
	private void ifImpar(int middleRow) {
		this.nToCollect++;
		int counter = nToCollect - 2;
		int linesToMove = 2;
		
		int topRow = middleRow - 1;
		int bottomRow = middleRow + 1;
		int rightCol = middleRow + 1;
		int leftCol = middleRow - 1;
	
		
		int nCycle = 1;
		
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
	
	private void ifpar(int middleRow, int middleCol) {
		int counter = nToCollect - 2;
		int linesToMove = 2;
		
		int topRow = middleRow - 1;
		int bottomRow = middleRow + 1;
		int rightCol = middleCol + 1;
		int leftCol = middleCol - 1;
	
		
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


	public int[] getResult() {
		return this.result;
	}

	private boolean isPar(int n) {
		return n % 2 == 0;
	}

}

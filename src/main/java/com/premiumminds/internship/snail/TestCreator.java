package com.premiumminds.internship.snail;

public class TestCreator {

	public TestCreator() {
		
	}
	

    /**
     * Creates a square matrix of the specified size in snail shell pattern.
     *
     * @param size the size of the matrix
     * @return the created matrix
     */
	public int[][] createMatrix(int size) {
		int[][] result = new int[size][size];
		
		int nToCollect = size*size;
		
		int lines = size;
		int columns = size;

		int topRow = 0;
		int bottomRow = lines - 1;

		int rightColumn = columns - 1;
		int leftColumn = 0;

		int counter = 0;

		while (counter < nToCollect) {

			int i;
			for (i = leftColumn; i <= rightColumn && counter < nToCollect; i++) {
				result[topRow][i] = counter + 1;
				counter++;
			}
			topRow++;

			for (i = topRow; i <= bottomRow && counter < nToCollect; i++) {
				result[i][rightColumn] = counter + 1;
				counter++;
			}
			rightColumn--;

			for (i = rightColumn; i >= leftColumn && counter < nToCollect; i--) {
				result[bottomRow][i] = counter + 1;
				counter++;
			}
			bottomRow--;

			for (i = bottomRow; i >= topRow && counter < nToCollect; i--) {
				result[i][leftColumn] = counter + 1;
				counter++;
			}
			leftColumn++;

		}
		return result;
	}
	
	
	 /**
     * Creates a sorted array of the specified size.
     *
     * @param size the size of the array
     * @return the created array
     */
	public int[] createArray(int size) {
		int[] result = new int[size*size];
		for (int i = 0; i < size*size; i++ )
			result[i] = i + 1;

		return result;
	}
	
}

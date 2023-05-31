package com.premiumminds.internship.snail;

public class SnailInverseFactory {

	private static SnailInverseFactory INSTANCE;
	
	private SnailInverseFactory() {}
	
	 /**
     * Retrieves the singleton instance of SnailInverseFactory.
     *
     * @return the singleton instance of SnailInverseFactory
     */
	public SnailInverseFactory getInstance() {
		
		if (INSTANCE == null)
			return new SnailInverseFactory();
		
		return INSTANCE;
		
	}
	
	/**
     * Creates an instance of SnailInverseOperation based on the given matrix dimensions and number of elements to collect.
     *
     * @param matrix     the matrix to operate on
     * @param nToCollect the number of elements to collect from the snail shell
     * @return an instance of SnailInverseOperation
     */
	public static SnailInverseOperation getInstance(int[][] matrix, int nToCollect) {
		
		if (isPar(matrix.length)) {
            return new EvenMatrixOperation(matrix, nToCollect);
        } else {
            return new OddMatrixOperation(matrix, nToCollect+1);
        }
		
	}
	
    /**
     * Checks if a number is even.
     *
     * @param n the number to check
     * @return true if the number is even, false otherwise
     */
	private static boolean isPar(int n) {
		return n % 2 == 0;
	}
	
}

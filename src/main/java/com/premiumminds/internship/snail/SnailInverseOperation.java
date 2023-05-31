package com.premiumminds.internship.snail;

public abstract class SnailInverseOperation implements Runnable{

	protected int[][] matrix;
	protected int nToCollect;
	protected int[] result;
	protected int middleRow;
	
	
    /**
     * Constructs a SnailInverseOperation with the given matrix and number of elements to collect.
     *
     * @param matrix     the matrix to operate on
     * @param nToCollect the number of elements to collect from the snail shell
     */
	public SnailInverseOperation(int[][] matrix, int nToCollect) {
		this.matrix = matrix;
		this.nToCollect = nToCollect;
		this.result = new int[nToCollect];
		this.middleRow = matrix.length / 2;
	}
	
    /**
     * Executes the snail inverse operation.
     * This method needs to be implemented by concrete subclasses.
     */
	@Override
	public abstract void run();

    /**
     * Retrieves the result of the snail inverse operation.
     *
     * @return the result array containing the collected elements
     */
	public int[] getResult() {
		return this.result;
	}
}

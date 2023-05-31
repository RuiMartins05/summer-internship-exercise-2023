package com.premiumminds.internship.snail;

public abstract class SnailInverseOperation implements Runnable{

	protected int[][] matrix;
	protected int nToCollect;
	protected int[] result;
	protected int middleRow;
	
	public SnailInverseOperation(int[][] matrix, int nToCollect) {
		this.matrix = matrix;
		this.nToCollect = nToCollect;
		this.result = new int[nToCollect];
		this.middleRow = matrix.length / 2;
	}
	
	@Override
	public abstract void run();

	public int[] getResult() {
		return this.result;
	}
}

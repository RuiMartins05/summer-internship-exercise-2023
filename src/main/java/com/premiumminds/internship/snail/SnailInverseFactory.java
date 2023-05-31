package com.premiumminds.internship.snail;

public class SnailInverseFactory {

	private static SnailInverseFactory INSTANCE;
	
	private SnailInverseFactory() {
	}
	
	public SnailInverseFactory getInstance() {
		
		if (INSTANCE == null)
			return new SnailInverseFactory();
		
		return INSTANCE;
		
	}
	
	public static SnailInverseOperation getInstance(int[][] matrix, int nToCollect) {
		
		if (isPar(matrix.length)) {
            return new EvenMatrixOperation(matrix, nToCollect);
        } else {
            return new OddMatrixOperation(matrix, nToCollect+1);
        }
		
	}
	
	private static boolean isPar(int n) {
		return n % 2 == 0;
	}
	
}

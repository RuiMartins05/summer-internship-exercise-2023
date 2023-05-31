package com.premiumminds.internship.snail;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by aamado on 05-05-2023.
 */
@RunWith(JUnit4.class)
public class SnailShellPatternTest {

	/**
	 * The corresponding implementations to test.
	 *
	 * If you want, you can make others :)
	 *
	 */
	public SnailShellPatternTest() {
	};

	@Test
	public void emptyMatrix()
			throws InterruptedException, ExecutionException, TimeoutException {
		int[][] matrix = new int[0][0];
		Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
		int[] result = count.get(10, TimeUnit.SECONDS);
		int[] expected = {};
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void ScreenLockinPatternTestFirst3Length2Test()
			throws InterruptedException, ExecutionException, TimeoutException {
		int[][] matrix = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
		Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
		int[] result = count.get(10, TimeUnit.SECONDS);
		int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		assertArrayEquals(expected, result);
	}

	@Test
	public void testEvenMatrix2x2()
			throws InterruptedException, ExecutionException, TimeoutException {
		int[][] matrix = {
				{ 1,  2},
				{4, 3}
		};

		Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
		int[] result = count.get(10, TimeUnit.SECONDS);
		int[] expected = { 1, 2, 3, 4};
		assertArrayEquals(expected, result);
	}

	@Test
	public void testMatrix4x4()
			throws InterruptedException, ExecutionException, TimeoutException {
		int[][] matrix = {
				{ 1,  2,  3,  1},
				{4, 5, 6, 4},
				{7, 8, 9, 7},
				{7, 8, 9, 7}
		};

		Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
		int[] result = count.get(10, TimeUnit.SECONDS);
		int[] expected = { 1, 2, 3, 1, 4, 7, 7, 9, 8, 7, 7, 4, 5, 6, 9, 8 };
		assertArrayEquals(expected, result);
	}

	@Test
	public void testMatrix5x5()
			throws InterruptedException, ExecutionException, TimeoutException {
		int[][] matrix = {
				{ 1,  2,  3,  4,  5},
				{16, 17, 18, 19,  6},
				{15, 24, 25, 20,  7},
				{14, 23, 22, 21,  8},
				{13, 12, 11, 10,  9}
		};

		Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
		int[] result = count.get(10, TimeUnit.SECONDS);
		int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void testMatrix50x50()
			throws InterruptedException, ExecutionException, TimeoutException {
		TestCreator tc = new TestCreator();
		
		int size = 50;
		
		int[][] matrix = tc.createMatrix(size);

		Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
		int[] result = count.get(10, TimeUnit.SECONDS);
		int[] expected = tc.createArray(size);
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void testMatrix10000x10000()
			throws InterruptedException, ExecutionException, TimeoutException {
		TestCreator tc = new TestCreator();
		
		int size = 10000;
		
		int[][] matrix = tc.createMatrix(size);

		Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
		int[] result = count.get(10, TimeUnit.SECONDS);
		int[] expected = tc.createArray(size);
		assertArrayEquals(expected, result);
	}



}
package com.premiumminds.internship.snail;

import static org.junit.Assert.assertArrayEquals;
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
  public void ScreenLockinPatternTestFirst3Length2Test()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    assertArrayEquals(expected, result);
  }  
  
  @Test
  public void test25()
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
  public void test16()
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
  
//  @Test
//  public void test16()
//	      throws InterruptedException, ExecutionException, TimeoutException {
//		  int[][] matrix = {
//				    { 1,  2,  3,  4},
//				    {12, 13, 14, 5},
//				    {11, 16, 15, 6},
//				    {10, 9, 8, 7}
//				};
//
//	    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
//	    int[] result = count.get(10, TimeUnit.SECONDS);
//	    int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
//	    assertArrayEquals(expected, result);
//	  }
}